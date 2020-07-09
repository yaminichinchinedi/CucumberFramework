package main.java.stepDefinitions.Login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;



public class UPAHomePageSteps extends TestBase{
	
	UPAHomePage homePage=null;

	
    @Given("^User navigates to UPA portal and enters \"([^\"]*)\" and login$")
	public void user_navigates_to_UPA_portal_and_enters_and_login(String userType) throws Throwable {
	   new UPARegistrationPage(testConfig); 
	   LoginUPA loginPage=new LoginUPA(testConfig);
	   homePage=loginPage.doLoginUPA(userType);
    }

    @When("^User Selects a tin on HomePage$")
    public void user_Selects_a_tin_on_HomePage() throws Throwable {
    	homePage.selectTin();
    }
    
   
    
    @When("^User Selects a tin on HomePage for \"([^\"]*)\"$")
    public void user_Selects_a_tin_on_HomePage_for(String searchCriteria) throws Throwable {
    	homePage.selectTin(searchCriteria);
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
			homePage.selectTINforUPA();
	}

	@When("^Click on UPA - My Profile Link$")
	public void click_on_Upa_My_Profile_Link() throws Throwable {
		homePage.clickMyProfileTab();
	}
	
	@When("^Click on Manage User Link$")
	public void click_on_Manage_User_Link() throws Throwable {
		homePage.clickManageUsersLink();
	}

	
}
