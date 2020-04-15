
package main.java.stepDefinitions.CrtEnrolmnt;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.SelectReportsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectReportsPageSteps extends TestBase {

	
	SelectReportsPage slctRprt=new SelectReportsPage(testConfig);
	
	
	
	@Then("^User clicks on drop down and verifies Enrollment Survey Results option$")
	public void user_clicks_on_drop_down_and_verifies_Enrollment_Survey_Results_option() throws Throwable {
		slctRprt.clickDropdown();
	}

	@Then("^User select Enrollment Survey Results option and verifies To and From Date fiels are present$")
	public void user_select_Enrollment_Survey_Results_option_and_verifies_To_and_From_Date_fiels_are_present() throws Throwable {
		slctRprt.verifyDateButton();
	}
	
	
	@Then("^User verifies Submit button on the page$")
	public void user_verifies_Submit_button_on_the_page() throws Throwable {
		slctRprt.verifySubmitButton();   
	}

	@Then("^click on Submit button without any input$")
	public void click_on_Submit_button_without_any_input() throws Throwable {
		slctRprt.clickSubmit();
	}
	@Then("^Click on form Button$")
	public void click_on_form_Button() throws Throwable {
		slctRprt.clickCalender();
	}
	

@When("^Provide from date and To Date greater than  todays date$")
public void provide_from_date_and_To_Date_greater_than_todays_date() throws Throwable {
    
}

@Then("^Error Message End Date should not be greater than Todays message should be displayed$")
public void error_Message_End_Date_should_not_be_greater_than_Todays_message_should_be_displayed() throws Throwable {
	slctRprt.enterInvalidDates("EndDtmoreTodayDt");
}

@When("^Provide from date  greater than To date$")
public void provide_from_date_greater_than_To_date() throws Throwable {
    
}

@Then("^Error Message FromDate can not exceed ToDate should be displayed$")
public void error_Message_FromDate_can_not_exceed_ToDate_should_be_displayed() throws Throwable {
	slctRprt.enterInvalidDates("ToDtmoreFromDt");

}

@Then("^Choose FromDate and ToDate from calenders and click submit button$")
public void choose_FromDate_and_ToDate_from_calenders_and_click_submit_button() throws Throwable {
    
}

@Then("^Choose dates \"([^\"]*)\" from calenders,click submit button,verifies SurveyResponse\\.xlx files opened$")
public void choose_dates_from_calenders_click_submit_button_verifies_SurveyResponse_xlx_files_opened(String arg1) throws Throwable {
	slctRprt.validtSurveyResponseFile(arg1);
}

@Then("^Verifies all the fields from excel file and database by running query$")
public void verifies_all_the_fields_from_excel_file_and_database_by_running_query() throws Throwable {
   
}


@Then("^Choose data dates from calenders,click submit button$")
public void choose_data_dates_from_calenders_click_submit_button() throws Throwable {
	slctRprt.enterDateswithNoData();
}

@Then("^If No data fetched then Error message: Your Search Return No Data returned$")
public void if_No_data_fetched_then_Error_message_Your_Search_Return_No_Data_returned() throws Throwable {
	slctRprt.validtErrMsgNoData();
}


}