package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ReviewAndSubmit;
import main.java.pageObjects.SelectPaymentMethods;
import main.java.pageObjects.UploadW9;
import main.java.pageObjects.ValidateEFTERAProviderInfo;

public class FinancialInsInfoRevSubmitSteps extends TestBase{
	
	UploadW9 uploadW9=null;
	ValidateEFTERAProviderInfo validateEFTERAProviderInfo=null;
	FinancialInstitutionInfoPage financialInstitutionInfoPage=null;
	ReviewAndSubmit reviewAndSubmit= null;
	SelectPaymentMethods selectPaymentMethods=null;
	
	@Then("^User fills all the information on Identify Administrators page and click continue to Fin Ins$")
	public void user_fills_all_the_information_on_Identify_Administrators_page_and_click_continue() throws Throwable {
		
		ValidateEFTERAProviderInfo validateEFTERAProviderInfo=new ValidateEFTERAProviderInfo(testConfig);
		financialInstitutionInfoPage=validateEFTERAProviderInfo.fillPrimaryProvInfo().clickContinue();
	}

	@Then("^User fills all the information on Financial Institution Information page and click continue$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_and_click_continue() throws Throwable {
		uploadW9 =financialInstitutionInfoPage.fillFinancialInstInfo().clickContinue();
	}
	
	@Then("^User navigates to UploadWnine page and click on continue button on financial Institution Page$")
	public void user_navigates_to_Uploadw_page_and_click_on_continue_button_on_financial_Institution_Page() throws Throwable {

		reviewAndSubmit=uploadW9.uploadW9();
	}
	
	@Then("^Vaidates Edit option next to each field on Review and Submit page$")
	public void vaidate_Edit_option_next_to_each_field_on_Review_and_Submit_page() throws Throwable {

		reviewAndSubmit.verifyEditLinks();
	}
	
	@Then("^Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page$")
	public void click_on_Edit_on_financial_Institution_Section_and_validate_user_navigates_to_Financial_Institution_Information_Page() throws Throwable {

		reviewAndSubmit.clickFinancialInfoEditLink();
	}
	
	@Then("^Validates buttons on Edit Financial Institution Information Page$")
	public void validate_buttons_on_Edit_Financial_Institution_Information_Page() throws Throwable {

		financialInstitutionInfoPage.validateFinInforButtons();
	}
	
	@Then("^Clicks on Cancel changes button and validate no changes are saved$")
	public void click_on_Cancel_changes_button_and_validate_no_changes_are_saved() throws Throwable {

		financialInstitutionInfoPage.clickCancelChanges();
		reviewAndSubmit.verifyCancelChangesFinancialInfoEdit();
	}
	
	@Then("^Clicks on link Where can i find a financial institution's routing number\\? and validate the popup message$")
	public void click_on_link_Where_can_i_find_a_financial_institution_s_routing_number_and_validate_the_popup_message() throws Throwable {

		financialInstitutionInfoPage.validateRoutingNumberPopup();
	}
	
	@Then("^User Navigates Back to Financial Institution Information Page from Review and Submit Page$")
	public void user_Navigates_Back_to_Financial_Institution_Information_Page_from_Review_and_Submit_Page() throws Throwable {

		reviewAndSubmit.validateBackButton();
		uploadW9.clickBackButton();
	}
	
	@Then("^Clicks on link How do i manage multiple NPI bank accounts and validate the popup message$")
	public void click_on_link_How_do_i_manage_multiple_NPI_bank_accounts_and_validate_the_popup_message() throws Throwable {
	   
		financialInstitutionInfoPage.validateMultipleNPIPopup();
	}
	
	@Then("^Validates Headers on Financial Information page$")
	public void validate_Headers_on_Financial_Information_page() throws Throwable {
		
		new HeaderContentValidation(testConfig).verifyHeaders("Financial Institution Information");
	}

	@Then("^User fills all the information on Financial Institution Information page and click continue to AV$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_and_click_continue_to_AV() throws Throwable {

		selectPaymentMethods =financialInstitutionInfoPage.fillFinancialInstInfo().clickContinueAV();
	}
	
	@Then("^User clicks Continue on Select Payment Methods Page$")
	public void user_clicks_Continue_on_Select_Payment_Methods_Page() throws Throwable {
		
		uploadW9=selectPaymentMethods.clickContinue();
	}

	@Then("^Validates Cancel button is disabled when click on edit for voided/blank letter document$")
	public void validate_Cancel_button_is_disabled_when_click_on_edit_for_voided_blank_letter_document() throws Throwable {

		financialInstitutionInfoPage.validateCancelChanges();
	}

	@Then("^Validates Missing data Error messages for Financial Institution Fields on click on save changes button$")
	public void validate_Missing_data_Error_messages_for_Financial_Institution_Fields_on_click_on_save_changes_button() throws Throwable {

		financialInstitutionInfoPage.verifyErrorMsg();
	}
	
	@Then("^Validates Invalid data Error messages for Financial Institution Fields on click on save changes button$")
	public void validate_Invalid_data_Error_messages_for_Financial_Institution_Fields_on_click_on_save_changes_button() throws Throwable {

		financialInstitutionInfoPage.validateInvalidDataErrorMsg();
	}
	
	@Then("^Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button$")
	public void validate_Non_numeric_data_Error_messages_for_Financial_Institution_Fields_on_click_on_save_changes_button() throws Throwable {

		financialInstitutionInfoPage.validateNonNumericErrorMsg();
	}
	
	@Then("^User should navigae to Review and Submit Page upon Entering valid information with changes reflecting$")
	public void user_should_navigae_to_Review_and_Submit_Page_upon_Entering_valid_information_with_changes_reflecting() throws Throwable {

		financialInstitutionInfoPage.VerifyValidFinInstInfo();
		reviewAndSubmit.verifySavedChangesFinInsInfo();

	}
}
