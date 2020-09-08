package main.java.stepDefinitions.ViewPayments;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.ValidateEnrollmentTypePage;
import main.java.pageObjects.ViewPayments_Page;
import main.java.pageObjects.paymentSummary;
import main.java.pageObjects.SearchTinPageViewPayments;

public class ViewPaymentsSteps extends TestBase {
               
    ViewPayments_Page viewPayments = new ViewPayments_Page(testConfig);
    paymentSummary paySum = new paymentSummary(testConfig);
    

    @Then("^Validate all other columns in Show All State$")
               public void validate_all_other_columns_in_Show_All_State() throws Throwable {
                   
               viewPayments.verifyAllOtherDrpDwns();
               }
    
    @Then("^Validate all other columns in Show All State for UPA$")
    public void validate_all_other_columns_in_Show_All_State_for_UPA() throws Throwable {
        
               viewPayments.verifyAllOtherDrpDwnsinUPA();
    }
   
    @Then("^Validate all other columns in Show All State for \"([^\"]*)\" of UPA View Payments$")
    public void validate_all_other_columns_in_Show_All_State_for_of_UPA_View_Payments(String TimePeriod) {
               viewPayments.verifyAllColumnsViewPay(TimePeriod);
    }
    
	
	@Then("^User selects time period filter \"([^\"]*)\" for View Payments$")
	public void user_selects_time_period_filter_for_View_Payments(String timePeriod) throws Throwable {
    	viewPayments.selectTimePeriod(timePeriod);
	}
    
	@Then("^User selects market type filter period \"([^\"]*)\" for View Payments$")
	public void user_selects_market_type_filter_period_for_View_Payments(String filter) throws Throwable {
    	viewPayments.selectMarketType(filter);
	}


    
    @When("^Validate all other columns in Show All State for UPA_Payer$")
    public void validate_all_other_columns_in_Show_All_State_for_UPA_Payer() throws Throwable {
        
               viewPayments.verifyAllOtherDrpDwnsinUPAPayer();
    }
    
    @Then("^Validate Payment Number Hyper Link$")
    public void validate_Payment_Number_Hyper_Link() throws Throwable {
               
               viewPayments.verifyPaymentNumberHypherLinkClaimDtl();
    }
        
   // Need to add comment 
    @Then("^Set FISL Parameters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void set_FISL_Parameters_and(String key, String value) throws Throwable {
               
               testConfig.putRunTimeProperty("key", key);
               testConfig.putRunTimeProperty("value", value); 
    }
    
    @When("^Click on View Payments Link for UPA$")
    public void click_on_View_Payments_Link_for_UPA() throws Throwable {
        
               viewPayments.clickViewPaymentsTab();
    }
    
    @Then("^Validate Payment Number Hyper Link in UPA$")
    public void validate_Payment_Number_Hyper_Link_in_UPA() throws Throwable {
   
                  viewPayments.verifyPayNumHypherLinkClaimDtlUPA();
    }
    
    @Then("^Validate Payment Number Hyper Link in UPA Payer$")
    public void validate_Payment_Number_Hyper_Link_in_UPA_Payer() throws Throwable {
       
                viewPayments.verifyPayNumHypherLinkClaimDtlPayer();
    }
    
    @Then("^Validate that View Payments Payer/Patient column name is changed to Payer for \"([^\"]*)\"$")
    public void validate_that_View_Payments_Payer_Patient_column_name_is_changed_to_Payer_for(String credentials) throws Throwable {
    	viewPayments.verifyPayerText(credentials);
    }

    @Then("^Validate the EPRA and Payer PRA column in View Payments Page for \"([^\"]*)\"$")
    public void validate_the_EPRA_and_Payer_PRA_column_in_View_Payments_Page_for(String credentials) throws Throwable {
    	viewPayments.verifyEPRAAndPayerPRA(credentials);
    }
    
    @Then("^Validate and click on payment number$")
    public void validate_and_click_on_payment_number() throws Throwable {
    	viewPayments.verifyandClickPayment();
    }
    
    @Then("^User selects \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" filters for \"([^\"]*)\" \"([^\"]*)\" and validate payment search results$")
    public void user_selects_filters_for_and_validate_payment_search_results(String filterPayments, String quickSearchFilter, String archiveFilter, String MktTypeFilter, String key, String value) throws Throwable {
    	testConfig.putRunTimeProperty("key", key);
		testConfig.putRunTimeProperty("value", value);
		if(MktTypeFilter.equalsIgnoreCase("Medical")) {
			paySum.verifyMktType(MktTypeFilter);
		}
		else {
			paySum.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, MktTypeFilter);
		}
    }
    
    @Then("^User selects \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" filters for \"([^\"]*)\" \"([^\"]*)\" and validate payment date sorting$")
    public void user_selects_filters_for_and_validate_payment_date_sorting(String filterPayments, String quickSearchFilter, String archiveFilter, String MktTypeFilter, String key, String value) throws Throwable {
    	testConfig.putRunTimeProperty("key", key);
		testConfig.putRunTimeProperty("value", value);
		paySum.setSearchFilters(filterPayments, quickSearchFilter, archiveFilter, MktTypeFilter);
		paySum.verifyPaymentDateSorting("Desc");
		paySum.verifyPaymentDateSorting("Asc");
    }
    
    @Then("^User verifies \"([^\"]*)\" zero dollar payments for \"([^\"]*)\" \"([^\"]*)\"$")
    public void user_verifies_zero_dollar_payments_for(String paymentType, String key, String value) throws Throwable {
    	testConfig.putRunTimeProperty("key", key);
		testConfig.putRunTimeProperty("value", value);
		paySum.verifyZeroDollarPayments(paymentType);
    }

    @Then("^User verifies hovering text in pop up for  \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\"$")
    public void user_verifies_hovering_text_in_pop_up_for_and(String paymentType, String key, String value) throws Throwable {
    	testConfig.putRunTimeProperty("key", key);
		testConfig.putRunTimeProperty("value", value);
		paySum.setQuickSearchFilter(paymentType);
		if (paymentType.equalsIgnoreCase("remitPayment")) {
			paySum.verifyRemitPaymentPopUp();
		}
		else if(paymentType.equalsIgnoreCase("failedPayment")){
			paySum.verifyFailedPaymentPopUp();
		}
    }
    @Then("^Verify Default Search Result Count$")
    public void verify_Default_Search_Result_Count() throws Throwable {
               paySum.verifyDefaultSearchResultCount();
    }
    
    @Then("^Verify Search Results With \"([^\"]*)\" for \"([^\"]*)\"$")
    public void verify_Search_Results_With_for(String filterPayments, String quickSearchFilter) throws Throwable {

               paySum.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
    }

    @Then("^Verify Search Results With \"([^\"]*)\" for \"([^\"]*)\" With \"([^\"]*)\"$")
    public void verify_Search_Results_With_for_With(String filterPayments, String quickSearchFilter, String archiveFilter) throws Throwable {
               paySum.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, archiveFilter);
               
    }
    
    @Then("^Verify Search Results for \"([^\"]*)\" having \"([^\"]*)\" With \"([^\"]*)\"$")
    public void verify_Search_Results_for_having_With(String filterPayments, String quickSearchFilter, String archiveFilter) throws Throwable {
        
               paySum.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, archiveFilter, filterPayments);
    }
    
    @Then("^Set Search Filters for \"([^\"]*)\" having \"([^\"]*)\"$")
    public void set_Search_Filters_for_having(String archiveFilter, String quickSearchFilter) throws Throwable {
               
               paySum.setSearchFilters(archiveFilter, quickSearchFilter, archiveFilter, archiveFilter);
               
    }
    
    @Then("^Verify Payment Date Sorting for \"([^\"]*)\"$")
    public void verify_Payment_Date_Sorting_for(String order) throws Throwable {
               paySum.verifyPaymentDateSorting(order);
    }
    
    @Then("^Set Quick Search Filter for \"([^\"]*)\"$")
    public void set_Quick_Search_Filter_for(String paymentType) throws Throwable {
               paySum.setQuickSearchFilter(paymentType);
    }

    @Then("^Verify Remit Payment PopUp$")
    public void verify_Remit_Payment_PopUp() throws Throwable {
               paySum.verifyRemitPaymentPopUp(); 
    }
    
    @Then("^Verify Failed Payment PopUp$")
    public void verify_Failed_Payment_PopUp() throws Throwable {
               paySum.verifyFailedPaymentPopUp();
    }
    
    @Then("^Verify Zero Dollar Payments for \"([^\"]*)\"$")
    public void verify_Zero_Dollar_Payments_for(String paymentType) throws Throwable {
               paySum.verifyZeroDollarPayments(paymentType);
    }
    
    @Then("^Verify Mkt Type for \"([^\"]*)\"$")
    public void verify_Mkt_Type_for(String mktTypeFilter) throws Throwable {
               paySum.verifyMktType(mktTypeFilter);
    }
       
}
