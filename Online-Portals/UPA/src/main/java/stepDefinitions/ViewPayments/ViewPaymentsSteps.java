package main.java.stepDefinitions.ViewPayments;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.ValidateEnrollmentTypePage;
import main.java.pageObjects.ViewPayments_Page;

import main.java.pageObjects.SearchTinPageViewPayments;

public class ViewPaymentsSteps extends TestBase {
	
    ViewPayments_Page viewPayments = new ViewPayments_Page(testConfig);
    

    @Then("^Validate all other columns in Show All State$")
	public void validate_all_other_columns_in_Show_All_State() throws Throwable {
	    
    	viewPayments.verifyAllOtherDrpDwns();
	}
    
    @Then("^Validate all other columns in Show All State for UPA$")
    public void validate_all_other_columns_in_Show_All_State_for_UPA() throws Throwable {
        
    	viewPayments.verifyAllOtherDrpDwnsinUPA();
    }
   
    @Then("^Validate all other columns in Show All State for \"([^\"]*)\" of UPA View Payments$")
    public void validate_all_other_columns_in_Show_All_State_for_of_UPA_View_Payments(String TimePeriod) {
    	viewPayments.verifyAllColumnsViewPay(TimePeriod);
    }
    @When("^Validate all other columns in Show All State for UPA_Payer$")
    public void validate_all_other_columns_in_Show_All_State_for_UPA_Payer() throws Throwable {
        
    	viewPayments.verifyAllOtherDrpDwnsinUPAPayer();
    }
    
    @Then("^Validate Payment Number Hyper Link$")
    public void validate_Payment_Number_Hyper_Link() throws Throwable {
    	
    	viewPayments.verifyPaymentNumberHypherLinkClaimDtl();
    }
    
    @When("^Click on View Payments Link for UPA$")
    public void click_on_View_Payments_Link_for_UPA() throws Throwable {
        
    	viewPayments.clickViewPaymentsTab();
    }
    
    @Then("^Validate Payment Number Hyper Link in UPA$")
    public void validate_Payment_Number_Hyper_Link_in_UPA() throws Throwable {
   
	   viewPayments.verifyPayNumHypherLinkClaimDtlUPA();
    }
    
    @Then("^Validate Payment Number Hyper Link in UPA Payer$")
    public void validate_Payment_Number_Hyper_Link_in_UPA_Payer() throws Throwable {
       
    	 viewPayments.verifyPayNumHypherLinkClaimDtlPayer();
    }

    
    
}
