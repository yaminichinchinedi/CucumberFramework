package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.EnrollmentSubmitted;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ReviewAndSubmit;

public class ReviewAndSubmitSteps extends TestBase {
	
	ReviewAndSubmit reviewAndSubmit=null;
	EnrollmentSubmitted enrollmentSubmitted=null;
	
	@Then("^Vaidates Headers in Review and Submit page$")
	public void vaidate_Headers_in_Review_and_Submit_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit=new ReviewAndSubmit(testConfig);
		new HeaderContentValidation(testConfig).verifyHeaders("Review and Submit");
		
	}
	
	@Then("^Vaidates Edit Links on Review and Submit page$")
	public void vaidate_Edit_Links_on_Review_and_Submit_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit=new ReviewAndSubmit(testConfig);
		reviewAndSubmit.verifyEditLinks();
		
	}
	
	@Then("^Vaidates Terms and condition Pdf download$")
	public void vaidate_Terms_and_condition_Pdf_download() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		reviewAndSubmit=new ReviewAndSubmit(testConfig);
		reviewAndSubmit.verifyTermConditionPdfDownl();
	}

	@Then("^User validates Authorized Enroller Information fields\\.$")
	public void user_validates_Authorized_Enroller_Information_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit=new ReviewAndSubmit(testConfig);
		reviewAndSubmit.fillAuthorizedEnrollersInfo();
	}
	
	@Then("^Validates Submit button is enabled when Terms & conditions is clicked$")
	public void validate_Submit_button_is_enabled_when_Terms_conditions_is_clicked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		reviewAndSubmit.verifySubmitEnrollButton();
	}
	
	@Then("^Validates Cancel Enrollment, Back and Submit Enrollment options display$")
	public void validate_Cancel_Enrollment_Back_and_Submit_Enrollment_options_display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		reviewAndSubmit.verifyReviewSubmitPageButtons();
	}
	
	@Then("^Validates Back button functionality$")
	public void validate_Back_button_functionality() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		reviewAndSubmit.validateBackButton();
	}
	
	@Then("^Validate Cancel Enrollment popup$")
	public void validate_Cancel_Enrollment_popup() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		reviewAndSubmit.verifyCancelEnrollmentFlow();
	}
	
	@Then("^Validates Error Messages on Review and Submit Page$")
	public void validate_Error_Messages_on_Review_and_Submit_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		reviewAndSubmit.verifyErrorMsgNull();
	}
	
	@Then("^Validates Invalid Data Error Messages on Review and Submit Page$")
	public void validate_Invalid_Data_Error_Messages_on_Review_and_Submit_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		reviewAndSubmit.VerifyInvalidDataError();
	}
	
	@Then("^Validate Invalid Data Error Messages for Email Address on Review and Submit Page$")
	public void validate_Invalid_Data_Error_Messages_for_Email_Address_on_Review_and_Submit_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		reviewAndSubmit.VerifyEmailInvalidDataError("inpFormatOne","Email").VerifyEmailInvalidDataError("inpFormatTwo","Email");
		reviewAndSubmit.VerifyEmailInvalidDataError("inpFormatOne","RetypeEmail").VerifyEmailInvalidDataError("inpFormatTwo","RetypeEmail");
	}

	@Then("^Validates the Data saved in Database on submit of Enrollment$")
	public void validate_the_Data_saved_in_Database_on_submit_of_Enrollment() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		reviewAndSubmit =new ReviewAndSubmit(testConfig);
		enrollmentSubmitted=reviewAndSubmit.fillInfoAndClickSubmit();
		enrollmentSubmitted.validateEnrollmentInfo();
	}

}
