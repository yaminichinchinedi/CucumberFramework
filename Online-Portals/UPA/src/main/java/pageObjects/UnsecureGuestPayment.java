package main.java.pageObjects;

import main.java.Utils.DataBase;
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
}
