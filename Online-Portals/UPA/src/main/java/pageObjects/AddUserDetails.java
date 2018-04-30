package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.DataBase.DatabaseType;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserDetails {
	
	
	@FindBy(name="fname")
	WebElement firstName;
	
	@FindBy(name="lname")
	WebElement lastName;
	
	@FindBy(xpath="//input[not(contains(@type,'hidden')) and @name='phoneNum']")
	WebElement phoneNum;
	
	@FindBy(xpath="//input[not(contains(@type,'hidden')) and @name='phoneNum1']")
	WebElement phoneNum1;
	
	@FindBy(xpath="//input[not(contains(@type,'hidden')) and @name='phoneNum2']")
	WebElement phoneNum2;
	
	@FindBy(name="email")
	WebElement email;
	
	
	@FindBy(name="addTincsr")
	WebElement addTin;
	
	@FindBy(name="mdlName")
	WebElement middleName;
	
	@FindBy(name="verifyEmail")
	WebElement verifyEmail;
	
	@FindBy(name="addTin")
	WebElement drpDwnSelectTin;
	
	@FindBy(name="extension")
	WebElement extension;
	
	@FindBy(name="No")
	WebElement btnNoForExistingUser;
	
	@FindBy(xpath="//input[@value='Add User']")
	WebElement btnAddUser;
	
	@FindBy(xpath="//input[@value=' Save ']")
	WebElement btnSave;
	

	
	//"//td[@class='subheadernormal'][2]")+ "//td[@class='subheadernormal']//following-sibling::td[@class='subheadernormal']")
	@FindBy(xpath="//td[contains(text(),'Provider')]")
	WebElement txtUserType;
			
	@FindBy(name="GridListResults[0].providerTinNumber")
	WebElement associatedTinNo;
	
	@FindBy(xpath="//span[contains(text(),'Status')]")
	WebElement enrollmentStatus;
			
	@FindBy(xpath ="//td[contains(text(),'Confirm Existing User')]")
	WebElement exitingUserText;
	
	@FindBy(xpath="//div[@id='flow']//tbody//a[contains(text(),firstName.getText())]")
	WebElement userNameInUserList;
	
	@FindBy(xpath="//font[contains(text(),'Selected TIN')]")
	WebElement errorInvalidTin;
	
	@FindBy(xpath="//font[contains(text(),'TIN grid is empty')]")
	WebElement errorEmptyGrid;
	
	@FindBy(xpath="//font[contains(text(),'Invalid First')]")
	WebElement errorFname;
	
	@FindBy(xpath="//font[contains(text(),'Invalid Extension')]")
	WebElement errorExtension;
	
	@FindBy(xpath="//font[contains(text(),'Invalid Last')]")
	WebElement errorLname;
	
	@FindBy(xpath="//font[contains(text(),'Invalid Phone')]")
	WebElement errorPhone;
	
	@FindBy(xpath="//font[contains(text(),'Invalid Email')]")
	WebElement errorEmail;
	
	@FindBy(xpath="//font[contains(text(),'Invalid Retype Email')]")
	WebElement errorRetypeEmail;
	
	
	@FindBy(xpath="//input[@value='Add TIN/NPI']")
	WebElement btnAddTin_NPI;
	
	@FindBy(css=".rowDark>td>select")
	WebElement drpDwnTinAccessLvl;
	
	
	@FindBy(xpath="//div[@id='flow']//tbody//a")
	List <WebElement> userNames;
	

	private TestBase testConfig;
	String phNo = Long.toString(Helper.generateRandomNumber(3));
	String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
	String userEmailAdr=Helper.getUniqueEmailId();
	
	 static final String firstNameTxt=Helper.generateRandomAlphabetsString(3);
	
	
	
	public AddUserDetails(TestBase testConfig) {
		// TODO Auto-generated constructor stub
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
     	Element.expectedWait(firstName, testConfig, "First Name textbox", "First Name textbox");
		
	}
	
	//Creating Default constructor
	public AddUserDetails() 
	 {	
		//Element.verifyElementPresent(firstName, "First Name textbox");
	 }

	public AddUserDetails fillNewUserInfo()
	{
		
		testConfig.putRunTimeProperty("email", userEmailAdr);
		
		Element.enterData(firstName, firstNameTxt, "Enter First Name as : " + firstNameTxt,"firstName");
		Element.enterData(lastName, firstNameTxt, "Enter Last Name as : " + firstNameTxt,"lastName");
		
		
		Element.enterData(phoneNum, phNo, "Enter Phone number in field 1 as:" + " "+phNo,"phoneNum");
		Element.enterData(phoneNum1, phNo, "Enter Phone number in field 2 as:" +" "+phNo,"phoneNum1");
		Element.enterData(phoneNum2, phNoLstField, "Enter Phone number in field 3 as:" + " "+phNoLstField ,"phoneNum2");
		Element.enterData(email, userEmailAdr, "Enter Email address as:" + " " +userEmailAdr,"email");
		Element.enterData(verifyEmail, userEmailAdr, "Re type email address as :" +" "+userEmailAdr ,"verifyEmail");
		return new AddUserDetails(testConfig);
		
	}
	
	public AddUserDetails selectAndAddTin()
	{
		//Element.selectByValue(drpDwnSelectTin, testConfig.getRunTimeProperty("tin"), "select tin");
		Element.selectByIndex(drpDwnSelectTin, 1, "Select first tin");
		Browser.wait(testConfig,2);
		clickAddTin();
		
		return this;
		
	}
	
	public AddUserDetails addTinCSR()
	{
		Element.enterData(addTin,testConfig.getRunTimeProperty("tin"), "Associate to tin","addTin");
        
		clickAddTin();
		return this;
	}
	
	public AddUserDetails clickAddTin()
	{
		Element.click(btnAddTin_NPI, "Add Tin/NPI");
		return this;
	}
	
	
	public AddUserDetails selectTinAccessLvl(String accessLevel)
	{
		 List <WebElement> accessLvls=testConfig.driver.findElements(By.xpath("//select[not(contains(@id,'accessLevel'))]/parent::td//select"));
		 Element.selectByVisibleText(accessLvls.get(0), accessLevel, accessLevel+ ":" + " " + "as access level");
		 Browser.wait(testConfig,2);
		 return this;
	}
	
	public ManageUsers clickSave()
	{
		Element.expectedWait(btnSave, testConfig, "Save button", "Save button");
		Element.click(btnSave, "Save");
		return new ManageUsers(testConfig) ;
		
	}
	
	
	
	public ManageUsers verifyDetailsOfNewUser(String userType)
	{
		int sqlRowNo=0;
		Map portalUser=null;
		for(WebElement userName:userNames)
		{ 
			if(userName.getText().toString().contains(firstNameTxt))
					{
				      Element.click(userName, "UserName: "+ " " +firstNameTxt);
				      break;
					}
		}
		
		if(userType.equalsIgnoreCase("BS"))
		{
			 sqlRowNo=13;
		     portalUser = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    
		}
		else if(userType.equalsIgnoreCase("PROV"))
		{
			sqlRowNo=9;
			portalUser = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			try
			{
			Helper.compareEquals(testConfig, "User Type", (portalUser.get("PAY_PROC_ACPT_CD_VAL_DESC").toString()), txtUserType.getText());
			Helper.compareEquals(testConfig, "Associated Tin Number", portalUser.get("PROV_TIN_NBR").toString(), associatedTinNo.getAttribute("value"));
			Helper.compareContains(testConfig, "Status", convertStatusType(portalUser.get("STS_CD").toString()), enrollmentStatus.getText());
			}
			catch(Exception e)
			{
				LogTemp.Fail("Exception occured : " + e);
			}
		}
		
		else if(userType.equalsIgnoreCase("PAY"))
		{
			sqlRowNo=13;
		    portalUser = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		}
	   
		Browser.wait(testConfig, 3);
	    Helper.compareEquals(testConfig, "First name", portalUser.get("FST_NM").toString(), firstName.getAttribute("value").toString());
	    Helper.compareEquals(testConfig, "Last name", portalUser.get("LST_NM").toString(), lastName.getAttribute("value").toString());
	    Helper.compareEquals(testConfig, "Phone number", portalUser.get("TEL_NBR").toString(), phoneNum.getAttribute("value").toString()+phoneNum1.getAttribute("value").toString()+phoneNum2.getAttribute("value").toString());
	    Helper.compareEquals(testConfig, "Email address", portalUser.get("EMAIL_ADR_TXT").toString(), email.getAttribute("value").toString());
	    return new ManageUsers(testConfig);
	    
	}
	
	public String convertStatusType(String DBUserType)
	{
		switch(DBUserType)
		{
		   case  "PR" : 
			return "Pending Registration";
			
		    case "A" :
		    return "Active";
		    
		    default:
		    return "Incorrect user type";
					
			
		}
	}
	
	
	
	
	public void verifyAssociatedTins() throws IOException
	{
		int sqlRowNo = 8;
		ArrayList<String> tinsListFromDB = new ArrayList<String>();
		List<String> tinsListFromUI = new ArrayList<String>();

		HashMap<Integer, HashMap<String, String>> associatedTins = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		for (int i = 1; i <= associatedTins.size(); i++) {
			tinsListFromDB.add(associatedTins.get(i).get("PROV_TIN_NBR"));
		}
		tinsListFromUI = Element.getAllOptionsInSelect(testConfig, drpDwnSelectTin);
		List<String> newListFromUI = new ArrayList<String>();
		for (String tinNo : tinsListFromUI) {
			String tin[] = tinNo.split("-");
			newListFromUI.add(tin[0].trim());
		}
		
		LogTemp.Comment("List of tins from UI is :" + '\n' + newListFromUI, "Green");
		LogTemp.Comment("List of tins from DB is :" + '\n' + tinsListFromDB, "Green");
		
		for (String tinNo : tinsListFromDB) {
			if (newListFromUI.contains(tinNo)) {
				LogTemp.Pass(tinNo + " :" + " " + "matches in both UI and DB");
			}

			else {
				LogTemp.Fail(tinNo + " :" + " " + "not present in DB");
				break;
			}
		}
	}
	public void verifyErrorMessages() throws IOException
	{

		int sqlRowNo=6;
		Map enrolledProviderTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String existingEmailAdr=enrolledProviderTable.get("EMAIL_ADR_TXT").toString().toLowerCase().trim();
		
		
		//Leave all fields blank and click Save
		Element.click(btnSave, "Save button");
		
		//Verify error messages when mandatory fields are left blank
		Element.verifyTextPresent(errorFname, "Invalid First Name");
		Element.verifyTextPresent(errorLname, "Invalid Last Name");
		Element.verifyTextPresent(errorPhone, "Invalid Phone Number");
		Element.verifyTextPresent(errorEmail, "Invalid Email Address");
		Element.verifyTextPresent(errorRetypeEmail, "Invalid Retype Email Address");
		
		//verify error message when tin is not selected
		fillNewUserInfo();
		Element.click(btnSave, "Save button");;
		Element.verifyTextPresent(errorEmptyGrid, "TIN grid is empty, add at least one record");
		Element.verifyTextPresent(errorInvalidTin, "Selected TIN is invalid");
		
		//Verify error message when invalid characters are entered in name fields and alphabets entered as ph no.
		Element.enterData(firstName, "@#", "Enter First Name as : " + "@#","firstName");
		Element.enterData(lastName, "@#", "Enter Last Name as : " + "@#","lastName");
		Element.enterData(phoneNum, firstNameTxt, "Enter Phone number in field 1 as:" + " "+firstNameTxt,"phoneNum");
		Element.enterData(phoneNum1, firstNameTxt, "Enter Phone number in field 2 as:" +" "+firstNameTxt,"phoneNum1");
		Element.enterData(phoneNum2, firstNameTxt, "Enter Phone number in field 3 as:" + " "+firstNameTxt ,"phoneNum2");
		Element.enterData(extension, firstNameTxt, "Enter extension  as:" + " "+firstNameTxt ,"extension");
		Element.enterData(email, firstNameTxt, "Enter Email address as:" + " " +firstNameTxt,"email");
		Element.enterData(verifyEmail, userEmailAdr, "Re type email address as :" +" "+userEmailAdr ,"verifyEmail");
		selectAndAddTin();
		Element.click(btnSave, "Save button");
		
		Element.verifyTextPresent(errorFname, "Invalid First Name");
		Element.verifyTextPresent(errorLname, "Invalid Last Name");
		Element.verifyTextPresent(errorPhone, "Invalid Phone Number");
		Element.verifyTextPresent(errorExtension, "Invalid Extension");
		Element.verifyTextPresent(errorEmail, "Invalid Email Address");
		Element.verifyTextPresent(errorRetypeEmail, "Invalid Retype Email Address");
		
		//Verify phone number field Allows 10 digits (Mandatory) 
		
		
		Element.enterData(phoneNum, phNo, "Enter Phone number in field 1 as:" + " "+phNo,"phoneNum");
		Element.enterData(phoneNum1, phNo, "Enter Phone number in field 2 as:" +" "+phNo,"phoneNum1");
		Element.enterData(phoneNum2, phNo, "Enter Phone number in field 3 as:" + " "+phNo ,"phoneNum2");
		Element.enterData(middleName, firstNameTxt, "Enter Middle name as :" + " " + firstNameTxt, "Middle Name");
		if(middleName.getAttribute("value").length()!=1)
		{
			LogTemp.Fail("Middle name allowing characters more than 1 which is" + middleName.getAttribute("value"));
		}
		else
		{
			LogTemp.Pass("Middle name allowing only one character which is :" + " " + firstNameTxt.charAt(0) );
		}
		
		Element.click(btnSave, "Save button");
		
		Element.verifyTextPresent(errorPhone, "Invalid Phone Number");
		
		//VErify Duplicate email is not allowed
		
		Element.enterData(firstName, firstNameTxt, "Enter First Name as : " + firstNameTxt,"firstName");
		Element.enterData(lastName, firstNameTxt, "Enter Last Name as : " + firstNameTxt,"lastName");
		Element.enterData(phoneNum, phNo, "Enter Phone number in field 1 as:" + " "+phNo,"phoneNum");
		Element.enterData(phoneNum1, phNo, "Enter Phone number in field 2 as:" +" "+phNo,"phoneNum1");
		Element.enterData(phoneNum2, phNoLstField, "Enter Phone number in field 3 as:" + " "+phNoLstField ,"phoneNum2");
		Element.enterData(email, existingEmailAdr, "Enter Email address as:" + " " +existingEmailAdr,"email");
		Element.enterData(verifyEmail, existingEmailAdr, "Re type email address as :" +" "+existingEmailAdr ,"verifyEmail");
		extension.clear();
		String accessLevel="Administrator";
		selectTinAccessLvl(accessLevel);
		Element.click(btnSave, "Save button");
		String expString="Confirm Existing User";
		Element.verifyTextPresent(exitingUserText,expString);
		
		//verifyAssociatedTins();
		
	}
	
	
	
}
