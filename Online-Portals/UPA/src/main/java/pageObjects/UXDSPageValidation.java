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
	
	@FindBy(linkText="Enrollment HO Identify Administrators")
	WebElement EnrollHOIdentifyAdmin;

	@FindBy(xpath="/html/body/section[1]/fieldset/section[4]/ul[1]/li[29]/a")
	WebElement TinElligibleBSUXDS;
	
	@FindBy(xpath="/html/body/section[1]/fieldset/section[4]/ul[1]/li[25]/a")
	WebElement BSIdentifyAdminUXDS;
	
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

		else if(targetElement.equalsIgnoreCase("Enrollment HO Identify Administrators"))
		{	
		Element.click(EnrollHOIdentifyAdmin, "Enrollment HO Billing Service");
		Browser.wait(testConfig, 3);
		Browser.verifyURL(testConfig, "enrollment_HO-identify-admins");
		}
		

		
		if (targetElement.equalsIgnoreCase("Enrollment TIN Eligible BS"))
		{	
		Element.click(TinElligibleBSUXDS, "Enrollment TIN Eligible BS");
		Browser.wait(testConfig, 3);
		Browser.verifyURL(testConfig, "enrollment-tin-eligible_bs.html");
		}
		
		if (targetElement.equalsIgnoreCase("Enrollment BS Identify Administrators"))
		{	
		Element.click(BSIdentifyAdminUXDS, "Enrollment BS Identify Administrators");
		Browser.wait(testConfig, 3);
		Browser.verifyURL(testConfig, "enrollment-bs-billing-service-identify-admins.html");
		}
	}
	
	

	
	
}
