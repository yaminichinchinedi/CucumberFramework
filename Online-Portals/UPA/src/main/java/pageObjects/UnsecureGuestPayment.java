package main.java.pageObjects;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;
import main.java.reporting.Log;
import org.apache.xmlbeans.impl.store.Query;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static main.java.Utils.DataBase.DatabaseType.Stage2;

public class UnsecureGuestPayment {

    @FindBy(xpath = "//a[.='Pay an invoice now']")
    WebElement PayInvoiceNowButton;

    @FindBy(xpath = "//*[@placeholder= 'Enter last four digits (2465)']")
    WebElement EnterLast4TinInput;

    @FindBy(id = "invoiceNbr")
    WebElement invoiceNumber;
    
    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;
    
    @FindBy(xpath = "//span[contains(@class,'tinNumberText')]")
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

    private TestBase testConfig;
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
         Element.enterData(invoiceNumber, InvoiceNumber, "InvoiceNumber", "invoiceNumberInput" );
         Element.fluentWait(testConfig,Continue,100, 1, "Continue Button");
         Element.click(Continue, "Continue Button");

    }
    
    public void enterNameAndEmail() {
          String randomFirstName=Helper.generateRandomAlphabetsString(8);
          String randomlastName=Helper.generateRandomAlphabetsString(6);
          String randomEmail=randomFirstName+"@optum.com";
    	 Element.enterData(firstName,randomFirstName, "FirstName", "FirstName");
    	 Element.enterData(lastName,randomlastName, "LastName", "LastName");
    	 Element.enterData(email,randomEmail, "Email", "Email");
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
    	Helper.compareEquals(testConfig, "Tin Number", expTin.substring(expTin.length()-4), actTin);
    	Helper.compareEquals(testConfig, "Organization", providerInfo.get("ORG_NM").toString(), actOrgName);
    	Helper.compareEquals(testConfig, "Invoice", providerInfo.get("INVC_NBR").toString(), actInvoice);
    	Helper.compareEquals(testConfig, "Invoice Amount", expInvoiceAmnt, actInvoiceAmount);
    	
    }
}
