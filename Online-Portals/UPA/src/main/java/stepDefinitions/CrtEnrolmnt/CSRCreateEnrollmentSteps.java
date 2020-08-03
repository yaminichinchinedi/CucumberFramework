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
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.CreateEnrollUsrTyp;
import main.java.pageObjects.CrtEnrollValidateTIN;
import main.java.pageObjects.ProviderEFTERAEnrollPage;

public class CSRCreateEnrollmentSteps extends TestBase {

	String option="Health plan communication";
	int excelRow=0;
	UPARegistrationPage registrationPage=null;
	BeginEnrollment beginEnrollmentPage=null;
	BeginEnrollmentContinue beginEnrollmentContinuePage=null;
	ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;






	CreateEnrollUsrTyp usrTyp=new CreateEnrollUsrTyp(testConfig);
	CrtEnrollValidateTIN validateTIN=null;
	@Then("^User Select User Type as \"([^\"]*)\" and enter unique TIN and click Search$")
	public void user_Select_User_Type_as_and_enter_unique_TIN_and_click_Search(String userType) throws Throwable {
		
		usrTyp.selectUserType(userType);
		

	}

	@Then("^User select Yes button of TIN not enrolled page$")
	public void user_select_Yes_button_of_TIN_not_enrolled_page() throws Throwable {
		validateTIN=new CrtEnrollValidateTIN(testConfig);
		Browser.wait(testConfig, 3);
		validateTIN.clickYesButton();
	}

	@Then("^User select User Type Enrollment as \"([^\"]*)\" and click continue button$")
	public void user_select_User_Type_Enrollment_as_and_click_continue_button(String EnrollType) throws Throwable {
		validateTIN.clickEnrolUsrTyp(EnrollType);
		
	}
}
