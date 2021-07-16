
package main.java.stepDefinitions.CrtEnrolmnt;

import java.io.IOException;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Runner.DemoTestNGRunner;
import main.java.Utils.Helper;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.Footer;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;


public class ProviderEFTERAEnrollPageSteps extends TestBase {

	
	String option="Health plan communication";
	int excelRow=1;
	UPARegistrationPage registrationPage=null;
	BeginEnrollment beginEnrollmentPage=null;
	
	ValidateEnrollmentTypePage validateEnrollmentTypePage=null;
	ValidateEFTERAProviderInfo validateEFTERAProviderInfo=null;
	ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	BeginEnrollmentContinue beginEnrollmentContinuePage=null;
	FinancialInstitutionInfoPage financialInstitutionInfoPage=null;
	
	@Then("^Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page$")
	public void select_Enrollment_Type_and_Clicks_Continue_button_of_Enrollment_TIN_Eligible_page (DataTable table) throws Throwable {
	   
		
		 beginEnrollmentContinuePage=new BeginEnrollmentContinue(testConfig);
		List<List<String>> EnrolmntTyps = table.raw();
		String EnrolmntTyp=EnrolmntTyps.get(1).get(0);
		if (EnrolmntTyp.equals("AO"))
		excelRow=1;
		else if (EnrolmntTyp.equals("BS"))
		excelRow=2;
		else if (EnrolmntTyp.equals("AV"))
		excelRow=3;
		else if (EnrolmntTyp.equals("VO"))
		excelRow=4;
		providerEFTERAEnrollPage=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue();
	}
	
	@Then("^user selects as \"(.*)\" and  Clicks continue button of Enrollment TIN Eligible page$")
	public void select_Enrollment_Type_as_and_Clicks_Continue_button_of_Enrollment_TIN_Eligible_page (String  EnrolmntTyp) throws Throwable {
		beginEnrollmentContinuePage=new BeginEnrollmentContinue(testConfig);
		if (EnrolmntTyp.equals("AO"))
		excelRow=1;
		else if (EnrolmntTyp.equals("BS"))
		excelRow=2;
		else if (EnrolmntTyp.equals("AV"))
		excelRow=3;
		else if (EnrolmntTyp.equals("VO"))
		excelRow=4;
		providerEFTERAEnrollPage=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue();
	}
	
	@Then("^User sets business phone$")
	public void user_set_valid_business_phone() {	
		System.setProperty("BusinessPhone1", Long.toString(Helper.generateRandomNumber(3)));
		System.setProperty("BusinessPhone2", Long.toString(Helper.generateRandomNumber(3)));
		System.setProperty("BusinessPhone3", Long.toString(Helper.generateRandomNumber(4)));
		System.setProperty("BusinessPhoneExt", Long.toString(Helper.generateRandomNumber(5)));
	}
	
	@Then("^User sets invalid business phone \"([^\"]*)\"$")
	public void user_set_invalid_business_phone(String stringFormat) {
		if(stringFormat.equals("AlphaNumericString")) {
		System.setProperty("BusinessPhone1", Helper.generateRandomAlphaNumericString(3));
		System.setProperty("BusinessPhone2", Helper.generateRandomAlphaNumericString(3));
		System.setProperty("BusinessPhone3", Helper.generateRandomAlphaNumericString(4));
		System.setProperty("BusinessPhoneExt", Helper.generateRandomAlphaNumericString(5));
		}else if(stringFormat.equals("SpecialCharacters")) {
			System.setProperty("BusinessPhone1", Helper.generateRandomSpecialCharacterString(3));
			System.setProperty("BusinessPhone2", Helper.generateRandomSpecialCharacterString(3));
			System.setProperty("BusinessPhone3", Helper.generateRandomSpecialCharacterString(4));
			System.setProperty("BusinessPhoneExt",Helper.generateRandomSpecialCharacterString(5));
		}
	}

	
	@Then("^User fills all the information  and click on Continue$")
	public void user_fills_all_the_information_and_click_on_Continue() throws Throwable {
		ProviderEFTERAEnrollPage providerEFTERAEnrollPage=new ProviderEFTERAEnrollPage(testConfig);
		validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfo();
	    
	}
	
	@Then("^User validate error messages$")
	public void user_validate_error_msg() {
		ProviderEFTERAEnrollPage providerEFTERAEnrollPage=new ProviderEFTERAEnrollPage(testConfig);
		providerEFTERAEnrollPage.verifyBusinesPhoneErrorMsg();
		
	}

	
	@Then("^User fills all the Organization information along with Business Phone \"(.*)\" and click on Continue$")
	public void user_fills_all_the_Orginformation_and_click_on_Continue(String businessPhone) throws Throwable {
		ProviderEFTERAEnrollPage providerEFTERAEnrollPage=new ProviderEFTERAEnrollPage(testConfig);
		validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfo();
	    
	}
	
	
	@Then("^User navigates to Billing service information page and fill all fields and click on continue button$")
	public void user_navigates_to_Billing_service_information_page_and_fill_all_fields_and_click_on_continue_button() throws Throwable {
		ProviderInformationEFTERAEnroll	providerInformationEFTERAEnroll=new ProviderInformationEFTERAEnroll(testConfig);
		validateEFTERAProviderInfo=providerInformationEFTERAEnroll.fillProviderOrgInfo();
	}
	@Then("^Validate the Footer Information on this page$")
    public void validate_the_Footer_Information() throws Throwable {
       	new Footer(testConfig).validateFooterContents(testConfig);
    }


	@Then("^Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page and Validate TIN enrolled message$")
	public void select_Enrollment_Type_and_Clicks_continue_button_of_Enrollment_TIN_Eligible_page_and_Validate_TIN_enrolled_message(DataTable table) throws Throwable {
		beginEnrollmentContinuePage=new BeginEnrollmentContinue(testConfig);
		List<List<String>> EnrolmntTyps = table.raw();
		String EnrolmntTyp=EnrolmntTyps.get(1).get(0);
		if (EnrolmntTyp.equals("AO"))
		excelRow=1;
		else if (EnrolmntTyp.equals("BS"))
		excelRow=2;
		else if (EnrolmntTyp.equals("AV"))
		excelRow=3;
		else if (EnrolmntTyp.equals("VO"))
		excelRow=4;
		new BeginEnrollmentContinue(testConfig).enrollAs(excelRow).clickContinue().verifyTINStatus();
	}

	@Then("^Select \"([^\"]*)\" and \"([^\"]*)\" clicks Continue button and verify enrolledTIN Message and its content from DB$")
	public void select_and_clicks_Continue_button_and_verify_enrolledTIN_Message_and_its_content_from_DB(String EnrollmentType, String TINStatus) throws Throwable {

		if (EnrollmentType.equals("AO"))
		excelRow=1;
		else if (EnrollmentType.equals("BS"))
		excelRow=2;
		else if (EnrollmentType.equals("AV"))
		excelRow=3;
		else if (EnrollmentType.equals("VO"))
		excelRow=4;
		new BeginEnrollmentContinue(testConfig).getTin(excelRow, TINStatus).clickContinue().verifyTINStatus().verifyContentManagedForTinNotEnrolledBS();
	}

	@Then("^Select \"([^\"]*)\" and \"([^\"]*)\" clicks Continue button$")
	public void select_and_clicks_Continue_button(String arg1, String arg2) throws Throwable {

	}

	@Then("^User clicks and validates wNineform link of this page$")
	public void user_clicks_and_validates_wNineform_link_of_this_page() throws Throwable {
		new ValidateEnrollmentTypePage(testConfig).verifyW9Form();
	}

	@Then("^User validates Cancel Enrollment and Continue button presence$")
	public void user_validates_Cancel_Enrollment_and_Continue_button_presence() throws Throwable {
		new ValidateEnrollmentTypePage(testConfig).verifyCancelAndContinueBtn();

	}

	@When("^User clicks on Cancel Enromment button,verify its popup content and also YES/NO button functionality$")
	public void user_clicks_on_Cancel_Enromment_button_verify_its_popup_content_and_also_YES_NO_button_functionality() throws Throwable {
		new ValidateEnrollmentTypePage(testConfig).clickCancel().verifyBSNotEnrolledBtnCancelPopup().confirmCancelNo().clickCancel().confirmCancelYes();

	}

	@Then("^User Validates Save changes and Cancel Changes button presence and its functionality$")
	public void user_Validates_Save_changes_and_Cancel_Changes_button_presence_and_its_functionality() throws Throwable {
		new ProviderInformationEFTERAEnroll(testConfig).verifyFooterButton();
	}

	@Then("^Select \"([^\"]*)\" and \"([^\"]*)\" Clicks continue button of Enrollment TIN Eligible page and vaidate enrolledTINMsg$")
	public void select_and_Clicks_continue_button_of_Enrollment_TIN_Eligible_page_and_vaidate_enrolledTINMsg(String EnrollmentType, String TINStatus) throws Throwable {
		if (EnrollmentType.equals("AO"))
		excelRow=1;
		else if (EnrollmentType.equals("BS"))
		excelRow=2;
		else if (EnrollmentType.equals("AV"))
		excelRow=3;
		else if (EnrollmentType.equals("VO"))
		excelRow=4;
		new BeginEnrollmentContinue(testConfig).getTin(excelRow, TINStatus).clickContinue();
		if (TINStatus.equals("EnrolledPreEnrollmentStatusTIN"))
			new ValidateEnrollmentTypePage(testConfig).verifyEnrolledPreEnrollmentStatusTIN();
		if (TINStatus.equals("AutoEnrolledPreEnrollmentStatusTIN"))
			new ValidateEnrollmentTypePage(testConfig).verifyAutoEnrolledPreEnrollmentStatusTIN();
		if (TINStatus.equals("EnrolledInactiveAndBlockStatusTIN"))
			new ValidateEnrollmentTypePage(testConfig).verifyEnrolledInactiveAndBlockStatusTIN();
		if (TINStatus.equals("EnrolledActiveStatusTIN"))
			new ValidateEnrollmentTypePage(testConfig).verifyEnrolledActiveStatusTIN();
		if (TINStatus.equals("TINNotEnrolled") || TINStatus.equals("InactiveUnBlockedTIN"))
			new ValidateEnrollmentTypePage(testConfig).verifyTINStatus();
	}

	@Then("^Select \"([^\"]*)\" and \"([^\"]*)\",Clicks Cancel Enrollment verify text content,the click NO to be on the same page and Yes to Cancel the Enrollment$")
	public void select_and_Clicks_Cancel_Enrollment_verify_text_content_the_click_NO_to_be_on_the_same_page_and_Yes_to_Cancel_the_Enrollment(String EnrollmentType, String TINStatus) throws Throwable {
		if (EnrollmentType.equals("AO"))
		excelRow=1;
		else if (EnrollmentType.equals("BS"))
		excelRow=2;
		else if (EnrollmentType.equals("AV"))
		excelRow=3;
		else if (EnrollmentType.equals("VO"))
		excelRow=4;
		new BeginEnrollmentContinue(testConfig).getTin(excelRow, TINStatus).clickContinue().clickCancel().verifyBtnCancelPopup().confirmCancelNo().clickCancel().verifyBtnCancelPopup().confirmCancelYes();
	}

	@Then("^Select \"([^\"]*)\" and \"([^\"]*)\" then Clicks continue then,clicks on W(\\d+) form link on next page$")
	public void select_and_then_Clicks_continue_then_clicks_on_W_form_link_on_next_page(String EnrollmentType, String TINStatus, int arg3) throws Throwable {
		if (EnrollmentType.equals("AO"))
		excelRow=1;
		else if (EnrollmentType.equals("BS"))
		excelRow=2;
		else if (EnrollmentType.equals("AV"))
		excelRow=3;
		else if (EnrollmentType.equals("VO"))
		excelRow=4;
		new BeginEnrollmentContinue(testConfig).getTin(excelRow, TINStatus).clickContinue().verifyW9Form();
	}

	@Then("^Select \"([^\"]*)\" and \"([^\"]*)\" clicks Continue button and vaidate enrolledTIN Message and its content from DB$")
	public void select_and_clicks_Continue_button_and_vaidate_enrolledTIN_Message_and_its_content_from_DB(String EnrollmentType, String TINStatus) throws Throwable {
	if (EnrollmentType.equals("BS"))
			excelRow=2;
	new BeginEnrollmentContinue(testConfig).getBSTin(excelRow, TINStatus).clickContinue();
	if (TINStatus.equals("PreEnrolledBSTIN"))
		new ValidateEnrollmentTypePage(testConfig).verifyEnrolledPreEnrollmentStatusTIN();
	if (TINStatus.equals("EnrolledActiveBSTIN"))
		new ValidateEnrollmentTypePage(testConfig).verifyEnrolledActiveBSTIN();
	}

	@Then("^User fills the auto populated information for BusinessNameAddress and click on Continue$")
	public void user_fills_auto_populated_information_and_click_on_Continue() throws Throwable {
		ProviderEFTERAEnrollPage providerEFTERAEnrollPage=new ProviderEFTERAEnrollPage(testConfig);
		validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfoWithAutoPopulatedInfo();
	    
	}
}
