package main.java.pageObjects;

import java.io.IOException;
import java.util.List;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeginEnrollmentContinue {

	@FindBy(id="healthcareorgselect")
	WebElement rdoHealthcare;
	
	@FindBy(id="changemyanswerorg1")
	WebElement lnkChangeOption;
	
	@FindBy(id="changemyansorg3")
	WebElement lnkChangeOption2;
	
	@FindBy(id="billingserivceselect")
	WebElement rdoBillingService;
	
	@FindBy(id="tin")
	WebElement rdoBillingTin;
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
	@FindBy(xpath=".//*[@id='enrollment3']/div/a[1]")
	WebElement btnCancelEnrollment;
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div/div[1]/div[3]/a[2]")
	WebElement btnCancelEnrollmentNoOptn;
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div/div[1]/div[3]/a[1]")
	WebElement btnCancelEnrollmentYesOptn;
	
	@FindBy(xpath=".//*[@id='enrollment2']/div/a[1]")
	WebElement lnkChoose2;
	
	@FindBy(xpath=".//*[@id='enrollment1']/div/a[1]")
	WebElement lnkChoose1;
	
	@FindBy(xpath=".//*[@id='hoModal']/div[1]")
	WebElement boxLinkPopUp2;
	
	@FindBy(xpath=".//*[@id='enrollmentClassificationModal']/div[1]")
	WebElement boxLinkPopUp1;
	
	@FindBy(xpath=".//*[@id='hoModal']/div[1]/div[3]/a")
	WebElement closeTip2;
	
	@FindBy(xpath=".//*[@id='enrollmentClassificationModal']/div[1]/div[3]/a")
	WebElement closeTip1;
	
	@FindBy(xpath="//.[@id='vcpModal']/div[1]")
	WebElement boxVCP;
	
	@FindBy(xpath=".//*[@id='vcpModal']/div[1]/div[3]/a[2]")
	WebElement btnVCPCacnel;
	
	@FindBy(xpath="//a[@value='VO']")
	WebElement rdoVoOnly;
	
	@FindBy(xpath="//a[@value='AO']")
	WebElement rdoAchOnly;

	@FindBy(xpath="//a[@value='AV']")
	WebElement rdoAV;
	
	@FindBy(name="tin")
	WebElement txtBoxTin;
	
	@FindBy(id="bstinfield")
	WebElement txtBoxBSTin;
	
	@FindBy(id="tinerror1")
	WebElement errorMsg1;
	
	@FindBy(xpath=".//*[@id='recaptcha-anchor']/div[5]") 
	WebElement chkBoxCaptcha;
	
	@FindBy(xpath=".//*[@id='vcpModal']/div[1]/div[3]/a[1]")
	WebElement btnIAgree;
	
	// .//*[@id='EFTERAenrForm']/div/div[1]/div[1]
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div/div[1]")
	WebElement popUpCnclEnrlmnt;
	
	
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
		   clickRdoHealthOrg();
		   Element.expectedWait(rdoAchOnly, testConfig, "radio button ACH only payment type", "radio button ACH only payment type");
			
		   switch (enrollmentPaymentType)
			 {
			   case "AO":
				Element.click(rdoAchOnly,"ACH only payment type");
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "AO");
				break;
				
			  case "VO":	
				Element.click(rdoVoOnly,"VCP only payment type");
				Element.click(btnIAgree, "I agree button");
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "VO");
				break;
				
			  case "AV":	
				Element.click(rdoAV,"ACH & VCP both payment type");
				Element.click(btnIAgree, "I agree button");
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "AV");
				break;
				
				default:
				Log.Comment("Unidentified Enrollment Method" + ":" + " " + enrollmentPaymentType);				 
			}
		}
		else if(data.GetData(excelRowNo, "EnrollmentTypeOrg").trim().equalsIgnoreCase("BS"))
		{
			Element.click(rdoBillingService, "Billing Service");
			Element.clickByJS(testConfig, rdoBillingTin, "Billing Service Tin");
			Element.enterData(txtBoxBSTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
		}
		else
		Log.Comment("Enrollment type" +data.GetData(excelRowNo, "EnrollmentType").toLowerCase().trim() + " " +"not identified");
	
		return this;
	}
	
	
	public ValidateEnrollmentTypePage clickContinue()
	{
		Element.clickByJS(testConfig,btnContinue, "Continue");
		return new ValidateEnrollmentTypePage(testConfig);
	}
	
	public BeginEnrollmentContinue clickRdoHealthOrg()
	{
		clickRdoHealthOrg();
		return this;
	}
	
	public BeginEnrollmentContinue clickCancelEnrollment()
	{
		Element.click(btnCancelEnrollment, "Cancel Enrollment");
		Element.verifyElementPresent(popUpCnclEnrlmnt, "Cancel Enrollment Pop Up"); 
		return this;
	}

	public  BeginEnrollmentContinue verifyCancelEnrollmentFunctionality()
	{
		clickCancelEnrollment();
		Element.click(btnCancelEnrollmentNoOptn,"No Option Clicked");
		Browser.verifyURL(testConfig, "beginEnrollmentContinue.do");
		clickCancelEnrollment();
		Element.click(btnCancelEnrollmentYesOptn, "Yes Option Clicked");
		Browser.verifyURL(testConfig, "chooseEnrollmentType.do");
		return this;
	}
	
	public void clickChooseLink()
	{
		Element.click(lnkChoose1, "Choose Link Before selecting Healthcare organization");
		Element.verifyElementPresent(boxLinkPopUp1, "Choose Link Pop Up");
		String text=boxLinkPopUp1.getText();
		Element.click(closeTip1, "Close tip");
		Browser.wait(testConfig, 2);
		clickRdoHealthOrg(); 
		Element.click(lnkChoose2,"Choose link After selecting Healthcare organization");
		Element.verifyElementPresent(boxLinkPopUp2, "Choose Link Pop Up");
		Browser.wait(testConfig, 2);
		Element.click(closeTip2, "Close tip");
		Browser.verifyURL(testConfig, "beginEnrollmentContinue.do");
		
	}
	
	public BeginEnrollmentContinue verifyChangeLink()
	{
		clickRdoHealthOrg();
		Element.verifyElementPresent(lnkChangeOption, "Change my answer for organization type");
		Element.click(lnkChangeOption,"Change my answer");
		Element.verifyElementNotPresent(lnkChangeOption, "Change my answer for organization type");
		
		clickRdoHealthOrg();
		Element.click(rdoAchOnly,"ACH only payment type");
		Element.verifyElementPresent(lnkChangeOption2, "Change my answer for organization type");
		Element.click(lnkChangeOption2,"Change my answer");
		Element.verifyElementNotPresent(lnkChangeOption2, "Change my answer for organization type");
		
		Element.click(rdoVoOnly,"VCP only payment type");
		Element.click(btnIAgree, "I agree button");
		Element.verifyElementPresent(lnkChangeOption2, "Change my answer for organization type");
		Element.click(lnkChangeOption2,"Change my answer");
		Element.verifyElementNotPresent(lnkChangeOption2, "Change my answer for organization type");
		
		Element.click(rdoAV,"ACH & VCP both payment type");
		Element.click(btnIAgree, "I agree button");
		Element.verifyElementPresent(lnkChangeOption2, "Change my answer for organization type");
		Element.click(lnkChangeOption2,"Change my answer");
		Element.verifyElementNotPresent(lnkChangeOption2, "Change my answer for organization type");
		
		return this;
	}
	
	public BeginEnrollmentContinue verifyPopUp()
	{
		clickRdoHealthOrg();
		Element.click(rdoVoOnly,"VCP only payment type");
		Element.verifyElementPresent(boxVCP, "VCP POP UP BOX");
		Browser.wait(testConfig, 2);
		Element.click(btnVCPCacnel, "VCP Cancel");
		Browser.verifyURL(testConfig, "beginEnrollmentContinue.do");
		return this;
	}
	
	public void verifyErrorMsg()
	{
		clickRdoHealthOrg();
		Element.click(rdoAchOnly,"ACH only payment type");
		Element.click(btnContinue, "Continue");
		String errMsg=Element.findElement(testConfig, "id", "tinerror1").getText();
		Helper.compareEquals(testConfig, "ERROR MSG", "Missing Data", errMsg);
		String tinNumber="0011";
		Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
		Element.click(btnContinue, "Continue");
		errMsg=Element.findElement(testConfig, "id", "tinerror1").getText();
		Helper.compareEquals(testConfig, "ERROR MSG", "Missing Data", errMsg);
		tinNumber="abc888ui";
		Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
		Element.click(btnContinue, "Continue");
		errMsg=Element.findElement(testConfig, "id", "tinerror1").getText();
		Helper.compareEquals(testConfig, "ERROR MSG", "Invalid Data", errMsg);
		
	}
}
