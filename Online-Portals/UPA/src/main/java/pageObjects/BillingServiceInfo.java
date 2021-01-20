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
import org.xml.sax.SAXException;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class BillingServiceInfo {

	@FindBy(xpath = "//select[@id='userTypeSelection']") WebElement usertypedrpdwn;
	@FindBy(name="identifierNbr") WebElement txtboxTinNo;
	@FindBy(xpath = "//input[@value='Search']") WebElement submitBtn;
	@FindBy(xpath = "//td[contains(text(),'Billing Service Information')]") WebElement bsheader;
	@FindBy(xpath = "//a[contains(text(),'Add Single Provider TIN')]") WebElement addtin;
	@FindBy(xpath = "//a[contains(text(),'Upload Multiple Provider TINs')]") WebElement mulprovtin;
	@FindBy(name="btnCancel") WebElement cancelbtn;
	@FindBy(name="provderTin") WebElement enterprovtin;
	@FindBy(xpath = "//tbody/tr[@id='singletin']/td[1]/input[2]") WebElement submitbtn;
	@FindBy(xpath = "//th[contains(text(),'Provider TIN')]") WebElement provtin;
	@FindBy(xpath = "/html/body/div/table/tbody/tr[2]/td/form/table/tbody/tr[13]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/th[1]/a") 
	WebElement provTinHeaderPendingRequests;
	
	@FindBy(xpath = "//*[contains(text(),'Provider Name')]") WebElement provname;
	@FindBy(xpath = "//*[contains(text(),'Request Date')]") WebElement reqdate;
	@FindBy(xpath = "//*[contains(text(),'Status')]") WebElement status;
	@FindBy(name="confirmCheckBox") WebElement confirmchkbox;
	@FindBy(xpath = "//*[contains(text(),'Enrollment Status')]") WebElement enrlstatus;
	@FindBy(xpath = "//*[contains(text(),'Confirm')]") WebElement confirm;
	@FindBy(name="btnSave") WebElement btnsave;
	@FindBy(name="btnSaveAssoc") WebElement btnSaveOnProvPage;
	
	@FindBy(name="btnCancel") WebElement btncancel;
	@FindBy(xpath = "//td[2]//a[contains(text(),'Home')]") WebElement homebtn;
	@FindBy(xpath="//a[contains(text(),'Billing Service Information')]") WebElement lnkbillingservice;
	@FindBy(xpath = "//td[contains(text(),'Pending Requests')]") WebElement provpendreq;

	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[17]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[2]") WebElement bsnamependreq;
	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[17]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[3]") WebElement pendreqdate;
	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[19]/td/table/tbody/tr[1]/td") WebElement provhistory;
	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[19]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[1]") WebElement provhisdate;
	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[19]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]") WebElement proveffcdate;
	@FindBy(name="apprCheck") WebElement apprvpendreq;
	@FindBy(name="effectiveDt_2317") WebElement pendeffectdate;
	@FindBy(name="btnSaveAssoc") WebElement provsavebtn;
	@FindBy(xpath = "//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr[2]") WebElement bsnamecheck;
	@FindBy(xpath = "//*[contains(text(),'Termination Date: Invalid Data')]") WebElement terminateerror;
	@FindBy(xpath = "//a[contains(text(),'Anniversary')]") WebElement annvrsybtn;
	@FindBy(name="remove") WebElement chkRemove;
	
	@FindBy(xpath = "//*[@id=\"billing-service-information-tabs\"]/div[1]/h2") WebElement pageText1;
	@FindBy(xpath = "//*[@id=\"billing-service-information-tabs\"]/div[1]/p[2]") WebElement pageText2;
	@FindBy(xpath = "//a[@id='tabBillingService']") WebElement lnkBsInfo;
	@FindBy(xpath = "//*[@id=\"tabHome\"]") 
	WebElement lnkHome;
	@FindBy(xpath = "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[13]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/th[3]/a") WebElement lnkReqDate;
	
	@FindBy(xpath="//*[@id=\\\"billingServiceViewInfoForm\\\"]/table/tbody/tr[13]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]")
	List <WebElement> provTINs;
	
	
	
    private ViewPaymentsDataProvider dataProvider;
	private TestBase testConfig;

	public BillingServiceInfo(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	private String getTinCSR(String paymentType) {
		
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		return dataProvider.getTinForPaymentType(paymentType);
	}
	public String getBSTinCSR() {
		 int sqlRowNo = 16;
			Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String bsTIN = data.get("IDENTIFIER_NBR").toString(); 
			testConfig.putRunTimeProperty("bsTIN", bsTIN);
			String bsname= data.get("BS_NM").toString();
			testConfig.putRunTimeProperty("bsname", bsname);
		return bsTIN;
	}
	public void verifyUserType(String paymentType, String usertype)
	{
		if(usertype.equalsIgnoreCase("Prov")) {
		String tin=getTinCSR(paymentType);
	    System.setProperty("tin", tin); 
		}
		else if(usertype.equalsIgnoreCase("BS")) {
			String bsTIN=getBSTinCSR();
		    System.setProperty("bsTIN", bsTIN); 
		}
		 
		switch(usertype) 
		 {
		
		
	        case "BS":
	        {   
			   String bsTIN = System.getProperty("bsTIN");
			   Element.selectByVisibleText(usertypedrpdwn, "Billing Service", "Billing Service dropdown");
			   Element.click(txtboxTinNo, "Enter TIN");
			   Element.enterData(txtboxTinNo, bsTIN, "Enter TIN for BS", "Enter BS TIN in CSR");
			   Element.click(submitBtn, "Click Search Button");
	  	       break;
	        }  
	       case "PROV":
	       {
			   String provTIN = System.getProperty("provTIN");
			   Element.selectByVisibleText(usertypedrpdwn, "Provider", "Provider dropdown");
			   Element.click(txtboxTinNo, "Enter TIN");
			   Element.enterData(txtboxTinNo, provTIN, "Enter TIN for PROV", "Enter PROV TIN in CSR");
			   Element.click(submitBtn, "Click Search Button");
	  	       break;
	        }
		 }
	}
	
public String getProvTinCSR() {
	 int sqlRowNo = 1340;
		testConfig.getRunTimeProperty("bsTIN");
		Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String provTIN = data.get("PROV_TIN_NBR").toString();  
	return provTIN;
}
	
	public void verifyBSInfoFunctionality()
	{
		String provTIN=getProvTinCSR();
	    System.setProperty("provTIN", provTIN); 
		Browser.wait(testConfig, 5);
		Element.click(addtin, "Add Single Provider TIN");
		Element.click(enterprovtin, "Enter Provider Tin");
		Element.enterData(enterprovtin, provTIN, "Enter Provider Tin", "EnterProvider Tin");
		Element.click(submitbtn, "Submit Button");
		Element.click(confirmchkbox, "Confirm Check Box");
		verifyAddProvConfirmPage();
		pendingRequestsFunction();
		verifyUiFunction();
	}
	 
		
	public void verifyaproveprovtin() throws ParseException
	{
	    Element.click(homebtn, "Home Button");
	    Browser.wait(testConfig, 3);
	    Element.click(lnkbillingservice, "Billing Service Infomation Link in Home Page");
	    String provTIN = System.getProperty("provTIN");
		Element.selectByVisibleText(usertypedrpdwn, "Provider", "Provider dropdown");
	    Element.click(txtboxTinNo, "Enter TIN");
    	Element.enterData(txtboxTinNo, provTIN, "Enter TIN for PROV", "Enter PROV TIN in CSR");
		Element.click(submitBtn, "Click Search Button");
		String text=Element.findElement(testConfig, "xpath", "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[15]/td").getText() ;
	
		if(testConfig.driver.findElements(By.xpath("//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[15]/td")).size() != 0) 
			Log.Comment("No Billing Service associations exist");
		else {
	    verifyProvFirstRow();
		}
		verifyProvSecondRow();
		verifyProvThirdRow();
		verifyAssocProv();
	  //verifyerrorsfordateformat();
		verifyDeleteAssoc();
	}
	
	public void verifyProvFirstRow()
	{
		ArrayList<String> tinsAssocHeader = new ArrayList<String>();
		List<String> tinsAssocHeaderUI = new ArrayList<String>();
		tinsAssocHeader.add("Provider TIN");
		tinsAssocHeader.add("Name of Billing Service");
		tinsAssocHeader.add("Status");
		tinsAssocHeader.add("Effective Date");
		tinsAssocHeader.add("Anniversary");
		tinsAssocHeader.add("Remove");
		tinsAssocHeader.add("Renew for Additional Year");
		tinsAssocHeader.add("Termination Date");
		int size = tinsAssocHeader.size();
		Browser.waitForPageLoad(testConfig);
		Browser.wait(testConfig, 5);
		for(int i=1; i<=size; i++)												                                        
		{																			
			String allOptions=	Element.findElement(testConfig, "xpath", "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr[1]/th["+i+"]").getText().toString().trim();												
			
			if(allOptions.contains("Renew for"))
			{
				allOptions = "Renew for Additional Year";
			}
			tinsAssocHeaderUI.add(allOptions);
		}
		
		Helper.compareEquals(testConfig, "Provider BS Info Tab First Row Headers", tinsAssocHeader, tinsAssocHeaderUI);
		
	  if(testConfig.driver.findElements(By.xpath("//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[4]")).size() != 0)
	  {
		  String effecdate = Element.findElement(testConfig, "xpath", "//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[4]").getText().trim();
    	  Element.isValidFormat("mm/dd/yyyy",effecdate,Locale.ENGLISH);
		  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", effecdate,Locale.ENGLISH));
	  }
	  else
		  Log.Comment("No data present in the row to check Effective Date format in first row");
	  
	  if(testConfig.driver.findElements(By.xpath("//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[5]")).size() != 0)
	  {
		  String annidate = Element.findElement(testConfig, "xpath", "//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[5]").getText().trim();
    	  Element.isValidFormat("mm/dd/yyyy",annidate,Locale.ENGLISH);
		  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", annidate,Locale.ENGLISH));
	  }
	  else
		  Log.Comment("No data present in the row to check Anniversary Date format in first row");
	  
}
	
	
public void verifyProvSecondRow() throws ParseException
	{
		
		String pendreheader = provpendreq.getText();
		Helper.compareEquals(testConfig, "Pending Request Header in Provider Tab existence", true, provpendreq.isDisplayed());
		Helper.compareEquals(testConfig, "Pending Request Header in Provider Tab", "Pending Requests", pendreheader);
		ArrayList<String> pendngreqheaders = new ArrayList<String>();
		List<String> pendngreqheadersui = new ArrayList<String>();
		pendngreqheaders.add("Provider TIN");
		pendngreqheaders.add("Name of Billing Service");
		pendngreqheaders.add("Request Date");
		pendngreqheaders.add("Status");
		pendngreqheaders.add("Approve");
		pendngreqheaders.add("Deny");
		pendngreqheaders.add("Effective Date");
		pendngreqheaders.add("Notify");
		int size = pendngreqheaders.size();
		for(int i=1; i<=size; i++)										
		{
			String allOptions = testConfig.driver.findElement(By.xpath("//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[17]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/th["+i+"]")).getText().trim();
			pendngreqheadersui.add(allOptions);
		}
		
		Helper.compareEquals(testConfig, "Provider BS Info Tab Second Row Headers", pendngreqheaders, pendngreqheadersui);
		String provtin = System.getProperty("provTIN");
		String provtinreq = testConfig.driver.findElement(By.xpath("//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[17]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[1]")).getText().trim();
		Helper.compareEquals(testConfig, "Provider TIN requested from BS vs displayed in Pending request Prov Tab", provtin, provtinreq);
		String bsnamedb = testConfig.getRunTimeProperty("bsname").trim();
		String bsnamepndrequi = bsnamependreq.getText().trim();
		Helper.compareEquals(testConfig, "Billing Service name displayed in Pending request Prov Tab", bsnamedb, bsnamepndrequi);
	    int sqlRowNo = 1910;
		Map curr_datedb = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String curr_date = curr_datedb.get("CURRENT_DATE").toString();
	    String pendreqdateui = pendreqdate.getText().trim();
		Helper.compareEquals(testConfig, "Provider TIN requested from BS vs displayed in Pending request Prov Tab", Helper.changeDateFormat(curr_date, "yyyy-mm-dd", "mm/dd/yyyy"),pendreqdateui);
		Element.isValidFormat("mm/dd/yyyy",pendreqdateui,Locale.ENGLISH);
  	    Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", pendreqdateui,Locale.ENGLISH));
}
	
	public void verifyProvThirdRow() throws ParseException
	{
		String provhistoryui = provhistory.getText().trim();
		Helper.compareEquals(testConfig, "History Header in Provider Tab existence", true, provhistory.isDisplayed());
		Helper.compareEquals(testConfig, "History Header in Provider Tab", "History", provhistoryui);
		ArrayList<String> historyheaders = new ArrayList<String>();
		List<String> historyheadersui = new ArrayList<String>();
		historyheaders.add("Date");
		historyheaders.add("Provider TIN");
		historyheaders.add("Name of Billing Service");
		historyheaders.add("Effective Date");
		historyheaders.add("End Date");
		historyheaders.add("Action Type");
		historyheaders.add("Name / Username");
		
		int size = historyheaders.size();
		for(int i=1; i<=size; i++)
		{																
			String allOptions = testConfig.driver.findElement(By.xpath("//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[19]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/th["+i+"]")).getText().trim();
			historyheadersui.add(allOptions);
		}
	    Helper.compareEquals(testConfig, "Provider BS Info Tab Third Row Headers", historyheaders, historyheadersui);
		if(provhisdate.isDisplayed())
		  {
			  String provhisdateui = provhisdate.getText().trim();
	    	  Element.isValidFormat("mm/dd/yyyy",provhisdateui,Locale.ENGLISH);
			  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", provhisdateui,Locale.ENGLISH));
		  }
		  else
			  Log.Comment("No data present in the row to check History Date format in Third row");
		
		if(proveffcdate.isDisplayed())
		  {
			  String proveffcdateui = proveffcdate.getText().trim();
	    	  Element.isValidFormat("mm/dd/yyyy",proveffcdateui,Locale.ENGLISH);
			  Log.Pass("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", proveffcdateui,Locale.ENGLISH));
		  }
		  else
			  Log.Comment("No data present in the row to check Effective Date format in Third row");
		
		Element.click(apprvpendreq, "Checkbox Aprrove Pending Request");
		Element.click(provsavebtn, "Save Button");
}
	
	public void verifyAssocProv()
	{
		Browser.wait(testConfig, 3);
	    annvrsybtn.click();
	    int count = Element.findElements(testConfig, "xpath", "//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr").size();
		String bsnamecheckui = Element.findElement(testConfig, "xpath","//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr["+count+"]/td[2]").getText().trim();
		String bsnameaddeddb = testConfig.getRunTimeProperty("bsname").trim();
		Helper.compareEquals(testConfig, "Provider TIN got added properly or not", bsnamecheckui, bsnameaddeddb);
	}
	
	public void verifyerrorsfordateformat()
	{
		final String splsymbols = "$&@?<>~!%#";
		String alphacheck = RandomStringUtils.randomAlphabetic(3); 
		int count = Element.findElements(testConfig, "xpath", "//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr").size();
		WebElement termdatecol = Element.findElement(testConfig, "xpath", "//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr["+count+"]/td[8]");	
		Element.click(chkRemove, "Remove checkbox");
		//Element.clickByJS(testConfig, termdatecol, "Termination Date textbox");
		//Element.enterData(termdatecol, alphacheck, "Checking alpha entry for error check", "Termination Date is not valid");
		//Element.clearData(termdatecol, "Clearing Termination Date");
		Browser.wait(testConfig, 3);
		Log.Comment(alphacheck);
		//Element.enterDataByJS(testConfig, termdatecol, alphacheck, "Checking Alpha Error");
		testConfig.driver.findElement(By.xpath("//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr["+count+"]/td[8]")).click();
		testConfig.driver.findElement(By.xpath("//table/tbody/tr[16]/td/table/tbody/tr/td/div/table/tbody/tr["+count+"]/td[8]")).sendKeys(alphacheck);
//		WebDriver driver= testConfig.getDriver();
//		JavascriptExecutor jst= (JavascriptExecutor) driver;
//		jst.executeScript("arguments[1].value = arguments[0]; ", alphacheck, termdatecol);
		Browser.wait(testConfig, 3);
		Element.click(btnSaveOnProvPage, "Save Button");
		Helper.compareEquals(testConfig, "Termination Date Format Error Msg Check for Aplhabetic Characters", true, terminateerror.isDisplayed());
		Element.clearData(termdatecol, "Termination Date");
		
		Browser.wait(testConfig, 3);
		String alphanumcheck = RandomStringUtils.randomAlphanumeric(10);
		Element.click(termdatecol, "Termination Date");
		//Element.enterData(termdatecol, alphanumcheck, "Checking alpha numeric entry for error check", "Termination Date is not valid");
		Element.clearData(termdatecol, "Clearing Termination Date");
		Element.enterDataByJS(testConfig, termdatecol, alphanumcheck, "Checking alpha numeric entry for error check");
		Element.click(chkRemove, "Remove checkbox");
		Element.click(btnSaveOnProvPage, "Save Button");
		Helper.compareEquals(testConfig, "Termination Date Format Error Msg Check for Aplhanumeric", true, terminateerror.isDisplayed());
		Element.clearData(termdatecol, "Termination Date");
		
		Browser.wait(testConfig, 3);
		Element.click(termdatecol, "Termination Date");
		//Element.enterData(termdatecol, splsymbols, "Checking Special Characters for error check", "Termination Date is not valid");
		Element.clearData(termdatecol, "Clearing Termination Date");
		Element.enterDataByJS(testConfig, termdatecol, splsymbols, "Checking Special Characters for error check");
		Element.click(chkRemove, "Remove checkbox");
		Element.click(btnSaveOnProvPage, "Save Button");
		Helper.compareEquals(testConfig, "Termination Date Format Error Msg Check for Special Characters", true, terminateerror.isDisplayed());
		Element.clearData(termdatecol, "Termination Date");
	
		String effcdtui = System.getProperty("effcdt");
		Element.click(termdatecol, "Termination Date");
		Element.enterData(termdatecol, "Enter Valid Date Format", effcdtui, "Entering Date");
		Element.click(chkRemove, "Remove checkbox");
		Element.click(btnsave, "Save Button");	
}
	
	
public void verifyDeleteAssoc()
{
	String tin = System.getProperty("provTIN");
	int sqlRowNo = 1911;
	int record = DataBase.executeDeleteQuery(testConfig, 1);
	
}
	
public void verifyUiFunction()
{
	List<String> pend_his_headers = new ArrayList<String>();
	Helper.compareEquals(testConfig, "Billing Service Information Header", true, bsheader.isDisplayed());
	Helper.compareEquals(testConfig, "Add Single Provider TIN Header", true, addtin.isDisplayed());
	Helper.compareEquals(testConfig, "Upload Multiple Provider TINs Header", true, mulprovtin.isDisplayed());
	Helper.compareEquals(testConfig, "Cancel Button Header", true, cancelbtn.isDisplayed());
}
	
public void pendingRequestsFunction()
{
	Browser.wait(testConfig, 7);
	Helper.compareEquals(testConfig, "Provider TIN Header in Pending Requests", true, provTinHeaderPendingRequests.isDisplayed());
	Helper.compareEquals(testConfig, "Provider Name Header in Pending Requests", true, provname.isDisplayed());
	Helper.compareEquals(testConfig, "Request Date Header in Pending Requests", true, reqdate.isDisplayed());
	Helper.compareEquals(testConfig, "Status Header in Pending Requests", true, status.isDisplayed());
	Browser.wait(testConfig, 3);
	String provName;									 
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
		String reqDate = Element.findElement(testConfig, "xpath", "//*[@id=\"billingServiceViewInfoForm\"]/table/tbody/tr[13]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[3]").getText().trim();
		Element.isValidFormat("mm/dd/yyyy",reqDate,Locale.ENGLISH);
		Log.Comment("isValid - mm/dd/yyyy = " + Element.isValidFormat("mm/dd/yyyy", reqDate,Locale.ENGLISH));
		
}
	
public void verifyAddProvConfirmPage()
{
	Helper.compareEquals(testConfig, "Provider TIN Header in Pending Requests", true, provtin.isDisplayed());
    Helper.compareEquals(testConfig, "Provider Name Header in Pending Requests", true, provname.isDisplayed());
    Helper.compareEquals(testConfig, "Enrollment Status Header in Pending Requests", true, enrlstatus.isDisplayed());
    Helper.compareEquals(testConfig, "Confirm Header in Pending Requests", true, confirm.isDisplayed());
    Helper.compareEquals(testConfig, "Save Button Header in Pending Requests", true, btnsave.isDisplayed());
    Helper.compareEquals(testConfig, "Cancel Button Header in Pending Requests", true, btncancel.isDisplayed());
	String providertin = Element.findElement(testConfig, "xpath", "//table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]").getText().trim();
    String tin = System.getProperty("provTIN");
	Helper.compareEquals(testConfig, "Provider TIN which is getting added", tin,providertin);
	String provname = Element.findElement(testConfig, "xpath", "//table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]").getText().trim().trim();
    int sqlRowNo = 1;
    testConfig.putRunTimeProperty("tin",tin);
    Map orgname = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
    Helper.compareEquals(testConfig, "Provider Name UI and DB", orgname.get("ORG_NM").toString().trim(),provname.trim());
    String enrlstatus = Element.findElement(testConfig, "xpath", "//table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]").getText();
    if(enrlstatus == "Active")
    {
	   enrlstatus = "A";
	   Helper.compareEquals(testConfig, "Provider Name UI and DB", orgname.get("ENRL_STS_CD").toString(),enrlstatus.trim());
	 }
	    Element.click(btnsave, "Save Button");
}

public void verifyTrialEndDateAndUpdateIfOver() throws Exception {
	 int sqlRowNo = 1341;
		Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String trialEndDate = data.get("PROC_DATA").toString();  
		String currentDate = Helper.getCurrentDate("yyyy/MM/dd");
		if(testConfig.driver.findElements(By.xpath("//*[@id=\"billing-service-information-tabs\"]/div[1]/h2")).size()==0) {	
		//update to current date
			currentDate = Helper.getCurrentDate("yyyy/MM/dd").replace("/", "-");
			testConfig.putRunTimeProperty("currentDate", currentDate);
			testConfig.getRunTimeProperty("currentDate");
			sqlRowNo = 1342;
			int dataBase=DataBase.executeUpdateQuery(testConfig,sqlRowNo);
			Element.click(testConfig, lnkHome, "Home Tab", 3);
			Browser.waitForPageLoad(testConfig);
			Element.click(testConfig, lnkBsInfo, "Billing Service Information Tab", 3);
			Browser.waitForPageLoad(testConfig);
		}
		else
			Log.Comment("Trial is not over yet");
}
public void verifyPageText() {
	String pageText1UI= pageText1.getText().trim();
	String pageText2UI= pageText2.getText().trim();
	String pageText1Expected= "Do you need full access to provider claim payment data?";
	String pageText2Expected="If you need access to historical claim data and search tools, talk to your provider administrator about activating the full functionality of Optum Pay.";
Helper.compareContains(testConfig, "Page Text in bold", pageText1Expected, pageText1UI);
Helper.compareContains(testConfig, "Page Text", pageText2Expected, pageText2UI);
}
}
	
