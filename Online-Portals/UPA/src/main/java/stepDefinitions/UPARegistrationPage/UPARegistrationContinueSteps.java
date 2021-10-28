package main.java.stepDefinitions.UPARegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BenefitsOfOptumPay;
import main.java.pageObjects.HowToEnroll;
import main.java.pageObjects.ResourcesPreLogin;
import main.java.pageObjects.UPARegistrationPage;

public class UPARegistrationContinueSteps extends TestBase {

	String option="Health plan communication";
	int excelRow=0;
	UPARegistrationPage registrationPage=null;
	BenefitsOfOptumPay benOfOptumPay =null;
	BeginEnrollment beginEnrollmentPage=null;
	HowToEnroll howToEnroll = null;
	ResourcesPreLogin resources=null;
	
	@Given("^User navigates to UPA Sys Test application$")
	public void user_navigates_to_UPA_Sys_Test_application () throws Throwable {
		registrationPage = new UPARegistrationPage(testConfig); 
	}

	
	@When("^User Clicks on Benefits Of Optum Pay from the landing page$")
	public void user_Clicks_on_Benefits_Of_Optum_Pay_from_the_landing_page() throws Throwable
	{
		benOfOptumPay = registrationPage.clickBenefitsOfOptumPayLink();
	}
	
	@When("^User Clicks on Enroll Now from the landing page$")
	public void user_Clicks_on_Enroll_Now_from_the_landing_page() throws Throwable {
	   
		 beginEnrollmentPage=  registrationPage.clickEnrollNow();   
	}
	
	@When("^User validates that Enroll Now and Benefits of Optum pay button are there$")
	public void User_validates_that_Enroll_Now_and_Benefits_of_Optum_pay_button_are_there() throws Throwable {
	   
		 registrationPage.verifyBenefitsOfOptumPayAndEnrollNowButtons();   
	}
	
	@When("^User validates all headers links Benefits of Optum Pay,How to Enroll,Optum Finantial Logo$")
	public void User_validates_all_headers_links_Benefits_of_Optum_Pay_How_to_Enroll_Optum_Finantial_Logo() throws Throwable {
	   
		 registrationPage.verifyAllHeaderLinks();   
	}
	
	@When("^User clicks on Alternative payments routing options and validates the navigation$")
	public void User_clicks_on_Alternative_payments_routing_options_and_validates_the_navigation() throws Throwable {
	   
		 registrationPage.navigatingAlternativePaymentSection();   
	}
	
	@When("^User Clicks on How to Enroll link section of homepage$")
	public void User_Clicks_on_How_to_Enroll_link_section_of_homepage() throws Throwable {
	   
		howToEnroll =  registrationPage.clickHowToEnrollLink();  
	}
	
	@When("^User clicks on Resources section of homepage$")
	public void User_clicks_on_Resources_section_of_homepage() throws Throwable {
	   
		resources =  registrationPage.clickResourcesLink();  
	}
	
	@When("^User validates Guides and Forms and Documents section$")
	public void User_validates_Guides_and_Forms_and_Documents_section() throws Throwable {
	   
		resources.verificationOfGuides();  
	}
	
	
		
	
}
