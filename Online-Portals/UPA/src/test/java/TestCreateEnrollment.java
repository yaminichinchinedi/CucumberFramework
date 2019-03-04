package test.java;

import java.io.IOException;

import org.testng.annotations.Test;

import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.BenefitsOfEPS;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.HowToEnroll;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.reporting.Log;

public class TestCreateEnrollment extends TestBase{
	
	
	@Test(priority=4,description="US1348562--TS004 Validates Page text is content Managed.")
	public void testPageContent() throws IOException
	 {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.clickEnrollNow().verifyPageContent();
	 }
	
	
	/**
	 * This test case belong to US1348529
	 * @author Amit
	 */
	@Test(priority=4,description="US1348529--TS001/TS002 Validates the Page navigation from BeginEnrollment page to BeginEnrollmentContinue page")
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
	
	@Test(priority=4,description="US1202167--TS001/TS002/TS018/TS023 Validates User Enrollment As Health Organisation") 
	public void testUserEnrollmentAsHealthOrg() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinue().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();
	 }
	
	@Test(priority=4,description="US1202167--TS003 Validates User Enrollment As BS")
	public void testUserEnrollmentAsBS() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();
	 }
	

	@Test(priority=4,description="US1202167--TS004/TS005/TS006/TS015 Validates what shall i choose after Selecting Health Org /TS005 Validates Pop Up after clicking Close link")
	public void testPopUpAfterChoosingHealthOrg() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyChooseLink();
	 }
	
	@Test(priority=4,description="US1202167--TS007/TS016/TS017 Validates Page after clicking on change link")
	public void testChangeLinkFunctionality() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyChangeLink();
	 }
	
	@Test(priority=4,description="US1202167--TS008 + TS009 =Validates navigation upon selection of VCP and healthOrg/TS009 Validates navigation upon clicking Cancel on VCP PopUp Box")
	public void testChooseVCP() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyPopUp("VO");
	 }

	@Test(priority=4,description="US1202167--TS010 Validates navigation upon selection of I agree option on VCP pop up ")
	public void testEnrollAsVCP() throws IOException
	 {
		String option="Health plan communication";
		int excelRowNo=4;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueToW9().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();
		
	 }
	
	@Test(priority=4,description="US1202167--TS011/TS014 Validates navigation upon selection of I agree option on ACH and VCP pop up")
	public void testEnrollAsVCPandACH() throws IOException
	 {
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinueAV().clickContinue().uploadW9().fillInfoAndClickSubmit().validateEnrollmentInfo();	
	 }

	@Test(priority=4,description="US1202167--TS012/TS013 Validates navigation upon clicking Cancel on VCP PopUp Box")
	public void testChooseVCPandACH() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		beginEnrollmentPage.selectHowYouHeard(option).verifyPopUp("AV");
	 }
	
	@Test(priority=4,description="US1202167--TS020/TS021/TS022 Validates Content of PopUp upon clicking Cancel Button")
	public void testCancelEnrollmentPopUp() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).verifyCancelEnrollmentFunctionality();
	 }
	
	@Test(priority=4,description="US1202167--TS024-TS026 Validates errors messages displayed on various TIN combinations")
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
	
	@Test(priority=3,description="US1351123- [1]TS_00003_Page text is content managed + TS_00004_Field label changes display Business Name and Business Address. + TS_00005_Messaging on page indicates not to enter special characters. + TS_00006_Header displays - For AO .+ TS_00009_To Validate Cancel Enrollment and Continue options display." )
	public void testPageContextFromDB()throws IOException
	{
		int excelRowNo=1;
			
	    UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyOrgInfoHeaders().verifyUITextFromDB();
			
	}
		
	@Test(priority=3,description="US1351123- TS_00009_To Validate Cancel Enrollment and Continue options display.+ TS_00010_To Validate Cancel Enrollment and Continue options display. + TS_00011_ Validate  Upon selection of No, popup box closes and user is back on Organization Information page.. + TS_00012_ Validate Upon selection of Yes, user is returned to the EPS Landing page." )
	public void testCancelEnrollment()throws IOException
	{
		int excelRowNo=1;
			
	    UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyCancelEnrollmentFlow();
			
	}
		
		
	@Test(priority=3,description="US1351123 - TS_00009_To Validate Cancel Enrollment and Continue options display.+ TS_00010_To Validate Cancel Enrollment and Continue options display. + TS_00011_ Validate  Upon selection of No, popup box closes and user is back on Organization Information page.. + TS_00012_ Validate Upon selection of Yes, user is returned to the EPS Landing page.+TS_00013,14 and 15,17" )
	public void testContinueEnrollment()throws IOException
	{
		int excelRowNo=1;
			
	    UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyContinueEnrollmentValidations();
			
	}
		
	@Test(priority=3,description="US1351123-TS_00018_Missing and invalid field validation for Business Name (special characters)" )
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
	
	@Test(priority=3,description="US1351172 -  TS007,TS009- Verifies validation message if an existing email is used for new enrollment For Primary Prov")
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
	
	@Test(priority=3,description="US1351172 -TS008 validation message if an existing email is used for new enrollment For Primary Prov")
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
	
	@Test(priority=3,description="US1351172 -TS007-Verifies validation message if an existing email is used for new enrollment For Secondary Prov")
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
	
	
	@Test(priority=3,description="US1351172 -TS008-Verifies validation message if an existing email is used for new enrollment For Secondary Prov")
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
	
	@Test(priority=3,description="US1351172 -TS013 - Verifies validation message if an existing email is used for new enrollment For Secondary Prov")
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
	
	@Test(priority=3,description="US1350108_TS01_TIN does not exist on EPS")
	void testTINNotEnrolled()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo,status).clickContinue().verifyTINStatus();
		
	}

	@Test(priority=3,description="US1350108_TS02_TIN exists Inactive and not blocked")
	void testInactiveUnBlockedTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "InactiveUnBlockedTIN";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();			
	}

	@Test(priority=3,description="US1350108_TS03_TIN does not exists on EPS_AO")
	void testTINNotEnrolledAO()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();		
	}

	@Test(priority=3,description="US1350108_TS04_TIN does not exists on EPS_AV")
	void testTINNotEnrolledVO()throws IOException
	{
		int excelRowNo=4;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();				
	}

	@Test(priority=3,description="US1350108_TS05_TIN does not exists on EPS_VO")
	void testTINNotEnrolledAV()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyTINStatus();			
	}

	@Test(priority=3,description="US1350108_TS06_Content Managed")
	void testContentManaged()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyContentManaged();	
	}

	@Test(priority=3,description="US1350108_TS07_UXDS match")
	void testUXDSMatch()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyContentWithUXDS();	
	}

	@Test(priority=3,description="US1350108_TS08_Blank W9")        // Need to check on this
	void testW9Form()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyW9Form();	
	}

	@Test(priority=3,description="US1350108_TS09_Cancel and Continue Enabled")
	void testCancelAndContinueBtn()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyCancelAndContinueBtn();
	}

	@Test(priority=3,description="US1350108_TS10_Cancel Enrollment_Popup")
	void testBtnCancelPopUp()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().clickCancel().verifyBtnCancelPopup();				
	}

	@Test(priority=3,description="US1350108_TS11_Cancel Enrollment_No")
	void testBtnCancelPopUpClickNo()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().clickCancel().verifyBtnCancelPopup().confirmCancelNo().verifyTINStatus();
	}

	@Test(priority=3,description="US1350108_TS12_Cancel Enrollment_Yes")
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
	 * @author p1058:Avneet
	 * @throws IOException
	 */
	
	@Test(priority=3,description="US1023501_TS01_Enrolled and Active Status TIN")
	void testEnrolledActiveStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledActiveStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledActiveStatusTIN();	
	}
	
	@Test(priority=3,description="US1023501_TS02_Enrolled and Pre-Enrollment Status TIN")
	void testEnrolledPreEnrollmentStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledPreEnrollmentStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledPreEnrollmentStatusTIN();			
	}
	
	@Test(priority=3,description="US1023501_TS03_Auto Enrolled and in Pre-Enrollment Status TIN")
	void testAutoEnrolledPreEnrollmentStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "AutoEnrolledPreEnrollmentStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyAutoEnrolledPreEnrollmentStatusTIN();	
	}
	
	@Test(priority=3,description="US1023501_TS04_Enrolled and Inactive/Block Status TIN")
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
	
	@Test(priority=3,description="US1348562 - TS_00001 - Upon selection of  Enroll Now button click navigates user to Before you begin enrollment page")
	public void testBeforeYouBeginEnrollmentPage()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateBeginEnrollment();
	}
	
	
	// TC_0007 is covered with this
	@Test(priority=3,description="US1348562 - TS_00002 - Enroll Now  button from How to Enroll Page navigates user to  Before you begin enrollment  page")
	public void testHowToEnrollLink()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		HowToEnroll howToEnroll = upaRegistrationPage.clickHowToEnrollLink();
		BeginEnrollment beginEnrollment = howToEnroll.validateEnrollNowBtn();
		beginEnrollment.validateBeginEnrollment();
	}
	
	@Test(priority=3,description="US1348562 - TS_00006 - Benefits of EPS link on page navigates user to the Benefits of EPS page.")
	public void testValidateBenefitsOfEPSLink()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BenefitsOfEPS benefitsOfEPS = upaRegistrationPage.clickBenefitsOfEPSLink();		
	}
	
	// TC_0009 is already covered and standard step for each test case.
	
	@Test(priority=3,description="US1348562 - TS_00010 - To Validate If user does not select an option and clicks continue , error message is displayed  below the radio buttons.")
	public void testBeginEnrollmentErrorValidation()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinue = beginEnrollment.clickContinue();
		beginEnrollmentContinue.validateErrorMsgs();		
	}
	
	//TC_00012 is also covered with this
	@Test(priority=3,description="US1348562 - TS_00011 - the error message  if user selects Other without entering text and clicks continue")
	public void testBeginEnrollmentOtherRadioSelectedErrorValidation()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinue = beginEnrollment.selectOtherToValidateErrorMessage();
		beginEnrollmentContinue.validateErrorMsgs();		
	}
	
	//Add TC0015 in below 
	@Test(priority=3,description="US1348562 - TS_00013 - the limit of characters to be entered for the Text box, [Max limit 50]")
	public void testBeginEnrollmentValidateLmtOfChars()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateTextBoxCharLmt();
	}
	
	@Test(priority=3,description="US1348562 - TS_00014 - The Pop up message on click of Cancel Enrollment Button.")
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
	
	@Test(priority=3,description="US1348562 - TS_00005 - Q and A are obtained from active entries in Survey Table (responses appear in appropriate order")
	public void testBeginEnrollmentQuestions() throws IOException
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateBeginEnrollmentQuestions();
	}
	
	/**
	 * @author rkrish38
	 * @throws IOException
	 */
	
	@Test(priority=4,description="US1033480--TS01-Create Enrollment Provider Footer Display")
	public void testFooterContents() throws IOException
	 {
		String option="Health plan communication";
		TestFooter testfooter=new TestFooter();
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		testfooter.validateFooterContents(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		testfooter.validateFooterContents(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		testfooter.validateFooterContents(testConfig);
		
		
			ValidateEnrollmentTypePage ValidateenrollmentTypePage=beginEnrollmentContinuePage.enrollAs(1).clickContinue();
			testfooter.validateFooterContents(testConfig);
			ProviderEFTERAEnrollPage providerEFTERAEnrollPage=ValidateenrollmentTypePage.clickContinue();
			testfooter.validateFooterContents(testConfig);
			ValidateEFTERAProviderInfo validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfo().fillPrimaryProvInfo();
			testfooter.validateFooterContents(testConfig);
			FinancialInstitutionInfoPage financialInstitutionInfoPage=validateEFTERAProviderInfo.clickContinue().fillFinancialInstInfo();
			testfooter.validateFooterContents(testConfig);
		
	 }
		
}
