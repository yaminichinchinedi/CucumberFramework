package test.java;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class TestFooter extends TestBase {

	@FindBy(linkText = "Privacy Policy")
	private WebElement lnkPrvcyPlcy;
	
	@FindBy(linkText = "Terms of Use")
	private WebElement lnkTrmOfUse;

	 @FindBy(xpath="//nobr")
	private WebElement cpyright;




	public void validateFooterContents(TestBase testConfig) {
		// Check first privacy policy

		
		//this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForLoad(testConfig.driver);
		
		String parentwindowhandle=testConfig.driver.getWindowHandle();

		System.out.println("Current URL is:"+testConfig.driver.getCurrentUrl());
		
		Browser.scrollToBottom(testConfig);
		System.out.println("scrolled to bottom");
		Element.click(lnkPrvcyPlcy, "Privacy Policy");
		Browser.switchToNewWindow(testConfig);
		String expectePrivacydURL = "Website_Privacy_Policy.pdf";
		

		Browser.verifyURL(testConfig, expectePrivacydURL);
		System.out.println("Privacy Policy passed");

//		
		 //Then check Terms of Use

		 Browser.switchToParentWindow( testConfig,  parentwindowhandle);
		 Browser.scrollToBottom(testConfig);
		 Element.click(lnkTrmOfUse, "Terms of Use");
		 
		 Browser.switchToNewWindow(testConfig);
		 String expecteTrmsOfUsedURL="Terms_of_Use.pdf";
		 Browser.verifyURL( testConfig, expecteTrmsOfUsedURL);
		 System.out.println("Terms of used passed");
		 
		 
		 
		 String actualcopyright=null;
		  //Then check for copyright
		 Browser.switchToParentWindow( testConfig,  parentwindowhandle);
		 try{
		  actualcopyright=cpyright.getText();
		 }
		 catch(NoSuchElementException e)
		 {
			 cpyright= testConfig.driver.findElement(By.className("copyright"));
			 actualcopyright=cpyright.getText();
		 }
		 System.out.println("value of copyright text:"+actualcopyright);
		
		 if(actualcopyright.length() != 10)
		 {
			 actualcopyright=actualcopyright.substring(2);
			 
		 }
		 
		 
		 int year=Calendar.getInstance().get(Calendar.YEAR);
		 String expectedcopyright=year+" Optum"; 
		 String stryear=actualcopyright.substring(0, 4); 
		 String optum=actualcopyright.substring(5);
		  
		  if ( (Integer.parseInt(stryear)==year) && (optum.equalsIgnoreCase("optum")) ) 
		  {
			  //Assert.assertTrue(true);
		  Log.Pass("Passed" + " " + ":" + "" + '\n' + "Expected was :" +" " + expectedcopyright + '\n' + "Actual is :" +" " +actualcopyright );
		  System.out.println("Copyright passed");
		  }
		  
		  else
		  {
			 //Assert.assertTrue(false);
			  Log.Fail("Failed" + " " + ":" + "" + '\n' + "Expected was :" +" " + expectedcopyright + '\n' + "Actual is :" +" " +actualcopyright );
		    System.out.println("Copyright failed"); }
		 

	}

}
