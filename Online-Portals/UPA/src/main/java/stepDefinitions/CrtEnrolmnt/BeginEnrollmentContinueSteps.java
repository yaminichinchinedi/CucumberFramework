package main.java.stepDefinitions.CrtEnrolmnt;

import java.util.List;

import main.java.pageObjects.UPARegistrationPage;
import cucumber.api.DataTable;
//import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Runner.DemoTestNGRunner;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
//import main.java.stepDefinitions.support.Hook;
//import main.java.stepDefinitions.support.SuperStepDef;
import main.java.pageObjects.ProviderEFTERAEnrollPage;


public class BeginEnrollmentContinueSteps extends TestBase {

	String option="Health plan communication";
	int excelRow=0;
	UPARegistrationPage registrationPage=null;
	BeginEnrollment beginEnrollmentPage=null;
	BeginEnrollmentContinue beginEnrollmentContinuePage=null;
	ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	//TestBase testConfig=null;
	//SuperStepDef supdef=null;
	
//	 public CrtEnrlflow(Hook hook) {
//		super(hook);
//	}
	
	@Given("^User navigates to UPA Sys Test application$")
	public void user_navigates_to_UPA_Sys_Test_application () throws Throwable {
		
		
		registrationPage = new UPARegistrationPage(testConfig);
	    
	}

	@When("^User Clicks on Enroll Now from the landing page$")
	public void user_Clicks_on_Enroll_Now_from_the_landing_page() throws Throwable {
	   
		 beginEnrollmentPage=  registrationPage.clickEnrollNow();   
	}

	@Then("^User Select a How you heard option and  click on Continue button$")
	public void user_Select_a_How_you_heard_option_and_click_on_Continue_button() throws Throwable {
		beginEnrollmentContinuePage=beginEnrollmentPage.selectHowYouHeard(option); 
	}
	
	//
	
}
