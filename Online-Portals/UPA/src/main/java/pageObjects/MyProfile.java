package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile {
	
	@FindBy(linkText="Change Password" )
	WebElement lnkChangePwd;
	
	@FindBy(xpath="//span[contains(text(),'successfully changed')]")
	WebElement successMsg;
			
	@FindBy(linkText="How to Enroll")
	WebElement tabHowToEnroll;
			
    @FindBy(linkText="Benefits of EPS")
    WebElement tabBenefitsOfEPS;
    
    @FindBy(linkText="Manage Security Questions" )
	WebElement lnkSecurityQuestions;
    
    @FindBy(xpath="//td[contains(text(),'User Name:')]//following-sibling::td")
    WebElement txtUserName;
    
    @FindBy(xpath="//span[contains(text(),'User Type')]/..//following-sibling::td")
    WebElement txtUserType;
    
    @FindBy(name="upaUserTo.lastName")
    WebElement txtBoxLName;
    
    @FindBy(name="upaUserTo.firstName")
    WebElement txtBoxFName;
    
    @FindBy(name="upaUserTo.middleInitial")
    WebElement txtBoxMName;
    
    @FindBy(id="phoneNum")
    WebElement txtBoxPhNo;
    
    @FindBy(id="phoneNum1")
    WebElement txtBoxPhNo1;
    
    @FindBy(id="phoneNum2")
    WebElement txtBoxPhNo2;
    
    @FindBy(name="upaUserTo.telephoneNumberExt")
    WebElement txtBoxExt;
    
    @FindBy(name="upaUserTo.emailAddress")
    WebElement txtBoxEmail;
    
    @FindBy(name="upaUserTo.verifyEmail")
    WebElement txtBoxVerifyEmail;
    
    @FindBy(xpath=".//*[@id='flow']/table//tr")
    List<WebElement> tinsTable;
    
    @FindBy(xpath="//input[contains(@name,'payerTinNumber')]")
    List<WebElement> payerTinsTable;
    
    @FindBy(xpath="//font[contains(text(),'First')]")
	WebElement errorFname;
	
	@FindBy(xpath="//font[contains(text(),'Ext')]")
	WebElement errorExtension;
	
	@FindBy(xpath="//font[contains(text(),'Last')]")
	WebElement errorLname;
	
	@FindBy(xpath="//font[contains(text(),'Phone')]")
	WebElement errorPhone;
	
	@FindBy(xpath="//font[contains(text(),'Address')]")
	WebElement errorEmail;
	
	@FindBy(xpath="//font[contains(text(),'Retype Email')]")
	WebElement errorRetypeEmail;
	
	@FindBy(xpath="//input[@value=' Save ']")
	WebElement btnSave;
	
	@FindBy(xpath="//font[contains(text(),'Invalid First')]")
	WebElement errors;
	private TestBase testConfig;
	

	public MyProfile(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.verifyElementPresent(lnkChangePwd, "Page is loaded and Change Password Link");
	}

	//Default constructor
	 MyProfile() 
	{
		
	}
	
	public MyProfileChangePwd clickChangePwd()
	{ 
		WebElement changePwd=Element.findElement(testConfig, "linkText", "Change Password");
	    Element.clickByJS(testConfig,changePwd, "Change Password");
		return new MyProfileChangePwd(testConfig);
	}
	
	public void verifySuccessMsg()
	{
		Element.verifyElementPresent(successMsg, "Success Message");
	}
	
	public ManageSecurityQuestions clickSecurityQuestions()
	{
		Element.clickByJS(testConfig,lnkSecurityQuestions, "Manage Security Questions");
		return new ManageSecurityQuestions(testConfig);
	}	
	
	public MyProfile verifyUserDetails(String userType) throws IOException
	{
		int sqlNo=0;
		String associatedTin="";
		if(userType.equals("PROV"))
		{
			sqlNo=159;//8;
			associatedTin="PROV_TIN_NBR";
		}
		else if (userType.equals("BS"))
		{
			sqlNo=160;
			associatedTin="IDENTIFIER_NBR";
		}
		else if (userType.equals("PAY"))
		{
			sqlNo=161;
			associatedTin="PAYR_TIN_NBR";
		}
		ArrayList<String> tinsListFromDB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> portalUser=DataBase.executeSelectQueryALL(testConfig, sqlNo);
		
		Helper.compareEquals(testConfig, "Username in DB and UI", portalUser.get(1).get("USERNAME").toString(), txtUserName.getText());
		Helper.compareEquals(testConfig, "First Name in DB and UI", portalUser.get(1).get("FST_NM").toString(), txtBoxFName.getAttribute("value"));
		Helper.compareEquals(testConfig, "Last in DB and UI", portalUser.get(1).get("LST_NM").toString(), txtBoxLName.getAttribute("value"));
		Helper.compareEquals(testConfig, "Middle in DB and UI", portalUser.get(1).get("MIDDLE_INIT").toString(), txtBoxMName.getAttribute("value"));
		Helper.compareEquals(testConfig, "Ph in DB and UI", portalUser.get(1).get("TEL_NBR").toString(), txtBoxPhNo.getAttribute("value")+txtBoxPhNo1.getAttribute("value")+txtBoxPhNo2.getAttribute("value"));
		Helper.compareEquals(testConfig, "Extension in DB and UI", portalUser.get(1).get("TEL_NBR_EXT").toString(), txtBoxExt.getAttribute("value"));
		Helper.compareEquals(testConfig, "Email in DB and UI", portalUser.get(1).get("EMAIL_ADR_TXT").toString(), txtBoxEmail.getAttribute("value"));
		Helper.compareEquals(testConfig, "Verify Email in DB and UI", portalUser.get(1).get("EMAIL_ADR_TXT").toString(), txtBoxVerifyEmail.getAttribute("value"));
		Helper.compareEquals(testConfig, "Verify UserType in DB and UI", changeUserType(portalUser.get(1).get("USER_TYP").toString()),txtUserType.getText());
		
		for (int i = 1; i <= portalUser.size(); i++) {
			tinsListFromDB.add(portalUser.get(i).get(associatedTin));
		}
	   
		if(userType.equals("PAY"))
			Helper.compareEquals(testConfig, "Associated Tins" , tinsListFromDB, getPayerTinsFromUI());
		else
		Helper.compareEquals(testConfig, "Associated Tins" , tinsListFromDB, getTinsFromUI());
		return this;
	}
	
	
	public ArrayList<String> getTinsFromUI() throws IOException
	{
		ArrayList<String> tinsListFromUI = new ArrayList<String>();
		for(int i=0;i<tinsTable.size();i++){
			tinsListFromUI.add(tinsTable.get(i).findElements(By.tagName("td")).get(0).getText());
		}
		return tinsListFromUI;
	}
	
	public ArrayList<String> getPayerTinsFromUI() throws IOException
	{
		ArrayList<String> tinsListFromUI = new ArrayList<String>();
		for(int i=0;i<payerTinsTable.size();i++){
			tinsListFromUI.add(payerTinsTable.get(i).getAttribute("value"));
		}
		return tinsListFromUI;
	}
	
	
	public String changeUserType(String userTypeFromDB )
	{
		if(userTypeFromDB.equals("P"))
			return "Provider";
		else if(userTypeFromDB.equals("BS"))
		   return "Billing Services";
		else if(userTypeFromDB.equals("PA"))
		   return "Payer";
		else
			return userTypeFromDB;
	}
	
	
	public void verifyErrorMessages(String userType) throws IOException
	{
		int sqlRowNo=6;
		Map enrolledProviderTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String existingEmailAdr=enrolledProviderTable.get("EMAIL_ADR_TXT").toString().toLowerCase().trim();
		
		
		//Enter invalid chars and click Save
		Log.Comment("Scenario : Enter invalid chars in first,last,phone,extension field");
		
		fillInvalidUserDetails();
		Element.click(btnSave, "Save button");
		
	    //Verify error messages when mandatory fields are invalid
		if(userType.equals("PAY"))
		{
			Element.waitTillTextAppears(errorFname, "First Name: Invalid Data",testConfig);
		    Element.verifyTextPresent(errorLname, "Last Name: Invalid Data");
		    Element.verifyTextPresent(errorPhone, "Phone Number : Missing Data");
		    Element.verifyTextPresent(errorExtension, "Ext : Invalid Data");
		}
		
		else
		{
			Element.waitTillTextAppears(errorFname, "Invalid First Name",testConfig);
		    Element.verifyTextPresent(errorLname, "Invalid Last Name");
		    Element.verifyTextPresent(errorPhone, "Invalid Phone Number");
		    Element.verifyTextPresent(errorExtension, "Invalid Extension");
		}
		
		fillValidUserDetails();

		//Enter invalid email 
		Log.Comment("Scenario : Enter invalid email in email field and rest of the fields are valid");
		Element.enterData(txtBoxEmail,"DDD", "Enter existing email address as : " + existingEmailAdr,"email");
		Element.click(btnSave, "Save button");
		if(userType.equals("PAY"))
			Element.waitTillTextAppears(errorEmail, "Email Address: Invalid Data",testConfig);
		else
			Element.waitTillTextAppears(errorEmail, "Invalid Email Address",testConfig);
		
		
		//Enter valid existing email in email field and invalid in retype email 
		
		Log.Comment("Scenario :Enter valid existing email in email field and invalid in retype email");
		Element.enterData(txtBoxEmail,existingEmailAdr, "Enter existing email address as : " + existingEmailAdr,"email");
		Element.enterData(txtBoxVerifyEmail, existingEmailAdr+1,"Enter verify email address as : " + existingEmailAdr+1,"Verify Email");
		Element.click(btnSave, "Save button");
		 if(userType.equals("PAY"))
			Element.waitTillTextAppears(errorEmail, "Verify E-Mail Address : Invalid Data", testConfig);
		else
			Element.waitTillTextAppears(errorEmail, "Invalid Retype Email Address", testConfig);
		
		
		//Enter existing email address in both email and verify email
		 
		Log.Comment("Scenario :Enter existing email address in both email and verify email");
		Element.enterData(txtBoxEmail,existingEmailAdr, "Enter existing email address as : " + existingEmailAdr,"email");
		Element.enterData(txtBoxVerifyEmail, existingEmailAdr,"Enter verify existing email address as : " + existingEmailAdr,"Verify Email");
		Element.click(btnSave, "Save button");
		Element.waitTillTextAppears(errorEmail, "Email Address already exists in our database", testConfig);
		
	}
	
	
	public void fillValidUserDetails()
	{
		Element.enterData(txtBoxFName, "Test", "Enter First Name as : Test " ,"firstName");
		Element.enterData(txtBoxLName, "User", "Enter Last Name as : User " ,"lastName");
		Element.enterData(txtBoxPhNo, "666", "Enter Phone number in field 1 as: 666","phoneNum");
		Element.enterData(txtBoxPhNo1, "666", "Enter Phone number in field 2 as: 666","phoneNum1");
		Element.enterData(txtBoxPhNo2, "6666", "Enter Phone number in field 3 as: 6666","phoneNum2");
		Element.enterData(txtBoxExt, " ", "Empty extension","extension");
	}
	
	public void fillInvalidUserDetails()
	{
		Element.enterData(txtBoxFName, "@#", "Enter First Name as : " + "@#","firstName");
		Element.enterData(txtBoxLName, "@#", "Enter Last Name as : " + "@#","lastName");
		Element.enterData(txtBoxPhNo, "abc", "Enter Phone number in field 1 as: abc","phoneNum");
		Element.enterData(txtBoxPhNo1, "abc", "Enter Phone number in field 2 as: abc","phoneNum1");
		Element.enterData(txtBoxPhNo2, "abc", "Enter Phone number in field 3 as: abc","phoneNum2");
		Element.enterData(txtBoxExt, "abc", "Enter extension  as: abc","extension");
	}
	
	
	
}