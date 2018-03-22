package main.java.reporting;


import org.junit.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Log {
		
	public ExtentReports report;
	public ExtentTest logger;
	
	@SuppressWarnings("deprecation")
	
//	public Log()
//	{
//	       report=new ExtentReports("C:\\POMFrameWorkDemo.html",false);
//	       report.config().documentTitle("Report title");
//	       logger=report.startTest("start");
//	}
	
	@BeforeClass
	public void startTestReport(String TestCaseName)
	{
		report=new ExtentReports("C:\\POMFrameWorkDemo.html",false);
	    report.config().documentTitle("Report title");
	    logger=report.startTest("start");
	}
	
	public void logPass(String successMsg)
	{
		
		logger.log(LogStatus.PASS, successMsg);
	}
	
	public void logFail(String failureMsg)
	{
		logger.log(LogStatus.FAIL, failureMsg);
	}
	
	public void logWarning(String WarningMsg)
	{
		logger.log(LogStatus.WARNING, WarningMsg);
	}
	
	public void logComment(String Comment)
	{
		logger.log(LogStatus.INFO, Comment);
	}
	
}

