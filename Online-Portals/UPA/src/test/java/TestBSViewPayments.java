package test.java;

import java.io.IOException;
import java.text.ParseException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ViewPayments;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;


public class TestBSViewPayments extends TestBase {
	String userType="BS";
    String accessType="Admin";
   
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - BS")
    void testPaymentsForShowAllFilter_30days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		String paymentType="generalPayment30Days";
 		String filterPayments="Show All";
 		String quickSearchFilter="Last 30 days";
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 
 		//By default gets data for 30 days
       home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - BS")
    void testPaymentsForShowAllFilter_60days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="generalPayment60Days";
    	String filterPayments="Show All";
    	String quickSearchFilter="Last 60 days";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - BS")
    void testPaymentsForShowAllFilter_90days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="generalPayment90Days";
    	String filterPayments="Show All";
    	String quickSearchFilter="Last 90 days";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - BS")
    void testPaymentsForShowAllFilter_4_6months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String filterPayments="Show All";
		String quickSearchFilter="Last 4-6 months";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		String paymentType=quickSearchFilter;
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - BS")
    void testPaymentsForShowAllFilter_6_9months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String filterPayments="Show All";
		String quickSearchFilter="Last 6-9 months";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		
 		String paymentType=quickSearchFilter;
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - BS")
    void testPaymentsForShowAllFilter_9_13months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String filterPayments="Show All";
		String quickSearchFilter="Last 9-13 months";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		String paymentType=quickSearchFilter;
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
  
    @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
    void testNPIOnlyFilter30Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
     {
    	String filterPayments="NPI Only";
        String archiveFilter="Show All";
        String quickSearchFilter="Last 30 days";
        String paymentType="generalPaymentForNPI_30days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");		
		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
  		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
  		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
         
     }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testNPIOnlyFilter60Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 60 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_60days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
				

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);
        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testNPIOnlyFilter90Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 90 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_90days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
				

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testNPIOnlyFilter4_6months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 4-6 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_4-6months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
			

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);
    }
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testNPIOnlyFilter6To9Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 6-9 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_6-9months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		
		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		 home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testNPIOnlyFilter9To13Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 9-13 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_9-13months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);        
    }
   
   /**
    * Tin only
    * 
    */
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testTINOnlyFilter60Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 60 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_60days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
			

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);
        
    }
   
  
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testTINOnlyFilter90Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 90 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_90days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		
			
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter); 
    }
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testTINOnlyFilter4To6Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 4-6 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_4_6months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
			

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testTINOnlyFilter6To9Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 6-9 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_6_9months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		ViewPayments paymentSummaryPage= home.clickViewPaymentsTab().enterBSTin(userType,paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);        
    }
   
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
   void testTINOnlyFilter9To13Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 9-13 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_9_13months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
				

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);        
    }
        
   @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending")
   void testPaymentDateSorting() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {  
	   String paymentType="generalPayment90Days";
   	   String filterPayments="Show All";
   	   String quickSearchFilter="Last 90 days";
       testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "TIN");		
	   
		
       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 	   ViewPayments paymentSummaryPage= home.clickViewPaymentsTab().enterBSTin(userType,paymentType);
 		
       home.clickViewPaymentsTab().setSearchFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
       paymentSummaryPage.verifyPaymentDateSorting("Desc");
       paymentSummaryPage.verifyPaymentDateSorting("Asc");    
   }
      
   @Test(priority=5,description="TS012_View Payments_Market Type filter_Medical_Dental etc" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type",groups="View Payments - BS")
   void testSpecificMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String mktTypeFilter="Medical";
       String paymentType="medicalFilter";
	   testConfig.putRunTimeProperty("key", "MARKET_TYPE");
	   testConfig.putRunTimeProperty("value", "M");
	   

	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifyMktType(mktTypeFilter);
   }
      
   
   @Test(priority=5,description="TS013_View Payments_Market Type filter_Show All" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-ALL from the  filter - Market Type",groups="View Payments - BS")
   void testALLMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
	   String filterPayments="Show All";
       String quickSearchFilter="Last 60 days";
       String paymentType="generalPayment60Days";
       testConfig.putRunTimeProperty("key", "MARKET_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL"); 
	  	
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    ViewPayments paymentSummaryPage= home.clickViewPaymentsTab().enterBSTin(userType,paymentType);
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments); 	
   }
   
   @Test(priority=5,description="TS014_View Payments_Zero Dollar ACH Payments",groups="View Payments - BS")
   void testZeroDollarACHPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="ACH"; 
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	 
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifyZeroDollarPayments(paymentType);      
   }
   
   @Test(priority=5,description="TS015_View Payments_Zero Dollar ACH Payments",groups="View Payments - BS")
   void testZeroDollarVCPPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="VCP"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifyZeroDollarPayments(paymentType);      
   }
   
   @Test(priority=5,description="TS024_View Payments_Remit payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Remit Payments",groups="View Payments - BS")
   void testRemitPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="remitPayment";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   ViewPayments paymentSummaryPage= home.clickViewPaymentsTab().enterBSTin(userType,paymentType).setQuickSearchFilter(paymentType);  
       paymentSummaryPage.verifyRemitPaymentPopUp();  
	}

   @Test(priority=5,description="TS025_View Payments_Failed payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Failed Payments",groups="View Payments - BS")
   void testFailedPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="failedPayment";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   ViewPayments paymentSummaryPage= home.clickViewPaymentsTab().enterBSTin(userType,paymentType).setQuickSearchFilter(paymentType);    
       paymentSummaryPage.verifyFailedPaymentPopUp();  

	}   
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - BS")
      void testTINOnlyFilter30Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
       {
   
           String filterPayments="TIN Only";
           String quickSearchFilter="Last 30 days";
           String MktTypeFilter = "Show All";
           String paymentType="generalPaymentForTIN_30days";
           testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
                 testConfig.putRunTimeProperty("value", "TIN");
   
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
                 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
                 home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, MktTypeFilter, MktTypeFilter);
   
       }
   
   
   @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
   
     void testPaymentsArchiveOnly_30days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
     {
          String filterPayments="Show All";
          String archiveFilter="Archived Only";
          String quickSearchFilter="Last 30 days";
          String paymentType="archiveOnly30Days";
          testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
            testConfig.putRunTimeProperty("value", "Y");
   
          UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
          OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
            HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
          home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
     }
   
   
      @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
   
     void testPaymentsArchiveOnly_60days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
     {
          String filterPayments="Show All";
          String archiveFilter="Archived Only";
          String quickSearchFilter="Last 60 days";
          String paymentType="archiveOnly60Days";
          testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
            testConfig.putRunTimeProperty("value", "Y");
   
          UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
          OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
            HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
          home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
     }
   
   @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testPaymentsArchiveOnly_90days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Archived Only";
           String quickSearchFilter="Last 90 days";
           String paymentType="archiveOnly90Days";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
                 testConfig.putRunTimeProperty("value", "Y");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      }
   
      @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testPaymentsArchiveOnly_4_6months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Archived Only";
           String quickSearchFilter="Last 4-6 months";
           String paymentType="archiveOnly4_6months";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
                 testConfig.putRunTimeProperty("value", "Y");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      }
   
   
   @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testPaymentsArchiveOnly_6_9months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Archived Only";
           String quickSearchFilter="Last 6-9 months";
           String paymentType="archiveOnly6_9months";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
           testConfig.putRunTimeProperty("value", "Y");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      }
   
      @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testArchivedPaymentsFilterArchiveOnly_9_13months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Archived Only";
           String quickSearchFilter="Last 9-13 months";
           String paymentType="archiveOnly9_13months";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
           testConfig.putRunTimeProperty("value", "Y");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
           HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      }
   /**
       * TS022
       * @throws IOException
       * @throws InterruptedException
       * @throws JAXBException
       * @throws SAXException
       * @throws ParserConfigurationException
       * @throws ParseException
       */
   
      @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testActiveOnlyPayments_30days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Active Only";
           String quickSearchFilter="Last 30 days";
           String paymentType="activeOnly30Days";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
                 testConfig.putRunTimeProperty("value", "N");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);

      }
   
      @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testActiveOnlyPayments_60days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Active Only";
           String quickSearchFilter="Last 60 days";
           String paymentType="activeOnly60Days";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
                 testConfig.putRunTimeProperty("value", "N");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);

      }

   @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testActiveOnlyPayments_90days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Active Only";
           String quickSearchFilter="Last 90 days";
           String paymentType="activeOnly90Days";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
                 testConfig.putRunTimeProperty("value", "N");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);

      }
   
      @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testActiveOnlyPayments_4_6months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Active Only";
           String quickSearchFilter="Last 4-6 months";
           String paymentType="activeOnly4_6months";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
                 testConfig.putRunTimeProperty("value", "N");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);

      }
   @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testActiveOnlyPayments_6_9months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Active Only";
           String quickSearchFilter="Last 6-9 months";
           String paymentType="activeOnly6_9months";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
                 testConfig.putRunTimeProperty("value", "N");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
             HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);

      }
   
      @TestDetails(author="Priyanka")
      @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments",groups="View Payments - BS")
      void testActiveOnlyPayments_9_13months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
      {
           String filterPayments="Show All";
           String archiveFilter="Active Only";
           String quickSearchFilter="Last 9-13 months";
           String paymentType="activeOnly9_13months";
           testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
           testConfig.putRunTimeProperty("value", "N");
   
           UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
           OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
           HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
           home.clickViewPaymentsTab().enterBSTin(userType,paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);

      }




}
