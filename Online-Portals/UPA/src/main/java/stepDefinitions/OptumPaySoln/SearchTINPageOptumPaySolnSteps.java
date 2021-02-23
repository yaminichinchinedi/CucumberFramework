package main.java.stepDefinitions.OptumPaySoln;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchTinPageOptmPaySoln;

public class SearchTINPageOptumPaySolnSteps extends TestBase {

	SearchTinPageOptmPaySoln srchTinOPSPage=new SearchTinPageOptmPaySoln(testConfig);
	
	
	
	@Then("^User enters TIN of \"([^\"]*)\" and click on Search button$")
	public void user_enters_TIN_of_and_click_on_Search_button(String accuredFeeStatus) throws Throwable {
		if(accuredFeeStatus.equalsIgnoreCase("withAccuredFee"))
		testConfig.putRunTimeProperty("nullStatus", "is not null");
		else if(accuredFeeStatus.equalsIgnoreCase("withoutAccuredFee"))
		testConfig.putRunTimeProperty("nullStatus", "is null");	
		
		srchTinOPSPage.enterTin("TinWthAccuredFeeStat").clickSearchBtn();
	}
	/*@Then("^User enters \"([^\"]*)\" TIN with \"([^\"]*)\" and click on Search button$")
	public void user_enters_TIN_with_and_click_on_Search_button(String tinTyp, String portalAccess) throws Throwable {
	    

		testConfig.putRunTimeProperty("tinType", tinTyp);
		testConfig.putRunTimeProperty("prdctSelected", portalAccess);
		srchTinOPSPage.enterTin("LegacyOrPremiOrStandard").clickSearchBtn();

	}*/
	@Then("^User Enters tin for OPS and click on search button for \"([^\"]*)\"\\.$")
	public void user_Enters_tin_for_OPS_and_click_on_search_button_for(String userType) throws Throwable {
		srchTinOPSPage.enterTinAndSrch(userType);
	}
}
