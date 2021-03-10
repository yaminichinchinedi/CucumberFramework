
package main.java.stepDefinitions.OptumPaySolution;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.OptumPaySolution;


public class OptumPaySolutionSteps extends TestBase {
	
OptumPaySolution optumPaySol = new OptumPaySolution(testConfig);

@Then("^User verifies Optum Pay Solution Tab for standard user with \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_verifies_Optum_Pay_Solution_Tab_for_standard_user_with_and(String trialStatus, String portalAccess) throws Throwable {
	if(portalAccess.equalsIgnoreCase("Standard"))
		optumPaySol.verifySolutionsTabForStandard(trialStatus,portalAccess);
	else if(portalAccess.equalsIgnoreCase("Premium"))
		optumPaySol.verifySolutionsTabForPremium(trialStatus,portalAccess);
}

@Then("^Verify the Cancellation Popup based on \"([^\"]*)\"$")
public void verify_the_Cancellation_Popup_based_on_trialStatus(String trialStatus) throws Throwable {
	optumPaySol.verifyCancellationPopUp(trialStatus);
}

@Then("^Validate the texts in Manage My Plan Tile$")
public void validate_the_texts_in_Manage_My_Plan_Tile() throws Throwable {
	  optumPaySol.validateManageMyPlanText().validateCancelMyPlanTextLink();
	  optumPaySol.validateFreeTrialTextNotPresent("Free Trial End Date:");

}
@Then("^User verifies the Optum Pay Solutions tiles For VO$")
	  public void user_verifies_the_tiles_in_UPA_VO() throws Throwable {
	  	optumPaySol.verifyOPSTilesForVO();
	  }
@Then("^User validates Tiles of this page in order$")
public void user_validates_Tiles_of_this_page_in_order() throws Throwable {
	optumPaySol.validateTitleNames();
}

@Then("^User validates contents of Fee tiles of this page$")
public void user_validates_contents_of_Fee_tiles_of_this_page() throws Throwable {
	optumPaySol.validateFeeTitle();
}	

@When("^User Validates Error Message upon Entering \"([^\"]*)\" on Optum Pay Solution$")
public void User_Validates_Error_Message_upon_Entering_Invalid_Tin_on_Optum_Pay_Solution(String InvalidTIN) throws Throwable {
	optumPaySol.verifyInvalidTINonOptumPaySolution(InvalidTIN);
}

@Then("^User validates contents of Plan Type tile of this page$")
public void user_validates_contents_of_Plan_Type_tile_of_this_page() throws Throwable {
	optumPaySol.validatePlanTypeTile();
}
@Then("^User then validates the Change Rate popup based \"([^\"]*)\"$")
public void user_then_validates_the_Change_Rate_popup_based(String credentials) throws Throwable {
	optumPaySol.validateChangeRatePopup(credentials);
}
@Then("^User validates the hover on info icon on the tiles$")
public void user_validates_the_hover_on_info_icon_on_the_tiles() throws Throwable {
	optumPaySol.validateInfoIconHover();
}

@Then("^User validates the Text, Dates, Rates on the Rate Tile section for given \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_validates_the_Text_Dates_Rates_on_the_Rate_Tile_section_for_given_and(String tinType, String portalAccess) throws Throwable {
	optumPaySol.rateTileCSRFeeAndDateVerification(tinType,portalAccess);
}
@Then("^User then validates the Change Rate scenarios based on \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_then_validates_the_Change_Rate_scenarios_based_on(String credentials, String changeRateValue, String changeRateReason) {
	optumPaySol.validateChangeRatePrcnt(credentials,changeRateValue,changeRateReason);
	}

@Then("^User validates contents of Past due fee of Fee tiles for this page$")
public void user_validates_contents_of_Past_due_fee_of_Fee_tiles_for_this_page() throws Throwable {
	optumPaySol.validatePastdueFee();
}

@Then("^User clicks on Fee Searh Tab on Optum Pay Solutions Page$")
public void user_clicks_on_fee_search_tab() throws Throwable {
	optumPaySol.navigateToFeeSearchTab();
}

	@Then("^User enters \"([^\"]*)\" on Fee Search page and click on search button\\.$")
	public void user_enters_and_click_on_search_button(String srchCriteria) throws Throwable {
		optumPaySol.doSearch(srchCriteria);
	}

	@Then("^User verifies Fee Search results for \"([^\"]*)\"$")
	public void verify_search_results_for(String criteriaType) throws Throwable {
		optumPaySol.verifyFeeSearchResults(criteriaType);
	}

	@Then("^User verifies the headers on Fee Search page$")
	public void verify_fee_search_results_headers() throws Throwable {
		optumPaySol.verifyFeeSearchResultHeaders();
	}

	@Then("^User verifies show fees i can refund on Fee Search page for \"([^\"]*)\"$")
	public void verify_show_fees_i_can_refund(String credentials) throws Throwable {
		optumPaySol.verifyShowFeesICanRefund(credentials);
	}
	
@Then("^User verifies if Invoices tab is available for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"\\.$")
public void user_verifies_if_Invoices_tab_is_available_for_and_and_and(String searchCriteria, String portalAccess, String tinType, String prdctRecSts) throws Throwable {
	optumPaySol.verifyInvoicesTab(searchCriteria, tinType, portalAccess,prdctRecSts);
}
}

