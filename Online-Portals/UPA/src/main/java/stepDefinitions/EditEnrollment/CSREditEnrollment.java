package main.java.stepDefinitions.EditEnrollment;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CreateMaintainEnrollment;
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
    
    @Then("^User navigates to Payer's page and Change the Payment Method$")
    public void user_navigates_to_Payer_s_page_and_Change_the_Payment_Method() throws Throwable {
    	editEnrollment.clickPayersTab();
    	editEnrollment.UpdateandVerifyPayerTable();
    }
    
    @Then("^User navigates to Payer's page and Change the Payment Method and Valiadate Payer Enrolled Provider History Table$")
    public void user_navigates_to_Payer_s_page_and_Change_the_Payment_Method_and_Valiadate_Payer_Enrolled_Provider_History_Table() throws Throwable {
    	editEnrollment.clickPayersTab();
    	editEnrollment.UpdatePaymentMethodandValidatePEPHistoryTable();
    }
    
    @Then("^User clicks on edit and navigates to Payer page and verify  Payment Method for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_clicks_on_edit_and_navigates_to_Payer_page_and_verify_Payment_Method_for_and(String payerName, String tinType) throws Throwable {
    	editEnrollment.clickPayersTab();
    	editEnrollment.verifyPaymentMethod(payerName, tinType);
    }
    
    @Then("^User Edit organization information$")
    public void user_Edit_organization_information() throws Throwable {
        editEnrollment.editOrganizationInfo();
    }
    @Then("^User Click on Print Enrollment Form$")
   	public void user_Click_on_Print_Enrollment_Form() throws Throwable {
       	editEnrollment.enrollmentPDF();
   	}


}