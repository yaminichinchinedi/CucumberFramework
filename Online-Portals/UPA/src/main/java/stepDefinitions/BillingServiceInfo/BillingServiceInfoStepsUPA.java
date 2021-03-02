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
}
