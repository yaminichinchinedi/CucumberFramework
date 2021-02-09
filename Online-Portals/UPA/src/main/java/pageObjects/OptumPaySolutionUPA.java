package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class OptumPaySolutionUPA {

	@FindBy(xpath = "//div[contains(text(),'Provider Name')]")
	WebElement txtProvNameHeader;
	@FindBy(xpath = "//div[contains(text(),'Plan Type')]")
	WebElement txtPlanTypeHeader;
	@FindBy(xpath = "//div[contains(text(),'Fees')]")
	WebElement txtFeesHeader;
	@FindBy(xpath = "//div[contains(text(),'Manage Subscriptions')]")
	WebElement txtManageSubHeader;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[1]/div/div[2]")
	WebElement txtProvNameInfo;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[2]//div[2]")
	WebElement txtPlanTypeInfoVO;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[3]//div[2]/b")
	WebElement txtFeesInfoVO;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[4]//div[2]/b")
	WebElement txtManageSubInfo;
	@FindBy(xpath = "//form[@id=\"showOptumPayForm\"]/div//h1")
	WebElement txtOnStandardPage;
	@FindBy(xpath = "//div[@id=\"videoID1\"]//div")
	WebElement video;
	@FindBy(linkText = "Logout")
	WebElement lnkLogout;
	@FindBy(linkText = "Home")
	WebElement lnkHome;
	@FindBy(xpath = "//div[@id=\"optum-pay-tabs\"]//div[1]//p[2]")
	WebElement pageText;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]")
	WebElement txtFeesInfoAO;
	@FindBy(linkText = "Cancel My Subscription")
	WebElement lnkCancelSubscription;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]")
	WebElement txtActivationAdminName;

	@FindBy(xpath = "//div[@id=\"cancelationModal\"]/h2")
	WebElement duringTrialCancelPopUp;
	@FindBy(xpath = "//div[@id=\"cancelationPostTrialModal\"]/h2")
	WebElement postTrialCancelPopUp;


	// Added by Mohammad Khalid

	@FindBy(xpath = "(//div[@class='topMessaggeDiv']/h2)[1]")
	WebElement topHeader1_ImpRem_Premium;

	@FindBy(xpath = "(//div[@class='topMessaggeDiv']/h2)[2]")
	WebElement topHeader2_IsYourProv_Premium;

	@FindBy(xpath = "(//div[@class='topMessaggeDiv']/p)[2]")
	WebElement topMsg1_YouWill_Premium;

	@FindBy(xpath = "(//div[@class='topMessaggeDiv']/p)[3]")
	WebElement topMsg2_SendTax_Premium;
	@FindBy(xpath = "//div[@id='cancelationModal']//h2") 
	WebElement duringTrialCancelPopUpHeading;
	@FindBy(xpath = "//div[@id='cancelationPostTrialModal']//h2") 
	WebElement postTrialCancelPopUpHeading;
	@FindBy(xpath = "//div[2]/div[1]/button[1]/span[1]") 
	WebElement btnCancelOnPopUp;
	@FindBy(xpath="//*[@id='reason_selector']//option")
	List<WebElement> listTrialCancellationReason;
	@FindBy(id="cancelationPostTrialModal")
	WebElement popUpCancellationPostTrial;
	@FindBy(xpath="//div[@id='cancelationPostTrialModal']//p")
	WebElement postTrialCancelPopUpText;
	@FindBy(id="cancelationModal")
	WebElement popUpCancellationTrial;
	@FindBy(id="reason_selector")
	WebElement popUpCancellationReasonSelector;
	@FindBy(xpath = "//div[@id='cancelationModal']//p[1]") 
	WebElement duringTrialCancelPopUpBody1;
	@FindBy(xpath = "//div[@id='cancelationModal']//p[2]") 
	WebElement duringTrialCancelPopUpBody3;
	@FindBy(xpath="//div[@id='cancelationModal']//ul//li")
	List<WebElement> duringTrialCancelPopUpBody2;
	@FindBy(xpath="//html//button[2]")
	WebElement btnCancellationSubmitTrial;
	@FindBy(xpath="//p[@id='errorswarning']")
	WebElement errorCancelWithoutReason;
	@FindBy(xpath="//*[@id='reason_selector']//option[8]")
	WebElement otherOptionTrialCancellationReason;
	
	
	@FindBy(xpath = "(//div[@class='bottomMessageDiv']/p)[2]")
	WebElement footer1_IfaProv_Premium;
	
	@FindBy(xpath = "(//div[@class='bottomMessageDiv']/p)[3]")
	WebElement footer2_Cancellation_Premium;
	
	@FindBy(xpath = "//h1[contains(text(),'Optum Pay brings more power to your practice')]")
	WebElement msg1_Standard;
	
	@FindBy(xpath = "//h1[contains(text(),'Optum Pay brings more power to your practice')]/../p")
	WebElement msg2_Standard;
	
	
	

	private TestBase testConfig;

	public OptumPaySolutionUPA(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	
	//Added by Mohammad Khalid
	String headerTop1_Premium ="Important reminder:";
	String headerTop2_Premium ="Is your provider organization tax exempt?";
	String pageTextTop1_Premium ="You will receive an email notification when the monthly invoice is ready. Fees are debited within 5 days and are deducted from the provider's TIN-level banking account. Please contact the financial institution and ask that the following ACH company ID and name be added to your bank account: Company ID: 1243848776 and Company Name: Optum Pay. Not adding Optum Pay as an authorized agent may result in ACH return fees and/or termination of service.";
	String pageTextTop2_Premium ="Send the tax exempt certificate to optumpay_taxexempt@optum.com to ensure correct billing.";
	
	String footer1_Premium = "If a provider cancels the full functionality of Optum Pay, their access will be limited to 2 users. However, if they were enrolled in Optum Pay prior to the upgrade (January 2021), then active portal users will retain access. Other features not available without a paid activation include search functionality, access to more than 30 days of historical data, multiple remittance options, and data bundling.";
	String footer2_Premium = "Cancellation may take up to 7 days to process during which time the provider will be responsible for any charges to their account.";
	
	String Message1_Standard = "Optum Pay brings more power to your practice";
	String Message2_Standard = "We are improving our service to help simplify your workflow and take efficiency to the next level. For a low fee*, we now offer additional tools and resources to give you more of what you're looking for.";
	

	public void verifyHeaders() {
		Helper.compareEquals(testConfig, "1st Tile Header", "Provider Name", txtProvNameHeader.getText().trim());
		Helper.compareEquals(testConfig, "2nd Tile Header", "Plan Type", txtPlanTypeHeader.getText().trim());
		Helper.compareEquals(testConfig, "3rd Tile Header", "Fees", txtFeesHeader.getText().trim());
		Helper.compareEquals(testConfig, "4th Tile Header", "Manage Subscriptions",
				txtManageSubHeader.getText().trim());
	}

	public void verifyPlanTypeInfoForVCP() {
		verifyHeaders();
		int sqlRowNo = 1;
		testConfig.getRunTimeProperty("tin");
		Map data = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Organization Name on 1st tile DB and UI",
				data.get("ORG_NM").toString().trim(), txtProvNameInfo.getText().trim());
		Helper.compareEquals(testConfig, "Plan Type on 2nd tile", "VCP Only", txtPlanTypeInfoVO.getText().trim());
		Helper.compareEquals(testConfig, "Fees on 3rd tile", "N/A", txtFeesInfoVO.getText().trim());
		Helper.compareEquals(testConfig, "Manage Subscriptions on 4th tile", "N/A", txtManageSubInfo.getText().trim());
		Element.click(testConfig, lnkHome, "Home", 3);
		Element.click(testConfig, lnkLogout, "Logout", 3);
	}

	public void verifySolutionsTabForStandard(String trialStatus, String portalAccess) {
		Helper.compareEquals(testConfig, "Optum Pay brings more power to your practice text on Standard view",
				"Optum Pay brings more power to your practice", txtOnStandardPage.getText().trim());
		Element.verifyElementPresent(video, "Video");
		Element.click(testConfig, lnkHome, "Home", 3);
		Element.click(testConfig, lnkLogout, "Logout", 3);
	}

	

	
	
	//Added by Mohammad Khalid
	public void verifyPageText_Top_Premium()
	{
		Helper.compareEquals(testConfig, "Header-1 Premium", headerTop1_Premium, topHeader1_ImpRem_Premium.getText().trim());
		Helper.compareEquals(testConfig, "Header-2 Premium", headerTop1_Premium, topHeader2_IsYourProv_Premium.getText().trim());
		Helper.compareEquals(testConfig, "Top Page Text -1 Premium", pageTextTop1_Premium, topMsg1_YouWill_Premium.getText().trim());
		Helper.compareEquals(testConfig, "Top Page Text -2 Premium", pageTextTop2_Premium, topMsg2_SendTax_Premium.getText().trim());
	}
	
	
	public void verifyPageText_Footer_Premium()
	{
		Helper.compareEquals(testConfig, "Footer-1 Premium", footer1_Premium, topHeader1_ImpRem_Premium.getText().trim());
		Helper.compareEquals(testConfig, "Footer-2 Premium", footer2_Premium, topHeader2_IsYourProv_Premium.getText().trim());
	}
	
	
	public void verifyPageText_Message1_Standard()
	{
		Helper.compareEquals(testConfig, "Message 1 Standard", Message1_Standard, msg1_Standard.getText().trim());
	}
	

	
		public void verifySolutionsTabForPremium(String trialStatus,String portalAccess) throws Exception{
			if(trialStatus.equalsIgnoreCase("A")) {
				Browser.browserRefresh(testConfig);
				Browser.waitForPageLoad(testConfig);
				verifyHeaders();
				planTypeInfoForPremium();
				Helper.compareEquals(testConfig, "During Trial Cancel pop-up", "You are about to lose important functionality through Optum Pay.", duringTrialCancelPopUpHeading.getText().trim());
				Element.click(btnCancelOnPopUp, "Close pop-up 'X' button");
				Element.verifyElementPresent(pageText, "Page Text");
				Element.click(testConfig, lnkHome, "Home", 3);
				Element.click(testConfig, lnkLogout, "Logout", 3);
			}
			else if(trialStatus.equalsIgnoreCase("I")) {
				verifyHeaders();
				planTypeInfoForPremium();
				Helper.compareEquals(testConfig, "Post Trial Cancel pop-up", "Call to cancel", postTrialCancelPopUpHeading.getText().trim());
				Element.click(btnCancelOnPopUp, "Close pop-up 'X' button");
				Element.verifyElementPresent(pageText, "Page Text");
			}
		}
		public void planTypeInfoForPremium() throws Exception {
			String planTypeInfo= Element.findElement(testConfig, "xpath", "//div[@id=\"optum-pay-options\"]//div//div[2]//div[2]").getText();
			Element.verifyElementPresent(pageText, "Page Text");
			int sqlRowNo = 1;
		    testConfig.getRunTimeProperty("tin");
		    Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    Helper.compareEquals(testConfig, "Organization Name on 1st tile DB and UI", data.get("ORG_NM").toString().trim(),txtProvNameInfo.getText().trim());
			Helper.compareEquals(testConfig, "2nd Tile text- Optum Pay", "Optum Pay", planTypeInfo.substring(0, 9).trim());	
			Helper.compareEquals(testConfig, "2nd Tile text- Activation Admin", "Activation Admin:", planTypeInfo.substring(10, 28).trim());	
			Helper.compareEquals(testConfig, "2nd Tile text- Activation Date", "Activation Date:", planTypeInfo.substring(37, 53).trim());	
			sqlRowNo=1344;
			testConfig.getRunTimeProperty("statusOfStandardRecd");
			testConfig.getRunTimeProperty("$SelectedOrDefault");
			data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String activationDate= data.get("PRTL_PRDCT_SELECT_DTTM").toString().trim().substring(0, 10).trim();
			activationDate=Helper.changeDateFormat(activationDate, "yyyy-mm-dd", "mm/dd/yyyy");
			Helper.compareEquals(testConfig, "2nd Tile Info- Activation Date", activationDate, planTypeInfo.substring(54, 64).trim());
			Helper.compareEquals(testConfig, "Fees on 3rd tile", "0.5% of Payment", txtFeesInfoAO.getText().trim());
			Helper.compareEquals(testConfig, "Fees on 4th tile", "Free Trial End Date:", txtManageSubInfo.getText().trim());
			sqlRowNo=1341;
			data= DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String trialEndDateDB= data.get("PROC_DATA").toString().trim();
			trialEndDateDB=Helper.changeDateFormat(trialEndDateDB, "yyyy-mm-dd", "mm/dd/yyyy").trim();
			String trialEndDateUI= Element.findElement(testConfig, "xpath", "//div[@id=\"optum-pay-options\"]//div[4]//div[2]").getText().trim();
			System.out.println(trialEndDateUI.substring(21, 31));
			Helper.compareEquals(testConfig, "Fees on 4th tile Info", trialEndDateDB, trialEndDateUI.substring(21, 31).trim());
			Element.click(lnkCancelSubscription, "Cancel My Subscription Link");
		}
		public void verifyCancellationPopUp(String trialStatus) throws IOException {
			int sqlRowNo=1111,i=1,j=0;;
			HashMap<Integer, HashMap<String, String>> cancelReasonDB=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
			ArrayList<String> cancelReasonList=new ArrayList<String>(){{add("Not using the portal as much as I thought I would");add("I receive my data from a clearinghouse");add("I don't need the search tools");add("I don't need historical claim data");add("I don't need additional users, 2 is sufficient");add("The service is too costly for my practice");add("Other");}};
			ArrayList<String> popUpTextList=new ArrayList<String>(){{add("Unlimited number of users");add("The ability to search claims");add("Years of claims and remittance history maintained for easy access");add("Multiple remittance options (835, EPRA or PPRA)");}};
			
			if(trialStatus.equalsIgnoreCase("I"))
			{ 
				Element.click(lnkCancelSubscription, "Cancel My Subscription Link");
				Element.verifyElementPresent(popUpCancellationPostTrial, "Post Trail Pop Up Cancellation");
				Helper.compareEquals(testConfig, "Post Trail Cancellation Popup Heading text","Call to cancel",postTrialCancelPopUpHeading.getText().toString());
				Helper.compareEquals(testConfig, "Post Trail Cancellation Popup Body text","In order to cancel your participation in Optum Pay, you will need to call 1-877-620-6194 for assistance. The process may take up to 7 days to process, in which time you will be responsible for any charges to your account. If at any time you will like to reinstate the full functionality of Optum Pay, please return to this tab.",postTrialCancelPopUpText.getText().toString());
			}
			else if(trialStatus.equalsIgnoreCase("A"))
			{  
				Element.click(lnkCancelSubscription, "Cancel My Subscription Link");
				Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text","You are about to lose important functionality through Optum Pay.",duringTrialCancelPopUpHeading.getText().toString());
				Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text","By cancelling your Optum Pay access, you will be losing features that many providers consider vital to their practice, including:",duringTrialCancelPopUpBody1.getText().toString());
				for( WebElement cancelPopUptext : duringTrialCancelPopUpBody2)
					{Helper.compareEquals(testConfig, "Pop Up Text List", popUpTextList.get(j).toString(), cancelPopUptext.getText().toString());
					j++;
					}									
				Helper.compareEquals(testConfig, "Trail Cancellation Popup Heading text","Upon cancellation of Optum Pay, you will continue to receive ACH payments and maintain limited portal access.",duringTrialCancelPopUpBody3.getText().toString());
				Element.click(btnCancellationSubmitTrial,"click on yes i want to cancel");
				Element.verifyElementPresent(errorCancelWithoutReason, "Error thrown when reason is not selected");
				Helper.compareEquals(testConfig, "Error thrown when reason is not selected", "Please enter Reason for Termination.", errorCancelWithoutReason.getText().toString());
				for(WebElement cancelReasonUI :listTrialCancellationReason)
					{
					  if(cancelReasonUI.getText().toString().equalsIgnoreCase("Select One"))
						  continue;
					  else
					   {
						  Helper.compareEquals(testConfig, "cancel List", cancelReasonDB.get(i).get("PAY_PROC_ACPT_CD_VAL_DESC").toString(), cancelReasonUI.getText().toString());
						  Helper.compareEquals(testConfig, "cancel List", cancelReasonList.get(i-1).toString(), cancelReasonUI.getText().toString());
						  i++;
					   }
					}
				Element.click(otherOptionTrialCancellationReason, "Selecting Other as the Reason");
				Element.click(btnCancellationSubmitTrial,"click on yes i want to cancel");
				Element.verifyElementPresent(errorCancelWithoutReason, "Error thrown when reason is not selected");
				Helper.compareEquals(testConfig, "Error thrown when other reason is not given", "Please enter Other reason for termination.", errorCancelWithoutReason.getText().toString());
			}
			
		}
	


	public void verifyPageText_Message2_Standard()
	{
		Helper.compareEquals(testConfig, "Message 2 Standard", Message2_Standard, msg2_Standard.getText().trim());
	}
	
	
	
	
	
	
	
	
	
}
