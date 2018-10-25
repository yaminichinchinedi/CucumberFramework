package test.java;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class SeleniumAssignment1 {
	
	WebDriver driver;
	
    private WebDriver setDriver(String browserType) {
		
	System.out.println("Browser on which test suite is running is : " +  browserType);
		
	switch (browserType) {
		
		case "FF":
			driver = initFirefoxDriver();
			 
			break;
			
		case "IE":
			
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true); 
            caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
            caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            caps.setCapability("disable-popup-blocking", true);
            
		    System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
		 	driver = new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			
			break;
		
		default:
			System.out.println("browser : " + browserType+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver();
		}
	
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

    /**
     * OPens FF browser
     * @return- driver of FF
     */
	private static WebDriver initFirefoxDriver() {
		
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("firefox_binary","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		capabilities.setCapability("marionette", true); 
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	@Test(description="Opens IE in one session")
	public void testWebDriver1()
	{
		WebDriver IEdriver;
		IEdriver=setDriver("IE");
		IEdriver.navigate().to("https://www.google.co.in");
		System.out.println(IEdriver);
		
	}
	
	@Test(description="Opens FF in differnt sessions")
	public void testWebDriver2()
	{
		WebDriver FFdriver;
		FFdriver=setDriver("FF");
		FFdriver.navigate().to("https://www.bing.com");
		System.out.println(FFdriver);
		
	}
	

}
