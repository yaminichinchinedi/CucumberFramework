package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.server.session.DatabaseAdaptor;

public class HomePage extends LoginUPA {

	private TestBase testConfig;

	@FindBy(xpath = "//span[contains(text(),'Welcome Screen')]")
	WebElement txtWelcomeScreen;

	@FindBy(xpath = ".//*[@id='tabmenu']/li[1]")
	WebElement CurrentNewsSection;

	@FindBy(xpath = ".//*[@id='tabmenu']/li[2]")
	WebElement ArchiveSection;
	
	@FindBy(id="tabHome")
	WebElement homeTab;

	@FindBy(id = "taxIndNbrId")
	WebElement drpDwnTin;
	
	@FindBy(linkText="View Payments")
	WebElement viewPaymentsTab;

	@FindBy(id = "tabSearch")
	WebElement searchRemittanceTab;

	@FindBy(id = "tabDataFiles")
	WebElement paymentDataFilesTab;

	@FindBy(linkText = "Maintain Enrollment")
	WebElement maintainEnrlTab;
	
	@FindBy(linkText="Manage Users")
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

	public HomePage(TestBase testConfig) {
		super(testConfig);
		this.testConfig = testConfig;
		PageFactory.initElements(TestBase.driver, this);
	}
	
	//Default constructor
	public HomePage() {}
	
	
    /**
     * Verifies UI
     * of Welcome Screen
     */
	
	public HomePage verifyWelcomeScreen() throws IOException {
	
		int sqlRowNo = 7;
		
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

	/**
	 * Verifies News section
	 * contains archive and current section
	 * and the one clicked 
	 * becomes active section
	 */
	
	public void verifyNewsSectionIsDisplayed() {
		
		Element.expectedWait(txtNewsAndInfoHeading, testConfig,"News and Heading section", "News and Heading section");
		Element.verifyElementPresent(txtNewsAndInfoHeading,"News and Information Heading Section");
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

	public void VerifyResourcesLinks() 
	{
		String expectedURLFAQs = "forms/OHFS_EPS_FAQs_040813.pdf";
		String expectedURLHelp = "/forms/Help.pdf";
		String expectedUserGuideURL = "/userguide/Optum_EPS_UserGuide_Provider_022014.pdf";
		String expectedContactUsURL = "/contactExante.do";

		// Hover mouse over Resources link and verify all elements are present
		
		Element.mouseHoverByJS(testConfig, lnkResources, "Resources");
		Element.verifyElementPresent(FAQs, "FAQs");
		Element.verifyElementPresent(VCPFAQs, "VCP FAQs");
		Element.verifyElementPresent(help, "Help");
		Element.verifyElementPresent(userGuide, "User Guide");
		Element.verifyElementPresent(contactUs, "Contact Us");
		

		Element.click(FAQs, "FAQs");
		String oldWindow = Browser.switchToNewWindow(testConfig,expectedURLFAQs);
		Browser.waitForLoad(testConfig.driver);
		Browser.verifyURL(testConfig, expectedURLFAQs);
		Browser.switchToParentWindow(testConfig, oldWindow);

		Element.mouseHoverByJS(testConfig, lnkResources, "Resources");
		Element.click(help, "Help");
		Browser.switchToNewWindow(testConfig,expectedURLHelp);
		Browser.verifyURL(testConfig, expectedURLHelp);

		Browser.switchToParentWindow(testConfig, oldWindow);
		Element.mouseHoverByJS(testConfig, lnkResources, "Resources");
		Element.click(userGuide, "User Guide");
		Browser.switchToNewWindow(testConfig,expectedUserGuideURL);
		Browser.verifyURL(testConfig, expectedUserGuideURL);

		Browser.switchToParentWindow(testConfig, oldWindow);
		Element.mouseHoverByJS(testConfig, lnkResources, "Resources");
		Element.click(contactUs, "Contact Us");
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
		
		Log.Comment("List of tins from UI is :" + '\n' + newListFromUI);
		Log.Comment("List of tins from DB is :" + '\n' + tinsListFromDB);
		for (String tinNo : tinsListFromDB) 
		{
		  if (newListFromUI.contains(tinNo))
		      Log.Pass(tinNo + " :" + " " + "matches in both UI and DB");
			
			else {
				Log.Fail(tinNo + " :" + " " + "not present in DB");
				break;
			}
		}
	}

	public ViewPayments clickViewPaymentsTab() 
	{
		Browser.wait(testConfig,2);
		Element.expectedWait(viewPaymentsTab, testConfig, "View Payments Tab", "View Payments Tab");
		Element.clickByJS(testConfig,viewPaymentsTab, "View Payments Tab");
		return new ViewPayments(testConfig);
	}
	
	public MaintainEnrollment clickMaintainEnrollmentTab() 
	{
		Element.expectedWait(maintainEnrlTab, testConfig, "Maintain Enrollment Tab","Maintain Enrollment Tab");
		Element.clickByJS(testConfig,maintainEnrlTab, "Maintain Enrollment Tab");
		return new MaintainEnrollment(testConfig);
	}

	public ManageUsers clickManageUsersTab() 
	{
		Element.expectedWait(manageUsersTab, testConfig, "Manage users tab","Manage Users tab");
		Element.clickByJS(testConfig,manageUsersTab, "Manage Users Tab");
		return new ManageUsers(testConfig);

	}
	
	
	public MyProfile clickMyProfileTab() 
	{
		Element.expectedWait(myProfileTab, testConfig, "My Profile tab","My Profile tab");
		Element.clickByJS(testConfig,myProfileTab, "My Profile Tab");
		return new MyProfile(testConfig);
	}

	public LoginUPA logOutFromUPA() {
		Element.clickByJS(testConfig,lnkLogOut, "Log out");
		return new LoginUPA(testConfig);
	}
	
	public SearchRemittanceSearchCriteria clickSearchRemittanceTab()
	{
	Element.expectedWait(searchRemittanceTab, testConfig, "Search Remittance Tab", "Search Remittance Tab");
	Element.clickByJS(testConfig,searchRemittanceTab, "Search Remittance Tab");
	return new SearchRemittanceSearchCriteria(testConfig);
	}

	public HomePage clickHomeTab()
	{
		Element.click(homeTab, "Home Tab");
		return this;
	}

}