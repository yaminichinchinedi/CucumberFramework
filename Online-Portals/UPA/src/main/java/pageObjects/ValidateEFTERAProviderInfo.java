package main.java.pageObjects;

import java.io.IOException;
import java.util.Map;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.DataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;

public class ValidateEFTERAProviderInfo {

	private TestBase testConfig;
	
	//First provider details
	
	@FindBy(name="firstNameContact1")
	WebElement firstProvFirstName;
	
	@FindBy(name="lastNameContact1")
	WebElement firstProvLastName;
	
	@FindBy(name="phoneNum1Contact1")
	WebElement firstProvPhField1;
	
	@FindBy(name="phoneNum2Contact1")
	WebElement firstProvPhField2;
	
	@FindBy(name="phoneNum3Contact1")
	WebElement firstProvPhField3;
	
	
	@FindBy(name="emailContact1")
	WebElement firstProvEmail;
	
	
	@FindBy(name="verifyEmailContact1")
	WebElement verifyFirstProvEmail;
	
	//Second Provider Details
	
	@FindBy(name="firstNameContact2")
	WebElement secondProvFirstName;
	
	@FindBy(name="lastNameContact2")
	WebElement secondProvLastName;
	
	@FindBy(name="phoneNum1Contact2")
	WebElement secondProvPhField1;
	
	@FindBy(name="phoneNum2Contact2")
	WebElement secondProvPhField2;
	
	@FindBy(name="phoneNum3Contact2")
	WebElement secondProvPhField3;
	
	
	@FindBy(name="emailContact2")
	WebElement secondProvEmail;
	
	
	@FindBy(name="verifyEmailContact2")
	WebElement verifySecondProvEmail;
	
	@FindBy(name="btnSubmit")
	WebElement btnContinue;
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][2]//td//table//tr//td//b")
	WebElement txtSecurityBold;
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][2]//td//table//tr//td//u")
	WebElement txtSecurityUnderlined;
	
	@FindBy(xpath = "//tr[3]/td/table/tbody/tr/td[2]")
	WebElement txtSecurityNormal;
	
	@FindBy(xpath ="//td[contains(text(),'EPS Enrollment - Confirm Existing User')]")
	WebElement exitingUserText;
			
	
	
	
	

	public ValidateEFTERAProviderInfo(TestBase testConfig)
	{   
		String expected="/validateEFTERAProviderInfo";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Helper.compareContains(testConfig, "URL", expected, testConfig.driver.getCurrentUrl());

	}
	
	public void fillPhoneNumber(String PrvoiderType)
	{
		
		String expectedText="Enrollment & Account Security Reminder - To help support the security of your account, use of a business issued e-mail domain is required for enrollment and account access.";
		Element.verifyTextPresent(txtSecurityNormal, expectedText);
		
		
		switch(PrvoiderType)
		{
		case "Provider1":
		 {
			String phNo = Long.toString(Helper.generateRandomNumber(3));
			String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
			Element.enterData(firstProvPhField1, phNo,
					"Entered first three digits of phone number","firstProvPhField1");
			Element.enterData(firstProvPhField2, phNo,
					"Entered second three digits of phone number","firstProvPhField2");
			Element.enterData(firstProvPhField3, phNoLstField,
					"Entered last four digits of phone number","firstProvPhField3");
		   break;
		 }
		case "Provider2":
		 {
		   String phNo=Long.toString(Helper.generateRandomNumber(3));
		   String phNoLstField=Long.toString(Helper.generateRandomNumber(4));
		   Element.enterData(secondProvPhField1, phNo, "Entered first three digits of phone number","secondProvPhField1");
		   Element.enterData(secondProvPhField2, phNo, "Entered second three digits of phone number","secondProvPhField2");
		   Element.enterData(secondProvPhField3, phNoLstField, "Entered last four digits of phone number","secondProvPhField3");
		   break;
		 }
	}
		 
	}
	
	public void fillFirstProviderInfo()
	{
		String firstProvFName=Helper.generateRandomAlphabetsString(5);
		String firstProvLName=Helper.generateRandomAlphabetsString(5);
		
		String firstProvEmailAdr=Helper.getUniqueEmailId();
		
		Browser.wait(testConfig, 1);
		Element.enterData(firstProvFirstName, firstProvFName,"Enter First name of first provider","firstProvFirstName");
		Element.enterData(firstProvLastName, firstProvLName,"Enter Last name of first provider","firstProvLastName");
		fillPhoneNumber("Provider1");
		Element.enterData(firstProvEmail, firstProvEmailAdr, "Enter email address of first provider","firstProvEmail");
		Element.enterData(verifyFirstProvEmail, firstProvEmailAdr, "Retype email address of first provider","verifyFirstProvEmail");
	}
	
	public void VerifyDuplicateEmailError() throws IOException
	{
		String firstProvFName=Helper.generateRandomAlphabetsString(5);
		String firstProvLName=Helper.generateRandomAlphabetsString(5);
		
		int sqlRowNo=6;
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		Map enrolledProviderTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Element.enterData(firstProvFirstName, firstProvFName,"Enter First name of first provider","firstProvFirstName");
		Element.enterData(firstProvLastName, firstProvLName,"Enter Last name of first provider","firstProvLastName");
		fillPhoneNumber("Provider1");
		String firstProvEmailAdr=enrolledProviderTable.get("EMAIL_ADR_TXT").toString().toLowerCase().trim();
		
		Element.enterData(firstProvEmail,firstProvEmailAdr , "Enter already existing provider email address","firstProvEmail");
		Element.enterData(verifyFirstProvEmail, firstProvEmailAdr, "Retype existing email address of first provider","verifyFirstProvEmail");
		fillSecondProviderInfo();
		Element.click(btnContinue, "Continue");
		String expString="EPS Enrollment - Confirm Existing User";
		Element.verifyTextPresent(exitingUserText,expString);
		
	}
		
	
	public void fillSecondProviderInfo()
	{
		String secondProvFName=Helper.generateRandomAlphabetsString(5);
		String secondProvLName=Helper.generateRandomAlphabetsString(5);
		String secondProvEmailAdr=Helper.getUniqueEmailId();
		Element.enterData(secondProvFirstName, secondProvFName,"Enter First name of Second provider","secondProvFirstName");
		Element.enterData(secondProvLastName, secondProvLName,"Enter Last name of Second provider","secondProvLastName");
		fillPhoneNumber("Provider2");
		Element.enterData(secondProvEmail, secondProvEmailAdr, "Enter email address of Second provider","secondProvEmail");
		Element.enterData(verifySecondProvEmail, secondProvEmailAdr, "Retype email address of Second provider","verifySecondProvEmail");
	}

	
	public FinancialInstitutionInfoPage clickContinue()
	{
		Element.click(btnContinue, "Continue");
		return new FinancialInstitutionInfoPage(testConfig) ;
	}
	


	
	
}
