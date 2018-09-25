package main.java.nativeFunctions;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

import main.java.reporting.Log;
import main.java.reporting.Log;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser 
 {
	
    public static Log logger;

	public static void browserRefresh(TestBase testConfig)
	{
		testConfig.driver.navigate().refresh();
		Log.Comment("Refreshing the browser...");
		acceptAlert(testConfig);
		waitForLoad(testConfig.driver);
		wait(testConfig,3);
	}
	
	public static void scrollToBottom(TestBase testConfig)
	{
		try{
			JavascriptExecutor js = (JavascriptExecutor) testConfig.driver;
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait(testConfig, 2);
		Log.Pass("Scrolled to bottom of the page");
		}
		catch(Exception e)
		{
			Log.Fail("Exception occured while scrolling : "  + e);
		}
	}
	
	public static void scrollTillAnElement(TestBase testConfig,WebElement element,String description)
	{
		try{
		JavascriptExecutor js = (JavascriptExecutor) testConfig.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		wait(testConfig, 2);
		Log.Pass("Scrolled till " + description);
		}
		catch(Exception e)
		{
			Log.Fail("Exception occured while scrolling : "  + e);
		}
	}
	
	public static void  acceptAlert(TestBase testConfig) {
	    try {
	        WebDriverWait wait = new WebDriverWait(testConfig.driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = testConfig.driver.switchTo().alert();
	        alert.accept();
	    } catch (NoAlertPresentException e) {
	        Log.Comment("No alert is present..continuing..");
	    }
	    
	    catch (Exception e) {
	        Log.Comment("No alert is present..continuing..");
	    }
	}
	
	
	public static void waitForLoad(WebDriver driver) 
	{
		try{
			
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
				{
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(pageLoadCondition);
		}
		catch(Exception e)
		{
			Log.Fail("Javascript exception \n" + e);
		}
	}
  

	public static void wait(TestBase testConfig,int seconds)
	{ 
		try{
		Log.Comment("Waiting for" + " " +seconds + " " + "seconds" );
		Thread.sleep(seconds * 1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.Comment("Element not found");
		}
	}
	
	public static void closeBrowser(TestBase testConfig)
	{
		try
		{
			if (testConfig.driver != null)
			{
				Log.Comment("Close the browser window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
				testConfig.driver.close();
			}
		}
		catch (UnreachableBrowserException e)
		{
			Log.Fail("Unable to close browser due to :" + '\n' + ExceptionUtils.getStackTrace(e));
			
		}
	}

	
	public void navigateTo(TestBase testConfig,String url)
	{
		
		testConfig.driver.navigate().to(url);
		Log.Comment("Navigating to...");
	}
	
	/**
	 * Quits this driver, closing every associated window.
	 * 
	 * @param Config
	 *            test config instance for the browser to be quit
	 */
	public static void quitBrowser(TestBase testConfig)
	{
		try
		{
			if (testConfig.driver!= null)
			{
				
				testConfig.driver.quit();
			}
		}
		catch (UnreachableBrowserException e)
		{
			logger.logWarning("Warning : " +e);
		}
	}
	
	public static String getURL(TestBase testConfig)
	{
		return testConfig.driver.getCurrentUrl();
		
	}

	
	// This class overrides the setCompressionQuality() method to workaround
		// a problem in compressing JPEG images using the javax.imageio package.
		public static class MyImageWriteParam extends JPEGImageWriteParam
		{
			public MyImageWriteParam()
			{
				super(Locale.getDefault());
			}
			
			// This method accepts quality levels between 0 (lowest) and 1 (highest)
			// and simply converts
			// it to a range between 0 and 256; this is not a correct conversion
			// algorithm.
			// However, a proper alternative is a lot more complicated.
			// This should do until the bug is fixed.
			@Override
			public void setCompressionQuality(float quality)
			{
				if (quality < 0.0F || quality > 1.0F)
				{
					throw new IllegalArgumentException("Quality out-of-bounds!");
				}
				this.compressionQuality = 256 - (quality * 256);
			}
		}
		
	public static File getScreenShotFile(TestBase testConfig)
	{
		File dest = getScreenShotDirectory(testConfig);
		return dest;
	}
	
	private static File getScreenShotDirectory(TestBase testConfig)
	{
		File dest = new File(testConfig.getRunTimeProperty("ResultsDir"));
		return dest;
	}
	private static String getScreenshotFileName(Method testMethod)
	 {
			String nameScreenshot = testMethod.getDeclaringClass().getName() + "." + testMethod.getName();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date();
			return dateFormat.format(date) + "_" + nameScreenshot + ".png";
	}
	
	
	/**
	 * Takes the screenshot of the current active browser window
	 * 
	 * @param Config
	 *            test config instance
	 * @param destination
	 *            file to which screenshot is to be saved
	 * @throws Exception 
	 */
//	public static void takeScreenShot(TestBase testConfig, File destination)  
//	{
//		try
//		{
//			if (testConfig.driver != null)
//			{
//				File screenshot = null;
//				String screenshotName="";
//				
//				try
//				{
//					screenshot = captureScreenshot(testConfig);
//				}
//				catch (NullPointerException ne)
//				{
//					Log.Comment("NullPointerException:Screenshot can't be taken. Probably browser is not reachable");
//					//test case will end, setting this as null will prevent taking screenshot again in cleanup
//					testConfig.driver = null;
//				}
//				
////				if (screenshot != null)
////				{
////					try
////					{
////						FileUtils.writeByteArrayToFile(destination, screenshot);
////						
////						float compressionQuality = (float) 0.5;
////						try
////						{
////							compressionQuality = Float.parseFloat(testConfig.getRunTimeProperty("ScreenshotCompressionQuality"));
////						}
////						catch (Exception e)
////						{
////							// We are not using testConfig.logException(e) to print
////							// exception here
////							// testConfig.logException(e) creates a infinite loop
////							// and breaks all test cases
////							e.printStackTrace();
////						}
////						compressJpegFile(destination, destination, compressionQuality);
////					}
////					catch (IOException e)
////					{
////						// We are not using testConfig.logException(e) to print
////						// exception here
////						// testConfig.logException(e) creates a infinite loop and
////						// breaks all test cases
////						e.printStackTrace();
////					}
////				}
//					if(testConfig.driver !=null)
//						Log.Comment("<B>Page URL</B>:- " + testConfig.driver.getCurrentUrl());
//					else 
//						Log.Comment("Driver is NULL");
//				}
//			
//				//String href =  screenshot;
//				//Log.Comment("<B>Screenshot</B>:- <a href=" + href  +" target='_blank' >" + destination.getName() + "</a>");
//			
//		}
//		catch (UnreachableBrowserException e)
//		{
//			testConfig.enableScreenshot = false;
//			Log.Comment("Unable to take screenshot:- " + ExceptionUtils.getStackTrace(e));
//		}
//		catch (Exception e)
//		{
//			testConfig.enableScreenshot = false;
//			Log.Comment("Unable to take screenshot:- " + ExceptionUtils.getStackTrace(e));
//			
//		}
//	}
	
			
			
		
		private static void compressJpegFile(File infile, File outfile, float compressionQuality)
			{
				try
				{
					// Retrieve jpg image to be compressed
					RenderedImage rendImage = ImageIO.read(infile);
					
					// Find a jpeg writer
					ImageWriter writer = null;
					Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("gif");
					if (iter.hasNext())
					{
						writer = iter.next();
					}
					
					// Prepare output file
					ImageOutputStream ios = ImageIO.createImageOutputStream(outfile);
					writer.setOutput(ios);
					
					// Set the compression quality
					ImageWriteParam iwparam = new MyImageWriteParam();
					iwparam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
					iwparam.setCompressionQuality(compressionQuality);
					
					// Write the image
					writer.write(new IIOImage(rendImage, null, null));
					
					// Cleanup
					ios.flush();
					writer.dispose();
					ios.close();
				}
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (OutOfMemoryError outOfMemoryError)
				{
					outOfMemoryError.printStackTrace();
				}
			}
			
			
			
			
	public static void captureScreenshot(TestBase testConfig) throws IOException
	{
		//byte[] screenshot = null;
		File screenShotName=null;
		
		try
		{
			// Return captured screenshot in File type
			 File sourceFile = ((TakesScreenshot)testConfig.driver).getScreenshotAs(OutputType.FILE);

			// Return a time stamp in format: http://YYYY.MM.DD-HH.MM.SS
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

			// Save the screen shot in 'D: drive' with name "screenshot.png"
			 screenShotName = new File("\\\\nas00912pn\\Apps\\Work\\Priyanka\\p1058\\Screenshot\\screenCapture"+timeStamp+".png");
			 
			// Copy captured screenshot in specified location
			 FileUtils.copyFile(sourceFile , screenShotName);
			 
			 if(testConfig.driver !=null)
			 {
				    Browser.waitForLoad(testConfig.driver);
					Log.Comment("<B>Page URL</B>:- " + testConfig.driver.getCurrentUrl());
			 }
				else 
					Log.Comment("Driver is NULL");
		
			String href=screenShotName.getAbsolutePath();
			Log.Comment("<B>Screenshot</B>:- <a href=" + href + ">" + "screenshot" + "</a>");
			

		}
		
		catch (NoSuchWindowException NoSuchWindowExp)
		{
			Log.Comment("NoSuchWindowException:Screenshot can't be taken. Probably browser is not reachable");
			//test case will end, setting this as null will prevent taking screenshot again in cleanup
			testConfig.driver = null;
		}
		catch (WebDriverException webdriverExp)
		{
			Log.Comment("Unable to take screenshot:- " + ExceptionUtils.getRootCauseStackTrace(webdriverExp));
		}
		
		catch (Exception unknownException)
		{
			Log.Comment("Unable to take screenshot beacuse of exception as:- " + unknownException);
		}
		
		
	}
	
	
	/**
	 * Verify Page URL
	 * 
	 * @param Config
	 *            test config instance
	 * @param expectedURL
	 * @return true if actual URL contains the expected URL
	 */
	public static boolean verifyURL(TestBase testConfig, String expectedURL)
	{
		try
		{
			int retries = 30;
			Browser.wait(testConfig,3);
			//Browser.waitForLoad(testConfig.driver);
			String actualURL = testConfig.driver.getCurrentUrl().toLowerCase();
			expectedURL = expectedURL.toLowerCase();
			
			while (retries > 0)
			{
				if (actualURL.contains(expectedURL))
				{
					Log.Pass("Browser URL", expectedURL,actualURL);
					
					// Verify that page stays on same page (no internal redirect)
					
					actualURL = testConfig.driver.getCurrentUrl().toLowerCase();
					if (!actualURL.contains(expectedURL))
					{
						Log.Fail("Browser URL", expectedURL, actualURL);
						return false;
					}
					
					return true;
				}
				actualURL = testConfig.driver.getCurrentUrl().toLowerCase();
				retries--;
			}
			Log.Fail("Browser URL", expectedURL, actualURL);
			return false;
		}
		catch (UnreachableBrowserException e)
		{
			
			Log.Comment("Exception is" + e, "Maroon");
			return false;
		}
	}
	
	
	/**
	 * Switch the driver to the new window
	 * 
	 * @param Config
	 *            test config instance
	 * @return window handle of the old window, so that it can be switched back
	 *         later
	 */
	public static String switchToNewWindow(TestBase testConfig,String expectedURLHelp)
	{  
		if (testConfig.driver != null)
		{
			Log.Comment("Switching to the new window");
			Browser.wait(testConfig, 2);
			String oldWindow = testConfig.driver.getWindowHandle();
			
			  
			  if (testConfig.driver.getWindowHandles().size() < 2)
 			  {
				  Log.Fail("No new window appeared, windows count available :-" + testConfig.driver.getWindowHandles().size());
			  }
			
			  
			for (String winHandle : testConfig.driver.getWindowHandles())
			{
				if (!winHandle.equals(oldWindow))
				{
					testConfig.driver.switchTo().window(winHandle);
					Log.Comment("Switched to new window..");
					Browser.wait(testConfig, 2);
					Log.Pass("Switched to window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
				}
			}
			Browser.waitForLoad(testConfig.driver);
			Browser.verifyURL(testConfig, expectedURLHelp);
			return oldWindow;
		}
		return null;
	}
	
	
	public static String switchToNewWindow(TestBase testConfig)
	{  
		if (testConfig.driver != null)
		{
			Log.Comment("Switching to the new window");
			Browser.wait(testConfig, 2);
			String oldWindow = testConfig.driver.getWindowHandle();
		    if (testConfig.driver.getWindowHandles().size() < 2)  
			Log.Fail("No new window appeared, windows count available :-" + testConfig.driver.getWindowHandles().size());
			 
			for (String winHandle : testConfig.driver.getWindowHandles())
			{
				if (!winHandle.equals(oldWindow))
				{
					testConfig.driver.switchTo().window(winHandle);
					Browser.wait(testConfig, 2);
					Log.Pass("Switched to window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
				}
			}
			Browser.waitForLoad(testConfig.driver);
			return oldWindow;
		}
		return null;
	}
	
	
	public static int getNoOfWindowHandles(TestBase testConfig)
	{
		return testConfig.driver.getWindowHandles().size();
	}
	
	
	public static void waitTillSpecificPageIsLoaded(TestBase testConfig,String pageTitle)
	{
		try{
			 WebDriverWait wait=new WebDriverWait(testConfig.driver, 60);
			 wait.until(ExpectedConditions.titleContains(pageTitle));
			 Log.Pass("Page is loaded with title : " + " " +pageTitle) ;
		}
		catch(Exception e)
		{
			Log.Fail("Page could not be loaded , because of exception : " + e);
		}
	}
	
	/**
	 * Switch the driver to the specified window
	 * 
	 * @param Config
	 *            test config instance
	 * @param windowHandle
	 *            Name of the window to be switched to
	 */
//	public static void switchToParentWindow(TestBase testConfig, String windowHandle)
//	{
//		if (testConfig.driver != null)
//		{
//			Log.Comment("Switching to the given window handle:- " + windowHandle);
////			testConfig.driver.close();
//			testConfig.driver.switchTo().window(windowHandle);
//			Log.Comment("Switched to window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
//		}
//	}
	
	public static void switchToParentWindow(TestBase testConfig, String windowHandle)
	{
		if (testConfig.driver != null)
		{
			Log.Comment("Switching to the given window handle:- " + windowHandle);
			System.out.println("No.of window handles are :" + testConfig.driver.getWindowHandles().size());
			if(getNoOfWindowHandles(testConfig)>1)
			testConfig.driver.close();
			testConfig.driver.switchTo().window(windowHandle);
			Log.Comment("Switched to Parent window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
		}
	}
	
	public static void switchToDefaultContent(TestBase testConfig)
	{
		if (testConfig.driver != null)
		{
			Log.Comment("Switching to the default window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
			testConfig.driver.switchTo().defaultContent();
		}
	}
	
	
	public static void switchToTheFirstWindow(TestBase testConfig)
	{
		if (testConfig.driver != null)
		{
			List<String> browserTabs = new ArrayList<String> (testConfig.driver.getWindowHandles());
			testConfig.driver.switchTo().window(browserTabs .get(1));
			Log.Pass("Switched to window with URL:- " + testConfig.driver.getCurrentUrl() + ". And title as :- " + testConfig.driver.getTitle());
		}
		
			
	}
}
