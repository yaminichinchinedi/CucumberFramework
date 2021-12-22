
package main.java.stepDefinitions.CrtEnrolmnt;

import java.io.IOException;

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
import main.java.pageObjects.FinancialInstitutionInfoPageNPI;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.ReviewAndSubmit;
import main.java.pageObjects.SelectPaymentMethods;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.UploadW9;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;

public class FinancialInstitutionInfoPageSteps extends TestBase {

	
	String option="Health plan communication";
	int excelRow=1;
	FinancialInstitutionInfoPage financialInstitutionInfoPage=new FinancialInstitutionInfoPage(testConfig);
	FinancialInstitutionInfoPageNPI financialInstitutionNPI=null;
	
	@Then("^It is Validated that Financial Institution Information page text is content managed$")
	public void it_is_Validated_that_Financial_Institution_Information_page_text_is_content_managed() throws Throwable {
		financialInstitutionInfoPage.verifyUITextFromDB();
	}
	
	@Then("^User clicks the link where can i find a finantial intitution's routing no$")
	public void User_clicks_link_FII_Routng_Lnk()
	{		financialInstitutionInfoPage.clickFINRoutlnk();	
	
	}
	
	@Then("^User clicks on browse and upload its supporting document$")
	public void user_clicks_on_browse_and_upload_its_supporting_document() throws Throwable {
		financialInstitutionInfoPage.uploadBankLetterPdfWithAcceptance();
	}
	
	@Then("^User clicks on hyperlink how do i manage multiple NPI bank accounts$")
	public void user_clicks_on_hyperlink_how_do_i_manage_multiple_NPI_bank_accounts() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA();
		financialInstitutionInfoPage.clickFINMngNPIAcc();
	}

	@Then("^User validates the Type of account as Checking by default and can be change to Saving$")
	public void user_validates_the_Type_of_account_as_Checking_by_default_and_can_be_change_to_Saving() throws Throwable {
		financialInstitutionInfoPage.verifyFinAccount("TypeOfAc");
	}

	
	@Then("^User validates the supporting document as Voided Check by default and can be change to Bank letter$")
	public void User_validates_supporting_document_as_Voided_Check_and_Bank_letter()
	{		financialInstitutionInfoPage.verifyFinAccount("SupportDoc");	
	
	}

	@Then("^User validates the NPI Bank account as No by default and can be change to Yes$")
	public void user_validates_the_NPI_Bank_account_as_No_by_default_and_can_be_change_to_Yes() throws Throwable {
		financialInstitutionInfoPage.verifyFinAccount("NPIBankAc");
	}
	
	@Then("^Validate all the Headers from FII page in case of AO and AV Enrollment type$")
	public void validate_all_the_Headers_from_FII_page_in_case_of_AV_Enrollment_type() throws Throwable {
		String BoldFontwthCircle="Financial Institution Information";
		new HeaderContentValidation(testConfig).verifyHeaders(BoldFontwthCircle);
	}

	@Then("^User validates and clicks buttons Back,Cancel Enrollment,Continue are on the FII page$")
	public void user_validates_and_clicks_buttons_Back_Cancel_Enrollment_Continue_are_on_the_FII_page() throws Throwable {
		financialInstitutionInfoPage.verifyButtons();
	}
	
	@Then("^User clicks on continue button of FII page and validtes the error messages$")
	public void User_clicks_on_continue_button_of_FII_page_and_validtes_the_error_messages() throws Throwable {
		financialInstitutionInfoPage.verifyErrors();
	}
	@Then("^User fills all the information and PO Box no in Street field and clicks on continue$")
	public void User_fills_all_the_information_and_PO_Box_no_in_Street_field_and_clicks_on_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstWrngInfo("Street");
	}
	
	@Then("^User fills all the information and invalid Zip code for corresponding City and clicks on continue$")
	public void User_fills_all_the_information_and_invalid_Zip_code_for_corresponding_City_and_clicks_on_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstWrngInfo("Zip");
	}
	
	@Then("^User fills all the information and upload non accepted file format and clicks on continue$")
	public void user_fills_all_the_information_and_upload_non_accepted_file_format_and_clicks_on_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstWrngInfo("uploadFile");
	}
	
	@Then("^User fills all the information on Financial Institution Information page and click continue NPI$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_and_click_continue_NPI() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA().clickYestoNPI().clickContinueNPI();
		
	}
	@Then("^Users clears the RTN No fill the new RTN No and validate the details and click on Save changes button$")
	public void users_clears_the_RTN_No_fill_the_new_RTN_No_and_validate_the_details_and_click_on_Save_changes_button() throws Throwable {
		financialInstitutionInfoPage.clearNfillRTNNoABA();
	}
	@Then("^User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_for_ABA_Validator_Click_YES_to_NPI_and_click_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA().clickYestoNPI().clickContinueNPI();
	}
	
	@Then("^User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_for_ABA_Validator_Click_YES_to_NPI() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA().clickYestoNPI();
	}
	@Then("^User fills all the information on Financial Institution Information page for ABA Validator and click continue$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_for_ABA_and_click_continue_NPI() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA().clickContinue();

	}
	@Then("^User fills all the information on Financial Institution Information page for ABA Validator$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_for_ABA_Validator() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA();

	}
	
	@Then("^User fills all the information on Financial Institution Information page for Routing And AccountNumber$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_for_Routing_And_AccountNumber() throws Throwable {
		financialInstitutionInfoPage.fillRoutingAndAccountNumberOnFinanacePage();

	}
	@Then("^User fills all the information on Financial Institution Information page for ABA Validator and click continue AV$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_for_ABA_Validator_and_click_continue_AV() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA().clickContinueAV();

	}
//	@Then("^User fills all the information of Financial Institution Information NPI page and click continue\\.$")
//	public void user_fills_all_the_information_of_Financial_Institution_Information_NPI_page_and_click_continue() throws Throwable {
//		financialInstitutionNPI=new FinancialInstitutionInfoPageNPI(testConfig);
//		financialInstitutionNPI.fillFinancialInstInfoForNPI().clickContinueAV();
//	}
	@When("^RTI API server is up$")
	public void rti_API_server_is_up_and_RTN_switch_is_set_as_Y() throws Throwable {
		 financialInstitutionInfoPage.checkABNValidator();
	}

	@Then("^All the validations are performed with incorrect information with editable RTN No$")
	public void all_the_validations_are_performed_with_incorrect_information_with_editable_RTN_No() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfoFromExcelABA().clickContinue();
	}
	@Then("^User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator$")
	public void user_fills_all_the_information_with_Incorrect_Improper_Null_RTN_No_on_Financial_Institution_Information_page_for_ABA_Validator() throws Throwable {
		   financialInstitutionInfoPage.fillFinancialInstInfoFromABA(null)
		   							   .fillFinancialInstInfoFromABA(Long.toString(Helper.generateRandomNumber(5)))
									   .fillFinancialInstInfoFromABA(Helper.generateRandomAlphaNumericString(9))
									   .fillFinancialInstInfoFromABA(Long.toString(Helper.generateRandomNumber(9)))
		   ;
	}

	@Then("^All the validations are performed for Incorrect information with editable RTN No$")
	public void all_the_validations_are_performed_for_Incorrect_information_with_editable_RTN_No() throws Throwable {
	    
	}
	@Then("^modify/remove RTN No making as invalid,validations are performed$")
	public void modify_remove_RTN_No_making_as_invalid_validations_are_performed() throws Throwable {
		financialInstitutionInfoPage
		   .fillFinancialInstInfoFromABA(Long.toString(Helper.generateRandomNumber(7)));
	}
	@Then("^User fills all the information on Financial Institution Information page and click continue$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_and_click_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfo().clickContinue();
	}

	@Then("^User fills all the information on Financial Institution Information page and click continue AV$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_and_click_continue_AV() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstInfo().clickContinueAV();  
	}
	
	@Then("^Validates buttons on Edit Financial Institution Information Page$")
	public void validate_buttons_on_Edit_Financial_Institution_Information_Page() throws Throwable {

		financialInstitutionInfoPage.validateCanclSaveButtons();
	}
	
	@Then("^Clicks on Cancel Changes button on Financial Institution Page\\.$")
	public void clicks_on_Cancel_Changes_button_on_Financial_Institution_Page() throws Throwable {
		financialInstitutionInfoPage.clickCancelChanges();
	}
	
	@Then("^Clicks on link Where can i find a financial institution's routing number\\? and validate the popup message$")
	public void click_on_link_Where_can_i_find_a_financial_institution_s_routing_number_and_validate_the_popup_message() throws Throwable {

		financialInstitutionInfoPage.validateRoutingNumberPopup();
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

		financialInstitutionInfoPage.fillFinancialInstInfo().clickContinueAV();
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

		//financialInstitutionInfoPage.validateInvalidDataErrorMsg();
	}
	
	@Then("^Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button$")
	public void validate_Non_numeric_data_Error_messages_for_Financial_Institution_Fields_on_click_on_save_changes_button() throws Throwable {

		//financialInstitutionInfoPage.validateNonNumericErrorMsg();
	}
	
	@Then("^User should navigate to Review and Submit Page upon Entering valid information$")
	public void user_should_navigate_to_Review_and_Submit_Page_upon_Entering_valid_information() throws Throwable {
		financialInstitutionInfoPage.VerifyValidFinInstInfo();
	}
	
	@Then("^User validates fiels are editables on Financial Institution Information page$")
	public void user_validates_fiels_are_editables_on_Financial_Institution_Information_page() throws Throwable {
		financialInstitutionInfoPage.verifyEditable();
	}
	
	@Then("^User clicks on edit link of Account information section and reupload any other document$")
	public void user_clicks_on_edit_link_of_Account_information_section_and_reupload_any_other_document() throws Throwable {
		financialInstitutionInfoPage.verifyUploadedDoc();
	}
	
	@Then("^User give alphanumeric No in Telphone no fiels and click on save changes button$")
	public void user_give_alphanumeric_No_in_Telphone_no_fiels_and_click_on_save_changes_button() throws Throwable {
		//financialInstitutionInfoPage.fillFIIwithNonNumericPhone();
	}
	@Then("^Users enters same AC No and RTN No on Financial Institution Information page validate error message$")
	public void users_enters_same_AC_No_and_RTN_No_on_Financial_Institution_Information_page_validate_error_message() throws Throwable {
		financialInstitutionInfoPage.fillsameRTNACNo();
	}
}
