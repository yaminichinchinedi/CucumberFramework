package main.java.stepDefinitions.UPARegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BenefitsOfOptumPay;
import main.java.pageObjects.UPARegistrationPage;

public class UPARegistrationContinueSteps extends TestBase {

	String option="Health plan communication";
	int excelRow=0;
	UPARegistrationPage registrationPage=null;
	BenefitsOfOptumPay benOfOptumPay =null;
	BeginEnrollment beginEnrollmentPage=null;
	
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
		
	
}
