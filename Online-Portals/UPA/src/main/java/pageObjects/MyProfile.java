package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile {
	
	@FindBy(linkText="Change Password" )
	WebElement lnkChangePwd;
	
	@FindBy(xpath="//span[contains(text(),'successfully changed')]")
	WebElement successMsg;
			
	@FindBy(linkText="How to Enroll")
	WebElement tabHowToEnroll;
			
    @FindBy(linkText="Benefits of EPS")
    WebElement tabBenefitsOfEPS;
	
	private TestBase testConfig;
	

	public MyProfile(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.verifyElementPresent(lnkChangePwd, "Page is loaded and Change Password Link");
	}

	//Default constructor
	 MyProfile() 
	{
		
	}
	
	public MyProfileChangePwd clickChangePwd()
	{ 
	 try
	  {
		Browser.wait(testConfig, 2);
	    testConfig.driver.findElement(By.linkText("Change Password")).click();
	    Log.Comment("Clicked Change Password" );
	  }
	 catch(Exception e)
	  {
		LogTemp.Fail("Could not click on Change password link due to exception : " + e);
	  }
		return new MyProfileChangePwd(testConfig);
	}
	
	public void verifySuccessMsg()
	{
		Element.verifyElementPresent(successMsg, "Success Message");
	}
	
}
