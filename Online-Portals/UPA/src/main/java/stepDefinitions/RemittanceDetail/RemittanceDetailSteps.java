package main.java.stepDefinitions.RemittanceDetail;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.SearchRemittance;

public class RemittanceDetailSteps extends TestBase {
	
    RemittanceDetail remitDetail = new RemittanceDetail(testConfig);
    SearchRemittance searchRemittance =  new SearchRemittance(testConfig);

	@Then("^Validate all Headers in the Page$")
	public void validate_all_Headers_in_the_Page() throws Throwable {
	    
		remitDetail.verifyAllHeaders();
	}

	@Then("^Validate Column Headers in the Page$")
	public void validate_Column_Headers_in_the_Page() throws Throwable {
	   
		remitDetail.verifyColumnHeaders();
	}

	@Then("^Validate Download, Print, Return buttons in Remit Page$")
	public void validate_Download_Print_Return_buttons_in_Remit_Page() throws Throwable {
	   
		remitDetail.verifyBottomHeaders();
	}

    @When("^Verify Pagination functionality$")
	public void verify_Pagination_functionality() throws Throwable {
	 
		remitDetail.verifyRemitPaginationOptions();
	}
	
	@Then("^Check RMK Code Pop Up$")
	public void check_RMK_Code_Pop_Up() throws Throwable {
	    
		remitDetail.verifyRMKCode();
		
	}
    
    @Then("^Check Adj Reason Code Pop Up$")
    public void check_Adj_Reason_Code_Pop_Up() throws Throwable {
    
    	remitDetail.verifyADJCode();
    }
    
    @Then("^Verify Remittance Detail Online vs FISL Response$")
	public void verify_Remittance_Detail_Online_vs_FISL_Response() throws Throwable {
    	
    	remitDetail.verifyRemittancePageData();
    }
    
    @When("^Verify Remittance Detail Online vs FISL Response for UPA$")
    public void verify_Remittance_Detail_Online_vs_FISL_Response_for_UPA() throws Throwable {
       
    	remitDetail.verifyRemittancePageDataUPA();
    }
    
    @When("^Verify Remittance Detail Online vs FISL Response \"([^\"]*)\"$")
	public void verify_Remittance_Detail_Online_vs_FISL_Response(String srchCriteria) throws Throwable {
	   
		remitDetail.verifyRemittancePageDataSerachCriteria(srchCriteria);
	}

    @When("^Verify FISL Response for COB Only Filter Claim$")
	public void verify_FISL_Response_for_COB_Only_Filter_Claim() throws Throwable {
    	
    	remitDetail.verifyCOBFilterClaimData();
    }

    @Then("^Verify FISL Response for COB Only Filter Claim for \"([^\"]*)\"$")
    public void verify_FISL_Response_for_COB_Only_Filter_Claim_for(String usertype) throws Throwable {
        
    	remitDetail.verifyCOBFilterClaimData(usertype);
    }
    
    @Then("^Verify FISL Response for Reversal Only Filter Claim for \"([^\"]*)\"$")
    public void verify_FISL_Response_for_Reversal_Only_Filter_Claim_for(String usertype) throws Throwable {
        
    	remitDetail.verifyReversalFilterClaimData(usertype);
    }
    
    @When("^Validate Payment with Multiple PLB Adjustments$")
    public void validate_Payment_with_Multiple_PLB_Adjustments() throws Throwable {
       
    	remitDetail.verifyMultiplePLBAdj();
    }
    
    @Then("^Validate Payment with Multiple PLB Adjustments for UPA$")
    public void validate_Payment_with_Multiple_PLB_Adjustments_for_UPA() throws Throwable {
   
	   remitDetail.verifyMultiplePLBAdjUPA();
   }

    @When("^Validate PLB Adjustment Only$")
    public void validate_PLB_Adjustment_Only() throws Throwable {
        
    	remitDetail.verifyPLBAdjOnly();
    }
    
    @Then("^Validate PLB Adjustment Only for UPA$")
    public void validate_PLB_Adjustment_Only_for_UPA() throws Throwable {
       
    	remitDetail.verifyPLBAdjOnlyUPA();
    }
    
    @Then("^Validate PLB Adjustment Only for UPA for Payer$")
    public void validate_PLB_Adjustment_Only_for_UPA_for_Payer() throws Throwable {
     
    	remitDetail.verifyPLBAdjOnlyPayer();
    }

    
//    @When("^Validate Sort By - Patient Last Name$")
//    public void validate_Sort_By_Patient_Last_Name() throws Throwable {
//       
//    	remitDetail.verifySortByPatientLastName();
//    }
//    
    @Then("^Validate Sort By - Patient Last Name for \"([^\"]*)\"$")
    public void validate_Sort_By_Patient_Last_Name_for(String usertype) throws Throwable {
        
    	remitDetail.verifySortByPatientLastName(usertype);
    }

//    
//    @Then("^Validate Sort By - Rendering Provider Last Name$")
//    public void validate_Sort_By_Rendering_Provider_Last_Name() throws Throwable {
//       
//    	remitDetail.verifySortByRendPrvdrLastName();
//    }
    
    @Then("^Validate Sort By - Rendering Provider Last Name for \"([^\"]*)\"$")
    public void validate_Sort_By_Rendering_Provider_Last_Name_for(String usertype) throws Throwable {
        
    	remitDetail.verifySortByRendPrvdrLastName(usertype);
    }

    
    @When("^Validate Tricare Masking$")
    public void validate_Tricare_Masking() throws Throwable {
       
    	remitDetail.verifyTricareMasking();
    }
    
    @Then("^User enters tin for Mutliple PLB Adjustments Criteria$")
    public void user_enters_tin_for_Mutliple_PLB_Adjustments_Criteria() throws Throwable {
        
    	remitDetail.enterTINMultiplePLBAdj();
    	
    }
    
    @Then("^User enter tin for CSR Search Remittance Page for \"([^\"]*)\" through \"([^\"]*)\" and click on continue button$")
    public void user_enter_tin_for_CSR_Search_Remittance_Page_for_through_and_click_on_continue_button(String searchBy,String usertype) throws Throwable {
       
    	remitDetail.enterTinCSR(searchBy, usertype);
    }
    
    @Then("^User enters tin for Mutliple PLB Adjustments Criteria for UPA$")
    public void user_enters_tin_for_Mutliple_PLB_Adjustments_Criteria_for_UPA() throws Throwable {
        
    	remitDetail.enterTINMultiplePLBAdjUPA();
    }

    @Then("^User enters tin for PLB Adjustment Only Criteria$")
    public void user_enters_tin_for_PLB_Adjustment_Only_Criteria() throws Throwable {
       
    	remitDetail.enterTINPLBOnlyAdj();
    }
    
    @Then("^User enters tin for PLB Adjustment Only Criteria for UPA$")
	public void user_enters_tin_for_PLB_Adjustment_Only_Criteria_for_UPA() throws Throwable {
	   
		remitDetail.enterTINPLBOnlyAdjUPA();
	}
	    
    @Then("^Enter Electronic Number for Mutliple PLB Adjustments Criteria$")
    public void enter_Electronic_Number_for_Mutliple_PLB_Adjustments_Criteria() throws Throwable {
        
    	remitDetail.enterElectronicNumForMultiplePLBCriteria();
    }
    
    @Then("^Enter Electronic Number for Adjustment Only Criteria$")
    public void enter_Electronic_Number_for_Adjustment_Only_Criteria() throws Throwable {
 
    	remitDetail.enterElectronicNumForPLBOnlyCriteria();
    }
   
    @Then("^User enters tin for Tricare Masking Criteria$")
    public void user_enters_tin_for_Tricare_Masking_Criteria() throws Throwable {
        
    	remitDetail.enterTINForTricareMask();
    }
    
    @Then("^User enters tin for Tricare Masking Criteria for UPA$")
    public void user_enters_tin_for_Tricare_Masking_Criteria_for_UPA() throws Throwable {
        
    	remitDetail.enterTINForTricareMaskUPA();
    }
    
    @Then("^Enter Electronic Number for Tricare Masking Criteria$")
    public void enter_Electronic_Number_for_Tricare_Masking_Criteria() throws Throwable {
       
    	remitDetail.enterElectronicNumForTricareMaskCriteria();
    }

    @Then("^User clicks on print request button present on Remittance Detail screen\\.$")
	public void user_clicks_on_print_request_button_present_on_Remittance_Detail_screen() throws Throwable {
    	remitDetail.clickPrintRequestButton();
	}
	
	@Then("^User clicks on Print Available button on Remittance Detail screen\\.$")
	public void user_clicks_on_Print_Available_button_on_Remittance_Detail_screen() throws Throwable {
		remitDetail.clickPrintButton();
	}
	
	@When("^Verify Remittance Detail Online vs FISL Response for UPA_Payer$")
	public void verify_Remittance_Detail_Online_vs_FISL_Response_for_UPA_Payer() throws Throwable {
	    
		remitDetail.verifyRemittancePageDataUPAPayer();
	}
	
	@Then("^Validate all Headers in the Page for Payer$")
	public void validate_all_Headers_in_the_Page_for_Payer() throws Throwable {
	   
		remitDetail.verifyAllHeadersPayer();
	}
	
    @Then("^Validate Column Headers in the Page for Payer$")
    public void validate_Column_Headers_in_the_Page_for_Payer() throws Throwable {
   
	   remitDetail.verifyColumnHeadersPayer();
     }

	@Then("^Validate Download, Print, Return buttons in Remit Page for Payer$")
	public void validate_Download_Print_Return_buttons_in_Remit_Page_for_Payer() throws Throwable {
	    
		remitDetail.verifyBottomHeadersPayer();
	}
	
	@Then("^Enter Electronic Number for Adjustment Only Criteria for Payer$")
	public void enter_Electronic_Number_for_Adjustment_Only_Criteria_for_Payer() throws Throwable {
	   
		remitDetail.enterElectronicNumForPLBOnlyPayer();
	}

	@Then("^click Payment Number in Search Remit Page$")
	public void click_Payment_Number_in_Search_Remit_Page() throws Throwable {
	   
		remitDetail.clickPayNum();
	}
	
	 @Then("^Verify Remittance Detail Online vs FISL Response for \"([^\"]*)\"$")
	    public void verify_Remittance_Detail_Online_vs_FISL_Response_for(String usertype) throws Throwable {
	       
	    	remitDetail.verifyRemittancePageDataUPA(usertype);
	    }
	
	 @Then("^Validate that Payer/Patient column name is changed to Payer$")
	 public void validate_that_Payer_Patient_column_name_is_changed_to_Payer() throws Throwable {
		 searchRemittance.verifyPayerText();
	 }

	 @Then("^Enter Check Number and click search$")
	 public void enter_Check_Number_and_click_search() throws Throwable {
		 remitDetail.enterCheckNumber();
	 }

	
	@Then("^Click on Payment Number Link and Validate the Download (\\d+) option is displayed$")
	public void click_on_Payment_Number_Link_and_Validate_the_Download_option_is_displayed(int arg1) throws Throwable {
		remitDetail.verifyDownload835();
    }
 
	@Then("^Validate Column Headers in the grid for remittance detail Page$")
	public void validate_Column_Headers_in_the_grid_for_remittance_detail_Page() throws Throwable {
		remitDetail.verifyHeadersRemittanceDetail();
	}

	@Then("^Enter Electronic Payment Number for Rendering Provider$")
	public void enter_Electronic_Payment_Number_for_Rendering_Provider() throws Throwable {
	   
		remitDetail.enterElecNumForRenderprov();
	}

	@Then("^Enter Electronic Payment Number based on \"([^\"]*)\"$")
	public void enter_Electronic_Payment_Number_based_on(String CriteriaType) throws Throwable {
	   
		remitDetail.verifyRemitPageDataUPA(CriteriaType);
	}
	
	@Then("^validate data in remittance detail screen$")
	public void validate_data_in_remittance_detail_screen() throws Throwable {
		remitDetail.verifyRemittanceDetailScreen();
	}
	
	 @Then("^Click on Claim number on Remittance Detail screen and go to Claim Detail screen\\.$")
	 public void click_on_Claim_number_on_Remittance_Detail_screen_and_go_to_Claim_Detail_screen() throws Throwable {
		 remitDetail.clickClaimNumber();
	 }
	 @Then("^User verifies Print Request and Print Available button is disabled$")
	 public void user_verifies_Print_Request_and_Print_Available_button_is_disabled() throws Throwable {
		 remitDetail.verifyPrintAvilableRequestVisiblity();
	}

	@Then("Verify FISL Response vs Remittance Detail UI")
	public void verifyFISLResponseVsRemittanceDetailUI()
			throws SAXException, ParserConfigurationException, IOException, JAXBException {
		remitDetail.validateFISLvsUI();
	}
	@When("^Validate Payment with PLB Adjustments$")
    public void validate_Payment_with_PLB_Adjustments() throws Throwable {
       
    	remitDetail.validatePLBAdj();
    }
	@And("User Enters TIN for Check Number")
	public void userEntersTINForCheckNumber() {
		remitDetail.enterTINForCheckNumber();
	}
	
	@And("User navigate to search Remittance Detail page and verify content")
	public void User_navigate_to_search_Remittance_Detail_page_and_verify_content() throws Exception {
		remitDetail.verifyingClaimDetailsforRequiredPayemnt();
	}
	
	@Then("^Validate Download, Print, Return buttons in Remit Page when user navigated from view paymemnts$")
	public void validate_Download_Print_Return_buttons_in_Remit_Page_from_view_Payments() throws Throwable {
	    
		remitDetail.verifyButtonOnRemittanceDetailsPageNavigatedFromViewPayments();
	}
	
}
