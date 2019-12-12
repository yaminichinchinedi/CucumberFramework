
package main.java.stepDefinitions.CrtEnrolmnt;

import java.io.IOException;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Runner.DemoTestNGRunner;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;
//import main.java.stepDefinitions.support.Hook;
//import main.java.stepDefinitions.support.SuperStepDef;

public class FinancialInstitutionInfoPageSteps extends TestBase {

	
	String option="Health plan communication";
	int excelRow=1;
	UPARegistrationPage registrationPage=null;
	BeginEnrollment beginEnrollmentPage=null;
	
	ValidateEnrollmentTypePage validateEnrollmentTypePage=null;
	//ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	ValidateEFTERAProviderInfo validateEFTERAProviderInfo=null;
	//TestBase testConfig=null;
	FinancialInstitutionInfoPage financialInstitutionInfoPage=null;
	//SuperStepDef supdup=null;
	
//	public CrtEnrlmntValiDateFinStepDef(Hook hook) {
//		super(hook);
//		
//	}
	
//	@Before
//	public void init(){
//	testConfig=new DemoTestNGRunner();
//	}
	
//	@Given("^User navigates to UPA Sys Test application$")
//	public void user_navigates_to_UPA_Sys_Test_application () throws Throwable {
//		
//		
//		registrationPage = new UPARegistrationPage(testConfig);
//	    
//	}
//
//	@When("^User Clicks on Enroll Now from the landing page$")
//	public void user_Clicks_on_Enroll_Now_from_the_landing_page() throws Throwable {
//	   
//		 beginEnrollmentPage=  registrationPage.clickEnrollNow();   
//	}
//
//	@Then("^User Select a How you heard option and  click on Continue button$")
//	public void user_Select_a_How_you_heard_option_and_click_on_Continue_button() throws Throwable {
//		 beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);  
//	    
//	}
	

	
//	@Then("^Select Enrollment Type as AO and  Clicks continue button of Enrollment TIN Eligible page$")
//	public void select_Enrollment_Type_as_AO_and_Clicks_Continue_button_of_Enrollment_TIN_Eligible_page () throws Throwable {
//	   
//		
//		BeginEnrollmentContinue beginEnrollmentContinuePage=new BeginEnrollmentContinue(testConfig);
//		providerEFTERAEnrollPage=beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue();
//	    
//	}

//	@Then("^User fills all the information  and click on Continue$")
//	public void user_fills_all_the_information_and_click_on_Continue() throws Throwable {
//		ProviderEFTERAEnrollPage providerEFTERAEnrollPage=new ProviderEFTERAEnrollPage(testConfig);
//		validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfo();
//	    
//	}


	@Then("^User fills all the information on Identify Administrators page and click continue$")
	public void user_fills_all_the_information_on_Identify_Administrators_page_and_click_continue() throws Throwable {
		validateEFTERAProviderInfo=new ValidateEFTERAProviderInfo(testConfig);
		financialInstitutionInfoPage=validateEFTERAProviderInfo.fillPrimaryProvInfo().clickContinue();
	}
	
	@Then("^It is Validated that Financial Institution Information page text is content managed$")
	public void it_is_Validated_that_Financial_Institution_Information_page_text_is_content_managed() throws Throwable {
		financialInstitutionInfoPage.verifyUITextFromDB();
	}
	
	@Then("^User clicks the link where can i find a finantial intitution's routing no$")
	public void User_clicks_link_FII_Routng_Lnk()
	{		financialInstitutionInfoPage.clickFINRoutlnk();	
	
	}
	
	@Then("^User clicks on browse and upload its supporting document$")
	public void user_clicks_on_browse_and_upload_its_supporting_document() throws Throwable {
		financialInstitutionInfoPage.uploadBankLetterPdfWithAcceptance();
	}
	
	@Then("^User clicks on hyperlink how do i manage multiple NPI bank accounts$")
	public void user_clicks_on_hyperlink_how_do_i_manage_multiple_NPI_bank_accounts() throws Throwable {
		financialInstitutionInfoPage.clickFINMngNPIAcc();
	}

	@Then("^User validates the Type of account as Checking by default and can be change to Saving$")
	public void user_validates_the_Type_of_account_as_Checking_by_default_and_can_be_change_to_Saving() throws Throwable {
		financialInstitutionInfoPage.verifyFinAccount("TypeOfAc");
	}

	
	@Then("^User validates the supporting document as Voided Check by default and can be change to Bank letter$")
	public void User_validates_supporting_document_as_Voided_Check_and_Bank_letter()
	{		financialInstitutionInfoPage.verifyFinAccount("SupportDoc");	
	
	}

	@Then("^User validates the NPI Bank account as No by default and can be change to Yes$")
	public void user_validates_the_NPI_Bank_account_as_No_by_default_and_can_be_change_to_Yes() throws Throwable {
		financialInstitutionInfoPage.verifyFinAccount("NPIBankAc");
	}
	
	@Then("^Validate all the Headers from FII page in case of AO and AV Enrollment type$")
	public void validate_all_the_Headers_from_FII_page_in_case_of_AV_Enrollment_type() throws Throwable {
		String BoldFontwthCircle="Financial Institution Information";
		new HeaderContentValidation(testConfig).verifyHeaders(BoldFontwthCircle);
	}

	@Then("^User validates and clicks buttons Back,Cancel Enrollment,Continue are on the FII page$")
	public void user_validates_and_clicks_buttons_Back_Cancel_Enrollment_Continue_are_on_the_FII_page() throws Throwable {
		financialInstitutionInfoPage.verifyButtons();
	}
	
	@Then("^User clicks on continue button of FII page and validtes the error messages$")
	public void User_clicks_on_continue_button_of_FII_page_and_validtes_the_error_messages() throws Throwable {
		financialInstitutionInfoPage.verifyErrors();
	}
	@Then("^User fills all the information and PO Box no in Street field and clicks on continue$")
	public void User_fills_all_the_information_and_PO_Box_no_in_Street_field_and_clicks_on_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstWrngInfo("Street");
	}
	
	@Then("^User fills all the information and invalid Zip code for corresponding City and clicks on continue$")
	public void User_fills_all_the_information_and_invalid_Zip_code_for_corresponding_City_and_clicks_on_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstWrngInfo("Zip");
	}
	
	@Then("^User fills all the information and upload non accepted file format and clicks on continue$")
	public void user_fills_all_the_information_and_upload_non_accepted_file_format_and_clicks_on_continue() throws Throwable {
		financialInstitutionInfoPage.fillFinancialInstWrngInfo("uploadFile");
	}
	
	

	@Then("^User give blank Give blank Bank Name,Street,City,State,Zip,Telephone,Routing Number,Account Number,Voided Check/Bank Letter and clicks on continue$")
	public void user_give_blank_Give_blank_Bank_Name_Street_City_State_Zip_Telephone_Routing_Number_Account_Number_Voided_Check_Bank_Letter_and_clicks_on_continue() throws Throwable {
	    
	}
}
