package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadW9PageBS extends UploadW9{
	private TestBase testConfig;
	
	public UploadW9PageBS(TestBase testConfig) 
	{
		super();
		String expectedURL = "/validateBillingServiceContacts";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public ReviewAndSubmitBSEnrollment uploadW9()  
	{   
		Browser.wait(testConfig, 2);
		Element.enterData(btnW9,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnW9");
		Browser.wait(testConfig,2);
		enrollmentInfoObj.setW9DocCode("W9");
		Element.clickByJS(testConfig, btnContinue, "Clicked Continue");
		return new ReviewAndSubmitBSEnrollment(testConfig);
	}
	
}
