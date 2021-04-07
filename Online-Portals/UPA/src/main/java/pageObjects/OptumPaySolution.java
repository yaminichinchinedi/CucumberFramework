package main.java.pageObjects;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;
import main.java.reporting.Log;

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
    
    @FindBy(xpath = "//div[@class='topMessaggeDiv']/p[2]/b")
	WebElement topHeader1_ImpRem_Premium;

	@FindBy(xpath = "(//div[@class='topMessaggeDiv']/p)[4]/b")
	WebElement topHeader2_IsYourProv_Premium;

	@FindBy(xpath = "(//div[@class='topMessaggeDiv']/p)[3]")
	WebElement topMsg1_YouWill_Premium;

	@FindBy(xpath = "(//div[@class='topMessaggeDiv']/p)[5]")
	WebElement topMsg2_SendTax_Premium;
	
	@FindBy(xpath = "(//div[@class='bottomMessageDiv']/p)[2]")
	WebElement footer1_IfaProv_Premium;
	
	@FindBy(xpath = "(//div[@class='bottomMessageDiv']/p)[3]")
	WebElement footer2_Cancellation_Premium;
	
	@FindBy(xpath = "//h1[contains(text(),'Optum Pay brings more power to your practice')]")
	WebElement msg1_Standard;
	
	@FindBy(xpath = "//h1[contains(text(),'Optum Pay brings more power to your practice')]/../p")
	WebElement msg2_Standard;
	
	@FindBy(xpath="//a[contains(text(),'Invoices') and @class='ui-tabs-anchor cursor-pointer']")
	WebElement invoicesTabOnOPS;
	
	@FindBy(xpath="//div[@id='optum-pay-invoices']/div[1]/div[1]/p/span")
	WebElement providerNameInvoicesTab;
	
	@FindBy(xpath="//div[@id='optum-pay-invoices']/div[1]/div[1]/p")
	WebElement providerNameValueInvoicesTab;
	
	@FindBy(xpath="//div[@id='optum-pay-invoices']/div[1]/div[2]/p")
	WebElement accruedFeesInvoicesTab;
	
	@FindBy(xpath="//div[@id='optum-pay-invoices']/div[1]/div[3]/p")
	WebElement pastDueFeesInvoicesTab;
	
	@FindBy(xpath="//table[@class='table']/thead/tr/th")
	WebElement invoicePeriodTableGrid;
	
    @FindBy(xpath=" //*[@id='optum-pay-options']/div[1]/div[3]/div[2]")
     WebElement feeTile;
    
    @FindBy(xpath="//div[@id='optum-pay-options']/div/div/div[3]/div/div[2]")
    WebElement feeTileUPA;
  

    @FindBy(linkText="Invoices")
    WebElement lnkInvoice;
    
    @FindBy(xpath="//div[@id=\"optum-pay-invoices\"]/div/div[1]/p")
    WebElement divPageMsg;

    @FindBy(xpath="//*[@id='optum-pay-invoices']/div/div[2]/p")
    WebElement divInvoicesAccrudFeesUI;
    @FindBy(xpath="//*[@id=\"optum-pay-invoices\"]/div/div[3]")
    WebElement divInvoicesPastDueFeesUI;
    @FindBy(xpath="//*[@id='optum-pay-invoices']/div/div[4]/div/p")
    WebElement msgNoInvoicesPresent;
    @FindBy(xpath="//*[@id='optum-pay-invoices']/div/div[4]/div/table/thead/tr/th")
    List<WebElement> tableInvoiceDetailTableHeader;
    @FindBy(xpath="//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr")
    List<WebElement> tableInvoiceDetailUI;
    @FindBy(xpath="//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[2]")
    List<WebElement> tableInvoiceAmountUI; 
    @FindBy(xpath="//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[3]")
    List<WebElement> tableInvoiceNumberUI;
    @FindBy(xpath="//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[1]")
    List<WebElement> tableInvoiceDateUI;

	
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

	//@FindBy(xpath = "//*[@id='optum-pay-fee-search']/div[2]/div[2]/div/div/div[1]/div[1]")
	@FindBy(xpath="//*[contains(text(),'Showing')]")
	WebElement divShowRslts;
	
	@FindBy(id="feeTypeOption_selector")
	WebElement feeTyp;
	
	@FindBy(id="feeStatusOption_selector")
	WebElement feeStatus;
	
	@FindBy(id="feeRangeMin")
	WebElement feeRngMin;
	
	@FindBy(id="feeRangeMax")
	WebElement feeRngMax;
	
	@FindBy(xpath="//button[contains(text(),'Details')]")
	WebElement detailsTab;
	
	@FindBy(xpath="//div[@id='feeSearchTable']/div[2]/div/table/tbody/tr")
	List <WebElement> noOfRows;
	
    @FindBy(xpath="//button[contains(text(),'Clear')]")
    private WebElement clearButton;
	
    @FindBy(xpath="//input[@name='showOnlyRefundables']")
    private WebElement refundFeeCheckbox;
    
    @FindBy(xpath="//input[@id='refundFeeButton']")
    private WebElement refundFeeButton;
    
    @FindBy(xpath="//input[@id='refundFeeCancelButton']")  
    private WebElement refundFeeCancelButton;
    
    @FindBy(xpath="//input[@value='Select All']")  
    private WebElement selectAll;
    
    @FindBy(xpath="//input[@name='refundFee'][1]")  
    private WebElement refundSingleRow;
    
    @FindBy(xpath="(//span[@class='wrapperTooltip'])[1]")
	WebElement planTypeTileInfoIconMsg;
		
	@FindBy(xpath="(//span[@class='wrapperTooltip'])[2]")
	WebElement rateTileInfoIconMsg;
		
	@FindBy(xpath="(//span[@class='wrapperTooltip'])[3]")
	WebElement feesTileInfoIconMsg;
		
	@FindBy(xpath="(//span[@class='wrapperTooltip'])[4]")
	WebElement manageMyPlanTileInfoIconMsg;
		
	@FindBy(xpath="//p[@class='errors mr-5 error__message']")
	WebElement errorMsgInvalid_NotAssociatedTIN_BS;
	
	@FindBy(xpath = "//td[@class='text-center']/a") 
	List<WebElement> invoiceNumberList;
	
	@FindBy(className="text-red")
	WebElement redTextError;
	
	@FindBy(xpath="//div[@class='modal-body']/p")
	WebElement feeRefundPopUpText2;
	
	@FindBy(xpath="//div[@id='refundConfirmation']/p")
	WebElement feeRefundPopUpText1;
	
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	WebElement refundPopUpCancelButton;
	
	@FindBy(xpath="//span[contains(text(),'Refund') and @class='ui-button-text']")
	WebElement refundPopUpRefundButton;
	
	@FindBy(xpath="//select[@name='selectedRefundReason']")
	WebElement reasonDropDownrefundPopUp;
	
	@FindBy(xpath = "//button[contains(text(),'Get Started with Optum Pay Today')]") 
	WebElement getStartedHeaderBtn;
	@FindBy(xpath="//input[@value='Get Started']") 
	WebElement getStartedBtn;
	@FindBy(xpath = "//form[@id='showOptumPayForm']//h2") 
	List<WebElement> headerBsUser;

	@FindBy(linkText="Cancel My Plan")
	WebElement cancelSubscriptionLinkCsr;
	@FindBy(id="reason_selector")
	WebElement reasonSelectorDrpDwn;
	@FindBy(name="otherReason")
	WebElement otherReasonTxtBox;
	@FindBy(id="cancelRequestDate")
	WebElement cancelRequestDateTxtBox;
	@FindBy(name="firstName")
	WebElement firstNameTxtBox;
	@FindBy(name="lastName")
	WebElement lastNameTxtBox;
	@FindBy(name="email")
	WebElement emailTxtBox;
	@FindBy(name="phoneNumber1")
	WebElement phoneNumber1;
	@FindBy(name="phoneNumber2")
	WebElement phoneNumber2;
	@FindBy(name="phoneNumber3")
	WebElement phoneNumber3;
	@FindBy(xpath="//div[@id='optum-pay-options']/div[5]/div[4]/input[2]")
	WebElement btnSave;
	@FindBy(xpath="//button[contains(text(),'Change']")
	WebElement btnChange;
	@FindBy(className="ui-button-text")
	List<WebElement> acceptPremiumBtn;
	
  //Added by Mohammad Khalid
  		String headerTop1_Premium ="Important reminder:";
  		String headerTop2_Premium ="Is your provider organization tax exempt?";
  		String pageTextTop1_Premium ="You will receive an email notification when the monthly invoice is ready. Fees are debited within 5 days and are deducted from the provider's TIN-level banking account. If you haven't already, please contact the financial institution and ask that the following ACH company ID and name be added to your bank account: Company ID: 1243848776 and Company Name: Optum Pay. Not adding Optum Pay as an authorized agent may result in ACH return fees and/or termination of service.";
  		String pageTextTop2_Premium ="Send the tax exempt certificate to optumpay_taxexempt@optum.com to ensure correct billing.";
  		
  		String footer1_Premium = "If a provider cancels the full functionality of Optum Pay several features will be lost, including access to pdf remittance files, the ability to search historical data and unlimited user access (user access exceptions may apply, visit the FAQs for details).";
  		String footer2_Premium = "Cancellation may take up to 7 days to process during which time the provider will be responsible for any charges to their account.";
  		
  		String Message1_Standard = "Optum Pay brings more power to your practice";
  		String Message2_Standard = "We are improving our service to help simplify your workflow and take efficiency to the next level. For a low fee*, we now offer additional tools and resources to give you more of what you're looking for.";
	
		private TestBase testConfig;
		
		public OptumPaySolution(TestBase testConfig) 
		{
			this.testConfig=testConfig;
			PageFactory.initElements(testConfig.driver, this);
			Element.fluentWait(testConfig, Element.findElement(testConfig, "xpath", "//*[@name='taxIndNbr']"), 60, 1, "Tin Selector");
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
				Browser.waitForPageLoad(testConfig.driver);
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
			
			if(credentials.equalsIgnoreCase("Super") && testConfig.getRunTimeProperty("prdctSelected").equalsIgnoreCase("Premium"))
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
		//Added by Mohammad Khalid
		public void verifyPageText_Top_Premium()
		{
			Helper.compareEquals(testConfig, "Header-1 Premium", headerTop1_Premium, topHeader1_ImpRem_Premium.getText().trim());
			Helper.compareEquals(testConfig, "Header-2 Premium", headerTop2_Premium, topHeader2_IsYourProv_Premium.getText().trim());
			Helper.compareEquals(testConfig, "Top Page Text -1 Premium", pageTextTop1_Premium, topMsg1_YouWill_Premium.getText().trim());
			Helper.compareEquals(testConfig, "Top Page Text -2 Premium", pageTextTop2_Premium, topMsg2_SendTax_Premium.getText().trim());
		}
		
		public void verifyPageText_Footer_Premium()
		{
			Helper.compareEquals(testConfig, "Footer-1 Premium", footer1_Premium, footer1_IfaProv_Premium.getText().trim());
			Helper.compareEquals(testConfig, "Footer-2 Premium", footer2_Premium, footer2_Cancellation_Premium.getText().trim());
		}
		
		
		public void verifyPageText_Message1_Standard()
		{
			Helper.compareEquals(testConfig, "Message 1 Standard", Message1_Standard, msg1_Standard.getText().trim());
		}
		
		public void verifyPageText_Message2_Standard()
		{
			Helper.compareEquals(testConfig, "Message 2 Standard", Message2_Standard, msg2_Standard.getText().trim());
		}
		
		
		public void clickOnInvoicesTab()
		{
			Element.click(invoicesTabOnOPS, "Invoices tab on OPS page");
		}
		
		public void verifyProviderName() throws IOException, SQLException
		{
			String expectedProviderName = null;
			testConfig.putRunTimeProperty("Prov_tin_nbr", testConfig.getRunTimeProperty("tin"));
			Map<String, String> results = DataBase.executeSelectQuery(testConfig,236, 1);
			expectedProviderName = (String) results.get("ORG_NM");
			String actualProviderName = providerNameValueInvoicesTab.getText().substring(9, providerNameValueInvoicesTab.getText().length());
			Helper.compareEquals(testConfig, "Provider Name", expectedProviderName, actualProviderName.trim());
		}
		
		public void verifyAccruedFees()
		{
			String actualAccruedFeesTitle = accruedFeesInvoicesTab.getText().substring(0, 27);
			String actualAccruedFees = accruedFeesInvoicesTab.getText().substring(29, accruedFeesInvoicesTab.getText().length());
			String expectedAccruedFees = null;
			testConfig.putRunTimeProperty("tin", testConfig.getRunTimeProperty("tin"));
			Map<String, String> data = DataBase.executeSelectQuery(testConfig,1616, 1);
			if (data.get("ACCRDFEE").toString().isEmpty())
				expectedAccruedFees = "0.00";
			else
				expectedAccruedFees = data.get("ACCRDFEE").toString();
			
			Helper.compareEquals(testConfig, "Accrued Fees Title", "Accrued fees month to date:", actualAccruedFeesTitle.trim());
			Helper.compareEquals(testConfig, "Accrued Fees", expectedAccruedFees, actualAccruedFees.trim());
		}
		
		public void verifyPastDueFees() throws IOException, SQLException
		{
			String expectedPastDueFees = null;
			testConfig.putRunTimeProperty("tin", testConfig.getRunTimeProperty("tin"));
			Map<String, String> data = DataBase.executeSelectQuery(testConfig,1630, 1);
			
			if(data.get("PASTDUEFEE").toString().isEmpty())
				expectedPastDueFees = "0.00";
			else
				expectedPastDueFees = data.get("PASTDUEFEE").toString();
			
			String actualPastDueFees = pastDueFeesInvoicesTab.getText().substring(16, pastDueFeesInvoicesTab.getText().length());
			Helper.compareEquals(testConfig, "Past Due Fees", expectedPastDueFees, actualPastDueFees.trim());
		}
		
		public void verifyInvoicePeriodGrid() throws IOException, SQLException, ParseException
		{
			List<WebElement> tableHeads = Element.findElements(testConfig, "xpath", "//table[@class='table']/thead/tr/th");
			List<String> expectedTableHeads = new ArrayList<>();
			expectedTableHeads.add(0, "Invoice Period");
			expectedTableHeads.add(1, "Total Invoice Amount");
			expectedTableHeads.add(2, "Download Invoice");
			
			String downloadInvoiceNumber = null;
			List<String> billingStartDate = new ArrayList<>();
			
			for (int i=0; i<tableHeads.size(); i++)
			{
				String actualTableHeads = tableHeads.get(i).getText().trim();
				Helper.compareEquals(testConfig, "Invoice Period Grid Titles", expectedTableHeads.get(i), actualTableHeads);
			}
			
			List<WebElement> tableValues = Element.findElements(testConfig, "xpath", "//table[@class='table']/tbody/tr");
			for (int i=0; i<tableValues.size(); i++)
			{
				String xpathInvcNumber = "//table[@class='table']/tbody/tr["+ (i+1) +"]/td[3]/a";
				WebElement invcNumber = Element.findElement(testConfig, "xpath", xpathInvcNumber);
				downloadInvoiceNumber = invcNumber.getText();
				
				String xpathtTotalInvoiceAmount = "//table[@class='table']/tbody/tr["+ (i+1) +"]/td[2]";
				WebElement totInvcAmount = Element.findElement(testConfig, "xpath", xpathtTotalInvoiceAmount);
				String exTotalInvoiceAmount = totInvcAmount.getText().substring(1);
				
				String xpathtBillingPeriod = "//table[@class='table']/tbody/tr["+ (i+1) +"]/td[1]";
				WebElement billingPeriod = Element.findElement(testConfig, "xpath", xpathtBillingPeriod);
				String invcBillingPeriod = billingPeriod.getText();
				
				billingStartDate.add(0, invcBillingPeriod.substring(0,10));
				
				String exBilMonthStart= invcBillingPeriod.substring(0,2);
				String exBilDayStart= invcBillingPeriod.substring(3,5);
				String exBilYearStart= invcBillingPeriod.substring(6,10);
				
				
				String exBilMonthEnd= invcBillingPeriod.substring(13,15);
				String exBilDayEnd= invcBillingPeriod.substring(16,18);
				String exBilYearEnd= invcBillingPeriod.substring(19,23);
				
				
				testConfig.putRunTimeProperty("tin", testConfig.getRunTimeProperty("tin"));
				testConfig.putRunTimeProperty("downloadInvoiceNumber", downloadInvoiceNumber);
				Map<String, String> data = DataBase.executeSelectQuery(testConfig,2010, 1);
				
				String actualInvcAmount = data.get("INVC_TOT_AMT").toString();
				
				String acBilYearStart= data.get("BILL_CYC_STRT_DT").toString().substring(0,4);
				String acBilMonthStart= data.get("BILL_CYC_STRT_DT").toString().substring(5,7);
				String acBilDayStart= data.get("BILL_CYC_STRT_DT").toString().substring(8,10);
				
				
				String acBilYearEnd= data.get("BILL_CYC_END_DT").toString().substring(0,4);
				String acBilMonthEnd= data.get("BILL_CYC_END_DT").toString().substring(5,7);
				String acBilDayEnd= data.get("BILL_CYC_END_DT").toString().substring(8,10);
				
				
				Helper.compareEquals(testConfig, "Total Invoice Amount for each Invoice", exTotalInvoiceAmount, actualInvcAmount);
				
				Helper.compareEquals(testConfig, "Billing Period Month-Start", exBilMonthStart, acBilMonthStart);
				Helper.compareEquals(testConfig, "Billing Period Day-Start", exBilDayStart, acBilDayStart);
				Helper.compareEquals(testConfig, "Billing Period Year-Start", exBilYearStart, acBilYearStart);
				
				Helper.compareEquals(testConfig, "Billing Period Month-End", exBilMonthEnd, acBilMonthEnd);
				Helper.compareEquals(testConfig, "Billing Period Day-End", exBilDayEnd, acBilDayEnd);
				Helper.compareEquals(testConfig, "Billing Period Year-End", exBilYearEnd, acBilYearEnd);
				
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			for (int i=0; i<billingStartDate.size()-1; i++)
			{
				for (int k=i+1; k<billingStartDate.size(); k++)
				{
					Date date1 = sdf.parse(billingStartDate.get(i));
			        Date date2 = sdf.parse(billingStartDate.get(k));
			        
			        if (date1.compareTo(date2)>=0)
			        {
			        	Log.Comment("The Billig Period is in decending order");
			        }
			        
			        else
			        {
			        	Log.Fail("The Billig Period is NOT in decending order");
			        }
				}
			}
			
		}
	 	public OptumPaySolution validatePastdueFee()
		{
			int sqlRowNo=1630;
			Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    String feeTitle=null;
			feeTitle="Past due fees: $" +data.get("PASTDUEFEE").toString();
			 if(System.getProperty("Application").contains("UPA"))
			Helper.compareContains(testConfig, "Past due fee value", feeTitle, feeTileUPA.getText());
			 else
			 Helper.compareContains(testConfig, "Past due fee value", feeTitle, feeTile.getText());
			return this;
		}
	 	
	 	public OptumPaySolution verifyInvoicesTab(String searchCriteria,String tinType,String portalAccess,String prdctRecSts) throws ParseException{
            if("TinWithInvoices".equals(searchCriteria)){
                Element.verifyElementPresent(lnkInvoice, "Invoices Link");
                Element.clickByJS(testConfig, lnkInvoice, "Invoices Link");
                Element.verifyElementPresent(divPageMsg, "Page message");
                verifyPastDuesInvoiceTab(searchCriteria);
                verifyProviderNameInvoices();
                verifyAccrudFeesInvoiceTab(searchCriteria);
                try {
					verifyInvoiceDetailsTableUI(searchCriteria);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            else if("TinWithoutInvoices".equals(searchCriteria) && ("AV".equals(tinType) || "AO".equals(tinType)) && "Premium".equals(portalAccess) && "PS".equals(prdctRecSts)){
                Element.verifyElementPresent(lnkInvoice, "Invoices Link");
                Element.clickByJS(testConfig, lnkInvoice, "Invoices Link");
                Element.verifyElementPresent(divPageMsg, "Page message");
                verifyPastDuesInvoiceTab(searchCriteria);
                verifyAccrudFeesInvoiceTab(searchCriteria);
                verifyProviderNameInvoices();
                Element.verifyElementPresent(msgNoInvoicesPresent, "no invoices present msg");
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
	 	
		public void verifyProviderNameInvoices() {
			int sqlRowNo=1;
			Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Helper.compareContains(testConfig,"test", data.get("ORG_NM").toString().trim(), Element.findElement(testConfig, "xpath", "//*[@id=\"optum-pay-invoices\"]/div/div[1]/p").getText().trim());
			
		}
		public void verifyInvoiceDetailsTableUI(String searchCriteria) throws IOException, ParseException {
			int sqlTable=1120;
            HashMap<Integer,HashMap<String,String>>  invoiceTableData = DataBase.executeSelectQueryALL(testConfig, sqlTable);
			ArrayList<String> expectedHeader=new ArrayList<String>(); 
			expectedHeader.add("Invoice Period");
			expectedHeader.add("Total Invoice Amount");
			expectedHeader.add("Download Invoice");
					
			if("TinWithInvoices".equals(searchCriteria))
			{
			  ArrayList<String> actualContentUI=new ArrayList<String>(); 
			  for(WebElement header: tableInvoiceDetailTableHeader)
			  	{
				  actualContentUI.add(header.getText());
			  	}
			
			  Helper.compareEquals(testConfig, "tableInvoiceDetailTableHeader", expectedHeader, actualContentUI);
			  
			  for(int i=0; i<tableInvoiceAmountUI.size() ;i++)
				{ 
				  String  startDate= Helper.changeDateFormat(invoiceTableData.get(i+1).get("BILL_CYC_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				 String  endDate= Helper.changeDateFormat(invoiceTableData.get(i+1).get("BILL_CYC_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				Helper.compareEquals(testConfig,"billing cycle",startDate+" - "+endDate,tableInvoiceDateUI.get(i).getText());
				Helper.compareEquals(testConfig,"invoice amount", "$"+invoiceTableData.get(i+1).get("INVC_TOT_AMT").toString(),tableInvoiceAmountUI.get(i).getText());
				Helper.compareEquals(testConfig,"invoice number", invoiceTableData.get(i+1).get("INVC_NBR").toString(),tableInvoiceNumberUI.get(i).getText()); 
	            }
			}
			
		}
		public void verifyAccrudFeesInvoiceTab(String searchCriteria) {
			int sqlRowNo=1616;
			Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    String invoiceAccrudFee=null;
		    if("TinWithInvoices".equals(searchCriteria)&& data.get("ACCRDFEE").toString().trim().length()>0)
		    invoiceAccrudFee="Accrued fees month to date: $" +data.get("ACCRDFEE").toString();
		    else if("TinWithoutInvoices".equals(searchCriteria)||data.get("ACCRDFEE").toString().trim().length()==0)
		    invoiceAccrudFee="Accrued fees month to date: $0.00" ;
		    
			Helper.compareContains(testConfig, "Accrud fee value", invoiceAccrudFee, divInvoicesAccrudFeesUI.getText());
			
		}
		public void verifyPastDuesInvoiceTab(String searchCriteria) {
			String invoicePastDueFee=null;
			int sqlRowNo=1122;
			Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			
			if("TinWithoutInvoices".equals(searchCriteria)|| data.get("PASTDUE").toString().trim().length()==0)
				invoicePastDueFee="Past due fees: $0.00";
			else if("TinWithInvoices".equals(searchCriteria))
				invoicePastDueFee="Past due fees: $" +data.get("PASTDUE").toString();
			
			Helper.compareContains(testConfig, "Past due fee value", invoicePastDueFee, divInvoicesPastDueFeesUI.getText());
			
		}
		
		public void navigateToFeeSearchTab() {
			Element.clickByJS(testConfig,feeSearchTab, "Fee Search Tab");
		}

		public OptumPaySolution doSearch(String criteriaType) throws ParseException {
			
			switch (criteriaType) {

				case "feeSearchPaymentNumber": {
//					Browser.wait(testConfig, 5);
					String dspl_consl_pay_nbr = testConfig.getRunTimeProperty("paymentNumber");
					Element.enterDataByJS(testConfig, paymentNumber, dspl_consl_pay_nbr, "Enter Fee Search payment number as: " + dspl_consl_pay_nbr);
					break;
				}
				case "feeSearchInvoiceNumber": {
					String invoice_nbr = testConfig.getRunTimeProperty("invoiceNumber");
					Element.enterDataByJS(testConfig,invoiceNumber, invoice_nbr, "Enter Fee Search invoice number as: " + invoiceNumber);
					break;
				}
				case "feeSrchTINdetailsTabwthAllVal": 
				{
					clickDetailsTab();
					Element.selectByVisibleText(feeTyp, "All", "All Value in Fee Type");
					Element.selectByVisibleText(feeStatus, "All", "All Value in Fee Status");
					break;
				}
				case "NofeeSearchTIN": {
					Browser.wait(testConfig, 2);
					clickDetailsTab();
					Element.selectByVisibleText(feeTyp, "All", "All Value in Fee Type");
					break;
				}
				
			}

			return clickSearchBtn();
		}

		public OptumPaySolution clickSearchBtn() {
			Element.clickByJS(testConfig, searchButton, "Fee Search Button");
			return this;
		}
		
		public OptumPaySolution clickDetailsTab() {
			Element.clickByJS(testConfig, detailsTab, "details Tab");
			return this;
		}
		public String getRecordCountFromUI() {
			String resultCount = divShowRslts.getText().toString();
			resultCount = resultCount.substring("Showing".length(), resultCount.indexOf("Results"));
			return resultCount.trim();
		}
		public int getNumberOfPages()
		 {
			int noOfPages=0;
			int recordsCount=Integer.parseInt(getRecordCountFromUI());
			if(recordsCount>30)
			 {
				noOfPages=recordsCount/30;
				if(recordsCount%30>0)
				noOfPages=noOfPages+1;
			 }
			else
			noOfPages=1;
	    	return noOfPages;
		 } 
		public OptumPaySolution verifyPagination(){
			
			if (Element.findElement(testConfig, "xpath", "//div[@id='optum-pay-fee-search']/div[2]/div/div/p")!=null)	
				{
				String actualtxt=Element.findElement(testConfig, "xpath", "//div[@id='optum-pay-fee-search']/div[2]/div/div/p").getText();
				Helper.compareEquals(testConfig, "message comparision", "No fees available for this Organization.", actualtxt);
				
			}
			else{
				int totalNoOfPages=getNumberOfPages();
			    int pageNo=1;
			
			
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
					
		    
			if(pageNo%10!=0 && pageNo<totalNoOfPages)
			    {  
			       int pageToBeClicked=pageNo+1;
			      
			       Element.findElement(testConfig,"xpath","//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text()," + pageToBeClicked + ")]").click();
			       Log.Comment("Clicked Page number : " + pageToBeClicked);
			       
			       Browser.wait(testConfig, 2);
			       Element.findElement(testConfig,"xpath","//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'<')]").click();
			       Log.Comment("Clicked back Page");
			       
			       Browser.wait(testConfig, 2);
			       Element.findElement(testConfig,"xpath","//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'>')]").click();
			       Log.Comment("Clicked next Page");
			       
			       Browser.wait(testConfig, 2);
			       Element.findElement(testConfig,"xpath","//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'<<')]").click();
			       Log.Comment("Clicked first Page");
			       
			       Element.findElement(testConfig,"xpath","//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'>>')]").click();
			       Log.Comment("Clicked last Page");
			       
					if(
							Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[2]").getTagName()!="a"&& 
							Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[3]").getTagName()!="a" )
							Log.Pass("> and >> are disabled");
							else
								Log.Fail("> and >> are enabled");	
			       Browser.waitForLoad(testConfig.driver);
			     }
			     
			}
			Element.clickByJS(testConfig,lnkLogOut , "logging Out of the portal");	    
		return this;
		
		}
		
		public OptumPaySolution clickFeesForRefund() {
	        if(!refundFeeCheckbox.isDisplayed())
	        	Element.fluentWait(testConfig, refundFeeCheckbox, 60, 1, "Show Fee for refund checkbox");
			Element.clickByJS(testConfig, refundFeeCheckbox, "Show Fee for refund checkbox");
			return this;
		}
		
		public OptumPaySolution validateFeeRefundButtonsAndFunctionality(String feeSearchCriteria) {
			
			clickFeesForRefund();
		
		    Element.verifyElementNotEnabled(refundFeeButton, "refund fee button is disabled");
		    Element.verifyElementNotEnabled(refundFeeCancelButton, "refund fee cancel button");
		    Element.verifyElementIsEnabled(selectAll, "Select all");
			
//			Assert.assertFalse(refundFeeButton.isEnabled(), "refund fee button assertion failed");
//			Assert.assertFalse(refundFeeCancelButton.isEnabled(), "refund fee cancel button assertion failed");
//			Assert.assertTrue(selectAll.isEnabled(), "refund fee select all assertion failed");
//			Log.Comment("Refund fee, selectAll, cancel button assertion successfully completed");
            
			Element.clickByJS(testConfig, refundSingleRow, "first entry in the refund fee");
			Element.clickByJS(testConfig, refundFeeCancelButton, "refund fee cancel button");
			Element.clickByJS(testConfig, selectAll, "select All button");
		   
			Element.verifyElementIsEnabled(refundFeeButton, "Refund Button");
			Element.verifyElementIsEnabled(refundFeeCancelButton, "refundFeeCancelButton");
			Element.verifyElementIsEnabled(selectAll, "Select all");
//			Assert.assertTrue(refundFeeButton.isEnabled(), "refund fee button assertion failed");
//			Assert.assertTrue(refundFeeCancelButton.isEnabled(), "refund fee cancel button assertion failed");
//			Assert.assertTrue(selectAll.isEnabled(), "refund fee select all assertion failed");
//			Log.Comment("Refund fee, selectAll, cancel button assertion successfully completed");
			
            if(feeSearchCriteria.equalsIgnoreCase("feeSearchInvoiceNumber")) {
            	Map<String,String> totalCount = DataBase.executeSelectQuery(testConfig,QUERY.EXPECTED_COUNT_FOR_FEE_REFUND_INVOICE_NUMBER, 1);
            	Helper.compareEquals(testConfig, "Asserting number of entries in DB vs UI", totalCount.get("COUNT"), getRecordCountFromUI());
            }
            
            if(feeSearchCriteria.equalsIgnoreCase("feeSearchPaymentNumber")) {
            	Map<String,String> totalCount2 = DataBase.executeSelectQuery(testConfig,QUERY.EXPECTED_COUNT_FOR_FEE_REFUND_PAYMENT_NUMBER, 1);
            	Helper.compareEquals(testConfig, "Asserting number of entries in DB vs UI", totalCount2.get("COUNT"), getRecordCountFromUI());
            }	
			
            clickFeesForRefund();		
            Element.clickByJS(testConfig, clearButton, "Clear button");
			return this;
		}		
		

		
	public void verifyInfoIconMessagesforAllTiles()
	 	{
	 		String planTypeInfoIconMsg="Your provider organization will be billed monthly for any fees incurred the previous month. For example, fees accrued during the month of June will be invoiced within the first 5 business days of July. You will receive an email in advance of the debit to your TIN-level bank account and you can review the fees on the Invoices subtab.";
	 		String rateInfoIconMsg="Per payment fees are calculated based on the total payment amount.";
	 		String feesInfoIconMsg="To view individual per-payment fees, please visit the View Payments page.  Fees will be billed monthly.";
	 		String manageMyPlanInfoIconMsg="To cancel the full functionality of Optum Pay, the Provider administrator must complete the Cancellation Fee Form found in the Resources link and email it to optumpay_cancel@optum.com." + 
	 				"Note:  Cancellation may take up to 7 days to process during which time the provider will be responsible for any charges to their account.  Any fees incurred prior to cancellation will be billed at the end of the current billing cycle.";
	 		
			
	 		Helper.compareEquals(testConfig, "Plan Type Info Icon Message", planTypeInfoIconMsg, planTypeTileInfoIconMsg.getAttribute("title").trim());
	 		Helper.compareEquals(testConfig, "Rate Info Icon Message", rateInfoIconMsg, rateTileInfoIconMsg.getAttribute("title").trim());
	 		Helper.compareEquals(testConfig, "Fees Info Icon Message", feesInfoIconMsg, feesTileInfoIconMsg.getAttribute("title").trim());
	 		Helper.compareContains(testConfig, "Manage My Plan Info Icon Message", manageMyPlanInfoIconMsg, manageMyPlanTileInfoIconMsg.getAttribute("title").replace("<br>", "").replaceAll("[\\n]", "").trim());
	 	}
		
		//Added by Mohammad
		public boolean verifyTilesArePresentOnOPS()
		{
			boolean flag = false;
			
			for(WebElement tiles: tilesHeaderUI)
			{
				if(tiles.isDisplayed())
				{
					flag=true;
				}
			}
			
			
			return flag;
		}
		
		public void verifyTINerroMsgforBSUsers(String tinType)
		{
			String ex_Error_MsgInvalidTIN_BS = "TIN must be 9 digits";
			String ex_Error_MsgNotAssociatedTIN_BS = "TIN is not enrolled and/or not associated with your Billing Service";
			
			switch (tinType)
			{
			case "Invalid":
			{
				Helper.compareEquals(testConfig, "Invalid TIN error message for BS", ex_Error_MsgInvalidTIN_BS, errorMsgInvalid_NotAssociatedTIN_BS.getText().trim());
				break;
			}
			
			case "NotAssociated":
			{
				Helper.compareEquals(testConfig, "Not Associated TIN error message for BS", ex_Error_MsgNotAssociatedTIN_BS, errorMsgInvalid_NotAssociatedTIN_BS.getText().trim());
				break;
			}
			}
			
		}
		
public OptumPaySolution clickInvoiceNumberAndOpenPdf()
	 	{
			String parentwindowhandle=testConfig.driver.getWindowHandle();
	 		String invoiceNum;
	 		String oldWindow="";
	 		int invoiceSql=1120;
	 		Map invoiceTable=DataBase.executeSelectQuery(testConfig, invoiceSql, 1);
	 		invoiceNum = invoiceTable.get("INVC_NBR").toString();
	 		for(WebElement invoice :invoiceNumberList)
	 		{

	 			if(invoiceNum.equals(invoice.getText()))
		 		{
		 			for (int i=0; i<2; i++)
		 			{
		 				Element.clickByJS(testConfig, invoice, "invoice");
		 				oldWindow=Browser.switchToNewWindow(testConfig);
		 				
		 				Browser.waitForLoad(testConfig.driver);
		 				if(redTextError.isDisplayed())
		 				{
		 					Helper.compareContains(testConfig, "Not able to generate Invoice", "Something went wrong. We were unable to generate the invoice. Please close this tab and try again later.", redTextError.getText());
		 				}
		 				else 
		 				{
		 					Browser.verifyURL(testConfig, "OPSInvoices.do?invoiceNumber"+invoiceNum);
		 				}
		 				Browser.closeBrowser(testConfig);
		 				Browser.switchToParentWindow(testConfig, oldWindow);
		 				break;
		 			}
	 			}
	 			
	 		}	 		
	 		return this;
	 	}	


		public void selectFeeAmountCheckBoxAndCalculateFeeAmount()
		{
			double feeAmount=0;
			clickFeesForRefund();
			
			List<WebElement> ls = Element.findElements(testConfig, "xpath", "//table[@class='table fee_table']/tbody/tr");
			int feeCount = ls.size();
			Log.Comment("Total Fee Number" + feeCount);
			testConfig.putRunTimeProperty("TotalNumberOfFees", String.valueOf(feeCount));
			
			for (int i=0; i<ls.size(); i++)
			{
				String xpathFeeAmount = "//table[@class='table fee_table']/tbody/tr["  + (i+1) + "]/td[5]";
				WebElement FeeAmount = Element.findElement(testConfig, "xpath", xpathFeeAmount);
				feeAmount = feeAmount + Double.valueOf(FeeAmount.getText().trim().substring(1, FeeAmount.getText().trim().length()));
			}
			
			testConfig.putRunTimeProperty("TotFeeAmountRefund", String.valueOf(feeAmount));
			
			selectAll.click();
			Log.Comment("Select All button clicked");
			
			refundFeeButton.click();
			Log.Comment("Refund Button clicked");
			
		}
		
		
		public void verifyTextOnRefundPopUI()
		{
			String ex_AreYouSure = "Are You Sure?";
			String ex_RefundText = "You are about to refund "+ testConfig.getRunTimeProperty("TotalNumberOfFees") +" fees totaling $"+ testConfig.getRunTimeProperty("TotFeeAmountRefund") +". This amount will be reflected as a credit on the provider's next invoice. Please select the reason for the refund.";
			
			Helper.compareEquals(testConfig, "Refund Pop UI Text", ex_AreYouSure, feeRefundPopUpText1.getText().trim());
			Helper.compareEquals(testConfig, "Refund Pop UI Text", ex_RefundText, feeRefundPopUpText2.getText().trim());
			Element.clickByJS(testConfig, refundFeeCancelButton, "Refund Pop Up Cancel Button");
		
		}
		
		public void clickOnSelectAllandRefundButton()
		{
			Element.clickByJS(testConfig, selectAll, "Select All Button clicked");
			Element.clickByJS(testConfig, refundFeeButton, "Refund Button");
		}
		
		public void selectRefundReasonandClickOnRefundButton()
		{
			Element.selectByVisibleText(reasonDropDownrefundPopUp, "Fraud", "Selecting 'Fraud' Reason for Fee Refund");
		}
		

		public void validateOptumPaySolutionPage(String userType, String portalAccess, String tinType) {

			if(userType.equals("BS") && portalAccess.equals("Standard")) {

				Helper.compareEquals(testConfig, "Heading", "Leverage all that Optum Pay has to offer", txtOnStandardPage.getText());
				Element.verifyElementPresent(video, "Video");
				Element.verifyElementNotPresent(getStartedHeaderBtn, "Get Started btn on Header");
				Element.verifyElementNotPresent(getStartedBtn, "Get Started btn");
				String headerExpected[]= {"Solutions to meet your needs","Data Access","Unlimited Users","Workflow Management Tools"};
				int i=0;
				for (WebElement header : headerBsUser) 
				{
					Helper.compareEquals(testConfig, "Headers for a Standard TIN", headerExpected[i++], header.getText());
				}
			}
		}
		
		public OptumPaySolution cancelPremiumAndSubmit(String reasonCode, String portal)
		{
			String fname="";
			String lname="";
			String email="";
			String phoneNum="";
			String phNum1="";
			String phNum2="";
			String otherReason="";
			String date="";

			if(portal.equals("CSR"))
			{
				fname=Helper.generateRandomAlphabetsString(5);
				lname=Helper.generateRandomAlphabetsString(5);
				email=Helper.getUniqueEmailId();
				phNum1=Long.toString(Helper.generateRandomNumber(3));
				phNum2=Long.toString(Helper.generateRandomNumber(4));
				date=Helper.getCurrentDate("MM/dd/yyyy");

				Element.clickByJS(testConfig, cancelSubscriptionLinkCsr, "Cancel link-CSR");

				Element.enterDataByJS(testConfig, cancelRequestDateTxtBox, date, "Cancel Request Date");
				Element.enterDataByJS(testConfig, firstNameTxtBox, fname, "First Name");
				Element.enterDataByJS(testConfig, lastNameTxtBox, lname, "Last Name");
				Element.enterDataByJS(testConfig, emailTxtBox, email, "Email");
				Element.enterDataByJS(testConfig, phoneNumber1, phNum1, "Phone Number 1");
				Element.enterDataByJS(testConfig, phoneNumber2, phNum1, "Phone Number 2");
				Element.enterDataByJS(testConfig, phoneNumber3, phNum2, "Phone Number 3");

				testConfig.putRunTimeProperty("phoneNum", phNum1+phNum1+phNum2);
			}
			else if(portal.equals("UPA")){
				int sql=7;
				Map portalData = DataBase.executeSelectQuery(testConfig, sql, 1);

				fname=portalData.get("FST_NM").toString();
				lname=portalData.get("LST_NM").toString();
				email=portalData.get("EMAIL_ADR_TXT").toString();
				phoneNum=portalData.get("TEL_NBR").toString();
				date=Helper.getCurrentDate("MM/dd/yyyy");

				Element.clickByJS(testConfig, lnkCancelPlanDuringTrial, "Cancel My Subscription Link-UPA");

				testConfig.putRunTimeProperty("phoneNum", phoneNum);
			}

			Element.selectByValue(reasonSelectorDrpDwn, reasonCode, "Selecting Others");
			if(reasonCode.equalsIgnoreCase("R7"))
			{
				otherReason=Helper.generateRandomAlphabetsString(7);
				Element.enterDataByJS(testConfig, otherReasonTxtBox, otherReason, "Fill Other Reason");
			}

			if(portal.equals("CSR")) 
				Element.clickByJS(testConfig, btnSave, "Save button");
			else if(portal.equals("UPA"))
				Element.clickByJS(testConfig, btnCancellationSubmitTrial, "click on cancel");//click(btnCancellationSubmitTrial,"click on cancel");

			testConfig.putRunTimeProperty("fname", fname);
			testConfig.putRunTimeProperty("lname", lname);
			testConfig.putRunTimeProperty("date", date);
			testConfig.putRunTimeProperty("email", email);
			testConfig.putRunTimeProperty("reasonCode", reasonCode);
			testConfig.putRunTimeProperty("otherReason", otherReason);

			return this;
		}

		public OptumPaySolution updatedToStandardAfterCancel(String trialStatus) throws ParseException {
			String effectiveDate="";
			if(trialStatus.compareToIgnoreCase("New Enroll WithinTrial and Paid")==0)
			{
				testConfig.putRunTimeProperty("stdStatus", "P");
				Map duringTrialRecord = DataBase.executeSelectQuery(testConfig, QUERY.PREMIUM_TRIAL_FOR_TIN, 1);
				effectiveDate = duringTrialRecord.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString();
			}
			else 
				testConfig.putRunTimeProperty("stdStatus", "A");

			Map portalUserTable = DataBase.executeSelectQuery(testConfig, QUERY.POST_CANCELLATION_TIN_STATUS, 1);

			if(portalUserTable!=null)
				Log.Pass("Premium Cancelled sucessfully");
			else Log.Fail("Premium Not Cancelled sucessfully");

			if(trialStatus.compareToIgnoreCase("New Enroll WithinTrial and Paid")==0) {
				Helper.compareEquals(testConfig, "Effective date of inserted Standard record for Within Trial TIN", Helper.addDays(effectiveDate, 30).toString(), portalUserTable.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().substring(0, 10));
			}
			else Helper.compareEquals(testConfig, "Effective date of inserted Standard record for Post Trial TIN", Helper.getCurrentDate("MM/dd/yyyy").toString(), Helper.changeDateFormat(testConfig, portalUserTable.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().substring(0, 10), "yyyy-mm-dd","mm/dd/yyyy").toString());

			return this;
		}

		public OptumPaySolution verifyCancelTableUpdated()
		{
			Map portalUserTable = DataBase.executeSelectQuery(testConfig, QUERY.PRODUCT_SELECTION_CANCEL_RECENT, 1);

			Helper.compareEquals(testConfig, "Reason Code", testConfig.getRunTimeProperty("reasonCode"), portalUserTable.get("PRTL_PRDCT_CNCL_RSN_CD").toString());
			Helper.compareEquals(testConfig, "Other Reason", testConfig.getRunTimeProperty("otherReason"), portalUserTable.get("PRTL_PRDCT_CNCL_RSN_NOTES").toString());
			Helper.compareEquals(testConfig, "Date", testConfig.getRunTimeProperty("date"), Helper.changeDateFormat(testConfig, portalUserTable.get("PRTL_PRDCT_CNCL_SUBMIT_DTTM").toString().substring(0, 10), "yyyy-mm-dd", "mm/dd/yyyy"));
			Helper.compareEquals(testConfig, "Email", testConfig.getRunTimeProperty("email"), portalUserTable.get("PRTL_PRDCT_CNCL_EMAIL").toString());
			Helper.compareEquals(testConfig, "First name", testConfig.getRunTimeProperty("fname"), portalUserTable.get("PRTL_PRDCT_CNCL_FST_NM").toString());
			Helper.compareEquals(testConfig, "Last name", testConfig.getRunTimeProperty("lname"), portalUserTable.get("PRTL_PRDCT_CNCL_LST_NM").toString());
			Helper.compareEquals(testConfig, "Phone Number", testConfig.getRunTimeProperty("phoneNum"), portalUserTable.get("PRTL_PRDCT_CNCL_PH").toString());

			return this;
		}

		public OptumPaySolution verifyPremiumCancelledOnUIAndChangeTinToPremium(String trialStatus, String portal) {
			if(portal.equals("CSR"))
				Helper.compareContains(testConfig, "Plan Change to Limited", "Limited", txtProvNameInfo.getText());
			else Element.verifyElementPresent(getStartedBtn, "getStartedBtn");

			if(trialStatus.equals("New Enroll WithinTrial and Paid"))
				testConfig.putRunTimeProperty("prdSts", "P"); 
			else testConfig.putRunTimeProperty("prdSts", "A");

			DataBase.executeDeleteQuery(testConfig, QUERY.DELETE_CANCELLED_TO_STANDARD_ROWS);
			DataBase.executeUpdateQuery(testConfig, QUERY.UPDATE_CANCELLED_TO_STANDARD_ROWS);
			return this;
		}
		
		public OptumPaySolution convertToPremiumFromUpa()
		{
			Element.clickByJS(testConfig, getStartedBtn, "Get Started Btn");
			Element.clickByJS(testConfig, acceptPremiumBtn.get(2), "I Accept, activate Premium");
			return this;
		}

		public OptumPaySolution verifyEffectiveDateOfTrialPendingRecord(String portalAccess, String tinType) throws ParseException
		{
			String trialDate;

			testConfig.putRunTimeProperty("prdSelection", portalAccess);
			testConfig.putRunTimeProperty("stsOfStdRecd", "P");

			if(portalAccess.equals("Premium") && tinType.equals("AO"))
				testConfig.putRunTimeProperty("SelectedOrDefault", "PS");
			else if(portalAccess.equals("Standard") && tinType.equals("AO"))
				testConfig.putRunTimeProperty("SelectedOrDefault", "PD");
			else Log.Fail("Invalid");

			trialDate = DataBase.executeSelectQuery(testConfig, QUERY.PREMIUM_TRIAL_FOR_TIN, 1).get("PRTL_PRDCT_SELECT_EFF_DTTM").toString();

			Map selectionTable = DataBase.executeSelectQuery(testConfig, QUERY.PRODUCT_SELECTION_TIN_QUERY, 1);

			Helper.compareEquals(testConfig, "Effective date of inserted Standard record for Within Trial TIN", Helper.addDays(trialDate, 30).toString(), selectionTable.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().substring(0, 10));
			return this;
		}

}


