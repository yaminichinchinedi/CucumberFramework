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
import org.openqa.selenium.remote.CapabilityType;
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

import cucumber.api.Scenario;
import test.java.TestDetails;
import main.java.Utils.CopyDir;
import main.java.Utils.DataBase;
import main.java.Utils.DataBase.DatabaseType;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.reporting.Log;
import main.java.reporting.ReporterClass;
import main.java.reporting.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends ReporterClass {



	public static HashMap<String, TestDataReader> testDataReaderHashMap = new HashMap<String, TestDataReader>();
	public static HashMap<Integer, HashMap<String, String>> genericErrors = new HashMap<Integer, HashMap<String, String>>();
	
	TestDataReader testDataReaderObj;
	public static WebDriver driver;
	public Method testMethod;
	public Properties runtimeProperties;
	public SoftAssert softAssert;
	protected static volatile TestBase testConfig;
	public Connection DBConnection = null;
	private final static String DEFAULT_SAUCE_USER = "pchaud19";
	private final static String DEFAULT_SAUCE_ACCESSKEY = "ddc4d7ea-db56-4a8f-84b2-936339468a87";
	
//	private static HashMap<String, HashMap<String, String>> loginCredentials;

	public TestBase() {

		runtimeProperties = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\ConfigFiles\\Config.properties");
		FileInputStream fileInput = null;
		this.softAssert = new SoftAssert();

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			runtimeProperties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Getting Jenkins Parameter
       
		if (System.getProperty("env") == null)
			urlHelper(runtimeProperties.getProperty(("Env")));

		else if (System.getProperty("env").equals("Stage2"))
			urlHelper("Stage2");

		else if (System.getProperty("env").equals("Stage")) 
			urlHelper("Stage");
		
		else if (System.getProperty("env").equals("IMPL")) 
			urlHelper("IMPL");
		
		else if (System.getProperty("env").equals("Test1")) 
			urlHelper("Test1");
		
		else if (System.getProperty("env").equals("Test2"))
			urlHelper("Test2");

		else if (System.getProperty("env").equals("IMPL"))
			urlHelper("IMPL");
	}

	public static TestBase getInstance() {
		if (testConfig == null)
			testConfig = new TestBase();
		return testConfig;
	}

	public void urlHelper(String env) 
	{
		System.setProperty("Database", env);
		System.setProperty("env", env);
	
		if (System.getProperty("tagsToRun") == null)
			System.setProperty("URL",runtimeProperties.getProperty(runtimeProperties.getProperty("testSuite") + "URL_" + env));

		else if (System.getProperty("tagsToRun").contains("UPA")) 
			System.setProperty("URL", runtimeProperties.getProperty("UPAURL_" + env));

		else if (System.getProperty("tagsToRun").equals("CSR"))
			System.setProperty("URL", runtimeProperties.getProperty("CSRURL_" + env));
		
		else 
			System.setProperty("URL", runtimeProperties.getProperty("CSRURL_" + env));

	}

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType)
	{
		String Execution_Env;
		if (System.getProperty("Executionin") == null)
			Execution_Env = runtimeProperties.getProperty("AutomationExecution");
		 else 
			Execution_Env = System.getProperty("Executionin");
		
		if (Execution_Env.equalsIgnoreCase("Local"))
		{
			DesiredCapabilities caps ;
			switch (browserType) {
			case "chrome":
			case "Chrome":
				driver = initChromeDriver();
				break;			
			case "IE":
				DesiredCapabilities caps1 = DesiredCapabilities.internetExplorer();
				caps1.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				caps1.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				caps1.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true); 
				caps1.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
				caps1.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
	            caps1.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
	            caps1.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
	            caps1.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,true);
	            caps1.setCapability("disable-popup-blocking", true);
	            caps1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	            caps1.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
	            
	            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
	            driver = new InternetExplorerDriver(caps1);
				driver.manage().window().maximize();
				
				break;
				
			case "CSRIE_UPAIE":
				if(System.getProperty("Application").contains("UPA"))
					driver = initChromeDriver();
				else if(System.getProperty("Application").contains("CSR"))
				{
					caps = DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
					caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
					caps.setCapability(InternetExplorerDriver.IE_USE_PER_PROCESS_PROXY, true);
					
					caps.setCapability("disable-popup-blocking", true);
					System.setProperty("webdriver.ie.driver",
							System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver(caps);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					Log.Comment("Launched IE browser-- : " + browserType);
				}
				break;
				
			case "CSRIEUPAChrome":
				if(System.getProperty("Application").contains("UPA"))
					driver = initChromeDriver();
			
				else if(System.getProperty("Application").contains("CSR"))
				{
					caps = DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
					caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
					caps.setCapability(InternetExplorerDriver.IE_USE_PER_PROCESS_PROXY, true);
					caps.setCapability("disable-popup-blocking", true);
					System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver(caps);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					Log.Comment("Launched " + browserType );
				}
				break;
			default:
				Log.Comment("browser : " + browserType + " is invalid, launching Chrome by default");
				driver = initChromeDriver();
			}
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		else 
		
		{
			Log.Comment("Execution environment is Saucelab");
			switch (browserType) {
			case "chrome":
				driver = SetdriveronSauce(browserType);
				break;
			case "IE":
				driver = SetdriveronSauce(browserType);
				break;
			case "CSRIEUPAIE":
				if(System.getProperty("Application").contains("CSR"))
					driver = SetdriveronSauce("IE");
				else if( System.getProperty("Application").contains("UPA"))
					driver = SetdriveronSauce("chrome");
				driver = SetdriveronSauce(browserType);
				break;
			case "CSRIEUPAChrome":
				if(System.getProperty("Application").contains("CSR"))
					driver = SetdriveronSauce("IE");
				else if( System.getProperty("Application").contains("UPA"))
					driver = SetdriveronSauce("chrome");
				driver = SetdriveronSauce(browserType);
				break;
			}
		}

	}

	private static WebDriver initChromeDriver() {
		Log.Comment("Launching Google Chrome..");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		String downloadFilepath = System.getProperty("user.dir") + "\\Downloads";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		// For handling pop up -Loading of unpacked extensions is disabled by
		// the administrator
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	
	public void cacheTestDataReaderObject(TestBase testbase,String sheetName, String path)
	{
		
			try {
				testDataReaderObj = new TestDataReader(testbase,sheetName,path);
			} catch (IOException e) {
				e.printStackTrace();
				Log.failure("Test Case Failed due to IO Exception");
			}
	}
	
	public TestDataReader cacheTestDataReaderObject(String sheetName) throws IOException {
		if (testDataReaderHashMap.get(sheetName) == null) {
			testDataReaderObj = new TestDataReader(this, sheetName);
			testDataReaderHashMap.put(sheetName, testDataReaderObj);
		}
		return testDataReaderHashMap.get(sheetName);
	}

	private void cacheTestDataReaderObject(String sheetName, String path) {
		if (testDataReaderHashMap.get(path + sheetName) == null) {
			testDataReaderObj = new TestDataReader(this);
			testDataReaderHashMap.put(path + sheetName, testDataReaderObj);
		}
	}

	public TestDataReader getCachedTestDataReaderObject(String sheetName) {
		String path = getRunTimeProperty("DataFilePath");
		if (sheetName.contains(".")) {
			path = System.getProperty("user.dir") + getRunTimeProperty(sheetName.split("\\.")[0]);
			sheetName = sheetName.split("\\.")[1];

		}
		return getCachedTestDataReaderObject(sheetName, path);
	}

	public TestDataReader getCachedTestDataReaderObject(String sheetName, String path) {
		TestDataReader obj = testDataReaderHashMap.get(path + sheetName);
		// Object is not in the cache
		if (obj == null) {
			// cache for future use
			synchronized (TestBase.class) {
				cacheTestDataReaderObject(sheetName, path);
				obj = testDataReaderHashMap.get(path + sheetName);
			}
		}
		return obj;
	}

	public String getRunTimeProperty(String key) {
		String value = "";
		try {
			value = runtimeProperties.get(key).toString();
			value = Helper.replaceArgumentsWithRunTimeProperties(this, value);
		} catch (Exception e) {

			return null;
		}
		return value;
	}

	public void putRunTimeProperty(String key, String value) {
		runtimeProperties.put(key, value);
	}


	//If browser type comes null from jenkins, pick up the browser type from Config.
	public void tearUp() 
	{
		if (System.getProperty("BrowserType") == null)
			setDriver(runtimeProperties.getProperty("BrowserType"));
		else
			setDriver(System.getProperty("BrowserType"));
	}

	/*
	@BeforeMethod()
	public void setupTestMethod(Method method) {

		String author;
		testConfig.putRunTimeProperty("AlreadyFailed", "no");
		Test test = method.getAnnotation(Test.class);
		if (test == null)
			return;

		TestDetails details = method.getAnnotation(TestDetails.class);
		if (details == null)
			author = "Unspecified";
		else
			author = details.author();

		new Log(testConfig, method.getName(), test.description(), author);
		

	}*/
	
	
	public void setupTestMethod(Scenario scn) {
		 startTestCase(scn.getName(),scn.getName(),"Priyanka");
	     new Log(testConfig);
	}

/*	@AfterMethod()
	public void endTest(ITestResult iTestResult) {
		Log.endTest(iTestResult);
	}*/

	
	public void endTest(Scenario scn) {
		logReportSteps(scn.getStatus());
		 endReporting();
	}
		
	@AfterTest
	public void tearDown() {
		 Browser.closeBrowser(testConfig);		 

	}

	@BeforeClass()
	public void init() {
		initializeData();
	}

	public void initializeData() {
		testConfig = TestBase.getInstance();
		tearUp();
	}



	public WebDriver SetdriveronSauce(String Browser) {
		String URL = "http://" + DEFAULT_SAUCE_USER + ":" + DEFAULT_SAUCE_ACCESSKEY + "@ondemand.saucelabs.com:80/wd/hub";
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
			Log.Comment("Launched browser-- : " + Browser);
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
			Log.Comment("Launched browser-- : " + Browser);
		}

		return driver;
	}

	
	/*private static WebDriver initFirefoxDriver() {

	Log.Comment("Launching Firefox browser..");
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");

	FirefoxProfile profile = new FirefoxProfile();

	profile.setPreference("browser.download.dir", System.getProperty("user.dir") + "\\Downloads");

	profile.setPreference("browser.download.folderList", 2);

	// Set Preference to not show file download confirmation dialogue using
	// MIME types Of different file extension types.

	profile.setPreference("browser.download.manager.showWhenStarting", false);

	profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
	// needed for pdf download
	profile.setPreference("pdfjs.disabled", true);
	profile.setPreference("browser.download.useDownloadDir", "false");

	profile.setPreference("browser.helperApps.alwaysAsk.force", false);

	// profile.setPreference("plugin.scan.Acrobat", "999.0");
	// profile.setPreference("plugin.scan.plid.all", false);

	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("firefox_binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	capabilities.setCapability("marionette", true);
	capabilities.setCapability(FirefoxDriver.PROFILE, profile);

	WebDriver driver = new FirefoxDriver(capabilities);
	driver.manage().window().maximize();
	return driver;
}
*/
}