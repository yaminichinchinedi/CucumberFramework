package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateBillingServiceEnrollmentType extends ValidateEnrollmentTypePage {

	private TestBase testConfig;

	public ValidateBillingServiceEnrollmentType(TestBase testConfig)
	{   
		super(testConfig);
		String expectedURL="/validateBillingServiceEnrollmentType.do";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public BillingServiceInformation clickContinue()
	{
		Element.click(btnContinue, "Continue on validate BS enrollment type page");
		return new BillingServiceInformation(testConfig) ;
	}
}
