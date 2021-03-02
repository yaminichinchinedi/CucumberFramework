package main.java.stepDefinitions.BillingServiceInfo;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.pageObjects.BillingServiceInfo;


public class BillingServiceInfoStepsUPA extends TestBase {
	
    BillingServiceInfo bsInfoPage = new BillingServiceInfo(testConfig);

    @Then("Verify Billing Service Header Text")
    public void verifyBillingServiceHeaderText() {
        bsInfoPage.verifyBillingServiceHeaderText();
    }
    @Then("^User verifies the page text for provider based on the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_verifies_the_page_text_for_provider_based_on_the_and(String tinType, String portalAccess) throws Throwable {
    	bsInfoPage.verifyProviderPageText(tinType,portalAccess);
    }
}

