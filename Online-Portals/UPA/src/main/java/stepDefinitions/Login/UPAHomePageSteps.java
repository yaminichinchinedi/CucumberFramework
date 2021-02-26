package main.java.stepDefinitions.Login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.Browser;
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
	SearchTinPageViewPayments viewPaymentsTIN = new SearchTinPageViewPayments(testConfig);
	
    @Given("^User navigates to UPA portal and enters \"([^\"]*)\" and login$")
	public void user_navigates_to_UPA_portal_and_enters_and_login(String userType) throws Throwable {
	   new UPARegistrationPage(testConfig); 
	   LoginUPA loginPage=new LoginUPA(testConfig);
	   homePage=loginPage.doLoginUPA(userType);
	   if (userType.equalsIgnoreCase("PROV_Admin"))
		   testConfig.putRunTimeProperty("AccssLvl", "A");
	   if (userType.equalsIgnoreCase("PROV_Gen"))
		   testConfig.putRunTimeProperty("AccssLvl", "G");
    }
    
	@Given("^User navigates to UPA portal for account activation,enters \"([^\"]*)\" and login$")
	public void user_navigates_to_UPA_portal_for_account_activation_enters_and_login(String userType) throws Throwable {
		new UPARegistrationPage(testConfig);
		LoginUPA loginPage = new LoginUPA(testConfig);
		loginPage.doLoginUPAActivateAccount(userType);
	}
	
	@Given("^User fetch tin for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for Portal Experience\\.$")
	public void user_fetch_tin_for_for_for_for_for_Portal_Experience(String userType,String searchCriteria, String tinType, String portalAccess) throws Throwable {
		homePage.fetchTin(userType, searchCriteria, tinType, portalAccess);
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
   
	@When("^Click on UPA - My Profile Link$")
	public void click_on_Upa_My_Profile_Link() throws Throwable {
		homePage.clickMyProfileTab();
	}
	
	@When("^Click on Manage User Link$")
	public void click_on_Manage_User_Link() throws Throwable {
		Browser.wait(testConfig, 3);
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
	
	@Then("^User clicks on Billing Service Information tab$")
    public void user_clicks_on_Billing_Service_Information_tab() throws Throwable {
	 homePage.clickOnBSInfoTabUPA();
    }
	
	@When("^User clicks on Optum Pay Solutions tab$")
	public void user_clicks_on_Optum_Pay_Solutions_tab() throws Throwable {
		 homePage.clickOnOptumPaySolutionsTabUPA();
	}

	 @When("^User verifies HomePage Alert depending upon \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void user_verifies_HomePage_Alert_depending_upon_and(String portalAccess,String tinType) throws Throwable {
		 homePage.verifyHomePageAlertUPA(portalAccess,tinType);
	 }

	@When("^User hovers on the Resources DropDown$")
	public void user_hovers_on_the_Resources_DropDown() throws Throwable {
		homePage.hoverOnResourceDropDown();
	}

	@Then("^User clicks on Faqs link and verifies the FAQ page$")
	public void user_clicks_on_Faqs_link_and_verifies_the_FAQ_page() throws Throwable {
		homePage.verifyFaqsFromResources();
	}
		
	@Then("^User clicks on Terms and Conditions$")
	public void user_clicks_on_Terms_and_Conditions() throws Throwable {
		homePage.verifyTncLinkUnderResources();
	}
	
	@Given("^User navigates to UPA portal and enters \"([^\"]*)\" and login when the Terms and Conditions are not accepted$")
	public void user_navigates_to_UPA_portal_and_enters_and_login_when_the_Terms_and_Conditions_are_not_accepted(String userType) throws Throwable {
		new UPARegistrationPage(testConfig); 
		LoginUPA loginPage=new LoginUPA(testConfig);
		loginPage.setUserProperties(userType);
		loginPage.updateTncIfAccepted();
		homePage=loginPage.doLoginUPA(userType);
	}
		
		@Then("^User Accept the Terms and Conditions and Submit$")
		public void user_Accept_the_Terms_and_Conditions_and_Submit() throws Throwable {
			homePage.acceptTncAndSubmit();
			homePage.verifyIfTncIsUpdated();
		}
		
		@Then("^User clicks on Partners link and verifies the page$")
		public void user_clicks_on_Partners_link_and_verifies_the_page() throws Throwable {
		    homePage.verifyPartnersLink();
		}


		@Given("^Is to verify if atleast one standard \"([^\"]*)\" TIN with \"([^\"]*)\" is associated with \"([^\"]*)\" and has \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
		public void is_to_verify_if_atleast_one_standard_TIN_with_is_associated_with_and_has_with_and(String portalAccess, String tinType, String userType, String trialStatus, String SelectedOrDefault, String statusOfStandardRecd) throws Throwable {
			testConfig.putRunTimeProperty("tinType", tinType);
		    testConfig.putRunTimeProperty("portalAccess", portalAccess);
		    testConfig.putRunTimeProperty("trialStatus", trialStatus);
		    testConfig.putRunTimeProperty("statusOfStandardRecd", statusOfStandardRecd);
		    testConfig.putRunTimeProperty("SelectedOrDefault", SelectedOrDefault);
		    new UPAHomePage(testConfig).verifyStandardTinAssociation(userType);
		}

		@Then("^User verifies the presence of Bring More Power pop-up and clicks No Thanks$")
		public void user_verifies_the_presence_of_Bring_More_Power_pop_up_and_clicks_No_Thanks() throws Throwable {
			homePage.clickNoThanksOnBringMorePowerPage();
		}
		@Then("^User verifies the presence of Bring More Power pop-up and clicks I Accept$")
		public void user_verifies_the_presence_of_Bring_More_Power_pop_up_and_clicks_I_Accept() throws Throwable {
			homePage.clickAcceptOnBringMorePowerPage();
		}
		@Then("^User verifies the insertion of pending PS record and inactivation of PD record in the product selection table for all the associated standard tins$")
		public void user_verifies_the_insertion_of_pending_PS_record_and_inactivation_of_PD_record_in_the_product_selection_table_for_all_the_associated_standard_tins() throws Throwable {
			homePage.verifyDbOnAcceptingPremium();
		}
		@Then("^User verifies if TC_ACCPT_IND is flipped to Y$")
		public void user_verifies_if_TC_ACCPT_IND_is_flipped_to_Y() throws Throwable {
			homePage.verifyIfTncIsUpdated();
		}

		@Then("^User verifies if homepage is presented when TC_ACCPT_IND is Y$")
		public void user_verifies_if_homepage_is_presented_when_TC_ACCPT_IND_is_Y() throws Throwable {
			homePage.verifyHomePage();
		}
		@Then("Verify Home Page Carousel Text for \"([^\"]*)\"")
		public void verifyHomePageCarouselText(String userType){
			homePage.verifyHomePageCarouselText(userType);
		}
  
		@Then("^User clicks on Document Vault and verifies the page$")
		public void user_clicks_on_Document_Vault_and_verifies_the_page() throws Throwable {
			homePage.verifyDocumentVaultLink();

		}
		@Then("^User logs out the session$")
		public void user_logs_out_the_session() throws Throwable {
			homePage.logoutSession();
		}
}
