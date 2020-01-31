package main.java.stepDefinitions.CrtEnrolmnt;


import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.EnrollmentSubmitted;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ReviewAndSubmit;
import cucumber.api.java.en.And;
import main.java.Utils.Helper;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;
import main.java.pageObjects.SelectPaymentMethods;
import main.java.pageObjects.UploadW9;
import main.java.pageObjects.ValidateEFTERAProviderInfo;

public class ReviewAndSubmitSteps extends TestBase {
	
	ReviewAndSubmit reviewAndSubmit=new ReviewAndSubmit(testConfig);
	
	@Then("^Validate Edit option appears next to Oranization Information$")
	public void validate_Edit_option_appears_next_to_Oranization_Information() throws Throwable {
		reviewAndSubmit.clickEditOrgButton();
	}
	@Then("^User validateds multiple Edit option on Review and Submit Page$")
	public void user_validateds_multiple_Edit_option_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.verifyEditHyperLinks();
	}
	@And("^Validate User is  redirected to Review and Submit Page and No changes are saved\\.$")
	public void validate_User_is_redirected_to_Review_and_Submit_Page_and_No_changes_are_saved() throws Throwable {
	    reviewAndSubmit.verifyOrgInfo();
	}

	@Then("^Validate User is  redirected to Review and Submit Page and changes are saved\\.$")
	public void validate_User_is_redirected_to_Review_and_Submit_Page_and_changes_are_saved() throws Throwable {
	    reviewAndSubmit.verifyOrgInfo();
	}

	@Then("^Validate Edit option appears next to Identify Administrators Information$")
	public void validate_Edit_option_appears_next_to_Identify_Administrators_Information() throws Throwable {
		reviewAndSubmit.clickEditAdminInfo();
	}

	@Then("^Vaidates Headers in Review and Submit page$")
	public void vaidate_Headers_in_Review_and_Submit_page() throws Throwable {
		new HeaderContentValidation(testConfig).verifyHeaders("Review and Submit");
		
	}
	
	@Then("^Vaidates Edit Links on Review and Submit page$")
	public void vaidate_Edit_Links_on_Review_and_Submit_page() throws Throwable {
	    reviewAndSubmit.verifyEditLinks();
		
	}
	
	@Then("^Vaidates Terms and condition Pdf download$")
	public void vaidate_Terms_and_condition_Pdf_download() throws Throwable {
	  	reviewAndSubmit.verifyTermConditionPdfDownl();
	}

	@Then("^User validates Authorized Enroller Information fields\\.$")
	public void user_validates_Authorized_Enroller_Information_fields() throws Throwable {
	   	reviewAndSubmit.fillAuthorizedEnrollersInfo();
	}
	
	@Then("^Validates Submit button is enabled when Terms & conditions is clicked$")
	public void validate_Submit_button_is_enabled_when_Terms_conditions_is_clicked() throws Throwable {
	  	reviewAndSubmit.verifySubmitEnrollButton();
	}
	
	@Then("^Validates Cancel Enrollment, Back and Submit Enrollment options display$")
	public void validate_Cancel_Enrollment_Back_and_Submit_Enrollment_options_display() throws Throwable {
	   	reviewAndSubmit.verifyReviewSubmitPageButtons();
	}
	
	@Then("^Validates Back button functionality$")
	public void validate_Back_button_functionality() throws Throwable {
	  	reviewAndSubmit.validateBackButton();
	}
	
	@Then("^Validate Cancel Enrollment popup$")
	public void validate_Cancel_Enrollment_popup() throws Throwable {
	   	reviewAndSubmit.verifyCancelEnrollmentFlow();
	}
	
	@Then("^Validates Error Messages on Review and Submit Page$")
	public void validate_Error_Messages_on_Review_and_Submit_Page() throws Throwable {
	   	reviewAndSubmit.verifyErrorMsgNull();
	}
	
	@Then("^Validates Invalid Data Error Messages on Review and Submit Page$")
	public void validate_Invalid_Data_Error_Messages_on_Review_and_Submit_Page() throws Throwable {
	   reviewAndSubmit.VerifyInvalidDataError();
	}
	
	@Then("^Validates Invalid Data Error Messages for Email Address on Review and Submit Page$")
	public void validate_Invalid_Data_Error_Messages_for_Email_Address_on_Review_and_Submit_Page() throws Throwable {
	   	reviewAndSubmit.VerifyEmailInvalidDataError("inpFormatOne","Email").VerifyEmailInvalidDataError("inpFormatTwo","Email");
		reviewAndSubmit.VerifyEmailInvalidDataError("inpFormatOne","RetypeEmail").VerifyEmailInvalidDataError("inpFormatTwo","RetypeEmail");
	}
	
	@Then("^Fill Authorize Enrollers Info and click on submit button on Review and Submit Page\\.$")
	public void fill_Authorize_Enrollers_Info_and_click_on_submit_button_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.fillInfoAndClickSubmit();
	}
	
	@Then("^Validates Edit option next to each field on Review and Submit page$")
	public void validate_Edit_option_next_to_each_field_on_Review_and_Submit_page() throws Throwable {

		reviewAndSubmit.verifyEditLinks();
	}
	
	@Then("^Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page$")
	public void click_on_Edit_on_financial_Institution_Section_and_validate_user_navigates_to_Financial_Institution_Information_Page() throws Throwable {

		reviewAndSubmit.clickFinancialInfoEditLink();
	}
	
	@Then("^Validate no changes are saved on Review Submit Page for Financial Institution section\\.$")
	public void validate_no_changes_are_saved_on_Review_Submit_Page_for_Financial_Institution_section() throws Throwable {
		reviewAndSubmit.verifyCancelChangesFinancialInfoEdit();
	}
	
	@Then("^User click back button on Review and Submit Page$")
	public void user_click_back_button_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.validateBackButton();
	}
	
	@Then("^Validate the changes are reflected on Review and Submit Page\\.$")
	public void validate_the_changes_are_reflected_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.verifySavedChangesFinInsInfo();
	}
	
	@Then("^User navigates to ReviewAndSubmit page and click on edit icon$")
	public void user_navigates_to_ReviewAndSubmit_page_and_click_on_edit_icon() throws Throwable {
		reviewAndSubmit.clickIdentifyEditLink();
	}
	
	@Then("^validates no changes are saved for Identify Admin Section on Review and Submit Page\\.$")
	public void validates_no_changes_are_saved_for_Identify_Admin_Section_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.verifyCancelChangesIdentifyAdminEdit();
	}
	
	@Then("^Validate changes are reflected on Review and Submit Page$")
	public void validate_changes_are_reflected_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.verifySavedChangesIdentifyAdmin();
	}
	
	@Then("^User clicks on Financial Institution Information NPI page Edit link$")
	public void user_clicks_on_Financial_Institution_Information_NPI_page_Edit_link() throws Throwable {
		reviewAndSubmit.clickEditNPI();
	}
	@Then("^User clicks on Financial Institution Information NPI page remove link and validate it is removed\\.$")
	public void user_clicks_on_Financial_Institution_Information_NPI_page_remove_link_and_validate_it_is_removed() throws Throwable {
		reviewAndSubmit.clickRemoveNPI();
	}
	@Then("^User verifies that uploaded document is present on Review and Submit Page$")
	public void user_verifies_that_uploaded_document_is_present_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.verifyUpldDoc("FIINPI");
	}
	
	@Then("^User verifies content of FII-NPI on Review and Submit Page$")
    public void user_verifies_content_of_FII_NPI_on_Review_and_Submit_Page() throws Throwable {
		reviewAndSubmit.verifyFIINPICOntent();
	}
	@Then("^User fills valid information on FII NPI page and click Save Changes, an verifies changes on Review Submit Page$")
	public void user_fills_valid_information_on_FII_NPI_page_and_click_Save_Changes_an_verifies_changes_on_Review_Submit_Page() throws Throwable {
		reviewAndSubmit.verifyFIINPICOntent();
	}
	
	@Then("^User verifies that uploaded document is present on Review and Submit Page on TIN Section$")
	public void user_verifies_that_uploaded_document_is_present_on_Review_and_Submit_Page_on_TIN_Section() throws Throwable {
		reviewAndSubmit.verifyUpldDoc("FII");
	}
}
