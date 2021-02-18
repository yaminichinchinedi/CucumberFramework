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
import main.java.pageObjects.ViewPayments;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;


public class TestPayerSearchRemitance extends TestBase {
	 
	String userType="PAY";
	
	@Test(priority=1,description="TS002_Search by Date of Payment")
	public void testEprabyDOP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String accessType="Admin";
		String criteriaType="byDOP";	
		 
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=2,description="TS003_Search by Date of service")
	public void testEprabyDOS() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String accessType="Admin";
		String criteriaType="byDOS";	
		 
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=3,description="TS004_Search by Electronic Payment Number only")
	public void testEpraByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String accessType="Admin";
		String criteriaType="byElectronicPaymentNo";	
		testConfig.putRunTimeProperty("criteriaType",criteriaType);	
		 
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	 }

	@Test(priority=4,description="TS005_Search by Check Number only")
	public void testEprabyCheckNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		 
		String accessType="Admin";
		String criteriaType="byCheckNo";
		
		 
		testConfig.putRunTimeProperty("criteriaType",criteriaType);						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	 }
	
	@Test(priority=5,description="TS006_Search by DOP and Acnt Number")
	public void testEprabyDOPAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOPAndAccountNo";	
		 
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=6,description="TS007_Search by DOP and Subscriber ID")
	public void testEprabyDOPAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOP&SubscriberID";			
		 
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=7,description="TS008_Search by DOP and NPI")
	public void testEprabyDOPAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOPAndNpi";		
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=8,description="TS009_Search by DOP and Claim Number")
	public void testEprabyDOPAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOPAndClaimNo";
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=9,description="TS010_Search by DOP and Patient Name")
	public void testEprabyDOPAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
			
		String criteriaType="byDOPAndPatientNm";
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=10,description="TS011_Search by DOP and Zero Payment Claims")
	public void testEprabyDOPAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
			
		String criteriaType="byDOPAndZeroPaymentClaims";		
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=11,description="TS012_Search by DOP and Market Type")
	public void testEprabyDOPAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOPAndMarketType";			
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=12,description="TS013_Search by DOS and Acnt Number")
	public void testEprabyDOSAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOSAndAcntNo";				
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=13,description="TS014_Search by DOS and Subscriber ID")
	public void testEprabyDOSAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOSAndSubscriberId";		
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=14,description="TS015_Search by DOS and NPI")
	public void testEprabyDOSAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOSAndNpi";			
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	

	@Test(priority=15,description="TS016_Search by DOS and Claim Number")
	public void testEprabyDOSAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOSAndClmNo";	
		 
								
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=16,description="TS017_Search by DOS and Patient Name")
	public void testEprabyDOSAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOSAndPtntNm";	
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=17,description="TS018_Search by DOS and Zero Payment Claims")
	public void testEprabyDOSAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
			
		String criteriaType="byDOSAndZeroPmntClms";	
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=18,description="TS019_Search by DOS and Market Type")
	public void testEprabyDOSAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Admin";
		String criteriaType="byDOSAndMarketType";			
		 
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=19,description="TS020_Search by DOS and Rendering Provider")
	public void testEprabyDOPAndRenderingProvider() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String accessType="Admin";
			
		String criteriaType="byDOPAndRenderingProvider";
		testConfig.putRunTimeProperty("835ID", "UMR01");
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);		
	}
	
   @Test(priority=20,description="TS023_Error Messages")
   public void testByErrorMsgs() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	    String accessType="Admin";
	    String criteriaType="byDOP"; 
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).verifyErrorMsgs();
   }
   
   /*@Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
   public void testSearchByPatientNameTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	    String accessType="Admin";
		String criteriaType="byDOPAndPatientNm"; 	
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);
   }
   
   @Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
   public void testSearchBySubscriberIDTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	    String accessType="Admin";
	    String criteriaType="byDOPAndSubscriberId"; 	
	   
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);
   }
   */
   @Test(priority=21,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
		String criteriaType="byElectronicPaymenForACH";
	    String accessType="Admin";
	     
		 		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifyPaymentStatus("ACH");
   }
   
   @Test(priority=22,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {

	   String criteriaType="byElectronicPaymentForVCP";

	    String accessType="Admin";
	     
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifyPaymentStatus("VCP");
		
   }
   
   @Test(priority=23,description="TS027_Returned Reason")
   public void testByReturnedReason() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	    String accessType="Admin";
	    String criteriaType="byDOP";
	     
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifyReturnedReasonDisplayed(criteriaType);
   }
   
   @Test(priority=24,description="TS028/029_Large Non Large Tin")
   public void testSearchRemittanceLargeNonLargeTin() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	    String accessType="Admin";
	    String criteriaType="byDOP";
	     
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).verifyLargeNonLargeTin();
   }
   
   @Test(priority=25,description="TS032_Search by Check Number only")
	public void testValidationOfCheckNoOfUnconsolidatedPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		 
		String accessType="Admin";		
		String criteriaType="byCheckNo";		
		    
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);	
	 }
   
   /*@Test(priority=5,description="TS033_Search by Check Number from Reoriginated Nacha table")
	public void testValidationOfCheckNoOfReOriginNacha() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		 
		String accessType="Admin";	
		String requestType="byCheckNo";
		String criteriaType="byCheckNoOfReoriginNacha";	
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(requestType);		
	 }
   
   @Test(priority=5,description="TS034_Search by Check Number from Consolidated Payment Detail table")
	public void testValidationOfCheckNoOfConslPayDtl() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		 
		String accessType="Admin";		
		String requestType="byCheckNo";
		String criteriaType="byCheckNoOfConslPayDtl";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(requestType);		
	 }*/
   
   @Test(priority=26,description="TS035_Search by Payment Number Of Consolidated Payment")
	public void testValidationOfPaymentNoOfConsolidatedPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		 
		String accessType="Admin";		
		String criteriaType="byElectronicPaymentNo";					
		    
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);		
	 }
   
   
	@Test(priority=27,description="TS036_Sorting on Payer Name")
	public void testSortByPayerName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		 
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Payer");
    }
	
	@Test(priority=28,description="TS037_Sorting on Claim Date")
	public void testSortByClaimDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Claim Date");
    }
	
	@Test(priority=29,description="TS038_Sorting on NPI")
	public void testSortByNPI() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("NPI");
    }
	
	@Test(priority=30,description="TS039_Sorting on Patient Name")
	public void testSortByPatientName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Patient Name");
    }
	
	@Test(priority=31,description="TS040_Sorting on Subscriber Id")
	public void testSortBySubscriberId() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("SuSUBPAYERcriber ID");
    }
	
	@Test(priority=32,description="TS041_Sorting on Account Number")
	public void testSortByAccountNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Account Number");
    }
	
	@Test(priority=33,description="TS042_Sorting on Claim #")
	public void testSortByClaimHash() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Claim #");
    }
	
	@Test(priority=34,description="TS043_Sorting on Claim Amount")
	public void testSortByClaimAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Claim Amount");	        
    }
	
	@Test(priority=35,description="TS044_Sorting on Market Type")
	public void testSortByMarketType() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Market Type");
    }
	
	/*@Test(priority=5,description="TS045_Sorting on Archive")
	public void testSortByArchive() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String accessType="Admin";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Archive");
    }*/
	
	@Test(priority=36,description="TS046_Sorting on Payment Date")
	public void testSortByPaymentDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String accessType="Admin";
		String criteriaType="byDOSAndNpi";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Payment Date");
    }
	
	@Test(priority=37,description="TS047_Sorting on Payment Number")
	public void testSortByPaymentNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String accessType="Admin";
		String criteriaType="byDOP";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Payment Number");
    }
	
	@Test(priority=38,description="TS048_Sorting on Payment Amount")
	public void testSortByPaymentAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String accessType="Admin";
		String criteriaType="byDOSAndNpi";
		    
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Amount");
    }
	
	@Test(priority=39,description="TS049_Pagination of Search Results")
	public void testPaginationOfSearchResults() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String accessType="Admin";
		String criteriaType="byDOP";
		 
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifyPagination();
   }
	
	
	
	//Test cases for PAYER GENERAL
	
	
	/*@Test(priority=5,description="TS002_Search by Date of Payment")
	public void testEpraByDateOfPaymentForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String accessType="Gen";
		String criteriaType="byDOP";	
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS003_Search by Date fo Service")
	public void testEprabyDOSForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String accessType="Gen";
		String criteriaType="byDOS";	
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;				
	}
	
	@Test(priority=5,description="TS004_Search by Electronic Payment Number Only")
	public void testEpraByPaymentNumberForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		 
		String accessType="Gen";
			
		String criteriaType="byElectronicPaymentNumber";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	 }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEprabyCheckNoForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		 
		String accessType="Gen";
			
		String criteriaType="byCheckNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	 }
	
	@Test(priority=5,description="TS006_Search by DOP and Acnt Number")
	public void testEpraByDateOfPaymentAndAcntNoForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOPAndAcntNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS007_Search by DOP and Subscriber ID")
	public void testEpraByDateOfPaymentAndSubscriberIdForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOPAndSubscriberId";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS008_Search by DOP and NPI")
	public void testEpraByDateOfPaymentAndNpiForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOPAndNpi";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS009_Search by DOP and Claim Number")
	public void testEpraByDateOfPaymentAndClmNoForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOPAndClmNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS010_Search by DOP and Patient Name ")
	public void testEpraByDateOfPaymentAndPtntNmForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOPAndPtntNm";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS011_Search by DOP and Zero Payment claims")
	public void testEpraByDateOfPaymentAndZeroPmntClmsForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOPAndZeroPmntClms";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS012_Search by DOP and Market Type")
	public void testEpraByDateOfPaymentAndMarketTypeForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOPAndMarketType";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS013_Search by DOS and Acnt Number")
	public void testEprabyDOSAndAcntNoForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOSAndAcntNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS014_Search by DOS and Subscriber ID")
	public void testEprabyDOSAndSubscriberIdForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOSAndSubscriberId";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS015_Search by DOS and NPI")
	public void testEprabyDOSAndNpiForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOSAndNpi";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS016_Search by DOS and Claim Number")
	public void testEprabyDOSAndClmNoForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOSAndClmNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS017_Search by DOS and Patient Name")
	public void testEprabyDOSAndPtntNmForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOSAndPtntNm";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS018_Search by DOS and Zero Payment Claims")
	public void testEprabyDOSAndZeroPmntClmsForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOSAndZeroPmntClms";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS019_Search by DOS and Market Type")
	public void testEpraByDOSAndMarketTypeForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";
			
		String criteriaType="byDOSAndMarketType";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);;		
	}
	
	@Test(priority=5,description="TS020_Search by DOS and Rendering Provider")
	public void testEprabyDOPAndRenderingProviderForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String accessType="Gen";
			
		String criteriaType="byDOPAndRenderingProvider";
		String tinType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(tinType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);		
	}
	
   @Test(priority=5,description="TS023_Error Messages")
   public void testByErrorMsgsForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	     
		String accessType="Gen";
		String criteriaType="byDOP"; 
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).verifyErrorMsgs();
   }
   
   @Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
   public void testSearchByPatientNameTricarePayerForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	     
		String accessType="Gen";
		String criteriaType="byDOPAndPtntNm"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
   public void testSearchBySubscriberIDTricarePayerForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	     
		String accessType="Gen";
		String criteriaType="byDOPAndSubscriberId"; 	
		String requestType="byDOP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(requestType);
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForACHForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	     
		String accessType="Gen";
		String criteriaType="byElectronicPaymenForACH";
		String tinType="ReoriginatedACH"; 		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(tinType,userType).doSearch(criteriaType).verifyPaymentStatus("ACH");
   }
   
   @Test(priority=5,description="TS026_Type And Payment Status")
   public void testTypeAndPaymentStatusByElectronicPaymentForVCPForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
   {
	     
		String accessType="Gen";
		String criteriaType="byElectronicPaymenForVCP";
		String tinType="byElectronicPaymentForVCP";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(tinType,userType).doSearch(criteriaType).verifyPaymentStatus("VCP");
		
   }
	
	@Test(priority=5,description="TS027_Returned Reason")
	public void testByReturnedReasonForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		 
		String accessType="Gen";
		
		String criteriaType="byDateOfPayment";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().doSearch(criteriaType).verifyReturnedReasonDisplayed(criteriaType);
	}
	
	@Test(priority=5,description="TS028/029_Large Non Large Tin")
	public void testSearchRemittanceLargeNonLargeTinForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	    String accessType="Gen";
	    String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).verifyLargeNonLargeTin();
	}
	   
	@Test(priority=5,description="TS032_Search by Check Number only")
	public void testValidationOfCheckNoOfUnconsolidatedPaymentForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";		
		String criteriaType="byCheckNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);	
	}
   
	@Test(priority=5,description="TS033_Search by Check Number from Reoriginated Nacha table")
	public void testValidationOfCheckNoOfReOriginNachaForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";	
		String tinType="byCheckNo";
		String criteriaType="byCheckNoOfReoriginNacha";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(tinType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);		
	}
   
	@Test(priority=5,description="TS034_Search by Check Number from Consolidated Payment Detail table")
	public void testValidationOfCheckNoOfConslPayDtlForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";		
		String tinType="byCheckNo";
		String criteriaType="byCheckNoOfConslPayDtl";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(tinType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);		
	}
   
	@Test(priority=5,description="TS035_Search by Payment Number Of Consolidated Payment")
	public void testValidationOfPaymentNoOfConsolidatedPaymentForSUBPAYERGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		 
		String accessType="Gen";		
		String criteriaType="byElectronicPaymentNo";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySearchResults(criteriaType);		
	}
	   
	@Test(priority=5,description="TS036_Sorting on Payer Name")
	public void testSortByPayerNameForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Payer");
    }
	
	@Test(priority=5,description="TS037_Sorting on Claim Date")
	public void testSortByClaimDateForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Claim Date");
    }
	
	@Test(priority=5,description="TS038_Sorting on NPI")
	public void testSortByNPIForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("NPI");
    }
	
	@Test(priority=5,description="TS039_Sorting on Patient Name")
	public void testSortByPatientNameForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Patient Name");
    }
	
	@Test(priority=5,description="TS040_Sorting on Subscriber Id")
	public void testSortBySubscriberIdForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Subscriber ID");
    }
	
	@Test(priority=5,description="TS041_Sorting on Account Number")
	public void testSortByAccountNumberForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Account Number");
    }
	
	@Test(priority=5,description="TS042_Sorting on Claim #")
	public void testSortByClaimHashForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Claim #");
    }
	
	@Test(priority=5,description="TS043_Sorting on Claim Amount")
	public void testSortByClaimAmountForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Claim Amount");	        
    }
	
	@Test(priority=5,description="TS044_Sorting on Market Type")
	public void testSortByMarketTypeForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Market Type");
    }
	
	@Test(priority=5,description="TS045_Sorting on Archive")
	public void testSortByArchiveForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Archive");
    }
	
	@Test(priority=5,description="TS046_Sorting on Payment Date")
	public void testSortByPaymentDateForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String accessType="Gen";
		String criteriaType="byDOSAndNpi";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Payment Date");
    }
	
	@Test(priority=5,description="TS047_Sorting on Payment Number")
	public void testSortByPaymentNumberForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Payment Number");
    }
	
	@Test(priority=5,description="TS048_Sorting on Payment Amount")
	public void testSortByPaymentAmountForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String accessType="Gen";
		String criteriaType="byDOSAndNpi";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifySorting("Amount");
    }
	
	@Test(priority=5,description="TS049_Pagination of Search Results")
	public void testPaginationOfSearchResultsForSUBPAYERGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		 
		String accessType="Gen";
		String criteriaType="byDOP";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.clickSearchRemittanceTab().selectTin(criteriaType,userType).doSearch(criteriaType).verifyPagination();
	    
   }*/
}