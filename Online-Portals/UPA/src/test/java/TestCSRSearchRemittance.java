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

public class TestCSRSearchRemittance extends TestBase {
	String loginUserType="Super";
	
	@Test(priority=5,description="TS004_Search by Electronic Payment Number only")
	public void testEpraByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byElectronicPaymentNo";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySearchResults(criteriaType);	
      }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByCheckNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byCheckNo";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);;		
      }
	
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEprabyDOS() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOS";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDOSAndAccountNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOSAndAccountNo";
		String requestType="byDOS";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDOSAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String criteriaType="byDOSAndSubscriberId";
		String requestType="byDOS";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
		SearchRemittanceSearchCriteria srchCriteriaPage=srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);
     }
		
   @Test(priority=5,description="TS005_Search by Check Number only")
   public void testEpraByDOSAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String loginUserType="Super";
		String criteriaType="byDOSAndNpi";
		String requestType="byDOS";
						
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);
    }
		
   @Test(priority=5,description="TS005_Search by Check Number only")
   public void testEpraByDOSAndClaimNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
    {
		String loginUserType="Super";
		String criteriaType="byDOSAndClaimNo";
		String requestType="byDOS";
			
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);
    }
		
   @Test(priority=5,description="TS005_Search by Check Number only")
   public void testEpraByDOSAndZeroPaymentClaims() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
    {
		String loginUserType="Super";
		String criteriaType="byDOSAndZeroPaymentClaims";
		String requestType="byDOS";
			
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
        srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);			
	 }
	
	@Test(priority=5,description="TS005_Search by Date of Payment")
	public void testEpraByDOP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {	
		String criteriaType="byDOP";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);
     }
	
	@Test(priority=5,description="TS005_Search by DOP & Account No")
	public void testEprabyDOPAndAccountNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOPAndAccountNo";
		String requestType="byDOP";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);	
     }
	
	@Test(priority=5,description="TS005_Search by DOP & Subscriber ID")
	public void testEprabyDOPAndSubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOPAndSubscriberId";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);		
     }
	
	//NMeed to fix as div on ui is different having dfifferent parametrs
	@Test(priority=5,description="TS005_Search by DOP & NPI")
	public void testEprabyDOPAndNpi() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOPAndNpi";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);	
     }
	
	@Test(priority=5,description="TS005_Search by DOP & Claim No")
	public void testEprabyDOPAndClaimNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOPAndClaimNo";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);	
     }
	
	@Test(priority=5,description="TS005_DOP & Patient Name")
	public void testEprabyDOPAndPatientNm() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOPAndPatientNm";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);	
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEprabyDOPAndZeroPaymentClaims() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOPAndZeroPaymentClaims";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);	
     }
	
	
	//Ask abhinav to give its query
	//need to complete this test case based on approach to cover different market Types
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEprabyDOPAndMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOPAndMarketType";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);		
     }
	
	//amit
		@Test(priority=5,description="TS023_Error Messages")
		public void testErrorMsgs() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 	
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);;		
			srchTinPage.clickSearchBtn().verifyErrorMsgs();
	     }
		
		@Test(priority=5,description="TS024_Search by Patient Name_Tricare Payer Messages")
		public void testSearchByPatientNameTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOPAndPatientNm"; 	
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);
	     }
		
		@Test(priority=5,description="TS025_Search by Subscriber ID_Tricare Payer Messages")
		public void testSearchBySubscriberIDTricarePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOPAndSubscriberId"; 	
			String requestType="byDOP";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);;		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(requestType);
	     }

		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymenForACH"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("ACH");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status") //no data coming
		public void testTypeAndPaymentStatusByElectronicPaymentForCHK() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymenForCHK"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("CHK");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymenForVCP";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("VCP");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForNON() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymenForNON";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("NON");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusByElectronicPaymentForDD() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="DD";
			
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);		
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("DD");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusForACH() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP";
			String tinType="byElectronicPaymenForACH";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifyPaymentStatus("ACH");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusForVCP() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP";
			String tinType="byElectronicPaymentForVCP";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.getPaymentStatusFromDB(tinType).doSearch(criteriaType).verifyPaymentStatus("VCP");
	     }
		
		@Test(priority=5,description="TS026_Type And Payment Status")
		public void testTypeAndPaymentStatusForNON() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP";
			String tinType="byElectronicPaymentForNON";
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.getPaymentStatusFromDB(tinType).doSearch(criteriaType).verifyPaymentStatus("NON");
	     }
		
		
		
		@Test(priority=5,description="TS027_Returned Reason")
		public void testReturnedReasonByElectronicNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymentNo";
	 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByElectronicPaymentToVerifyReturnedReason(criteriaType).verifyReturnedReasonDisplayed(criteriaType);
	     }
		
		@Test(priority=5,description="TS027_Returned Reason")
		public void testReturnedReasonByCheckNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byCheckNo";
 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.searchByCheckNumberToVerifyReturnedReason(criteriaType).verifyReturnedReasonDisplayed(criteriaType);
	     }
		
		@Test(priority=5,description="TS029_Search Remittance Large Tin")
		public void testSearchRemittanceLargeTin() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 	
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);;		
			srchTinPage.clickSearchBtn().verifyLargeNonLargeTin();
	     }
		
		@Test(priority=5,description="TS030_Print Search Result First Page")
		public void testByPrintSearchResultFirstPage() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);		
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifyPrintFirstPage();
	     }
		
		@Test(priority=5,description="TS032_Search by Check Number only")
		public void testValidationOfCheckNoOfUnconsolidatedPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byCheckNo";
						
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);;		
	      }
		
		@Test(priority=5,description="TS033_Search by Check Number from Reoriginated Nacha table")
		public void testValidationOfCheckNoOfReOriginNacha() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String tinType="byCheckNo";
			String criteriaType="byCheckNoOfReoriginNacha";			
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);;		
	      }
		
		@Test(priority=5,description="TS034_Search by Check Number from Consolidated Payment Detail table")
		public void testValidationOfCheckNoOfConslPayDtl() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String tinType="byCheckNo";
			String criteriaType="byCheckNoOfConslPayDtl";		
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(tinType);
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);;		
	      }
		
		@Test(priority=5,description="TS035_Search by Payment Number Of Consolidated Payment")
		public void testValidationOfPaymentNoOfConsolidatedPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byElectronicPaymentNo";
						
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);
			SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
			srchCriteriaPage.doSearch(criteriaType).verifySearchResults(criteriaType);;		
	      }
		
		@Test(priority=5,description="TS036_Sorting on Payer Name")
		public void testSortByPayerName() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Payer");;
	     }
		
		@Test(priority=5,description="TS037_Sorting on Claim Date")
		public void testSortByClaimDate() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
	     
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Claim Date");
	     }
		
		@Test(priority=5,description="TS038_Sorting on NPI")
		public void testSortByNPI() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("NPI");
	     }
		
		@Test(priority=5,description="TS039_Sorting on Patient Name")
		public void testSortByPatientName() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Patient Name");	
	     }
		
		@Test(priority=5,description="TS040_Sorting on Subscriber Id")
		public void testSortBySubscriberId() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		{
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Subscriber ID");
	     }
		
		@Test(priority=5,description="TS041_Sorting on Account Number")
		public void testSortByAccountNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Account Number");	
	     }
		
		@Test(priority=5,description="TS042_Sorting on Claim #")
		public void testSortByClaimHash() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Claim #");	
	     }
		
		@Test(priority=5,description="TS043_Sorting on Claim Amount")
		public void testSortByClaimAmount() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Claim Amount");	
	     }
		
		@Test(priority=5,description="TS044_Sorting on Market Type")
		public void testSortByMarketType() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Market Type");	
	     }
		
		@Test(priority=5,description="TS045_Sorting on Archive")
		public void testSortByArchive() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Archive");	
	     }
		
		@Test(priority=5,description="TS046_Sorting on Payment Date")
		public void testSortByPaymentDate() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOSAndNpi"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Payment Date");	
	     }
		
		@Test(priority=5,description="TS047_Sorting on Payment Number")
		public void testSortByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOP"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Payment Number");
		 }
		
		@Test(priority=5,description="TS048_Sorting on Payment Amount")
		public void testSortByPaymentAmount() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOSAndNpi"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifySorting("Amount");	
	     }
		
		@Test(priority=5,description="TS049_Pagination of Search Results")
		public void testPaginationOfSearchResults() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
		 {
			String criteriaType="byDOS"; 
			LoginCSR loginPage=new LoginCSR(testConfig);
			CSRHomePage homePage=loginPage.doLogin(loginUserType);
			SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin("421193699");	//421193699//596014973 
			srchTinPage.clickSearchBtn().doSearch(criteriaType).verifyPagination();
		 }
}
