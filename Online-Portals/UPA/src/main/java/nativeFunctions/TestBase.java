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

import test.java.TestDetails;
import main.java.Utils.CopyDir;
import main.java.Utils.DataBase;
import main.java.Utils.DataBase.DatabaseType;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.reporting.Log;
import main.java.reporting.LogTemp;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

	public static WebDriver driver;
	static String driverPath = "D:\\chromedriver\\";
	public static HashMap<String, TestDataReader> testDataReaderHashMap = new HashMap<String, TestDataReader>();
	public static HashMap<Integer, HashMap<String, String>> genericErrors = new HashMap<Integer, HashMap<String, String>>();
	TestDataReader testDataReaderObj;
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

		if (System.getProperty("env") == null) {
			urlHeper(runtimeProperties.getProperty(("Env")));

		}

		else if (System.getProperty("env").equals("Stage2")) {
			urlHeper("Stage2");
		}

		else if (System.getProperty("env").equals("Stage")) {
			urlHeper("Stage");
		}

		else if (System.getProperty("env").equals("IMPL")) {
			urlHeper("IMPL");
		}

		// testConfig=this;
	}

	public static TestBase getInstance() {

		// TestBase result = testConfig;
		if (testConfig == null) {
			testConfig = new TestBase();
		}
		return testConfig;
	}

	public void urlHeper(String env) {

		System.setProperty("Database", env);
		System.setProperty("UserActiveURL", runtimeProperties.getProperty("UPAURLActive_" + env));
		System.setProperty("env", env);
		LogTemp.Comment("testSuite " + System.getProperty("testSuite"));
		LogTemp.Comment("BrowserType " + System.getProperty("BrowserType"));
		LogTemp.Comment("Running on Environment : " + System.getProperty("env"), "Orange");

		if (System.getProperty("testSuite") == null) {

			System.setProperty("URL",
					runtimeProperties.getProperty(runtimeProperties.getProperty("testSuite") + "URL_" + env));

			LogTemp.Comment("Running test Suite for: " + runtimeProperties.getProperty("testSuite"));

		} else if (System.getProperty("testSuite").equals("UPA_Regression")) {

			System.setProperty("URL", runtimeProperties.getProperty("UPAURL_" + env));
		}

		else if (System.getProperty("testSuite").equals("CSR_Regression")) {

			LogTemp.Comment("**runtimeProperties.getPropertyenv-" + runtimeProperties.getProperty("CSRURL_" + env));
			System.setProperty("URL", runtimeProperties.getProperty("CSRURL_" + env));

		} else {

			System.setProperty("URL", runtimeProperties.getProperty("CSRURL_" + env));
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType) {
		String Execution_Env;
		if (System.getProperty("Executionin") == null) {
			Execution_Env = runtimeProperties.getProperty("AutomationExecution");
		} else {
			Execution_Env = System.getProperty("Executionin");
		}

		

		try {
			if (runtimeProperties.getProperty("testSuite").contains("CSR")
					|| System.getProperty("testSuite").equalsIgnoreCase("CSR_Regression"))
				;
			;// browserType="IE";
		}

		catch (Exception e) {
			LogTemp.Comment("Starting execution ..");
		}
		if (Execution_Env.equalsIgnoreCase("Local")) {
			DesiredCapabilities caps ;
			switch (browserType) {
			case "chrome":
				driver = initChromeDriver();
				break;			
			case "IE":
				caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
				caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
				caps.setCapability(InternetExplorerDriver.IE_USE_PER_PROCESS_PROXY, true);
				//String v = caps.getVersion().toString();
				caps.setCapability("disable-popup-blocking", true);
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver(caps);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				LogTemp.Comment("Launched IE browser-- : " + browserType);
				break;
			case "CSRIEUPAIE":
				if(System.getProperty("Application").contains("UPA"))
				{
					driver = initChromeDriver();
				}
				else if(System.getProperty("Application").contains("CSR"))
				{
					caps = DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
					caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
					caps.setCapability(InternetExplorerDriver.IE_USE_PER_PROCESS_PROXY, true);
					//String v = caps.getVersion().toString();
					caps.setCapability("disable-popup-blocking", true);
					System.setProperty("webdriver.ie.driver",
							System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver(caps);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					LogTemp.Comment("Launched IE browser-- : " + browserType);
				}
				break;
			case "CSRIEUPAChrome":
				if(System.getProperty("Application").contains("UPA"))
				{
					driver = initChromeDriver();
				}
				else if(System.getProperty("Application").contains("CSR"))
				{
					caps = DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
					caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
					caps.setCapability(InternetExplorerDriver.IE_USE_PER_PROCESS_PROXY, true);
					//String v = caps.getVersion().toString();
					caps.setCapability("disable-popup-blocking", true);
					System.setProperty("webdriver.ie.driver",
							System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver(caps);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					LogTemp.Comment("Launched IE browser-- : " + browserType);
				}
				break;
			default:
				Log.Comment("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
				driver = initFirefoxDriver();
			}
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else {
			LogTemp.Comment("Execution environment is Saucelab");
			switch (browserType) {
			case "chrome":
				driver = SetdriveronSauce(browserType);
				break;
			case "IE":
				driver = SetdriveronSauce(browserType);
				break;
			case "CSRIEUPAIE":
				if(System.getProperty("Application").contains("CSR"))
				{
					driver = SetdriveronSauce("IE");
				}
				else if( System.getProperty("Application").contains("UPA"))
				{
					driver = SetdriveronSauce("chrome");
				}
				driver = SetdriveronSauce(browserType);
				break;
			case "CSRIEUPAChrome":
				if(System.getProperty("Application").contains("CSR"))
				{
					driver = SetdriveronSauce("IE");
				}
				else if( System.getProperty("Application").contains("UPA"))
				{
					driver = SetdriveronSauce("chrome");
				}
				driver = SetdriveronSauce(browserType);
				break;
			}
		}

	}

	private static WebDriver initChromeDriver() {
		LogTemp.Comment("Launching google chrome..");

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
		// options.addArguments("--headless");
		// options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");

		// WebDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver initFirefoxDriver() {

		LogTemp.Comment("Launching Firefox browser..");
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

	@BeforeSuite
	public void setUpReportingConfig() {
		Log.setReportingConfig();

	}

	//@BeforeTest
	public void tearUp() {
		//LogTemp.Comment("** TearUp1---" + System.getProperty("BrowserType"));
		if (System.getProperty("BrowserType") == null) {
			LogTemp.Comment("** Browser value is  : null");
			LogTemp.Comment("** Browser value is  : "+runtimeProperties.getProperty("BrowserType"));
			setDriver(runtimeProperties.getProperty("BrowserType"));
		} else {
			LogTemp.Comment("** Browser value is not null" + System.getProperty("BrowserType"));
			setDriver(System.getProperty("BrowserType"));
		}
		// testConfig.putRunTimeProperty("createDt",Helper.getCurrentDate("yyyy-MM-dd
		// HH:mm:ss"));
	}

	@BeforeMethod()
	public void setupTestMethod(Method method) {

		String author;
		System.out.println("====testConfig" + testConfig);
		testConfig.putRunTimeProperty("AlreadyFailed", "no");
		Test test = method.getAnnotation(Test.class);
		if (test == null)
			return;

		TestDetails details = method.getAnnotation(TestDetails.class);
		if (details == null)
			author = "Unspecified";
		else
			author = details.author();

		Log logger = new Log(testConfig, method.getName(), test.description(), author);
		// fetchAppCredentials();

	}

	@AfterMethod()
	public void endTest(ITestResult iTestResult) {
		Log.endTest(iTestResult);
		// String
		// testClass=iTestResult.getTestClass().getName().replace("test.java.",
		// "");
		// testConfig.putRunTimeProperty("testClass", testClass);

	}

	//@AfterTest
	public void tearDown() {
		 Browser.closeBrowser(testConfig);

	}

	@BeforeClass()
	public void init() {

		// Log logger =new Log(testConfig,"BeforeClass");
		initializeData();
	}

	public void initializeData() {
		testConfig = TestBase.getInstance();
	}

	// @AfterClass()
	// public void deinit()
	// {
	// deinitializeData();
	// }
	//
	// public void deinitializeData()
	// {
	// }

	public void fetchAppCredentials() {
		String query = "Select * from eps_automation.config;";
		loginCredentials = new HashMap<String, HashMap<String, String>>();
		try {
			ResultSet rs = DataBase.testExecuteSelectQuery(testConfig, query, DatabaseType.Automation);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			while (rs.next()) {
				HashMap<String, String> row = new HashMap<String, String>(columns);
				String key = rs.getString("AppName") + rs.getString("UserType") + rs.getString("AccessType")
						+ rs.getString("Env");
				row.put("USERNAME", rs.getString("Username"));
				row.putIfAbsent("PASSWORD", rs.getString("Pwd"));
				loginCredentials.put(key, row);
			}
		} catch (Exception e) {
			Log.Comment(e.getMessage());
		}

	}

	@AfterClass()
	public void afterClass(ITestContext iTestContext) throws UnknownHostException {
		testConfig.putRunTimeProperty("endDt", Helper.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
		testConfig.putRunTimeProperty("host", localMachine.getHostName() + "-" + System.getProperty("user.name"));

		System.out.println(iTestContext.getAllTestMethods());
		testConfig.putRunTimeProperty("passedTests", String.valueOf(iTestContext.getPassedTests().size()));
		testConfig.putRunTimeProperty("failedTests", String.valueOf(iTestContext.getFailedTests().size()));
		if (testConfig.getRunTimeProperty("IsAutomationStatRequired").equalsIgnoreCase("Yes"))
			insertAutomationCount();
	}

	public void insertAutomationCount() {
		System.setProperty("Database", "Automation");
		int sqlRow = 158;
		DataBase.executeInsertQuery(testConfig, sqlRow);

	}

	// public String getUsername(String appName,String userType,String
	// accessType,String env){
	// if(loginCredentials == null || loginCredentials.isEmpty()){
	// fetchAppCredentials();
	// }
	// return
	// loginCredentials.get(appName+userType+accessType+env).get("USERNAME");
	// }
	// public String getPassword(String appName,String userType,String
	// accessType,String env){
	// if(loginCredentials == null || loginCredentials.isEmpty()){
	// fetchAppCredentials();
	// }
	// return
	// loginCredentials.get(appName+userType+accessType+env).get("PASSWORD");
	// }

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			LogTemp.Comment("Launched browser-- : " + Browser);
		} else if (Browser.equalsIgnoreCase("chrome")) {
			
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
			LogTemp.Comment("Launched browser-- : " + Browser);
		}

		return driver;
	}

}