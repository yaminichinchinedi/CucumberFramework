package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.List;


import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import main.java.nativeFunctions.TestBase;

import main.java.reporting.Log;
import main.java.nativeFunctions.Element;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.reporting.Log;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.mysql.jdbc.StringUtils;

import cucumber.api.java.it.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import main.java.reporting.Log;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.SearchRemittanceSearchCriteria;
import main.java.queries.QUERY;
import main.java.nativeFunctions.TestBase;
public class RunReports extends TestBase{
	
@FindBy(xpath="//input[@value='hipaaErrorSummaryReport']")
WebElement radioHipaaErrorSummaryReport;
    
@FindBy(xpath="//input[@value='paymentRemitOnlySummaryReport']")
WebElement radioPaymentRemitOnlySummaryReport;
  	
@FindBy(xpath="//input[@value='paymentSummaryReport']")
WebElement radioPaymentSummaryReport;

@FindBy(xpath="//input[@value='transactionSummaryReport']")
WebElement radioTransactionSummaryReport;	
	
@FindBy(name="fromDate")
WebElement txtFromDate;

@FindBy(name="toDate")
WebElement txtToDate;

@FindBy(xpath="//*[@id='reorigNacha']//table//tbody//tr[2]//td[1]//input[2]")
WebElement radioDateRangePaymentRemitOnlySummary;

@FindBy(xpath="//input[@value='vcpReport']")
WebElement radioVcpPayements;

@FindBy(xpath="//input[@value='asReport']")
WebElement radioAccountingSummary;

@FindBy(xpath="//input[@value='billingServiceEnrollmentReport']")
WebElement radioBillingServiceEnrollment;

@FindBy(xpath="//input[@value='reorignNachaReport']")
WebElement radioReorgNacha;

@FindBy(xpath="//input[@value='orgAdrChgReport']")
WebElement radioOrgAddressChangeReport;

@FindBy(name="tin")
WebElement txtTin;

@FindBy(name="btnViewReport")
WebElement btnViewReport;

@FindBy(name="Save As Excel")
WebElement btnSaveAsExcel;

@FindBy(name="New Report")
WebElement btnNewReport;

@FindBy(name="Print Report")
WebElement btnPrintReport;

@FindBy(name="Print")
WebElement btnPrint;

@FindBy(xpath="//input[@value='Contact']")
WebElement radioUserHistory;

@FindBy(xpath="//input[@value='bshistoryReport']")
WebElement radioBSHistory;

@FindBy(linkText="Change Description")
WebElement linkChangeDescription;

@FindBy(id="logOutId")
WebElement lnkLogOut;
@FindBy(linkText="Home")
WebElement linkHome;

@FindBy(xpath="//input[@value='DebitFee']")
WebElement radioCstmTINRtReport;

@FindBy(xpath="//input[@name='fromDate']")
WebElement fromDate;

@FindBy(xpath="//input[@name='toDate]")
WebElement toDate;

private TestBase testConfig;
private RunReports runReports;
int sqlRowNo;

public RunReports(TestBase testConfig)
{
	this.testConfig=testConfig;
	PageFactory.initElements(testConfig.driver, this);
	Element.verifyElementPresent(radioOrgAddressChangeReport, "Organization History radio");
}


public RunReports clickHipaaErrorSummaryReport() {
	 
    Element.clickByJS(testConfig,radioHipaaErrorSummaryReport,"CLick the HipaaErrorSummaryReport");
	return this;
	
}

public RunReports clickPaymentRemitOnlyPaymentSummaryReport() {
	 
    Element.clickByJS(testConfig,radioPaymentRemitOnlySummaryReport,"CLick the PaymentRemitOnlySummaryReportt");
    Element.expectedWait(radioDateRangePaymentRemitOnlySummary, testConfig, "CLick the Date Range PaymentRemitOnlySummaryReport", "radioDateRangePaymentRemitOnlySummary");
    Element.clickByJS(testConfig,radioDateRangePaymentRemitOnlySummary,"CLick the Date Range PaymentRemitOnlySummaryReport");
	return this;
	
}

public RunReports clickPaymentSummaryReport() {
	 
    Element.clickByJS(testConfig,radioPaymentSummaryReport,"CLick the PaymentSummaryReport"); 
	return this;
}

public RunReports clickTransactionSummaryReport() {
	 
    Element.clickByJS(testConfig,radioTransactionSummaryReport,"CLick the TransactionSummaryReport");
	return this;
	
}
public void clickOrgAddressHistoryReport() {
	Element.clickByJS(testConfig, radioOrgAddressChangeReport, "adrress change history radio");
	
}
public RunReports clickOrgUserHistory() {
	Element.clickByJS(testConfig,radioUserHistory,"CLick the OrgUser History");
        return this;
	
}

public RunReports clickBSUserHistory() {
      Element.clickByJS(testConfig,radioBSHistory,"CLick the BS User History");
	
	 return this;
}
public void clickViewReportButton() {
	Element.clickByJS(testConfig,btnViewReport,"CLick the view Report btn");
}
public void clickHome() {
	Element.clickByJS(testConfig,linkHome, "home link clicked");
}
public void validatebtnNewReport() {
	Element.verifyElementPresent( btnNewReport," the New Report btn");

}
public RunReports clickCstmTINRtRprt() {
	 
    Element.clickByJS(testConfig,radioCstmTINRtReport,"Click the TransactionSummaryReport");
    Browser.wait(testConfig, 2);
    Element.click( btnViewReport,"Click the view Report btn");
    return this;
	
}
public void verifyHoverFunctionality() {
	 
	 String portal=System.getProperty("Application");
	 WebElement toolTipHover;
	 List<WebElement> subPayerList=null;
if(portal.equalsIgnoreCase("CSR"))
 { Browser.wait(testConfig, 2);
	Element.mouseHoverByJS(testConfig, txtFromDate, "From Date Hover?");
	toolTipHover=Element.findElement(testConfig, "xpath", "//*[@id='detailpopup']//table//tr//td");
	Helper.compareEquals(testConfig, "Mousehover comparision","Click Here to Pick up the date",  toolTipHover.getText());
    
    Element.mouseHoverByJS(testConfig, txtToDate, "To Date Hover?");   
    toolTipHover=Element.findElement(testConfig, "xpath", "//*[@id='detailpopup']//table//tr//td");
	Helper.compareEquals(testConfig, "Mousehover comparision","Click Here to Pick up the date", toolTipHover.getText());	
	List<WebElement> payerList=Element.findElements(testConfig, "xpath", "//*[@id='selectedPayers']//option");
   for(WebElement payer:payerList)
  {
	
   Element.mouseHoverByJS(testConfig, payer , "payerlist hover"); 
   toolTipHover=Element.findElement(testConfig, "xpath", "//*[@id='detailpopup']//table//tr//td");
  	Helper.compareEquals(testConfig, "Mousehover comparision"+payer.getText(),"CTRL and click on one or multiple of your Payer(s).", toolTipHover.getText().trim());
  }
   WebElement payerLists=Element.findElement(testConfig, "xpath", "//*[@id='selectedPayers']//option[3]");
   Element.click(payerLists, "clicking payer list");
   subPayerList= Element.findElements(testConfig,"xpath","//*[@id='selectedSubPayers']//option");
 }

 for(WebElement subPayer : subPayerList)
  { 	

    Element.mouseHoverByJS(testConfig,subPayer , "subpayerlist hover"); 
    toolTipHover=Element.findElement(testConfig, "xpath", "//*[@id='detailpopup']//table//tr//td");
    Helper.compareEquals(testConfig, "Mousehover comparision"+subPayer.getText(),"CTRL and click on one or multiple of your SubPayer(s).", toolTipHover.getText().trim());
  }
   
 Element.clickByJS(testConfig,lnkLogOut , "logging Out of the portal");
}

public void validateDescriptionLink() {
	 Element.verifyElementPresent(linkChangeDescription, "Description link present?");

	}

public void validatebtnPrint() {
	Element.verifyElementPresent( btnPrintReport," the Print Report btn btn present?");

}

public void validatSaveAsExcelBtn() {
	Element.verifyElementPresent( btnSaveAsExcel," Save as Excel");
}

public void verifyOrgUserHistory() {
	  sqlRowNo=1115; 
	 String d=Helper.getCurrentDate("MM-dd-yyyy");
	d=d.replace('-', '/');
	Element.enterDataByJS(testConfig,txtFromDate ,Helper.getDateBeforeOrAfterDays(-1,"MM/dd/yyyy"), "Enter From date");
	 Element.enterDataByJS(testConfig,txtToDate ,d , "Enter To date  ");
	 Element.enterDataByJS(testConfig,txtTin,testConfig.getRunTimeProperty("tin"), "Enter Tin ");
	 clickViewReportButton();
	 WebElement table=driver.findElement(By.xpath("//*[@id='reportForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr"));
	 if(table == null)
			Log.Fail("No active data available in Database for " +"Please execute the test case manually");
	 else
	         Log.Comment("Data Available");
	 Element.findElement(testConfig, "xpath", "//*[@id='reportForm']//table//tbody//tr[8]//td//table//tbody//tr//td//table/tbody/tr[1]/td[1]/a");
	 Element.clickByJS(testConfig,testConfig.driver.findElement(By.xpath("//*[@id='reportForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr[1]/td[1]/a")),"CLick the desc format link?");
	 Browser.wait(testConfig, 1);
	 testConfig.getRunTimeProperty("tin");
	  Map SearchedData=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	 List< WebElement> reportTable=driver.findElements(By.xpath("//*[@id='reportForm']//table//tbody//tr[8]//td//table//tbody//tr//td//table//tbody//tr"));

	 Helper.compareEquals(testConfig, "First name", SearchedData.get("FST_NM").toString().trim(), reportTable.get(1).findElements(By.tagName("td")).get(4).getText());
	Helper.compareEquals(testConfig, "Last name", SearchedData.get("LST_NM").toString().trim(), reportTable.get(1).findElements(By.tagName("td")).get(5).getText());
	Helper.compareEquals(testConfig, "Email address", SearchedData.get("EMAIL_ADR_TXT").toString().trim(),reportTable.get(1).findElements(By.tagName("td")).get(7).getText()); 
	Helper.compareEquals(testConfig, "mod typ desc", SearchedData.get("MOD_TYP_DESC").toString().trim(), reportTable.get(1).findElements(By.tagName("td")).get(10).getText());
			
		 
}



public void verifyBSUserHistory() {

  sqlRowNo=1117;
   String d=Helper.getCurrentDate("MM-dd-yyyy");
   d=d.replace('-', '/');
   Element.enterDataByJS(testConfig,txtFromDate ,Helper.getDateBeforeOrAfterDays(-1,"MM/dd/yyyy"), "Enter From date");
   Element.enterDataByJS(testConfig,txtToDate ,d , "Enter To date  ");
   Element.enterDataByJS(testConfig,txtTin,testConfig.getRunTimeProperty("tin"), "Enter Tin ");
   clickViewReportButton();
   WebElement table=driver.findElement(By.xpath("//*[@id='reportForm']//table//tbody//tr[8]//td//table//tbody//tr//td//table//tbody//tr"));
   if(table == null)
		Log.Fail("No active data available in Database for " +"Please execute the test case manually");
   else
        Log.Comment("Data Available");
    Element.clickByJS(testConfig, testConfig.driver.findElement(By.xpath("//*[@id='reportForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr[1]/td[1]/a")),"CLick the desc format link?");
     Browser.wait(testConfig, 2);
    List< WebElement> reportTable=driver.findElements(By.xpath("//*[@id='reportForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr"));
    testConfig.getRunTimeProperty("tin");
           Map SearchedData=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
           Helper.compareEquals(testConfig, "First name", SearchedData.get("FST_NM").toString().trim(), reportTable.get(1).findElements(By.tagName("td")).get(3).getText());
		   Helper.compareEquals(testConfig, "Last name", SearchedData.get("LST_NM").toString().trim(), reportTable.get(1).findElements(By.tagName("td")).get(4).getText());
		   Helper.compareEquals(testConfig, "Email address", SearchedData.get("EMAIL_ADR_TXT").toString().trim(), reportTable.get(1).findElements(By.tagName("td")).get(5).getText()); 
		
}




public void enterTinAndDateRangeForOrgUserHistory() {
	   sqlRowNo=1112;
	   Map SearchedDate=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	   String dateTemp=SearchedDate.get("LST_CHG_BY_DTTM").toString().trim().substring(0,10).replace('-', '/');
	   dateTemp=Helper.changeDateFormat(testConfig, dateTemp, "yyyy/mm/dd", "mm/dd/yyyy");
	   testConfig.putRunTimeProperty("tin",SearchedDate.get("PROV_TIN_NBR").toString().trim());
	   Element.enterDataByJS(testConfig, txtFromDate, dateTemp, "Enter From date");
	   Element.enterDataByJS(testConfig,txtToDate , dateTemp , "Enter To date");
	   Element.enterDataByJS(testConfig ,txtTin,SearchedDate.get("PROV_TIN_NBR").toString().trim(), "Enter Tin ");
       clickViewReportButton();
	   WebElement table=driver.findElement(By.xpath("//*[@id='reportForm']//table//tbody//tr[8]//td//table//tbody//tr//td//table//tbody//tr"));
	   if(table == null)
		 Log.Fail("No active data available in Database for " +"Please execute the test case manually");
	  else
		Log.Comment("Data Available");
	
}



public void enterTinAndDateRangeForBSUserHistory() {
	sqlRowNo=1113;
	 Map SearchedDate=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	 String dateTemp=SearchedDate.get("LST_CHG_BY_DTTM").toString().trim().substring(0,10).replace('-', '/');
	 dateTemp=Helper.changeDateFormat(testConfig, dateTemp, "yyyy/mm/dd", "mm/dd/yyyy");
	 testConfig.putRunTimeProperty("identifier_number",SearchedDate.get("IDENTIFIER_NBR").toString().trim());
	 Element.enterDataByJS(testConfig,txtFromDate , dateTemp , "Enter From date");
	 Element.enterDataByJS(testConfig,txtToDate , dateTemp , "Enter To date  ");
	 Element.enterDataByJS(testConfig,txtTin,SearchedDate.get("IDENTIFIER_NBR").toString().trim() , "Enter Tin FOR BS ");  
	 clickViewReportButton();
	 WebElement table=driver.findElement(By.xpath("//*[@id='reportForm']//table//tbody//tr[8]//td//table//tbody//tr//td//table//tbody//tr"));
	 if(table == null)
		Log.Fail("No active data available in Database for " +"Please execute the test case manually");
	 else
	    Log.Comment("Data Available");
	
}


public RunReports validateSortColumn() throws IOException{
	

	List <String> sortedDBColumn=new ArrayList<String>();
	List <String> storedUIColumn=new ArrayList<String>();
	int sqlNo=1628;
	//j=6 represents six columns for ORG_NM,RATE_PCT,RATE_SUB_LEVEL,LST_CHG_BY_DTTM,LST_CHG_BY_ID,REASON
	for (int j=0;j<6;j++)
	{
		
		List<WebElement> uIList=Element.findElements(testConfig, "xpath", "//form[@id='reportForm']/table/tbody/tr[6]/td/table/tbody/tr/td/table/tbody/tr");
		WebElement header=Element.findElement(testConfig, "xpath", "//form[@id='reportForm']/table/tbody/tr[6]/td/table/tbody/tr/td/table/tbody/tr[1]/td["+(j+1)+"]/a");
		Element.waitForElementTobeClickAble(testConfig, header, 60);
		Element.clickByJS(testConfig, header, "Header link");
			Browser.wait(testConfig, 2);
		
		for (int i=1;i<uIList.size();i++)
		{
			WebElement uiColumn=Element.findElement(testConfig,"xpath","//form[@id='reportForm']/table/tbody/tr[6]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]");
			storedUIColumn.add(uiColumn.getText());

		}
		if (j==1||j==3||j==5)
		{
			if (j==1)
			{	
			testConfig.putRunTimeProperty("bysortColumn", "RATE_SUB_LEVEL");
			testConfig.putRunTimeProperty("byslctColumn", "RATE_SUB_LEVEL");}
			if (j==3)	
			{
			testConfig.putRunTimeProperty("bysortColumn", "LST_CHG_BY_DTTM");
			testConfig.putRunTimeProperty("byslctColumn", "LST_CHG_BY_DTTM");}

			if (j==5){	
			testConfig.putRunTimeProperty("bysortColumn", "REASON");
			testConfig.putRunTimeProperty("byslctColumn", "PAY_PROC_ACPT_CD_VAL_DESC ASC,REAS_DESC");}

			
		testConfig.putRunTimeProperty("ascdesc", "ASC");
		}
		else
		{
			if (j==0){
			testConfig.putRunTimeProperty("bysortColumn", "ORG_NM");
			testConfig.putRunTimeProperty("byslctColumn", "ORG_NM");}

			if (j==2){	
			testConfig.putRunTimeProperty("bysortColumn", "RATE_PCT");
			testConfig.putRunTimeProperty("byslctColumn", "RATE_PCT");}

			if (j==4){	
			testConfig.putRunTimeProperty("bysortColumn", "LST_CHG_BY_ID");
			testConfig.putRunTimeProperty("byslctColumn", "LST_CHG_BY_ID");}

		testConfig.putRunTimeProperty("ascdesc", "DESC");
		}
		HashMap<Integer, HashMap<String, String>> ColumnName = DataBase.executeSelectQueryALL(testConfig,sqlNo);
		for(Integer tmp : ColumnName.keySet()){
			sortedDBColumn.add(ColumnName.get(tmp).get(testConfig.getRunTimeProperty("bysortColumn")).toString().trim());
		}
		Helper.compareEquals(testConfig, "Sorted Column", sortedDBColumn, storedUIColumn);
		sortedDBColumn.clear();
		storedUIColumn.clear();
	}
	return this;
}
public void enterDateRangeasCurrentAndTinForOrgUserHistory()
{      	   
	   String query=QUERY.GET_LAST_UPDATED_DATE;
	   Map SearchedDate=DataBase.executeSelectQuery(testConfig,query, 1);
	   String dateTemp=SearchedDate.get("LST_CHG_BY_DTTM").toString().trim().substring(0,10).replace('-', '/');
	   dateTemp=Helper.changeDateFormat(testConfig, dateTemp, "yyyy/mm/dd", "mm/dd/yyyy");
	   Element.enterDataByJS(testConfig,txtFromDate , dateTemp , "Enter From date");
	   Element.enterDataByJS(testConfig,txtToDate , dateTemp , "Enter To date  ");
	   Element.enterDataByJS(testConfig ,txtTin,testConfig.getRunTimeProperty("tin").toString().trim(), "Enter Tin ");
       clickViewReportButton();
}
public void checkChangeDescForFraud()
{
	String query=QUERY.MOD_TYP_CD_PUHISTORY;
	Map searchedData = DataBase.executeSelectQuery(testConfig, query, 1);
	List< WebElement> reportTable=driver.findElements(By.xpath("//form[@id='reportForm']//table//tbody//tr[8]//td//tr//td//tr"));
	Helper.compareEquals(testConfig, "mod typ desc", searchedData.get("MOD_TYP_DESC").toString().trim(), reportTable.get(1).findElements(By.tagName("td")).get(10).getText());
	
}
}
