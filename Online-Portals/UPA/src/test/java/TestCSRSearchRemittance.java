package test.java;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchRemittanceSearchCriteria;
import main.java.pageObjects.SearchTinPageSearchRemittance;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.paymentSummary;

public class TestCSRSearchRemittance extends TestBase {
	String loginUserType="Super";
	
	@Test(priority=5,description="TS004_Search by Electronic Payment Number only")
	public void testEpraByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byElectronicPaymentNo";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);;		
      }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByCheckNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byCheckNumber";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
      }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfService() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfService";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";	
		String filterPayments="Show All";
		String criteriaType="byDateOfPayment";
		String requestType="byDateOfService";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		SearchRemittance srchRemit = srchCriteriaPage.doSearch(criteriaType);
		srchRemit.verifySearchResults(requestType);
     }
	
	//Need to optimize query used to getch a/c no and setl_dt for this test case
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfPaymentAndAcntNo";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfPaymentAndSubscriberId";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfPaymentAndNpi";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndClmNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfPaymentAndClmNo";
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndPtntNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfPaymentAndPtntNm";
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndZeroPmntClms() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfPaymentAndZeroPmntClms";
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDateOfPaymentAndMarketType";
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType);		
     }
	
	//amit
		@Test(priority=5,description="TS023_Error Messages")
		public void testErrorMsgs() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 	
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);;		
			srchTinPage.clickSearchBtn().verifyErrorMsgs();
	     }
		
		@Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
		public void testSearchByPatientNameTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPaymentAndPtntNm"; 	
			String requestType="byDateOfPayment";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);
	     }
		
		@Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
		public void testSearchBySubscriberIDTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPaymentAndSubscriberId"; 	
			String requestType="byDateOfPayment";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);;		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);
	     }
		/*@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatus() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment";
			String tinType="byDateOfPayment"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("ACH");
	     }*/
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String tinType="ReoriginatedACH"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","ACH");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByElectronicPaymentToVerifyPaymentStatusforACH(tinType).verifyPaymentStatus("ACH");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status") //no data coming
		public void testTypeAndPaymentStatusByElectronicPaymentForCHK() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String tinType="ReoriginatedACH"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","CHK");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByElectronicPaymentToVerifyPaymentStatusforACH(tinType).verifyPaymentStatus("CHK");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymentforStatus";
			String tinType="byElectronicPaymentforStatus";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","VCP");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByElectronicPaymentToVerifyPaymentStatusforVCP(criteriaType).verifyPaymentStatus("VCP");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForNON() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymentforStatus";
			String tinType="byElectronicPaymentforStatus";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","NON");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByElectronicPaymentToVerifyPaymentStatusforVCP(criteriaType).verifyPaymentStatus("NON");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForDD() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="DD";
			String tinType="DD";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","DD");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByElectronicPaymentToVerifyPaymentStatusforDD(criteriaType).verifyPaymentStatus("DD");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment";
			String tinType="ReoriginatedACH";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","ACH");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("ACH");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment";
			String tinType="byElectronicPaymentforStatus";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","VCP");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.getPaymentStatusFromDB(tinType).doSearch(criteriaType).verifyPaymentStatus("VCP");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusForNON() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment";
			String tinType="byElectronicPaymentforStatus";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			testConfig.putRunTimeProperty("type","NON");
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.getPaymentStatusFromDB(tinType).doSearch(criteriaType).verifyPaymentStatus("NON");
	     }
		
		
		
		@Test(priority=5,description="TS027_Returned Reason")
		public void testReturnedReasonByElectronicNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPmt";
			String tinType="byElectronicPmt"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByElectronicPaymentToVerifyReturnedReason(criteriaType).verifyreturnedReasonDisplayed(criteriaType,"CSR");
	     }
		
		@Test(priority=5,description="TS027_Returned Reason")
		public void testReturnedReasonByCheckNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byCheckPmt";
			String tinType="byCheckPmt"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByCheckNumberToVerifyReturnedReason(criteriaType).verifyreturnedReasonDisplayed(criteriaType,"CSR");
	     }

		@Test(priority=5,description="TS030_Print Search Result First Page")
		public void testByPrintSearchResultFirstPage() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifyPrintFirstPage();
	     }
		
		@Test(priority=5,description="TS036_Sorting on Payer Name")
		public void testSortByPayerName() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Payer");;
	     }
		
		@Test(priority=5,description="TS037_Sorting on Claim Date")
		public void testSortByClaimDate() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Claim Date");
	     }
		
		@Test(priority=5,description="TS038_Sorting on NPI")
		public void testSortByNPI() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("NPI");
	     }
		
		@Test(priority=5,description="TS039_Sorting on Patient Name")
		public void testSortByPatientName() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Patient Name");	
	     }
		
		@Test(priority=5,description="TS040_Sorting on Subscriber Id")
		public void testSortBySubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		{
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Subscriber ID");
	     }
		
		@Test(priority=5,description="TS041_Sorting on Account Number")
		public void testSortByAccountNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Account Number");	
	     }
		
		@Test(priority=5,description="TS042_Sorting on Claim #")
		public void testSortByClaimHash() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Claim #");	
	     }
		
		@Test(priority=5,description="TS043_Sorting on Claim Amount")
		public void testSortByClaimAmount() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Claim Amount");	
	     }
		
		@Test(priority=5,description="TS044_Sorting on Market Type")
		public void testSortByMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Market Type");	
	     }
		
		@Test(priority=5,description="TS045_Sorting on Archive")
		public void testSortByArchive() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Archive");	
	     }
		
		@Test(priority=5,description="TS047_Sorting on Payment Number")
		public void testSortByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfPayment"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Payment Number");
		 }
		@Test(priority=5,description="TS049_Pagination of Search Results")
		public void testPaginationOfSearchResults() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDateOfService"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin("421193699");	//421193699//596014973 
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifyPagination();
		 }
}
