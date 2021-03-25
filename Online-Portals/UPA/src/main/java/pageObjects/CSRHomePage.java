package main.java.pageObjects;

import java.util.List;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;

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
	
	private ViewPaymentsDataProvider dataProvider;

    @FindBy(css=".productName") 
	WebElement txtloggedIn;

	
//	@FindBy(xpath="//p[contains(text(),'With EPS Online Enrollment you can:')]")
//	WebElement txtloggedIn;
	
	@FindBy(xpath="//input[@value='Add TIN/NPI']")
	WebElement btnAddTin;
	
	@FindBy(name="GridListResults[0].accessLevel")
	WebElement drpDwnAccessLevel;
	
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement btnSaveUser;
	
//	@FindBy(linkText="Search Remittance")
//    WebElement lnkSearchRemittance;
	
	@FindBy(xpath="//a[contains(text(),'Billing Service Information')]")
	WebElement lnkbillingservice;
	
	@FindBy(xpath="//a[contains(text(),'Search Remittance')]")
	WebElement lnkSearchRemittance;
	
	@FindBy(xpath="//a[contains(text(),' Create/Maintain Enrollment')]")
	WebElement lnkCreateMaintainEnrollment;
	
	@FindBy(linkText="Common Reports")
    WebElement lnkComnRerts;

	@FindBy(css = "a.runtext")
    WebElement lnkCrtEnrl;
	
	@FindBy(linkText="Home")
	WebElement home;
	
	@FindBy(linkText="Optum Pay Solutions")
	WebElement lnkOptPaySoln;
	
	@FindBy(linkText="Manage Internal Users")
	WebElement lnkManageInternalUSer;
	
	@FindBy(linkText="Run Reports")
    WebElement linkRunReports;
	
	@FindBy(id="logOutId")
    WebElement linkLogout;
	
	@FindBy(xpath = "//a[contains(text(),'Payment Data Files')]") 
	WebElement linkPaymentDataFiles;
	
	CSRHomePage(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.fluentWait(testConfig, linkRunReports, 100, 1,"User is successfully logged in");
		
	}

	public SearchTinPage clickManageUsersLink()
	{
		Element.fluentWait(testConfig, lnkManageUsers, 200, 3, "Manage Users link");
		Element.clickByJS(testConfig,lnkManageUsers, "Manage Users");
		return new SearchTinPage(testConfig);
	}
	
    public SearchTinPageViewPayments clickViewPaymentsLink()
    {
    	   Element.fluentWait(testConfig, lnkViewPayments, 200, 3, "View Payments");
           Element.clickByJS(testConfig,lnkViewPayments, "View Payments");
           return new SearchTinPageViewPayments(testConfig);
    }
    
    public SearchTinPageSearchRemittance clickSearchRemittanceLink()
    {
           Element.clickByJS(testConfig,lnkSearchRemittance, "Search Remittance Link");
           return new SearchTinPageSearchRemittance(testConfig);
    }

    
    public void clickCreateMaintainEnrollmentLink()
    {
           Element.clickByJS(testConfig,lnkCreateMaintainEnrollment, "Create Maintain Enrollment Link");
    }

    public SelectReportsPage clickCommonReportsLink()
    {
           Element.clickByJS(testConfig,lnkComnRerts, "Common Report Link");
           return new SelectReportsPage(testConfig);
    }
    public CreateEnrollUsrTyp clickCrtEnrlmnt()
    {
           Element.clickByJS(testConfig,lnkCrtEnrl, "Create/Maintain Enrollment Link");
          return new CreateEnrollUsrTyp(testConfig);
    }
    
    public  void VerifyCSRLogin() {
    	Element.verifyElementPresent(home, "Home Button");
		Log.Comment("User is on CSR Home Page");
		if (home.isDisplayed()) {
	           Element.clickByJS(testConfig,home, "Home Link");
		}
		}
    
    public void clickBillingServiceInfoLink()
    {      Browser.wait(testConfig, 7);
           Element.clickByJS(testConfig,lnkbillingservice,"Billing Service Information");
           
    }
    public void clickOptmPaySolnLink()
    {      Browser.wait(testConfig, 2);
           Element.clickByJS(testConfig,lnkOptPaySoln,"Optum Pay Solutions");
           
    }
    public void clickManageInternalUserlink() {
		Element.clickByJS(testConfig, lnkManageInternalUSer, "Manage Internal Users Link");

	}

	public CSRHomePage fetchTin(String userType,String searchCriteria, String tinType,String portalAccess) {
		if(searchCriteria.contains("days") || searchCriteria.contains("month"))
			Helper.getPayerSchema(testConfig,searchCriteria);	
		String tin = getTin(userType,searchCriteria,tinType,portalAccess); 
		System.setProperty("tin", tin);
		return this;
	}
	
	public String getTin(String userType,String searchCriteria,String tinType,String portalAccess)
	{
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		String tin=dataProvider.getTinForSearchCriteria(searchCriteria,tinType,portalAccess);
		return tin;
	}
	
	public void clickRunReportLink() {
    	Element.clickByJS(testConfig,linkRunReports,"CLick the RunReport link");
    	Browser.wait(testConfig, 1);
	}
	public void clickLogoutCSR() {
		Element.clickByJS(testConfig,linkLogout,"Logout");
	}
	public SearchTinPagePaymentDataFiles clickPaymentDataFilesTab()
    {
		Element.expectedWait(linkPaymentDataFiles, testConfig, "Payment Data Files Link","Payment Data Files Link");
		Element.clickByJS(testConfig,linkPaymentDataFiles, "Payment Data Files Link");
		return new SearchTinPagePaymentDataFiles(testConfig);
		
	}
	
	public void dataPrepForFeeRefund() {
		//Prerequisites for getting tin for refund
		String pastDateForFeeRefund = Helper.getDateBeforeOrAfterDays(-59, "YYYY-MM-dd"); //This date should be lesser than or equal to 60 days in the past
		String feeRefundStartDate = Helper.getDateBeforeOrAfterDays(-60, "YYYY-MM-dd"); //Time frame for considering entries for refund
		testConfig.putRunTimeProperty("pastDateForFeeRefund", pastDateForFeeRefund);
	 	testConfig.putRunTimeProperty("feeRefundStartDate", feeRefundStartDate);
    	DataBase.executeUpdateQuery(testConfig, 2012); 
    	DataBase.executeUpdateQuery(testConfig, 2013);
    	Log.Comment("Dataset up for Refund successfully completed");

	}
}
