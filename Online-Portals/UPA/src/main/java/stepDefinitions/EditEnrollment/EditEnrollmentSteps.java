package main.java.stepDefinitions.EditEnrollment;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ClaimDetail;
import main.java.pageObjects.CreateMaintainEnrollment;
import main.java.pageObjects.EditEnrollment;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.MaintainEnrollment;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchTinPage;
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
    
    @When("^Changes banking data$")
    public void changes_banking_data() throws Throwable {
    	editEnrollment=maintainEnrollment.clickEditBtn().clickBankAccountTab().clickChangeBankData().fillDetails().clickContinueBank();
      
    }

    @When("^Adds a new bank account at Payer Level$")
    public void adds_a_new_bank_account_at_Payer_Level() throws Throwable {
       
    }

    @Then("^Verify at Payer level Bank Name, Bank Address, and Phone Number are  greyed out\\.$")
    public void verify_at_Payer_level_Bank_Name_Bank_Address_and_Phone_Number_are_greyed_out() throws Throwable {
      
    }

    @Then("^Verify Message ?Financial Institution information will be populated from the Federal Reserve based on the routing number data you provide? is displayed above the Bank Information$")
    public void verify_Message_Financial_Institution_information_will_be_populated_from_the_Federal_Reserve_based_on_the_routing_number_data_you_provide_is_displayed_above_the_Bank_Information() throws Throwable {
        
    }

    @When("^User updates the bank account at payer level$")
    public void user_updates_the_bank_account_at_payer_level() throws Throwable {
      
    }
	    
    @Given("^Change Payment Method for \"([^\"]*)\" from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void change_Payment_Method_for_from_to(String payer, String paymentFrom, String paymentTo) throws Throwable {
    	editEnrollment=maintainEnrollment.clickEditBtn();
    	editEnrollment.clickPayersTab();
    	editEnrollment.changePaymentMethod(payer, paymentFrom, paymentTo);
    }

    @Given("^Validate  \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\"  these fields in DB$")
    public void validate_these_fields_in_DB(String payer, String paymentFrom, String paymentTo) throws Throwable {
    	editEnrollment.verifyPaymentMethod(payer, paymentFrom, paymentTo);
    }

    
    @Then("^User clicks on Payer Information Tab and validates Optum Pay text insted of EPS$")
    public void user_clicks_on_Payer_Information_Tab_and_validates_Optum_Pay_text_insted_of_EPS() throws Throwable {
    	maintainEnrollment.validateOptumPayText();
    }

    @Then("^Click on Edit button and then Payers Tab and validates Optum Pay text insted of EPS$")
    public void click_on_Edit_button_and_then_Payers_Tab_and_validates_Optum_Pay_text_insted_of_EPS() throws Throwable {
    	maintainEnrollment.validateOptumPayTextonEdit();    
    }
    @Then("^Click on Edit button and then Organisation Tab,Enter special charater,click on Continue and validates Optum Pay text insted of EPS$")
    public void click_on_Edit_button_and_then_Organisation_Tab_Enter_special_charater_click_on_Continue_and_validates_Optum_Pay_text_insted_of_EPS() throws Throwable {
    	maintainEnrollment.validateOptumPayTextonEditOrg("PROV");;    
   
    }
    @Then("^User clicks on Cancel button and validates Optum Pay text insted of EPS$")
    public void user_clicks_on_Cancel_button_and_validates_Optum_Pay_text_insted_of_EPS() throws Throwable {
    	maintainEnrollment.validateOptumPayTextonCancel();
    }

    @Then("^User clicks on Finish and Submit button and validates Optum Pay text insted of EPS$")
    public void user_clicks_on_Finish_and_Submit_button_and_validates_Optum_Pay_text_insted_of_EPS() throws Throwable {
    	maintainEnrollment.validateOptumPayTextonFinish();
    }
        
    @Then("^User clicks on Edit button then Cancel button and validates Optum Pay text insted of EPS$")
    public void user_clicks_on_Edit_button_then_Cancel_button_and_validates_Optum_Pay_text_insted_of_EPS() throws Throwable {
    	maintainEnrollment.validateOptumPayTextonCancelBS();
    }
    @Then("^User clicks on Edit button,Enter special charater in Org Name then click on Finish button and validates Optum Pay text insted of EPS$")
    public void user_clicks_on_Edit_button_Enter_special_charater_in_Org_Name_then_click_on_Finish_button_and_validates_Optum_Pay_text_insted_of_EPS() throws Throwable {
    	maintainEnrollment.validateOptumPayTextonEditOrg("BS");;    
   
    }
    @Then("^User clicks on Finish and Submit button and validates Optum Pay text insted of EPS for Billing Service$")
    public void user_clicks_on_Finish_and_Submit_button_and_validates_Optum_Pay_text_insted_of_EPS_for_Billing_Service() throws Throwable {
    	maintainEnrollment.validateOptumPayTextonFinishBS();

    }   
    @Then("^User clicks of Print Enrollment Form,a PDF file is downloaded and verify Optum Pay Text instead of EPS$")
    public void user_clicks_of_Print_Enrollment_Form_a_PDF_file_is_downloaded_and_verify_Optum_Pay_Text_instead_of_EPS() throws Throwable {
    	maintainEnrollment.readPDFFile("PROV");
    }
    @Then("^User clicks of Print Enrollment Form,a PDF file is downloaded and verify Optum Pay Text instead of EPS in Billing Service$")
    public void user_clicks_of_Print_Enrollment_Form_a_PDF_file_is_downloaded_and_verify_Optum_Pay_Text_instead_of_EPS_in_Billing_Service() throws Throwable {
    	maintainEnrollment.readPDFFile("BS");

    }
    @Then("^Edit organization information$")
    public void edit_organization_information() throws Throwable {
    	 editEnrollment.editOrganizationInfo();
    }
    @Then("^User Clicks on Print Enrollment Form$")
	public void user_Clicks_on_Print_Enrollment_Form() throws Throwable {
    	editEnrollment.enrollmentPDF();
	}
    @Then("^Clicks on Payers tab$")
    public void clicks_on_Payers_tab() throws Throwable {
    	editEnrollment.clickOnPayersTab();
    }
    
    @Then("^User clicks on Edit button$")
    public void user_clicks_on_Edit_button() throws Throwable {
    	editEnrollment=maintainEnrollment.clickEditButn();  
    }

    @Then("^Change payment method preferences \"([^\"]*)\"$")
    public void change_payment_method_preferences(String tinType) throws Throwable {
        editEnrollment.changePaymentMethod(tinType);
    }

    @Then("^User validates MFA Dialog Box Title, Message, Yes and NO buttons for Maintain Enrollment tab$")
    public void user_validates_MFA_Dialog_Box_Title_Message_Yes_and_NO_buttons_for_Maintain_Enrollment_tab() throws Throwable {
        maintainEnrollment.validateMFADialogBoxContentMEtab();
    }

    @Then("^Users enters same AC No and RTN No on maintain Enrollment page and validate error message$")
    public void users_enters_same_AC_No_and_RTN_No_on_maintain_Enrollment_page_and_validate_error_message() throws Throwable {
    	editEnrollment.fillsameRTNACNo();
    }


}
