package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class HowToEnroll {
	
	@FindBy(xpath=".//*[@id='signInForm']/article/h1")
	WebElement textHowToEnroll;
	
	
	@FindBy(xpath=".//*[@id='signInForm']/article/a/span[2]")
	private WebElement dwnldEPSInstructions;
	
	@FindBy(xpath=".//*[@id='signInForm']/article/div/a")
	private WebElement enrollNowBtn;
	
	private TestBase testConfig;
	
	public HowToEnroll(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expectedURL="HowToEnroll.do";
		Browser.verifyURL(testConfig, expectedURL);
		
		Element.expectedWait(textHowToEnroll, testConfig, "How to Enroll", "How to Enroll");
		Element.verifyElementPresent(dwnldEPSInstructions, "Download EPS Enrollment Instructions");
		Element.verifyElementPresent(enrollNowBtn, "Enroll Now Button");
	}
	
	public BeginEnrollment validateEnrollNowBtn() {
		Element.click(enrollNowBtn, "Enroll Now Button");
		return new BeginEnrollment(testConfig);
	}

}
