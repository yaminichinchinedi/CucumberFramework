package main.java.stepDefinitions.BillingServiceInfo;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.pageObjects.BillingServiceInfo;


public class BillingServiceInfoStepsUPA extends TestBase {
	
    BillingServiceInfo bsInfoPage = new BillingServiceInfo(testConfig);
    @Then("^User verifies the Trial End Date and updates it to one day later if trial is over$")
    public void user_verifies_the_Trial_End_Date_and_updates_it_to_one_day_later_if_trial_is_over() throws Throwable {
    	bsInfoPage.verifyTrialEndDateAndUpdateIfOver();
    }

    @Then("^User verifies the page text during trial$")
    public void user_verifies_the_page_text_during_trial() throws Throwable {
    	bsInfoPage.verifyPageText();
    }

    @Then("Verify Billing Service Header Text")
    public void verifyBillingServiceHeaderText() {
        bsInfoPage.verifyBillingServiceHeaderText();
    }
}
