package test.java;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.paymentSummary;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class TestUPASearchRemittance extends TestBase{
		String userType="PROV";
		String accessType="Admin";
    
	   @Test(priority=5,description="TS023_Error Messages")
	   void testByErrorMsgs() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().verifyErrorMsgs();
	   }
		
	   @Test(priority=5,description="TS027_Returned Reason")
		void testByReturnedReason() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	    {
			String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyreturnedReasonDisplayed(criteriaType,"UPA");
	    }
	   
		@Test(priority=5,description="TS036_Sorting on Payer Name")
		void testSortByPayerName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	    {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payer");
	    }
		
		@Test(priority=5,description="TS037_Sorting on Claim Date")
		void testSortByClaimDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Date");
	   }
		
		@Test(priority=5,description="TS038_Sorting on NPI")
		void testSortByNPI() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("NPI");
	   }
		
		@Test(priority=5,description="TS039_Sorting on Patient Name")
		void testSortByPatientName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	    {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Patient Name");
	    }
		
		@Test(priority=5,description="TS040_Sorting on Subscriber Id")
		void testSortBySubscriberId() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Subscriber ID");
	   }
		
		@Test(priority=5,description="TS041_Sorting on Account Number")
		void testSortByAccountNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Account Number");
	   }
		
		@Test(priority=5,description="TS042_Sorting on Claim #")
		void testSortByClaimHash() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim #");
		}
		
		@Test(priority=5,description="TS043_Sorting on Claim Amount")
		void testSortByClaimAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Amount");	        
	   }
		
		@Test(priority=5,description="TS044_Sorting on Market Type")
		void testSortByMarketType() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Market Type");
	   }
		
		@Test(priority=5,description="TS045_Sorting on Archive")
		void testSortByArchive() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
		{
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Archive");
	   }
		
		@Test(priority=5,description="TS047_Sorting on Payment Number")
		void testSortByPaymentNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
		{
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payment Number");
	   }
		
		@Test(priority=5,description="TS049_Pagination of Search Results")
		void testPaginationOfSearchResults() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
		{
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyPagination();
	   }
}

