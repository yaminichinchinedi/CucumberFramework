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


	public void user_validates_contents_of_Plan_Type_tile_of_this_page() throws Throwable {
		optPaySoln.validatePlanTypeTile();
	}
	@Then("^User then validates the Change Rate popup based \"([^\"]*)\"$")
	public void user_then_validates_the_Change_Rate_popup_based(String credentials) throws Throwable {
		optPaySoln.validateChangeRatePopup(credentials);
	}
	@Then("^User validates the hover on info icon on the tiles$")
	public void user_validates_the_hover_on_info_icon_on_the_tiles() throws Throwable {
		optPaySoln.validateInfoIconHover();
	}

}
