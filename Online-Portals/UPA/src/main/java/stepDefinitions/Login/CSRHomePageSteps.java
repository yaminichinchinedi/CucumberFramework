package main.java.stepDefinitions.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.CreateMaintainEnrollment;
import main.java.pageObjects.EditEnrollment;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.ManageUsers;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchTinPage;

public class CSRHomePageSteps extends TestBase{
	
	CSRHomePage homePage=null;
	LoginCSR loginPage=new LoginCSR(testConfig);
	SearchTinPage searchTinPage;
	ManageUsers manageUsers;


	@Given("^User navigates to CSR portal and enters credentials and login$")
	public void user_navigates_to_CSR_portal_and_enters_credentials_and_login(String userType) throws Throwable {
	//	LoginCSR loginPage=new LoginCSR(testConfig);
		homePage=loginPage.doLogin(userType);
	}
	
	
	
	@Given("^User navigates to CSR portal and enters \"([^\"]*)\" and login$")
	public void user_navigates_to_CSR_portal_and_enters_and_login(String userType) throws Throwable {
	//	LoginCSR loginPage=new LoginCSR(testConfig);
		homePage=loginPage.doLogin(userType);
	}

	   
	   @When("^Click on View Payments Link$")
	   public void click_on_View_Payments_Link() throws Throwable {
		   homePage.clickViewPaymentsLink();
	   }
	   
	   
	   @When("^Validate Search Remit Page as Prerequisties$")
	    public void validate_Search_Remit_Page_as_Prerequisties() throws Throwable {
	        
		   homePage.clickSearchRemittanceLink();
	    }
	
	   @Then("^User clicks on Search Remittance link$")
		public void user_clicks_on_Search_Remittance_link() throws Throwable {
			homePage.clickSearchRemittanceLink();
		}
	   
	   @Then("^User clicks on Common Reports link$")
		public void user_clicks_on_Common_Reports_link() throws Throwable {
			homePage.clickCommonReportsLink(); 
		}
	   
	   @When("^User clicks on Manage Users link$")
		public void user_clicks_on_Manage_Users_link() throws Throwable {
		   searchTinPage=homePage.clickManageUsersLink();
		}
	   
	   
	   @When("^Search for \"([^\"]*)\" with \"([^\"]*)\"$")
	   public void search_for_with(String userType, String searchCriteria) throws Throwable {
		   manageUsers=searchTinPage.doSearch(userType, searchCriteria);
		}
	   
	  @Then("^Verify Purged user option state is \"([^\"]*)\"$")
	   public void verify_Purged_user_option_state_is(String expectedState) throws Throwable {
		  manageUsers.verifyPurgedUserOptionState(expectedState);
		}
	 


	   @Then("^User clicks on Create/Maintain Enrollment link$")
	   public void user_clicks_on_Create_Maintain_Enrollment_link() throws Throwable {
		   homePage.clickCreateMaintainEnrollmentLink();
	   }
	   


//	   @Then("^User enters \"([^\"]*)\" and active TIN in Create/Maintain Enrollment page and navigate to edit enrollment page\\.$")
//	   public void user_enters_and_active_TIN_in_Create_Maintain_Enrollment_page_and_navigate_to_edit_enrollment_page(String userType) throws Throwable {
//			CreateMaintainEnrollment enrollment = new CreateMaintainEnrollment(testConfig);
//			enrollment.doSearch(userType);
//			enrollment.validateViewEnrollment();
//			enrollment.clickEditBtn();
//		}


	   @When("^Click on CSRManage User Link$")
		public void click_on_CSRManage_User_Link() throws Throwable {
			homePage.clickManageUsersLink();
		}
	   
	   
	   @Then("^User clicks on Create/Maintain Enrollment link on CSR HomePage$")
	   public void user_clicks_on_Create_Maintain_Enrollment_link_on_CSR_HomePage() throws Throwable {
		   homePage.clickCrtEnrlmnt();
	   }


		@Given("^User is on CSR Home Page$")
		public void user_is_on_CSR_Home_Page() throws Throwable {
			homePage.VerifyCSRLogin();
			
}
		
		@When("^Click on Billing Service Info Link CSR$")
		   public void click_on_Billing_Service_Info_Link_CSR() throws Throwable {
		       
			   homePage.clickBillingServiceInfoLink();
		   }
		@Then("^User clicks on Optum Pay Soultions link on CSR HomePage$")
		public void user_clicks_on_Optum_Pay_Soultions_link_on_CSR_HomePage() throws Throwable {
			homePage.clickOptmPaySolnLink();
		}
		
		@Then("^User clicks on Manage Internal Users link$")
		public void user_clicks_on_Manage_Internal_Users_link() throws Throwable {
			homePage.clickManageInternalUserlink();
		}
		
	
	@Given("^User fetch tin on CSR for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for Portal Experience\\.$")
	public void user_fetch_tin_on_CSR_for_for_for_for_for_Portal_Experience(String userType,String searchCriteria, String tinType, String portalAccess) throws Throwable {
		homePage.fetchTin(userType, searchCriteria, tinType, portalAccess);
	}

}
