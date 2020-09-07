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
	SearchTinPage searchTinPage;
	ManageUsers manageUsers;


	@Given("^User navigates to CSR portal and enters credentials and login$")
	public void user_navigates_to_CSR_portal_and_enters_credentials_and_login(String userType) throws Throwable {
		LoginCSR loginPage=new LoginCSR(testConfig);
		homePage=loginPage.doLogin(userType);
	}
	
	
	
	@Given("^User navigates to CSR portal and enters \"([^\"]*)\" and login$")
	public void user_navigates_to_CSR_portal_and_enters_and_login(String userType) throws Throwable {
		LoginCSR loginPage=new LoginCSR(testConfig);
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
	 

	  @Then("^Verify Users List for \"([^\"]*)\" with \"([^\"]*)\" on selecting and deselecting of purge checkbox$")
	  public void verify_Users_List_for_with_on_selecting_and_deselecting_of_purge_checkbox(String userType, String searchCriteria) throws Throwable {
		  manageUsers=new ManageUsers(testConfig);
		  manageUsers.verifyUserList(userType,searchCriteria);
	  }
	  
	  @Then("^Verify UI Details for Purged \"([^\"]*)\" user$")
	  public void verify_UI_Details_for_Purged_user(String userType) throws Throwable {
		  manageUsers=new ManageUsers(testConfig);
		  manageUsers.verifyDetailsForPurgedUser(userType);
	    
	  }

	   @Then("^User clicks on Create/Maintain Enrollment link$")
	   public void user_clicks_on_Create_Maintain_Enrollment_link() throws Throwable {
		   homePage.clickCreateMaintainEnrollmentLink();
	   }
	   
	   @Then("^User enters \"([^\"]*)\" and active TIN in Create/Maintain Enrollment page and navigate to edit enrollment page\\.$")
	   public void user_enters_and_active_TIN_in_Create_Maintain_Enrollment_page_and_navigate_to_edit_enrollment_page(String userType) throws Throwable {
			CreateMaintainEnrollment enrollment = new CreateMaintainEnrollment(testConfig);
			enrollment.doSearch(userType);
			enrollment.validateViewEnrollment();
			enrollment.clickEditBtn();
		}
	   

	   @When("^Click on CSRManage User Link$")
		public void click_on_CSRManage_User_Link() throws Throwable {
			homePage.clickManageUsersLink();
		}
	   
	   
	   @Then("^User clicks on Create/Maintain Enrollment link on CSR HomePage$")
	   public void user_clicks_on_Create_Maintain_Enrollment_link_on_CSR_HomePage() throws Throwable {
		   homePage.clickCrtEnrlmnt();
	   }

}
