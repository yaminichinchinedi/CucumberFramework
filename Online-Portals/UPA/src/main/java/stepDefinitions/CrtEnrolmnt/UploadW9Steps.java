package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.UploadW9;
import main.java.pageObjects.ValidateEFTERAProviderInfo;

public class UploadW9Steps extends TestBase {
	
	UploadW9 uploadW9=new UploadW9(testConfig);
	
	@Then("^User uploads the WNine form and click continue$")
	public void user_uploads_the_W_form_and_click_continue() throws Throwable {
		uploadW9.uploadW9();
	}
	
	@Then("^clicks back button on Upload WNine Page\\.$")
	public void clicks_back_button_on_Upload_WNine_Page() throws Throwable {
		Browser.wait(testConfig, 2);
		uploadW9.clickBackButton();
	}
	

	@Then("^User navigates to Upload w(\\d+) page and validate its headers$")
	public void user_navigates_to_Upload_w_page_and_validate_its_headers(int arg1) throws Throwable {
		uploadW9.verifyHeaders();
	}

	@Then("^User Validates Back,Cancel Enrollment and Continue button presence and its functionality on upload w(\\d+) page$")
	public void user_Validates_Back_Cancel_Enrollment_and_Continue_button_presence_and_its_functionality_on_upload_w_page(int arg1) throws Throwable {
		uploadW9.verifyFootersContent();
	}

	@When("^User clicks on back button it navigates to Identify Admin Page$")
	public void user_clicks_on_back_button_it_navigates_to_Identify_Admin_Page() throws Throwable {
		uploadW9.verifyProvierAdmin();

	}

	@Then("^User click on Cancel Enrollment verifies its popup content and YES/NO button functionality$")
	public void user_click_on_Cancel_Enrollment_verifies_its_popup_content_and_YES_NO_button_functionality() throws Throwable {
		new ValidateEFTERAProviderInfo(testConfig).clickContinueToW9().verifyClckCancEnroll();
	}

	@Then("^User clicks on link Federal W(\\d+) Form here,validates its content$")
	public void user_clicks_on_link_Federal_W_Form_here_validates_its_content(int arg1) throws Throwable {
		uploadW9.verifyClckNo().verifyFederalW9link();
	}

}

