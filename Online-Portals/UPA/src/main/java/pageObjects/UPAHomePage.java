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
	
	@FindBy(xpath = "//a[@id='tabBillingService']") 
	WebElement lnkBsInfo;
	
	@FindBy(xpath = "//a[@id='tabOptumPay']") 
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
	
	@FindBy(xpath = "//b[contains(text(),'Partner Links')]")
	WebElement  resourcesPartnerLink;
	
	@FindBy(linkText="Cancel Form")
	WebElement  resourcesCancelForm;
	
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

	
	@FindBy(xpath = "//select[@id='taxIndNbrId']") 
	WebElement prvdrTIN;
	
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
			Helper.getPayerSchema(testConfig,searchCriteria);	
		String tin = getTin(userType,searchCriteria,tinType,portalAccess); 
		//String tin = "200304197"; 
		System.setProperty("tin", tin);
		switch (userType)
			{
			   case "PROV": 
				 WebElement homeTab = Element.findElement(testConfig, "id", "tabHome");
				 List<String> tinList = Element.getAllOptionsInSelect(testConfig, prvdrTIN);
	
				 String Enrolledtin = tin + " - Enrolled";
				 if ((!tinList.contains(Enrolledtin))) 
				 {
					Element.click(homeTab, "home Tab");
					Browser.waitForLoad(TestBase.driver);
					Browser.wait(testConfig, 2);
					Element.expectedWait(prvdrTIN, testConfig, "Tin dropdown", "Tin dropdown");
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

	public void verifyHomePageCarouselText(String userType) {
		switch (userType){
			case "BS_Admin":

				String[] expectedBSHeaders = {
						"Missing the Optum Pay features you need?",
						"Debit authorization required.",
						"Is your client's practice tax exempt?",
						"Missing the full functionality of Optum Pay?",
						"What is Optum Pay?"
				};

				String[] expectedBSTexts = {
						"Missing the Optum Pay features you need?The upgraded Optum Pay portal gives you more ways to manage claims payment and remittance. Talk to your provider client about activating Optum Pay.",
						"Debit authorization required.Your ACH clients Optum Pay fees will be deducted from their TIN level bank account on a monthly basis, they will need to provide Optum Bank Company ID (1243848776) and Company Name (Optum Pay) to their bank to authorize a debit from their account.",
						"Is your client's practice tax exempt?Send their tax exemption certificate to optumpay_taxexempt@optum.com",
						"Missing the full functionality of Optum Pay?New features include: workflow management settings, claim counts and expanded access to historical claim payment data and search history. Talk to your provider client about activating Optum Pay.",
						"What is Optum Pay?Watch this short video to learn about the new features and functionality that are included with an Optum Pay activation."
				};
				homePageCarouselTextValidation(expectedBSHeaders, expectedBSTexts);
				break;
			case "PAY_Admin":

				String[] expectedPayerHeaders = {
						"Why Optum Pay?",
						"Less paper. Better tools.",
						"Flexibility with Optum Pay.",
						"Getting questions about Optum Pay from providers?",
						"What is Optum Pay?"
				};

				String[] expectedPayerTexts = {
						"Why Optum Pay?It makes managing claims payment and remittance processes easier and more efficient.",
						"Less paper. Better tools.Optum Pay is designed to increase practice efficiency.",
						"Flexibility with Optum Pay.Providers can select from two payment options - ACH and virtual card payment. If ACH is selected, a basic level of the Optum Pay portal is offered at no charge.",
						"Getting questions about Optum Pay from providers?Our call center can help. Have them call 1�877�620�6194 or email us at optumpay@optum.com.",
						"What is Optum Pay?Watch this short video to learn about the new features and functionality that are included with an Optum Pay activation."
				};
				homePageCarouselTextValidation(expectedPayerHeaders, expectedPayerTexts);
				break;
		}
	}

	private void homePageCarouselTextValidation(String[] expectedHeaders, String[] expectedTexts) {

		WebElement windowSlides = Element.findElement(testConfig, "xpath", "//*[@class=\"slides-window\"]");
		List<WebElement> imageTiles = windowSlides.findElements(By.xpath("//*[@class=\"slide image\"]"));
		List<WebElement> videoTiles = windowSlides.findElements(By.xpath("//*[@class=\"slide video\"]"));


		int j=0;
		for(int i=0; i<imageTiles.size(); i++){
			Element.waitTillTextAppears(imageTiles.get(i).findElement(By.tagName("h2")), expectedHeaders[j], testConfig);
			String actualText = imageTiles.get(i).findElement(By.tagName("h2")).getText().trim()+
					imageTiles.get(i).findElement(By.tagName("p")).getText().trim();
			Assert.assertTrue(actualText.equals(expectedTexts[j]), "Text Validation failed");
			Log.Comment("Text validated successfully: \n"+actualText+"\n");
			j++;
		}
		for(int i=0; i<videoTiles.size(); i++){
			Element.waitTillTextAppears(videoTiles.get(i).findElement(By.tagName("h2")), expectedHeaders[j], testConfig);
			String actualText = videoTiles.get(i).findElement(By.tagName("h2")).getText().trim()+
					videoTiles.get(i).findElement(By.tagName("p")).getText().trim();
			Assert.assertTrue(actualText.equals(expectedTexts[j]), "Text Validation failed");
			Log.Comment("Text validated successfully: \n"+actualText+"\n");
			j++;
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
	public void verifyCapitationReportLinkUnderResources() {
		   String parentwindowhandle=testConfig.driver.getWindowHandle();
		   Element.click(lnkResourcesCapitationReport, "capitation report");
		   Browser.switchToNewWindow(testConfig);
		   String expectePrivacydURL = "https://www.uhcprovider.com/en/resource-library/link-provider-self-service.html";
		   Browser.verifyURL(testConfig, expectePrivacydURL);
		   Browser.switchToParentWindow(testConfig,  parentwindowhandle);
		
	}
}

