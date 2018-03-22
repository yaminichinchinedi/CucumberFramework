package main.java.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class CustomReporter extends org.testng.reporters.EmailableReporter{

		  @Override
		  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) 
		  {
		    //Iterating over each suite included in the test
			  System.out.println("chkkkk");
			 
			  super.generateReport(xmlSuites, suites, outputDirectory);
//			  for (ISuite suite : suites)
//			  {
//		      //Following code gets the suite name
//		      String suiteName = suite.getName();
//		      
//		      //Getting the results for the said suite
//		      Map<String, ISuiteResult> suiteResults = suite.getResults();
//		      
//		      for (ISuiteResult sr : suiteResults.values()) 
//		      {
//		        ITestContext tc = sr.getTestContext();
//		        System.out.println("Passed tests for suite '" + suiteName + "' is:" + tc.getPassedTests().getAllResults().size());
//		        System.out.println("Failed tests for suite '" + suiteName + "' is:" +  tc.getFailedTests().getAllResults().size());
//		        System.out.println("Skipped tests for suite '" + suiteName +"' is:" + tc.getSkippedTests().getAllResults().size());
//		      }
//		    }
			  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 // CopyDir.copyReportToSharedFolder();
//			  try {
//				//SendMail.sendEmail();
//			    }
//			  catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
			  
		  }	
		
}