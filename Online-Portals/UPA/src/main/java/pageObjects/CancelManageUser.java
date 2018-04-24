package main.java.pageObjects;

import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelManageUser {

	
	@FindBy(name="No")
	WebElement btnNo;
	
	@FindBy(name="Yes")
	WebElement btnYes;

	private TestBase testConfig;
	
    public CancelManageUser(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.verifyElementPresent(btnYes,"Yes Button");
	}
    
    public HomePage clickYes()
	{
		Element.click(btnYes, "Yes button");
		return new HomePage(testConfig);
	}
	
	public void clickNo()
	{
		Element.click(btnNo, "No button");
	}
	
}
