package main.java.stepDefinitions.PaymentDataFiles;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchTinPagePaymentDataFiles;

public class SearchTinPagePaymentDataFilesSteps extends TestBase{
		
	SearchTinPagePaymentDataFiles srchTinPagePaymentDataFiles = new SearchTinPagePaymentDataFiles(testConfig);

@Then("^User Enters tin and click on search button for \"([^\"]*)\" on Payment Data Files page$")
public void user_Enters_tin_and_click_on_search_button_for_on_Payment_Data_Files_page(String userType) throws Throwable {
	if(testConfig.getRunTimeProperty("App").equalsIgnoreCase("CSR"))
		srchTinPagePaymentDataFiles.enterTinAndSrchCSR(userType);
	else if (testConfig.getRunTimeProperty("App").equalsIgnoreCase("UPA"))
		srchTinPagePaymentDataFiles.enterTinAndSrchUPA(userType);
}

@When("^User Validates Error Message upon Entering invalid TIN$")
public void User_Validates_Error_Message_upon_Entering_invalid_TIN() throws Throwable {
	srchTinPagePaymentDataFiles.verifyErrorMsgForInvalidTIN();
}



}