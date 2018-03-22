package main.java.pageObjects;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SplashPage3 {

	
	
	@FindBy(linkText="SIGN IN TO EPS WITH OPTUM ID")
	WebElement lnkSignInWithOptumId;
	private TestBase testConfig;
	
	public SplashPage3(TestBase testConfig)
	{   
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForLoad(testConfig.driver);
		Element.expectedWait(lnkSignInWithOptumId, testConfig, "Sign in with optum id link", "Sign in with optum id link");
	}
	
	public OptumIdLoginPage clickSignInWithOptumId()
	{
		Element.click(lnkSignInWithOptumId, "Sign in with optum id");
		return new OptumIdLoginPage(testConfig);
	}
}
