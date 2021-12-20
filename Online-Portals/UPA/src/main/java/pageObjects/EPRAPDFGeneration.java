package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.jdbc.Driver;

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
		
		EPFAPDFGenMessage1.getText().equalsIgnoreCase("The PDF document that you requested is being generated. Please standby and it will display momentarily.");
		
		PaymentNum.getText().contains(PaymentNumber);
		
		Browser.wait(testConfig, 5);
		
		System.out.println(EPFAPDFGenMessage2.getText());
		
		EPFAPDFGenMessage2.getText().equalsIgnoreCase("We're sorry, it looks like the requested PDF document will take additional time to generate. Please click on the \"OK\" button to close this page. When the document is ready a PDF icon will display. ");
		
		PaymentNum.getText().contains(PaymentNumber);
		
		OKButton.isDisplayed();
		
		OKButton.click();
		
		Browser.switchToParentWindow(testConfig, parentWindow);
		
		Browser.wait(testConfig, 8);	
		
	}

}
