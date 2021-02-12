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
	
@FindBy(xpath="//*[@id='conslEngStatusForm']//table//tbody//tr[2]//td//table//tbody//tr[1]//td//table//tbody//tr//td[2]//span//a//img")
WebElement txtprocessDate;

@FindBy(name="fromDate")
WebElement txtFromDate;

@FindBy(name="toDate")
WebElement txtToDate;

@FindBy(xpath="//*[@id='reorigNacha']//table//tbody//tr[2]//td[1]//input[2]")
WebElement radioDateRangePaymentRemitOnlySummary;

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

private TestBase testConfig;
private RunReports runReports;
int sqlRowNo;

public RunReports(TestBase testConfig)
{
	this.testConfig=testConfig;
	PageFactory.initElements(testConfig.driver, this);
}


public RunReports clickHipaaErrorSummaryReport() {
	 
    Element.clickByJS(testConfig,radioHipaaErrorSummaryReport,"CLick the HipaaErrorSummaryReport");
	return this;
	
}

public RunReports clickPaymentRemitOnlyPaymentSummaryReport() {
	 
    Element.clickByJS(testConfig,radioPaymentRemitOnlySummaryReport,"CLick the PaymentRemitOnlySummaryReportt");
    Browser.wait(testConfig, 1);
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


public void enterTinAndDateRange(String userType) {
	if(userType.equalsIgnoreCase("PROV"))
	{  String tin_fin;
		sqlRowNo=15;//1101;//1109
		   Map SearchedDate=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		   String dateTemp=SearchedDate.get("LST_CHG_BY_DTTM").toString().trim().substring(0,10).replace('-', '/');
		   dateTemp=Helper.changeDateFormat(testConfig, dateTemp, "yyyy/mm/dd", "mm/dd/yyyy");
		   Log.Comment(dateTemp);
		   Log.Comment( SearchedDate.get("PROV_TIN_NBR").toString().trim());
		   tin_fin=SearchedDate.get("PROV_TIN_NBR").toString().trim();
		   testConfig.putRunTimeProperty("tin_fin",tin_fin);
		 
		   Element.enterData(txtFromDate , dateTemp , "Enter From date" ,"fromDate");
		   Element.enterData(txtToDate , dateTemp , "Enter To date  " ,"toDate");
		   Element.enterData(txtTin,tin_fin, "Enter Tin " ,"tin_fin");
	
	       Element.verifyElementPresent( btnViewReport," view Report btn present?");
		   Element.click( btnViewReport,"CLick the view Report btn");
		   WebElement table=driver.findElement(By.xpath("//*[@id=\"reportForm\"]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr"));
		   if(null == table)
			 Log.Fail("No active data available in Database for " +"Please execute the test case manually");
		  else
			Log.Comment("Data Available");
	}
	else
	{
		sqlRowNo=16;//1104
		 Map SearchedDate=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	    String  tin_bs=SearchedDate.get("IDENTIFIER_NBR").toString().trim();
		String biling_id=SearchedDate.get("BILLING_SERVICE_ID").toString().trim();
		//testConfig.putRunTimeProperty("tin_bs",tin_bs);
		//testConfig.putRunTimeProperty("biling_id",biling_id);
		   
		   //sqlRowNo=1103;//1116
		   //Map SearchedData=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		   String dateTemp=SearchedDate.get("CREAT_DTTM").toString().trim().substring(0,10).replace('-', '/');
		   dateTemp=Helper.changeDateFormat(testConfig, dateTemp, "yyyy/mm/dd", "mm/dd/yyyy");
			Log.Comment(dateTemp);
		 
		  Element.enterData(txtFromDate , dateTemp , "Enter From date" ,"fromDate");
		  Element.enterData(txtToDate , dateTemp , "Enter To date  " ,"toDate");
		  Element.enterData(txtTin,tin_bs, "Enter Tin " ,"tin_bs");
		   
		   
				 Element.click(btnViewReport,"CLick the view Report btn");
				 WebElement table=driver.findElement(By.xpath("//*[@id=\"reportForm\"]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr"));
				 if(null == table)
						Log.Fail("No active data available in Database for " +"Please execute the test case manually");
				 else
				         Log.Comment("Data Available");
	}
}
}//class ends
