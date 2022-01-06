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

    @And("User enters tin and invoice number and clicks on continue button")
    public void userEntersTinAndInvoiceNumberAndClicksOnCountiueButton() {
        unsecureGuestPayment.enterLastFourTinandInvoiceNumberthenCLickContinue();
    }

    @And("User enters contact information")
    public void userEntersContactInformation() {
        unsecureGuestPayment.enterContactInformation();
    }

    @And("User validates provider information")
    public void userValidateProviderInfo() {
        unsecureGuestPayment.validateProviderInformation();
    }


    @And("User enters routing and account number")
    public void userEntersRoutingandAccountNumbers() {
        unsecureGuestPayment.routingAndAccountNoInserter();
    }
    @And("User clicks on consent")
    public void userClicksOnConsent() {
        unsecureGuestPayment.userClicksOnConsent();
    }
    @And("User clicks on submit")
    public void userUserClicksSubmit() {
        unsecureGuestPayment.userUserClicksSubmit();
    }
    @Then("^User enters name and email$")
    public void user_enters_name_and_email() throws Throwable {
    	unsecureGuestPayment.enterContactInfo();
    }

    @Then("^User enters same routing number and account number and validates error \"([^\"]*)\"$")
    public void user_enters_same_routing_number_and_account_number_and_validates_error(String arg1) throws Throwable {
    	unsecureGuestPayment.enterSameRoutingAndAccountNo();
    }
//    @And("User enters routing and account number")
//    public void userEntersRoutingandAccountNumbers() {
//        unsecureGuestPayment.enterSameRoutingAndAccountNo();
//    } 
}
