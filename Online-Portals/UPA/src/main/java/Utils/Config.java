//package Utils;
////
////
////package Utils;
////
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.sql.Connection;
//import logExceptionjava.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Properties;
//
//import nativeFunctions.Browser;
//
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.logging.Log;
//import org.apache.http.HttpHost;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.message.BasicHttpEntityEnclosingRequest;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.io.TemporaryFilesystem;
//import org.openqa.selenium.remote.SessionId;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.asserts.SoftAssert;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.ios.IOSDriver;
//import io.selendroid.SelendroidCapabilities;
//import io.selendroid.SelendroidLauncher;
//import ru.yandex.qatools.allure.annotations.Attachment;
//
//public class Config
//{
//	
//	public static String BrowserName;
//	public static String Environment;
//	
//	public String customerId = null;
//	public Connection DBConnection = null;
//	public boolean debugMode = false;
//	public static String RunType;
//	public static String fileSeparator = File.separator;
//	
//	// parameters different for every test
//	public WebDriver driver;
//	public String downloadPath = null;
//	public boolean enableScreenshot = true;
//	public boolean endExecutionOnfailure = false;
//	public boolean logToStandardOut = true;
//
//
//	// stores the run time properties (different for every test)
//	Properties runtimeProperties;
//	
//	public SoftAssert softAssert;
//	public static HashMap<String, TestDataReader> testDataReaderHashMap = new HashMap<String, TestDataReader>();
//	public static HashMap<Integer, HashMap<String, String>> genericErrors = new HashMap<Integer, HashMap<String, String>>();
//	TestDataReader testDataReaderObj;
//	public boolean remoteExecution;
//
//	
//	public String testLog;
//	
//	public Method testMethod;
//	String testName;
//	
//	public boolean testResult;
//	
//	
//	
//	public String previousPage="";
//	public SessionId session=null;
//	
//	public Config(Method method)
//	{
//		try
//		{
//			endExecutionOnfailure = true;
//			
//			this.testMethod = method;
//			this.testResult = true;
//			this.testLog = "";
//			this.softAssert = new SoftAssert();
//			// Read the Config file
//			Properties property = new Properties();
//			
//			String path = System.getProperty("user.dir") + fileSeparator + "Parameters" + fileSeparator + "Config.properties";
//			
//			if (debugMode)
//				logComment("Read the configuration file:-" + path);
//			FileInputStream fn = new FileInputStream(path);
//			property.load(fn);
//			fn.close();
//			
//			// override the environment value if passed through ant command line
//			if (!(Environment == null || Environment.isEmpty()))
//				property.put("Environment", Environment.toLowerCase());
//			
//			
//			path = System.getProperty("user.dir") + fileSeparator + "Parameters" + fileSeparator + property.get("Environment") + ".properties";
//			logComment("Read the environment file:- " + path);
//			
//			fn = new FileInputStream(path);
//			property.load(fn);
//			fn.close();
//						
//			this.runtimeProperties = new Properties();
//			Enumeration<Object> em = property.keys();
//			while (em.hasMoreElements())
//			{
//				String str = (String) em.nextElement();
//				putRunTimeProperty(str, (String) property.get(str));
//			}
//	
//						
//			
//			if (!(Browser == null))
//			 	putRunTimeProperty("Browser", Browser);
//			
//			else
//			{
//				// Set the full path of results dir
//				String resultsDir = System.getProperty("user.dir") + getRunTimeProperty("ResultsDir");
//				logComment("Results Directory is:- " + resultsDir);
//				putRunTimeProperty("ResultsDir", resultsDir);
//				
//			}
//			
//
//			//TODO Uncomment for android web execution
////			if (getRunTimeProperty("MobileUAFlag").equals("true"))
////			{
////				putRunTimeProperty("browser", "android_web");
////			}
//								
//			// Set the full path of test data sheet
//			String testDataSheet = System.getProperty("user.dir") + getRunTimeProperty("TestDataSheet");
//			putRunTimeProperty("TestDataSheet", testDataSheet);
//			
//		}
//		catch (IOException e)
//		{
//			logException(e);
//		}
//	}
//	
//	/**
//	 * Create TestDataReader object for the given sheet and cache it can be
//	 * fetched using - getCachedTestDataReaderObject()
//	 * 
//	 * @param sheetName
//	 */
//	private void cacheTestDataReaderObject(String sheetName, String path)
//	{
//		if (testDataReaderHashMap.get(path + sheetName) == null)
//		{
//			testDataReaderObj = new TestDataReader();
//			testDataReaderHashMap.put(path + sheetName, testDataReaderObj);
//		}
//	}
//	
//	
//	public void closeBrowser()
//	{
//		logToStandardOut = true;
//		
//		Browser.quitBrowser(this);
//		driver = null;
//	}
//	
//	public void closeBrowser(ITestResult result)
//	{
//		try
//		{
//			Browser.closeBrowser(this);
//		}
//		catch (Exception e)
//		{
//		}
//		
//		try
//		{
//			Browser.quitBrowser(this);
//		}
//		catch (Exception ex)
//		{
//		}
//		
//		try
//		{
//			driver.switchTo().defaultContent();
//			Browser.closeBrowser(this);
//		}
//		catch (Exception e)
//		{
//		}
//		
//		try
//		{
//			driver.switchTo().defaultContent();
//			Browser.quitBrowser(this);
//		}
//		catch (Exception ex)
//		{
//		}
//		
//		driver = null;
//	}
//	
////	/**
//	 * End Test
//	 * @param result - ITestResult
//	 */
//	public void endTest(ITestResult result)
//	{
//		testEndTime = Helper.getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
//		
//		endExecutionOnfailure = false;
//		enableScreenshot = false;
//		recordPageHTMLOnFailure = false;
//		
//		List<String> reporterOutput = Reporter.getOutput(result);
//		if(this.testStartTime != null)
//		{
//			long minutes = 0;
//			long seconds = 0;
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String minuteOrMinutes = " ";
//			String secondOrSeconds = "";
//			try
//			{
//				long timeinMillis = (dateFormat.parse(testEndTime).getTime() - dateFormat.parse(this.testStartTime).getTime())/1000;
//				minutes = timeinMillis/60;
//				seconds = timeinMillis%60;
//				if(minutes > 1)
//					minuteOrMinutes = "s ";
//				if(seconds > 1)
//					secondOrSeconds = "s";
//			}
//			catch(Exception e)
//			{}
//
//			if(!Helper.listContainsString(reporterOutput, "<font color='Blue'><B>Total time taken by Test '" + getTestName() + "' : '"))
//				logComment("<font color='Blue'><B>Total time taken by Test '" + getTestName() + "' : '" + minutes + " minute" + minuteOrMinutes + seconds + " second" + secondOrSeconds + "' </B></font>");
//		}
//		
//		if (!testResult)
//		{
//			if(!Helper.listContainsString(reporterOutput, "<B>Failure occured in test '" + getTestName() + "' Ended on '"))
//				logFail("<B>Failure occured in test '" + getTestName() + "' Ended on '" + testEndTime + "'</B>");
//		}
//		else
//		{
//			if(!Helper.listContainsString(reporterOutput, "<B>Test Passed '" + getTestName() + "' Ended on '"))
//				logPass("<B>Test Passed '" + getTestName() + "' Ended on '" + testEndTime + "'</B>");
//		}
//	}
//	
//	/**
//	 * Get the cached TestDataReader Object for the given sheet. If it is not
//	 * cached, it will be cached for future use
//	 * 
//	 * To read datasheet other than TestDataSheet, pass filename and sheet name separated by dot (i.e filename.sheetname)
//	 * 
//	 * @param sheetName
//	 * @return TestDataReader object or null if object is not in cache
//	 */
//	public TestDataReader getCachedTestDataReaderObject(String sheetName)
//	{	
//		String path = getRunTimeProperty("TestDataSheet");
//		if(sheetName.contains("."))
//		{	
//			path=System.getProperty("user.dir")+getRunTimeProperty(sheetName.split("\\.")[0]);
//			sheetName=sheetName.split("\\.")[1];
//			
//		}
//		return getCachedTestDataReaderObject(sheetName, path);
//	}
//	
//	
//	/**
//	 * Get the cached TestDataReader Object for the given sheet in the excel
//	 * specified by path. If it is not cached, it will be cached for future use
//	 * 
//	 * @param sheetName
//	 * @param path
//	 *            Path of excel sheet to read
//	 * @return TestDataReader object or null if object is not in cache
//	 */
//	public TestDataReader getCachedTestDataReaderObject(String sheetName, String path)
//	{
//		TestDataReader obj = testDataReaderHashMap.get(path + sheetName);
//		// Object is not in the cache
//		if (obj == null)
//		{
//			// cache for future use
//			synchronized(Config.class)
//			{
//				cacheTestDataReaderObject(sheetName, path);
//				obj = testDataReaderHashMap.get(path + sheetName);
//			}
//		}
//		return obj;
//	}
//	
//	/**
//	 * Get the Run Time Property value
//	 * 
//	 * @param key
//	 *            key name whose value is needed
//	 * @return value of the specified key
//	 */
//	@SuppressWarnings("unchecked")
//	public ArrayList<JSONObject> getJSONArrayListFromRunTimeProperty(String key)
//	{
//		String keyName = key.toLowerCase();
//		ArrayList<JSONObject> value;
//		try
//		{
//			value = (ArrayList<JSONObject>) runtimeProperties.get(keyName);
//			if (debugMode)
//				logComment("Reading Run-Time key-" + keyName + " value:-'" + value + "'");
//		}
//		catch (Exception e)
//		{
//			if (debugMode)
//			{
//				logComment(e.toString());
//				logComment("'" + key + "' not found in Run Time Properties");
//			}
//			return null;
//		}
//		return value;
//	}
//	
//	/**
//	 * Get the Run Time Property value
//	 * 
//	 * @param key
//	 *            key name whose value is needed
//	 * @return value of the specified key
//	 */
//	public Object getObjectRunTimeProperty(String key)
//	{
//		String keyName = key.toLowerCase();
//		Object value = "";
//		try
//		{
//			value = runtimeProperties.get(keyName);
//			if (debugMode)
//				logComment("Reading Run-Time key-" + keyName + " value:-'" + value + "'");
//		}
//		catch (Exception e)
//		{
//			if (debugMode)
//			{
//				logComment(e.toString());
//				logComment("'" + key + "' not found in Run Time Properties");
//			}
//			return null;
//		}
//		return value;
//	}
//	
//	/**
//	 * Refreshes the cache for the given sheet in excel, and gets TestDataReader
//	 * Object Also it will be cached for future use
//	 * 
//	 * @param sheetName
//	 * @param path
//	 *            Path of excel sheet to read
//	 * @return TestDataReader object or null if object is not in cache
//	 */
//	public TestDataReader getRefreshedTestDataReaderObject(String sheetName, String path)
//	{
//		TestDataReader obj = new TestDataReader(this, sheetName, path);
//		// cache for future use
//		testDataReaderHashMap.put(path + sheetName, obj);
//		obj = testDataReaderHashMap.get(path + sheetName);
//		
//		return obj;
//	}
//	
//	/**
//	 * Get the Run Time Property value
//	 * 
//	 * @param key
//	 *            key name whose value is needed
//	 * @return value of the specified key
//	 */
//	public String getRunTimeProperty(String key)
//	{
//		String keyName = key.toLowerCase();
//		String value = "";
//		try
//		{
//			value = runtimeProperties.get(keyName).toString();
//			value = Helper.replaceArgumentsWithRunTimeProperties(this, value);
//			if (debugMode)
//				logComment("Reading Run-Time key-" + keyName + " value:-'" + value + "'");
//		}
//		catch (Exception e)
//		{
//			if (debugMode)
//			{
//				logComment(e.toString());
//				logComment("'" + key + "' not found in Run Time Properties");
//			}
//			
//			return null;
//		}
//		return value;
//	}
//	
//	public String getTestName()
//	{
//		return testName;
//	}
//	
//	public boolean getTestCaseResult()
//	{
//		return testResult;
//	}
//	
//	public void logComment(String message)
//	{
//		Log.Comment(message, this);
//	}
//	
//	public void logException(Throwable e)
//	{
//		testResult = false;
//		String fullStackTrace = ExceptionUtils.getFullStackTrace(e);
//		Log.Fail(fullStackTrace, this);
//	}
//	
//	public void logFail(String message)
//	{
//		testResult = false;
//		Log.Fail(message, this);
//	}
//	
//	public void logFail(String what, float expected, float actual)
//	{
//		testResult = false;
//		String message = "Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
//		Log.Fail(message, this);
//
//	}
//	
//	/*
//	 * Method to log redmine id for failed test cases
//	 */
//	public void logRedmineID(String issueID)
//	{
//		Log.Comment("<B><font color='Red'>" + ">>>>>>>>>> Test case failed due to KNOWN bug in Application <<<<<<<<<<" + "</font></B>", this);
//		Log.Comment("<B>RedmineID</B>:- <a href="+"http://redmine.payu.in/issues/" + issueID + " target='_blank' >" +"http://redmine.payu.in/issues/"+issueID+"</a>", this);
//	}
//	
//	public void logFail(String what, double expected, double actual)
//	{
//		testResult = false;
//		String message = "Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
//		Log.Fail(message, this);
//		
//	}
//	
//	public void logFail(String what, int expected, int actual)
//	{
//		testResult = false;
//		String message = "Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
//		Log.Fail(message, this);
//	}
//	
//	public void logFail(String what, String expected, String actual)
//	{
//		testResult = false;
//		String message = "Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
//		Log.Fail(message, this);
//	}
//	
//	public void logWarning(String what, String expected, String actual)
//	{
//		//testResult = false;
//		String message = "Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
//		Log.Warning(message, this);
//	}
//	
//	public void logFailureException(Throwable e)
//	{
//		testResult = false;
//		Log.Failfinal(ExceptionUtils.getFullStackTrace(e), this);
//	}
//	
//	public void logPass(String message)
//	{
//		Log.Pass(message, this);
//	}
//	
//	public void logPass(String what, float actual)
//	{
//		String message = "Verified '" + what + "' as :-'" + actual + "'";
//		Log.Pass(message, this);
//	}
//	
//	public void logPass(String what, double actual)
//	{
//		String message = "Verified '" + what + "' as :-'" + actual + "'";
//		Log.Pass(message, this);
//	}
//	
//	public void logPass(String what, int actual)
//	{
//		String message = "Verified '" + what + "' as :-'" + actual + "'";
//		Log.Pass(message, this);
//	}
//	
//	public void logPass(String what, String actual)
//	{
//		String message = "Verified '" + what + "' as :-'" + actual + "'";
//		Log.Pass(message, this);
//	}
//	
//	public void logWarning(String message)
//	{
//		Log.Warning(message, this);
//	}
//	
//	public void logWarning(String message, boolean logPageInfo)
//	{
//		Log.Warning(message, this, logPageInfo);
//	}
//	
//	
//	public void openBrowser()
//	{
//		int retryCnt = 3;
//		while (this.driver == null && retryCnt > 0)
//		{
//			try
//			{
//				this.driver = Browser.openBrowser(this);
//				printNodeIpAddress(this.session, "browser");
//				
//			}
//			catch (Exception e)
//			{
//				Log.Warning("Retrying the browser launch:-" + e.getLocalizedMessage(), this);
//			}
//			if (this.driver == null)
//			{
//				if (this.remoteExecution)
//				{
//					Log.Comment("Deleting temporary files from folder", this);
//					TemporaryFilesystem tempFS = TemporaryFilesystem.getTmpFsBasedOn(new File((File.separator + File.separator + Config.RemoteAddress + File.separator + "SeleniumTemp" + File.separator + getRunTimeProperty("BuildId") + File.separator)+this.getTestName()));
//					tempFS.deleteTemporaryFiles();
//					Browser.wait(this, 30);
//				}
//				retryCnt--;
//				if (retryCnt == 0)
//				{
//					logFail("Browser could not be opened");
//					Assert.assertTrue(false);
//				}
//				Browser.wait(this, 2);
//			}
//			
//		}
//		endExecutionOnfailure = false;
//	}
//	
//	/**
//	 * Add the given key ArrayListJSONObject pair in the Run Time Properties
//	 */
//	public void putJSONArrayListInRunTimeProperty(String key, ArrayList<JSONObject> table)
//	{
//		String keyName = key.toLowerCase();
//		runtimeProperties.put(keyName, table);
//		if (debugMode)
//			logComment("Putting Run-Time key-" + keyName + " value:-'" + table.toString() + "'");
//	}
//	
//	/**
//	 * Add the given key value pair in the Run Time Properties
//	 * 
//	 * @param key
//	 * @param value
//	 */
//	public void putRunTimeProperty(String key, Object value)
//	{
//		String keyName = key.toLowerCase();
//		runtimeProperties.put(keyName, value);
//		if (debugMode)
//			logComment("Putting Run-Time key-" + keyName + " value:-'" + value + "'");
//	}
//	
//	/**
//	 * Add the given key value pair in the Run Time Properties
//	 * 
//	 * @param key
//	 * @param value
//	 */
//	public void putRunTimeProperty(String key, String value)
//	{
//		String keyName = key.toLowerCase();
//		runtimeProperties.put(keyName, value);
//		if (debugMode)
//		{
//				logComment("Putting Run-Time key-" + keyName + " value:-'" + value + "'");
//		}
//	}
//	
//	/**
//	 * Removes the given key from the Run Time Properties
//	 * 
//	 * @param key
//	 */
//	public void removeRunTimeProperty(String key)
//	{
//		String keyName = key.toLowerCase();
//		if (debugMode)
//			logComment("Removing Run-Time key-" + keyName);
//		runtimeProperties.remove(keyName);
//	}
//	
//	
//	
//}
//
//
