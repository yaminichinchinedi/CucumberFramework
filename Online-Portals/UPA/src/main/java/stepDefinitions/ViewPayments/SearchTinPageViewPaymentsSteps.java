
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
    
    @Then("Provider select the TIN on view payments page$")
	public void User_select_the_TIN_on_view_payments_page() throws Throwable {
		viewPaymentsTIN.SelectingTinOnViewPaymentPage();
	}
}


