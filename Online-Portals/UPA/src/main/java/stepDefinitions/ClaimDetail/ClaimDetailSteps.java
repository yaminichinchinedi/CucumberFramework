package main.java.stepDefinitions.ClaimDetail;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ClaimDetail;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.ValidateEnrollmentTypePage;

public class ClaimDetailSteps extends TestBase {
	
    ClaimDetail claimDetail = new ClaimDetail(testConfig);
    
    @Then("^Verify Claim Detail UI vs FISL Response for \"([^\"]*)\"$")
    public void verify_Claim_Detail_UI_vs_FISL_Response_for(String usertype) throws Throwable {
    
    	claimDetail.verifyClaimDtlPageData_latest(usertype);
    }
    
    @Then("^Validate all Headers in the Page for Claim Detail Page$")
    public void validate_all_Headers_in_the_Page_for_Claim_Detail_Page() throws Throwable {
        
    	claimDetail.verifyAllHeadersClaimDtl();
    }

    @Then("^Validate Column Headers in the Page for Claim Detail Page$")
    public void validate_Column_Headers_in_the_Page_for_Claim_Detail_Page() throws Throwable {
       
    	claimDetail.verifyColumnHeadersClaimDtl();
    }
    
    @Then("^Validate Column Footers in the Page for Claim Detail Page$")
    public void validate_Column_Footers_in_the_Page_for_Claim_Detail_Page() throws Throwable {
       
    	claimDetail.verifyColumnFootersClaimDtl();
    }

    @Then("^Validate all Headers in the Page for Claim Detail Page for Payer$")
    public void validate_all_Headers_in_the_Page_for_Claim_Detail_Page_for_Payer() throws Throwable {
    
    	claimDetail.verifyAllHeadersClaimDtlPay();
    }

    @Then("^Click on Payment number on Claim detail screen and go to single Payment View Payment screen\\.$")
    public void click_on_Payment_number_on_Claim_detail_screen_and_go_to_single_Payment_View_Payment_screen() throws Throwable {
    	claimDetail.clickPaymentNumber();
    }
}
