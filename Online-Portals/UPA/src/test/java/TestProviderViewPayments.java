package test.java;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

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


public class TestProviderViewPayments extends TestBase {
	String userType="PROV";
    String accessType="Admin";
        
 
    /**
     * Includes TS002,TS006 to TS011
     * @throws IOException
     * @throws InterruptedException
     * @throws JAXBException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws ParseException
     */
   @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
   void testShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	 {
	    String filterPayments="Show All";
		String quickSearchFilter="";
		
		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "ALL");	
		
		String paymentType="generalPayment";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin(paymentType);
		
		//By default gets data for 30 days
		
		paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().verifyDefaultSearchResultCount();
		
	    quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);

        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
 
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
         
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
        
        quickSearchFilter="Last 4-6 months";
      paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	 }	
   
   
   /**
    * Includes TS005
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   
   @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
   void testNPIOnlyFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
    {
         
        String filterPayments="NPI Only";
        String archiveFilter="Show All";
        String quickSearchFilter="Last 30 days";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "NPI");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
 		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
 		home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
         
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
         
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);

        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
         
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
        
//        quickSearchFilter="Last 4-6 months";
//        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
     }	
   
   
   /**
    * TS004
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   @Test(priority=3,description="TS004_View Payments_Payments filter_TIN Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
   void testTinOnlyFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="TIN Only";
        String archiveFilter="Show All";
        String quickSearchFilter="Last 30 days";
        
        testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
		testConfig.putRunTimeProperty("value", "TIN");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
      
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter); 	
      
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
//        quickSearchFilter="Last 4-6 months";
//        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
      
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
  }	

   
   /**
    * TS021
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments")
   void testActiveOnlyArchivedPaymntFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter="Active Only";
        String quickSearchFilter="Last 30 days";
        
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");		

        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
      
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
      
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
//        quickSearchFilter="Last 4-6 months";
//        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }	
   
   
   
   
   /**
    * TS022
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   
   @Test(priority=5,description="TS022_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
   void testShowAllArchivedPaymntFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String archiveFilter=filterPayments;
        String quickSearchFilter="Last 30 days";
        testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
      
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments); 	
      
        quickSearchFilter="Last 60 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 90 days";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
//        quickSearchFilter="Last 4-6 months";
//        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 6-9 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
      
        quickSearchFilter="Last 9-13 months";
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
  }
   
   
   /**
    * TS003,TS017
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */

   @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending")
   void testPaymentDateSorting() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {   
	    String quickSearchFilter="Last 60 days";
	    String archiveFilter="Show All";
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter);
        paymentSummaryPage.verifyPaymentDateSorting("Desc");
        paymentSummaryPage.verifyPaymentDateSorting("Asc");    
   }
   
   
   /**
    * TS024
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   
   @Test(priority=5,description="TS024_View Payments_Remit payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Remit Payments")
   void testRemitPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="remitPayment";
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setQuickSearchFilter(paymentType);
       paymentSummaryPage.verifyRemitPaymentPopUp();  
	}
   
   
   /**
    * TS025
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   
   @Test(priority=5,description="TS025_View Payments_Failed payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Failed Payments")
   void testFailedPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   String paymentType="failedPayment";
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setQuickSearchFilter(paymentType);
       paymentSummaryPage.verifyFailedPaymentPopUp();  
	}
   
   
   /**
    * TS014
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   
   @Test(priority=5,description="TS014_View Payments_Zero Dollar ACH Payments")
   void testZeroDollarACHPayments() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
	   String paymentType="ACH"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
	   paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();	  
	   paymentSummaryPage.verifyZeroDollarPayments(paymentType);      
   }
   
   
   /**
    * TS015
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
   
   @Test(priority=5,description="TS015_View Payments_Zero Dollar VCP Payments")
   void testZeroDollarVCPPayments() throws InterruptedException, IOException, JAXBException, SAXException, ParserConfigurationException, ParseException 
   {
	   String paymentType="VCP";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
	   paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();	   
	   paymentSummaryPage.verifyZeroDollarPayments(paymentType);	
   }
   
   
   @Test(priority=5,description="TS012_View Payments_Market Type filter_Medical_Dental etc" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type")
   void testSpecificMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String mktTypeFilter="Medical";
        String quickSearchFilter="Last 30 days";
        
        testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		testConfig.putRunTimeProperty("value", "M");
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, mktTypeFilter); 	
   }
      
   
   @Test(priority=5,description="TS013_View Payments_Market Type filter_Show All" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-ALL from the  filter - Market Type")
   void testALLMarketTypeFilter() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
      
        String filterPayments="Show All";
        String quickSearchFilter="Last 30 days";
        
        testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		testConfig.putRunTimeProperty("value", "ALL");
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
        paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments); 	
   }
   
   /**
    * Includes TS002,TS006 to TS011
    * @throws IOException
    * @throws InterruptedException
    * @throws JAXBException
    * @throws SAXException
    * @throws ParserConfigurationException
    * @throws ParseException
    */
  @Test(priority=1,description="TS006_View Payments_Payments filter_Show All " + "<br>" + "TS002_View Payments_display of TINs latest payments within the last 30 days" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
  void testShowALLFilter_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   userType="PROV";
	   accessType="Gen";
	   String filterPayments="Show All";
	   String quickSearchFilter="";
		
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
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
        
//       quickSearchFilter="Last 4-6 months";
//       paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
        
       quickSearchFilter="Last 6-9 months";
       paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
        
       quickSearchFilter="Last 9-13 months";
       paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
	 }	
  
  
  /**
   * Includes TS005
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  
  @Test(priority=2,description="TS005_View Payments_Payments filter_NPI Only"+ "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
  void testNPIOnlyFilter_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
   {
        
	   userType="PROV";
	   accessType="Gen";
	   
       String filterPayments="NPI Only";
       String archiveFilter="Show All";
       String quickSearchFilter="Last 30 days";
       
       testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "NPI");		

       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin();
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
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
  
  
  /**
   * TS004
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  @Test(priority=3,description="TS004_View Payments_Payments filter_TIN Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
  void testTinOnlyfilter_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
  {
	   userType="PROV";
	   accessType="Gen";
	   
       String filterPayments="TIN Only";
       String archiveFilter="Show All";
       String quickSearchFilter="Last 30 days";
       
       testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "TIN");		

       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin();
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
     
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

  
  /**
   * TS021
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  @Test(priority=5,description="TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments")
  void testActiveOnlyArchivedPaymntFilter_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
  {    
	   userType="PROV";
	   accessType="Gen";
     
       String filterPayments="Show All";
       String archiveFilter="Active Only";
       String quickSearchFilter="Last 30 days";
       
       testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
		testConfig.putRunTimeProperty("value", "N");		

       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.selectTin();
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
     
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
  
  
  
  
  /**
   * TS022
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  
  @Test(priority=5,description="TS022_View Payments_Active_Archived Payments filter_Archived Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
  void testShowAllArchivedPaymntFilter_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
  {
	   userType="PROV";
	   accessType="Gen";
	   
       String filterPayments="Show All";
       String archiveFilter=filterPayments;
       String quickSearchFilter="Last 30 days";
       testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
	   testConfig.putRunTimeProperty("value", "N");
		
       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin();
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
     
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
  
  
  /**
   * TS003,TS017
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */

  @Test(priority=4,description="TS003_View Payments_chronological order of payments" + "<br>" + "Validate Payment date sorting for both ascending and descending")
  void testPaymentDateSorting_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
  {    
	   userType="PROV";
	   accessType="Gen";
	   
	   String quickSearchFilter="Last 60 days";
	   String archiveFilter="Show All";
	   
       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin();
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter);
       paymentSummaryPage.verifyPaymentDateSorting("Desc");
       paymentSummaryPage.verifyPaymentDateSorting("Asc");    
  }
  
  
  /**
   * TS024
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  
  @Test(priority=5,description="TS024_View Payments_Remit payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Remit Payments")
  void testRemitPayments_GEN()throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   userType="PROV";
	   accessType="Gen";
	   
	   String paymentType="remitPayment";
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setQuickSearchFilter(paymentType);
       paymentSummaryPage.verifyRemitPaymentPopUp();  
	}
  
  
  /**
   * TS025
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  
  @Test(priority=5,description="TS025_View Payments_Failed payments " + " "+ "<br>" + "Validate hovering text appearing in popup for Failed Payments")
  void testFailedPayments_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
	{
	   userType="PROV";
	   accessType="Gen";
	   
	   String paymentType="failedPayment";
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setQuickSearchFilter(paymentType);
       paymentSummaryPage.verifyFailedPaymentPopUp();  
	}
  
  
  /**
   * TS014
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  
  @Test(priority=5,description="TS014_View Payments_Zero Dollar ACH Payments")
  void testZeroDollarACHPayments_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
  {
	   userType="PROV";
	   accessType="Gen"; 
	   
	   String paymentType="ACH"; 
	    
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
	   paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();	   
	   paymentSummaryPage.verifyZeroDollarPayments(paymentType);      
  }
  
  
  /**
   * TS015
   * @throws IOException
   * @throws InterruptedException
   * @throws JAXBException
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws ParseException
   */
  
  @Test(priority=5,description="TS015_View Payments_Zero Dollar VCP Payments")
  void testZeroDollarVCPPayments_GEN() throws InterruptedException, IOException, JAXBException, SAXException, ParserConfigurationException, ParseException 
  {    
	   userType="PROV";
	   accessType="Gen";
	  
	   String paymentType="VCP";
	   
	   testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");	
	   
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home = optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin(paymentType);
	   paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();	   
	   paymentSummaryPage.verifyZeroDollarPayments(paymentType);	
  }
  
  
  @Test(priority=5,description="TS012_View Payments_Market Type filter_Medical_Dental etc" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type")
  void testSpecificMarketTypeFilter_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
  {
	   userType="PROV";
	   accessType="Gen";
       String filterPayments="Show All";
       String mktTypeFilter="Medical";
       String quickSearchFilter="Last 30 days";
       
       testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		testConfig.putRunTimeProperty("value", "M");
		
       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin();
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
       paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, mktTypeFilter); 	
  }
     
  
  @Test(priority=5,description="TS013_View Payments_Market Type filter_Show All" + "<br>" + "Validate that correct payment information is displayed on selection of Market type-ALL from the  filter - Market Type")
  void testALLMarketTypeFilter_GEN() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
  {
	   userType="PROV";
	   accessType="Gen";
       String filterPayments="Show All";
       String quickSearchFilter="Last 30 days";
       
       testConfig.putRunTimeProperty("key", "MARKET_TYPE");
	   testConfig.putRunTimeProperty("value", "ALL");
		
       UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
       OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	   home.selectTin();
       paymentSummary paymentSummaryPage= home.clickViewPaymentsTab();
       paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments); 	
  }
 
//   
//   //Change its description
//   @Test(priority=1,description="TS_002_UPA_Provider_View payments_Request Sent to Request API _General user " + "<br>" + "Validate EPRA status is 'R' when PDF is generated for any payment number and pdf is present on nas drive")
//   void testEpraGeneration() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException   
//	 {
//	    String paymentType="nonEpraPayment";
//	    
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//	    HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	    home.selectTin(paymentType);
//        paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().setQuickSearchFilter(paymentType);
//        paymentSummaryPage.clickEpraPDFLink().verifyEpraStatus("R"); 	
//        //Add code for verification from unix server
//	 }
}

			
