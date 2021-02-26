package main.java.stepDefinitions.CrtEnrolmnt;

import main.java.pageObjects.PopularFaq;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.nativeFunctions.Element;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.PopularFaq;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;

public class UPAPopularFaqSteps extends TestBase {
		
	PopularFaq popularFaq=new PopularFaq(testConfig);
	
	@When("^User scrolls to popular FAQ section$")
	public void user_scrolls_to_popularFaqs_section() throws Throwable {
		popularFaq.verifyPopularFAQSectionPresent();
	}
	
	@Then("^Verify all Popular FAQ links are present$")
	public void verify_all_popularFaqs_links_are_present() throws Throwable {
		popularFaq.verifyAllLinksPresent();
	}
	
	
	@Then("^Click on VIEW ALL FAQs button and verify all FAQs are present$")
	public void click_on_VIEW_ALL_FAQs_button_and_verify_all_FAQs_are_present() throws Throwable {
		popularFaq.viewAllFaqButtonAvailable();
		popularFaq.linkRedirectToFaq();
	}
}