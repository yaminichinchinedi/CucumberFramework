package main.java.stepDefinitions.OptumPaySolution;

import cucumber.api.java.en.And;
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
		
		//srchTinOPSPage.enterTin("TinWthAccuredFeeStat").clickSearchBtn();
	}
	@Then("^User Enters tin for OPS and click on search button for \"([^\"]*)\"\\.$")
	public void user_Enters_tin_for_OPS_and_click_on_search_button_for(String userType) throws Throwable {
		srchTinOPSPage.enterTinAndSrch(userType);
	}
	
	@And("^Change control to Optum Pay Solutions page$")
	public void change_control_to_Optum_Pay_Solutions_page() throws Throwable {
		srchTinOPSPage.changeToOptumPaySolutionPage();
	}
	
}
