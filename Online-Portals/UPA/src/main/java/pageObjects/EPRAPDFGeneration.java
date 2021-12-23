package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;

public class EPRAPDFGeneration extends ViewPayments {

	public EPRAPDFGeneration(TestBase testConfig) {
		super(testConfig);

	}

	@FindBy(xpath = "//div[@id='message1']")
	WebElement EPFAPDFGenMessage1;

	@FindBy(xpath = "//div[@id='message2']")
	WebElement EPFAPDFGenMessage2;

	@FindBy(xpath = "//b[contains(text(),'Payment Number:')]")
	WebElement PaymentNum;

	@FindBy(xpath = "//input[@class='btn-primary']")
	WebElement OKButton;

	public void EPRAPDFGenration() {

		String parentWindow = testConfig.driver.getWindowHandle();
		Browser.switchToNewWindow(testConfig);
		Browser.waitForPageLoad(TestBase.driver);

		EPFAPDFGenMessage1.getText()
				.equalsIgnoreCase(TestBase.contentMessages.getProperty("ePRApdf.generation.messagecontent1"));

		PaymentNum.getText().contains(PaymentNumber);

		Browser.wait(testConfig, 5);

		EPFAPDFGenMessage2.getText()
				.equalsIgnoreCase(TestBase.contentMessages.getProperty("ePRApdf.generation.messagecontent2"));

		PaymentNum.getText().contains(PaymentNumber);

		OKButton.isDisplayed();

		Browser.switchToParentWindow(testConfig, parentWindow);

		Browser.wait(testConfig, 8);

	}

}
