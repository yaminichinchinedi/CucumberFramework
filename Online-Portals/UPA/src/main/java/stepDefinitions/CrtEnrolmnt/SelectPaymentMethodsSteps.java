package main.java.stepDefinitions.CrtEnrolmnt;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.SelectPaymentMethods;
import cucumber.api.java.en.Then;

public class SelectPaymentMethodsSteps extends TestBase{

	SelectPaymentMethods slctPayMth=new SelectPaymentMethods(testConfig);
	
	@Then("^User clicks on Terms and Condition link on Select Payment Method Page and clicks on close link\\.$")
	public void user_clicks_on_Terms_and_Condition_link_on_Select_Payment_Method_Page_and_clicks_on_close_link() throws Throwable {
		slctPayMth.clickTrmsCondtn();  
	}

	@Then("^User clicks on which payment information should i choose link and then clicks on close link\\.$")
	public void user_clicks_on_which_payment_information_should_i_choose_link_and_then_clicks_on_close_link() throws Throwable {
		slctPayMth.clickPaymntChooseLnk();
	}
	
	@Then("^User Validate Header for Select Payment Method Page\\.$")
	public void user_Validated_Header_for_Select_Payment_Method_Page() throws Throwable {
		new HeaderContentValidation(testConfig).verifyHeaders("Select Payment Methods");
	}
	
	@Then("^User clicks on Back button on Select Payment Method Page and validate user is navigted to FII-Organisation Information Page\\.$")
	public void user_clicks_on_Back_button_on_Select_Payment_Method_Page_and_validate_user_is_navigted_to_FII_Organisation_Information_Page() throws Throwable {
		slctPayMth.clickBackToFIIOrg();
	}

	@Then("^User clicks on Cancel Enrollment button on Select Payment Method Page and clicks on No button on the Pop up\\.$")
	public void user_clicks_on_Cancel_Enrollment_button_on_Select_Payment_Method_Page_and_clicks_on_No_button_on_the_Pop_up() throws Throwable {
		slctPayMth.clickCanclEnrlmnt().clickNoCanclEnrlmnt();
	}

	@Then("^User clicks on Canerl Enrollment button on Select Payment Method Page and clicks on Yes button on the Pop up\\.$")
	public void user_clicks_on_Canerl_Enrollment_button_on_Select_Payment_Method_Page_and_clicks_on_Yes_button_on_the_Pop_up() throws Throwable {
		slctPayMth.clickCanclEnrlmnt().clickYesCanclEnrlmnt();
	}
	
	@Then("^Validate Select Payment Method Page is context Managed\\.$")
	public void validate_Select_Payment_Method_Page_is_context_Managed() throws Throwable {
		slctPayMth.verifyPageContent();
	}
	
	@Then("^User checks the Payer are listed in Alpha Order and verify Payer for AO and AV\\.$")
	public void user_checks_the_Payer_are_listed_in_Alpha_Order_and_verify_Payer_for_AO_and_AV() throws Throwable {
		slctPayMth.verifyPayerList();
	}
	
	@Then("^User clicks Continue on Select Payment Methods Page$")
	public void user_clicks_Continue_on_Select_Payment_Methods_Page() throws Throwable {
		slctPayMth.clickContinue();
	}
}
