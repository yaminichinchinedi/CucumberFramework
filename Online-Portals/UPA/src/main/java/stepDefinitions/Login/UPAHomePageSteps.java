package main.java.stepDefinitions.Login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BenefitsOfOptumPay;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.HowToEnroll;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;



public class UPAHomePageSteps extends TestBase{
	
	UPAHomePage homePage=null;
	LoginUPA loginPage=null;
	
    @Given("^User navigates to UPA portal and enters \"([^\"]*)\" and login$")
	public void user_navigates_to_UPA_portal_and_enters_and_login(String userType) throws Throwable {
	   new UPARegistrationPage(testConfig); 
	   LoginUPA loginPage=new LoginUPA(testConfig);
	   homePage=loginPage.doLoginUPA(userType);
    }
    
	@Given("^User navigates to UPA portal for account activation,enters \"([^\"]*)\" and login$")
	public void user_navigates_to_UPA_portal_for_account_activation_enters_and_login(String userType) throws Throwable {
		new UPARegistrationPage(testConfig);
		LoginUPA loginPage = new LoginUPA(testConfig);
		loginPage.doLoginUPAActivateAccount(userType);
	}
	
    @When("^User Selects a tin on HomePage$")
    public void user_Selects_a_tin_on_HomePage() throws Throwable {
    	homePage.selectTin();
    }
    

@Then("^Select the TIN for UPA Portal for \"([^\"]*)\"$")
public void select_the_TIN_for_UPA_Portal_for(String paymentType) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	homePage.selectTin(paymentType);
}
   
    
    @When("^User Selects a tin on HomePage for \"([^\"]*)\"$")
    public void user_Selects_a_tin_on_HomePage_for(String searchCriteria) throws Throwable {
    	homePage.selectTin(searchCriteria);
    }
    
    @When("^User Selects a tin on HomePage for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for Portal Experience\\.$")
    public void user_Selects_a_tin_on_HomePage_for_for_for_for_Portal_Experience(String searchCriteria, String tinType, String portalAccess) throws Throwable {
    	testConfig.putRunTimeProperty("tinType", tinType);
    	testConfig.putRunTimeProperty("prdctSelected", portalAccess);
    	testConfig.putRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER", "21QG96591932");
    	homePage.selectTin(searchCriteria);
    	homePage.clickHomeTab();
    }

  
    @When("^Click on View Payments Link in UPA$")   
    public void click_on_View_Payments_Link_in_UPA() throws Throwable {
	homePage.clickViewPaymentsLinkUPA();
    }

   @Then("^User clicks on Search Remittance link for UPA$")
   public void user_clicks_on_Search_Remittance_link_for_UPA() throws Throwable {
	homePage.clickSearchRemitUPA();
   }

   @And("^Clicks on Maintain Enrollment Tab$")
   public void clicks_on_Maintain_Enrollment_Tab() throws Throwable {
   	homePage.clickMaintainEnrollmentTab();
   }
   
   @Then("^Select the TIN for \"([^\"]*)\" UPA Portal$")
	public void select_the_TIN_for_UPA_Portal(String userType) throws Throwable {
		if(userType.equalsIgnoreCase("PROV"))
			homePage.selectTin();
	}

   @Then("^Select the Purged TIN from the dropdown$")
   public void select_the_Purged_TIN_from_the_dropdown() throws Throwable {
		homePage.selectPursedTin();

   }
	@When("^Click on UPA - My Profile Link$")
	public void click_on_Upa_My_Profile_Link() throws Throwable {
		homePage.clickMyProfileTab();
	}
	
	@When("^Click on Manage User Link$")
	public void click_on_Manage_User_Link() throws Throwable {
		homePage.clickManageUsersTab();
	}

	
	@Given("^User navigates to UPA portal and enters \"([^\"]*)\" and login as purged User\\.$")
	public void user_navigates_to_UPA_portal_and_enters_and_login_as_purged_User(String userType) throws Throwable {
		if(userType.contains("PRPURGED"))
			testConfig.putRunTimeProperty("prpurged", "prpurged");
		 new UPARegistrationPage(testConfig); 
		 loginPage=new LoginUPA(testConfig);
		 loginPage.doLoginPurgedUPA(userType);
	}

	@Then("^validate the error page and click return to login button\\.$")
	public void validate_the_error_page_and_click_return_to_login_button() throws Throwable {
		loginPage.verifyErrorPageAndClickReturn();
	}

	@Then("^validate landing page is present\\.$")
	public void validate_landing_page_is_present() throws Throwable {
		loginPage.verifyLandingPage();
	}

	@Then("^Enters security pin for \"([^\"]*)\"\\.$")
	public void enters_security_pin_for(String role) throws Throwable {
		loginPage.enterSSOTin(role);
	}

	@Given("^User navigates to UPA portal and verifies user is on landing page$")
	public void user_navigates_to_UPA_portal_and_verifies_user_is_on_landing_page() throws Throwable {
		new UPARegistrationPage(testConfig);
		LoginUPA loginPage = new LoginUPA(testConfig);
		loginPage.verifyLandingPage();
	}

	@Then("^user verifies home page$")
	public void user_verifies_home_page() throws Throwable {
		new UPARegistrationPage(testConfig).verifyHomePage();
	}

	@Then("^user navigates to benefits of optum pay tab$")
	public void user_navigates_to_benefits_of_optum_pay_tab() throws Throwable {
		new UPARegistrationPage(testConfig).clickBenefitsOfOptumPayLink();
	}

	@Then("^user verifies benefits of optum pay page$")
	public void user_verifies_benefits_of_optum_pay_page() throws Throwable {
		BenefitsOfOptumPay benefits = new BenefitsOfOptumPay(testConfig);
		benefits.verifyBenefitsOfOptumPayPage();
	}

	@Then("^user navigates to how to enroll tab$")
	public void user_navigates_to_how_to_enroll_tab() throws Throwable {
		new UPARegistrationPage(testConfig).clickHowToEnrollLink();
	}

	@Then("^user verifies how to enroll page$")
	public void user_verifies_how_to_enroll_page() throws Throwable {
		HowToEnroll enrl = new HowToEnroll(testConfig);
		enrl.verifyHowToEnrollPage();
	}
	
	@When("^Click on UPA - Manage User Link$")
	public void click_on_Upa_Manage_User_Link() throws Throwable {
	    homePage.clickManageUsersLink();
	}
}
