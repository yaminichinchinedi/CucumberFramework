package main.java.stepDefinitions.OptumPaySoln;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchTinPageOptmPaySoln;

public class SearchTINPageOptumPaySolnSteps extends TestBase {

	SearchTinPageOptmPaySoln srchTinpage=new SearchTinPageOptmPaySoln(testConfig);
	
	
	
	@Then("^User enters TIN of \"([^\"]*)\" and click on Search button$")
	public void user_enters_TIN_of_and_click_on_Search_button(String accuredFeeStatus) throws Throwable {
		if(accuredFeeStatus.equalsIgnoreCase("withAccuredFee"))
		testConfig.putRunTimeProperty("nullStatus", "is not null");
		else if(accuredFeeStatus.equalsIgnoreCase("withoutAccuredFee"))
		testConfig.putRunTimeProperty("nullStatus", "is null");	
		
		srchTinpage.enterTin("TinWthAccuredFeeStat").clickSearchBtn();
	}
	@Then("^User enters \"([^\"]*)\" TIN with \"([^\"]*)\" and click on Search button$")
	public void user_enters_TIN_with_and_click_on_Search_button(String tinTyp, String portalAccess) throws Throwable {
	    

		testConfig.putRunTimeProperty("tinType", tinTyp);
		testConfig.putRunTimeProperty("prdctSelected", portalAccess);
		srchTinpage.enterTin("LegacyOrPremiOrStandard").clickSearchBtn();

	}
}
