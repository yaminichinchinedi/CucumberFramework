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
        
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - Payer ")
    void testPaymentsForShowAllFilter_30days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="generalPayment30Days";
    	String filterPayments="Show All";
    	String quickSearchFilter="Last 30 days";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		testConfig.putRunTimeProperty("835ID", "87726");
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		
 		//By default gets data for 30 days
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - Payer ")
    void testPaymentsForShowAllFilter_60days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="generalPayment60Days";
    	String filterPayments="Show All";
    	String quickSearchFilter="Last 60 days";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		testConfig.putRunTimeProperty("835ID", "87726");
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - Payer ")
    void testPaymentsForShowAllFilter_90days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="generalPayment90Days";
    	String filterPayments="Show All";
    	String quickSearchFilter="Last 90 days";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		testConfig.putRunTimeProperty("835ID", "87726");
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - Payer ")
    void testPaymentsForShowAllFilter_4_6months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="Last 4-6 months";
    	String filterPayments="Show All";
    	String quickSearchFilter=paymentType;
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		testConfig.putRunTimeProperty("835ID", "87726");
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - Payer ")
    void testPaymentsForShowAllFilter_6_9months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="Last 6-9 months";
    	String filterPayments="Show All";
    	String quickSearchFilter=paymentType;
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		testConfig.putRunTimeProperty("835ID", "87726");
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
    
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments",groups="View Payments - Payer ")
    void testPaymentsForShowAllFilter_9_13months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
    	String paymentType="Last 9-13 months";
    	String filterPayments="Show All";
    	String quickSearchFilter=paymentType;
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		testConfig.putRunTimeProperty("835ID", "87726");
 		
 		
 		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
 		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
 	 }
  
    @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
    void testNPIOnlyFilter30Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
     {
          
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 30 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_30days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "NPI");	
 		testConfig.putRunTimeProperty("835ID", "87726");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
  		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
  		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
         
     }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testNPIOnlyFilter60Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 60 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_60days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("835ID", "87726");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testNPIOnlyFilter90Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 90 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_90days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("835ID", "87726");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testNPIOnlyFilter4_6months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 4-6 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_4-6months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("835ID", "87726");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
    }
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testNPIOnlyFilter6To9Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 6-9 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_6-9months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("835ID", "87726");	
		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		 home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testNPIOnlyFilter9To13Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="NPI Only";
        String quickSearchFilter="Last 9-13 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForNPI_9-13months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");	
		testConfig.putRunTimeProperty("835ID", "87726");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   /**
    * Tin only
    */
    
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testTINOnlyFilter60Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 60 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_60days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("835ID", "87726");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);
        
    }
   
  
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testTINOnlyFilter90Days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 90 days";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_90days";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("835ID", "87726");	
			
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter); 
    }
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testTINOnlyFilter4To6Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 4-6 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_4_6months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("835ID", "87726");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testTINOnlyFilter6To9Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 6-9 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_6_9months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("835ID", "87726");	

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);	 		
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
   
   
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments",groups="View Payments - Payer ")
   void testTINOnlyFilter9To13Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {         
        String filterPayments="TIN Only";
        String quickSearchFilter="Last 9-13 months";
        String MktTypeFilter = "Show All";
        String paymentType="generalPaymentForTIN_9_13months";
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");	
		testConfig.putRunTimeProperty("835ID", "87726");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.clickViewPaymentsTab().payerTin(paymentType).verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, MktTypeFilter);        
    }
        
   @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending",groups="View Payments - Payer ")
   void testPaymentDateSorting() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {  
	   String paymentType="generalPayment90Days";
   	   String filterPayments="Show All";
   	   String quickSearchFilter="Last 90 days";
       testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "TIN");		
	   testConfig.putRunTimeProperty("835ID", "87726");
		
       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
 		
       home.clickViewPaymentsTab().setSearchFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
       paymentSummaryPage.verifyPaymentDateSorting("Desc");
       paymentSummaryPage.verifyPaymentDateSorting("Asc");    
   }
      
   @Test(priority=5,description="TS012_View Payments_Market Type filter_Medical_Dental etc" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type",groups="View Payments - Payer ")
   void testSpecificMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String mktTypeFilter="Medical";
       String paymentType="medicalFilter";
	   testConfig.putRunTimeProperty("key", "MARKET_TYPE");
	   testConfig.putRunTimeProperty("value", "M");
	   testConfig.putRunTimeProperty("835ID", "87726");

	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.clickViewPaymentsTab().payerTin(paymentType).verifyMktType(mktTypeFilter);
   }
      
   
   @Test(priority=5,description="TS013_View Payments_Market Type filter_Show All" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-ALL from the  filter - Market Type",groups="View Payments - Payer ")
   void testALLMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
	   String filterPayments="Show All";
       String quickSearchFilter="Last 60 days";
       String paymentType="generalPayment60Days";
       testConfig.putRunTimeProperty("key", "MARKET_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL"); 
	   testConfig.putRunTimeProperty("835ID", "87726");		
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType);
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments); 	
   }
   
   @Test(priority=5,description="TS014_View Payments_Zero Dollar ACH Payments",groups="View Payments - Payer ")
   void testZeroDollarACHPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="ACH"; 
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("835ID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.clickViewPaymentsTab().payerTin(paymentType).verifyZeroDollarPayments(paymentType);      
   }
   
   @Test(priority=5,description="TS015_View Payments_Zero Dollar ACH Payments",groups="View Payments - Payer ")
   void testZeroDollarVCPPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="VCP"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("835ID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.clickViewPaymentsTab().payerTin(paymentType).verifyZeroDollarPayments(paymentType);      
   }
   
   
   @Test(priority=5,description="TS020_View Payments_display of Payments for Payer Role")
   void testPayerRolePayments() throws IOException  
   {
	   String paymentType="generalPayment90Days"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("835ID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.clickViewPaymentsTab().payerTin(paymentType).verifyPayerRolePayments();    
   }
   
   @Test(priority=5,description="TS024_View Payments_Remit payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Remit Payments",groups="View Payments - Payer ")
   void testRemitPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="remitPayment";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("835ID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType).setQuickSearchFilter(paymentType);  
       paymentSummaryPage.verifyRemitPaymentPopUp();  
	}

   
   @Test(priority=5,description="TS025_View Payments_Failed payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Failed Payments",groups="View Payments - Payer ")
   void testFailedPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="failedPayment";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   testConfig.putRunTimeProperty("835ID", "87726");
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().payerTin(paymentType).setQuickSearchFilter(paymentType);    
       paymentSummaryPage.verifyFailedPaymentPopUp();  

	}   
}
