package main.java.stepDefinitions.CrtEnrolmnt;

import main.java.Utils.Helper;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.FinancialInstitutionInfoPageNPI;
import cucumber.api.java.en.Then;

public class FinancialInstitutionInfoPageNPISteps extends TestBase{

	FinancialInstitutionInfoPageNPI financialInstitutionNPI=new FinancialInstitutionInfoPageNPI(testConfig);
	@Then("^User fills all the information of Financial Institution Information NPI page and click continue\\.$")
	public void user_fills_all_the_information_of_Financial_Institution_Information_NPI_page_and_click_continue() throws Throwable {
		
		financialInstitutionNPI.fillFinancialInstInfoForNPI().clickContinue();
	}
	@Then("^User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue\\.$")
	public void user_fills_NPI_No_RTN_No_and_other_information_on_Financial_Institution_Information_NPI_page_and_click_continue() throws Throwable {
		financialInstitutionNPI.fillFinancialInstInfoFromExcelABANPI().clickContinue();

	}
	@Then("^User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue for AV\\.$")
	public void user_fills_NPI_No_RTN_No_and_other_information_on_Financial_Institution_Information_NPI_page_and_click_continue_for_AV() throws Throwable {
		financialInstitutionNPI.fillFinancialInstInfoFromExcelABANPI().clickContinueAV();
	}

	@Then("^User fills NPI No and other information with Incorrect/Improper/Null RTN No on Financial Institution Information NPI page for ABA Validator$")
	public void user_fills_NPI_No_and_other_information_with_Incorrect_Improper_Null_RTN_No_on_Financial_Institution_Information_NPI_page_for_ABA_Validator() throws Throwable {
		financialInstitutionNPI.fillFinancialInstInfoFromNPIABA(null)
							   .fillFinancialInstInfoFromNPIABA(Long.toString(Helper.generateRandomNumber(5)))
						       .fillFinancialInstInfoFromNPIABA(Helper.generateRandomAlphaNumericString(9))
						       .fillFinancialInstInfoFromNPIABA(Long.toString(Helper.generateRandomNumber(9)))
;

	}
	
	@Then("^Users clears the RTN No on NPI page fill the new RTN No and validate the details and click on Save changes button$")
	public void users_clears_the_RTN_No_on_NPI_page_fill_the_new_RTN_No_and_validate_the_details_and_click_on_Save_changes_button() throws Throwable {
		financialInstitutionNPI.clearNfillRTNNoABANPI();
	}
	@Then("^User fills all the information of Financial Institution Information NPI page and click continue for AV\\.$")
	public void user_fills_all_the_information_of_Financial_Institution_Information_NPI_page_and_click_continue_for_AV() throws Throwable {
		
		financialInstitutionNPI.fillFinancialInstInfoForNPI().clickContinueAV();
	}
	
	@Then("^User clicks on hyperlink 'where can I find a finantial Institution's routing number\\?'\\.$")
	public void user_clicks_on_hyperlink_where_can_I_find_a_finantial_Institution_s_routing_number() throws Throwable {
		financialInstitutionNPI.clickFIIRoutingNumNPI();
	}
	
	@Then("^User validates the various default input like Typ of account,Supporting doc,NPI Bank Account and it can be changed\\.$")
	public void user_validates_the_various_default_input_like_Typ_of_account_Supporting_doc_NPI_Bank_Account_and_it_can_be_changed() throws Throwable {
	financialInstitutionNPI.verifyFinAccount("TypeOfAc").verifyFinAccount("SupportDoc").verifyFinAccount("NPIBankAc");
	}
	
	@Then("^User clicks on browse and upload its supporting document on NPI Page\\.$")
	public void user_clicks_on_browse_and_upload_its_supporting_document() throws Throwable {
		financialInstitutionNPI.uploadBankLetterPdfWithAcceptance();
	}
	
	@Then("^User clicks on hyperlink 'how do i manage multiple NPI bank accounts\\?'$")
	public void user_clicks_on_hyperlink_how_do_i_manage_multiple_NPI_bank_accounts() throws Throwable {
		financialInstitutionNPI.clickFINMngNPIAcc();
	}
	
	@Then("^User fills all the information on Financial Institution Information NPI page and click continue NPI\\.$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_page_and_click_continue_NPI() throws Throwable {
		financialInstitutionNPI.fillFinancialInstInfoForNPI().clickNPIYes().clickContinueNPI();
	}
	
	

	@Then("^User validates functionality of different buttons like Back,cancel enrollment,Continue\\(Yes/No on Continue\\) by clicking\\.$")
	public void user_validates_functionality_of_different_buttons_like_Back_cancel_enrollment_Continue_Yes_No_on_Continue_by_clicking() throws Throwable {
	 	financialInstitutionNPI.verifyButtons();
	}
	
	@Then("^User clicks on continue button of FII NPI page and validtes the error messages\\.$")
	public void user_clicks_on_continue_button_of_FII_NPI_page_and_validtes_the_error_messages() throws Throwable {
		financialInstitutionNPI.verifyErrors();
	}
	
	@Then("^User validates various input field by giving blank input and clicking continue button\\.$")
	public void user_validates_various_input_field_by_giving_blank_input_and_clicking_continue_button() throws Throwable {
		financialInstitutionNPI.fillInsufficientFinancialInstInfoForNPI("NpiNumber").clickContinueNPI()
							   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstName")
							   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstStreet")
							   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstCity")
							   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstState")
							   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstZipCode")
							   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("PhoneNo")
							   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstroutingNo")
							  .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstaccountNo")
							  .clickEditlink().fillInsufficientFinancialInstInfoForNPI("NofileUpload")
							  .fillInsufficientFinancialInstInfoForNPI("NonPdfUpload")
							   ;
	}
	
	@Then("^User validates various input field by giving nonnumeric data input and clicking continue button\\.$")
	public void user_validates_various_input_field_by_giving_nonnumeric_data_input_and_clicking_continue_button() throws Throwable {
		financialInstitutionNPI.fillInsufficientFinancialInstInfoForNPI("NonNumericNPI")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("NonNumericPhone")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("NonNumericroutingNo")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("NonNumericAccountNo");
		
		  
	}
	
	@Then("^User validates error messages by giving PO BOX No in Street field,Invalid zip/state code incomplete phoneno\\.$")
	public void user_validates_error_messages_by_giving_PO_BOX_No_in_Street_field_Invalid_zip_state_code_incomplete_phoneno() throws Throwable {
	 	financialInstitutionNPI.fillInsufficientFinancialInstInfoForNPI("POBoxNoInStreet")
		.clickEditlink().fillInsufficientFinancialInstInfoForNPI("AlphaZipCode")
		.clickEditlink().fillInsufficientFinancialInstInfoForNPI("UnMatchedAddress")
		.clickEditlink().fillInsufficientFinancialInstInfoForNPI("IncompPhoneNo")
		;
	}
	
	@Then("^User validates error messages when  TIN no and NPI no are same\\.$")
	public void user_validates_error_messages_when_TIN_no_and_NPI_no_are_same() throws Throwable {
		financialInstitutionNPI.fillInsufficientFinancialInstInfoForNPI("SameNPI&TIN");
	}
	
	@Then("^User Validates UI content with DataBase enrties\\.$")
	public void user_Validates_UI_content_with_DataBase_enrties() throws Throwable {
		financialInstitutionNPI.verifyUIContentFromDB();
	}

	@Then("^User verifies that FII-NPI fields are editables$")
	public void user_verifies_that_FII_NPI_fields_are_editables() throws Throwable {
		financialInstitutionNPI.verifyEditable();
	}
	@Then("^User fills all the information on Financial Institution Information NPI page and click Save Changes$")
	public void user_fills_all_the_information_on_Financial_Institution_Information_NPI_page_and_click_Save_Changes() throws Throwable {
		financialInstitutionNPI.clickEditlink().fillFinancialInstInfoForNPI().clickContinueNPI(); 
	}
	
	@Then("^User validates the Cancel Changes and Save changes buttons,click on Cancel Changes button$")
	public void user_validates_the_Cancel_Changes_and_Save_changes_buttons_click_on_Cancel_Changes_button() throws Throwable {
		financialInstitutionNPI.verifyChangeButtons();
	}
	
	@Then("^User clicks on Edit link to upload doc and validates Cancel button is disabled$")
	public void user_clicks_on_Edit_link_to_upload_doc_validates_Cancel_button_is_disabled() throws Throwable {
		financialInstitutionNPI.verifyUploadedDoc();
	}
	@Then("^User fills invalid information on FII NPI page and click Save Changes, an error will be there and Cancel Changes button is disabled$")
	public void user_fills_invalid_information_on_FII_NPI_page_and_click_Save_Changes_an_error_will_be_there_and_Cancel_Changes_button_is_disabled() throws Throwable {
		financialInstitutionNPI.validateInvaidInfo();
	}
	
	@Then("^User validates various input field by giving blank input and clicking Save Changes button\\.$")
	public void user_validates_various_input_field_by_giving_blank_input_and_clicking_Save_Changes_button() throws Throwable {
		financialInstitutionNPI.clickEditlink().fillInsufficientFinancialInstInfoForNPI("NpiNumber").clickContinueNPI()
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstName")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstStreet")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstCity")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstState")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstZipCode")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("PhoneNo")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstroutingNo")
		  .clickEditlink().fillInsufficientFinancialInstInfoForNPI("financialInstaccountNo")
		  .clickEditlink().fillInsufficientFinancialInstInfoForNPI("NofileUpload")
		   ;
	}

	@Then("^User validates various input field by giving nonnumeric data input and clicking Save Changes button\\.$")
	public void user_validates_various_input_field_by_giving_nonnumeric_data_input_and_clicking_Save_Changes_button() throws Throwable {
		financialInstitutionNPI.clickEditlink().fillInsufficientFinancialInstInfoForNPI("NonNumericNPI")
			.clickEditlink().fillInsufficientFinancialInstInfoForNPI("NonNumericPhone")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("NonNumericroutingNo")
		   .clickEditlink().fillInsufficientFinancialInstInfoForNPI("NonNumericAccountNo");
		  
	}

	@Then("^User validates error messages by giving PO BOX No in Street field,Invalid zip/state code,incomplete phoneno and click on Save Change\\.$")
	public void user_validates_error_messages_by_giving_PO_BOX_No_in_Street_field_Invalid_zip_state_code_incomplete_phoneno_and_click_on_Save_Change() throws Throwable {
		financialInstitutionNPI.clickEditlink().fillInsufficientFinancialInstInfoForNPI("POBoxNoInStreet")
		.clickEditlink().fillInsufficientFinancialInstInfoForNPI("AlphaZipCode")
		.clickEditlink().fillInsufficientFinancialInstInfoForNPI("UnMatchedAddress")
		.clickEditlink().fillInsufficientFinancialInstInfoForNPI("IncompPhoneNo")
		;
		
	}
	 
	@Then("^User clicks Save Changes Button on Financial Institution Information NPI page\\.$")
	public void user_clicks_continue_on_Financial_Institution_Information_NPI_page() throws Throwable {
		financialInstitutionNPI.clickSaveChanges();
	}

	
}
