package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;

public class ValidateEnrollmentTypePage {
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;

	private TestBase testConfig;
	
	public ValidateEnrollmentTypePage(TestBase testConfig)
	{   
		String expectedURL="/validateEnrollmentType.do";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL); 
	}
	
	public ValidateEnrollmentTypePage() {
		// TODO Auto-generated constructor stub
	}

	public ProviderInformationEFTERAEnroll clickContinue()
	{
		Element.clickByJS(testConfig, btnContinue, "Continue on validate enrollment type page");
		return new ProviderInformationEFTERAEnroll(testConfig) ;
	}

}
