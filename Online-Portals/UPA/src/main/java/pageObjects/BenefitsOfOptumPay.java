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
	
	@FindBy(id="copyright")
	private WebElement footerText;
	
	@FindBy(xpath = "//b[contains(text(),'Optum Pay Savings Calculator')]")
	WebElement optumPaySavingsCalculatorHeader;
	
	@FindBy(xpath = "//body//article//p[1]")
	WebElement openingParagraphText;
	
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
		Element.verifyElementPresent(lnkPaymentSavingsCalc, "Payment Saving Calculator");		
	}
	
	public void verifyOptumPayText(WebElement ele) {
		String optum_pay = "Optum Pay";	
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
		Helper.compareEquals(testConfig, "Footer Text", footerText.getText(), "2020 Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC");
	}
	
	public void verifyBenefitsofOptumPayHeader()
	
	{
		Helper.compareEquals(testConfig, "Benefits of Optum Pay Text", textBenefitsOfOptumPay.getText(), "Benefits of Optum Pay");
	}
	
	public void clickAndVerifyOptumPaySavingsCalculator()
	{
		Element.click(lnkPaymentSavingsCalc,"Calculate My Savings");
		Helper.compareEquals(testConfig, "Optum Pay Savings Calculator Text", optumPaySavingsCalculatorHeader.getText(), "Optum Pay Savings Calculator");

	}
	
	public BenefitsOfOptumPay verifyBenefitsOfOptumPayPage() {
		
		this.verifyOptumLogo();
		this.verifyFooter();
		this.verifyBenefitsofOptumPayHeader();
		this.verifyOptumPayText(openingParagraphText);
		this.verifyOptumPayText(secondParagraphText);
		this.verifyOptumPayText(paragraphBelowClockText);
		this.verifyOptumPayText(lastParagraphText);
		this.clickAndVerifyOptumPaySavingsCalculator();
		return new BenefitsOfOptumPay(testConfig);
	}

}