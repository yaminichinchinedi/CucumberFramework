package main.java.stepDefinitions.CrtEnrolmnt;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;

public class CrtEnrlmntCommonStepDef extends TestBase {

	String option="Health plan communication";
	int excelRow=0;
	UPARegistrationPage registrationPage=null;
	BeginEnrollment beginEnrollmentPage=null;
	BeginEnrollmentContinue beginEnrollmentContinuePage=null;
	ValidateEnrollmentTypePage validateEnrollmentTypePage=null;
	ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	ValidateEFTERAProviderInfo validateEFTERAProviderInfo=null;

	@Given("^User navigates to UPA Sys application$")
	public void user_navigates_to_UPA_Sys_application() throws Throwable {
		registrationPage = new UPARegistrationPage(testConfig);
	    
	}

	@When("^User Clicks on Enroll Now button$")
	public void user_Clicks_on_Enroll_Now_button() throws Throwable {
	   
		 beginEnrollmentPage=  registrationPage.clickEnrollNow();     
	}

	@Then("^User Selects How you heard option and  click on Continue button$")
	public void user_Selects_How_you_heard_option_and_click_on_Continue_button() throws Throwable {
		beginEnrollmentContinuePage=beginEnrollmentPage.selectHowYouHeard(option);
	    
	}

	@Then("^Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page$")
	public void select_Enrollment_Type_and_Clicks_continue_button_of_Enrollment_TIN_Eligible_page(DataTable table) throws Throwable {
		List<List<String>> EnrolmntTyps = table.raw();
		String EnrolmntTyp=EnrolmntTyps.get(1).get(0);
		if (EnrolmntTyp.equals("AO"))
		excelRow=1;
		if(EnrolmntTyp.equals("BS"))
			excelRow=2;	
		else if(EnrolmntTyp.equals("VO"))
			excelRow=4;	
		else if(EnrolmntTyp.equals("AV"))
			excelRow=3;	
 	providerEFTERAEnrollPage=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue();
	}
	
	@Then("^User fills all the info.  and clicks on Continue$")
	public void user_fills_all_the_information_and_click_on_Continue() throws Throwable {
		//ProviderEFTERAEnrollPage providerEFTERAEnrollPage=new ProviderEFTERAEnrollPage(testConfig);
		validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfo();
	    
	}
	
}
