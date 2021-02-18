package main.java.stepDefinitions.ViewPayments;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchTinPageViewPayments;

public class SearchTinPageViewPaymentsSteps extends TestBase {
	
    SearchTinPageViewPayments viewPaymentsTIN = new SearchTinPageViewPayments(testConfig);

    @Then("^User Enters tin and click on search button for \"([^\"]*)\"\\.$")
	public void user_Enters_tin_and_click_on_search_button_for(String userType) throws Throwable {
		viewPaymentsTIN.enterTinAndSrch(userType);
	}
	/*@When("^User enters  \"([^\"]*)\" tin \"([^\"]*)\" with \"([^\"]*)\" for \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void user_enters_tin_with_for_and_for_for(String tinType, String searchCriteria, String portalAccess, String trialStatus, String statusOfStandardRecd, String SelectedOrDefault, String userType) throws Throwable {
		testConfig.putRunTimeProperty("tinType", tinType);
		testConfig.putRunTimeProperty("portalAccess", portalAccess);
		testConfig.putRunTimeProperty("trialStatus", trialStatus);
		testConfig.putRunTimeProperty("statusOfStandardRecd", statusOfStandardRecd);
		testConfig.putRunTimeProperty("SelectedOrDefault", SelectedOrDefault);
		testConfig.getRunTimeProperty("id");
		viewPaymentsTIN.enterPaymentTin(userType,searchCriteria, tinType,portalAccess);
	}*/

}
