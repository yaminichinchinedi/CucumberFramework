package main.java.stepDefinitions.OptumPaySolution;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.OptumPaySolution;
import main.java.reporting.Log;

import java.sql.SQLException;


public class OptumPaySolutionSteps extends TestBase {
	
OptumPaySolution optumPaySol = new OptumPaySolution(testConfig);

@Then("^User verifies Optum Pay Solution Tab for standard user with \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_verifies_Optum_Pay_Solution_Tab_for_standard_user_with_and(String trialStatus, String portalAccess) throws Throwable {
	if(portalAccess.equalsIgnoreCase("Standard"))
		optumPaySol.verifySolutionsTabForStandard(trialStatus,portalAccess);
	else if(portalAccess.equalsIgnoreCase("Premium"))
		optumPaySol.verifySolutionsTabForPremium(trialStatus,portalAccess);
}

@Then("^Verify the Cancellation Popup based on \"([^\"]*)\"$")
public void verify_the_Cancellation_Popup_based_on_trialStatus(String trialStatus) throws Throwable {
	optumPaySol.verifyCancellationPopUp(trialStatus);
}

@Then("^Validate the texts in Manage My Plan Tile$")
public void validate_the_texts_in_Manage_My_Plan_Tile() throws Throwable {
	  optumPaySol.validateManageMyPlanText().validateCancelMyPlanTextLink();
	  optumPaySol.validateFreeTrialTextNotPresent("Free Trial End Date:");

}
@Then("^User verifies the Optum Pay Solutions tiles For VO$")
	  public void user_verifies_the_tiles_in_UPA_VO() throws Throwable {
	  	optumPaySol.verifyOPSTilesForVO();
	  }
@Then("^User validates Tiles of this page in order$")
public void user_validates_Tiles_of_this_page_in_order() throws Throwable {
	optumPaySol.validateTitleNames();
}

@Then("^User validates contents of Fee tiles of this page$")
public void user_validates_contents_of_Fee_tiles_of_this_page() throws Throwable {
	optumPaySol.validateFeeTitle();
}	
@Then("^User validates accrued content fee on this page$")
public void user_validates_accrued_content_fee_on_this_page() throws Throwable {
	optumPaySol.validtAccrdFeesMnthFrInvceTab();
}
@When("^User Validates Error Message upon Entering \"([^\"]*)\" on Optum Pay Solution$")
public void User_Validates_Error_Message_upon_Entering_Invalid_Tin_on_Optum_Pay_Solution(String InvalidTIN) throws Throwable {
	optumPaySol.verifyInvalidTINonOptumPaySolution(InvalidTIN);
}

@Then("^User validates contents of Plan Type tile of this page$")
public void user_validates_contents_of_Plan_Type_tile_of_this_page() throws Throwable {
	optumPaySol.validatePlanTypeTile();
}
@Then("^User then validates the Change Rate popup based \"([^\"]*)\"$")
public void user_then_validates_the_Change_Rate_popup_based(String credentials) throws Throwable {
	optumPaySol.validateChangeRatePopup(credentials);
}
@Then("^User validates the hover on info icon on the tiles$")
public void user_validates_the_hover_on_info_icon_on_the_tiles() throws Throwable {
	optumPaySol.validateInfoIconHover();
}

@Then("^User validates the Text, Dates, Rates on the Rate Tile section for given \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_validates_the_Text_Dates_Rates_on_the_Rate_Tile_section_for_given_and(String tinType, String portalAccess) throws Throwable {
	optumPaySol.rateTileCSRFeeAndDateVerification(tinType,portalAccess);
}
@Then("^User then validates the Change Rate scenarios based on \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_then_validates_the_Change_Rate_scenarios_based_on(String credentials, String changeRateValue, String changeRateReason) {
	optumPaySol.validateChangeRatePrcnt(credentials,changeRateValue,changeRateReason);
	}

//Added by Mohammad Khalid
@Then("^User verifies page text \"([^\"]*)\" messaging in Optum Pay Solutions page$")
public void user_verifies_page_text_messaging_in_Optum_Pay_Solutions_page(String pageText) throws Throwable 
{
	switch (pageText)
	{
	case "Premium_TopMsg":
	{
		optumPaySol.verifyPageText_Top_Premium();
		break;
	}
	case "Premium_FooterMsg":
	{
		optumPaySol.verifyPageText_Footer_Premium();
		break;
	}
	case "Standard_Msg_1":
	{
		optumPaySol.verifyPageText_Message1_Standard();
		break;
	}
	
	case "Standard_Msg_2":
	{
		optumPaySol.verifyPageText_Message2_Standard();
		break;
	}
	
	}

}


//Added by Mohammad to click on Invoices tab on OPS tab

@Then("^User clicks on \"([^\"]*)\" tab$")
public void user_clicks_on_tab(String tabName) throws Throwable
{
    optumPaySol.clickOnInvoicesTab();
}

@Then("^User validates \"([^\"]*)\"$")
public void user_validates(String paraName) throws Throwable
{
	switch(paraName)
	{
	case "ProviderName" :
	{
		optumPaySol.verifyProviderName();
		break;
	}
	
	case "AccruedFees" :
	{
		optumPaySol.verifyAccruedFees();
		break;
	}
	
	case "PastDueFees" :
	{
		optumPaySol.verifyPastDueFees();
		break;
	}
	
	case "InvoicePeriodGrid" :
	{
		optumPaySol.verifyInvoicePeriodGrid();
		break;
	}
	}
    
}

@Then("^User validates Provider Name, Accrued Fees, Past Due Fees and Invoice Period Grid$")
public void user_validates_Provider_Name_Accrued_Fees_Past_Due_Fees_and_Invoice_Period_Grid() throws Throwable
{
	optumPaySol.verifyInvoiceTabHeader().verifyProviderName().verifyAccruedFees().verifyPastDueFees().verifyInvoicePeriodGrid();
}



@Then("^User validates contents of Past due fee of Fee tiles for this page$")
public void user_validates_contents_of_Past_due_fee_of_Fee_tiles_for_this_page() throws Throwable {
	optumPaySol.validatePastdueFee();
}
@Then("^User validates contents of Accrued fee of Fee tiles for this page$")
public void user_validates_contents_of_Accrued_fee_of_Fee_tiles_for_this_page() throws Throwable {
	optumPaySol.validateAccruedFeesMonth();
}
@Then("^User verifies if Invoices tab is available for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"\\.$")
public void user_verifies_if_Invoices_tab_is_available_for_and_and_and(String searchCriteria, String portalAccess, String tinType, String prdctRecSts) throws Throwable {
	optumPaySol.verifyInvoicesTab(searchCriteria, tinType, portalAccess,prdctRecSts);
}

@Then("^User clicks on Fee Searh Tab on Optum Pay Solutions Page$")
public void user_clicks_on_fee_search_tab() throws Throwable {
	optumPaySol.navigateToFeeSearchTab();
}

	@Then("^User enters \"([^\"]*)\" on Fee Search page and click on search button\\.$")
	public void user_enters_and_click_on_search_button(String srchCriteria) throws Throwable {
		optumPaySol.doSearch(srchCriteria);
	}
	@Then("^verify that max (\\d+) records are on single page and pagination links enabled/disabled accordingly$")
public void verify_that_max_records_are_on_single_page_and_pagination_links_enabled_disabled_accordingly(int arg1) throws Throwable {
    optumPaySol.verifyPagination();
}
	
	@Then("^User enters \"([^\"]*)\" validates selectAll, Cancel, RefundFee buttons and select column functionality$")
	public void user_enters_validates_selectAll_Cancel_RefundFee_buttons_and_select_column_functionality(String feeSearchCriteria) throws Throwable {
		optumPaySol.validateFeeRefundButtonsAndFunctionality(feeSearchCriteria);
	}
		
	@Then("^User validates info icon hover message for Plan Type, Rate, Fees and Manage My Plan tile$")
	public void user_validates_info_icon_hover_message_for_Plan_Type_Rate_Fees_and_Manage_My_Plan_tile() throws Throwable {
	    optumPaySol.verifyInfoIconMessagesforAllTiles();
	}
	
	@Then("^User validated header and footer message on options tab for \"([^\"]*)\" for \"([^\"]*)\"\\.$")
	public void user_validated_header_and_footer_message_on_options_tab_for_for(String tinType, String userType) throws Throwable {
		optumPaySol.verifyHeaderFooterMsgOptionsTab(tinType,userType);
	}

	@Then("^User verifies if tiles are present for \"([^\"]*)\" TIN$")
	public void user_verifies_if_tiles_are_present_for_TIN(String tinType) throws Throwable 
	{
	    boolean isPresent = optumPaySol.verifyTilesArePresentOnOPS();
	    
	    if (tinType.equalsIgnoreCase("Premium")&&isPresent==true)
	    	Log.Pass("The Premium OPS page is present");
	    else if(tinType.equalsIgnoreCase("Standard")&&isPresent==false)
	    	Log.Pass("The Standard OPS page is present");
	    else
	    	Log.Fail("The OPS page is not correctly displayed for: " + tinType);
	    	
	}

	@Then("^User verifies the error message for \"([^\"]*)\" tin$")
	public void user_verifies_the_error_message_for_tin(String tinType) throws Throwable {
	    optumPaySol.verifyTINerroMsgforBSUsers(tinType);
	}
	
		@Then("^User clicks on Invoice Number that opens pdf in new tab$")
	public void user_clicks_on_Invoice_Number_that_opens_pdf_in_new_tab() throws Throwable {
		optumPaySol.clickInvoiceNumberAndOpenPdf();
	}
		
		@Then("^User clicks on Pay Now Button$")
	public void user_clicks_on_pay_now_button() throws Throwable {
		optumPaySol.clickOnPayNowButton();
	}
		
		
	@Then("^User selects fees in the grid, calculate the total fee amount and clicks on Refund Fee button$")
	public void user_selects_fees_in_the_grid_calculate_the_total_fee_amount_and_clicks_on_Refund_Fee_button() throws Throwable {
	    optumPaySol.selectFeeAmountCheckBoxAndCalculateFeeAmount();
	}
	
	@Then("^User verifies Refund Pop Up UI is displayed, verifies text and clicks on Cancel button$")
	public void user_verifies_Refund_Pop_Up_UI_is_displayed_verifies_text_and_clicks_on_Cancel_button() throws Throwable {
		 optumPaySol.verifyTextOnRefundPopUI();
	}
	
	@Then("^User clicks on the Select All again and clicks on Refund Fee button$")
	public void user_clicks_on_the_Select_All_again_and_clicks_on_Refund_Fee_button() throws Throwable {
	    optumPaySol.clickOnSelectAllandRefundButton();
	}

	@Then("^User selects Refund reason and clicks on Refund button on Pop Up$")
	public void user_selects_Refund_reason_and_clicks_on_Refund_button_on_Pop_Up() throws Throwable {
	   optumPaySol.selectRefundReasonandClickOnRefundButton();
	}
	
		@Then("^User verifies the Optum Pay Solution page for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\"$")
		public void user_verifies_the_Optum_Pay_Solution_page_for_for_for(String userType, String portalAccess, String tinType) throws Throwable {
			optumPaySol.validateOptumPaySolutionPage(userType, portalAccess, tinType);
		}

		@Then("^Fill Cancel Details with Reason as \"([^\"]*)\" and Submit for \"([^\"]*)\"$")
		public void fill_Cancel_Details_with_Reason_as_and_Submit_for_UPA(String reasonCode, String portal) throws Throwable {
			optumPaySol.cancelPremiumAndSubmit(reasonCode, portal);
		}

		@Then("^Verify that the Premium is cancelled for \"([^\"]*)\" on \"([^\"]*)\"$")
		public void verify_that_the_Premium_is_cancelled_for_on(String trialStatus, String portal) throws Throwable {
			optumPaySol.updatedToStandardAfterCancel(trialStatus).verifyCancelTableUpdated().verifyPremiumCancelledOnUIAndChangeTinToPremium(trialStatus, portal);		
		}

		@Then("^Verify the effective date for \"([^\"]*)\" record for \"([^\"]*)\"$")
		public void verify_the_effective_date_for_record_for(String portalAccess, String tinType) throws Throwable {
			optumPaySol.verifyEffectiveDateOfTrialPendingRecord(portalAccess, tinType);
		}

		@Then("^User clicks on Get Started to select Premium$")
		public void user_clicks_on_Get_Started_to_select_Premium() throws Throwable {
			optumPaySol.convertToPremiumFromUpa();
		}
		
		@Then("^User validates Process My Payment modal$")
		public void user_validates_Process_My_Payment_modal() throws Throwable {
			optumPaySol.verifyProcessMyPaymentModal();
		}


		@Then("^User validates RTN when ABA Switch is \"([^\"]*)\" and \"([^\"]*)\" response from ABA API$")
		public void user_validates_RTN_when_ABA_Switch_is_and_response_from_ABA_API(String ABASwitch, String ABAResponse) throws Throwable {
			optumPaySol.validateProcessMyPaymentHeader(ABASwitch, ABAResponse );

		}
		
		@Then("^User verifies the Modal post filling information and Submits the ACH Payment Modal$")
		public void user_verifies_the_Modal_post_filling_information_and_Submits_the_ACH_Payment_Modal() throws Throwable {
			optumPaySol.verifyProcessMyPaymentModalAfterEnteringUserInfo();
		}
		@Then("^User clicks on close button of Thank you popup$")
		public void user_clicks_on_close_button_of_Thank_you_popup() throws Throwable {
		    optumPaySol.verifyThankyoupopup();
		}
		@Then("^verify the Invoice tab header message$")
		public void verify_the_Invoice_tab_header_message() throws Throwable {
			optumPaySol.verifyInvoiceTabHeader();
		}
		@Then("^verify that the Pay Now Button is disabled for Credit only Invoice$")
		public void verify_that_the_Pay_Now_Button_is_disabled_for_Credit_only_Invoice() throws Throwable {
		   optumPaySol.verifyPayNowButtonForRefundInvoice();
		}
		
		@Then("^validate Wavie Full Fee functionality and options when clicked on it$")
		public void validate_Wavie_Full_Fee_functionality_and_options_when_clicked_on_it() throws Throwable {
			optumPaySol.verifyWavieButtonOptions();
		}

		@Given("^Update the ADJ_REQ_ON Date to Current Date$")
		public void update_the_ADJ_REQ_ON_Date_to_Current_Date() throws Throwable {
			//optumPaySol.verifyDebitFeeAdj();
		}

		@Given("^Update the ADJ_REQ_ON Date to Current Date for \"([^\"]*)\"$")
		public void update_the_ADJ_REQ_ON_Date_to_Current_Date_for(String searchCriteria) throws Throwable {
			optumPaySol.verifyDebitFeeAdj(searchCriteria);
		}
		
		

      @Then("^validate Wavie Full Fee Button based on \"([^\"]*)\" enabled or not$")
      public void validate_Wavie_Full_Fee_Button_based_on_enabled_or_not(String searchCriteria) throws Throwable {

    	  optumPaySol.verifyWaivedfeespending(searchCriteria);
      }
      
      @Then("^User verifies waive fees and clicks on waive fee button$")
		public void VerifyAndClickWaiveFee() throws Throwable {
			optumPaySol.verifyAndClickWaiveFee();
		}
      
      @Then("^User verifies waive fees$")
		public void VerifyWaiveFee() throws Throwable {
			optumPaySol.verifyWaiveFee();
		}
      
      //Piyush
      @Then("^Verify Select Option to Waive Fees opens$")
		public void VerifySelectOptionToWaiveFeesWindow() throws Throwable {
			optumPaySol.verifyWaiveFeesWindow();
		}
    
   
	@Then("^Verify Waive full and partial amount$")
	public void VerifyWaiveFullAndPartialAmount()
	{
		optumPaySol.verifyWaivefullAndPartialAmount();
	}
	
	  //Piyush
    @Then("^Click on Home Link$")
    public void ClickOnHomeLink(){
  	  optumPaySol.clickOnHomeLink();
    }
	
      @Then("^Verify Select Option for waive fees \"([^\"]*)\" dropdown$")
		public void VerifySelectDropdownOptions(String reason) throws Throwable {
			optumPaySol.verifySelectDropdownOptions(reason);
		}
      
		@Then("^User verifies accrued fees as 0.00$")
		public void VerifyAccruedFeeAndCheckWaiveFee() throws Throwable {
			optumPaySol.verifyAccruedFeeAndCheckWaiveFeeButton();
		}
		
		@Then("^User clicks cancel button$")
		public void UserClicksCancelButton() throws Throwable {
			optumPaySol.clickCancelButton();
		}

		
		@Then("^User selects waived fee reason \"([^\"]*)\" and click continue$")
		public void UserSelectWaivedFeeReasonClickContinue(String reason) throws Throwable {
			optumPaySol.selectWaivedFeeReason(reason);
		}
		//Piyush
		@Then("^User selects waived fee reason \"([^\"]*)\" from dropdown$")
		public void UserSelectWaivedFeeReason(String reason) throws Throwable {
			optumPaySol.selectWaivedFeeReasonOnly(reason);
			if(reason.contains("Other"))
			{
				optumPaySol.verifySelectOptionReasonText();
			}
		}
	
		//Piyush
		@Then("^User Provides \"([^\"]*)\" in message box for \"([^\"]*)\" if \"([^\"]*)\" is other$")
		public void UserEnterMessageInText(String ReasonMessage, String ScenarioType,String waivedFeeReason)
		{
			if(waivedFeeReason.contains("Other") && ScenarioType.equalsIgnoreCase("PositiveMessage"))
			{
				optumPaySol.verifyPositiveScenarioForMessage(ReasonMessage);
			}	
			else if(waivedFeeReason.contains("Other") && ScenarioType.equalsIgnoreCase("NegativeMessage")) {
				optumPaySol.verifyNegativeScenarioForMessage(ReasonMessage);
				
			}
		}
		
		//Piyush
		@Then("^Verify Continue button is enable for \"([^\"]*)\" mentioned$")
		public void UserEnterMessageInText(String ScenarioType)
		{
			if(ScenarioType.equalsIgnoreCase("PositiveMessage"))
				optumPaySol.verifyContinueEnable();
			
		}
		
		
		@Then("^User confirms waived fee and proceed$")
		public void user_confirms_waived_fee() throws Throwable {
			optumPaySol.confirmAndProceedWaiveFee();
		}
		@Then("^User verify waive fees pending$")
		public void user_verify_waive_fee_pending() throws Throwable {
			optumPaySol.verifyWaiveFeePending();
		}
		
		@Then("^User Selects Waive Partail amount radio button$")
		public void UserSelectWaivePartailAmount() throws Throwable {
			optumPaySol.selectWaivePartailAmount();
		}
		@Then("^Verify that field is displayed called Enter partial dollar amount and Verify \"([^\"]*)\" as per \"([^\"]*)\" data in text box$")
		//@Then("^Verify that field is displayed called Enter partial dollar amount and Enter data as \"([^\"]*)\" in text box$")
		public void VerifyFieldEnterPartialDollarAmount(String ErrorMessage,String ScenarioType) throws Throwable {
			
			optumPaySol.verifyEnterPartialDollarAmount();
			optumPaySol.enterPartialAmount(ErrorMessage,ScenarioType);
		}
		
		@Then("^User verify waive fees button disabled$")
		public void user_verify_waive_fee_button_disabled() throws Throwable {
			optumPaySol.verifyWaiveFeesButtonDisabled();
		}

	@And("The accrued fee is abovezero")
	public void the_accrued_fee_is_aboveZero() throws InterruptedException {
		optumPaySol.accruedFeeIsAboveZero();
	}

	@And("Request for waive full fee is not in the process")
	public void request_for_waive_full_fee_is_not_in_the_process() {
		optumPaySol.waiveFullFeeIsNotInProgress();
	}

	@Then("The system shall display the following-1. Display the Waive fees button as enabled under the Fees card")
	public void the_system_shall_display_the_following() {
		optumPaySol.waiveFeeButtonVisibility();
	}


	@And("The accrued fee is zero")
	public void theAccruedFeeIsZero() {
		optumPaySol.accruedFeeIsZero();
	}



	@When("The user clicks on the Waive fees button")
	public void theUserClicksOnTheWaiveFeesButton() {
	optumPaySol.waiveFeeButtonClick();
	}

	@Then("The system shall display and allow the user to do the following actions:Preselected Full fee, disabled partial fee, total amount displayed, dropdown options")
	public void theSystemShallDisplayAndAllowTheUserToDoTheFollowingActionsPreselectedFullFeeDisabledPartialFeeTotalAmountDisplayedDropdownOptions(){
	optumPaySol.partialDisabledAndFullSelectedAndOptionsGivenAndFullAmountShownVerifier();
	}
	@Then("^User hover over purple dots$")
	public void user_hover_over_purple_dots() throws Throwable {
	    optumPaySol.hoveroverpurpledots();
	}
	
	
	@Then("^User clicks on Set up recurring payments button$")
	public void user_clicks_on_Set_up_recurring_payments_button() throws Throwable {
		optumPaySol.clickRecPay();
	}

	@Then("^User clicks on Continue button of welcome to recurring payments$")
	public void user_clicks_on_Continue_button_of_welcome_to_recurring_payments() throws Throwable {
		optumPaySol.clicContinuebutofRecPay();
	}

	@Then("^User selects Tins from the TIN grid,clicks one of radio button of one Available ACH debit options and Clicks on Assign Account button$")
	public void user_selects_Tins_from_the_TIN_grid_clicks_one_of_radio_button_of_one_Available_ACH_debit_options_and_Clicks_on_Assign_Account_button() throws Throwable {
		optumPaySol.clickTinchkboxes();
	}

	@Then("^verifies that in TIN grid  Account ending and Pay type columns are populated with selected ACH debit options$")
	public void verifies_that_in_TIN_grid_Account_ending_and_Pay_type_columns_are_populated_with_selected_ACH_debit_options() throws Throwable {
		optumPaySol.validateTINgridpopulation();
	}


	
	


	@And("Resets or sets the payments")
	public void resetsOrSetsThePayments() {
		optumPaySol.resetsOrSetsThePayments();
	}

	@And("Sets all payers as primary banking account")
	public void setsAllPayersAsPrimaryBankingAccount() {
	optumPaySol.setsAllPayersAsPrimaryBankingAccount();
	}

	@And("User does click on recurring payment step two continue button")
	public void userDoesClickOnRecurringPaymentStepTwoContinueButton() {
		optumPaySol.userClicksOnRecurringPaymentStepTwoContinueButton();
	}
	@And("User clicks checkboxes aand submit button on step three")
	public void userClicksCheckboxesAandSubmitButtonOnStepThree() {
	optumPaySol.userClicksCheckboxesAandSubmitButtonOnStepThree();
	}
	@Then("User validates the primary bank account entries in the DB")
	public void userValidatesThePrimaryBankAccountEntriesInTheDB() {
	optumPaySol.userValidatesThePrimaryBankAccountEntriesInTheDB();
	}


	@And("Sets all payers as alternating bank account")
	public void setsAllPayersAsAlternatingBankAccount() {
	optumPaySol.setAlternateBankAccount();
	}

	@Then("User validates the alternate bank account entries in the DB")
	public void userValidatesTheAlternateBankAccountEntriesInTheDB() {
	optumPaySol.userValidatesTheAlternateBankAccountEntriesInTheDB();
	}
	@Then("^verifies Recurring Payments Setup Review Selections$")
	public void verifies_Recurring_Payments_Setup_Review_Selections() throws Throwable {
		optumPaySol.ReviewSelection();
	}
	@Then("^User clicks on Manage pay methods button on invoices tab$")
	public void user_clicks_on_Manage_pay_methods_button_on_invoices_tab() throws Throwable {
	   optumPaySol.Setuprecurringpayments();
	}
	@Then("^User validates that Recurring Payment exemption is present with and Status,setupby,Activation date and enabled Review invoices button$")
	public void user_validates_that_Recurring_Payment_exemption_is_present_with_and_Status_setupby_Activation_date_and_enabled_Review_invoices_button() throws Throwable {
		optumPaySol.validateRecurrDashboard();
	}
	@Then("^User validates that Recurring Payment exemption is not present on the OPS dashboard$")
	public void user_validates_that_Recurring_Payment_exemption_is_not_present_on_the_OPS_dashboard() throws Throwable {
		optumPaySol.validateRecurrDashboard();
	}

	@Then("^Users enters same AC No and RTN No on popup of alternate bank ac and validate error message$")
	public void users_enters_same_AC_No_and_RTN_No_on_popup_of_alternate_bank_ac_and_validate_error_message() throws Throwable {
		optumPaySol.enterSameRoutingAndAccountNo();
	}

	@Then("User validates if request and remove exemption section is displayed accordingly")
	public void userValidatesIfRequestAndRemoveExemptionSectionIsDisplayedAccordingly() {
	optumPaySol.exemptionSectionValidatorCSR_RO_RW();
	}

	@Then("User validates if exemption section is not displayed for basic and VO")
	public void userValidatesIfExemptionSectionIsNotDisplayedForBasicAndVO() {
	optumPaySol.basic_VO_TinExemptionValidator();

	}

	@Then("^User selects the unpaid invoice$")
	public void user_selects_the_unpaid_invoice() throws Throwable {
	    optumPaySol.payInvoice();
	}
	@Then("^user verifies the confirmation screen$")
	public void user_verifies_the_confirmation_screen() throws Throwable {
	    optumPaySol.validateConfirmationScreen();
	}
	
	@Then("^user validates unpaid invoices flow in Adjustment tab$")
	public void user_validates_unpaid_invoices_flow_in_Adjustment_tab() throws Throwable {
	    optumPaySol.validateUnpaidInvoiceFlow().validateSelectedInvoicesTable().validateAdjustmentdetailsSection();
	}
	@Then("^User clicks on Manage pay methods button on CSR Invoices Tab$")
	public void user_clicks_on_Manage_pay_methods_button_on_CSR_Invoices_Tab() throws Throwable {
	  optumPaySol.Managepaymethod();
	}
	@Then("^User validates the Alternate bank account information based \"([^\"]*)\"$")
	public void user_validates_the_Alternate_bank_account_information_based(String credentials) throws Throwable {
		optumPaySol.ReviewingAlternateBankAccountInformation(credentials);
	    
	}


}


