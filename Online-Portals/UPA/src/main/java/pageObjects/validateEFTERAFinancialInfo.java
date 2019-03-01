package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class validateEFTERAFinancialInfo {

	private TestBase testConfig;
	
	@FindBy(css="input[value='BL']")
	WebElement rdoBankLetter;

	@FindBy(css="input[value='VC']")
	WebElement rdoVoidedCheck;
	
	@FindBy(name = "msgFile")
	WebElement btnBrowse;
	
	@FindBy(name = "btnChange")
	WebElement btnChange;
	
	
	@FindBy(name = "acceptance")
	WebElement chkAcceptanceBox;
	
	@FindBy(name = "firstNameEPS")
	WebElement firstName;
	
	@FindBy(name = "lastNameEPS")
	WebElement lastName;
	
	@FindBy(name = "titleEPS")
	WebElement title;
	
	@FindBy(name = "efterabtnSubmit")
	WebElement btnSubmit;

	
	@FindBy(xpath="//tr[10]/td/table/tbody/tr/td[2]/div/table/tbody/tr[4]/td/b")
	WebElement txtSecurity;
	
	@FindBy(xpath="//tr[5]/td/table/tbody/tr[2]/td[2]/b")
	WebElement txtSecurity1;
	
	@FindBy(xpath="//tr[5]/td/table/tbody/tr[3]/td[2]/b")
	WebElement txtSecurity2;
	


	public validateEFTERAFinancialInfo(TestBase testConfig) {
		String expectedURL = "/validateEFTERAFinancialInfo";
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
		//Helper.compareContains(testConfig, "URL", expected,testConfig.driver.getCurrentUrl());
	}
	
	//Default Constructor
	public validateEFTERAFinancialInfo() {
		
	}

	
	
	public void uploadBankLetterPdfWithAcceptance()  
	{   
		String expectedText="Optum reserves the right to request additional information to help ensure the security of your account.";
		//Element.verifyTextPresent(txtSecurity,expectedText);
		expectedText="For your security, you may be contacted";
		//Element.verifyTextPresent(txtSecurity1,expectedText);
		expectedText="and required to submit additional information.";
		//Element.verifyTextPresent(txtSecurity2,expectedText);
		
		
		Element.click(rdoBankLetter, "Bank Letter radio button");
		Browser.waitForLoad(testConfig.driver);
		Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnBrowse");
		Browser.wait(testConfig,2);
		Element.click(chkAcceptanceBox, "Acceptance check box");
		if(chkAcceptanceBox.isSelected())
		{
			Log.Comment("Acceptance checkbox checked");
		}
		else
		{
			Element.click(chkAcceptanceBox, "Acceptance check box");
		}
	}
	
	public validateEFTERAFinancialInfo checkAcceptanceBox()
	{
		Element.click(chkAcceptanceBox, "Acceptance check box");
		if(chkAcceptanceBox.isSelected())
		{
			Log.Comment("Acceptance checkbox checked");
		}
		else
		{
			Log.Warning("Could not check Acceptance check box for the first time, trying again..", testConfig);
			Element.click(chkAcceptanceBox, "Acceptance check box");
		}	
		return this;
	}
	
	public validateEFTERAFinancialInfo fillAuthorizedSignature() 
	{   
		Element.enterData(firstName,Helper.generateRandomAlphabetsString(4).toLowerCase(), "Enter First Name in Authorized Signature section","firstName");
		Element.enterData(lastName,Helper.generateRandomAlphabetsString(4).toLowerCase(), "Enter First Name in Authorized Signature section","lastName");
		Element.enterData(title,Helper.generateRandomAlphabetsString(4).toLowerCase(), "Enter title","title");
		return this;
	}
	
	public void submitForm() 
	{   
		Element.click(btnSubmit, "Submit button");
	}
	
	public ValidateEFTERASubmitInfo fillUploadEFTERAFileFormAndSubmit()
	{
		uploadBankLetterPdfWithAcceptance();
		fillAuthorizedSignature();
		submitForm();
		return new ValidateEFTERASubmitInfo(testConfig);
	}
	
}
