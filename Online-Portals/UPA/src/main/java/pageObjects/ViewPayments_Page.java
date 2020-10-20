package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

//import main.java.Utils.Config;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.fislServices.FISLConnection2;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.stepDefinitions.RemittanceDetail.RemittanceDetailSteps;

public class ViewPayments_Page {
	
	//Writing all Locators here
	
	@FindBy(xpath = "//a[contains(text(),'View Payments')]") WebElement viewPaymentsTab;
	@FindBy(xpath = "//input[@name='providerTIN']") WebElement enterTIN;
	@FindBy(xpath = "//input[@name='btnSubmit']") WebElement seacrhBtn;
	@FindBy(xpath = "//select[@id='periodId']") WebElement quickSeacrhDrpDwn;
	@FindBy(xpath = "//select[@name='filterPayments']") WebElement filterPaymentsDrpDwn;
	@FindBy(xpath = "//select[@id='mktTypeId']") WebElement mrktTypeDrpDwn;
	@FindBy(xpath = "//select[@id='payerFilterType']") WebElement payerDrpDwn;
	@FindBy(xpath = "//select[@id='archiveFilterType']") WebElement archiveDrpDwn;
	@FindBy(xpath = "//td[contains(text(),'Record Count:')]") WebElement record;
	@FindBy(xpath = "//input[@name='btnSubmit']") WebElement searchBtn;
	@FindBy(xpath = "//a[@id='paymentNbr_1']") WebElement firstPaymentNumber;
	@FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td/table/tbody/tr[2]/td[1]/span[1]") WebElement firstPayerName;
	@FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td/table/tbody/tr[2]/td[1]/span[1] ") WebElement payerUI;
	@FindBy(xpath = "//a[@id='paymentNbr_1']") WebElement paymentNo1;
	@FindBy(xpath = "//select[@id='periodId']") WebElement quickSearch;
	@FindBy(xpath = "//select[@id='mktTypeId']") WebElement marketTyp;
	@FindBy(xpath = "//select[@id='payerFilterType']") WebElement payerDrpDown;
	@FindBy(xpath = "//select[@name='filterPayments']") WebElement filterDrpDown;
	@FindBy(xpath = "//td[starts-with(text(),'Payment Number')]/a") WebElement paymentNumHyper;
	@FindBy(xpath = "//td[@class='subheader']") WebElement viewPaymentsSubHeader;
	@FindBy(xpath = "//td[starts-with(text(),'Organization:')]") WebElement orgHeader;
	@FindBy(xpath = "//select[@id='archiveFilterType']") WebElement activeDrpDown;
	@FindBy(xpath = "//a[contains(text(),'Payer')]") WebElement payerHeader;
	@FindBy(xpath = "//td[contains(text(),'Payer')]") WebElement payerHeaderPrintPaymentSummary;
	@FindBy(xpath = "//a[contains(text(),'Payment Date')]") WebElement payDateHeader;
	@FindBy(xpath = "//a[contains(text(),'NPI')]") WebElement npiHeader;
	@FindBy(xpath = "//a[contains(text(),'Payment Number')]") WebElement paymentNum;
	@FindBy(xpath = "//th[contains(text(),'Proxy')]") WebElement proxyNum;
	@FindBy(xpath = "//a[contains(text(),'Amount')]") WebElement amountHeader;
	@FindBy(xpath = "//a[starts-with(text(),'Type')]") WebElement typeHeader;
	@FindBy(xpath = "//th[starts-with(text(),'Payment')]") WebElement paymentStatusHeader;
	@FindBy(xpath = "//th[contains(text(),'Redemption')]") WebElement redemptionHeader;
	@FindBy(xpath = "//a[contains(text(),'Market Type')]") WebElement marketTypeHeader;
	@FindBy(xpath = "//span[contains(text(),'Returned Reason')]") WebElement returnedReasonHeader;
	@FindBy(xpath = "//th[contains(text(),'Updated Payment Dt')]") WebElement updatedHeader;
	@FindBy(xpath = "//th[contains(text(),'Resend Payment')]") WebElement resendHeader;
	@FindBy(xpath = "//span[contains(text(),'835 / EPRA')]") WebElement epraHeader;
	@FindBy(xpath = "//span[contains(text(),'Payer')]") WebElement ppraHeader;
	@FindBy(xpath = "//a[contains(text(),'Archive')]") WebElement archiveHeader;
	@FindBy(xpath = "//input[@value='Print Payment Summary']") WebElement printBtn;
	@FindBy(xpath = "//input[@id='saveArchive']") WebElement saveBtn;
	@FindBy(xpath = "//a[@class='exante-default-header-txt-bold'][contains(text(),'Home')]") WebElement homeBtn;
	@FindBy(xpath = "//input[@name='btnSearch']") WebElement srchBtn;
	@FindBy(xpath = "//td[contains(text(),'No payments')]") WebElement errormsg;
	@FindBy(xpath = "//td[@class='errors']") WebElement errormsgcsr;
	@FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td/table/tbody/tr") List<WebElement> payerTable;
		
	
	
	
	
	
	
private TestBase testConfig;
private ViewPaymentsDataProvider dataProvider;

public ViewPayments_Page(TestBase testConfig)
{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
}
	
public void verifyAllOtherDrpDwns() throws Exception
{
//		Element.selectVisibleText(quickSearch,"Last 9-13 months","Quick Search from View Payments");
//		Log.Comment("Quick Search Dropdown Selected: Last 9-13 months");
	
	String[] arr= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};

    for(String s: arr)
    {
    	Browser.wait(testConfig, 5);
        Element.selectVisibleText(quickSearch,s,"Quick Search from View Payments");
        Browser.wait(testConfig, 5);
        
        try{
        	
        	if(!errormsg.isDisplayed())
        	{	
        	    System.out.println("Error Message is not displayed");
        		break;
        	}	
        }
        catch(NoSuchElementException e)
    	{
        	break;
         }
    }

		Element.selectVisibleText(marketTyp,"Show All","Market Type from View Payments");
		Log.Comment("Market Type Dropdown Selected: Show All");
		Browser.wait(testConfig, 7);

		Element.selectVisibleText(payerDrpDown,"Show All","Payer Dropdown from View Payments");
		Log.Comment("PayerDrpDown Dropdown Selected: Show All");
		Browser.wait(testConfig, 5);
		
		Element.selectVisibleText(archiveDrpDwn,"Show All","Active/Archived Payments Dropdown from View Payments");
		Log.Comment("Active/Archived Payments Dropdown Selected: Show All");
		Browser.wait(testConfig, 5);
		
		Element.selectVisibleText(filterDrpDown,"Show All","Filter Payments Dropdown from View Payments");
		Log.Comment("Filter Payments Dropdown Selected: Show All");
		Browser.wait(testConfig, 5);
    
}
	
public void verifyAllOtherDrpDwnsinUPA() throws Exception
{
	
	String[] arr= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};

    for(String s: arr)
    {
        Element.selectVisibleText(quickSearch,s,"Quick Search from View Payments");
   
        
        try{
        	
        	if(!errormsg.isDisplayed())
        		break;
        }
        catch(NoSuchElementException e)
    	{
        	break;
         }

	Element.selectVisibleText(marketTyp,"Show All","Market Type from View Payments");
	Log.Comment("Market Type Dropdown Selected: Show All");

	Element.selectVisibleText(filterDrpDown,"Show All","Filter Payments Dropdown from View Payments");
	Log.Comment("Filter Payments Dropdown Selected: Show All");
	
    }
//	
//	
//		Element.selectVisibleText(quickSearch,"Last 9-13 months","Quick Search from View Payments");
//		Log.Comment("Quick Search Dropdown Selected: Last 9-13 months");
//
//		Element.selectVisibleText(marketTyp,"Show All","Market Type from View Payments");
//		Log.Comment("Market Type Dropdown Selected: Show All");
//
//		Element.selectVisibleText(filterDrpDown,"Show All","Filter Payments Dropdown from View Payments");
//		Log.Comment("Filter Payments Dropdown Selected: Show All");
}



public void verifyAllColumnsViewPay(String TimePeriod) 
{
	
	String[] arr= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};
	
	if (TimePeriod.equals("Last 30 days"))
	Element.selectVisibleText(quickSearch,"Last 30 days","Quick Search from View Payments");
	if (TimePeriod.equals("Last 60 days"))
	Element.selectVisibleText(quickSearch,"Last 60 days","Quick Search from View Payments");
	if (TimePeriod.equals("Last 90 days"))
	Element.selectVisibleText(quickSearch,"Last 90 days","Quick Search from View Payments");
	if (TimePeriod.equals("Last 4-6 months"))
	Element.selectVisibleText(quickSearch,"Last 4-6 months","Quick Search from View Payments");
	if (TimePeriod.equals("Last 6-9 months"))
	Element.selectVisibleText(quickSearch,"Last 6-9 months","Quick Search from View Payments");
	if (TimePeriod.equals("Last 9-13 months"))
	Element.selectVisibleText(quickSearch,"Last 9-13 months","Quick Search from View Payments");
		

		Element.selectVisibleText(marketTyp,"Show All","Market Type from View Payments");
		Log.Comment("Market Type Dropdown Selected: Show All");

		Element.selectVisibleText(filterDrpDown,"Show All","Filter Payments Dropdown from View Payments");
		Log.Comment("Filter Payments Dropdown Selected: Show All");
		Element.selectVisibleText(activeDrpDown,"Show All","Payments type Dropdown from View Payments");
		Log.Comment("Payments Type Dropdown Selected: Show All");
//		int sqlRowNo=246;
//		String tin=System.getProperty("tin");
//		testConfig.putRunTimeProperty("tin", tin);
//		 Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//		 testConfig.putRunTimeProperty("dspl_consl_pay_nbr",tinNumbers.get("CP_DSPL_CONSL_PAY_NBR").toString());
}


public void verifyAllOtherDrpDwnsinUPAPayer() throws Exception 
{

	    
	    String[] arr= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};

	    for(String s: arr)
	    {
	        Element.selectVisibleText(quickSearch,s,"Quick Search from View Payments");
	   
	        
	        try{
	        	
	        	if(!errormsg.isDisplayed())
	        		break;
	        }
	        catch(NoSuchElementException e)
	    	{
	        	break;
	         }

		Element.selectVisibleText(marketTyp,"Show All","Market Type from View Payments");
		Log.Comment("Market Type Dropdown Selected: Show All");

		Element.selectVisibleText(filterDrpDown,"Show All","Filter Payments Dropdown from View Payments");
		Log.Comment("Filter Payments Dropdown Selected: Show All");
		
	    }
}



public void verifyPaymentNumberHypherLinkClaimDtl() throws Exception
{
	
	Element.click(paymentNumHyper, "Payment Number Hyper Link");
	Browser.wait(testConfig, 5);
	
	Boolean filterDrpDownUI = filterDrpDown.isDisplayed();
	Helper.compareEquals(testConfig, "Filter Payments Drop Down", true, filterDrpDownUI);
	
	Boolean quickSearchUI = quickSearch.isDisplayed();
	Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);
	
	Boolean marketTypUI = marketTyp.isDisplayed();
	Helper.compareEquals(testConfig, "Market Type Drop Down", true, marketTypUI);
	
	Boolean activeDrpDownUI = activeDrpDown.isDisplayed();
	Helper.compareEquals(testConfig, "Active/Archived Payments Drop Down", true, activeDrpDownUI);
	
	Boolean payerHeaderUI = payerHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Payer Header", true, payerHeaderUI);
	
	Boolean npiHeaderUI = npiHeader.isDisplayed();
	Helper.compareEquals(testConfig, "NPI Header", true, npiHeaderUI);
	
	Boolean paymentNumUI = paymentNum.isDisplayed();
	Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNumUI);
	
	Boolean proxyNumUI = proxyNum.isDisplayed();
	Helper.compareEquals(testConfig, "Proxy Number Header", true, proxyNumUI);
	
	Boolean amountHeaderUI = amountHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Amount Header", true, amountHeaderUI);
	
	Boolean typeHeaderUI = typeHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Type Header", true, typeHeaderUI);
	
	Boolean paymentStatusHeaderUI = paymentStatusHeader.isDisplayed();
	Helper.compareEquals(testConfig, "PaymentStatus Header", true, paymentStatusHeaderUI);
	
	Boolean redemptionHeaderUI = redemptionHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Redemption Date Header", true, redemptionHeaderUI);
	
	Boolean marketTypeHeaderUI = marketTypeHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Market Type Header", true, marketTypeHeaderUI);
	
	Boolean updatedHeaderUI = updatedHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Updated Payment Date Header", true, updatedHeaderUI);
	
	Boolean resendHeaderUI = resendHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Resend Payment Header", true, resendHeaderUI);
	
	Boolean epraHeaderUI = epraHeader.isDisplayed();
	Helper.compareEquals(testConfig, "835/EPRA Header", true, epraHeaderUI);
	
	Boolean ppraHeaderUI = ppraHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Payer PRA Header", true, ppraHeaderUI);
	
	Boolean archiveHeaderUI = archiveHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Archive Header", true, archiveHeaderUI);
	
	Boolean printBtnUI = printBtn.isDisplayed();
	Helper.compareEquals(testConfig, "Print Button", true, printBtnUI);
	
	Boolean saveBtnUI = saveBtn.isDisplayed();
	Helper.compareEquals(testConfig, "Save Button", true, saveBtnUI);

	
}


public void clickViewPaymentsTab() throws Exception
{
	
	 Browser.wait(testConfig, 5);
     Element.clickByJS(testConfig,viewPaymentsTab, "View Payments");
	
}


public void verifyPayNumHypherLinkClaimDtlUPA() throws Exception
{
	
	Element.click(paymentNumHyper, "Payment Number Hyper Link");
	Browser.wait(testConfig, 5);
	
	Boolean filterDrpDownUI = filterDrpDown.isDisplayed();
	Helper.compareEquals(testConfig, "Filter Payments Drop Down", true, filterDrpDownUI);
	
	Boolean quickSearchUI = quickSearch.isDisplayed();
	Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);
	
	Boolean marketTypUI = marketTyp.isDisplayed();
	Helper.compareEquals(testConfig, "Market Type Drop Down", true, marketTypUI);
	
	Boolean activeDrpDownUI = activeDrpDown.isDisplayed();
	Helper.compareEquals(testConfig, "Active/Archived Payments Drop Down", true, activeDrpDownUI);
	
	Boolean payerHeaderUI = payerHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Payer Header", true, payerHeaderUI);
	
//	Boolean payDateHeaderUI = payDateHeader.isDisplayed();
//	Helper.compareEquals(testConfig, "Payment Date Header", true, payDateHeaderUI);
	
	Boolean npiHeaderUI = npiHeader.isDisplayed();
	Helper.compareEquals(testConfig, "NPI Header", true, npiHeaderUI);
	
	Boolean paymentNumUI = paymentNum.isDisplayed();
	Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNumUI);
	
	Boolean proxyNumUI = proxyNum.isDisplayed();
	Helper.compareEquals(testConfig, "Proxy Number Header", true, proxyNumUI);
	
	Boolean amountHeaderUI = amountHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Amount Header", true, amountHeaderUI);
	
	Boolean typeHeaderUI = typeHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Type Header", true, typeHeaderUI);
	
	Boolean paymentStatusHeaderUI = paymentStatusHeader.isDisplayed();
	Helper.compareEquals(testConfig, "PaymentStatus Header", true, paymentStatusHeaderUI);
	
	Boolean redemptionHeaderUI = redemptionHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Redemption Date Header", true, redemptionHeaderUI);
	
	Boolean marketTypeHeaderUI = marketTypeHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Market Type Header", true, marketTypeHeaderUI);

	Boolean epraHeaderUI = epraHeader.isDisplayed();
	Helper.compareEquals(testConfig, "835/EPRA Header", true, epraHeaderUI);
	
	Boolean ppraHeaderUI = ppraHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Payer PRA Header", true, ppraHeaderUI);
	
	Boolean archiveHeaderUI = archiveHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Archive Header", true, archiveHeaderUI);
	
	Boolean printBtnUI = printBtn.isDisplayed();
	Helper.compareEquals(testConfig, "Print Button", true, printBtnUI);
	
// 	Boolean saveBtnUI = saveBtn.isDisplayed();
//	Helper.compareEquals(testConfig, "Save Button", true, saveBtnUI);

	
}

public void verifyPayNumHypherLinkClaimDtlPayer() throws Exception
{
	
	Element.click(paymentNumHyper, "Payment Number Hyper Link");
	Browser.wait(testConfig, 5);
	
	Boolean filterDrpDownUI = filterDrpDown.isDisplayed();
	Helper.compareEquals(testConfig, "Filter Payments Drop Down", true, filterDrpDownUI);
	
	Boolean quickSearchUI = quickSearch.isDisplayed();
	Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);
	
	Boolean marketTypUI = marketTyp.isDisplayed();
	Helper.compareEquals(testConfig, "Market Type Drop Down", true, marketTypUI);
	
	Boolean payerHeaderUI = payerHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Payer Header", true, payerHeaderUI);
	
	Boolean payDateHeaderUI = payDateHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Payment Date Header", true, payDateHeaderUI);
	
	Boolean npiHeaderUI = npiHeader.isDisplayed();
	Helper.compareEquals(testConfig, "NPI Header", true, npiHeaderUI);
	
	Boolean paymentNumUI = paymentNum.isDisplayed();
	Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNumUI);
	
	Boolean proxyNumUI = proxyNum.isDisplayed();
	Helper.compareEquals(testConfig, "Proxy Number Header", true, proxyNumUI);
	
	Boolean amountHeaderUI = amountHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Amount Header", true, amountHeaderUI);
	
	Boolean typeHeaderUI = typeHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Type Header", true, typeHeaderUI);
	
	Boolean paymentStatusHeaderUI = paymentStatusHeader.isDisplayed();
	Helper.compareEquals(testConfig, "PaymentStatus Header", true, paymentStatusHeaderUI);
	
	Boolean redemptionHeaderUI = redemptionHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Redemption Date Header", true, redemptionHeaderUI);
	
	Boolean marketTypeHeaderUI = marketTypeHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Market Type Header", true, marketTypeHeaderUI);

	Boolean epraHeaderUI = epraHeader.isDisplayed();
	Helper.compareEquals(testConfig, "835/EPRA Header", true, epraHeaderUI);
	
	Boolean ppraHeaderUI = ppraHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Payer PRA Header", true, ppraHeaderUI);
	
	Boolean printBtnUI = printBtn.isDisplayed();
	Helper.compareEquals(testConfig, "Print Button", true, printBtnUI);

	
  }



public void verifyDisable()
{
	Boolean quickSearchUI = quickSearch.isDisplayed();
	Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);
	
	Boolean activeDrpDownUI = activeDrpDown.isDisplayed();
	Helper.compareEquals(testConfig, "Active/Archived Payments Drop Down", true, activeDrpDownUI);	
//	if (archiveDrpDwn == null)
//		Log.Comment("Save Archive Changes button is not on the Page");
}

	public void selectTimePeriod(String TimePeriod) {

		if (TimePeriod.equals("Last 30 days"))
			Element.selectVisibleText(quickSearch, "Last 30 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 60 days"))
			System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
			Element.selectVisibleText(quickSearch, "Last 60 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 90 days"))
			Element.selectVisibleText(quickSearch, "Last 90 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 4-6 months"))
			Element.selectVisibleText(quickSearch, "Last 4-6 months", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 6-9 months"))
			Element.selectVisibleText(quickSearch, "Last 6-9 months", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 9-13 months"))
			Element.selectVisibleText(quickSearch, "Last 9-13 months", "Quick Search from View Payments");

	}

	public void selectMarketType(String filter) {
			Element.selectVisibleText(marketTyp, filter, "Market Type filter selected on View Payments as :" + filter);
	}

	public void verifyPayerText(String credentials) {
		if (credentials.equals("CSR")) {
			Helper.compareEquals(testConfig, "Payer Text", "Payer", payerHeader.getText());
		} else {
			Helper.compareEquals(testConfig, "Payer Text", "Payer", payerHeader.getText());
			Browser.scrollToBottom(testConfig);
			Element.click(printBtn, "Print Payment Summary");
			String oldWindow = Browser.switchToNewWindow(testConfig, "printPaymentSummary.do");
			Helper.compareEquals(testConfig, "Payer Text", "Payer", payerHeaderPrintPaymentSummary.getText());
			Browser.switchToParentWindow(testConfig, oldWindow);
		}
	}

	
	public void verifyEPRAAndPayerPRA(String credentials) {
		if (credentials.equals("CSR")) {
			if (payerTable.get(2).findElements(By.tagName("td")).get(9).getText().contentEquals("Patient Payments")) {
				Helper.compareEquals(testConfig, "Payer PRA", "N/A", payerTable.get(2).findElements(By.tagName("td")).get(17).getText());
				payerTable.get(2).findElements(By.tagName("td")).get(14).isDisplayed();
				Helper.compareEquals(testConfig, "835", "835", payerTable.get(2).findElements(By.tagName("td")).get(14).getText());
				Helper.compareEquals(testConfig, "EPRA", "N/A", payerTable.get(2).findElements(By.tagName("td")).get(16).getText());

		} }else {
			Helper.compareEquals(testConfig, "Payer PRA", "N/A", payerTable.get(2).findElements(By.tagName("td")).get(14).getText());
			payerTable.get(2).findElements(By.tagName("td")).get(11).isDisplayed();
			Helper.compareEquals(testConfig, "835", "835", payerTable.get(2).findElements(By.tagName("td")).get(11).getText());
			Helper.compareEquals(testConfig, "EPRA", "N/A", payerTable.get(2).findElements(By.tagName("td")).get(13).getText());
		}
	}

	public void verifyandClickPayment() throws Exception
	{
		Boolean firstPaymentNbr = firstPaymentNumber.isDisplayed();
		Helper.compareEquals(testConfig, "First payment Number", true, firstPaymentNbr);
	    Element.clickByJS(testConfig,firstPaymentNumber, "First payment Number");
		
	}


}
