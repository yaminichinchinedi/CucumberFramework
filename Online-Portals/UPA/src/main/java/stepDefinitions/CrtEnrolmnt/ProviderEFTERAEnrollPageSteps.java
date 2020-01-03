
package main.java.stepDefinitions.CrtEnrolmnt;

import java.io.IOException;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Runner.DemoTestNGRunner;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.Footer;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;


public class ProviderEFTERAEnrollPageSteps extends TestBase {

	
	String option="Health plan communication";
	int excelRow=1;
	UPARegistrationPage registrationPage=null;
	BeginEnrollment beginEnrollmentPage=null;
	
	ValidateEnrollmentTypePage validateEnrollmentTypePage=null;
	//ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	ValidateEFTERAProviderInfo validateEFTERAProviderInfo=null;
	//TestBase testConfig=null;
	ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	BeginEnrollmentContinue beginEnrollmentContinuePage=null;
	FinancialInstitutionInfoPage financialInstitutionInfoPage=null;

	
	@Then("^Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page$")
	public void select_Enrollment_Type_and_Clicks_Continue_button_of_Enrollment_TIN_Eligible_page (DataTable table) throws Throwable {
	   
		
		 beginEnrollmentContinuePage=new BeginEnrollmentContinue(testConfig);
		List<List<String>> EnrolmntTyps = table.raw();
		String EnrolmntTyp=EnrolmntTyps.get(1).get(0);
		if (EnrolmntTyp.equals("AO"))
		excelRow=1;
		else if (EnrolmntTyp.equals("BS"))
		excelRow=2;
		else if (EnrolmntTyp.equals("AV"))
		excelRow=3;
		else if (EnrolmntTyp.equals("VO"))
		excelRow=4;
		providerEFTERAEnrollPage=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue();
	}
	
	@Then("^user selects as \"(.*)\" and  Clicks continue button of Enrollment TIN Eligible page$")
	public void select_Enrollment_Type_as_and_Clicks_Continue_button_of_Enrollment_TIN_Eligible_page (String  EnrolmntTyp) throws Throwable {
		beginEnrollmentContinuePage=new BeginEnrollmentContinue(testConfig);
		if (EnrolmntTyp.equals("AO"))
		excelRow=1;
		else if (EnrolmntTyp.equals("BS"))
		excelRow=2;
		else if (EnrolmntTyp.equals("AV"))
		excelRow=3;
		else if (EnrolmntTyp.equals("VO"))
		excelRow=4;
		providerEFTERAEnrollPage=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue();
	}
	
	
	@Then("^User fills all the information  and click on Continue$")
	public void user_fills_all_the_information_and_click_on_Continue() throws Throwable {
		ProviderEFTERAEnrollPage providerEFTERAEnrollPage=new ProviderEFTERAEnrollPage(testConfig);
		validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfo();
	    
	}
	@Then("^User navigates to Billing service information page and fill all fields and click on continue button$")
	public void user_navigates_to_Billing_service_information_page_and_fill_all_fields_and_click_on_continue_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ProviderInformationEFTERAEnroll	providerInformationEFTERAEnroll=new ProviderInformationEFTERAEnroll(testConfig);
		validateEFTERAProviderInfo=providerInformationEFTERAEnroll.fillProviderOrgInfo();
	}
	@Then("^Validate the Footer Information on this page$")
    public void validate_the_Footer_Information() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    	new Footer(testConfig).validateFooterContents(testConfig);
    }

	
}
