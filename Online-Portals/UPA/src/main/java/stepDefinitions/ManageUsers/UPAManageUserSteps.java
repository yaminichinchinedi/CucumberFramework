package main.java.stepDefinitions.ManageUsers;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    public void user_enters_in_Upa_Manage_Users_Page_and_verify_User_Details_Read_Only(String userType) throws Throwable {
        manageUser.verifyUserDetailsAreReadOnly(userType);
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
		addUserDetails=manageUser.getPurgedEmail().clickAddNewUser().fillNewUserInfo(stsCode).selectAndAddTin().selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave().verifyUserInList(userType).verifyDetailsOfNewUser(userType);
        manageUser.removeFistTinInGrid();
	}
	
	@Then("^Verifies details for \"([^\"]*)\" and \"([^\"]*)\" New Payer and BS user using \"([^\"]*)\"$")
	public void verifies_details_for_and_New_Payer_and_BS_user_using(String userType, String accessLevelOfNewUser, String stsCode) throws Throwable {
		addUserDetails=manageUser.getPurgedEmail().clickAddNewUser().fillNewUserInfo(stsCode).selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave().verifyUserInList(userType).verifyDetailsOfNewUser(userType);
	}
    
    @Then("^Verify Save and Cancel func for AccessLvl for \"([^\"]*)\"$")
    public void verify_Save_and_Cancel_func_for_AccessLvl_for(String userType) throws Throwable {
    	manageUser.changeAndSaveAccessLevel(userType);
     
    }

    @Then("^Validate status of purged user for \"([^\"]*)\" in portal tables\\.$")
    public void validate_status_of_purged_user_for_in_portal_tables(String userType) throws Throwable {
    	manageUser.verifyPurgedUserStatus(userType);
    }

    @Then("^Verify Purged User validations by clicking on it$")
    public void verify_Purged_User_validations_by_clicking_on_it() throws Throwable {
    	manageUser.validatePurgeUsers("UPA","All");
    }
    

	@Then("^User perform validation by adding TIN with same TIN$")
	public void user_perform_validation_by_adding_TIN_with_same_TIN() throws Throwable {
	manageUser.clickActiveUserName("PROV");
	manageUser.validateAddingSameTIN();
}
	

	@When("^Verify Reset Password Option doesnt exists for UPA$")
	public void verify_Reset_Password_Option_doesnt_exists_for_UPA() throws Throwable {
    
		manageUser.verifyResetPwdButtonUPA();
}


}
