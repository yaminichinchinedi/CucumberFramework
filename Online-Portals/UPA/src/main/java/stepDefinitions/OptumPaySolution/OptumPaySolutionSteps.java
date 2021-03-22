
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

//Added by Mohammad Khalid
@Then("^User verifies page text \"([^\"]*)\" messaging in Optum Pay Solutions page$")
public void user_verifies_page_text_messaging_in_Optum_Pay_Solutions_page(String pageText) throws Throwable 
{
	switch (pageText)
	{
	case "Premium_TopMsg":
	{
		optumPaySol.verifyPageText_Top_Premium();
		break;
	}
	case "Premium_FooterMsg":
	{
		optumPaySol.verifyPageText_Footer_Premium();
		break;
	}
	case "Standard_Msg_1":
	{
		optumPaySol.verifyPageText_Message1_Standard();
		break;
	}
	
	case "Standard_Msg_2":
	{
		optumPaySol.verifyPageText_Message2_Standard();
		break;
	}
	
	}

}


//Added by Mohammad to click on Invoices tab on OPS tab

@Then("^User clicks on \"([^\"]*)\" tab$")
public void user_clicks_on_tab(String tabName) throws Throwable
{
    optumPaySol.clickOnInvoicesTab();
}

@Then("^User validates \"([^\"]*)\"$")
public void user_validates(String paraName) throws Throwable
{
	switch(paraName)
	{
	case "ProviderName" :
	{
		optumPaySol.verifyProviderName();
		break;
	}
	
	case "AccruedFees" :
	{
		optumPaySol.verifyAccruedFees();
		break;
	}
	
	case "PastDueFees" :
	{
		optumPaySol.verifyPastDueFees();
		break;
	}
	
	case "InvoicePeriodGrid" :
	{
		optumPaySol.verifyInvoicePeriodGrid();
		break;
	}
	}
    
}

@Then("^User validates Provider Name, Accrued Fees, Past Due Fees and Invoice Period Grid$")
public void user_validates_Provider_Name_Accrued_Fees_Past_Due_Fees_and_Invoice_Period_Grid() throws Throwable
{
	optumPaySol.verifyProviderName();
	optumPaySol.verifyAccruedFees();
	optumPaySol.verifyPastDueFees();
	optumPaySol.verifyInvoicePeriodGrid();
}



@Then("^User validates contents of Past due fee of Fee tiles for this page$")
public void user_validates_contents_of_Past_due_fee_of_Fee_tiles_for_this_page() throws Throwable {
	optumPaySol.validatePastdueFee();
}
@Then("^User verifies if Invoices tab is available for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"\\.$")
public void user_verifies_if_Invoices_tab_is_available_for_and_and_and(String searchCriteria, String portalAccess, String tinType, String prdctRecSts) throws Throwable {
	optumPaySol.verifyInvoicesTab(searchCriteria, tinType, portalAccess,prdctRecSts);
}

@Then("^User clicks on Fee Searh Tab on Optum Pay Solutions Page$")
public void user_clicks_on_fee_search_tab() throws Throwable {
	optumPaySol.navigateToFeeSearchTab();
}

	@Then("^User enters \"([^\"]*)\" on Fee Search page and click on search button\\.$")
	public void user_enters_and_click_on_search_button(String srchCriteria) throws Throwable {
		optumPaySol.doSearch(srchCriteria);
	}
	@Then("^verify that max (\\d+) records are on single page and pagination links enabled/disabled accordingly$")
public void verify_that_max_records_are_on_single_page_and_pagination_links_enabled_disabled_accordingly(int arg1) throws Throwable {
    optumPaySol.verifyPagination();
}
}

