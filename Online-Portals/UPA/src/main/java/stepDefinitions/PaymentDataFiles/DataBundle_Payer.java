package main.java.stepDefinitions.PaymentDataFiles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.PaymentDataFiles_Payer;
import main.java.pageObjects.Payment_DataFiles_Page;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;

public class DataBundle_Payer {
	
	TestBase testConfig = TestBase.getInstance();
	PaymentDataFiles_Payer payerdatabundle = new PaymentDataFiles_Payer(testConfig);
	//PaymentDataFiles_UPA provdatabundle = new PaymentDataFiles_UPA(testConfig);
	//Payment_DataFiles_Page clickDataBundle = new Payment_DataFiles_Page(testConfig);
	
	@Given("^User navigates to UPA portal and enters \"([^\"]*)\" to login as Payer$")
	public void user_navigates_to_UPA_portal_and_enters_to_login_as_Payer(String userType) throws Throwable {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig); 
        LoginUPA loginPage=new LoginUPA(testConfig);
		UPAHomePage upaHome=loginPage.doLoginUPA(userType);   
	    
	}

	@When("^User clicks on Data Bundle Tab for Payer$")
	public void user_clicks_on_Data_Bundle_Tab_for_Payer() throws Throwable {
		payerdatabundle.clickPaymentDataFilesTab();
	    
	}

	@When("^User enters Provider tin for UPA \"([^\"]*)\"$")
	public void user_enters_Provider_tin_for_UPA(String srchCriteria) throws Throwable {
	    
		payerdatabundle.enterTin(srchCriteria);
	}

	@When("^Verify User navigates to Create Data Bundle Page on UI for Payer$")
	public void verify_User_navigates_to_Create_Data_Bundle_Page_on_UI_for_Payer() throws Throwable {
	    
		payerdatabundle.verifyCreateDataBundlePage();
	}

	@Then("^Verify the values in Create Data Bundle Page for Payer$")
	public void verify_the_values_in_Create_Data_Bundle_Page_for_Payer() throws Throwable {
	    
		payerdatabundle.verifyAllValuesinCreateBundlePage();
	}
	
	@When("^Verify Error Message upon clicking Submit Button without selecting any Fields for Payer$")
	public void verify_Error_Message_upon_clicking_Submit_Button_without_selecting_any_Fields_for_Payer() throws Throwable {
		payerdatabundle.verifyErrorWithoutSubmiitingAnyField();
	    
	}

	@When("^Verify Error Message when Settlement Date is not Selected for Payer$")
	public void verify_Error_Message_when_Settlement_Date_is_not_Selected_for_Payer() throws Throwable {
	    
		payerdatabundle.verifyErrorWithoutSettlementDates();
	}

	@When("^Verify Error Message when File Types is not Selected for Payer$")
	public void verify_Error_Message_when_File_Types_is_not_Selected_for_Payer() throws Throwable {
		payerdatabundle.verifyErrorWithoutFileType();
	    
	}

	@When("^Verify Error Message when Settlement Date range is selected for more than (\\d+) Days Between From and To Date for Payer$")
	public void verify_Error_Message_when_Settlement_Date_range_is_selected_for_more_than_Days_Between_From_and_To_Date_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verifyErrorForMore30days();
	    
	}

	@Then("^Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for Payer$")
	public void verify_Error_Message_when_Settlement_Date_selected_To_From_Dates_prior_to_or_same_as_Current_date_for_Payer() throws Throwable {
		payerdatabundle.verifyErrorForPriorDates();
	    
	}

	@When("^User Enter Settlement Date in TO and From Date Range for Payer$")
	public void user_Enter_Settlement_Date_in_TO_and_From_Date_Range_for_Payer() throws Throwable {
		payerdatabundle.enterPaymentDate();
	}

	@When("^User verifies All the Three File Type Options for Payer$")
	public void user_verifies_All_the_Three_File_Type_Options_for_Payer() throws Throwable {
		payerdatabundle.verifyAllFilesTypes();
	}

	@Then("^User selects File Type Option as (\\d+) and Submit Payment Data Bundle Request for Payer$")
	public void user_selects_File_Type_Option_as_and_Submit_Payment_Data_Bundle_Request_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verifySubmiteight35DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for (\\d+) File Type for Payer$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_File_Type_for_Payer(int arg1) throws Throwable {
		payerdatabundle.eight35filetype();
	}
	
	@Then("^User verifies the (\\d+) indicator in Database entry for Payer$")
	public void user_verifies_the_indicator_in_Database_entry_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verify835Ind();
	}
	@Then("^User selects File Type Option as EPRA and Submit Payment Data Bundle Request for Payer$")
	public void user_selects_File_Type_Option_as_EPRA_and_Submit_Payment_Data_Bundle_Request_for_Payer() throws Throwable {
		payerdatabundle.verifySubmitEPRAsDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type for Payer$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_File_Type_for_Payer() throws Throwable {
		payerdatabundle.eprafiletype();
	}

	@Then("^User verifies the EPRA indicator in Database entry for Payer$")
	public void user_verifies_the_EPRA_indicator_in_Database_entry_for_Payer() throws Throwable {
		payerdatabundle.verifyEPRAInd();
	}

	@Then("^User selects File Type Option as PPRA and Submit Payment Data Bundle Request for Payer$")
	public void user_selects_File_Type_Option_as_PPRA_and_Submit_Payment_Data_Bundle_Request_for_Payer() throws Throwable {
		payerdatabundle.verifySubmitPPRAsDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type for Payer$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_File_Type_for_Payer() throws Throwable {
		payerdatabundle.pprafiletype();
	}

	@Then("^User verifies the PPRA indicator in Database entry for Payer$")
	public void user_verifies_the_PPRA_indicator_in_Database_entry_for_Payer() throws Throwable {
		payerdatabundle.verifyPPRAInd();
	}
	
	@Then("^User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request for Payer$")
	public void user_selects_File_Type_Option_as_EPRA_and_PPRA_and_Submit_Payment_Data_Bundle_Request_for_Payer() throws Throwable {
		payerdatabundle.verifySubmiteprapraDataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type for Payer$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_PPRA_File_Type_for_Payer() throws Throwable {
		payerdatabundle.epranpprafiletype();
	    
	}

	@Then("^User verifies the EPRA and PPRA indicator in Database entry for Payer$")
	public void user_verifies_the_EPRA_and_PPRA_indicator_in_Database_entry_for_Payer() throws Throwable {
	    
		payerdatabundle.verifyEPRAnPPRAInd();
	}

	@Then("^User selects File Type Option as EPRA and (\\d+) and Submit Payment Data Bundle Request for Payer$")
	public void user_selects_File_Type_Option_as_EPRA_and_and_Submit_Payment_Data_Bundle_Request_for_Payer(int arg1) throws Throwable {
	    
		payerdatabundle.verifySubmitepra835DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and (\\d+) File Type for Payer$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_and_File_Type_for_Payer(int arg1) throws Throwable {
		payerdatabundle.epran835filetype();
	}

	@Then("^User verifies the EPRA and (\\d+) indicator in Database entry for Payer$")
	public void user_verifies_the_EPRA_and_indicator_in_Database_entry_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verifyEPRAn835Ind();
	}
	
	@Then("^User selects File Type Option as PPRA and (\\d+) and Submit Payment Data Bundle Request for Payer$")
	public void user_selects_File_Type_Option_as_PPRA_and_and_Submit_Payment_Data_Bundle_Request_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verifySubmitppra835DataBundle();
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and (\\d+) File Type for Payer$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_PPRA_and_File_Type_for_Payer(int arg1) throws Throwable {
		payerdatabundle.ppran835filetype();
	}

	@Then("^User verifies the PPRA and (\\d+) indicator in Database entry for Payer$")
	public void user_verifies_the_PPRA_and_indicator_in_Database_entry_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verifyPPRAn835Ind();
	}

	@Then("^User selects File Type Option as EPRA PPRA and (\\d+) and Submit Payment Data Bundle Request for Payer$")
	public void user_selects_File_Type_Option_as_EPRA_PPRA_and_and_Submit_Payment_Data_Bundle_Request_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verifySubmitAlltypeDataBundle();  
	}

	@Then("^User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and (\\d+) File Type for Payer$")
	public void user_Verifies_Data_Bundle_Request_entry_in_Download_Data_Bundle_Page_for_EPRA_PPRA_and_File_Type_for_Payer(int arg1) throws Throwable {
		payerdatabundle.epran835npprafiletype();
	}

	@Then("^User verifies the EPRA, PPRA and (\\d+) indicator in Database entry for Payer$")
	public void user_verifies_the_EPRA_PPRA_and_indicator_in_Database_entry_for_Payer(int arg1) throws Throwable {
		payerdatabundle.verifyEPRAn835nPPRAInd();
	}

	@When("^User verifies EPRA and PPRA Options Disabled for Payer$")
	public void user_verifies_EPRA_and_PPRA_Options_Disabled_for_Payer() throws Throwable {
	    payerdatabundle.verifyRallyFilesTypes();
	}
}
