package main.java.stepDefinitions.PaymentDataFiles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.PaymentDataFilesUPA;
import main.java.pageObjects.PaymentDataFilesCSR;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;

public class PaymentDataFilesUPASteps {
	
	TestBase testConfig = TestBase.getInstance();
	PaymentDataFilesUPA paymentDataFilesUPA = new PaymentDataFilesUPA(testConfig);


	@When("^Verify User navigates to Create Data Bundle Page on UI$")
	public void verify_User_navigates_to_Create_Data_Bundle_Page_on_UI() throws Throwable {	    
		paymentDataFilesUPA.verifyCreateDataBundlePage();
	}

	@Then("^Verify the values in Create Data Bundle Page for \"([^\"]*)\"$")
	public void verify_the_values_in_Create_Data_Bundle_Page_for(String userType) throws Throwable {
		paymentDataFilesUPA.verifyAllValuesinCreateBundlePage(userType);
	}

	@Then("^Verify Error Message upon clicking Submit Button without selecting any Fields for \"([^\"]*)\"$")
	public void verify_Error_Message_upon_clicking_Submit_Button_without_selecting_any_Fields_for(String userType) throws Throwable {
		paymentDataFilesUPA.verifyErrorWithoutSubmiitingAnyField(userType);
	}

	@Then("^Verify Error Message when Settlement Date is not Selected for \"([^\"]*)\"$")
	public void verify_Error_Message_when_Settlement_Date_is_not_Selected_for(String userType) throws Throwable {
		paymentDataFilesUPA.verifyErrorWithoutSettlementDates(userType);
	}
	@Then("^Verify Error Message when File Types is not Selected for \"([^\"]*)\"$")
	public void verify_Error_Message_when_File_Types_is_not_Selected_for(String userType) throws Throwable {
		paymentDataFilesUPA.verifyErrorWithoutFileType(userType);
	}

	@Then("^Verify Error Message when Settlement Date range is selected for more than (\\d+) Days Between From and To Date for \"([^\"]*)\"$")
	public void verify_Error_Message_when_Settlement_Date_range_is_selected_for_more_than_Days_Between_From_and_To_Date_for(int arg1, String userType) throws Throwable {
		paymentDataFilesUPA.verifyErrorForMore30days(userType);
	}

	@Then("^Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for \"([^\"]*)\"$")
	public void verify_Error_Message_when_Settlement_Date_selected_To_From_Dates_prior_to_or_same_as_Current_date_for(String userType) throws Throwable {
		paymentDataFilesUPA.verifyErrorForPriorDates(userType);
	}

	@When("^User Enter Settlement Date in TO and From Date Range$")
	public void user_Enter_Settlement_Date_in_TO_and_From_Date_Range() throws Throwable {
		paymentDataFilesUPA.enterPaymentDate();
	}

	@When("^User verifies All the Three File Type Options$")
	public void user_verifies_All_the_Three_File_Type_Options() throws Throwable {
		paymentDataFilesUPA.verifyAllFilesTypes();
	}

	@Then("^User selects File Type Option as (\\d+) and Submit Payment Data Bundle Request$")
	public void user_selects_File_Type_Option_as_and_Submit_Payment_Data_Bundle_Request(int arg1) throws Throwable {
		paymentDataFilesUPA.verifySubmit835DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for (\\d+) File Type$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_File_Type(int arg1) throws Throwable {
		paymentDataFilesUPA.eight35FileType();
	}
	
	@Then("^User verifies the (\\d+) indicator in Database entry$")
	public void user_verifies_the_indicator_in_Database_entry_for(int arg1) throws Throwable {
		paymentDataFilesUPA.verify835Ind();
	}
	@Then("^User selects File Type Option as EPRA and Submit Payment Data Bundle Request$")
	public void user_selects_File_Type_Option_as_EPRA_and_Submit_Payment_Data_Bundle_Request() throws Throwable {
		paymentDataFilesUPA.verifySubmitEPRAsDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_File_Type() throws Throwable {
		paymentDataFilesUPA.EPRAFileType();
	}

	@Then("^User verifies the EPRA indicator in Database entry$")
	public void user_verifies_the_EPRA_indicator_in_Database_entry() throws Throwable {
		paymentDataFilesUPA.verifyEPRAInd();
	}

	@Then("^User selects File Type Option as PPRA and Submit Payment Data Bundle Request$")
	public void user_selects_File_Type_Option_as_PPRA_and_Submit_Payment_Data_Bundle_Request() throws Throwable {
		paymentDataFilesUPA.verifySubmitPPRAsDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_File_Type() throws Throwable {
		paymentDataFilesUPA.PPRAFileType();
	}

	@Then("^User verifies the PPRA indicator in Database entry$")
	public void user_verifies_the_PPRA_indicator_in_Database_entry() throws Throwable {
		paymentDataFilesUPA.verifyPPRAInd();
	}
	
	@Then("^User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request$")
	public void user_selects_File_Type_Option_as_EPRA_and_PPRA_and_Submit_Payment_Data_Bundle_Request() throws Throwable {
		paymentDataFilesUPA.verifySubmitEPRAnPPRADataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_PPRA_File_Type() throws Throwable {
		paymentDataFilesUPA.EPRAnPPRAFileType();
	    
	}

	@Then("^User verifies the EPRA and PPRA indicator in Database entry$")
	public void user_verifies_the_EPRA_and_PPRA_indicator_in_Database_entry() throws Throwable {
	    
		paymentDataFilesUPA.verifyEPRAnPPRAInd();
	}

	@Then("^User selects File Type Option as EPRA and (\\d+) and Submit Payment Data Bundle Request$")
	public void user_selects_File_Type_Option_as_EPRA_and_and_Submit_Payment_Data_Bundle_Request(int arg1) throws Throwable {
	    
		paymentDataFilesUPA.verifySubmitEPRAn835DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and (\\d+) File Type$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_File_Type(int arg1) throws Throwable {
		paymentDataFilesUPA.EPRAn835FileType();
	}

	@Then("^User verifies the EPRA and (\\d+) indicator in Database entry$")
	public void user_verifies_the_EPRA_and_indicator_in_Database_entry(int arg1) throws Throwable {
		paymentDataFilesUPA.verifyEPRAn835Ind();
	}
	
	@Then("^User selects File Type Option as PPRA and (\\d+) and Submit Payment Data Bundle Request$")
	public void user_selects_File_Type_Option_as_PPRA_and_and_Submit_Payment_Data_Bundle_Request(int arg1) throws Throwable {
		paymentDataFilesUPA.verifySubmitPPRA835DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and (\\d+) File Type$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_and_File_Type(int arg1) throws Throwable {
		paymentDataFilesUPA.PPRAn835FileType();
	}

	@Then("^User verifies the PPRA and (\\d+) indicator in Database entry$")
	public void user_verifies_the_PPRA_and_indicator_in_Database_entry(int arg1) throws Throwable {
		paymentDataFilesUPA.verifyPPRAn835Ind();
	}

	@Then("^User selects File Type Option as EPRA PPRA and (\\d+) and Submit Payment Data Bundle Request$")
	public void user_selects_File_Type_Option_as_EPRA_PPRA_and_and_Submit_Payment_Data_Bundle_Request(int arg1) throws Throwable {
		paymentDataFilesUPA.verifySubmitAlltypeDataBundle();  
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and (\\d+) File Type$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_PPRA_and_File_Type(int arg1) throws Throwable {
		paymentDataFilesUPA.EPRAn835nPPRAFileType();
	}

	@Then("^User verifies the EPRA, PPRA and (\\d+) indicator in Database entry$")
	public void user_verifies_the_EPRA_PPRA_and_indicator_in_Database_entry(int arg1) throws Throwable {
		paymentDataFilesUPA.verifyEPRAn835nPPRAInd();
	}


	@Then("^User Verify Payer Name List in Payer Selection Grid for \"([^\"]*)\"$")
	public void user_Verify_Payer_Name_List_in_Payer_Selection_Grid_for(String userType) throws Throwable {
		if(userType.equalsIgnoreCase("PROV") || userType.equalsIgnoreCase("BS") ) 
			paymentDataFilesUPA.verifyPayerList(userType);
		
	}

	@When("^User Verify All the PageButtons Available: Add, Add All, Remove, Remove All$")
	public void user_Verify_All_the_PageButtons_Available_Add_Add_All_Remove_Remove_All() throws Throwable {
		paymentDataFilesUPA.verifyButtonsList();
	}

	@When("^Verify User is able to access Add Button Functionality$")
	public void verify_User_is_able_to_access_Add_Button_Functionality() throws Throwable {
		paymentDataFilesUPA.verifyAddButton();
	}

	@When("^Verify User is able to access Remove Button Functionality$")
	public void verify_User_is_able_to_access_Remove_Button_Functionality() throws Throwable {
		paymentDataFilesUPA.verifyRemoveButton();
	}

	@Then("^Verify User is able to access Add All Button Functioanlity$")
	public void verify_User_is_able_to_access_Add_All_Button_Functioanlity() throws Throwable {
		paymentDataFilesUPA.verifyAddAllButton();
	}

	@Then("^Verify User is able to access Remove All Button Functionality$")
	public void verify_User_is_able_to_access_Remove_All_Button_Functionality() throws Throwable {
		paymentDataFilesUPA.verifyRemoveAllButton(); 
	}

	@Then("^Verify User is able to access Reset Functionality$")
	public void verify_User_is_able_to_access_Reset_Functionality() throws Throwable {
		paymentDataFilesUPA.verifyResetButton();
	}

	@Then("^Verify Error Message when No Payer is Selected for \"([^\"]*)\"$")
	public void verify_Error_Message_when_No_Payer_is_Selected_for(String userType) throws Throwable {
		if(!userType.equalsIgnoreCase("Payer"))
		paymentDataFilesUPA.verifyErrorForPayerSelection();
	}

	@Then("^User selects All Payers from the Payer List for \"([^\"]*)\"$")
	public void user_selects_All_Payers_from_the_Payer_List_for(String userType) throws Throwable {
		paymentDataFilesUPA.verifyPayerSelection(userType);
	}
	@When("^User verifies the Data Bundle Request Completed in Last (\\d+) Days$")
	public void user_verifies_the_Data_Bundle_Request_Completed_in_Last_Days(int arg1) throws Throwable {
		paymentDataFilesUPA.getCompletedIN();
	}

	@When("^User Click on Download Data Bundle Tab on UI$")
	public void user_Click_on_Download_Data_Bundle_Tab_on_UI() throws Throwable {
		paymentDataFilesUPA.downloadBundlePage();
	}

	@Then("^User validates the completed File Name in the Grid$")
	public void user_validates_the_completed_File_Name_in_the_Grid() throws Throwable {
		paymentDataFilesUPA.verifyZipFileName();
	}

	@When("^User verifies the Maximize your efficiency pop up for standard tin$")
	public void user_verifies_the_Maximize_your_efficiency_pop_up_for_standard_tin() throws Throwable {
		paymentDataFilesUPA.verifyPopUp();
	}

}
