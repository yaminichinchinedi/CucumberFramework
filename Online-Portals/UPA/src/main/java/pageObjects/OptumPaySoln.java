package main.java.pageObjects;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptumPaySoln {
	private WebDriver driver;
	private TestBase testConfig;
	
	@FindBy(className="wrapperTooltip")
	List <WebElement> titles;

	@FindBy(xpath = "//li[contains(text(),'Please enter a existing 9 digit TIN number.')]") 
	WebElement nonExistingTINmsgOptumPaySol;
	
	@FindBy(xpath = "//li[contains(text(),'Please enter a valid 9 digit TIN number.')]") 
	WebElement InValidTINmsgOptumPaySol;
	
	@FindBy(xpath = "//input[@name='taxIndNbr']") 
    WebElement enterTIN;
	
	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement searchBtn;
	@FindBy(linkText="Change Rate")
	WebElement lnkChangeRate;
	@FindBy(xpath="//*[@id=\"change_rate_reason_selector\"]/option[3]")
	WebElement optionReasonForRateChange;
   @FindBy(xpath="//*[@id=\"optum-pay-options\"]/div[3]/div[2]/input[2]")
   WebElement btnSaveChangeRate;
   @FindBy(id="confirmationModal")
   WebElement popUpChangeRate;
   @FindBy(xpath="/html/body/div[7]/div[3]/div/button[2]")
   WebElement btnChangeRatePopupCancel;
   @FindBy(xpath="/html/body/div[7]/div[3]/div/button[1]")
   WebElement btnChangeRatePopupChange;	
   @FindBy(xpath="//*[@id=\"optum-pay-options\"]/div[1]/div[1]/div[2]")
   WebElement tilePlanType;
   @FindBy(id="logOutId")
   WebElement lnkLogOut;
   @FindBy(xpath="//*[@id='ui-id-3']//div")
	WebElement hoverPlanType;
	@FindBy(xpath="//*[@id='ui-id-4']//div	")
	WebElement hoverRate;
	@FindBy(xpath="//*[@id='ui-id-5']/div")
	WebElement hoverFees;
	@FindBy(xpath="//*[@id='ui-id-6']/div")
	WebElement hoverManageMyPlan;

	@FindBy(id="rate")
	WebElement rateTxtBox;
	
	@FindBy(id="change_rate_reason_selector")
	WebElement rsnRtChngdrpdwn;

	@FindBy(id="otherReasonForChange")
	WebElement otrRsnTxtAra;
	public OptumPaySoln(TestBase testBase)
	{
		this.testConfig=testBase;
		PageFactory.initElements(testConfig.driver, this);
	}
	public OptumPaySoln validateTitleNames(){
	
		ArrayList<String> expectdtitles=new ArrayList<String>(); 
		expectdtitles.add("Plan Type");
		expectdtitles.add("Rate");
		expectdtitles.add("Fees");
		expectdtitles.add("Manage My Plan");
		//String[] titles1={"Plan Type","Rate","Fees","Manage My Plan"};
		
		ArrayList<String> UItitles=new ArrayList<String>(); 
		for(WebElement title: titles)
		{
			UItitles.add(title.getText());
		}
		Helper.compareEquals(testConfig, "Title comparision", expectdtitles, UItitles);	
		return this;
	}
	
	public OptumPaySoln validateFeeTitle()
	{
		int sqlRowNo=1616;
		Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	    String feeTitle=null;
		if (data.get("ACCRDFEE").toString().substring(data.get("ACCRDFEE").toString().length()-1).equals("0"))
		 feeTitle="Accrued fees month to date: $" +data.get("ACCRDFEE").toString().substring(0,data.get("ACCRDFEE").toString().length()-1);
		Helper.compareContains(testConfig, "1st part of Fee Title", feeTitle, Element.findElement(testConfig, "xpath", "//*[@id='optum-pay-options']/div/div[3]").getText());
		Helper.compareContains(testConfig, "2nd part of Fee Title", "Past due fees: $0.00", Element.findElement(testConfig, "xpath", "//*[@id='optum-pay-options']/div/div[3]").getText());

		return this;
	}
	

	public OptumPaySoln verifyInvalidTINonOptumPaySolution(String invalidTIN) throws Exception 
	{
		Element.expectedWait(enterTIN, testConfig, "TIN field","TIN Field");
		Element.enterData(enterTIN, invalidTIN, "TIN entered as : "+invalidTIN, "EnterTIN");
		Element.clickByJS(testConfig,searchBtn, "Search Button");
		Browser.wait(testConfig, 4);
		boolean isInteger;
		try {
		    int x = Integer.parseInt(invalidTIN);
		    isInteger=true;
		}
		catch(NumberFormatException nFE) {
			isInteger=false;
		}
		
		if(isInteger && invalidTIN.length()==9)
		{
			String ErrorMsgText = nonExistingTINmsgOptumPaySol.getText();
			Helper.compareEquals(testConfig, "Non-Existing TIN error msg", "Please enter a existing 9 digit TIN number.", ErrorMsgText);
		}
		else
		{
			String ErrorMsgText = InValidTINmsgOptumPaySol.getText();
			Helper.compareEquals(testConfig, "InValid TIN error msg", "Please enter a valid 9 digit TIN number.", ErrorMsgText);
		}
		return this;
	
	}
	public void validatePlanTypeTile() throws ParseException  {
		int sqlRowNo=1509;
		testConfig.getRunTimeProperty("tin");
		Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		
		if(portalUserData.get("PRTL_PRDCT_SELECT_DTTM").toString().length()>0)
		{String activationDate= portalUserData.get("PRTL_PRDCT_SELECT_DTTM").toString().trim().substring(0, 10).trim();
		 activationDate=Helper.changeDateFormat(activationDate, "yyyy-mm-dd", "mm/dd/yyyy");
			Helper.compareContains(testConfig, "Plan Type Tile text- Activation Date", activationDate, tilePlanType.getText().trim());
		}
		Helper.compareContains(testConfig, "Plan Type Tile text- Optum Pay", "Optum Pay", tilePlanType.getText().trim());	
		Helper.compareContains(testConfig, "Plan Type Tile text- Billing Cycle", "Billing Cycle: Monthly", tilePlanType.getText().trim());
		Helper.compareContains(testConfig, "Plan Type Tile text- Activation Admin", "Activation Admin:", tilePlanType.getText().trim());
        Helper.compareContains(testConfig, "Plan Type Tile text- Activation Date", "Activation Date:", tilePlanType.getText().trim());
        Helper.compareContains(testConfig, "Plan Type Tile text- Activation name", portalUserData.get("PRTL_PRDCT_SELECT_USER_FULLNAME").toString().trim(), tilePlanType.getText().trim());

		Element.clickByJS(testConfig,lnkLogOut , "logging Out of the portal");
	}
		
		public void validateChangeRatePopup(String credentials) {
		
			if(credentials.equalsIgnoreCase("Super") &&
			 testConfig.getRunTimeProperty("prdctSelected").equalsIgnoreCase("Premium") &&
			 testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO") || testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AV") )
					
		{
		Element.clickByJS(testConfig, lnkChangeRate, "Change Rate link");
		//Element.clickByJS(testConfig,optionReasonForRateChange,"Rate Change Reason");
		Element.clickByJS(testConfig,rsnRtChngdrpdwn,"Rate Change Reason");
		Element.clickByJS(testConfig,btnSaveChangeRate,"Save Rate Change");
		System.out.println(popUpChangeRate.getText());
		Helper.compareContains(testConfig, "PopUp text", "Are you sure?" ,popUpChangeRate.getText().trim());
		Helper.compareContains(testConfig, "PopUp text", "If you proceed with this rate change the new per payment rate for this" ,popUpChangeRate.getText().trim());
		Helper.compareContains(testConfig, "PopUp text", "TIN will be effective starting the next business day" ,popUpChangeRate.getText().trim());
			
        Element.verifyElementPresent(btnChangeRatePopupChange, "change btn");
        Element.verifyElementPresent(btnChangeRatePopupCancel, "cancel btn");
        Element.clickByJS(testConfig, btnChangeRatePopupCancel, "cancel btn");
		}
		else
			Element.verifyElementNotPresent(lnkChangeRate, "Change Rate link");
		
		Element.clickByJS(testConfig,lnkLogOut , "logging Out of the portal");
	}
	
		
		public void clickChangeRateEvents(String credentials,String rateValue,String changeRateValue, String changeRateReason) {
			
			if(credentials.equalsIgnoreCase("Super") &&
			  testConfig.getRunTimeProperty("prdctSelected").equalsIgnoreCase("Premium") &&
			  testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO") || testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AV") )
			{
			Element.clickByJS(testConfig, lnkChangeRate, "Change Rate link");	
			Element.enterData(rateTxtBox, rateValue, "change rate", "rate change textbox");
			
			if (changeRateReason.equalsIgnoreCase("Other with Blank"))
			Element.selectByVisibleText(rsnRtChngdrpdwn, "Other", "reason for change dropdown");
			else
			Element.selectByVisibleText(rsnRtChngdrpdwn, changeRateReason, "reason for change dropdown");
			
			if (changeRateReason.equalsIgnoreCase("Other"))
			Element.enterData(otrRsnTxtAra, "Testing", "Other Change rate", "Other Change TextArea");
			if (changeRateReason.equalsIgnoreCase("Other with Blank"))
			Element.enterData(otrRsnTxtAra, "", "Other Change rate", "Other Change TextArea");
			
			Browser.wait(testConfig,1);
			Element.clickByJS(testConfig,btnSaveChangeRate,"Save Rate Change");
			System.out.println(popUpChangeRate.getText());
			Helper.compareContains(testConfig, "PopUp text", "Are you sure?" ,popUpChangeRate.getText().trim());
			Helper.compareContains(testConfig, "PopUp text", "If you proceed with this rate change the new per payment rate for this" ,popUpChangeRate.getText().trim());
			Helper.compareContains(testConfig, "PopUp text", "TIN will be effective starting the next business day" ,popUpChangeRate.getText().trim());
				
	        Element.verifyElementPresent(btnChangeRatePopupChange, "change btn");
	        Element.verifyElementPresent(btnChangeRatePopupCancel, "cancel btn");
	        Element.clickByJS(testConfig, btnChangeRatePopupChange, "Change btn click");
			
	        if (changeRateValue.equals("Invalid value")|| changeRateReason.equalsIgnoreCase("Other with Blank") )
	        {
	        String actual= Element.findElement(testConfig, "xpath", "//div[@id='optum-pay-tabs']/div[1]").getText();
	        if (changeRateValue.equals("Invalid value"))
	        Helper.compareContains(testConfig, "Error Validation", "The rate must be greater than or equal to 0 and less than the system global rate", actual);
			if (changeRateReason.equalsIgnoreCase("Other with Blank"))
			Helper.compareContains(testConfig, "Error Validation", "Enter a reason for the rate change", actual);
	        }
			}
			else
				Element.verifyElementNotPresent(lnkChangeRate, "Change Rate link");
			
		}
		
		public void validateInfoIconHover() {
			for(WebElement title: titles)
			  Element.mouseHoverByJS(testConfig, title, "title");
	 
			Helper.compareEquals(testConfig, "Plan Type","Providers will be billed monthly\n" + 
					"for any fees incurred the previous\n" + 
					"month. For example, fees accrued\n" + 
					"during the month of June will be\n" + 
					"invoiced within the first 5\n" + 
					"business days of July. Provider\n" + 
					"administrators will receive an\n" + 
					"email in advance of the debit to\n" + 
					"the TIN-level bank account and\n" + 
					"they can review the fees on the\n" + 
					"Invoices subtab.", hoverPlanType.getText().trim());
			Helper.compareEquals(testConfig, "Plan Type", "Per payment fees are\n" + 
					"calculated based on the\n" + 
					"total payment amount.\n" + 
					"Any rate changes will be\n" + 
					"effective the following\n" + 
					"business day.",hoverRate.getText().trim());
			Helper.compareEquals(testConfig, "Plan Type", "To view individual per-\n" + 
					"payment fees, please visit\n" + 
					"the View Payments page.\n" + 
					"Fees will be billed monthly.\n" + 
					"To estimate monthly fees,\n" + 
					"select the Print Payment\n" + 
					"summary button from the\n" + 
					"View Payments page to\n" + 
					"download 30 days of\n" + 
					"payment data. Then,\n" + 
					"calculate that amount by\n" + 
					"the current rate.", hoverFees.getText().trim());
			Helper.compareEquals(testConfig, "Plan Type", "To cancel the paid subscription,\n" + 
					"Provider administrators\n" + 
					"complete the Cancellation Fee\n" + 
					"Form found in the Resources link\n" + 
					"and email it to\n" + 
					"optumpay_cancel@optum.com.\n" + 
					"\n" + 
					"Note: Cancellation may take up\n" + 
					"to 7 days to process during which\n" + 
					"time the provider will be\n" + 
					"responsible for any charges to\n" + 
					"their account. Any fees incurred\n" + 
					"prior to cancellation will be billed\n" + 
					"at the end of the current billing\n" + 
					"cycle.",hoverManageMyPlan.getText().trim());
		
		}
	
}
