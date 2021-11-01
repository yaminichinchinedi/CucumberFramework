package main.java.pageObjects;

import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateEnrollUsrTyp {
		private TestBase testConfig;
		EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	@FindBy(css="#userTypeSelection")
	WebElement usrTyp;
	
	@FindBy(id="taxNumber")
	WebElement usrTIN;
	
	@FindBy(name="btnSubmit")
	WebElement srchButtn;
	
	@FindBy(xpath="//tr[@id='errorMessage']/td")
	WebElement CSRTINErrorMessage;
	
	public CreateEnrollUsrTyp(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	public CrtEnrollValidateTIN selectUserType(String userType )
	{
		if (userType.equals("Provider")||userType.equalsIgnoreCase("PROV")) {
		Browser.wait(testConfig, 5);
		Element.selectByIndex(usrTyp, 1, "Provider User Type");
		}
		if (userType.equals("Billing Service")) {
			Element.selectByIndex(usrTyp, 2, "BS User Type");
		}
		String tinNumber=Integer.toString(Helper.getUniqueTinNumber());
		enrollmentInfoPageObj.setTin(tinNumber);
		Element.enterData(usrTIN, tinNumber, "Tin Number", "TIN");
		testConfig.putRunTimeProperty("EnrolTin", tinNumber);
		Element.clickByJS(testConfig, srchButtn, "Search Button");
		Browser.wait(testConfig, 8);
		if(userType.equalsIgnoreCase("Billing Service"))
			return new CrtEnrollValidateTIN(testConfig,userType);
		else
		   return new CrtEnrollValidateTIN(testConfig);
	}
	
	public void validatingErrorMessageForInCorrectTINNumber(String userType )
	{
		if (userType.equals("Provider")) {
		Browser.wait(testConfig, 5);
		Element.selectByIndex(usrTyp, 1, "Provider User Type");
		}
		if (userType.equals("Billing Service")) {
			Element.selectByIndex(usrTyp, 2, "BS User Type");
		}
		
		Browser.wait(testConfig, 2);
		
		Element.enterData(usrTIN, "", "Tin Number", "TIN");
		Element.clickByJS(testConfig, srchButtn, "Search Button"); 
		Helper.compareEquals(testConfig, "Error when TIN value is null", CSRTINErrorMessage.getText(), "Please enter Valid and Active Tax Identification Number");
		
		
		Element.enterData(usrTIN, "2345", "Tin Number", "TIN");
		Element.clickByJS(testConfig, srchButtn, "Search Button");
		Browser.wait(testConfig, 1);
		Helper.compareEquals(testConfig, "Error when TIN value less 9 digits", CSRTINErrorMessage.getText(), "Please enter Valid and Active Tax Identification Number");
		
		Element.enterData(usrTIN, "2345AS345", "Tin Number", "TIN");
		Element.clickByJS(testConfig, srchButtn, "Search Button");
		Browser.wait(testConfig, 1);
		Helper.compareEquals(testConfig, "Error when TIN value Alphanumaric", CSRTINErrorMessage.getText(), "Please enter Valid and Active Tax Identification Number");
		
		Element.enterData(usrTIN, "2345%^345", "Tin Number", "TIN");
		Element.clickByJS(testConfig, srchButtn, "Search Button");
		Browser.wait(testConfig, 1);
		Helper.compareEquals(testConfig, "Error when TIN value contains special char", CSRTINErrorMessage.getText(), "Please enter Valid and Active Tax Identification Number");
		
		
	}
	
	
	}
