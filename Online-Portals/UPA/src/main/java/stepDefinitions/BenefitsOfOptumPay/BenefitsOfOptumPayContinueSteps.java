package main.java.stepDefinitions.BenefitsOfOptumPay;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BenefitsOfOptumPay;
import main.java.pageObjects.UPARegistrationPage;

public class BenefitsOfOptumPayContinueSteps extends TestBase {

	String option="Health plan communication";
	int excelRow=0;
	UPARegistrationPage registrationPage=null;
//	BeginEnrollment beginEnrollmentPage=null;
//	BeginEnrollmentContinue beginEnrollmentContinuePage=null;
//	ProviderEFTERAEnrollPage providerEFTERAEnrollPage=null;
	
	BenefitsOfOptumPay benOfOptumPay =null;
	BenefitsOfOptumPayContinueSteps benOfOptumPayContinue = null;
	
	@Given("^User navigates to UPA Sys Test application$")
	public void user_navigates_to_UPA_Sys_Test_application () throws Throwable {
		registrationPage = new UPARegistrationPage(testConfig); 
	}

	@When("^User Clicks on Benefits Of Optum Pay from the landing page$")
	public void user_Clicks_on_Benefits_Of_Optum_Pay_from_the_landing_page() throws Throwable
	{
		benOfOptumPay = registrationPage.clickBenefitsOfOptumPayLink();
	}
	
	@Then("^User validates Page title$")
	public void user_validates_Page_title() throws Throwable
	{
		benOfOptumPay.verifyBenefitsofOptumPayHeader();
	}

	@Then("^User validates Opening Paragraph Text$")
	public void user_validates_Opening_Paragraph_Text() throws Throwable 
	{
		benOfOptumPay.verifyBenefitsOfOptumPayPage();
	}
	
	@Then("^User validates Footer in the Benefits of Optum Pay page$")
	public void user_validates_Footer_in_the_Benefits_of_Optum_Pay_page() throws Throwable 
	{
	    benOfOptumPay.verifyFooter();
	}
	
	
	@Then("^User validates Green Tick Paragraph (\\d+)$")
	public void user_validates_Green_Tick_Paragraph(int paraNum) throws Throwable 
	{
	    benOfOptumPay.verifyGreenTickMark1Paragraph(paraNum);
	}

	@Then("^User Validates \"([^\"]*)\" paragraph$")
	public void user_Validates_paragraph(String paraName) throws Throwable 
	{
		benOfOptumPay.verifyparagraphTextOnOptumPayPage(paraName);
	}
	
	
}
