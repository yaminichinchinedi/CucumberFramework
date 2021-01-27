package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
	@FindBy(linkText="Logout") 
	WebElement lnkLogout;
	@FindBy(linkText="Home") 
	WebElement lnkHome;
	@FindBy(xpath = "//div[@id=\"optum-pay-tabs\"]//div[1]//p[2]") 
	WebElement pageText;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]") 
	WebElement txtFeesInfoAO;
	@FindBy(linkText="Cancel My Subscription")  
	WebElement lnkCancelSubscription;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div[3]//div[2]") 
	WebElement txtActivationAdminName;
	@FindBy(xpath = "//div[@id=\"cancelationModal\"]/h2") 
	WebElement duringTrialCancelPopUp;
	@FindBy(xpath = "//div[@id=\"cancelationPostTrialModal\"]/h2") 
	WebElement postTrialCancelPopUp;
	@FindBy(xpath = "//div[2]/div[1]/button[1]/span[1]") 
	WebElement btnCancelOnPopUp;
	
		private TestBase testConfig;
		public OptumPaySolutionUPA(TestBase testConfig) {
			this.testConfig=testConfig;
			PageFactory.initElements(testConfig.driver, this);
		}
		public void verifyHeaders(){
			Helper.compareEquals(testConfig, "1st Tile Header", "Provider Name", txtProvNameHeader.getText().trim());
			Helper.compareEquals(testConfig, "2nd Tile Header", "Plan Type", txtPlanTypeHeader.getText().trim());
			Helper.compareEquals(testConfig, "3rd Tile Header", "Fees", txtFeesHeader.getText().trim());
			Helper.compareEquals(testConfig, "4th Tile Header", "Manage Subscriptions", txtManageSubHeader.getText().trim());	
		}
		public void verifyPlanTypeInfoForVCP(){
			verifyHeaders();
			int sqlRowNo = 1;
		    testConfig.getRunTimeProperty("tin");
		    Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    Helper.compareEquals(testConfig, "Organization Name on 1st tile DB and UI", data.get("ORG_NM").toString().trim(),txtProvNameInfo.getText().trim());
		    Helper.compareEquals(testConfig, "Plan Type on 2nd tile", "VCP Only", txtPlanTypeInfoVO.getText().trim());
		    Helper.compareEquals(testConfig, "Fees on 3rd tile", "N/A", txtFeesInfoVO.getText().trim());
		    Helper.compareEquals(testConfig, "Manage Subscriptions on 4th tile", "N/A", txtManageSubInfo.getText().trim());	
		    Element.click(testConfig, lnkHome, "Home", 3);
			Element.click(testConfig, lnkLogout, "Logout", 3);
		}
		public void verifySolutionsTabForStandard(String trialStatus, String portalAccess){
			Helper.compareEquals(testConfig, "Optum Pay brings more power to your practice text on Standard view", "Optum Pay brings more power to your practice", txtOnStandardPage.getText().trim());
			Element.verifyElementPresent(video, "Video");
			Element.click(testConfig, lnkHome, "Home", 3);
			Element.click(testConfig, lnkLogout, "Logout", 3);
		}
		public void verifySolutionsTabForPremium(String trialStatus,String portalAccess) throws Exception{
			if(trialStatus.equalsIgnoreCase("A")) {
				Browser.browserRefresh(testConfig);
				Browser.waitForPageLoad(testConfig);
				verifyHeaders();
				planTypeInfoForPremium();
				Helper.compareEquals(testConfig, "During Trial Cancel pop-up", "You are about to lose important functionality through Optum Pay.", duringTrialCancelPopUp.getText().trim());
				Element.click(btnCancelOnPopUp, "Close pop-up 'X' button");
				Element.verifyElementPresent(pageText, "Page Text");
				Element.click(testConfig, lnkHome, "Home", 3);
				Element.click(testConfig, lnkLogout, "Logout", 3);
			}
			else if(trialStatus.equalsIgnoreCase("I")) {
				verifyHeaders();
				planTypeInfoForPremium();
				Helper.compareEquals(testConfig, "Post Trial Cancel pop-up", "Call to cancel", postTrialCancelPopUp.getText().trim());
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
		}

