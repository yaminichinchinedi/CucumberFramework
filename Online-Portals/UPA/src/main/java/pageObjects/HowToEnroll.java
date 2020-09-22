package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class HowToEnroll {
	
	@FindBy(xpath="//h1[contains(text(),'How to Enroll')]")
	WebElement textHowToEnroll;	
	
	@FindBy(xpath=".//*[@id='signInForm']/article/a/span[2]")
	private WebElement dwnldEPSInstructions;
	
	@FindBy(xpath=".//*[@id='signInForm']/article/div/a")
	private WebElement enrollNowBtn;
	
	@FindBy(css="a.white-header__logo.latest--optumbank-logo")
	private WebElement lnkOptumLogo;
	
	@FindBy(id="copyright")
	private WebElement footerText;
	
	@FindBy(linkText="Download ACH/Direct Deposit Enrollment Guide")
	private WebElement downloadACHDirect;
	
	@FindBy(linkText="Download Billing Service Enrollment Guide")
	private WebElement downloadBillingService;
	
	@FindBy(tagName = "strong")
	WebElement openingParagraphText;
	
	@FindBy(xpath="//p[contains(text(),'Contact information for your designated Optum Pay contacts')]")
	WebElement thirdCheckText;
	
	@FindBy(xpath="//body//p[3]")
	WebElement firstParagraphAfterLastCheckMark;
	
	@FindBy(xpath="//body//p[5]")
	WebElement secondParagraphAfterLastCheckMark;
	
	@FindBy(xpath="//body//p[8]")
	WebElement thirdParagraphAfterLastCheckMark;
	
	@FindBy(xpath="//body//p[11]")
	WebElement fourthParagraphAfterLastCheckMark;
	
	private TestBase testConfig;
	
	public HowToEnroll(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expectedURL="HowToEnroll.do";
		Browser.verifyURL(testConfig, expectedURL);
		
		Element.expectedWait(textHowToEnroll, testConfig, "How to Enroll", "How to Enroll");
	}
	
	public BeginEnrollment validateEnrollNowBtn() {
		Element.click(enrollNowBtn, "Enroll Now Button");
		return new BeginEnrollment(testConfig);
	}

	public void verifyOptumLogo()
	{
		Element.verifyElementPresent(lnkOptumLogo,"Optum Logo at header");
	}
	
	public void verifyFooter()
	
	{
		Helper.compareEquals(testConfig, "Footer Text", footerText.getText(), "2020 Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC");
	}
	
	public void verifyHowToEnrollHeader()
	
	{
		Helper.compareEquals(testConfig, "How To Enroll Text", textHowToEnroll.getText(), "How to Enroll");
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
	
	public void verifyEnrollmentInstructions()
	
	{
		Helper.compareEquals(testConfig, "Download ACH/Direct Deposit Enrollment Guide Text", downloadACHDirect.getText(), "Download ACH/Direct Deposit Enrollment Guide");
		Helper.compareEquals(testConfig, "Download Billing Service Enrollment Guide Text", downloadBillingService.getText(), "Download Billing Service Enrollment Guide");
	}
	
	public void verifyHowToEnrollPage() {
		this.verifyOptumLogo();
		this.verifyFooter();
		this.verifyHowToEnrollHeader();
		this.verifyOptumPayText(openingParagraphText);
		this.verifyOptumPayText(thirdCheckText);
		this.verifyOptumPayText(firstParagraphAfterLastCheckMark);
		this.verifyOptumPayText(secondParagraphAfterLastCheckMark);
		this.verifyOptumPayText(thirdParagraphAfterLastCheckMark);
		this.verifyOptumPayText(fourthParagraphAfterLastCheckMark);
		this.verifyEnrollmentInstructions();
	}
}
