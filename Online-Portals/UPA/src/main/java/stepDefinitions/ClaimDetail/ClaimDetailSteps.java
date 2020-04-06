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
    
    @Then("^Verify Claim Detail UI vs FISL Response$")
    public void verify_Claim_Detail_UI_vs_FISL_Response() throws Throwable {
        
    	claimDetail.verifyClaimDtlPageData();
    }
    
    @Then("^Validate all Headers in the Page for Claim Detail Page$")
    public void validate_all_Headers_in_the_Page_for_Claim_Detail_Page() throws Throwable {
        
    	claimDetail.verifyAllHeadersClaimDtl();
    }

    @Then("^Validate Column Headers in the Page for Claim Detail Page$")
    public void validate_Column_Headers_in_the_Page_for_Claim_Detail_Page() throws Throwable {
       
    	claimDetail.verifyColumnHeadersClaimDtl();
    }
    
    @Then("^Validate Tricare Masking for Claim Detail Page$")
    public void validate_Tricare_Masking_for_Claim_Detail_Page() throws Throwable {
        
    	claimDetail.verifyTricareMaskingClaimDtl();
    }
   

    @Then("^Validate all Headers in the Page for Claim Detail Page for Payer$")
    public void validate_all_Headers_in_the_Page_for_Claim_Detail_Page_for_Payer() throws Throwable {
    
    	claimDetail.verifyAllHeadersClaimDtlPay();
    }

	
}
