package main.java.reporting;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public  class Log extends ExtentTestManager {
		
	 static  ExtentReports report;
	static ExtentHtmlReporter htmlReporter;
	
	
	private  static TestBase testConfig;
	static boolean showInHtmlReport=false;
	
	//static boolean testAlreadyFailed=true;
	
	public Log(TestBase testConfig)
	{
		this.testConfig=testConfig;
	}
	
	public Log()
	{
		
	}

	public static void startTest(ITestNGMethod  method)
	{
		
	}
	
	   
	/*public static void setReportingConfig()
	{
		report=new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReportResults.html");
		htmlReporter.config().setReportName("Automation Report");
		report.attachReporter(htmlReporter);
	}*/
	
	
	/*public static void endTest(ITestResult result)
	{
	    if(result.getStatus() == ITestResult.FAILURE) 
		  Log.Fail(result);
	    else if(result.getStatus() == ITestResult.SKIP)
	    	Log.skipped(result);
	    logger.assignCategory(result.getMethod().getGroups());
	   
		report.flush();
	}*/
	
	public synchronized static void flushReport()
	 {
	                report.flush();
	  }

	
	public synchronized static void Fail(ITestResult result) 
	{
			if(testConfig.getRunTimeProperty("AlreadyFailed")!=null)
			{}
			else
			PageInfo(testConfig, "Failed due to unknown exception : " + result.getThrowable());
	}
	
	public synchronized static void skipped(ITestResult result) 
	{
		 ExtentTestManager.getTest().skip(result.getThrowable());

	}
	
	
	public synchronized static void skipped(String result) 
	{
		 ExtentTestManager.getTest().skip(result);

	}
	
	

	
	public  synchronized static void Comment(String message,String color)
	 {
			/* syso to display message on
			 screen by calling printToScreen function */
			printToScreen(message);
			
			//This message will be displayed in HTML reports 
			if(ExtentTestManager.getTest()!=null)
			ExtentTestManager.getTest().info(message);
				
	}
			
	//Overloaded Comment Method for passing color internally
	public synchronized static void Comment(String message)
	 {
			//System.setProperty("org.uncommons.reportng.escape-output", "false");
			Comment(message, "Black");
	}
		
		
	public synchronized static void Fail(String message) 
		{
		
			failure(message);

		}
		
    public synchronized static void failure(String message)
	 {
			//testConfig.putRunTimeProperty("AlreadyFailed","yes");
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
					  String dest=captureScreenshot(testConfig);
                      ExtentTestManager.getTest().addScreenCaptureFromPath(dest).fail(message);
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
				else 
				{
					Log.Comment("Driver is null in Page info method, so unable to take screenshot", "Red");
					 ExtentTestManager.getTest().fail(message);
				}
			}
		
		
		public synchronized static String captureScreenshot(TestBase testConfig) throws IOException
		{
				File sourceFile = ((TakesScreenshot)testConfig.driver).getScreenshotAs(OutputType.FILE);
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		        String dest = "\\\\nas00912pn\\Apps\\Work\\Priyanka\\p1058\\ErrorScreenshots\\"+"ScreenShot"+timeStamp+".png";
		        File destination = new File(dest);
		        FileUtils.copyFile(sourceFile, destination);              
		        return dest;
		}
		
	
	
				

		
		private  synchronized static void printToScreen(String message)
		{
			System.out.println(message);
		}
		
		
		
		public synchronized static void Pass(String message)
		{
			printToScreen(message);
			ExtentTestManager.getTest().pass(message);
			
		}
		

		public synchronized static void Warning(String message, TestBase testConfig)
		{  
			printToScreen(message);
			 ExtentTestManager.getTest().warning(message);
		}
		
		public static void FailWarning(String message, TestBase testConfig)
		{  
			printToScreen(message);
			ExtentTestManager.getTest().warning(message);
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
	
	public synchronized static void Pass (TestBase testConfig, String what, Object expected, Object actual)
	{
		
		Pass("Passed comparison of"+ " " + what + '\n' +"Expected was :" + " " +  expected + " " + '\n' + "Actual is :" + " " + actual);
		
	}

//	public void logWarning(String message) {
//		logger.warning(message);	
//		
//	}


	public static void Comment(String message, TestBase testConfig) {

		
        printToScreen(message);
		
		//For giving color to message using html font tag
		
		
		if (!showInHtmlReport)
		{
			message = "<font color='"  + "'>" + message + "</font></br>";
		}
		
		//This message will be displayed in HTML reports 
		ExtentTestManager.getTest().info(message);
		
	}
	
	
	private static void addScreenshotMsgForPass(TestBase testConfig,String message)
	  {
	      MediaEntityModelProvider mediaModel;
	       try {
	            mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(testConfig)).build();
	            ExtentTestManager.getTest().pass(message, mediaModel);
	            }
        catch (IOException e1) 
	       {
	         e1.printStackTrace();
	       }
	    }

	
	public synchronized static void passWithScreenshot(String message)
	{
		printToScreen(message);
		addScreenshotMsgForPass(testConfig,message);
		
	}
		
	
}

