package main.java.nativeFunctions;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

import main.java.reporting.Log;


import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

	public static WebDriver driver;
	static String driverPath = "D:\\chromedriver\\";
	
	public static HashMap<Integer, HashMap<String, String>> genericErrors = new HashMap<Integer, HashMap<String, String>>();
	public boolean printToScreen = true;
	public boolean enableScreenshot;
	public String testLog;
	public Connection DBConnection = null;
	protected static volatile TestBase testConfig;
	private static Object mutex = new Object();
	public static String ResultsDir;
	public Method testMethod;
	private static HashMap<String, HashMap<String, String>> loginCredentials;
	private final static String DEFAULT_SAUCE_USER = "pchaud19";
	private final static String DEFAULT_SAUCE_ACCESSKEY = "ddc4d7ea-db56-4a8f-84b2-936339468a87";

	// stores the run time properties (different for every test)

	public Properties runtimeProperties;
	public SoftAssert softAssert;
	public Connection connection = null;

	public TestBase() {

		// Reading Config file

		File file = new File(System.getProperty("user.dir") + "\\ConfigFiles\\Config.properties");
		FileInputStream fileInput = null;
		testLog = "";
		this.softAssert = new SoftAssert();

		// Set the full path of results dir for taking screenshot
		// Need to understand this
		// this.testMethod = method;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		runtimeProperties = new Properties();

		// load properties file
		try {
			runtimeProperties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
       
		
		// Getting Jenkins Parameter
			
		  
		urlHelper(System.getProperty("env"));

		
	}

	
	public void urlHelper(String env) {
		System.out.println("Env from jenkins is " + System.getProperty("env"));
		if (System.getProperty("env") == null) 
			System.setProperty("URL",runtimeProperties.getProperty(runtimeProperties.getProperty("Env")+"_VersionURL"));
		else
			System.setProperty("URL",System.getProperty(System.getProperty(env)+"_VersionURL"));
		
		
		
	}

	public static TestBase getInstance() {

		// TestBase result = testConfig;
		if (testConfig == null) {
			testConfig = new TestBase();
		}
		return testConfig;
	}



	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType)
	{
			DesiredCapabilities caps ;
			switch (browserType) {
			case "chrome":
				driver = initChromeDriver();
				break;			
			default:
			
				driver = initChromeDriver();
			}
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		

	private static WebDriver initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		String downloadFilepath = System.getProperty("user.dir") + "\\Downloads";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("download.default_directory", downloadFilepath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);
		options.setExperimentalOption("useAutomationExtension", false);

		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");

		// WebDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	
	

	

	public void putRunTimeProperty(String key, String value) {
		runtimeProperties.put(key, value);
	}

	@BeforeSuite
	public void setUpReportingConfig() {
		Log.setReportingConfig();

	}
	
	@BeforeClass()
	public void init() {
		initializeData();
	}

	public void initializeData() {
		testConfig = TestBase.getInstance();
		setDriver("chrome");
	}



	public WebDriver SetdriveronSauce(String Browser) {
		
		String URL = "http://" + "pchaud19" + ":" + DEFAULT_SAUCE_ACCESSKEY + "@ondemand.saucelabs.com:80/wd/hub";
		if (Browser.equalsIgnoreCase("IE")) {
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "11.285");
			caps = DesiredCapabilities.internetExplorer();

			caps.setCapability("parent-tunnel", "optumtest");
			caps.setCapability("tunnelIdentifier", "Optum-Stage");
			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		
		}
		else if (Browser.equalsIgnoreCase("chrome")) {
			
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps = DesiredCapabilities.chrome();
			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		
		}

		return driver;
	}
	
	@BeforeMethod()
	public void setupTestMethod(Method method) {
		testConfig.putRunTimeProperty("AlreadyFailed", "no");
		Test test = method.getAnnotation(Test.class);
		if (test == null)
			return;


		new Log(testConfig, method.getName(), "Branch Test", "Priyanka");
		

	}

	
}