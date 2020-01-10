package main.java.stepDefinitions.CrtEnrolmnt;


import cucumber.api.java.en.And;
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
public class ValidateEFTERAProviderInfoSteps extends TestBase{
	String option="Health plan communication";
	int excelRow=0;
	ValidateEFTERAProviderInfo valdtEFETRAProvInfo=new ValidateEFTERAProviderInfo(testConfig);
	
	@Then("^User fills all the information on Identify Administrators page and click continue$")
	public void user_fills_all_the_information_on_Identify_Administrators_page_and_click_continue() throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickContinue();
	}
	
	
	@And("^Validate the Identify Admin fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page\\.$")
	public void validate_the_Identify_Admin_fields_are_editable_and_SAVA_CHANGES_and_CANCEL_CHANGES_button_are_present_on_page() throws Throwable {
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
		valdtEFETRAProvInfo.validateAdminInfoFields("FrstProvFName", "").validateAdminInfoFields("FrstProvFName", "kino&*&*")
		.validateAdminInfoFields("FrstProvLName", "").validateAdminInfoFields("FrstProvLName", "yamato^&^&").validateAdminInfoFields("FrstProvMName", "&").validateAdminInfoFields("FrstProvMName", "9").
		validateAdminInfoFields("FrstProvPhnNo", "").validateAdminInfoFields("FrstProvPhnNo", "47").validateAdminInfoFields("FrstProvPhnNo", "a89b").validateAdminInfoFields("FrstProvEmail", "").
		validateAdminInfoFields("FrstProvReEmail", "").validateAdminInfoFields("FrstProvEmailSame", "random@@com").validateAdminInfoFields("FrstProvReEmail", "random@xyz.com");
	}

	@And("^Fill Administrator Info and Verify error msgs for Secondary Contacts\\.$")
	public void fill_Administrator_Info_and_Verify_error_msgs_for_Secondary_Contacts() throws Throwable {
		valdtEFETRAProvInfo.validateAdminInfoFields("ScndProvFName", "").validateAdminInfoFields("ScndProvLName", "").validateAdminInfoFields("ScndProvPhnNo",
				"").validateAdminInfoFields("ScndProvEmail", "").validateAdminInfoFields("ScndProvReEmail",
		"").validateAdminInfoFields("ScndProvPhnNo", "abcd").validateAdminInfoFields("ScndProvPhnNo", "897").validateAdminInfoFields("ScndProvEmailSame",
				"random@xyz@com").validateAdminInfoFields("ScndProvReEmail", "random@yuz.com").validateAdminInfoFields("ScndProvFName",
						"&*9io").validateAdminInfoFields("ScndProvLName", "&^&%vh9").validateAdminInfoFields("ScndProvMName", "9").validateAdminInfoFields("ScndProvMName", "%");
	}
	
	@And("^ReFill the Admin Info and verify the saved changes\\.$")
	public void refill_the_Admin_Info_and_verify_the_saved_changes() throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickSaveChngBtn().verifyAdminInfo();
	}
	
	@Then("^User fills all the information on Identify Administrators page and click continue to W(\\d+)$")
	public void user_fills_all_the_information_on_Identify_Administrators_page_and_click_continue_to_W(int arg1) throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickContinueToW9();  
	}

	@Then("^User navigates to Identity Administrators page and fill all fields and click on continue button$")
	public void user_navigates_to_Identity_Administrators_page_and_fill_all_fields_and_click_on_continue_button() throws Throwable {
		valdtEFETRAProvInfo.fillPrimaryProvInfo().clickContinueToW9();
	}
	
	@Then("^User navigates to Organization information page and validate fields are editable$")
	public void user_navigates_to_Organization_information_page_and_validate_fields_are_editable() throws Throwable {
		valdtEFETRAProvInfo.verifyEditables();
	}
	
	@Then("^Validates only Cancel and Save Changes options are displayed on  Identify Administrators page$")
	public void validate_only_Cancel_and_Save_Changes_options_are_displayed_on_Identify_Administrators_page() throws Throwable {
		
		valdtEFETRAProvInfo.validateCanclSaveBtn();
	}

	@Then("^User clicks on cancel button and return to Review and Submit Page\\.$")
	public void user_clicks_on_cancel_button_and_return_to_Review_and_Submit_Page() throws Throwable {
		valdtEFETRAProvInfo.clickCancel();
	}

	@Then("^Validates all the headers from the Identify Administrators page$")
	public void validate_all_the_headers_from_the_Identify_Administrators_page() throws IOException{

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


	@Then("^Click on Save changes button and validate Form and error messages$")
	public void click_on_Save_changes_button_and_validate_Form_and_error_messages() throws Throwable {
		valdtEFETRAProvInfo.verifyErrorMsgNull();
	}
	
	@Then("^Click on save changes button and Validate Error hyperlinks$")
	public void click_on_save_changes_button_and_Validate_Error_hyperlinks() throws Throwable {
		valdtEFETRAProvInfo.verifyErrorMsgsHyperlink();
	}
	

    @Then("^Click on save changes button and Validate Error message for both Primary and Secondary Admin Fields$")
    public void click_on_save_changes_button_and_Validate_Error_message_for_both_Primary_and_Secondary_Admin_Fields() throws Throwable {
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
    public void enter_invalid_email_address_for_Primary_and_Secondary_Admin_and_validate_error_message() throws Throwable {
    	valdtEFETRAProvInfo.ValidateInvalidEmailAddr("inpFormatOne","Email").ValidateInvalidEmailAddr("inpFormatTwo","Email")/*.ValidateInvalidEmailAddr("inpFormatThree","Email")*/;
    }

    @Then("^Enter invalid Retype email address for Primary and Secondary Admin and validate error message$")
    public void enter_invalid_Retype_email_address_for_Primary_and_Secondary_Admin_and_validate_error_message() throws Throwable {
    	valdtEFETRAProvInfo.ValidateInvalidEmailAddr("inpFormatOne","RetypeEmail").ValidateInvalidEmailAddr("inpFormatTwo","RetypeEmail").ValidateInvalidEmailAddr("inpFormatThree","RetypeEmail");
    
    }
    
    @Then("^Enter mobile number for Primary Admin and validate Text alert checkbox$")
    public void enter_mobile_number_for_Primary_Admin_and_validate_Text_alert_checkbox() throws Throwable {
    	valdtEFETRAProvInfo.verifyMobileAlertEnabled("Primary").verifyMobileAlertEnabled("Secondary");
    }


    @Then("^Click on Learn about alert frquency for both Primary and secondary admin and validate the popup$")
    public void click_on_Learn_about_alert_frquency_for_both_Primary_and_secondary_admin_and_validate_the_popup() throws Throwable {
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
    public void validate_Clear_Administrator_Information_field_is_hidden_when_editing_the_administrator_Information() throws Throwable {
    	valdtEFETRAProvInfo.validateClearAdminInfoHidden();
    }


}

