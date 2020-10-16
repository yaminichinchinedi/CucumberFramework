package main.java.stepDefinitions.ViewPayments;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
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
               testConfig.putRunTimeProperty(key, value); 
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

    @When("^User validates different UI fields as enabled/disabled,renamed and few New$")
    public void user_validates_different_UI_fields_as_enabled_disabled_renamed_and_few_New() throws Throwable {
    	viewPayments.verifyDisable();
    }

    @When("^User also validates for refreshment of page and limited UI if diferent standard TIN is selected from dropdown$")
    public void user_also_validates_for_refreshment_of_page_and_limited_UI_if_diferent_standard_TIN_is_selected_from_dropdown() throws Throwable {
        
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

    @Then("^Validate user is able to change the value of Payment Status column$")
    public void validate_user_is_able_to_change_the_value_of_Payment_Status_column() throws Throwable {
       paySum.verifyPaymentStatusColumnDropdwn();
    }

    @Then("^Validate (\\d+), ePRA and Payer PRA are enabled$")
    public void validate_ePRA_and_Payer_PRA_are_enabled(int arg1) throws Throwable {
      paySum.verify835EPRAlink();
    }

    @Then("^Validate payment summary page for only single NPI payments for \"([^\"]*)\"$")
    public void validate_payment_summary_page_for_only_single_NPI_payments_for(String paymentType) throws Throwable {
    	paySum.verifyNPI(paymentType);
    }
    
    @Then("^Click on print Payment Summary button\\.$")
    public void click_on_print_Payment_Summary_button() throws Throwable {
        paySum.clickPrintPaymentBtn();
    }
    
    @Then("^Set search filters for \"([^\"]*)\" having \"([^\"]*)\" With \"([^\"]*)\"$")
    public void set_search_filters_for_having_With(String archivefilter, String quickSearchFilter, String filterPayments) throws Throwable {
    	paySum.setSearchFilters(filterPayments, quickSearchFilter, archivefilter, filterPayments);
    }

    @Then("^Validate the data of Print Payment Summary page\\.$")
    public void validate_the_data_of_Print_Payment_Summary_page() throws Throwable {
    	testConfig.putRunTimeProperty("page", "printPaymentSummary");
    	 paySum.verifyPrintPaymentSummaryPage();
    }

    @Then("^Validate default value of Quick Search filter displays Last thirty days option and it is greyed out\\.$")
    public void validate_default_value_of_Quick_Search_filter_displays_Last_thirty_days_option_and_it_is_greyed_out() throws Throwable {
    	paySum.verifyQuickSrchFilterOptions("Standard");
        
    }

    @Then("^Validate Active/Archived Payments filter is relabeled to Payment Status,default value as New and greyed out\\.$")
    public void validate_Active_Archived_Payments_filter_is_relabeled_to_Payment_Status_default_value_as_New_and_greyed_out() throws Throwable {
    	paySum.verifyPaymentStatusFilter("Standard");
        
    }

    @Then("^Validate Archive/Save changes button is not there$")
    public void validate_Archive_Save_changes_button_is_not_there() throws Throwable {
        
    	paySum.verifySavArchbtnNotPresent();
    }

    @Then("^Validate Claim Count,ePRA,pPRA and Payment status fields appear with a gray box with value 'N/A'and (\\d+)field as enabled\\.$")
    public void validate_Claim_Count_ePRA_pPRA_and_Payment_status_fields_appear_with_a_gray_box_with_value_N_A_and_field_as_enabled(int arg1) throws Throwable {
        paySum.verifyColumnValuesNA();
        
    }
	  
	@Then("^Validate selecting different standard TIN page gets refreshed and will display limited UI View$")
	public void validate_selecting_different_standard_TIN_page_gets_refreshed_and_will_display_limited_UI_View() throws Throwable {
		paySum.selectTinNverfyPagRfrsh();
	}

    //Amit code imported.Modify and check all the codes
    @Then("^Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options\\.$")
    public void validate_default_value_of_Quick_Search_filter_displays_Last_thirty_days_option_and_dropdown_have_other_time_period_options() throws Throwable {
    	paySum.verifyQuickSrchFilterOptions("Standard");
    }

    @Then("^Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options\\.$")
    public void validate_Active_Archived_Payments_filter_is_relabeled_to_Payment_Status_and_has_default_value_as_New_and_dropdown_have_other_status_options() throws Throwable {
    	paySum.verifyPaymentStatusFilter("Standard");
    }

    @Then("^Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace$")
    public void validate_grid_no_longer_displays_Type_column_or_Payment_Status_field_and_is_relabeled_to_ACH_Trace() throws Throwable {
    	paySum.verifyColumnPresent("ACH Trace Number").verifyColumnIsNotPresent("Type").verifyColumnIsNotPresent("Payment Status / Trace Number");
    }

  
}
