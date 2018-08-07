package test.java;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

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


public class TestBSGenViewPayments extends TestBase {
	String userType="BS";
    String accessType="Gen";
        

    
    
    @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending")
    void testPaymentDateSorting() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {   
 	    String quickSearchFilter="Last 60 days";
 	    String archiveFilter="Show All";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter);
        paymentSummaryPage.verifyPaymentDateSorting("Desc");
        paymentSummaryPage.verifyPaymentDateSorting("Asc");    
    }
        

    @Test(priority=3,description="TS004_View Payments_Payments filter_TIN Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
    void testPaymentDetailsForTinOnlyfilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
       
         String filterPayments="TIN Only";
         String archiveFilter="Show All";
         String quickSearchFilter="Last 30 days";
         
         testConfig.putRunTimeProperty("key", "taxIdentifierType");
 		testConfig.putRunTimeProperty("value", "TIN");		

         UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
         OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 	    home.selectTin();
         paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
       
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
       
         /*
         quickSearchFilter="Last 60 days";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
       
         quickSearchFilter="Last 90 days";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
       
         quickSearchFilter="Last 4-6 months";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
       
         quickSearchFilter="Last 6-9 months";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
       
         quickSearchFilter="Last 9-13 months";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
         */
   }	
 

    @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
    void testPaymentDetailsForNPIOnlyFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
     {
          
         String filterPayments="NPI Only";
         String archiveFilter="Show All";
         String quickSearchFilter="Last 30 days";
         
         testConfig.putRunTimeProperty("key", "taxIdentifierType");
         testConfig.putRunTimeProperty("value", "NPI");		

         UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
         OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
  		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
  		 home.selectTin();
         paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
          /*
         quickSearchFilter="Last 60 days";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
          
         quickSearchFilter="Last 90 days";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
          
//         quickSearchFilter="Last 4-6 months";
//         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
//          
//         quickSearchFilter="Last 6-9 months";
//         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
//          
//         quickSearchFilter="Last 9-13 months";
//         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
         */
      }	
   
    
    
   @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="";		
		
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");			
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		
		//By default gets data for 30 days		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().verifyDefaultSearchResultCount();
		
	 }	
   

   @Test(priority=1,description="TS007_View Payments_Payments filter_Last Sixty Days " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForLastSixtyDaysFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 60 days";
				
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");	
				
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);        
	 }	

   
   @Test(priority=1,description="TS008_View Payments_Payments filter_Last Ninety Days " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForLastNinetyDaysFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 90 days";
				
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");	
				
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();

		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	 }	

   
   @Test(priority=1,description="TS009_View Payments_Payments filter_Last 4 to 6 Months " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForFourToSixMonthsFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 4-6 months";
				
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");	
				
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();

		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);         
	 }	

   
   
   @Test(priority=1,description="TS010_View Payments_Payments filter_Last 6 to 9 Months " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForSixToNineMonthsFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 6-9 months";
				
		testConfig.putRunTimeProperty("key", "taxIdentifierType");
		testConfig.putRunTimeProperty("value", "ALL");	
				
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	 }	

   
   @Test(priority=1,description="TS011_View Payments_Payments filter_Last 9 to 13 Months " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   	void testPaymentDetailsForNineToThirteenMonthsFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="Last 9-13 months";
				
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
   
   @Test(priority=5,description="TS022_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Archived Only' from the  filter - Archive Payments")
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
   
   
   @Test(priority=5,description="TS022_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
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


    
}

			
