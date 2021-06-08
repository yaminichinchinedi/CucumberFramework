package main.java.stepDefinitions.OptumPaySolution;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.OptumPaySolution;
import main.java.reporting.Log;


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


}


