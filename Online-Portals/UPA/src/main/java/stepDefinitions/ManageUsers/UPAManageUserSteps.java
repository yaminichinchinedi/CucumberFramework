package main.java.stepDefinitions.ManageUsers;

import org.openqa.selenium.By;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.AddUserDetails;
import main.java.pageObjects.HomePage;
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

    @Then("^Verify provider user details are read only on UPA for \"([^\"]*)\"$")
    public void verify_provider_user_details_are_read_only_on_UPA_for(String userType) throws Throwable {
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
        //manageUser.verifyAccessLvlChange(userType);
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
		addUserDetails=manageUser.clickPurgedChkBox(userType).getPurgedEmail().clickAddNewUser().fillNewUserInfo(stsCode).selectAndAddTin().selectTinAccessLvl(accessLevelOfNewUser);
        addUserDetails.clickSave().verifyUserInList(userType).verifyDetailsOfNewUser(userType);
	}
	
	@Then("^Verifies details for \"([^\"]*)\" and \"([^\"]*)\" New Payer and BS user using \"([^\"]*)\"$")
	public void verifies_details_for_and_New_Payer_and_BS_user_using(String userType, String accessLevelOfNewUser, String stsCode) throws Throwable {
		addUserDetails=manageUser.clickPurgedChkBox(userType).getPurgedEmail().clickAddNewUser().fillNewUserInfo(stsCode).selectTinAccessLvl(accessLevelOfNewUser);
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
	
    @Then("^verifies if the TIN grid is relabeled for from Remove Row to Delete User$")
    public void verifies_if_the_TIN_grid_is_relabeled_for_from_Remove_Row_to_Delete_User() throws Throwable {
    	manageUser.verifyDeleteUserInTinGrid();  
    }
    @Then("^validates if access level, email checkbox, delete user checkbox are enabled or disabled for \"([^\"]*)\"$")
    public void validates_if_access_level_email_checkbox_delete_user_checkbox_are_enabled_or_disabled_for(String accessLevel) throws Throwable {
    	manageUser.verifyAbilityOfTinItems(accessLevel);
    }

    @Then("^deletes \"([^\"]*)\" \"([^\"]*)\" user and verifies from UI and DB$")
    public void deletes_user_and_verifies_from_UI_and_DB(String accessType, String accessLevel) throws Throwable {
    	manageUser.deleteUserAndVerify(accessType, accessLevel);
    }

    @Then("^verifies adding a new user of \"([^\"]*)\" with deleted user email with \"([^\"]*)\"$")
    public void verifies_adding_a_new_user_of_with_deleted_user_email_with(String accessType, String accessLevel) throws Throwable {
    	manageUser.clickbtnAddNewUser(accessLevel);
        manageUser.fillUserInfo(accessType,accessLevel);  
    }
    @Then("^verifies Admin user is able to update General user \"([^\"]*)\"$")
    public void verify_Admin_user_is_able_to_update_General_user_s(String accessLevel) throws Throwable {
    	manageUser.verifyAdminPrivileges(accessLevel);
    }

    @Then("^Validate the ability of the fields of TIN grid for \"([^\"]*)\"$")
    public void validate_the_ability_of_the_fields_of_TIN_grid_for(String accessLevel) throws Throwable {
       manageUser.abilityOfFields(accessLevel);
    }
    @Then("^Verify BS Admin is able to update BS Gen \"([^\"]*)\"$")
    public void verify_BS_Admin_is_able_to_update_BS_Gen(String accessLevel ) throws Throwable {
    	manageUser.bsAdminPrivilages(accessLevel);
    }
    
    @Then("^validate ability of access level, email checkbox, delete user checkbox for Payer \"([^\"]*)\"$")
    public void validate_ability_of_access_level_email_checkbox_delete_user_checkbox_for_Payer(String accessLevel) throws Throwable {
        manageUser.abilityOfFieldsForPayer(accessLevel);
    }

   

	  @Then("^Verify Users List for \"([^\"]*)\" with \"([^\"]*)\" on selecting and deselecting of purge checkbox$")
	  public void verify_Users_List_for_with_on_selecting_and_deselecting_of_purge_checkbox(String userType, String searchCriteria) throws Throwable {
		  new ManageUsers(testConfig).verifyUserList(userType,searchCriteria);
	  }
	  
	  
	  @Then("^Verify UI Details for Purged \"([^\"]*)\" user$")
	  public void verify_UI_Details_for_Purged_user(String userType) throws Throwable {
		  manageUser.verifyDetailsForPurgedUser(userType);
	    
	  }

		@Then("^User clicks on View Purge Users checkbox$")
		public void user_click_on_View_Purge_Users_checkbox() throws Throwable {
			manageUser.clickPurgeUsers();
		}

}
