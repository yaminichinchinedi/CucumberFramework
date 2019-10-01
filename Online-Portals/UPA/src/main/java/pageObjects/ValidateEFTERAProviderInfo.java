package main.java.pageObjects;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
	
//	@FindBy(xpath="//div[@class='error']//h4")
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
		return this;
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
		int sqlRow=166;
		pageData=DataBase.executeSelectQueryALL(testConfig, sqlRow);
		Element.click(lnkAlertFrequency, "Alert frequency Link");
		Element.verifyElementPresent(lnkClosTip, "Alert frequency PopUp");
		Helper.compareContains(testConfig, "Alert Pop Up Heading",divFrqncyPopUp.get(0).findElement(By.tagName("h4")).getText(),pageData.get(32).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Alert Pop Up Paragraph",divFrqncyPopUp.get(1).findElement(By.tagName("p")).getText(),pageData.get(33).get("CLOBVAL").trim().replace("\n", "").replaceAll("( )+", " "));
		Helper.compareContains(testConfig, "Alert Pop Up Paragraph",divFrqncyPopUp.get(2).findElement(By.tagName("a")).getText(),pageData.get(34).get("TEXT_VAL").toUpperCase());
		Element.click(lnkClosTip, "Click close tip on Pop Up");
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
	
	public  ValidateEFTERAProviderInfo validateSecondaryAdminFields(String field,String data) throws IOException {
		WebElement ele=null;
		switch(field)
		{
			case "ScndProvFName":
				Element.enterData(secondProvFName, data, "Enter provider First name as :" + data,"providerFName");
				ele=secondProvFName;
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
		}
		fillSecondProvInfo(field);
		Element.click(btnContinue, "Continue button");
		verifySecAdminError(ele);
		return this;

	}
	
	public  ValidateEFTERAProviderInfo fillSecondProvInfo(String field) throws IOException {
		String provName = Helper.generateRandomAlphabetsString(5);
		
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
		if(!field.equals("ScndProvEmail"))
			Element.enterData(secondProvEmail,secondProvEmailAdr , "Enter Sec Prov Email: "+secondProvEmailAdr,"email");
		if(!field.equals("ScndProvReEmail"))
			Element.enterData(verifySecondProvEmail, secondProvEmailAdr,"Enter Sec Prov ReEmail: "+secondProvEmailAdr ,"EeEmail");
		
		return this;
	}	

	public void verifySecAdminError(WebElement element)
	{
		String errorMsg="Missing Data";
		if(element.equals(secondProvFName)||element.equals(secondProvLName))
			Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("../following-sibling::p")).getText(),errorMsg);
		else if(element.equals(secondProvPhField1))
			Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//section[2]//fieldset[1]/div[2]/p")).getText(),errorMsg);
		else if(element.equals(secondProvEmail))
			Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//*[@id='emailcontact2']/p")).getText(),errorMsg);
		else 
			Helper.compareEquals(testConfig, "Error Msg",element.findElement(By.xpath("//*[@id='verifyemailContact2']/p")).getText(),errorMsg);
			
		Element.verifyElementPresent(errorLink, "Error link");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted" , "#c21926", Color.fromString(element.getCssValue("border-top-color")).asHex());
		
	}
}
