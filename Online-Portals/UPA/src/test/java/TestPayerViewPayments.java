package test.java;

import java.io.IOException;
import java.text.ParseException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.TestDataReader;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.paymentSummary;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;


public class TestPayerViewPayments extends TestBase {
	String userType="PAY";
    String accessType="Admin";
        
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
    void testShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {	   
    	String filterPayments="Show All";
    	String quickSearchFilter="";
    	String paymentType="generalPayment";

    	testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
    	testConfig.putRunTimeProperty("value", "ALL");			
    	testConfig.putRunTimeProperty("payerID", "87726");		

    	UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
    	OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
    	HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);		
    	paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);

    	//	By default gets data for 30 days		
    	paymentSummaryPage= home.clickViewPaymentsTab().verifyDefaultSearchResultCount();

    	quickSearchFilter="Last 60 days";
    	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);

    	quickSearchFilter="Last 90 days";	
    	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);

    	quickSearchFilter="Last 4-6 months";
    	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);

    	quickSearchFilter="Last 6-9 months";
    	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);

    	quickSearchFilter="Last 9-13 months";
    	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);     

    }	
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testNPIOnlyFilter60Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 60 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","60 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	
 		paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testTINOnlyFilter60Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 60 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","60 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	
 		paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
        
    }
   
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testNPIOnlyFilter90Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 90 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","90 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	
 		paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testTINOnlyFilter90Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 90 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","90 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	
 		paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testNPIOnlyFilter4To6Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 4-6 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","120 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testTINOnlyFilter4To6Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 4-6 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","120 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testNPIOnlyFilter6To9Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 6-9 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","180 days");

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testTINOnlyFilter6To9Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 6-9 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","180 days");

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testNPIOnlyFilter9To13Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 9-13 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","270 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testTINOnlyFilter9To13Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 9-13 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("payerID", "87726");	
		testConfig.putRunTimeProperty("days","270 days");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
        
   @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending")
   void testPaymentDateSorting() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {  
	    String filterPayments= "Show All";
	    String quickSearchFilter="";
	    quickSearchFilter="Last 4-6 months";
	    String MktTypeFilter = "Show All";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");		
		testConfig.putRunTimeProperty("payerID", "87726");
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin();
 		
        home.clickViewPaymentsTab().setSearchFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
        paymentSummaryPage.verifyPaymentDateSorting("Desc");
        paymentSummaryPage.verifyPaymentDateSorting("Asc");    
   }
      
   @Test(priority=5,description="TS012_View Payments_Market Type filter_Medical_Dental etc" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type")
   void testSpecificMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
	   String filterPayments="Show All";
	   String mktTypeFilter="Medical";
	   String quickSearchFilter="Last 60 days";
	   String paymentType="generalPayment";

	   testConfig.putRunTimeProperty("key", "MARKET_TYPE");
	   testConfig.putRunTimeProperty("value", "M");
	   testConfig.putRunTimeProperty("payerID", "87726");

	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
	   paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, mktTypeFilter); 	
   }
      
   
   @Test(priority=5,description="TS013_View Payments_Market Type filter_Show All" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-ALL from the  filter - Market Type")
   void testALLMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String mktTypeFilter="Show All";
        String quickSearchFilter="Last 60 days";
        String paymentType="generalPayment";

        testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		testConfig.putRunTimeProperty("value", "ALL");
		testConfig.putRunTimeProperty("payerID", "87726");		
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, mktTypeFilter); 	
   }
   
   @Test(priority=5,description="TS014_View Payments_Zero Dollar ACH Payments")
   void testZeroDollarACHPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="ACH"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("payerID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
	   paymentSummaryPage.verifyZeroDollarPayments(paymentType);      
   }
   
   @Test(priority=5,description="TS015_View Payments_Zero Dollar ACH Payments")
   void testZeroDollarVCPPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="VCP"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("payerID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
	   paymentSummaryPage.verifyZeroDollarPayments(paymentType);      
   }
   
   @Test(priority=5,description="TS020_View Payments_display of Payments for Payer Role")
   void testPayerRolePayments() throws IOException  
   {
	   String paymentType="generalPayment"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("payerID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
	   paymentSummaryPage.verifyPayerRolePayments();    
   }
   
   @Test(priority=5,description="TS024_View Payments_Remit payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Remit Payments")
   void testRemitPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="remitPayment";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("payerID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType).setQuickSearchFilter(paymentType);       
       paymentSummaryPage.verifyRemitPaymentPopUp();  
	}

   
   @Test(priority=5,description="TS025_View Payments_Failed payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Failed Payments")
   void testFailedPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="failedPayment";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("payerID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType).setQuickSearchFilter(paymentType);    
       paymentSummaryPage.verifyFailedPaymentPopUp();  

	}
   
   @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments")
   void testActiveOnlyArchivedPaymntFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter="Active Only";
        String quickSearchFilter="Last 30 days";
		String paymentType="generalPayment";
        
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");	
		testConfig.putRunTimeProperty("payerID", "87726");

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);	    
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
      
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
      
   @Test(priority=5,description="TS022_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
   void testShowAllArchivedPaymntFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter=filterPayments;
        String quickSearchFilter="Last 30 days";
		String paymentType="generalPayment";
        
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");
		testConfig.putRunTimeProperty("payerID", "87726");
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);	    
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
      
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
}
