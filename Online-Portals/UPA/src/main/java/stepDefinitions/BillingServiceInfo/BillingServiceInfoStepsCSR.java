package main.java.stepDefinitions.BillingServiceInfo;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.pageObjects.BillingServiceInfo;

public class BillingServiceInfoStepsCSR extends TestBase {
	
    BillingServiceInfo bsInfoPage = new BillingServiceInfo(testConfig);
    
    @Then("^valdiate BS Info Page functionality$")
    public void valdiate_BS_Info_Page_functionality() throws Throwable {
    	bsInfoPage.verifyBSInfoFunctionality();
    }
    @Then("^validate Provider Tin Approval and functionality check$")
    public void validate_Provider_Tin_Approval_and_functionality_check() throws Throwable {
    	bsInfoPage.verifyApproveProvTin(); 
    }
	
}
