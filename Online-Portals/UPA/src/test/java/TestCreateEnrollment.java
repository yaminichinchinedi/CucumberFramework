package test.java;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;



import main.java.Utils.Helper;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.BenefitsOfEPS;
import main.java.pageObjects.EnrollmentSubmitted;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.Footer;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.HowToEnroll;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;
import main.java.pageObjects.ThankYouPage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.UXDSPageValidation;
import main.java.pageObjects.UploadW9;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.reporting.Log;

public class TestCreateEnrollment extends TestBase{
	
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1348562--TS004 Validates Page text is content Managed.",groups="Provider")
	public void testPageContent() throws IOException
	 {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.clickEnrollNow().verifyPageContent();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1348529--TS001/TS002 Validates the Page navigation from BeginEnrollment page to BeginEnrollmentContinue page",groups="Provider")

	public void testSurveyTablesAndResponse()
	 {
		String option="Provider Advocate recommendation";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.clickEnrollNow().selectHowYouHeard(option).verifySurveyTables(option);
	 }


	/**
	 * These below test cases belong to US1202167
	 * @author Amit
	 * @throws IOException
	 */

	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS001/TS002/TS018/TS023 Validates User Enrollment As Health Organisation",groups="Provider") 
	public void testUserEnrollmentAsHealthOrg() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinue().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();
	 }
	

	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS003 Validates User Enrollment As BS",groups="Billing Service")
	public void testUserEnrollmentAsBS() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS004/TS005/TS006/TS015 Validates what shall i choose after Selecting Health Org /TS005 Validates Pop Up after clicking Close link",groups="Provider")
	public void testPopUpAfterChoosingHealthOrg() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyChooseLink();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS007/TS016/TS017 Validates Page after clicking on change link",groups="Provider")
	public void testChangeLinkFunctionality() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyChangeLink();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS008 + TS009 =Validates navigation upon selection of VCP and healthOrg/TS009 Validates navigation upon clicking Cancel on VCP PopUp Box",groups="Provider")
	public void testChooseVCP() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyPopUp("VO");
	 }

	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS010 Validates navigation upon selection of I agree option on VCP pop up ",groups="Provider")
	public void testEnrollAsVCP() throws IOException
	 {
		String option="Health plan communication";
		int excelRowNo=4;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();
		
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS011/TS014 Validates navigation upon selection of I agree option on ACH and VCP pop up",groups="Provider")
	public void testEnrollAsVCPandACH() throws IOException
	 {
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinueAV().clickContinue().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();	
	 }

	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS012/TS013 Validates navigation upon clicking Cancel on VCP PopUp Box",groups="Provider")
	public void testChooseVCPandACH() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		beginEnrollmentPage.selectHowYouHeard(option).verifyPopUp("AV");
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS020/TS021/TS022 Validates Content of PopUp upon clicking Cancel Button",groups="Provider")
	public void testCancelEnrollmentPopUp() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).verifyCancelEnrollmentFunctionality();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,description="US1202167--TS024-TS026 Validates errors messages displayed on various TIN combinations",groups="Provider")
	public void testErrorMsgs() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyErrorMsg();
	 }
	
	
	/**
	 * US1351123
	 * @author Priyanka
	 * @throws IOException
	 */
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351123- [1]TS_00003_Page text is content managed + TS_00004_Field label changes display Business Name and Business Address. + TS_00005_Messaging on page indicates not to enter special characters. + TS_00006_Header displays - For AO .+ TS_00009_To Validate Cancel Enrollment and Continue options display.",groups="Provider" )
	public void testPageContextFromDB()throws IOException
	{
		int excelRowNo=1;
			
	    UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyOrgInfoHeaders().verifyUITextFromDB();
			
	}
		
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351123- TS_00009_To Validate Cancel Enrollment and Continue options display.+ TS_00010_To Validate Cancel Enrollment and Continue options display. + TS_00011_ Validate  Upon selection of No, popup box closes and user is back on Organization Information page.. + TS_00012_ Validate Upon selection of Yes, user is returned to the EPS Landing page.",groups="Provider" )
	public void testCancelEnrollment()throws IOException
	{
		int excelRowNo=1;
			
	    UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyCancelEnrollmentFlow();
			
	}
		
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351123 - TS_00009_To Validate Cancel Enrollment and Continue options display.+ TS_00010_To Validate Cancel Enrollment and Continue options display. + TS_00011_ Validate  Upon selection of No, popup box closes and user is back on Organization Information page.. + TS_00012_ Validate Upon selection of Yes, user is returned to the EPS Landing page.+TS_00013,14 and 15,17",groups="Provider" )
	public void testContinueEnrollment()throws IOException
	{
		int excelRowNo=1;
			
	    UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyContinueEnrollmentValidations();
			
	}
		
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351123-TS_00018_Missing and invalid field validation for Business Name (special characters)",groups="Billing Service" )
	public void testFieldValidations()throws IOException
	{
		int excelRowNo=1;
			
	    UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillBusinessName("#&*").verifyErrorMsgForInvalidData("BusinessName").fillBusinessAddress("#&*").verifyErrorMsgForInvalidData("BusinessAddress");
			
	}
	
	
	/**
	 * US1351172 - Create Enrollment - Email Address Exists - Confirm User
	 * @author Priyanka
	 * @throws IOException
	 */
	
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351172 -  TS007,TS009- Verifies validation message if an existing email is used for new enrollment For Primary Prov",groups="Provider")
	public void testDupEmailErrorForPrimaryProvWithYes()throws IOException
	{
		int excelRowNo=1;
		String provType="Primary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).verifyAssociatedTins().clickYes(provType);
		
	}
	
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351172 -TS008 validation message if an existing email is used for new enrollment For Primary Prov",groups="Provider")
	public void testDupEmailErrorForPrimaryProvWithNo()throws IOException
	{
		int excelRowNo=1;
		String provType="Primary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).clickNo(provType);
		
	}
	
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351172 -TS007-Verifies validation message if an existing email is used for new enrollment For Secondary Prov",groups="Provider")
	public void testDupEmailErrorForSecondaryProvWithYes()throws IOException
	{
		int excelRowNo=1;
		String provType="Secondary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).verifyAssociatedTins().clickYes(provType);
	}
	
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351172 -TS008-Verifies validation message if an existing email is used for new enrollment For Secondary Prov",groups="Provider")
	public void testDupEmailErrorForSecondaryProvWithNo()throws IOException
	{
		int excelRowNo=1;
		String provType="Secondary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).verifyAssociatedTins().clickNo(provType);
	}
	
	@TestDetails(author="Priyanka")
	@Test(priority=3,description="US1351172 -TS013 - Verifies validation message if an existing email is used for new enrollment For Secondary Prov",groups="Provider")
	public void testDupEmailErrorForBothPrimaryAndSecondaryProv()throws IOException
	{
		int excelRowNo=1;
		String provType="PrimaryAndSecondary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).clickYes(provType).verifyDupEmailError("Secondary");
	}
	
	
	/**
	 * US1350108
	 * @author Avneet
	 * @throws IOException
	 */
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS01_TIN does not exist on EPS",groups="Provider")
	void testTINNotEnrolled()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo,status).clickContinue().verifyTINStatus();
		
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS02_TIN exists Inactive and not blocked",groups="Provider")
	void testInactiveUnBlockedTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "InactiveUnBlockedTIN";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();			
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS03_TIN does not exists on EPS_AO",groups="Provider")
	void testTINNotEnrolledAO()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();		
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS04_TIN does not exists on EPS_AV",groups="Provider")
	void testTINNotEnrolledVO()throws IOException
	{
		int excelRowNo=4;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();				
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS05_TIN does not exists on EPS_VO",groups="Provider")
	void testTINNotEnrolledAV()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();			
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS06_Content Managed",groups="Provider")
	void testContentManaged()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyContentManaged();	
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS07_UXDS match",groups="Provider")
	void testUXDSMatch()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyContentWithUXDS();	
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS08_Blank W9",groups="Provider")        // Need to check on this
	void testW9Form()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyW9Form();	
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS09_Cancel and Continue Enabled",groups="Provider")
	void testCancelAndContinueBtn()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyCancelAndContinueBtn();
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS10_Cancel Enrollment_Popup",groups="Provider")
	void testBtnCancelPopUp()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().clickCancel().verifyBtnCancelPopup();				
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS11_Cancel Enrollment_No",groups="Provider")
	void testBtnCancelPopUpClickNo()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().clickCancel().verifyBtnCancelPopup().confirmCancelNo().verifyTINStatus();
	}

	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1350108_TS12_Cancel Enrollment_Yes",groups="Provider")
	void testBtnCancelPopUpClickYes()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().clickCancel().verifyBtnCancelPopup().confirmCancelYes().clickAndVerifyHeaderHome();
	}
	
	
	
	/**
	 * US1023501
	 * @author :Avneet
	 * @throws IOException
	 */
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1023501_TS01_Enrolled and Active Status TIN",groups="Provider")
	void testEnrolledActiveStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledActiveStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledActiveStatusTIN();	
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1023501_TS02_Enrolled and Pre-Enrollment Status TIN",groups="Provider")
	void testEnrolledPreEnrollmentStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledPreEnrollmentStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledPreEnrollmentStatusTIN();			
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1023501_TS03_Auto Enrolled and in Pre-Enrollment Status TIN",groups="Provider")
	void testAutoEnrolledPreEnrollmentStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "AutoEnrolledPreEnrollmentStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyAutoEnrolledPreEnrollmentStatusTIN();	
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1023501_TS04_Enrolled and Inactive/Block Status TIN",groups="Provider")
	void testEnrolledInactiveAndBlockStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledInactiveAndBlockStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledInactiveAndBlockStatusTIN();
	}
	
	//US1348562- Abhinav
	
	/**
	 * @author Abhinav
	 */
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00001 - Upon selection of  Enroll Now button click navigates user to Before you begin enrollment page",groups="Provider")
	public void testBeforeYouBeginEnrollmentPage()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateBeginEnrollment();
	}
	
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00002/TC_0007 - Enroll Now  button from How to Enroll Page navigates user to  Before you begin enrollment  page",groups="Provider")
	public void testHowToEnrollLink()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		HowToEnroll howToEnroll = upaRegistrationPage.clickHowToEnrollLink();
		BeginEnrollment beginEnrollment = howToEnroll.validateEnrollNowBtn();
		beginEnrollment.validateBeginEnrollment();
	}
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00006 - Benefits of EPS link on page navigates user to the Benefits of EPS page.",groups="Provider")
	public void testValidateBenefitsOfEPSLink()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		upaRegistrationPage.clickBenefitsOfEPSLink();		
	}
	
	
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00010/TC_0009 - To Validate If user does not select an option and clicks continue , error message is displayed  below the radio buttons.",groups="Provider")
	public void testBeginEnrollmentErrorValidation()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinue = beginEnrollment.clickContinue();
		beginEnrollmentContinue.validateErrorMsgs();		
	}
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00011/TC_00012 - the error message  if user selects Other without entering text and clicks continue",groups="Provider")
	public void testBeginEnrollmentOtherRadioSelectedErrorValidation()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinue = beginEnrollment.selectOtherToValidateErrorMessage();
		beginEnrollmentContinue.validateErrorMsgs();		
	}
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00013/TC0015 - the limit of characters to be entered for the Text box, [Max limit 50]",groups="Provider")
	public void testBeginEnrollmentValidateLmtOfChars()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateTextBoxCharLmt();
	}
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00014 - The Pop up message on click of Cancel Enrollment Button.",groups="Provider")
	public void testValidateCancelEnrlmntBtn()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateCancelEnrollmentBtnNo();
		beginEnrollment.validateBeginEnrollment();
		upaRegistrationPage = beginEnrollment.validateCancelEnrollmentBtnYes();
	}
	
	@Test(priority=3,description="US1348562 - TS_00008 - User is able to download Enrollment Guide PDFs.")
	public void testAbleToDwnldEnrlmntPdf()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateUserIsAbleToDwnldEnrlmntPdf();		
	}
	
	@TestDetails(author="Abhinav")
	@Test(priority=3,description="US1348562 - TS_00005 - Q and A are obtained from active entries in Survey Table (responses appear in appropriate order",groups="Provider")
	public void testBeginEnrollmentQuestions() throws IOException
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateBeginEnrollmentQuestions();
	}
	
	@TestDetails(author="Amit")
	@Test(priority=3,groups="Billing Service",description="US1048048 - TS_013-TS023 - Validate Billing Service Fields")
	public void testValidateBillingServiceFieldsLeftBlank() throws IOException
	{
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().verifyContinueEnrollmentValidations();
	}
	
	@TestDetails(author="Amit")
	@Test(priority=3,groups="Billing Service",description="US1048048 - TS_013-TS023 - Validate Billing Service Fields")
	public void testValidateBillingServiceFieldsWithSpecialChar() throws IOException
	{
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow(); 
		beginEnrollmentPage.selectHowYouHeard(option).enrollAs(excelRow).clickContinue().clickContinue().validateBillingService("BSName", "&*min","CONTINUE").validateBillingService("Street", "*(*(*","CONTINUE").validateBillingService("Street", "PO BOX 7530","CONTINUE").validateBillingService("City", "%^&&","CONTINUE").validateBillingService("ZipCode", "anjhu","CONTINUE").validateBillingService("ZipCode", "70165","CONTINUE");
	}
		
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1033935 -TS001_Create Enrollment_HO_Enrollment Submitted_Print Completed Enrollment Form_AO enrollment") 
	public void testPDFVerificationforACH() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickYestoNPI().clickContinueNPI().fillFinancialInstInfoForNPI().clickContinue().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo().verifyPDFData();
	}
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1033935 -TS002_Create Enrollment_HO_Enrollment Submitted_Print Completed Enrollment Form_AV enrollment") 
	public void testPDFVerificationforVCP() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=4;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1033935 -TS003_Create Enrollment_HO_Enrollment Submitted_Print Completed Enrollment Form_VO enrollment") 
	public void testPDFVerificationforACHandVCP() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickYestoNPI().clickContinueNPI().fillFinancialInstInfoForNPI().clickContinueAV().clickContinue().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo().verifyPDFData();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Billing Service",description="US1048199 - TS01-TS07 Verify pdf data while enrolling as BS/US1048192-TS05") 
	public void testPDFVerificationforBS() throws IOException
	{
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo().verifyPDFData();
	 }

	@TestDetails(author="Amit")
	@Test(priority=4,groups="Billing Service",description="US1048192 - TS01/TS03/TS04/TS06/TS07 Enrollment Submitted page verification and Exit Enrollment Button present or not and its functionality") 
	public void testExitEnrollmentforBS() throws IOException
	{
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit().verifyPageContextforBS().verifyHeaders().verifyExitEnrollemnt();
		
	 }
	
	/**
	 * @author rkrish38
	 * @throws IOException
	 */
	@TestDetails(author="Rahul")
	@Test(priority=4,description="US1033480--TS01/TS02/TS03--Create Enrollment Provider Footer Display",groups="Provider")
	public void testFooterContents() throws IOException
	 {
		String option = "Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		new Footer(testConfig).validateFooterContents(testConfig);
		BeginEnrollment beginEnrollmentPage = registrationPage.clickEnrollNow();
		new Footer(testConfig).validateFooterContents(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinuePage = beginEnrollmentPage.selectHowYouHeard(option);
		new Footer(testConfig).validateFooterContents(testConfig);

		ValidateEnrollmentTypePage ValidateenrollmentTypePage = beginEnrollmentContinuePage.enrollAs(1).clickContinue();
		new Footer(testConfig).validateFooterContents(testConfig);
		ProviderEFTERAEnrollPage providerEFTERAEnrollPage = ValidateenrollmentTypePage.clickContinue();
		new Footer(testConfig).validateFooterContents(testConfig);
		ValidateEFTERAProviderInfo validateEFTERAProviderInfo = providerEFTERAEnrollPage.fillProviderOrgInfo().fillPrimaryProvInfo();
		new Footer(testConfig).validateFooterContents(testConfig);
		FinancialInstitutionInfoPage financialInstitutionInfoPage = validateEFTERAProviderInfo.clickContinue().fillFinancialInstInfo();
		new Footer(testConfig).validateFooterContents(testConfig);
		
	 }
	/**
	 * @author rkrish38
	 * @throws IOException
	 */

	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1033910-TS004 Validate the header display for AO ( Enrollment Submitted ) Page") 
	public void testApprovedUIforAO() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		EnrollmentSubmitted enrollmentSubmitted=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinue().uploadW9().fillInfoAndClickSubmit();	
		
		enrollmentSubmitted.verifyPageUI(testConfig);
	 }
    
	@TestDetails(author="Rahul")
	@Test(priority=4,description="US1033910-TS004 Validate the header display for AO ( Enrollment Submitted ) Page",groups="Provider") 
	public void testHeaderDisplayforAO() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		EnrollmentSubmitted enrollmentSubmitted=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinue().uploadW9().fillInfoAndClickSubmit();	
		enrollmentSubmitted.verifyHeaders();

	 }
	
	/**
	 * @author rkrish38
	 * @throws IOException
	 */
	
	@TestDetails(author="Rahul")
	@Test(priority=4,description="US1033910-TS005 Validate the header display for AV ( Enrollment Submitted ) Page",groups="Provider")
	public void testHeaderDisplayforAV() throws IOException
	 {
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		EnrollmentSubmitted enrollmentSubmitted=beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinueAV().clickContinue().uploadW9().fillInfoAndClickSubmit();	
		enrollmentSubmitted.verifyHeaders();

	 }
	/**
	 * @author rkrish38
	 * @throws IOException
	 */
	@TestDetails(author="Rahul")
	@Test(priority=4,description="US1033910-TS006 Validate the header display for VO ( Enrollment Submitted ) Page",groups="Provider") 
	public void testHeaderDisplayforVO() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=4;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
        EnrollmentSubmitted enrollmentSubmitted=beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit();
        enrollmentSubmitted.verifyHeaders();

	}
	
	/**
	 * @author rkrish38
	 * @throws IOException
	 */
	@TestDetails(author="Rahul")
	@Test(priority=4,description="TS_00007_The PDF display  for the user to download or view or print their enrollment form",groups="Provider") 
	public void testDownloadEnrollmentForm() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=4;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		EnrollmentSubmitted enrollmentSubmitted=beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit();
		enrollmentSubmitted.verifyEnrollmentFormIsDownloaded("EnrollmentPDF.pdf");
	}
	
	@TestDetails(author="Rahul")
	@Test(priority=4,description="US1033910-TS_00008_Upon selection of What is the ACH addendum record for link, a pop-up appears with information on ACH Addendum Record",groups="Provider") 
	public void testclickACHAddenfumRecrd() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);

		EnrollmentSubmitted enrollmentSubmitted=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinue().uploadW9().fillInfoAndClickSubmit();	
        enrollmentSubmitted.clickACHAddenfumRecrd();
	 }
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,description="US1033910-TS009/0010 Option displays to Exit Enrollment and When click on Exit Enrollment button Navigate  to EPS Landing page.",groups="Provider") 
	public void testVerifyExitEnrollemnt() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=4;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);

		EnrollmentSubmitted enrollmentSubmitted=beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit();
		enrollmentSubmitted.verifyExitEnrollemnt();
	}
	
	

	/**
	 * @author Avneet
	 * User story- US1048015
	 */

	@TestDetails(author="Avneet")
	@Test(priority=4,description="Verifies Header Links functionality",groups="Billing Service")
	public void testHeaderLinks()
	 {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.verifyAllHeaderLinks();
	 }
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS01_Enrolled_and_Active_BS_TIN",groups="Billing Service")
	void testEnrolledActiveBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyEnrolledActiveBSTIN();		
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS02_Enrolled_and_Active_BS_TIN_Details",groups="Billing Service")
	void testEnrolledActiveBSTINDetails()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyEnrolledActiveBSTINDetails();		
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS03_Enrolled_and_Active_BS_TIN_Sign_In_To_EPS_Option",groups="Billing Service")
	void testEnrolledActiveBSTINReturnToLogin()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyEnrolledActiveBSTINDetails().returnToLogin();		
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS04_Pre_Enrolled_BS_TIN",groups="Billing Service")
	void testPreEnrolledBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "PreEnrolledBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyPreEnrolledBSTIN();
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS05_Pre_Enrolled_BS_TIN_Sign_In_To_EPS_Option",groups="Billing Service")
	void testPreEnrolledBSTINReturnToLogin()throws IOException
	{
		int excelRowNo=2;
		String status = "PreEnrolledBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyPreEnrolledBSTIN().returnToLogin();
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS06_UXDS_HTML",groups="Billing Service")
	void testUXDSHTML()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyContentWithUXDSBS();	
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS07_Content_Managed",groups="Billing Service")
	void testContentManagedActiveBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyContentManagedForActiveBSTIN();
	}
	
	@TestDetails(author="Avneet")
	@Test(priority=3,description="US1048015_TS07_Content_Managed",groups="Billing Service")
	void testContentManagedPendingEnrollmentBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "PreEnrolledBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyContentManagedForPendingEnrollmentBSTIN();
	}
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0001_Validate the navigation upon selection of Continue from Organization Information page."
			+ "/TS_0004_Validate the error message when all the Secondary Admin fields are left empty."
			+ "/TS007-TS013/Validate the action upon clicking on Learn About Frequency/Clear Secondary Information Pop Up box and Yes and No button Functionality on these box"
			+ "TS022") 
	public void testAdministratorsPage() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().verifyAlertFrequencyPopUp().verifyClrInfo().clickYesOnClrInfoPopUp().verifyErrorOnContinueEnrlment();
	 }
	
	/*
	 * Below test case is failing as the design uploaded on UXDS is not updated with the current design on stage
	 * so while comparison it is getting failed.
	 */
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0002_Validate the layout of the Identify Administrators page.") 
	public void testAdministratorsPageUXDS() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().verifyContentWithUXDS();
	}
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0003_Validate the content of the Identify Administrators page.") 
	public void testAdministratorsPageContent() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().verifyPageContent();
	}
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0005_Validate the Mobile Phone Number field is mandatory or not If Send text alerts boxed is unchecked."
			+ "/TS_0006_Validate the Mobile Phone Number field is mandatory or not If Send text alerts boxed is checked.") 
	public void testAdministratorsPageMobileAlert() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().verifyMobileNoChckBoxfunctionality();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0014_Validate the navigation upon selection of Back button."
			+ "/TS015") 
	public void testAdministratorsPageContinuebtnErrors() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickBackBtn().clickContinueToProviderInfoPage().validateContinueButtonfunctionality();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0016_Validate the content of the Pop Up box upon click of Cancel Enrollment button."
			+ "/TS_0017_Validate the page navigation upon clicking No button on Cancel Popup.") 
	public void testAdministratorsPageCancelEnrlmnt() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().clickCancelEnrlmnt().clickNoCancelEnrlmnt();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0018_Validate the page navigation upon clicking Yes button on Cancel Popup.") 
	public void testAdministratorsPageCancelEnrlmntYesBtn() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().clickYesCancelEnrlmnt();
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS_0019_Validate the headers on Identify Administrator page for AO TIN."
	+"TS_0020_Validate the headers on Identify Administrator page for AV TIN."
	+"TS_0021_Validate the headers on Identify Administrator page for VO TIN.") 
	public void testAdministratorsPageHeaderVerification() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=1;
		for(;excelRowNo<=4;excelRowNo++)
		{
			if(excelRowNo==2)
				continue;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo();
			new HeaderContentValidation(testConfig).verifyHeaders("Identify Administrators");
		}
	 }
	
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1247779 -TS023-TS027/Validate error msgs when No data entered for Secondary Administrators FirstName/SecondName/Email/ReEmail/Telephone") 
	public void testSecondaryAdminInfo() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().validateSecondaryAdminFields("ScndProvFName", "").validateSecondaryAdminFields("ScndProvLName", "").validateSecondaryAdminFields("ScndProvPhnNo", "").validateSecondaryAdminFields("ScndProvEmail", "").validateSecondaryAdminFields("ScndProvReEmail", "");
	 }
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1064240 -TS01_Create Enrollment_BS_Identify Administrators page"
			+ "/TS02_Create Enrollment_BS_Identify Administrators page_Header") 
	public void testIdentifyAdminForBS() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo();//.fillPrimaryProvInfo();
		new HeaderContentValidation(testConfig).verifyHeaders("Identify Administrators");
	}
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1064240 -TS03_Create Enrollment_BS_Identify Administrators page_Existing Email"
			+ "/TS04_Create Enrollment_BS_Identify Administrators page_Existing Email_Association Grid"
			+ "TS05_Create Enrollment_BS_Identify Administrators page_Existing Email_Confirm User option/"
			+ "TS06_Create Enrollment_BS_Identify Administrators page_Existing Email_Confirm User option_Yes/"
			+ "TS07_Create Enrollment_BS_Identify Administrators page_Existing Email_Confirm User option_No/"
			+ "TS08_Create Enrollment_BS_Identify Administrators page_Existing Email_Primary only") 
	public void testIdentifyAdminExistingEmailForBS() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().verifyDupEmailError("Primary").verifyAssociatedTinsData().verifyNoBtnFunctionality().verifyDupEmailError("Primary").verifyYesBtnFunctionality();
	}
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1064240 -TS09_Create Enrollment_BS_Identify Administrators page_Existing Email_Secondary Only") 
	public void testIdentifyAdminExistingEmailSecForBS() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().verifyDupEmailError("Secondary");
	}
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1064240 -TS10_Create Enrollment_BS_Identify Administrators page_Existing Email_Primary and Secondary both") 
	public void testIdentifyAdminExistingEmailForBSBoth() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().verifyDupEmailError("");
	}
	/*
	 * TS012 - Not completed as the page layout does not match to that of production. Layout is not updated on UXDS design pages.
	 */
	
	@TestDetails(author="Amit")
	@Test(priority=4,groups="Provider",description="US1064240 -TS11_Create Enrollment_BS_Identify Administrators page_Existing Email_Confirm User option_No Response"
			+ "/TS13_Create Enrollment_BS_Content Managed") 
	public void testIdentifyAdminExistingEmailForBSContentManaged() throws IOException
	{
		String option="Health plan communication";
		int excelRowNo=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().verifyDupEmailError("").verifyIdentifyAdminDupEmailContentManaged(); 
	} 
	
	
	
	/**
	 * @author rkrish38
	 * @throws IOException
	 */
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",description="US1048076-TS001 Create Enrollment - Upload W9 - Billing Service")
	public void testUserEnrollmntAsBSNavigateToUpldW9page() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9();
		
	 }
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",description="US1048076-TS02_Create Enrollment_BS_Upload W9_Header")
	public void testUserEnrollmntAsBSvlDtHeader() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().verifyHeaders();
		
		
	 }
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",description="US1048076-TS03_Create Enrollment_BS_Upload W9_Cancel_Back_Submit buttons")
	public void testUserEnrollmntAsBSvlDtFooter() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().verifyFootersContent();
		
		
	 }
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",description="US1048076-TS04_Create Enrollment_BS_Upload W9_Back functionality")
	public void testUserEnrollmntAsBSBckToProvdr() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().verifyProvierAdmin();
		
		
	 }
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",description="US1048076-TS05_Create Enrollment_BS_Upload W9_Cancel Enrollment Popup/TS06_Create Enrollment_BS_Upload W9_Cancel Enrollment Popup_No")
	public void testUserEnrollmntAsBSClckCancEnrollNclckNo() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().verifyClckCancEnroll().verifyClckNo();
		
		
	 }
	
	@TestDetails(author="Rahul")	 
	@Test(priority=4,groups="Billing Service",description="US1048076-TS07_Create Enrollment_BS_Upload W9_Cancel Enrollment Popup_Yes")
	   public void testUserEnrollmntAsBSClickYes() throws IOException
		 {
			String option="Health plan communication";
			int excelRow=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().verifyClckYes();
			
		 }
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",description="US1048076-TS12_Create Enrollment_BS_Upload W9 page_FederalW9 link")
	   public void testUserEnrollmntAsBSClickFederalW9link() throws IOException
		 {
			String option="Health plan communication";
			int excelRow=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().verifyFederalW9link();
			
		 }
	
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",
	      description="US1177082_TS001_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Edit option and "
	      +"TS003_Create Enrollment_BS_Review and Submit - edit Billing Service Information page text is content managed"
			                    + "TS004_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Previously input data")
	   public void testUserEnrollmntAsBSClckReiewNSbmtEdit() throws IOException
		 {
			String option="Health plan communication";
			int excelRowBS=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowBS).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().clickEditLink().verifyUITextFromDBforBS();
			
			
		 }
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",
	      description="US1177082_TS002_Create Enrollment_BS_Review and Submit - edit Billing Service Information page content matches to UXDS html"
	      )
	   public void testUserEnrollmntAsBSClckUXDS() throws IOException
		 {
			String option="Health plan communication";
			int excelRowBS=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowBS).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().clickEditLink().verifyContentBSWithUXDS();
			
			
		 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",
		 description="US1177082_TS005_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Header")
	   public void testUserEnrollmntAsBSVerifyHeaders() throws IOException
		 {
			String option="Health plan communication";
			int excelRowBS=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowBS).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().clickEditLink();
			String BoldFontwthCircle="Billing Service Information";
			new HeaderContentValidation(testConfig).verifyHeaders(BoldFontwthCircle);
		}
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",
	      description="US1177082_TS006_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Edit option and "+
	    		                  "TS007_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Cancel Changes"
			                   )
	   public void testUserEnrollmntAsBSVerifyFootButton() throws IOException
		 {
			String option="Health plan communication";
			int excelRowBS=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowBS).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().clickEditLink().verifyFooterButton();
			
			
		 }
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",
	      description="US1177082_TS010_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Error message_Billing Service Name_Street_City_State_Zip_Missing Data "
			                   )
	   public void testUserEnrollmntAsBSverifyErrorMsg() throws IOException
		 {
			String option="Health plan communication";
			int excelRowBS=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowBS).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().clickEditLink().verifyErrorMsgNull();
			
			
		 }

	//
	

	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",
	      description="US1177082_TS011_TS012_TS013_TS014_TS016_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Error message_Billing Service Name_Street_City_State_Zip_Missing Data "
			                   )
	   public void testUserEnrollmntAsBSverifySpecChar() throws IOException
		 {
			String option="Health plan communication";
			int excelRowBS=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowBS).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().clickEditLink().validateBillingService("BSName", "&*min","SAVE CHANGES").validateBillingService("Street", "*(*(*","SAVE CHANGES").validateBillingService("Street", "PO BOX 7530","SAVE CHANGES").validateBillingService("City", "%^&&","SAVE CHANGES").validateBillingService("ZipCode", "anjhu123","SAVE CHANGES").validateBillingService("ZipCode", "70165","SAVE CHANGES");
			
			
		 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Billing Service",
	      description="US1177082_TS015_Create Enrollment_BS_Review and Submit - edit Billing Service Information_Error message_Billing Service Name_Street_City_State_Zip_Missing Data "
			                   )
	
	   public void testUserEnrollmntAsBSClckOnSavChng() throws IOException
		 {
			String option="Health plan communication";
			int excelRowBS=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRowBS).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().clickEditLink().fillProviderOrgInfo();
			
			
		 }
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0028_Validate the error message when non numeric data entered for Secondary Administrator Telephone Number."+
							"TS_0029_Validate the error message when not complete data entered for Secondary Administrator Telephone Number.") 
	public void testValidateErrMsg() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillInvalidProvInfo("Secondary","Incomplete").fillInvalidProvInfo("Secondary","nonNumeric");	
		
	 }
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0030_Validate the error message when data entered in not proper format for Secondary Administrator Email Address.") 
	public void testValidateEmailErr() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillProvInfoWrngEmail("Secondary","inpFormatOne").fillProvInfoWrngEmail("Secondary","inpFormatTwo").fillProvInfoWrngEmail("Secondary","inpFormatThree");	
		
	 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0031_Validate the error message when data entered for Secondary Administrator Email Address does not match email address.") 
	public void testValidateCompEmail() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillProvMailComp("Secondary");	
		
	 }
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0032_Validate the error message when alphanumeric data entered for Secondary Administrator First Name."+
							"TS_0034_Validate the error message when alphanumeric data entered for Secondary Administrator Middle Name."+
			"TS_0036_Validate the error message when alphanumeric data entered for Secondary Administrator Last Name.") 
	public void testValidateErrMsgNames() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillProvInfoName("Secondary","First Name",Helper.generateRandomAlphaNumericString(5)).fillProvInfoName("Secondary","Middle Name",Helper.generateRandomAlphaNumericString(5)).fillProvInfoName("Secondary","Last Name",Helper.generateRandomAlphaNumericString(5));	
		
	 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0033_Validate the error message when special characters entered for Secondary Administrator First Name."+
							"TS_0035_Validate the error message when special characters entered for Secondary Administrator Middle Name."+
			"TS_0037_Validate the error message when special characters entered for Secondary Administrator Last Name.") 
	public void testValidateSecSpCharErrMsgNames() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillProvInfoName("Secondary","First Name","&*min").fillProvInfoName("Secondary","Middle Name", "*(*(*").fillProvInfoName("Secondary","Last Name", "%^&&");	
		
	 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0040_Validate the error message when no data entered for Primary Administrator First Name."+
										"TS_0041_Validate the error message when no data entered for Primary Administrator Last Name."+
										"TS_0042_Validate the error message when no data entered for Primary Administrator Telephone Number."+
										"TS_0043_Validate the error message when no data entered for Primary Administrator Email Address."+
										"TS_0044_Validate the error message when no data entered for Primary Administrator Re-type Email Address."
														) 
	public void testValidateWthBlnkData() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().
																				fillPrimaryNoDataProvInfo("First Name").
																				fillPrimaryNoDataProvInfo("Last Name").
																				fillPrimaryNoDataProvInfo("Email Address").
																				fillPrimaryNoDataProvInfo("ReType Email Address").
																				fillPrimaryNoDataProvInfo("Telephone No");	
		
	 }
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0045_Validate the error message when non numeric data entered for Secondary Administrator Telephone Number."+
							"TS_0046_Validate the error message when not complete data entered for Secondary Administrator Telephone Number.") 
	public void testValidatePrmErrMsg() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		//beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillInvalidPrmryProvInfo();	
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillInvalidProvInfo("Primary","Incomplete").fillInvalidProvInfo("Primary","nonNumeric");	

		
	 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0047_Validate the error message when data entered in not proper format for Primary Administrator Email Address.") 
	public void testValidatePrmryEmailErr() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillProvInfoWrngEmail("Primary","inpFormatOne").fillProvInfoWrngEmail("Primary","inpFormatTwo").fillProvInfoWrngEmail("Primary","inpFormatThree");
	 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0048_Validate the error message when data entered for Primary Administrator Email Address does not match email address.") 
	public void testValidateSecProvEmailComp() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().fillProvMailComp("Primary");	
		
	 }
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0049_Validate the error message when alphanumeric data entered for Primary Administrator First Name."+
							"TS_0051_Validate the error message when alphanumeric data entered for Primary Administrator Middle Name."+
							"TS_0053_Validate the error message when alphanumeric data entered for Primary Administrator Last Name.") 
	public void testValidateErrMsgFirstNames() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillProvInfoName("Primary","First Name",Helper.generateRandomAlphaNumericString(5)).fillProvInfoName("Primary","Middle Name",Helper.generateRandomAlphaNumericString(5)).fillProvInfoName("Primary","Last Name",Helper.generateRandomAlphaNumericString(5));
	 }
	
	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0050_Validate the error message when special characters entered for Primary Administrator First Name."+
							"TS_0052_Validate the error message when special characters entered for Primary Administrator Middle Name."+
			"TS_0054_Validate the error message when special characters entered for Primary Administrator Last Name.") 
	public void testValidatePrmrySpCharErrMsgNames() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillProvInfoName("Primary","First Name","&*min").fillProvInfoName("Primary","Middle Name", "*(*(*").fillProvInfoName("Primary","Last Name", "%^&&");
	 }

	
	@TestDetails(author="Rahul")
	@Test(priority=4,groups="Create Enrollment",description="US1247779_TS_0055_Validate the error message when non numeric data entered for Secondary Administrator Telephone Number.")
							 
	public void testValidateButtons() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().valiDateButtons();	
		
	 }
	
	
	/**
	 * @author umadhavi
	 * @throws IOException
	 */
	
	@TestDetails(author="Madhavi")
	@Test(priority=4,groups="Billing Service",description="US1350550-TS_0001_Validate the page upon selection of Continue from the Enrollment Type page for not enrolled TIN.")
	   public void validatePageForTinNotEnrolled() throws IOException
		 {
			String option="Health plan communication";
			int excelRow=2;
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
			BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
			beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().verifyTINStatus();
		 }
	
	
	@TestDetails(author="Madhavi")
	@Test(priority=3,description="US1350550-TS_0003_Validate the layout of the Congratulations, your TIN is eligible for enrollment page.",groups="Billing Service")
	void validateLayoutForInactiveEnrolledTin() throws IOException
	{
		int excelRowNo=2;
		String status = "InactiveUnBlockedTIN";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus().verifyContentTinEligibleBSWithUXDS();	
	}
	
	@TestDetails(author="Madhavi")
	@Test(priority=3,description="US1350550-TS_0004_Validate the content of the Congratulations, your TIN is eligible for enrollment page.",groups="Billing Service")
	void validateContentForInactiveEnrolledTin() throws IOException
	{
		int excelRowNo=2;
		String status = "InactiveUnBlockedTIN";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus().verifyContentManagedForTinNotEnrolledBS();	
	}
	
	@TestDetails(author="Madhavi")
	@Test(priority=3,description="US1350550-TS_0005_Validate the page navigation upon clicking This link.",groups="Billing Service")
	void validatePageNavigationThisLink() throws IOException
	{
		int excelRowNo=2;
		String status = "InactiveUnBlockedTIN";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus().verifyW9Form();		
	}
	
	@TestDetails(author="Madhavi")
	@Test(priority=3,description="US1350550-TS_0008/TS_0009",groups="Billing Service")
	void validatePopUpCancelBSEnrollmentAsNo() throws IOException
	{
		int excelRowNo=2;
		String status = "InactiveUnBlockedTIN";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus().verifyCancelAndContinueBtn().clickCancel().confirmCancelNo().clickCancel().confirmCancelYes();		
	}

	@TestDetails(author="Madhavi")
	@Test(priority=3,description="US1350550-TS_002/TS_006/TS_007")
	void validateBSEnrollment() throws IOException
	{
		int excelRowNo=2;
		String status = "InactiveUnBlockedTIN";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus().verifyCancelAndContinueBtn().clickCancel().verifyBSNotEnrolledBtnCancelPopup();	
	}
	
}
