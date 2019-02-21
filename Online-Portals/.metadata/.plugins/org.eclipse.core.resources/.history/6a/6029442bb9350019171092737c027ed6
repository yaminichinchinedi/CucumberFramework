package main.java.pageObjects;

import main.java.api.pojo.epsEnrollment.EnrollmentInfo;
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
		String expectedURL;
		if(testConfig.getRunTimeProperty("enrollmentType").equals("VO"))
			expectedURL = "/validateEFTERAProviderContact";
		else if(testConfig.getRunTimeProperty("enrollmentType").equals("AV"))
			expectedURL="/UploadW9EFTERAEnroll";
		else
			expectedURL="/validateEFTERAFinancialInfo";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public UploadW9() {
		// TODO Auto-generated constructor stub
	}

	public ReviewAndSubmit uploadW9()  
	{   
//		Browser.wait(testConfig, 5);
		Element.enterData(btnW9,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnW9");
		enrollmentInfoObj.setW9DocCode("W9");
		Browser.wait(testConfig, 5);
		Element.clickByJS(testConfig, btnContinue, "Clicked Continue");
		return new ReviewAndSubmit(testConfig);
	}
}
