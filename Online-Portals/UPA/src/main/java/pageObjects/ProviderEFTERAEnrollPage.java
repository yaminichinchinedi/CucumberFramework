package main.java.pageObjects;

import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;

public class ProviderEFTERAEnrollPage {
	
	@FindBy(name="btnSubmit")
	WebElement btnContinue;
	
	@FindBy(linkText="Download EPS Enrollment Instructions")
	WebElement lnkEpsPdf;
	
	private TestBase testConfig;

	public ProviderEFTERAEnrollPage(TestBase testConfig)
 {
		String expected = "/providerEFTERAEnroll.do";
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Helper.compareContains(testConfig, "URL", expected,testConfig.driver.getCurrentUrl());
	    Element.verifyElementPresent(lnkEpsPdf,"Pdf link");
	}
	
	public ProviderInformationEFTERAEnroll clickContinue() 
	{
		Element.click(btnContinue, "Continue");
		return new ProviderInformationEFTERAEnroll(testConfig) ;
	}

	

}
