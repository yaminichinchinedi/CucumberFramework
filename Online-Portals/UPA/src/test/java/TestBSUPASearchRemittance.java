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

public class TestBSUPASearchRemittance extends TestBase{
 
	String userType="BS";
	String accessType="Admin";
    
	//001264825
	
	@Test(priority=5,description="TS002_Search by Date of Payment")
	public void testEprabyDOP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS003_Search by Date of service")
	public void testEpraByDateOfService() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDateOfService";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS004_Search by Electronic Payment Number only")
	public void testEpraByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byElectronicPaymentNumber";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	 }

	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByCheckNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byCheckNumber";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	 }
	
	@Test(priority=5,description="TS006_Search by DOP and Acnt Number")
	public void testEprabyDOPAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDOPAndAcntNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS007_Search by DOP and Subscriber ID")
	public void testEprabyDOPAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDOPAndSubscriberId";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS008_Search by DOP and NPI")
	public void testEprabyDOPAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDOPAndNpi";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS0059_Search by DOP and Claim Number")
	public void testEprabyDOPAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDOPAndClmNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS010_Search by DOP and Patient Name")
	public void testEprabyDOPAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDOPAndPtntNm";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS011_Search by DOP and Zero Payment Claims")
	public void testEprabyDOPAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
			
		String criteriaType="byDOPAndZeroPmntClms";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS012_Search by DOP and Market Type")
	public void testEprabyDOPAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="BS";
		String accessType="Admin";
		String criteriaType="byDOPAndMarketType";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType);		
	}
	
   @Test(priority=5,description="TS023_Error Messages")
   public void testByErrorMsgs() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	    String criteriaType="byDOP"; 
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).verifyErrorMsgs();
   }
   
   @Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
   public void testSearchByPatientNameTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byDOPAndPtntNm"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
   public void testSearchBySubscriberIDTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byDOPAndSubscriberId"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	    String criteriaType="byDOP";
		String tinType="ReoriginatedACH"; 		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).searchByElectronicPaymentToVerifyPaymentStatusforACH(tinType).verifyPaymentStatus("ACH");
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byElectronicPaymentforStatus";
		String tinType="byElectronicPaymentforStatus";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   // home.selectTin();
	    testConfig.putRunTimeProperty("type","VCP");
	    home.clickSearchRemittanceTab().selectTin(criteriaType).searchByElectronicPaymentToVerifyPaymentStatusforVCP(criteriaType).verifyPaymentStatus("VCP");
		
   }
   
   @Test(priority=5,description="TS027_Returned Reason")
   public void testByReturnedReason() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifyreturnedReasonDisplayed(criteriaType,"UPA");
   }
   
	@Test(priority=5,description="TS036_Sorting on Payer Name")
	public void testSortByPayerName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Payer");
    }
	
	@Test(priority=5,description="TS037_Sorting on Claim Date")
	public void testSortByClaimDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Claim Date");
    }
	
	@Test(priority=5,description="TS038_Sorting on NPI")
	public void testSortByNPI() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"NPI");
    }
	
	@Test(priority=5,description="TS039_Sorting on Patient Name")
	public void testSortByPatientName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Patient Name");
    }
	
	@Test(priority=5,description="TS040_Sorting on Subscriber Id")
	public void testSortBySubscriberId() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Subscriber ID");
    }
	
	@Test(priority=5,description="TS041_Sorting on Account Number")
	public void testSortByAccountNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Account Number");
    }
	
	@Test(priority=5,description="TS042_Sorting on Claim #")
	public void testSortByClaimHash() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Claim #");
    }
	
	@Test(priority=5,description="TS043_Sorting on Claim Amount")
	public void testSortByClaimAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Claim Amount");	        
    }
	
	@Test(priority=5,description="TS044_Sorting on Market Type")
	public void testSortByMarketType() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Market Type");
    }
	
	@Test(priority=5,description="TS045_Sorting on Archive")
	public void testSortByArchive() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Archive");
    }
	
	@Test(priority=5,description="TS047_Sorting on Payment Number")
	public void testSortByPaymentNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifySorting(criteriaType,"Payment Number");
    }
	
	@Test(priority=5,description="TS049_Pagination of Search Results")
	public void testPaginationOfSearchResults() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType).doSearch(criteriaType).verifyPagination();
	    //010179500 //21-03-2018
   }
	
}