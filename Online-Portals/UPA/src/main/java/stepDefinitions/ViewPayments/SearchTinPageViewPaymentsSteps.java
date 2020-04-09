package main.java.stepDefinitions.ViewPayments;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.ValidateEnrollmentTypePage;
import main.java.pageObjects.ViewPayments_Page;

import main.java.pageObjects.SearchTinPageViewPayments;

public class SearchTinPageViewPaymentsSteps extends TestBase {
	
    SearchTinPageViewPayments ViewPaymentsTIN = new SearchTinPageViewPayments(testConfig);

    
    @Then("^User enters tin on View Payments Tin \"([^\"]*)\" and click continue$")
    public void user_enters_tin_on_View_Payments_Tin_and_click_continue(String srchCriteria) throws Throwable {
        
    	ViewPaymentsTIN.enterTin(srchCriteria).clickSearchBtn();
    }
    
	@Given("^User enters tin for UPA \"([^\"]*)\"$")
	public void user_enters_tin_for_UPA(String srchCriteria) throws Throwable {
	    
		ViewPaymentsTIN.enterTinUPA(srchCriteria);
	}
	
	@Then("^User enters tin for UPA \"([^\"]*)\" for BS$")
	public void user_enters_tin_for_UPA_for_BS(String srchCriteria) throws Throwable {
	   
		ViewPaymentsTIN.enterTinForBS(srchCriteria);
	}
	
	@When("^User enters tin for BS UPA \"([^\"]*)\" for BS for \"([^\"]*)\" and click on continue button$")
	public void user_enters_tin_for_BS_UPA_for_BS_for_and_click_on_continue_button(String srchCriteria, String priority) throws Throwable {
	
		if(priority.equals("1"))
		{
			testConfig.putRunTimeProperty("claimRange1", "1");
			testConfig.putRunTimeProperty("claimRange2", "10");
			testConfig.putRunTimeProperty("priority", "1");
		}
		else if(priority.equals("2"))
		{
			testConfig.putRunTimeProperty("claimRange1", "80");
			testConfig.putRunTimeProperty("claimRange2", "100");
			testConfig.putRunTimeProperty("priority", "2");
		}

		ViewPaymentsTIN.enterTinForBS(srchCriteria);
	}
	
	@Given("^User enters tin for UPA \"([^\"]*)\" for Payer$")
	public void user_enters_tin_for_UPA_for_Payer(String srchCriteria) throws Throwable {
	   
		ViewPaymentsTIN.enterTinForPayer(srchCriteria);
	}
	
}
