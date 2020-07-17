package main.java.stepDefinitions.Login;

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
	HomePage home=null;

	
    @Given("^User navigates to UPA portal and enters \"([^\"]*)\" and login$")
	public void user_navigates_to_UPA_portal_and_enters_and_login(String userType) throws Throwable {

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig); 
		LoginUPA loginPage=new LoginUPA(testConfig);
		homePage=loginPage.doLoginUPA(userType);

    }


@Then("^Select the TIN for UPA Portal$")
   public void select_the_TIN_for_UPA_Portal() throws Throwable {
    
	   homePage.selectTINforUPA();
	   
}

@Then("^Select the TIN for UPA Portal for \"([^\"]*)\"$")
public void select_the_TIN_for_UPA_Portal_for(String paymentType) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	homePage.selectTin(paymentType);
}
   
  

@When("^Click on View Payments Link in UPA$")
public void click_on_View_Payments_Link_in_UPA() throws Throwable {
    
	homePage.clickViewPaymentsLinkUPA();
}


@Then("^User clicks on Search Remittance link for UPA$")
public void user_clicks_on_Search_Remittance_link_for_UPA() throws Throwable {
   
	homePage.clickSearchRemitUPA();
}

	
	
	
}
