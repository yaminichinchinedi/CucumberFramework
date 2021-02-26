package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.And;
import main.java.Utils.Helper;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HeaderContentValidation;

import java.io.IOException;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.Footer;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;
import main.java.pageObjects.ReviewAndSubmit;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.UploadW9;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;

public class ValidateEFTERAProviderInfoSteps extends TestBase {
	String option = "Health plan communication";
	int excelRow = 0;
	ValidateEFTERAProviderInfo valdtEFETRAProvInfo = new ValidateEFTERAProviderInfo(testConfig);

	@Then("^User fills all the information on Identify Administrators page and click continue$")
	public void user_fills_all_the_information_on_Identify_Administrators_page_and_click_continue() throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickContinue();
	}

	@And("^Validate the Identify Admin fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page\\.$")
	public void validate_the_Identify_Admin_fields_are_editable_and_SAVA_CHANGES_and_CANCEL_CHANGES_button_are_present_on_page()
			throws Throwable {
		valdtEFETRAProvInfo.verifyEditables().verifyCanclSaveBtn();
	}

	@Then("^User Check if Mobile number field is mandatory if check box is enabled\\.$")
	public void user_Check_if_Mobile_number_field_is_mandatory_if_check_box_is_enabled() throws Throwable {
		valdtEFETRAProvInfo.verifyMobileNoChckBoxfunctionality();
	}

	@Then("^User Clicks Cancel Changes button On Identify Admin Page\\.$")
	public void user_Clicks_Cancel_Changes_button_On_Identify_Admin_Page() throws Throwable {
		valdtEFETRAProvInfo.clickCanclChngBtn();
	}

	@Then("^User click on Learn About Alert Frequency Link\\.$")
	public void user_click_on_Learn_About_Alert_Frequency_Link() throws Throwable {
		valdtEFETRAProvInfo.verifyAlertFrequencyPopUp();
	}

	@And("^Validate the Headers on Identify Admin Page\\.$")
	public void validate_the_Headers_on_Identify_Admin_Page() throws Throwable {
		new HeaderContentValidation(testConfig).verifyHeaders("Identify Administrators");
	}

	@And("^Fill Administrator Info and Verify error msgs for Primary Contacts\\.$")
	public void fill_Administrator_Info_and_Verify_error_msgs_for_Primary_Contacts() throws Throwable {
		valdtEFETRAProvInfo.validateAdminInfoFields("FrstProvFName", "")
				.validateAdminInfoFields("FrstProvFName", "kino&*&*").validateAdminInfoFields("FrstProvLName", "")
				.validateAdminInfoFields("FrstProvLName", "yamato^&^&").validateAdminInfoFields("FrstProvMName", "&")
				.validateAdminInfoFields("FrstProvMName", "9").validateAdminInfoFields("FrstProvPhnNo", "")
				.validateAdminInfoFields("FrstProvPhnNo", "47").validateAdminInfoFields("FrstProvPhnNo", "a89b")
				.validateAdminInfoFields("FrstProvEmail", "").validateAdminInfoFields("FrstProvReEmail", "");
				//.validateAdminInfoFields("FrstProvEmailSame", "random@@com")
				//.validateAdminInfoFields("FrstProvReEmail", "random@xyz.com");
	}

	@And("^Fill Administrator Info and Verify error msgs for Secondary Contacts\\.$")
	public void fill_Administrator_Info_and_Verify_error_msgs_for_Secondary_Contacts() throws Throwable {
		valdtEFETRAProvInfo.validateAdminInfoFields("ScndProvFName", "").validateAdminInfoFields("ScndProvLName", "")
				.validateAdminInfoFields("ScndProvPhnNo", "").validateAdminInfoFields("ScndProvEmail", "")
				.validateAdminInfoFields("ScndProvReEmail", "").validateAdminInfoFields("ScndProvPhnNo", "abcd")
				.validateAdminInfoFields("ScndProvPhnNo", "897")
				//.validateAdminInfoFields("ScndProvEmailSame", "random@xyz@com")
				//.validateAdminInfoFields("ScndProvReEmail", "random@yuz.com")
				.validateAdminInfoFields("ScndProvFName", "&*9io").validateAdminInfoFields("ScndProvLName", "&^&%vh9")
				.validateAdminInfoFields("ScndProvMName", "9").validateAdminInfoFields("ScndProvMName", "%");
	}

	@And("^ReFill the Admin Info and verify the saved changes\\.$")
	public void refill_the_Admin_Info_and_verify_the_saved_changes() throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickSaveChngBtn().verifyAdminInfo();
	}

	@Then("^User fills all the information on Identify Administrators page and click continue to W(\\d+)$")
	public void user_fills_all_the_information_on_Identify_Administrators_page_and_click_continue_to_W(int arg1)
			throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickContinueToW9();
	}

	@Then("^User navigates to Identity Administrators page and fill all fields and click on continue button$")
	public void user_navigates_to_Identity_Administrators_page_and_fill_all_fields_and_click_on_continue_button()
			throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickContinueToW9();
	}

	@Then("^User navigates to Organization information page and validate fields are editable$")
	public void user_navigates_to_Organization_information_page_and_validate_fields_are_editable() throws Throwable {
		valdtEFETRAProvInfo.verifyEditables();
	}

	@Then("^Validates only Cancel and Save Changes options are displayed on  Identify Administrators page$")
	public void validate_only_Cancel_and_Save_Changes_options_are_displayed_on_Identify_Administrators_page()
			throws Throwable {

		valdtEFETRAProvInfo.validateCanclSaveBtn();
	}

	@Then("^User clicks on cancel button and return to Review and Submit Page\\.$")
	public void user_clicks_on_cancel_button_and_return_to_Review_and_Submit_Page() throws Throwable {
		valdtEFETRAProvInfo.clickCancel();
	}

	@Then("^Validates all the headers from the Identify Administrators page$")
	public void validate_all_the_headers_from_the_Identify_Administrators_page() throws IOException {

		new HeaderContentValidation(testConfig).verifyHeaders("Identify Administrators");
	}

	@Then("^Validates page content matches to UXDS html$")
	public void validate_page_content_matches_to_UXDS_html() throws Throwable {

		valdtEFETRAProvInfo.verifyContentBSWithUXDS();
	}

	@Then("^Validates page text is content managed$")
	public void validate_page_text_is_content_managed() throws Throwable {
		valdtEFETRAProvInfo.verifyTextBSWithContentPage();
	}

	@Then("^Click on Save changes/Continue button and Validate Error hyperlinks$")
	public void click_on_Save_changes_Continue_button_and_Validate_Error_hyperlinks() throws Throwable {
		valdtEFETRAProvInfo.verifyErrorMsgsHyperlink();
	}

	@Then("^Click on Save changes/Continue button and validate Form and error messages$")
	public void click_on_Save_changes_Continue_button_and_validate_Form_and_error_messages() throws Throwable {
		valdtEFETRAProvInfo.verifyErrorMsgNull();
	}

	@Then("^Click on save changes button and Validate Error message for both Primary and Secondary Admin Fields$")
	public void click_on_save_changes_button_and_Validate_Error_message_for_both_Primary_and_Secondary_Admin_Fields()
			throws Throwable {
		valdtEFETRAProvInfo.verifyMissingDataErrorMsgSecondary();
	}

	@Then("^Enter invalid data for Primary Admin and validate error message$")
	public void enter_invalid_data_for_Primary_Admin_and_validate_error_message() throws Throwable {
		valdtEFETRAProvInfo.ValidateInvalidPhnNumbers("Primary", "nonNumeric");
		valdtEFETRAProvInfo.ValidateInvalidPhnNumbers("Primary", "Incomplete");
	}

	@Then("^Enter invalid data for Secondary Admin and validate error message$")
	public void enter_invalid_data_for_Secondary_Admin_and_validate_error_message() throws Throwable {
		valdtEFETRAProvInfo.ValidateInvalidPhnNumbers("Secondary", "nonNumeric");
		valdtEFETRAProvInfo.ValidateInvalidPhnNumbers("Secondary", "Incomplete");
	}

	@Then("^Enter invalid email  address for Primary and Secondary Admin and validate error message$")
	public void enter_invalid_email_address_for_Primary_and_Secondary_Admin_and_validate_error_message()
			throws Throwable {
		valdtEFETRAProvInfo.ValidateInvalidEmailAddr("inpFormatOne", "Email").ValidateInvalidEmailAddr("inpFormatTwo",
				"Email")/* .ValidateInvalidEmailAddr("inpFormatThree","Email") */;
	}

	@Then("^Enter invalid Retype email address for Primary and Secondary Admin and validate error message$")
	public void enter_invalid_Retype_email_address_for_Primary_and_Secondary_Admin_and_validate_error_message()
			throws Throwable {
		valdtEFETRAProvInfo.ValidateInvalidEmailAddr("inpFormatOne", "RetypeEmail")
				.ValidateInvalidEmailAddr("inpFormatTwo", "RetypeEmail")
				.ValidateInvalidEmailAddr("inpFormatThree", "RetypeEmail");

	}

	@Then("^Enter mobile number for Primary Admin and validate Text alert checkbox$")
	public void enter_mobile_number_for_Primary_Admin_and_validate_Text_alert_checkbox() throws Throwable {
		valdtEFETRAProvInfo.verifyMobileAlertEnabled("Primary").verifyMobileAlertEnabled("Secondary");
	}

	@Then("^Click on Learn about alert frquency for both Primary and secondary admin and validate the popup$")
	public void click_on_Learn_about_alert_frquency_for_both_Primary_and_secondary_admin_and_validate_the_popup()
			throws Throwable {
		valdtEFETRAProvInfo.ValidateAlertFrquencyPopup("Primary").ValidateAlertFrquencyPopup("Secondary");
	}

	@Then("^Fills new information and click on save changes$")
	public void fills_new_information_and_click_on_save_changes() throws Throwable {
		valdtEFETRAProvInfo.fillIdentifyInfoSaveChanges();
	}

	@Then("^Validates Cancel button is disabled in case errors are seen on Identify Admin page$")
	public void validate_Cancel_button_is_disabled_in_case_errors_are_seen_on_Identify_Admin_page() throws Throwable {
		valdtEFETRAProvInfo.VerifyCancelButtonDisbaled();
	}

	@Then("^Validates Clear Administrator Information field is hidden when editing the administrator Information$")
	public void validate_Clear_Administrator_Information_field_is_hidden_when_editing_the_administrator_Information()
			throws Throwable {
		valdtEFETRAProvInfo.validateClearAdminInfoHidden();
	}

	@Then("^User clicks on hyperlink CLEAR ADMINISTRATOR INFORMATION$")
	public void User_clicks_on_hyperlink_CLEAR_ADMINISTRATOR_INFORMATION() throws Throwable {
		valdtEFETRAProvInfo.clickClrAdminitration();
	}

	@Then("^User validates Cancel Enrollment, Back and Continue options is displayed at the bottom of the Identify Administrators Page\\.$")
	public void user_validates_Cancel_Enrollment_Back_and_Continue_options_is_displayed_at_the_bottom_of_the_Identify_Administrators_Page()
			throws Throwable {

		valdtEFETRAProvInfo.valiDateButtons();
	}

	@Then("^User Clicks on Back button and navigates to Billing Service Information Page\\.$")
	public void user_Clicks_on_Back_button_and_navigates_to_Billing_Service_Information_Page() throws Throwable {
		valdtEFETRAProvInfo.clickBSBackBtn();
	}

	@Then("^User Clicks on Cancel button and a popup appears with Are you sure you want to cancel your Optum Pay enrollment application\\? with Yes and No$")
	public void user_Clicks_on_Cancel_button_and_a_popup_appears_with_Are_you_sure_you_want_to_cancel_your_EPS_enrollment_application_with_Yes_and_No()
			throws Throwable {

		valdtEFETRAProvInfo.clickCancelEnrlmnt();
	}

	@When("^User Clicks on No button and user is back to Organization Information page\\.$")
	public void user_Clicks_on_No_button_and_user_is_back_to_Organization_Information_page() throws Throwable {

		valdtEFETRAProvInfo.clickNoCancelEnrlmnt();
	}

	@When("^User Clicks on Yes button and user is on Optum Pay landing page\\.$")
	public void user_Clicks_on_Yes_button_and_user_is_on_EPS_landing_page() throws Throwable {

		valdtEFETRAProvInfo.clickYesCancelEnrlmnt();
	}

	@Then("^User navigates to Identity Administrators page and fill  details for \"([^\"]*)\" with incorrect/improper \"([^\"]*)\" and click on continue button$")
	public void user_navigates_to_Identity_Administrators_page_and_fill_details_fields_for_with_incorrect_improper_and_click_on_continue_button(
			String ProviderType, String InputField) throws Throwable {
		if (InputField.equals("Telephone No")) {
			valdtEFETRAProvInfo.fillPrimaryProvInfo().fillInvalidProvInfo(ProviderType, "Incomplete")
					.fillInvalidProvInfo(ProviderType, "nonNumeric");

		} else if (InputField.equals("Email Address")) {
			valdtEFETRAProvInfo.fillPrimaryProvInfo().fillProvInfoWrngEmail(ProviderType, "inpFormatOne")
					.fillProvInfoWrngEmail(ProviderType, "inpFormatTwo");
		}
	}

	@Then("^User navigates to Identity Administrators page and fill all  details  for \"([^\"]*)\" details with not matching Email and Retype Email and click on continue button$")
	public void user_navigates_to_Identity_Administrators_page_and_fill_all_details_for_details_with_not_matching_Email_and_Retype_Email_and_click_on_continue_button(
			String ProviderType) throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().fillProvMailComp(ProviderType);
	}

	@Then("^User fills all fields with \"([^\"]*)\" on Identify Admin page click continue button and validates all the data from DB$")
	public void user_fills_all_fields_with_on_Identify_Admin_page_click_continue_button_and_validates_all_the_data_from_DB(
			String existingEmail) throws Throwable {
		valdtEFETRAProvInfo.verifyDupEmailError(existingEmail);

	}

	@Then("^click on Yes to continue with \"([^\"]*)\",Click on NO with different email address depending on \"([^\"]*)\"$")
	public void click_on_Yes_to_continue_with_same_email_address_Click_on_NO_with_different_email_address(
			String existingEmail, String Flag) throws Throwable {
		if (Flag.contains("Y")) {
			valdtEFETRAProvInfo.clickYes(existingEmail);
		}
		if (Flag.contains("N")) {
			valdtEFETRAProvInfo.clickYes(existingEmail);
		}
	}

	@Then("^User validates the page content of Identify Admin page$")
	public void user_validates_the_page_content_of_Identify_Admin_page() throws Throwable {
		valdtEFETRAProvInfo.verifyPageContent();
	}

	@Then("^User clicks on Learn about alert frequency link validates its content and close it$")
	public void user_clicks_on_Learn_about_alert_frequency_link_validates_its_content_and_close_it() throws Throwable {
		valdtEFETRAProvInfo.verifyAlertFrequencyPopUp();
	}

	@Then("^User clicks on CLEAR ADMINISTRATOR INFORMATION link verify its content and YES/NO functionality$")
	public void user_clicks_on_CLEAR_ADMINISTRATOR_INFORMATION_link_verify_its_content_and_YES_NO_functionality()
			throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().verifyClrInfo().clickYesOnClrInfoPopUp();
	}

	@Then("^Clicks on Continue to validate all the Error Messages$")
	public void clicks_on_Continue_to_validate_all_the_Error_Messages() throws Throwable {
		valdtEFETRAProvInfo.verifyErrorOnContinueEnrlment();
	}

	@Then("^User fills mobileNo and checks its enabilty/disability of Identify Admin Page$")
	public void user_fills_mobileNo_and_checks_its_enabilty_disability_of_Identify_Admin_Page() throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().verifyMobileNoChckBoxfunctionality();
	}

	@Then("^User checks its Back and continue button functionality$")
	public void user_checks_its_Back_and_continue_button_functionality() throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickBackBtn().clickContinueToProviderInfoPage()
				.validateContinueButtonfunctionality();
	}

	@Then("^User Clicks on Cancel Enrollment,verify its content and YES/NO button functionality$")
	public void user_Clicks_on_Cancel_Enrollment_verify_its_content_and_YES_NO_button_functionality() throws Throwable {
		valdtEFETRAProvInfo.clickCancelEnrlmnt().clickNoCancelEnrlmnt().clickYesCancelEnrlmnt();
	}

	@Then("^User fills  all data but different email and Retype email for \"([^\"]*)\" and validate Error messages$")
	public void user_fills_all_data_but_different_email_and_Retype_email_for_and_validate_Error_messages(
			String InputField) throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().fillProvMailComp(InputField);
	}

	@Then("^User fills  primary info\\. and in Secondary info\\. enter \"([^\"]*)\" and \"([^\"]*)\" and validate Error messages$")
	public void user_fills_primary_info_and_in_Secondary_info_enter_and_and_validate_Error_messages(String InputField,
			String dataFormat) throws Throwable {
		if (dataFormat.contentEquals("blank"))
			valdtEFETRAProvInfo.fillPrimaryProvInfo().validateAdminInfoFields("ScndProvFName", "")
					.validateAdminInfoFields("ScndProvLName", "").validateAdminInfoFields("ScndProvPhnNo", "")
					.validateAdminInfoFields("ScndProvEmail", "").validateAdminInfoFields("ScndProvReEmail", "");
		if (dataFormat.contentEquals("Incomplete,nonNumeric"))
			valdtEFETRAProvInfo.fillPrimaryProvInfo().fillInvalidProvInfo("Secondary", "nonNumeric")
					.fillInvalidProvInfo("Secondary", "Incomplete");
		if (dataFormat.contentEquals("Incorrect"))
			valdtEFETRAProvInfo.fillPrimaryProvInfo().fillProvInfoWrngEmail("Secondary", "inpFormatOne")
					.fillProvInfoWrngEmail("Secondary", "inpFormatTwo");// .fillProvInfoWrngEmail("Secondary","inpFormatThree");
		if (dataFormat.contentEquals("Alphanumeric"))
			valdtEFETRAProvInfo.fillPrimaryProvInfo()
					.fillProvInfoName("Secondary", "First Name", Helper.generateRandomAlphaNumericString(5))
					.fillProvInfoName("Secondary", "Middle Name", "3")
					.fillProvInfoName("Secondary", "Last Name", Helper.generateRandomAlphaNumericString(5));
		if (dataFormat.contentEquals("Special Char"))
			valdtEFETRAProvInfo.fillPrimaryProvInfo().fillProvInfoName("Secondary", "First Name", "&*min")
					.fillProvInfoName("Secondary", "Middle Name", "*(*(*")
					.fillProvInfoName("Secondary", "Last Name", "%^&&");
	}

	@Then("^User fills  primary information with \"([^\"]*)\" and \"([^\"]*)\" and validate Error messages$")
	public void user_fills_primary_information_with_and_and_validate_Error_messages(String InputField,
			String dataFormat) throws Throwable {
		if (dataFormat.contentEquals("blank"))
			valdtEFETRAProvInfo.fillPrimaryNoDataProvInfo("First Name").fillPrimaryNoDataProvInfo("Last Name")
					.fillPrimaryNoDataProvInfo("Email Address").fillPrimaryNoDataProvInfo("ReType Email Address")
					.fillPrimaryNoDataProvInfo("Telephone No");
		if (dataFormat.contentEquals("Incomplete,nonNumeric"))
			valdtEFETRAProvInfo.fillInvalidProvInfo("Primary", "Incomplete").fillInvalidProvInfo("Primary",
					"nonNumeric");
		if (dataFormat.contentEquals("Incorrect"))
			valdtEFETRAProvInfo.fillPrimaryProvInfo().fillProvInfoWrngEmail("Primary", "inpFormatOne")
					.fillProvInfoWrngEmail("Primary", "inpFormatTwo");// .fillProvInfoWrngEmail("Primary","inpFormatThree");
		if (dataFormat.contentEquals("Alphanumeric"))
			valdtEFETRAProvInfo.fillProvInfoName("Primary", "First Name", Helper.generateRandomAlphaNumericString(5))
					.fillProvInfoName("Primary", "Middle Name", "3")
					.fillProvInfoName("Primary", "Last Name", Helper.generateRandomAlphaNumericString(5));
		if (dataFormat.contentEquals("Special Char"))
			valdtEFETRAProvInfo.fillProvInfoName("Primary", "First Name", "&*min")
					.fillProvInfoName("Primary", "Middle Name", "*(*(*")
					.fillProvInfoName("Primary", "Last Name", "%^&&");
	}

	@Then("^User fills all fields with existing Primary Email on Identify Admin page click continue button and validates all the data from DB$")
	public void user_fills_all_fields_with_existing_Primary_Email_on_Identify_Admin_page_click_continue_button_and_validates_all_the_data_from_DB()
			throws Throwable {
		valdtEFETRAProvInfo.verifyDupEmailError("Primary").verifyAssociatedTinsData();
	}

	@Then("^click on Yes to continue with same email address,Click on NO with different email address$")
	public void click_on_Yes_to_continue_with_same_email_address_Click_on_NO_with_different_email_address()
			throws Throwable {
		valdtEFETRAProvInfo.verifyNoBtnFunctionality().verifyDupEmailError("Primary").verifyYesBtnFunctionality();
	}

	@Then("^User fills all fields with existing Secondary Email on Identify Admin page click continue button$")
	public void user_fills_all_fields_with_existing_Secondary_Email_on_Identify_Admin_page_click_continue_button()
			throws Throwable {
		valdtEFETRAProvInfo.verifyDupEmailError("Secondary");
	}

	@Then("^User fills all fields with existing both primary and Secondary Email on Identify Admin page click continue validates all the content from DB$")
	public void user_fills_all_fields_with_existing_both_primary_and_Secondary_Email_on_Identify_Admin_page_click_continue_validates_all_the_content_from_DB()
			throws Throwable {
		valdtEFETRAProvInfo.clickNoBtn().verifyDupEmailError("");
	}

}
