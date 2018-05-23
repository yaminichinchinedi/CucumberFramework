package main.java.reporting;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;

import java.io.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;

public class LogTemp 

{
	public static TestBase testConfig;
	
   private static Boolean showInHtmlReport = false;
   
     
   public  LogTemp(TestBase testConfig)
   {
	   
	   LogTemp.testConfig=testConfig;
   }
   
	public static void Comment(String message,String color)
	{
		/* syso to display message on
		 screen by calling printToScreen function */
         
		printToScreen(message);
		
		//For giving color to message using html font tag
		
		if (!showInHtmlReport)
		{
			message = "<font color='" + color + "'>" + message + "</font></br>";
		}
		
		//This message will be displayed in HTML reports 
		
		Reporter.log(message);
	
		//Don't know its use currently hence commenting
		//testConfig.testLogTemp = testConfig.testLogTemp.concat(message);
	}
	
	
	//Overloaded Comment Method for passing color internally
	public static void Comment(String message)
	{
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Comment(message, "Black");
	}
	
	
	public static void Fail(String message) 
	{
		//PageInfo(testConfig);
 
		failure(message);
		
	}
	
	public static void failure(String message)
	{	
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String ReportMessage="";
		//For displaying in console
		printToScreen(message);
		
		//For displaying message in Red color in HTML reports
		if (!showInHtmlReport)
		{
			 ReportMessage = "<font color='Red'>" + "Failed" + "" + ":" + " " + message + "</font></br>";
		}
				
		Reporter.log(ReportMessage);
		PageInfo(testConfig);
		
		Assert.fail(message);
				
				
		//testConfig.testLogTemp = testConfig.testLogTemp.concat(message);
		
		// Stop the execution if end execution flag is ON
		//if (testConfig.endExecutionOnfailure)
			//Assert.fail(tempMessage + " --[Ending execution in the middle!]");
	}
	
//	public static void Failfinal(String message, Config testConfig)
//	{
//		try
//		{
//			PageInfo(testConfig);
//		}
//		catch (Exception e)
//		{
//			testConfig.LogTempWarning("Unable to LogTemp page info:- " + ExceptionUtils.getStackTrace(e));
//			//Commenting it to prevent exception being thrown in OnTestFailure method of test listener. Otherwise LogTemps don't appear
//			//throw e;
//		}
//	}
	
	private static void printToScreen(String message)
	{
		System.out.println(message);
	}
	
	private static void PageInfo(TestBase testConfig) 
	{
			if (testConfig.driver != null)
			{
				try 
				{
				  Browser.captureScreenshot(testConfig);
				} 
				catch (IOException e) 
				{
					
					e.printStackTrace();
				}
			}
			else 
			{
				LogTemp.Comment("Driver is null in Page info method, so unable to take screenshot", "Red");
			}
		}
	
	public static void Pass(String message)
	{
		printToScreen(message);
		
		if (!showInHtmlReport)
		{
			message = "<font color='Green'>" + message + "</font></br>";
		}
		
		Reporter.log(message);
		//testConfig.testLogTemp = testConfig.testLogTemp.concat(message);
	}
	
	
	public static void Warning(String message, TestBase testConfig)
	{  
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		if (testConfig.printToScreen)
			printToScreen(message);
		if (!showInHtmlReport)
		{
			message = "<font color='Orange'>" + message + "</font></br>";
		}
		Reporter.log(message);
		
	}


	public static void Comment(String message, TestBase testConfig)
	{
		// TODO Auto-generated method stub
		
        printToScreen(message);
		
		//For giving color to message using html font tag
		
		if (!showInHtmlReport)
		{
			message = "<font color='"  + "'>" + message + "</font></br>";
		}
		
		//This message will be displayed in HTML reports 
		Reporter.log(message);
		
	}


	public static void Fail(String what, String expected, String actual) {
		
        failure("Failed comparison of"+ " " + what + '\n' +"Expected was :" + " " +  expected + " " + '\n' + "Actual is :" + " " + actual);
		
	}
	
public static void Pass(String what, String expected, String actual) {
	
	    Pass("Passed comparison of "+ " " + what + '\n' +"Expected was :" + " "  + expected + " " + '\n' + "Actual is :" + " " + actual);	
		
	}
	
}
