package main.java.stepDefinitions.ManageUsers;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Utils.Helper;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.AddUserDetails;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.ManageUsers;
import main.java.pageObjects.SearchTinPage;

public class CSRManageUserSuper extends TestBase {

	CSRHomePage homePage=null;
	SearchTinPage searchTInPage = new SearchTinPage(testConfig);
	ManageUsers manageUsers;
	AddUserDetails addUserDetails;

	@When("^selects \"([^\"]*)\" from dropdown, enters tin on Search Tin Page for the selected usertype and clicks on search button$")
	public void selects_user_from_dropdown_enters_tin_on_Search_Tin_Page_for_the_selected_and_clicks_on_search_button(String userType) throws Throwable {
		manageUsers = searchTInPage.doSearch(userType);
	}

	@Then("^User should be navigated to manage user page for the selected \"([^\\\"]*)\"$")
	public void user_should_be_navigated_to_manage_user_page(String userType) throws Throwable {
		String title = "";
		switch (userType) {
		case "PAY":
			title+="Manage Payer Users";
			break;
		case "PROV":
			title+="Manage Users";
			break;
		case "BS":
			title+="Secure User- Manage Users";
			break;
		}
		Helper.compareEquals(testConfig, "Comparing Manage user page title for different users", title, driver.getTitle());
	}

	@Then("^User verifies the UI for selected \"([^\"]*)\"$")
	public void user_verifies_the_UI_for_selected(String userType) throws Throwable {
		manageUsers.verifyCsrManageUserUI(userType);
	}

	@When("^Adds a user for the selected \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" or \"([^\"]*)\"$")
	public void adds_a_user_for_the_selected_with_and_or(String userType, String tinAccessLevel, String subPayerAccess, String AssociateBStoAllProv) throws Throwable {

		switch (userType) {
		case "PROV":
			manageUsers = manageUsers.clickAddNewUser().fillNewUserInfo().addTinCSR().selectTinAccessLvl(tinAccessLevel).clickSave();	
			break;
		case "PAY":
			addUserDetails = manageUsers.clickAddNewUser().fillNewUserInfo().selectSubPayerAccess(subPayerAccess);
			if (subPayerAccess.equalsIgnoreCase("Yes")) 
				addUserDetails.addSubPayerId();
			manageUsers = manageUsers.selectTinAccessLvl(tinAccessLevel).clickSave();
			break;
		case "BS":
			addUserDetails = manageUsers.clickAddNewUser().fillNewUserInfo().selectBsAccessLevel(tinAccessLevel);
			if (AssociateBStoAllProv.equalsIgnoreCase("Yes")) 
				addUserDetails.clickAsscociateYesButton();
			else
				addUserDetails.clickAsscociateNoButton().addProviderAssociation();
			manageUsers = manageUsers.selectTinAccessLvl(tinAccessLevel).clickSave();
			break;
		}	
	}

	@Then("^Verify that user is added for the selected \"([^\"]*)\"$")
	public void verify_that_user_is_added_for_the_selected(String userType) throws Throwable {
		manageUsers.verifyDetailsOfNewUser(userType);
	}

	@Then("^Verify that user successfully created message is displayed for the newly created \"([^\"]*)\"$")
	public void verify_that_user_successfully_created_message_is_displayed_for_the_newly_created(String userType) throws Throwable {
		manageUsers.verifyUserSuccessfullyCreatedMessage(userType);
	}

	@Given("^Selects an active user from the user list$")
	public void select_an_active_user_from_the_user_list() throws Throwable {
		manageUsers.selectActiveUser(testConfig.getRunTimeProperty("userName"));
	}

	@Given("^Edits the user details$")
	public void edits_the_user_details() throws Throwable {
		manageUsers.editUserDetails();
	}

	@Then("^Verify that user successfully updated message is displayed$")
	public void verify_that_user_successfully_updated_message_is_displayed() throws Throwable {
		manageUsers.verifyUserDetailsUpdatedMessage();
	}

	@Then("^Verify the updated user details in database$")
	public void verify_the_updated_user_details_in_database() throws Throwable {
		manageUsers.verifyUpdatedUserDetails();
	}

}
