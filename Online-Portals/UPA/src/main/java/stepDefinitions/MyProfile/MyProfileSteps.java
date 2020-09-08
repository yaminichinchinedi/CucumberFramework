package main.java.stepDefinitions.MyProfile;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.MyProfile;

public class MyProfileSteps extends TestBase {

    MyProfile myProfile = new MyProfile(testConfig);

    @Then("^Verifies \"([^\"]*)\" User Details displayed on My profile Page from user details saved in Database for logged in user$")
    public void user_enters_in_Upa_My_Profile_Page(String userType) throws Throwable {
        myProfile.verifyUserDetails(userType);
    }

    @Then("^Verifies \"([^\"]*)\" Error messages for provider$")
    public void user_enters_in_Upa_My_Profile_Page_And_Verify_Error_Message(String userType) throws Throwable {
        myProfile.verifyErrorMessages(userType);
    }
    
    @Then("^User updates fields on My profile Page and verifies in Database for logged in user$")
    public void user_updates_fields_on_My_profile_Page_and_verifies_in_Database_for_logged_in_user() throws Throwable {
    	myProfile.updateAndVerifyUserDetails();
    }
    
    @Then("^User updates fields on My profile Page for provider and verifies in Database for logged in user$")
    public void user_updates_fields_on_My_profile_Page_for_provider_and_verifies_in_Database_for_logged_in_user() throws Throwable {
    	myProfile.updateAndVerifyProvDetails();
    }

}
