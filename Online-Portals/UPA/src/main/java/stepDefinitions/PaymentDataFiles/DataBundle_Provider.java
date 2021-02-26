package main.java.stepDefinitions.PaymentDataFiles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.PaymentDataFiles_UPA;
import main.java.pageObjects.Payment_DataFiles_Page;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;

public class DataBundle_Provider {

	TestBase testConfig = TestBase.getInstance();
	PaymentDataFiles_UPA provdatabundle = new PaymentDataFiles_UPA(testConfig);
	
	@Given("^User navigates to UPA portal and enters \"([^\"]*)\" to login as Provider$")
	public void user_navigates_to_UPA_portal_and_enters_and_login(String userType) throws Throwable 
	{
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig); 
        LoginUPA loginPage=new LoginUPA(testConfig);
        UPAHomePage upaHome=loginPage.doLoginUPA(userType);   
	}

	@Given("^User selects tin for UPA \"([^\"]*)\"$")
    public void user_enters_tin_for_UPA(String srchCriteria) throws Throwable 
	{
		provdatabundle.selectTin(srchCriteria);
    }
	
	@When("^User clicks on Data Bundle Tab for Provider$")
	public void user_clicks_on_Data_Bundle_Tab() throws Throwable 
	{
		provdatabundle.clickPaymentDataFilesTab();
	}

	@When("^Verify User navigates to Create Data Bundle Page on UI for Provider$")
	public void verify_User_navigates_Create_Data_Bundlec() throws Throwable {
	    
		provdatabundle.verifyCreateDataBundlePage();
	}

	@Then("^Verify the values in Create Data Bundle Page for Provider$")
	public void verify_the_values_in_Create_Data_Bundle_Page() throws Throwable {
	    
		provdatabundle.verifyAllValuesinCreateBundlePage();
	}

	@When("^User Verify Payer Name List in Payer Selection Grid for Provider$")
	public void user_Verify_Payer_Name_List_in_Payer_Selection_Grid() throws Throwable {
		provdatabundle.verifyPayerList();
	    
	}

	@When("^User Verify All the PageButtons Available: Add, Add All, Remove, Remove All for Provider$")
	public void user_Verify_All_the_Buttons_Available_Add_Add_All_Remove_Remove_All() throws Throwable {
		provdatabundle.verifyButtonsList();
	    
	}

	@When("^Verify User is able to access Add Button Functionality for Provider$")
	public void verify_User_is_able_to_access_Add_Button_Functionality() throws Throwable {
	    
		provdatabundle.verifyAddButton();
	}

	@When("^Verify User is able to access Remove Button Functionality for Provider$")
	public void verify_User_is_able_to_access_Remove_Button_Functionality() throws Throwable {
	    
		provdatabundle.verifyRemoveButton();
	}

	@Then("^Verify User is able to access Add All Button Functioanlity for Provider$")
	public void verify_User_is_able_to_access_Add_All_Button_Functioanlity() throws Throwable {
	    
		provdatabundle.verifyAddAllButton();
	}

	@Then("^Verify User is able to access Remove All Button Functionality for Provider$")
	public void verify_User_is_able_to_access_Remove_All_Button_Functionality() throws Throwable {
	    
		provdatabundle.verifyRemoveAllButton(); 
	}

	@Then("^Verify User is able to access Reset Functionality for Provider$")
	public void verify_User_is_able_to_access_Reset_Functionality() throws Throwable {
	    
		provdatabundle.verifyResetButton();
	}

	@When("^Verify Error Message upon clicking Submit Button without selecting any Fields for Provider$")
	public void verify_Error_Message_upon_clicking_Submit_Button_without_selecting_any_Fields() throws Throwable {
	    
		provdatabundle.verifyErrorWithoutSubmiitingAnyField();
	}

	@When("^Verify Error Message when Settlement Date is not Selected for Provider$")
	public void verify_Error_Message_when_Settlement_Date_is_not_Selected() throws Throwable {
	    
		provdatabundle.verifyErrorWithoutSettlementDates();
	}

	@When("^Verify Error Message when File Types is not Selected for Provider$")
	public void verify_Error_Message_when_File_Types_is_not_Selected() throws Throwable {
	    
		provdatabundle.verifyErrorWithoutFileType();
	}

	@When("^Verify Error Message when Settlement Date range is selected for more than (\\d+) Days Between From and To Date for Provider$")
	public void verify_Error_Message_when_Settlement_Date_range_is_selected_for_more_than_Days_Between_From_and_To_Date(int arg1) throws Throwable {
		provdatabundle.verifyErrorForMore30days();
	    
	}

	@Then("^Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for Provider$")
	public void verify_Error_Message_when_Settlement_Date_selected_To_From_Dates_prior_to_or_same_as_Current_date() throws Throwable {
	    
		provdatabundle.verifyErrorForPriorDates();
	}

	@Then("^Verify Error Message when No Payer is Selected for Provider$")
	public void verify_Error_Message_when_No_Payer_is_Selected() throws Throwable {
	    
		provdatabundle.verifyErrorForPayerSelection();
	}

	@When("^User selects All Payers from the Payer List for Provider$")
	public void user_selects_All_Payers_from_the_Payer_List() throws Throwable {
		provdatabundle.verifyPayerSelection();
	}

	@When("^User Enter Settlement Date in TO and From Date Range for Provider$")
	public void user_Enter_Settlement_Date_in_TO_and_From_Date_Range() throws Throwable {
		provdatabundle.enterPaymentDate();
	    
	}

	@When("^User verifies All the Three File Type Options for Provider$")
	public void user_verifies_All_the_Three_File_Type_Options() throws Throwable {
	    
		provdatabundle.verifyAllFilesTypes();
	}

	@Then("^User selects File Type Option as EPRA and Submit Payment Data Bundle Request for Provider$")
	public void user_selects_File_Type_Option_as_EPRA_and_Submit_File_Data_Bundle() throws Throwable {
		provdatabundle.verifySubmitEPRAsDataBundle();
	    
	}
	
	@Then("^User selects File Type Option as PPRA and Submit Payment Data Bundle Request for Provider$")
	public void user_selects_File_Type_Option_as_PPRA_and_Submit_File_Data_Bundle() throws Throwable {
		provdatabundle.verifySubmitPPRAsDataBundle();
	    
	}

	@Then("^User selects File Type Option as (\\d+) and Submit Payment Data Bundle Request for Provider$")
	public void user_selects_File_Type_Option_as_and_Submit_File_Data_Bundle(int arg1) throws Throwable {
		provdatabundle.verifySubmiteight35DataBundle();
	    
	}

	@Then("^User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request for Provider$")
	public void user_selects_File_Type_Option_as_EPRA_and_PPRA_and_Submit_File_Data_Bundle() throws Throwable {
	    
		provdatabundle.verifySubmiteprapraDataBundle();
	}

	@Then("^User selects File Type Option as EPRA and (\\d+) and Submit Payment Data Bundle Request for Provider$")
	public void user_selects_File_Type_Option_as_EPRA_and_and_Submit_File_Data_Bundle(int arg1) throws Throwable {
		provdatabundle.verifySubmitepra835DataBundle();
	    
	}

	@Then("^User selects File Type Option as PPRA and (\\d+) and Submit Payment Data Bundle Request for Provider$")
	public void user_selects_File_Type_Option_as_PPRA_and_and_Submit_File_Data_Bundle(int arg1) throws Throwable {
	    
		provdatabundle.verifySubmitppra835DataBundle();
	}

	@Then("^User selects File Type Option as EPRA PPRA and (\\d+) and Submit Payment Data Bundle Request for Provider$")
	public void user_selects_File_Type_Option_as_EPRA_PPRA_and_and_Submit_File_Data_Bundle(int arg1) throws Throwable {
	    
		provdatabundle.verifySubmitAlltypeDataBundle();   
	}

	@When("^User Selects RallyPay Payer from the Payer List for Provider$")
	public void user_Selects_RallyPay_Payer_from_the_Payer_List() throws Throwable {
	    
	    
	}

	@When("^User verifies the Data Bundle Request Completed in Last 7 Days for the Provider User$")
	public void user_selects_the_TIN_of_completed_Data_Bundle_Requests_from_the_TIN_drop_down() throws Throwable {
	    
	    provdatabundle.getCompletedIN();
	    
	}

	@When("^User Click on Download Data Bundle Tab on UI for Provider$")
	public void user_Click_on_Download_Data_Bundle_Tab_on_UI() throws Throwable {
	    
		provdatabundle.downloadbundlePage();
	}

	@Then("^User validates the completed File Name in the Grid for Provider$")
	public void user_validates_the_completed_File_Name_in_the_Grid() throws Throwable {
	    
		provdatabundle.verifyZipFileName();
	}

	//Need to be looked into
	@Then("^User verifies the EPRA indicator of Provider Request in Database entry for Provider$")
	public void user_verifies_the_EPRA_indicator_in_Database_entry() throws Throwable {
	    
		provdatabundle.verifyEPRAInd();
	}
	
	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type for Provider$")
	public void user_verifies_data_reques_entry_in_download_data_bundle_pageforEPRA() throws Throwable {
		provdatabundle.eprafiletype();
	}
	
	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type for Provider$")
	public void user_verifies_data_reques_entry_in_download_data_bundle_pageforPPRA() throws Throwable {
		provdatabundle.pprafiletype();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for (\\d+) File Type for Provider$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_File_Type(int arg1) throws Throwable {
		provdatabundle.eight35filetype();
	}
	
	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type for Provider$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_PPRA_File_Type() throws Throwable {
		provdatabundle.epranpprafiletype();
	}
	
	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and (\\d+) File Type for Provider$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_File_Type(int arg1) throws Throwable {
		provdatabundle.epran835filetype();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and (\\d+) File Type for Provider$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_and_File_Type(int arg1) throws Throwable {
		provdatabundle.ppran835filetype();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and (\\d+) File Type for Provider$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_PPRA_and_File_Type(int arg1) throws Throwable {
		provdatabundle.epran835npprafiletype();
	}
	@Then("^User verifies the EPRA indicator in Database entry for Provider$")
	public void user_verifies_the_EPRA_indicator_in_Database_entry_for_Provider() throws Throwable {
		provdatabundle.verifyEPRAInd();   
	}

	@Then("^User verifies the PPRA indicator in Database entry for Provider$")
	public void user_verifies_the_PPRA_indicator_in_Database_entry_for_Provider() throws Throwable {
		provdatabundle.verifyPPRAInd();
	}

	@Then("^User verifies the (\\d+) indicator in Database entry for Provider$")
	public void user_verifies_the_indicator_in_Database_entry_for_Provider(int arg1) throws Throwable {
		provdatabundle.verify835Ind();
	}

	@Then("^User verifies the EPRA and PPRA indicator in Database entry for Provider$")
	public void user_verifies_the_EPRA_and_PPRA_indicator_in_Database_entry_for_Provider() throws Throwable {
		provdatabundle.verifyEPRAnPPRAInd();
	}

	@Then("^User verifies the EPRA and (\\d+) indicator in Database entry for Provider$")
	public void user_verifies_the_EPRA_and_indicator_in_Database_entry_for_Provider(int arg1) throws Throwable {
		provdatabundle.verifyEPRAn835Ind();
	}

	@Then("^User verifies the PPRA and (\\d+) indicator in Database entry for Provider$")
	public void user_verifies_the_PPRA_and_indicator_in_Database_entry_for_Provider(int arg1) throws Throwable {
		provdatabundle.verifyPPRAn835Ind();
	}

	@Then("^User verifies the EPRA, PPRA and (\\d+) indicator in Database entry for Provider$")
	public void user_verifies_the_EPRA_PPRA_and_indicator_in_Database_entry_for_Provider(int arg1) throws Throwable {
		provdatabundle.verifyEPRAn835nPPRAInd();
	}
	
}
