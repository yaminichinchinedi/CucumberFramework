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
	@Then("^User clicks on Continue button of BeginEnrollment Page$")
	public void user_clicks_on_Continue_button_of_BeginEnrollment_Page() throws Throwable {
		beginEnrollmentPage.clickContinue();
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

	@Then("^User Validates all the UI content with database for BeginEnrollment Page$")
	public void user_Validates_all_the_UI_content_with_database_for_BeginEnrollment_Page() throws Throwable {
		beginEnrollmentPage.verifyNewPageContent(); 
	}



	@Then("^User clicks on which option should i choose link,validates its content and close the opened popup$")
	public void user_clicks_on_which_option_should_i_choose_link_validates_its_content_and_close_the_opened_popup() throws Throwable {
		beginEnrollmentContinuePage.verifyChooseLink();
	}

	@Then("^User validates on Clicking on Change link,beside of Enrollment type$")
	public void user_validates_on_Clicking_on_Change_link_beside_of_Enrollment_type() throws Throwable {
		beginEnrollmentContinuePage.clickChangeLink().verifyChangeLink();
	}

	@Then("^Select \"([^\"]*)\" and verifies popup content,and button fuctionality for Cancel and I Agree button$")
	public void select_and_verifies_popup_content_and_button_fuctionality_for_Cancel_and_I_Agree_button(String arg1) throws Throwable {
		beginEnrollmentContinuePage.clickChangeLink().verifyPopUp(arg1);

	}

	@Then("^User clicks on Cancel Enrollment button and verify YES/NO button functionality$")
	public void user_clicks_on_Cancel_Enrollment_button_and_verify_YES_NO_button_functionality() throws Throwable {
		beginEnrollmentContinuePage.clickChangeLink().enrollAs(1).verifyCancelEnrollmentFunctionality();
	}

	@Then("^Select Enrollment Type as Enrollment Type and validates various messgaes by Entering null,less than (\\d+) char,Alphanumeric char,Specia char in TIN$")
	public void select_Enrollment_Type_as_Enrollment_Type_and_validates_various_messgaes_by_Entering_null_less_than_char_Alphanumeric_char_Specia_char_in_TIN(int arg1, DataTable arg2) throws Throwable {
		beginEnrollmentContinuePage.clickChangeLink().verifyErrorMsg();
	}

	@Then("^User also validats captcha Error by turning ON and OFF captcha$")
	public void user_also_validats_captcha_Error_by_turning_ON_and_OFF_captcha() throws Throwable {

	}
}
