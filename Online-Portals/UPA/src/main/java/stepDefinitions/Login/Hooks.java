package main.java.stepDefinitions.Login;

import java.sql.SQLException;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.*;
import main.java.reporting.Log;

public class Hooks extends TestBase{
	
	
	@Before
	public void BeforeScenario(Scenario scn)
	{
		setupTestMethod(scn);
		initializeData();
	}

	@After
	public void afterhook(Scenario scn) 
	 {
		try {
	     if(scn.isFailed())
	      {
	       scn.write("Browser Type: " + runtimeProperties.getProperty("BrowserType"));
	       scn.write("Execution Environment: " + System.getProperty("env"));
	       final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);	
	       scn.embed(screenshot, "image/png");	
	      }
	    } 
		catch (Exception e) 
		{
	    	Log.Fail("Failed to capture screenshot due to exception : " + e);
	    }
        if(!scn.getName().contains("API")) {
		if(System.getProperty("Application").contains("UPA") && "true".equals(testConfig.getRunTimeProperty("associationDone"))){
			
			int sqlRowNo=1911;
			if("BS".equals(testConfig.getRunTimeProperty("userType"))){
				DataBase.executeDeleteQuery(testConfig, sqlRowNo);
				sqlRowNo=1512;
				DataBase.executeDeleteQuery(testConfig, sqlRowNo);
			}
			else if("PROV".equals(testConfig.getRunTimeProperty("userType"))){
				sqlRowNo=1921;
				DataBase.executeDeleteQuery(testConfig, sqlRowNo);
			}
		}
		}
        tearDown();
		//endTest(scn);
	 }
	
}
