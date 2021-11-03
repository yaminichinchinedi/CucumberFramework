package main.java.pageObjects;


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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
















import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
 














import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class SelectReportsPage {

	private TestBase testConfig;
	
	@FindBy(id="reportName")
	WebElement RprtDropdown;
	
	@FindBy(xpath="//div[@id='report_typ']/label")
	WebElement txtSelectRprt;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement sbmtButtn;
	
	@FindBy(xpath = "//img[@alt='previous month']")
	WebElement btnPreviousMonth;
	
	@FindBy(xpath = "//img[@alt='next month']")
	WebElement btnNextMonth;
	
	@FindBy(xpath = "//img[@alt='previous year']")
	WebElement btnPreviousYear;
	
	@FindBy(xpath = "//img[@alt='next year']")
	WebElement btnNxtYear;
	
	@FindBy(xpath = "//table//table//table//tr//font")
	WebElement monthYearInCal;
	
	
	WebElement dopFrom=null;
	WebElement dopTo=null;
	
public SelectReportsPage(TestBase testConfig)
{
	this.testConfig=testConfig;
	PageFactory.initElements(testConfig.driver, this);
	Element.expectedWait(txtSelectRprt, testConfig, "Select Reports text", "txtSelectRprt");
	Browser.verifyURL(testConfig, "epsExcelReports");
}

public void clickDropdown(){
	
	Element.selectByVisibleText(RprtDropdown, "Enrollment Survey Results", "Enrollment Survey Results option");
}

public void verifyDateButton(){
	
	
	Helper.compareContains(testConfig, "From and To Date text", Element.findElement(testConfig, "xpath", "//*[contains(text(),'Date Range: From:')]").getText(), "Date Range: From: To:");	
	
	List <WebElement> calenders=Element.findElements(testConfig, "xpath", "//div[@id='date_range']/a/img");
	if (calenders.size()==2)
	Log.Pass("From and To Calenders icon present on webpage");	
	else
	Log.Fail("From and To Calenders icon not present on webpage");
		
}

public void verifySubmitButton(){
	
	
	Element.verifyElementPresent(sbmtButtn, "Submit Button");
	}

public void clickSubmit(){
	sbmtButtn.click();
	WebElement errorMsg=Element.findElement(testConfig, "xpath", "//span[@id='error']");
	Element.verifyTextPresent(errorMsg, "Please Provide FromDate and ToDate");
	Helper.compareEquals(testConfig, "Verify Red color is highlighted " , "#ff0000", Color.fromString(errorMsg.getCssValue("color")).asHex());
}

//Synchronization method to wait for page status to reach ready state
public void waitForPageLoad(WebDriver driver) {
JavascriptExecutor js = (JavascriptExecutor)driver;
for (int i =0;i<60; i++) {
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
}
//To check if page is in ready state.
if (js.executeScript("return document.readyState").toString().equals("complete")) {
break;
}
}
}

//Method to switch between windows using window handlers for windows currently active in explorer 
public void funSwitchWin(String fValue) throws InterruptedException 
{
waitForPageLoad(testConfig.driver);
try{
for (String Handle : testConfig.driver.getWindowHandles())
{
  	System.out.println(testConfig.driver.switchTo().window(Handle).getTitle());
  	String Title = testConfig.driver.switchTo().window(Handle).getTitle();
  	if(Title.equalsIgnoreCase(fValue))
  	{
  		testConfig.driver.switchTo().window(Handle);
  	System.out.println("TestInfo : Successfully Switched to Window - " + Title);
  	Assert.assertTrue(true);
  	break;
  	}
}     
  }
catch (Exception e) 
{
System.out.println("Exception from Switch window method - " + e);
}	
}


	public void validtErrMsgNoData() throws IOException
	{
		Browser.wait(testConfig, 5);
		//String actual1=Element.findElement(testConfig, "xpath", "//tr[@class='errors']/td/li/font").getText();
		//WebElement actual12=Element.findElement(testConfig, "css", "html body div#contentId table tbody tr td div.report_content form div#errors table tbody tr.errors td li font.errors");
		String actual=Element.findElement(testConfig, "xpath", "//font[contains(text(),'Your Search Return No Data.')]").getText();
		//String actual=actual12.getAttribute("value");
		String expected="Your Search Return No Data.";
		Helper.compareEquals(testConfig, "Error msg comparision", expected, actual);
	}

public void validtSurveyResponseFile(String inpTyp) throws IOException{
	
	String fromDate=null;
	String toDate=null;
	if (inpTyp.equals("Random")){
	
	 fromDate = Helper.getDateBeforeOrAfterDays(-3,"MM/dd/yyyy");
	 toDate = Helper.getCurrentDate("MM/dd/yyyy");//Todays date
	}
	
	else if (inpTyp.equals("today")){
		
		 fromDate = Helper.getCurrentDate("MM/dd/yyyy");//Todays date
		 toDate = Helper.getCurrentDate("MM/dd/yyyy");//Todays date
		}
	else if (inpTyp.equals("1 Month")){
		
		 fromDate = Helper.getDateBeforeOrAfterDays(-30,"MM/dd/yyyy");
		 toDate = Helper.getCurrentDate("MM/dd/yyyy");//Todays date
		}
	else if (inpTyp.equals("12 Months")){
		
		 fromDate = Helper.getDateBeforeOrAfterDays(-360,"MM/dd/yyyy");
		 toDate = Helper.getCurrentDate("MM/dd/yyyy");//Todays date
		}
	else if (inpTyp.equals("13 Months")){
		
		 fromDate = Helper.getDateBeforeOrAfterDays(-390,"MM/dd/yyyy");
		 toDate = Helper.getCurrentDate("MM/dd/yyyy");//Todays date
		}
	WebElement fromDt=Element.findElement(testConfig, "id", "fromDate");
	WebElement toDt=Element.findElement(testConfig, "id", "toDate");
	
	Element.enterData(fromDt, fromDate, "From Date","Date field FromDate");
	Browser.wait(testConfig, 2);
	Element.enterData(toDt, toDate, "To Date","Date field ToDate");
	Browser.wait(testConfig, 2);
	
	sbmtButtn.click();
	Browser.wait(testConfig, 10);
	
	System.out.println("**************************************"+Element.findElements(testConfig, "xpath", "//font[text()='Your Search Return No Data.']").size());
	if((Element.findElements(testConfig, "xpath", "//font[text()='Your Search Return No Data.']").size()==0)) {	
		
	
	//String downloadFilepath = System.getProperty("user.dir") + "\\Downloads";
	String downloadFilepath = System.getProperty("user.dir")+testConfig.getRunTimeProperty("Dwnldfloderpath");
	
	File fileDirectory=new File(downloadFilepath);
	fileDirectory.getAbsolutePath();
	Helper.purgeDirectory(fileDirectory);
	try{
	Robot robot= new Robot();
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

		  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//Set the String to Enter
		  
		  //StringSelection stringSelection = new StringSelection("C:\\Users\\rkrish38\\Documents\\EmployeeServey_1.xls");
		  StringSelection stringSelection = new StringSelection(fileDirectory+"\\EmployeeServey_1.xls");
		//Copy the String to Clipboard
		  clipboard.setContents(stringSelection, null);
		  Browser.wait(testConfig, 5);
		//Use Robot class instance to simulate CTRL+C and CTRL+V key events :
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		//Simulate Enter key event
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
//	Browser.wait(testConfig, 35);
//	int rowNo=1;
//	testConfig.cacheTestDataReaderObject("Enrollment Survey", downloadFilepath+"\\EmployeeServey_1.xlsx");
//	//getting the value from excel file
//	 TestDataReader data =testConfig.getCachedTestDataReaderObject("Enrollment Survey", downloadFilepath+"\\EmployeeServey_1.xlsx");
//	 String responseid=data.GetData(rowNo, "Response ID");
//	 System.out.println("Value of Response Id is:"+responseid);
	
	Browser.wait(testConfig, 20);
	String downloadFullFile=fileDirectory+"\\EmployeeServey_1.xls";
	String sheetName="Enrollment Survey";
	 testConfig.cacheTestDataReaderObject(testConfig,sheetName,downloadFullFile);
	}
	
}

public void enterDateswithNoData(){
	
	String fromDate = "04/05/2020";
	String  toDate = "04/05/2020";
	 
	WebElement fromDt=Element.findElement(testConfig, "id", "fromDate");
	WebElement toDt=Element.findElement(testConfig, "id", "toDate");
	
	Element.enterData(fromDt, fromDate, "From Date","Date field FromDate");
	Browser.wait(testConfig, 2);
	Element.enterData(toDt, toDate, "To Date","Date field ToDate");
	Browser.wait(testConfig, 2);
	
	sbmtButtn.click();
}

public void enterInvalidDates(String msgTyp){
	String todaysDate = Helper.getCurrentDate("MM/dd/yyyy");
	WebElement fromDt=Element.findElement(testConfig, "id", "fromDate");
	WebElement toDt=Element.findElement(testConfig, "id", "toDate");
	
	if (msgTyp.equals("EndDtmoreTodayDt"))
	{
	String fromDate = Helper.getDateBeforeOrAfterDays(-5,"MM/dd/yyyy");
	String toDate = Helper.getDateBeforeOrAfterDays(3,"MM/dd/yyyy");//Todate greater than todays date
	
	Element.enterData(fromDt, fromDate, "From Date","Date field FromDate");
	Browser.wait(testConfig, 2);
	Element.enterData(toDt, toDate, "To Date","Date field ToDate");
	Browser.wait(testConfig, 2);
	
	sbmtButtn.click();
	
	String expected="Please Check End date,It Should not be more than today's Date";
	String actual=Element.findElement(testConfig, "css", "span#error").getText();
	Helper.compareEquals(testConfig, "Error message comparision", expected, actual);
	}
	
	if (msgTyp.equals("ToDtmoreFromDt"))
	{
	String fromDate2 = Helper.getDateBeforeOrAfterDays(-3,"MM/dd/yyyy");
	String toDate2 = Helper.getDateBeforeOrAfterDays(-4,"MM/dd/yyyy");//Todate greater than todays date
	
	
	Element.clearData(fromDt, "Date field FromDate ");
	Element.clearData(toDt, "Date field ToDate ");
	Browser.wait(testConfig, 2);
	Element.enterData(fromDt, fromDate2, "From Date","Date field FromDate");
	Browser.wait(testConfig, 2);
	Element.enterData(toDt, toDate2, "To Date","Date field ToDate");
	Browser.wait(testConfig, 2);
	sbmtButtn.click();
	
	String expectedmsg="Please Check From date and TO date. From date can't Exceed to date";
	String actualmsg=Element.findElement(testConfig, "css", "span#error").getText();
	Helper.compareEquals(testConfig, "Error message comparision for from date greater tah ToDate", expectedmsg, actualmsg);
	}
}
public void clickCalender(){
	
	String toDateDos = Helper.getCurrentDate("MM/dd/yyyy");
	String fromDateDos = Helper.getDateBeforeOrAfterDays(-30,"MM/dd/yyyy");
	
	
	dopFrom=Element.findElement(testConfig, "xpath", "//div[@id='date_range']/a");
	//dopTo=Element.findElement(testConfig, "xpath", "//div[@id='date_range']/a/img[2]");
	
	
	
	clickFromDateIcon().setDate(fromDateDos);//.clickToDateIcon().setDate(toDateDos);
	sbmtButtn.click();
}

public SelectReportsPage clickFromDateIcon()
{
		Element.expectedWait(dopFrom, testConfig, "Clicked calendar", "Calendar");
    	//Element.clickByJS(testConfig, dopFrom, "From date calendar");
    	Actions seriesOfAct=new Actions(testConfig.driver);
		seriesOfAct.moveToElement(dopFrom).click().build().perform();
		Browser.wait(testConfig, 6);	
		String parentwindowhandle=testConfig.driver.getWindowHandle();
		System.out.println("No of window handles:"+testConfig.driver.getWindowHandles().size());
		
		for (String winHandle : testConfig.driver.getWindowHandles())
		{
			System.out.println("Window handle id are:"+winHandle);
				
				Browser.wait(testConfig, 2);
				
				if (!winHandle.equals(parentwindowhandle))
				{
					testConfig.driver.switchTo().window(winHandle);
					Browser.wait(testConfig, 2);
					System.out.println("Switched to window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
				}
		}
		
	return this;
}

//public SelectReportsPage clickToDateIcon()
//{
//	
//		Element.expectedWait(dopTo, testConfig, "Calendar Present", "calendar");
//    	Element.clickByJS(testConfig,dopTo, "To date calendar");
//		Browser.wait(testConfig, 2);	 
//	return this;
//}

public SelectReportsPage setDate(String date)
{
	String parentwindowhandle=testConfig.driver.getWindowHandle();
	System.out.println("No of handles:"+testConfig.driver.getWindowHandles().size());
//	try {
//		funSwitchWin("Select Date, Please.");
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	Browser.switchToNewWindow(testConfig);
	selectDate(testConfig,date);
	Browser.switchToParentWindow(testConfig,parentwindowhandle);
	return this;
	
//	for(int i =0;i<3;i++){
//		if(!(Browser.getNoOfWindowHandles(testConfig)<2))
//			break;
//		else
//			clickFromDateIcon();			   
//	}
//	//Browser.wait(testConfig, 8);
//	String oldWindow=Browser.switchToNewWindow(testConfig, "/calendar.html");
//	selectDate(testConfig,date);
//	Browser.switchToParentWindow(testConfig,oldWindow);
//	return this;
	
	
}


public SelectReportsPage selectDate(TestBase testConfig, String requiredDate)
{
    String curr[] = Helper.getCurrentDate("MM/dd/yyyy").split("/");
    String req[] = requiredDate.split("/");

//    int currDate = Integer.parseInt(curr[0]);
    int reqDate = Integer.parseInt(req[1]);
    int currMonth = Integer.parseInt(curr[0]);
    int reqMonth = Integer.parseInt(req[0]);
    int currYr = Integer.parseInt(curr[2]);
    int reqYr = Integer.parseInt(req[2]);
    String date=String.valueOf(reqDate);
    String monthAndYearInCal[]={};

    
    // Select required year
    if (currYr > reqYr){
        for (int i=0;i<(currYr-reqYr);i++){
            //decrease year
        	Element.clickByJS(testConfig,btnPreviousYear, "Previous Year button to go back one year..year is now : " + String.valueOf(currYr-(i+1)));
        	Browser.wait(testConfig,3);
        	monthAndYearInCal=monthYearInCal.getText().split(" ");
        	Helper.compareEquals(testConfig, "Selected Year", monthAndYearInCal[1], String.valueOf(currYr-(i+1)));
        }   
    } else if (currYr < reqYr){
        for (int j=0;j<(reqYr-currYr);j++){
            //increase year
        	Element.clickByJS(testConfig,btnNxtYear, "Next Year button to go ahead one year..year is now : " + String.valueOf(currYr+(j+1)));
        	Browser.wait(testConfig,3);
        	monthAndYearInCal=monthYearInCal.getText().split(" ");
        	Helper.compareEquals(testConfig, "Selected Year", monthAndYearInCal[1], String.valueOf(currYr+(j+1)));
        }
    }

    
    if (currMonth > reqMonth){
        for (int i=0;i<(currMonth-reqMonth);i++){
            //decrease month
        	Element.clickByJS(testConfig,btnPreviousMonth, "Previous month button to go back one month..month is now : " + String.valueOf(currMonth-(i+1)));
        	Browser.wait(testConfig,3);
        	
        }
    } else if (currMonth < reqMonth){
        for (int j=0;j<(reqMonth-currMonth);j++){
            // increase month
        	Element.clickByJS(testConfig,btnNextMonth, "Next month to go ahead one month..month is now : " + String.valueOf(currMonth+(j+1)));
        	Browser.wait(testConfig, 2);
        }
    }
    monthAndYearInCal=monthYearInCal.getText().split(" ");
    Log.Comment("Date to be selected is : " +  testConfig.driver.findElement(By.xpath("//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']")).getText() + monthAndYearInCal[0] + monthAndYearInCal[1] );
    WebElement dateToBeClicked=Element.findElement(testConfig, "xpath", "//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']");
    Element.clickByJS(testConfig, dateToBeClicked, "date to be clicked");
    return this;
}


}