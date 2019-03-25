package main.java.pageObjects;

import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadW9 {
	@FindBy(id="file")
	WebElement btnW9;
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
	private TestBase testConfig;
	EnrollmentInfo enrollmentInfoObj=EnrollmentInfo.getInstance();
	
	public UploadW9(TestBase testConfig) 
	{
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		String expectedURL;
		
		if(enrollmentInfoObj.getTinIdentifier().equals("VO"))
			expectedURL = "/validateEFTERAProviderContact";
		else if(enrollmentInfoObj.getTinIdentifier().equals("AV"))
			expectedURL="/UploadW9EFTERAEnroll";
		else if(enrollmentInfoObj.getTinIdentifier().equals("AO"))
			expectedURL="/validateefterafinancialinfo";
		else
			expectedURL="/validateBillingServiceContacts";
		
		Browser.verifyURL(testConfig, expectedURL);
	}

	public ReviewAndSubmit uploadW9()  
	{   
		Element.enterData(btnW9,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnW9");
		Browser.wait(testConfig, 2);
		enrollmentInfoObj.setW9DocCode("W9");
		Browser.wait(testConfig, 3);
		Element.clickByJS(testConfig, btnContinue, "Clicked Continue");
		return new ReviewAndSubmit(testConfig);
	}
}
