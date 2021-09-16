package main.java.pageObjects;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;
import main.java.reporting.Log;
import org.apache.xmlbeans.impl.store.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static main.java.Utils.DataBase.DatabaseType.Stage2;

public class UnsecureGuestPayment {

    @FindBy(xpath = "//a[.='Pay an invoice now']")
    WebElement PayInvoiceNowButton;

    @FindBy(xpath = "//*[@placeholder= 'Enter last four digits (2465)']")
    WebElement EnterLast4TinInput;

    @FindBy(id = "invoiceNbr")
    WebElement invoiceNumber;

    @FindBy(xpath = "//*[@id='payAsGuestForm']/article/div[3]/h3")
    WebElement contactInformation;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "title")
    WebElement title;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(xpath = "//span[contains(@class,'fullTinNumberText')]")
    WebElement tinNumber;

    @FindBy(xpath = "//span[contains(@class,'organizationText')]")
    WebElement organization;
    
    @FindBy(xpath = "//span[contains(@class,'invoiceNumberText')]")
    WebElement invoice;

    @FindBy(xpath = "(//span[contains(@class,'invoiceAmountText')])[1]")
    WebElement invoiceAmount;


    @FindBy(xpath = "//*[@onclick= 'getTinAndInvoiceDataAjax()']")
    WebElement Continue;

    @FindBy(xpath = "//*[@id= 'payAsGuestForm']/article/h1")
    WebElement PayasaGuestTitle;

    //div[@class='tile tile--fancy--dark mt-5 step bankInfo']/h3
    @FindBy(xpath = "//h3[contains(.,'bank account')]")
    WebElement Step3Title;

    @FindBy(id = "refund_reason_selector")
    WebElement AccountTypeDropdown;

    @FindBy(xpath = "//span[contains(.,'Routing Number')]")
    WebElement RoutingNumberText;

    @FindBy(id = "routingNumber")
    WebElement RoutingNumberInput;

    @FindBy(xpath = "//input[@id='accountNumber']/../span")
    WebElement AccountNumberText;

    @FindBy(id = "accountNumber")
    WebElement AccountNumberInput;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement BottomCancelButton;

    @FindBy(xpath = "//button[.='Submit']")
    WebElement BottomSubmitButton;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//th[1]")
    WebElement InvoiceHeader;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//th[2]")
    WebElement BillingPeriodHeader;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//th[3]")
    WebElement AmountHeader;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//th[4]")
    WebElement TINlast4Header;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//td[1]")
    WebElement InvoiceValue;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//td[2]")
    WebElement BillingPeriodValue;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//td[3]")
    WebElement AmountValue;

    @FindBy(xpath = "(//table[@class='w-100 invoiceTable providerInfo'])[1]//td[4]")
    WebElement TINlast4Value;

    @FindBy(xpath = "//input[@name='consent']")
    WebElement consentCheckBox;

    private TestBase testConfig;
    Actions builder = new Actions (testConfig.driver);
    public UnsecureGuestPayment(TestBase testConfig) {
        this.testConfig=testConfig;
        PageFactory.initElements(testConfig.driver, this);

    }

    public void clickPayInvoiceNow() {
        Element.fluentWait(testConfig, PayInvoiceNowButton, 100, 1, "PayInvoiceNowButton");
        Element.click(PayInvoiceNowButton,"Pay an invoice now");
        System.out.println(Element.getTextPresent(PayInvoiceNowButton , "Pay an invoice now"));
    }

    public void validatePayasAGuestTitle(){
        String title = "Pay as a guest";
         Element.verifyTextPresent(PayasaGuestTitle, title);
    }

    public void enterLastFourTinandInvoiceNumberthenCLickContinue(){
         String tin = testConfig.getRunTimeProperty("tin");
         String InvoiceNumber = testConfig.getRunTimeProperty("invoiceNumber");
         String tinLast4 = tin.substring(tin.length()-4);
         Element.enterData(EnterLast4TinInput,tinLast4, "last4TinInput", "provTinNbrlast4");
         Element.enterData(invoiceNumber, InvoiceNumber, "InvoiceNumber", "invoiceNumberInput");
         builder.sendKeys(Keys.TAB).build().perform();
         Element.fluentWait(testConfig,Continue,100, 1, "Continue Button");
         Element.click(Continue, "Continue Button");

    }
    
    public void enterContactInformation() {
        String verifyStep2Title = "Step 2: Enter your contact information";
        Element.verifyTextPresent(contactInformation,verifyStep2Title);
        String randomFirstName=Helper.generateRandomAlphabetsString(8);
        String randomlastName=Helper.generateRandomAlphabetsString(6);
        String randomTitle = Helper.generateRandomAlphabetsString(60);
        long phoneNumber = Helper.generateRandomNumber(12);
        String randomEmail=randomFirstName+"@optum.com";
        Element.enterData(firstName,randomFirstName, "FirstName", "FirstName");
        Element.enterData(lastName,randomlastName, "LastName", "LastName");
        Element.enterData(email,randomEmail, "Email", "Email");
        Element.enterData(title,randomTitle, "Job title", "Job title");
        Element.enterData(phone, String.valueOf(phoneNumber),"Phone number", "Phone number");
    }
    
    public void validateProviderInformation() {
    	Map providerInfo=DataBase.executeSelectQuery(testConfig, QUERY.PROVIDER_INFO, 1);
    	String actTin=Element.getTextPresent(tinNumber, "TinNumber");
    	String actOrgName=Element.getTextPresent(organization, "Organization Name");
    	String actInvoice=Element.getTextPresent(invoice, "Invoice Number");
    	String actInvoiceAmount=Element.getTextPresent(invoiceAmount, "Invoice Amount");
    	actInvoiceAmount=actInvoiceAmount.replace("$", "");
    	actInvoiceAmount=actInvoiceAmount.replace(",", "");
    	actInvoiceAmount=String.format("%.0f",Double.valueOf(actInvoiceAmount));
    	String expTin=providerInfo.get("PROV_TIN_NBR").toString();
    	String expInvoiceAmnt=providerInfo.get("INVC_TOT_AMT").toString().replace(",", "");
    	expInvoiceAmnt=String.format("%.0f",Double.valueOf(expInvoiceAmnt));
    	Helper.compareEquals(testConfig, "Tin Number", expTin, actTin);
    	Helper.compareEquals(testConfig, "Organization", providerInfo.get("ORG_NM").toString(), actOrgName);
    	Helper.compareEquals(testConfig, "Invoice", providerInfo.get("INVC_NBR").toString(), actInvoice);
    	Helper.compareEquals(testConfig, "Invoice Amount", expInvoiceAmnt, actInvoiceAmount);
    	
    }
    public void routingAndAccountNoInserter()  {
        int rowNo = 1;
        TestDataReader data = null;
        try {
            data = testConfig.cacheTestDataReaderObject("FinancialInfo");
            List<String> ValidRoutNos = data.GetAllColumnsData("FinancialInfo", "ValidRoutingNos");
            String routingNumber = data.GetData(rowNo, "RoutingNumber");
            String accountNumber = data.GetData(rowNo, "AccountNumber");
            System.setProperty("routingNumber",routingNumber);
            System.setProperty("accountNumber",accountNumber);
            Element.fluentWait(testConfig,RoutingNumberInput,100,1,"Routing Input");
            Element.enterData(RoutingNumberInput,routingNumber,"Routing Number","Routing Number Input");
            Element.enterData(AccountNumberInput,accountNumber,"Account Number","Account number Input");
            Element.click(testConfig,Step3Title,"title",3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void userClicksOnConsent() {
        Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//input[@name='consent']"),10);
        Element.click(testConfig,consentCheckBox,"consent checkbox",3);
    }

    public void userUserClicksSubmit() {
        Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//button[.='Submit']"),10);
        Element.click(testConfig,BottomSubmitButton,"Submit Button",3);
    }
}
