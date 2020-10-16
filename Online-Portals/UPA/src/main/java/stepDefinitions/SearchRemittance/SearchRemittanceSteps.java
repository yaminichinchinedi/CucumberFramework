package main.java.stepDefinitions.SearchRemittance;

import cucumber.api.java.en.Then;
import main.java.Utils.SFTPAccess;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchRemittanceSearchCriteria;
import main.java.reporting.Log;

public class SearchRemittanceSteps extends TestBase{
	
	private TestBase testConfig=TestBase.getInstance();
	SearchRemittance srchRemittance = new SearchRemittance(testConfig);
	String NASLocation=System.getProperty("NASLocation_"+System.getProperty("env"));
	
	@Then("^User validates EPRA pdf link is present and clicks on EPRA when \"([^\"]*)\" and validate a new window is open with appropriate Text and Hover msg is displayed\\.$")
	public void user_validates_EPRA_pdf_link_is_present_and_clicks_on_EPRA_when_and_validate_a_new_window_is_open_with_appropriate_Text_and_Hover_msg_is_displayed(String srchCriteria) throws Throwable {
		
		if (srchCriteria.equals("viewPayments"))
		srchRemittance.clickEpraPDFLink(srchCriteria);
		else
		srchRemittance.clickEpraPDFLinkSrchRemit(srchCriteria);
			
	}
	
	@Then("^validate Claim_Count and Priority is set accordingly\\.$")
	public void validate_Claim_Count_and_Priority_is_set_accordingly() throws Throwable {
		
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraClaimCntAndPriority();
	}
	
	@Then("^validate Claim_Count and Priority is set accordingly based on \"([^\"]*)\" for Search Remit Page$")
	public void validate_Claim_Count_and_Priority_is_set_accordingly_based_on_for_Search_Remit_Page(String arg1) throws Throwable {
	   
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraClaimCntAndPrioritySrch();
	}
	
	@Then("^validate Claim_Count and Priority is set accordingly based on \"([^\"]*)\"$")
	public void validate_Claim_Count_and_Priority_is_set_accordingly_based_on(String srchCriteria) throws Throwable {
	    
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraClaimCntAndPriority(srchCriteria);
	}


	@Then("^validate new Entry is created in Ole\\.EPRA_STATUS with C status for Consol_Pay_Nbr$")
	public void validate_new_Entry_is_created_in_Ole_EPRA_STATUS_with_C_status_for_Consol_Pay_Nbr() throws Throwable {
		
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraStatus("C");
		//srchRemittance.getPDFfileNameEPRA();
	}
	
	
	@Then("^validate new Entry is created in Ole\\.EPRA_STATUS with C status for Search Remit Page$")
	public void validate_new_Entry_is_created_in_Ole_EPRA_STATUS_with_C_status_for_Search_Remit_Page() throws Throwable {
	    
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraStatusSrchRemit("C");
	}
	
	@Then("^validate new Entry is created in Ole\\.EPRA_STATUS with appropriate status for Consol_Pay_Nbr$")
	public void validate_new_Entry_is_created_in_Ole_EPRA_STATUS_with_appropriate_status_for_Consol_Pay_Nbr() throws Throwable {
		Browser.wait(testConfig, 8);
		srchRemittance.verifyEpraStatus("viewPayments",10);
		//srchRemittance.getPDFfileNameEPRA();
		
	}
	@Then("^validate PDF link is changed to PDF icon and is enabled and is downloadable for \"([^\"]*)\"\\.$")
	public void validate_PDF_link_is_changed_to_PDF_icon_and_is_enabled_and_is_downloadable_for(String srchBy) throws Throwable {
		
		Browser.browserRefresh(testConfig);
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraPdfIcon(srchBy);
	}

	@Then("^validate download status is set to Y in Ole\\.EPRA_STATUS$")
	public void validate_download_status_is_set_to_Y_in_Ole_EPRA_STATUS() throws Throwable {
		
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraDownloadStatus("Y");
	}

	@Then("^validate record is inserted in User_Event_Log\\.$")
	public void validate_record_is_inserted_in_User_Event_Log() throws Throwable {
		
		srchRemittance.verifyUsrEvntLog();
	}
	
	@Then("^validate Entry exist in Ole\\.EPRA_STATUS with C status for Consol_Pay_Nbr$")
	public void validate_Entry_exist_in_Ole_EPRA_STATUS_with_C_status_for_Consol_Pay_Nbr() throws Throwable {
		
		srchRemittance.verifyEpraStatus("C");
	}
	
	@Then("^validate PDF icon is enabled and is downloadable for \"([^\"]*)\"\\.$")
	public void validate_PDF_icon_is_enabled_and_is_downloadable_for(String srchBy) throws Throwable {
		
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraPdfIcon(srchBy);
		//srchRemittance.verifyEpraDownloadStatus("Y");
	}
	
	@Then("^validate PDF icon is enabled and is downloadable\\.$")
	public void validate_PDF_icon_is_enabled_and_is_downloadable() throws Throwable {
		
		Browser.wait(testConfig, 2);
		srchRemittance.verifyEpraDownloadStatus("Y");
	}
	
	@Then("^validate new Entry is created in Ole\\.EPRA_STATUS with E status for Consol_Pay_Nbr$")
	public void validate_new_Entry_is_created_in_Ole_EPRA_STATUS_with_E_status_for_Consol_Pay_Nbr() throws Throwable {
		
		srchRemittance.verifyEpraStatus("E");
	}

	@Then("^validate PDF link is not changed to PDF icon\\.$")
	public void validate_PDF_link_is_not_changed_to_PDF_icon() throws Throwable {
		
		srchRemittance.verifyNoEpraPdfIcon();
	}
	
	@Then("^User clicks on Payment Number when \"([^\"]*)\" and validate Remittance Detail page is opened\\.$")
	public void user_clicks_on_Payment_Number_when_and_validate_Remittance_Detail_page_is_opened(String srchCriteria) throws Throwable {
		
		srchRemittance.clickPaymentNumber(srchCriteria);
	}
	
	@Then("^validate record is inserted in User_Event_Log for Remittance Detail$")
	public void validate_record_is_inserted_in_User_Event_Log_for_Remittance_Detail() throws Throwable {
	    
		srchRemittance.verifyUsrEvntLogRemitDetail();
	}
	
	@Then("^validate record is inserted in User_Event_Log for \"([^\"]*)\"$")
	public void validate_record_is_inserted_in_User_Event_Log_for(String usertype) throws Throwable {
	    
		srchRemittance.verifyUsrEvntLogForSrchRemit(usertype);
	}
	
	@Then("^validate record is inserted in User_Event_Log for Remittance Detail for CSR \"([^\"]*)\"$")
	public void validate_record_is_inserted_in_User_Event_Log_for_Remittance_Detail_for_CSR(String userType) throws Throwable {
	    
		srchRemittance.verifyUsrEvntLogRemitDetailCSR(userType);
	}
	@Then("^User validates EPRA file is present in NAS Drive and delete it in both EPRA_STATUS Table, Nas Drive$")
	public void user_validates_EPRA_file_is_present_in_NAS_Drive_and_delete_it_in_both_EPRA_STATUS_Table_Nas_Drive() throws Throwable {
	    
		srchRemittance.verifyfileinNASDrive();
	}

	@Then("^User Validates Ole\\.PPRA_STATUS status for Consol_Pay_Nbr \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void user_Validates_Ole_PPRA_STATUS_status_for_Consol_Pay_Nbr_should_be(String Consol_Pay_Number, String Status) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("CONSL_PAY_NBR", Consol_Pay_Number);
		testConfig.putRunTimeProperty("CONSL_PAY_NBR",Consol_Pay_Number);
		Browser.wait(testConfig, 15);
		//srchRemittance.verifyppraStatus(Status);
		if(Status.equalsIgnoreCase("C"))
		{
			srchRemittance.getPDFfileName();
		}
}
	@Then("^Validate PDF file placed over NAS Drive for date \"([^\"]*)\"$")
	public void validate_PDF_file_placed_over_NAS_Drive_for_date(String Date) throws Throwable {
	  
		//Connecting to sFTP location
	    SFTPAccess obj_FTPaccess = new SFTPAccess();		
		obj_FTPaccess.connect();		
		
		//Calling isFileAvailable function to validate file presence
		System.getProperty("Tin").substring(0,2);
		srchRemittance.getPDFfileName();
		Log.Pass("File name is : "+ System.getProperty("PDFFileName"));
		if(obj_FTPaccess.IsFileAvailable(NASLocation+System.getProperty("Tin").substring(0,2)+"/"+System.getProperty("Tin")+"/"+Date+"",System.getProperty("PDFFileName")))
			Log.Pass("File is Available");
		
		//Closing sFTP connection
		obj_FTPaccess.Closeconnection();		
	}
	
	@Then("^User Delete PDf file placed over NAS drive  for date \"([^\"]*)\"$")
	public void user_Delete_PDf_file_placed_over_NAS_drive_for_date(String Date) throws Throwable {
		
		SFTPAccess obj_FTPaccess = new SFTPAccess();		
		obj_FTPaccess.connect();		
		//srchRemittance.getPDFfileName();
		Log.Pass("File name using get property  is "+System.getProperty("PDFFileName"));
		if(obj_FTPaccess.IsFileAvailable(NASLocation+System.getProperty("Tin").substring(0,2)+"/"+System.getProperty("Tin")+"/"+Date+"",System.getProperty("PDFFileName")))
			obj_FTPaccess.DeleteFile_FileNameAppended(NASLocation+System.getProperty("Tin").substring(0,2)+"/"+System.getProperty("Tin")+"/"+Date+"/"+System.getProperty("PDFFileName"));
		//Closing sFTP connection
		obj_FTPaccess.Closeconnection();				
		
	}
	
    @Then("^Validate the EPRA and Payer PRA column in Search Remittance Page for \"([^\"]*)\"$")
    public void validate_the_EPRA_and_Payer_PRA_column_in_Search_Remittance_Page_for(String credentials) throws Throwable {
    	srchRemittance.verifyEPRAAndPayerPRA(credentials);
    }
    
    @Then("^verify search results for \"([^\"]*)\"$")
    public void verify_search_results_for(String criteriaType) throws Throwable {
    	srchRemittance.verifySearchResults(criteriaType);
    }
    

    @Then("^verify search results sorting for \"([^\"]*)\"$")
    public void verify_search_results_sorting_for(String criteriaType) throws Throwable {
    	srchRemittance.verifySorting(criteriaType);
    }
    
    @Then("^verify pagination in search results$")
    public void verify_pagination_in_search_results() throws Throwable {
    	srchRemittance.verifyPagination();
    }
    
    @Then("^verify payment status for <\"([^\"]*)\"> in search results$")
    public void verify_payment_status_for_in_search_results(String paymentType) throws Throwable {
    	srchRemittance.verifyPaymentStatus(paymentType);
    }
    
    @Then("^User verifies returned reason for \"([^\"]*)\" in search results$")
    public void User_verifies_returned_reason_for_in_search_results(String criteriaType) throws Throwable {
    	srchRemittance.verifyReturnedReasonDisplayed(criteriaType);
    }



	@Then("^Validate in Grid search Results,Type column or Payment Status field not displayed and is relabeled to ACH Trace$")
	public void validate_in_Grid_search_Results_Type_column_or_Payment_Status_field_not_displayed_and_is_relabeled_to_ACH_Trace() throws Throwable {
		srchRemittance.verifyColumnPresent("ACH Trace Number").verifyColumnIsNotPresent("Type").verifyColumnIsNotPresent("Payment Status / Trace Number");
	}

	@Then("^Validate Claim Count column is present which appears as Hyperlink for nonzero claim count and on click redirects to Remittance Detail page$")
	public void validate_Claim_Count_column_is_present_which_appears_as_Hyperlink_for_nonzero_claim_count_and_on_click_redirects_to_Remittance_Detail_page() throws Throwable {
		srchRemittance.verifyClaimCountHyperlink("Claim Count","Search Remittance");
	}

	@Then("^Validate ePRA,pPRA and (\\d+) fields are enabled$")
	public void validate_ePRA_pPRA_and_fields_are_enabled(int arg1) throws Throwable {
		srchRemittance.verify835EPRAlink("Search Remittance");
	}

	@Then("^Validate Archived Coulmn,Save Archived button is relabeled to Payment Status and Save button respectively$")
	public void validate_Archived_Coulmn_Save_Archived_button_is_relabeled_to_Payment_Status_and_Save_button_respectively() throws Throwable {
		srchRemittance.verifyColumnPresent("Payment Status").verifyColumnIsNotPresent("Archive").verifySaveBtnRelabled(); 

	}

	@Then("^Validate that Search Criertia box do not contain hyphen following colon on each search criteria option$")
	public void validate_that_Search_Criertia_box_do_not_contain_hyphen_following_colon_on_each_search_criteria_option() throws Throwable {
		srchRemittance.validateHyfen();
	}
}
