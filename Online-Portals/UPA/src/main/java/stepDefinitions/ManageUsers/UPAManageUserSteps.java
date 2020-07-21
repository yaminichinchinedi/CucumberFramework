package main.java.stepDefinitions.ManageUsers;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.AddUserDetails;
import main.java.pageObjects.ManageUsers;

public class UPAManageUserSteps extends TestBase {

    ManageUsers manageUser = new ManageUsers(testConfig);
    AddUserDetails addUserDetails = null;

    @Then("^Verifies user list sorting is working correctly on Manage Users Tab$")
    public void user_enters_in_Upa_Manage_Users_Page() throws Throwable {
        manageUser.doUserListSorting();
    }

    @Then("^Verifies \"([^\"]*)\" Save & Cancel button functionlity for Access level changes for a Provider User$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify(String userType) throws Throwable {
        manageUser.changeAndSaveAccessLevel(userType).changeAndCancelAccessLevel(userType);
    }

    @Then("^Verifies Tin Grid Details in Manage Users Tab$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_Grid_Details() throws Throwable {
        manageUser.verifyTinGridSorting();
        manageUser.verifyManageUserUI();
    }

    @Then("^Verifies error messages and associated tins with a user$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_Error_Message() throws Throwable {
        addUserDetails =manageUser.clickAddNewUser();
        addUserDetails.verifyErrorMessages();
    }

    @Then("^Verifies provider user details are read only on UPA$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_User_Details_Read_Only() throws Throwable {
        manageUser.verifyUserDetailsAreReadOnly();
    }

    @Then("^Verifies details for \"([^\"]*)\" and \"([^\"]*)\" New Billing Service user$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_User_Service(String userType, String accessLevelOfNewUser) throws Throwable {
        addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave();
        addUserDetails.verifyDetailsOfNewUser(userType);
    }

    @Then("^Verifies Payer \"([^\"]*)\" user details are read only on UPA$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_Payer_User_Details(String userType) throws Throwable {
        manageUser.verifyPayerUserDetailsAreReadOnly();
        manageUser.verifyAccessLvlChange(userType);
    }

    @Then("^Verifies details for \"([^\"]*)\" and \"([^\"]*)\" New Payer user$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_New_Payer_User_Service(String userType, String accessLevelOfNewUser) throws Throwable {
        addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave();
        addUserDetails.verifyDetailsOfNewUser(userType);
    }

    @Then("^Verifies details for \"([^\"]*)\" and \"([^\"]*)\" New Provider user$")
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_New_Provider_User_Service(String userType, String accessLevelOfNewUser) throws Throwable {
        addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo().selectAndAddTin().selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave();
        addUserDetails.verifyDetailsOfNewUser(userType);
        manageUser.removeFistTinInGrid();
    }
    
	
	@Then("^Verifies details for \"([^\"]*)\" and \"([^\"]*)\" New Provider user using \"([^\"]*)\"$")
	public void verifies_details_for_and_New_Provider_user_using(String userType, String accessLevelOfNewUser, String stsCode) throws Throwable {
		addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo(stsCode).selectAndAddTin().selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave().verifyDetailsOfNewUser(userType);
        manageUser.removeFistTinInGrid();
	}
	
	@Then("^Verifies details for \"([^\"]*)\" and \"([^\"]*)\" New Payer and BS user using \"([^\"]*)\"$")
	public void verifies_details_for_and_New_Payer_and_BS_user_using(String userType, String accessLevelOfNewUser, String stsCode) throws Throwable {
		addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo(stsCode).selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave().verifyDetailsOfNewUser(userType);
	}

}
