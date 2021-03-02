
package main.java.pageObjects;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;


import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.xml.sax.SAXException;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.pageObjects.SearchTinPageBillingServiceInfo;
public class BillingServiceInfo {
	@FindBy(xpath = "//select[@id='userTypeSelection']") WebElement userTypeDrpDwn;
	@FindBy(name="identifierNbr") WebElement txtboxTinNo;
	@FindBy(xpath = "//input[@value='Search']") WebElement btnSearch;
	@FindBy(xpath = "//td[contains(text(),'Billing Service Information')]") WebElement txtbsHeader;
	@FindBy(linkText="Add Single Provider TIN") WebElement lnkAddTin;
	@FindBy(linkText="Upload Multiple Provider TINs") WebElement lnkMulProvTin;
	@FindBy(name="btnCancel") WebElement btnCancel;
	@FindBy(name="provderTin") WebElement txtboxEnterProvTin;
	@FindBy(xpath = "//tr[@id='singletin']/td/input[2]") WebElement btnSubmit;
	@FindBy(xpath = "//th[contains(text(),'Provider TIN')]") WebElement provTinHeader;
	@FindBy(xpath = "//form[@id=\"billingServiceViewInfoForm\"]//table//tr[13]//tr[2]//th[1]") WebElement provTinHeaderPendingRequests;
	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table//tr[11]//th[2]") WebElement providerNameHeader;
	@FindBy(xpath = "//a[contains(text(),'Request Date')]") WebElement reqDateHeader;
	@FindBy(xpath = "//form[@id=\"billingServiceViewInfoForm\"]//table//tr[13]//tr[2]//th[4]") WebElement statusHeader;
	@FindBy(name="confirmCheckBox") WebElement chkboxConfirm;
	@FindBy(xpath = "//th[contains(text(),'Enrollment Status')]") WebElement enrlStatusHeader;
	@FindBy(xpath = "//th[contains(text(),'Confirm')]") WebElement confirmHeader;
	@FindBy(name="btnSave") WebElement btnSave;
	@FindBy(name="btnSaveAssoc") WebElement btnSaveOnProvPage;	
	@FindBy(name="btnCancel") WebElement btncancel;
	@FindBy(xpath = "//td[2]//a[contains(text(),'Home')]") WebElement btnHome;
	@FindBy(linkText="Billing Service Information") WebElement lnkBillingService;
	@FindBy(xpath = "//td[contains(text(),'Pending Requests')]") WebElement txtprovPendReq;
	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[17]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[3]") WebElement pendreqdate;
	@FindBy(xpath = "//form[@id=\"billingServiceViewInfoForm\"]//table//tr[19]//tr[1]/td") WebElement provHistory;
	@FindBy(xpath = "//form[@id=\"billingServiceViewInfoForm\"]//table//tr[19]//tr[2]//tr[2]//td[1]") WebElement provHisDate;
	@FindBy(xpath = "//form[@id=\"billingServiceViewInfoForm\"]//table//tr[19]//tr[2]//tr[2]//td[4]") WebElement provEffcDate;
	@FindBy(name="apprCheck") WebElement approvePendingReq;
	@FindBy(name="effectiveDt_2317") WebElement pendeffectdate;
	@FindBy(name="btnSaveAssoc") WebElement btnProvSave;
	@FindBy(xpath = "//font[contains(text(),'Termination Date: Invalid Data')]") WebElement txtInvalidDateError;
	@FindBy(linkText="Anniversary") WebElement lnkAnniversaryHeader;
	@FindBy(name="remove") WebElement chkRemove;
	@FindBy(xpath = "//table[1]//div//tr[2]//td[1]") WebElement provTinOnAddProvTinPage;
	@FindBy(xpath = "//table[1]//div//tr[2]//td[2]") WebElement provNameOnAddProvTinPage;
	@FindBy(xpath = "//table[1]//div//tr[2]//td[3]") WebElement enrlStatusOnAddProvTinPage;	
	@FindBy(xpath = "//div[@id='billing-service-information-tabs']//h2") WebElement pageText1;
	@FindBy(xpath = "//div[@id='billing-service-information-tabs']//p[2]") WebElement pageText2;
	@FindBy(linkText="Billing Service Information") WebElement lnkBsInfo;
	@FindBy(linkText="Home") WebElement lnkHome;
	@FindBy(xpath = "//div[@id='billing-service-information-tabs']//p") WebElement pageTextProviderParagraph;

	private TestBase testConfig;
	public BillingServiceInfo(TestBase testConfig){
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}

	public void verifyBSInfoFunctionality(){
		/** Gets an active provider TIN which is not already associated with the billing service **/
		 
		int sqlRowNo = 1340;
		testConfig.getRunTimeProperty("tin");
		Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1); 
		String provTIN=data.get("PROV_TIN_NBR").toString();
	    System.setProperty("provTIN", provTIN); 
	    
	    
		Element.click(lnkAddTin, "Add Single Provider TIN");
		Element.click(txtboxEnterProvTin, "Enter Provider Tin");
		Element.enterData(txtboxEnterProvTin, provTIN, "Enter Provider Tin", "EnterProvider Tin");
		Element.click(btnSubmit, "Submit Button");
		Browser.waitForPageLoad(testConfig);
		Element.click(chkboxConfirm, "Confirm Check Box");
		verifyAddProvConfirmPage();
		pendingRequestsFunction();
		verifyUiFunction();
	}
	 	
	public void verifyApproveProvTin() throws ParseException{
	    Element.click(btnHome, "Home Button");
	    Element.click(lnkBillingService, "Billing Service Infomation Link on Home Page");
	    String provTIN = System.getProperty("provTIN");
		Element.selectByVisibleText(userTypeDrpDwn, "Provider", "Provider dropdown");
	    Element.click(txtboxTinNo, "Enter TIN");
    	Element.enterData(txtboxTinNo, provTIN, "Enter TIN for PROV", "Enter PROV TIN in CSR");
		Element.click(btnSearch, "Click Search Button");
		if(testConfig.driver.findElements(By.xpath("//td[contains(text(),'No Billing Service associations exist')]")).size() != 0) 
			Log.Comment("No Billing Service associations exist");
		else 
			verifyProvFirstRow();
		
		verifyProvSecondRow();
		verifyProvThirdRow();
		verifyAssocProv();
	    //verifyErrorsForInvaidDateFormat();
		verifyDeleteAssoc();
	}
	
	public void verifyProvFirstRow(){
		ArrayList<String> tinsAssocHeader = new ArrayList<String>(Arrays.asList("Provider TIN", "Name of Billing Service","Status","Effective Date","Anniversary","Remove","Renew for Additional Year","Termination Date"));
		List<String> tinsAssocHeaderUI = new ArrayList<String>();
		Browser.waitForPageLoad(testConfig);
		for(int i=1; i<=tinsAssocHeader.size(); i++){			     	  		
			String allOptions=	Element.findElement(testConfig, "xpath", "//form[@id='billingServiceViewInfoForm']//tr[16]//table//tr[1]/th["+i+"]").getText().replace("\n", "").trim();															
			tinsAssocHeaderUI.add(allOptions);
		}		
		Helper.compareEquals(testConfig, "Provider BS Info Tab First Row Headers", tinsAssocHeader, tinsAssocHeaderUI);
	  if(testConfig.driver.findElements(By.xpath("//table//tr[16]//tr[2]//td[4]")).size() != 0) {	  
		  String effecDate = Element.findElement(testConfig, "xpath", "//table//tr[16]//tr[2]//td[4]").getText().trim();
    	  Element.isValidFormat("mm/dd/yyyy",effecDate,Locale.ENGLISH);
		  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", effecDate,Locale.ENGLISH));
	  }
	  else
		  Log.Pass("No data present in the row to check Effective Date format in first row");
	  
	  if(testConfig.driver.findElements(By.xpath("//table//tr[16]//tr[2]//td[5]")).size() != 0){
		  String annidate = Element.findElement(testConfig, "xpath", "//table//tr[16]//tr[2]//td[5]").getText().trim();
    	  Element.isValidFormat("mm/dd/yyyy",annidate,Locale.ENGLISH);
		  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", annidate,Locale.ENGLISH));
	  }
	  else
		  Log.Pass("No data present in the row to check Anniversary Date format in first row");	  
}	
	
public void verifyProvSecondRow() throws ParseException{
		Helper.compareEquals(testConfig, "Pending Request Header in Provider Tab", "Pending Requests", txtprovPendReq.getText());
		ArrayList<String> pendingReqHeaders = new ArrayList<String>(Arrays.asList("Provider TIN", "Name of Billing Service", "Request Date","Status","Approve","Deny","Effective Date","Notify"));
		List<String> pendingReqHeadersUI = new ArrayList<String>();
		
		for(int i=1; i<=pendingReqHeaders.size(); i++){																	
			String allOptions = testConfig.driver.findElement(By.xpath("//form[@id='billingServiceViewInfoForm']/table//tr[17]//tr[2]//tr[1]/th["+i+"]")).getText().trim();
			pendingReqHeadersUI.add(allOptions);
		}
		Helper.compareEquals(testConfig, "Provider BS Info Tab Second Row Headers", pendingReqHeaders, pendingReqHeadersUI);
		List<WebElement> tinGridRows = Element.findElements(testConfig, "xpath","//form[@id='billingServiceViewInfoForm']//table//tr[13]//tr[2]//tr");
		String tin = System.getProperty("provTIN");
		for (int i = 1; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if (tinNo.equals(tin)) {
				Log.Pass("TIN added is displayed under Pending Requests Grid until approved");
				String bsNamePendReq = tinGridRows.get(i).findElements(By.tagName("td")).get(1).getText();
				Helper.compareEquals(testConfig, "Billing Service name displayed in Pending request Prov Tab", testConfig.getRunTimeProperty("bsname").trim(), bsNamePendReq.trim());
				break;
			}
		}
		int sqlRowNo = 1910;
		Map currDateDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Provider TIN requested from BS vs displayed in Pending request Prov Tab", Helper.changeDateFormat(currDateDB.get("CURRENT_DATE").toString(), "yyyy-mm-dd", "mm/dd/yyyy"),pendreqdate.getText().trim());
		Element.isValidFormat("mm/dd/yyyy",pendreqdate.getText().trim(),Locale.ENGLISH);
  	    Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", pendreqdate.getText().trim(),Locale.ENGLISH));
}
	
	public void verifyProvThirdRow() throws ParseException{
		Helper.compareEquals(testConfig, "History Header in Provider Tab", "History", provHistory.getText().trim());
		ArrayList<String> historyheaders = new ArrayList<String>(Arrays.asList("Date","Provider TIN", "Name of Billing Service","Effective Date","End Date","Action Type","Name / Username"));
		List<String> historyheadersui = new ArrayList<String>();
		for(int i=1; i<=historyheaders.size(); i++){																
			String allOptions = testConfig.driver.findElement(By.xpath("//form[@id='billingServiceViewInfoForm']//table//tr[19]//tr[1]//th["+i+"]")).getText().trim();
			historyheadersui.add(allOptions);
		}
	    Helper.compareEquals(testConfig, "Provider BS Info Tab Third Row Headers", historyheaders, historyheadersui);
		if(provHisDate.isDisplayed()){
	    	  Element.isValidFormat("mm/dd/yyyy",provHisDate.getText().trim(),Locale.ENGLISH);
			  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", provHisDate.getText().trim(),Locale.ENGLISH));
		  }
		  else
			  Log.Pass("No data present in the row to check History Date format in Third row");
		
		if(provEffcDate.isDisplayed()){
	    	  Element.isValidFormat("mm/dd/yyyy",provEffcDate.getText().trim(),Locale.ENGLISH);
			  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", provEffcDate.getText().trim(),Locale.ENGLISH));
		  }
		  else
			  Log.Pass("No data present in the row to check Effective Date format in Third row");
		
		Element.click(approvePendingReq, "Checkbox Aprrove Pending Request");
		Element.click(btnProvSave, "Save Button");
}
	
	public void verifyAssocProv(){
		Browser.wait(testConfig, 3);
		lnkAnniversaryHeader.click();
	    int count = Element.findElements(testConfig, "xpath", "//table/tbody/tr[16]//tr//tr").size();
		String bsNameCheckUI = Element.findElement(testConfig, "xpath","//table//tr[16]//tr//tr["+count+"]/td[2]").getText().trim();
		Helper.compareEquals(testConfig, "Billing Service name for the provider TIN added", bsNameCheckUI, testConfig.getRunTimeProperty("bsname").trim());
	}
	
public void verifyDeleteAssoc(){
	String tin = System.getProperty("provTIN");
	int sqlRowNo = 1911;
	int record = DataBase.executeDeleteQuery(testConfig, sqlRowNo);
	
}
	
public void verifyUiFunction(){
	List<String> pend_his_headers = new ArrayList<String>();
	Helper.compareEquals(testConfig, "Billing Service Information Header", true, txtbsHeader.isDisplayed());
	Helper.compareEquals(testConfig, "Add Single Provider TIN Header", true, lnkAddTin.isDisplayed());
	Helper.compareEquals(testConfig, "Upload Multiple Provider TINs Header", true, lnkMulProvTin.isDisplayed());
	Helper.compareEquals(testConfig, "Cancel Button Header", true, btnCancel.isDisplayed());
}
	
public void pendingRequestsFunction(){
	Browser.wait(testConfig, 7);
	Helper.compareEquals(testConfig, "Provider TIN Header in Pending Requests", true, provTinHeaderPendingRequests.isDisplayed());
	Helper.compareEquals(testConfig, "Provider Name Header in Pending Requests", true, providerNameHeader.isDisplayed());
	Helper.compareEquals(testConfig, "Request Date Header in Pending Requests", true, reqDateHeader.isDisplayed());
	Helper.compareEquals(testConfig, "Status Header in Pending Requests", true, statusHeader.isDisplayed());
	Browser.wait(testConfig, 3);							 
    String tin = System.getProperty("provTIN");
    List<WebElement> tinGridRows = Element.findElements(testConfig, "xpath","//tbody/tr[13]/td[1]/table[1]/tbody/tr[2]/td/div/table/tbody/tr");
	for (int i = 1; i < tinGridRows.size(); i++) {
		String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
		if (tinNo.equals(tin)) {
			Log.Pass("TIN added is displayed under Pending Requests Grid until approved");
			String providerName = tinGridRows.get(i).findElements(By.tagName("td")).get(1).getText();
			 int sqlRowNo = 1;
		    testConfig.putRunTimeProperty("tin",tin);
	    	Map orgname = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Helper.compareEquals(testConfig, "Provider Name UI and DB", orgname.get("ORG_NM").toString().trim(),providerName.trim());
			break;
		}
	}
		String reqDate = Element.findElement(testConfig, "xpath", "//*[@id='billingServiceViewInfoForm']/table/tbody/tr[13]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[3]").getText().trim();
		Element.isValidFormat("mm/dd/yyyy",reqDate,Locale.ENGLISH);
		Log.Comment("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", reqDate,Locale.ENGLISH));
}
	
public void verifyAddProvConfirmPage(){
	Helper.compareEquals(testConfig, "Provider TIN Header in Pending Requests", true, provTinHeader.isDisplayed());
    Helper.compareEquals(testConfig, "Provider Name Header in Pending Requests", true, providerNameHeader.isDisplayed());
    Helper.compareEquals(testConfig, "Enrollment Status Header in Pending Requests", true, enrlStatusHeader.isDisplayed());
    Helper.compareEquals(testConfig, "Confirm Header in Pending Requests", true, confirmHeader.isDisplayed());
    Helper.compareEquals(testConfig, "Save Button Header in Pending Requests", true, btnSave.isDisplayed());
    Helper.compareEquals(testConfig, "Cancel Button Header in Pending Requests", true, btncancel.isDisplayed());
    String tin = System.getProperty("provTIN");
	Helper.compareEquals(testConfig, "Provider TIN which is getting added", tin,provTinOnAddProvTinPage.getText().trim());
    int sqlRowNo = 1;
    testConfig.putRunTimeProperty("tin",tin);
    Map orgname = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
    Helper.compareEquals(testConfig, "Provider Name UI and DB", orgname.get("ORG_NM").toString().trim(),provNameOnAddProvTinPage.getText().trim());
    if(enrlStatusOnAddProvTinPage.getText().trim().equalsIgnoreCase("Active")) 
	   Helper.compareEquals(testConfig, "Provider Enroll Status UI and DB", "A",orgname.get("ENRL_STS_CD").toString().trim());

	Element.click(btnSave, "Save Button");
}

	public void verifyBillingServiceHeaderText() {

		String expected = "As a billing service, you will need your provider client to activate Optum Pay so that you have full access to their claims and remittance data and historical files. If not having this information is impacting your work, contact the provider and talk to them about activating Optum Pay.";
		String actual = Element.findElement(testConfig, "xpath", "//*[@id=\"billing-service-information-tabs\"]/div[1]/p[2]").getText().trim();

		Assert.assertTrue(expected.equals(actual), "Page Text validation failed");
		Log.Comment("Text Validation successful : \n"+actual);
	}
	public void verifyProviderPageText(String tinType, String portalAccess) {
		if("VO".equalsIgnoreCase(tinType))
			Helper.compareEquals(testConfig, "pagetText", "As part of your virtual card payment option, you have access to the full functionality of Optum Pay. This allows your billing service provider to access all of your claims and remittance data and work more efficiently for you.", pageTextProviderParagraph.getText());
		if(("AO".equalsIgnoreCase(tinType)||"AV".equalsIgnoreCase(tinType)) && "Premium".equalsIgnoreCase(portalAccess))
			Helper.compareEquals(testConfig, "pagetText", "With the full functionality of Optum Pay, your billing service provider is able to access all your claims and remittance data and work more efficiently for you.", pageTextProviderParagraph.getText().trim());
		if(("AO".equalsIgnoreCase(tinType)||"AV".equalsIgnoreCase(tinType)) && "Standard".equalsIgnoreCase(portalAccess))
			{Helper.compareEquals(testConfig, "pagetText", "Activating the full functionality of Optum Pay will help the billing service more efficiently manage your claim and remittance data. Learn More.", pageTextProviderParagraph.getText().trim());
			 Helper.compareEquals(testConfig,"pagetext", "Do you use a billing service provider?", pageText1.getText().trim());
			}
	}
}
	


