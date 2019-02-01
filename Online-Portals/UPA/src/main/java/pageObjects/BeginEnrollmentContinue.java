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

/**
 * @author Amit
 *
 */
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
				clickRdoAO();
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "AO");
				break;
				
			  case "VO":	
				clickRdoVO();
				Element.enterData(txtBoxTin,tinNumber, "Entered unique tin number as: " + tinNumber,"txtBoxTin");
				testConfig.putRunTimeProperty("enrollmentType", "VO");
				break;
				
			  case "AV":
				clickRdoAV();
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
		Element.click(rdoHealthcare,"HealthCare Organisation type");
		return this;
	}
	
	public BeginEnrollmentContinue clickRdoAO()
	{
		Element.click(rdoAchOnly,"ACH only payment type");
		return this;
	}
	
	public BeginEnrollmentContinue clickRdoVO()
	{
		Element.click(rdoVoOnly,"VCP only payment type");
		Element.click(btnIAgree, "I agree button");
		return this;
	}
	
	public BeginEnrollmentContinue clickRdoAV()
	{
		Element.click(rdoAV,"ACH & VCP both payment type");
		Element.click(btnIAgree, "I agree button");
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
	
	public BeginEnrollmentContinue clickChooseLinkFunctionality(WebElement lnkChoose,WebElement boxPopUp,WebElement closeTip)
	{
		Element.click(lnkChoose, "Choose Link ");
		Element.verifyElementPresent(boxPopUp, "Pop Up Box");
		Element.click(closeTip, "Close tip");
		return this;
	}
	
	public BeginEnrollmentContinue clickChooseLink()
	{
		clickChooseLinkFunctionality(lnkChoose1,boxLinkPopUp1,closeTip1);
		clickRdoHealthOrg(); 
		clickChooseLinkFunctionality(lnkChoose2,boxLinkPopUp2,closeTip2);
		Browser.verifyURL(testConfig, "beginEnrollmentContinue.do");
		return this;
	}
	
	
	/*click on change link and verifies it.
	input --> link to change option*/ 
	public void verifyChangeLinkFunctionality(WebElement lnkChng)
	{
		Element.verifyElementPresent(lnkChng, "Change my answer for organization type");
		Element.click(lnkChng,"Change my answer");
		Element.verifyElementNotPresent(lnkChng, "Change my answer for organization type");
	}
	
	public BeginEnrollmentContinue verifyChangeLink()
	{
		clickRdoHealthOrg();
		verifyChangeLinkFunctionality(lnkChangeOption);
		
		clickRdoHealthOrg();
		clickRdoAO(); 
		verifyChangeLinkFunctionality(lnkChangeOption2);
		
		clickRdoVO();
		verifyChangeLinkFunctionality(lnkChangeOption2);
		
		clickRdoAV();
		verifyChangeLinkFunctionality(lnkChangeOption2);
		return this;
	}
	
	public BeginEnrollmentContinue verifyPopUpFunctionality(WebElement payOptn)
	{
		Element.click(payOptn,"Payment Type selected");
		Element.verifyElementPresent(boxVCP, "VCP POP UP BOX");
		Element.click(btnVCPCacnel, "VCP Cancel");
		Browser.verifyURL(testConfig, "beginEnrollmentContinue.do");
		return this;
	}
	
	public BeginEnrollmentContinue verifyPopUp(String paymentType)
	{
		clickRdoHealthOrg();
		if(paymentType.equals("VO"))
			verifyPopUpFunctionality(rdoVoOnly);
		else
			verifyPopUpFunctionality(rdoAV);
		return this;
	}
	
	public BeginEnrollmentContinue ErrorMsgFunctionality(String expected)
	{
		Element.click(btnContinue, "Continue");
		String errMsg=Element.findElement(testConfig, "id", "tinerror1").getText();
		Helper.compareEquals(testConfig, "ERROR MSG", expected, errMsg);
		return this;
	}
	
	public BeginEnrollmentContinue verifyErrorMsg()
	{
		clickRdoHealthOrg();
		clickRdoAO();
		ErrorMsgFunctionality("Missing Data");
		
		Element.enterData(txtBoxTin,"0011", "Entered unique tin number as: 0011","txtBoxTin");
		ErrorMsgFunctionality("Missing Data");
		
		Element.enterData(txtBoxTin,"abc888ui", "Entered unique tin number as: abc888ui","txtBoxTin");
		ErrorMsgFunctionality("Invalid Data");
		
		Element.enterData(txtBoxTin,"&{{-*-}}&", "Entered unique tin number as: abc888ui","txtBoxTin");
		ErrorMsgFunctionality("Invalid Data");
		return this;
	}
}
