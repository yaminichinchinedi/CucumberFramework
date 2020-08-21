package main.java.stepDefinitions.ManageUsers;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ManageUsers;
import main.java.pageObjects.SearchTinPage;

public class CSRManageUserSteps extends TestBase {

    ManageUsers manageUsers = null;
    SearchTinPage searchPage = new SearchTinPage(testConfig);

    @Then("^User enters \"([^\"]*)\" in Manage Users Page and Click to add new User and fill the details \"([^\"]*)\" and verify the user detils and delete the user$")
    public void user_enters_in_Manage_Users_Page_and_add_user_and_verify(String userType,String accessLevelOfNewUser) throws Throwable {
        if(userType.equalsIgnoreCase("PROV"))
            manageUsers = searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().addTinCSR().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
        else
            manageUsers = searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser).clickSave();

        manageUsers.verifyDetailsOfNewUser(userType).deleteAndVerifyUserIsDeleted();
    }
    
    @Then("^User enters \"([^\"]*)\" in Manage Users Page and Click to add new User using \"([^\"]*)\"  and fill the details \"([^\"]*)\" and verify the user detils and delete the user$")
    public void user_enters_in_Manage_Users_Page_and_Click_to_add_new_User_using_and_fill_the_details_and_verify_the_user_detils_and_delete_the_user(String userType, String stsCode, String accessLevelOfNewUser) throws Throwable {
    	testConfig.putRunTimeProperty("Purged", "Purged");
    	if(userType.equalsIgnoreCase("PROV"))
             manageUsers = searchPage.doSearch(userType).clickPurgedChkBox(userType).getPurgedEmail().clickAddNewUser().fillNewUserInfo(stsCode).addTinCSR().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
         else
             manageUsers = searchPage.doSearch(userType).clickPurgedChkBox(userType).getPurgedEmail().clickAddNewUser().fillNewUserInfo(stsCode).selectTinAccessLvl(accessLevelOfNewUser).clickSave();

         manageUsers.clickPurgedChkBox(userType).verifyUserInList(userType).verifyDetailsOfNewUser(userType).deleteAndVerifyUserIsDeleted();
    }



	@Then("^User enters \"([^\"]*)\"  and Purged TIN  and click on Search button in Manage Users Page$")
	public void user_enters_and_Purged_TIN_and_click_on_Search_button_in_Manage_Users_Page(String userType) throws Throwable {
		if(userType.equalsIgnoreCase("PROV"))
			manageUsers = searchPage.doSearchPUTIN("PROV");
	  
	}
    
	@Then("^User clicks on View Purge Users checkbox$")
	public void user_click_on_View_Purge_Users_checkbox() throws Throwable {
		manageUsers.clickPurgeUsers();
	}

	@Then("^User clicks on one of Purged User from User list and perform validations like Name,Phone No,Email,TIN List,buttons disabled for \"([^\"]*)\" user$")
	public void user_clicks_on_one_of_Purged_User_from_User_list_and_perform_validations_like_Name_Phone_No_Email_TIN_List_buttons_disabled_for_user(String credentials) throws Throwable {
		manageUsers.validatePurgeUsers("CSR",credentials);    	
	}
	
    @Then("^validate User enters \"([^\"]*)\" to verify acive admin, access level, email check, remove tin \"([^\"]*)\" and modify email \"([^\"]*)\" and \"([^\"]*)\" firstName$")
    public void user_enters_in_Manage_Users_Page_and_Verify_Deatils_one(String userType,String disabledValue,String email,String firstName) throws Throwable {
        String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
        System.setProperty("tin", tinNo);
        manageUsers = searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);

        if(email.equalsIgnoreCase("email"))
            manageUsers.editEmailWithExistingAdress().verifyDisabledItemsForTin(tinNo,disabledValue);

        if(firstName.equalsIgnoreCase("firstName")) {
            manageUsers.editFirstName("abc").verifyDisabledItemsForTin(tinNo, disabledValue);
            manageUsers.editFirstName("abc%()").verifyDisabledItemsForTin(tinNo, disabledValue);
        }
    }

    @Then("^User enters \"([^\"]*)\" in Manage Users Page and Verifies if a tin has only one active admin , access level dropdown, email check box & remove tin/npi checkbox \"([^\"]*)\" is disabled after modifying the Last name of user with both valid and invalid data$")
    public void user_enters_in_Manage_Users_Page_and_Verify_Deatils_Fourth(String userType,String disabledValue) throws Throwable {
        String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
        manageUsers = searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);
        manageUsers.editLastName("abc").verifyDisabledItemsForTin(tinNo,disabledValue);
        manageUsers.editLastName("abc%()").verifyDisabledItemsForTin(tinNo,disabledValue);
    }

    @Then("^User enters \"([^\"]*)\" in Manage Users Page and Verifies if a tin has more than one active admin , access level dropdown, email check box & remove tin/npi checkbox \"([^\"]*)\" is enabled$")
    public void user_enters_in_Manage_Users_Page_and_Verify_Deatils_Fifth(String userType,String eabledValue) throws Throwable {
        String tinNo=searchPage.selectUserType(userType).enterTin("tinWithMoreThanOneActiveAdmin");
        searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,eabledValue);
    }

    @Then("^User enters \"([^\"]*)\" in Manage Users Page and Verifies access level,email and npi/tin checkbox remains disabled for a user who is the only active admin for a tin when gets associated with another new tin and Verifies if the new tin is removed then also these items access level etc remains \"([^\"]*)\" disabled for the only active admin tin$")
    public void user_enters_in_Manage_Users_Page_and_Verify_Deatils_Sixth(String userType,String disabledValue) throws Throwable {
        int sqlNo=172;
        String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
        ManageUsers manageUsers=searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);
        String newTinAdded=manageUsers.addTinCSR(sqlNo);
        manageUsers.verifyDisabledItemsForTin(tinNo, disabledValue).selectAccessLvl("Administrator",newTinAdded).clickSave().removeTinNpi(newTinAdded).verifyDisabledItemsForTin(tinNo,disabledValue);
    }
	
	@Then("^Validate status of purged user for \"([^\"]*)\" in tables\\.$")
	public void validate_status_of_purged_user_for_in_tables(String userType) throws Throwable {
		manageUsers.verifyPurgedUserStatus(userType);
	}

	@Then("^select user \"([^\"]*)\" from dropdown$")
	public void select_user_from_dropdown(String userType) throws Throwable {
		searchPage.selectUserType(userType);
	}

	@Then("^Enter tin on Search Tin Page for \"([^\"]*)\" having condition as \"([^\"]*)\" and click search button$")
	public void enter_tin_on_Search_Tin_Page_for_having_condition_as_and_click_search_button(String userType, String termsAndCondition) throws Throwable {
		String typeOfTin=null;
		if(userType.equals("PROV"))
			typeOfTin="tinwithTermAndConditionProv";
		else
			typeOfTin="tinwithTermAndConditionBS";
		testConfig.putRunTimeProperty("termsAndCondition", termsAndCondition);
		searchPage.enterTin(typeOfTin);
		manageUsers=searchPage.clickSearch(userType);
	}

	@Then("^User clicks on username from user list$")
	public void user_clicks_on_username_from_user_list() throws Throwable {
		manageUsers.clickSpecificUserName(testConfig.getRunTimeProperty("username"));
	}

	@Then("^validate T and C fields\\.$")
	public void validate_T_and_C_fields() throws Throwable {
		manageUsers.validateTandCFields();
	}
    
    @Then("^User enters \"([^\"]*)\" in Manage Users Page and Updates an active User and verify the user details in the UI and DB$")
    public void user_enters_in_Manage_Users_Page_and_Updates_an_active_User_and_verify_the_user_details_in_the_UI_and_DB(String userType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	if(userType.equalsIgnoreCase("PROV"))
          manageUsers = searchPage.doSearch(userType);
    	else
          manageUsers = searchPage.doSearch(userType);
    	manageUsers.clickActiveUserName(userType).updateDemographicInfo(userType).clickSave().verifyYourChangesWereUpdatedSuccessfully();
    	manageUsers.VerifyDetailsOfUser(userType);   
}

}
