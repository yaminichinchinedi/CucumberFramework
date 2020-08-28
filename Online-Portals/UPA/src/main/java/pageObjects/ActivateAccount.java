package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class ActivateAccount {

	@FindBy(xpath = "//*[contains(text(),'activate your account')]")
	WebElement activateAccountHeader;

	@FindBy(xpath = "//p[contains(text(),'Welcome to Optum Pay! Help us answer a few short questions to get you started.')]")
	WebElement welcomeHeader;

	@FindBy(xpath = "//strong[contains(text(),'First things first, is your organization enrolled')]")
	WebElement firstthingsHeader;

	@FindBy(xpath = "//*[contains(text(),'my organization is already enrolled')]")
	WebElement yesEnrolledHeader;

	@FindBy(xpath = "//*[contains(text(),'I need to enroll my organization')]")
	WebElement notEnrolledHeader;

	@FindBy(xpath = "//strong[contains(text(),'Next, do you have an active Optum Pay username and')]")
	WebElement nextdoyouhaveanactiveCredentialsHeader;

	@FindBy(xpath = "//*[contains(text(),'I have my active Optum Pay username')]")
	WebElement yesicredentialsHeader;

	@FindBy(xpath = "//*[contains(text(),'I do not have an active Optum Pay')]")
	WebElement nocredentialsHeader;

	@FindBy(id = "changemyanswer2")
	WebElement changemyanswerCredentials;

	@FindBy(id = "changemyanswer1")
	WebElement changemyanswerEnrollment;

	@FindBy(xpath = "//strong[contains(text(),'Take a minute to connect your Optum Pay account wi')]")
	WebElement takeaMinuteHeader;

	@FindBy(linkText = "Benefits of Optum Pay.")
	WebElement benefitsofOptumPay;

	@FindBy(linkText = "Need Help?")
	WebElement needHelp;

	@FindBy(xpath = "//*[contains(text(),'Username']")
	WebElement usernameElement;
	
	@FindBy(xpath = "//*[contains(text(),'Password']")
	WebElement pwdElement;
	
	@FindBy(xpath = "//a[contains(text(),'Close')]")
	WebElement close;
	
	@FindBy(xpath = "//h4[contains(text(),'We are here to help')]")
	WebElement weareheretohelp;
	
	@FindBy(xpath = "//h1[contains(text(),'Benefits of Optum Pay')]")
	WebElement benefitsofOptumPayHeader;
	
	@FindBy(xpath = "//p[@class='latest_activation-header__logo-all latest--optumbank-logo-all']")
	WebElement optumGlobalHeader;
	
	String optum_pay = "Optum Pay";	
	


	private TestBase testConfig;


	public ActivateAccount(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		}


	public void verifyActivateAccountLandingPage() throws Exception {

		Element.verifyElementPresent(activateAccountHeader, "Activate Account Header");

	}
	
	public void verifyOptumPayText(WebElement ele) {
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
		

	public void verifyWelcomeHeader() throws Exception {
		Element.verifyElementPresent(welcomeHeader, "Welcome Header");
		this.verifyOptumPayText(welcomeHeader);	
	}

	public void verifyFirstThingFirstMessage() throws Exception {

		Element.verifyElementPresent(firstthingsHeader, "First Things first message");
		this.verifyOptumPayText(firstthingsHeader);	
	}

	public void verifyYesMyOrgIsEnrolled() throws Exception {

		Element.verifyElementPresent(yesEnrolledHeader, "Yes, Enrolled message");

	}

	public void verifyNoINeedToEnroll() throws Exception {

		Element.verifyElementPresent(notEnrolledHeader, "No, I need to enroll header");

	}

	public void clickINeedToEnroll() throws Exception {

		Element.click(notEnrolledHeader, "No, I need to enroll header");

	}

	public void clickYesMyOrgIsEnrolled() throws Exception {

		Element.click(yesEnrolledHeader, "Yes, Enrolled header");

	}

	public void verifyIhaveActiveOPtumCredentials() throws Exception {

		Element.verifyElementPresent(nextdoyouhaveanactiveCredentialsHeader, "DO you have active credentials..");
		this.verifyOptumPayText(nextdoyouhaveanactiveCredentialsHeader);
		Element.verifyElementPresent(yesicredentialsHeader, "Yes I have credentials...");
		this.verifyOptumPayText(yesicredentialsHeader);
	}

	public void clickYesIHaveCredentials() {

		Element.click(yesicredentialsHeader, "Yes, I have credentials.");

	}

	public void verifyNoActiveOptumAcc() {
		Element.verifyElementPresent(nocredentialsHeader, "No  I do not have credentials...");
		this.verifyOptumPayText(nocredentialsHeader);
	}

	public void verifyTakeAMinuteToConnect() {
		Element.verifyElementPresent(takeaMinuteHeader,
				"Take a minute to connect your Optum Pay account with Optum ID");
		this.verifyOptumPayText(takeaMinuteHeader);

	}

	public void verifyAbsenseOfUsernamePassword() {
		Element.verifyElementNotPresent(usernameElement, "Username field");
		Element.verifyElementNotPresent(pwdElement, "Password field");

	}

	public void userNavigatesToMainScreen() {
		Element.click(changemyanswerEnrollment, "Change my Answer 1");

	}

	public void verifyOptumPayBenefitsLink() {
		Element.verifyElementPresent(benefitsofOptumPay, "Optum Pay benefits text");

	}

	public void clickNeedHelp() {
		Element.click(needHelp, "Need Help");

	}

	public void verifyHelpText() {

		Element.verifyElementPresent(weareheretohelp, "We are here to help Header");
		Element.click(close, "Close pop up");

	}

	public void clickOptumPayBenefitsLink() {
		Element.click(benefitsofOptumPay, "Optum Pay benefits text");
		
	}

	public void verifyBenefitsPage() {
		Element.verifyElementPresent(benefitsofOptumPayHeader, "Benefits of Optum Pay Header");
	}
	
	public void verifyOptumGlobalHeader() {
		Element.verifyElementPresent(optumGlobalHeader, "Optum Global Header");
	}

}