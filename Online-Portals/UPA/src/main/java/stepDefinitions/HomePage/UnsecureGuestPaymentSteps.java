package main.java.stepDefinitions.HomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.UnsecureGuestPayment;

public class UnsecureGuestPaymentSteps extends TestBase {

    UnsecureGuestPayment unsecureGuestPayment = new UnsecureGuestPayment(testConfig);


    @Then("I validate the Title for Pay as a guest")
    public void iValidateTheTitleForPayAsAGuest() {
        unsecureGuestPayment.validatePayasAGuestTitle();
    }

    @And("User enters tin and invoice number and clicks on countiue button")
    public void userEntersTinAndInvoiceNumberAndClicksOnCountiueButton() {
        unsecureGuestPayment.enterLastFourTinandInvoiceNumberthenCLickContinue();
    }

}
