package main.java.stepDefinitions.CrtEnrolmnt;

import java.io.IOException;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.Footer;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;
import main.java.pageObjects.ReviewAndSubmit;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.UploadW9;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;

public class CreateEnrlmntBSIdentifyEdit extends TestBase{

	String option="Health plan communication";
	int excelRow=0;
	UPARegistrationPage registrationPage=null;
	BeginEnrollment beginEnrollmentPage=null;
	BeginEnrollmentContinue beginEnrollmentContinuePage=null;
	ValidateEnrollmentTypePage validateEnrollmentTypePage=null;
	ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	ValidateEFTERAProviderInfo validateEFTERAProviderInfo=null;
	UploadW9 uploadW9=null;
	ReviewAndSubmit reviewAndSubmit=null;
	ProviderInformationEFTERAEnroll providerInformationEFTERAEnroll=null;
	
	
	/*@Then("^User navigates to Enrollment Eligible TIN  page and click on continue$")
	public void user_navigates_to_Enrollment_Eligible_TIN_page_and_click_on_continue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ValidateEnrollmentTypePage validateEnrollmentTypePage=new ValidateEnrollmentTypePage(testConfig);
		providerEFTERAEnrollPage=validateEnrollmentTypePage.verifyTINStatus().clickContinue();
	}*/

	@Then("^User navigates to Billing service information page and fill all fields and click on continue button$")
	public void user_navigates_to_Billing_service_information_page_and_fill_all_fields_and_click_on_continue_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		providerInformationEFTERAEnroll=new ProviderInformationEFTERAEnroll(testConfig);
		validateEFTERAProviderInfo=providerInformationEFTERAEnroll.fillProviderOrgInfo();
	}

	@Then("^User navigates to Identity Administrators page and fill all fields and click on continue button$")
	public void user_navigates_to_Identity_Administrators_page_and_fill_all_fields_and_click_on_continue_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		uploadW9=validateEFTERAProviderInfo.fillPrimaryProvInfo().clickContinueToW9();
	}
	
	@Then("^User navigates to Uploadw(\\d+) page and click on continue button$")
	public void user_navigates_to_Uploadw_page_and_click_on_continue_button(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//reviewAndSubmit=new ReviewAndSubmit(testConfig);
		reviewAndSubmit=uploadW9.uploadW9();
	}

	@Then("^User navigates to ReviewAndSubmit page and click on edit icon$")
	public void user_navigates_to_ReviewAndSubmit_page_and_click_on_edit_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		reviewAndSubmit.clickIdentifyEditLink();
	}

	@Then("^User navigates to Organization information page and validate fields are editable$")
	public void user_navigates_to_Organization_information_page_and_validate_fields_are_editable() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		validateEFTERAProviderInfo=validateEFTERAProviderInfo.verifyEditable();
	}
	
	@Then("^Validate only Cancel and Save Changes options are displayed on  Identify Administrators page$")
	public void validate_only_Cancel_and_Save_Changes_options_are_displayed_on_Identify_Administrators_page() throws Throwable {
		
		validateEFTERAProviderInfo.valiDateButtonsIdenityAdmn();
	}

	@Then("^User clicks on cancel button and Validate no changes are saved and should return to Review and Submit page$")
	public void user_clicks_on_cancel_button_and_Validate_no_changes_are_saved_and_should_return_to_Review_and_Submit_page() throws Throwable {
     
		validateEFTERAProviderInfo.clickCancel();
		reviewAndSubmit.verifyCancelChangesIdentifyAdminEdit();
	
	}

	@Then("^Validate all the headers from the Identify Administrators page$")
	public void validate_all_the_headers_from_the_Identify_Administrators_page() throws IOException{

		new HeaderContentValidation(testConfig).verifyHeaders("Identify Administrators");
	}
	
	@Then("^Validate page content matches to UXDS html$")
	public void validate_page_content_matches_to_UXDS_html() throws Throwable {

		validateEFTERAProviderInfo.verifyContentBSWithUXDS();
	}
	
	@Then("^Validate page text is content managed$")
	public void validate_page_text_is_content_managed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		validateEFTERAProviderInfo.verifyTextBSWithContentPage();
	}


	@Then("^click on Save changes button and validate Form and error messages$")
	public void click_on_Save_changes_button_and_validate_Form_and_error_messages() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		validateEFTERAProviderInfo.verifyErrorMsgNull();
	}
	
	@Then("^click on save changes button and Validate Error hyperlinks$")
	public void click_on_save_changes_button_and_Validate_Error_hyperlinks() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		validateEFTERAProviderInfo.verifyErrorMsgsHyperlink();
	}
	

    @Then("^click on save changes button and Validate Error message for both Primary and Secondary Admin Fields$")
    public void click_on_save_changes_button_and_Validate_Error_message_for_both_Primary_and_Secondary_Admin_Fields() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
    	validateEFTERAProviderInfo.verifyMissingDataErrorMsgSecondary();
    }
    
    @Then("^enter invalid data for Primary Admin and validate error message$")
    public void enter_invalid_data_for_Primary_Admin_and_validate_error_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	
    	validateEFTERAProviderInfo.ValidateInvalidPhnNumbers("Primary", "nonNumeric");
    	validateEFTERAProviderInfo.ValidateInvalidPhnNumbers("Primary", "Incomplete");
    }

    @Then("^enter invalid data for Secondary Admin and validate error message$")
    public void enter_invalid_data_for_Secondary_Admin_and_validate_error_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	
    	validateEFTERAProviderInfo.ValidateInvalidPhnNumbers("Secondary", "nonNumeric");
    	validateEFTERAProviderInfo.ValidateInvalidPhnNumbers("Secondary", "Incomplete");
    }

    @Then("^enter invalid email  address for Primary and Secondary Admin and validate error message$")
    public void enter_invalid_email_address_for_Primary_and_Secondary_Admin_and_validate_error_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    	validateEFTERAProviderInfo.ValidateInvalidEmailAddr("inpFormatOne","Email").ValidateInvalidEmailAddr("inpFormatTwo","Email")/*.ValidateInvalidEmailAddr("inpFormatThree","Email")*/;
    }

    @Then("^enter invalid Retype email address for Primary and Secondary Admin and validate error message$")
    public void enter_invalid_Retype_email_address_for_Primary_and_Secondary_Admin_and_validate_error_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    	validateEFTERAProviderInfo.ValidateInvalidEmailAddr("inpFormatOne","RetypeEmail").ValidateInvalidEmailAddr("inpFormatTwo","RetypeEmail").ValidateInvalidEmailAddr("inpFormatThree","RetypeEmail");
    
    }
    
    @Then("^enter mobile number for Primary Admin and validate Text alert checkbox$")
    public void enter_mobile_number_for_Primary_Admin_and_validate_Text_alert_checkbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    
    	validateEFTERAProviderInfo.verifyMobileAlertEnabled("Primary").verifyMobileAlertEnabled("Secondary");
    }


    @Then("^Click on Learn about alert frquency for both Primary and secondary admin and validate the popup$")
    public void click_on_Learn_about_alert_frquency_for_both_Primary_and_secondary_admin_and_validate_the_popup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
   
    	validateEFTERAProviderInfo.ValidateAlertFrquencyPopup("Primary").ValidateAlertFrquencyPopup("Secondary");
    }
    
    @Then("^fill new information and click on save changes and displayed on Review and Submit page$")
    public void fill_new_information_and_click_on_save_changes_and_displayed_on_Review_and_Submit_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    	validateEFTERAProviderInfo.fillIdentifyInfoSaveChanges();
    	reviewAndSubmit.verifySavedChangesIdentifyAdmin();
    }
    
    @Then("^Validate Cancel button is disabled in case errors are seen on Identify Admin page$")
    public void validate_Cancel_button_is_disabled_in_case_errors_are_seen_on_Identify_Admin_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	
    	validateEFTERAProviderInfo.VerifyCancelButtonDisbaled();
    }
    
    @Then("^Validate Clear Administrator Information field is hidden when editing the administrator Information$")
    public void validate_Clear_Administrator_Information_field_is_hidden_when_editing_the_administrator_Information() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    	validateEFTERAProviderInfo.validateClearAdminInfoLink();
    }

    @Then("^validate the Footer Information$")
    public void validate_the_Footer_Information() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    	new Footer(testConfig).validateFooterContents(testConfig);
    }
}
