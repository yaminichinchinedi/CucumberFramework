package main.java.stepDefinitions.SearchRemittance;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Utils.sFTPAccess;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchRemittance;

public class SearchRemittanceSteps extends TestBase{
	
	private TestBase testConfig=TestBase.getInstance();
	SearchRemittance srchRemittance = new SearchRemittance(testConfig);
	
	@Then("^User validates EPRA pdf link is present and clicks on EPRA when \"([^\"]*)\" and validate a new window is open with appropriate Text and Hover msg is displayed\\.$")
	public void user_validates_EPRA_pdf_link_is_present_and_clicks_on_EPRA_when_and_validate_a_new_window_is_open_with_appropriate_Text_and_Hover_msg_is_displayed(String srchCriteria) throws Throwable {
		
		srchRemittance.clickEpraPDFLink(srchCriteria);
	}
	
	@Then("^validate Claim_Count and Priority is set accordingly\\.$")
	public void validate_Claim_Count_and_Priority_is_set_accordingly() throws Throwable {
		
		Browser.wait(testConfig, 5);
		srchRemittance.verifyEpraClaimCntAndPriority();
	}
	
	@Then("^validate Claim_Count and Priority is set accordingly based on \"([^\"]*)\" for Search Remit Page$")
	public void validate_Claim_Count_and_Priority_is_set_accordingly_based_on_for_Search_Remit_Page(String arg1) throws Throwable {
	   
		Browser.wait(testConfig, 5);
		srchRemittance.verifyEpraClaimCntAndPrioritySrch();
	}
	
	@Then("^validate Claim_Count and Priority is set accordingly based on \"([^\"]*)\"$")
	public void validate_Claim_Count_and_Priority_is_set_accordingly_based_on(String srchCriteria) throws Throwable {
	    
		Browser.wait(testConfig, 5);
		srchRemittance.verifyEpraClaimCntAndPriority(srchCriteria);
	}


	@Then("^validate new Entry is created in Ole\\.EPRA_STATUS with C status for Consol_Pay_Nbr$")
	public void validate_new_Entry_is_created_in_Ole_EPRA_STATUS_with_C_status_for_Consol_Pay_Nbr() throws Throwable {
		
		Browser.wait(testConfig, 8);
		srchRemittance.verifyEpraStatus("C");
		//srchRemittance.getPDFfileNameEPRA();
	}
	
	@Then("^validate new Entry is created in Ole\\.EPRA_STATUS with appropriate status for Consol_Pay_Nbr$")
	public void validate_new_Entry_is_created_in_Ole_EPRA_STATUS_with_appropriate_status_for_Consol_Pay_Nbr() throws Throwable {
		Browser.wait(testConfig, 8);
		srchRemittance.verifyEpraStatus("viewPayments",10);
		srchRemittance.getPDFfileNameEPRA();
		
	}
	
	@Then("^validate PDF link is changed to PDF icon and is enabled and is downloadable for \"([^\"]*)\"\\.$")
	public void validate_PDF_link_is_changed_to_PDF_icon_and_is_enabled_and_is_downloadable_for(String srchBy) throws Throwable {
		
		Browser.browserRefresh(testConfig);
		Browser.wait(testConfig, 5);
		srchRemittance.verifyEpraPdfIcon(srchBy);
	}

	@Then("^validate download status is set to Y in Ole\\.EPRA_STATUS$")
	public void validate_download_status_is_set_to_Y_in_Ole_EPRA_STATUS() throws Throwable {
		
		Browser.wait(testConfig, 5);
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
		
		Browser.wait(testConfig, 10);
		srchRemittance.verifyEpraPdfIcon(srchBy);
		//srchRemittance.verifyEpraDownloadStatus("Y");
	}
	
	@Then("^validate PDF icon is enabled and is downloadable\\.$")
	public void validate_PDF_icon_is_enabled_and_is_downloadable() throws Throwable {
		
		Browser.wait(testConfig, 10);
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
		Browser.wait(testConfig, 8);
		srchRemittance.verifyppraStatus(Status);
		srchRemittance.getPDFfileName();
}
	@Then("^Validate PDF file placed over NAS Drive for date \"([^\"]*)\"$")
	public void validate_PDF_file_placed_over_NAS_Drive_for_date(String Date) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	    sFTPAccess obj_FTPaccess = new sFTPAccess();		
		//Connecting to sFTP location
		obj_FTPaccess.connect();		
		//Calling isFileAvailable function to validate file presence
		System.getProperty("Tin").substring(0,2);
		srchRemittance.getPDFfileName();
		System.out.print("----File name using get property-->"+System.getProperty("PDFFileName"));
		if(obj_FTPaccess.IsFileAvailable("/home/ppsstg/stg/meob/regular/"+System.getProperty("Tin").substring(0,2)+"/"+System.getProperty("Tin")+"/"+Date+"",System.getProperty("PDFFileName")))
		{
			System.out.print("*File Available*");
		}
		//Closing sFTP connection
		obj_FTPaccess.Closeconnection();		
	}
	
	@Then("^User Delete PDf file placed over NAS drive  for date \"([^\"]*)\"$")
	public void user_Delete_PDf_file_placed_over_NAS_drive_for_date(String Date) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		sFTPAccess obj_FTPaccess = new sFTPAccess();		
		//Connecting to sFTP location
		obj_FTPaccess.connect();		
		//Calling isFileAvailable function to validate file presence
	
		//srchRemittance.getPDFfileName();
		System.out.print("----File name using get property-->"+System.getProperty("PDFFileName"));
		
		if(obj_FTPaccess.IsFileAvailable("/home/ppsstg/stg/meob/regular/"+System.getProperty("Tin").substring(0,2)+"/"+System.getProperty("Tin")+"/"+Date+"",System.getProperty("PDFFileName")))
		{
			obj_FTPaccess.DeleteFile_FileNameAppended("/home/ppsstg/stg/meob/regular/"+System.getProperty("Tin").substring(0,2)+"/"+System.getProperty("Tin")+"/"+Date+"/"+System.getProperty("PDFFileName"));
		}
		//Closing sFTP connection
		obj_FTPaccess.Closeconnection();				
		
	}
}
