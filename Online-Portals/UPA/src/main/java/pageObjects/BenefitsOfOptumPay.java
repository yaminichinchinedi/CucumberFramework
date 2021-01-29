package main.java.pageObjects;

 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

 

public class BenefitsOfOptumPay {
    
    @FindBy(xpath="//h1[contains(text(),'Benefits of Optum Pay')]")
    private WebElement textBenefitsOfOptumPay;
    
    @FindBy(linkText="Payment Savings Calculator")
    private WebElement lnkPaymentSavingsCalc;
    
    @FindBy(css="a.white-header__logo.latest--optumbank-logo")
    private WebElement lnkOptumLogo;
    
    @FindBy(xpath="//p[@class='copyrights copyright__text']/span")
    private WebElement footerText;
    
    @FindBy(xpath = "//b[contains(text(),'Optum Pay Savings Calculator')]")
    WebElement optumPaySavingsCalculatorHeader;
    
    @FindBy(xpath = "(//body//article//p[1])[1]")
    WebElement openingParagraphText;
    
    @FindBy(xpath = "(//body//article//p[1])[2]")
    WebElement greenTick1ParagraphText;
    
    @FindBy(xpath = "(//body//article//p[1])[3]")
    WebElement greenTick2ParagraphText;
    
    @FindBy(xpath = "(//body//article//p[1])[4]")
    WebElement greenTick3ParagraphText;
    
    @FindBy(xpath = "(//body//article//p[1])[5]")
    WebElement accessCanBeRestirctedParagraphText;
    
    @FindBy(xpath = "(//h2[@class='font-weight-bold'])[2]")
    WebElement weAreOnlyACallAway;
    
    @FindBy(xpath = "//p[contains(text(),'The Optum Pay service is all online - from enrollment, to managing your account, to setting up users, along with access to all of your claims and payment data via a secure, easy to access website.')]")
    WebElement secondParagraphText;
    
    @FindBy(xpath = "//body//article//p[3]")
    WebElement paragraphBelowClockText;
    
    @FindBy(xpath = "//p[contains(text(),'We know you will be satisfied too. Enroll your organization today to take advantage of all the benefits that Optum Pay can bring to your organization.')]")
    WebElement lastParagraphText;
    
    private TestBase testConfig;
    
    public BenefitsOfOptumPay(TestBase testConfig) {
        this.testConfig = testConfig;
        PageFactory.initElements(testConfig.driver, this);
        String expectedURL="benefitofeps.do";
        
        Element.expectedWait(textBenefitsOfOptumPay, testConfig, "Benefits of Optum Pay", "Benefits of Optum Pay");
        Browser.verifyURL(testConfig, expectedURL);
        //Element.verifyElementPresent(lnkPaymentSavingsCalc, "Payment Saving Calculator");        
    }
    
    public void verifyOptumPayText(WebElement ele) {
        String optum_pay = "Claim payments can be complicated and challenging. Optum Pay simplifies the process — and your workflow — by offering multiple options for electronic claim payments. In addition, we provide the tools needed to receive, reconcile and manage claim payment and remittance data. We take efficiency to the next level.";    
        
        
        String text = ele.getText();
        if (text.contains(optum_pay))
        {
        Log.Pass(ele + " " +"contains text" + " " + optum_pay);
        }
        else
        {
        Log.Fail(ele + " " + "does not contains text" + " " + optum_pay);
        }
        }
        
    
    public void verifyOptumLogo()
    {
        Element.verifyElementPresent(lnkOptumLogo,"Optum Logo at header");
    }
    
    public void verifyFooter()
    
    {
        Helper.compareEquals(testConfig, "Footer Text", footerText.getText(), "Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC");
    }
    
    public void verifyBenefitsofOptumPayHeader()
    
    {
        Helper.compareEquals(testConfig, "Benefits of Optum Pay Text", textBenefitsOfOptumPay.getText(), "Benefits of Optum PayTM");
    }
    
    public void clickAndVerifyOptumPaySavingsCalculator()
    {
        Element.click(lnkPaymentSavingsCalc,"Calculate My Savings");
        Helper.compareEquals(testConfig, "Optum Pay Savings Calculator Text", optumPaySavingsCalculatorHeader.getText(), "Optum Pay Savings Calculator");

 

    }
    
    public BenefitsOfOptumPay verifyBenefitsOfOptumPayPage() {
        
        //this.verifyOptumLogo();
        //this.verifyFooter();
        //this.verifyBenefitsofOptumPayHeader();
        this.verifyOptumPayText(openingParagraphText);
        //this.verifyOptumPayText(secondParagraphText);
        //this.verifyOptumPayText(paragraphBelowClockText);
        //this.verifyOptumPayText(lastParagraphText);
        //this.clickAndVerifyOptumPaySavingsCalculator();
        return new BenefitsOfOptumPay(testConfig);
    }
    
    
    public void verifyGreenTickMark1Paragraph(int paraNum)
    {

 

        WebElement ele = null;
        String paraText = null;
        
        
        switch (paraNum)
        {
        case 1:
        {
            ele = greenTick1ParagraphText;
            paraText = "You select the payment method that best meets the needs of your practice - either ACH/direct deposit";
            break;
        }
        case 2:
        {
            ele = greenTick2ParagraphText;
            paraText = "Payments made using ACH/direct deposit are deposited directly into your designated bank account.";
            break;
        }
        
        case 3:
        {
            ele = greenTick3ParagraphText;
            paraText = "VCP payments are loaded onto a virtual card and are processed by you using your point of sale credit card terminal, like the way patient co-pays would be processed.";
            break;
        }
        
        }
        
        
        String text = ele.getText();
        if (text.contains(paraText))
        {
        Log.Pass(ele + " " +"contains text" + " " + paraText);
        }
        else
        {
        Log.Fail(ele + " " + "does not contains text" + " " + paraText);
        }
        
    }
    
    
    public void verifyparagraphTextOnOptumPayPage(String paraName)
    {
        
        WebElement ele = null;
        String paraText = null;
        
        
        switch (paraName)
        {
        case "Access can be restricted":
        {
            ele = accessCanBeRestirctedParagraphText;
            paraText = "You can set the level of access to payment and claims information for each individual on your staff. This lets you restrict access to sensitive banking information while allowing staff to reconcile claims payments and initiate patient billing.";
            break;
        }
        
        
        case "We are only a call away":
        {
            ele = weAreOnlyACallAway;
            paraText = "We're only a call away";
            break;
        }
        
        }
    }
}