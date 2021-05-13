package main.java.stepDefinitions.ReourcesPreLogin;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ResourcesPreLogin;

public class ResourcesSteps extends TestBase {

	ResourcesPreLogin rPreLogin = new ResourcesPreLogin(testConfig);

	@Then("^user clicks on the cancellation link and verifies the url$")
	public void user_clicks_on_the_cancellation_link_and_verifies_the_url() throws Throwable {
		rPreLogin.verifyCancellationFormLinkUnderResourcesPreLogin();
	}

		
	@Then("^user validates cancellation pdf form content$")
	public void user_validates_cancellation_pdf_form_content() throws Throwable {
		rPreLogin.verifyCancellationFormLinkPDFContent();
	}

}
