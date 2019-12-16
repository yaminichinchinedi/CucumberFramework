
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
import main.java.pageObjects.HeaderContentValidation;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;
//import main.java.stepDefinitions.support.Hook;
//import main.java.stepDefinitions.support.SuperStepDef;

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

	
	/*@Then("^Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page$")
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
	}*/
	
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


//	@Then("^User fills all the information on Identify Administrators page and click continue$")
//	public void user_fills_all_the_information_on_Identify_Administrators_page_and_click_continue() throws Throwable {
//		financialInstitutionInfoPage=validateEFTERAProviderInfo.fillPrimaryProvInfo().clickContinue();
//	}
//	
//	@Then("^User clicks the link where can i find a finantial intitution's routing no$")
//	public void User_clicks_link_FII_Routng_Lnk()
//	{		financialInstitutionInfoPage.clickFINRoutlnk();	
//	
//	}
//	
//	@Then("^User clicks on browse and upload its supporting document$")
//	public void user_clicks_on_browse_and_upload_its_supporting_document() throws Throwable {
//		financialInstitutionInfoPage.uploadBankLetterPdfWithAcceptance();
//	}
//	
//	@Then("^User clicks on hyperlink how do i manage multiple NPI bank accounts$")
//	public void user_clicks_on_hyperlink_how_do_i_manage_multiple_NPI_bank_accounts() throws Throwable {
//		financialInstitutionInfoPage.clickFINMngNPIAcc();
//	}
//
//	
//	@Then("^User validates the supporting document as Voided Check and Bank letter$")
//	public void User_validates_supporting_document_as_Voided_Check_and_Bank_letter()
//	{		financialInstitutionInfoPage.verifyFinAccount();	
//	
//	}
//	
//	@Then("^Validate all the Headers from FII page in case of AO and AV Enrollment type$")
//	public void validate_all_the_Headers_from_FII_page_in_case_of_AV_Enrollment_type() throws Throwable {
//		String BoldFontwthCircle="Financial Institution Information";
//		new HeaderContentValidation(testConfig).verifyHeaders(BoldFontwthCircle);
//	}
//
//	@Then("^User validates and clicks buttons Back,Cancel Enrollment,Continue are on the FII page$")
//	public void user_validates_and_clicks_buttons_Back_Cancel_Enrollment_Continue_are_on_the_FII_page() throws Throwable {
//		financialInstitutionInfoPage.verifyButtons();
//	}
//	
//	@Then("^User clicks on continue button of FII page and validtes the error messages$")
//	public void User_clicks_on_continue_button_of_FII_page_and_validtes_the_error_messages() throws Throwable {
//		financialInstitutionInfoPage.verifyErrors();
//	}
	
}
