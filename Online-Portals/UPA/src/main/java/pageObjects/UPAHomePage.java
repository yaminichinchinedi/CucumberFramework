package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;

public class UPAHomePage {
	
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
	
	
	@FindBy(xpath="//span[contains(text(),'Welcome Screen')]") 
	WebElement txtloggedIn;
	
	@FindBy(xpath="//input[@value='Add TIN/NPI']")
	WebElement btnAddTin;
	
	@FindBy(name="GridListResults[0].accessLevel")
	WebElement drpDwnAccessLevel;
	
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement btnSaveUser;
	
	@FindBy(linkText="Search Remittance")
    WebElement lnkSearchRemittance;
	
	
	@FindBy(xpath = "//select[@id='taxIndNbrId']") WebElement tinDrpDwn;
	
	
	UPAHomePage(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//span[contains(text(),'Welcome Screen')]"), 60);
		//Element.expectedWait(txtloggedIn, testConfig, "User is successfully logged in", "Logged in text");	
	}

	public SearchTinPage clickManageUsersLink()
	{
		Element.clickByJS(testConfig,lnkManageUsers, "Manage Users");
		return new SearchTinPage(testConfig);
	}
	
    public SearchTinPageViewPayments clickViewPaymentsLink()
    {
           Element.clickByJS(testConfig,lnkViewPayments, "View Payments");
           return new SearchTinPageViewPayments(testConfig);
    }
    
    public SearchTinPageSearchRemittance clickSearchRemittanceLink()
    {
           Element.clickByJS(testConfig,lnkSearchRemittance, "Search Remittance Link");
           return new SearchTinPageSearchRemittance(testConfig);
    }

	
	public void selectTINforUPA() 
	{
		
		Element.selectVisibleText(tinDrpDwn,"133757370 - Enrolled","TIN Selection from Dropdown");
		Log.Comment("TIN selected: 133757370 - Enrolled");
	}
	
	
	public void clickViewPaymentsLinkUPA() 
	{
		
		Browser.wait(testConfig, 5);
        Element.clickByJS(testConfig,lnkViewPayments, "View Payments");
		
	}
	
	
	public void clickSearchRemitUPA() 
	{
		
		Browser.wait(testConfig, 5);
        Element.clickByJS(testConfig,lnkSearchRemittance, "Search Remittance");
		
	}

	
}
