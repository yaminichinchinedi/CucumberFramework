package main.java.stepDefinitions.Login;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.java.nativeFunctions.*;
import main.java.reporting.Log;

public class Hooks extends TestBase{
	
	
	@Before
	public void BeforeScenario(Scenario scn)
	{
//		System.out.print("**Before hooks----->");		
		setupTestMethod(scn);
	}

	@After
	public void Aftertest()
	{
		testConfig.tearDown();
	}
	
	 @After
	    public void afterhook(Scenario scn) 
	 {
		
		try {
	     if(scn.isFailed())
	      {
	       scn.write("Browser Type: " + runtimeProperties.getProperty("BrowserType"));
	       scn.write("Execution Environment: " + System.getProperty("env"));
	       final byte[] screenshot = ((TakesScreenshot) testConfig.driver).getScreenshotAs(OutputType.BYTES);	
	       scn.embed(screenshot, "image/png");	
	      }
	    } 
		
		catch (Exception e) 
		 {
	    	Log.Fail("Failed to capture screenshot due to exception : " + e);
	     }

	 endTest(scn);
}
}
