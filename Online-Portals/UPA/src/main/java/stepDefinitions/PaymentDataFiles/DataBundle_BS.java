package main.java.stepDefinitions.PaymentDataFiles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.PaymentDataFiles_BS;
import main.java.pageObjects.PaymentDataFiles_Payer;
import main.java.pageObjects.Payment_DataFiles_Page;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;

public class DataBundle_BS {
	
	TestBase testConfig = TestBase.getInstance();
	PaymentDataFiles_BS bsdatabundle = new PaymentDataFiles_BS(testConfig);
	
	@Given("^User navigates to UPA portal and enters \"([^\"]*)\" to login as Billing Service$")
	public void user_navigates_to_UPA_portal_and_enters_to_login_as_Billing_Service(String userType) throws Throwable {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig); 
        LoginUPA loginPage=new LoginUPA(testConfig);
		UPAHomePage upaHome=loginPage.doLoginUPA(userType);   
	}

	@When("^User clicks on Data Bundle Tab for Billing Service$")
	public void user_clicks_on_Data_Bundle_Tab_for_Billing_Service() throws Throwable {
		bsdatabundle.clickPaymentDataFilesTab();
	    
	}

	@When("^User enters Provider Tin associated to BS for UPA \"([^\"]*)\"$")
	public void user_enters_Provider_tin_for_UPA(String srchCriteria) throws Throwable {
	    
		bsdatabundle.enterBSTin(srchCriteria);
	}

	@When("^Verify User navigates to Create Data Bundle Page on UI for Billing Service$")
	public void verify_User_navigates_to_Create_Data_Bundle_Page_on_UI_for_Billing_Service() throws Throwable {
	    
		bsdatabundle.verifyCreateDataBundlePage();
	}

	@Then("^Verify the values in Create Data Bundle Page for Billing Service$")
	public void verify_the_values_in_Create_Data_Bundle_Page_for_Billing_Service() throws Throwable {
	    
		bsdatabundle.verifyAllValuesinCreateBundlePage();
	}
	
	@When("^Verify Error Message upon clicking Submit Button without selecting any Fields for Billing Service$")
	public void verify_Error_Message_upon_clicking_Submit_Button_without_selecting_any_Fields_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyErrorWithoutSubmiitingAnyField();
	    
	}

	@When("^Verify Error Message when Settlement Date is not Selected for Billing Service$")
	public void verify_Error_Message_when_Settlement_Date_is_not_Selected_for_Billing_Service() throws Throwable {
	    
		bsdatabundle.verifyErrorWithoutSettlementDates();
	}

	@When("^Verify Error Message when File Types is not Selected for Billing Service$")
	public void verify_Error_Message_when_File_Types_is_not_Selected_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyErrorWithoutFileType();
	    
	}

	@When("^Verify Error Message when Settlement Date range is selected for more than (\\d+) Days Between From and To Date for Billing Service$")
	public void verify_Error_Message_when_Settlement_Date_range_is_selected_for_more_than_Days_Between_From_and_To_Date_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verifyErrorForMore30days();
	    
	}

	@Then("^Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for Billing Service$")
	public void verify_Error_Message_when_Settlement_Date_selected_To_From_Dates_prior_to_or_same_as_Current_date_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyErrorForPriorDates();
	    
	}

	@When("^User Enter Settlement Date in TO and From Date Range for Billing Service$")
	public void user_Enter_Settlement_Date_in_TO_and_From_Date_Range_for_Billing_Service() throws Throwable {
		bsdatabundle.enterPaymentDate();
	}

	@When("^User verifies All the Three File Type Options for Billing Service$")
	public void user_verifies_All_the_Three_File_Type_Options_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyAllFilesTypes();
	}

	@Then("^User selects File Type Option as (\\d+) and Submit Payment Data Bundle Request for Billing Service$")
	public void user_selects_File_Type_Option_as_and_Submit_Payment_Data_Bundle_Request_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verifySubmiteight35DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for (\\d+) File Type for Billing Service$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_File_Type_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.eight35filetype();
	}
	
	@Then("^User verifies the (\\d+) indicator in Database entry for Billing Service$")
	public void user_verifies_the_indicator_in_Database_entry_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verify835Ind();
	}
	@Then("^User selects File Type Option as EPRA and Submit Payment Data Bundle Request for Billing Service$")
	public void user_selects_File_Type_Option_as_EPRA_and_Submit_Payment_Data_Bundle_Request_for_Billing_Service() throws Throwable {
		bsdatabundle.verifySubmitEPRAsDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type for Billing Service$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_File_Type_for_Billing_Service() throws Throwable {
		bsdatabundle.eprafiletype();
	}

	@Then("^User verifies the EPRA indicator in Database entry for Billing Service$")
	public void user_verifies_the_EPRA_indicator_in_Database_entry_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyEPRAInd();
	}

	@Then("^User selects File Type Option as PPRA and Submit Payment Data Bundle Request for Billing Service$")
	public void user_selects_File_Type_Option_as_PPRA_and_Submit_Payment_Data_Bundle_Request_for_Billing_Service() throws Throwable {
		bsdatabundle.verifySubmitPPRAsDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type for Billing Service$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_File_Type_for_Billing_Service() throws Throwable {
		bsdatabundle.pprafiletype();
	}

	@Then("^User verifies the PPRA indicator in Database entry for Billing Service$")
	public void user_verifies_the_PPRA_indicator_in_Database_entry_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyPPRAInd();
	}
	
	@Then("^User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request for Billing Service$")
	public void user_selects_File_Type_Option_as_EPRA_and_PPRA_and_Submit_Payment_Data_Bundle_Request_for_Billing_Service() throws Throwable {
		bsdatabundle.verifySubmiteprapraDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type for Billing Service$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_PPRA_File_Type_for_Billing_Service() throws Throwable {
		bsdatabundle.epranpprafiletype();
	    
	}

	@Then("^User verifies the EPRA and PPRA indicator in Database entry for Billing Service$")
	public void user_verifies_the_EPRA_and_PPRA_indicator_in_Database_entry_for_Billing_Service() throws Throwable {
	    
		bsdatabundle.verifyEPRAnPPRAInd();
	}

	@Then("^User selects File Type Option as EPRA and (\\d+) and Submit Payment Data Bundle Request for Billing Service$")
	public void user_selects_File_Type_Option_as_EPRA_and_and_Submit_Payment_Data_Bundle_Request_for_Billing_Service(int arg1) throws Throwable {
	    
		bsdatabundle.verifySubmitepra835DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and (\\d+) File Type for Billing Service$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_File_Type_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.epran835filetype();
	}

	@Then("^User verifies the EPRA and (\\d+) indicator in Database entry for Billing Service$")
	public void user_verifies_the_EPRA_and_indicator_in_Database_entry_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verifyEPRAn835Ind();
	}
	
	@Then("^User selects File Type Option as PPRA and (\\d+) and Submit Payment Data Bundle Request for Billing Service$")
	public void user_selects_File_Type_Option_as_PPRA_and_and_Submit_Payment_Data_Bundle_Request_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verifySubmitppra835DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and (\\d+) File Type for Billing Service$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_and_File_Type_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.ppran835filetype();
	}

	@Then("^User verifies the PPRA and (\\d+) indicator in Database entry for Billing Service$")
	public void user_verifies_the_PPRA_and_indicator_in_Database_entry_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verifyPPRAn835Ind();
	}

	@Then("^User selects File Type Option as EPRA PPRA and (\\d+) and Submit Payment Data Bundle Request for Billing Service$")
	public void user_selects_File_Type_Option_as_EPRA_PPRA_and_and_Submit_Payment_Data_Bundle_Request_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verifySubmitAlltypeDataBundle();  
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and (\\d+) File Type for Billing Service$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_PPRA_and_File_Type_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.epran835npprafiletype();
	}

	@Then("^User verifies the EPRA, PPRA and (\\d+) indicator in Database entry for Billing Service$")
	public void user_verifies_the_EPRA_PPRA_and_indicator_in_Database_entry_for_Billing_Service(int arg1) throws Throwable {
		bsdatabundle.verifyEPRAn835nPPRAInd();
	}

	@When("^User Verify Payer Name List in Payer Selection Grid for Billing Service$")
	public void user_Verify_Payer_Name_List_in_Payer_Selection_Grid_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyPayerList();
	}

	@When("^User Verify All the PageButtons Available: Add, Add All, Remove, Remove All for Billing Service$")
	public void user_Verify_All_the_PageButtons_Available_Add_Add_All_Remove_Remove_All_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyButtonsList();
	}

	@When("^Verify User is able to access Add Button Functionality for Billing Service$")
	public void verify_User_is_able_to_access_Add_Button_Functionality_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyAddButton();
	}

	@When("^Verify User is able to access Remove Button Functionality for Billing Service$")
	public void verify_User_is_able_to_access_Remove_Button_Functionality_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyRemoveButton();
	}

	@Then("^Verify User is able to access Add All Button Functioanlity for Billing Service$")
	public void verify_User_is_able_to_access_Add_All_Button_Functioanlity_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyAddAllButton();
	}

	@Then("^Verify User is able to access Remove All Button Functionality for Billing Service$")
	public void verify_User_is_able_to_access_Remove_All_Button_Functionality_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyRemoveAllButton(); 
	}

	@Then("^Verify User is able to access Reset Functionality for Billing Service$")
	public void verify_User_is_able_to_access_Reset_Functionality_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyResetButton();
	}

	@Then("^Verify Error Message when No Payer is Selected for Billing Service$")
	public void verify_Error_Message_when_No_Payer_is_Selected_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyErrorForPayerSelection();
	}

	@When("^User selects All Payers from the Payer List for Billing Service$")
	public void user_selects_All_Payers_from_the_Payer_List_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyPayerSelection();
	}

	@When("^User verifies the Data Bundle Request Completed in Last (\\d+) Days for Billing Service User$")
	public void user_verifies_the_Data_Bundle_Request_Completed_in_Last_Days_for_Billing_Service_User(int arg1) throws Throwable {
		bsdatabundle.getCompletedIN();
	}

	@When("^User Click on Download Data Bundle Tab on UI for Billing Service$")
	public void user_Click_on_Download_Data_Bundle_Tab_on_UI_for_Billing_Service() throws Throwable {
		bsdatabundle.downloadbundlePage();
	}

	@Then("^User validates the completed File Name in the Grid for Billing Service$")
	public void user_validates_the_completed_File_Name_in_the_Grid_for_Billing_Service() throws Throwable {
		bsdatabundle.verifyZipFileName();
	}

}
