package main.java.pageObjects;

import java.io.IOException;
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

public class PaymentDataFiles_BS extends TestBase{

	@FindBy(id = "taxIndNbrId")
	WebElement drpDwnTin;
	@FindBy(id = "tabDataFiles")
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
	@FindBy(xpath = "//span[contains(text(),'Provider:')]")
	WebElement Provider;
	@FindBy(xpath = "//span[contains(text(),'TIN:')]") 
	WebElement TINvisible;
	@FindBy(xpath = "//td[contains(text(),'Settlement Date Range')]") 
	WebElement StlDateRange;
	@FindBy(xpath = "//td[contains(text(),'File Types:')]")
	WebElement FileTypes;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='835s']")
	WebElement FileType835;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='Payer PRAs']")
	WebElement FileTypePRA;
	@FindBy(xpath = ".//td[@class='runtext']/input[@value='EPRAs']")
	WebElement FileTypeEPRA;
	@FindBy(xpath = "//input[@value='       Add >      ']")
	WebElement AddBtn;
	@FindBy(xpath = "//input[@value='    Add All >>  ']")
	WebElement AddAllBtn;
	@FindBy(xpath = "//input[@value='   < Remove    ']")
	WebElement RemoveBtn;
	@FindBy(xpath = "//input[@value='<< Remove All']") 
	WebElement RemoveAllBtn;
	@FindBy(xpath = "//option[contains(text(),'Rally Pay Member Payments')]") 
	WebElement RallyPayer;
	@FindBy(xpath = "//option[contains(text(),'Rally Pay Member Payments')]") 
	WebElement SelectedRallyPayer;
	@FindBy(xpath = "//select[@name='availablePayerTinNbrs']/option[contains(text(),'Rally Pay Member Payments')]")
	WebElement AvailablePayer;
	@FindBy(xpath = "//*[@name='selectedPayerTinNbrs']")
	WebElement SelectedPayer;
	@FindBy(xpath = "//th[contains(text(),'Please correct the following fields before submit')]") 
	WebElement ErrorHeader;
	@FindBy(xpath = "//font[contains(text(),'Settlement Date Range: From and To Dates are required ')]") 
	WebElement Settlerror;
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
	WebElement prachkbox;
	@FindBy(xpath = "//input[@value = 'EPRAs']") 
	WebElement eprachkbox;
	@FindBy(xpath = "//input[@name = 'settlementDateFrom']") 
	WebElement fromdate;
	@FindBy(xpath = "//input[@name = 'settlementDateTo']") 
	WebElement todate;
	@FindBy(xpath = "//th[contains(text(),'Your bundle has been successfully submitted.')]") 
    WebElement BundleSubmission;
	@FindBy(xpath = "//td[contains(text(),'Payer Selection:')]") 
	WebElement PayerSelection;
	@FindBy(xpath = "//li[contains(text(),'Download Data Bundle')]")
	WebElement DownloadDataBundle;
	@FindBy(xpath = "(//tr[@class='subheadernormal'])[2]")
	WebElement DownloadDataBundlePage;
	@FindBy(xpath = "(//u[contains(text(),'View Bundle Detail')])[1]")
	WebElement ViewDetailLink;
	@FindBy(xpath = "(//td[@class='runtext'])[1]")
	WebElement BundleFileName;
	@FindBy(xpath = "(//td[@class='runtext'])[2]")
	WebElement BundleFileType;
	@FindBy(xpath = "//input[@name='paProvTinNbr']")
	WebElement TINField;
	@FindBy(xpath = "//input[@name='continueBtn']")
	WebElement SearchButton;
	@FindBy(xpath = "//input[@value='Reset']")
	WebElement ResetBtn;
	@FindBy(xpath = "//body/div[2]")
	WebElement standardPopUp;
	
	
	TestBase testConfig=TestBase.getInstance();
	int sqlRowNo;
	
	public PaymentDataFiles_BS(TestBase testConfig) {
		
//		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		PageFactory.initElements(testConfig.driver, this);
	}
	
	public PaymentDataFiles_BS enterBSTin(String srchCriteria)
	 {
		/*int sqlRow;
		System.out.println("TIN selected for "+srchCriteria);
		
		//Get the Payer from the User
		sqlRow=237;
		Map schema=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String Schema = schema.get("PAYR_SCHM_NM").toString().trim();
		String PayerName = schema.get("PAYR_DSPL_NM").toString().trim();
		System.out.println(Schema);
		System.out.println(PayerName);
		testConfig.putRunTimeProperty("Schema", schema.get("PAYR_SCHM_NM").toString().trim());
		
		sqlRow=238;
		Map paymentdetails=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String Prov_tin_nbr = paymentdetails.get("PROV_TAX_ID_NBR").toString().trim();
		String Setl_dt = paymentdetails.get("SETL_DT").toString().trim();
		
		testConfig.putRunTimeProperty("Prov_tin_nbr", paymentdetails.get("PROV_TAX_ID_NBR").toString().trim());
		testConfig.putRunTimeProperty("Setl_dt", paymentdetails.get("SETL_DT").toString().trim());*/
		
		String Prov_tin_nbr = "860841271";
		String Setl_dt = "2020-04-09";
		
		testConfig.putRunTimeProperty("Prov_tin_nbr", Prov_tin_nbr);
		testConfig.putRunTimeProperty("Setl_dt", Setl_dt);
		
		Element.enterData(TINField, Prov_tin_nbr, "Provider TIN entered: "+Prov_tin_nbr, "TINField");
		Element.click(SearchButton, "Search Button");
		
		return this;
	}
	
	public PaymentDataFiles_BS clickPaymentDataFilesTab() 
	{
		Element.expectedWait(paymentDataFilesTab, testConfig, "Payment Data Files tab","Payment Data Files tab");
		Element.click(paymentDataFilesTab, "Payment Data Files tab");
		return this;

	}
	
	public PaymentDataFiles_BS verifyCreateDataBundlePage() throws Exception
	{

		String DataBundlePage = CreateDataBundle.getText();
		Browser.wait(testConfig, 3);
		Helper.compareEquals(testConfig, "Navigating to Create Data Bundle Page", "Create Data Bundle", DataBundlePage);
	
		Browser.wait(testConfig, 3);
		return  new PaymentDataFiles_BS(testConfig);
	}
	
	public PaymentDataFiles_BS verifyAllValuesinCreateBundlePage() throws Exception

	{
		//String subheader = SubHeader.getText().trim();
		//testConfig.softAssert.assertEquals(subheader, "Payment Data Files", "Subheader message: "+subheader);
		String PageTextContext  = PageText.getText().trim();
		String PageTextActual = "The Payment Data File feature enables faster and easier access to large amounts of payment data. Using this tool you can create data bundles by day, by file type and by payer.";
		testConfig.softAssert.assertEquals(PageTextContext, PageTextActual, "Page Text Context Displays: "+PageTextContext);
		String DetailedInstructions = DetailedInstrctns.getText().trim(); 
		
		testConfig.softAssert.assertEquals(DetailedInstructions, "Detailed Instructions For Bundle Creation", "Detailed Instructions Link Displays: "+DetailedInstructions);
		
		String ProviderName = Provider.getText().trim();
		int sqlRow=236;
		Map orgNameDB=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String orgName = orgNameDB.get("ORG_NM").toString().trim();
		String ProvName = "Provider: "+orgName;
		testConfig.softAssert.assertEquals(ProviderName, ProvName, "Provider Name Displaying:- " +orgName);
		
		
		String SettlementDate = StlDateRange.getText().trim(); 
		testConfig.softAssert.assertEquals(SettlementDate, "Settlement Date Range:", "Settlement Date Text Displaying.");
		
		String FileType = FileTypes.getText().trim(); 
		testConfig.softAssert.assertEquals(FileType, "File Types:", "FileTypes Displaying.");
		
		String FileTyp835 =  FileType835.getAttribute("value");
		testConfig.softAssert.assertEquals(FileTyp835, "835s", "FileTypes Displaying for 835.");
	
		String FileTypPRA =  FileTypePRA.getAttribute("value");
	
		testConfig.softAssert.assertEquals(FileTypPRA, "Payer PRAs", "FileTypes Displaying for PPRA.");
	
	   
		String FileTypEPRA =  FileTypeEPRA.getAttribute("value");
		testConfig.softAssert.assertEquals(FileTypEPRA, "EPRAs", "FileTypes Displaying for EPRA.");

		
		String PayerSelectionName = PayerSelection.getText().trim();
	
		testConfig.softAssert.assertEquals(PayerSelectionName, "Payer Selection:", "PayerSelection Header.");
		
		testConfig.softAssert.assertAll();
	   return this;	
	}
	
	public PaymentDataFiles_BS verifyErrorWithoutSubmiitingAnyField() throws Exception
	{
		Browser.wait(testConfig, 2);
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 3);
		String ErrorHeaderMsg = ErrorHeader.getText();
		 
		 // To verify Settlement Date Range Error
		String SettlerrorMsg = Settlerror.getText();
		testConfig.softAssert.assertEquals(SettlerrorMsg, "Settlement Date Range: From and To Dates are required", "Settlement Error Displays: " + SettlerrorMsg);
		
		 //to Verify Payer Selection Error
		 Browser.wait(testConfig, 3);
		 String PayerErrorMsg = PayerError.getText();
		 testConfig.softAssert.assertEquals(PayerErrorMsg, "Payer Selection : Missing Data", "Payer Error Displays: " + PayerErrorMsg);
		 
		 //to Verify File Types Error
		Browser.wait(testConfig, 3);
		String FileErrorMsg = FileError.getText();
		testConfig.softAssert.assertEquals(FileErrorMsg, "File Types : Missing Data", "File Type Error Displays: " + FileErrorMsg);
		 
		 Log.Pass("All the Three error messages are displaying correctly. Error Messages are Displayed as: "+ErrorHeaderMsg);
	 	 Browser.wait(testConfig, 2);
	 	 Element.click(ResetBtn, "Reset Button");
		 Browser.wait(testConfig, 3);
		 return this;
	 }

	public PaymentDataFiles_BS verifyErrorWithoutSettlementDates() throws Exception
	{
		Element.click(ResetBtn, "Reset Button");
		 Browser.wait(testConfig, 3);
		 Element.click(RallyPayer, "Rally Payer");
		 Element.click(AddBtn, "Add Button");
		 Browser.wait(testConfig, 2);

		Element.click(Eight35ChkBox, "Click on 835 Check Box");
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 3);
		
		String SettlerrorMsg = Settlerror.getText();
		testConfig.softAssert.assertEquals(SettlerrorMsg, "Settlement Date Range: From and To Dates are required", "Settlement Error Displays: " + SettlerrorMsg);
		
		Element.click(ResetBtn, "Reset Button");
		Browser.wait(testConfig, 5);
		return this;
	}
			  
	public String currentDate() 
	{
		String month, day;
		java.util.Date date = new java.util.Date();
		int mmn = date.getMonth()+1; 
		if(mmn==10 || mmn== 11 || mmn == 12)
		{			 month = String.valueOf(mmn);		 }
		else {			 month = "0"+mmn;		 }
		 
		int days = date.getDate();
		if(days<10) 
		{			 day = "0"+days;		 }
		else
		{			 day = String.valueOf(days);		 }
		 
		int year  = date.getYear()+1900;
		 
		String curnt_dt = month + "/" +day+"/"+year;
		return curnt_dt;
	}
	public String SettlementDate()
	{
		String Setl_Dt = testConfig.getRunTimeProperty("Setl_dt");
		String[] sDBDate=Setl_Dt.split("-");  		    
			
		String sDBYear=sDBDate[0];
		String sDBMonth=sDBDate[1];
		String sDBDay=sDBDate[2];
		String SetDate = sDBMonth+"/"+sDBDay+"/"+sDBYear;
		Log.Comment("Payment Date from DB is: " + SetDate);
		return SetDate;
	}
	 
	public PaymentDataFiles_BS verifyErrorWithoutFileType() throws Exception
	{
		Element.click(RallyPayer, "Rally Payer");
		 Element.click(AddBtn, "Add Button");
		
		String date1=SettlementDate();
	
		Browser.wait(testConfig, 1);
		Element.enterData(fromdate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(todate, date1, "To Date: "+date1, "todate");
		
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 3);
		
		String FileErrorMsg = FileError.getText();
		testConfig.softAssert.assertEquals(FileErrorMsg, "File Types : Missing Data", "File Type Error Displays: " + FileErrorMsg);
		Element.click(ResetBtn, "Reset Button");
		Browser.wait(testConfig, 3);
		return this;
	}
	
	public PaymentDataFiles_BS verifyErrorForMore30days() throws Exception
	{
		Element.click(RallyPayer, "Rally Payer");
		Element.click(AddBtn, "Add Button");
		Element.click(Eight35ChkBox, "Click on 835 Check Box");
			 
		String month, day;
		java.util.Date date = new java.util.Date();
		int mmn = date.getMonth()+1; 
		if(mmn==10 || mmn== 11 || mmn == 12)
		{			 month = String.valueOf(mmn);		 }
		else {			 month = "0"+mmn;		 }
		int days = date.getDate();
		if(days<10) 
		{			 day = "0"+days;		 }
		else
		{			 day = String.valueOf(days);		 }
		int year  = date.getYear()+1899;
		String date1 = month + "/" +day+"/"+year;
			 
		String date2 =currentDate();
		Browser.wait(testConfig, 1);
		Element.enterData(fromdate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(todate, date2, "To Date: "+date2, "todate");
		Browser.wait(testConfig, 3);
		Element.click(btnSubmit, "Click on Submit Button");	
		Browser.wait(testConfig, 3);
		String SettlmntErrorMoreThan30Days = SettlErrorMore30Days.getText();
		testConfig.softAssert.assertEquals(SettlmntErrorMoreThan30Days, "Settlement Date Range : From Date must not be greater than 30 Days prior to To date", "Error for More Than 30 Days Displays: " + SettlmntErrorMoreThan30Days);
		
		Element.click(ResetBtn, "Reset Button");
		Browser.wait(testConfig, 3);
		return this;
	}
  
	public PaymentDataFiles_BS verifyErrorForPriorDates() throws Exception
	{
		Element.click(RallyPayer, "Rally Payer");
		 Element.click(AddBtn, "Add Button");
		Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 
		String date1 =currentDate();
		java.util.Date date = new java.util.Date();
		String month, day;
		int mmn = date.getMonth()+1; 
		if(mmn==10 || mmn== 11 || mmn == 12)
		{			 month = String.valueOf(mmn);		 }
		else {			 month = "0"+mmn;		 }
		int days = date.getDate();
		if(days<10) 
		{			 day = "0"+days;		 }
		else
		{			 day = String.valueOf(days);		 }
		int year  = date.getYear()+1901;
		String date2 = month + "/" +day+"/"+year;
		Browser.wait(testConfig, 1);
		Element.enterData(fromdate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(todate, date2, "To Date: "+date2, "todate");
		Browser.wait(testConfig, 3);
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 3);
		 
		String SettlmntDatePriorErrorMsg = SettlmntDatePriorError.getText();
		testConfig.softAssert.assertEquals(SettlmntDatePriorErrorMsg, "Settlement Date Range : To and From Dates must be prior to or same as current date.", "Error for Prior Days Displays: " + SettlmntDatePriorErrorMsg);
		
		Element.click(ResetBtn, "Reset Button");
		Browser.wait(testConfig, 3);
		return this;
	}

	public PaymentDataFiles_BS verifyErrorForPayerSelection() throws Exception
	{
		Browser.wait(testConfig, 3);
		String date1 = currentDate();
		Element.enterData(fromdate, date1, "From Date: "+date1, "fromdate");
		Element.enterData(todate, date1, "To Date: "+date1, "todate");
		Element.click(Eight35ChkBox, "Click on 835 Check Box");
		Browser.wait(testConfig, 1);
		Element.click(btnSubmit, "Click on Submit Button");
		Browser.wait(testConfig, 3);	   
		
		//Verify Payer Selection Error Message
		String PayerSelectErrorMsg = PayerError.getText();
		testConfig.softAssert.assertEquals(PayerSelectErrorMsg, "Payer Selection : Missing Data", "Payer Selection Error Displays: " + PayerSelectErrorMsg);
		
		Element.click(ResetBtn, "Reset Button");
		testConfig.softAssert.assertAll();
		Browser.wait(testConfig, 3);
		return this;	   
	}
	
	
	public PaymentDataFiles_BS getTINnDate() 
	{
		int sqlRow=233;
		Map<String,String> TINAndSetlDate= new HashMap<String, String>();
		Map displayNo=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
			
		TINAndSetlDate.put("TINNumber", displayNo.get("PROV_TAX_ID_NBR").toString());
		TINAndSetlDate.put("setlDate", displayNo.get("SETL_DT").toString());
		 
		testConfig.putRunTimeProperty("TINNumber", displayNo.get("PROV_TAX_ID_NBR").toString()); 
		testConfig.putRunTimeProperty("setlDate", displayNo.get("SETL_DT").toString());
		return this;
	}
	 
	public PaymentDataFiles_BS enterPaymentDate() throws InterruptedException 
	{
		
		 String DateEntered = SettlementDate();
		 Browser.wait(testConfig, 1);
		 Element.enterData(fromdate, DateEntered, "From Date Entered: "+DateEntered, "fromdate");
		 Element.enterData(todate, DateEntered, "To Date Entered: "+DateEntered, "todate");
		 Browser.wait(testConfig, 3);
		 return this;
	}
		   
	public PaymentDataFiles_BS verifyAllFilesTypes() throws Exception
	{
		 String FileType = FileTypes.getText();
		 String FileTyp835 =  FileType835.getAttribute("value");
		 testConfig.softAssert.assertEquals(FileTyp835, "835s", "FileTypes Displays for 835.");
		
		 String FileTypPRA =  FileTypePRA.getAttribute("value");
		 testConfig.softAssert.assertEquals(FileTypPRA, "Payer PRAs", "FileTypes Displays for PPRA.");
		 	   
		 String FileTypEPRA =  FileTypeEPRA.getAttribute("value");
		 testConfig.softAssert.assertEquals(FileTypEPRA, "EPRAs", "FileTypes Displays for EPRA.");
		 
		 return this;
	}

	public PaymentDataFiles_BS verifySubmitEPRAsDataBundle() throws Exception
	{
		 Element.click(eprachkbox, "Click on EPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 3);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		
		 Browser.wait(testConfig, 7);
		 return this;
	}
	
	public PaymentDataFiles_BS verifySubmitPPRAsDataBundle() throws Exception
	{
		 Element.click(prachkbox, "Click on PPRA Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 3);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for PPRA File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 Browser.wait(testConfig, 7);
		 return this;
	}

	public PaymentDataFiles_BS verifySubmiteight35DataBundle() throws Exception
	{
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 3);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for 835 File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 Browser.wait(testConfig, 7);
		 return this;
	}
	 
	public PaymentDataFiles_BS verifySubmiteprapraDataBundle() throws Exception
	{
		 Element.click(eprachkbox, "Click on EPRA Check Box");
		 Element.click(prachkbox, "Click on PPRA Check Box");
		 //Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 3);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and PPRA File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 Browser.wait(testConfig, 7);
		 return this;
	}

	public PaymentDataFiles_BS verifySubmitepra835DataBundle() throws Exception
	{
		 Element.click(eprachkbox, "Click on EPRA Check Box");
		 //Element.click(prachkbox, "Click on PPRA Check Box");
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 3);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for EPRA and 835 File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 Browser.wait(testConfig, 7);
		 return this;
	}

	public PaymentDataFiles_BS verifySubmitppra835DataBundle() throws Exception
	{
		 //Element.click(eprachkbox, "Click on EPRA Check Box");
		 Element.click(prachkbox, "Click on PPRA Check Box");
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 3);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for PPRA and 835 File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 Browser.wait(testConfig, 7);
		 return this;
	}
	 
	public PaymentDataFiles_BS verifySubmitAlltypeDataBundle() throws Exception
	{
		 Element.click(eprachkbox, "Click on EPRA Check Box");
		 Element.click(prachkbox, "Click on PPRA Check Box");
		 Element.click(Eight35ChkBox, "Click on 835 Check Box");
		 Element.click(btnSubmit, "Click on Submit Button");
		 Browser.wait(testConfig, 3);
		 		   
		 String BundleSubmitMsg = BundleSubmission.getText();
		 Helper.compareEquals(testConfig, "Data Bundle Message for All File Type", "Your bundle has been successfully submitted.", BundleSubmitMsg);
		 
		 Browser.wait(testConfig, 7);
		 return this;
	}
	 
	public PaymentDataFiles_BS downloaddatabundle() throws Exception
	{
		 Element.click(DownloadDataBundle, "Click on Download Data Bundle Tab");
		 Browser.wait(testConfig, 3);
		
		 //verify that we are on the page
		 String PageNote = DownloadDataBundlePage.getText();
		 String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download";
		 if(PageNote.contains(expectedNote)) {
			 Log.Pass("User has been navigated to Download Data Bundle Page. Text Displayed: "+PageNote);
		 }
		 else {
			 testConfig.softAssert.assertEquals(PageNote, expectedNote, "Incorrect Navigation to Download Data Bundle Page");
		 }
		 
		 //Click on the View Bundle Detail Link for the Latest entry
		 Element.click(ViewDetailLink, "View Detail Link");
		 Browser.wait(testConfig, 3);
		 
		 //verifies user navigated to Download Data Bundle - Bundle Details
		 String PageHeader = SubHeader.getText();
		 Helper.compareEquals(testConfig, "Navigation to Download Data Bundle Page", "Download Data Bundle - Bundle Details", PageHeader);
		 
		 //verify the filename:
		 String FileName = BundleFileName.getText().trim();
		 Helper.compareEquals(testConfig, "File Name Not Generated", "Bundle File Name: N/A", FileName);
		 
		return this;
	}
	 
	public PaymentDataFiles_BS eprafiletype() throws Exception
	{
		 downloaddatabundle();
		 String FileType = BundleFileType.getText().trim();
		 Helper.compareEquals(testConfig, "File Type Selected: EPRA", "File Types selected for this bundle: EPRAs", FileType);
		  
		 return this;
	}
	
	public PaymentDataFiles_BS pprafiletype() throws Exception
	{
		 downloaddatabundle();
		 String FileType = BundleFileType.getText().trim();
		 Helper.compareEquals(testConfig, "File Type Selected: PPRA", "File Types selected for this bundle: Payer PRAs", FileType);
		 
		 return this;
	}
	
	public PaymentDataFiles_BS eight35filetype() throws Exception
	{
		 downloaddatabundle();
		 String FileType = BundleFileType.getText().trim();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s", "File Types selected for this bundle: 835s", FileType);
		 
		 return this;
	}
	 
	public PaymentDataFiles_BS epranpprafiletype() throws Exception
	{
		 downloaddatabundle();
		 String FileType = BundleFileType.getText().trim();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer PRAs, EPRAs", "File Types selected for this bundle: Payer PRAs, EPRAs", FileType); 
		 
		 return this;
	}
	 
	public PaymentDataFiles_BS epran835filetype() throws Exception
	{
		 downloaddatabundle();
		 String FileType = BundleFileType.getText().trim();
		 Helper.compareEquals(testConfig, "File Type Selected: Payer 835, EPRAs", "File Types selected for this bundle: 835s, EPRAs", FileType);
		 
		 return this;
	}
	 
	public PaymentDataFiles_BS ppran835filetype() throws Exception
	{
		 downloaddatabundle();
		 String FileType = BundleFileType.getText().trim();
		 Helper.compareEquals(testConfig, "File Type Selected: 835s, Payer PRAs", "File Types selected for this bundle: 835s, Payer PRAs", FileType);
		 
		 return this;
	}
	 
	public PaymentDataFiles_BS epran835npprafiletype() throws Exception
	{
		 downloaddatabundle();
		 String FileType = BundleFileType.getText().trim();
		 Helper.compareEquals(testConfig, "File Type Selected: All", "File Types selected for this bundle: 835s, Payer PRAs, EPRAs", FileType);
		 
		 return this;
	}

	public PaymentDataFiles_BS downloadbundlePage() throws Exception
	{
		 Element.click(DownloadDataBundle, "Click on Download Data Bundle Tab");
		 Browser.wait(testConfig, 3);
		
		 //verify that we are on the page
		 String PageNote = DownloadDataBundlePage.getText();
		 String expectedNote = "Each Payment Data File will be listed below in order of when the data bundle was created, along with the selected data elements. Payment Data Files will be available for download";
		 Helper.compareContains(testConfig, "Navigation to Download Data Bundle Page", expectedNote, PageNote);

		 return this;
	}
	
	public PaymentDataFiles_BS getCompletedIN() 
	{
		 int sqlRow=239;
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
		 {
			 Log.Comment("No FileName retrieved to be Validated");
		 }
		 return this;
	}

	public PaymentDataFiles_BS verifyZipFileName() 
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
		  
	public PaymentDataFiles_BS verifyDatabunldeDb()
	{
		String TIN = testConfig.getRunTimeProperty("Prov_tin_nbr");
		int sqlRow=234;
		Map Indicator=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		testConfig.putRunTimeProperty("DataBundleID", Indicator.get("DATA_BUNDLE_ID").toString());
		testConfig.putRunTimeProperty("835Ind", Indicator.get("INCL_835_IND").toString());
		testConfig.putRunTimeProperty("PPRAInd", Indicator.get("INCL_PAYR_PRA_IND").toString());
		testConfig.putRunTimeProperty("EPRAInd", Indicator.get("INCL_EPRA_IND").toString());
	
		return this;
	}
	
	public PaymentDataFiles_BS verify835Ind()
	{
		 verifyDatabunldeDb();
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
		
	public PaymentDataFiles_BS verifyEPRAInd()
	{
			verifyDatabunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("N") && value835.equalsIgnoreCase("N"))
			{
			Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully  with EPRA indicator as: "+valueEPRA);	
			}
			else {Log.Fail("Error in Data Bundle Request");
			}
			return this;
	}
		
	public PaymentDataFiles_BS verifyPPRAInd()
	{
			verifyDatabunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("N") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("N"))
			{
				Log.Pass("Data Bundle Request with ID "+DataBundleID+"have been Submitted Successfully with PPRA indicator as: "+valuePPRA);	
			}
			else {Log.Fail("Error in Data Bundle Request");
			}
			return this;
	}
	
	public PaymentDataFiles_BS verifyEPRAnPPRAInd()
	{
			verifyDatabunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("N") )
			{
				Log.Pass("Data Bundle Request with ID "+DataBundleID+"have been Submitted Successfully with EPRA indicator as: "+valueEPRA + " and PPRA indicator as: "+valuePPRA);	
			}
			else {Log.Fail("Error in Data Bundle Request");
			}
			return this;
	}
		
	public PaymentDataFiles_BS verifyEPRAn835Ind()
	{
			verifyDatabunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("N") && value835.equalsIgnoreCase("Y") )
			{
				Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with EPRA indicator as: "+valueEPRA + " and 835 indicator as: "+value835);	
			}
			else {Log.Fail("Error in Data Bundle Request");
			}
			return this;
	}
		
	public PaymentDataFiles_BS verifyPPRAn835Ind()
	{
			verifyDatabunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("N") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("Y") )
			{
				Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with PPRA indicator as: "+valuePPRA + " and 835 indicator as: "+value835);	
			}
			else {Log.Fail("Error in Data Bundle Request");
			}
			return this;
	}
		
	public PaymentDataFiles_BS verifyEPRAn835nPPRAInd()
	{
			verifyDatabunldeDb();
			String value835 = testConfig.getRunTimeProperty("835Ind").trim();
			String valuePPRA = testConfig.getRunTimeProperty("PPRAInd").trim();
			String valueEPRA = testConfig.getRunTimeProperty("EPRAInd").trim();
			String DataBundleID = testConfig.getRunTimeProperty("DataBundleID").trim();
			if(valueEPRA.equalsIgnoreCase("Y") && valuePPRA.equalsIgnoreCase("Y") && value835.equalsIgnoreCase("Y") )
			{
				Log.Pass("Data Bundle Request with ID "+DataBundleID+" have been Submitted Successfully with EPRA, PPRA and 835 indicator as Y");	
			}
			else {Log.Fail("Error in Data Bundle Request");
			}
			return this;
	}
		   
	public PaymentDataFiles_BS verifyPayerList() throws InterruptedException, IOException
	{		Browser.wait(testConfig, 5);
		//Map PayerListDB=null;
		
		List<String> PayerListUI=new ArrayList<>();
		List<WebElement> payer =Element.findElements(testConfig, "xpath", "//select[@name='availablePayerTinNbrs']/option");
				for(int i=1; i<= payer.size(); i++)
		{
			String  Payr = Element.findElement(testConfig, "xpath", "//select[@name='availablePayerTinNbrs']/option["+i+"]").getText().trim();
			PayerListUI.add(Payr);
		}
		   
		   Browser.wait(testConfig, 3);
		   sqlRowNo = 231;
		   ArrayList<String> PayerListDB = new ArrayList<String>();
		   HashMap<Integer, HashMap<String, String>> PayerListDB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		   		
		   for (int i = 1; i <= PayerListDB1.size(); i++) 
           {
			   PayerListDB.add(PayerListDB1.get(i).get("PAYR_DSPL_NM"));
           }
		   		   
		   Browser.wait(testConfig, 3);
		   sqlRowNo = 232;
		   ArrayList<String> PayerListDBAll = new ArrayList<String>();
		   HashMap<Integer, HashMap<String, String>> PayerListDB2 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		   for (int i = 1; i <= PayerListDB2.size(); i++) 
           {
			   PayerListDBAll.add(PayerListDB2.get(i).get("PAYR_DSPL_NM"));
           }
		   
		   PayerListDB.addAll(PayerListDBAll);
		   
		   if(PayerListDB.equals(PayerListUI))
		   {
			   Log.Pass("Available Payers:- ");
		   }
		   else {
			   Log.Comment("Payer List Not Matching. Payers from UI: "+PayerListUI + " And List from DB: "+PayerListDB);
		   }
		   
		   return this;
	}
	
	 public PaymentDataFiles_BS verifyButtonsList() throws Exception
	 {
		 Browser.wait(testConfig, 3);
		 Boolean AddButtonPresent = AddBtn.isDisplayed();
		 testConfig.softAssert.assertTrue(AddButtonPresent, "Add Button Present in Create Data Bundle Page");

		 Boolean AddAllButton = AddAllBtn.isDisplayed();
		 testConfig.softAssert.assertTrue(AddAllButton, "Add All Button Present in Create Data Bundle Page");
		 
		 Boolean RemoveButton = RemoveBtn.isDisplayed();
		 testConfig.softAssert.assertTrue(RemoveButton, "Remove Button Present in Create Data Bundle Page");
		   
		 Boolean RemoveAllButton = RemoveAllBtn.isDisplayed();
		 testConfig.softAssert.assertTrue(RemoveAllButton, "Remove All Button Present in Create Data Bundle Page");
		   
		 return this;	
	 }
	   
	 public PaymentDataFiles_BS verifyAddButton() throws Exception
	 {	
		 Browser.wait(testConfig, 3);
		 Element.click(RallyPayer, "Rally Payer");
		 Element.click(AddBtn, "Add Button");
		 testConfig.softAssert.assertEquals(SelectedRallyPayer.getText(), RallyPayer.getText(), "Add Button Functionality");
		 return this;	
	 }
		   
	 public PaymentDataFiles_BS verifyRemoveButton() throws Exception
	 {
		 Browser.wait(testConfig, 3);
		 Element.click(RallyPayer, "Rally Payer");
		 Element.click(RemoveBtn, "Remove Button");
		 testConfig.softAssert.assertEquals(AvailablePayer.getText().trim(), "Rally Pay Member Payments", "Remove Button Functionality");
		 return this;
	 }
	 public PaymentDataFiles_BS verifyAddAllButton() throws Exception
	 {
		 Browser.wait(testConfig, 3);
		 List<WebElement> list1= Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
		 Element.click(AddAllBtn, "Add All Button");
		 List<WebElement> list2= Element.findElements(testConfig, "xpath", "//*[@name='selectedPayerTinNbrs']/option");
		 testConfig.softAssert.assertEquals(list2.size(), list1.size(), "Add All Functionality");
		 return this;	
	 }
		   
	 public PaymentDataFiles_BS verifyRemoveAllButton() throws Exception
	 {
		 Browser.wait(testConfig, 3);
		 List<WebElement> list2= Element.findElements(testConfig, "xpath", "//*[@name='selectedPayerTinNbrs']/option");
		 Element.click(RemoveAllBtn, "Remove All Button");
		 List<WebElement> list1=Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
		 testConfig.softAssert.assertEquals(list1.size(), list2.size(), "Remove All Functionality");
		 
		 return this;
	 }
	 
	 public PaymentDataFiles_BS verifyResetButton() throws Exception
	 {
		 Browser.wait(testConfig, 3);
		 List<WebElement> list1= Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
		 Element.click(AddAllBtn, "Add All Button");
		 List<WebElement> list2= Element.findElements(testConfig, "xpath", "//*[@name='selectedPayerTinNbrs']/option");
		 if(list1.size() == list2.size())
		 {
			 Element.click(ResetBtn, "Reset Button");
			 List<WebElement> list3=Element.findElements(testConfig, "xpath", "//*[@name='availablePayerTinNbrs']/option");
			 testConfig.softAssert.assertEquals(list1.size(), list3.size(), "Reset Functionality");
		 }
		 else {
			 testConfig.softAssert.assertEquals(list2.size(), list1.size(), "Add All Functionality");
		 }
		 
		 testConfig.softAssert.assertAll();
		 return this;
	 }


	 public PaymentDataFiles_BS verifyPayerSelection() throws Exception
	 {
		 Element.click(AddAllBtn, "Add All Button");
		 Browser.wait(testConfig, 3);
		 return this;
	 }
	 
	 
	public PaymentDataFiles_BS clickSubmit()
	{
		Element.click(btnSubmit, "Submit button");
		return this;
	}
 public PaymentDataFiles_BS fetchAndEnterBSTin() {
		int sqlRow=1345;
		testConfig.getRunTimeProperty("id");
		Map schema=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String prov_tin_nbr = schema.get("PROV_TIN_NBR").toString().trim();
		Element.enterData(TINField, prov_tin_nbr, "Provider TIN entered: "+prov_tin_nbr, "TINField");
		Element.click(SearchButton, "Search button");
	 return this;
 }
 public PaymentDataFiles_BS verifyPopUp() {
	 Element.verifyElementPresent(standardPopUp, "Maximize your efficiency pop up");
	 return this;
 }
}
