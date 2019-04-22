package test.java;
import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.paymentSummary;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class TestCSRViewPayments extends TestBase{
	
	String loginUserType="Super";
	
	@Test(priority=5,description="Validate Failed Payment on CSR")
	public void testFailedPayments() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String paymentType="failedPayment";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);		
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
		paymentSummaryPage.setQuickSearchFilter(paymentType).verifyFailedPaymentPopUp();
      }
	
	@Test(priority=5,description="Validate Remit Payment on CSR")
	public void testRemitPayments() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String paymentType="remitPayment";
			
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
		paymentSummaryPage.setQuickSearchFilter(paymentType).verifyRemitPaymentPopUp();
      }
	
	
	/*@Test(priority=5,description="Validate Payer Filter on CSR")
	public void testValidatePayer() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";	
		String filterPayments="Show All";
		String paymentType="remitPayment";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink();
		srchTinPage.enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();

		paymentSummaryPage.setPayerFilter();
		paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
		//paymentSummaryPage.loadPayments(filterPayments, quickSearchFilter, filterPayments, filterPayments);
		Browser.wait(testConfig, 2); // need to shift in internally called functions
      } */
	
	
	
	@Test(priority=5,description="TS006_View Payments_Payments filter_Show All " + " "+ "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
	void testRecordCountForShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
		String filterPayments="Show All";
		String quickSearchFilter="Last 30 days";
		String paymentType="generalPayment";
		testConfig.putRunTimeProperty("taxIdentifierType", "ALL");	

		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
		quickSearchFilter="Last 60 days";
		paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
		quickSearchFilter="Last 90 days";
		paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	}
	
	
	@TestDetails(author="Priyanka")
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
    void testPaymentsForShowAllFilter_30days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");
 		String paymentType="generalPayment30Days";
 		
 		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		srchTinPage.clickSearchBtn().verifyDefaultSearchResultCount();

 	 }
    
    @TestDetails(author="Priyanka")
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
    void testPaymentsForShowAllFilter_60days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
 	    String filterPayments="Show All";
		String quickSearchFilter="Last 60 days";
 		String paymentType="generalPayment60Days";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		srchTinPage.clickSearchBtn().verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	

 	 }
    
    @TestDetails(author="Priyanka")
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
    void testPaymentsForShowAllFilter_90days() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
 	    String filterPayments="Show All";
		String quickSearchFilter="Last 90 days";
		String paymentType="generalPayment90Days";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		
 		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		srchTinPage.clickSearchBtn().verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);		
 	 }
    
    @TestDetails(author="Priyanka")
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
    void testPaymentsForShowAllFilter_4_6Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
 	    String filterPayments="Show All";
		String quickSearchFilter="Last 4-6 months";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(quickSearchFilter);
		srchTinPage.clickSearchBtn().verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);			

 	 }
    
    @TestDetails(author="Priyanka")
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
    void testPaymentsForShowALLFilter_6_9Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
 	    String filterPayments="Show All";
		String quickSearchFilter="Last 6-9 months";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(quickSearchFilter);
		srchTinPage.clickSearchBtn().verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);			
 	 }
    
    @TestDetails(author="Priyanka")
    @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
    void testPaymentsForShowALLFilter_9_13Months() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
 	 {
 	    String filterPayments="Show All";
		String quickSearchFilter="Last 9-13 months";
 		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
 		testConfig.putRunTimeProperty("value", "ALL");	
 		
 		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(quickSearchFilter);
		srchTinPage.clickSearchBtn().verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);			
 	 }
        
	
	
	@Test(priority=5,description="TS005_View Payments_Payments filter_NPI Only" + "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
	void testRecordCountForNPIOnlyFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	         
	    String filterPayments="NPI Only";
	    String archiveFilter="Show All";
	    String quickSearchFilter="Last 30 days";
	    String paymentType="generalPayment";
	    testConfig.putRunTimeProperty("taxIdentifierType", "NPI");
	    
	    LoginCSR loginPage=new LoginCSR(testConfig);
	 	CSRHomePage homePage=loginPage.doLogin(loginUserType);
 		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn(); 		
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
	   
	   
   @Test(priority=5,description="TS004_View Payments_Payments filter_TIN Only" + '\n' + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
   void testRecordCountForTinOnlyfilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
     
	   	String filterPayments="TIN Only";
	   	String archiveFilter="Show All";
	   	String quickSearchFilter="Last 30 days";
	   	String paymentType="generalPayment";
	   	testConfig.putRunTimeProperty("taxIdentifierType", "TIN");	

	   	LoginCSR loginPage=new LoginCSR(testConfig);
	   	CSRHomePage homePage=loginPage.doLogin(loginUserType);
	   	SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();	   	
	   	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
	   	quickSearchFilter="Last 60 days";
	   	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
	   	quickSearchFilter="Last 90 days";
	   	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
	   	quickSearchFilter="Last 4-6 months";
	   	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
	   	quickSearchFilter="Last 6-9 months";
	   	paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
	      
  }
   
   //Need to build query
   
   @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments")
   void testArchivedPaymentsFilterActiveOnly() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter="Active Only";
        String quickSearchFilter="Last 30 days";
        String paymentType="generalPayment";
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");
		
		LoginCSR loginPage=new LoginCSR(testConfig);
	   	CSRHomePage homePage=loginPage.doLogin(loginUserType);
	   	SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
	   	
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 4-6 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }	
   
   @Test(priority=5,description="TS022_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Archived Only' from the  filter - Archive Payments")
   void testArchivedPaymentsFilterArchivedOnly() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter="Archived Only";
        String quickSearchFilter="Last 30 days";
        String loginUserType="Super";
        String paymentType="generalPayment";
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "Y");
		
		LoginCSR loginPage=new LoginCSR(testConfig);
	   	CSRHomePage homePage=loginPage.doLogin(loginUserType);
	   	SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 4-6 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }	
   
   
   @Test(priority=5,description="TS022_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
   void testArchivedPaymentsFilterShowALL() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter=filterPayments;
        String quickSearchFilter="Last 30 days";
        String paymentType="generalPayment";
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");
		
		LoginCSR loginPage=new LoginCSR(testConfig);
	   	CSRHomePage homePage=loginPage.doLogin(loginUserType);
	   	SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();     
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
      
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 4-6 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }
   
   @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending")
   void testPaymentDateSorting() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {   
	    String quickSearchFilter="Last 60 days";
	    String archiveFilter="Show All";
	    String loginUserType="Super";
        String paymentType="generalPayment";
        
	    LoginCSR loginPage=new LoginCSR(testConfig);
	   	CSRHomePage homePage=loginPage.doLogin(loginUserType);
	   	SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
        paymentSummaryPage.setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter).verifyPaymentDateSorting("Desc");
   }
   
   @Test(priority=5,description="TS014_View Payments_Zero Dollar ACH Payments")
   void testZeroDollarACHPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="ACH"; 
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   LoginCSR loginPage=new LoginCSR(testConfig);
	   CSRHomePage homePage=loginPage.doLogin(loginUserType);
	   SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
	   paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();	   	   
	   paymentSummaryPage.verifyZeroDollarPayments(paymentType);      
   }
   
   @Test(priority=5,description="TS015_View Payments_Zero Dollar VCP Payments")
   void testZeroDollarVCPPayments() throws InterruptedException, IOException, JAXBException, SAXException, ParserConfigurationException, ParseException 
   {
	   String paymentType="VCP";
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   LoginCSR loginPage=new LoginCSR(testConfig);
	   CSRHomePage homePage=loginPage.doLogin(loginUserType);
	   SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
	   paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();paymentSummaryPage.verifyZeroDollarPayments(paymentType);	
   }
   
   @Test(priority=5,description="TS012_View Payments_Market Type filter_Medical_Dental etc" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type")
   void testSpecificMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   	String filterPayments="Show All";
        String mktTypeFilter="Medical";
        String quickSearchFilter="Last 30 days";
        String paymentType="generalPayment";
        testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		testConfig.putRunTimeProperty("value", "M");
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
		paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, mktTypeFilter); 	
   }
      
   
   @Test(priority=5,description="TS013_View Payments_Market Type filter_Show All" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-ALL from the  filter - Market Type")
   void testALLMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   { 
	   String filterPayments="Show All";
       String quickSearchFilter="Last 30 days";
       String paymentType="generalPayment";
       testConfig.putRunTimeProperty("key", "MARKET_TYPE");
       testConfig.putRunTimeProperty("value", "ALL");
       
       LoginCSR loginPage=new LoginCSR(testConfig);
       CSRHomePage homePage=loginPage.doLogin(loginUserType);
       SearchTinPageViewPayments srchTinPage = homePage.clickViewPaymentsLink().enterTin(paymentType);
       paymentSummary paymentSummaryPage = srchTinPage.clickSearchBtn();
       paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments); 	
   }

}
