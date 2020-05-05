package main.java.stepDefinitions.Login;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.java.nativeFunctions.*;

public class Hooks extends TestBase{
	
	
	@Before
	public void Beforetest()
	{
		System.out.print("**Before hooks----->");		
	}

	@After
	public void Aftertest()
	{
		System.out.print("**After hooks----->");
		//Closing browser
		testConfig.tearDown();
	}
	
	 @After
	    public void afterhook(Scenario scn) {

	    try {
	    if(scn.isFailed())
	    {
	    scn.write("Browser Type: " + runtimeProperties.getProperty("BrowserType"));
	    scn.write("Execution Environment: " + System.getProperty("env"));
	    final byte[] screenshot = ((TakesScreenshot) testConfig.driver).getScreenshotAs(OutputType.BYTES);	
	    // to embed screen shot to cucumber report :
	    scn.embed(screenshot, "image/png"); // ... and embed it in	
	    }

	    } catch (Exception e) {}

	    }
}
