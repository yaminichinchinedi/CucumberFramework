package main.java.pageObjects;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import main.java.Utils.TestDataReader;
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
    @FindBy(linkText = "Logout")
    WebElement lnkLogout;
    @FindBy(linkText = "Home")
    WebElement lnkHome;
    @FindBy(xpath = "//div[@class='topMessaggeDiv']")
    WebElement pageHeader;
    @FindBy(xpath = "//div[@class='bottomMessageDiv']")
    WebElement pageFooter;
    @FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]")
    WebElement txtFeesInfoAO;
    @FindBy(linkText = "Cancel My Plan")
    WebElement lnkCancelSubscription;
    @FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]")
    WebElement txtActivationAdminName;
    @FindBy(xpath = "//div[@id='cancelationModal']//h2")
    WebElement duringTrialCancelPopUpHeading;
    @FindBy(xpath = "//div[@id='cancelationPostTrialModal']//h2") ////*[@id="cancelationModal"]/h2
    WebElement postTrialCancelPopUpHeading;
    @FindBy(xpath = "//div[2]/div[1]/button[1]/span[1]")
    WebElement btnCancelOnPopUp;
    @FindBy(xpath = "//*[@id='reason_selector']//option")
    List<WebElement> listTrialCancellationReason;
    @FindBy(id = "cancelationPostTrialModal")
    WebElement popUpCancellationPostTrial;
    @FindBy(xpath = "//div[@id='cancelationPostTrialModal']//p")
    WebElement postTrialCancelPopUpText;
    @FindBy(id = "cancelationModal")
    WebElement popUpCancellationTrial;
    @FindBy(id = "reason_selector")
    WebElement popUpCancellationReasonSelector;
    @FindBy(xpath = "//div[@id='cancelationModal']//p[1]")
    WebElement duringTrialCancelPopUpBody1;
    @FindBy(xpath = "//div[@id='cancelationModal']//p[2]")
    WebElement duringTrialCancelPopUpBody3;
    @FindBy(xpath = "//div[@id='cancelationModal']//ul//li")
    List<WebElement> duringTrialCancelPopUpBody2;
    @FindBy(xpath = "//html//button[2]")
    WebElement btnCancellationSubmitTrial;
    @FindBy(xpath = "//p[@id='errorswarning']")
    WebElement errorCancelWithoutReason;
    @FindBy(xpath = "//*[@id='reason_selector']//option[8]")
    WebElement otherOptionTrialCancellationReason;
    @FindBy(className = "wrapperTooltip")
    List<WebElement> tilesHeaderUI;
    @FindBy(xpath = "//*[@id=\"optum-pay-options\"]/div/div/div/div/div[2]")
    List<WebElement> tileContentUI;
    @FindBy(xpath = "//span[contains(text(),'Manage My Plan')]")
    WebElement manageMyPlanText;
    //@FindBy(id="openCancelationPostTrialPopup")
    @FindBy(linkText = "Cancel My Plan")
    WebElement lnkCancelPlanPostTrial;
    //@FindBy(id="openCancelationPopup")
    @FindBy(linkText = "Cancel My Plan")
    WebElement lnkCancelPlanDuringTrial;

    @FindBy(className = "wrapperTooltip")
    List<WebElement> titles;

    @FindBy(xpath = "//li[contains(text(),'Please enter a existing 9 digit TIN number.')]")
    WebElement nonExistingTINmsgOptumPaySol;

    @FindBy(xpath = "//li[contains(text(),'Please enter a valid 9 digit TIN number.')]")
    WebElement InValidTINmsgOptumPaySol;

    @FindBy(xpath = "//input[@name='taxIndNbr']")
    WebElement enterTIN;

    @FindBy(xpath = "//input[@name='btnSubmit']")
    WebElement searchBtn;
    @FindBy(linkText = "Change Rate")
    WebElement lnkChangeRate;
    @FindBy(xpath = "//*[@id=\"change_rate_reason_selector\"]/option[3]")
    WebElement optionReasonForRateChange;
    @FindBy(xpath = "//*[@id=\"optum-pay-options\"]/div[3]/div[2]/input[2]")
    WebElement btnSaveChangeRate;
    @FindBy(id = "confirmationModal")
    WebElement popUpChangeRate;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    WebElement btnChangeRatePopupCancel;
    @FindBy(xpath = "//button[contains(text(),'Change')]")
    WebElement btnChangeRatePopupChange;
    @FindBy(xpath = "//*[@id=\"optum-pay-options\"]/div[1]/div[1]/div[2]")
    WebElement tilePlanType;
    @FindBy(id = "logOutId")
    WebElement lnkLogOut;
    @FindBy(xpath = "//*[@id='ui-id-1']//div")
    WebElement hoverPlanType;
    @FindBy(xpath = "//*[@id='ui-id-2']//div")
    WebElement hoverRate;
    @FindBy(xpath = "//*[@id='ui-id-3']//div")
    WebElement hoverFees;
    @FindBy(xpath = "//*[@id='ui-id-4']//div")
    WebElement hoverManageMyPlan;

    @FindBy(id = "rate")
    WebElement rateTxtBox;

    @FindBy(id = "change_rate_reason_selector")
    WebElement rsnRtChngdrpdwn;

    @FindBy(id = "otherReasonForChange")
    WebElement otrRsnTxtAra;

    @FindBy(xpath = "//b[contains(text(),'Standard Per Payment fee:')]")
    private WebElement standardPerPaymentFee;

    @FindBy(xpath = "//b[contains(text(),'Custom Per Payment fee:')]")
    private WebElement customPerPaymentFee;

    @FindBy(xpath = "//b[contains(text(),'Standard Per Payment fee:')]/../..")
    private WebElement globalFee;

    @FindBy(xpath = "//b[contains(text(),'Custom Per Payment fee:')]/../..")
    private WebElement customFee;

    @FindBy(xpath = "//b[contains(text(),'Custom Per Payment fee:')]/../../../p[2]")
    private WebElement customFeeDate;

    @FindBy(xpath = "//span[contains(text(),'Rate')]/../..//div[contains(text(),'N/A')]")
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

    @FindBy(xpath = "//a[contains(text(),'Invoices') and @class='ui-tabs-anchor cursor-pointer']")
    WebElement invoicesTabOnOPS;

    @FindBy(xpath = "//div[@id='optum-pay-invoices']/div[1]/div[1]/p/span")
    WebElement providerNameInvoicesTab;

    @FindBy(xpath = "//div[@id='optum-pay-invoices']/div[1]/div[1]/p")
    WebElement providerNameValueInvoicesTab;

    @FindBy(xpath = "//div[@id='optum-pay-invoices']/div[1]/div[2]/p")
    WebElement accruedFeesInvoicesTab;

    @FindBy(xpath = "//div[@id='optum-pay-invoices']/div[1]/div[3]/p")
    WebElement pastDueFeesInvoicesTab;

    @FindBy(xpath = "//table[@class='table']/thead/tr/th")
    WebElement invoicePeriodTableGrid;

    @FindBy(xpath = " //*[@id='optum-pay-options']/div[1]/div[3]/div[2]")
    WebElement feeTile;

    @FindBy(xpath = "//div[@id='optum-pay-options']/div/div/div[3]/div/div[2]")
    WebElement feeTileUPA;

    @FindBy(xpath = "//div[@id='optum-pay-invoices']/div/div[2]/p")
    WebElement feeTileUPAInvc;

    @FindBy(linkText = "Invoices")
    WebElement lnkInvoice;

    @FindBy(xpath = "//div[@id=\"optum-pay-invoices\"]/div/div[1]/p")
    WebElement divPageMsg;

    @FindBy(id = "waiveButton")
    WebElement waiveFeeButton;

    @FindBy(id = "waiveFeeReason")
    WebElement waivedFeeReason;

    @FindBy(xpath = "//input[@id='waiveButton']/following-sibling::div")
    WebElement waivedFeePending;


    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[text()='Yes, continue']")
    WebElement confirmButton;

    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[2]/p")
    WebElement divInvoicesAccrudFeesUI;
    @FindBy(xpath = "//*[@id=\"optum-pay-invoices\"]/div/div[3]")
    WebElement divInvoicesPastDueFeesUI;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/p")
    WebElement msgNoInvoicesPresent;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/thead/tr/th")
    List<WebElement> tableInvoiceDetailTableHeader;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr")
    List<WebElement> tableInvoiceDetailUI;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[3]")
    List<WebElement> tableInvoiceAmountUI;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[1]")
    List<WebElement> tableInvoiceNumberUI;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[2]")
    List<WebElement> tableInvoiceDateUI;
    @FindBy(xpath = "//div[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[4]")
    List<WebElement> tableInvoicePayNowButtonUI;
    @FindBy(xpath = "//p[contains(text(),'Select an invoice to view billing details.')]")
    private WebElement invoice_grid_header;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[6]")
    List<WebElement> tableInvoiceConfirmationUI;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[5]")
    List<WebElement> tableInvoiceProcessedByUI;
    @FindBy(xpath = "//*[@id='optum-pay-invoices-tabs']/div[1]/p[1]")
    WebElement txtInvoicesPageText1;
    @FindBy(xpath = "//*[@id='optum-pay-invoices-tabs']/div[1]/p[2]")
    WebElement txtInvoicesPageText2;

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
    @FindBy(xpath = "//*[contains(text(),'Showing')]")
    WebElement divShowRslts;

    @FindBy(id = "feeTypeOption_selector")
    WebElement feeTyp;

    @FindBy(id = "feeStatusOption_selector")
    WebElement feeStatus;

    @FindBy(id = "feeRangeMin")
    WebElement feeRngMin;

    @FindBy(id = "feeRangeMax")
    WebElement feeRngMax;

    @FindBy(xpath = "//button[contains(text(),'Details')]")
    WebElement detailsTab;

    @FindBy(xpath = "//div[@id='feeSearchTable']/div[2]/div/table/tbody/tr")
    List<WebElement> noOfRows;

    @FindBy(xpath = "//button[contains(text(),'Clear')]")
    private WebElement clearButton;

    @FindBy(xpath = "//input[@name='showOnlyRefundables']")
    private WebElement refundFeeCheckbox;

    @FindBy(xpath = "//input[@id='refundFeeButton']")
    private WebElement refundFeeButton;

    @FindBy(xpath = "//input[@id='refundFeeCancelButton']")
    private WebElement refundFeeCancelButton;

    @FindBy(xpath = "//input[@value='Select All']")
    private WebElement selectAll;

    @FindBy(xpath = "//input[@name='refundFee'][1]")
    private WebElement refundSingleRow;

    @FindBy(xpath = "(//span[@class='wrapperTooltip'])[1]")
    WebElement planTypeTileInfoIconMsg;

    @FindBy(xpath = "(//span[@class='wrapperTooltip'])[2]")
    WebElement rateTileInfoIconMsg;

    @FindBy(xpath = "(//span[@class='wrapperTooltip'])[3]")
    WebElement feesTileInfoIconMsg;

    @FindBy(xpath = "(//span[@class='wrapperTooltip'])[4]")
    WebElement manageMyPlanTileInfoIconMsg;

    @FindBy(xpath = "//p[@class='errors mr-5 error__message']")
    WebElement errorMsgInvalid_NotAssociatedTIN_BS;

    @FindBy(xpath = "//td[@class='text-center']/a")
    List<WebElement> invoiceNumberList;

    @FindBy(className = "text-red")
    WebElement redTextError;

    @FindBy(xpath = "//div[@class='modal-body']/p")
    WebElement feeRefundPopUpText2;

    @FindBy(xpath = "//div[@id='refundConfirmation']/p")
    WebElement feeRefundPopUpText1;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement refundPopUpCancelButton;

    @FindBy(xpath = "//span[contains(text(),'Refund') and @class='ui-button-text']")
    WebElement refundPopUpRefundButton;

    @FindBy(xpath = "//select[@name='selectedRefundReason']")
    WebElement reasonDropDownrefundPopUp;

    @FindBy(xpath = "//button[contains(text(),'Get Started with Optum Pay Today')]")
    WebElement getStartedHeaderBtn;
    @FindBy(xpath = "//input[@value='Get Started']")
    WebElement getStartedBtn;
    @FindBy(xpath = "//form[@id='showOptumPayForm']//h2")
    List<WebElement> headerBsUser;

    @FindBy(linkText = "Cancel My Plan")
    WebElement cancelSubscriptionLinkCsr;
    @FindBy(id = "reason_selector")
    WebElement reasonSelectorDrpDwn;
    @FindBy(name = "otherReason")
    WebElement otherReasonTxtBox;
    @FindBy(id = "cancelRequestDate")
    WebElement cancelRequestDateTxtBox;
    @FindBy(name = "firstName")
    WebElement firstNameTxtBox;
    @FindBy(name = "lastName")
    WebElement lastNameTxtBox;
    @FindBy(name = "email")
    WebElement emailTxtBox;
    @FindBy(name = "phoneNumber1")
    WebElement phoneNumber1;
    @FindBy(name = "phoneNumber2")
    WebElement phoneNumber2;
    @FindBy(name = "phoneNumber3")
    WebElement phoneNumber3;
    @FindBy(xpath = "//div[@id='optum-pay-options']/div[5]/div[4]/input[2]")
    WebElement btnSave;
    @FindBy(xpath = "//button[contains(text(),'Change']")
    WebElement btnChange;
    @FindBy(className = "ui-button-text")
    List<WebElement> acceptPremiumBtn;

    @FindBy(id = "invoiceAchPaymentModal")
    WebElement popUpACHPaymentModal;
    @FindBy(xpath = "//input[@value='Pay Now']")
    WebElement payNow;

    @FindBy(xpath = "//p[contains(text(),'Process My Payment')]")
    WebElement processMyPayment;

    @FindBy(name = "invoicesAchPaymentForm.routingNumber")
    WebElement routingNumber;

    @FindBy(name = "invoicesAchPaymentForm.accountNumber")
    WebElement accountNumber;

    @FindBy(xpath = "//p[@class='error__message__text mt-0']")
    WebElement errorMsg;

    @FindBy(name = "invoicesAchPaymentForm.consent")
    WebElement optumPayDebitAuthCheckBox;

    @FindBy(xpath = "//button[@class='btn-primary submitAchPayment ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id='invoiceAchPaymentModal']/p")
    List<WebElement> pageTextModalACHpayment;

    @FindBy(xpath = "//*[@id='invoicesAchPaymentForm']/div[6]/div/div/p")
    List<WebElement> txtScrollableDivModalACHpayment;

    @FindBy(className = "closeMakePaymentModal")
    WebElement btnCancelModalACHpayment;

    @FindBy(className = "submitAchPayment")
    WebElement btnSubmitModalACHpayment;

    @FindBy(xpath = "//*[@id='invoicesAchPaymentForm']/div[5]/div/label/input")
    WebElement chkboxOptumFeeDebitAuth;

    @FindBy(xpath = "//*[@id='refund_reason_selector']/option")
    List<WebElement> drpdownAccountTypeSelector;

    @FindBy(xpath = "//*[@id='invoicesAchPaymentForm']/div[3]/div[1]")
    WebElement txtboxPaymentModalRoutingNumber;

    @FindBy(xpath = "//*[@id='invoicesAchPaymentForm']/div[3]/div[2]")
    WebElement txtboxPaymentModalAccountNumber;
    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[4]/input")
    WebElement paynowbtn;

    @FindBy(xpath = "//*[@id='invoicesAchPaymentForm']/div[3]/div[1]/input")
    WebElement routingNum;

    @FindBy(xpath = "//*[@id='invoicesAchPaymentForm']/div[3]/div[2]/input")
    WebElement accntNum;

    @FindBy(name = "invoicesAchPaymentForm.consent")
    WebElement accepcheck;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subBtn;

    @FindBy(xpath = "//p[text()='Thank You']")
    WebElement Thnkyou;
    @FindBy(xpath = "//p[text()='Confirmation Number: ']")
    WebElement confirmNumber;
    @FindBy(xpath = "//p[text()='Amount Paid: ']")
    WebElement amtPaid;
    @FindBy(xpath = "//button[@class='btn-secondary closeMakePaymentModal ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-primary closeAndRefresh']")
    WebElement closeBtn;
    @FindBy(xpath = "//*[@id='invoiceAchPaymentModal']/p[2]")
    WebElement paragraphTxt;

    @FindBy(xpath = "//input[@class='btn btn-secondary mb-0']")
    WebElement paidBtn;

    @FindBy(xpath = "//*[@id='optum-pay-invoices']/div/div[4]/div/table/tbody/tr/td[3]")
    WebElement amountDue;

    @FindBy(xpath = "//div[@id='invoiceAchPaymentModal']/p[3]/strong")
    WebElement confNbr;

    @FindBy(xpath = "//*[@id=\"optum-pay-options\"]/div[1]/div[3]/div[2]/div[1]/text()")
    WebElement accrd_sum;

    @FindBy(id = "waiveButton")
    WebElement wavieBtn;


    @FindBy(xpath = "//input[@name='waiveFeesForm.waiveType']")
    WebElement preselRadioBtn;


    @FindBy(xpath = "//input[@name='waiveFeesForm.waiveType' and @class = 'partialWaive']")
    WebElement partialRadioBtn;


    @FindBy(xpath = "//body[1]/div[7]/div[2]/form[1]/div[3]/div[1]/span[1]")
    WebElement totAmtWavie;


    @FindBy(xpath = "//input[@name='waiveFeesForm.waiveType' and @class = 'partialWaive']")
    WebElement asteriskchk;

    @FindBy(xpath = "//body/div[7]/div[2]/form[1]/div[6]/div[1]/span[1]")
    WebElement asttext;


    @FindBy(id = "feeTypeOption_selector")
    WebElement reasondrpdwn;


    @FindBy(xpath = "//*[@id='waiveFeesForm']/div[5]/div/p")
    WebElement txtModalWaiveFee;


    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    WebElement wavieCancelBtn;


    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement wavieContBtn;

    @FindBy(xpath = "//button[contains(text(),'Yes, continue')]")
    WebElement wavieyesBtn;


    @FindBy(xpath = "//div[contains(text(),'Waived fees pending')]")
    WebElement waviefeependng;

    @FindBy(xpath = "//div[@class='mt-2 font-grey-italic' and contains(.,'Waived fees pending')]")
    WebElement waiveFeesInProgressMessage;


    @FindBy(xpath = "//select[@id='waiveFeeReason']")
    WebElement waiveFeeReasonDropdown;


  
  	@FindBy(xpath = "//*[contains(text(),'Select option to waive fees')]")
  	WebElement SelectOptionWaiveFeesPage;
  	
  	@FindBy(xpath = "//label[@id='reasonText-error' and contains(text(),'This field is required.')]")
  	WebElement ThisIsRequiredFieldErrorMessage;

  	
  	@FindBy(xpath = "//label[@id='reasonText-error' and contains(text(),'Maximum character limit is 150')]")
  	WebElement MaximumCharacterLimitIs150ErrorMessage;

  
  	@FindBy(xpath = "//textarea[@id='reasonText']")
  	WebElement SelectOptionreasonText;

  
  	@FindBy(xpath = "//input[@id='partialAmount']")
  	WebElement EnterPartialAmountText;

  
  	@FindBy(xpath = "//input[@id='partialAmount']/following-sibling::label")
  	WebElement PartialAmountErrorMessage;

 
  	@FindBy(xpath = "//span[contains(text(),'Total amount:')]//ancestor::span[2]")
  	WebElement TotalAmountText;
  	
    //Added by Mohammad Khalid
    String headerTop1_Premium = "Important reminder:";
    String headerTop2_Premium = "Is your provider organization tax exempt?";
    String pageTextTop1_Premium = "You will receive an email notification when the monthly invoice is ready";

    //String pageTextTop1_Premium = "You will receive an email notification when the monthly invoice is ready. Fees are debited within 5 days and are deducted from the provider's TIN-level banking account. If you haven't already, please contact the financial institution and ask that the following ACH company ID and name be added to your bank account: Company ID: 1243848776 and Company Name: Optum Pay. Not adding Optum Pay as an authorized agent may result in ACH return fees and/or termination of service.";
    String pageTextTop2_Premium = "Send the tax exempt certificate to optumpay_taxexempt@optum.com to ensure correct billing.";

    //String footer1_Premium = "If a provider cancels the full functionality of Optum Pay several features will be lost, including access to pdf remittance files, the ability to search historical data and unlimited user access (user access exceptions may apply, visit the FAQs for details).";
    String footer1_Premium = "If a provider cancels the full functionality of Optum Pay premium several features will be lost, including the ability to search historical data, bundle payment files and access to workflow management tools.";
    String footer2_Premium = "Click here for frequently asked questions.";
    //String footer2_Premium = "Cancellation may take up to 7 days to process during which time the provider will be responsible for any charges to their account.";

    String Message1_Standard = "Optum Pay brings more power to your practice";
    String Message2_Standard = "We are improving our service to help simplify your workflow and take efficiency to the next level. For a low fee*, we now offer additional tools and resources to give you more of what you're looking for.";

    private TestBase testConfig;

    Map<String, String> optumPaySolndata = new HashMap<String, String>();

    public OptumPaySolution(TestBase testConfig) {
        this.testConfig = testConfig;
        PageFactory.initElements(testConfig.driver, this);
        if (testConfig.getRunTimeProperty("App").equalsIgnoreCase("UPA"))
            Element.fluentWait(testConfig, Element.findElement(testConfig, "xpath", "//*[@name='taxIndNbr']"), 60, 1, "Tin Selector");
    }

    public void verifyHeaders() {
        Helper.compareEquals(testConfig, "1st Tile Header", "Provider Name", txtProvNameHeader.getText().trim());
        Helper.compareEquals(testConfig, "2nd Tile Header", "Plan Type", txtPlanTypeHeader.getText().trim());
        Helper.compareEquals(testConfig, "3rd Tile Header", "Fees", txtFeesHeader.getText().trim());
        Helper.compareEquals(testConfig, "4th Tile Header", "Manage Subscriptions", txtManageSubHeader.getText().trim());
    }

    public void verifySolutionsTabForStandard(String trialStatus, String portalAccess) {
        Helper.compareEquals(testConfig, "Optum Pay brings more power to your practice text on Standard view", "Optum Pay brings more power to your practice", txtOnStandardPage.getText().trim());
        Element.verifyElementPresent(video, "Video");
        Element.click(testConfig, lnkHome, "Home", 3);
        Element.click(testConfig, lnkLogout, "Logout", 3);
    }

    public void verifySolutionsTabForPremium(String trialStatus, String portalAccess) throws Exception {
        if (trialStatus.equalsIgnoreCase("A")) {
            Browser.browserRefresh(testConfig);
            Browser.waitForPageLoad(testConfig.driver);
            verifyHeaders();
            planTypeInfoForPremium();
            Helper.compareEquals(testConfig, "During Trial Cancel pop-up", "You are about to lose important functionality through Optum Pay.", duringTrialCancelPopUpHeading.getText().trim());
            Element.click(btnCancelOnPopUp, "Close pop-up 'X' button");
            Element.verifyElementPresent(pageHeader, "Page Text");
            Element.click(testConfig, lnkHome, "Home", 3);
            Element.click(testConfig, lnkLogout, "Logout", 3);
        } else if (trialStatus.equalsIgnoreCase("I")) {
            verifyHeaders();
            planTypeInfoForPremium();
            Helper.compareEquals(testConfig, "Post Trial Cancel pop-up", "Call to cancel", postTrialCancelPopUpHeading.getText().trim());
            Element.click(btnCancelOnPopUp, "Close pop-up 'X' button");
            Element.verifyElementPresent(pageHeader, "Page Text");
        }
    }

    public void planTypeInfoForPremium() throws Exception {
        String planTypeInfo = Element.findElement(testConfig, "xpath", "//div[@id=\"optum-pay-options\"]//div//div[2]//div[2]").getText();
        Element.verifyElementPresent(pageHeader, "Page Text");
        int sqlRowNo = 1;
        testConfig.getRunTimeProperty("tin");
        Map data = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
        Helper.compareEquals(testConfig, "Organization Name on 1st tile DB and UI", data.get("ORG_NM").toString().trim(), txtProvNameInfo.getText().trim());
        Helper.compareEquals(testConfig, "2nd Tile text- Optum Pay", "Optum Pay", planTypeInfo.substring(0, 9).trim());
        Helper.compareEquals(testConfig, "2nd Tile text- Activation Admin", "Activation Admin:", planTypeInfo.substring(10, 28).trim());
        Helper.compareEquals(testConfig, "2nd Tile text- Activation Date", "Activation Date:", planTypeInfo.substring(37, 53).trim());
        sqlRowNo = 1344;
        testConfig.getRunTimeProperty("statusOfStandardRecd");
        testConfig.getRunTimeProperty("SelectedOrDefault");
        data = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
        String activationDate = data.get("PRTL_PRDCT_SELECT_DTTM").toString().trim().substring(0, 10).trim();
        activationDate = Helper.changeDateFormat(activationDate, "yyyy-mm-dd", "mm/dd/yyyy");
        Helper.compareEquals(testConfig, "2nd Tile Info- Activation Date", activationDate, planTypeInfo.substring(54, 64).trim());
        Helper.compareEquals(testConfig, "Fees on 3rd tile", "0.5% of Payment", txtFeesInfoAO.getText().trim());
        Helper.compareEquals(testConfig, "Fees on 4th tile", "Free Trial End Date:", txtManageSubInfo.getText().trim());
        sqlRowNo = 1341;
        data = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
        String trialEndDateDB = data.get("PROC_DATA").toString().trim();
        trialEndDateDB = Helper.changeDateFormat(trialEndDateDB, "yyyy-mm-dd", "mm/dd/yyyy").trim();
        String trialEndDateUI = Element.findElement(testConfig, "xpath", "//div[@id=\"optum-pay-options\"]//div[4]//div[2]").getText().trim();
        System.out.println(trialEndDateUI.substring(21, 31));
        Helper.compareEquals(testConfig, "Fees on 4th tile Info", trialEndDateDB, trialEndDateUI.substring(21, 31).trim());
        Element.click(lnkCancelSubscription, "Cancel My Subscription Link");
    }

    public void verifyCancellationPopUp(String trialStatus) throws IOException {
        testConfig.putRunTimeProperty("pay_proc_cd", "55");
        int sqlRowNo = 1111, i = 1, j = 0;
        HashMap<Integer, HashMap<String, String>> cancelReasonDB = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        ArrayList<String> cancelReasonList = new ArrayList<String>() {{
            add("Not using the portal as much as I thought I would");
            add("I receive my data from a clearinghouse");
            add("I don't need the search tools");
            add("I don't need historical claim data");
            add("I don't need additional users, 2 is sufficient");
            add("The service is too costly for my practice");
            add("Other");
        }};
        ArrayList<String> popUpTextList = new ArrayList<String>() {{
            add("Workflow management tools and claim count information");
            add("The ability to search claims");
            add("36 months of claims and remittance history maintained for easy access");
        }};

        Element.click(lnkCancelPlanDuringTrial, "Cancel My Subscription Link");

        Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text", "You are about to lose important functionality through Optum Pay.", duringTrialCancelPopUpHeading.getText().toString());
        Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text", "By cancelling your Optum Pay access, you will be losing features that many providers consider vital to their practice, including:", duringTrialCancelPopUpBody1.getText().toString());
        for (WebElement cancelPopUptext : duringTrialCancelPopUpBody2) {
            Helper.compareEquals(testConfig, "Pop Up Text List", popUpTextList.get(j).toString(), cancelPopUptext.getText().toString());
            j++;
        }
        Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text", "Upon cancellation of Optum Pay, you will continue to receive ACH payments and maintain limited portal access.", duringTrialCancelPopUpBody3.getText().toString());
        Element.click(btnCancellationSubmitTrial, "click on yes i want to cancel");
        Element.verifyElementPresent(errorCancelWithoutReason, "Error thrown when reason is not selected");
        Helper.compareEquals(testConfig, "Error thrown when reason is not selected", "Please enter Reason for Termination.", errorCancelWithoutReason.getText().toString());
        for (WebElement cancelReasonUI : listTrialCancellationReason) {
            if (cancelReasonUI.getText().toString().equalsIgnoreCase("Select One"))
                continue;
            else {
                Helper.compareEquals(testConfig, "cancel List", cancelReasonDB.get(i).get("PAY_PROC_ACPT_CD_VAL_DESC").toString(), cancelReasonUI.getText().toString());
                Helper.compareEquals(testConfig, "cancel List", cancelReasonList.get(i - 1).toString(), cancelReasonUI.getText().toString());
                i++;
            }
        }
        Element.click(otherOptionTrialCancellationReason, "Selecting Other as the Reason");
        Element.click(btnCancellationSubmitTrial, "click on yes i want to cancel");
        Element.verifyElementPresent(errorCancelWithoutReason, "Error thrown when reason is not selected");
        Helper.compareEquals(testConfig, "Error thrown when other reason is not given", "Please enter Other reason for termination.", errorCancelWithoutReason.getText().toString());


    }

    public OptumPaySolution validateManageMyPlanText() {
        Element.verifyTextPresent(manageMyPlanText, "Manage My Plan");
        return this;
    }

    public void validateCancelMyPlanTextLink() {
        Element.verifyTextPresent(lnkCancelSubscription, "Cancel My Plan");
    }

    public void validateFreeTrialTextNotPresent(String text) {
        Element.verifyTextNotPresent(text);
    }

    public void verifyOPSTilesForVO() {
        ArrayList<String> expectedContent = new ArrayList<String>();
        expectedContent.add("Plan Type");
        expectedContent.add("Rate");
        expectedContent.add("Fees");
        expectedContent.add("Manage My Plan");

        ArrayList<String> actualContentUI = new ArrayList<String>();
        for (WebElement tiles : tilesHeaderUI) {
            actualContentUI.add(tiles.getText());
        }
        Helper.compareEquals(testConfig, "Title comparision", expectedContent, actualContentUI);

        expectedContent.clear();
        expectedContent.add("VCP Only");
        expectedContent.add("N/A");
        expectedContent.add("N/A");
        expectedContent.add("N/A");

        actualContentUI.clear();
        for (WebElement tiles : tileContentUI) {
            actualContentUI.add(tiles.getText().trim());
        }
        Helper.compareEquals(testConfig, "Tile Content comparision", expectedContent, actualContentUI);
    }


    public OptumPaySolution validateTitleNames() {

        ArrayList<String> expectdtitles = new ArrayList<String>();
        expectdtitles.add("Plan Type");
        expectdtitles.add("Rate");
        expectdtitles.add("Fees");
        expectdtitles.add("Manage My Plan");

        ArrayList<String> UItitles = new ArrayList<String>();
        for (WebElement title : titles) {
            UItitles.add(title.getText());
        }
        Helper.compareEquals(testConfig, "Title comparision", expectdtitles, UItitles);
        return this;
    }


    public OptumPaySolution validateFeeTitle() {
        validatePastdueFee().validateAccruedFeesMonth();
        return this;
    }


    public OptumPaySolution verifyInvalidTINonOptumPaySolution(String invalidTIN) throws Exception {
        Element.expectedWait(enterTIN, testConfig, "TIN field", "TIN Field");
        Element.enterDataByJS(testConfig, enterTIN, invalidTIN, "TIN entered as : " + invalidTIN);
        Element.clickByJS(testConfig, searchBtn, "Search Button");
        Browser.wait(testConfig, 4);
        boolean isInteger;
        try {
            int x = Integer.parseInt(invalidTIN);
            isInteger = true;
        } catch (NumberFormatException nFE) {
            isInteger = false;
        }

        if (isInteger && invalidTIN.length() == 9) {
            String ErrorMsgText = nonExistingTINmsgOptumPaySol.getText();
            Helper.compareEquals(testConfig, "Non-Existing TIN error msg", "Please enter a existing 9 digit TIN number.", ErrorMsgText);
        } else {
            String ErrorMsgText = InValidTINmsgOptumPaySol.getText();
            Helper.compareEquals(testConfig, "InValid TIN error msg", "Please enter a valid 9 digit TIN number.", ErrorMsgText);
        }
        return this;

    }

    public void validatePlanTypeTile() throws ParseException {
        int sqlRowNo = 1509;
        testConfig.getRunTimeProperty("tin");
        Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);

        if (portalUserData.get("PRTL_PRDCT_SELECT_DTTM").toString().length() > 0) {//String activationDate= portalUserData.get("PRTL_PRDCT_SELECT_DTTM").toString().trim().substring(0, 10).trim();
            String activationDate = portalUserData.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().trim().substring(0, 10).trim();
            activationDate = Helper.changeDateFormat(activationDate, "yyyy-mm-dd", "mm/dd/yyyy");
            Helper.compareContains(testConfig, "Plan Type Tile text- Activation Date", activationDate, tilePlanType.getText().trim());
        }
        Helper.compareContains(testConfig, "Plan Type Tile text- Optum Pay", "Optum Pay", tilePlanType.getText().trim());
        Helper.compareContains(testConfig, "Plan Type Tile text- Billing Cycle", "Billing Cycle: Monthly", tilePlanType.getText().trim());
        Helper.compareContains(testConfig, "Plan Type Tile text- Activation Admin", "Activation Admin:", tilePlanType.getText().trim());
        Helper.compareContains(testConfig, "Plan Type Tile text- Activation Date", "Activation Date:", tilePlanType.getText().trim());
        Helper.compareContains(testConfig, "Plan Type Tile text- Activation name", portalUserData.get("PRTL_PRDCT_SELECT_USER_FULLNAME").toString().trim(), tilePlanType.getText().trim());

        Element.clickByJS(testConfig, lnkLogOut, "logging Out of the portal");
    }

    public void validateChangeRatePopup(String credentials) {

        if (credentials.equalsIgnoreCase("Super") && testConfig.getRunTimeProperty("prdctSelected").equalsIgnoreCase("Premium")) {
            Element.clickByJS(testConfig, lnkChangeRate, "Change Rate link");
            Element.clickByJS(testConfig, optionReasonForRateChange, "Rate Change Reason");
            Element.clickByJS(testConfig, btnSaveChangeRate, "Save Rate Change");
            System.out.println(popUpChangeRate.getText());
            Helper.compareContains(testConfig, "PopUp text", "Are you sure?", popUpChangeRate.getText().trim());
            Helper.compareContains(testConfig, "PopUp text", "If you proceed with this rate change the new per payment rate for this", popUpChangeRate.getText().trim());
            Helper.compareContains(testConfig, "PopUp text", "TIN will be effective starting the next business day", popUpChangeRate.getText().trim());

            Element.verifyElementPresent(btnChangeRatePopupChange, "change btn");
            Element.verifyElementPresent(btnChangeRatePopupCancel, "cancel btn");
            Element.clickByJS(testConfig, btnChangeRatePopupCancel, "cancel btn");
        } else
            Element.verifyElementNotPresent(lnkChangeRate, "Change Rate link");

        Element.clickByJS(testConfig, lnkLogOut, "logging Out of the portal");
    }

    public void validateChangeRatePrcnt(String credentials, String changeRateValue, String changeRateReason) {

        String rateValue = "";
        int sqlRowNo = 1627;
        Map rate = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);

        BigDecimal globalVal = BigDecimal.valueOf(Double.parseDouble(rate.get("RATE_PCT").toString().trim())).multiply(new BigDecimal(100));
        if (changeRateValue.equals("Invalid value")) {
            rateValue = globalVal.add(new BigDecimal("0.001")).toString();
            validateChangeRateEvents(credentials, rateValue, changeRateValue, changeRateReason);
            rateValue = "-" + Helper.generateRandomDecimalValue(0, 1, 3);
            validateChangeRateEvents(credentials, rateValue, changeRateValue, changeRateReason);
        }
        if (changeRateValue.equals("valid value")) {
            rateValue = globalVal.add(new BigDecimal("-0.001")).toString();
            validateChangeRateEvents(credentials, rateValue, changeRateValue, changeRateReason);
            Browser.wait(testConfig, 1);
            validateChangeRateEvents(credentials, rateValue, changeRateValue, "Other with Blank");
        }
    }

    public void validateChangeRateEvents(String credentials, String rateValue, String changeRateValue, String changeRateReason) {

        if (credentials.equalsIgnoreCase("Super") &&
                testConfig.getRunTimeProperty("prdctSelected").equalsIgnoreCase("Premium") &&
                testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO") || testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AV")) {
            //if( (changeRateValue.equals("valid value") && changeRateReason.equalsIgnoreCase("Other"))|| (changeRateValue.equals("Invalid value") && (!rateValue.contains("-"))))
            if ((changeRateValue.equals("valid value") && changeRateReason.contains("Other")) || (changeRateValue.equals("Invalid value") && (!rateValue.contains("-"))))
                Element.clickByJS(testConfig, lnkChangeRate, "Change Rate link");
            Element.clearData(rateTxtBox, "change rate");
            Element.enterDataByJS(testConfig, rateTxtBox, rateValue, "change rate");

            if (changeRateReason.equalsIgnoreCase("Other with Blank"))
                Element.selectByVisibleText(rsnRtChngdrpdwn, "Other", "reason for change dropdown");
            else
                Element.selectByVisibleText(rsnRtChngdrpdwn, changeRateReason, "reason for change dropdown");

            if (changeRateReason.equalsIgnoreCase("Other"))
                Element.enterDataByJS(testConfig, otrRsnTxtAra, "Testing", "Other Change rate");
            if (changeRateReason.equalsIgnoreCase("Other with Blank"))
                Element.enterDataByJS(testConfig, otrRsnTxtAra, "", "Other Change rate");

            Browser.wait(testConfig, 1);
            Element.clickByJS(testConfig, btnSaveChangeRate, "Save Rate Change");

            Helper.compareContains(testConfig, "PopUp text", "Are you sure?", popUpChangeRate.getText().trim());
            Helper.compareContains(testConfig, "PopUp text", "If you proceed with this rate change the new per payment rate for this\n" +
                    "TIN will be effective starting the next business day", popUpChangeRate.getText().trim());
            //Helper.compareContains(testConfig, "PopUp text", "TIN will be effective starting the next business day" ,popUpChangeRate.getText().trim());

            Element.clickByJS(testConfig, btnChangeRatePopupChange, "Change btn click");

            if (changeRateValue.equals("Invalid value") || changeRateReason.equalsIgnoreCase("Other with Blank")) {
                Browser.wait(testConfig, 2);
                String actual = Element.findElement(testConfig, "xpath", "//*[@id=\"optum-pay-tabs\"]/div[1]/ul/li").getText(); //rate_input--error_message
                //String actual= Element.findElement(testConfig, "class", "rate_input--error_message").getText();
                if (changeRateValue.equals("Invalid value"))
                    Helper.compareContains(testConfig, "Error Validation", "The rate must be greater than or equal to 0 and less than the system global rate", actual);
                if (changeRateReason.equalsIgnoreCase("Other with Blank"))
                    Helper.compareContains(testConfig, "Error Validation", "Enter a reason for the rate change", actual);
            }
        } else
            Element.verifyElementNotPresent(lnkChangeRate, "Change Rate link");

    }

    public void validateInfoIconHover() {
        for (WebElement title : titles)
            Element.mouseHoverByJS(testConfig, title, "title");

        Helper.compareEquals(testConfig, "Plan Type", "Providers will be billed monthly for any fees incurred the previous month. For example, fees accrued during the month of June will be invoiced by mid�July. Provider administrators will receive an email along with payment instructions and they can review the fees on the Invoices subtab.", hoverPlanType.getText().trim());
        Helper.compareEquals(testConfig, "Fees", "Per payment fees are calculated based on the total payment amount and will not exceed $2,000 per billing period for each organizational tax identification number (TIN). Any rate changes will be effective the following business day.", hoverRate.getText().trim());
        Helper.compareEquals(testConfig, "Rate", "To view individual per-\n" +
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
        Helper.compareEquals(testConfig, "Manage my Plan", "To cancel the paid subscription, Provider administrators can either click on the \"Cancel my Plan\" button on the Solutions tab or complete the Cancellation Fee Form found in the Resources link and email it to optumpay_cancel@optum.com.", hoverManageMyPlan.getText().trim());
    }


    public void rateTileCSRFeeAndDateVerification(String tinType, String portalAccess) {

        if (tinType.equals("VO") || portalAccess.equals("Standard")) {
            String naMessage1 = validateNA.getText().trim();
            String naMessage = naMessage1.substring(0, 3);
            Helper.compareContains(testConfig, "Validating N/A is present for VO or Standard Tins", "N/A", naMessage);
            return;
        }
        //For Database
        String currDateDB = Helper.getCurrentDate("YYYY-MM-dd");
        String getCurrentMonthDB = currDateDB.substring(5, 7);
        String getCurrentYearDB = currDateDB.substring(0, 4);
        String futureDateInSameMonthDB = getCurrentYearDB + "-" + getCurrentMonthDB + "-" + "20"; //20 or it can be any future date in same month
        String pastDateDB = Helper.getDateBeforeOrAfterDays(-31, "YYYY-MM-dd");
        String tomorrowsDateDB = Helper.getDateBeforeOrAfterDays(1, "YYYY-MM-dd");
        String currMonthsFirstDateDB = getCurrentYearDB + "-" + getCurrentMonthDB + "-" + "01";
        String currMonthsSecondDateDB = getCurrentYearDB + "-" + getCurrentMonthDB + "-" + "02";

        //For UI
        String currDate = Helper.getCurrentDate("MM/dd");
        String getCurrentMonth = currDate.substring(0, 2);
        String currDay = currDate.substring(currDate.length() - 2);
        String futureDateInSameMonth = getCurrentMonth + "/20";
        String currMonthsFirstDate = getCurrentMonth + "/01";
        String currMonthsSecondDate = getCurrentMonth + "/02";
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
        if (currDay.equals("01")) {
            validatingCustomFeeInUI();
        } else {
            validatingGlobalFeeInUI();
            validatingCustomFeeInUI();
            Helper.compareContains(testConfig, "Validating whether the custom Fee is displayed properly in the Rate Tile UI", validatingCustomFeeDate(), currMonthsFirstDate + " - " + currMonthsFirstDate);
        }

        //Update Tin Level date from (2nd of current month - 20th of current month)
        //Scenario 4 - Displaying both custom and global fee
        DataBase.executeUpdateQuery(testConfig, 2004);
        Browser.browserRefresh(testConfig);
        if (currDay.equals("01")) {
            validatingGlobalFeeInUI();
        } else {
            validatingGlobalFeeInUI();
            validatingCustomFeeInUI();
            Helper.compareContains(testConfig, "Validating whether the custom Fee is displayed properly in the Rate Tile UI", validatingCustomFeeDate(), currMonthsSecondDate + " - " + futureDateInSameMonth);
        }

        //Update Tin Level date from (2nd of current month - NULL)
        //Scenario 5 - Displaying both custom and global fee
        DataBase.executeUpdateQuery(testConfig, 2005);
        Browser.browserRefresh(testConfig);
        if (currDay.equals("01")) {
            validatingGlobalFeeInUI();
        } else {
            validatingGlobalFeeInUI();
            validatingCustomFeeInUI();
            Helper.compareContains(testConfig, "Validating whether the custom Fee is displayed properly in the Rate Tile UI", validatingCustomFeeDate(), currMonthsSecondDate + " - " + lastDateOfCurrentMonth);
        }

        //Deleting the entry which we created for our tin in Debit_Fee_Rate table
        DataBase.executeDeleteQuery(testConfig, 2007);
        Log.Comment("Entry was deleted from Rate Fee table");
    }

    public void validateStandardPerPaymentFeeText() {
        Element.verifyTextPresent(standardPerPaymentFee, "Standard Per Payment fee:");
    }

    public void validateCustomPerPaymentFeeText() {
        Element.verifyTextPresent(customPerPaymentFee, "Custom Per Payment fee:");
    }

    public void validatingGlobalFeeInUI() {

        String globalFeeFromDB = null;
        String globalFeeFromUI = null;

        if (globalFeeFromDB == null && globalFeeFromUI == null) {
            Map<String, String> globalFeeFromDatabase = DataBase.executeSelectQuery(testConfig, 2001, 1);
            globalFeeFromDB = globalFeeFromDatabase.get("RATE_PCT");

            //If last two digits for global fee is 0 in database, then we display only one digit after decimal point in UI
            if (globalFeeFromDB.charAt(globalFeeFromDB.length() - 1) == '0' && globalFeeFromDB.charAt(globalFeeFromDB.length() - 2) == '0') {
                DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.0");
                globalFeeFromUI = decimalFormat.format(Float.parseFloat(globalFeeFromDB) * 100);
            }

            //If last one digit for global fee is 0 in database, then we display only two digits after decimal point in UI
            else if (globalFeeFromDB.charAt(globalFeeFromDB.length() - 1) == '0') {
                DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.00");
                globalFeeFromUI = decimalFormat.format(Float.parseFloat(globalFeeFromDB) * 100);
            }

            //If last digit for global fee is non zero in database, then we display three digits after decimal point in UI
            else {
                DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.000");
                globalFeeFromUI = decimalFormat.format(Float.parseFloat(globalFeeFromDB) * 100);
            }
        }

        String split[] = globalFee.getText().trim().split(": ");
        String stdFee = split[split.length - 1].trim();

        Helper.compareContains(testConfig, "Validating whether the Global Fee is displayed properly in the Rate Tile UI", stdFee, globalFeeFromUI + "%");
        validateStandardPerPaymentFeeText();
    }

    public void validatingCustomFeeInUI() {
        String customFeeFromDB = null;
        String customFeeFromUI = null;

        //Fetch the Custom Fee from database, and display three digits after decimal point in UI
        if (customFeeFromDB == null && customFeeFromUI == null) {
            Map<String, String> customFeeFromDatabase = DataBase.executeSelectQuery(testConfig, 2006, 1);
            customFeeFromDB = customFeeFromDatabase.get("RATE_PCT");

            DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.000");
            customFeeFromUI = decimalFormat.format(Float.parseFloat(customFeeFromDB) * 100);
        }

        String split[] = customFee.getText().trim().split(": ");
        String custFee = split[split.length - 1].trim();

        Helper.compareContains(testConfig, "Validating whether the custom Fee is displayed properly in the Rate Tile UI", custFee, customFeeFromUI + "%");
        validateCustomPerPaymentFeeText();
    }

    public String validatingCustomFeeDate() {
        return customFeeDate.getText().trim();
    }

    public void updatingStartDateOfGlobalLevelFee() {
        DataBase.executeUpdateQuery(testConfig, 2008);
    }

    //Added by Mohammad Khalid
    public void verifyPageText_Top_Premium() {
        Helper.compareEquals(testConfig, "Header-1 Premium", headerTop1_Premium, topHeader1_ImpRem_Premium.getText().trim());
        Helper.compareEquals(testConfig, "Header-2 Premium", headerTop2_Premium, topHeader2_IsYourProv_Premium.getText().trim());
        Helper.compareContains(testConfig, "Top Page Text -1 Premium", pageTextTop1_Premium, topMsg1_YouWill_Premium.getText().trim());
        Helper.compareContains(testConfig, "Top Page Text -2 Premium", pageTextTop2_Premium, topMsg2_SendTax_Premium.getText().trim());
    }

    public void verifyPageText_Footer_Premium() {
        Helper.compareEquals(testConfig, "Footer-1 Premium", footer1_Premium, footer1_IfaProv_Premium.getText().trim());
        Helper.compareEquals(testConfig, "Footer-2 Premium", footer2_Premium, footer2_Cancellation_Premium.getText().trim());
    }


    public void verifyPageText_Message1_Standard() {
        Helper.compareEquals(testConfig, "Message 1 Standard", Message1_Standard, msg1_Standard.getText().trim());
    }

    public void verifyPageText_Message2_Standard() {
        Helper.compareEquals(testConfig, "Message 2 Standard", Message2_Standard, msg2_Standard.getText().trim());
    }


    public void clickOnInvoicesTab() {
        Element.click(invoicesTabOnOPS, "Invoices tab on OPS page");
    }

    public OptumPaySolution verifyInvoiceTabHeader() {
        Helper.compareEquals(testConfig, "Invoice Tab Header", TestBase.contentMessages.getProperty("provBS.admin.premium.ao.optumPaySolution.invoiceTab.header").trim(), pageHeader.getText().trim());
        return this;
    }

    public OptumPaySolution verifyProviderName() throws IOException, SQLException {
        String expectedProviderName = null;
        testConfig.putRunTimeProperty("Prov_tin_nbr", testConfig.getRunTimeProperty("tin"));
        Map<String, String> results = DataBase.executeSelectQuery(testConfig, 236, 1);
        expectedProviderName = (String) results.get("ORG_NM");
        String actualProviderName = providerNameValueInvoicesTab.getText().substring(9, providerNameValueInvoicesTab.getText().length());
        Helper.compareEquals(testConfig, "Provider Name", expectedProviderName, actualProviderName.trim());
        return this;
    }

    public OptumPaySolution verifyAccruedFees() {
        String actualAccruedFeesTitle = accruedFeesInvoicesTab.getText().substring(0, 27);
        String actualAccruedFees = accruedFeesInvoicesTab.getText().substring(29, accruedFeesInvoicesTab.getText().length());
        String expectedAccruedFees = null;
        testConfig.putRunTimeProperty("tin", testConfig.getRunTimeProperty("tin"));
        Map<String, String> data = DataBase.executeSelectQuery(testConfig, QUERY.TOTAL_ACCRUED_FEES, 1);
        if (data.get("ACCRDFEE").toString().isEmpty())
            expectedAccruedFees = "0.00";
        else
            expectedAccruedFees = data.get("ACCRDFEE").toString();

        Helper.compareContains(testConfig, "accrued Fees Title", "Accrued fees month to date:", actualAccruedFeesTitle.trim());
        Helper.compareEquals(testConfig, "Accrued Fees", expectedAccruedFees, actualAccruedFees.trim().replace(",", ""));
        return this;
    }

    public OptumPaySolution verifyPastDueFees() throws IOException, SQLException {
        String expectedPastDueFees = null;
        testConfig.putRunTimeProperty("tin", testConfig.getRunTimeProperty("tin"));
        Map<String, String> data = DataBase.executeSelectQuery(testConfig, 1630, 1);

        if (data.get("PASTDUEFEE").toString().isEmpty())
            expectedPastDueFees = "0.00";
        else
            expectedPastDueFees = data.get("PASTDUEFEE").toString();

        String actualPastDueFees = pastDueFeesInvoicesTab.getText().substring(16, pastDueFeesInvoicesTab.getText().length());
        Helper.compareEquals(testConfig, "Past Due Fees", expectedPastDueFees, actualPastDueFees.trim());
        return this;
    }

    public OptumPaySolution verifyInvoicePeriodGrid() throws IOException, SQLException, ParseException {
        List<WebElement> tableHeads = Element.findElements(testConfig, "xpath", "//table[@class='table']/thead/tr/th");
        List<String> expectedTableHeads = new ArrayList<>();
        expectedTableHeads.add(0, "Invoice Period");
        expectedTableHeads.add(1, "Total Invoice Amount");
        expectedTableHeads.add(2, "Download Invoice");

        String downloadInvoiceNumber = null;
        List<String> billingStartDate = new ArrayList<>();

        for (int i = 0; i < tableHeads.size(); i++) {
            String actualTableHeads = tableHeads.get(i).getText().trim();
            Helper.compareEquals(testConfig, "Invoice Period Grid Titles", expectedTableHeads.get(i), actualTableHeads);
        }

        List<WebElement> tableValues = Element.findElements(testConfig, "xpath", "//table[@class='table']/tbody/tr");
        for (int i = 0; i < tableValues.size(); i++) {
            String xpathInvcNumber = "//table[@class='table']/tbody/tr[" + (i + 1) + "]/td[3]/a";
            WebElement invcNumber = Element.findElement(testConfig, "xpath", xpathInvcNumber);
            downloadInvoiceNumber = invcNumber.getText();

            String xpathtTotalInvoiceAmount = "//table[@class='table']/tbody/tr[" + (i + 1) + "]/td[2]";
            WebElement totInvcAmount = Element.findElement(testConfig, "xpath", xpathtTotalInvoiceAmount);
            String exTotalInvoiceAmount = totInvcAmount.getText().substring(1);

            String xpathtBillingPeriod = "//table[@class='table']/tbody/tr[" + (i + 1) + "]/td[1]";
            WebElement billingPeriod = Element.findElement(testConfig, "xpath", xpathtBillingPeriod);
            String invcBillingPeriod = billingPeriod.getText();

            billingStartDate.add(0, invcBillingPeriod.substring(0, 10));

            String exBilMonthStart = invcBillingPeriod.substring(0, 2);
            String exBilDayStart = invcBillingPeriod.substring(3, 5);
            String exBilYearStart = invcBillingPeriod.substring(6, 10);


            String exBilMonthEnd = invcBillingPeriod.substring(13, 15);
            String exBilDayEnd = invcBillingPeriod.substring(16, 18);
            String exBilYearEnd = invcBillingPeriod.substring(19, 23);


            testConfig.putRunTimeProperty("tin", testConfig.getRunTimeProperty("tin"));
            testConfig.putRunTimeProperty("downloadInvoiceNumber", downloadInvoiceNumber);
            Map<String, String> data = DataBase.executeSelectQuery(testConfig, 2010, 1);

            String actualInvcAmount = data.get("INVC_TOT_AMT").toString();

            String acBilYearStart = data.get("BILL_CYC_STRT_DT").toString().substring(0, 4);
            String acBilMonthStart = data.get("BILL_CYC_STRT_DT").toString().substring(5, 7);
            String acBilDayStart = data.get("BILL_CYC_STRT_DT").toString().substring(8, 10);


            String acBilYearEnd = data.get("BILL_CYC_END_DT").toString().substring(0, 4);
            String acBilMonthEnd = data.get("BILL_CYC_END_DT").toString().substring(5, 7);
            String acBilDayEnd = data.get("BILL_CYC_END_DT").toString().substring(8, 10);


            Helper.compareEquals(testConfig, "Total Invoice Amount for each Invoice", exTotalInvoiceAmount, actualInvcAmount);

            Helper.compareEquals(testConfig, "Billing Period Month-Start", exBilMonthStart, acBilMonthStart);
            Helper.compareEquals(testConfig, "Billing Period Day-Start", exBilDayStart, acBilDayStart);
            Helper.compareEquals(testConfig, "Billing Period Year-Start", exBilYearStart, acBilYearStart);

            Helper.compareEquals(testConfig, "Billing Period Month-End", exBilMonthEnd, acBilMonthEnd);
            Helper.compareEquals(testConfig, "Billing Period Day-End", exBilDayEnd, acBilDayEnd);
            Helper.compareEquals(testConfig, "Billing Period Year-End", exBilYearEnd, acBilYearEnd);

        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        for (int i = 0; i < billingStartDate.size() - 1; i++) {
            for (int k = i + 1; k < billingStartDate.size(); k++) {
                Date date1 = sdf.parse(billingStartDate.get(i));
                Date date2 = sdf.parse(billingStartDate.get(k));

                if (date1.compareTo(date2) >= 0) {
                    Log.Comment("The Billig Period is in decending order");
                } else {
                    Log.Fail("The Billig Period is NOT in decending order");
                }
            }
        }
        return this;
    }

    public OptumPaySolution validatePastdueFee() {
        int sqlRowNo = 1630;
        Map data = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
        String feeTitle = null;
        if (StringUtils.equals(data.get("PASTDUEFEE").toString(), ""))
            feeTitle = "Past due fees: $0.00";
        else
            feeTitle = "Past due fees: $" + data.get("PASTDUEFEE").toString();
        if (System.getProperty("Application").contains("UPA"))
            Helper.compareEquals(testConfig, "Past due fee value", feeTitle, feeTileUPA.getText().substring(feeTileUPA.getText().indexOf("Past"), feeTileUPA.getText().length()));
        else
            Helper.compareEquals(testConfig, "Past due fee value", feeTitle, feeTile.getText().substring(feeTile.getText().indexOf("Past"), feeTile.getText().length()));
        return this;
    }

    public OptumPaySolution validateAccruedFeesMonth() {
        String amount = DataBase.executeSelectQuery(testConfig, QUERY.PAST_DUE_ACCRUED_FEE, 1).get("DBT_FEE_ACCRD_AMT").toString();
        String feeTitle = null;
        String month = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        feeTitle = month + " " + "accrued fees month to date: $" + amount;
        if (System.getProperty("Application").contains("UPA"))
            Helper.compareContains(testConfig, "accrued fee month value", feeTitle, feeTileUPA.getText().substring(0, feeTileUPA.getText().indexOf("\n")).replaceAll(",", ""));
        else
            Helper.compareContains(testConfig, "accrued fee month value", feeTitle, feeTile.getText().substring(0, feeTile.getText().indexOf("\n")).replaceAll(",", ""));
        return this;
    }

    public OptumPaySolution validtAccrdFeesMnthFrInvceTab() throws ParseException {


        if (StringUtils.equals(testConfig.getRunTimeProperty("portalAccess"), "Standard"))
            testConfig.putRunTimeProperty("prtl_prdct_selected_sts_cd", "PD");
        else if (StringUtils.equals(testConfig.getRunTimeProperty("portalAccess"), "Premium"))
            testConfig.putRunTimeProperty("prtl_prdct_selected_sts_cd", "PS");

        DataBase.executeUpdateQuery(testConfig, QUERY.UPDATE_PRODUCT_SELECTION);

        Browser.browserRefresh(testConfig);
        String amount = DataBase.executeSelectQuery(testConfig, QUERY.PAST_DUE_ACCRUED_FEE, 1).get("DBT_FEE_ACCRD_AMT").toString();
        if (amount.isEmpty())
            amount = "0.00";
        String month = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

        String feeTitle = null;
        feeTitle = month + " " + "accrued fees month to date: $" + amount;
        if (System.getProperty("Application").contains("UPA"))
            Helper.compareEquals(testConfig, "Accrued fee month value", feeTitle, feeTileUPAInvc.getText());
        else if (System.getProperty("Application").contains("CSR"))
            Helper.compareEquals(testConfig, "Accrued fee month value", feeTitle, divInvoicesAccrudFeesUI.getText());
        //Change the record to the origional record
        if (StringUtils.equals(testConfig.getRunTimeProperty("portalAccess"), "Standard")) {
            testConfig.putRunTimeProperty("portalAccess", "Premium");
            testConfig.putRunTimeProperty("prtl_prdct_selected_sts_cd", "PS");
            DataBase.executeUpdateQuery(testConfig, QUERY.UPDATE_PRODUCT_SELECTION);

        }
        return this;
    }

    public OptumPaySolution verifyInvoicesTab(String searchCriteria, String tinType, String portalAccess, String prdctRecSts) throws ParseException {
        if ("TinWithInvoices".equals(searchCriteria)) {
            Element.verifyElementPresent(lnkInvoice, "Invoices Link");
            Element.clickByJS(testConfig, lnkInvoice, "Invoices Link");
            Element.verifyElementPresent(divPageMsg, "Page message");
            verifyInvoicesPageText();
            Element.verifyElementPresent(invoice_grid_header, "Invoice grid header");
            verifyPastDuesInvoiceTab(searchCriteria);
            verifyProviderNameInvoices();
            verifyAccrudFeesInvoiceTab(searchCriteria);
            try {
                verifyInvoiceDetailsTableUI(searchCriteria);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("TinWithoutInvoices".equals(searchCriteria) && ("AV".equals(tinType) || "AO".equals(tinType)) && "Premium".equals(portalAccess) && "PS".equals(prdctRecSts)) {
            Element.verifyElementPresent(lnkInvoice, "Invoices Link");
            Element.clickByJS(testConfig, lnkInvoice, "Invoices Link");
            Element.verifyElementPresent(divPageMsg, "Page message");
            verifyPastDuesInvoiceTab(searchCriteria);
            verifyAccrudFeesInvoiceTab(searchCriteria);
            verifyProviderNameInvoices();
            Element.verifyElementPresent(msgNoInvoicesPresent, "no invoices present msg");
        } else if ("TinWithoutInvoices".equals(searchCriteria) && ("AV".equals(tinType) || "AO".equals(tinType)) && "Premium".equals(portalAccess) && "TR".equals(prdctRecSts)) {
            Element.verifyElementNotPresent(lnkInvoice, "Invoices Link");
        } else if ("TinWithoutInvoices".equals(searchCriteria) && "VO".equals(tinType)) {
            Element.verifyElementNotPresent(lnkInvoice, "Invoices Link");
        } else if ("TinWithoutInvoices".equals(searchCriteria) && "Standard".equals(portalAccess)) {
            Element.verifyElementNotPresent(lnkInvoice, "Invoices Link");
        }
        return this;
    }

    public void verifyInvoicesPageText() {
        Helper.compareEquals(testConfig, "Invoices pagetext 1 ", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutions.pageText1"), txtInvoicesPageText1.getText().trim());
        Helper.compareEquals(testConfig, "Invoices pagetext 2 ", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutions.pageText2"), txtInvoicesPageText2.getText().trim());
    }

    public void verifyProviderNameInvoices() {
        int sqlRowNo = 1;
        Map data = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
        Helper.compareContains(testConfig, "test", data.get("ORG_NM").toString().trim(), Element.findElement(testConfig, "xpath", "//*[@id=\"optum-pay-invoices\"]/div/div[1]/p").getText().trim());

    }

    public void verifyInvoiceDetailsTableUI(String searchCriteria) throws IOException, ParseException {
        HashMap<Integer, HashMap<String, String>> invoiceTableData = DataBase.executeSelectQueryALL(testConfig, QUERY.Enhancement_Invoice_Grid_Data);
        ArrayList<String> expectedHeader = new ArrayList<String>();
        expectedHeader.add("Invoice");
        expectedHeader.add("Billing Period");
        expectedHeader.add("Amount Due");
        expectedHeader.add("Processed By");
        expectedHeader.add("Confirmation");

        if ("TinWithInvoices".equals(searchCriteria)) {
            ArrayList<String> actualContentUI = new ArrayList<String>();
            for (WebElement header : tableInvoiceDetailTableHeader) {
                if (!header.getText().isEmpty()) {
                    actualContentUI.add(header.getText());
                }
            }

            Helper.compareEquals(testConfig, "tableInvoiceDetailTableHeader", expectedHeader, actualContentUI);

            for (int i = 0; i < tableInvoiceAmountUI.size(); i++) {

                String invoice_Sts1 = String.format("//tbody/tr[%s]/td[4]/input[1]", i + 1);
                String invoice_sts = Element.findElement(testConfig, "xpath", invoice_Sts1).getAttribute("value");
                String invoice_StatusDB = invoiceTableData.get(i + 1).get("INVC_STS").toString();
                String startDate = Helper.changeDateFormat(invoiceTableData.get(i + 1).get("BILL_CYC_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
                String endDate = Helper.changeDateFormat(invoiceTableData.get(i + 1).get("BILL_CYC_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
                String firstName = invoiceTableData.get(i + 1).get("FST_NM").toString();
                String lastName = invoiceTableData.get(i + 1).get("LST_NM").toString();

                Helper.compareEquals(testConfig, "Billing Period", startDate + " - " + endDate, tableInvoiceDateUI.get(i).getText());

                if (firstName.isEmpty() && lastName.isEmpty()) {
                    Helper.compareEquals(testConfig, "Processed By", "---", tableInvoiceProcessedByUI.get(i).getText().trim());
                } else {
                    Helper.compareEquals(testConfig, "Processed By", firstName + " " + lastName, tableInvoiceProcessedByUI.get(i).getText());
                }

                if (invoice_StatusDB.equals("IR") || invoice_StatusDB.equals("FP")) {
                    Helper.compareEquals(testConfig, "Asserting the Invoice Status DB vs UI", "Pay Now", invoice_sts);
                }

                if (invoice_StatusDB.equals("IP") || invoice_StatusDB.equals("FS") || invoice_StatusDB.equals("FC")) {
                    Helper.compareEquals(testConfig, "Asserting the Invoice Status DB vs UI", "Paid", invoice_sts);
                }

                if (invoice_sts.contentEquals("Paid")) {
                    Helper.compareEquals(testConfig, "Amount Due", "$0.00", tableInvoiceAmountUI.get(i).getText());
                } else {
                    Helper.compareEquals(testConfig, "Amount Due", "$" + invoiceTableData.get(i + 1).get("INVC_TOT_AMT").toString(), tableInvoiceAmountUI.get(i).getText());
                }
                Helper.compareEquals(testConfig, "Invoice", invoiceTableData.get(i + 1).get("INVC_NBR").toString(), tableInvoiceNumberUI.get(i).getText());
            }
        }

    }

    public void verifyAccrudFeesInvoiceTab(String searchCriteria) {
        Map data = DataBase.executeSelectQuery(testConfig, QUERY.PAST_DUE_ACCRUED_FEE, 1);
        String invoiceAccrudFee = null;

        if ("TinWithInvoices".equals(searchCriteria) && data.get("DBT_FEE_ACCRD_AMT").toString().trim().length() > 0)
            invoiceAccrudFee = "Accrued fees month to date: $" + data.get("DBT_FEE_ACCRD_AMT").toString();
        else if ("TinWithoutInvoices".equals(searchCriteria) || data.get("DBT_FEE_ACCRD_AMT").toString().trim().length() == 0)
            invoiceAccrudFee = "Accrued fees month to date: $0.00";

        Helper.compareContains(testConfig, "Accrud fee value", invoiceAccrudFee, divInvoicesAccrudFeesUI.getText());

    }

    public void verifyPastDuesInvoiceTab(String searchCriteria) {
        String invoicePastDueFee = null;
        int sqlRowNo = 1122;
        Map data = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);

        if ("TinWithoutInvoices".equals(searchCriteria) || data.get("PASTDUE").toString().trim().length() == 0)
            invoicePastDueFee = "Past due fees: $0.00";
        else if ("TinWithInvoices".equals(searchCriteria))
            invoicePastDueFee = "Past due fees: $" + data.get("PASTDUE").toString();

        Helper.compareContains(testConfig, "Past due fee value", invoicePastDueFee, divInvoicesPastDueFeesUI.getText());

    }

    public void navigateToFeeSearchTab() {
        //Element.click(testConfig, feeSearchTab, "Fee Search Tab", 3);
        Element.clickByJS(testConfig, feeSearchTab, "Fee Search Tab");
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
                Element.enterDataByJS(testConfig, invoiceNumber, invoice_nbr, "Enter Fee Search invoice number as: " + invoiceNumber);
                break;
            }

            case "feeSrchTINdetailsTabwthAllVal": {
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

    public int getNumberOfPages() {
        int noOfPages = 0;
        int recordsCount = Integer.parseInt(getRecordCountFromUI());
        if (recordsCount > 30) {
            noOfPages = recordsCount / 30;
            if (recordsCount % 30 > 0)
                noOfPages = noOfPages + 1;
        } else
            noOfPages = 1;
        return noOfPages;
    }

    public OptumPaySolution verifyPagination() {

        if (Element.findElement(testConfig, "xpath", "//div[@id='optum-pay-fee-search']/div[2]/div/div/p") != null) {
            String actualtxt = Element.findElement(testConfig, "xpath", "//div[@id='optum-pay-fee-search']/div[2]/div/div/p").getText();
            Helper.compareEquals(testConfig, "message comparision", "No fees available for this Organization.", actualtxt);

        } else {
            int totalNoOfPages = getNumberOfPages();
            int pageNo = 1;


            //verify pagination links >>,<<
            if (Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]") != null &&
                    Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[3]/div[2]/span") != null
            )
                Log.Pass("Uppar and lower pagination links are on the page ");
            else
                Log.Fail("Uppar and lower pagination links are not on the page");
            //verify 30 rows
            if (noOfRows.size() <= 30)
                Log.Pass("Maximum 30 rows in a page");
            else
                Log.Fail("More than 30 rows in a page");
            //click on >,>>,<,<< and disability
            if (
                    Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[1]").getTagName() != "a" &&
                            Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[2]").getTagName() != "a")
                Log.Pass("< and << are disabled");
            else
                Log.Fail("< and << are enabled");


            if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
                int pageToBeClicked = pageNo + 1;

                Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text()," + pageToBeClicked + ")]").click();
                Log.Comment("Clicked Page number : " + pageToBeClicked);

                Browser.wait(testConfig, 2);
                Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'<')]").click();
                Log.Comment("Clicked back Page");

                Browser.wait(testConfig, 2);
                Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'>')]").click();
                Log.Comment("Clicked next Page");

                Browser.wait(testConfig, 2);
                Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'<<')]").click();
                Log.Comment("Clicked first Page");

                Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/a[contains(text(),'>>')]").click();
                Log.Comment("Clicked last Page");

                if (
                        Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[2]").getTagName() != "a" &&
                                Element.findElement(testConfig, "xpath", "//div[@id='feeSearchTable']/div[1]/div[2]/span/span[3]").getTagName() != "a")
                    Log.Pass("> and >> are disabled");
                else
                    Log.Fail("> and >> are enabled");
                Browser.waitForLoad(testConfig.driver);
            }

        }
        Element.clickByJS(testConfig, lnkLogOut, "logging Out of the portal");
        return this;

    }

    public OptumPaySolution clickFeesForRefund() {
        if (!refundFeeCheckbox.isDisplayed())
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

        if (feeSearchCriteria.equalsIgnoreCase("feeSearchInvoiceNumber")) {
            Map<String, String> totalCount = DataBase.executeSelectQuery(testConfig, QUERY.EXPECTED_COUNT_FOR_FEE_REFUND_INVOICE_NUMBER, 1);
            Helper.compareEquals(testConfig, "Asserting number of entries in DB vs UI", totalCount.get("COUNT"), getRecordCountFromUI());
        }

        if (feeSearchCriteria.equalsIgnoreCase("feeSearchPaymentNumber")) {
            Map<String, String> totalCount2 = DataBase.executeSelectQuery(testConfig, QUERY.EXPECTED_COUNT_FOR_FEE_REFUND_PAYMENT_NUMBER, 1);
            Helper.compareEquals(testConfig, "Asserting number of entries in DB vs UI", totalCount2.get("COUNT"), getRecordCountFromUI());
        }

        clickFeesForRefund();
        Element.clickByJS(testConfig, clearButton, "Clear button");
        return this;
    }


    public OptumPaySolution verifyHeaderFooterMsgOptionsTab(String tinType, String userType) {
        Element.expectedWait(pageHeader, testConfig, "Page header text to be displayed", "Page header Texr");
        if (StringUtils.equals(userType, "PROV")) {
            if (StringUtils.equals(tinType, "AO") || StringUtils.equals(tinType, "AV")) {
                Helper.compareEquals(testConfig, "Header on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.ao.optumPaySolution.optionsTab.header").trim(), pageHeader.getText());
                Helper.compareEquals(testConfig, "Footer on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.ao.optumPaySolution.optionsTab.footer").trim(), pageFooter.getText().trim());
            } else if (StringUtils.equals(tinType, "VO")) {
                Helper.compareEquals(testConfig, "Header on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.vo.optumPaySolution.optionsTab.header").trim(), pageHeader.getText());
                Helper.compareEquals(testConfig, "Footer on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.vo.optumPaySolution.optionsTab.footer").trim(), pageFooter.getText().trim());
            } else if (StringUtils.equals(tinType, "AO") || StringUtils.equals(tinType, "AV") && StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and Paid")) {
                Helper.compareEquals(testConfig, "Header on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.trial.ao.optumPaySolution.optionsTab.header").trim(), pageHeader.getText());
                Helper.compareEquals(testConfig, "Footer on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.trial.ao.optumPaySolution.optionsTab.footer").trim(), pageFooter.getText().trim());
            }
        } else if (StringUtils.equals(userType, "BS")) {
            if (StringUtils.equals(tinType, "AO") || StringUtils.equals(tinType, "AV")) {
                Helper.compareEquals(testConfig, "Header on Options tab", TestBase.contentMessages.getProperty("bs.admin.premium.ao.optumPaySolution.optionsTab.header").trim(), pageHeader.getText());
                Helper.compareEquals(testConfig, "Footer on Options tab", TestBase.contentMessages.getProperty("bs.admin.premium.ao.optumPaySolution.optionsTab.footer").trim(), pageFooter.getText().trim());
            } else if (StringUtils.equals(tinType, "VO")) {
                Helper.compareEquals(testConfig, "Header on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.vo.optumPaySolution.optionsTab.header").trim(), pageHeader.getText());
                Helper.compareEquals(testConfig, "Footer on Options tab", TestBase.contentMessages.getProperty("prov.admin.premium.vo.optumPaySolution.optionsTab.footer").trim(), pageFooter.getText().trim());
            }
        }

        return this;
    }

    public void verifyInfoIconMessagesforAllTiles() {
        Helper.compareEquals(testConfig, "Plan Type Info Icon Message", TestBase.contentMessages.getProperty("prov.admin.premium.ao.optumPaySolution.planTypeTile.infoIcon").trim(), planTypeTileInfoIconMsg.getAttribute("title").replaceAll("<p>", "").replaceAll("</p>", "").trim());
        Helper.compareEquals(testConfig, "Rate Info Icon Message", TestBase.contentMessages.getProperty("prov.admin.premium.ao.optumPaySolution.rateTile.infoIcon").trim(), rateTileInfoIconMsg.getAttribute("title").replaceAll("<p>", "").replaceAll("</p>", "").trim());
        Helper.compareEquals(testConfig, "Fees Info Icon Message", TestBase.contentMessages.getProperty("prov.admin.premium.ao.optumPaySolution.feeTile.infoIcon").trim(), feesTileInfoIconMsg.getAttribute("title").replaceAll("<p>", "").replaceAll("</p>", "").trim());
        Helper.compareEquals(testConfig, "Manage My Plan Info Icon Message", TestBase.contentMessages.getProperty("prov.admin.premium.ao.optumPaySolution.manageMyPlanTile.infoIcon").trim(), manageMyPlanTileInfoIconMsg.getAttribute("title").replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("<a href=\"#mailto:optumpay_cancel@optum.com@optum.com\">", "").replaceAll("</a>", "").trim());
    }

    //Added by Mohammad
    public boolean verifyTilesArePresentOnOPS() {
        boolean flag = false;

        for (WebElement tiles : tilesHeaderUI) {
            if (tiles.isDisplayed()) {
                flag = true;
            }
        }
        return flag;
    }

    public void verifyTINerroMsgforBSUsers(String tinType) {
        String ex_Error_MsgInvalidTIN_BS = "TIN must be 9 digits";
        String ex_Error_MsgNotAssociatedTIN_BS = "TIN is not enrolled and/or not associated with your Billing Service";

        switch (tinType) {
            case "Invalid": {
                Helper.compareEquals(testConfig, "Invalid TIN error message for BS", ex_Error_MsgInvalidTIN_BS, errorMsgInvalid_NotAssociatedTIN_BS.getText().trim());
                break;
            }

            case "NotAssociated": {
                Helper.compareEquals(testConfig, "Not Associated TIN error message for BS", ex_Error_MsgNotAssociatedTIN_BS, errorMsgInvalid_NotAssociatedTIN_BS.getText().trim());
                break;
            }
        }

    }

    public OptumPaySolution clickInvoiceNumberAndOpenPdf() {
        String parentwindowhandle = testConfig.driver.getWindowHandle();
        String invoiceNum;
        String oldWindow = "";
        int invoiceSql = 1120;
        Map invoiceTable = DataBase.executeSelectQuery(testConfig, invoiceSql, 1);
        invoiceNum = invoiceTable.get("INVC_NBR").toString();
        for (WebElement invoice : invoiceNumberList) {

            if (invoiceNum.equals(invoice.getText())) {
                for (int i = 0; i < 2; i++) {
                    Element.clickByJS(testConfig, invoice, "invoice");
                    oldWindow = Browser.switchToNewWindow(testConfig);

                    //Browser.waitForLoad(testConfig.driver);
                    try {
                        if (redTextError.isDisplayed())
                            Helper.compareContains(testConfig, "Not able to generate Invoice", "Something went wrong. We were unable to generate the invoice. Please close this tab and try again later.", redTextError.getText());
                        //Log.Fail("The Invoice not available");
                    } catch (Exception e) {
                        Browser.verifyURL(testConfig, "opsinvoices.do?method=index&invoicenumber=%20" + invoiceNum);
                    }
                    Browser.closeBrowser(testConfig);
                    Browser.switchToParentWindow(testConfig, oldWindow);
                    break;
                }
            }

        }
        return this;
    }


    public void selectFeeAmountCheckBoxAndCalculateFeeAmount() {
        double feeAmount = 0;
        clickFeesForRefund();

        List<WebElement> ls = Element.findElements(testConfig, "xpath", "//table[@class='table fee_table']/tbody/tr");
        int feeCount = ls.size();
        Log.Comment("Total Fee Number" + feeCount);
        testConfig.putRunTimeProperty("TotalNumberOfFees", String.valueOf(feeCount));

        for (int i = 0; i < ls.size(); i++) {
            String xpathFeeAmount = "//table[@class='table fee_table']/tbody/tr[" + (i + 1) + "]/td[5]";
            WebElement FeeAmount = Element.findElement(testConfig, "xpath", xpathFeeAmount);
            feeAmount = feeAmount + Double.valueOf(FeeAmount.getText().trim().substring(1, FeeAmount.getText().trim().length()));
        }

        testConfig.putRunTimeProperty("TotFeeAmountRefund", String.valueOf(feeAmount));

        selectAll.click();
        Log.Comment("Select All button clicked");

        refundFeeButton.click();
        Log.Comment("Refund Button clicked");

    }


    public void verifyTextOnRefundPopUI() {
        String ex_AreYouSure = "Are You Sure?";
        String ex_RefundText = "You are about to refund " + testConfig.getRunTimeProperty("TotalNumberOfFees") + " fees totaling $" + testConfig.getRunTimeProperty("TotFeeAmountRefund") + ". This amount will be reflected as a credit on the provider's next invoice. Please select the reason for the refund.";

        Helper.compareEquals(testConfig, "Refund Pop UI Text", ex_AreYouSure, feeRefundPopUpText1.getText().trim());
        Helper.compareEquals(testConfig, "Refund Pop UI Text", ex_RefundText, feeRefundPopUpText2.getText().trim());
        Element.clickByJS(testConfig, refundFeeCancelButton, "Refund Pop Up Cancel Button");

    }

    public void clickOnSelectAllandRefundButton() {
        Element.clickByJS(testConfig, selectAll, "Select All Button clicked");
        Element.clickByJS(testConfig, refundFeeButton, "Refund Button");
    }

    public void selectRefundReasonandClickOnRefundButton() {
        Element.selectByVisibleText(reasonDropDownrefundPopUp, "Fraud", "Selecting 'Fraud' Reason for Fee Refund");
    }


    public void validateOptumPaySolutionPage(String userType, String portalAccess, String tinType) {

        if (userType.equals("BS") && portalAccess.equals("Standard")) {

            Helper.compareEquals(testConfig, "Heading", "Leverage all that Optum Pay has to offer", txtOnStandardPage.getText());
            Element.verifyElementPresent(video, "Video");
            Element.verifyElementNotPresent(getStartedHeaderBtn, "Get Started btn on Header");
            Element.verifyElementNotPresent(getStartedBtn, "Get Started btn");
            String headerExpected[] = {"Solutions to meet your needs", "Data Access", "Unlimited Users", "Workflow Management Tools"};
            int i = 0;
            for (WebElement header : headerBsUser) {
                Helper.compareEquals(testConfig, "Headers for a Standard TIN", headerExpected[i++], header.getText());
            }
        }
    }

    public OptumPaySolution cancelPremiumAndSubmit(String reasonCode, String portal) {
        String fname = "";
        String lname = "";
        String email = "";
        String phoneNum = "";
        String phNum1 = "";
        String phNum2 = "";
        String otherReason = "";
        String date = "";

        if (portal.equals("CSR")) {
            fname = Helper.generateRandomAlphabetsString(5);
            lname = Helper.generateRandomAlphabetsString(5);
            email = Helper.getUniqueEmailId();
            phNum1 = Long.toString(Helper.generateRandomNumber(3));
            phNum2 = Long.toString(Helper.generateRandomNumber(4));
            date = Helper.getCurrentDate("MM/dd/yyyy");

            Element.clickByJS(testConfig, cancelSubscriptionLinkCsr, "Cancel link-CSR");
            Element.clearData(cancelRequestDateTxtBox, "Cancel Request Date");
            Element.enterDataByJS(testConfig, cancelRequestDateTxtBox, date, "Cancel Request Date");
            Element.enterDataByJS(testConfig, firstNameTxtBox, fname, "First Name");
            Element.enterDataByJS(testConfig, lastNameTxtBox, lname, "Last Name");
            Element.enterDataByJS(testConfig, emailTxtBox, email, "Email");
            Element.enterDataByJS(testConfig, phoneNumber1, phNum1, "Phone Number 1");
            Element.enterDataByJS(testConfig, phoneNumber2, phNum1, "Phone Number 2");
            Element.enterDataByJS(testConfig, phoneNumber3, phNum2, "Phone Number 3");

            testConfig.putRunTimeProperty("phoneNum", phNum1 + phNum1 + phNum2);
        } else if (portal.equals("UPA")) {
            int sql = 7;
            Map portalData = DataBase.executeSelectQuery(testConfig, sql, 1);

            fname = portalData.get("FST_NM").toString();
            lname = portalData.get("LST_NM").toString();
            email = portalData.get("EMAIL_ADR_TXT").toString();
            phoneNum = portalData.get("TEL_NBR").toString();
            date = Helper.getCurrentDate("MM/dd/yyyy");

            Element.clickByJS(testConfig, lnkCancelPlanDuringTrial, "Cancel My Subscription Link-UPA");

            testConfig.putRunTimeProperty("phoneNum", phoneNum);
        }

        Element.selectByValue(reasonSelectorDrpDwn, reasonCode, "Selecting Others");
        if (reasonCode.equalsIgnoreCase("R7")) {
            otherReason = Helper.generateRandomAlphabetsString(7);
            Element.enterDataByJS(testConfig, otherReasonTxtBox, otherReason, "Fill Other Reason");
        }

        if (portal.equals("CSR"))
            Element.clickByJS(testConfig, btnSave, "Save button");
        else if (portal.equals("UPA"))
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
        String effectiveDate = "";
        if (trialStatus.compareToIgnoreCase("New Enroll WithinTrial and Paid") == 0) {
            testConfig.putRunTimeProperty("stdStatus", "P");
            Map duringTrialRecord = DataBase.executeSelectQuery(testConfig, QUERY.PREMIUM_TRIAL_FOR_TIN, 1);
            effectiveDate = duringTrialRecord.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString();
        } else
            testConfig.putRunTimeProperty("stdStatus", "A");


        Browser.wait(testConfig, 3);
        Map portalUserTable = DataBase.executeSelectQuery(testConfig, QUERY.POST_CANCELLATION_TIN_STATUS, 1);

        if (portalUserTable != null)
            Log.Pass("Premium Cancelled sucessfully");
        else Log.Fail("Premium Not Cancelled sucessfully");

        if (trialStatus.compareToIgnoreCase("New Enroll WithinTrial and Paid") == 0) {
            if (testConfig.getRunTimeProperty("App").equalsIgnoreCase("UPA"))
                Helper.compareEquals(testConfig, "Effective date of inserted Standard record for Within Trial TIN", Helper.addDays(effectiveDate, 30).toString(), portalUserTable.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().substring(0, 10));
            else
                Helper.compareEquals(testConfig, "Effective date of inserted Standard record for Within Trial TIN", Helper.addDays(effectiveDate, 29).toString(), portalUserTable.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().substring(0, 10));
        } else
            Helper.compareEquals(testConfig, "Effective date of inserted Standard record for Post Trial TIN", Helper.getCurrentDate("MM/dd/yyyy").toString(), Helper.changeDateFormat(testConfig, portalUserTable.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().substring(0, 10), "yyyy-mm-dd", "mm/dd/yyyy").toString());

        return this;
    }

    public OptumPaySolution verifyCancelTableUpdated() {
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
        if (portal.equals("CSR"))
            Helper.compareContains(testConfig, "Plan Change to Limited", "Limited", Element.findElement(testConfig, "xpath", "//div[@id=\"optum-pay-options\"]//div[1]/div/div[2]").getText());//txtProvNameInfo.getText());
        else Element.verifyElementPresent(getStartedBtn, "getStartedBtn");

        if (trialStatus.equals("New Enroll WithinTrial and Paid"))
            testConfig.putRunTimeProperty("prdSts", "P");
        else testConfig.putRunTimeProperty("prdSts", "A");

        DataBase.executeDeleteQuery(testConfig, QUERY.DELETE_CANCELLED_TO_STANDARD_ROWS);
        DataBase.executeUpdateQuery(testConfig, QUERY.UPDATE_CANCELLED_TO_STANDARD_ROWS);
        return this;
    }

    public OptumPaySolution convertToPremiumFromUpa() {
        Element.clickByJS(testConfig, getStartedBtn, "Get Started Btn");
        Element.clickByJS(testConfig, acceptPremiumBtn.get(2), "I Accept, activate Premium");
        return this;
    }

    public OptumPaySolution verifyEffectiveDateOfTrialPendingRecord(String portalAccess, String tinType) throws ParseException {
        String trialDate;

        testConfig.putRunTimeProperty("prdSelection", portalAccess);
        testConfig.putRunTimeProperty("stsOfStdRecd", "P");

        if (portalAccess.equals("Premium") && tinType.equals("AO"))
            testConfig.putRunTimeProperty("SelectedOrDefault", "PS");
        else if (portalAccess.equals("Standard") && tinType.equals("AO"))
            testConfig.putRunTimeProperty("SelectedOrDefault", "PD");
        else Log.Fail("Invalid");

        trialDate = DataBase.executeSelectQuery(testConfig, QUERY.PREMIUM_TRIAL_FOR_TIN, 1).get("PRTL_PRDCT_SELECT_EFF_DTTM").toString();

        Map selectionTable = DataBase.executeSelectQuery(testConfig, QUERY.PRODUCT_SELECTION_TIN_QUERY, 1);

        Helper.compareEquals(testConfig, "Effective date of inserted Standard record for Within Trial TIN", Helper.addDays(trialDate, 30).toString(), selectionTable.get("PRTL_PRDCT_SELECT_EFF_DTTM").toString().substring(0, 10));
        return this;
    }

    public OptumPaySolution clickOnPayNowButton() {

        testConfig.putRunTimeProperty("invc_nbr", payNow.findElement(By.xpath("./preceding::td[3]")).getText());
        Element.clickByJS(testConfig, payNow, "Pay Now Button clicked");
        return this;
    }

    public OptumPaySolution verifyProcessMyPaymentModal() {
        ArrayList<String> expectedContent = new ArrayList<String>();
        ArrayList<String> actualContent = new ArrayList<String>();
        expectedContent.add("Savings");
        expectedContent.add("Checking");
        Element.verifyElementPresent(popUpACHPaymentModal, "ACH PAYMENT MODAL");
        Helper.compareEquals(testConfig, "Process My Payment Header", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutionsPaymentModal.header"), pageTextModalACHpayment.get(0).getText().trim());
        Helper.compareContains(testConfig, "Enter your bank account information below to pay your premium fee(s).", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutionsPaymentModal.pageText1"), pageTextModalACHpayment.get(1).getText().trim());
        Helper.compareContains(testConfig, "Amount to pay", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutionsPaymentModal.pageText2"), pageTextModalACHpayment.get(2).getText().trim());
        Helper.compareEquals(testConfig, "scrollable div page Text 1", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutionsPaymentModalScrollableDiv.pageText1"), txtScrollableDivModalACHpayment.get(0).getText().trim());
        Helper.compareEquals(testConfig, "scrollable div page Text 2", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutionsPaymentModalScrollableDiv.pageText2"), txtScrollableDivModalACHpayment.get(1).getText().trim());
        Helper.compareEquals(testConfig, "scrollable div page Text 3", TestBase.contentMessages.getProperty("prov.admin.premium.ao.invoicesOptumPaySolutionsPaymentModalScrollableDiv.pageText3"), txtScrollableDivModalACHpayment.get(2).getText().trim());
        for (WebElement accType : drpdownAccountTypeSelector) {
            actualContent.add(accType.getText());
        }
        Helper.compareEquals(testConfig, "ACCOUNT TYPE OPTIONS", expectedContent, actualContent);
        Element.verifyElementPresent(btnCancelModalACHpayment, "Cancel button");
        Element.verifyElementNotEnabled(btnSubmitModalACHpayment, "Submit Button");
        Helper.compareEquals(testConfig, "checkbox ", "true", chkboxOptumFeeDebitAuth.getAttribute("disabled"));
        Helper.compareEquals(testConfig, "routing number", "* Routing Number", txtboxPaymentModalRoutingNumber.getText());
        Helper.compareEquals(testConfig, "accounting number", "* Account Number", txtboxPaymentModalAccountNumber.getText());
        Helper.compareEquals(testConfig, "Routing Number comparison", "*********", routingNumber.getAttribute("placeholder"));

        return this;

    }

    public OptumPaySolution validateProcessMyPaymentHeader(String ABASwitch, String ABAResponse) throws IOException {

        //user validates RTN is 9 digits.
        Element.enterData(routingNumber, "2345", "Enter Routing Number", "routingNumber");
        Element.enterData(accountNumber, "132323", "Enter Account Number", "accountNumber");

        //Verify Error Message
        Element.verifyElementPresent(errorMsg, "Invalid Data Error Message");
        Helper.compareEquals(testConfig, "Invalid Data Error Msg", "Invalid Data", errorMsg.getText().trim());


        //Set ABA Validator Switch
        testConfig.putRunTimeProperty("proc_data", ABASwitch);
        DataBase.executeUpdateQuery(testConfig, QUERY.UPDATE_ABA_VALIDATOR_SWITCH, DataBase.getDatabaseType());

        if (ABASwitch.contentEquals("Y")) {
            if (ABAResponse.equalsIgnoreCase("Valid")) {
                int rowNo = 1;
                TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
                List<String> ValidRoutNos = data.GetAllColumnsData("FinancialInfo", "ValidRoutingNos");
                String routingNo = data.GetData(rowNo, "RoutingNumber");
                String accountNo = data.GetData(rowNo, "AccountNumber");
                if (ValidRoutNos.contains(routingNo)) {
                    Element.enterData(routingNumber, routingNo, "Read from excel and Enter Routing Number", "routingNumber");
                    Element.enterData(accountNumber, accountNo, "Read from excel and Enter Account Number", "accountNumber");
                    optumPaySolndata.put("RTE_TRNS_NBR", routingNo);
                    optumPaySolndata.put("BANK_ACCT_NBR", accountNo);
                    //finInstAcctNum.sendKeys(Keys.TAB);
                    Element.enterKeys(accountNumber, Keys.TAB, "TAB Key entering", "TAB Key");
                    Browser.wait(testConfig, 5);
                    Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@id='invoicesAchPaymentForm']/div[4]/div[1]"), 60);
                    WebElement AddronUI = Element.findElement(testConfig, "xpath", "//*[@id='invoicesAchPaymentForm']/div[4]/div[1]");
                    String AddronUIText = AddronUI.getText();

                    String[] Bankdetails = AddronUIText.split("\n");
                    List<String> UIBankDetails = Arrays.asList(Bankdetails);
                    List<String> ValidAddr = data.GetAllColumnsData("FinancialInfo", "ValidAddr");
                    ValidAddr.add(0, "Financial Institution Information");
                    List<String> UIList = new ArrayList<String>();
                    UIList.add(UIBankDetails.get(0));
                    UIList.add(UIBankDetails.get(1));
                    UIList.add(UIBankDetails.get(2).replace(".", ""));
                    UIList.add(UIBankDetails.get(3));
                    UIList.add(UIBankDetails.get(4).replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));
                    List<String> expectedList = new ArrayList<String>();
                    expectedList.add(ValidAddr.get(0));
                    expectedList.add(ValidAddr.get(1));
                    expectedList.add(ValidAddr.get(2));
                    expectedList.add(ValidAddr.get(3).replace("-0000", ""));
                    expectedList.add(ValidAddr.get(4).replace("-", ""));
                    Helper.compareEquals(testConfig, "UI and Actual Compasision", expectedList, UIList);

                }
            } else {
                Element.enterData(routingNumber, "111111111", "Enter Routing Number", "routingNumber");
                Element.enterData(accountNumber, "212121212", "Enter Account Number", "accountNumber");
                //finInstAcctNum.sendKeys(Keys.TAB);
                Element.enterKeys(accountNumber, Keys.TAB, "TAB Key entering", "TAB Key");
                Browser.wait(testConfig, 5);

                //Verify Error Message
                Element.verifyElementPresent(errorMsg, "Invalid Data Error Message");
                Helper.compareEquals(testConfig, "No Financial Error Msg", "No Financial Institution match found for this routing number- Please enter again", errorMsg.getText().trim());

            }

        } else {
            int rowNo = 1;
            TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
            List<String> ValidRoutNos = data.GetAllColumnsData("FinancialInfo", "ValidRoutingNos");
            String routingNo = data.GetData(rowNo, "RoutingNumber");
            String accountNo = data.GetData(rowNo, "AccountNumber");
            if (ValidRoutNos.contains(routingNo)) {
                Element.enterData(routingNumber, routingNo, "Read from excel and Enter Routing Number", "routingNumber");
                Element.enterData(accountNumber, accountNo, "Read from excel and Enter Account Number", "accountNumber");
                //finInstAcctNum.sendKeys(Keys.TAB);
                Element.enterKeys(accountNumber, Keys.TAB, "TAB Key entering", "TAB Key");
                Browser.wait(testConfig, 5);
            }
            Element.clickByJS(testConfig, optumPayDebitAuthCheckBox, "Optum Pay Debit Auth CheckBox");
            Helper.compareEquals(testConfig, "Submit Button is enabled", true, submitButton.isEnabled());

        }
        return this;
    }

    public void verifyProcessMyPaymentModalAfterEnteringUserInfo() {
        Element.click(testConfig, chkboxOptumFeeDebitAuth, "chkboxOptumFeeDebitAuth", 2);
        Element.verifyElementIsEnabled(btnSubmitModalACHpayment, "Submit Button");
        WebElement slt = Element.findElement(testConfig, "id", "refund_reason_selector");
        optumPaySolndata.put("ACCT_TYP_ID", Element.getFirstSelectedOption(testConfig, slt, "text"));
        Element.clickByJS(testConfig, btnSubmitModalACHpayment, "Submit Button");


    }

    public void verifyThankyoupopup() {
        Browser.wait(testConfig, 2);
        Helper.compareEquals(testConfig, "Header message", "Thank You", Thnkyou.getText().trim());
        Helper.compareEquals(testConfig, "paragraph message", "We have received your payment. Please allow three business days for processing. Below is your confirmation number which can also be referenced at any time on the invoices tab.", paragraphTxt.getText().trim());
        Element.verifyElementPresent(confirmNumber, "Confirmation Number ");
        Element.verifyElementPresent(amtPaid, "Amount paid ");
        optumPaySolndata.put("CONFIRM_NBR", Element.findElement(testConfig, "xpath", "//div[@id='invoiceAchPaymentModal']/p[3]/strong").getText());

        Element.clickByJS(testConfig, closeBtn, "Close Button");
        Element.fluentWait(testConfig, paidBtn, 60, 1, "Paid Button");
        Element.verifyElementNotEnabled(paidBtn, "Paid Button");
        Helper.compareEquals(testConfig, "Amount Due", "$0.00", amountDue.getText().trim());
        verifyupdatedRcrdsDB();
    }

    public void verifyupdatedRcrdsDB() {
        String ACCT_TYP_ID = null;
        try {
            Map portalUserData = DataBase.executeSelectQuery(testConfig, 7, 1);
            Map currDateDB = DataBase.executeSelectQuery(testConfig, 1910, 1);
            if (StringUtils.equals(optumPaySolndata.get("ACCT_TYP_ID"), "Checking"))
                ACCT_TYP_ID = "1";
            else if (StringUtils.equals(optumPaySolndata.get("ACCT_TYP_ID"), "saving"))
                ACCT_TYP_ID = "2";
            HashMap<Integer, HashMap<String, String>> updatedDebitFee = DataBase.executeSelectQueryALL(testConfig, QUERY.UPDATED_DEBIT_FEE_INVCE);

            for (int i = 1; i <= updatedDebitFee.size(); i++) {

                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("PAID_BY_USER").toString(), portalUserData.get("PORTAL_USER_ID").toString());
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("PAID_DATE").toString().substring(0, 10), currDateDB.get("CURRENT_DATE").toString());
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("INVC_STS").toString(), "IP");
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("CONFIRM_NBR").toString(), optumPaySolndata.get("CONFIRM_NBR"));
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("PAYMENT_CONSENT_IND").toString(), "Y");
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("LST_CHG_BY_ID").toString(), portalUserData.get("PORTAL_USER_ID").toString());
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("LST_CHG_BY_DTTM").toString().substring(0, 10), currDateDB.get("CURRENT_DATE").toString());
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("RTE_TRNS_NBR").toString(), optumPaySolndata.get("RTE_TRNS_NBR"));
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("BANK_ACCT_NBR").toString(), optumPaySolndata.get("BANK_ACCT_NBR"));
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("ACCT_TYP_ID").toString(), ACCT_TYP_ID);
                Helper.compareEquals(testConfig, "DEBIT_FEE_INVC List", updatedDebitFee.get(i).get("PAYMENT_TYPE").toString(), "AO");
            }
        } catch (Exception e) {
            Log.Comment("Exception occured as :" + " " + e);
        }
    }

    public void verifyPayNowButtonForRefundInvoice() throws IOException {
        testConfig.getRunTimeProperty("tin");
        Map<String, String> invoiceTableData = DataBase.executeSelectQuery(testConfig, QUERY.INVOICE_SEARCH_REFUND, 1);

        for (int i = 0; i < tableInvoiceNumberUI.size(); i++) {

            if (tableInvoiceNumberUI.get(i).getText().equalsIgnoreCase(invoiceTableData.get("INVC_NBR").toString())) {
                if (tableInvoicePayNowButtonUI.get(i).findElement(By.cssSelector("input")).getAttribute("value").equals("Pay Now"))
                    Log.Pass("correct button Text");
                else
                    Log.Fail("invalid text");

                Element.click(tableInvoicePayNowButtonUI.get(i).findElement(By.cssSelector("input")), "clicking pay now button");
                Element.verifyElementNotPresent(popUpACHPaymentModal, "ACH PAYMENT MODAL");
            }
        }
    }

    public void verifyWavieButtonOptions() {
        Helper.compareEquals(testConfig, "Waive Fees", true, wavieBtn.isDisplayed());
        Element.click(wavieBtn, "Waive Fees");
        Helper.compareEquals(testConfig, "Waive Total Amount Radio Button Checked", true, preselRadioBtn.isSelected());
        Helper.compareEquals(testConfig, "Waive Total Amount Radio Button Checked", false, partialRadioBtn.isSelected());
        Helper.compareEquals(testConfig, "Wavie Fee with Asterisk", "* Waived fees", asttext.getText().trim());
        Select drpdwn = new Select(testConfig.driver.findElement(By.xpath("//select[@id='waiveFeeReason']")));
        List<WebElement> options = drpdwn.getOptions();
        int size = options.size();
        List<String> opts = new ArrayList<>();
        List<String> optsUI = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String optionsUI = options.get(i).getText();
            optsUI.add(optionsUI);
            optsUI.addAll(opts);
        }

        ArrayList<String> optsDB = new ArrayList<String>(
                Arrays.asList("Select reason", "UHC Requested, Provider Meets Criteria for Large Volume", "Other"));


        Helper.compareEquals(testConfig, "Wavie Dropdown Options", optsDB.toString().trim(), optsUI.toString().trim());
        Helper.compareEquals(testConfig, "waive modal text", TestBase.contentMessages.getProperty("prov.admin.premium.ao.waiveFeeModalOptumPaySolutions.pageText1") + "" + "$" + testConfig.getRunTimeProperty("DBT_FEE_ACCRD_AMT") + TestBase.contentMessages.getProperty("prov.admin.premium.ao.waiveFeeModalOptumPaySolutions.pageText2").trim(), txtModalWaiveFee.getText().trim());
        Helper.compareEquals(testConfig, "Wavie Cancel Button Enabled", true, wavieCancelBtn.isEnabled());
        Helper.compareEquals(testConfig, "Wavie Cntinue Button Disabled", false, wavieContBtn.isEnabled());
    }


    public void verifyWaivedfeespending(String searchCriteria) {

        if (searchCriteria.equalsIgnoreCase("ZERO_DEBIT_FEE")) {
            Helper.compareEquals(testConfig, "Waive Fees", false, wavieBtn.isEnabled());
            Helper.compareEquals(testConfig, "Text", "Waived fees pending", waviefeependng.getText());
        } else {
            Helper.compareEquals(testConfig, "Waive Fees", true, wavieBtn.isEnabled());
        }

    }


    public void verifyDebitFeeAdj(String searchCriteria) {
        System.getProperty("tin");


        if (searchCriteria.equalsIgnoreCase("ZERO_DEBIT_FEE")) {
            int update = DataBase.executeUpdateQuery(testConfig, QUERY.UPDATED_DEBIT_FEE_ADJ);
        } else {
            int update = DataBase.executeUpdateQuery(testConfig, QUERY.UPD_DEBIT_FEE_ADJ_NEG1);
        }

    }

    public void verifyAndClickWaiveFee() {
        String accruedFeeMonthValue = "";
        if (System.getProperty("Application").contains("UPA"))
            accruedFeeMonthValue = feeTileUPA.getText().split(":")[1].trim().split("\n")[0].substring(1);
        else
            accruedFeeMonthValue = feeTile.getText().split(":")[1].trim().split("\n")[0].substring(1);


        float accruedFee = Float.valueOf(accruedFeeMonthValue);
        if (accruedFee > 0.00) {
        	
            Element.click(waiveFeeButton, "Waive Fee Button");
            
        }

    }

    public void verifyAccruedFeeAndCheckWaiveFeeButton() {
        String accruedFeeMonthValue = "";
        if (System.getProperty("Application").contains("UPA"))
            accruedFeeMonthValue = feeTileUPA.getText().split(":")[1].trim().split("\n")[0].substring(1);
        else
            accruedFeeMonthValue = feeTile.getText().split(":")[1].trim().split("\n")[0].substring(1);


        Helper.compareEquals(testConfig, "Accrued Fees month to date", accruedFeeMonthValue.trim(), "0.00");


    }

    public void clickCancelButton() {
        Element.click(cancelButton, "Cancel Button");
    }

    public void selectWaivedFeeReason(String reason) {
        Element.selectByVisibleText(waivedFeeReason, reason, "reason for waived fee");
        Element.click(continueButton, "Continue");
    }

    public void confirmAndProceedWaiveFee() {
        Element.click(confirmButton, "Confirm Button");
    }

    public void verifyWaiveFeePending() {
        String waiveFeePendingMsg = waivedFeePending.getText().trim();
        Helper.compareEquals(testConfig, "Waive Fee Pending", waiveFeePendingMsg, "Waived fees pending");
    }

    public void verifyWaiveFeesButtonDisabled() {
        Element.verifyElementNotEnabled(waiveFeeButton, "Waive Fee Button");
    }

    public void accruedFeeIsAboveZero() {
        testConfig.getDriver().manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
        String amount = Element.findElement(testConfig, "xpath", "(//div[@class='mb-4'])[1]").getText();
        amount = amount.substring(amount.indexOf("$") + 1);
        double amountValue = Double.parseDouble(amount);
        Assert.assertTrue(amountValue > 0, "Failed: Fee is not greater than zero");
        Log.Comment("============>>>>Amount is above Zero Verification PASSED!!!. Amount is: $" + amountValue);

    }

    public void waiveFullFeeIsNotInProgress() {
        //code might be needed for future reference.
//		 List<WebElement> pendingFeeMessageElements = testConfig.getDriver().findElements(By.xpath("//div[@class='mt-2 font-grey-italic' and contains(.,'Waived fees pending')]"));
//		 Assert.assertTrue(pendingFeeMessageElements.isEmpty(), "Pending fees are in process. Acceptance criteria is not met!!!");
        Element.verifyElementNotPresent(waiveFeesInProgressMessage, "Pending Fee Waive Request Message");
    }

    public void waiveFeeButtonVisibility() {
        Element.verifyElementIsEnabled(wavieBtn, "Waive Fee Button");
        Element.verifyElementPresent(wavieBtn, "Waive Fee Button");
    }


    public void accruedFeeIsZero() {
        testConfig.getDriver().manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
        String amount = Element.findElement(testConfig, "xpath", "(//div[@class='mb-4'])[1]").getText();
        amount = amount.substring(amount.indexOf("$") + 1);
        double amountValue = Double.parseDouble(amount);
        Assert.assertTrue(amountValue == 0, "Failed: Fee is not greater than zero");
        Log.Comment("============>>>>Amount is Zero Verification PASSED!!!. Amount is: $" + amountValue);
    }

    public void waiveFeeButtonClick() {
        Element.click(wavieBtn,"Waive Fee Button");
    }

    public void partialDisabledAndFullSelectedAndOptionsGivenAndFullAmountShownVerifier() {
        Element.verifyElementIsChecked(preselRadioBtn,"Waive total amount radio button");
        Element.verifyElementNotEnabled(partialRadioBtn,"Waive partial amount radio button");
        String amountStr = totAmtWavie.getText();
        String amountStr2 = txtModalWaiveFee.getText();
        amountStr = amountStr.substring(amountStr.indexOf("$") +1 , amountStr.indexOf("$") +5);
        amountStr2 = amountStr2.substring(amountStr2.indexOf("$") +1 , amountStr2.indexOf("$") +5);
        Helper.compareEquals(testConfig,"amounts in messages", amountStr,amountStr2);
        ArrayList<String> dropdownOptionsActual = (ArrayList)Element.getAllOptionsInSelect(testConfig,waiveFeeReasonDropdown);
        ArrayList<String> dropdownOptionsExpected = new ArrayList<>(Arrays.asList("Select reason",  "UHC Requested",               "Provider Meets Criteria for Large Volume" ,"Other" ));
        Helper.compareEquals(testConfig,"Dropdown options: Expected Vs Actual", dropdownOptionsExpected,dropdownOptionsActual);
        Element.verifyElementIsEnabled(cancelButton,"Cancel Button");
        Element.verifyElementNotEnabled(continueButton,"Continue Button");
    }
    
    //Piyush
    public void verifyWaiveFee() {

		Element.verifyElementPresent(waiveFeeButton, "Select Option to waive fees window is closed, waive Fee Button is present");
			//Element.click(waiveFeeButton, "Waive Fee Button");
	//	}

	}

	//Piyush
	public void verifyWaiveFeesWindow() {


		//Element.verifyElementNotEnabled(waiveFeeButton, "Waive Fee Button");
		Element.verifyElementPresent(SelectOptionWaiveFeesPage, "Select option to waive fees");
		List<String> options = Element.getAllOptionsInSelect(testConfig, waivedFeeReason);
		/*for(String option : options)
		{
			System.out.println(option); 
		}*/

	}


	//Piyush
		public void ClickonHomeLink() {

	Element.click(testConfig, lnkHome, "Home", 3);
		}
	//Piyush
	public void VerifyWaivefullAndPartialAmount() {

		String TotalAmount;
		TotalAmount = Element.GetTextPresent(TotalAmountText,"Total Amount Text");
		TotalAmount = TotalAmount.substring(15);
		Helper.compareEquals(testConfig, "Total for Waive Full amount which is sum of processed and settled amount from OLE.DEBIT_FEE_ACCRD table", testConfig.getRunTimeProperty("Total_Full_DBT_Fee"), TotalAmount);

		Element.click(partialRadioBtn, "Waive Partial Radio button");

		TotalAmount = Element.GetTextPresent(TotalAmountText,"Total Amount Text");
		TotalAmount = TotalAmount.substring(15);
		Helper.compareEquals(testConfig, "Total for Waive Partail amount which is Settled amount from OLE.DEBIT_FEE_ACCRD table", testConfig.getRunTimeProperty("Total_Partial_DBT_Fee"), TotalAmount);	

		}
	//Piyush
	public void FetchProviderTINWaivePartialWaiveTotalFromDB()
	{
		String query = QUERY.WAIVE_PARTIAL_AMOUNT;
			Map tinNumbers = null;
			tinNumbers = DataBase.executeSelectQuery(testConfig, query, 1);
			try {
				Log.Comment("Tin retreived from query for " + tinNumbers.get("PROV_TIN_NBR").toString());
				testConfig.putRunTimeProperty("tin", tinNumbers.get("PROV_TIN_NBR").toString());
				testConfig.putRunTimeProperty("Total_Partial_DBT_Fee", tinNumbers.get("TOTAL_PARTIAL_DBT_FEE").toString());
				}
			catch (Exception e) {
				testConfig.putRunTimeProperty("AlreadyFailed", "yes");
				Log.FailWarning("No tin with payments from the above query, please execute the test case manually",
						testConfig);
			}
			String Full_query = QUERY.WAIVE_FULL_AMOUNT;
			Full_query = Full_query.replace("$ReplaceTINNumber$", testConfig.getRunTimeProperty("tin"));

			Map<String, String> FulltinNumbers = DataBase.executeSelectQuery(testConfig, Full_query, 1);
			try {
				Log.Comment("Tin retreived from query for " + FulltinNumbers.get("PROV_TIN_NBR").toString());
				testConfig.putRunTimeProperty("tin", FulltinNumbers.get("PROV_TIN_NBR").toString());
				testConfig.putRunTimeProperty("Total_Full_DBT_Fee", FulltinNumbers.get("TOTAL_FULL_DBT_FEE").toString());
				}
			catch (Exception e) {
				testConfig.putRunTimeProperty("AlreadyFailed", "yes");
				Log.FailWarning("No tin with payments from the above query, please execute the test case manually",
						testConfig);
			}

}

	//Piyush
	public void verifySelectDropdownOptions(String reason) {


		
		List<String> options = Element.getAllOptionsInSelect(testConfig, waivedFeeReason);
		for(String option : options)
		{
			if(!(option.contains("Select reason")))
			Helper.compareContains(testConfig, "Reason Drop down option", option,reason);
		}

	}
	
	//Piyush
	public void selectWaivedFeeReasonOnly(String reason) {
		Element.selectByVisibleText(waivedFeeReason, reason, "reason for waived fee: "+reason);

	}

	//Piyush
		public void VerifySelectOptionreasonText() {
			Map objAttribute;
			Element.verifyElementPresent(SelectOptionreasonText, "Select Option reason Text for Other reason");
			objAttribute = Element.getAllAttributes(testConfig, SelectOptionreasonText, "Select Option reason Text for Other reason");
			String strDefault = (String) objAttribute.get("placeholder");
			if(strDefault !=null) {				
				Helper.compareEquals(testConfig, "Static Message for reason", "Max 150 characters", strDefault);
			}

			//Max 150 characters
		}

		//Piyush
		public void VerifyPositiveScenarioForMessage(String ReasonText) {
			int intStringLength = ReasonText.length();
			Element.verifyElementPresent(SelectOptionreasonText, "Reason Text for Other option");
			Element.verifyElementPresent(ThisIsRequiredFieldErrorMessage, "This Is Required Field Error Message is present before entering data");
			Element.enterData(SelectOptionreasonText, ReasonText, "Enter reason text in other option", "Reason Text for Other option of length "+intStringLength);

			Element.verifyElementNotPresent(ThisIsRequiredFieldErrorMessage, "This Is Required Field Error Message is not present after entering data");

		}

		//Piyush
		public void VerifyNegativeScenarioForMessage(String ReasonText) {
			int intStringLength = ReasonText.length();
			Element.verifyElementPresent(SelectOptionreasonText, "Reason Text for Other option");
			Element.verifyElementNotPresent(MaximumCharacterLimitIs150ErrorMessage, "Maximum Character limit is 150 is not present before entering message of length "+intStringLength);

			Element.enterData(SelectOptionreasonText, ReasonText, "Enter reason text in other option", "Reason Text for Other option of length "+intStringLength);

			Element.verifyElementPresent(MaximumCharacterLimitIs150ErrorMessage, "Maximum Character limit is 150 is appeared after entering message of length "+intStringLength);

		}


		//Piyush
		public void VerifyContinueEnable()
		{
			Element.click(waivedFeeReason, "Reason Drop down");
			Helper.compareEquals(testConfig, "Waive Continue Button is enabled", true, wavieContBtn.isEnabled());
		}

		//piyush
		public void SelectWaivePartailAmount()
		{
			Element.click(partialRadioBtn, "Waive Partial Radio button");

		}
		//piyush
		public void VerifyEnterPartialDollarAmount(){
			Element.verifyElementPresent(EnterPartialAmountText, "Enter Partial Amount Text Box");
		}
		//Piyush
		public void EnterPartialAmount(String ErrorMessage_Expacted,String ScenarioType)
		{
			String TotalAmount;
			TotalAmount = Element.GetTextPresent(TotalAmountText,"Total Amount Text");
			TotalAmount = TotalAmount.substring(15);
			double dblTotalAmount = Double.parseDouble(TotalAmount);


			if(ScenarioType.equalsIgnoreCase("PositiveMessage"))
			{
				dblTotalAmount = dblTotalAmount/2;
				String ValueToEnter = String.valueOf(dblTotalAmount);
				Element.enterData(EnterPartialAmountText, ValueToEnter, "Enter data" + ValueToEnter + "in Partial Amount Text Box", "Partial Amount Text Box");
				String ErrorMessage = Element.GetTextPresent(PartialAmountErrorMessage,"Partial Amount Error Message");

				if(ErrorMessage.equalsIgnoreCase("")) {
					Log.Pass("No error message for Valid amount", ErrorMessage, ErrorMessage);
				}
				else {
					Log.Fail("Received unexpected error message for valid amount", ErrorMessage, ErrorMessage);
				}
			}	
			else if(ScenarioType.equalsIgnoreCase("NegativeMessage")) {
				dblTotalAmount = dblTotalAmount+10;
				String ValueToEnter = String.valueOf(dblTotalAmount);
				Element.enterData(EnterPartialAmountText, ValueToEnter, "Enter data" + ValueToEnter + "in Partial Amount Text Box", "Partial Amount Text Box");
				String ErrorMessage = Element.GetTextPresent(PartialAmountErrorMessage,"Partial Amount Error Message");

			if(ErrorMessage.equalsIgnoreCase(ErrorMessage_Expacted)) {
				Log.Pass("Received expected error message for excceding amount", ErrorMessage, ErrorMessage);
			}
			else {
				Log.Fail("Did not Received expected error message for excceding amount", ErrorMessage, ErrorMessage);
			}
			}else if(ScenarioType.equalsIgnoreCase("NegativeValue"))
			{
				Element.enterData(EnterPartialAmountText, "-1", "Enter data" + "-1" + "in Partial Amount Text Box", "Partial Amount Text Box");
				String ErrorMessage = Element.GetTextPresent(PartialAmountErrorMessage,"Partial Amount Error Message");

				Helper.compareContains(testConfig, "Expected error message for excceding amount", ErrorMessage_Expacted, ErrorMessage);

			
			Element.enterData(EnterPartialAmountText, "0", "Enter data" + "0" + "in Partial Amount Text Box", "Partial Amount Text Box");
			ErrorMessage = Element.GetTextPresent(PartialAmountErrorMessage,"Partial Amount Error Message");

			Helper.compareContains(testConfig, "Expected error message for excceding amount", ErrorMessage_Expacted, ErrorMessage);
			
			}


		}



}

