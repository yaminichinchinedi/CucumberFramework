package main.java.pageObjects;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.DataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
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
	
	@FindBy(name="lastNameContact1")
	WebElement firstProvLName;
	
	@FindBy(name="phoneNum1Contact1")
	WebElement firstProvPhField1;
	
	@FindBy(name="phoneNum2Contact1")
	WebElement firstProvPhField2;
	
	@FindBy(name="phoneNum3Contact1")
	WebElement firstProvPhField3;
	
	
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
	
	@FindBy(name="verifyEmailContact1")
	WebElement verifyFirstProvEmail;
	
	//Second Provider Details
	
	@FindBy(name="firstNameContact2")
	WebElement secondProvFName;
	
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
	
	@FindBy(name="mobilePhone1Contact2")
	WebElement SecProvMobField1;
	
	@FindBy(name="mobilePhone2Contact2")
	WebElement SecProvMobField2;
	
	@FindBy(name="mobilePhone3Contact2")
	WebElement SecProvMobField3;
	
	@FindBy(id="sendAlertsContact2")
	WebElement SecProvMobAlert;
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
	@FindBy(linkText="CANCEL ENROLLMENT")
	WebElement btnCnclEnrlmnt;
	
	@FindBy(linkText="Back")
	WebElement btnBack;
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][2]//td//table//tr//td//b")
	WebElement txtSecurityBold;
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][2]//td//table//tr//td//u")
	WebElement txtSecurityUnderlined;
	
	@FindBy(xpath = "//tr[3]/td/table/tbody/tr/td[2]")
	WebElement txtSecurityNormal;
	
	@FindBy(xpath ="//strong[contains(text(),'EPS Enrollment - Confirm Existing User')]")
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
	
	@FindBy(linkText="Close Tip") 
	WebElement lnkClosTip;
	
	@FindBy(xpath="//section//form/div[3]/div[1]/div")
	List<WebElement> divFrqncyPopUp;
	
	@FindBy(xpath="//section//form/a")
	WebElement lnkClrAdmnInfo;
	
	@FindBy(xpath="//section//form/div[5]/div[1]/div")
	List<WebElement> divClrInfo;
	
	@FindBy(xpath="//section//form/div[4]/div[1]/div")
	List<WebElement> divCnclEnrlmnt;
	
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
	
	HashMap<Integer,HashMap<String,String>> pageData=null;
	
	String fName=Helper.generateRandomAlphabetsString(5);
	String lName=Helper.generateRandomAlphabetsString(5);
	String secondProvEmailAdr=Helper.getUniqueEmailId();
	String firstProvEmailAdr=Helper.getUniqueEmailId();
	String phNo = Long.toString(Helper.generateRandomNumber(3));
	String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
	
	String expHeaderMsg="EPS Enrollment - Confirm Existing User";
	public ValidateEFTERAProviderInfo(TestBase testConfig)
	{   
		String expectedURL="/validateEFTERAProviderInfo";
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedURL="/validateBSbillingServiceInfo";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
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
			Helper.compareEquals(testConfig, "check box is not disabled",null,firstProvMobAlert.getAttribute("disabled") );
//			System.out.println("check box is not disabled: "+firstProvMobAlert.getAttribute("disabled"));
//			Browser.wait(testConfig, 2);
			Element.enterData(firstProvMobField3, "89","Entered last four digits of phone number as : 89"  ,"firstProvMobField3");
			Helper.compareEquals(testConfig, "", "true", firstProvMobAlert.getAttribute("disabled"));
//			System.out.println("check box disabled:"+firstProvMobAlert.getAttribute("disabled"));
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
	
	public ValidateEFTERAProviderInfo verifyDupEmailError(String provType) throws IOException
	{
	   String expHeaderMsg="EPS Enrollment - Confirm Existing User";
	   String expMsg="";
	   expMsg=fillProvInfoWithDupEmail(provType);
	   Element.click(btnContinue, "Continue");
	   
	   Element.verifyTextPresent(exitingUserHeaderMsg,expHeaderMsg);
	   Element.verifyElementPresent(btnYesOnExsistingEmailPage, "Yes BTN");
	   Element.verifyElementPresent(btnNoOnExsistingEmailPage, "NO BTN");
	   Browser.wait(testConfig, 120);
//	   Element.verifyTextPresent(exitingUserMsg,expMsg);
	   return this;
	}
	
	public ValidateEFTERAProviderInfo verifyYesBtnFunctionality() throws IOException
	{
		Element.click(btnYesOnExsistingEmailPage, "Yes Button");
		Element.click(btnContinue, "Continue");
		int sqlRowNo=164;
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
		return tinsFromUI;
	}
	
	
	public ArrayList<String> getAssociatedTinsFromDB() throws IOException
	{
	   int sqlNo=9;
       ArrayList<String> tinsListFromDB = new ArrayList<String>();
	   HashMap<Integer, HashMap<String, String>> portalUser=DataBase.executeSelectQueryALL(testConfig,sqlNo);
	   for (int i = 1; i <= portalUser.size(); i++) 
		   tinsListFromDB.add(portalUser.get(i).get("PROV_TIN_NBR"));
		return tinsListFromDB;
	}
		
	
	public void fillSecondProvInfo()
	{
		Element.enterData(secondProvFName, fName,"Enter First name of Second provider as: "+ fName,"secondProvFirstName");
		Element.enterData(secondProvLName, lName,"Enter Last name of Second provider as : "+ lName,"secondProvLastName");
		fillPhoneNumber("Secondary");
		Element.enterData(secondProvEmail, secondProvEmailAdr, "Enter email address of Second provider","secondProvEmail");
		Element.enterData(verifySecondProvEmail, secondProvEmailAdr, "Retype email address of Second provider","verifySecondProvEmail");
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
		int sqlRow=163;
		pageData=DataBase.executeSelectQueryALL(testConfig, sqlRow);
		Element.click(lnkAlertFrequency, "Alert frequency Link");
		Element.verifyElementPresent(lnkClosTip, "Alert frequency PopUp");
		Helper.compareContains(testConfig, "Alert Pop Up Heading",divFrqncyPopUp.get(0).findElement(By.tagName("h4")).getText(),pageData.get(33).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Alert Pop Up Paragraph",divFrqncyPopUp.get(1).findElement(By.tagName("p")).getText(),pageData.get(34).get("CLOBVAL").trim().replace("\n", "").replaceAll("( )+", " "));
		Helper.compareContains(testConfig, "Alert Pop Up Paragraph",divFrqncyPopUp.get(2).findElement(By.tagName("a")).getText(),pageData.get(35).get("TEXT_VAL").toUpperCase());
		Element.click(lnkClosTip, "Click close tip on Pop Up");
		Element.verifyElementNotPresent(lnkClosTip, "Alert frequency PopUp");
		return this;
	}
	
	public ValidateEFTERAProviderInfo verifyClrInfo() 
	{
		Element.click(lnkClrAdmnInfo, "Clear Administrator Information");
		Element.verifyElementPresent(divClrInfo.get(2).findElements(By.tagName("a")).get(1), "Clear Info PopUp");
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divClrInfo.get(0).findElement(By.tagName("h4")).getText(),pageData.get(41).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divClrInfo.get(1).findElements(By.tagName("p")).get(0).getText(),pageData.get(42).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divClrInfo.get(1).findElements(By.tagName("p")).get(1).getText(),pageData.get(43).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divClrInfo.get(2).findElements(By.tagName("a")).get(0).getText(),pageData.get(39).get("TEXT_VAL").toUpperCase());
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divClrInfo.get(2).findElements(By.tagName("a")).get(1).getText(),pageData.get(40).get("TEXT_VAL").toUpperCase());
		Element.click(divClrInfo.get(2).findElements(By.tagName("a")).get(0), "clicked NO");
		Element.verifyElementNotPresent(divClrInfo.get(2).findElements(By.tagName("a")).get(1), "Clear Info PopUp");
		return this;
	}
	
	public ValidateEFTERAProviderInfo clickBackBtn()
	{
		Element.click(btnContinue, "Clicked Back Button");
		Browser.verifyURL(testConfig, "validateefteraprovidercontact");
		return this;
	}
	
	public ValidateEFTERAProviderInfo clickYesOnClrInfoPopUp()
	{
		Element.click(divClrInfo.get(2).findElements(By.tagName("a")).get(1), "clicked YES");
		System.out.println(firstProvFName.getAttribute("value"));
		return this;
	}
	
	public ValidateEFTERAProviderInfo clickCancelEnrlmnt() throws IOException
	{
		int sqlRow=163;
		pageData=DataBase.executeSelectQueryALL(testConfig, sqlRow);
		Element.click(btnCnclEnrlmnt, "Cancel Enrollment");
		Element.verifyElementPresent(divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(1), "Clear Info PopUp");
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(0).findElement(By.tagName("h4")).getText(),pageData.get(36).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(1).findElements(By.tagName("p")).get(0).getText(),pageData.get(37).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(1).findElements(By.tagName("p")).get(1).getText(),pageData.get(38).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(0).getText(),pageData.get(39).get("TEXT_VAL").toUpperCase());
		Helper.compareContains(testConfig, "Cancel Enrlment Pop Up Heading",divCnclEnrlmnt.get(2).findElements(By.tagName("a")).get(1).getText(),pageData.get(40).get("TEXT_VAL").toUpperCase());
		
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
	
	public ValidateEFTERAProviderInfo verifyPageContent()
	{
		
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
		
		Log.Comment("Verifying Error Msg is displayed for Provider First Name.."); ///html/body/section/main/form/section[1]/fieldset/fieldset[1]/div/div[3]/p
//		Element.verifyTextPresent(firstProvPhField1.findElement(By.xpath("../following-sibling::div//p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvPhField1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Provider First Name..");
//		Element.verifyTextPresent(firstProvPhField2.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvPhField2.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Provider First Name..");
//		Element.verifyTextPresent(firstProvPhField3.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvPhField3.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Email..");
		Element.verifyTextPresent(firstProvEmail.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(firstProvEmail.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Retype Email address..");
		Element.verifyTextPresent(verifyFirstProvEmail.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(verifyFirstProvEmail.getCssValue("border-top-color")).asHex());		
		return this;
	}
	
	public  ValidateEFTERAProviderInfo validateSecondaryAdminFields(String field,String data) throws IOException {
		WebElement ele=null;
		switch(field)
		{
			case "ScndProvFName":
				Element.enterData(secondProvFName, data, "Enter provider name as :" + data,"providerName");
				ele=secondProvFName;
				break;
			case "ScndProvLName":
				Element.enterData(secondProvLName, data, "Enter street name as : " + data,"street");
				ele=secondProvLName;
				break;
			case "ScndProvPhnNo":
				Element.enterData(secondProvPhField1,  data, "Enter city name as :" + data,"city");
				Element.enterData(secondProvPhField2,  data, "Enter city name as :" + data,"city");
				Element.enterData(secondProvPhField3,  data, "Enter city name as :" + data,"city");
				ele=secondProvPhField1;
				break;
			case "ScndProvEmail":
				Element.enterData(secondProvEmail, data, "Enter state name","city");
				ele=secondProvEmail;
				break;
			case "ScndProvReEmail":
				Element.enterData(verifySecondProvEmail, data,"Entered zip code in first textbox as" + data,"zipCode1");
				ele=verifySecondProvEmail;
				break;
		}
		fillSecondProvInfo(field);
		Element.click(btnContinue, "Continue button");
		verifySecAdminError(ele);
		return this;

	}
	
	public  ValidateEFTERAProviderInfo fillSecondProvInfo(String field) throws IOException {
		int rowNo=1;
		String provName = Helper.generateRandomAlphabetsString(5);
		String streetName = Helper.generateRandomAlphabetsString(5);
		TestDataReader data= testConfig.cacheTestDataReaderObject("FinancialInfo");
	
		if(!field.equals("ScndProvFName"))
			Element.enterData(secondProvFName, provName, "Enter provider name as :" + provName,"providerName");
		if(!field.equals("ScndProvLName"))
			Element.enterData(secondProvLName, provName, "Enter street name as : " + streetName,"street");
		if(!field.equals("ScndProvPhnNo"))
		{
			Element.enterData(secondProvPhField1, provName , "Enter city name as :" + data,"city");
			Element.enterData(secondProvPhField2, provName,  "Enter city name as :" + data,"city");
			Element.enterData(secondProvPhField3, provName,  "Enter city name as :" + data,"city");
		}
		if(!field.equals("ScndProvEmail"))
			Element.enterData(secondProvEmail,secondProvEmailAdr , "Enter state name","email");
		if(!field.equals("ScndProvReEmail"))
			Element.enterData(verifySecondProvEmail, secondProvEmailAdr,"Entered zip code in first textbox as" ,"email");
		
		return this;
	}	

	public void verifySecAdminError(WebElement element)
	{
		/*if(element.equals(zipCode1))
		{
			if(error.getText().contains("Data"))
				Element.verifyTextPresent(error, "Invalid Data");
			else
				Element.verifyTextPresent(error, "Invalid for City/State");
		}
		else if(element.equals(street))
		{
			if(error.getText().contains("Special"))
				Element.verifyTextPresent(error, "Special characters not allowed");
			else
				Element.verifyTextPresent(error, "P.O. Boxes are not accepted");
		}
		else*/
//		Element.verifyTextPresent(error, "Missing Data");
		Element.verifyElementPresent(errorLink, "Error links");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted" , "#c21926", Color.fromString(element.getCssValue("border-top-color")).asHex());
		
	}
}
