package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;

public class ProviderEFTERAEnrollPage extends ProviderInformationEFTERAEnroll {
	
	@FindBy(name="btnSubmit")
	WebElement btnContinue;
	
	@FindBy(linkText="Download EPS Enrollment Instructions")
	WebElement lnkEpsPdf;
	
	private TestBase testConfig;

	public ProviderEFTERAEnrollPage(TestBase testConfig)
    {
		super(testConfig);
		String expectedURL = "/providerEFTERAEnroll.do";
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public ProviderInformationEFTERAEnroll clickContinue() 
	{
		Element.click(btnContinue, "Continue");
		return new ProviderInformationEFTERAEnroll(testConfig) ;
	}

	

}
