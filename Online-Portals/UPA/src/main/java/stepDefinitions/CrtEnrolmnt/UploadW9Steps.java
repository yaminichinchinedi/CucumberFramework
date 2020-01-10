package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.UploadW9;

public class UploadW9Steps extends TestBase {
	
	UploadW9 uploadW9=new UploadW9(testConfig);
	
	@Then("^User uploads the WNine form and click continue$")
	public void user_uploads_the_W_form_and_click_continue() throws Throwable {
		uploadW9.uploadW9();
	}
	
	@Then("^clicks back button on Upload WNine Page\\.$")
	public void clicks_back_button_on_Upload_WNine_Page() throws Throwable {
		uploadW9.clickBackButton();
	}
}

