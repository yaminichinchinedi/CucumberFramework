package main.java.reporting;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public  class Log  {
		
	public static ExtentReports report;
	public static ExtentTest logger;
	private  static TestBase testConfig;
	static boolean showInHtmlReport=false;
	
	public Log(TestBase testConfig,String testCaseName)
	{
		logger=report.startTest(testCaseName);
		this.testConfig=testConfig;
	}

	   
	@SuppressWarnings("deprecation")
	public static void setReportingConfig()
	{
		report= new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReportResults.html", true);
		report.loadConfig(new File (System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
	}
	
	
	public static void endTest(String testCaseDesc)
	{
		
		logger.setDescription(testCaseDesc);
		report.endTest(logger);
		report.flush();
	}
	public static void Comment(String message,String color)
	 {
			/* syso to display message on
			 screen by calling printToScreen function */
			printToScreen(message);
			
			//This message will be displayed in HTML reports 
			logger.log(LogStatus.INFO, message);	
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
			
			String ReportMessage="";
			//For displaying in console
			printToScreen(message);
			PageInfo(testConfig,message);
			Assert.fail(message);
					
		}
		
		
		private static void PageInfo(TestBase testConfig,String message) 
		{
				if (testConfig.driver != null)
				{
					try 
					{
					  String dest=captureScreenshot(testConfig);
					  logger.log(LogStatus.FAIL, message  + logger.addScreenCapture(dest));
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
		        String dest = System.getProperty("user.dir") +"\\ExtentReports\\"+"ScreenShot"+timeStamp+".png";
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
			logger.log(LogStatus.PASS, message);
		}
		
		
		public static void Warning(String message, TestBase testConfig)
		{  
			printToScreen(message);
			logger.log(LogStatus.WARNING, message);
			testConfig.testLog = testConfig.testLog.concat(message);
		}


		public static void Fail(String what, String expected, String actual) {
			
			Fail("Failed comparison of"+ " " + what + '\n' +"Expected was :" + " " +  expected + " " + '\n' + "Actual is :" + " " + actual);
			
		}
		
	public static void Pass(String what, String expected, String actual) {
		
		    Pass("Passed comparison of "+ " " + what + '\n' +"Expected was :" + " "  + expected + " " + '\n' + "Actual is :" + " " + actual);	
			
		}


	public void logWarning(String message) {
		logger.log(LogStatus.WARNING, message);
		
		
	}


	public static void Comment(String message, TestBase testConfig) {

		
        printToScreen(message);
		
		//For giving color to message using html font tag
		
		
		if (!showInHtmlReport)
		{
			message = "<font color='"  + "'>" + message + "</font></br>";
		}
		
		//This message will be displayed in HTML reports 
		logger.log(LogStatus.INFO, message);
		
	}
		
	
}

