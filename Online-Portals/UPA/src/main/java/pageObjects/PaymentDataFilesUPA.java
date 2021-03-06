package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;
import main.java.reporting.Log;
import main.java.reporting.Log;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDataFilesUPA extends TestBase{

	@FindBy(id = "taxIndNbrId")
	WebElement drpDwnTin;
	@FindBy(xpath = "//a[contains(text(),'Payment Data Files')]")
	WebElement paymentDataFilesTab;
	@FindBy(xpath="//input[@value='Submit']")
	WebElement btnSubmit;
	@FindBy(xpath = "//ul[@id='payment-data-files__tabmenu']//li[1]//a") 
	WebElement createDataBundle;
	@FindBy(xpath = "//td[@class='subheader']")  
	WebElement subHeader;	
	@FindBy(xpath = "//td[contains(text(),'The Payment Data File feature enables faster and e')]")
	WebElement pageText;
	@FindBy(xpath = "//u[contains(text(),'Detailed Instructions For Bundle Creation')]") 
	WebElement detailedInstrctns;
	@FindBy(xpath = "//div[@id='payment-data-files-body']//tr[5]//td")
	WebElement providerBS;
	@FindBy(xpath = "//div[@id='payment-data-files-body']//tr//tr[4]/td//td[1]")
	WebElement providerPROV;		
	@FindBy(xpath = "//td[contains(text(),'Settlement Date Range')]") 
	WebElement stlDateRange;
	@FindBy(xpath = "//td[contains(text(),'File Types:')]")
	WebElement fileTypes;
	@FindBy(xpath = ".//td[@class='runtext pt-2']/input[@value='835s']")
	WebElement fileType835;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='Payer PRAs']")
	WebElement fileTypePRA;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='EPRAs']")
	WebElement fileTypeEPRA;
	@FindBy(xpath = "//input[@value='       Add       ']")
	WebElement addBtn;
	@FindBy(xpath = "//input[@value='    Add All   ']")
	WebElement addAllBtn;
	@FindBy(xpath = "//input[@value='    Remove    ']")
	WebElement removeBtn;
	@FindBy(xpath = "//input[@value=' Remove All']") 
	WebElement removeAllBtn;
	@FindBy(xpath = "//select[@id='availablePayerTinNbrs']//option[1]") 
	WebElement firstPayer;
	@FindBy(xpath = "//select[@id='selectedPayerTinNbrs']//option[1]") 
	WebElement selectedFirstPayer;
	@FindBy(xpath = "//select[@name='availablePayerTinNbrs']//option[1]")
	WebElement availablePayer;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range: From and To Dates are required ')]") 
	WebElement settlerror;
	@FindBy(xpath = "//font[contains(text(),'Payer Selection : Missing Data')]") 
	WebElement payerError;
	@FindBy(xpath = "//font[contains(text(),'File Types : Missing Data')]")
	WebElement fileError;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range : From Date must not be greater than 30 Days prior to To date')]") 
	WebElement settlErrorMore30Days;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range : To and From Dates must be prior to or same as current date.')]")
	WebElement settlmntDatePriorError;
	@FindBy(xpath = "//input[@value = '835s']") 
	WebElement eight35ChkBox;
	@FindBy(xpath = "//input[@value = 'Payer PRAs']")
	WebElement praChkbox;
	@FindBy(xpath = "//input[@value = 'EPRAs']") 
	WebElement epraChkbox;
	@FindBy(xpath = "//input[@name = 'settlementDateFrom']") 
	WebElement fromDate;
	@FindBy(xpath = "//input[@name = 'settlementDateTo']") 
	WebElement toDate;
	@FindBy(xpath = "//th[contains(text(),'Your bundle has been successfully submitted.')]") 
    WebElement bundleSubmission;
	@FindBy(xpath = "//td[contains(text(),'Payer Selection:')]") 
	WebElement payerSelection;
	@FindBy(xpath = "//a[contains(text(),'Download Data Bundle')]")
	WebElement downloadDataBundle;
	@FindBy(xpath = "//div[@id='payment-data-files']/div/p")
	WebElement downloadDataBundlePage;
	@FindBy(xpath = "//form[@id='downloadDataDeliveryForm']//tr[1]/td[2]")
	WebElement bundleFileName;
	@FindBy(xpath = "//form[@id='downloadDataDeliveryForm']//tr[2]/td[2]")
	WebElement bundleFileType;
	@FindBy(xpath = "//input[@value='Reset']")
	WebElement resetBtn;
	@FindBy(xpath = "//body/div[2]")
	WebElement standardPopUp;
	@FindBy(xpath = "//h2[contains(text(),'Organize data your way.')]")
	WebElement standardPopUpText;
	@FindBy(xpath="//select[@name='availablePayerTinNbrs']//option")
	List<WebElement> availablePayerList;	
	@FindBy(name = "paProvTinNbr")
	WebElement bstinDrpDwn;
	@FindBy(xpath="//select[@name='selectedPayerTinNbrs']//option")	
	List<WebElement> selectedPayerList;
	
	TestBase testConfig=TestBase.getInstance();
	int sqlRowNo;
	
	public PaymentDataFilesUPA(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		
		if((testConfig.getRunTimeProperty("userType").contains("BS") ||testConfig.getRunTimeProperty("userType").contains("Payer")))
			Element.fluentWait(testConfig, bstinDrpDwn, 100, 1, "TIN textbox");
		
		else if	((testConfig.getRunTimeProperty("userType").contains("PROV")))
			Element.fluentWait(testConfig, epraChkbox, 100, 1, "EPRA checkbox");
	}
	
	
	public PaymentDataFilesUPA verifyNavigationToCreateDataBundlePage() throws Exception
	{
		Helper.compareEquals(testConfig, "Navigating to Create Data Bundle Page", "Create Data Bundle", createDataBundle.getText());
		return  new PaymentDataFilesUPA(testConfig);
	}
	
	public PaymentDataFilesUPA verifyAllFieldsinCreateBundlePage(String userType) throws Exception
	{
		String PageTextActual = "The Payment Data File feature enables faster and easier access to large amounts of payment data. Using this tool you can create data bundles by day, by file type and by payer.";		
		Helper.compareEquals(testConfig, "Page Text Context Displays: ", PageTextActual, pageText.getText().trim());		 				
		Helper.compareEquals(testConfig, "Detailed Instructions Link Displays", "Detailed Instructions For Bundle Creation", detailedInstrctns.getText().trim());
		String providerNameUI="";
		
		if(userType.equalsIgnoreCase("BS") || userType.equalsIgnoreCase("Payer")) 
			 providerNameUI = providerBS.getText().trim();
		else if(userType.equalsIgnoreCase("PROV"))
			providerNameUI = providerPROV.getText().trim();
		
		int sqlRow=236;
		testConfig.putRunTimeProperty("Prov_tin_nbr", System.getProperty("tin"));
		Map orgNameDB=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String orgName = orgNameDB.get("ORG_NM").toString().trim();
		String provName = "Provider: "+orgName;
		Helper.compareEquals(testConfig, "Provider Name", provName, providerNameUI);						
		Helper.compareEquals(testConfig, "Settlement Date Range", "Settlement Date Range", stlDateRange.getText().trim());
		Helper.compareEquals(testConfig, "File Types:", "File Types:", fileTypes.getText().trim());
		Helper.compareEquals(testConfig, "835s", "835s", fileType835.getAttribute("value"));
		Helper.compareEquals(testConfig, "Payer PRAs", "Payer PRAs", fileTypePRA.getAttribute("value"));
		Helper.compareEquals(testConfig, "EPRAs", "EPRAs", fileTypeEPRA.getAttribute("value"));
		
		if(userType.equalsIgnoreCase("BS") || userType.equalsIgnoreCase("PROV")) {
			String PayerSelectionName = payerSelection.getText().trim();
			Helper.compareEquals(testConfig, "Payer Selection:", "Payer Selection:", PayerSelectionName);
		}
	   return this;	
	}
	
	public PaymentDataFilesUPA verifyErrorWithoutSubmiitingAnyField(String userType) throws Exception
	{
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 1);
		 // To verify Settlement Date Range Error
		Helper.compareEquals(testConfig, "Settlement Error Displays: ", "Settlement Date Range: From and To Dates are required", settlerror.getText());
		 //to Verify Payer Selection Error
		if(!userType.equalsIgnoreCase("Payer")) {
		 Helper.compareEquals(testConfig, "Payer Error Displays: ", "Payer Selection : Missing Data", payerError.getText());
		}
		 //to Verify File Types Error
		Helper.compareEquals(testConfig, "File Type Error Displays: ", "File Types : Missing Data", fileError.getText()); 
	 	
	 	 if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(resetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		
		 return this;
	 }

	public PaymentDataFilesUPA verifyErrorWithoutSettlementDates(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(resetBtn, "Reset Button");
			Browser.wait(testConfig, 1);		 
			Element.click(firstPayer, "First Payer");
		    Element.click(addBtn, "Add Button");
			Element.click(eight35ChkBox, "Click on 835 Check Box");
		}
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 1);
		
		Helper.compareEquals(testConfig, "Settlement Error Displays: ", "Settlement Date Range: From and To Dates are required", settlerror.getText());
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(resetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		
		return this;
	}
			  
	public PaymentDataFilesUPA verifyErrorWithoutFileType(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(firstPayer, "First Payer");
			Element.click(addBtn, "Add Button");
		}
		String date1=testConfig.getRunTimeProperty("setl_dt");
		date1= Helper.changeDateFormat(date1, "yyyy-mm-dd", "mm/dd/yyyy");
		Element.enterData(fromDate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(toDate, date1, "To Date: "+date1, "todate");
		
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 1);
		
		Helper.compareEquals(testConfig, "File Type Error Displays: ", "File Types : Missing Data", fileError.getText()); 
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(resetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		
		return this;
	}
	
	public PaymentDataFilesUPA verifyErrorForMore30days(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(resetBtn, "Reset Button");
			Browser.wait(testConfig, 1);		
			Element.click(firstPayer, "First Payers");
			Element.click(addBtn, "Add Button");
		}
		Element.click(eight35ChkBox, "Click on 835 Check Box");
			 
		String date1 = Helper.getDateBeforeOrAfterDays(-366,"MM/dd/yyyy");
		String date2= Helper.getCurrentTime("MM/dd/yyyy");
		Element.enterData(fromDate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(toDate, date2, "To Date: "+date2, "todate");
		Element.click(btnSubmit, "Click on Submit Button");	
		Browser.wait(testConfig, 1);
		Helper.compareEquals(testConfig, "Error for More Than 30 Days Displays: ", "Settlement Date Range : From Date must not be greater than 30 Days prior to To date", settlErrorMore30Days.getText());
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(resetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
				
		return this;
	}
  
	public PaymentDataFilesUPA verifyErrorForPriorDates(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(firstPayer, "First Payer");
			Element.click(addBtn, "Add Button");
		}
		Element.click(eight35ChkBox, "Click on 835 Check Box");
		 
		String date1=Helper.getCurrentDate("MM/dd/yyyy");
		String date2 = Helper.getDateBeforeOrAfterDays(366,"MM/dd/yyyy");
		Element.enterDataByJS(testConfig, fromDate, date1,  " fromdate");
		Element.enterDataByJS(testConfig, toDate, date2, " todate");
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 1);
		 
		Helper.compareEquals(testConfig, "Error for Prior Days Displays: ", "Settlement Date Range : To and From Dates must be prior to or same as current date.", settlmntDatePriorError.getText());
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(resetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		return this;
	}

	public PaymentDataFilesUPA verifyErrorForPayerSelection() throws Exception
	{
		String date1=Helper.getCurrentDate("MM/dd/yyyy");
		Element.enterDataByJS(testConfig, fromDate, date1, "From Date: "+date1+ "fromdate");
		Element.enterDataByJS(testConfig, toDate, date1, "From Date: "+date1+ "todate");
		Element.click(eight35ChkBox, "Click on 835 Check Box");
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 1);	   
		
		//Verify Payer Selection Error Message
		Helper.compareEquals(testConfig, "Payer Selection Error Displays", "Payer Selection : Missing Data", payerError.getText());
		Element.click(resetBtn, "Reset Button");
		return this;	   
	}
	
	 
	public PaymentDataFilesUPA enterPaymentDate() throws InterruptedException, Exception 
	{
		 String dateEntered= Helper.changeDateFormat(testConfig.getRunTimeProperty("setl_dt"), "yyyy-mm-dd", "mm/dd/yyyy");
		 Element.enterData(fromDate, dateEntered, "From Date Entered: "+dateEntered, "fromdate");
		 Element.enterData(toDate, dateEntered, "To Date Entered: "+dateEntered, "todate");
		 return this;
	}
		   
	public PaymentDataFilesUPA verifyAllFilesTypes() throws Exception
	{				
		 Helper.compareEquals(testConfig, "FileTypes Displays for 835.", fileType835.getAttribute("value"), "835s");
		 Helper.compareEquals(testConfig, "FileTypes Displays for PPRA.", fileTypePRA.getAttribute("value"), "Payer PRAs");
		 Helper.compareEquals(testConfig, "FileTypes Displays for EPRA.", fileTypeEPRA.getAttribute("value"), "EPRAs");		 
		 return this;
	}

	public PaymentDataFilesUPA verifySubmitEPRAsDataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 1);
		 		   
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA File Type", "Your bundle has been successfully submitted.", bundleSubmission.getText());
		
		 return this;
	}
	
	public PaymentDataFilesUPA verifySubmitPPRAsDataBundle() throws Exception
	{
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 		   
		 Helper.compareEquals(testConfig, "Data Bundle Message for PPRA File Type", "Your bundle has been successfully submitted.", bundleSubmission.getText());
		 
		 return this;
	}

	public PaymentDataFilesUPA verifySubmit835DataBundle() throws Exception
	{
		 Element.click(eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 		 		   
		 Helper.compareEquals(testConfig, "Data Bundle Message for 835 File Type", "Your bundle has been successfully submitted.", bundleSubmission.getText());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA verifySubmitEPRAnPPRADataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 		   
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and PPRA File Type", "Your bundle has been successfully submitted.", bundleSubmission.getText());
	
		 return this;
	}

	public PaymentDataFilesUPA verifySubmitEPRAn835DataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 1);
		 		   
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and 835 File Type", "Your bundle has been successfully submitted.", bundleSubmission.getText());
		 return this;
	}

	public PaymentDataFilesUPA verifySubmitPPRA835DataBundle() throws Exception
	{
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 1);
		 		   
		 Helper.compareEquals(testConfig, "Data Bundle Message for PPRA and 835 File Type", "Your bundle has been successfully submitted.", bundleSubmission.getText());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA verifySubmitAlltypeDataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 1);
		 		   
		 Helper.compareEquals(testConfig, "Data Bundle Message for All File Type", "Your bundle has been successfully submitted.", bundleSubmission.getText());

		 return this;
	}
	 
	public PaymentDataFilesUPA downloadDataBundle() throws Exception
	{
		 Element.click(downloadDataBundle, "Click on Download Data Bundle Tab");
		 Browser.wait(testConfig, 2);
		
		 //verify that we are on the page
		 String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download for 7 days with the expiration date listed for each bundle.";
		 Helper.compareEquals(testConfig, "Validate Navigation to Download Data Bundle Page", expectedNote.trim(), downloadDataBundlePage.getText().trim());
		 
		 
		 //Click on the View Bundle Detail Link for the Latest entry
		 String tin= testConfig.getRunTimeProperty("tin");
		 WebElement viewDetailLink= Element.findElement(testConfig, "xpath", "(//td[contains(text(),'"+tin+"')])[1]/following-sibling::td/a");
		 Element.click(viewDetailLink, "View Detail Link");
		 Browser.wait(testConfig, 2);
		 
		 //verifies user navigated to Download Data Bundle - Bundle Details
		 Helper.compareEquals(testConfig, "Navigation to Download Data Bundle Page", "Download Data Bundle - Bundle Details", subHeader.getText());
		 
		 //verify the filename:
		 Helper.compareEquals(testConfig, "File Name Not Generated", "Bundle File Name: N/A", bundleFileName.getText().trim());
		 
		return this;
	}
	 
	public PaymentDataFilesUPA EPRAFileType() throws Exception
	{
		 downloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: EPRA", "File Types selected for this bundle: EPRAs", bundleFileType.getText().trim());
		  
		 return this;
	}
	
	public PaymentDataFilesUPA PPRAFileType() throws Exception
	{
		 downloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: PPRA", "File Types selected for this bundle: Payer PRAs", bundleFileType.getText().trim());
		 
		 return this;
	}
	
	public PaymentDataFilesUPA eight35FileType() throws Exception
	{
		 downloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s", "File Types selected for this bundle: 835s", bundleFileType.getText().trim());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA EPRAnPPRAFileType() throws Exception
	{
		 downloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer PRAs, EPRAs", "File Types selected for this bundle: Payer PRAs, EPRAs", bundleFileType.getText().trim()); 
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA EPRAn835FileType() throws Exception
	{
		 downloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer 835, EPRAs", "File Types selected for this bundle: 835s, EPRAs", bundleFileType.getText().trim());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA PPRAn835FileType() throws Exception
	{
		 downloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s, Payer PRAs", "File Types selected for this bundle: 835s, Payer PRAs", bundleFileType.getText().trim());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA EPRAn835nPPRAFileType() throws Exception
	{
		 downloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: All", "File Types selected for this bundle: 835s, Payer PRAs, EPRAs", bundleFileType.getText().trim());
		 
		 return this;
	}

	public PaymentDataFilesUPA downloadBundlePage() throws Exception
	{
		 Element.click(downloadDataBundle, "Click on Download Data Bundle Tab");
		 Browser.wait(testConfig, 1);
		
		 //verify that we are on the page
		 String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download";
		 Helper.compareContains(testConfig, "Navigation to Download Data Bundle Page", expectedNote, downloadDataBundlePage.getText());

		 return this;
	}
	
	public PaymentDataFilesUPA getCompletedIN() 
	{
		 int sqlRow=239;
		 testConfig.putRunTimeProperty("Prov_tin_nbr", System.getProperty("tin"));
		 Map<String,String> TINAndFileName= new HashMap<String, String>();
		 Map displayNo=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		 if (displayNo != null)
		 {
			 TINAndFileName.put("TINNbr", displayNo.get("PROV_TIN_NBR").toString());
			 TINAndFileName.put("FileName", displayNo.get("FILE_NM").toString());
			
			 testConfig.putRunTimeProperty("TINNbr", displayNo.get("PROV_TIN_NBR").toString()); 
			 testConfig.putRunTimeProperty("FileName", displayNo.get("FILE_NM").toString());
		 }
		 else		 
			 Log.Comment("No FileName retrieved to be Validated");
		 
		 return this;
	}

	public PaymentDataFilesUPA verifyZipFileName() 
	{
		 String FileName1 = testConfig.getRunTimeProperty("FileName");
		 if (FileName1 != null)
		 {
			 boolean Zipfilename = Element.findElement(testConfig, "xpath", "//td[contains(text(),'"+FileName1+"')]").isDisplayed();				
			 if (Zipfilename = true) 
				 Log.Pass("Data Bundle Zip file is present to download with File Name as: "+FileName1);			 
			 else 
				 Log.Fail("System Not able to find the Zip file on UI with File Name as: "+FileName1);			 
		 }
		 else 
			 Log.Pass("No Data Bundle Request has been completed in Last 7 Days");
		 	
		 return this;
	}
		  
	public PaymentDataFilesUPA verifyDataBundleDB()
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
	
	public PaymentDataFilesUPA verify835Ind()
	{
		 verifyDataBundleDB();
		 String value835 = testConfig.getRunTimeProperty("835Ind").trim();
		 String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
		 String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
		 String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
		 if(valueEPRA.equalsIgnoreCase("N") && valuePPRA.equalsIgnoreCase("N") && value835.equalsIgnoreCase("Y") ) 
		 {
			 Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with 835 indicator as: "+value835);	
		 }
		 else {Log.Fail("Error in Data Bundle Request");
		 }
		 return this;
		}
		
	public PaymentDataFilesUPA verifyEPRAInd()
	{
		verifyDataBundleDB();
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
		
	public PaymentDataFilesUPA verifyPPRAInd()
	{
		verifyDataBundleDB();
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
	
	public PaymentDataFilesUPA verifyEPRAnPPRAInd()
	{
		verifyDataBundleDB();
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
		
	public PaymentDataFilesUPA verifyEPRAn835Ind()
	{
		verifyDataBundleDB();
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
		
	public PaymentDataFilesUPA verifyPPRAn835Ind()
	{
		verifyDataBundleDB();
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
		
	public PaymentDataFilesUPA verifyEPRAn835nPPRAInd()
	{
		verifyDataBundleDB();
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
		   
	public PaymentDataFilesUPA verifyPayerList(String userType) throws InterruptedException, IOException
	{				
		List<String> PayerListUI=new ArrayList<>();
		List<WebElement> payer =Element.findElements(testConfig, "xpath", "//select[@name='availablePayerTinNbrs']//option");
				for(int i=1; i<= payer.size(); i++)
		{
			String  Payr = Element.findElement(testConfig, "xpath", "//select[@name='availablePayerTinNbrs']/option["+i+"]").getText().trim();
			PayerListUI.add(Payr);
		}   
		   
		   String query=QUERY.PAYER_LIST;
		   testConfig.putRunTimeProperty("Prov_tin_nbr", System.getProperty("tin"));
		   HashMap<Integer, HashMap<String, String>> PayerListDB2 = DataBase.executeSelectQueryALL(testConfig, query);
		   testConfig.putRunTimeProperty("totalPayers", PayerListDB2.get(1).get("TOTALROWS"));	
		   testConfig.putRunTimeProperty("firstPayer", PayerListDB2.get(1).get("PAYR_DSPL_NM"));
		   ArrayList<String> PayerListDBAll = new ArrayList<String>();		   
		   for (int i = 1; i <= PayerListDB2.size(); i++){ 
			   PayerListDBAll.add(PayerListDB2.get(i).get("PAYR_DSPL_NM"));
           }		   
		   if(PayerListDBAll.equals(PayerListUI))		 
			   Log.Pass("Available Payers: "+ PayerListUI);		 
		   else 
			   Log.Fail("Payer List Not Matching. Payers from UI: "+PayerListUI + " And List from DB: "+PayerListDBAll);		   
		
		   return this;
	}
	
	 public PaymentDataFilesUPA verifyButtonsList() throws Exception
	 {		 		 
		 Helper.compareEquals(testConfig, "Add Button Present in Create Data Bundle Page", true, addBtn.isDisplayed());
		 Helper.compareEquals(testConfig, "Add All Button Present in Create Data Bundle Page", true, addAllBtn.isDisplayed());
		 Helper.compareEquals(testConfig, "Remove Button Present in Create Data Bundle Page", true, removeBtn.isDisplayed());
		 Helper.compareEquals(testConfig, "Remove All Button Present in Create Data Bundle Page", true, removeAllBtn.isDisplayed());
		 return this;	
	 }
	   
	 public PaymentDataFilesUPA verifyAddButton() throws Exception
	 {	
			Element.click(firstPayer, "First Payer");
			Element.click(addBtn, "Add Button");
			Helper.compareEquals(testConfig, "Add Button Functionality", testConfig.getRunTimeProperty("firstPayer"), selectedFirstPayer.getText().trim());
		 return this;	
	 }
		   
	 public PaymentDataFilesUPA verifyRemoveButton() throws Exception
	 {
		Element.click(selectedFirstPayer, "Selected First Payer");
		Element.click(removeBtn, "Remove Button");
		Helper.compareEquals(testConfig, "Remove Button Functionality", 0, selectedPayerList.size());

		return this;
	 }
	 public PaymentDataFilesUPA verifyAddAllButton() throws Exception
	 {
		Element.click(addAllBtn, "Add All Button");
		Helper.compareEquals(testConfig, "Add All Functionality", Integer.parseInt(testConfig.getRunTimeProperty("totalPayers").trim()), selectedPayerList.size());
		 return this;	
	 }
		   
	 public PaymentDataFilesUPA verifyRemoveAllButton() throws Exception
	 {	
		 Element.click(removeAllBtn, "Remove All Button");		
		 Helper.compareEquals(testConfig, "Remove All Functionality", 0, selectedPayerList.size());
		 
		 return this;
	 }
	 
	 public PaymentDataFilesUPA verifyResetButton() throws Exception
	 {
		Element.click(addAllBtn, "Add All Button");	
		Browser.wait(testConfig, 1);
		Element.clickByJS(testConfig,resetBtn, "Reset Button");
		Helper.compareEquals(testConfig, "Reset Functionality", Integer.parseInt(testConfig.getRunTimeProperty("totalPayers").trim()), availablePayerList.size());
		Helper.compareEquals(testConfig, "Reset Functionality", 0, selectedPayerList.size());
		return this;

	 }


	 public PaymentDataFilesUPA verifyPayerSelection(String userType) throws Exception
	 {
		 if(!userType.equalsIgnoreCase("Payer"))
		 Element.click(addAllBtn, "Add All Button");
		 return this;
	 }
	 
	 
	public PaymentDataFilesUPA clickSubmit()
	{
		Element.click(btnSubmit, "Submit button");
		return this;
	}
 public PaymentDataFilesUPA verifyPopUp() {
	 Element.verifyElementPresent(standardPopUp, "Organize data your way.");
	 Helper.compareEquals(testConfig, "Organize data your way.", "Organize data your way.",standardPopUpText.getText().trim());
	 return this;
 }

	/**
	 * Author : Vinay Raghumanda
	 * Validates Page Text for Payment data Files for different types of users.
	 * @param accessType
	 * @param portalAccess
	 */
	public void validatePageText(String accessType, String portalAccess) {

		String expectedParagraph, expectedHeader, actualButtonText, expectedButtonText;
		WebElement button = null;

		switch (accessType + "_" + portalAccess + "_" + testConfig.getRunTimeProperty("tinType")){
			case "PROV_Admin_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_Admin_Premium_VO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.premium.vo.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;	
			case "PROV_Admin_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				button = Element.findElement(testConfig, "xpath", "//*[@type=\"button\"]/span[text()='Get Started']");
				actualButtonText = button.getText().trim();
				expectedButtonText = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.buttonText");
				Helper.compareEquals(testConfig, "Page Text", expectedButtonText, actualButtonText);
				break;
			case "PROV_Gen_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_Gen_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("prov.general.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			case "BS_Admin_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_Admin_Standard_AO":
				if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and NotPaid"))
				{
					expectedHeader = TestBase.contentMessages.getProperty("bs.admin.standard.withinTrialNotPaid.ao.pageDataFiles.header");
					expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.standard.withinTrialNotPaid.ao.pageDataFiles.paragraph");
					validateStandardUsers(expectedParagraph, expectedHeader);
				}
				else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "PostTrial and NotPaid"))
				{
				expectedHeader = TestBase.contentMessages.getProperty("bs.admin.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);}
				break;
			case "BS_Gen_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_Gen_Standard_AO":
				if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and NotPaid"))
				{
					expectedHeader = TestBase.contentMessages.getProperty("bs.general.standard.withinTrialNotPaid.ao.pageDataFiles.header");
					expectedParagraph = TestBase.contentMessages.getProperty("bs.general.standard.withinTrialNotPaid.ao.pageDataFiles.paragraph");
					validateStandardUsers(expectedParagraph, expectedHeader);
				}
				else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "PostTrial and NotPaid"))
				{
				expectedHeader = TestBase.contentMessages.getProperty("bs.general.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);}
				break;
			default:
				break;
		}
	}

	private void validateStandardUsers(String expectedParagraph, String expectedHeader) {
		WebElement headerTag=null;
		WebElement paragraphTag=null;
		String actualHeader;
		String actualParagraph;
	  if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and NotPaid"))
		{
			Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//div[@id='payment-data-files']/div[1]/p[2]/b"), 30);
			headerTag = Element.findElement(testConfig, "xpath", "//div[@id='payment-data-files']/div[1]/p[2]/b");
			paragraphTag=Element.findElement(testConfig, "xpath", "//div[@id='payment-data-files']/div[1]/p[3]");	
		}
		else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "PostTrial and NotPaid"))
		{
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//div[@id='paymentDataFilesPremium']//h2"), 30);
		headerTag = Element.findElement(testConfig, "xpath", "//div[@id='paymentDataFilesPremium']//h2");
		paragraphTag=Element.findElement(testConfig, "xpath", "//div[@id='paymentDataFilesPremium']//p[2]");
		}
		actualHeader = headerTag.getText().trim();
		actualParagraph = paragraphTag.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", expectedHeader, actualHeader);
		Helper.compareEquals(testConfig, "Page Text", expectedParagraph, actualParagraph);
	}

	private void validatePremiumUsers(String expectedParagraph) {
		WebElement paragraphTag=null;
		String actualParagraph=null;
		if (testConfig.getRunTimeProperty("searchCriteria").equals("PremiumOrStandardTIN") && testConfig.getRunTimeProperty("tinType").equals("VO"))
		{
			Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//div[@id='payment-data-files']/div[1]/p[2]"), 30);
			paragraphTag = Element.findElement(testConfig, "xpath", "//div[@id='payment-data-files']/div[1]/p[2]");	
		}
		else{
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@class=\"topMessaggeDiv\"]"), 30);
		paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
		}
		actualParagraph = paragraphTag.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", expectedParagraph, actualParagraph);
	}
}
