package main.java.reporting;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import main.java.nativeFunctions.TestBase;



public abstract class ReporterClass {

	private static final ExtentReports EXTENT = ExtentManager.getInstance();

    public ExtentTest test, suiteTest;
    public String testCaseName, testDescription, category, authors;

    public synchronized ExtentTest startTestCase(String testName, String desc, String author)
    {
        return ExtentTestManager.createTest(testName,desc).assignAuthor(author);
    }

    
    
  /*  public synchronized static void logReportSteps(ITestResult result)
	{
    	  if(result.getStatus() == ITestResult.FAILURE) 
    		  Log.Fail(result);
    	    else if(result.getStatus() == ITestResult.SKIP)
    	    	Log.skipped(result);
	    ExtentTestManager.getTest().assignCategory(result.getMethod().getGroups());
	}*/
    
    
    public synchronized static void logReportSteps(String result)
   	{
       	  if(result.equalsIgnoreCase("failed")) 
       		  Log.Fail(result);
//       	    else if(result.equalsIgnoreCase("passed"))
//       	    	Log.Pass(result);
//       	    else 
//       	    	Log.skipped(result);
//   	    ExtentTestManager.getTest().assignCategory(result.getMethod().getGroups());
   	}
    public synchronized void endReporting() {
        EXTENT.flush();
    }

 




}



