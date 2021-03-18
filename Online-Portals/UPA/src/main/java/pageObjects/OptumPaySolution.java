package main.java.pageObjects;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.sql.QueryBuilder;

public class OptumPaySolution {
	                 
	@FindBy(xpath = "//div[contains(text(),'Provider Name')]") 
	WebElement txtProvNameHeader;
	@FindBy(xpath = "//div[contains(text(),'Plan Type')]") 
	WebElement txtPlanTypeHeader;
	@FindBy(xpath = "//div[contains(text(),'Fees')]") 
	WebElement txtFeesHeader;
	@FindBy(xpath = "//div[contains(text(),'Manage Subscriptions')]") 
	WebElement txtManageSubHeader;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[1]/div/div[2]") 
	WebElement txtProvNameInfo;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[2]//div[2]") 
	WebElement txtPlanTypeInfoVO;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[3]//div[2]/b") 
	WebElement txtFeesInfoVO;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[4]//div[2]/b") 
	WebElement txtManageSubInfo;
	@FindBy(xpath = "//form[@id=\"showOptumPayForm\"]/div//h1") 
	WebElement txtOnStandardPage;
	@FindBy(xpath = "//div[@id=\"videoID1\"]//div") 
	WebElement video;
	@FindBy(linkText="Logout") 
	WebElement lnkLogout;
	@FindBy(linkText="Home") 
	WebElement lnkHome;
	@FindBy(xpath = "//div[@id=\"optum-pay-tabs\"]//div[1]//p[2]") 
	WebElement pageText;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]") 
	WebElement txtFeesInfoAO;
	@FindBy(linkText="Cancel My Plan")
	WebElement lnkCancelSubscription;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]") 
	WebElement txtActivationAdminName;
	@FindBy(xpath = "//div[@id='cancelationModal']//h2") 
	WebElement duringTrialCancelPopUpHeading;
	@FindBy(xpath = "//div[@id='cancelationPostTrialModal']//h2") 
	WebElement postTrialCancelPopUpHeading;
	@FindBy(xpath = "//div[2]/div[1]/button[1]/span[1]") 
	WebElement btnCancelOnPopUp;
	@FindBy(xpath="//*[@id='reason_selector']//option")
	List<WebElement> listTrialCancellationReason;
	@FindBy(id="cancelationPostTrialModal")
	WebElement popUpCancellationPostTrial;
	@FindBy(xpath="//div[@id='cancelationPostTrialModal']//p")
	WebElement postTrialCancelPopUpText;
	@FindBy(id="cancelationModal")
	WebElement popUpCancellationTrial;
	@FindBy(id="reason_selector")
	WebElement popUpCancellationReasonSelector;
	@FindBy(xpath = "//div[@id='cancelationModal']//p[1]") 
	WebElement duringTrialCancelPopUpBody1;
	@FindBy(xpath = "//div[@id='cancelationModal']//p[2]") 
	WebElement duringTrialCancelPopUpBody3;
	@FindBy(xpath="//div[@id='cancelationModal']//ul//li")
	List<WebElement> duringTrialCancelPopUpBody2;
	@FindBy(xpath="//html//button[2]")
	WebElement btnCancellationSubmitTrial;
	@FindBy(xpath="//p[@id='errorswarning']")
	WebElement errorCancelWithoutReason;
	@FindBy(xpath="//*[@id='reason_selector']//option[8]")
	WebElement otherOptionTrialCancellationReason;
	@FindBy(className="wrapperTooltip")
	List <WebElement> tilesHeaderUI;
	@FindBy(xpath="//*[@id=\"optum-pay-options\"]/div/div/div/div/div[2]")
	List <WebElement> tileContentUI;
	@FindBy(xpath="//span[contains(text(),'Manage My Plan')]")
	WebElement manageMyPlanText;
	@FindBy(id="openCancelationPostTrialPopup")
	WebElement lnkCancelPlanPostTrial;
	@FindBy(id="openCancelationPopup")
	WebElement lnkCancelPlanDuringTrial;
	
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
   @FindBy(xpath="//button[contains(text(),'Cancel')]")
   WebElement btnChangeRatePopupCancel;
   @FindBy(xpath="//button[contains(text(),'Change')]")
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

	@FindBy(xpath="//b[contains(text(),'Standard Per Payment fee:')]")
    private WebElement standardPerPaymentFee;  
	
    @FindBy(xpath="//b[contains(text(),'Custom Per Payment fee:')]")
    private WebElement customPerPaymentFee;       
    
    @FindBy(xpath="//b[contains(text(),'Standard Per Payment fee:')]/../..")
    private WebElement globalFee;  
    
    @FindBy(xpath="//b[contains(text(),'Custom Per Payment fee:')]/../..")
    private WebElement customFee;   
    
    @FindBy(xpath="//b[contains(text(),'Custom Per Payment fee:')]/../../../p[2]")
    private WebElement customFeeDate;  
    
    @FindBy(xpath="//span[contains(text(),'Rate')]/../..//div[contains(text(),'N/A')]")
    private WebElement validateNA;

    @FindBy(xpath=" //*[@id='optum-pay-options']/div[1]/div[3]/div[2]")
    private WebElement feeTile;
    
    @FindBy(linkText="Invoices")
    WebElement lnkInvoice;
    
    @FindBy(xpath="//div[@id=\"optum-pay-invoices\"]/div/div[1]/p")
    WebElement divPageMsg;

	@FindBy(linkText = "Fee Search")
	private WebElement feeSearchTab;

	@FindBy(id = "paymentNumber")
	WebElement paymentNumber;

	@FindBy(id = "invoiceNumber")
	WebElement invoiceNumber;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	@FindBy(name = "showOnlyRefundables")
	WebElement refundableCheckBox;

	@FindBy(xpath = "//*[@id='optum-pay-fee-search']/div[2]/div[2]/div/div/div[1]/div[1]")
	WebElement divShowRslts;
	
	@FindBy(id="feeTypeOption_selector")
	WebElement feeTyp;
	
	@FindBy(id="feeStatusOption_selector")
	WebElement feeStatus;
	
	@FindBy(id="feeRangeMin")
	WebElement feeRngMin;
	
	@FindBy(id="feeRangeMax")
	WebElement feeRngMax;
	
	@FindBy(className="btn btn-primary switch__button details_button")
	WebElement detailsTab;
	
	@FindBy(xpath="//div[@id='feeSearchTable']/div[2]/div/table/tbody/tr")
	List <WebElement> noOfRows;
	
		private TestBase testConfig;
		public OptumPaySolution(TestBase testConfig) {
			this.testConfig=testConfig;
			PageFactory.initElements(testConfig.driver, this);
		}
		public void verifyHeaders(){
			Helper.compareEquals(testConfig, "1st Tile Header", "Provider Name", txtProvNameHeader.getText().trim());
			Helper.compareEquals(testConfig, "2nd Tile Header", "Plan Type", txtPlanTypeHeader.getText().trim());
			Helper.compareEquals(testConfig, "3rd Tile Header", "Fees", txtFeesHeader.getText().trim());
			Helper.compareEquals(testConfig, "4th Tile Header", "Manage Subscriptions", txtManageSubHeader.getText().trim());	
		}
		public void verifySolutionsTabForStandard(String trialStatus, String portalAccess){
			Helper.compareEquals(testConfig, "Optum Pay brings more power to your practice text on Standard view", "Optum Pay brings more power to your practice", txtOnStandardPage.getText().trim());
			Element.verifyElementPresent(video, "Video");
			Element.click(testConfig, lnkHome, "Home", 3);
			Element.click(testConfig, lnkLogout, "Logout", 3);
		}
		public void verifySolutionsTabForPremium(String trialStatus,String portalAccess) throws Exception{
			if(trialStatus.equalsIgnoreCase("A")) {
				Browser.browserRefresh(testConfig);
				Browser.waitForPageLoad(testConfig);
				verifyHeaders();
				planTypeInfoForPremium();
				Helper.compareEquals(testConfig, "During Trial Cancel pop-up", "You are about to lose important functionality through Optum Pay.", duringTrialCancelPopUpHeading.getText().trim());
				Element.click(btnCancelOnPopUp, "Close pop-up 'X' button");
				Element.verifyElementPresent(pageText, "Page Text");
				Element.click(testConfig, lnkHome, "Home", 3);
				Element.click(testConfig, lnkLogout, "Logout", 3);
			}
			else if(trialStatus.equalsIgnoreCase("I")) {
				verifyHeaders();
				planTypeInfoForPremium();
				Helper.compareEquals(testConfig, "Post Trial Cancel pop-up", "Call to cancel", postTrialCancelPopUpHeading.getText().trim());
				Element.click(btnCancelOnPopUp, "Close pop-up 'X' button");
				Element.verifyElementPresent(pageText, "Page Text");
			}
		}
		public void planTypeInfoForPremium() throws Exception {
			String planTypeInfo= Element.findElement(testConfig, "xpath", "//div[@id=\"optum-pay-options\"]//div//div[2]//div[2]").getText();
			Element.verifyElementPresent(pageText, "Page Text");
			int sqlRowNo = 1;
		    testConfig.getRunTimeProperty("tin");
		    Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    Helper.compareEquals(testConfig, "Organization Name on 1st tile DB and UI", data.get("ORG_NM").toString().trim(),txtProvNameInfo.getText().trim());
			Helper.compareEquals(testConfig, "2nd Tile text- Optum Pay", "Optum Pay", planTypeInfo.substring(0, 9).trim());	
			Helper.compareEquals(testConfig, "2nd Tile text- Activation Admin", "Activation Admin:", planTypeInfo.substring(10, 28).trim());	
			Helper.compareEquals(testConfig, "2nd Tile text- Activation Date", "Activation Date:", planTypeInfo.substring(37, 53).trim());	
			sqlRowNo=1344;
			testConfig.getRunTimeProperty("statusOfStandardRecd");
			testConfig.getRunTimeProperty("$SelectedOrDefault");
			data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String activationDate= data.get("PRTL_PRDCT_SELECT_DTTM").toString().trim().substring(0, 10).trim();
			activationDate=Helper.changeDateFormat(activationDate, "yyyy-mm-dd", "mm/dd/yyyy");
			Helper.compareEquals(testConfig, "2nd Tile Info- Activation Date", activationDate, planTypeInfo.substring(54, 64).trim());
			Helper.compareEquals(testConfig, "Fees on 3rd tile", "0.5% of Payment", txtFeesInfoAO.getText().trim());
			Helper.compareEquals(testConfig, "Fees on 4th tile", "Free Trial End Date:", txtManageSubInfo.getText().trim());
			sqlRowNo=1341;
			data= DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String trialEndDateDB= data.get("PROC_DATA").toString().trim();
			trialEndDateDB=Helper.changeDateFormat(trialEndDateDB, "yyyy-mm-dd", "mm/dd/yyyy").trim();
			String trialEndDateUI= Element.findElement(testConfig, "xpath", "//div[@id=\"optum-pay-options\"]//div[4]//div[2]").getText().trim();
			System.out.println(trialEndDateUI.substring(21, 31));
			Helper.compareEquals(testConfig, "Fees on 4th tile Info", trialEndDateDB, trialEndDateUI.substring(21, 31).trim());
			Element.click(lnkCancelSubscription, "Cancel My Subscription Link");
		}
		public void verifyCancellationPopUp(String trialStatus) throws IOException {
			testConfig.putRunTimeProperty("pay_proc_cd","55");
			int sqlRowNo=1111,i=1,j=0;
			HashMap<Integer, HashMap<String, String>> cancelReasonDB=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
			ArrayList<String> cancelReasonList=new ArrayList<String>(){{add("Not using the portal as much as I thought I would");add("I receive my data from a clearinghouse");add("I don't need the search tools");add("I don't need historical claim data");add("I don't need additional users, 2 is sufficient");add("The service is too costly for my practice");add("Other");}};
			ArrayList<String> popUpTextList=new ArrayList<String>(){{add("Unlimited number of users");add("The ability to search claims");add("Years of claims and remittance history maintained for easy access");add("Multiple remittance options (835, EPRA or PPRA)");}};
			
			if(trialStatus.equalsIgnoreCase("PostTrial and Paid"))
			{ 
				Element.click(lnkCancelPlanPostTrial, "Cancel My Subscription Link");
				Element.verifyElementPresent(popUpCancellationPostTrial, "Post Trail Pop Up Cancellation");
				Helper.compareEquals(testConfig, "Post Trail Cancellation Popup Heading text","Call to cancel",postTrialCancelPopUpHeading.getText().toString());
				Helper.compareEquals(testConfig, "Post Trail Cancellation Popup Body text","In order to cancel your participation in Optum Pay, you will need to call 1-877-620-6194 for assistance. The process may take up to 7 days to process, in which time you will be responsible for any charges to your account. If at any time you will like to reinstate the full functionality of Optum Pay, please return to this tab.",postTrialCancelPopUpText.getText().toString());
			}
			else if(trialStatus.equalsIgnoreCase("WithinTrial and Paid"))
			{  
				Element.click(lnkCancelPlanDuringTrial, "Cancel My Subscription Link");
				Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text","You are about to lose important functionality through Optum Pay.",duringTrialCancelPopUpHeading.getText().toString());
				Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text","By cancelling your Optum Pay access, you will be losing features that many providers consider vital to their practice, including:",duringTrialCancelPopUpBody1.getText().toString());
				for( WebElement cancelPopUptext : duringTrialCancelPopUpBody2)
					{Helper.compareEquals(testConfig, "Pop Up Text List", popUpTextList.get(j).toString(), cancelPopUptext.getText().toString());
					j++;
					}									
				Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text","Upon cancellation of Optum Pay, you will continue to receive ACH payments and maintain limited portal access.",duringTrialCancelPopUpBody3.getText().toString());
				Element.click(btnCancellationSubmitTrial,"click on yes i want to cancel");
				Element.verifyElementPresent(errorCancelWithoutReason, "Error thrown when reason is not selected");
				Helper.compareEquals(testConfig, "Error thrown when reason is not selected", "Please enter Reason for Termination.", errorCancelWithoutReason.getText().toString());
				for(WebElement cancelReasonUI :listTrialCancellationReason)
					{
					  if(cancelReasonUI.getText().toString().equalsIgnoreCase("Select One"))
						  continue;
					  else
					   {
						  Helper.compareEquals(testConfig, "cancel List", cancelReasonDB.get(i).get("PAY_PROC_ACPT_CD_VAL_DESC").toString(), cancelReasonUI.getText().toString());
						  Helper.compareEquals(testConfig, "cancel List", cancelReasonList.get(i-1).toString(), cancelReasonUI.getText().toString());
						  i++;
					   }
					}
				Element.click(otherOptionTrialCancellationReason, "Selecting Other as the Reason");
				Element.click(btnCancellationSubmitTrial,"click on yes i want to cancel");
				Element.verifyElementPresent(errorCancelWithoutReason, "Error thrown when reason is not selected");
				Helper.compareEquals(testConfig, "Error thrown when other reason is not given", "Please enter Other reason for termination.", errorCancelWithoutReason.getText().toString());
			}
			
		}
       
	    public  OptumPaySolution validateManageMyPlanText() {
            Element.verifyTextPresent(manageMyPlanText,"Manage My Plan");
            return this;
         }
		
		public void validateCancelMyPlanTextLink() {
			Element.verifyTextPresent(lnkCancelSubscription,"Cancel My Plan");
		}
		
		public void validateFreeTrialTextNotPresent(String text) {  
            Element.verifyTextNotPresent(text);
        }
    
	    public void verifyOPSTilesForVO() {
					ArrayList<String> expectedContent=new ArrayList<String>(); 
					expectedContent.add("Plan Type");
					expectedContent.add("Rate");
					expectedContent.add("Fees");
					expectedContent.add("Manage My Plan");
				
					ArrayList<String> actualContentUI=new ArrayList<String>(); 
					for(WebElement tiles: tilesHeaderUI)
					{
						actualContentUI.add(tiles.getText());
					}
					Helper.compareEquals(testConfig, "Title comparision", expectedContent, actualContentUI);
					
					expectedContent.clear(); 
					expectedContent.add("VCP Only");
					expectedContent.add("N/A");
					expectedContent.add("N/A");
					expectedContent.add("N/A");
				
					actualContentUI.clear();
					for(WebElement tiles: tileContentUI)
					{
						actualContentUI.add(tiles.getText().trim());
					}
					Helper.compareEquals(testConfig, "Tile Content comparision", expectedContent, actualContentUI);
				}
	    
	    
		public OptumPaySolution validateTitleNames(){
			
			ArrayList<String> expectdtitles=new ArrayList<String>(); 
			expectdtitles.add("Plan Type");
			expectdtitles.add("Rate");
			expectdtitles.add("Fees");
			expectdtitles.add("Manage My Plan");
						
			ArrayList<String> UItitles=new ArrayList<String>(); 
			for(WebElement title: titles)
			{
				UItitles.add(title.getText());
			}
			Helper.compareEquals(testConfig, "Title comparision", expectdtitles, UItitles);	
			return this;
		}
		

		public OptumPaySolution validateFeeTitle()
		{
			int sqlRowNo=1616;
			Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    String feeTitle="Accrued fees month to date: $" +data.get("ACCRDFEE").toString().substring(0,data.get("ACCRDFEE").toString().length());
  			Helper.compareContains(testConfig, "1st part of Fee Title", feeTitle, Element.findElement(testConfig, "xpath", "//*[@id='optum-pay-options']/div[1]/div[3]/div[2]").getText());
			//Helper.compareContains(testConfig, "2nd part of Fee Title", "Past due fees: $0.00", Element.findElement(testConfig, "xpath", "//*[@id='optum-pay-options']/div/div[3]").getText());
            //covered in another US
			return this;
		}

		

		public OptumPaySolution verifyInvalidTINonOptumPaySolution(String invalidTIN) throws Exception 
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
			
			if(credentials.equalsIgnoreCase("Super"))
			{
			Element.clickByJS(testConfig, lnkChangeRate, "Change Rate link");
			Element.clickByJS(testConfig,optionReasonForRateChange,"Rate Change Reason");
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
		
			public void validateChangeRatePrcnt(String credentials, String changeRateValue, String changeRateReason)
			{
				
				String rateValue="";
				int sqlRowNo=1627;
				Map rate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
				
				BigDecimal globalVal=BigDecimal.valueOf(Double.parseDouble(rate.get("RATE_PCT").toString().trim())).multiply(new BigDecimal(100));
				if (changeRateValue.equals("Invalid value"))
				{
					rateValue=globalVal.add(new BigDecimal("0.001")).toString();
					validateChangeRateEvents(credentials,rateValue,changeRateValue,changeRateReason);
					rateValue="-"+Helper.generateRandomDecimalValue(0, 1, 3);
					validateChangeRateEvents(credentials,rateValue,changeRateValue,changeRateReason);
				}
				if (changeRateValue.equals("valid value"))
				{
					rateValue=globalVal.add(new BigDecimal("-0.001")).toString();
					validateChangeRateEvents(credentials,rateValue,changeRateValue,changeRateReason);
					Browser.wait(testConfig, 1);
					validateChangeRateEvents(credentials,rateValue,changeRateValue,"Other with Blank");
				}
			}
			
			public void validateChangeRateEvents(String credentials,String rateValue,String changeRateValue, String changeRateReason) {
			
			if(credentials.equalsIgnoreCase("Super") &&
			  testConfig.getRunTimeProperty("prdctSelected").equalsIgnoreCase("Premium") &&
			  testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO") || testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AV") )
			{
			if( (changeRateValue.equals("valid value") && changeRateReason.equalsIgnoreCase("Other"))|| (changeRateValue.equals("Invalid value") && (!rateValue.contains("-"))))
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
			
			Helper.compareContains(testConfig, "PopUp text", "Are you sure?" ,popUpChangeRate.getText().trim());
			Helper.compareContains(testConfig, "PopUp text", "If you proceed with this rate change the new per payment rate for this" ,popUpChangeRate.getText().trim());
			Helper.compareContains(testConfig, "PopUp text", "TIN will be effective starting the next business day" ,popUpChangeRate.getText().trim());
			
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

			
	 public void rateTileCSRFeeAndDateVerification(String tinType, String portalAccess) {
		          
	 	   if(tinType.equals("VO") || portalAccess.equals("Standard")) {  
	 		   String naMessage1 = validateNA.getText().trim();
	 		   String naMessage = naMessage1.substring(0, 3);
	 		   Helper.compareContains(testConfig, "Validating N/A is present for VO or Standard Tins","N/A",naMessage);
	 		   return;
	 	   }
	 	   //For Database
	 	   String currDateDB = Helper.getCurrentDate("YYYY-MM-dd");
	 	   String getCurrentMonthDB = currDateDB.substring(5, 7);
	 	   String getCurrentYearDB = currDateDB.substring(0,4);
	 	   String futureDateInSameMonthDB = getCurrentYearDB+"-"+getCurrentMonthDB+"-"+"20"; //20 or it can be any future date in same month
	 	   String pastDateDB = Helper.getDateBeforeOrAfterDays(-31, "YYYY-MM-dd");
	 	   String tomorrowsDateDB = Helper.getDateBeforeOrAfterDays(1, "YYYY-MM-dd");
	 	   String currMonthsFirstDateDB = getCurrentYearDB+"-"+getCurrentMonthDB+"-"+"01";  
	 	   String currMonthsSecondDateDB = getCurrentYearDB+"-"+getCurrentMonthDB+"-"+"02"; 
	 	   
	 	   //For UI
	 	   String currDate = Helper.getCurrentDate("MM/dd");
	 	   String getCurrentMonth = currDate.substring(0, 2);
	 	   String currDay = currDate.substring(currDate.length()-2);
	 	   String futureDateInSameMonth = getCurrentMonth+"/20";
	 	   String currMonthsFirstDate = getCurrentMonth+"/01";
	 	   String currMonthsSecondDate = getCurrentMonth+"/02";
	 	   String lastDateOfCurrentMonth = Helper.getLastDateOfMonth("MM/dd");
		              
	 	   testConfig.putRunTimeProperty("currDateDB", currDateDB);
	 	   testConfig.putRunTimeProperty("pastDateDB", pastDateDB);
	 	   testConfig.putRunTimeProperty("tomorrowsDateDB", tomorrowsDateDB);
	 	   testConfig.putRunTimeProperty("currMonthsFirstDateDB", currMonthsFirstDateDB);
	 	   testConfig.putRunTimeProperty("currMonthsFirstDateDB", currMonthsFirstDateDB);
	 	   testConfig.putRunTimeProperty("currMonthsSecondDateDB", currMonthsSecondDateDB);
	 	   testConfig.putRunTimeProperty("futureDateInSameMonthDB", futureDateInSameMonthDB);
		             
	 	   //Pre-requisite - Updating the Global Fee start date as 1st Jan 2021 and the end date should be NULL
	 	   updatingStartDateOfGlobalLevelFee();
		   
	 	   //Scenario 1 - Asserting only Global Fee
	 	   validatingGlobalFeeInUI(); 
		              
	 	   //Inserting a Custom Per Payment Fee with dates from (Previous month date - tomorrow's date)
	       //Scenario 2 - Asserting only Custom Fee	 	   
	 	   DataBase.executeInsertQuery(testConfig, 2002); 
	 	   Browser.browserRefresh(testConfig);
	 	   validatingCustomFeeInUI();  
		              
	 	   //Updating Tin level date from (Previous month date - 1st of current month)
	 	   //Scenario 3 - Displaying both Custom and Global Fee	 	   
	 	   DataBase.executeUpdateQuery(testConfig, 2003); 
	 	   Browser.browserRefresh(testConfig);  
	 	   if(currDay.equals("01")) {                   
	 		   validatingCustomFeeInUI();
	 	   }
	 	   else {
	 		   validatingGlobalFeeInUI();                 
	 		   validatingCustomFeeInUI();
	 		   Helper.compareContains(testConfig, "Validating whether the custom Fee is displayed properly in the Rate Tile UI", validatingCustomFeeDate(), currMonthsFirstDate+" - "+currMonthsFirstDate);
	 	   } 
	 	    	   
	 	   //Update Tin Level date from (2nd of current month - 20th of current month)
	 	   //Scenario 4 - Displaying both custom and global fee	 	   
	 	   DataBase.executeUpdateQuery(testConfig, 2004);
	 	   Browser.browserRefresh(testConfig);
	 	   if(currDay.equals("01")) {                   
	 		   validatingGlobalFeeInUI();
	 	   }
	 	   else {
	 		   validatingGlobalFeeInUI();
	 		   validatingCustomFeeInUI();
	 		   Helper.compareContains(testConfig, "Validating whether the custom Fee is displayed properly in the Rate Tile UI", validatingCustomFeeDate(), currMonthsSecondDate+" - "+futureDateInSameMonth);
	 	   }
	 	   
	 	   //Update Tin Level date from (2nd of current month - NULL)
	 	   //Scenario 5 - Displaying both custom and global fee
	 	   DataBase.executeUpdateQuery(testConfig, 2005);
	 	   Browser.browserRefresh(testConfig);
	 	   if(currDay.equals("01")) {                   
		 		 validatingGlobalFeeInUI();
		 	   }
	 	   else {
	 		   validatingGlobalFeeInUI();  
		 	   validatingCustomFeeInUI();
		 	   Helper.compareContains(testConfig, "Validating whether the custom Fee is displayed properly in the Rate Tile UI", validatingCustomFeeDate(), currMonthsSecondDate+" - "+lastDateOfCurrentMonth);
	 	   }
	 	   		   
	 	   //Deleting the entry which we created for our tin in Debit_Fee_Rate table
	 	   DataBase.executeDeleteQuery(testConfig, 2007); 
	 	   Log.Comment("Entry was deleted from Rate Fee table");
	 }
	 		    
	 public void validateStandardPerPaymentFeeText() {
		 Element.verifyTextPresent(standardPerPaymentFee,"Standard Per Payment fee:");
	 }
		      
	 public void validateCustomPerPaymentFeeText() {
		 Element.verifyTextPresent(customPerPaymentFee,"Custom Per Payment fee:");
	 }
		         
	 public void validatingGlobalFeeInUI() {   
		          
		 String globalFeeFromDB = null;
		 String globalFeeFromUI = null;  
		 
		 if(globalFeeFromDB == null && globalFeeFromUI==null) {
			 Map<String, String> globalFeeFromDatabase = DataBase.executeSelectQuery(testConfig, 2001, 1);
			 globalFeeFromDB = globalFeeFromDatabase.get("RATE_PCT");
		              
			 //If last two digits for global fee is 0 in database, then we display only one digit after decimal point in UI 
			 if(globalFeeFromDB.charAt(globalFeeFromDB.length()-1)=='0' && globalFeeFromDB.charAt(globalFeeFromDB.length()-2)=='0') {
				 DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.0");
				 globalFeeFromUI = decimalFormat.format(Float.parseFloat(globalFeeFromDB)*100);
			 }
			 
			 //If last one digit for global fee is 0 in database, then we display only two digits after decimal point in UI  
			 else if(globalFeeFromDB.charAt(globalFeeFromDB.length()-1)=='0'){
				 DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.00");
				 globalFeeFromUI = decimalFormat.format(Float.parseFloat(globalFeeFromDB)*100);
			 }
			 
			 //If last digit for global fee is non zero in database, then we display three digits after decimal point in UI
			 else {
				 DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.000");
				 globalFeeFromUI = decimalFormat.format(Float.parseFloat(globalFeeFromDB)*100);
			 }             
		 }
		          
		 String split[] = globalFee.getText().trim().split(": ");
		 String stdFee = split[split.length-1].trim();
		          
		 Helper.compareContains(testConfig,"Validating whether the Global Fee is displayed properly in the Rate Tile UI", stdFee, globalFeeFromUI+"%"); 
		 validateStandardPerPaymentFeeText();
	 }
		      
	 	public void validatingCustomFeeInUI() {
	 		String customFeeFromDB = null;
	 		String customFeeFromUI = null;
		    
	 		//Fetch the Custom Fee from database, and display three digits after decimal point in UI
	 		if(customFeeFromDB == null && customFeeFromUI==null) {
	 			Map<String, String> customFeeFromDatabase = DataBase.executeSelectQuery(testConfig, 2006, 1);
	 			customFeeFromDB = customFeeFromDatabase.get("RATE_PCT");
	 			
	 			DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.000");
	 			customFeeFromUI = decimalFormat.format(Float.parseFloat(customFeeFromDB)*100);
	 		} 

	 		String split[] = customFee.getText().trim().split(": ");
	 		String custFee = split[split.length-1].trim();
	 		
	 		Helper.compareContains(testConfig,"Validating whether the custom Fee is displayed properly in the Rate Tile UI", custFee, customFeeFromUI+"%");    
	 		validateCustomPerPaymentFeeText();
	 	}
		      
	 	public String validatingCustomFeeDate() {
	 		return customFeeDate.getText().trim(); 
	 	} 
		      
	 	public void updatingStartDateOfGlobalLevelFee() {
	 		DataBase.executeUpdateQuery(testConfig, 2008);		          
	 	}		
	 	public OptumPaySolution validatePastdueFee()
		{
			int sqlRowNo=1630;
			Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    String feeTitle=null;
			feeTitle="Past due fees: $" +data.get("PASTDUEFEE").toString();
			Helper.compareContains(testConfig, "Past due fee value", feeTitle, feeTile.getText());
			return this;
		}
	 	
	 	public OptumPaySolution verifyInvoicesTab(String searchCriteria,String tinType,String portalAccess,String prdctRecSts){
            if("TinWithInvoices".equals(searchCriteria)){
                Element.verifyElementPresent(lnkInvoice, "Invoices Link");
                Element.clickByJS(testConfig, lnkInvoice, "Invoices Link");
                Element.verifyElementPresent(divPageMsg, "Page message");
            }
            else if("TinWithoutInvoices".equals(searchCriteria) && ("AV".equals(tinType) || "AO".equals(tinType)) && "Premium".equals(portalAccess) && "PS".equals(prdctRecSts)){
                Element.verifyElementPresent(lnkInvoice, "Invoices Link");
                Element.clickByJS(testConfig, lnkInvoice, "Invoices Link");
                Element.verifyElementPresent(divPageMsg, "Page message");
            }
            else if("TinWithoutInvoices".equals(searchCriteria) && ("AV".equals(tinType) || "AO".equals(tinType)) && "Premium".equals(portalAccess) && "TR".equals(prdctRecSts)){
                Element.verifyElementNotPresent(lnkInvoice, "Invoices Link");
            }
            else if("TinWithoutInvoices".equals(searchCriteria) && "VO".equals(tinType)){
                Element.verifyElementNotPresent(lnkInvoice, "Invoices Link");
            }
            else if("TinWithoutInvoices".equals(searchCriteria) && "Standard".equals(portalAccess)){
                Element.verifyElementNotPresent(lnkInvoice, "Invoices Link");
            }
            return this;
        }
		public void navigateToFeeSearchTab() {
			Element.click(testConfig, feeSearchTab, "Fee Search Tab", 3);
		}

		public OptumPaySolution doSearch(String criteriaType) throws ParseException {

			switch (criteriaType) {

				case "feeSearchPaymentNumber": {
					Browser.wait(testConfig, 5);
					String dspl_consl_pay_nbr = testConfig.getRunTimeProperty("paymentNumber");
					Element.enterData(paymentNumber, dspl_consl_pay_nbr, "Enter Fee Search payment number as: " + dspl_consl_pay_nbr, "payment number");
					break;
				}
				case "feeSearchInvoiceNumber": {
					Browser.wait(testConfig, 5);
					String invoice_nbr = testConfig.getRunTimeProperty("invoiceNumber");
					Element.enterData(invoiceNumber, invoice_nbr, "Enter Fee Search invoice number as: " + invoiceNumber, "invoice number");
					break;
				}
				case "detailsTabwthAllVal": {
					Browser.wait(testConfig, 2);
					clickDetailsTab();
					Element.selectByVisibleText(feeTyp, "All", "All Value in Fee Type");
					Element.selectByVisibleText(feeStatus, "All", "All Value in Fee Type");
					//Element.enterData(feeRngMin, "0", "fee min Range", "feeRangeMin");
					//Element.enterData(feeRngMax, "10000000000", "fee max Range", "feeRngMax");;
					break;
				}
				
			}

			return clickSearchBtn();
		}

		public OptumPaySolution clickSearchBtn() {
			Element.clickByJS(testConfig, searchButton, "Fee Search Button");
			return new OptumPaySolution(testConfig);
		}
		public OptumPaySolution clickDetailsTab() {
			Element.clickByJS(testConfig, detailsTab, "details Tab");
			return new OptumPaySolution(testConfig);
		}
		public OptumPaySolution verifyPagination(){
			int totalNoOfPages=new ViewPayments(testConfig).getNumberOfPages();
			if (totalNoOfPages == 0)
			{
				String actualtxt=Element.findElement(testConfig, "xpath", "//div[@id='optum-pay-fee-search']/div[2]/div/div/p").getText();
				Helper.compareEquals(testConfig, "message comparision", "No fees available for this Organization.", actualtxt);
				
			}
			else{
			int pageNo=0;
			
			
			for( pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		    {
			//verify pagination links >>,<<
				if (Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]")!=null &&
					Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[3]/div[2]/span")!=null 	
						)
				Log.Pass("Uppar and lower pagination links are on the page ");
				else
				Log.Fail("Uppar and lower pagination links are not on the page");	
			//verify 30 rows
				if (noOfRows.size()<=30)
				Log.Pass("Maximum 30 rows in a page");
				else
				Log.Fail("More than 30 rows in a page");	
				//click on >,>>,<,<< and disability
				if(
				Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[1]").getTagName()!="a"&& 
				Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[2]").getTagName()!="a" )
				Log.Pass("< and << are disabled");
				else
					Log.Fail("< and << are enabled");	
					
		    } 
			if(pageNo%10!=0 && pageNo<totalNoOfPages)
			    {  
			       int pageToBeClicked=pageNo+1;
			       String first="<<";
			       String back="<";
			       String next=">";
			       String last=">>";
			       Element.findElement(testConfig,"xpath","//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text()," + pageToBeClicked + ")]").click();
			       Log.Comment("Clicked Page number : " + pageToBeClicked);
			       
			       Browser.wait(testConfig, 2);
			       Element.findElement(testConfig,"xpath","/div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),back)]").click();
			       Log.Comment("Clicked back Page");
			       
			       Browser.wait(testConfig, 2);
			       Element.findElement(testConfig,"xpath","/div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),next)]").click();
			       Log.Comment("Clicked next Page");
			       
			       Browser.wait(testConfig, 2);
			       Element.findElement(testConfig,"xpath","/div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),first)]").click();
			       Log.Comment("Clicked Page number : " + pageToBeClicked);
			       
			       Element.findElement(testConfig,"xpath","/div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),last)]").click();
			       Log.Comment("Clicked Page number : " + pageToBeClicked);
			       
					if(
							Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[2]").getTagName()!="a"&& 
							Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[3]").getTagName()!="a" )
							Log.Pass("> and >> are disabled");
							else
								Log.Fail("> and >> are enabled");	
			       Browser.waitForLoad(testConfig.driver);
			     }
			     
//			    else if(pageNo%10==0 && totalNoOfPages!=2 && pageNo<totalNoOfPages)
//			    {
//			       Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
//			       Element.click(lnkNextPage,"Next Link");
//			       Browser.waitForLoad(testConfig.driver);
//			       Browser.wait(testConfig,3);
//			     }
			}
			    
		return this;	
		}
		
		/**
		 * Get Headers List till Market Type
		 * to store them as key in map
		 *
		 * @return HeaderList
		 */
		public ArrayList<String> getHeadersFromFeeSearchTable() {
			List<String> headerList = new ArrayList<String>();
			int size = 0;
			WebElement headerRow = null;
			headerRow = Element.findElement(testConfig, "xpath", "//*[@id='optum-pay-fee-search']/div[2]/div[2]/div/div/div[2]/div/table/thead/tr[1]");

			if (headerRow != null) {
				size = headerRow.findElements(By.tagName("th")).size();
			}
			for (int i = 0; i < size; i++) {
				String header = "";
				header = headerRow.findElements(By.tagName("th")).get(i).getText();
				if (header.equals("Original Payment Date"))
					header = "Payment Date";
				headerList.add(header);
			}
			return (ArrayList<String>) headerList;

		}

		public void verifyFeeSearchResults(String requestType) throws SQLException, IOException {
			QueryBuilder queryBuilder = new QueryBuilder();

			String query = queryBuilder.getFeeSearchQuery(requestType);

			System.out.println(query);

			ResultSet resultset = DataBase.testExecuteSelectQuery(testConfig, query, DataBase.getDatabaseType());
			Helper.compareEquals(testConfig, "Record Count from DB and UI :", getRowCount(resultset), getRecordCountFromUI());
			resultset.beforeFirst();
			Helper.compareMaps(testConfig, "Payments Details Comparison", getFeeSearchDetailsFromDB(resultset), getFeeSearchDetailsFromUI());

		}

		private String getRowCount(ResultSet resultSet) throws SQLException {
			int count = 0;
			while (resultSet.next()) {
				++count;
			}
			return String.valueOf(count);
		}

		public String getRecordCountFromUI() {
			String resultCount = divShowRslts.getText().toString();
			resultCount = resultCount.substring("Showing".length(), resultCount.indexOf("Results"));
			return resultCount.trim();
		}

		public void verifyFeeSearchResultHeaders() {
			List<String> expectedHeaders = new ArrayList<>(Arrays.asList("Payment Date", "Payer Name", "Payment Number", "Payment Amount", "Fee Amount", "Invoice Number", "Invoice Date", "Fee Type", "Fee Status"));
			List<String> actualHeaders = getHeadersFromFeeSearchTable();
			Helper.compareEquals(testConfig, "headers", expectedHeaders, actualHeaders);
		}

		public void verifyShowFeesICanRefund(String credentials) {
			if (credentials.contains("Super")) {
				Element.verifyElementPresent(refundableCheckBox, "Show Fees I Can Refund CheckBox");
			} else {
				Element.verifyElementNotPresent(refundableCheckBox, "Show Fees I Can Refund CheckBox");
			}
		}

		/**
		 * This function creates an outer map with Key as payment number, payment Amount,Payment Date and Fee Amount and Value as
		 * another hash map i.e. inner map that contains all the details for key like
		 * payer name, amount etc
		 *
		 * @return Outer map
		 */
		public Map<String, LinkedHashMap<String, String>> getFeeSearchDetailsFromUI() {
			/** Gets headers List which will be key for following map */

			LinkedHashMap<String, String> innerMap;

			Map<String, LinkedHashMap<String, String>> outerMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
			ArrayList<String> headers = getHeadersFromFeeSearchTable();

			int totalNoOfPages = 1;

			for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
				List<WebElement> searchResultRows = Element.findElements(testConfig, "xpath",
						"//*[@id='optum-pay-fee-search']/div[2]/div[2]/div/div/div[2]/div/table/tbody/tr");

				for (int i = 0; i < searchResultRows.size(); i++) {
					innerMap = new LinkedHashMap<String, String>();

					for (int j = 0; j < headers.size(); j++) {
						String details = "";
						details = searchResultRows.get(i).findElements(By.tagName("td")).get(j).getText();
						if (headers.get(j).equals("Payment Amount") || headers.get(j).equals("Fee Amount")) {
							if (!details.isEmpty()) {
								details = details.substring(1);
							}
						}
						innerMap.put(headers.get(j), details);
					}
					if (!innerMap.get("Fee Status").equalsIgnoreCase("Refund Pending")) {
						outerMap.put(innerMap.get("Payment Date")+'_'+innerMap.get("Payment Number")+'_'+innerMap.get("Payment Amount")+'_'+innerMap.get("Fee Amount"), innerMap);
					}
				}

			}
			Log.Comment("Details from UI is: " + outerMap.toString());
			return outerMap;

		}

		public Map<String, LinkedHashMap<String, String>> getFeeSearchDetailsFromDB(ResultSet resultSet) throws SQLException {
			Map<String, LinkedHashMap<String, String>> outerMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
			int outerMapCounter = 0;
			int rowCount = 0;
			int max_row_count = 30;
			
			while (resultSet.next()) {
				if (!resultSet.getString("ROW_TYPE").equals("RFD")) {
					LinkedHashMap<String, String> innerMap = new LinkedHashMap<String, String>();
					
					String name = resultSet.getString("SUBPAYER_NAME");
					if (name == null) {
						name = resultSet.getString("PAYER_NAME");
					}
					String feeStatus = resultSet.getString("FEE_STATUS");
					if (feeStatus.equals("FS")) {
						feeStatus = "Accured";
					}
					innerMap.put("Payment Date", resultSet.getString("PAYMENT_DATE"));
					innerMap.put("Payer Name", name);
					innerMap.put("Payment Number", resultSet.getString("CONSL_PAY_NBR"));
					innerMap.put("Payment Amount", resultSet.getString("CONSL_AMT"));
					innerMap.put("Fee Amount", resultSet.getString("DBT_FEE_ACCRD_AMT"));
					innerMap.put("Invoice Number", resultSet.getString("INVC_NBR"));
					innerMap.put("Invoice Date", resultSet.getString("INVC_SETL_DT"));
					innerMap.put("Fee Type", "Per Payment Fee");
					innerMap.put("Fee Status", feeStatus);
					outerMap.put(resultSet.getString("PAYMENT_DATE")+'_'+resultSet.getString("CONSL_PAY_NBR")+'_'+resultSet.getString("CONSL_AMT")+'_'+resultSet.getString("DBT_FEE_ACCRD_AMT") ,innerMap);
					outerMapCounter++;
				}
				++rowCount;
				if (rowCount == max_row_count) {
					resultSet.afterLast();
				}
			}
			return outerMap;
		}
	
		}