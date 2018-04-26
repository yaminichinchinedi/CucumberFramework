package main.java.nativeFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import main.java.Utils.CopyDir;
import main.java.Utils.CustomReporter;
import main.java.Utils.Helper;
import main.java.Utils.SendMail;
import main.java.Utils.TestDataReader;
import main.java.reporting.LogTemp;

public class TestBase {

	public WebDriver driver;
	static String driverPath = "D:\\chromedriver\\";
	public static HashMap<String, TestDataReader> testDataReaderHashMap = new HashMap<String, TestDataReader>();
	public static HashMap<Integer, HashMap<String, String>> genericErrors = new HashMap<Integer, HashMap<String, String>>();
	TestDataReader testDataReaderObj;
	public boolean printToScreen = true;
	public boolean enableScreenshot;
	public String testLog;
	public Connection DBConnection = null;
	protected  TestBase testConfig;
	public static String ResultsDir;
	public Method testMethod;
	
	
	
	
	// stores the run time properties (different for every test)

	public Properties runtimeProperties;
	public SoftAssert softAssert;
	public Connection connection= null;;

	public TestBase() {

		// Reading Config file
        
		File file = new File("Config.properties");
		FileInputStream fileInput = null;
		testLog = "";
		this.softAssert = new SoftAssert();
		
		// Set the full path of results dir for taking screenshot		
		//Need to understand this
		//this.testMethod = method;

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
		
		
		
		//Getting Jenkins Parameter
		
		if(System.getProperty("env") == null) 
		  {
			urlHeper(runtimeProperties.getProperty(("Env")));
		  }
		
		else if (System.getProperty("env").equals("Stage2"))
		{
			urlHeper("Stage2");
		}
		
		
		else if(System.getProperty("env").equals("Stage") )
		{
			urlHeper("Stage");		
		}
		
		else if(System.getProperty("env").equals("IMPL"))
		{
			urlHeper("IMPL");		
		}
        
		testConfig=this;
	}
	
	private void urlHeper(String env)
	{
		
		System.setProperty("Database", env);
		System.setProperty("UserActiveURL",runtimeProperties.getProperty("UPAURLActive_"+env));
		System.setProperty("env", env);
        
		if(System.getProperty("testSuite")==null)
		{
			
			System.setProperty("URL", runtimeProperties.getProperty(runtimeProperties.getProperty("testSuite") +"URL_"+env));
			
		}
		else if(System.getProperty("testSuite").equals("UPA.xml"))
		{
			System.setProperty("URL", runtimeProperties.getProperty("UPAURL_"+env));
		}
			
			else if (System.getProperty("testSuite").equals("CSR.xml"))
			{
				System.setProperty("URL", runtimeProperties.getProperty("CSRURL_"+env));
				
			}
			else{
				
				System.setProperty("URL", runtimeProperties.getProperty("CSRURL_"+env));
			}
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType) {
		
		try
		{
		if(runtimeProperties.getProperty("testSuite").equals("CSR") || System.getProperty("testSuite").equalsIgnoreCase("CSR.xml"))
			browserType="IE";
		}
		catch(Exception e)
		{
			LogTemp.Comment("Running UPA" + '\n' + e);
		}
		
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "FF":
			driver = initFirefoxDriver();
			break;
		case "IE":
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
            //caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true); 
            caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
            caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            
           // caps.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings",true);
            caps.setCapability("disable-popup-blocking", true);
            
            
		    System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
		    
		 	driver = new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private static WebDriver initChromeDriver() {
		LogTemp.Comment("Launching google chrome..");
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver initFirefoxDriver() {
		LogTemp.Comment("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver",
				"geckodriver.exe");
		LogTemp.Comment("Gecko Property set");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("firefox_binary","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		capabilities.setCapability("marionette", false);
		LogTemp.Comment("All capabilities set");
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.manage().window().maximize();
		return driver;
	}

	 public TestDataReader cacheTestDataReaderObject(String sheetName) throws IOException
	 {
		 if (testDataReaderHashMap.get(sheetName) == null)
		 {
		 testDataReaderObj = new TestDataReader(this,sheetName);
		 testDataReaderHashMap.put(sheetName, testDataReaderObj);
		 }
		 return testDataReaderHashMap.get(sheetName);
	 }

		private void cacheTestDataReaderObject(String sheetName, String path)
		{
			if (testDataReaderHashMap.get(path + sheetName) == null)
			{
				testDataReaderObj = new TestDataReader(this);
				testDataReaderHashMap.put(path + sheetName, testDataReaderObj);
			}
		}
	 
		public TestDataReader getCachedTestDataReaderObject(String sheetName)
		{	
			String path = getRunTimeProperty("DataFilePath");
			if(sheetName.contains("."))
			{	
				path=System.getProperty("user.dir")+getRunTimeProperty(sheetName.split("\\.")[0]);
				sheetName=sheetName.split("\\.")[1];
				
			}
			return getCachedTestDataReaderObject(sheetName, path);
		}
		
		public TestDataReader getCachedTestDataReaderObject(String sheetName, String path)
		{
			TestDataReader obj = testDataReaderHashMap.get(path + sheetName);
			// Object is not in the cache
			if (obj == null)
			{
				// cache for future use
				synchronized(TestBase.class)
				{
					cacheTestDataReaderObject(sheetName, path);
					obj = testDataReaderHashMap.get(path + sheetName);
				}
			}
			return obj;
		}
		
		
		
		
		
		
//	 public TestDataReader getRefreshedTestDataReaderObject(String sheetName, String path) throws IOException
//		{
//			TestDataReader obj = new TestDataReader(this, sheetName, path);
//			
//			// cache for future use
//			testDataReaderHashMap.put(path + sheetName, obj);
//			obj = testDataReaderHashMap.get(path + sheetName);
//			
//			return obj;
//		}
	 
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

	
	@BeforeTest
	public void tearUp()
	{
		setDriver(runtimeProperties.getProperty("BrowserType"));
		LogTemp logger =new LogTemp(testConfig);
		LogTemp.Comment("Running on environment" + System.getProperty("env"),"Maroon");
	}
	
	@AfterTest
	public void tearDown() {
    Browser.closeBrowser(testConfig);
		
	}	
}