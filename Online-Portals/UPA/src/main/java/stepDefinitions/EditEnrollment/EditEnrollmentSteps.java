package main.java.stepDefinitions.EditEnrollment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ClaimDetail;
import main.java.pageObjects.EditEnrollment;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.MaintainEnrollment;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.ValidateEnrollmentTypePage;

public class EditEnrollmentSteps extends TestBase {
	
    MaintainEnrollment maintainEnrollment = new MaintainEnrollment(testConfig);
    EditEnrollment editEnrollment;
    UPAHomePage homePage;

    
    @Then("^Verify Edit Enrollment Page UI for \"([^\"]*)\"$")
    public void verify_Edit_Enrollment_Page_UI_for(String accessType) throws Throwable {
    	maintainEnrollment.verifyEnrollmentUI(accessType);
    }
    
    @Then("^Verify Org Info$")
    public void verify_Org_Info() throws Throwable {
    	maintainEnrollment.verifyOrgInfoOfSelectedTin();
    }

    @Then("^Verify W9 is downloaded successfully$")
    public void verify_W9_is_downloaded_successfully() throws Throwable {
    	maintainEnrollment.verifyw9IsDownloaded();
    }

    @Then("^Verify Bank Account info for \"([^\"]*)\"$")
    public void verify_Bank_Account_info(String accessType) throws Throwable {
    	maintainEnrollment.verifyOrgBankAccountInfo(accessType);
    }

    @Then("^Verify Voided Check is downloaded successfully for \"([^\"]*)\"$")
    public void verify_Voided_Check_is_downloaded_successfully(String accessType) throws Throwable {
    	maintainEnrollment.verifyVoidedCheckIsDownloaded(accessType); 
    }
    
    @When("^Clicks on Edit button$")
    public void clicks_on_Edit_button() throws Throwable {
    	editEnrollment=maintainEnrollment.clickEditBtn();
    }

    @Then("^Verify Org,Payer and Bank Account Tabs are displayed$")
    public void verify_Org_Payer_and_Bank_Account_Tabs_are_displayed() throws Throwable {
    	editEnrollment.verifyTabsAreDisplayed();
    }

    @Then("^Verify Org Info from DB and UI$")
    public void verify_Org_Info_from_DB_and_UI() throws Throwable {
    	editEnrollment.verifyOrgInfo();
    }

    @Then("^Clicks and verify cancel button functionality$")
    public void clicks_and_verify_cancel_button_functionality() throws Throwable {
    	homePage=editEnrollment.clickandVerifyCancelFunc();
    }


    @Then("^Clicks Continue button and verify Payer tab gets Active$")
    public void clicks_Continue_button_and_verify_Payer_tab_gets_Active() throws Throwable {
    	editEnrollment.clickContinue();
    }

    @Then("^Verify Payer Table Data$")
    public void verify_Payer_Table_Data() throws Throwable {
    	editEnrollment.verifyPayerTable();
    }
    
    
    @When("^Clicks Bank Account Tab$")
    public void clicks_Bank_Account_Tab() throws Throwable {
     editEnrollment.clickBankAccountTab();
    }

    @Then("^Clicks Change Bank Data and fill details$")
    public void clicks_Change_Bank_Data_and_fill_details() throws Throwable {
    	editEnrollment.clickChangeBankData().fillDetails();	
    }

    @Then("^Clicks Continue Bank$")
    public void clicks_Continue_Bank() throws Throwable {
    	editEnrollment.clickContinueBank();
    }

    @Then("^Verify Tin Level Bank Info$")
    public void verify_Tin_Level_Bank_Info() throws Throwable {
    	editEnrollment.verifyTinLevelBankInfo();
    }

    @Then("^Verify Bank Name is updated with new name$")
    public void verify_Bank_Name_is_updated_with_new_name() throws Throwable {
    	editEnrollment.updateBankName();
    }
    
    @Then("^Verify Payer Level Info$")
    public void verify_Payer_Level_Info() throws Throwable {
    	editEnrollment.verifyPayerLevelInfoUI();
    }
    
    @Then("^Verify NPI Level Info$")
    public void verify_NPI_Level_Info() throws Throwable {
    	editEnrollment.verifyNPILevelInfo();
    }
    
    
    
   
	
}
