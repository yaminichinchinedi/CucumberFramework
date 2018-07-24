package test.java;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

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
	String userType="PAYER";
    String accessType="Admin";
        
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
   
   
   
}

			
