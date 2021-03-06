package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class PaymentDataFilesCSR extends TestBase
{
	@FindBy(xpath = "//input[@name='taxIndNbr']") 
    WebElement enterTin;
	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement searchBtn;

	@FindBy(xpath = "//li[contains(text(),'Create Data Bundle')]") 
	WebElement createDataBundle;
	@FindBy(xpath = "//td[@class='subheader']")
	WebElement subHeaderCreate;
	@FindBy(xpath = "(//td[@class='subheader'])[2]") 
	WebElement subHeader;
	@FindBy(xpath = "//td[contains(text(),'The Payment Data File feature enables faster and e')]")
	WebElement pageText;
	@FindBy(xpath = "//u[contains(text(),'Detailed Instructions For Bundle Creation')]") 
	WebElement detailedInstrctns;
	@FindBy(xpath = "//td[contains(text(),'Provider:')]")
	WebElement provider;
	@FindBy(xpath = "//td[contains(text(),'Settlement Date Range:')]") 
	WebElement stlDateRange;
	@FindBy(xpath = "//td[contains(text(),'File Types:')]")
	WebElement fileTypes;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='835s']")
	WebElement fileType835;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='Payer PRAs']")
	WebElement fileTypePRA;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='EPRAs']")
	WebElement fileTypeEPRA;
	@FindBy(xpath = "//td[contains(text(),'Payer Selection:')]") 
	WebElement payerSelection;
	@FindBy(xpath = "//input[@value='       Add >      ']")
	WebElement addBtn;
	@FindBy(xpath = "//input[@value='   Add All >>   ']")
	WebElement addAllBtn;
	@FindBy(xpath = "//input[@value='   < Remove    ']")
	WebElement removeBtn;
	@FindBy(xpath = "//input[@value='<< Remove All']") 
	WebElement removeAllBtn;
	@FindBy(xpath = "//input[@value='     Reset     ']")
	WebElement resetBtn;
	@FindBy(xpath = "//select[@name='availablePayers']//option[1]") 
	WebElement firstPayer;
	@FindBy(xpath = "//select[@name='selectedPayers']//option[1]") 
	WebElement selectedFirstPayer;
	@FindBy(xpath = "//select[@name='availablePayers']//option[1]") 
	WebElement availablePayer;
	@FindBy(xpath = "//input[@value='     Submit     ']")
	WebElement btnSubmit;
	@FindBy(xpath = "//th[contains(text(),'Please correct the following fields before submit')]") 
	WebElement errorHeader;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range : From and To Dates are required.')]")
	WebElement settlError;
	@FindBy(xpath = "//font[contains(text(),'Payer Selection : Missing Data')]")
	WebElement payerError;
	@FindBy(xpath = "//font[contains(text(),'File Types : Missing Data')]")
	WebElement fileError;
	@FindBy(name = "eights") 
	WebElement eight35ChkBox;
	@FindBy(id = "pra")
	WebElement praChkbox;
	@FindBy(id = "epra") 
	WebElement epraChkbox;
	@FindBy(name = "setlDateFrom") 
	WebElement fromDate;
	@FindBy(name = "setlDateTo") 
	WebElement toDate;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range : From Date must not be greater than 30 Days prior to To date')]") 
	WebElement settlErrorMore30Days;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range : To and From Dates must be prior to or same as current date.')]")
	WebElement settlmntDatePriorError;
	@FindBy(xpath = "//td[contains(text(),'Your bundle has been successfully submitted.')]") 
	WebElement bundleSubmission;
	@FindBy(xpath = "//li[contains(text(),'Download Data Bundle')]")
	WebElement downloadDataBundle;
	
	@FindBy(xpath = "(//tr[@class='subheadernormal'])[2]")
	WebElement downloadDataBundlePage;
	@FindBy(xpath = "(//a[contains(text(),'View Bundle Detail')])[1]")
	WebElement viewDetailLink;
	@FindBy(xpath = "(//td[@class='runtext'])[1]")
	WebElement bundleFileName;
	@FindBy(xpath = "(//td[@class='runtext'])[2]")
	WebElement bundleFileType;
	
	@FindBy(name = "availablePayers")
	WebElement payerName;
	
	@FindBy(xpath = "//span[contains(text(),'Note: Payer PRAs and EPRAs may not be available for all Payers.')]")
	WebElement payerPRANote;
	
	@FindBy(xpath = "//*[contains(text(),'Data Bundle requests for Patient Payments will be available soon')]")
	WebElement patientPaymentsNote;
	
	@FindBy(xpath="//select[@name='availablePayers']//option")
	List<WebElement> availablePayerList;
	
	@FindBy(xpath="//select[@name='selectedPayers']//option")	
	List<WebElement> selectedPayerList;
	
	public PaymentDataFilesCSR(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.fluentWait(testConfig, addAllBtn, 100, 1, "Add All button");
	}
	
	public PaymentDataFilesCSR verifyCreateDataBundlePage() throws Exception{	
		Helper.compareEquals(testConfig, "Navigation to Create Data Bundle Page", "Create Data Bundle", createDataBundle.getText());
		return this;
	}

	public PaymentDataFilesCSR verifyAllValuesInCreateBundlePage() throws Exception{
		String pageTextExpected = "The Payment Data File feature enables faster and easier access to large amounts of payment data. Using this tool you can create data bundles by day, by file type and by payer.";
		Helper.compareEquals(testConfig, "Subheader message", "Payment Data Files", subHeaderCreate.getText().trim());
		Helper.compareEquals(testConfig, "Subheader message", pageTextExpected, pageText.getText().trim());
		Helper.compareEquals(testConfig, "Subheader message", "Detailed Instructions For Bundle Creation", detailedInstrctns.getText().trim());		
		
		int sqlRow=236;
		testConfig.putRunTimeProperty("Prov_tin_nbr", System.getProperty("tin"));
		Map orgNameDB=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String ProvName = "Provider: "+ orgNameDB.get("ORG_NM").toString().trim();
		Helper.compareEquals(testConfig, "Provider Name", ProvName, provider.getText().trim());		
		Helper.compareEquals(testConfig, "Settlement Date Text", "Settlement Date Range:", stlDateRange.getText().trim());		
		Helper.compareEquals(testConfig, "fileTypes Displaying", "File Types:", fileTypes.getText().trim());	
		Helper.compareEquals(testConfig, "PayerSelection Header", "Payer Selection:", payerSelection.getText().trim());
	   return this;	
	}
	
	public PaymentDataFilesCSR verifyPayerList() throws InterruptedException, Exception
	{				

		List<String> PayerListUI=new ArrayList<>();
		List<WebElement> payer =Element.findElements(testConfig, "xpath", "//select[@name='availablePayers']//option");
				for(int i=1; i<= payer.size(); i++)
		{
			String  Payr = Element.findElement(testConfig, "xpath", "//select[@name='availablePayers']//option["+i+"]").getText().trim();
			PayerListUI.add(Payr);
		}   
		   int sqlRowNo = 1347;
		   testConfig.putRunTimeProperty("Prov_tin_nbr", System.getProperty("tin"));
		   ArrayList<String> PayerListDBAll = new ArrayList<String>();
		   HashMap<Integer, HashMap<String, String>> PayerListDB2 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		   for (int i = 1; i <= PayerListDB2.size(); i++){ 
			   PayerListDBAll.add(PayerListDB2.get(i).get("PAYR_DSPL_NM"));
           }		   
		   if(PayerListDBAll.equals(PayerListUI))		 
			   Log.Pass("Available Payers:- ");		 
		   else 
			   Log.Fail("Payer List Not Matching. Payers from UI: "+PayerListUI + " And List from DB: "+PayerListDBAll);		   
		
		   return this;
	}
	
	public PaymentDataFilesCSR verifyButtonsList() throws Exception
	{
		 Helper.compareEquals(testConfig, "Add Button Present in Create Data Bundle Page", true, addBtn.isDisplayed());
		 Helper.compareEquals(testConfig, "Add All Button Present in Create Data Bundle Page", true, addAllBtn.isDisplayed());
		 Helper.compareEquals(testConfig, "Remove Button Present in Create Data Bundle Page", true, removeBtn.isDisplayed());
		 Helper.compareEquals(testConfig, "Remove All Button Present in Create Data Bundle Page", true, removeAllBtn.isDisplayed());
	   
	  return this;
	}
	
	public PaymentDataFilesCSR verifyAddButton() throws Exception
	{
		String txtFirstPayer=firstPayer.getText();
		Element.click(firstPayer, "First Payer");
		Element.clickByJS(testConfig,addBtn, "Add Button");
		Helper.compareEquals(testConfig, "Add Button Functionality", txtFirstPayer, selectedFirstPayer.getText().trim());
		return this;	
	}
		   
	public PaymentDataFilesCSR verifyRemoveButton() throws Exception
	{
		Element.click(selectedFirstPayer, "Selected First Payer");
		Element.clickByJS(testConfig,removeBtn, "Remove Button");
		Helper.compareEquals(testConfig, "Remove Button Functionality", 0, selectedPayerList.size());
		return this; 
	}
		   
	public PaymentDataFilesCSR verifyAddAllButton() throws Exception
	{
		
		Element.click(addAllBtn, "Add All Button");
		if(selectedPayerList.size()!=48)
			Element.clickByJS(testConfig,addAllBtn, "Add All Button");
		 Helper.compareEquals(testConfig, "Add All Functionality", 48, selectedPayerList.size());
		return this;
	}
		   
	public PaymentDataFilesCSR verifyRemoveAllButton() throws Exception
	{
		Element.click(removeAllBtn, "Remove All Button");
		if(selectedPayerList.size()!=0)
			Element.clickByJS(testConfig,removeAllBtn, "Add All Button");
		 Helper.compareEquals(testConfig, "Remove All Functionality", 0, selectedPayerList.size());
		return this;
	}
		   
	public PaymentDataFilesCSR verifyAvailablePayerListAfterReset() throws Exception
	{
		Element.click(addAllBtn, "Add All Button");	 
		if(selectedPayerList.size()!=48)
			Element.clickByJS(testConfig,addAllBtn, "Add All Button");
        Element.clickByJS(testConfig,resetBtn, "Reset Button");
        Browser.wait(testConfig, 2);
		Helper.compareEquals(testConfig, "Reset Functionality", 48, availablePayerList.size());	
		return this;
	}

	public PaymentDataFilesCSR verifyErrorWithoutSubmittingAnyField() throws Exception
	{
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Element.fluentWait(testConfig, settlError, 100, 1, "Settlement Error");
		
		  
		
		// To verify Settlement Date Range Error
		Helper.compareEquals(testConfig, "Settlement Error Displays", "Settlement Date Range : From and To Dates are required.", settlError.getText());	 
		//to Verify Payer Selection Error
		Helper.compareEquals(testConfig, "Payer Error Displays", "Payer Selection : Missing Data", payerError.getText());
		//to Verify File Types Error
		Helper.compareEquals(testConfig, "File Type Error Displays", "File Types : Missing Data", fileError.getText());
		Element.click(resetBtn, "Reset Button");
		
		return this;
	}

	public PaymentDataFilesCSR verifyErrorWithoutSettlementDates() throws Exception
	{
		Element.clickByJS(testConfig,resetBtn, "Reset Button");
		firstPayer=Element.findElement(testConfig, "xpath", "//select[@name='availablePayers']//option[1]");
		Element.click(firstPayer, "First Payer");
		Element.click(addBtn, "Add Button");
		Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Element.fluentWait(testConfig, settlError, 100, 1, "Error msg");
		Helper.compareEquals(testConfig, "Settlement Error Displays", "Settlement Date Range : From and To Dates are required.", settlError.getText());
		Element.clickByJS(testConfig,resetBtn, "Reset Button");
		return this;
	}
			  
	public PaymentDataFilesCSR verifyErrorWithoutFileType() throws Exception
	{
		firstPayer=Element.findElement(testConfig, "xpath", "//select[@name='availablePayers']//option[1]");
		Element.click(firstPayer, "First Payer");
		Element.clickByJS(testConfig,addBtn, "Add Button");
		String date1=testConfig.getRunTimeProperty("setl_dt");
		date1= Helper.changeDateFormat(date1, "yyyy-mm-dd", "mm/dd/yyyy");
		Element.enterDataByJS(testConfig,fromDate, date1, "From Date: "+date1);
		Element.enterDataByJS(testConfig,toDate, date1, "To Date: "+date1);
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		
		fileError=Element.findElement(testConfig, "xpath", "//font[contains(text(),'File Types : Missing Data')]");
		Helper.compareEquals(testConfig, "File Type Error Displays: ", "File Types : Missing Data", fileError.getText());
		Element.clickByJS(testConfig,resetBtn, "Reset Button");
		
		return this;
	}	

	public PaymentDataFilesCSR verifyErrorForMore30days() throws Exception
	{
		firstPayer=Element.findElement(testConfig, "xpath","//select[@name='availablePayers']//option[1]");
		Element.click(firstPayer, "First Payer");
		Element.clickByJS(testConfig,addBtn, "Add Button");
		Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		
		String date1 = Helper.getDateBeforeOrAfterDays(-366,"MM/dd/yyyy");
		String date2= Helper.getCurrentTime("MM/dd/yyyy");
		Element.enterDataByJS(testConfig,fromDate, date1, "From Date: "+date1);
		Element.enterDataByJS(testConfig,toDate, date2, "To Date: "+date2);
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");		
		Helper.compareEquals(testConfig, "Error for More Than 30 Days Displays: ", "Settlement Date Range : From Date must not be greater than 30 Days prior to To date.", settlErrorMore30Days.getText());
		Element.clickByJS(testConfig,resetBtn, "Reset Button");
	
		return this;
	}
 
	public PaymentDataFilesCSR verifyErrorForPriorDates() throws Exception
	{
		firstPayer=Element.findElement(testConfig, "xpath", "//select[@name='availablePayers']//option[1]");
		Element.click(firstPayer, "First Payer");
		Element.clickByJS(testConfig,addBtn, "Add Button");
		Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		
		String date1=Helper.getCurrentDate("MM/dd/yyyy");
		String date2 = Helper.getDateBeforeOrAfterDays(366,"MM/dd/yyyy");
		Element.enterDataByJS(testConfig,fromDate, date1, "From Date: "+date1);
		Element.enterDataByJS(testConfig,toDate, date2, "To Date: "+date2);
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Helper.compareEquals(testConfig, "Error for Prior Days Displays: ", "Settlement Date Range : To and From Dates must be prior to or same as current date.", settlmntDatePriorError.getText());
		Element.clickByJS(testConfig,resetBtn, "Reset Button");
		return this;
	}	

	public PaymentDataFilesCSR verifyErrorForPayerSelection() throws Exception
	{
		String date1=Helper.getCurrentDate("MM/dd/yyyy");
		Element.enterDataByJS(testConfig, fromDate, date1, "From Date: "+date1+ "fromDate");
		Element.enterDataByJS(testConfig, toDate, date1, "From Date: "+date1+ "toDate");
		Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		  
		Element.fluentWait(testConfig, payerError, 100, 1, "Error Msg");
		
		//Verify Payer Selection Error Message
		Helper.compareEquals(testConfig, "Payer Selection Error Displays", "Payer Selection : Missing Data", payerError.getText());
		Element.clickByJS(testConfig,resetBtn, "Reset Button");
		return this;	   
	}	

	public PaymentDataFilesCSR verifyPayerSelection() throws Exception
	{	
		Element.click(addAllBtn, "Add All Button");
		if(selectedPayerList.size()!=48)
			Element.clickByJS(testConfig,addAllBtn, "Add All Button");
			
		return this;

	}
	   
	public PaymentDataFilesCSR enterPaymentDate() throws InterruptedException, Exception 
	{
		String DateEntered= Helper.changeDateFormat(testConfig.getRunTimeProperty("setl_dt"), "yyyy-mm-dd", "mm/dd/yyyy");
		Element.enterDataByJS(testConfig,fromDate, DateEntered, "From Date Entered: "+DateEntered);
		Element.enterDataByJS(testConfig,toDate, DateEntered, "To Date Entered: "+DateEntered);
		return this;
	}
	
	public PaymentDataFilesCSR verifySubmitEPRAsDataBundle() throws Exception
	{
		Element.clickByJS(testConfig,epraChkbox, "Click on EPRA Check Box");
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Element.fluentWait(testConfig, bundleSubmission, 100,1, "Bundle submitted msg");
		Helper.compareEquals(testConfig, "Data Bundle Message for EPRA File Type", " Your bundle has been successfully submitted.", bundleSubmission.getText());
		return this;
	}	

	public PaymentDataFilesCSR verifyDownloadDataBundle() throws Exception
	{
		Element.clickByJS(testConfig,downloadDataBundle, "Download Data Bundle Tab");
		
		//verify that we are on the page
		String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download for 7 days with the expiration date listed for each bundle.";
		/*if(downloadDataBundlePage.getText().contains(expectedNote))
			 Log.Pass("User has been navigated to Download Data Bundle Page. Text Displayed: "+downloadDataBundlePage.getText());
		 else 
			 Helper.compareEquals(testConfig, "Incorrect Navigation to Download Data Bundle Page", expectedNote, downloadDataBundlePage.getText());
			 */
		
		//Click on the View Bundle Detail Link for the Latest entry
		Element.clickByJS(testConfig,viewDetailLink, "View Detail Link");
		 
		//verifies user navigated to Download Data Bundle - Bundle Details
		Helper.compareEquals(testConfig, "Navigation to Download Data Bundle Page", "Download Data Bundle - Bundle Details", subHeader.getText());
		 
		//verify the filename:
		Helper.compareEquals(testConfig, "File Name Not Generated", "Bundle File Name: N/A", bundleFileName.getText().trim());
		 
		return this;
	 }
	
	
	public PaymentDataFilesCSR verifyRequestEntryInDownloadDataBundle() throws Exception
	{
		verifyDownloadDataBundle();
		Helper.compareEquals(testConfig, "File Type Selected: EPRA", "File Types selected for this bundle: EPRAs", bundleFileType.getText().trim());
		return this;
	}
	
	public PaymentDataFilesCSR verifyDataBunldeDb()
	{
		testConfig.putRunTimeProperty("Prov_tin_nbr",System.getProperty("tin"));
		int sqlRow=234;
		Map Indicator=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		testConfig.putRunTimeProperty("DataBundleID", Indicator.get("DATA_BUNDLE_ID").toString());
		testConfig.putRunTimeProperty("835Ind", Indicator.get("INCL_835_IND").toString());
		testConfig.putRunTimeProperty("PPRAInd", Indicator.get("INCL_PAYR_PRA_IND").toString());
		testConfig.putRunTimeProperty("EPRAInd", Indicator.get("INCL_EPRA_IND").toString());
				
		return this;
	}
	
	public PaymentDataFilesCSR verifyEPRAInd()
	{
		verifyDataBunldeDb();
		String value835 = testConfig.getRunTimeProperty("835Ind").trim();
		String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
		String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
		String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
		if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("N") && value835.equalsIgnoreCase("N"))
			Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully  with EPRA indicator as: "+valueEPRA);	
		
		else 
			Log.Fail("Error in Data Bundle Request");
		
		return this;
	}
	
	public PaymentDataFilesCSR verifySubmitPRAsDataBundle() throws Exception
	{
		Element.clickByJS(testConfig,praChkbox, "Click on PPRA Check Box");
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Helper.compareEquals(testConfig, "Data Bundle Message for PPRA File Type", " Your bundle has been successfully submitted.", bundleSubmission.getText());
		return this;
	}
	
	
	public PaymentDataFilesCSR verifySubmit835DataBundle() throws Exception
	{
		Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Helper.compareEquals(testConfig, "Data Bundle Message for 835 File Type", " Your bundle has been successfully submitted.", bundleSubmission.getText());
		return this;
	}
	
	 public PaymentDataFilesCSR eight35FileType() throws Exception
	 {
		 verifyDownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s", "File Types selected for this bundle: 835s", bundleFileType.getText().trim());
		 return this;
	 }
	
	public PaymentDataFilesCSR PPRAFileType() throws Exception
	{
		verifyDownloadDataBundle();
		Helper.compareEquals(testConfig, "File Type Selected: PPRA", "File Types selected for this bundle: Payer PRAs", bundleFileType.getText().trim());
		
		return this;
	}
	
	public PaymentDataFilesCSR verify835Ind()
	{
		verifyDataBunldeDb();
		 String value835 = testConfig.getRunTimeProperty("835Ind").trim();
		 String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
		 String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
		 String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
		 if(valueEPRA.equalsIgnoreCase("N") && valuePPRA.equalsIgnoreCase("N") && value835.equalsIgnoreCase("Y") ) 
			 Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with 835 indicator as: "+value835);	
		 else 
		 Log.Fail("Error in Data Bundle Request");

		 return this;
		
	 }
	
	
	public PaymentDataFilesCSR verifyPPRAInd()
	{
		verifyDataBunldeDb();
		String value835 = testConfig.getRunTimeProperty("835Ind").trim();
		String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
		String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
		String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
		if(valueEPRA.equalsIgnoreCase("N") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("N"))
			Log.Pass("Data Bundle Request with ID "+DataBundleID+"have been Submitted Successfully with PPRA indicator as: "+valuePPRA);	
		else 
		Log.Fail("Error in Data Bundle Request");
		
		return this;
	}
	
	public PaymentDataFilesCSR VerifyEPRAandPPRA() throws Exception
	 {
		 Element.clickByJS(testConfig,epraChkbox, "Click on EPRA Check Box");
		 Element.clickByJS(testConfig,praChkbox, "Click on PPRA Check Box");
		 Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and PPRA File Type", " Your bundle has been successfully submitted.", bundleSubmission.getText());
		 return this;
	 }

	 public PaymentDataFilesCSR VerifyEPRAand835() throws Exception
	 {
		 Element.clickByJS(testConfig,epraChkbox, "Click on EPRA Check Box");
		 Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		 Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and 835 File Type", " Your bundle has been successfully submitted.", bundleSubmission.getText());
		 return this;
	 }

	 public PaymentDataFilesCSR VerifyPPRAand835() throws Exception
	 {
		 Element.clickByJS(testConfig,praChkbox, "Click on PPRA Check Box");
		 Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		 Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		 Helper.compareEquals(testConfig, "Data Bundle Message for PPRA and 835 File Type", " Your bundle has been successfully submitted.", bundleSubmission.getText());
		 return this;
	 }
	 
	 public PaymentDataFilesCSR VerifyEPRAandPPRAand835() throws Exception
	 {
		 Element.clickByJS(testConfig,epraChkbox, "Click on EPRA Check Box");
		 Element.clickByJS(testConfig,praChkbox, "Click on PPRA Check Box");
		 Element.clickByJS(testConfig,eight35ChkBox, "Click on 835 Check Box");
		 Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		 Helper.compareEquals(testConfig, "Data Bundle Message for All File Type", " Your bundle has been successfully submitted.", bundleSubmission.getText());
		 return this;
	 }

	 public PaymentDataFilesCSR EPRAnPPRAFileType() throws Exception
	 {
		 verifyDownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer PRAs, EPRAs", "File Types selected for this bundle: Payer PRAs, EPRAs", bundleFileType.getText().trim());
		  
		 return this;
	 }
	 
	 public PaymentDataFilesCSR EPRAn835FileType() throws Exception
	 {
		 verifyDownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer 835, EPRAs", "File Types selected for this bundle: 835s, EPRAs", bundleFileType.getText().trim());
		
		 return this;
	 }
	 
	 public PaymentDataFilesCSR PPRAn835FileType() throws Exception
	 {
		 verifyDownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s, Payer PRAs", "File Types selected for this bundle: 835s, Payer PRAs", bundleFileType.getText().trim());
		
		 return this;
	 }
	 
	 public PaymentDataFilesCSR EPRAn835nPPRAFileType() throws Exception
	 {
		 verifyDownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: All", "File Types selected for this bundle: 835s, Payer PRAs, EPRAs", bundleFileType.getText().trim());
		  
		 return this;
	 }
	
	 public PaymentDataFilesCSR verifyEPRAnPPRAInd()
	 {
		 verifyDataBunldeDb();
		 String value835 = testConfig.getRunTimeProperty("835Ind").trim();
		 String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
		 String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
		 String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
		 if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("N") )		
			Log.Pass("Data Bundle Request with ID "+DataBundleID+"have been Submitted Successfully with EPRA indicator as: "+valueEPRA + " and PPRA indicator as: "+valuePPRA);			
		 else 
			Log.Fail("Error in Data Bundle Request");
				
		return this;
		}
			
		public PaymentDataFilesCSR verifyEPRAn835Ind()
		{
			verifyDataBunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("N") && value835.equalsIgnoreCase("Y") )			
				Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with EPRA indicator as: "+valueEPRA + " and 835 indicator as: "+value835);	
			
			else 
				Log.Fail("Error in Data Bundle Request");
			
			return this;
		}
			
		public PaymentDataFilesCSR verifyPPRAn835Ind()
		{
			verifyDataBunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("N") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("Y") )				
				Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with PPRA indicator as: "+valuePPRA + " and 835 indicator as: "+value835);					
			else 
				Log.Fail("Error in Data Bundle Request");
				
			return this;
		}
			
		public PaymentDataFilesCSR verifyEPRAn835nPPRAInd()
		{
			verifyDataBunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("Y") )				
				Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with EPRA, PPRA and 835 indicator as Y");					
			else 
				Log.Fail("Error in Data Bundle Request");
				
			return this;
		}
	 	
		public PaymentDataFilesCSR getCompletedIN() throws Exception 
		{
			int sqlRow=235;
			Map<String,String> TINAndFileName= new HashMap<String, String>();
			Map displayNo=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
			
			if (displayNo != null) {			
				TINAndFileName.put("TINNbr", displayNo.get("PROV_TIN_NBR").toString());
				TINAndFileName.put("FileName", displayNo.get("FILE_NM").toString());
			
				testConfig.putRunTimeProperty("TINNbr", displayNo.get("PROV_TIN_NBR").toString()); 
				testConfig.putRunTimeProperty("FileName", displayNo.get("FILE_NM").toString());
			
				Element.enterData(enterTin, displayNo.get("PROV_TIN_NBR").toString(), "Enter Tin to proceed for Data Bundle" +displayNo.get("PROV_TIN_NBR").toString(), "enterTin");
				Element.click(searchBtn, "Search Button");			
		    }
			else
				Log.Comment("No FileName retrieved to be Validated");
			
			return this;
		}	

		public PaymentDataFilesCSR DownloadDataBundlePage() throws Exception
		{
			Element.clickByJS(testConfig,downloadDataBundle, "Click on Download Data Bundle Tab");
			Browser.wait(testConfig, 2);
			 //verify that we are on the page
			 String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download";
			 Helper.compareContains(testConfig, "Navigation to Download Data Bundle Page", expectedNote, downloadDataBundlePage.getText());
			 
			 return this;
		 
		}

		public PaymentDataFilesCSR verifyZipFileName() 
		{
			String FileName1 = testConfig.getRunTimeProperty("FileName");
			if (FileName1 != null)
			{
				boolean Zipfilename = Element.findElement(testConfig, "xpath", "//td[contains(text(),'"+FileName1+"')]").isDisplayed();
				
				if (Zipfilename = true) {
					Log.Pass("Data Bundle Zip file is present to download with File Name as: "+FileName1);
				}
				else {
					Log.Fail("System Not able to find the Zip file on UI with File Name as: "+FileName1);
				}
			}
			else {
				Log.Pass("No Data Bundle Request have been completed in Last 7 Days");
			}
			 return this;
		}
		
		public PaymentDataFilesCSR verifyPatientPaymentOnTopOfTheList() {
		Element.verifyTextPresent(payerName.findElements(By.tagName("option")).get(0), "UHC Member Payment");
		return this;
		}
		
		public PaymentDataFilesCSR verifyPayerPRANote() {
			Element.verifyTextPresent(payerPRANote, "Note: Payer PRAs and EPRAs may not be available for all Payers.");
			return this;
		}
		
		public PaymentDataFilesCSR verifyAbsenseOfPatientPaymentsNote() {
			Element.verifyElementNotPresent(patientPaymentsNote, "Data Bundle requests for Patient Payments will be available soon");
			return this;

		}
		
		public PaymentDataFilesCSR verify835isClickable() {
			Element.clickByJS(testConfig,eight35ChkBox, "835's Check Box");
			Element.verifyElementIsChecked(eight35ChkBox, "835's Check Box");
			return this;

		}
}