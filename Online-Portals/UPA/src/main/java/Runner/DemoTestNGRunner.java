package main.java.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 













import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import test.java.TestDetails;
import main.java.Utils.CopyDir;
import main.java.Utils.DataBase;
import main.java.Utils.DataBase.DatabaseType;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.reporting.Log;


@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"main/java/stepDefinitions"},
        monochrome=true,
        plugin = { 
                
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"},
       
        
        
//        "com.cucumber.listener.ExtentCucumberFormatter:"+ "C:/CucumberEditEnrollment/CucumberFramework/Online-Portals/UPA/ExtentReports/ExtentReportResults.html"},
        dryRun=false,
        strict=true,
        tags={"@UPAEditEnr4"}
		)
public class DemoTestNGRunner extends TestBase {
    private TestNGCucumberRunner testNGCucumberRunner;
   

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
    	//this.testConfig
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
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