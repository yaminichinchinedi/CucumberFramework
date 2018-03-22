package main.java.pageObjects;

import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;

public class ValidateEnrollmentTypePage {
	
	@FindBy(name="btnSubmit")
	WebElement btnContinue;

	private TestBase testConfig;
	
	public ValidateEnrollmentTypePage(TestBase testConfig)
	{   
		String expected="/validateEnrollmentType.do";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Helper.compareContains(testConfig, "URL", expected, testConfig.driver.getCurrentUrl());
	}
	
	public ProviderEFTERAEnrollPage clickContinue()
	{
		Element.click(btnContinue, "Continue");
		return new ProviderEFTERAEnrollPage(testConfig) ;
	}

}
