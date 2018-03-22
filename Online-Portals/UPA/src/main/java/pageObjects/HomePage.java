package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sqlj.runtime.profile.ref.IterConvertProfile.IterConvertStatement;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;

public class HomePage extends LoginUPA {

	private WebDriver driver;
	private TestBase testConfig;

	@FindBy(xpath = "//span[contains(text(),'Welcome Screen')]")
	WebElement txtWelcomeScreen;

	@FindBy(xpath = ".//*[@id='tabmenu']/li[1]")
	WebElement CurrentNewsSection;

	@FindBy(xpath = ".//*[@id='tabmenu']/li[2]")
	WebElement ArchiveSection;

	@FindBy(id = "taxIndNbrId")
	WebElement drpDwnTin;

	@FindBy(id = "tabPayer")
	WebElement viewPaymentsTab;

	@FindBy(id = "tabSearch")
	WebElement searchRemittanceTab;

	@FindBy(id = "tabDataFiles")
	WebElement paymentDataFilesTab;

	@FindBy(id = "tabMntnEnrl")
	WebElement maintainEnrlTab;

//	@FindBy(xpath = ".//*[@id='tabManageusers']")
//	WebElement ManageUsersTab;
	
	@FindBy(id="tabManageusers")
	WebElement manageUsersTab;
	
	@FindBy(id="tabMyprofile")
	WebElement myProfileTab;


	@FindBy(id = "tabproviderBillingService")
	WebElement BillingInfoTab;

	@FindBy(xpath = "//td[contains(text(),'News and Information')]")
	WebElement txtNewsAndInfoHeading;

	@FindBy(linkText = "Resources")
	WebElement lnkResources;

	@FindBy(id = "dropmenudiv")
	WebElement divResources;

	@FindBy(linkText = "FAQs")
	WebElement FAQs;

	@FindBy(linkText = "VCP FAQs")
	WebElement VCPFAQs;

	@FindBy(linkText = "Help")
	WebElement help;

	@FindBy(linkText = "User Guide")
	WebElement userGuide;

	@FindBy(linkText = "Contact Us")
	WebElement contactUs;

	@FindBy(linkText = "Logout")
	WebElement lnkLogOut;

	@FindBy(css = ".hdrLogoImg>a>img")
	WebElement optumLogo;

	@FindBy(css = "td.runtextbold")
	WebElement txtEPSFreedom;

	@FindBy(id = "kunal")
	WebElement txtWelcomeUserName;

	@FindBy(xpath = "//td[contains(text(),'Eliminate paper checks and receive electronic claims payments.')]")
	WebElement txtEliminatePaper;

	@FindBy(xpath = "//td[contains(text(),'Receive electronic remittance advices.')]")
	WebElement txtReceiveElectronics;

	@FindBy(xpath = "//td[contains(text(),'Reconcile your claims quickly and more efficiently.')]")
	WebElement txtReconcile;

	@FindBy(xpath = "//td[contains(text(),'Create and download bundled daily 835 files, Payer PRA, and ePRAs in one easily retrievable zip file.')]")
	WebElement txtCreateDownload;

	private paymentSummary paymentSummaryPage;

	public HomePage(TestBase testConfig) {
		super(testConfig);
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expected = "/validateCustomerLogin.do?unencripted=yes";
		Element.expectedWait(txtWelcomeScreen, testConfig,"Welcome Screen Text is present on home page"," Welcome Screen Text");

		// Element.verifyElementPresent(txtWelcomeScreen,"Welcome Screen Text is present on home page");

	}
	
	//Default constructor
	public HomePage() 
	{
		//PageFactory.initElements(testConfig.driver, this);
	}

	public HomePage verifyWelcomeScreen() throws IOException {
		int sqlRowNo = 7;
		// Verifies count of records displayed in view payments tab from DB
		Map portalUserTable = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		Helper.compareEquals(testConfig, "Welcome <FN><LN>", "Welcome," + " "+ portalUserTable.get("FST_NM").toString() + " "+ portalUserTable.get("LST_NM").toString(),txtWelcomeUserName.getText());

		Element.verifyElementPresent(optumLogo, "Optum Logo");
		Element.verifyElementPresent(txtEliminatePaper, "1st heading :" + " "+ txtEliminatePaper.getText());
		Element.verifyElementPresent(txtReceiveElectronics, "2nd heading :"+ " " + txtReceiveElectronics.getText());
		Element.verifyElementPresent(txtReconcile, "3rd heading:" + " "+ txtReconcile.getText());
		Element.verifyElementPresent(txtCreateDownload, "4th heading :" + " "+ txtCreateDownload.getText());
		Element.verifyElementPresent(txtEPSFreedom, "Main Heading :" + " "+ txtEPSFreedom.getText());
		return this;
	}

	public void verifyNewsSectionIsDisplayed() {
		Browser.wait(testConfig, 5);
		Element.expectedWait(txtNewsAndInfoHeading, testConfig,"News and Heading section", "News and Heading section");
		Element.verifyElementPresent(txtNewsAndInfoHeading,"News and Information Heading Section");
		Browser.wait(testConfig, 2);
		Element.verifyElementPresent(CurrentNewsSection,"Current News Section is displayed on home page");
		Element.verifyElementPresent(ArchiveSection,"Archive Section is displayed on home page");

		Helper.compareEquals(testConfig, "class", "inactiveclass",ArchiveSection.getAttribute("class"));

		Helper.compareEquals(testConfig, "class", "activeclass",CurrentNewsSection.getAttribute("class"));

		Element.click(ArchiveSection, "Click Archive Section tab");
		Browser.wait(testConfig, 2);
		Helper.compareEquals(testConfig, "class", "activeclass",ArchiveSection.getAttribute("class"));
		Browser.browserRefresh(testConfig);
		Browser.wait(testConfig, 2);
		Element.click(CurrentNewsSection, "Click Archive Section tab");
	}

	public void VerifyAllTabsAreDisplayedAfterSelectingTin() {
		// Select Tin from dropdown
		selectTin();

		verifyNewsSectionIsDisplayed();

		// Verify all tabs are displayed after tin is selected

		Element.verifyElementPresent(viewPaymentsTab, "Payer tab");
		Element.verifyElementPresent(searchRemittanceTab,"Search Remittance tab");
		Element.verifyElementPresent(paymentDataFilesTab,"Payment Data Files Tab");
		Element.verifyElementPresent(maintainEnrlTab, "Maintain Enrollment");
		Element.verifyElementPresent(manageUsersTab, "Manage Users tab");
		Element.verifyElementPresent(myProfileTab, "My Profile tab");
		Element.verifyElementPresent(BillingInfoTab, "Billing Info tab");
		Element.verifyElementPresent(lnkResources, "Resources link");
	}

	public void VerifyResourcesLinks() {
		String expectedURLFAQs = "forms/OHFS_EPS_FAQs_040813.pdf";
		String expectedURLHelp = "/forms/Help.pdf";
		String expectedUserGuideURL = "/userguide/Optum_EPS_UserGuide_Provider_022014.pdf";
		String expectedContactUsURL = "/contactExante.do";

		// Hover mouse over Resources link and verify all elements are present
		Element.onMouseHover(testConfig, lnkResources, "Resources");
		Element.verifyElementPresent(FAQs, "FAQs");
		Element.verifyElementPresent(VCPFAQs, "VCP FAQs");
		Element.verifyElementPresent(help, "Help");
		Element.verifyElementPresent(userGuide, "User Guide");
		Element.verifyElementPresent(contactUs, "Contact Us");
		Element.verifyElementPresent(lnkLogOut, "Log out");

		Element.click(FAQs, "FAQs");
		String oldWindow = Browser.switchToNewWindow(testConfig,expectedURLFAQs);
		//Browser.wait(testConfig, 3);
		//Browser.verifyURL(testConfig, expectedURLFAQs);
		Browser.switchToParentWindow(testConfig, oldWindow);
		//Browser.wait(testConfig, 3);

		Element.onMouseHover(testConfig, lnkResources, "Resources");
		Element.click(help, "Help");
		Browser.switchToNewWindow(testConfig,expectedURLHelp);
		//Browser.wait(testConfig, 3);
		//Browser.verifyURL(testConfig, expectedURLHelp);

		Browser.switchToParentWindow(testConfig, oldWindow);
		//Browser.wait(testConfig, 3);
		Element.onMouseHover(testConfig, lnkResources, "Resources");
		Element.click(userGuide, "User Guide");
		Browser.switchToNewWindow(testConfig,expectedUserGuideURL);
		//Browser.wait(testConfig, 3);
		//Browser.verifyURL(testConfig, expectedUserGuideURL);

		Browser.switchToParentWindow(testConfig, oldWindow);
		//Browser.wait(testConfig, 3);
		Element.onMouseHover(testConfig, lnkResources, "Resources");
		Element.click(contactUs, "Contact Us");
		//Browser.wait(testConfig, 3);
		Browser.verifyURL(testConfig, expectedContactUsURL);

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
		tinsListFromUI = Element.getAllOptionsInSelect(testConfig, drpDwnTin);
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

	public HomePage selectTin() 
	{
		Browser.wait(testConfig, 3);
		Element.expectedWait(drpDwnTin, testConfig, "Tin dropdown",  "Tin dropdown");
		
		Element.selectByIndex(drpDwnTin, 1, "Select Tin in dropdown");
		Browser.wait(testConfig, 5);
		String tinNumber = Element.getFirstSelectedOption(testConfig,drpDwnTin, "text");
		LogTemp.Comment("Selected tin number is" + tinNumber);
		String tin[]=tinNumber.split("-");
		testConfig.putRunTimeProperty("tin", tin[0]);
		return new HomePage(testConfig);
	}

	public paymentSummary clickViewPaymentsTab() 
	{

		testConfig.driver.findElement(By.linkText("View Payments"));

		Element.click(viewPaymentsTab, "View Payments Tab");
		return new paymentSummary(testConfig);

	}
	
	public MaintainEnrollment clickMaintainEnrollmentTab() 
	{

		Element.click(maintainEnrlTab, "Maintain Enrollment Tab");
		return new MaintainEnrollment(testConfig);

	}

	public ManageUsers clickManageUsersTab() 
	{
		Element.expectedWait(manageUsersTab, testConfig, "Manage users tab","Manage Users tab");
		testConfig.driver.findElement(By.linkText("Manage Users"));
		Element.click(manageUsersTab, "Manage Users Tab");
		return new ManageUsers(testConfig);

	}
	
	public MyProfile clickMyProfileTab() 
	{
		Element.click(myProfileTab, "My Profile Tab");
		return new MyProfile(testConfig);

	}

	public LoginUPA logOutFromUPA() {
		Element.click(lnkLogOut, "Log out");
		return new LoginUPA(testConfig);
	}

}