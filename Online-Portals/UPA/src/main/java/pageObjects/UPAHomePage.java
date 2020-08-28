package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;

public class UPAHomePage extends HomePage {
	
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
	
	
	@FindBy(id="taxIndNbrId") WebElement tinDrpDwn;
	
	private ViewPaymentsDataProvider dataProvider;
	
	
	UPAHomePage(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.fluentWait(testConfig, txtWelcomeScreen, 100, 5, "Welcome Screen Text ");	
	}

	public ManageUsers clickManageUsersTab()
	{
		Element.expectedWait(manageUsersTab, testConfig, "Manage users tab","Manage Users tab");
		Element.click(lnkManageUsers, "Manage Users");
		return new ManageUsers(testConfig);
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

	public UPAHomePage selectTin() 
	 {
			int sqlRow=23;
			Map provDetails=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
			Element.selectByVisibleText(tinDrpDwn,provDetails.get("PROV_TIN_NBR").toString()+" - Enrolled", " Selected Tin is : "  +provDetails.get("PROV_TIN_NBR").toString());
			Browser.waitForLoad(testConfig.driver);
			Element.expectedWait(tinDrpDwn, testConfig, "Tin dropdown ",  "Tin dropdown");
			testConfig.putRunTimeProperty("tin", provDetails.get("PROV_TIN_NBR").toString());
			return new UPAHomePage(testConfig);
	}


	
	public HomePage selectTin(String paymentType) 
	 {
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		String tin=dataProvider.getTinForPaymentType(paymentType);
		dataProvider.associateTinWithUser(tin);
		List <String> tinList=Element.getAllOptionsInSelect(testConfig,drpDwnTin);
		tin=tin+" - Enrolled";
		
		if((!tinList.contains(tin))){
		   Element.click(homeTab, "home Tab");
		   Browser.waitForLoad(testConfig.driver);
		   Browser.wait(testConfig, 3);
		   Element.expectedWait(drpDwnTin, testConfig, "Tin dropdown", "Tin dropdown"); 
		 }
		
		Element.selectByVisibleText(drpDwnTin,tin, "Tin is : "  + tin);
		Browser.waitForLoad(testConfig.driver);
		return this;
	}
}
