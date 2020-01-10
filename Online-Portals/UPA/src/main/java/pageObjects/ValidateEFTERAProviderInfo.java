package main.java.pageObjects;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.DataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;

public class ValidateEFTERAProviderInfo {

	protected TestBase testConfig;
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	//First provider details
	
	@FindBy(name="firstNameContact1")
	WebElement firstProvFName;
	
	@FindBy(name="middleNameContact1")
	WebElement firstProvMName;
	
	@FindBy(name="lastNameContact1")
	WebElement firstProvLName;
	
	@FindBy(name="phoneNum1Contact1")
	WebElement firstProvPhField1;
	
	@FindBy(name="phoneNum2Contact1")
	WebElement firstProvPhField2;
	
	@FindBy(name="phoneNum3Contact1")
	WebElement firstProvPhField3;
	
	@FindBy(id="EFTERAenrBSForm")
	List<WebElement> pageForm;
	
	@FindBy(name="emailContact1")
	WebElement firstProvEmail;
	
	@FindBy(name="mobilePhone1Contact1")
	WebElement firstProvMobField1;
	
	@FindBy(name="mobilePhone2Contact1")
	WebElement firstProvMobField2;
	
	@FindBy(name="mobilePhone3Contact1")
	WebElement firstProvMobField3;
	
	@FindBy(id="sendAlertsContact1")
	WebElement firstProvMobAlert;
	
	@FindBy(id="sendAlertsContact2")
	WebElement scndProvMobAlert;

	@FindBy(id="emailmailContactOne")
	WebElement emailAdr;
	
	@FindBy(id="verifyEmailContactOne")
	WebElement verifyEmailaddr;
	
	@FindBy(id="emailcontact2")
	WebElement emailAdr2;
	
	@FindBy(id="verifyemailContact2")
	WebElement verifyEmailaddr2;
	
	@FindBy(name="verifyEmailContact1")
	WebElement verifyFirstProvEmail;
	
	@FindBy(id="telephoneNumberContact1")
	WebElement telephoneNumberContact1;
	
	@FindBy(id="telephoneContact2")
	WebElement telephoneNumberContact2;
	
	//Second Provider Details
	
	@FindBy(name="firstNameContact2")
	WebElement secondProvFName;
	
//	@FindBy(name="middleNameContact2")
	@FindBy(xpath="//input[@name='middleNameContact2']")
	WebElement secondProvMName;
	
	@FindBy(name="lastNameContact2")
	WebElement secondProvLName;
	
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
	
	@FindBy(name="mobileAlertCheckedContact1")
	WebElement mobileAlertCheckedContact1;
	
	@FindBy(name="mobileAlertCheckedContact2")
	WebElement mobileAlertCheckedContact2;
	
	@FindBy(name="mobilePhone1Contact1")
	WebElement mobilePhone1Contact1;
	
	@FindBy(name="mobilePhone2Contact1")
	WebElement mobilePhone2Contact1;
	
	@FindBy(name="mobilePhone3Contact1")
	WebElement mobilePhone3Contact1;
	
	@FindBy(name="mobilePhone1Contact2")
	WebElement mobilePhone1Contact2;
	
	@FindBy(name="mobilePhone2Contact2")
	WebElement mobilePhone2Contact2;
	
	@FindBy(name="mobilePhone3Contact2")
	WebElement mobilePhone3Contact2;
	
	@FindBy(name="mobilePhone1Contact2")
	WebElement SecProvMobField1;
	
	@FindBy(name="mobilePhone2Contact2")
	WebElement SecProvMobField2;
	
	@FindBy(name="mobilePhone3Contact2")
	WebElement SecProvMobField3;
	
	@FindBy(id="sendAlertsContact2")
	WebElement SecProvMobAlert;
	
	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;
	
	@FindBy(linkText="CANCEL ENROLLMENT")
	WebElement btnCnclEnrlmnt;
	
	@FindBy(linkText="BACK")
	WebElement btnBack;
	
	@FindBy(linkText="CLEAR ADMINISTRATOR INFORMATION")
	WebElement btnCrlAdmnInfo;
		
	@FindBy(xpath = "//tr[@class='subheadernormal'][2]//td//table//tr//td//b")
	WebElement txtSecurityBold;
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][2]//td//table//tr//td//u")
	WebElement txtSecurityUnderlined;
	
	@FindBy(xpath = "//tr[3]/td/table/tbody/tr/td[2]")
	WebElement txtSecurityNormal;
	
	@FindBy(xpath ="//strong[contains(text(),'Optum Pay Enrollment - Confirm Existing User')]")
	WebElement exitingUserHeaderMsg;
	
	@FindBy(xpath ="//section//fieldset//div[1]/div//p")
	WebElement exitingUserMsg;
	
	@FindBy(xpath ="//section//table//tbody//tr")
	List<WebElement> associatedTinsTable;
	
	@FindBy(xpath ="//input[@id='yes']//following-sibling::label")
	WebElement rdoYes;

	@FindBy(xpath ="//input[@id='no']//following-sibling::label")
	WebElement rdoNo;
	
	@FindBy(linkText="Learn about alert frequency")
	WebElement lnkAlertFrequency;
	
	@FindBy(linkText="CLOSE TIP") 
	WebElement lnkClosTip;
	
	@FindBy(xpath="//section//form/div[3]/div[1]/div")
	List<WebElement> divFrqncyPopUp;
	
	@FindBy(xpath="//section//form/a")
	WebElement lnkClrAdmnInfo;
	
	@FindBy(xpath="//section//form/div[5]/div[1]/div")
	List<WebElement> divClrInfo;
	
	@FindBy(xpath="//section//form/div[4]/div[1]/div")
	List<WebElement> divCnclEnrlmnt;
		
	@FindBy(name="btnCancel")
	WebElement btnCancel;
	
	@FindBy(linkText="SAVE CHANGES")
	WebElement savChanges;
	
	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List <WebElement> BSInfoHeaders;
	
	@FindBy(xpath = ".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/legend/h1")
	WebElement identifyAdminHeader;
	
	@FindBy(xpath = ".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/p[1]")
	WebElement identifyMemberAdmin;
	
	@FindBy(xpath = ".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/p[2]")
	WebElement additionalMemberText;
	
	@FindBy(xpath = ".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/h4/strong")
	WebElement primaryAdminInfoHeader;
	
	@FindBy(xpath = ".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/h4/strong")
	WebElement primaryAdminInfoSubHeader;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[2]/fieldset/h4/strong")
	WebElement secondaryAdminInfoHeader;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[2]/fieldset/p")
	WebElement secondaryAdminInfoSubHeader;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/div[1]/strong")
	WebElement  accountAdministrators;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/div[1]/ul/li[1]")
	WebElement  accountAdminList1;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/div[1]/ul/li[2]")
	WebElement  accountAdminList2;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/div[1]/ul/li[3]")
	WebElement  accountAdminList3;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/p[3]")
	WebElement  requiredFields;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/fieldset[2]/div/div/div/label/span")
	WebElement  futureUpdateChecbox;
	
	@FindBy(xpath ="/.//*[@id='EFTERAenrBSForm']/section[1]/fieldset/fieldset[2]/div/div/div/label/span")
	WebElement primaryfutureUpdateinfo;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[2]/fieldset/fieldset[2]/div/div/div/label/span")
	WebElement secondaryfutureUpdateinfo;
		
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/div[3]/div[2]/label[1]")
	WebElement  primaryEmailAdressInfo;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/div[3]/div[2]/label[2]")
	WebElement  primaryRetypeEmailAdressInfo;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[2]/fieldset/div[2]/div[2]/label[1]")
	WebElement  secondaryEmailAdressInfo;
	
	@FindBy(xpath =".//*[@id='EFTERAenrBSForm']/section[2]/fieldset/div[2]/div[2]/label[2]")
	WebElement  secondaryRetypeEmailAdressInfo;
	
	@FindBy(xpath="//div[@class='error']//h4")
	WebElement errorHeader;
	
	@FindBy(xpath = "//div[@class='error']//a") 
	WebElement errorLink;
	
	@FindBy(xpath = "//p[@class='error-msg']") 
	WebElement error;
	
	@FindBy(xpath = "//form//div[7]//div[1]/label") 
	WebElement btnYesOnExsistingEmailPage;
	
	@FindBy(xpath = "//form//div[7]//div[2]/label") 
	WebElement btnNoOnExsistingEmailPage;
	
	@FindBy(xpath="//*[@id='EFTERAregForm']/div[5]/div[1]")
	WebElement divClrAdminInfo;
	
	@FindBy(linkText="NO")
	WebElement btnNo;
	
	@FindBy(linkText="YES")
	WebElement btnYes;
	
	@FindBy(xpath="//*[@id='yesnosecondary']//div[2]/label")
	WebElement rdoBtnNoSec;
	
	@FindBy(xpath="//*[@id='yesnoprimary']//div[2]/label")
	WebElement rdoBtnNoPri;
	
	@FindBy(name="btnCancel")
	WebElement btnCnclChng;
	
	@FindBy(linkText="SAVE CHANGES")
	WebElement btnSavChng;
	
	@FindBy(xpath="//div[@class='error']//ul//li")
	List <WebElement> individualErrors;
	
	@FindBy(xpath="//div[@class='modal-container help-modal fixed-modal']//div[@class=' help-modal-content float-left']//p")
	WebElement alertFrequencyPopup;
	
	@FindBy(xpath=".//*[@id='EFTERAenrBSForm']/section[1]/fieldset/fieldset[2]/div/div/div/label/span/a")
	WebElement primaryLearnAlertFrequencyLink;
	
	@FindBy(xpath=".//*[@id='EFTERAenrBSForm']/section[2]/fieldset/fieldset[2]/div/div/div/label/span/a")
	WebElement secondaryLearnAlertFrequencyLink;
	
	@FindBy(xpath=".//*[@id='EFTERAenrBSForm']/div[3]/div[1]/div[3]/a")
	WebElement closeTipButton;
	
	@FindBy(xpath="//a[@class='button--secondary enrollment-container-footer__btn-margin float-right']")
	WebElement backBtn;
	
	HashMap<Integer,HashMap<String,String>> pageData=null;

	
	String fName=Helper.generateRandomAlphabetsString(5);
	String lName=Helper.generateRandomAlphabetsString(5);
	String secondProvEmailAdr=Helper.getUniqueEmailId();
	String firstProvEmailAdr=Helper.getUniqueEmailId().replace("@abc.com", "27@abc.com");
	String phNo = Long.toString(Helper.generateRandomNumber(3));
	String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
	
	String expHeaderMsg="EPS Enrollment - Confirm Existing User";
	
	String frstName="";
	String lstName="";
	String email="";
	
	public ValidateEFTERAProviderInfo(TestBase testConfig)
	{   
		String expectedURL="/validateEFTERAProviderInfo";
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedURL="/validateBSbillingServiceInfo";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
//		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public ValidateEFTERAProviderInfo validateContinueButtonfunctionality()
	{
		Helper.compareEquals(testConfig, "Provider First Namw", firstProvFName.getAttribute("value"),enrollmentInfoPageObj.getFrstName() );
		return this;
	}
	
	public void fillPhoneNumber(String prvoiderType)
	{
//		String expectedText="Enrollment & Account Security Reminder - To help support the security of your account, use of a business issued e-mail domain is required for enrollment and account access.";
//		Element.verifyTextPresent(txtSecurityNormal, expectedText);
		
		
		
		switch(prvoiderType)
		{
		  case "Primary":
		  {
			
			Element.enterData(firstProvPhField1, phNo,"Entered first three digits of phone number as :" + phNo ,"firstProvPhField1");
			Element.enterData(firstProvPhField2, phNo,"Entered second three digits of phone number as :" + phNo,"firstProvPhField2");
			Element.enterData(firstProvPhField3, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"firstProvPhField3");
			enrollmentInfoPageObj.setPhnNumbr(phNo+phNo+phNoLstField);
			break;
		   }
		  case "Secondary":
		  {
		   Element.enterData(secondProvPhField1, phNo, "Entered first three digits of phone number as :" + phNo,"secondProvPhField1");
		   Element.enterData(secondProvPhField2, phNo, "Entered second three digits of phone number as :" + phNo,"secondProvPhField2");
		   Element.enterData(secondProvPhField3, phNoLstField, "Entered last four digits of phone number as :" + phNoLstField,"secondProvPhField3");
		   break;
		  } 
	     }
		 
	}
	
	public  ValidateEFTERAProviderInfo fillPrimaryProvInfo()
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
	
	public  ValidateEFTERAProviderInfo fillMobileCntct(String providerType)
	{	
		switch(providerType)
		{
		  case "Primary":
		  {
			
			Element.enterData(firstProvMobField1, phNo,"Entered first three digits of phone number as :" + phNo ,"firstProvMobField1");
			Element.enterData(firstProvMobField2, phNo,"Entered second three digits of phone number as :" + phNo,"firstProvMobField2");
			Element.enterData(firstProvMobField3, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"firstProvMobField3");
			
			break;
		   }
		  case "Secondary":
		  {
		   Element.enterData(SecProvMobField1, phNo, "Entered first three digits of phone number as :" + phNo,"SecProvMobField1");
		   Element.enterData(SecProvMobField2, phNo, "Entered second three digits of phone number as :" + phNo,"SecProvMobField2");
		   Element.enterData(SecProvMobField3, phNoLstField, "Entered last four digits of phone number as :" + phNoLstField,"SecProvMobField3");
		   
		   break;
		  } 
	     }
		
		return this;
	}
	
	public ValidateEFTERAProviderInfo verifyMobileNoChckBoxfunctionality()
	{
		fillMobileCntct("Primary");
		Helper.compareEquals(testConfig, "check box is not disabled",null,firstProvMobAlert.getAttribute("disabled") );
		Element.enterData(firstProvMobField3, "89","Entered last four digits of phone number as : 89"  ,"firstProvMobField3");
		Helper.compareEquals(testConfig, "", "true", firstProvMobAlert.getAttribute("disabled"));
		
		fillMobileCntct("Secondary");
		Helper.compareEquals(testConfig, "check box is not disabled",null,scndProvMobAlert.getAttribute("disabled") );
		Element.enterData(SecProvMobField3, "89","Entered last four digits of phone number as : 00"  ,"SecProvMobField3");
		Helper.compareEquals(testConfig, "", "true", scndProvMobAlert.getAttribute("disabled"));
		
		return this;
	}

	public  ValidateEFTERAProviderInfo fillPrimaryNoDataProvInfo(String inputType)
	{	
		
		String retypeEmail="";
		if (inputType.equalsIgnoreCase("First Name"))
			{
			frstName=fName;
			fName="";
			}	
		if (inputType.equalsIgnoreCase("Last Name"))
		{
			lstName=lName;
			lName="";
			fName=frstName;
		}
		if (inputType.equalsIgnoreCase("Email Address"))
		{
		email=firstProvEmailAdr;
		firstProvEmailAdr="";
		fName=frstName;
		lName=lstName;
		}
		retypeEmail=firstProvEmailAdr;
		if (inputType.equalsIgnoreCase("ReType Email Address"))
		{	
			
		fName=frstName;
		lName = lstName;
		firstProvEmailAdr=email;
		retypeEmail="";
		}
		Element.enterData(firstProvFName, fName,"Enter First name of first provider as : " + fName,"firstProvFirstName");
		Element.enterData(firstProvLName, lName,"Enter Last name of first provider as : " + lName,"firstProvLastName");
		
		if (inputType.equalsIgnoreCase("Telephone No"))
		{		
			phNo="";
			phNoLstField="";
			Element.enterData(firstProvPhField1, phNo,"Entered first three digits of phone number as :" + phNo ,"firstProvPhField1");
			Element.enterData(firstProvPhField2, phNo,"Entered second three digits of phone number as :" + phNo,"firstProvPhField2");
			Element.enterData(firstProvPhField3, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"firstProvPhField3");
			
		}
		else
		fillPhoneNumber("Primary");
		
		Element.enterData(firstProvEmail, firstProvEmailAdr, "Enter email address of first provider as : " +firstProvEmailAdr,"firstProvEmail");
		Element.enterData(verifyFirstProvEmail, retypeEmail, "Retype email address of first provideras : " +retypeEmail,"verifyFirstProvEmail");
		enrollmentInfoPageObj.setFrstName(fName);
		enrollmentInfoPageObj.setLstName(lName);
		if (inputType.equalsIgnoreCase("Telephone No"))
		enrollmentInfoPageObj.setPhnNumbr(phNo+phNo+phNoLstField);
		
		enrollmentInfoPageObj.setEmail(firstProvEmailAdr);
		Element.click(btnContinue, "Continue");
		
		VerifyError(inputType);
		
		return this;
	}
	public void VerifyError(String inputType)
	{
		switch(inputType)
		{
		case "First Name":
		{	
		
		
		WebElement error=Element.findElement(testConfig, "xpath", "//div[@class='margin-bottom-alpha']/div[1]/p");
		Element.verifyTextPresent(error, "Missing Data");
		break;
		}
		case "Last Name":
		{
			
		
		WebElement errorLstNm=Element.findElement(testConfig, "xpath", "//div[@class='margin-bottom-alpha']/div[3]/p");
		Element.verifyTextPresent(errorLstNm, "Missing Data");
		break;
		}
		case "Telephone No":
		{
			
		
		WebElement Telno=Element.findElement(testConfig, "xpath", "//div[@id='telephoneNumberContact1']/div[3]/p");
		Element.verifyTextPresent(Telno, "Missing Data");
		break;
		}
		case "Email Address":
		{
			
		
		WebElement errorEmlAd=Element.findElement(testConfig, "xpath", "//div[@id='emailmailContactOne']/p");
		Element.verifyTextPresent(errorEmlAd, "Missing Data");
		break;
		}
		case "ReType Email Address":
		{
			
		
		WebElement errorReTypEmlAd=Element.findElement(testConfig, "xpath", "//div[@id='verifyEmailContactOne']/div/p");
		Element.verifyTextPresent(errorReTypEmlAd, "Missing Data");
		break;
		}
		
		}
	}
	
	public ValidateEFTERAProviderInfo verifyDupEmailError(String provType) throws IOException
	{
	   String expHeaderMsg="Optum Pay Enrollment - Confirm Existing User";
	   String expMsg=fillProvInfoWithDupEmail(provType);
	   Element.click(btnContinue, "Continue");
	   
	   Element.verifyTextPresent(exitingUserHeaderMsg,expHeaderMsg);
	   Element.verifyElementPresent(btnYesOnExsistingEmailPage, "Yes BTN");
	   Element.verifyElementPresent(btnNoOnExsistingEmailPage, "NO BTN");
	  
	   return this;
	}
	
	public void verifyIdentifyAdminDupEmailContentManaged() throws IOException
	{
		int sqlRowNo=169;
		String expectedColor="#c21926";
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		WebElement page=Element.findElement(testConfig, "xpath", "//*[@id='EFTERAenrBSForm']//fieldset");
		
		Helper.compareEquals(testConfig, "Compare Heading",dataTest.get(1).get("TEXT_VAL")+"\n"+dataTest.get(21).get("TEXT_VAL")
				+"\n"+dataTest.get(1).get("TEXT_VAL")+"\n"+dataTest.get(22).get("TEXT_VAL")
				,page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[3]")).getText());
		
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(3).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[4]//dl/dt[1]")).getText());
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(4).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[4]//dl/dt[2]")).getText());
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(8).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[4]//dl/dt[3]")).getText());
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(9).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[4]//dl/dt[4]")).getText());
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(10).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[4]//dl/dt[5]")).getText());
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(11).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[5]//h4")).getText());
		
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(12).get("TEXT_VAL")+" "+dataTest.get(13).get("TEXT_VAL")+" "+dataTest.get(14).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[5]//thead")).getText());
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(18).get("TEXT_VAL")+"\n"+dataTest.get(17).get("TEXT_VAL"),page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[6]")).getText());
		Helper.compareEquals(testConfig, "Yes No Radio  Button",dataTest.get(19).get("TEXT_VAL")+"\n"+dataTest.get(20).get("TEXT_VAL")
				+"\n"+dataTest.get(19).get("TEXT_VAL")+"\n"+dataTest.get(20).get("TEXT_VAL")
				,page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[7]")).getText());
		Element.click(btnContinue, "Continue Button");
		Browser.wait(testConfig, 2);
		errorHeader=Element.findElement(testConfig, "xpath", "//span[@id='iconwarning']");
		Element.verifyElementPresent(errorLink, "Error Link");
		Helper.compareEquals(testConfig, "Verify error Link is highlighted in red color" , expectedColor, Color.fromString(errorLink.getCssValue("border-top-color")).asHex());
		Element.verifyElementPresent(errorHeader, "Error msg Header");
		Browser.wait(testConfig, 20);
		Element.click(rdoBtnNoPri, "Pri Prov No button");
		Element.click(rdoBtnNoSec, "Sec Prov No button");
		Element.click(btnContinue, "Continue Button");
		verifyDupEmailError("Primary");
		page=Element.findElement(testConfig, "xpath", "//*[@id='EFTERAenrBSForm']//fieldset");
		Helper.compareEquals(testConfig, "Compare page Data",dataTest.get(1).get("TEXT_VAL")+"\n"+dataTest.get(2).get("TEXT_VAL")
				,page.findElement(By.xpath("//*[@id='EFTERAenrBSForm']//div[3]")).getText());
		
	
	}
	
	public ValidateEFTERAProviderInfo verifyYesBtnFunctionality() throws IOException
	{
		Element.click(btnYesOnExsistingEmailPage, "Yes Button");
		Element.click(btnContinue, "Continue");
		int sqlRowNo=167;
		Map adminData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			
		String firstName=firstProvFName.getAttribute("value");
		String email=firstProvEmail.getAttribute("value");
		String lastName=firstProvLName.getAttribute("value");
		String telNo=firstProvPhField1.getAttribute("value")+firstProvPhField2.getAttribute("value")+firstProvPhField3.getAttribute("value");
		Helper.compareEquals(testConfig, "Provider First Name", firstName, adminData.get("FST_NM"));
		Helper.compareEquals(testConfig, "Provider Last Name", lastName, adminData.get("LST_NM"));
		Helper.compareEquals(testConfig, "Provider Phone Number", telNo, adminData.get("TEL_NBR"));
		Helper.compareEquals(testConfig, "Provider Email", email, adminData.get("EMAIL_ADR_TXT"));
		
	   return this;
	}
	
	public ValidateEFTERAProviderInfo verifyNoBtnFunctionality() throws IOException
	{
	   Element.click(btnNoOnExsistingEmailPage, "No Button");
	   Element.click(btnContinue, "Continue");
	   String firstNameString=firstProvFName.getAttribute("value");
	   Helper.compareEquals(testConfig, "Provider First Name", firstNameString, "");
	   return this;
	}
	
	public ValidateEFTERAProviderInfo verifyAssociatedTinsData() throws IOException
	{
		int sqlRowNo=9;
		HashMap<Integer,HashMap<String,String>> gridData=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
		verifyAssociatedTins();
		ArrayList<String> orgNameFromUI=new ArrayList<String>();
		ArrayList<String> accsLvlFromUI=new ArrayList<String>();
		for(int i=0;i<associatedTinsTable.size();i++)
		{
			orgNameFromUI.add(associatedTinsTable.get(i).findElements(By.tagName("td")).get(1).getText());
			accsLvlFromUI.add(associatedTinsTable.get(i).findElements(By.tagName("td")).get(2).getText());
		}
		
		ArrayList<String> orgNameFromDB=new ArrayList<String>();
		ArrayList<String> accsLvlFromDB=new ArrayList<String>();
		for (int i = 1; i <= gridData.size(); i++) 
		{
			orgNameFromDB.add(gridData.get(i).get("ORG_NM"));
			if(gridData.get(i).get("ACCESS_LVL").equals("A"))
				accsLvlFromDB.add("Administrator");
			else
				accsLvlFromDB.add("General");
		}
		
		Helper.compareEquals(testConfig, "Associated Org Name", orgNameFromUI, orgNameFromDB);
		Helper.compareEquals(testConfig, "Associated User Level", accsLvlFromUI, accsLvlFromDB);
		return this;
	}
	
	public String fillProvInfoWithDupEmail(String provType)
	{
		String expMsg="";
		int sqlRowNo=6;
		Map enrolledProviderTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String existingEmail=enrolledProviderTable.get("EMAIL_ADR_TXT").toString().trim();
		testConfig.putRunTimeProperty("email", existingEmail);
		
		fillPrimaryProvInfo();
		if(provType.equals("Primary"))
		 {
		   Element.enterData(firstProvEmail,existingEmail , "Enter already existing provider email address as : "+ existingEmail,"firstProvEmail");
		   Element.enterData(verifyFirstProvEmail, existingEmail, "Retype existing email address of first provider as :" + existingEmail ,"verifyFirstProvEmail");
		 }
		else if(provType.equals("Secondary"))
		 {
			fillSecondProvInfo();
			Element.enterData(secondProvEmail, existingEmail, "Enter email address of Second provider as : "+ existingEmail,"secondProvEmail");
			Element.enterData(verifySecondProvEmail, existingEmail, "Retype email address of Second provider as : "+ existingEmail,"verifySecondProvEmail");
		 }
		else
		{
			sqlRowNo=125;
			enrolledProviderTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			fillPrimaryProvInfo();
			fillSecondProvInfo();
			Element.enterData(firstProvEmail,existingEmail , "Enter already existing provider email address as : "+ existingEmail,"firstProvEmail");
			Element.enterData(verifyFirstProvEmail, existingEmail, "Retype existing email address of first provider as :" + existingEmail ,"verifyFirstProvEmail");
			Element.enterData(secondProvEmail, enrolledProviderTable.get("EMAIL_ADR_TXT").toString(), "Enter email address of Second provider as : "+ enrolledProviderTable.get("EMAIL_ADR_TXT").toString(),"secondProvEmail");
			Element.enterData(verifySecondProvEmail, enrolledProviderTable.get("EMAIL_ADR_TXT").toString(), "Retype email address of Second provider as : "+ enrolledProviderTable.get("EMAIL_ADR_TXT").toString(),"verifySecondProvEmail");
		}
		return getDupErrorMsg(provType);
	}
	
	
	public String getDupErrorMsg(String provType)
	{
		String expMsg="The email address you entered for at least one of the contacts already exists in our records. The contact information and TINs already associated with this email address are below.";
		if(provType.equals("Primary"))
			return expMsg;
		else if(provType.equals("Secondary"))
		{
			expMsg="The email address you entered for the Secondary Contacts already exists in our records. The contact information and TINs already associated with this email address are below.";
			return expMsg;
		}
		else
		 return expMsg;
			
		
	}
	
	public ValidateEFTERAProviderInfo verifyAssociatedTins() throws IOException
	{
		Helper.compareEquals(testConfig, "Associated Tin List", getAssociatedTinsFromDB(), getAssociatedTinsFromUI());
		return this;
	}
	
	
	public ArrayList<String> getAssociatedTinsFromUI()
	{
         ArrayList<String> tinsFromUI=new ArrayList<String>();
		for(int i=0;i<associatedTinsTable.size();i++)
			tinsFromUI.add(associatedTinsTable.get(i).findElements(By.tagName("td")).get(0).getText());
		Collections.sort(tinsFromUI);
		return tinsFromUI;
	}
	
	
	public ArrayList<String> getAssociatedTinsFromDB() throws IOException
	{
	   int sqlNo=9;
       ArrayList<String> tinsListFromDB = new ArrayList<String>();
	   HashMap<Integer, HashMap<String, String>> portalUser=DataBase.executeSelectQueryALL(testConfig,sqlNo);
	   for (int i = 1; i <= portalUser.size(); i++) 
		   tinsListFromDB.add(portalUser.get(i).get("PROV_TIN_NBR"));
	   Collections.sort(tinsListFromDB);
	   	return tinsListFromDB;
	}
		
	
	public  ValidateEFTERAProviderInfo fillSecondProvInfo()
	{
		Element.enterData(secondProvFName, fName,"Enter First name of Second provider as: "+ fName,"secondProvFirstName");
		Element.enterData(secondProvLName, lName,"Enter Last name of Second provider as : "+ lName,"secondProvLastName");
		fillPhoneNumber("Secondary");
		Element.enterData(secondProvEmail, secondProvEmailAdr, "Enter email address of Second provider","secondProvEmail");
		Element.enterData(verifySecondProvEmail, secondProvEmailAdr, "Retype email address of Second provider","verifySecondProvEmail");
		return this;
	}
	
	public ValidateEFTERAProviderInfo fillProvInfoWrngEmail(String inputType,String  inputFormat)
	{
		ArrayList <WebElement> tmpProv=new ArrayList<WebElement>();
		if (inputType.equals("Secondary"))
		{
		ArrayList <WebElement> secProv=new ArrayList<WebElement>();
		secProv.add(secondProvFName);
		secProv.add(secondProvLName);
		secProv.add(secondProvEmail);
		secProv.add(verifySecondProvEmail);
		tmpProv=secProv;
		}
		if (inputType.equals("Primary"))
		{
		ArrayList <WebElement> prmProv=new ArrayList<WebElement>();
		prmProv.add(firstProvFName);
		prmProv.add(firstProvLName);
		prmProv.add(firstProvEmail);
		prmProv.add(verifyFirstProvEmail);
		tmpProv=prmProv;
		}
		
		Element.enterData(tmpProv.get(0), fName,"Enter First name of"+ inputType +"provider as: "+ fName,"ProvFirstName");
		Element.enterData(tmpProv.get(1), lName,"Enter Last name of" + inputType + "provider as : "+ lName,"ProvLastName");
		fillPhoneNumber(inputType);
		String ProvEmailAdr=null;
		if (inputFormat.equals("inpFormatOne")){
		 ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "");
		 	}
		if (inputFormat.equals("inpFormatTwo")){
			ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "abc.com");
		}
		if (inputFormat.equals("inpFormatThree")){
			 ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "@xyzcom");
		}
		Element.enterData(tmpProv.get(2), ProvEmailAdr, "Enter email address of " + inputType + " provider"+ProvEmailAdr,"ProvEmail");
		Element.enterData(tmpProv.get(3), ProvEmailAdr, "Retype email address of " + inputType + " provider"+ProvEmailAdr,"ProvEmailAdr");
		Element.click(btnContinue, "Continue");
		
		
		if (inputType.equals("Secondary"))
		{
		WebElement errorEmail=Element.findElement(testConfig, "xpath", "//div[@id='emailcontact2']/p");
		Element.verifyTextPresent(errorEmail, "Invalid Data");
		}
		WebElement errorRetypeEmail=null;
		if (inputType.equals("Primary"))
		errorRetypeEmail=Element.findElement(testConfig, "xpath", "//div[@id='emailmailContactOne']/p");
		else
		 errorRetypeEmail=Element.findElement(testConfig, "xpath", "//*[@id='verifyemailContact2']/p");
		Element.verifyTextPresent(errorRetypeEmail, "Invalid Data");
		return this;
	}
	


	
	public  ValidateEFTERAProviderInfo fillProvMailComp(String inputType)
	{	
		
		ArrayList <WebElement> tmpProv=new ArrayList<WebElement>();
		if (inputType.equals("Secondary"))
		{
		ArrayList <WebElement> secProv=new ArrayList<WebElement>();
		secProv.add(secondProvFName);
		secProv.add(secondProvLName);
		secProv.add(secondProvEmail);
		secProv.add(verifySecondProvEmail);
		tmpProv=secProv;
		}
		if (inputType.equals("Primary"))
		{
		ArrayList <WebElement> prmProv=new ArrayList<WebElement>();
		prmProv.add(firstProvFName);
		prmProv.add(firstProvLName);
		prmProv.add(firstProvEmail);
		prmProv.add(verifyFirstProvEmail);
		tmpProv=prmProv;
		}
		
		
		
		Element.enterData(tmpProv.get(0), fName,"Enter First name of"+ inputType +"provider as: "+ fName,"ProvFirstName");
		Element.enterData(tmpProv.get(1), lName,"Enter Last name of" + inputType + "provider as : "+ lName,"ProvLastName");
		fillPhoneNumber(inputType);
		Element.enterData(tmpProv.get(2), firstProvEmailAdr, "Enter email address of " + inputType + " provider as : " +firstProvEmailAdr,"ProvEmail");
		
		String retypeEmail=Helper.getUniqueEmailId();
		if(!retypeEmail.equals(firstProvEmailAdr))
		Element.enterData(tmpProv.get(3), retypeEmail, "Retype email address of " + inputType + " provider as : " +retypeEmail,"verifyProvEmail");
		enrollmentInfoPageObj.setFrstName(fName);
		enrollmentInfoPageObj.setLstName(lName);
		enrollmentInfoPageObj.setEmail(firstProvEmailAdr);
		Element.click(btnContinue, "Continue");
		WebElement errorRetypeEmail=null;
		
		if (inputType.equals("Primary"))
		errorRetypeEmail=Element.findElement(testConfig, "xpath", "//div[@id='verifyEmailContactOne']/div/p");
		
		if (inputType.equals("Secondary"))
		errorRetypeEmail=Element.findElement(testConfig, "xpath", "//*[@id='verifyemailContact2']/p");
		Element.verifyTextPresent(errorRetypeEmail, "Invalid Data");
		return this;

		
	}
	



	public ValidateEFTERAProviderInfo fillProvInfoName(String inputType,String inputField,String data)
	{
		
		String alphaNumChar="[a-zA-Z0-9]*";
		int flag=1;
		
		if (data.matches(alphaNumChar))
		flag=2;
		
		
		ArrayList <WebElement> tmpProv=new ArrayList<WebElement>();
		if (inputType.equals("Secondary"))
		{
		ArrayList <WebElement> secProv=new ArrayList<WebElement>();
		secProv.add(secondProvFName);
		secProv.add(secondProvMName);
		secProv.add(secondProvLName);
		secProv.add(secondProvEmail);
		secProv.add(verifySecondProvEmail);
		tmpProv=secProv;
		}
		if (inputType.equals("Primary"))
		{
		ArrayList <WebElement> prmProv=new ArrayList<WebElement>();
		prmProv.add(firstProvFName);
		prmProv.add(firstProvMName);
		prmProv.add(firstProvLName);
		prmProv.add(firstProvEmail);
		prmProv.add(verifyFirstProvEmail);
		tmpProv=prmProv;
		}
		
		
		switch(inputField)
		{
		case "First Name":
		Element.enterData(tmpProv.get(0), data,"Enter First name of Second provider as: "+ data,"ProvFirstName");
		Element.enterData(tmpProv.get(2), lName,"Enter Last name of Second provider as : "+ lName,"ProvLastName");
		break;
		case "Middle Name":
		Element.enterData(tmpProv.get(0), fName,"Enter First name of Second provider as: "+ fName,"ProvFirstName");
		Element.enterData(tmpProv.get(1), data,"Enter Middle name of Second provider as: "+ data,"ProvMName");
		Element.enterData(tmpProv.get(2), lName,"Enter Last name of Second provider as : "+ lName,"ProvLastName");
		break;
		case "Last Name":
		Element.enterData(tmpProv.get(0), fName,"Enter First name of Second provider as: "+ fName,"ProvFirstName");
		secondProvMName.clear();
		Element.enterData(tmpProv.get(2), data,"Enter Last name of Second provider as : "+ data,"ProvLastName");
		break;
		}
		fillPhoneNumber(inputType);
		Element.enterData(tmpProv.get(3), secondProvEmailAdr, "Enter email address of Second provider","ProvEmail");
		Element.enterData(tmpProv.get(4), secondProvEmailAdr, "Retype email address of Second provider","verifyProvEmail");
		Element.click(btnContinue, "Continue");
		
		if (flag ==1)
		verifyBSNames( inputType,inputField);
		if (flag==2)
		{	
		Browser.wait(testConfig, 3);
		Element.click(Element.findElement(testConfig, "linkText", "BACK"), "Back Button");
		}
		return this;
	}
	
	
	


	public void verifyBSNames(String inputType,String element)
	{
		WebElement error=null;
		if (element.equalsIgnoreCase("First Name"))
		{
			
			if (inputType.equals("Secondary"))
			error=Element.findElement(testConfig, "xpath", "//div[@id='fnameSecAdmin']/p");
			else
			error=Element.findElement(testConfig, "xpath", "//div[@class='margin-bottom-alpha']//p");	
			Element.verifyTextPresent(error, "Invalid Data");
		}
		if (element.equalsIgnoreCase("Middle Name"))
		{
			if (inputType.equals("Secondary")) 
			error=Element.findElement(testConfig, "xpath", "//div[@id='middleNmContact2']/div/p");
			else
		    error=Element.findElement(testConfig, "xpath", "//div[@id='middleNmContact1']//p");	
			Element.verifyTextPresent(error, "Invalid Data");
		}
		if (element.equalsIgnoreCase("Last Name"))
		{
			if (inputType.equals("Secondary")) 
			error=Element.findElement(testConfig, "xpath", "//div[@id='lastNmContact2']//p");
			else
			error=Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset/div[3]/div[3]/p");	
			Element.verifyTextPresent(error, "Invalid Data");
		}
	}
	public ValidateEFTERAProviderInfo fillInvalidProvInfo(String provType,String inpdataTyp)
	{
		ArrayList <WebElement> tmpProv=new ArrayList<WebElement>();
		if (provType.equals("Secondary"))
		{
		ArrayList <WebElement> secProv=new ArrayList<WebElement>();
		secProv.add(secondProvFName);
		secProv.add(secondProvLName);
		secProv.add(secondProvEmail);
		secProv.add(verifySecondProvEmail);
		tmpProv=secProv;
		}
		if (provType.equals("Primary"))
		{
		ArrayList <WebElement> prmProv=new ArrayList<WebElement>();
		prmProv.add(firstProvFName);
		prmProv.add(firstProvLName);
		prmProv.add(firstProvEmail);
		prmProv.add(verifyFirstProvEmail);
		tmpProv=prmProv;
		}
		
		String ProvEmailAdr=Helper.getUniqueEmailId();
		String Telno=null;
		Element.enterData(tmpProv.get(0), fName,"Enter First name of  provider as: "+ fName,"ProvFirstName");
		Element.enterData(tmpProv.get(1), lName,"Enter Last name of  provider as : "+ lName,"ProvLastName");
		fillInvalidPhoneNumber(provType,inpdataTyp);
		Element.enterData(tmpProv.get(2), ProvEmailAdr, "Enter email address of  provider","ProvEmail");
		Element.enterData(tmpProv.get(3), ProvEmailAdr, "Retype email address of  provider","verifyProvEmail");
		Element.click(btnContinue, "Continue");
		
		if (provType.equals("Secondary"))
		Telno=Element.findElement(testConfig, "xpath", "//fieldset[@class='margin-bottom-beta'][1]//p").getText();

		if (provType.equals("Primary"))
		Telno=Element.findElement(testConfig, "xpath", "//div[@id='telephoneNumberContact1']/div[3]/p").getText();
		
		Helper.compareEquals(testConfig, "phone no comparision", Telno, "Invalid Data");
		return this;
	}
	
	
	
	public void fillInvalidPhoneNumber(String input,String InpdataType)
	{
		 
		if (InpdataType.equals("nonNumeric"))
		{
		phNo=Helper.generateRandomAlphaNumericString(3);
		phNoLstField=Helper.generateRandomAlphaNumericString(4);
		}
		if (InpdataType.equals("Incomplete"))
		{
		phNo = Long.toString(Helper.generateRandomNumber(2));
		phNoLstField = Long.toString(Helper.generateRandomNumber(3));
		}
		switch(input)
		{
		case "Primary":
		{
			
			Element.enterData(firstProvPhField1, phNo,"Entered first three digits of phone number as :" + phNo ,"firstProvPhField1");
			Element.enterData(firstProvPhField2, phNo,"Entered second three digits of phone number as :" + phNo,"firstProvPhField2");
			Element.enterData(firstProvPhField3, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"firstProvPhField3");
			break;
		 } 

		case "Secondary":
				 {
				   Element.enterData(secondProvPhField1, phNo, "Entered first field of phone number as :" + phNo,"secondProvPhField1");
				   Element.enterData(secondProvPhField2, phNo, "Entered second field of phone number as :" + phNo,"secondProvPhField2");
				   Element.enterData(secondProvPhField3, phNoLstField, "Entered third field of phone number as :" + phNoLstField,"secondProvPhField3");
				 break;
				  } 
		}
		 
	}
	
	public FinancialInstitutionInfoPage clickContinue()
	{
		Element.click(btnContinue, "Continue");
		return new FinancialInstitutionInfoPage(testConfig) ;
	}
	
	public UploadW9 clickContinueToW9() {
		Element.click(btnContinue, "Continue");
		return new UploadW9(testConfig) ;
	}
	public ValidateEFTERAProviderInfo clickYes(String provType)
	{
		Element.click(rdoYes, "Yes radio button");
		Element.click(btnContinue, "Continue");
		Browser.verifyURL(testConfig, "confirmExistingUser.do");
		
		 int sqlNo=13;
		 Map portalUser=DataBase.executeSelectQuery(testConfig,sqlNo, 1);

		if(provType.equals("Primary"))
		 {
		   Log.Comment("Verifying details of Pimary provider..");
		   Helper.compareEquals(testConfig, "First Name",portalUser.get("FST_NM"),firstProvFName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Last Name", portalUser.get("LST_NM"),firstProvLName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 1 ", portalUser.get("TEL_NBR").toString().substring(0,3),firstProvPhField1.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 2 ", portalUser.get("TEL_NBR").toString().substring(3,6),firstProvPhField2.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 3 ", portalUser.get("TEL_NBR").toString().substring(6,10),firstProvPhField3.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Email Address ",  portalUser.get("EMAIL_ADR_TXT"),firstProvEmail.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Re type Email Address",portalUser.get("EMAIL_ADR_TXT"),verifyFirstProvEmail.getAttribute("value"));	
		 }
		else if(provType.equals("Secondary"))
		 {
		   Log.Comment("Verifying details of Secondary provider..");
		   Helper.compareEquals(testConfig, "First Name",portalUser.get("FST_NM"),secondProvFName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Last Name",portalUser.get("LST_NM"),secondProvLName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 1 ",portalUser.get("TEL_NBR").toString().substring(0,3),secondProvPhField1.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 2 ", portalUser.get("TEL_NBR").toString().substring(3,6),secondProvPhField2.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 3 ", portalUser.get("TEL_NBR").toString().substring(6,10),secondProvPhField3.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Email Address ", portalUser.get("EMAIL_ADR_TXT"),secondProvEmail.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Re type Email Address",portalUser.get("EMAIL_ADR_TXT"),verifySecondProvEmail.getAttribute("value"));
		 }
		 
		return this;
	}
	
	public void clickNo(String provType)
	{
		if(Browser.getURL(testConfig).contains("confirmExistingUser.do"))
			Element.click(btnContinue, "Continue");
		
		Element.click(rdoNo, "No radio button");
		Element.click(btnContinue, "Continue");
		Browser.verifyURL(testConfig, "confirmExistingUser.do");
		
		if(provType.equals("Primary"))
		 {
		   Log.Comment("Verifying details of Pimary provider..");
		   Helper.compareEquals(testConfig, "First Name", "",firstProvFName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Last Name", "",firstProvLName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 1 ", "",firstProvPhField1.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 2 ", "",firstProvPhField2.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 3 ", "",firstProvPhField3.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Email Address ", "",firstProvEmail.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Re type Email Address", "",verifyFirstProvEmail.getAttribute("value"));	
		 }
		else
		 {
		   Log.Comment("Verifying details of Secondary provider..");
		   Helper.compareEquals(testConfig, "First Name", "",secondProvFName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Last Name", "",secondProvLName.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 1 ", "",secondProvPhField1.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 2 ", "",secondProvPhField2.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Phone No Field 3 ", "",secondProvPhField3.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Email Address ", "",secondProvEmail.getAttribute("value"));
		   Helper.compareEquals(testConfig, "Re type Email Address", "",verifySecondProvEmail.getAttribute("value"));
		 }
		
	}
	
	public void verifySecondaryDupEmailError()
	{
		String expMsg="The email address you entered for the Secondary Contacts already exists in our records. The contact information and TINs already associated with this email address are below.";
		Element.click(btnContinue, "Continue");   
		Element.verifyTextPresent(exitingUserHeaderMsg,expHeaderMsg);
		Element.verifyTextPresent(exitingUserMsg,expMsg);
	}
	
	public void verifyPrimaryDupEmailError()
	{
		String expMsg="The email address you entered for at least one of the contacts already exists in our records. The contact information and TINs already associated with this email address are below.";
		Element.click(btnContinue, "Continue");   
		Element.verifyTextPresent(exitingUserHeaderMsg,expHeaderMsg);
		Element.verifyTextPresent(exitingUserMsg,expMsg);
	}
	
	public ValidateEFTERAProviderInfo verifyAlertFrequencyPopUp() throws IOException
	{
		int sqlRow=166;
		pageData=DataBase.executeSelectQueryALL(testConfig, sqlRow);
		Element.click(lnkAlertFrequency, "Alert frequency Link");
		Element.verifyElementPresent(lnkClosTip, "Alert frequency PopUp");
		Helper.compareContains(testConfig, "Alert Pop Up Heading",divFrqncyPopUp.get(0).findElement(By.tagName("h4")).getText(),pageData.get(32).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Alert Pop Up Paragraph",divFrqncyPopUp.get(1).findElement(By.tagName("p")).getText(),pageData.get(33).get("CLOBVAL").trim().replace("\n", "").replaceAll("( )+", " "));
		Helper.compareContains(testConfig, "Alert Pop Up Paragraph",divFrqncyPopUp.get(2).findElement(By.tagName("a")).getText(),pageData.get(34).get("TEXT_VAL").toUpperCase());
		Element.click(lnkClosTip, "Close TIP on Pop Up");
		Element.verifyElementNotPresent(lnkClosTip, "Alert frequency PopUp");
		return this;
	}
	
	public ValidateEFTERAProviderInfo verifyClrInfo() 
	{
		Element.click(lnkClrAdmnInfo, "Clear Administrator Information");
		Element.verifyElementPresent(divClrInfo.get(2).findElements(By.tagName("a")).get(1), "Clear Info PopUp");
		Helper.compareContains(testConfig, "Clear Administrator Pop Up Heading",divClrInfo.get(0).findElement(By.tagName("h4")).getText(),pageData.get(40).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Clear Administrator Pop Up Body",divClrInfo.get(1).findElements(By.tagName("p")).get(0).getText(),pageData.get(41).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Clear Administrator Pop Up Body",divClrInfo.get(1).findElements(By.tagName("p")).get(1).getText(),pageData.get(42).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Clear Administrator Pop Up Body",divClrInfo.get(2).findElements(By.tagName("a")).get(0).getText(),pageData.get(38).get("TEXT_VAL").toUpperCase());
		Helper.compareContains(testConfig, "Clear Administrator Pop Up Footer",divClrInfo.get(2).findElements(By.tagName("a")).get(1).getText(),pageData.get(39).get("TEXT_VAL").toUpperCase());
		Element.click(divClrInfo.get(2).findElements(By.tagName("a")).get(1), "NO");
		if(firstProvFName.getAttribute("value").equalsIgnoreCase(""))
			Log.Fail("Failed Verification of functionality upon selection of No button");
		else
			Log.Pass("Passed Verification of functionality upon selection of No button");
		Element.verifyElementNotPresent(divClrInfo.get(2).findElements(By.tagName("a")).get(1), "Clear Info PopUp");
		return this;
	}
	
	public ProviderInformationEFTERAEnroll clickBackBtn()
	{
		Element.click(btnBack, "Clicked Back Button");
		Browser.verifyURL(testConfig, "providerinformationefteraenroll");
		return new ProviderInformationEFTERAEnroll(testConfig);
	}
	
	public ValidateEFTERAProviderInfo clickYesOnClrInfoPopUp()
	{
		Element.click(lnkClrAdmnInfo, "Clear Administrator Information");
		Element.click(divClrInfo.get(2).findElements(By.tagName("a")).get(0), "clicked YES");
		if(firstProvFName.getAttribute("value").equalsIgnoreCase(""))
			Log.Pass("Passed Verification of functionality upon selection of Yes button");
		else
			Log.Fail("Failed Verification of functionality upon selection of Yes button");
		return this;
	}
	
	public ValidateEFTERAProviderInfo clickCancelEnrlmnt() throws IOException
	{
		int sqlRow=166;
		pageData=DataBase.executeSelectQueryALL(testConfig, sqlRow);
		Element.click(btnCnclEnrlmnt, "Cancel Enrollment");
		Element.verifyElementPresent(divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(1), "Clear Info PopUp");
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(0).findElement(By.tagName("h4")).getText(),pageData.get(35).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(1).findElements(By.tagName("p")).get(0).getText(),pageData.get(36).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(1).findElements(By.tagName("p")).get(1).getText(),pageData.get(37).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(0).getText(),pageData.get(38).get("TEXT_VAL").toUpperCase());
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(1).getText(),pageData.get(39).get("TEXT_VAL").toUpperCase());
		
		return this;
	}
	
	public ValidateEFTERAProviderInfo clickNoCancelEnrlmnt()
	{
		Element.click(divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(1), "clicked NO");
		Element.verifyElementNotPresent(divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(1), "Clear Info PopUp");
		return this;
	}
	
	public ValidateEFTERAProviderInfo clickYesCancelEnrlmnt()
	{
		Element.click(btnCnclEnrlmnt, "Cancel Enrollment");
		Element.click(divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(0), "clicked Yes");
		Browser.verifyURL(testConfig, "registrationsignin");
		return this;
	}
	
	
	public ValidateEFTERAProviderInfo verifyContentWithUXDS()
	{
		ArrayList<String> listUI = new ArrayList<String>();
		ArrayList<String> listUXDS = new ArrayList<String>();
		
		listUI.add(testConfig.driver.findElement(By.className("progress-indicator__container")).getText());
		listUI.add(testConfig.driver.findElement(By.xpath("//*[@id='EFTERAregForm']")).getText());
	
		new UXDSPageValidation(testConfig,"Enrollment HO Identify Administrators");
		
		listUXDS.add(Element.findElement(testConfig, "xpath", "//section//header[1]/ul").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//h1 [text()='Identify Administrators']").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//p[1]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//div[2]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//p[2]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//p[3]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]/fieldset/h4").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//p[4]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//div[3]/div[1]/div").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//div[3]/div[2]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//div[3]/div[3]/div").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//fieldset[1]/div/label").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]/fieldset/fieldset[1]/div/div").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//fieldset[2]/div/legend").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//fieldset[2]/div/div").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]/fieldset/div[4]/div[1]/div[1]/label").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]/fieldset/div[4]/div[1]/div[2]/div/label").getText()); // div[1]/div[2]
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[1]//div[4]/div[2]").getText());
		
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//h4").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//p").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//div[1]/div[1]/div").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//div[1]/div[2]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//div[1]/div[3]/div").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//fieldset[1]/div/legend").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]/fieldset/fieldset[1]/div/div").getText());
		
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//fieldset[2]/div/legend").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//fieldset[2]/div/div").getText()); //*[@id="providerContacts"]/section[2]/fieldset/fieldset[1]/div/div
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//div[2]/div[1]/div[1]/label").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//div[2]/div[1]/div[2]/div/label").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/section[2]//div[2]/div[2]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/a").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/footer/a[1]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/footer/a[2]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/footer/a[3]").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//*[@id='providerContacts']/footer/div").getText());
		
		Helper.compareEquals(testConfig, "UI and UXDS", listUXDS, listUI);
		return this;
	}
	
	public ValidateEFTERAProviderInfo verifyPageContent() throws IOException
	{
		int sqlRowNo=166;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
		pageForm=Element.findElements(testConfig, "xpath", "//*[@id='EFTERAregForm']/section");
		
		Helper.compareEquals(testConfig, "Heading", dataTest.get(1).get("TEXT_VAL"), pageForm.get(0).findElement(By.tagName("h1")).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(2).get("CLOBVAL"), pageForm.get(0).findElements(By.tagName("p")).get(0).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(3).get("TEXT_VAL")+"\n"+dataTest.get(4).get("TEXT_VAL")+"\n"+dataTest.get(5).get("TEXT_VAL")+"\n"+dataTest.get(6).get("TEXT_VAL"), pageForm.get(0).findElements(By.tagName("div")).get(0).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(7).get("CLOBVAL"), pageForm.get(0).findElements(By.tagName("p")).get(1).getText());
		Helper.compareEquals(testConfig, "Heading", dataTest.get(10).get("TEXT_VAL"), pageForm.get(0).findElement(By.tagName("h4")).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(8).get("TEXT_VAL")+" () "+dataTest.get(9).get("TEXT_VAL"), pageForm.get(0).findElements(By.tagName("p")).get(2).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(11).get("CLOBVAL"), pageForm.get(0).findElements(By.tagName("p")).get(3).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(12).get("TEXT_VAL")+"\n"+dataTest.get(13).get("TEXT_VAL")+"\n"+dataTest.get(14).get("TEXT_VAL"), pageForm.get(0).findElements(By.tagName("div")).get(1).getText());
		Helper.compareEquals(testConfig, "Paragraph", (dataTest.get(15).get("TEXT_VAL")+"\n"+"–"+"\n"+"–"+"\n"+dataTest.get(16).get("TEXT_VAL")), pageForm.get(0).findElements(By.tagName("fieldset")).get(1).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(17).get("TEXT_VAL")+"\n"+"–"+"\n"+"–"+"\n"+dataTest.get(18).get("CLOBVAL")+" "+dataTest.get(19).get("TEXT_VAL"), pageForm.get(0).findElements(By.tagName("fieldset")).get(2).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(20).get("TEXT_VAL")+"\n"+dataTest.get(21).get("TEXT_VAL")+"\n"+dataTest.get(22).get("CLOBVAL")+"\n"+
				dataTest.get(23).get("TEXT_VAL")+" "+dataTest.get(24).get("TEXT_VAL")+" "+dataTest.get(25).get("TEXT_VAL"), pageForm.get(0).findElements(By.tagName("div")).get(11).getText());
		
		Helper.compareEquals(testConfig, "Heading", dataTest.get(45).get("TEXT_VAL"), pageForm.get(1).findElement(By.tagName("h4")).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(46).get("TEXT_VAL")+" () "+dataTest.get(47).get("TEXT_VAL"), pageForm.get(1).findElements(By.tagName("p")).get(0).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(26).get("CLOBVAL"), pageForm.get(1).findElements(By.tagName("p")).get(1).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(12).get("TEXT_VAL")+"\n"+dataTest.get(13).get("TEXT_VAL")+"\n"+dataTest.get(14).get("TEXT_VAL"), pageForm.get(1).findElements(By.tagName("div")).get(0).getText());
		Helper.compareEquals(testConfig, "Paragraph", (dataTest.get(15).get("TEXT_VAL")+"\n"+"–"+"\n"+"–"+"\n"+dataTest.get(16).get("TEXT_VAL")), pageForm.get(1).findElements(By.tagName("fieldset")).get(1).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(17).get("TEXT_VAL")+"\n"+"–"+"\n"+"–"+"\n"+dataTest.get(18).get("CLOBVAL")+" "+dataTest.get(19).get("TEXT_VAL"), pageForm.get(1).findElements(By.tagName("fieldset")).get(2).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(20).get("TEXT_VAL")+"\n"+dataTest.get(21).get("TEXT_VAL"), pageForm.get(1).findElements(By.tagName("div")).get(13).getText());
		Helper.compareEquals(testConfig, "Paragraph", dataTest.get(22).get("CLOBVAL")+"\n"+dataTest.get(23).get("TEXT_VAL")+" "+dataTest.get(24).get("TEXT_VAL")+" "+dataTest.get(25).get("TEXT_VAL"), pageForm.get(1).findElements(By.tagName("div")).get(17).getText());
		Helper.compareEquals(testConfig, "Clear Administrator Btn", dataTest.get(27).get("TEXT_VAL"), btnCrlAdmnInfo.getText());
		Helper.compareEquals(testConfig, "Back Button", dataTest.get(43).get("TEXT_VAL").toLowerCase(), btnBack.getText().toLowerCase());
		Helper.compareEquals(testConfig, "Continue Button", dataTest.get(44).get("TEXT_VAL").toLowerCase(), btnContinue.getText().toLowerCase());
		Element.click(btnCrlAdmnInfo, "Clear Administrator Information");
		Helper.compareEquals(testConfig, "Clear Administrator Information Div", dataTest.get(40).get("TEXT_VAL")+"\n"+dataTest.get(41).get("TEXT_VAL")+"\n"+dataTest.get(42).get("TEXT_VAL")+"\n"+dataTest.get(38).get("TEXT_VAL").toUpperCase()+" "+dataTest.get(39).get("TEXT_VAL").toUpperCase(), divClrAdminInfo.getText());
		Element.click(btnNo, "No Button Clicked");
		Element.click(lnkAlertFrequency, "Alert Frequency Button");
		Helper.compareEquals(testConfig, "Alert Frequency Pop Up", dataTest.get(32).get("TEXT_VAL"), divFrqncyPopUp.get(0).getText());
		Helper.compareEquals(testConfig, "Alert Frequency Pop Up", dataTest.get(33).get("CLOBVAL").replace("\n", " ").trim().replaceAll("( )+", " "), divFrqncyPopUp.get(1).getText());
		Helper.compareEquals(testConfig, "Alert Frequency Pop Up", dataTest.get(34).get("TEXT_VAL").toUpperCase(), divFrqncyPopUp.get(2).getText());
		Element.click(lnkClosTip, "Close Tip");
		Element.click(btnCnclEnrlmnt, "Cancel Enrollment");
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up", dataTest.get(35).get("TEXT_VAL"), divCnclEnrlmnt.get(0).getText());
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up", dataTest.get(36).get("TEXT_VAL")+"\n"+dataTest.get(37).get("TEXT_VAL"), divCnclEnrlmnt.get(1).getText());
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up",dataTest.get(38).get("TEXT_VAL").toUpperCase()+" "+dataTest.get(39).get("TEXT_VAL").toUpperCase(), divCnclEnrlmnt.get(2).getText());
		sqlRowNo=168;
		Map cancelData=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Cancel Button", cancelData.get("TEXT_VAL").toString().toLowerCase(), btnCnclEnrlmnt.getText().toLowerCase());
		
		return this;
	}
	
	public ValidateEFTERAProviderInfo verifyErrorOnContinueEnrlment()
	{
		String expectedText="Missing Data";
		String expectedColor="#c21926";
		Element.click(btnContinue, "Continue Button");
		
		Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		Element.verifyElementPresent(errorLink, "Error links");
		
		Log.Comment("Verifying Error Msg is displayed for Provider First Name..");
		Element.verifyTextPresent(firstProvFName.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvFName.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Provider Last Name..");
		Element.verifyTextPresent(firstProvLName.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvLName.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Provider Phone Number.."); 
		Element.verifyTextPresent(firstProvPhField1.findElement(By.xpath("//*[@id='telephoneNumberContact1']/div[3]/p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvPhField1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Provider Phone Number..");
//		Element.verifyTextPresent(firstProvPhField2.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvPhField2.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Provider Phone Number..");
//		Element.verifyTextPresent(firstProvPhField3.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvPhField3.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Email..");
//		Element.verifyTextPresent(firstProvEmail.findElement(By.xpath("../following-sibling::p")), expectedText);
		Element.verifyTextPresent(firstProvEmail.findElement(By.xpath("//div[@id='emailmailContactOne']/p")), expectedText); 
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvEmail.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Retype Email address..");
		Element.verifyTextPresent(verifyFirstProvEmail.findElement(By.xpath("//*[@id='verifyEmailContactOne']/div/p")), expectedText); 
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(verifyFirstProvEmail.getCssValue("border-top-color")).asHex());		
		return this;
	}
	
	public  ValidateEFTERAProviderInfo validateAdminInfoFields(String field,String data) throws IOException {
		WebElement ele=null;
		switch(field)
		{
			case "FrstProvFName":
				Element.enterData(firstProvFName, data, "Enter provider First name as :" + data,"providerFName");
				ele=firstProvFName;
				break;
			case "FrstProvLName":
				Element.enterData(firstProvLName, data, "Enter provider Last name as :" + data,"providerLName");
				ele=firstProvLName;
				break;
			case "FrstProvMName":
				Element.enterData(firstProvMName, data, "Enter provider Middle name as :" + data,"providerMName");
				ele=firstProvMName;
				break;
			case "FrstProvPhnNo":
				Element.enterData(firstProvPhField1,  data, "Enter phone no filed1 as :" + data,"PhNo1");
				Element.enterData(firstProvPhField2,  data, "Enter phone no filed2 as :" + data,"PhNo2");
				Element.enterData(firstProvPhField3,  data, "Enter phone no filed3 as :" + data,"PhNo3");
				ele=firstProvPhField1;
				break;
			case "FrstProvEmail":
				Element.enterData(firstProvEmail, data, "Enter Scnd Prov Email","First Prov Email");
				ele=firstProvEmail;
				break;
			case "FrstProvReEmail":
				Element.enterData(verifyFirstProvEmail, data,"Enter Sec Prov ReEmail" + data,"First Prov ReEmail");
				ele=verifyFirstProvEmail;
				break;
				
			case "FrstProvEmailSame":
				Element.enterData(firstProvEmail, data, "Enter First Prov Email: "+data,"First Prov Email");
				Element.enterData(verifyFirstProvEmail, data,"Enter First Prov ReEmail: " + data,"First Prov ReEmail");
				ele=firstProvEmail;
				break;	
				
			case "ScndProvFName":
				Element.enterData(secondProvFName, data, "Enter provider First name as :" + data,"providerFName");
				ele=secondProvFName;
				break;
			case "ScndProvMName":
				Element.enterData(secondProvMName, data, "Enter provider Middle name as :" + data,"providerMName");
				ele=secondProvMName;
				break;
			case "ScndProvLName":
				Element.enterData(secondProvLName, data, "Enter provider Last name as : " + data,"providerLName");
				ele=secondProvLName;
				break;
			case "ScndProvPhnNo":
				Element.enterData(secondProvPhField1,  data, "Enter phone no filed1 as :" + data,"PhNo1");
				Element.enterData(secondProvPhField2,  data, "Enter phone no filed2 as :" + data,"PhNo2");
				Element.enterData(secondProvPhField3,  data, "Enter phone no filed3 as :" + data,"PhNo3");
				ele=secondProvPhField1;
				break;
			case "ScndProvEmail":
				Element.enterData(secondProvEmail, data, "Enter Scnd Prov Email","Sec Prov Email");
				ele=secondProvEmail;
				break;
			case "ScndProvReEmail":
				Element.enterData(verifySecondProvEmail, data,"Enter Sec Prov ReEmail" + data,"Sec Prov ReEmail");
				ele=verifySecondProvEmail;
				break;
				
			case "ScndProvEmailSame":
				Element.enterData(secondProvEmail, data, "Enter Scnd Prov Email: "+data,"Sec Prov Email");
				Element.enterData(verifySecondProvEmail, data,"Enter Sec Prov ReEmail: " + data,"Sec Prov ReEmail");
				ele=verifySecondProvEmail;
				break;
		}
		fillProvInfo(field);
		try
		{
			if(btnContinue.isDisplayed())
				Element.click(btnContinue, "Continue button");
			else 
				Element.clickByJS(testConfig, btnSavChng, "SAVE CHANGE BUTTON");
		}
		catch(NoSuchElementException e)
		{
			String successMsg="Verified Continue Button is not present on the page";
			Log.Pass(successMsg);
			Element.clickByJS(testConfig, btnSavChng, "SAVE CHANGE BUTTON");
			Helper.compareEquals(testConfig, "Cancel Change button is disabled", "true", btnCnclChng.getAttribute("disabled"));
		}
		verifyAdminError(ele);
		return this;

	}
	
	public  ValidateEFTERAProviderInfo fillProvInfo(String field) throws IOException {
		String provName = Helper.generateRandomAlphabetsString(5);
		
		if(!field.equals("FrstProvFName"))
			Element.enterData(firstProvFName, provName, "Enter provider Firts name as :" + provName,"providerFName");
		if(!field.equals("FrstProvLName"))
			Element.enterData(firstProvLName, provName, "Enter provider Last name as :" + provName,"providerLName");
		if(!field.equals("FrstProvMName"))
			Element.enterData(firstProvMName, provName, "Enter provider Middle name as :" + provName,"providerLName");
		if(!field.equals("FrstProvPhnNo"))
		{
			Element.enterData(firstProvPhField1, phNo , "Enter First Prov Phone No1 :" + phNo,"PhNo1");
			Element.enterData(firstProvPhField2, phNo,  "Enter First Prov Phone No2 :" + phNo,"PhNo2");
			Element.enterData(firstProvPhField3, phNoLstField,  "Enter First Prov Phone No3 :" + phNoLstField,"PhNo3");
		}
		if(!field.equals("FrstProvEmail") && !field.equals("FrstProvEmailSame"))
			Element.enterData(firstProvEmail,firstProvEmailAdr , "Enter First Prov Email: "+firstProvEmailAdr,"email");
		if(!field.equals("FrstProvReEmail") && !field.equals("FrstProvEmailSame"))
			Element.enterData(verifyFirstProvEmail, firstProvEmailAdr,"Enter First Prov ReEmail: "+firstProvEmailAdr ,"Re-Email");
		
		
		if(!field.equals("ScndProvFName"))
			Element.enterData(secondProvFName, provName, "Enter provider Firts name as :" + provName,"providerFName");
		if(!field.equals("ScndProvLName"))
			Element.enterData(secondProvLName, provName, "Enter provider Last name as : " + provName,"providerLName");
		if(!field.equals("ScndProvPhnNo"))
		{
			Element.enterData(secondProvPhField1, phNo , "Enter sec Prov Phone No1 :" + phNo,"PhNo1");
			Element.enterData(secondProvPhField2, phNo,  "Enter sec Prov Phone No2 :" + phNo,"PhNo2");
			Element.enterData(secondProvPhField3, phNoLstField,  "Enter sec Prov Phone No3 :" + phNoLstField,"PhNo3");
		}
		if(!field.equals("ScndProvEmail") && !field.equals("ScndProvEmailSame"))
			Element.enterData(secondProvEmail,secondProvEmailAdr , "Enter Sec Prov Email: "+secondProvEmailAdr,"email");
		if(!field.equals("ScndProvReEmail") && !field.equals("ScndProvEmailSame"))
			Element.enterData(verifySecondProvEmail, secondProvEmailAdr,"Enter Sec Prov ReEmail: "+secondProvEmailAdr ,"Re-Email");
		
		return this;
	}	

	public void verifyAdminError(WebElement element)
	{
		String errorMsg="Missing Data";
		
		if(element.equals(firstProvFName))
			if(element.findElement(By.xpath("//div[@id='firstNmContact1']/following-sibling::p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='firstNmContact1']/following-sibling::p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='firstNmContact1']/following-sibling::p")).getText(),"Invalid Data");
		else if(element.equals(firstProvMName))
			Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='middleNmContact1']/p")).getText(),"Invalid Data");
		else if(element.equals(firstProvLName))
			if(element.findElement(By.xpath("//div[@id='lastNmContact1']/following-sibling::p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='lastNmContact1']/following-sibling::p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='lastNmContact1']/following-sibling::p")).getText(),"Invalid Data");
		else if(element.equals(firstProvPhField1))
			if(element.findElement(By.xpath("//div[@id='telephoneNumberContact1']//p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='telephoneNumberContact1']//p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='telephoneNumberContact1']//p")).getText(),"Invalid Data");
		else if(element.equals(firstProvEmail))
			if(element.findElement(By.xpath("//div[@id='emailmailContactOne']/p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='emailmailContactOne']/p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='emailmailContactOne']/p")).getText(),"Invalid Data");
		else if(element.equals(verifyFirstProvEmail)) 
			if(element.findElement(By.xpath("//div[@id='verifyEmailContactOne']//p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='verifyEmailContactOne']//p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='verifyEmailContactOne']//p")).getText(),"Invalid Data");
		
		
		// SECONDARY CONTACTS ERROR
		
		else if(element.equals(secondProvFName)||element.equals(secondProvLName))
			if(element.findElement(By.xpath("../following-sibling::p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("../following-sibling::p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("../following-sibling::p")).getText(),"Invalid Data");
		else if(element.equals(secondProvPhField1))
			if(element.findElement(By.xpath("//section[2]//fieldset[1]/div[2]/p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//section[2]//fieldset[1]/div[2]/p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//section[2]//fieldset[1]/div[2]/p")).getText(),"Invalid Data");
		else if(element.equals(secondProvEmail))
			Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='emailcontact2']/p")).getText(),errorMsg);
		else if(element.equals(secondProvMName))
			Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='middleNmContact2']//p")).getText(),"Invalid Data");
		else 
			if(element.findElement(By.xpath("//div[@id='verifyemailContact2']/p")).getText().contains("Missing"))
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='verifyemailContact2']/p")).getText(),errorMsg);
			else
				Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//div[@id='verifyemailContact2']/p")).getText(),"Invalid Data");
		Element.verifyElementPresent(errorLink, "Error link");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted" , "#c21926", Color.fromString(element.getCssValue("border-top-color")).asHex());
		
	}
	
	public void valiDateButtons()
	{
		String continueBut=Element.findElement(testConfig, "xpath", "//a[@class='button--primary enrollment-container-footer__btn-margin float-right']").getText();
		String backBut=Element.findElement(testConfig, "xpath", "//a[@class='button--secondary enrollment-container-footer__btn-margin float-right']").getText();
		String cancelEnrol=Element.findElement(testConfig, "xpath", "//a[@class='button--primary-hover float-right cancel-activation']").getText();
		Helper.compareContains(testConfig, "Continue Button", "CONTINUE", continueBut);
		Helper.compareContains(testConfig, "Back Button", "BACK", backBut);
		Helper.compareContains(testConfig, "Cancel Enrollment Button", "CANCEL ENROLLMENT", cancelEnrol);
	}
	
	public ValidateEFTERAProviderInfo verifyEditables()
	{
		Helper.compareEquals(testConfig, "Primary Provider First Name", enrollmentInfoPageObj.getFrstName(), firstProvFName.getAttribute("value"));
		Helper.compareEquals(testConfig, "Primary Provider Last Name", enrollmentInfoPageObj.getLstName(), firstProvLName.getAttribute("value"));
		Helper.compareEquals(testConfig, "Primary Provider Email", enrollmentInfoPageObj.getEmail(),firstProvEmail.getAttribute("value"));
		Helper.compareEquals(testConfig, "Primary Provider ReEmail", enrollmentInfoPageObj.getEmail(),verifyFirstProvEmail.getAttribute("value"));
		Helper.compareEquals(testConfig, "Primary Provider Phone Number", enrollmentInfoPageObj.getPhnNumbr(),firstProvPhField1.getAttribute("value")+firstProvPhField2.getAttribute("value")+firstProvPhField3.getAttribute("value"));
		
		
		if(firstProvFName.getAttribute("readonly") == null&& firstProvLName.getAttribute("readonly") == null&&
		firstProvEmail.getAttribute("readonly") == null&& verifyFirstProvEmail.getAttribute("readonly") == null&&
		firstProvPhField1.getAttribute("readonly") == null&& firstProvPhField2.getAttribute("readonly") == null && firstProvPhField3.getAttribute("readonly") == null)
			Log.Pass("Identify Admin Fields are Editable");
		else
			Log.failure("Identify Admin Fields are not Editable");
			
		return this;
	}
	
	public ValidateEFTERAProviderInfo verifyCanclSaveBtn()
	{
		Element.verifyElementPresent(btnCnclChng, "CANCEL CHANGE BUTTON");
		Element.verifyElementPresent(btnSavChng, "SAVE CHANGE BUTTON");
		return this;
	}
	
	public ReviewAndSubmit clickCanclChngBtn()
	{
		Element.click(btnCnclChng, "CANCEL CHANGE BUTTON");
		return new ReviewAndSubmit(testConfig);
	}
	
	public ReviewAndSubmit clickSaveChngBtn()
	{
		Element.click(btnSavChng, "SAVE CHANGE BUTTON");
		return new ReviewAndSubmit(testConfig);
	}
	
    public void validateCanclSaveBtn()
    
	{
		Helper.compareContains(testConfig, "Save Changes", "SAVE CHANGES", savChanges.getText());
		Helper.compareContains(testConfig, "Cancel Changes", "Cancel Changes", btnCancel.getAttribute("value"));
		Element.verifyElementNotPresent(backBtn, "BACK");
	}
    
    public void clickCancel()
	{
		Element.click(btnCancel, "Continue");
		
	}
	
   
    
    public void verifyContentBSWithUXDS() throws IOException
	{

    	ArrayList<String> listUXDS = new ArrayList<String>();
		
    	ArrayList<String> listUI = new ArrayList<String>();
		listUI.add(identifyAdminHeader.getText());
		listUI.add(identifyMemberAdmin.getText());
		listUI.add( additionalMemberText.getText());
		listUI.add( primaryAdminInfoHeader.getText());
		listUI.add( primaryAdminInfoSubHeader.getText());
		listUI.add( secondaryAdminInfoHeader.getText());
		listUI.add( secondaryAdminInfoSubHeader.getText());

		
		new UXDSPageValidation(testConfig,"Enrollment BS Identify Administrators");
		
		
		listUXDS.add(Element.findElement(testConfig, "xpath", "/html/body/section/main/form/section[1]/fieldset/legend/h1").getText()); //Identify Administrators
		listUXDS.add(Element.findElement(testConfig, "xpath", "/html/body/section/main/form/section[1]/fieldset/p[1]").getText()); //Please identify at least one member of the billing service who will serve as administrator on the account.
		listUXDS.add(Element.findElement(testConfig, "xpath", "/html/body/section/main/form/section[1]/fieldset/p[2]").getText()); //If you have additional members of your organization who need basic access to only view payment information, they can be added as a General Access user by an Administrator using the Manage Users tab of the EPS portal.
		listUXDS.add(Element.findElement(testConfig, "xpath", "/html/body/section/main/form/section[1]/fieldset/h4/strong").getText()); // Primary Administrator Information
		listUXDS.add(Element.findElement(testConfig, "xpath", "/html/body/section/main/form/section[1]/fieldset/p[4]").getText());  // The primary administrator should be an individual responsible for daily and routine matters.
		listUXDS.add(Element.findElement(testConfig, "xpath", "/html/body/section/main/form/section[2]/fieldset/h4/strong").getText()); // Secondary Administrator Information
		listUXDS.add(Element.findElement(testConfig, "xpath", "/html/body/section/main/form/section[2]/fieldset/p").getText()); //The secondary administrator should be someone in your Finance or Account area responsible for provider client management.
		
	
		Helper.compareEquals(testConfig, "UI and UXDS comparision", listUXDS, listUI);
		if (listUI.equals(listUXDS))
		{
			Log.Pass( "matches in both UI and UXDS");
		}
		else
		{
			Log.Fail( "matches in both UI and UXDS");
		}
		

	//	return this;
	}
	
	
    
    public void verifyTextBSWithContentPage() throws IOException
	{
    	
        int sqlRowNo=172;
		
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
		Helper.compareEquals(testConfig, "Identify Administrators ", identifyAdminHeader.getText(), dataTest.get(48).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "BS secondary Admin Sub Info", secondaryAdminInfoSubHeader.getText(), dataTest.get(1).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Account Admin List2", accountAdminList2.getText(), dataTest.get(2).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Identify Admin Sub header", identifyMemberAdmin.getText(), dataTest.get(3).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Secondary Admin Header", secondaryAdminInfoHeader.getText(),dataTest.get(23).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Primary Admin Header", primaryAdminInfoHeader.getText(),dataTest.get(39).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Account Admin List3", accountAdminList3.getText(), dataTest.get(43).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Account Admin List1", accountAdminList1.getText(), dataTest.get(45).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Account Administrators may: ", accountAdministrators.getText(), dataTest.get(46).get("TEXT_VAL"));
		
		String requiredFileds=dataTest.get(41).get("TEXT_VAL")+" () "+dataTest.get(40).get("TEXT_VAL");
		
		Helper.compareEquals(testConfig, "All fields marked with an asterisk (*) are required.: ", requiredFields.getText(), requiredFileds);
		
		Helper.compareEquals(testConfig, "Additional members Text ", additionalMemberText.getText(), dataTest.get(42).get("CLOBVALFROM"));
		
		Helper.compareEquals(testConfig, "Primary Future Update Information  ",primaryfutureUpdateinfo.getText(),dataTest.get(31).get("CLOBVALFROM")+" "+dataTest.get(30).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Secondary Future Update Information  ",secondaryfutureUpdateinfo.getText(),dataTest.get(31).get("CLOBVALFROM")+" "+dataTest.get(30).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Primary Email Addr Information  ",primaryEmailAdressInfo.getText(),dataTest.get(27).get("CLOBVALFROM"));
		
		String primaryRetypeEmailInfo=dataTest.get(26).get("TEXT_VAL")+" "+dataTest.get(25).get("TEXT_VAL")+" "+dataTest.get(24).get("TEXT_VAL");
		
		Helper.compareEquals(testConfig, "Primary Retype Email Addr Information ",primaryRetypeEmailAdressInfo.getText(),primaryRetypeEmailInfo);
		
		Helper.compareEquals(testConfig, "Secondary Email Addr Information  ",secondaryEmailAdressInfo.getText(),dataTest.get(27).get("CLOBVALFROM"));
		
		Helper.compareEquals(testConfig, "Secondary Retype Email Addr Information ",secondaryRetypeEmailAdressInfo.getText(),primaryRetypeEmailInfo);
		
		
	}
    
    public void verifyErrorMsgNull()
	{
    	clearPrimaryAdminFields();
		Element.click(savChanges, "Save Changes Button");
		
		List <String> expectedErrorMsgs;
		Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		 expectedErrorMsgs=Arrays.asList("- Identify Administrators - First Name - Primary Administrator","- Identify Administrators - Last Name - Primary Administrator","- Identify Administrators - Telephone Number - Primary Administrator","- Identify Administrators - Email - Primary Administrator","- Identify Administrators - Verify Email - Primary Administrator");
		for(int i=0;i<expectedErrorMsgs.size();i++)
		{
			Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));
		}
		
		verifyMissingDataErrorMsgPrimary();
		
	}
    
	public void verifyMissingDataErrorMsgPrimary()
	{
		String expectedText="Missing Data";
		String expectedColor="#c21926";
		
		Log.Comment("Verifying Error Msg is displayed for Primary First Name..");
		Element.verifyTextPresent(firstProvFName.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in First name box" , expectedColor, Color.fromString(firstProvFName.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Primary Last Name..");
		Element.verifyTextPresent(firstProvLName.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Last name box" , expectedColor, Color.fromString(firstProvLName.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Primary Phone Number filed1 ..");
		Element.verifyTextPresent(telephoneNumberContact1.findElement(By.xpath("div[3]/p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 1 box" , expectedColor, Color.fromString(firstProvPhField1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Primary Phone Number filed2..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 2 box" , expectedColor, Color.fromString(firstProvPhField2.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Primary Phone Number filed3..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 3 box" , expectedColor, Color.fromString(firstProvPhField3.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Primary Email Address ..");
		Element.verifyTextPresent(emailAdr.findElement(By.xpath("p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Primary Email text box" , expectedColor, Color.fromString(firstProvEmail.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Primary Retype Email Address ..");
		Element.verifyTextPresent(verifyEmailaddr.findElement(By.xpath("div/p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Retype Primary Email text box" , expectedColor, Color.fromString(verifyFirstProvEmail.getCssValue("border-top-color")).asHex());
		
		
	}
	
	public void verifyErrorMsgsHyperlink() {
		
		clearPrimaryAdminFields();
		Element.click(savChanges, "Save Changes Button");

		for (int i= 1; i <= individualErrors.size(); i++) {

			WebElement links = Element.findElement(testConfig,"xpath","//div[@class='error']//ul//li["+i+"]//a");
			String expectedURL=links.getAttribute("href");
			Element.click(links,links.getText());
			Browser.verifyURL(testConfig, expectedURL);
		}
	}
	
	public void clearPrimaryAdminFields() {
		
		Element.clearData(firstProvFName,  "First Name"); 
		Element.clearData(firstProvLName,  "Last Name");
		Element.clearData(firstProvPhField1,  "Ph Filed 1");
		Element.clearData(firstProvPhField2,  "Ph Filed 2");
		Element.clearData(firstProvPhField3,  "Ph Filed 3");
		Element.clearData(firstProvEmail,  "Primary Email Address");
		Element.clearData(verifyFirstProvEmail,  "Retype Email Address");

	}
	
	public void verifyMissingDataErrorMsgSecondary()
	{
		String expectedText="Missing Data";
		String expectedColor="#c21926";
		
		Log.Comment("Enter Secondary Provider First Name..");
		Element.enterData(secondProvFName, fName,"Enter First name of Second provider as: "+ fName,"secondProvFirstName");
		Element.click(savChanges, "Save Changes Button");

		Log.Comment("Verifying Error Msg is displayed for Secondary Last Name..");
		Element.verifyTextPresent(secondProvLName.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Last name box" , expectedColor, Color.fromString(secondProvLName.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Secondary Phone Number filed1 ..");
		Element.verifyTextPresent(telephoneNumberContact2.findElement(By.xpath("../div[2]/p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 1 box" , expectedColor, Color.fromString(secondProvPhField1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Secondary Phone Number filed2..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 2 box" , expectedColor, Color.fromString(secondProvPhField2.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Secondary Phone Number filed3..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 3 box" , expectedColor, Color.fromString(secondProvPhField3.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Secondary Email Address ..");
		Element.verifyTextPresent(emailAdr2.findElement(By.xpath("p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Secondary Email text box" , expectedColor, Color.fromString(secondProvEmail.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Secondary Retype Email Address ..");
		Element.verifyTextPresent(verifyEmailaddr2.findElement(By.xpath("p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Retype Secondary Email text box" , expectedColor, Color.fromString(verifySecondProvEmail.getCssValue("border-top-color")).asHex());
		
		clearPrimaryAdminFields();
		Element.click(savChanges, "Save Changes Button");
		verifyMissingDataErrorMsgPrimary();
	}
	
	
	public void ValidateInvalidPhnNumbers(String provType,String InpdataType) {
		    String Telno=null;
		    fillInvalidPhoneNumber(provType, InpdataType);
		    Element.click(savChanges, "Save Changes Button");
			if (provType.equals("Secondary"))
			Telno=Element.findElement(testConfig, "xpath", "//fieldset[@class='margin-bottom-beta'][1]//p").getText();

			if (provType.equals("Primary"))
			Telno=Element.findElement(testConfig, "xpath", "//div[@id='telephoneNumberContact1']/div[3]/p").getText();
			
			Helper.compareEquals(testConfig, "phone no comparision", Telno, "Invalid Data");
	}
	
	public ValidateEFTERAProviderInfo ValidateInvalidEmailAddr(String inputFormat,String inputType) {
		
		
		String ProvEmailAdr=null;
		if (inputFormat.equals("inpFormatOne")){
		 ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "");
		 	}
		if (inputFormat.equals("inpFormatTwo")){
			ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "abc.com");
		}
		if (inputFormat.equals("inpFormatThree")){
			 ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "@xyzcom");
		}
		WebElement errorRetypeEmail=null;
		if (inputType.equals("Email")) {
			
			Element.enterData(firstProvEmail, ProvEmailAdr, "Enter Primary email address of " + inputType + " provider"+ProvEmailAdr,"ProvEmail");
			Element.enterData(secondProvEmail, ProvEmailAdr, "Enter Secondary email address of " + inputType + " provider"+ProvEmailAdr,"ProvEmail");
			Element.click(savChanges, "Save Changes Button");
			errorRetypeEmail=Element.findElement(testConfig, "xpath", "//div[@id='emailmailContactOne']/p");
			Element.verifyTextPresent(errorRetypeEmail, "Invalid Data");
			errorRetypeEmail=Element.findElement(testConfig, "xpath", "//div[@id='emailcontact2']/p");
			Element.verifyTextPresent(errorRetypeEmail, "Invalid Data");
	
		}else if(inputType.equals("RetypeEmail")) {
			
			Element.enterData(verifyFirstProvEmail, ProvEmailAdr, "Enter Retype Primary email address of " + inputType + " provider"+ProvEmailAdr,"ProvEmailAdr");
			Element.enterData(verifySecondProvEmail, ProvEmailAdr, "Enter Retype Secondary email address of " + inputType + " provider"+ProvEmailAdr,"ProvEmailAdr");
			Element.click(savChanges, "Save Changes Button");
			
			errorRetypeEmail=Element.findElement(testConfig, "xpath", "//*[@id='verifyemailContact2']/p");
			Element.verifyTextPresent(errorRetypeEmail, "Invalid Data");
			errorRetypeEmail=Element.findElement(testConfig, "xpath", "//*[@id='verifyEmailContactOne']/div/p");
			Element.verifyTextPresent(errorRetypeEmail, "Invalid Data");
		}
		
		return this;
	}
	
	public ValidateEFTERAProviderInfo verifyMobileAlertEnabled(String prvoiderType) {
		
		switch(prvoiderType)
		{
		  case "Primary":
		  {
			
			Element.enterData(mobilePhone1Contact1, phNo,"Entered first three digits of phone number as :" + phNo ,"firstProvPhField1");
			Element.enterData(mobilePhone2Contact1, phNo,"Entered second three digits of phone number as :" + phNo,"firstProvPhField2");
			Element.enterData(mobilePhone3Contact1, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"firstProvPhField3");
			Log.Comment("Primary Mobile Alert is enabled.."+mobileAlertCheckedContact1.isEnabled());
			
			break;
		   }
		  case "Secondary":
		  {
		   Element.enterData(mobilePhone1Contact2, phNo, "Entered first three digits of phone number as :" + phNo,"secondProvPhField1");
		   Element.enterData(mobilePhone2Contact2, phNo, "Entered second three digits of phone number as :" + phNo,"secondProvPhField2");
		   Element.enterData(mobilePhone3Contact2, phNoLstField, "Entered last four digits of phone number as :" + phNoLstField,"secondProvPhField3");
		   Log.Comment("Secondary Mobile Alert is enabled.."+mobileAlertCheckedContact2.isEnabled());
		   
		   break;
		  } 
	     }
		return this;
	}
	
	public ValidateEFTERAProviderInfo ValidateAlertFrquencyPopup(String inputType) throws IOException {
	
		int sqlRowNo=172;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		String expectedText=dataTest.get(15).get("CLOBVALFROM").trim();
		expectedText=expectedText.replaceAll("[\r\n]+", "").replaceAll("^ +| +$|( )+", "$1");
		if(inputType.equals("Primary"))
			Element.click(primaryLearnAlertFrequencyLink, "Primary Learn Alert Frequency Link ");
		else
			Element.click(secondaryLearnAlertFrequencyLink, "Secondary Learn Alert Frequency Link ");
		
		Element.verifyTextPresent(alertFrequencyPopup, expectedText);
		Element.click(closeTipButton, "closeTip Button");
		return this;
	}
	
	public void fillIdentifyInfoSaveChanges() {
		
		fillPrimaryProvInfo();
		Element.clickByJS(testConfig, savChanges, "Clicked Save Changes");
		String expectedURL="/validateBillingServiceContacts.do?fromReview=Y";
     	Browser.verifyURL(testConfig, expectedURL);
	}
	
	public void VerifyCancelButtonDisbaled() {
		
		clearPrimaryAdminFields();
		Element.click(savChanges, "Save Changes Button");
		Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		if(btnCancel.isDisplayed())
			Log.Comment("Cancel Button is Disabled.");
		fillIdentifyInfoSaveChanges();
	}
	
	public void validateClearAdminInfoHidden() {
		
		Element.verifyElementNotPresent(divClrAdminInfo, "Clear Administration Information Link");
		
	}
	
}
