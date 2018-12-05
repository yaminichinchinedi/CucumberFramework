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

public class TestProvUPASearchRemittance extends TestBase{
 
	String userType="PROV";
	String accessType="Admin";
    
	@Test(priority=5,description="TS002_Search by Date of Payment")
	public void testEprabyDOP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS003_Search by Date of Service")
	public void testEprabyDOS() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOS";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS004_Search by Electronic Payment Number only")
	public void testEpraByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byElectronicPaymentNumber";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	 }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByCheckNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byCheckNumber";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	 }
	
	@Test(priority=5,description="TS006_Search by DOP and Acnt No")
	public void testEprabyDOPAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOPAndAcntNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS007_Search by DOP and Sybscriber ID")
	public void testEprabyDOPAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOPAndSubscriberId";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS008_Search by DOP and NPI")
	public void testEprabyDOPAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOPAndNpi";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS009_Search by DOP and Claim Number")
	public void testEprabyDOPAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOPAndClmNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS010_Search by DOP abd Patient Name")
	public void testEprabyDOPAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOPAndPtntNm";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS011_Search by DOP and Zero Payment Claims")
	public void testEprabyDOPAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOPAndZeroPmntClms";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS012_Search by DOP and Market Type")
	public void testEprabyDOPAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOPAndMarketType";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS013_Search by DOS and Acnt No")
	public void testEprabyDOSAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOSAndAcntNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS014_Search by DOS and Sybscriber ID")
	public void testEprabyDOSAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOSAndSubscriberId";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS015_Search by DOS and NPI")
	public void testEprabyDOSAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOSAndNpi";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS016_Search by DOS and Claim Number")
	public void testEprabyDOSAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOSAndClmNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS017_Search by DOP abd Patient Name")
	public void testEprabyDOSAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOSAndPtntNm";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS018_Search by DOS and Zero Payment Claims")
	public void testEprabyDOSAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOSAndZeroPmntClms";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS019_Search by DOS and Market Type")
	public void testEprabyDOSAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Admin";
			
		String criteriaType="byDOSAndMarketType";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
   @Test(priority=5,description="TS023_Error Messages")
   public void testByErrorMsgs() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().verifyErrorMsgs();
   }
   
   @Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
   public void testSearchByPatientNameTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byDOPAndPtntNm"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
   public void testSearchBySubscriberIDTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byDOPAndSubscriberId"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byElectronicPaymenForACH"; 		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("ACH");
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byElectronicPaymenForVCP";
		String tinType="byElectronicPaymenForVCP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
	    home.clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("VCP");
		
   }
   
   @Test(priority=5,description="TS027_Returned Reason")
   public void testByReturnedReason() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyreturnedReasonDisplayed(criteriaType,"UPA");
   }
   
	@Test(priority=5,description="TS036_Sorting on Payer Name")
	public void testSortByPayerName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Payer");
    }
	
	@Test(priority=5,description="TS037_Sorting on Claim Date")
	public void testSortByClaimDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Claim Date");
    }
	
	@Test(priority=5,description="TS038_Sorting on NPI")
	public void testSortByNPI() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"NPI");
    }
	
	@Test(priority=5,description="TS039_Sorting on Patient Name")
	public void testSortByPatientName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Patient Name");
    }
	
	@Test(priority=5,description="TS040_Sorting on Subscriber Id")
	public void testSortBySubscriberId() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Subscriber ID");
    }
	
	@Test(priority=5,description="TS041_Sorting on Account Number")
	public void testSortByAccountNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Account Number");
    }
	
	@Test(priority=5,description="TS042_Sorting on Claim #")
	public void testSortByClaimHash() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Claim #");
    }
	
	@Test(priority=5,description="TS043_Sorting on Claim Amount")
	public void testSortByClaimAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Claim Amount");	        
    }
	
	@Test(priority=5,description="TS044_Sorting on Market Type")
	public void testSortByMarketType() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Market Type");
    }
	
	@Test(priority=5,description="TS045_Sorting on Archive")
	public void testSortByArchive() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Archive");
    }
	
	@Test(priority=5,description="TS047_Sorting on Payment Number")
	public void testSortByPaymentNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Payment Number");
    }
	
	@Test(priority=5,description="TS049_Pagination of Search Results")
	public void testPaginationOfSearchResults() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyPagination();
   }
	
	
	
	//Test cases for PROVIDER GENERAL
	
	
	@Test(priority=5,description="TS002_Search by Date of Payment")
	public void testEprabyDOPForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS003_Search by Date fo Service")
	public void testEprabyDOSForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOS";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS004_Search by Electronic Payment Number Only")
	public void testEpraByPaymentNumberForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byElectronicPaymentNumber";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	 }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByCheckNumberForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byCheckNumber";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	 }
	
	@Test(priority=5,description="TS006_Search by DOP and Acnt Number")
	public void testEprabyDOPAndAcntNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOPAndAcntNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS007_Search by DOP and Subscriber ID")
	public void testEprabyDOPAndSubscriberIdForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOPAndSubscriberId";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS008_Search by DOP and NPI")
	public void testEprabyDOPAndNpiForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOPAndNpi";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS009_Search by DOP and Claim Number")
	public void testEprabyDOPAndClmNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOPAndClmNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS010_Search by DOP and Patient Name ")
	public void testEprabyDOPAndPtntNmForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOPAndPtntNm";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS011_Search by DOP and Zero Payment claims")
	public void testEprabyDOPAndZeroPmntClmsForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOPAndZeroPmntClms";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS012_Search by DOP and Market Type")
	public void testEprabyDOPAndMarketTypeForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOPAndMarketType";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS013_Search by DOS and Acnt Number")
	public void testEprabyDOSAndAcntNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOSAndAcntNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS014_Search by DOS and Subscriber ID")
	public void testEprabyDOSAndSubscriberIdForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOSAndSubscriberId";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS015_Search by DOS and NPI")
	public void testEprabyDOSAndNpiForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOSAndNpi";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS016_Search by DOS and Claim Number")
	public void testEprabyDOSAndClmNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOSAndClmNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS017_Search by DOS and Patient Name ")
	public void testEprabyDOSAndPtntNmForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOSAndPtntNm";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS018_Search by DOS and Zero Payment claims")
	public void testEprabyDOSAndZeroPmntClmsForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOSAndZeroPmntClms";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
	@Test(priority=5,description="TS019_Search by DOS and Market Type")
	public void testEprabyDOSAndMarketTypeForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String userType="PROV";
		String accessType="Gen";
			
		String criteriaType="byDOSAndMarketType";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType);		
	}
	
   @Test(priority=5,description="TS023_Error Messages")
   public void testByErrorMsgsForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	    String userType="PROV";
		String accessType="Gen";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().verifyErrorMsgs();
   }
   
   @Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
   public void testSearchByPatientNameTricarePayerForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	    String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOPAndPtntNm"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
   public void testSearchBySubscriberIDTricarePayerForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	    String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOPAndSubscriberId"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForACHForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	    String userType="PROV";
		String accessType="Gen";
		String tinType="ReoriginatedACH"; 	
		String criteriaType="byElectronicPaymenForACH";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("ACH");
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForVCPForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	    String userType="PROV";
		String accessType="Gen";
		String criteriaType="byElectronicPaymenForVCP";
		String tinType="byElectronicPaymenForVCP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
	    home.clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("VCP");
		
   }
	
	@Test(priority=5,description="TS027_Returned Reason")
   public void testByReturnedReasonForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
		String userType="PROV";
		String accessType="Gen";
		
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().doSearch(criteriaType).verifyreturnedReasonDisplayed(criteriaType,"UPA");
   }

	@Test(priority=5,description="TS036_Sorting on Payer Name")
	public void testSortByPayerNameForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Payer");
    }
	
	@Test(priority=5,description="TS037_Sorting on Claim Date")
	public void testSortByClaimDateForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Claim Date");
    }
	
	@Test(priority=5,description="TS038_Sorting on NPI")
	public void testSortByNPIForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"NPI");
    }
	
	@Test(priority=5,description="TS039_Sorting on Patient Name")
	public void testSortByPatientNameForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Patient Name");
    }
	
	@Test(priority=5,description="TS040_Sorting on Subscriber Id")
	public void testSortBySubscriberIdForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Subscriber ID");
    }
	
	@Test(priority=5,description="TS041_Sorting on Account Number")
	public void testSortByAccountNumberForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Account Number");
    }
	
	@Test(priority=5,description="TS042_Sorting on Claim #")
	public void testSortByClaimHashForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Claim #");
    }
	
	@Test(priority=5,description="TS043_Sorting on Claim Amount")
	public void testSortByClaimAmountForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Claim Amount");	        
    }
	
	@Test(priority=5,description="TS044_Sorting on Market Type")
	public void testSortByMarketTypeForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Market Type");
    }
	
	@Test(priority=5,description="TS045_Sorting on Archive")
	public void testSortByArchiveForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Archive");
    }
	
	@Test(priority=5,description="TS047_Sorting on Payment Number")
	public void testSortByPaymentNumberForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting(criteriaType,"Payment Number");
    }
	
	@Test(priority=5,description="TS049_Pagination of Search Results")
	public void testPaginationOfSearchResultsForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String userType="PROV";
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyPagination();
   }
}

