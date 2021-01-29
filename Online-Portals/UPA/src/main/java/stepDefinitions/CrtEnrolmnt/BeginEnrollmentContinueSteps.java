package main.java.stepDefinitions.CrtEnrolmnt;

import java.util.List;

import main.java.pageObjects.UPARegistrationPage;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
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
	
	@Given("^User navigates to UPA Sys Test application$")
	public void user_navigates_to_UPA_Sys_Test_application () throws Throwable {
		
		registrationPage = new UPARegistrationPage(testConfig);
		
	  
	}

	@When("^User Clicks on Enroll Now from the landing page$")
	public void user_Clicks_on_Enroll_Now_from_the_landing_page() throws Throwable {
	   
		 beginEnrollmentPage=  registrationPage.clickEnrollNow();   
	}

	@Then("^User Validates link Download Virtual Card Payment Enrollment Guide Link  and click on it$")
	public void user_Validates_link_Download_Virtual_Card_Payment_Enrollment_Guide_Link_and_click_on_it() throws Throwable {
		beginEnrollmentPage.validateUserIsAbleToDwnldEnrlmntPdf();
	}
	@Then("^User Select a How you heard option and  click on Continue button$")
	public void user_Select_a_How_you_heard_option_and_click_on_Continue_button() throws Throwable {
		beginEnrollmentContinuePage=beginEnrollmentPage.selectHowYouHeard(option); 
	}
	@Then("^User clicks on which option should i choose link and close the opened popup$")
	public void user_clicks_on_which_option_should_i_choose_link_and_close_the_opened_popup() throws Throwable {
		beginEnrollmentContinuePage.verifyHowtoChooseLink();

	}
	
	@Then("^Select Enrollment Type as BS$")
	public void select_Enrollment_Type_as_BS() throws Throwable {
		beginEnrollmentContinuePage.clickRdoBS();
	}
	
	@Then("^Verify option to Select TIN/SSN is there and input box is present\\.$")
	public void verify_option_to_Select_TIN_SSN_is_there_and_input_box_is_present() throws Throwable {
	    beginEnrollmentContinuePage.verifyTinRdo();
	}
	
	@And("^Verify Change Link is Present for BS\\.$")
	public void verify_Change_Link_is_Present_for_BS() throws Throwable {
	   beginEnrollmentContinuePage.verifyChangeLink();
	}
	
	@Then("^Click Cancel Enrollment button and Verify its functionality\\.$")
	public void click_Cancel_Enrollment_button_and_Verify_its_functionality() throws Throwable {
	    beginEnrollmentContinuePage.verifyCancelEnrollmentFunctionality();
	}
	
	@Then("^Enter Incorrect Tin and Verify Error msgs\\.$")
	public void enter_Incorrect_Tin_and_Verify_Error_msgs() throws Throwable {
	    beginEnrollmentContinuePage.verifyErrorMsg();
	}
	
	@Then("^Click Cancel Enrollment button and Verify its content\\.$")
	public void click_Cancel_Enrollment_button_and_Verify_its_content() throws Throwable {
		beginEnrollmentContinuePage.verifyCnclEnrlmntPoppUptxt();
	}
}
