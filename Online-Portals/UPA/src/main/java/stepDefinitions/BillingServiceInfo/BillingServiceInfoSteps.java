package main.java.stepDefinitions.BillingServiceInfo;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.pageObjects.BillingServiceInfo;


public class BillingServiceInfoSteps extends TestBase {
	
    BillingServiceInfo bsInfoPage = new BillingServiceInfo(testConfig);
    
    @Then("^Select \"([^\"]*)\" and TIN for \"([^\"]*)\"$")
    public void select_and_TIN_for(String searchBy,String usertype) throws Throwable {
    	bsInfoPage.verifyUserType(searchBy, usertype);
    }

//    @Then("^validate BS Info Page functionality for \"([^\"]*)\"$")
//    public void validate_BS_Info_Page_functionality_for(String usertype) throws Throwable {
//    	bsInfoPage.verifyBSInfoFunctionality(usertype);
//    }
    
    @Then("^valdiate BS Info Page functionality$")
    public void valdiate_BS_Info_Page_functionality() throws Throwable {
    	bsInfoPage.verifyBSInfoFunctionality();
    }
//    @Then("^valdiate BS Info Page functionality \"([^\"]*)\"$")
//    public void valdiate_BS_Info_Page_functionality(String paymentType) throws Throwable {
//    	bsInfoPage.verifyBSInfoFunctionality(paymentType);
//    }


    @Then("^validate Provider Tin Approval and functionality check$")
    public void validate_Provider_Tin_Approval_and_functionality_check() throws Throwable {
    	bsInfoPage.verifyaproveprovtin(); 
    }
    
    @Then("^User verifies the Trial End Date and updates it to one day later if trial is over$")
    public void user_verifies_the_Trial_End_Date_and_updates_it_to_one_day_later_if_trial_is_over() throws Throwable {
    	bsInfoPage.verifyTrialEndDateAndUpdateIfOver();
    }

    @Then("^User verifies the page text during trial$")
    public void user_verifies_the_page_text_during_trial() throws Throwable {
    	bsInfoPage.verifyPageText();
    }


	
}
