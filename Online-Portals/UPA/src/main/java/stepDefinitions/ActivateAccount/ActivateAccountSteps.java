package main.java.stepDefinitions.ActivateAccount;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ActivateAccount;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.UPARegistrationPage;

public class ActivateAccountSteps extends TestBase {

	ActivateAccount activateAcc = new ActivateAccount(testConfig);

	@Then("^verify user is on activate your account page$")
	public void verify_user_is_on_activate_your_account_page() throws Throwable {
		activateAcc.verifyActivateAccountLandingPage();
	}
	
	@Then("^verify Optum header is displayed on activate your account page$")
	public void verify_Optum_header_is_displayed_on_activate_your_account_page() throws Throwable {
		activateAcc.verifyOptumGlobalHeader();
	}

	@Then("^Verify the message -> Welcome to Optum Pay! Help us answer a few short questions to get you started$")
	public void verify_the_message_Welcome_to_Optum_Pay_Help_us_answer_a_few_short_questions_to_get_you_started()
			throws Throwable {
		activateAcc.verifyWelcomeHeader();
	}

	@Then("^Verify the message -> First things first, is your organization enrolled in Optum Pay\\?$")
	public void verify_the_message_First_things_first_is_your_organization_enrolled_in_Optum_Pay() throws Throwable {
		activateAcc.verifyFirstThingFirstMessage();
	}

	@Then("^Verify the message -> Yes, my organization is already enrolled and I need account access$")
	public void verify_the_message_Yes_my_organization_is_already_enrolled_and_I_need_account_access()
			throws Throwable {
		activateAcc.verifyYesMyOrgIsEnrolled();
	}

	@Then("^Verify the message -> No, I need to enroll my organization$")
	public void verify_the_message_No_I_need_to_enroll_my_organization() throws Throwable {
		activateAcc.verifyNoINeedToEnroll();
	}

	@Given("^User Clicks on -> Yes, my organization is already enrolled and I need account access$")
	public void user_Clicks_on_Yes_my_organization_is_already_enrolled_and_I_need_account_access() throws Throwable {
		activateAcc.clickYesMyOrgIsEnrolled();
	}

	@Then("^Verify the option -> Yes, I have my active Optum Pay username and password$")
	public void verify_the_option_Yes_I_have_my_active_Optum_Pay_username_and_password() throws Throwable {

		activateAcc.verifyIhaveActiveOPtumCredentials();
	}


	@Then("^Verify the option -> No, I do not have an active Optum Pay user account$")
	public void verify_the_option_No_I_do_not_have_an_active_Optum_Pay_user_account() throws Throwable {

		activateAcc.verifyNoActiveOptumAcc();
	}

	@Given("^User Clicks on -> Yes, I have my active Optum Pay username and password$")
	public void user_Clicks_on_Yes_I_have_my_active_Optum_Pay_username_and_password() throws Throwable {
		activateAcc.clickYesIHaveCredentials();
	}

	@Then("^Verify the option -> Take a minute to connect your Optum Pay account with Optum ID$")
	public void verify_the_option_Take_a_minute_to_connect_your_Optum_Pay_account_with_Optum_ID() throws Throwable {

		activateAcc.verifyTakeAMinuteToConnect();
	}

	@Then("^Verify the absence of forgot Username and password link$")
	public void verify_the_absence_of_forgot_Username_and_password_link() throws Throwable {
		activateAcc.verifyAbsenseOfUsernamePassword();
	}

	@Then("^User navigates back by clicking change my answer$")
	public void user_navigates_back_by_clicking_change_my_answer() throws Throwable {
		activateAcc.userNavigatesToMainScreen();
	}

	@Then("^User clicks on No, I need to enroll my organization$")
	public void user_clicks_on_No_I_need_to_enroll_my_organization() throws Throwable {

		activateAcc.clickINeedToEnroll();
	}

	@Then("^Verifies the text -> Benefits of Optum Pay link$")
	public void verifies_the_text_Benefits_of_Optum_Pay_link() throws Throwable {
		activateAcc.verifyOptumPayBenefitsLink();
	}

	@Then("^Click on Need Help link$")
	public void click_on_Need_Help_link() throws Throwable {
		activateAcc.clickNeedHelp();
	}

	@Then("^Verify the text on the we are here to help pop up$")
	public void verify_the_text_on_the_we_are_here_to_help_pop_up() throws Throwable {
		activateAcc.verifyHelpText();
	}

	@Then("^Click on Benefits of Optum Pay link$")
	public void click_on_Benefits_of_Optum_Pay_link() throws Throwable {
		activateAcc.clickOptumPayBenefitsLink();
	}

	@Then("^Verify User navigates to benefit page$")
	public void verify_User_navigates_to_benefit_page() throws Throwable {
		activateAcc.verifyBenefitsPage();
	}

}
