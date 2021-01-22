
package main.java.pageObjects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;



import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;



public class CrtEnrollValidateTIN {
	
	private TestBase testConfig;
	
	@FindBy(xpath="//tr[@id='showYesNoButton']/td/input[1]")
	WebElement yesButton;
	
	@FindBy(xpath="//tr[@id='showYesNoButton']/td/input[2]")
	WebElement noButton;
	
	@FindBy(id="paymentPrefAO")
	WebElement usrTypAO;
	
	@FindBy(id="paymentPrefAV")
	WebElement usrTypAV;
	
	@FindBy(id="paymentPrefVO")
	WebElement usrTypVO;
	@FindBy(xpath="//tr[@id='showcontcanButton']/td/input[1]")
	WebElement continueButton;
	
	@FindBy(xpath="//tr[@id='showcontcanButton']/td/input[2]")
	WebElement cancelButton;
	
	EnrollmentInfo enrollmentInfoObj=EnrollmentInfo.getInstance();

	public CrtEnrollValidateTIN(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, "validateTIN.do");
	}
	
	public CrtEnrollValidateTIN clickYesButton(){
	Element.clickByJS(testConfig, yesButton, "Yes Button");	
	return this;
	}
	
	public ProviderEFTERAEnrollPage clickEnrolUsrTyp(String enrollmentPaymentType){
		enrollmentInfoObj.setEnrollType("HO");
		
		
		switch (enrollmentPaymentType)
		{
		case "AO":
			Element.click(usrTypAO, "ACH User Type");
			testConfig.putRunTimeProperty("enrollmentType", "AO");
			enrollmentInfoObj.setTinIdentifier("AO");
			enrollmentInfoObj.setTin(testConfig.getRunTimeProperty("EnrolTin"));
			break;

		case "VO":	
			Element.click(usrTypVO, "VO User Type");
			testConfig.putRunTimeProperty("enrollmentType", "VO");
			enrollmentInfoObj.setTinIdentifier("VO");
			enrollmentInfoObj.setTin(testConfig.getRunTimeProperty("EnrolTin"));
			break;

		case "AV":
			Element.click(usrTypAV, "ACH User Type");
			testConfig.putRunTimeProperty("enrollmentType", "AV");
			enrollmentInfoObj.setTinIdentifier("AV");
			enrollmentInfoObj.setTin(testConfig.getRunTimeProperty("EnrolTin"));
			break;

		default:
			Log.Comment("Unidentified Enrollment Method" + ":" + " " + enrollmentPaymentType);				 
		}

		
		Element.click(continueButton, "Continue Button");
		Browser.wait(testConfig, 8);
	
		return new ProviderEFTERAEnrollPage(testConfig) ;
	}
	
	}