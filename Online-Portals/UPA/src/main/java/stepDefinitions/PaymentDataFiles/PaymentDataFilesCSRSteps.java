package main.java.stepDefinitions.PaymentDataFiles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.PaymentDataFilesCSR;
import main.java.pageObjects.CSRHomePage;   
import main.java.pageObjects.LoginCSR;      



public class PaymentDataFilesCSRSteps extends TestBase {

	TestBase testConfig = TestBase.getInstance();
	PaymentDataFilesCSR clickDataBundle = new PaymentDataFilesCSR(testConfig);



@When("^User Validates Error Message upon Entering invalid TIN$")
public void User_Validates_Error_Message_upon_Entering_invalid_TIN() throws Throwable {
	clickDataBundle.verifyInvalidTIN();
}

@When("^Verify User navigates to Create Data Bundle Page$")
public void verify_User_navigates_to_Create_Data_Bundle_Page() throws Throwable {
	clickDataBundle.verifyCreateDataBundlePage();
  }

@Then("^Verify all values in Create Data Bundle Page$")
public void verify_all_values_in_Create_Data_Bundle_Page() throws Throwable {
	clickDataBundle.verifyAllValuesInCreateBundlePage();
  }

@When("^User Verify Payer Name List in Payer Selection$")
public void verify_Payer_Name_List_in_Payer_Selection() throws Throwable {
	clickDataBundle.verifyPayerList();
    
}

@When("^User Verify Buttons Available viz: Add, Add All, Remove, Remove All$")
public void verify_Buttons_Available_viz_Add_Add_All_Remove_Remove_All() throws Throwable {
	clickDataBundle.verifyButtonsList();
}

@When("^Verify Add Button Functionality$")
public void verify_Add_Button_Functionality() throws Throwable {
	clickDataBundle.verifyAddButton();
}

@When("^Verify Remove Button Functionality$")
public void verify_Remove_Button_Functionality() throws Throwable {
	clickDataBundle.verifyRemoveButton();
}

@Then("^Verify Add All Button Functioanlity$")
public void verify_Add_All_Button_Functioanlity() throws Throwable {
	clickDataBundle.verifyAddAllButton();
}

@Then("^Verify Remove All Button Functionality$")
public void verify_Remove_All_Button_Functionality() throws Throwable {
	clickDataBundle.verifyRemoveAllButton(); 
}

@Then("^Verify Reset Functionality$")
public void verify_Reset_Functionality() throws Throwable {
	clickDataBundle.verifyResetButton();
}

@Then("^Verify Submit Error without selecting any Fields$")
public void verify_Submit_Error_without_selecting_any_Fields() throws Throwable {
	clickDataBundle.verifyErrorWithoutSubmittingAnyField();
	}

@Then("^Verify Settlement Date Error Upon selecting Payer and File Types$")
public void verify_Settlement_Error_when_selecting_Payer_File_Types() throws Throwable {
    clickDataBundle.verifyErrorWithoutSettlementDates();
    }

@Then("^Verify File Types Error Upon selecting Payer and Settlement Date$")
public void verify_File_Types_Error_when_selecting_Payer_Settlement_Types() throws Throwable {
    clickDataBundle.verifyErrorWithoutFileType();
}

@Then("^Verify Settlemnet Date Error for Selecting Date range of more than (\\d+) Days Between From and To Date$")
public void verify_Settlemnet_Date_Error_for_more_than_Days_Between_From_and_To_Date(int arg1) throws Throwable {
    clickDataBundle.verifyErrorForMore30days();
}

@Then("^Verify Settlement Date Error for To/From Dates must be prior to or same as Current date$")
public void verify_Settlement_Date_Error_To_From_Dates_must_be_prior_to_or_same_as_Current_date() throws Throwable {
    clickDataBundle.verifyErrorForPriorDates();
}

@Then("^Verify Payer Selection Error$")
public void verify_Payer_Selection_Error() throws Throwable {
	clickDataBundle.verifyErrorForPayerSelection();
}


@Then("^User selects all the Payer from the Payer List$")
public void verify_Payer_Selection_from_Available_to_Selected_Payers_List() throws Throwable {
	clickDataBundle.verifyPayerSelection();
}

@Then("^User Enter Settlement Date Range$")
public void enter_Settlement_Date_Range() throws Throwable {
	clickDataBundle.enterPaymentDate();
}

@Then("^User selects File Type as EPRA and Submit File Data Bundle$")
public void submit_EPRA_File_Data_Bundle() throws Throwable {
	clickDataBundle.verifySubmitEPRAsDataBundle();
}

@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type on CSR$")
public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_File_Type_on_CSR() throws Throwable {
	clickDataBundle.EPRAFileType();
}


@Then("^User verifies the EPRA indicator in Database entry on CSR$")
public void user_verifies_the_EPRA_indicator_in_Database_entry_on_CSR() throws Throwable {
	clickDataBundle.verifyEPRAInd();
}

@Then("^User selects File Type as PPRA and Submit File Data Bundle$")
public void submit_PPRA_File_Data_Bundle() throws Throwable {
	clickDataBundle.verifySubmitPRAsDataBundle();
}

@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type on CSR$")
public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_File_Type_on_CSR() throws Throwable {
	clickDataBundle.PPRAFileType();
}

@Then("^User verifies the PPRA indicator in Database entry on CSR$")
public void user_verifies_the_PPRA_indicator_in_Database_entry_on_CSR() throws Throwable {
	clickDataBundle.verifyPPRAInd();
}

@Then("^User selects File Type as (\\d+) and Submit File Data Bundle$")
public void submit_File_Data_Bundle(int arg1) throws Throwable {
	clickDataBundle.verifySubmit835DataBundle();
}


@Then("^User verifies the (\\d+) indicator in Database entry on CSR$")
public void user_verifies_the_indicator_in_Database_entry_on_CSR(int arg1) throws Throwable {
	clickDataBundle.verify835Ind();
}

@Then("^User verifies the EPRA and PPRA indicator in Database entry on CSR$")
public void user_verifies_the_EPRA_and_PPRA_indicator_in_Database_entry_on_CSR() throws Throwable {    
	clickDataBundle.verifyEPRAnPPRAInd();
}

@Then("^User verifies the EPRA and (\\d+) indicator in Database entry on CSR$")
public void user_verifies_the_EPRA_and_indicator_in_Database_entry_on_CSR(int arg1) throws Throwable {
	clickDataBundle.verifyEPRAn835Ind();
}

@Then("^User verifies the PPRA and (\\d+) indicator in Database entry on CSR$")
public void user_verifies_the_PPRA_and_indicator_in_Database_entry_on_CSR(int arg1) throws Throwable {
	clickDataBundle.verifyPPRAn835Ind();
}

@Then("^User verifies the EPRA, PPRA and (\\d+) indicator in Database entry on CSR$")
public void user_verifies_the_EPRA_PPRA_and_indicator_in_Database_entry_on_CSR(int arg1) throws Throwable {
	clickDataBundle.verifyEPRAn835nPPRAInd();
}

@Then("^User selects File Type as EPRA and PPRA and Submit File Data Bundle on CSR$")
public void submit_EPRA_and_PPRA_File_Data_Bundle_on_csr() throws Throwable {
	clickDataBundle.VerifyEPRAandPPRA();
}

@Then("^User selects File Type as EPRA and (\\d+) and Submit File Data Bundle on CSR$")
public void submit_EPRA_and_File_Data_Bundle_on_CSR(int arg1) throws Throwable {
	clickDataBundle.VerifyEPRAand835(); 
}

@Then("^User selects File Type as PPRA and (\\d+) and Submit File Data Bundle on CSR$")
public void submit_PPRA_and_File_Data_Bundle_on_CSR(int arg1) throws Throwable {
	clickDataBundle.VerifyPPRAand835();
}

@Then("^User selects File Type as EPRA PPRA and (\\d+) and Submit File Data Bundle on CSR$")
public void submit_EPRA_and_PPRA_and_File_Data_Bundle_on_CSR(int arg1) throws Throwable {
	clickDataBundle.VerifyEPRAandPPRAand835();
}

@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for (\\d+) File Type on CSR$")
public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_File_Type_on_CSR(int arg1) throws Throwable {
	clickDataBundle.eight35FileType();
	
}

@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type on CSR$")
public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_PPRA_File_Type_on_CSR() throws Throwable {
	clickDataBundle.EPRAnPPRAFileType();
}

@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and (\\d+) File Type on CSR$")
public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_File_Type_on_CSR(int arg1) throws Throwable {
	clickDataBundle.EPRAn835FileType();
}

@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and (\\d+) File Type on CSR$")
public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_and_File_Type_on_CSR(int arg1) throws Throwable {
	clickDataBundle.PPRAn835FileType();
}

@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and (\\d+) File Type on CSR$")
public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_PPRA_and_File_Type_on_CSR(int arg1) throws Throwable {
	clickDataBundle.EPRAn835nPPRAFileType();
}

@When("^User enters the TIN number of completed Data Bundle Requests$")
public void user_enters_the_TIN_number_of_completed_Data_Bundle_Requests() throws Throwable {
	clickDataBundle.getCompletedIN();
}

@When("^User Click on Download Data Bundle Tab$")
public void user_Click_on_Download_Data_Bundle_Tab() throws Throwable {
	clickDataBundle.DownloadDataBundlePage();
    
}

@Then("^User validates the completed File Name in the Grid on CSR$")
public void user_validates_the_completed_File_Name_in_the_Grid_on_CSR() throws Throwable {	
	clickDataBundle.verifyZipFileName();
}


@Then("^User Verify Patient Payment Payer appear on top of the list$")
public void user_Verify_Patient_Payment_Payer_appear_on_top_of_the_list() throws Throwable {
	clickDataBundle.verifyPatientPaymentOnTopOfTheList();
}

@Then("^User Verify for Note appears that Payer PRAs and EPRAs are not available for Patient Payments$")
public void user_Verify_for_Note_appears_that_Payer_PRAs_and_EPRAs_are_not_available_for_Patient_Payments() throws Throwable {
	clickDataBundle.verifyPayerPRANote();
}

@Then("^User  Verify for Note that Data Bundle requests for Patient Payments will be available soon, no longer appears above Payer Selection\\.$")
public void user_Verify_for_Note_that_Data_Bundle_requests_for_Patient_Payments_will_be_available_soon_no_longer_appears_above_Payer_Selection() throws Throwable {
	clickDataBundle.verifyAbsenseOfPatientPaymentsNote();
}

@Then("^User  Verifies able to select (\\d+)s$")
public void user_Verifies_able_to_select_s(int arg1) throws Throwable {
	clickDataBundle.verify835isClickable();
}

}
