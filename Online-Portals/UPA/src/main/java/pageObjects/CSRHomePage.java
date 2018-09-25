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
	
    @FindBy(linkText="View Payments")
    WebElement lnkViewPayments;
	
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
		Element.expectedWait(txtloggedIn, testConfig, "User is successfully logged in", "Logged in text");
		Helper.compareContains(testConfig, "URL", expected,testConfig.driver.getTitle());	
	}

	
	
	public SearchTinPage clickManageUsersLink()
	{
		Element.clickByJS(testConfig,lnkManageUsers, "Manage Users");
		return new SearchTinPage(testConfig);
	}
	
    public SearchTinPageViewPayments clickViewPaymentsLink()
    {
           Element.click(lnkViewPayments, "View Payments");
           return new SearchTinPageViewPayments(testConfig);
    }

	
}
