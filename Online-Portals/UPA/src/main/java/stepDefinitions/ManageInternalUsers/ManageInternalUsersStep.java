package main.java.stepDefinitions.ManageInternalUsers;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ManageInternalUsers;


public class ManageInternalUsersStep extends TestBase
{
	ManageInternalUsers manageInternalUser=new ManageInternalUsers(testConfig);
	

	@Then("^Enter \"([^\"]*)\" in userid$")
	public void enter_userId_inManageInternalUsers(String userId) throws Throwable {
		manageInternalUser.enterUserId(userId);
	}
	
   
	@Then("^Edit OptumPay Sol Transactions \"([^\"]*)\"$")
   public void edit_OptumPay_Sol_from_Transactions(String Action) throws Throwable {
	   manageInternalUser.editSelectedTransactions(Action);
   }

	
	@Then("^Check if OptumPay Solutions is present or not based on \"([^\"]*)\"$")
	public void check_if_OptumPay_Solutions_is_present_or_not(String Action) throws Throwable {
	    manageInternalUser.optumPaySolutionsLinkPresentorNot(Action);
	}

}