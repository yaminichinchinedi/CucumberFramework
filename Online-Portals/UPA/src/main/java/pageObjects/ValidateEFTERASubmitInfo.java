package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class ValidateEFTERASubmitInfo {

	private main.java.nativeFunctions.TestBase testConfig;
	
	@FindBy(name = "w9File")
	WebElement btnBrowse;
	
	
	@FindBy(name ="sameAsAuth")
	WebElement chkSameAsAuthorized;
	
	@FindBy(name ="enrollerTitleFinPage")
	WebElement enrollerTitle;
	
	@FindBy(name ="enrollerTele1")
	WebElement enrollerTelPh1;
	
	@FindBy(name ="enrollerTele2")
	WebElement enrollerTelPh2;
	
	@FindBy(name ="enrollerTele3")
	WebElement enrollerTelPh3;
	
	@FindBy(name ="enrollerEmail")
	WebElement enrollerEmail;
	
	@FindBy(name ="enrollerRetypeEmail")
	WebElement retypeErollerEmail;
	
	@FindBy(name ="btnSubmit")
	WebElement btnSubmit;
	

	public ValidateEFTERASubmitInfo(TestBase testConfig) {
		
		String expectedURL = "/validateEFTERASubmitInfo";
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
		
	public void uploadW9pdf() 
	{   
		Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"path of pdf is : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnBrowse");
	}


	public ThankYouPage fillEnrollersInfo() 
	{   
		String phNo = Long.toString(Helper.generateRandomNumber(3));
		String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
		String email=Helper.getUniqueEmailId();
		uploadW9pdf();
		Browser.wait(testConfig, 5);
		Element.enterData(enrollerTelPh1,phNo, "Enter first three digits of phone number as :" + " " + phNo ,"enrollerTelPh1");
		Element.click(chkSameAsAuthorized, "Same as authorized checkbox");
		if(!chkSameAsAuthorized.isSelected())
		{
			Log.Comment("Aceptance box was not checked at the first time, checking it again");
			Element.click(chkSameAsAuthorized, "Same as authorized checkbox");
		}
		Element.enterData(enrollerTitle,Helper.generateRandomAlphabetsString(2), "Enter enroller's title","enrollerTitle");
		Element.enterData(enrollerTelPh1,phNo, "Enter first three digits of phone number","enrollerTelPh1");
		Element.enterData(enrollerTelPh2,phNo, "Enter second three digits of phone number","enrollerTelPh2");
		Element.enterData(enrollerTelPh3,phNoLstField, "Enter second three digits of phone number","enrollerTelPh3");
		Element.enterData(enrollerEmail, email, "Enter email address of enroller","enrollerEmail");
		Element.enterData(retypeErollerEmail, email, "Re type email address of enroller","retypeErollerEmail");
		return submitForm();
		
	}
	
	public ThankYouPage submitForm() 
	{   
		Element.click(btnSubmit, "Submit button");
		return new ThankYouPage(testConfig);
	}
	

	
	
}
