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