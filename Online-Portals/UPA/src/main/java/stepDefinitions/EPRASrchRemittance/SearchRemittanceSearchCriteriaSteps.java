package main.java.stepDefinitions.EPRASrchRemittance;

import java.util.Map;

import cucumber.api.java.en.Then;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.SearchRemittanceSearchCriteria;

public class SearchRemittanceSearchCriteriaSteps extends TestBase{
	
	SearchRemittanceSearchCriteria srchCriteriaPage = new SearchRemittanceSearchCriteria(testConfig);
	
	@Then("^User enters \"([^\"]*)\" and click on search button\\.$")
	public void user_enters_and_click_on_search_button(String srchCriteria) throws Throwable {
		srchCriteriaPage.doSearch(srchCriteria); 
	}
	
	@Then("^User enters \"([^\"]*)\" and click on search button for Payer$")
	public void user_enters_and_click_on_search_button_for_Payer(String srchCriteria) throws Throwable {
		
		srchCriteriaPage.doSearchForPayer(srchCriteria);
	}		
	
	@Then("^User clicks on PDF Link$")
	public void user_clicks_on_PDF_Link() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		RemittanceDetail remittanceDetail=new RemittanceDetail(testConfig);
		remittanceDetail.SelectPDFLink();
	}
	
	@Then("^User Deletes paymentdetail record \"([^\"]*)\" from ole\\.ppra_status_dtl and ole\\.ppra_status table$")
	public void user_Deletes_paymentdetail_record_from_ole_ppra_status_dtl_and_ole_ppra_status_table(String PaymentNumber) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("PaymentNumber",PaymentNumber);
		Browser.wait(testConfig, 10); 
		//
		int sqlRowNo1=227;
        testConfig.putRunTimeProperty("CONSL_PAY_NBR",PaymentNumber);
		testConfig.putRunTimeProperty("PaymentNumber", System.getProperty("PaymentNumber"));
        DataBase.executeDeleteQuery(testConfig, sqlRowNo1);
        
        Browser.wait(testConfig, 10);
        int sqlRowNo2=228;
        testConfig.putRunTimeProperty("PaymentNumber", System.getProperty("PaymentNumber"));
        DataBase.executeDeleteQuery(testConfig, sqlRowNo2);
	}
	
	@Then("^User selects \"([^\"]*)\" for Consol_Pay_Nmbr \"([^\"]*)\" with NPI value as \"([^\"]*)\" with fromdate \"([^\"]*)\" and todate \"([^\"]*)\" and click on search button\\.$")
	public void user_selects_for_Consol_Pay_Nmbr_with_NPI_value_as_with_fromdate_and_todate_and_click_on_search_button(String srchCriteria, String PaymentNumber, String NPI, String DOPFromDate, String DOPToDate ) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("CONSL_PAY_NBR", PaymentNumber);
		testConfig.putRunTimeProperty("CONSL_PAY_NBR",PaymentNumber);
		System.setProperty("NPI", NPI);
		System.setProperty("DOPFromDate", DOPFromDate);
		System.setProperty("DOPToDate", DOPToDate);
		srchCriteriaPage.doSearch(srchCriteria); 
	}
	
	@Then("^User selects \"([^\"]*)\" with value \"([^\"]*)\" and click on search button\\.$")
	public void user_selects_with_value_and_click_on_search_button(String srchCriteria, String PaymentNumber) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("CONSL_PAY_NBR", PaymentNumber);
		testConfig.putRunTimeProperty("CONSL_PAY_NBR",PaymentNumber);
		srchCriteriaPage.doSearch(srchCriteria); 
	}
	
	@Then("^User validates pPRA file is \"([^\"]*)\"$")
	public void user_validates_pPRA_file_is(String Status) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		Thread.sleep(8000);
		RemittanceDetail remittanceDetail=new RemittanceDetail(testConfig);
		remittanceDetail.isPDFAvailable(Status);
		
		
	}

    @Then("^verify error messages in search results$")
    public void verify_error_messages_in_search_results() throws Throwable {
    	srchCriteriaPage.verifyErrorMsgs();
    }
    
    @Then("^verify large non large tin in search results$")
    public void verify_large_non_large_tin_in_search_results() throws Throwable {
    	srchCriteriaPage.verifyLargeNonLargeTin();
    }
    
    
    //Added by Mohammad
    @Then("^User verifies page text message \"([^\"]*)\"$")
    public void user_verifies_page_text_message(String typeMsg) throws Throwable 
    {
       srchCriteriaPage.verifyTopMsgProv_Premium(typeMsg);
    }

}
