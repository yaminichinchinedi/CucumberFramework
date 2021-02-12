	
package main.java.stepDefinitions.RunReports;

import cucumber.api.PendingException;
import main.java.pageObjects.RunReports;
import main.java.pageObjects.SearchTinPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;

public class RunReportsStep extends TestBase {
	RunReports runReports= new RunReports(testConfig);
	
	@When("^User clicks on HIPAA Error Summary Report$")
	public void user_clicks_on_HIPAA_Error_Summary_Report() throws Throwable {
		runReports.clickHipaaErrorSummaryReport();
	}

	@When("^User clicks on Payment/Remit Only Payment Summary Report$")
	public void user_clicks_on_Payment_Remit_Only_Payment_Summary_Report() throws Throwable {
		runReports.clickPaymentRemitOnlyPaymentSummaryReport();
	}

	@When("^User clicks on Payment Summary Report$")
	public void user_clicks_on_Payment_Summary_Report() throws Throwable {
		runReports.clickPaymentSummaryReport();
	}

	@When("^User clicks on Transaction Summary Report$")
	public void user_clicks_on_Transaction_Summary_Report() throws Throwable {
		runReports.clickTransactionSummaryReport();
	}
	
	@When("^User clicks on Organization Address History Report$")
	public void user_clicks_on_Organization_Address_History_Report() throws Throwable {
		runReports.clickOrgAddressHistoryReport();
	}

	@Then("^verify hover functionality$")
	public void verify_hover_functionality() throws Throwable {
	    runReports.verifyHoverFunctionality();
	}
	
	@When("^User clicks on Organization User History$")
	public void user_clicks_on_Organization_User_History() throws Throwable {
		runReports.clickOrgUserHistory();
	 }
	@When("^User clicks on Biling Service History$")
	public void user_clicks_on_Biling_Service_History() throws Throwable {
		runReports.clickBSUserHistory();
	 }
	@When("^Input the data range and tin for \"([^\"]*)\"$")
	public void input_the_data_range_and_tin_for(String userType) throws Throwable {
		 runReports.enterTinAndDateRange(userType);
	 }
	@Then("^Validate if description link is present$")
	public void validate_if_description_link_is_present() throws Throwable {
		runReports.validateDescriptionLink();
	 }
	@Then("^Validate if the print button is present$")
	public void validate_if_the_print_button_is_present() throws Throwable {
		runReports.validatebtnPrint();
	 }
	@Then("^Validate if the Save As Excel button is present$")
	public void validate_if_the_Save_As_Excel_button_is_present() throws Throwable {
		runReports.validatSaveAsExcelBtn();
	}
	
	
}