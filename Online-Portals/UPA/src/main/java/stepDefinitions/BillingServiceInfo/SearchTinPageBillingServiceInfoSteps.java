package main.java.stepDefinitions.BillingServiceInfo;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchTinPageBillingServiceInfo;
import main.java.pageObjects.SearchTinPageViewPayments;

public class SearchTinPageBillingServiceInfoSteps {

	private TestBase testConfig;
	SearchTinPageBillingServiceInfo srchTinBSInfo= new SearchTinPageBillingServiceInfo(testConfig);
	
	@Then("^User Enters tin and click on search button for \"([^\"]*)\" on CSR Billing Service Info page\\.$")
	public void user_Enters_tin_and_click_on_search_button_for_on_CSR_Billing_Service_Info_page(String userType) throws Throwable {
		srchTinBSInfo. verifyUserType(userType);
	}
}
