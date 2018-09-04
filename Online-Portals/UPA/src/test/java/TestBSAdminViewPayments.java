package test.java;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.DataBase;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.paymentSummary;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;


public class TestBSAdminViewPayments extends TestBase {
	
	Boolean tinAssociated = false;
	Boolean tinAssociationExisted = false;
	
	String userType="BS";
    String accessType="Admin";
    String associatedTin="";
    String billingServiceId="";
        

    
    void associateTIN(int startMonth, int endMonth, int numberOfDays, int count )
    {

    	String env=System.getProperty("env");
		String id=testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+accessType+"_"+env);
		
		associatedTin = getTinForBsAssociation( startMonth,  endMonth, numberOfDays, count );
        tinAssociated =true;
        
        Object input[] = new Object[1];
        input[0] = id;
        
        HashMap<String, Object> existingAssociation = getBsIdAndTinOfBSUser(input);
        billingServiceId = existingAssociation.get("bsId").toString();
        
        String existingTins = existingAssociation.get("associatedTins").toString();
        
        if(!existingTins.contains(associatedTin)) {
        	associateBSUserToTin(associatedTin, billingServiceId);
        	tinAssociated = true;
        	tinAssociationExisted = false;
        }
        else
        {
        	tinAssociated = true;
        	tinAssociationExisted = true;
        }
        
    }
    
    void disassociateTIN()
    {
    	if(tinAssociationExisted == false)
    	{
    		disassociateBSUserToTin(associatedTin, billingServiceId);
    		tinAssociated= false;
    		tinAssociationExisted= false;
    		associatedTin = "";
    	}
    	
    }
   
    
	public String getTinForBsAssociation(int startMonth, int endMonth, int numberOfDays, int count )
	{		
		
		String provTin="";
		List< HashMap<String, String> > result;
		
		int sqlRow = startMonth<=0 && endMonth<=0 && numberOfDays>0 ?38:39;
		
		if(sqlRow ==38)
		{
			if(count<=0) {
				count=10;
			}
			Object[] values =  {numberOfDays, count};
			result = DataBase.executeSelectPreparedStatement(testConfig, sqlRow, values );
		}
		else
		{
			if(count<=0) {
				count=10;
			}
			Object[] values =  {startMonth, endMonth, count};
			result = DataBase.executeSelectPreparedStatement(testConfig, sqlRow, values );
		}
		
		for( HashMap<String,String> data : result)
		{
			provTin = data.get("PROV_TAX_ID_NBR");
		}
		
		
		return provTin;
	}
	
	public HashMap<String, Object> getBsIdAndTinOfBSUser( Object[] values)
	{
		int sqlRow=40;
		boolean setBsID = false;
		String bsId="";
		String associatedTins="";
		
		List< HashMap<String, String> > dbData = DataBase.executeSelectPreparedStatement(testConfig, sqlRow, values );
		
		for(HashMap<String, String> data :dbData )
		{
			if(setBsID == false)
			{
				bsId = data.get("BILLING_SERVICE_ID");
				setBsID = true;
			}
			associatedTins = associatedTins + data.get("PROV_TIN_NBR")+",";
		}
	
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("bsId", bsId);
		result.put("associatedTins",associatedTins);		
		return result;
	}
		
	public int associateBSUserToTin(String provTin, String billingServiceId)
	{
		int sqlRow = 41;
		Integer bsId = Integer.valueOf(billingServiceId);
		
		Object values[] = new Object[2];
		values[0] = provTin;
		values[1] =  bsId;
			int result = DataBase.executeUpdatePreparedStatement(testConfig, sqlRow, values);
		return result;
	}

	public int disassociateBSUserToTin(String provTin, String billingServiceId)
	{
		int sqlRow = 42;
		Integer bsId = Integer.valueOf(billingServiceId);
		
		Object values[] = new Object[2];
		values[0] = provTin;
		values[1] =  bsId;
		
		int result = DataBase.executeUpdatePreparedStatement(testConfig, sqlRow, values);
		return result;
	}
	
	
    @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending")
    void testPaymentDateSorting() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {   
    	try 
    	{
	    	associateTIN(0, 0, 90, 10);
	 	    String quickSearchFilter="Last 90 days";
	 	    String archiveFilter="Show All";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	 	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	
	        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().bsTin(associatedTin);
	        paymentSummaryPage.setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter);
	        paymentSummaryPage.verifyPaymentDateSorting("Asc");
	        paymentSummaryPage.verifyPaymentDateSorting("Desc");
    	}
    	finally 
    	{
    		disassociateTIN();
    	}
    }   

    @Test(priority=3,description="TS004_View Payments_Payments filter_TIN Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
    void testPaymentDetailsForTinOnlyfilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
    	try {
	    	associateTIN(0,0,90,10);
	    	String filterPayments="TIN Only";
	    	String archiveFilter="Show All";
	    	String quickSearchFilter="Last 90 days";
	         
	        testConfig.putRunTimeProperty("key", "taxIdentifierType");
	 		testConfig.putRunTimeProperty("value", "TIN");		
	
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	
			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();
			System.out.println(associatedTin);
			paymentSummaryPage = paymentSummaryPage.bsTin(associatedTin);
			paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
    	}
    	finally {
    		disassociateTIN();
    	}		
   }	
 
    @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
    void testPaymentDetailsForNPIOnlyFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
     {

    	try 
    	{
    		 associateTIN(0,0,90,10);
			 String filterPayments="NPI Only";
			 String archiveFilter="Show All";
			 String quickSearchFilter="Last 90 days";
			 
			 testConfig.putRunTimeProperty("key", "taxIdentifierType");
			 testConfig.putRunTimeProperty("value", "NPI");		
			
			 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
			 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		
			 paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
			 System.out.println(associatedTin);	
			 paymentSummaryPage = paymentSummaryPage.bsTin(associatedTin);	
			 paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
	    }
    	finally 
    	{
			disassociateTIN();
		}	

      }	

    
   @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {

	   	try {
		    	associateTIN(0,0,30, 5);
			    String filterPayments="Show All";
				String quickSearchFilter="Last 30 days";		
				
				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
				testConfig.putRunTimeProperty("value", "ALL");			
				
				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
				OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
				HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
				
				//By default gets data for 30 days		
				paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().bsTin(associatedTin);
		        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	   	}
	   	finally {
	   		disassociateTIN();
	   	}
	 }	
   
   @Test(priority=1,description="TS007_View Payments_Payments filter_Last Sixty Days " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForLastSixtyDaysFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {

	   	try {
	    	associateTIN(0,0,60, 5);
			    String filterPayments="Show All";
				String quickSearchFilter="Last 60 days";
						
				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
				testConfig.putRunTimeProperty("value", "ALL");	
						
				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
				OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
				HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
				
				paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().bsTin(associatedTin);
		        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);   
	   	}
	   	finally {
	   		disassociateTIN();
	   	}
	 }	

   @Test(priority=1,description="TS008_View Payments_Payments filter_Last Ninety Days " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForLastNinetyDaysFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {

	   	try 
	   	{
	    	associateTIN(0,0,90, 5);
		    String filterPayments="Show All";
			String quickSearchFilter="Last 90 days";
					
			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
			testConfig.putRunTimeProperty("value", "ALL");	
					
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	
			paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().bsTin(associatedTin);
			paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	   	}
	   	finally {
	   		disassociateTIN();
	   	}
	 }	

   @Test(priority=1,description="TS009_View Payments_Payments filter_Last 4 to 6 Months " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForFourToSixMonthsFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {

	   	try 
	   	{
	    	associateTIN(4,6,0,10);
		    String filterPayments="Show All";
			String quickSearchFilter="Last 4-6 months";
					
			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
			testConfig.putRunTimeProperty("value", "ALL");	
					
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	
			paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().bsTin(associatedTin);
	        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	   	}
	   	finally {
	   		disassociateTIN();
	   	}         
	 }	
   
   @Test(priority=1,description="TS010_View Payments_Payments filter_Last 6 to 9 Months " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForSixToNineMonthsFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	   	try 
	   	{
	    	associateTIN(6,9,0,10);
		    String filterPayments="Show All";
			String quickSearchFilter="Last 6-9 months";
					
			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
			testConfig.putRunTimeProperty("value", "ALL");	
					
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
			
			paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().bsTin(associatedTin);
	        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	   	}
	   	finally {
	   		disassociateTIN();
	   	}
	 }	
   
   @Test(priority=1,description="TS011_View Payments_Payments filter_Last 9 to 13 Months " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForNineToThirteenMonthsFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	   	try 
	   	{
	    	associateTIN(9,13,0,10);
		    String filterPayments="Show All";
			String quickSearchFilter="Last 9-13 months";
					
			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
			testConfig.putRunTimeProperty("value", "ALL");	
					
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
			
			paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().bsTin(associatedTin);        
	        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	   	}
	   	finally {
	   		disassociateTIN();
	   	}
	 }	

   
      /*
   @Test(priority=1,description="TS012_View Payments_Market Type filter_Medical_Dental etc " + "<br>" + "Validate that the correct payment information is displayed when user selects a specific Market Type from the Market Type filter.")
   	void testPaymentDetailsForMedicalDentalFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 4-6 months";
		String marketType ="Dental";
				
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");	
				
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();        
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, marketType);

		marketType ="Medical";
		paymentSummaryPage= home.clickViewPaymentsTab();        
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, marketType);
        
	 }	

   
   @Test(priority=1,description="TS013_View Payments_Market Type filter_Show All" + "<br>" + "Validate that the correct payment information is displayed when user selects a specific Market Type from the Market Type filter.")
   	void testPaymentAllMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 4-6 months";
		String marketType ="Show All";
				
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");	
				
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();        
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
        
	 }	


   @Test(priority=1,description="TS014_View Payments_Zero Dollar ACH payments" + "<br>" + "Validate that Zero dollar payment information displays appropriately for ACH payments.")
   	void testPaymentDetailsForZeroDollarACHFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 4-6 months";
		String marketType ="Show All";
				
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");	
				
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();        
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
        
	 }	
   
   
   

   @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments")
   	void testArchivedPaymentsFilterActiveOnly() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter="Active Only";
        String quickSearchFilter="Last 30 days";
        
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
      
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
      
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 4-6 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }	
   
   @Test(priority=5,description="TS023_View Payments_Active_Archived Payments filter_Show All" + "<br>" + "Validate that correct payment information is displayed on selection of 'Archived Only' from the  filter - Archive Payments")
   	void testArchivedPaymentsFilterArchivedOnly() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter="Archived Only";
        String quickSearchFilter="Last 30 days";
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "Y");
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
      
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
      
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 4-6 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }	
   
   @Test(priority=5,description="TS024_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
   	void testArchivedPaymentsFilterShowALL() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter=filterPayments;
        String quickSearchFilter="Last 30 days";
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
      
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
      
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 4-6 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }

*/
   
   
   
}

			
