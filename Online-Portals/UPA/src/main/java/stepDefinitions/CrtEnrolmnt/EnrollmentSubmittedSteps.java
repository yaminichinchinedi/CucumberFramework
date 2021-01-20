package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.EnrollmentSubmitted;

public class EnrollmentSubmittedSteps extends TestBase{
	
	EnrollmentSubmitted enrollmentSubmitted=new EnrollmentSubmitted(testConfig);
	
	@Then("^Validate Data is saved in Database on Enrollment Page\\.$")
	public void validate_Data_is_saved_in_Database_on_Enrollment_Page() throws Throwable {
		enrollmentSubmitted.validateEnrollmentInfo();
	}
	
	@Then("^Validate one corresponding row is inserted in Product Selection Table$")
	public void validate_one_corresponding_row_is_inserted_in_Product_Selection_Table() throws Throwable {
		enrollmentSubmitted.validateRowfrVOTIN();
	}


	@Then("^Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page$")
	public void also_Validates_page_content_Headers_Exit_Enrollment_button_on_Enrollment_Submitted_Page() throws Throwable {
		enrollmentSubmitted.verifyHeaders();
	}

	@Then("^Click on ACH Addendum link verify popup functionality and close the link$")
	public void click_on_ACH_Addendum_link_verify_popup_functionality_and_close_the_link() throws Throwable {
        enrollmentSubmitted.clickACHAddenfumRecrd();
	}

	@Then("^Also click on Print Enrollment page,download PDF and validates all the information from PDF page$")
	public void also_click_on_Print_Enrollment_page_download_PDF_and_validates_all_the_information_from_PDF_page() throws Throwable {
		enrollmentSubmitted.verifyEnrollmentFormIsDownloaded("EnrollmentPDF.pdf");
	}

	@Then("^Click on Exit Enrollment button navigates to the Optum Pay landing page$")
	public void click_on_Exit_Enrollment_button_navigates_to_the_Optum_Pay_landing_page() throws Throwable {
		enrollmentSubmitted.verifyExitEnrollemnt();
	}

	@Then("^Click on Submit Enrollment button and verify Enrollment Information$")
	public void click_on_Submit_Enrollment_button_and_verify_Enrollment_Information() throws Throwable {
		enrollmentSubmitted.validateEnrollmentInfo();
	}

	@Then("^Also click on Print Enrollment form link download PDF and verify PDF data$")
	public void also_click_on_Print_Enrollment_form_link_download_PDF_and_verify_PDF_data() throws Throwable {
		enrollmentSubmitted.verifyPDFData();
	}
}
