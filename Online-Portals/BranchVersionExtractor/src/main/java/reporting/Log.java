package main.java.reporting;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import main.java.nativeFunctions.TestBase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public  class Log  {
		
	static com.aventstack.extentreports.ExtentReports report;
	static ExtentHtmlReporter htmlReporter;
	static com.aventstack.extentreports.ExtentTest logger;
	
	private  static TestBase testConfig;
	static boolean showInHtmlReport=false;
	
	//static boolean testAlreadyFailed=true;
	
	public Log(TestBase testConfig,String testCaseName,String desc,String author)
	{
		this.testConfig=testConfig;
		logger=report.createTest(testCaseName,desc);
		 logger.assignAuthor(author);
	}
	

	public static void startTest(ITestNGMethod  method)
	{
		
	}
	
	   
	public static void setReportingConfig()
	{
		report=new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReportResults.html");
		htmlReporter.config().setReportName("Automation Report");
		report.attachReporter(htmlReporter);
	}
	
	
	public static void endTest(ITestResult result)
	{
	    if(result.getStatus() == ITestResult.FAILURE) 
		  Log.Fail(result);
	    else if(result.getStatus() == ITestResult.SKIP)
	    	Log.skipped(result);
	    logger.assignCategory(result.getMethod().getGroups());
	   
		report.flush();
	}
	
	public static void Fail(ITestResult result) 
	{
//		if(testConfig.getRunTimeProperty("AlreadyFailed").equalsIgnoreCase("no"))
		PageInfo(testConfig, "Failed due to unknown exception : " + result.getThrowable());

	}
	
	public static void skipped(ITestResult result) 
	{
		logger.skip(result.getThrowable());

	}
	
	
	public static void Comment(String message,String color)
	 {
			/* syso to display message on
			 screen by calling printToScreen function */
			printToScreen(message);
			
			//This message will be displayed in HTML reports 
			logger.info(message);
				
	}
			
	//Overloaded Comment Method for passing color internally
	public static void Comment(String message)
	 {
			//System.setProperty("org.uncommons.reportng.escape-output", "false");
			Comment(message, "Black");
	}
		
		
	public static void Fail(String message) 
		{
		
			failure(message);

		}
		
    public static void failure(String message)
	 {
			testConfig.putRunTimeProperty("AlreadyFailed","yes");
			//For displaying in console
			printToScreen(message);
			PageInfo(testConfig,message);
			Assert.fail(message);
					
	 }
    
    public static void Softfailure(String message)
	 {
			SoftAssert softAsert=new SoftAssert();
			softAsert.fail(message);
						
	 }
		
		
		private static void PageInfo(TestBase testConfig,String message) 
		{
				if (testConfig.driver != null)
				{
					try 
					{
//					  Browser.wait(testConfig, 3);
					  String dest=captureScreenshot(testConfig);
					  logger.addScreenCaptureFromPath(dest);
					  logger.fail(message);
					} 
					catch (IOException e) 
					{
						
						e.printStackTrace();
					}
				}
				else 
				{
					Log.Comment("Driver is null in Page info method, so unable to take screenshot", "Red");
				}
			}
		
		
		public static String captureScreenshot(TestBase testConfig) throws IOException
		{
				File sourceFile = ((TakesScreenshot)testConfig.driver).getScreenshotAs(OutputType.FILE);
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		        
		        String dest = "\\\\nas00912pn\\Apps\\Work\\Priyanka\\p1058\\ErrorScreenshots\\"+"ScreenShot"+timeStamp+".png";
		        File destination = new File(dest);
		        FileUtils.copyFile(sourceFile, destination);              
		        return dest;
		}
				

		
		private static void printToScreen(String message)
		{
			System.out.println(message);
		}
		
		
		
		public static void Pass(String message)
		{
			printToScreen(message);
			logger.pass(message);
		}
		
		
		public static void Warning(String message, TestBase testConfig)
		{  
			printToScreen(message);
			logger.warning(message);
		}
		
		public static void FailWarning(String message, TestBase testConfig)
		{  
			printToScreen(message);
			logger.warning(message);
			Softfailure(message);
		}


		public static void Fail(String what, String expected, String actual) {
			
			Fail("Failed comparison of"+ " " + what + '\n' +"Expected was :" + " " +  expected + " " + '\n' + "Actual is :" + " " + actual);
			
		}
		
	public static void Pass(String what, String expected, String actual) {
		
		    Pass("Passed comparison of "+ " " + what + '\n' +"Expected was :" + " "  + expected + " " + '\n' + "Actual is :" + " " + actual);	
			
		}

	
	
	public static void Fail (TestBase testConfig, String what, Object expected, Object actual)
	{
		
		Fail("Failed comparison of"+ " " + what + '\n' +"Expected was :" + " " +  expected + " " + '\n' + "Actual is :" + " " + actual);
		
	}
	
	public static void Pass (TestBase testConfig, String what, Object expected, Object actual)
	{
		
		Pass("Passed comparison of"+ " " + what + '\n' +"Expected was :" + " " +  expected + " " + '\n' + "Actual is :" + " " + actual);
		
	}

	public void logWarning(String message) {
		logger.warning(message);	
		
	}


	public static void Comment(String message, TestBase testConfig) {

		
        printToScreen(message);
		
		//For giving color to message using html font tag
		
		
		if (!showInHtmlReport)
		{
			message = "<font color='"  + "'>" + message + "</font></br>";
		}
		
		//This message will be displayed in HTML reports 
		logger.info(message);
		
	}
		
	
}

