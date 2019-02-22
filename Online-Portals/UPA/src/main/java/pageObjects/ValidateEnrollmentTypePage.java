package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;

public class ValidateEnrollmentTypePage {
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;

	private TestBase testConfig;
	EnrollmentInfo enrollmnt=EnrollmentInfo.getInstance();
	
	public ValidateEnrollmentTypePage(TestBase testConfig)
	{   
		String expectedURL="/validateEnrollmentType.do";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		if(enrollmnt.getEnrollType().equals("BS"))
			expectedURL="/validateBillingServiceEnrollmentType.do";
		Browser.verifyURL(testConfig, expectedURL); 
	}
	
	public ProviderEFTERAEnrollPage clickContinue()
	{
		Element.clickByJS(testConfig, btnContinue, "Continue on validate enrollment type page");
		return new ProviderEFTERAEnrollPage(testConfig) ;
	}
	
	

}
