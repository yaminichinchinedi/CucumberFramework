//package test.java;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.HashMap;
//import javax.xml.bind.JAXBException;
//import javax.xml.parsers.ParserConfigurationException;
//
//import main.java.Utils.ViewPaymentsBSData;
//import main.java.nativeFunctions.TestBase;
//import main.java.pageObjects.HomePage;
//import main.java.pageObjects.OptumIdLoginPage;
//import main.java.pageObjects.UPARegistrationPage;
//import main.java.pageObjects.paymentSummary;
//import main.java.reporting.Log;
//
//import org.testng.annotations.Test;
//import org.xml.sax.SAXException;
//
///**
// * @author schandy 
// * needs to be changed-Priyanka
// *
// */
//public class TestBSViewPayments extends TestBase {
//
//	Boolean tinAssociated = false;
//	Boolean tinAssociationExisted = false;
//	String userType = "BS";
//	String accessType = "Admin";
//	String generalAccessType = "Gen";
//	String billingServiceId = "";
//	String existingTins ="";
//	Integer tinDatesBackTo = 0;
//	String adminUserName ="";
//	String genUserName ="";
//	
//	
//	ViewPaymentsBSData billingServiceData;
//	
//	HashMap<String, String> assignedTins = new HashMap<String,String>();
//	HashMap<String, Boolean> isTinNewlyAssigned = new HashMap<String, Boolean>(); 
//	HashMap<String, String> existingAssociation = new HashMap<String,String>();
//	
//	
//	@Override
//	public void initializeData()
//	{
//		String env = System.getProperty("env");
//		adminUserName = testConfig.runtimeProperties.getProperty("UPA_OptumID_BS_Admin_" + env);
//		genUserName = testConfig.runtimeProperties.getProperty("UPA_OptumID_BS_Gen_" + env);
//
//		billingServiceData = new ViewPaymentsBSData(testConfig);
//		billingServiceData.setBsIdAndTinOfBSUser(adminUserName);
//		billingServiceData.setBsIdAndTinOfBSUser(genUserName);
//		
//		billingServiceData.identifyTINsForAllViewPaymentTestCases();
//		billingServiceData.associateBillingServiceUserToTIN();
//	}
//	
//	@Override
//	public void deinitializeData()
//	{
//		billingServiceData.deleteAllAssociatedTINs();
//		billingServiceData =null;
//	}
//	
//
//	/**
//	 * TS002, TS006, TS023
//	 * TS002_View Payments_Admin_display of TINs latest payments within the last 30 days, TS006_View Payments_Payments filter_Show All and TS023_View Payments_Active_Archived Payments filter_Show All 
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS002, TS006 and TS023_View Payments_Payments filter_Show All " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testAdminShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException,ParserConfigurationException, ParseException 
//	{
//	  String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");		
//	  if (associatedTin.equals("")) 
//		 Log.Warning("Did not find a TIN to test this test case. Please test this test case manually.",testConfig);
//	else 
//	  {
//		Log.Comment("Testing the test case with the TIN : "+associatedTin);
//		String archivePayments = "Show All";
//		testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//		testConfig.putRunTimeProperty("value", "ALL");
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//		OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//		HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//		paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//		paymentSummaryPage.newVerifySearchResultsWithFilters(null, null, archivePayments, null, false);
//		}
//	}
//	
//	/**
//	 * TS002, TS006, TS023
//	 * TS002_View Payments_Admin_display of TINs latest payments within the last 30 days, TS006_View Payments_Payments filter_Show All and TS023_View Payments_Active_Archived Payments filter_Show All 
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS002, TS006 and TS023_General_View Payments_Payments filter_Show All " + "<br>" + "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testGenShowALLFilter() throws IOException, InterruptedException, JAXBException, SAXException,ParserConfigurationException, ParseException 
//	{
//		
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");		
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			Log.Comment("Testing the test case with the TIN : "+associatedTin);
//			String archivePayments = "Show All";
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, null, archivePayments, null, false);
//		}
//	}
//		
//	
//	/**
//	 * TS003_View Payments_Admin_chronological order of payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 4, description = "TS003_View Payments_Admin_chronological order of payments" + "<br>"+ "Validate Payment date sorting for both ascending and descending")
//	void testPaymentDateSortingAdmin() throws IOException, InterruptedException, JAXBException, SAXException,ParserConfigurationException, ParseException {
//
//		
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			Log.Comment("Testing the test case with the TIN : "+associatedTin);
//			String quickSearchFilter = "Last 90 days";
//			String archiveFilter = "Show All";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter);			
//			Log.Comment("Testing to see if the dates are sorted in descending order ");
//			paymentSummaryPage.verifyPaymentDateSorting("Desc");
//			Log.Comment("Testing to see if the dates are sorted in ascending order ");
//			paymentSummaryPage.verifyPaymentDateSorting("Asc");
//		}
//	}
//
//	/**
//	 * TS003_View Payments_General_chronological order of payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 4, description = "TS003_View Payments_General_chronological order of payments" + "<br>"+ "Validate Payment date sorting for both ascending and descending")
//	void testPaymentDateSortingGeneral() throws IOException, InterruptedException, JAXBException, SAXException,ParserConfigurationException, ParseException {
//
//		
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		}
//		else 
//		{
//			Log.Comment("Testing the test case with the TIN : "+associatedTin);
//			String quickSearchFilter = "Last 90 days";
//			String archiveFilter = "Show All";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter);			
//			Log.Comment("Testing to see if the dates are sorted in descending order ");
//			paymentSummaryPage.verifyPaymentDateSorting("Desc");
//			Log.Comment("Testing to see if the dates are sorted in ascending order ");
//			paymentSummaryPage.verifyPaymentDateSorting("Asc");
//		}
//	}
//		
//	
//	/**
//	 * TS004_View Payments_Admin_Payments filter_TIN Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 3, description = "TS004_View Payments_Admin_Payments filter_TIN Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
//	void testPaymentDetailsForTinOnlyfilterAdmin() throws IOException, InterruptedException, JAXBException, SAXException,
//			ParserConfigurationException, ParseException {
//		
//		String associatedTin = billingServiceData.assignedTins.get("TIN").get("PROV_TAX_ID_NBR");
//
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			Log.Comment("Testing the test case with the TIN : "+associatedTin);
//			String filterPayments = "TIN Only";
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "TIN");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();
//			paymentSummaryPage = paymentSummaryPage.bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(filterPayments, quickSearchFilter, null,null, true);
//		}
//	}
//	
//	/**
//	 * TS004_View Payments_General_Payments filter_TIN Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 3, description = "TS004_View Payments_General_Payments filter_TIN Only" + "<br>" + "Validate that correct payment information is displayed on selection of 'TIN Only' from the  filter - Filter Payments")
//	void testPaymentDetailsForTinOnlyfilterGeneral() throws IOException, InterruptedException, JAXBException, SAXException,
//			ParserConfigurationException, ParseException {
//		
//		String associatedTin = billingServiceData.assignedTins.get("TIN").get("PROV_TAX_ID_NBR");
//
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			Log.Comment("Testing the test case with the TIN : "+associatedTin);
//			String filterPayments = "TIN Only";
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "TIN");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();
//			paymentSummaryPage = paymentSummaryPage.bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(filterPayments, quickSearchFilter, null,null, true);
//		}
//	}
//	
//
//	/**
//	 * TS005_View Payments_Admin_Payments filter_NPI Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 2, description = "TS005_View Payments_Payments filter_NPI Only" + "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
//	void testPaymentDetailsForNPIOnlyFilterAdmin() throws IOException, InterruptedException, JAXBException, SAXException,
//			ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("NPI").get("PROV_TAX_ID_NBR");
//
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String filterPayments = "NPI Only";
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "NPI");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();
//			System.out.println(associatedTin);
//			paymentSummaryPage = paymentSummaryPage.bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(filterPayments, quickSearchFilter, null,null, true);
//		}
//	}
//
//	/**
//	 * TS005_View Payments_General_Payments filter_NPI Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 2, description = "TS005_View Payments_General_Payments filter_NPI Only" + "<br>" + "Validate correct payment information is displayed on selection of 'NPI Only' from the  filter - Filter Payments")
//	void testPaymentDetailsForNPIOnlyFilterGeneral() throws IOException, InterruptedException, JAXBException, SAXException,
//			ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("NPI").get("PROV_TAX_ID_NBR");
//
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String filterPayments = "NPI Only";
//			String archiveFilter = "Show All";
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "NPI");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();
//			System.out.println(associatedTin);
//			paymentSummaryPage = paymentSummaryPage.bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(filterPayments, quickSearchFilter, null,null, true);
//		}
//	}
//
//	
//	/**
//	 * TS007_View Payments_Payments_Admin filter_Last Sixty Days
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS007_View Payments_Payments filter_Last Sixty Days " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForLastSixtyDaysFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} else {
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 60 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//
//	 /** 
//	  * TS007_View Payments_General_Payments filter_Last Sixty Days
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS007_View Payments_General_Payments filter_Last Sixty Days " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForLastSixtyDaysFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 60 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//
//
//	/**
//	 * TS008_View Payments_Admin_Payments filter_Last Ninety Days
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS008_View Payments_Admin_Payments filter_Last Ninety Days " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForLastNinetyDaysFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//
//	/**
//	 * TS008_View Payments_General_Payments filter_Last Ninety Days
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS008_View Payments_General_Payments filter_Last Ninety Days " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForLastNinetyDaysFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//
//
//	/**
//	 * TS009_View Payments_Admin_Payments filter_Last 4 to 6 Months 
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS009_View Payments_Payments filter_Last 4 to 6 Months " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForFourToSixMonthsFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("FourToSixMonths").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} else {
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 4-6 months";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//
//	/**
//	 * TS009_View Payments_General_Payments filter_Last 4 to 6 Months 
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS009_View Payments_Payments filter_Last 4 to 6 Months " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForFourToSixMonthsFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("FourToSixMonths").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else {
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 4-6 months";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//	
//
//	/**
//	 * TS010_View Payments_Admin_Payments filter_Last 6 to 9 Months 
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS010_View Payments_Payments filter_Last 6 to 9 Months " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForSixToNineMonthsFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("SixToNineMonths").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else {
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 6-9 months";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//
//	/**
//	 * TS010_View Payments_General_Payments filter_Last 6 to 9 Months 
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS010_View Payments_General_Payments filter_Last 6 to 9 Months " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForSixToNineMonthsFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//
//		String associatedTin = billingServiceData.assignedTins.get("SixToNineMonths").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else {
//			String filterPayments = "Show All";
//			String quickSearchFilter = "Last 6-9 months";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//		}
//	}
//	
//
//	/**
//	 * TS011_View Payments_Admin_Payments filter_Last 9 to 13 Months
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS011_View Payments_Admin_Payments filter_Last 9 to 13 Months " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForNineToThirteenMonthsFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//
//		String associatedTin = billingServiceData.assignedTins.get("NineToThirteenMonths").get("PROV_TAX_ID_NBR");		
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		}
//		else {
//				String filterPayments = "Show All";
//				String quickSearchFilter = "Last 9-13 months";
//				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//			}
//	}
//
//	/**
//	 * TS011_View Payments_General_Payments filter_Last 9 to 13 Months
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS011_View Payments_General_Payments filter_Last 9 to 13 Months " + "<br>"
//			+ "Validate correct payment information is displayed on selection of 'Show All' from the  filter - Filter Payments")
//	void testPaymentDetailsForNineToThirteenMonthsFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//
//		String associatedTin = billingServiceData.assignedTins.get("NineToThirteenMonths").get("PROV_TAX_ID_NBR");		
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		}
//		else {
//				String filterPayments = "Show All";
//				String quickSearchFilter = "Last 9-13 months";
//				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, false);
//			}
//	}
//	
//	
//	/**
//	 * TS012_View Payments_Admin_Market Type filter_Medical_Dental etc and TS013_View Payments_Market Type filter_Show All
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS012_View Payments_Admin_Market Type filter_Medical_Dental etc and TS013_View Payments_Market Type filter_Show All " + "<br>"
//			+ "Validate that the correct payment information is displayed when user selects a specific Market Type from the Market Type filter.")
//	void testPaymentDetailsForMedicalDentalFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//			
//			String associatedTin =  billingServiceData.assignedTins.get("Dental").get("PROV_TAX_ID_NBR");
//
//			if (associatedTin.equals(""))
//			{
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String filterPayments = "Show All";
//				String quickSearchFilter = "Last 90 days";
//				String marketType = "Dental";				
//				testConfig.putRunTimeProperty("key", "MARKET_TYPE");
//				testConfig.putRunTimeProperty("value", "D");
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, marketType, true);
//				marketType = "Show All";
//				testConfig.putRunTimeProperty("key", "MARKET_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null,null, true);
//			}
//	}
//	
//	/**
//	 * TS012_View Payments_General_Market Type filter_Medical_Dental etc and TS013_View Payments_Market Type filter_Show All
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS012_View Payments_Market Type filter_Medical_Dental etc and TS013_View Payments_Market Type filter_Show All " + "<br>"
//			+ "Validate that the correct payment information is displayed when user selects a specific Market Type from the Market Type filter.")
//	void testPaymentDetailsForMedicalDentalFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//			
//			String associatedTin =  billingServiceData.assignedTins.get("Dental").get("PROV_TAX_ID_NBR");
//
//			if (associatedTin.equals("")) 
//			{
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String filterPayments = "Show All";
//				String quickSearchFilter = "Last 90 days";				
//				
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//
//				String marketType = "Dental";				
//				testConfig.putRunTimeProperty("key", "MARKET_TYPE");
//				testConfig.putRunTimeProperty("value", "D");
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null, marketType, true);
//				
//				marketType = "Show All";
//				testConfig.putRunTimeProperty("key", "MARKET_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, null, marketType, true);
//			}
//	}
//	
//
//	/**
//	 * TS014_View Payments_Zero Dollar ACH payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS014_View Payments_Zero Dollar ACH payments" + "<br>"
//			+ "Validate that Zero dollar payment information displays appropriately for ACH payments.")
//	void testPaymentDetailsForZeroDollarACHFilterAdmin() throws IOException, InterruptedException, JAXBException,SAXException, ParserConfigurationException, ParseException 
//	{
//		String associatedTin = billingServiceData.assignedTins.get("ZeroAch").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifyZeroDollarPayments("ACH");
//		}
//	}
//
//	/**
//	 * TS014_View Payments_General_Zero Dollar ACH payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS014_View Payments_General_Zero Dollar ACH payments" + "<br>"
//			+ "Validate that Zero dollar payment information displays appropriately for ACH payments.")
//	void testPaymentDetailsForZeroDollarACHFilterGeneral() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException 
//	{
//		String associatedTin = billingServiceData.assignedTins.get("ZeroAch").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifyZeroDollarPayments("ACH");
//		}
//	}
//	
//
//	/**
//	 * TS015_View Payments_Zero Dollar VCP payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS015_View Payments_Zero Dollar VCP payments" + "<br>"
//			+ "Validate that Zero dollar payment information displays appropriately for VCP payments.")
//	void testPaymentDetailsForZeroDollarVCPFilterAdmin() throws IOException, InterruptedException, JAXBException,SAXException, ParserConfigurationException, ParseException 
//	{
//		String associatedTin = billingServiceData.assignedTins.get("ZeroVcp").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifyZeroDollarPayments("VCP");
//		}
//	}
//	
//	/**
//	 * TS015_View Payments_General_Zero Dollar VCP payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS015_View Payments_Zero Dollar VCP payments" + "<br>"
//			+ "Validate that Zero dollar payment information displays appropriately for VCP payments.")
//	void testPaymentDetailsForZeroDollarVCPFilterGeneral() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException 
//	{	
//		String associatedTin = billingServiceData.assignedTins.get("ZeroVcp").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifyZeroDollarPayments("VCP");
//		}
//	}
//	
//
//	/**
//	 * TS017_View Payments_Column Re-sorting on UPA
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */ 
//	@Test(priority = 4, description = "TS017_View Payments_chronological order of payments" + "<br>"+ "Validate Payment date sorting for both ascending and descending")
//	void testPaymentOtherFieldSortingAdmin() throws IOException, InterruptedException, JAXBException, SAXException,ParserConfigurationException, ParseException 
//	{
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String quickSearchFilter = "Last 30 days";
//			String archiveFilter = "Show All";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.verifyOtherFieldSorting();
//		}
//	}
//	
//	/**
//	 * TS017_View Payments_General_Column Re-sorting on UPA
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */ 
//	@Test(priority = 4, description = "TS017_View Payments_General_chronological order of payments" + "<br>"+ "Validate Payment date sorting for both ascending and descending")
//	void testPaymentOtherFieldSortingGeneral() throws IOException, InterruptedException, JAXBException, SAXException,ParserConfigurationException, ParseException 
//	{
//		String associatedTin = billingServiceData.assignedTins.get("AllDays").get("PROV_TAX_ID_NBR");
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String quickSearchFilter = "Last 30 days";
//			String archiveFilter = "Show All";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.verifyOtherFieldSorting();
//		}
//	}
//	
//	
//	/**
//	 * TS018_View Payments_Maximum limit of payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS018_View Payments_Maximum limit of payments" + "<br>"
//			+ "Validate that a maximum of 30 payments display on View Payments page")
//	void testPaymentDetailsForPaginationMaximumLimitFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//			String associatedTin = billingServiceData.assignedTins.get("Pagination").get("PROV_TAX_ID_NBR");		
//			if (associatedTin.equals("")) 
//			{
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String quickSearchFilter = "Last 30 days";	
//				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");	
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);	
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifyMaximumRecordsInAPage( quickSearchFilter);				
//			}
//	}
//	
//	/**
//	 * TS018_View Payments_General_Maximum limit of payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS018_View Payments_Maximum limit of payments" + "<br>"
//			+ "Validate that a maximum of 30 payments display on View Payments page")
//	void testPaymentDetailsForPaginationMaximumLimitFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//			String associatedTin = billingServiceData.assignedTins.get("Pagination").get("PROV_TAX_ID_NBR");		
//			if (associatedTin.equals("")) 
//			{
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String quickSearchFilter = "Last 90 days";
//				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifyMaximumRecordsInAPage( quickSearchFilter );
//			}
//	}
//	
//	
//	/**
//	 * TS019_View Payments_Pagination
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS019_View Payments_Pagination" + "<br>" + "Validate pagination if more than 30 payment results need to be displayed")
//	void testPaymentDetailsForPaginationAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//		String associatedTin = billingServiceData.assignedTins.get("Pagination").get("PROV_TAX_ID_NBR");
//		
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			String quickSearchFilter = "Last 30 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifyPagination( quickSearchFilter );	
//		}
//	}
//
//	/**
//	 * TS019_View Payments_General_Pagination
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS019_View Payments_General_Pagination" + "<br>" + "Validate pagination if more than 30 payment results need to be displayed")
//	void testPaymentDetailsForPaginationGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//		String associatedTin = billingServiceData.assignedTins.get("Pagination").get("PROV_TAX_ID_NBR");
//		
//		if (associatedTin.equals("")) {
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else {
//			String quickSearchFilter = "Last 90 days";
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//			paymentSummaryPage.newVerifyPagination( quickSearchFilter );
//		}
//	}
//
//	
//	
//	/**
//	 * TS021_View Payments_Active_Archived Payments filter_Active Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 5, description = "TS021_View Payments_Active_Archived Payments filter_Active Only" + "<br>"
//			+ "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments")
//	void testPaymentDetailsForActiveOnlyFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//			String associatedTin = billingServiceData.assignedTins.get("ArchiveActiveOnly").get("PROV_TAX_ID_NBR");
//			if (associatedTin.equals("")) 
//			{
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String filterPayments = "Show All";
//				String quickSearchFilter =  "Last 90 days";
//				String marketType = "Show All";
//				String archiveType = "Active Only";
//				testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
//				testConfig.putRunTimeProperty("value", "N");
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, archiveType,null, true);
//			}
//	}
//	
//	/**
//	 * TS021_View Payments_General_Active_Archived Payments filter_Active Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 5, description = "TS021_View Payments_General_Active_Archived Payments filter_Active Only" + "<br>"
//			+ "Validate that correct payment information is displayed on selection of 'Active Only' from the  filter - Archived Payments")
//	void testPaymentDetailsForActiveOnlyFilterGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//			String associatedTin = billingServiceData.assignedTins.get("ArchiveActiveOnly").get("PROV_TAX_ID_NBR");
//			if (associatedTin.equals("")) 
//			{
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String filterPayments = "Show All";
//				String quickSearchFilter =  "Last 90 days";
//				String marketType = "Show All";
//				String archiveType = "Active Only";
//				testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
//				testConfig.putRunTimeProperty("value", "N");
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, archiveType,null, true);
//			}
//	}
//
//	
//	
//	/**
//	 * TS022_View Payments_Admin_Active_Archived Payments filter_Active Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 5, description = "TS022_View Payments_Active_Archived Payments filter_Active Only" + "<br>"
//			+ "Validate that correct payment information is displayed on selection of 'Archcived Only' from the  filter - Archived Payments")
//	void testPaymentDetailsForArchiveOnlyFilterAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//			String associatedTin = billingServiceData.assignedTins.get("ArchiveActiveOnly").get("PROV_TAX_ID_NBR");
//			if (associatedTin.equals("")) 
//			{
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String filterPayments = "Show All";
//				String quickSearchFilter =  "Last 90 days";
//				String marketType = "Show All";
//				String archiveType = "Archived Only";	
//				testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
//				testConfig.putRunTimeProperty("value", "Y");	
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);	
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, archiveType,null, true);
//			}
//	}
//
//		/**
//	 * TS022_View Payments_General_Active_Archived Payments filter_Active Only
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 5, description = "TS022_View Payments_Active_Archived Payments filter_Active Only" + "<br>"
//			+ "Validate that correct payment information is displayed on selection of 'Archcived Only' from the  filter - Archived Payments")
//	void testPaymentDetailsForArchiveOnlyFilterGeneral() throws IOException, InterruptedException, JAXBException,
//				SAXException, ParserConfigurationException, ParseException {
//			
//				String associatedTin = billingServiceData.assignedTins.get("ArchiveActiveOnly").get("PROV_TAX_ID_NBR");
//				if (associatedTin.equals("")) 
//				{
//					Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//				} 
//				else 
//				{
//					String filterPayments = "Show All";
//					String quickSearchFilter =  "Last 90 days";
//					String marketType = "Show All";
//					String archiveType = "Archived Only";		
//					testConfig.putRunTimeProperty("key", "ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
//					testConfig.putRunTimeProperty("value", "Y");		
//					UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//					OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//					HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);		
//					paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//					paymentSummaryPage.newVerifySearchResultsWithFilters(null, quickSearchFilter, archiveType,null, true);
//				}
//		}	
//
//	
//	
//	
//	/**
//	 * TS024_View Payments_Admin_Remit in progress payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS024_View Payments_Remit in progress payments" + "<br>"
//			+ "Validate that for ACH/CHK/VCP Remit In Progress Payments, Payment Number link will be disabled and user will see pop-up instead of Remittance Detail\n")
//	void testPaymentDetailsForRemitPaymentsAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//		Log.Fail("Please perform this test manually as there is a known bug in js call window.createpopup(). This works only on IE");
//		
//		String associatedACHTin = billingServiceData.assignedTins.get("RemitACH").get("PROV_TAX_ID_NBR");
//		String associatedVCPTin = billingServiceData.assignedTins.get("RemitVCP").get("PROV_TAX_ID_NBR");
//		String associatedCHKTin = billingServiceData.assignedTins.get("RemitCHK").get("PROV_TAX_ID_NBR");
//		
//		Log.Fail("Please perform this test manually as there is a known compatibility issue with the js call window.createpopup(). This works only on IE. Identified TIN :" + associatedACHTin +" ,"+ associatedVCPTin +" ,"+ associatedCHKTin );
//		
//		if (associatedACHTin.equals("") && associatedVCPTin.equals("") && associatedCHKTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();
//						
//			if(!associatedACHTin.equals(""))
//			{
//				paymentSummaryPage.bsTin(associatedACHTin);
//				paymentSummaryPage.verifyRemitPaymentPopUp();
//			}
//			else
//			{
//				Log.Warning("Did not find a TIN to test failed ACH payments", testConfig);				
//			}
//			
//			if(!associatedVCPTin.equals(""))
//			{
//				paymentSummaryPage.bsTin(associatedVCPTin);
//				paymentSummaryPage.verifyRemitPaymentPopUp();
//			}
//			else
//			{
//				Log.Warning("Did not find a TIN to test failed VCP payments", testConfig);				
//			}
//			
//			if(!associatedCHKTin.equals(""))
//			{
//				paymentSummaryPage.bsTin(associatedCHKTin);
//				paymentSummaryPage.verifyRemitPaymentPopUp();
//			}
//			else
//			{
//				Log.Warning("Did not find a TIN to test failed CHK payments", testConfig);				
//			}
//		}
//	}
//	
//	/**
//	 * TS024_View Payments_General_Remit in progress payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS024_View Payments_General_Remit in progress payments" + "<br>"
//			+ "Validate that for ACH/CHK/VCP Remit In Progress Payments, Payment Number link will be disabled and user will see pop-up instead of Remittance Detail\n")
//	void testPaymentDetailsForRemitPaymentsGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//		String associatedACHTin = billingServiceData.assignedTins.get("RemitACH").get("PROV_TAX_ID_NBR");
//		String associatedVCPTin = billingServiceData.assignedTins.get("RemitVCP").get("PROV_TAX_ID_NBR");
//		String associatedCHKTin = billingServiceData.assignedTins.get("RemitCHK").get("PROV_TAX_ID_NBR");
//		
//		Log.Fail("Please perform this test manually as there is a known compatibility issue with the js call window.createpopup(). This works only on IE. Identified TIN :" + associatedACHTin +" ,"+ associatedVCPTin +" ,"+ associatedCHKTin );
//		
//		if (associatedACHTin.equals("") && associatedVCPTin.equals("") && associatedCHKTin.equals("")) 
//		{
//			Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//		} 
//		else 
//		{
//			testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//			testConfig.putRunTimeProperty("value", "ALL");
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//			HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//			paymentSummary paymentSummaryPage = home.clickViewPaymentsTab();
//			
//			if(!associatedACHTin.equals(""))
//			{
//				paymentSummaryPage.bsTin(associatedACHTin);
//				paymentSummaryPage.verifyRemitPaymentPopUp();
//			}
//			else
//			{
//				Log.Warning("Did not find a TIN to test failed ACH payments", testConfig);				
//			}
//			
//			if(!associatedVCPTin.equals(""))
//			{
//				paymentSummaryPage.bsTin(associatedVCPTin);
//				paymentSummaryPage.verifyRemitPaymentPopUp();
//			}
//			else
//			{
//				Log.Warning("Did not find a TIN to test failed VCP payments", testConfig);				
//			}
//			
//			if(!associatedCHKTin.equals(""))
//			{
//				paymentSummaryPage.bsTin(associatedCHKTin);
//				paymentSummaryPage.verifyRemitPaymentPopUp();
//			}
//			else
//			{
//				Log.Warning("Did not find a TIN to test failed CHK payments", testConfig);				
//			}
//		}
//	}
//	
//	
//	/**
//	 * TS025_View Payments_Admin_Failed payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS025_View Payments_Failed payments" + "<br>"
//			+ "Validate that in case of Failed ACH/CHK/VCP Payments user gets pop-up \"Please contact provider support at 1-877-620-6194\") on hovering over the Failed Payment Status")
//	void testPaymentDetailsForFailedPaymentsAdmin() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//			String associatedTin = billingServiceData.assignedTins.get("Failed").get("PROV_TAX_ID_NBR");
//			Log.Fail("Please perform this test manually as there is a known compatibility issue with the js call window.createpopup(). This works only on IE. Identified TIN :" + associatedTin);
//			
//			if (associatedTin.equals("")) {
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String quickSearchFilter = "Last 90 days";	
//				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");	
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, accessType);
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.verifyFailedPaymentPopUp(quickSearchFilter);
//				
//			}
//	}
//
//	/**
//	 * TS025_View Payments_General_Failed payments
//	 * @throws IOException
//	 * @throws InterruptedException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 * @throws ParserConfigurationException
//	 * @throws ParseException
//	 */
//	@Test(priority = 1, description = "TS025_View Payments_General_Failed payments" + "<br>"
//			+ "Validate that in case of Failed ACH/CHK/VCP Payments user gets pop-up \"Please contact provider support at 1-877-620-6194\") on hovering over the Failed Payment Status")
//	void testPaymentDetailsForFailedPaymentsGeneral() throws IOException, InterruptedException, JAXBException,
//			SAXException, ParserConfigurationException, ParseException {
//		
//			String associatedTin = billingServiceData.assignedTins.get("Failed").get("PROV_TAX_ID_NBR");			
//			Log.Fail("Please perform this test manually as there is a known compatibility issue with the js call window.createpopup(). This works only on IE. Identified TIN :" + associatedTin);
//			
//			if (associatedTin.equals("")) {
//				Log.Fail("Did not find a TIN to test this test case. Please test this test case manually.");
//			} 
//			else 
//			{
//				String quickSearchFilter = "Last 90 days";	
//				testConfig.putRunTimeProperty("key", "TAX_IDENTIFIER_TYPE");
//				testConfig.putRunTimeProperty("value", "ALL");	
//				UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//				OptumIdLoginPage optumIDLoginPage = registrationPage.clickSignInWithOptumId();
//				HomePage home = optumIDLoginPage.loginWithOptumID(userType, generalAccessType);	
//				paymentSummary paymentSummaryPage = home.clickViewPaymentsTab().bsTin(associatedTin);
//				paymentSummaryPage.verifyFailedPaymentPopUp(quickSearchFilter);
//				
//			}
//	}
//
//	
//}
