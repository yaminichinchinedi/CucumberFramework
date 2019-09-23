package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UXDSPageValidation   {

	@FindBy(xpath="/html/body/section[1]/h1")
	WebElement uxdsPageHeading;
	@FindBy(linkText="Enrollment BS Billing Service")
	WebElement EnrollBS;
	
	@FindBy(xpath="/html/body/section[1]/fieldset/section[4]/ul[1]/li[29]/a")
	WebElement TinElligibleBSUXDS;
	
	protected TestBase testConfig;
	
	public UXDSPageValidation(TestBase testConfig,String targetElement)
	{
		this.testConfig=testConfig;
		testConfig.driver.navigate().to("http://webrd1220.uhc.com/eps-2018/approved/");
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForLoad(testConfig.driver);
		Element.expectedWait(uxdsPageHeading, testConfig, "Pages",  "Pages");
		
		if (targetElement.equalsIgnoreCase("Enrollment BS Billing Service"))
		{	
		Element.click(EnrollBS, "Enrollment BS Billing Service");
		Browser.wait(testConfig, 3);
		Browser.verifyURL(testConfig, "enrollment-bs-billing-service-information");
		}
		
		if (targetElement.equalsIgnoreCase("Enrollment TIN Eligible BS"))
		{	
		Element.click(TinElligibleBSUXDS, "Enrollment TIN Eligible BS");
		Browser.wait(testConfig, 3);
		Browser.verifyURL(testConfig, "enrollment-tin-eligible_bs.html");
		}
	}
	
	

	
	
}
