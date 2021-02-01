package main.java.stepDefinitions.OptumPaySoln;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.MyProfile;
import main.java.pageObjects.OptumPaySoln;

public class OptumPaySolnSteps extends TestBase {

	OptumPaySoln optPaySoln=new OptumPaySoln(testConfig);

	@Then("^User validates Tiles of this page in order$")
	public void user_validates_Tiles_of_this_page_in_order() throws Throwable {
		optPaySoln.validateTitleNames();
	}
	
	@Then("^User validates contents of Fee tiles of this page$")
	public void user_validates_contents_of_Fee_tiles_of_this_page() throws Throwable {
		optPaySoln.validateFeeTitle();
	}	
	
	@When("^User Validates Error Message upon Entering \"([^\"]*)\" on Optum Pay Solution$")
	public void User_Validates_Error_Message_upon_Entering_Invalid_Tin_on_Optum_Pay_Solution(String InvalidTIN) throws Throwable {
		optPaySoln.verifyInvalidTINonOptumPaySolution(InvalidTIN);
	}
}
