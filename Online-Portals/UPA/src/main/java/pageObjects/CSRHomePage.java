package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;

public class CSRHomePage {
	
	private WebDriver driver;
	private TestBase testConfig;
	
	
	@FindBy(linkText="Manage Users")
	WebElement lnkManageUsers;
	
	@FindBy(id="userTypeSelection")
	WebElement drpDownUserType;
	
	@FindBy(name="identifierNbr")
	WebElement txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	WebElement btnSearch;
	
	@FindBy(xpath="//input[@value='Add User']")
	WebElement btnAddUser;
	
	@FindBy(name="fname")
	WebElement txtboxFirstName;
	
	@FindBy(name="lname")
	WebElement txtboxLstName;
	
	@FindBy(name="phoneNum")
	WebElement phoneNum;
	
	@FindBy(name="phoneNum1")
	WebElement phoneNum1;
	
	@FindBy(name="phoneNum2")
	WebElement phoneNum2;
	
	@FindBy(name="email")
	WebElement txtboxEmail;
	
	@FindBy(name="verifyEmail")
	WebElement txtboxVerifyEmail;
	
	@FindBy(name="addTincsr")
	WebElement addTin;
	
	
	@FindBy(xpath="//td[contains(text(),'You are logged in to support : All Payers')]") 
	WebElement txtloggedIn;
	
	@FindBy(xpath="//input[@value='Add TIN/NPI']")
	WebElement btnAddTin;
	
	@FindBy(name="GridListResults[0].accessLevel")
	WebElement drpDwnAccessLevel;
	
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement btnSaveUser;  
	
	
	CSRHomePage(TestBase testConfig) 
	{
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expected = "Welcome";
		Helper.compareContains(testConfig, "URL", expected,testConfig.driver.getTitle());
		Element.verifyElementPresent(txtloggedIn,"User is successfully logged in");
		
	}

	
	
	public SearchTinPage clickManageUsersLink()
	{
		Element.click(lnkManageUsers, "Manage Users");
		Browser.waitForLoad(testConfig.driver);
		return new SearchTinPage(testConfig);
	}
	
	public void addNewUser()
	{
		Element.click(lnkManageUsers, "Click Manage Users");
		Element.selectByValue(drpDownUserType, "PROV", "Select provider type");
		Element.enterData(txtboxTinNo, "999776123","enter tin number","txtboxTinNo");
		
		Element.click(btnSearch, "click search button");
		Element.click(btnAddUser, "click Add user button");
		Element.enterData(txtboxFirstName,Helper.generateRandomAlphabetsString(5), "Entered first name","txtboxFirstName");
		Element.enterData(txtboxLstName,Helper.generateRandomAlphabetsString(5), "Entered Last name","txtboxLstName");
		Element.enterData(phoneNum,Long.toString(Helper.generateRandomNumber(3)), "Entered first 3 numbers","phoneNum");
		Element.enterData(phoneNum1,Long.toString(Helper.generateRandomNumber(3)), "Entered second 3 numbers","phoneNum1");
		Element.enterData(phoneNum2,Long.toString(Helper.generateRandomNumber(3)), "Entered last 4 digits","phoneNum2");
		Element.enterData(addTin, "999776123", "Associate to tin","addTin");
		Element.click(btnAddTin, "click add tin");
		Element.selectByValue(drpDwnAccessLevel, "A", "select administrator");
		Browser.wait(testConfig, 5);
		Element.click(btnSaveUser, "Click save");
		
	}
}
