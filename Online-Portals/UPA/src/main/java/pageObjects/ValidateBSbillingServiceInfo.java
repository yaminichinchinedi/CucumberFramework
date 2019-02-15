package main.java.pageObjects;

import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.api.pojo.epsEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.support.PageFactory;

public class ValidateBSbillingServiceInfo  extends ValidateEFTERAProviderInfo{
	
	
	
	public ValidateBSbillingServiceInfo(TestBase testConfig)
	{   
		super(testConfig);
		String expectedURL="/validateBSbillingServiceInfo";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public  ValidateBSbillingServiceInfo fillPrimaryBSInfo()
	{	
		Element.enterData(firstProvFName, fName,"Enter First name of first provider as : " + fName,"firstProvFirstName");
		Element.enterData(firstProvLName, lName,"Enter Last name of first provider as : " + lName,"firstProvLastName");
		fillPhoneNumber("Primary");
		Element.enterData(firstProvEmail, firstProvEmailAdr, "Enter email address of first provider as : " +firstProvEmailAdr,"firstProvEmail");
		Element.enterData(verifyFirstProvEmail, firstProvEmailAdr, "Retype email address of first provideras : " +firstProvEmailAdr,"verifyFirstProvEmail");
		enrollmentInfoPageObj.setFrstName(fName);
		enrollmentInfoPageObj.setLstName(lName);
		enrollmentInfoPageObj.setEmail(firstProvEmailAdr);
		return this;
	}
	
	public UploadW9Page clickCntinue()
	{
		Browser.wait(testConfig, 5);
		Element.click(btnContinue, "Continue");
		return new UploadW9Page(testConfig) ;
	}
	
}
