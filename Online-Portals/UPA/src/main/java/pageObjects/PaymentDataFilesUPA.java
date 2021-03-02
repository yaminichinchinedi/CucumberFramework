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
import main.java.reporting.Log;
import main.java.reporting.Log;

import org.openqa.selenium.By;
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
	WebElement CreateDataBundle;
	@FindBy(xpath = "//td[@class='subheader']")  
	WebElement SubHeader;	
	@FindBy(xpath = "//td[contains(text(),'The Payment Data File feature enables faster and e')]")
	WebElement PageText;
	@FindBy(xpath = "//u[contains(text(),'Detailed Instructions For Bundle Creation')]") 
	WebElement DetailedInstrctns;
	@FindBy(xpath = "//div[@id='payment-data-files-body']//tr[5]//td")
	WebElement ProviderBS;
	@FindBy(xpath = "//div[@id='payment-data-files-body']//tr//tr[4]/td//td[1]")
	WebElement ProviderPROV;		
	@FindBy(xpath = "//span[contains(text(),'TIN:')]") 
	WebElement TINvisible;
	@FindBy(xpath = "//td[contains(text(),'Settlement Date Range')]") 
	WebElement StlDateRange;
	@FindBy(xpath = "//td[contains(text(),'File Types:')]")
	WebElement FileTypes;
	@FindBy(xpath = ".//td[@class='runtext pt-2']/input[@value='835s']")
	WebElement FileType835;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='Payer PRAs']")
	WebElement FileTypePRA;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='EPRAs']")
	WebElement FileTypeEPRA;
	@FindBy(xpath = "//input[@value='       Add       ']")
	WebElement AddBtn;
	@FindBy(xpath = "//input[@value='    Add All   ']")
	WebElement AddAllBtn;
	@FindBy(xpath = "//input[@value='    Remove    ']")
	WebElement RemoveBtn;
	@FindBy(xpath = "//input[@value=' Remove All']") 
	WebElement RemoveAllBtn;
	@FindBy(xpath = "//select[@id='availablePayerTinNbrs']//option[1]") 
	WebElement FirstPayer;
	@FindBy(xpath = "//select[@id='selectedPayerTinNbrs']//option[1]") 
	WebElement SelectedFirstPayer;
	@FindBy(xpath = "//select[@name='availablePayerTinNbrs']//option[1]")
	WebElement AvailablePayer;
	@FindBy(xpath = "//*[@name='selectedPayerTinNbrs']")
	WebElement SelectedPayer;
	@FindBy(xpath = "//th[contains(text(),'Please correct the following fields before submit')]") 
	WebElement ErrorHeader;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range: From and To Dates are required ')]") 
	WebElement Settlerror;
	@FindBy(xpath = "//tr[@id='errorswarning']//tr//font") 
	WebElement errorMsg;	
	@FindBy(xpath = "//font[contains(text(),'Payer Selection : Missing Data')]") 
	WebElement PayerError;
	@FindBy(xpath = "//font[contains(text(),'File Types : Missing Data')]")
	WebElement FileError;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range : From Date must not be greater than 30 Days prior to To date')]") 
	WebElement SettlErrorMore30Days;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range : To and From Dates must be prior to or same as current date.')]")
	WebElement SettlmntDatePriorError;
	@FindBy(xpath = "//input[@value = '835s']") 
	WebElement Eight35ChkBox;
	@FindBy(xpath = "//input[@value = 'Payer PRAs']")
	WebElement praChkbox;
	@FindBy(xpath = "//input[@value = 'EPRAs']") 
	WebElement epraChkbox;
	@FindBy(xpath = "//input[@name = 'settlementDateFrom']") 
	WebElement fromdate;
	@FindBy(xpath = "//input[@name = 'settlementDateTo']") 
	WebElement todate;
	@FindBy(xpath = "//th[contains(text(),'Your bundle has been successfully submitted.')]") 
    WebElement BundleSubmission;
	@FindBy(xpath = "//td[contains(text(),'Payer Selection:')]") 
	WebElement PayerSelection;
	@FindBy(xpath = "//a[contains(text(),'Download Data Bundle')]")
	WebElement DownloadDataBundle;
	@FindBy(xpath = "//div[@id='payment-data-files']/div/p")
	WebElement DownloadDataBundlePage;
	@FindBy(xpath = "//form[@id='downloadDataDeliveryForm']//tr[1]/td[2]")
	WebElement BundleFileName;
	@FindBy(xpath = "//form[@id='downloadDataDeliveryForm']//tr[2]/td[2]")
	WebElement BundleFileType;
	@FindBy(xpath = "//input[@name='paProvTinNbr']")
	WebElement TINField;
	@FindBy(xpath = "//input[@name='continueBtn']")
	WebElement SearchButton;
	@FindBy(xpath = "//input[@value='Reset']")
	WebElement ResetBtn;
	@FindBy(xpath = "//body/div[2]")
	WebElement standardPopUp;
	@FindBy(xpath = "//h2[contains(text(),'Organize data your way.')]")
	WebElement standardPopUpText;
	
	
	TestBase testConfig=TestBase.getInstance();
	int sqlRowNo;
	
	public PaymentDataFilesUPA(TestBase testConfig) {
		PageFactory.initElements(testConfig.driver, this);
		PageFactory.initElements(testConfig.driver, this);
	}
	
	
	public PaymentDataFilesUPA verifyCreateDataBundlePage() throws Exception
	{
		String DataBundlePage = CreateDataBundle.getText();
		Browser.wait(testConfig, 3);
		Helper.compareEquals(testConfig, "Navigating to Create Data Bundle Page", "Create Data Bundle", DataBundlePage);
	
		Browser.wait(testConfig, 3);
		return  new PaymentDataFilesUPA(testConfig);
	}
	
	public PaymentDataFilesUPA verifyAllValuesinCreateBundlePage(String userType) throws Exception
	{
		String PageTextContext  = PageText.getText().trim();
		String PageTextActual = "The Payment Data File feature enables faster and easier access to large amounts of payment data. Using this tool you can create data bundles by day, by file type and by payer.";
		testConfig.softAssert.assertEquals(PageTextContext, PageTextActual, "Page Text Context Displays: "+PageTextContext);
		String DetailedInstructions = DetailedInstrctns.getText().trim(); 		
		testConfig.softAssert.assertEquals(DetailedInstructions, "Detailed Instructions For Bundle Creation", "Detailed Instructions Link Displays: "+DetailedInstructions);
		
		String ProviderName="";
		if(userType.equalsIgnoreCase("BS") || userType.equalsIgnoreCase("Payer")) 
			 ProviderName = ProviderBS.getText().trim();
		else if(userType.equalsIgnoreCase("PROV"))
			 ProviderName = ProviderPROV.getText().trim();
		
		int sqlRow=236;
		testConfig.putRunTimeProperty("Prov_tin_nbr", System.getProperty("tin"));
		Map orgNameDB=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String orgName = orgNameDB.get("ORG_NM").toString().trim();
		String ProvName = "Provider: "+orgName;
		Helper.compareEquals(testConfig, "Provider Name", ProvName, ProviderName);						
		Helper.compareEquals(testConfig, "Settlement Date Range", "Settlement Date Range", StlDateRange.getText().trim());
		Helper.compareEquals(testConfig, "File Types:", "File Types:", FileTypes.getText().trim());
		Helper.compareEquals(testConfig, "835s", "835s", FileType835.getAttribute("value"));
		Helper.compareEquals(testConfig, "Payer PRAs", "Payer PRAs", FileTypePRA.getAttribute("value"));
		Helper.compareEquals(testConfig, "EPRAs", "EPRAs", FileTypeEPRA.getAttribute("value"));
		
		if(userType.equalsIgnoreCase("BS") || userType.equalsIgnoreCase("PROV")) {
			String PayerSelectionName = PayerSelection.getText().trim();
			Helper.compareEquals(testConfig, "Payer Selection:", "Payer Selection:", PayerSelectionName);
		}
	   return this;	
	}
	
	public PaymentDataFilesUPA verifyErrorWithoutSubmiitingAnyField(String userType) throws Exception
	{
		Browser.wait(testConfig, 2);
		Element.clickByJS(testConfig,btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 2);
		 // To verify Settlement Date Range Error
		Helper.compareEquals(testConfig, "Settlement Error Displays: ", "Settlement Date Range: From and To Dates are required", Settlerror.getText());
		 //to Verify Payer Selection Error
		if(!userType.equalsIgnoreCase("Payer")) {
		 Browser.wait(testConfig, 2);
		 Helper.compareEquals(testConfig, "Payer Error Displays: ", "Payer Selection : Missing Data", PayerError.getText());
		}
		 //to Verify File Types Error
		Browser.wait(testConfig, 2);
		Helper.compareEquals(testConfig, "File Type Error Displays: ", "File Types : Missing Data", FileError.getText()); 
	 	 Browser.wait(testConfig, 2);
	 	
	 	 if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(ResetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		 Browser.wait(testConfig, 2);
		
		 return this;
	 }

	public PaymentDataFilesUPA verifyErrorWithoutSettlementDates(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(ResetBtn, "Reset Button");
			Browser.wait(testConfig, 2);		 
			Element.click(FirstPayer, "First Payer");
		    Element.click(AddBtn, "Add Button");
			Element.click(Eight35ChkBox, "Click on 835 Check Box");
		}
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 2);
		
		Helper.compareEquals(testConfig, "Settlement Error Displays: ", "Settlement Date Range: From and To Dates are required", Settlerror.getText());
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(ResetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		 Browser.wait(testConfig, 2);
		
		return this;
	}
			  
	public PaymentDataFilesUPA verifyErrorWithoutFileType(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(FirstPayer, "First Payer");
			Element.click(AddBtn, "Add Button");
		}
		String date1=testConfig.getRunTimeProperty("setl_dt");
		date1= Helper.changeDateFormat(date1, "yyyy-mm-dd", "mm/dd/yyyy");
		Element.enterData(fromdate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(todate, date1, "To Date: "+date1, "todate");
		
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 2);
		
		Helper.compareEquals(testConfig, "File Type Error Displays: ", "File Types : Missing Data", FileError.getText()); 
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(ResetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		 Browser.wait(testConfig, 2);
		
		return this;
	}
	
	public PaymentDataFilesUPA verifyErrorForMore30days(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(ResetBtn, "Reset Button");
			Browser.wait(testConfig, 2);		
			Element.click(FirstPayer, "First Payers");
			Element.click(AddBtn, "Add Button");
		}
		Element.click(Eight35ChkBox, "Click on 835 Check Box");
			 
		String date1 = Helper.getDateBeforeOrAfterDays(-366,"MM/dd/yyyy");
		String date2= Helper.getCurrentTime("MM/dd/yyyy");
		Element.enterData(fromdate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(todate, date2, "To Date: "+date2, "todate");
		Browser.wait(testConfig, 1);
		Element.click(btnSubmit, "Click on Submit Button");	
		Browser.wait(testConfig, 2);
		Helper.compareEquals(testConfig, "Error for More Than 30 Days Displays: ", "Settlement Date Range : From Date must not be greater than 30 Days prior to To date", SettlErrorMore30Days.getText());
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(ResetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		
		Browser.wait(testConfig, 2);		
		return this;
	}
  
	public PaymentDataFilesUPA verifyErrorForPriorDates(String userType) throws Exception
	{
		if(!userType.equalsIgnoreCase("Payer")) {
			Element.click(FirstPayer, "First Payer");
			Element.click(AddBtn, "Add Button");
		}
		Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 
		String date1=Helper.getCurrentDate("MM/dd/yyyy");
		String date2 = Helper.getDateBeforeOrAfterDays(366,"MM/dd/yyyy");
		Element.enterDataByJS(testConfig, fromdate, date1,  " fromdate");
		Element.enterDataByJS(testConfig, todate, date2, " todate");
		Browser.wait(testConfig, 1);
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 2);
		 
		Helper.compareEquals(testConfig, "Error for Prior Days Displays: ", "Settlement Date Range : To and From Dates must be prior to or same as current date.", SettlmntDatePriorError.getText());
		if(!userType.equalsIgnoreCase("Payer")) {
	 		Element.click(ResetBtn, "Reset Button");
	 	}
	 	else
	 		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		 Browser.wait(testConfig, 2);
		return this;
	}

	public PaymentDataFilesUPA verifyErrorForPayerSelection() throws Exception
	{
		Browser.wait(testConfig, 2);
		String date1=Helper.getCurrentDate("MM/dd/yyyy");
		Element.enterDataByJS(testConfig, fromdate, date1, "From Date: "+date1+ "fromdate");
		Element.enterDataByJS(testConfig, todate, date1, "From Date: "+date1+ "todate");
		Element.click(Eight35ChkBox, "Click on 835 Check Box");
		Browser.wait(testConfig, 1);
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 2);	   
		
		//Verify Payer Selection Error Message
		String PayerSelectErrorMsg = PayerError.getText();
		testConfig.softAssert.assertEquals(PayerSelectErrorMsg, "Payer Selection : Missing Data", "Payer Selection Error Displays: " + PayerSelectErrorMsg);
		
		Element.click(ResetBtn, "Reset Button");
		testConfig.softAssert.assertAll();
		Browser.wait(testConfig, 2);
		return this;	   
	}
	
	 
	public PaymentDataFilesUPA enterPaymentDate() throws InterruptedException, Exception 
	{
		 String dateEntered= Helper.changeDateFormat(testConfig.getRunTimeProperty("setl_dt"), "yyyy-mm-dd", "mm/dd/yyyy");
		 Element.enterData(fromdate, dateEntered, "From Date Entered: "+dateEntered, "fromdate");
		 Element.enterData(todate, dateEntered, "To Date Entered: "+dateEntered, "todate");
		 Browser.wait(testConfig, 3);
		 return this;
	}
		   
	public PaymentDataFilesUPA verifyAllFilesTypes() throws Exception
	{		
		 testConfig.softAssert.assertEquals(FileType835.getAttribute("value"), "835s", "FileTypes Displays for 835.");		
		 testConfig.softAssert.assertEquals(FileTypePRA.getAttribute("value"), "Payer PRAs", "FileTypes Displays for PPRA.");		 	   
		 testConfig.softAssert.assertEquals(FileTypeEPRA.getAttribute("value"), "EPRAs", "FileTypes Displays for EPRA.");
		 
		 return this;
	}

	public PaymentDataFilesUPA verifySubmitEPRAsDataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 2);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		
		 return this;
	}
	
	public PaymentDataFilesUPA verifySubmitPPRAsDataBundle() throws Exception
	{
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 2);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for PPRA File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 return this;
	}

	public PaymentDataFilesUPA verifySubmit835DataBundle() throws Exception
	{
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 2);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for 835 File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA verifySubmitEPRAnPPRADataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 2);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and PPRA File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
	
		 return this;
	}

	public PaymentDataFilesUPA verifySubmitEPRAn835DataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 2);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and 835 File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 return this;
	}

	public PaymentDataFilesUPA verifySubmitPPRA835DataBundle() throws Exception
	{
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 2);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for PPRA and 835 File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA verifySubmitAlltypeDataBundle() throws Exception
	{
		 Element.click(epraChkbox, "Click on EPRA Check Box");
		 Element.click(praChkbox, "Click on PPRA Check Box");
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 2);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for All File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);

		 return this;
	}
	 
	public PaymentDataFilesUPA DownloadDataBundle() throws Exception
	{
		 Element.click(DownloadDataBundle, "Click on Download Data Bundle Tab");
		 Browser.wait(testConfig, 2);
		
		 //verify that we are on the page
		 String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download";
		 if(DownloadDataBundlePage.getText().contains(expectedNote)) {
			 Log.Pass("User has been navigated to Download Data Bundle Page. Text Displayed: "+DownloadDataBundlePage.getText());
		 }
		 else {
			 testConfig.softAssert.assertEquals(DownloadDataBundlePage.getText(), expectedNote, "Incorrect Navigation to Download Data Bundle Page");
		 }
		 
		 //Click on the View Bundle Detail Link for the Latest entry
		 String tin= testConfig.getRunTimeProperty("tin");
		 WebElement ViewDetailLink= Element.findElement(testConfig, "xpath", "(//td[contains(text(),'"+tin+"')])[1]/following-sibling::td/a");
		 Element.click(ViewDetailLink, "View Detail Link");
		 Browser.wait(testConfig, 2);
		 
		 //verifies user navigated to Download Data Bundle - Bundle Details
		 Helper.compareEquals(testConfig, "Navigation to Download Data Bundle Page", "Download Data Bundle - Bundle Details", SubHeader.getText());
		 
		 //verify the filename:
		 Helper.compareEquals(testConfig, "File Name Not Generated", "Bundle File Name: N/A", BundleFileName.getText().trim());
		 
		return this;
	}
	 
	public PaymentDataFilesUPA EPRAFileType() throws Exception
	{
		 DownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: EPRA", "File Types selected for this bundle: EPRAs", BundleFileType.getText().trim());
		  
		 return this;
	}
	
	public PaymentDataFilesUPA PPRAFileType() throws Exception
	{
		 DownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: PPRA", "File Types selected for this bundle: Payer PRAs", BundleFileType.getText().trim());
		 
		 return this;
	}
	
	public PaymentDataFilesUPA eight35FileType() throws Exception
	{
		DownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s", "File Types selected for this bundle: 835s", BundleFileType.getText().trim());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA EPRAnPPRAFileType() throws Exception
	{
		DownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer PRAs, EPRAs", "File Types selected for this bundle: Payer PRAs, EPRAs", BundleFileType.getText().trim()); 
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA EPRAn835FileType() throws Exception
	{
		DownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer 835, EPRAs", "File Types selected for this bundle: 835s, EPRAs", BundleFileType.getText().trim());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA PPRAn835FileType() throws Exception
	{
		DownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s, Payer PRAs", "File Types selected for this bundle: 835s, Payer PRAs", BundleFileType.getText().trim());
		 
		 return this;
	}
	 
	public PaymentDataFilesUPA EPRAn835nPPRAFileType() throws Exception
	{
		DownloadDataBundle();
		 Helper.compareEquals(testConfig, "File Type Selected: All", "File Types selected for this bundle: 835s, Payer PRAs, EPRAs", BundleFileType.getText().trim());
		 
		 return this;
	}

	public PaymentDataFilesUPA downloadBundlePage() throws Exception
	{
		 Element.click(DownloadDataBundle, "Click on Download Data Bundle Tab");
		 Browser.wait(testConfig, 3);
		
		 //verify that we are on the page
		 String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download";
		 Helper.compareContains(testConfig, "Navigation to Download Data Bundle Page", expectedNote, DownloadDataBundlePage.getText());

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
		Browser.wait(testConfig, 5);
		List<String> PayerListUI=new ArrayList<>();
		List<WebElement> payer =Element.findElements(testConfig, "xpath", "//select[@name='availablePayerTinNbrs']/option");
				for(int i=1; i<= payer.size(); i++)
		{
			String  Payr = Element.findElement(testConfig, "xpath", "//select[@name='availablePayerTinNbrs']/option["+i+"]").getText().trim();
			PayerListUI.add(Payr);
		}   
		   Browser.wait(testConfig, 3);
		   sqlRowNo = 1347;
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
	
	 public PaymentDataFilesUPA verifyButtonsList() throws Exception
	 {
		 Browser.wait(testConfig, 1);		 
		 testConfig.softAssert.assertTrue(AddBtn.isDisplayed(), "Add Button Present in Create Data Bundle Page");		 
		 testConfig.softAssert.assertTrue(AddAllBtn.isDisplayed(), "Add All Button Present in Create Data Bundle Page");		 		 
		 testConfig.softAssert.assertTrue(RemoveBtn.isDisplayed(), "Remove Button Present in Create Data Bundle Page");		   		 
		 testConfig.softAssert.assertTrue(RemoveAllBtn.isDisplayed(), "Remove All Button Present in Create Data Bundle Page");
		   
		 return this;	
	 }
	   
	 public PaymentDataFilesUPA verifyAddButton() throws Exception
	 {	
		 Browser.wait(testConfig, 1);
		 Element.click(FirstPayer, "First Payer");
		 Element.click(AddBtn, "Add Button");
		 testConfig.softAssert.assertEquals(SelectedFirstPayer.getText(), FirstPayer.getText(), "Add Button Functionality");
		 return this;	
	 }
		   
	 public PaymentDataFilesUPA verifyRemoveButton() throws Exception
	 {
		 Browser.wait(testConfig, 1);
		 Element.click(FirstPayer, "First Payer");
		 Element.click(RemoveBtn, "Remove Button");
		 testConfig.softAssert.assertEquals(AvailablePayer.getText().trim(), "First Payer", "Remove Button Functionality");
		 return this;
	 }
	 public PaymentDataFilesUPA verifyAddAllButton() throws Exception
	 {
		 Browser.wait(testConfig, 1);
		 List<WebElement> list1= Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
		 Element.click(AddAllBtn, "Add All Button");
		 List<WebElement> list2= Element.findElements(testConfig, "xpath", "//*[@name='selectedPayerTinNbrs']/option");
		 testConfig.softAssert.assertEquals(list2.size(), list1.size(), "Add All Functionality");
		 return this;	
	 }
		   
	 public PaymentDataFilesUPA verifyRemoveAllButton() throws Exception
	 {
		 Browser.wait(testConfig, 1);
		 List<WebElement> list2= Element.findElements(testConfig, "xpath", "//*[@name='selectedPayerTinNbrs']/option");
		 Element.click(RemoveAllBtn, "Remove All Button");
		 List<WebElement> list1=Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
		 testConfig.softAssert.assertEquals(list1.size(), list2.size(), "Remove All Functionality");
		 
		 return this;
	 }
	 
	 public PaymentDataFilesUPA verifyResetButton() throws Exception
	 {
		 Browser.wait(testConfig, 1);
		 List<WebElement> list1= Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
		 Element.clickByJS(testConfig,AddAllBtn, "Add All Button");
		 List<WebElement> list2= Element.findElements(testConfig, "xpath", "//*[@name='selectedPayerTinNbrs']/option");
		 if(list1.size() == list2.size())
		 {
			 Browser.wait(testConfig, 1);
			 Element.clickByJS(testConfig,ResetBtn, "Reset Button");
			 List<WebElement> list3=Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
			 testConfig.softAssert.assertEquals(list1.size(), list3.size(), "Reset Functionality");
		 }
		 else {
			 testConfig.softAssert.assertEquals(list2.size(), list1.size(), "Add All Functionality");
		 }
		 
		 testConfig.softAssert.assertAll();
		 return this;
	 }


	 public PaymentDataFilesUPA verifyPayerSelection(String userType) throws Exception
	 {
		 if(!userType.equalsIgnoreCase("Payer"))
		 Element.click(AddAllBtn, "Add All Button");
		 Browser.wait(testConfig, 3);
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
}
