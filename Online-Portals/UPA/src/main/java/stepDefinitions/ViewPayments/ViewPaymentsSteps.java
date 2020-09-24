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
    	paySum.verifyMktType(mktTypeFilter);
    }
    
    @Then("^Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options\\.$")
    public void validate_default_value_of_Quick_Search_filter_displays_Last_thirty_days_option_and_dropdown_have_other_time_period_options() throws Throwable {
    	paySum.verifyQuickSrchFilterOptions();
    }

    @Then("^Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options\\.$")
    public void validate_Active_Archived_Payments_filter_is_relabeled_to_Payment_Status_and_has_default_value_as_New_and_dropdown_have_other_status_options() throws Throwable {
    	paySum.verifyPaymentStatusFilter();
    }

    @Then("^Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace$")
    public void validate_grid_no_longer_displays_Type_column_or_Payment_Status_field_and_is_relabeled_to_ACH_Trace() throws Throwable {
    	paySum.verifyColumnPresent("ACH Trace Number").verifyColumnIsNotPresent("Type").verifyColumnIsNotPresent("Payment Status / Trace Number");
    }

    @Then("^Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page\\.$")
    public void validate_Claim_Count_column_is_present_which_appears_as_Hyperlink_and_on_click_redirects_to_Remittance_Detail_page() throws Throwable {
        paySum.verifyClaimCountHyperlink("Claim Count");
    }

	@Then("^Validate Archive column relabeled to Payment Status$")
	public void validate_Archive_column_relabeled_to_Payment_Status() throws Throwable {
		paySum.verifyColumnPresent("Payment Status").verifyColumnIsNotPresent("Archive"); 
	}

    @Then("^Validate Archive/Save changes button is relabeled to Save$")
    public void validate_Archive_Save_changes_button_is_relabeled_to_Save() throws Throwable {
        paySum.verifySaveBtnRelabled();
    }
    
    @Then("^Validate default value of Payment Status filter displays New and dropdown have other status options\\.$")
    public void validate_default_value_of_Payment_Status_filter_displays_New_and_dropdown_have_other_status_options() throws Throwable {
    	paySum.verifyPaymentStatusFilter();
    }
    
    @Then("^Validate Archive column relabeled to Payment Status and has dropdown menu having values New, Pending and Closed$")
    public void validate_Archive_column_relabeled_to_Payment_Status_and_has_dropdown_menu_having_values_New_Pending_and_Closed() throws Throwable {
    	paySum.verifyColumnPresent("Payment Status").verifyColumnIsNotPresent("Archive").verifyPaymentStatusColumnDropdwn();
    }

    @Then("^Validate user is able to change the value of Payment Status column$")
    public void validate_user_is_able_to_change_the_value_of_Payment_Status_column() throws Throwable {
       paySum.verifyPaymentStatusColumnDropdwn();
    }

    @Then("^Validate upon changing of status in Payment Status filter appropriate payments display\\.$")
    public void validate_upon_changing_of_status_in_Payment_Status_filter_appropriate_payments_display() throws Throwable {
       
    }

    @Then("^Validate on Legacy Mode Pending and New Status are treated as Active and Closed Status as Archive$")
    public void validate_on_Legacy_Mode_Pending_and_New_Status_are_treated_as_Active_and_Closed_Status_as_Archive() throws Throwable {
       
    }
    
    @Then("^Validate (\\d+), ePRA and Payer PRA are enabled$")
    public void validate_ePRA_and_Payer_PRA_are_enabled(int arg1) throws Throwable {
      paySum.verify835EPRAlink();
    }

    @Then("^Validate \"([^\"]*)\" is able to re-originate ACH/drop to check payments$")
    public void validate_is_able_to_re_originate_ACH_drop_to_check_payments(String arg1) throws Throwable {
       paySum.verifyResendPayment();
    }

}
