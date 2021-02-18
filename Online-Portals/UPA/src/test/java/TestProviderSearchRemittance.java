//package test.java;
//import java.awt.AWTException;
//import java.io.IOException;
//import java.text.ParseException;
//
//import javax.xml.bind.JAXBException;
//import javax.xml.parsers.ParserConfigurationException;
//
//import main.java.nativeFunctions.TestBase;
//import main.java.pageObjects.CSRHomePage;
//import main.java.pageObjects.HomePage;
//import main.java.pageObjects.LoginCSR;
//import main.java.pageObjects.OptumIdLoginPage;
//import main.java.pageObjects.SearchRemittance;
//import main.java.pageObjects.SearchRemittanceSearchCriteria;
//import main.java.pageObjects.SearchTinPageSearchRemittance;
//import main.java.pageObjects.UPARegistrationPage;
//import main.java.pageObjects.paymentSummary;
//
//import org.testng.annotations.Test;
//import org.xml.sax.SAXException;
//
//public class TestProviderSearchRemittance extends TestBase{
// 
//	String userType="PROV";
//	String accessType="Admin";
//	
//	
//    
//	@TestDetails(author="Priyanka")
//	@Test(priority=1,description="TS008_Search by DOP and NPI",groups="Provider Search Remittance")
//	public void testEprabyDOPAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOPAndNpi";			
//		 
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=2,description="TS008_Search by DOS and NPI",groups="Provider Search Remittance")
//	public void testEprabyDOSAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOSAndNpi";		
//		testConfig.putRunTimeProperty("criteriaType", criteriaType);
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=3,description="TS002_Search by Date of Payment",groups="Provider Search Remittance")
//	public void testEprabyDOP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOP";
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType).selectTin(criteriaType);
//		home.clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=4,description="TS003_Search by Date of Service",groups="Provider Search Remittance")
//	public void testEprabyDOS() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOS";
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=5,description="TS004_Search by Electronic Payment Number only",groups="Provider Search Remittance")
//	public void testEpraByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	 {
//		String accessType="Admin";
//		String criteriaType="byElectronicPaymentNo";	
//		testConfig.putRunTimeProperty("criteriaType",criteriaType);
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	 }
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=6,description="TS005_Search by Check Number only",groups="Provider Search Remittance")
//	public void testEpraByCheckNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	 {
//		String accessType="Admin";
//		String criteriaType="byCheckNo";	
//		testConfig.putRunTimeProperty("criteriaType",criteriaType);
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);;		
//	 }
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=7,description="TS006_Search by DOP and Acnt No",groups="Provider Search Remittance")
//	public void testEprabyDOPAndAccountNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOPAndAccountNo";
//		  
//
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=8,description="TS007_Search by DOP and Sybscriber ID",groups="Provider Search Remittance")
//	public void testEprabyDOPAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOP&SubscriberID";
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=9,description="TS009_Search by DOP and Claim Number",groups="Provider Search Remittance")
//	public void testEprabyDOPAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOPAndClaimNo";		
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@TestDetails(author="Priyanka")
//	@Test(priority=10,description="TS010_Search by DOP abd Patient Name",groups="Provider Search Remittance")
//	public void testEprabyDOPAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOPAndPatientNm";	
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//	
//	
//	//query taking lot of time check
//	@TestDetails(author="Priyanka")
//	@Test(priority=11,description="TS011_Search by DOP and Zero Payment Claims",groups="Provider Search Remittance")
//	public void testEprabyDOPAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOPAndZeroPaymentClaims";
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	
//	@Test(priority=12,description="TS012_Search by DOP and Market Type",groups="Provider Search Remittance")
//	public void testEprabyDOPAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOPAndMarketType";
//		
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=13,description="TS013_Search by DOS and Acnt No",groups="Provider Search Remittance")
//	public void testEprabyDOSAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOSAndAcntNo";
//		testConfig.putRunTimeProperty("criteriaType", criteriaType);
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=14,description="TS014_Search by DOS and Sybscriber ID",groups="Provider Search Remittance")
//	public void testEprabyDOSAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOSAndSubscriberId";
//		
//		  
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//	
//	
//	
//	@Test(priority=15,description="TS016_Search by DOS and Claim Number",groups="Provider Search Remittance")
//	public void testEprabyDOSAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOSAndClmNo";
//		  
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//	
//	
//	@Test(priority=16,description="TS017_Search by DOP abd Patient Name",groups="Provider Search Remittance")
//	public void testEprabyDOSAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOSAndPtntNm";	
//		  
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	
//	@Test(priority=17,description="TS018_Search by DOS and Zero Payment Claims",groups="Provider Search Remittance")
//	public void testEprabyDOSAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOSAndZeroPmntClms";		
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//		
//	@Test(priority=18,description="TS019_Search by DOS and Market Type",groups="Provider Search Remittance")
//	public void testEprabyDOSAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//			
//		String criteriaType="byDOSAndMarketType";
//		  
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);
//	}
//	
//	
//
//	
//   @Test(priority=19,description="TS023_Error Messages",groups="Provider Search Remittance")
//   public void testByErrorMsgs() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//   {
//	   	String accessType="Admin";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().verifyErrorMsgs();
//   }
//   
//   
//   @Test(priority=20,description="TS026_Type And Payment Status",groups="Provider Search Remittance")
//   public void testTypeAndPaymentStatusByElectronicPaymentForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//   {
//	    String accessType="Admin";
//		String criteriaType="byElectronicPaymenForACH"; 		
//		  
//		
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("ACH");
//   }
//   
//   @Test(priority=21,description="TS026_Type And Payment Status",groups="Provider Search Remittance")
//   public void testTypeAndPaymentStatusByElectronicPaymentForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//   {
//	    String accessType="Admin";
//		String criteriaType="byElectronicPaymentForVCP";
//		  
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType).selectTin(criteriaType);
//	    home.clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("VCP");
//		
//   }
//   
//   @Test(priority=22,description="TS027_Returned Reason",groups="Provider Search Remittance")
//   public void testByReturnedReason() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//   {
//	    String accessType="Admin";
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifyReturnedReasonDisplayed(criteriaType);
//   }
//   
//   	@Test(priority=23,description="TS028/029_Large Non Large Tin",groups="Provider Search Remittance")
//	public void testSearchRemittanceLargeNonLargeTin() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//	    String accessType="Admin";
//	    String criteriaType="byDOP";
//	     
//       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().verifyLargeNonLargeTin();
//	}
//	   
//	@Test(priority=24,description="TS032_Search by Check Number only",groups="Provider Search Remittance")
//	public void testValidationOfCheckNoOfUnconsolidatedPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		 
//		String accessType="Admin";		
//		String criteriaType="byCheckNo";		
//		  
//		testConfig.putRunTimeProperty("criteriaType", criteriaType);
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
////  
////	//As per discussion with PRashant, commenting because we are not able to get data from fisl though it is displayed in ui, need to ask dev eam for the tag in request
////	 /*@Test(priority=5,description="TS033_Search by Check Number from Reoriginated Nacha table")
////	public void testValidationOfCheckNoOfReOriginNacha() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
////	{
////		 
////		String accessType="Admin";	
////		String requestType="byCheckNo";
////		String criteriaType="byCheckNoOfReoriginNacha";		
////		
////		testConfig.putRunTimeProperty("criteriaType", requestType);
////		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
////	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
////		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
////		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);		
////	}
////	
//// 
////	@Test(priority=5,description="TS034_Search by Check Number from Consolidated Payment Detail table")
////	public void testValidationOfCheckNoOfConslPayDtl() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
////	{
////		 
////		String accessType="Admin";		
////		String requestType="byCheckNo";
////		String criteriaType="byCheckNoOfConslPayDtl";			
////		
////		testConfig.putRunTimeProperty("criteriaType", requestType);
////		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
////	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
////		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
////		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);		
////	}*/
////  
//	@Test(priority=25,description="TS035_Search by Payment Number Of Consolidated Payment",groups="Provider Search Remittance")
//	public void testValidationOfPaymentNoOfConsolidatedPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		 
//		String accessType="Admin";		
//		String criteriaType="byElectronicPaymentNo";	
//		  
//		
//		testConfig.putRunTimeProperty("criteriaType",criteriaType);
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=26,description="TS036_Sorting on Payer Name",groups="Provider Search Remittance")
//	public void testSortByPayerName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payer");
//    }
//	
//	@Test(priority=27,description="TS037_Sorting on Claim Date",groups="Provider Search Remittance")
//	public void testSortByClaimDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Date");
//    }
//	
//	@Test(priority=28,description="TS038_Sorting on NPI",groups="Provider Search Remittance")
//	public void testSortByNPI() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("NPI");
//    }
//	
//	
//	@Test(priority=29,description="TS039_Sorting on Patient Name",groups="Provider Search Remittance")
//	public void testSortByPatientName() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Patient Name");
//    }
//	
//	@Test(priority=30,description="TS040_Sorting on Subscriber Id",groups="Provider Search Remittance")
//	public void testSortBySubscriberId() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Subscriber ID");
//    }
//	
//	
//	@Test(priority=31,description="TS041_Sorting on Account Number",groups="Provider Search Remittance")
//	public void testSortByAccountNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Account Number");
//    }
//	
//	
//	@Test(priority=32,description="TS042_Sorting on Claim #",groups="Provider Search Remittance")
//	public void testSortByClaimHash() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim #");
//    }
//	
//	@Test(priority=33,description="TS043_Sorting on Claim Amount",groups="Provider Search Remittance")
//	public void testSortByClaimAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Amount");	        
//    }
//	
//	@Test(priority=34,description="TS044_Sorting on Market Type",groups="Provider Search Remittance")
//	public void testSortByMarketType() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Market Type");
//    }
//	
//	
//	/*@Test(priority=5,description="TS045_Sorting on Archive")
//	public void testSortByArchive() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Archive");
//    }*/
//	
//	@Test(priority=35,description="TS046_Sorting on Payment Date")
//	public void testSortByPaymentDate() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String criteriaType="byCheckNo";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payment Date");
//    }
//	
//	@Test(priority=36,description="TS047_Sorting on Payment Number",groups="Provider Search Remittance")
//	public void testSortByPaymentNumber() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payment Number");
//    }
//	
//	@Test(priority=37,description="TS048_Sorting on Payment Amount",groups="Provider Search Remittance")
//	public void testSortByPaymentAmount() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Amount");
//    }
//	
//	@Test(priority=38,description="TS049_Pagination of Search Results",groups="Provider Search Remittance")
//	public void testPaginationOfSearchResults() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String criteriaType="byDOP";
//		  
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifyPagination();
//   }
//	
//	
//	@Test(priority=39,description="TS020_Search by DOP and Rendering Provider",groups="Provider Search Remittance")
//	public void testEprabyDOPAndRenderingProvider() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Admin";
//		String criteriaType="byDOPAndRenderingProvider";
//		testConfig.putRunTimeProperty("criteriaType", criteriaType);
//		testConfig.putRunTimeProperty("835ID", "UMR01");
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	
//	
//	
//	//Test cases for PROVIDER GENERAL
//	
//	
//	/*@Test(priority=5,description="TS002_Search by Date of Payment")
//	public void testEprabyDOPForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOP";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//	
//	@Test(priority=5,description="TS003_Search by Date fo Service")
//	public void testEprabyDOSForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOS";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//	
//	@Test(priority=5,description="TS004_Search by Electronic Payment Number Only")
//	public void testEpraByPaymentNumberForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	 {
//		String accessType="Gen";
//			
//		String criteriaType="byElectronicPaymentNumber";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	 }
//	
//	@Test(priority=5,description="TS005_Search by Check Number only")
//	public void testEpraByCheckNumberForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	 {
//		String accessType="Gen";
//			
//		String criteriaType="byCheckNumber";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	 }
//	
//	@Test(priority=5,description="TS006_Search by DOP and Acnt Number")
//	public void testEprabyDOPAndAcntNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndAcntNo";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS007_Search by DOP and Subscriber ID")
//	public void testEprabyDOPAndSubscriberIdForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndSubscriberId";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS008_Search by DOP and NPI")
//	public void testEprabyDOPAndNpiForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndNpi";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS009_Search by DOP and Claim Number")
//	public void testEprabyDOPAndClmNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndClmNo";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS010_Search by DOP and Patient Name ")
//	public void testEprabyDOPAndPtntNmForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndPtntNm";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS011_Search by DOP and Zero Payment claims")
//	public void testEprabyDOPAndZeroPmntClmsForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndZeroPmntClms";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS012_Search by DOP and Market Type")
//	public void testEprabyDOPAndMarketTypeForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndMarketType";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS013_Search by DOS and Acnt Number")
//	public void testEprabyDOSAndAcntNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOSAndAcntNo";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS014_Search by DOS and Subscriber ID")
//	public void testEprabyDOSAndSubscriberIdForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOSAndSubscriberId";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS015_Search by DOS and NPI")
//	public void testEprabyDOSAndNpiForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOSAndNpi";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//	
//	@Test(priority=5,description="TS016_Search by DOS and Claim Number")
//	public void testEprabyDOSAndClmNoForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOSAndClmNo";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS017_Search by DOS and Patient Name ")
//	public void testEprabyDOSAndPtntNmForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOSAndPtntNm";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS018_Search by DOS and Zero Payment claims")
//	public void testEprabyDOSAndZeroPmntClmsForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOSAndZeroPmntClms";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS019_Search by DOS and Market Type")
//	public void testEprabyDOSAndMarketTypeForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOSAndMarketType";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//	
//	@Test(priority=5,description="TS020_Search by DOS and Rendering Provider")
//	public void testEprabyDOPAndRenderingProviderForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		String accessType="Gen";
//			
//		String criteriaType="byDOPAndRenderingProvider";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//   @Test(priority=5,description="TS023_Error Messages")
//   public void testByErrorMsgsForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//   {
//		String accessType="Gen";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().verifyErrorMsgs();
//   }
//   
//   @Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
//   public void testSearchByPatientNameTricarePayerForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//   {
//		String accessType="Gen";
//		String criteriaType="byDOPAndPtntNm"; 	
//		String requestType="byDOP";
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
//   }
//   
//   @Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
//   public void testSearchBySubscriberIDTricarePayerForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//   {
//		String accessType="Gen";
//		String criteriaType="byDOPAndSubscriberId"; 	
//		String requestType="byDOP";
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);
//   }
//   
//   @Test(priority=5,description="TS026_Type And Payment Status")
//   public void testTypeAndPaymentStatusByElectronicPaymentForACHForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//   {
//		String accessType="Gen";
//		String tinType="ReoriginatedACH"; 	
//		String criteriaType="byElectronicPaymenForACH";
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("ACH");
//   }
//   
//   @Test(priority=5,description="TS026_Type And Payment Status")
//   public void testTypeAndPaymentStatusByElectronicPaymentForVCPForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//   {
//		String accessType="Gen";
//		String criteriaType="byElectronicPaymenForVCP";
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType).selectTin(criteriaType);
//	    home.clickSearchRemittanceTab().doSearch(criteriaType).verifyPaymentStatus("VCP");
//		
//   }
//	
//	@Test(priority=5,description="TS027_Returned Reason")
//   public void testByReturnedReasonForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//   {
//		String accessType="Gen";
//		
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.clickSearchRemittanceTab().doSearch(criteriaType).verifyReturnedReasonDisplayed(criteriaType);
//   }
//	
//	@Test(priority=5,description="TS028/029_Large Non Large Tin")
//	public void testSearchRemittanceLargeNonLargeTinForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//	    String accessType="Gen";
//	    String criteriaType="byDOP";
//       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().verifyLargeNonLargeTin();
//	}
//	   
//	@Test(priority=5,description="TS032_Search by Check Number only")
//	public void testValidationOfCheckNoOfUnconsolidatedPaymentForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		 
//		String accessType="Gen";		
//		String criteriaType="byCheckNo";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);	
//	}
//  
//	@Test(priority=5,description="TS033_Search by Check Number from Reoriginated Nacha table")
//	public void testValidationOfCheckNoOfReOriginNachaForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		 
//		String accessType="Gen";	
//		String requestType="byCheckNo";
//		String criteriaType="byCheckNoOfReoriginNacha";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);		
//	}
//  
//	@Test(priority=5,description="TS034_Search by Check Number from Consolidated Payment Detail table")
//	public void testValidationOfCheckNoOfConslPayDtlForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		 
//		String accessType="Gen";		
//		String requestType="byCheckNo";
//		String criteriaType="byCheckNoOfConslPayDtl";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(requestType);		
//	}
//  
//	@Test(priority=5,description="TS035_Search by Payment Number Of Consolidated Payment")
//	public void testValidationOfPaymentNoOfConsolidatedPaymentForProvGen() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
//	{
//		 
//		String accessType="Gen";		
//		String criteriaType="byElectronicPaymentNo";						
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySearchResults(criteriaType);		
//	}
//	
//	@Test(priority=5,description="TS036_Sorting on Payer Name")
//	public void testSortByPayerNameForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payer");
//    }
//	
//	@Test(priority=5,description="TS037_Sorting on Claim Date")
//	public void testSortByClaimDateForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Date");
//    }
//	
//	@Test(priority=5,description="TS038_Sorting on NPI")
//	public void testSortByNPIForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("NPI");
//    }
//	
//	@Test(priority=5,description="TS039_Sorting on Patient Name")
//	public void testSortByPatientNameForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Patient Name");
//    }
//	
//	@Test(priority=5,description="TS040_Sorting on Subscriber Id")
//	public void testSortBySubscriberIdForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Subscriber ID");
//    }
//	
//	@Test(priority=5,description="TS041_Sorting on Account Number")
//	public void testSortByAccountNumberForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Account Number");
//    }
//	
//	@Test(priority=5,description="TS042_Sorting on Claim #")
//	public void testSortByClaimHashForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim #");
//    }
//	
//	@Test(priority=5,description="TS043_Sorting on Claim Amount")
//	public void testSortByClaimAmountForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Claim Amount");	        
//    }
//	
//	@Test(priority=5,description="TS044_Sorting on Market Type")
//	public void testSortByMarketTypeForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//    {
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Market Type");
//    }
//	
//	@Test(priority=5,description="TS045_Sorting on Archive")
//	public void testSortByArchiveForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Archive");
//    }
//	
//	@Test(priority=5,description="TS046_Sorting on Payment Date")
//	public void testSortByPaymentDateForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String accessType="Gen";
//		String criteriaType="byDOSAndNpi";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payment Date");
//    }
//	
//	@Test(priority=5,description="TS047_Sorting on Payment Number")
//	public void testSortByPaymentNumberForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(criteriaType).clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Payment Number");
//    }
//	
//	@Test(priority=5,description="TS048_Sorting on Payment Amount")
//	public void testSortByPaymentAmountForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String accessType="Gen";
//		String criteriaType="byDOSAndNpi";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifySorting("Amount");
//    }
//	
//	@Test(priority=5,description="TS049_Pagination of Search Results")
//	public void testPaginationOfSearchResultsForProvGen() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	{
//		String accessType="Gen";
//		String criteriaType="byDOP";
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).verifyPagination();
//   }*/
//}
//
