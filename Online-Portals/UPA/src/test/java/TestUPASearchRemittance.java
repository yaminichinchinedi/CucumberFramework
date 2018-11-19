package test.java;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchRemittanceSearchCriteria;
import main.java.pageObjects.SearchTinPageSearchRemittance;
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
	   
	   @Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
	   public void testSearchByPatientNameTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	   {
			String criteriaType="byDateOfPaymentAndPtntNm"; 	
			String requestType="byDateOfPayment";
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
	   }
	   
	   @Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
	   public void testSearchBySubscriberIDTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	   {
			String criteriaType="byDateOfPaymentAndSubscriberId"; 	
			String requestType="byDateOfPayment";
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
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
	   
	   @Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String tinType="ReoriginatedACH"; 		
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().searchByElectronicPaymentToVerifyPaymentStatusforACH(tinType).verifyPaymentStatus("ACH");
	     }
	   
		@Test(priority=5,description="TS036_Sorting on Payer Name")
		void testSortByPayerName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	    {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payer",criteriaType);
	    }
		
		@Test(priority=5,description="TS037_Sorting on Claim Date")
		void testSortByClaimDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Date",criteriaType);
	   }
		
		@Test(priority=5,description="TS038_Sorting on NPI")
		void testSortByNPI() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("NPI",criteriaType);
	   }
		
		@Test(priority=5,description="TS039_Sorting on Patient Name")
		void testSortByPatientName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	    {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Patient Name",criteriaType);
	    }
		
		@Test(priority=5,description="TS040_Sorting on Subscriber Id")
		void testSortBySubscriberId() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Subscriber ID",criteriaType);
	   }
		
		@Test(priority=5,description="TS041_Sorting on Account Number")
		void testSortByAccountNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Account Number",criteriaType);
	   }
		
		@Test(priority=5,description="TS042_Sorting on Claim #")
		void testSortByClaimHash() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim #",criteriaType);
		}
		
		@Test(priority=5,description="TS043_Sorting on Claim Amount")
		void testSortByClaimAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Amount",criteriaType);	        
	   }
		
		@Test(priority=5,description="TS044_Sorting on Market Type")
		void testSortByMarketType() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	   {
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Market Type",criteriaType);
	   }
		
		@Test(priority=5,description="TS045_Sorting on Archive")
		void testSortByArchive() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
		{
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Archive",criteriaType);
	   }
		
		@Test(priority=5,description="TS047_Sorting on Payment Number")
		void testSortByPaymentNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
		{
    		String criteriaType="byDateOfPayment";
	        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payment Number",criteriaType);
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

