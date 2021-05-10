package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;
import main.java.reporting.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;

import org.testng.Assert;

public class UPAHomePage extends HomePage {
	
	private WebDriver driver;
	private TestBase testConfig;
	private ViewPaymentsDataProvider dataProvider;

	@FindBy(xpath="//a[@id=\"tabManageusers\"]")
	WebElement lnkManageUsers;
	
	@FindBy(id="tabHome")
	WebElement homeTab;

	@FindBy(id = "taxIndNbrId")
	WebElement drpDwnTin;
	
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
	
	@FindBy(id="taxIndNbrId") 
	WebElement tinDrpDwn;
	
	@FindBy(linkText = "Billing Service Information") 
	WebElement lnkBsInfo;
	
	@FindBy(linkText = "Optum Pay Solutions") 
	WebElement lnkOptumPaySol;
	
	@FindBy (xpath="//table[@id='outerTable']//section/div[1]//p")
	WebElement txthomepageAlert;
	
	@FindBy(xpath="//table[@id='outerTable']//section/div[1]//p//a")
	WebElement lnkFAQAlertText;

	@FindBy(xpath = "//a[contains(text(),'Resources')]")
	//@FindBy(xpath="//*[@id=\"withoutHomeId\"]/a[1]")
	WebElement  resourcesDropDown;
	
	@FindBy(linkText="FAQs")
	WebElement  resourcesFaqs;
	
	@FindBy(linkText="VCP FAQs")
	WebElement  vcpFaqs;
	
	@FindBy(linkText="Terms & Conditions")
	WebElement  resourcesTnc;

	@FindBy(linkText="Document Vault")
	WebElement  resourcesDocVault;
	
	@FindBy(xpath = "//span[contains(text(),'Partner Links')]")
	WebElement  resourcesPartnerLink;
	
	@FindBy(linkText="Cancel Form")
	WebElement  resourcesCancelForm;
	
	@FindBy(linkText="Cancellation Form")
	WebElement  CancellationForm;
	
	@FindBy(id="guide-top")
	WebElement  guideSection;
	
	@FindBy(linkText="SIGN IN") 
	WebElement signInBtn;
	
	@FindBy(tagName="header") 
	WebElement header;

	@FindBy(xpath="//b[contains(text(),'Terms and Conditions')]")
	WebElement tncText;
	
	@FindBy(name = "acceptTerms")
	WebElement tncChkBox;
	
	@FindBy(name = "btnSubmit")
	WebElement btnSubmit;
	
	@FindBy(name = "btnCancel")
	WebElement btnCancel;

	@FindBy(linkText="Download Terms and Conditions")
	WebElement tncPdf;

	@FindBy(linkText="Capitation Reports")
	WebElement  lnkResourcesCapitationReport;

	

	@FindBy(xpath="//p[contains(text(),'Bring more power to your practice')]")
	WebElement bringMorePowerPopUp;
	
	@FindBy(xpath="//span[contains(text(),'No, Thanks')]")
	WebElement btnNoThanks;
	
	@FindBy(xpath="//div[@id='tabPrmryMenu']/ul")
	WebElement tabMenu ;
	
	@FindBy(xpath="//span[contains(text(),'I Accept, Activate Premium Services')]")
	WebElement btnIAccept;
	
	

	@FindBy(xpath = "//select[@id='taxIndNbrId']") 
	WebElement prvdrTIN;
	
	@FindBy(linkText="Logout") 
	WebElement lnkLogout;
	@FindBy(className="slide image")
	List<WebElement> imageTiles;
	@FindBy(className="slide video")
	List<WebElement> videoTiles;
	public UPAHomePage(TestBase testConfig) 
	{
 		super(testConfig);
		this.testConfig=testConfig;
		PageFactory.initElements(TestBase.driver, this);
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

	public void clickViewPaymentsLinkUPA() 
	{
		Browser.wait(testConfig, 3);
        Element.clickByJS(testConfig,lnkViewPayments, "View Payments");
	}
	
	public void clickSearchRemitUPA() 
	{
		Browser.wait(testConfig, 3);
        Element.clickByJS(testConfig,lnkSearchRemittance, "Search Remittance");
	}
	

	public void clickManageUsersLink()
	{
		Element.clickByJS(testConfig,lnkManageUsers, "Manage Users");
	}
	
	public void clickOnBSInfoTabUPA() {
		Browser.wait(testConfig, 3);
        Element.clickByJS(testConfig,lnkBsInfo, "Billing Service Information");
	}
	
	public void clickOnOptumPaySolutionsTabUPA() {
		Browser.wait(testConfig, 3);
        Element.clickByJS(testConfig,lnkOptumPaySol, "Optum Pay Solutions");
	}

	public void verifyHomePageAlertUPA(String portalAccess,String tinType) {
		if(tinType.equalsIgnoreCase("AO"))
		{
		 if(portalAccess.equalsIgnoreCase("Standard"))
		    Helper.compareEquals(testConfig, "Standard Alert text", "You're going to lose important functionality by not activating, be sure to sign up before the free trial ends.", txthomepageAlert.getText().toString());
		 else if(portalAccess.equalsIgnoreCase("Premium"))
		   {      
			   Helper.compareEquals(testConfig, "Premium Alert text", "Optum Pay will debit your bank account at the end of the billing cycle; please ensure you've taken the necessary steps by reviewing our FAQ's for important information.", txthomepageAlert.getText().toString());
			   Element.clickByJS(testConfig, lnkFAQAlertText, "lnkFAQAlertText");
			   String parentwindowhandle=TestBase.driver.getWindowHandle();
			   Browser.switchToNewWindow(testConfig);
			   String expectePrivacydURL = "epsFaqs.do?from=dropdown#how-am-i-billed";
			   Browser.verifyURL(testConfig, expectePrivacydURL);
			   Browser.switchToParentWindow( testConfig,  parentwindowhandle);
		  }
		}
	}

	public void hoverOnResourceDropDown()
	{
		Element.mouseHoverByJS(testConfig, resourcesDropDown, "Resources Drp Dwn");
	}
	
	public void verifyFaqsFromResources()
	{
		Element.verifyElementNotPresent(vcpFaqs, "VCP FAQs");
		Element.verifyElementPresent(resourcesFaqs, "FAQs");
		String parentwindowhandle=testConfig.driver.getWindowHandle();
		Element.click(resourcesFaqs, "FAQs");
		Browser.switchToNewWindow(testConfig);
		String faqsUrl = "/epsFaqs.do";
		Browser.verifyURL(testConfig, faqsUrl);
		
		verifyElementNotPresentOnFaq();
		
		Helper.compareEquals(testConfig, "Tnc windows", 2, Browser.getNoOfWindowHandles(testConfig));
		Browser.closeBrowser(testConfig);
		Browser.switchToParentWindow( testConfig,  parentwindowhandle);
	}
	
	public void verifyElementNotPresentOnFaq()
	{
		Element.verifyElementNotPresent(guideSection, "Guides");
		Element.verifyElementNotPresent(signInBtn, "Sign In");
		Element.verifyElementNotPresent(header, "Header");

	}
	public void verifyTncLinkUnderResources()
	{
		Element.verifyElementPresent(resourcesTnc, "TnC");
		String parentwindowhandle=TestBase.driver.getWindowHandle();
		Element.click(resourcesTnc, "TnC");
		Browser.switchToNewWindow(testConfig);
		Helper.compareEquals(testConfig, "Tnc windows", 2, Browser.getNoOfWindowHandles(testConfig));
		Browser.closeBrowser(testConfig);		
		Browser.switchToParentWindow( testConfig,  parentwindowhandle);
	}
	
	public void verifyTncPageAppears()
	{
		Element.verifyElementPresent(tncText, "TnC text");
		Element.verifyElementPresent(tncChkBox, "TnC accept checkbox");
		Element.verifyElementPresent(btnSubmit, "Submit btn");
		Element.verifyElementPresent(btnCancel, "Cancel btn");
		Element.verifyElementPresent(tncPdf, "TnC Pdf");
	}
	
	public void downloadTncPdf()
	{
		Element.verifyElementPresent(tncPdf, "TnC");
		String parentwindowhandle=TestBase.driver.getWindowHandle();
		Element.click(tncPdf, "TnC");
		Browser.switchToNewWindow(testConfig);
		Browser.switchToParentWindow( testConfig,  parentwindowhandle);
	}
	
	public  UPAHomePage acceptTncAndSubmit()
	{
		Element.verifyElementNotEnabled(btnSubmit, "Submit button");
		Element.clickByJS(testConfig, tncChkBox, "TnC accept checkbox");
		Map attributes=Element.getAllAttributes(testConfig, btnSubmit, "Update button");
		if(!attributes.containsKey("disabled"))
		{
			Log.Pass("Submit is enabled after TnC is accepted");
		}
		else 
			Log.Fail("Submit mustn't be disabled after TnC is accepted");
		Element.clickByJS(testConfig, btnSubmit, "Submit");
		return this;
	}
	
	public  UPAHomePage verifyIfTncIsUpdated()
	{
		int sql=7;
		Map tncStatus=DataBase.executeSelectQuery(testConfig, sql, 1);
		String tncAcceptStatus = tncStatus.get("TC_ACCEPT_IND").toString().trim();
		Helper.compareEquals(testConfig, "Terms and conditions accept status", "Y", tncAcceptStatus);
		return this;
	}
	
	public UPAHomePage fetchTin(String userType,String searchCriteria, String tinType,String portalAccess) {
		if(searchCriteria.contains("days") || searchCriteria.contains("month"))
			Helper.getPayerSchema(testConfig,searchCriteria,userType);	
		String tin = getTin(userType,searchCriteria,tinType,portalAccess); 
		System.setProperty("tin", tin);
		testConfig.putRunTimeProperty("userType",userType);
		testConfig.putRunTimeProperty("searchCriteria", searchCriteria);
		switch (userType)
			{
			   case "PROV": 
				 WebElement homeTab = Element.findElement(testConfig, "id", "tabHome");
				 List<String> tinList = Element.getAllOptionsInSelect(testConfig, prvdrTIN);
	
				 String Enrolledtin = tin + " - Enrolled";
				 if ((!tinList.contains(Enrolledtin))) 
				 {
					Element.click(homeTab, "home Tab");
					Browser.waitForLoad(testConfig.driver);
					Browser.wait(testConfig, 2);
					Element.fluentWait(testConfig, prvdrTIN, 60, 1, "Tin dropdown");
				 }
				Element.selectVisibleText(prvdrTIN, tin + " - Enrolled", "TIN Selection from Dropdown");
				break;
			case "BS": 
				Log.Comment("Tin fetched as per search criteria is : "+tin);
				break;
			case "Payer": 
				Log.Comment("Tin fetched as per search criteria is : "+tin);
				break;
			}
		return this;
	}

	public String getTin(String userType,String searchCriteria,String tinType,String portalAccess)
	{
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		String tin=dataProvider.getTinForSearchCriteria(searchCriteria,tinType,portalAccess);
		dataProvider.associateTinWithUser(userType,tin);
		return tin;
	}

	/**
	 * Author: Vinay Raghumanda
	 * Verifies Home page Carousel text for different types of users
	 * @param userType
	 * @param credentials
	 */
	public void verifyHomePageCarouselText(String userType, String credentials) {
		switch (userType) {
			case "BS_Admin":
				String[] expectedBSHeaders = {
						TestBase.contentMessages.getProperty("bs.admin.home.car1.header"),
						TestBase.contentMessages.getProperty("bs.admin.home.car2.header"),
						TestBase.contentMessages.getProperty("bs.admin.home.car3.header"),
						TestBase.contentMessages.getProperty("bs.admin.home.car4.header"),
						TestBase.contentMessages.getProperty("bs.admin.home.car5.header")
				};
				String[] expectedBSTexts = {
						TestBase.contentMessages.getProperty("bs.admin.home.car1.text"),
						TestBase.contentMessages.getProperty("bs.admin.home.car2.text"),
						TestBase.contentMessages.getProperty("bs.admin.home.car3.text"),
						TestBase.contentMessages.getProperty("bs.admin.home.car4.text"),
						TestBase.contentMessages.getProperty("bs.admin.home.car5.text")
				};
				homePageCarouselTextValidation(expectedBSHeaders, expectedBSTexts);
				break;
			case "PAY_Admin":
				String[] expectedPayerHeaders = {
						TestBase.contentMessages.getProperty("payer.admin.home.car1.header"),
						TestBase.contentMessages.getProperty("payer.admin.home.car2.header"),
						TestBase.contentMessages.getProperty("payer.admin.home.car3.header"),
						TestBase.contentMessages.getProperty("payer.admin.home.car4.header"),
						TestBase.contentMessages.getProperty("payer.admin.home.car5.header")
				};
				String[] expectedPayerTexts = {
						TestBase.contentMessages.getProperty("payer.admin.home.car1.text"),
						TestBase.contentMessages.getProperty("payer.admin.home.car2.text"),
						TestBase.contentMessages.getProperty("payer.admin.home.car3.text"),
						TestBase.contentMessages.getProperty("payer.admin.home.car4.text"),
						TestBase.contentMessages.getProperty("payer.admin.home.car5.text")
				};
				homePageCarouselTextValidation(expectedPayerHeaders, expectedPayerTexts);
				break;
			case "PROV":
				if (testConfig.getRunTimeProperty("portalAccess").equalsIgnoreCase("Premium") &&
						credentials.equalsIgnoreCase("PROV_Admin") &&
						testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO") && StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and Paid")) {
					String[] expectedProvHeaders = {
							TestBase.contentMessages.getProperty("prov.admin.premium.trial.home.car1.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.trial.home.car2.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.trial.home.car3.header")
					};

					String[] expectedProvTexts = {
							TestBase.contentMessages.getProperty("prov.admin.premium.trial.home.car1.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.trial.home.car2.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.trial.home.car3.text")
					};
					homePageCarouselTextValidation(expectedProvHeaders, expectedProvTexts);
					break;
				}
				else if (testConfig.getRunTimeProperty("portalAccess").equalsIgnoreCase("Premium") &&
						credentials.equalsIgnoreCase("PROV_Admin") &&
						testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO")) {
					String[] expectedProvHeaders = {
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car1.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car2.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car3.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car4.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car5.header")
					};

					String[] expectedProvTexts = {
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car1.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car2.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car3.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car4.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.home.car5.text")
					};
					homePageCarouselTextValidation(expectedProvHeaders, expectedProvTexts);
					break;
				} else if (testConfig.getRunTimeProperty("portalAccess").equalsIgnoreCase("Standard") &&
						credentials.equalsIgnoreCase("PROV_Admin") &&
						testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO")) {
					String[] expectedProvHeaders = {
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car1.header"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car2.header"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car3.header"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car4.header"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car5.header")
					};

					String[] expectedProvTexts = {
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car1.text"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car2.text"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car3.text"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car4.text"),
							TestBase.contentMessages.getProperty("prov.admin.standard.home.car5.text")
					};
					homePageCarouselTextValidation(expectedProvHeaders, expectedProvTexts);
					break;
				} else if (testConfig.getRunTimeProperty("portalAccess").equalsIgnoreCase("Premium") &&
						credentials.equalsIgnoreCase("PROV_Gen") &&
						testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO")) {
					String[] expectedProvHeaders = {
							TestBase.contentMessages.getProperty("prov.general.premium.home.car1.header"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car2.header"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car3.header"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car4.header"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car5.header")
					};

					String[] expectedProvTexts = {
							TestBase.contentMessages.getProperty("prov.general.premium.home.car1.text"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car2.text"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car3.text"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car4.text"),
							TestBase.contentMessages.getProperty("prov.general.premium.home.car5.text")
					};
					homePageCarouselTextValidation(expectedProvHeaders, expectedProvTexts);
					break;
				} else if (testConfig.getRunTimeProperty("portalAccess").equalsIgnoreCase("Standard") &&
						credentials.equalsIgnoreCase("PROV_Gen") &&
						testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("AO")) {
					String[] expectedProvHeaders = {
							TestBase.contentMessages.getProperty("prov.general.standard.home.car1.header"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car2.header"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car3.header"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car4.header"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car5.header")
					};

					String[] expectedProvTexts = {
							TestBase.contentMessages.getProperty("prov.general.standard.home.car1.text"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car2.text"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car3.text"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car4.text"),
							TestBase.contentMessages.getProperty("prov.general.standard.home.car5.text")
					};
					homePageCarouselTextValidation(expectedProvHeaders, expectedProvTexts);
					break;
				} else if (testConfig.getRunTimeProperty("portalAccess").equalsIgnoreCase("Premium") &&
						credentials.equalsIgnoreCase("PROV_Admin") &&
						testConfig.getRunTimeProperty("tinType").equalsIgnoreCase("VO")) {
					String[] expectedProvHeaders = {
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car1.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car2.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car3.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car4.header"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car5.header")
					};

					String[] expectedProvTexts = {
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car1.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car2.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car3.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car4.text"),
							TestBase.contentMessages.getProperty("prov.admin.premium.vo.home.car5.text")
					};
					homePageCarouselTextValidation(expectedProvHeaders, expectedProvTexts);
					break;
				} else {
					Log.Comment("Search criteria not met");
				}
		}
	}

	private void homePageCarouselTextValidation(String[] expectedHeaders, String[] expectedTexts) {
		int j=0;
		for(WebElement img : imageTiles)
		{
			Element.waitTillTextAppears(img, expectedHeaders[j], testConfig);
			String actualText = img.getText().trim() +
					img.getText().trim();
			Helper.compareEquals(testConfig, "Home Car Text", expectedTexts[j++], actualText);
		}  

		for(WebElement vid : videoTiles)
		{
			Element.waitTillTextAppears(vid, expectedHeaders[j], testConfig);
			String actualText = vid.getText().trim() +
					vid.getText().trim();
			Helper.compareEquals(testConfig, "Home Car Text", expectedTexts[j++], actualText);
		}
	}
	
	public void verifyPartnersLink()
	{
		Element.verifyElementPresent(resourcesPartnerLink, "Partner Link");
		Element.click(resourcesPartnerLink, "Partner Link");
		Helper.compareEquals(testConfig, "Partner Link windows", 1, Browser.getNoOfWindowHandles(testConfig));
	}
	
	public void verifyDocumentVaultLink()
	{
		Element.verifyElementPresent(resourcesDocVault, "Document Vault");
		String parentwindowhandle=testConfig.driver.getWindowHandle();
		Element.click(resourcesDocVault, "Document Vault");
		Browser.switchToNewWindow(testConfig,"document-vault");
		Helper.compareEquals(testConfig, "Document Vault windows", 2, Browser.getNoOfWindowHandles(testConfig));
		Browser.closeBrowser(testConfig);
		Browser.switchToParentWindow( testConfig,  parentwindowhandle);
	}

	
	public void verifyStandardTinAssociation(String userType) throws IOException {
		String id=testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+System.getProperty("env"));
		testConfig.putRunTimeProperty("id",id);
		int sqlTin=23;
		ArrayList<String> tins = new ArrayList<>();
		HashMap<Integer, HashMap<String, String>> tinsDb = DataBase.executeSelectQueryALL(testConfig, sqlTin); //DataBase.executeSelectQuery(testConfig, sqlTin, 1);
	
		DataBase.executeDeleteQuery(testConfig, QUERY.DELETE_ALL_TINS_FOR_USER);
		for (Integer tmp : tinsDb.keySet()) {
			tins.add(tinsDb.get(tmp).get("PROV_TIN_NBR"));
			testConfig.putRunTimeProperty("tin", tins.get(tmp-1).toString());
			DataBase.executeInsertQuery(testConfig, QUERY.INSERT_ALL_STD_TRIAL_TINS_FOR_USER);
		}
		
	}
	public void verifyBringMorePowerPage() {
		Element.expectedWait(bringMorePowerPopUp, testConfig, "Bring more power to your practice pop-up", "Bring more power to your practice pop-up");	
	}
	public void clickNoThanksOnBringMorePowerPage() {
		verifyBringMorePowerPage();
		Element.click(btnNoThanks, "No, Thanks button");
		Element.verifyElementPresent(tabMenu, "Home Page Tab Menu");
	}
	public void clickAcceptOnBringMorePowerPage() {
		verifyBringMorePowerPage();
		Element.click(btnIAccept, "I Accept, Let's get started button");
		Element.verifyElementPresent(tabMenu, "Home Page Tab Menu");
	}
	public void verifyDbOnAcceptingPremium() {
		int sql=1349;
		Map AllTins = DataBase.executeSelectQuery(testConfig,sql, 1);
		String nbrOfTinsAssociated=AllTins.get("ALL_ASSOCIATED_TINS").toString();
		
		sql=1350;
		Map premiumTins = DataBase.executeSelectQuery(testConfig,sql, 1);
		String nbrOfPaidTins=premiumTins.get("PAID_TINS_ROW_COUNT").toString();
		
		Helper.compareEquals(testConfig, "All associated Standard TINS should become Paid", nbrOfTinsAssociated, nbrOfPaidTins);
	}
	public void verifyHomePage() {
		Element.verifyElementPresent(tabMenu, "Home Page Tab Menu");
	}
	public void clickLogoutUPA() {
		Element.clickByJS(testConfig, lnkLogout, "Logout");
		Element.waitTillURlLoads(testConfig, "https://www.optumbank.com/");
	
	}
	public void verifyCapitationReportLinkUnderResources() {
		   String parentwindowhandle=testConfig.driver.getWindowHandle();
		   Element.click(lnkResourcesCapitationReport, "capitation report");
		   Browser.switchToNewWindow(testConfig);
		   String expectePrivacydURL = "https://www.uhcprovider.com/en/resource-library/link-provider-self-service.html";
		   Browser.verifyURL(testConfig, expectePrivacydURL);
		   Browser.switchToParentWindow(testConfig,  parentwindowhandle);
	}
	public PaymentDataFilesUPA clickPaymentDataFilesTab() 
	{
		Browser.wait(testConfig, 1);
		Element.clickByJS(testConfig,paymentDataFilesTab, "Payment Data Files tab");
		return new PaymentDataFilesUPA (testConfig);
	}
	
	
	/**
	 * Author: Mohammad Khalid. 
	 * Clicks on the Cancellation Form in Resources Drop down**/
	
	public void verifyCancellationFormLinkUnderResources()
	{
		Element.verifyElementPresent(CancellationForm, "Cancellation Form");
		Element.click(CancellationForm, "TnC");
		Browser.switchToNewWindow(testConfig);
		Helper.compareEquals(testConfig, "Tnc windows", 2, Browser.getNoOfWindowHandles(testConfig));
		Helper.compareContains(testConfig, "The Cancellation PDF URL", "pdf", testConfig.getDriver().getCurrentUrl());
		Browser.verifyURL(testConfig, "pdf");
	}
	
	public void verifyCancellationFormLinkPDFContentPostLogin() throws IOException
	{
		String expectedPDFContent=null;
		String actualPDFContent=null;
		
		String exPDFPath = System.getProperty("user.dir") + "\\PDFDocuments\\CancellationForm.pdf";
		
		actualPDFContent = Helper.readPDF(TestBase.driver.getCurrentUrl());
		expectedPDFContent = Helper.readPDF(exPDFPath);
		
		Helper.compareEquals(testConfig, "The Cancellation Form PDF", expectedPDFContent, actualPDFContent);
	}
}
