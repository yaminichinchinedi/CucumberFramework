package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import main.java.Utils.Helper;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;

public class ProviderInformationEFTERAEnrollSteps  extends TestBase{
	
	ProviderInformationEFTERAEnroll providerInfoEFETRAenroll=new ProviderInformationEFTERAEnroll(testConfig);
	
	@And("^Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page\\.$")
	public void validate_the_fields_are_editable_and_SAVA_CHANGES_and_CANCEL_CHANGES_button_are_present_on_page() throws Throwable {
		providerInfoEFETRAenroll.verifyEditable().verifyCanclSavChangeBtns();
	}
	
	@Then("^User Clicks Cancel Changes button\\.$")
	public void user_Clicks_Cancel_Changes_button() throws Throwable {
	    providerInfoEFETRAenroll.clickCanclChangBtn();
	}
	
	@Then("^User enters new information incorrectly and clicks save button\\.$")
	public void user_enters_new_information_incorrectly_and_clicks_save_button() throws Throwable {
		providerInfoEFETRAenroll.validateBillingService("BSName", "&*min","SAVE CHANGES").validateBillingService("Street", "*(*(*","SAVE CHANGES").validateBillingService("Street", "PO BOX 7530","SAVE CHANGES").validateBillingService("City", "%^&&","SAVE CHANGES").validateBillingService("ZipCode", "anjhu","SAVE CHANGES").validateBillingService("ZipCode", "70165","SAVE CHANGES").validateBillingService("NPI", "78978789","SAVE CHANGES");
	}

	@Then("^Validate the CANCEL CHANGE button is disabled\\.$")
	public void validate_the_CANCEL_CHANGE_button_is_disabled() throws Throwable {
		providerInfoEFETRAenroll.verifyCanclChangBtnDsabl();
	}

	@Then("^User enters new information correctly and clicks save button\\.$")
	public void user_enters_new_information_correctly_and_clicks_save_button() throws Throwable {
		String name=Helper.generateRandomAlphabetsString(5);
		providerInfoEFETRAenroll.fillBusinessName(name).clickSaveBtn();
	}
	
	@And("^Validate page is Content Managed\\.$")
	public void validate_page_is_Content_Managed() throws Throwable {
		providerInfoEFETRAenroll.verifyPageContentManaged();
	}
	
	@Then("^User clears all the information and clicks save button and validate error messages\\.$")
	public void user_clears_all_the_information_and_clicks_save_button_and_validate_error_messages() throws Throwable {
		providerInfoEFETRAenroll.verifyErrorMsgNull();
	}
	
	@And("^Validate the Headers for Organization Information\\.$")
	public void validate_the_Headers() throws Throwable {
		new HeaderContentValidation(testConfig).verifyHeaders("Organization Information");
	}
	

}
