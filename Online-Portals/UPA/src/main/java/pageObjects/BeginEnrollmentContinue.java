package main.java.pageObjects;

import java.io.IOException;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeginEnrollmentContinue {
	
//	@FindBy(xpath="//span[contains(text(),'Choose Your Enrollment Type')]")
//	WebElement txtEnrollmentType;
//	
//	@FindBy(xpath=".//*[@id='org1']/td[1]/input")
//	WebElement rdoHealthcareOrg;
	
	@FindBy(id="healthcareorgselect")
	WebElement rdoHealthcare;
	
	@FindBy(id="billingserivceselect")
	WebElement rdoBillingService;
			
	
	
	
	//new changes
//	@FindBy(xpath="//input[@value='org']")
//	WebElement rdoHealthcare;
	
//	@FindBy(xpath="//input[@value='bs']")
//	WebElement rdoBillingService;
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
	@FindBy(xpath="//a[@value='VO']")
	WebElement rdoVoOnly;
	
	@FindBy(xpath="//a[@value='AO']")
	WebElement rdoAchOnly;

	@FindBy(xpath="//a[@value='AV']")
	WebElement rdoAV;
	
	@FindBy(name="tin")
	WebElement txtBoxTin;
	
	@FindBy(css=".pops")
	WebElement btnIAgree;
	
	private TestBase testConfig;
	public ValidateEnrollmentTypePage validateEnrollmentType;
	
	public BeginEnrollmentContinue(TestBase testConfig)
	{
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, "beginEnrollmentContinue.do");
	}
	
	
	//Selecting Health care organization and going to validate enrollment page
	
	public BeginEnrollmentContinue enrollAs(int excelRowNo) throws IOException
	 {
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo"); 
		String tinNumber=Integer.toString(Helper.getUniqueTinNumber());
		String enrollmentPaymentType=data.GetData(excelRowNo, "EnrollmentTypeMethod").trim();
		testConfig.putRunTimeProperty("tin", tinNumber);
	
		if(data.GetData(excelRowNo, "EnrollmentTypeOrg").toLowerCase().trim().equalsIgnoreCase("healthcare"))
		 {
		   Element.click(rdoHealthcare, "Healthcare organization");
		   Element.expectedWait(rdoAchOnly, testConfig, "radio button ACH only payment type", "radio button ACH only payment type");
			
		   switch (enrollmentPaymentType)
			 {
			   case "AO":
				Element.click(rdoAchOnly,"ACH only payment type");
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as" + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "AO");
				break;
				
			  case "VO":	
				Element.click(rdoVoOnly,"VCP only payment type");
				Element.click(btnIAgree, "I agree button");
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as" + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "VO");
				break;
				
			  case "AV":	
				Element.click(rdoAV,"ACH & VCP both payment type");
				Element.click(btnIAgree, "I agree button");
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as" + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "AV");
				break;
				
				default:
				Log.Comment("Unidentified Enrollment Method" + ":" + " " + enrollmentPaymentType);				 
			}
		}
		else if(data.GetData(excelRowNo, "EnrollmentTypeOrg").trim().equalsIgnoreCase("BS"))
		Element.click(rdoBillingService, "Billing Service");
		else
		Log.Comment("Enrollment type" +data.GetData(excelRowNo, "EnrollmentType").toLowerCase().trim() + " " +"not identified");
	
		return new BeginEnrollmentContinue(testConfig);
	}
	
	
	public ValidateEnrollmentTypePage clickContinue()
	{
		Element.click(btnContinue, "Continue");
		return new ValidateEnrollmentTypePage(testConfig);
	}
	
}
