package main.java.stepDefinitions.EditEnrollment;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.EditEnrollment;

public class CSREditEnrollment extends TestBase {
	
    EditEnrollment editEnrollment = new EditEnrollment(testConfig);
    
    @Then("^User clicks on Bank Account\\(s\\) tab and verify Payer/Patient banking level header, Select Payer/Patient Dropdown title, Select Payer/Patient Dropdown displays 'Patient Payment', Header on Banking Information table display Payer/Patient\\.$")
    public void user_clicks_on_Bank_Account_s_tab_and_verify_Payer_Patient_banking_level_header_Select_Payer_Patient_Dropdown_title_Select_Payer_Patient_Dropdown_displays_Patient_Payment_Header_on_Banking_Information_table_display_Payer_Patient() throws Throwable {
    	editEnrollment.clickBankAccountTab().verifyPayerPatientBankingHeader();
    	editEnrollment.verifySelectPayerPatientdropdowntitle();
    }
    
    @Then("^User navigates to Payer's page and verify Payers page display Patient Payment$")
    public void user_navigates_to_Payer_s_page_and_verify_Payers_page_display_Patient_Payment() throws Throwable {
    	editEnrollment.clickPayersTab().verifyPayersPagePayerNameandId();
    }
    
    @Then("^User navigates to Payer PPRAs page and verify Patient Payment under Payer Name$")
    public void user_navigates_to_Payer_PPRAs_page_and_verify_Patient_Payment_under_Payer_Name() throws Throwable {
    	editEnrollment.clickPayerPRATab().verifyPayerPRAPagePayerName();
    }
}