package main.java.pageObjects;

import java.util.List;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApprovdUIPage extends TestBase {
protected TestBase testbase;
	@FindBy(xpath="//header[2]//span[@class='progress-indicator__title']" )
	List<WebElement> OrgInfoforAO;
	//@FindBy(xpath="//li[@class='progress-indicator__step progress-indicator__step--complete']" )
	//List<WebElement> OrgInfoforAO;
	@FindBy(xpath="//fieldset" )
	WebElement fieldset;
	
	@FindBy(linkText="EXIT ENROLLMENT")
	WebElement continueButton;
	WebDriver driver;
	public ApprovdUIPage()
	{
		    Log.Comment("Launching Firefox browser..");
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			
			FirefoxProfile profile = new FirefoxProfile();
			
			profile.setPreference("browser.download.dir", System.getProperty("user.dir")+"\\Downloads");
			profile.setPreference("browser.download.folderList", 2);
	 
		
			//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
			
			 
			profile.setPreference( "browser.download.manager.showWhenStarting", false );

			profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
			//needed for pdf download
			profile.setPreference("pdfjs.disabled", true);
			profile.setPreference("browser.download.useDownloadDir", "false"); 
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			
			//profile.setPreference("plugin.scan.Acrobat", "999.0");
			//profile.setPreference("plugin.scan.plid.all", false);
			
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("firefox_binary","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			capabilities.setCapability("firefox_binary","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			

			capabilities.setCapability("marionette", true); 
			capabilities.setCapability (FirefoxDriver.PROFILE, profile);
			
			WebDriver driver = new FirefoxDriver(capabilities);
			driver.manage().window().maximize();
	
		
		
		driver.navigate().to("http://webrd1220.uhc.com/eps-2018/approved/enrollment/enrollment-ho-ACH-complete.html");
		Log.Comment("Navigated to UPA with URL : " + driver.getCurrentUrl());
		PageFactory.initElements(driver, this);
		Browser.waitForLoad(driver);
		
		try{
			 WebDriverWait wait=new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.visibilityOf(continueButton));
			 
			 Log.Pass(continueButton + " " + "is present on page");
		}
		
		catch(Exception e){
			e.printStackTrace();
			Log.Fail("Element" + " " + "'"+continueButton +"'"+ " " + " is Not found on page" + '\n' + e);
		}
		
		//Element.expectedWait(continueButton, testConfig, "Continue Button","Continue Button");
		System.out.println("Current URL is:"+driver.getCurrentUrl());
		System.out.println("Field set is:"+fieldset.getText());
	}

}
