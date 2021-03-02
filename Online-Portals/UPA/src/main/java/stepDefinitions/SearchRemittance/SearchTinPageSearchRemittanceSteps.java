package main.java.stepDefinitions.SearchRemittance;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchTinPageSearchRemittance;

public class SearchTinPageSearchRemittanceSteps extends TestBase {
	
	SearchTinPageSearchRemittance searchRemittanceTIN = new SearchTinPageSearchRemittance(testConfig);

    @Then("^User Enters Search Remittance tin and click on search button for \"([^\"]*)\"\\.$")
	public void user_Enters_tin_for_searchRemittance_and_click_on_search_button_for(String userType) throws Throwable {
    	searchRemittanceTIN.enterTinAndSrch(userType);
	}
}
