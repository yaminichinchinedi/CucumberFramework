package main.java.stepDefinitions.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.SearchRemittance;

public class CSRHomePageSteps extends TestBase{
	
	CSRHomePage homePage=null;


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
	   
	   @When("^Click on CSRManage User Link$")
		public void click_on_CSRManage_User_Link() throws Throwable {
			homePage.clickManageUsersLink();
		}

	 
}
