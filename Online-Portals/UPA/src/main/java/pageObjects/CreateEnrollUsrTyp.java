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
	
	public CreateEnrollUsrTyp(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	public CrtEnrollValidateTIN selectUserType(String userType )
	{
		if (userType.equals("Provider"))
		Browser.wait(testConfig, 5);
		//Element.selectByVisibleText(usrTyp, "Provider", "Click on Provider");
		Element.selectByIndex(usrTyp, 1, "Provider User Type");
		
		if (userType.equals("Billing Service"))
			//Element.selectByVisibleText(usrTyp, "Provider", "Click on Provider");
			Element.selectByIndex(usrTyp, 2, "BS User Type");
		
		String tinNumber=Integer.toString(Helper.getUniqueTinNumber());
		enrollmentInfoPageObj.setTin(tinNumber);
		Element.enterData(usrTIN, tinNumber, "Tin Number", "TIN");
		testConfig.putRunTimeProperty("EnrolTin", tinNumber);
		Element.clickByJS(testConfig, srchButtn, "Search Button");
		Browser.wait(testConfig, 8);
		return new CrtEnrollValidateTIN(testConfig);
	}
	
	
	}
