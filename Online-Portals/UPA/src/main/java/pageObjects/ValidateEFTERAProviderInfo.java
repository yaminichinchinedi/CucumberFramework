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
	
	
	@FindBy(name="emailContact1")
	WebElement firstProvEmail;
	
	
	@FindBy(name="verifyEmailContact1")
	WebElement verifyFirstProvEmail;
	
	//Second Provider Details
	
	@FindBy(name="firstNameContact2")
	WebElement secondProvFName;
	
	@FindBy(name="middleNameContact2")
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
	
	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;
	
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
	

	
	String fName=Helper.generateRandomAlphabetsString(5);
	String lName=Helper.generateRandomAlphabetsString(5);
	String secondProvEmailAdr=Helper.getUniqueEmailId();
	String firstProvEmailAdr=Helper.getUniqueEmailId();
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
	   String expHeaderMsg="EPS Enrollment - Confirm Existing User";
	   String expMsg="";
	   expMsg=fillProvInfoWithDupEmail(provType);
	   Element.click(btnContinue, "Continue");
	   
	   Element.verifyTextPresent(exitingUserHeaderMsg,expHeaderMsg);
	   Element.verifyTextPresent(exitingUserMsg,expMsg);
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
	
	
	public void valiDateButtons()
	{
		String continueBut=Element.findElement(testConfig, "xpath", "//a[@class='button--primary enrollment-container-footer__btn-margin float-right']").getText();
		String backBut=Element.findElement(testConfig, "xpath", "//a[@class='button--secondary enrollment-container-footer__btn-margin float-right']").getText();
		String cancelEnrol=Element.findElement(testConfig, "xpath", "//a[@class='button--primary-hover float-right cancel-activation']").getText();
		Helper.compareContains(testConfig, "Continue Button", "CONTINUE", continueBut);
		Helper.compareContains(testConfig, "Back Button", "BACK", backBut);
		Helper.compareContains(testConfig, "Cancel Enrollment Button", "CANCEL ENROLLMENT", cancelEnrol);
	}
	
	
}
