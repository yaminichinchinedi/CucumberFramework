package test.java;

import java.io.IOException;
import java.text.ParseException;

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



public class TestViewPayments extends TestBase {
	String userType="PROV";
    String accessType="Admin";
        
   @Test(priority=5,description="TS006_View Payments_Payments filter_Show All " + " "
   		                        + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   void testRecordCountForShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="";
		testConfig.putRunTimeProperty("taxIdentifierType", "ALL");	
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		LoginUPA loginPage=new LoginUPA(testConfig);
		SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
		OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		
		//By default gets data for 30 days
		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().verifyDefaultSearchResultCount();
		
		quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
         
         quickSearchFilter="Last 90 days";
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
         
//         quickSearchFilter="Last 4-6 months";
//         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
//         
//         quickSearchFilter="Last 6-9 months";
//         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
//         
//         quickSearchFilter="Last 9-13 months";
//         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	 }	
   
   
   @Test(priority=5,description="TS005_View Payments_Payments filter_NPI Only"
		   + "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testRecordCountForNPIOnlyFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
         String filterPayments="NPI Only";
         String archiveFilter="Show All";
         String quickSearchFilter="Last 30 days";
         testConfig.putRunTimeProperty("taxIdentifierType", "NPI");	

         UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
         LoginUPA loginPage=new LoginUPA(testConfig);
         SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
         OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
         HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
         home.selectTin();
         paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
         paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
         
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
     }	
   
   
   @Test(priority=5,description="TS004_View Payments_Payments filter_TIN Only"
           + '\n' + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
   void testRecordCountForTinOnlyfilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
      String filterPayments="TIN Only";
      String archiveFilter="Show All";
      String quickSearchFilter="Last 30 days";
      testConfig.putRunTimeProperty("taxIdentifierType", "TIN");	

      UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
      LoginUPA loginPage=new LoginUPA(testConfig);
      SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
      OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
      HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
      home.selectTin();
      paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
      
      paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
      
      quickSearchFilter="Last 60 days";
      paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
      quickSearchFilter="Last 90 days";
      paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
      quickSearchFilter="Last 4-6 months";
      paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
      quickSearchFilter="Last 6-9 months";
      paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
//      quickSearchFilter="Last 9-13 months";
//      paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
  }	




}

			
