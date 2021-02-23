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
	
	@FindBy(xpath = "//td[contains(text(),'Your profile changes were updated successfully.')]")
	WebElement updateMsg;
	
    @FindBy(name="tinGridList[0].emailNotify")
	WebElement emailChkbox;
    
	@FindBy(linkText="Change Password")
	WebElement chngPwd;
	
	@FindBy(linkText="Manage Security Questions")
	WebElement mngSecQuestns;
	
	@FindBy(xpath="//td[contains(text(),'Optum ID:')]")
	WebElement optumID;
	
	@FindBy(xpath="//font[contains(text(),'Invalid First')]")
	WebElement errors;
	private TestBase testConfig;
	

	public MyProfile(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
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
		int sql=6;
		Map emailData = DataBase.executeSelectQuery(testConfig, sql, 1);
		String existingRandomEmail= emailData.get("EMAIL_ADR_TXT").toString();
		Log.Comment("Scenario :Enter existing email address in both email and verify email");
		Element.enterData(txtBoxEmail,existingRandomEmail, "Enter existing email address as : " + existingRandomEmail,"email");
		Element.enterData(txtBoxVerifyEmail, existingRandomEmail,"Enter verify existing email address as : " + existingRandomEmail,"Verify Email");
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
	
	
	public void updateAndVerifyUserDetails()
	{
		int sqlRowNo=404;
		String phNo = Long.toString(Helper.generateRandomNumber(3));
		String userEmailAdr=Helper.getUniqueEmailId();
		String firstNameTxt=Helper.generateRandomAlphabetsString(3);
		
		Element.enterData(txtBoxEmail,  userEmailAdr, "Enter existing email address as : " + userEmailAdr,"email");
		Element.enterData(txtBoxVerifyEmail, userEmailAdr,"Enter verify existing email address as : " + userEmailAdr,"Verify Email");
		Element.click(btnSave, "Save button");
		Browser.wait(testConfig, 5);
		
		Element.verifyTextPresent(updateMsg, "Your profile changes were updated successfully.");
		
		Map email=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "mod_typ_cd", email.get("MOD_TYP_CD").toString().trim(), "PCE");
		
		Element.enterData(txtBoxFName, firstNameTxt, "Enter First Name as : " + firstNameTxt ,"FirstName");
		Element.click(btnSave, "Save button");
		Browser.wait(testConfig, 5);
		
		Element.verifyTextPresent(updateMsg, "Your profile changes were updated successfully.");
		
		Map name=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "mod_typ_cd", name.get("MOD_TYP_CD").toString().trim(), "PCN");
		
		Element.enterData(txtBoxPhNo1, phNo, "Enter Phone number in field 2 as: " + phNo,"phoneNum1");
		Element.click(btnSave, "Save button");
		
		Browser.wait(testConfig, 5);
		
		Element.verifyTextPresent(updateMsg, "Your profile changes were updated successfully.");
		Map phone=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "mod_typ_cd", phone.get("MOD_TYP_CD").toString().trim(), "PCT");
		
		
		Element.enterData(txtBoxLName, firstNameTxt, "Enter Last Name as : " + firstNameTxt ,"LastName");
		Element.enterData(txtBoxPhNo, phNo, "Enter Phone number in field 2 as: " + phNo,"phoneNum");
		Element.click(btnSave, "Save button");
		
		Browser.wait(testConfig, 5);
		
		Element.verifyTextPresent(updateMsg, "Your profile changes were updated successfully.");
		Map multiple=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "mod_typ_cd", multiple.get("MOD_TYP_CD").toString().trim(), "PCM");

	}
	

	public void updateAndVerifyProvDetails()
	{
		int sqlRowNo=406;
		String userEmailAdr=Helper.getUniqueEmailId();
		String phNo = Long.toString(Helper.generateRandomNumber(3));
		Element.enterData(txtBoxEmail,  userEmailAdr, "Enter existing email address as : " + userEmailAdr,"email");
		Element.enterData(txtBoxVerifyEmail, userEmailAdr,"Enter verify existing email address as : " + userEmailAdr,"Verify Email");
		Element.enterData(txtBoxPhNo1, phNo, "Enter Phone number in field 2 as: " + phNo,"phoneNum1");
		Element.click(btnSave, "Save button");
		Browser.wait(testConfig, 5);
		Element.verifyTextPresent(updateMsg, "Your profile changes were updated successfully.");
		Map query=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Phone number", query.get("TEL_NBR").toString(), txtBoxPhNo.getAttribute("value").toString()+txtBoxPhNo1.getAttribute("value").toString()+txtBoxPhNo2.getAttribute("value").toString());

	}
	
	public void verifyChangePwdSecurity() 
	{
		Element.verifyElementNotPresent(chngPwd, "Change Password Link/Text");
		Element.verifyElementNotPresent(mngSecQuestns, "Manage Security Questions Link/Text");
		
	}
	
	public void verifyOptumID()
	{	
		Element.verifyElementPresent(optumID, "Optum ID Option");	
	}
	
	


}