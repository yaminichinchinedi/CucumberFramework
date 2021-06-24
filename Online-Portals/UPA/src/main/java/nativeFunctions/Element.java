package main.java.nativeFunctions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//import junit.framework.Assert;
import net.sourceforge.htmlunit.corejs.javascript.ast.CatchClause;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sun.mail.iap.Argument;

import main.java.Utils.Helper;
import main.java.reporting.Log;
import main.java.reporting.Log;

 public class Element {
	
	 public static TestBase testConfig;
	 
	/**Enters data in web element
	 * @Argument-WebElement,data to be entered, 
	 * description and name of element
	 */
	 
	 public static void clearData(WebElement element, String namOfElement)
	 {
		 try{
				element.clear();
				Log.Comment(namOfElement+" " +"has been cleared successfully");
				}
					 
		 catch(NoSuchElementException e)
			{
				Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
			}
			
			catch(ElementNotVisibleException e)
			{
				Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
			}
		 catch(Exception e)
			{
				Log.Comment("Can not clear the element" + " " + namOfElement);
				e.printStackTrace();
			}
		 
	 }
	 
	public static void enterData(WebElement element,String data, String description,String namOfElement)
	{
		try{
		element.clear();
		}
		catch(Exception e)
		{
			Log.Comment("Can not clear the element" + " " + namOfElement+"directly entering data");
		}
		try
		{
		element.sendKeys(data);		
		Log.Comment(description);
		}
		catch(NoSuchElementException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
		}
		
		catch(ElementNotVisibleException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
		}
		
		catch(StaleElementReferenceException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page"+ '\n' + e);
		}
		
		catch(NullPointerException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page and exception is: " + " " + e);
		}
	}
	
	public static void enterKeys(WebElement element,Keys key, String description,String namOfElement)
	{
	
		try
		{
		element.sendKeys(key);		
		Log.Comment(description);
		}
		catch(NoSuchElementException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
		}
		
		catch(ElementNotVisibleException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
		}
		
		catch(StaleElementReferenceException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page"+ '\n' + e);
		}
		
		catch(NullPointerException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page and exception is: " + " " + e);
		}
	}
	
	public static void expectedWait(WebElement element,TestBase testConfig,String description,String namOfElement)
	{
		try{
			 WebDriverWait wait=new WebDriverWait(testConfig.driver, 60);
			 wait.until(ExpectedConditions.visibilityOf(element));
			 
			 Log.Pass(namOfElement + " " + "is present on page");
		}
		catch(NoSuchElementException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
		}
		
		catch (TimeoutException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +" "+ " " +  " is Not found on page and timeout happened" + '\n' + e);
		}
		
		catch(ElementNotVisibleException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
		}
		
		catch(StaleElementReferenceException e)
		{
			 WebDriverWait wait=new WebDriverWait(testConfig.driver, 60);
			 wait.until(ExpectedConditions.visibilityOf(element));
			 //Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
		}
		
		catch(Exception e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
		}
	}
	
	public static void waitTillURlLoads(TestBase testConfig,String url)
	{
		try{
			 WebDriverWait wait=new WebDriverWait(testConfig.driver, 60);
			 wait.until(ExpectedConditions.urlToBe(url));
			 Log.Pass(url + " " + "is loaded");
		}
		catch(Exception e)
		{
			Log.Fail("Exception occured" + e);
		}
	}
	
	
	public static void waitTillTextAppears(WebElement element,String text,TestBase testConfig)
	{
		try{
			 WebDriverWait wait=new WebDriverWait(testConfig.driver, 60);
			 wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			 Log.Pass(text + " " + "is present on page");
		}
		catch (TimeoutException e)
		{
			Log.Fail("Text" + " " + "'"+text +" "+ " " +  " is Not found on page and timeout happened" + '\n' + e);
		}
		catch(Exception e)
		{
			Log.Fail("Exception occured while waiting for the text"+ "'" + text + "'" + " to be present " + e);
		}
	}
	
	/**
	 * Waits till an element becomes interactive to be clicked
	 * and then clicks it
	 * @param element
	 * @param namOfElement
	 * @param expectedWait
	 */
	public static void click(TestBase testConfig,WebElement element,String namOfElement,int expectedWait)
	{
		try{
	     
	     WebDriverWait wait = new WebDriverWait(testConfig.driver,expectedWait);
	     WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
	     element1.click();
	     Log.Comment("Clicked " + namOfElement);
	     
		}
		catch(Exception e){
			Log.Fail("Could not click on " + namOfElement+ " due to exception : " + e);
			
		}
	}	
	
	/**
	 * Performs Click action on specified element
	 * @param element
	 * @param namOfElement
	 */
	public static void click(WebElement element,String namOfElement)
	{
		try{
		  element.click();
		  Log.Comment("Clicked " + namOfElement);
		 }
		
		catch(NoSuchElementException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page and exception is: " + '\n' + e);
		}
		
		catch(ElementNotVisibleException e)
		{
			Log.Fail("Element" + namOfElement+" is not visible at first go and exception is: " + '\n' + e);
		}
		
		catch(NullPointerException e)
		{
			
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page and exception is: " + '\n' + e);
		}
		
		catch(Exception e)
		{
			Log.Fail("Unable to click " + " " + "'"+namOfElement +"'"+ " " + " and exception is: " + '\n' + e);
		}
			
	}
	
	public static void clickByJS(TestBase testConfig,WebElement element,String namOfElement)
	{
		try{
			 JavascriptExecutor js = (JavascriptExecutor) testConfig.driver;
		      js.executeScript("arguments[0].click();", element);
		      Log.Pass("Clicked " + namOfElement);
		 }
		
		catch(JavascriptException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page and exception is: " + '\n' + e);
		}
		
		catch(NoSuchElementException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page and exception is: " + '\n' + e);
		}
		
		catch(ElementNotVisibleException e)
		{
			Log.Fail("Element" + namOfElement+" is not visible at first go and exception is: " + '\n' + e);
		}
		
		catch(NullPointerException e)
		{
			
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page and exception is: " + '\n' + e);
		}
		
		catch(Exception e)
		{
			Log.Fail("Unable to click " + " " + "'"+namOfElement +"'"+ " " + " and exception is: " + '\n' + e);

		}
	}
	
	
	public static void onMouseHover(TestBase testConfig,WebElement element,String namOfElement)
	{
		
		Actions builder = new Actions (testConfig.driver);							
        builder.clickAndHold().moveToElement(element);					
        builder.moveToElement(element).build().perform(); 
		Log.Comment("Mouse Hovered over " + namOfElement);
	}
	
	public static void mouseHoverByJS(TestBase testConfig,WebElement element,String namOfElement)
	{
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		try{
			 JavascriptExecutor js = (JavascriptExecutor) testConfig.driver;
		     js.executeScript(mouseOverScript,element);
		     Log.Pass("Mouse hovered over " + namOfElement);
		}
		catch(Exception e)
		{
			Log.Fail("Exception occured while hovering over " + namOfElement + '\n'+ e);
		}
			
		
	}
	
	
	

	//Verifies element is present on the page 
	public static void verifyElementIsEnabled(WebElement button,String namOfButton)
	{
		try
		{
			if(button.isEnabled()== true)
		
		 {
			String successMsg="Verified " + namOfButton + " is enabled";
			Log.Pass(successMsg);
		 }
		else 
		{
			String failureMsg=namOfButton + " is not enabled on the page";
			Log.Fail(failureMsg);
		}
	}
	catch(Exception e)
	{
		Log.Fail(namOfButton +" is not present on the page and exception is :" + "<br>" + e);
			e.printStackTrace();
	}
}
	
	
	//Verifies element is disabled on the page 
		public static void verifyElementNotEnabled(WebElement button,String namOfButton)
		{
			try
			{
				if(!button.isEnabled()== true)
			
			 {
				String successMsg="Verified " + namOfButton + " is disabled";
				Log.Pass(successMsg);
			 }
			else 
			{
				String failureMsg=namOfButton + " is enabled on the page";
				Log.Fail(failureMsg);
			}
		}
		catch(Exception e)
		{
			Log.Fail(namOfButton +" is not present on the page and exception is :" + "<br>" + e);
				e.printStackTrace();
		}
	}
		
		
	
	
	//Verifies element is present on the page 
	public static void verifyElementPresent(WebElement element,String namOfElement)
	{
		try
		{
			if(element.isDisplayed())
		
		 {
			String successMsg="Verified " + namOfElement + " is present on the page";
			Log.Pass(successMsg);
		 }
		else 
		{
			String failureMsg=namOfElement + " is not present on the page";
			Log.Fail(failureMsg);
		}
	}
	catch(Exception e)
	{
		Log.Fail(namOfElement +" is not present on the page and exception is :" + "<br>" + e);
			
	}
}
	
	//Verifies element is present on the page. This accepts only the string as parameter.
    public static void verifyTextPresent(String actualText)
    {

 


        try {
            Boolean expectedText = testConfig.driver.getPageSource().toString().contains(actualText);
            Helper.compareEquals(testConfig, "Asserting whether given text "+actualText+"is present on the page", expectedText.toString(),"true");
            Log.Comment("Assertion passed successfully");
        }
        catch (Exception e)
        {
            Log.Fail("Exception occured" + '\n' + e);            
        }

 


    }

 


    //Verifies element is not present on the page. This accepts only the string as parameter.
    public static void verifyTextNotPresent(String actualText)
    {

 


        try{
            Boolean expectedText = testConfig.driver.getPageSource().toString().contains(actualText);
            Helper.compareEquals(testConfig, "Asserting whether given text "+actualText+"is not present on the page", expectedText.toString(),"false");
            Log.Comment("Assertion passed successfully");
        }
        catch(Exception e)
        {
            Log.Fail("Exception occured" + '\n' + e);            
        }

 


    }
	//Verifies element is not present on the page
	public static void verifyElementNotPresent(WebElement element,String namOfElement)
		{
		try
		{
			if(!element.isDisplayed())
		
		 {
			String successMsg="Verified " + namOfElement + " is not present on the page";
			Log.Pass(successMsg);
		 }
		else 
		{
			String failureMsg=namOfElement + " is present on the page";
			Log.Fail(failureMsg);
		}
	}
	catch(NoSuchElementException e)
	{
		String successMsg="Verified " + namOfElement + " is not present on the page";
		Log.Pass(successMsg);
			
	}
		
	catch(Exception e)
	{
			Log.Fail(namOfElement +" is  present on the page" + e);		
	}
		
	}
	public static void verifyTextPresent(WebElement element,String expectedText)
	{
		
		try{
			String actualText=element.getText().trim();
		if(actualText.contains(expectedText))
		{
			Log.Pass("Verified text is displayed as :" + " " + "'" + actualText + "'" );
		}
		else 	
			Log.Fail("Actual and Expected text don't match" + " " + " " + "Actual text is:" + " "  + "'" +actualText + " " + "'" + "" + "Where As Expected Text was:" + " " + "'" + expectedText + "'");
		}
		catch(Exception e)
		{
			
			Log.Fail("Exception occured" + '\n' + e);			
		}
		}
	
		
	public static String GetTextPresent(WebElement element,String expectedText)
	{
		String actualText = null;
		try{
			actualText=element.getText().trim();
		
		}
		catch(Exception e)
		{
			
			Log.Fail("Exception occured" + '\n' + e);			
		}
		return actualText;
		
		}
	
	//Verifies element is not present on the page 
	public static void verifyElementNotPresent(TestBase testConfig,String locatorType,String locatorValue,String elementName)
	{
		try {
			 WebElement ele=findElement(testConfig,locatorType, locatorValue);
			 if(ele==null)
				 Log.Pass("PASS: "+elementName + " " + "is not present");
			 else
				 Log.Fail("FAILED: "+elementName + " " + " is present");
		    }
		catch (Exception e) 
		{
			Log.Pass("PASS: "+elementName + " " + "is not present");
	    }
			
	}
	
	//Verifies element is checked
	public static void verifyElementIsChecked(WebElement element,String namOfElement)
	{
		if((element.isSelected()))
		{
			String successMsg = "Element" + namOfElement + "is checked";
		    Log.Pass(successMsg);
		}
		else 
		{
		    String failureMsg="Element" + namOfElement + "is not checked";
		    Log.Fail(failureMsg);
		}
			
	}
	
	//Verifies element is not checked
	public static void verifyElementNotChecked(WebElement element,String namOfElement)
	{
		try
		{ if(!(element.isSelected()))
		{
			String successMsg = "Element" + namOfElement + "is not checked";
			Log.Pass(successMsg);
		}
			
		else 
		{
		    String failureMsg="Element" + namOfElement + "is checked";
		    Log.Fail(failureMsg);
		}
		}
		catch(Exception e)
		{
			Log.Fail("Exception occured as : " + e);
		}
	}
	
	/**
	 * Gets all the available string options in the Select Element
	 * 
	 * @param testConfig
	 *            Config instance used for logging
	 * @param element
	 *            Select WebElement
	 * @return String list of options
	 */
	public static List<String> getAllOptionsInSelect(TestBase testConfig, WebElement element)
	{
		Log.Comment("Retrieve all the Options present for this specified Select WebElement");
		Select sel = new Select(element);
		List<WebElement> elements = sel.getOptions();
		List<String> options = new ArrayList<String>(elements.size());
		
		for (WebElement e : elements)
		{
			options.add(e.getText());
		}
		return options;
	}
	
	/**
	 * If u want to get text from drop down pass "text" as argument else pass "value" if attribute is to be retreived
	 * @param testConfig
	 * @param element
	 * @param textOrValue --> Options
	 * @return
	 */
	public static String getFirstSelectedOption(TestBase testConfig, WebElement element,String textOrValue)
	{
	  try{
		   
		   String FirstSelectedOption=null;
		   
		   Select sel = new Select(element);
		   
//		  System.out.println( sel.getFirstSelectedOption().getText());
		   
		   if(textOrValue.contains("text"))
		    FirstSelectedOption=sel.getFirstSelectedOption().getText();
		
		   else if (textOrValue.contains("value"))
		    FirstSelectedOption=sel.getFirstSelectedOption().getAttribute("value");
		
		   return FirstSelectedOption;
		 }
		
	  catch(StaleElementReferenceException e){
			Log.Fail("Unable to find selected item in dropdown due to stale element exception" + '\n' + e);
			return null;
		}
	  
		catch(Exception e){
			Log.Fail("Unable to find selected item in dropdown due to" + '\n' + e);
			return null;
		}
	  
	  
	}
	
	/**
	 * Selects the given visible text 'value' for the specified WebElement
	 * 
	 * @param testConfig
	 *            Config instance used for logging
	 * @param element
	 *            WebElement to select
	 * @param value
	 *            visible text value to the selected
	 * @param description
	 *            logical name of specified WebElement, used for Logging
	 *            purposes in report
	 */
	public static void selectVisibleText(WebElement element, String value, String description)
	{
			Log.Comment("Select the " + description + " dropdown text '" + value + "'");
			
			Select sel = new Select(element);
			sel.selectByVisibleText(value);
			
//			try
//			{
//				sel = new Select(element);
//				element.click();
//				sel.selectByVisibleText(value);
//			}
//			catch(Exception e){}
	}
	
	public static void selectByIndex(WebElement element, int index, String description)
	{
			Log.Comment("Select" +  description + "from dropdown");
			
			Select sel = new Select(element);
			sel.selectByIndex(index);
	}
	
	public static void selectByVisibleText(WebElement element, String text, String description)
	{
			try{

			Select sel = new Select(element);
			sel.selectByVisibleText(text);
			Log.Comment("Selected" + " " +  description);
			}
			catch (StaleElementReferenceException e)
			{
				Log.Fail("Stale exception" + e);
			}
			
			catch (Exception e)
			{
				Log.Fail("Exception occured as : " + '\n' + e);
			}
	}
	
	public static void selectByValue(WebElement element, String text, String description)
	{
			Log.Comment("Select" +  description + "from dropdown");
			Select sel = new Select(element);
			sel.selectByValue(text);
	}
	
	
	public static List<WebElement> findElements(TestBase testConfig,String locatorType,String locatorValue )
	{
		Browser.waitForLoad(testConfig.driver);
		int retry=4;
		try
		{
		  switch(locatorType)
           {
		      case "id":
			  return testConfig.driver.findElements(By.id(locatorValue));
		  
		      case "name":
			  return testConfig.driver.findElements(By.name(locatorValue));
		  
		      case "xpath":
		      return testConfig.driver.findElements(By.xpath(locatorValue));
		    
		      case "css":
			  return testConfig.driver.findElements(By.cssSelector(locatorValue));
		  
		      case "linkText":
			  return testConfig.driver.findElements(By.linkText(locatorValue));
		  
		      case "partialLinkText":
			  return testConfig.driver.findElements(By.partialLinkText(locatorValue));  
		      case "className":
				  return testConfig.driver.findElements(By.className(locatorValue));
		     default:
		     return null;  
		  }
		
	    }
		
		catch (StaleElementReferenceException e1)
		{
			while(retry>0)
			{
			Log.Comment("Stale element reference exception. Trying again...");
			Browser.wait(testConfig, 2);
			retry--;
			findElements(testConfig,locatorType,locatorValue);
			}
			
		}
		catch (NoSuchElementException e)
		{
			Log.Comment("Could not find the element on page and exception is : " + '\n' + e);
			return null;
		}
		
		catch (NullPointerException e)
		{
			Log.Fail("Exception Occured" + e);
			return null;
		}
		
		catch (Exception e)
		{
			Log.Fail("Exception Occured" + e);
			return null;
		}
		return null;
		
	}
	
	public static WebElement findElement(TestBase testConfig,String locatorType,String locatorValue )
	{
		
		try
		{
		  switch(locatorType)
           {
		      case "id":
			  return testConfig.driver.findElement(By.id(locatorValue));
		  
		      case "name":
			  return testConfig.driver.findElement(By.name(locatorValue));
		  
		      case "xpath":
		      return testConfig.driver.findElement(By.xpath(locatorValue));
		    
		      case "css":
			  return testConfig.driver.findElement(By.cssSelector(locatorValue));
		  
		      case "linkText":
			  return testConfig.driver.findElement(By.linkText(locatorValue));
		  
		      case "partialLinkText":
			  return testConfig.driver.findElement(By.partialLinkText(locatorValue));
			  
		      case "className":
			  return testConfig.driver.findElement(By.className(locatorValue)); 
		
		     default:
		     return null;  
		  }
		
	    }
		
		catch (StaleElementReferenceException e)
		{
			Log.Comment("Stale element reference exception. Trying again...");
			
			// retry
			Browser.wait(testConfig, 3);
			Log.Comment("Retrying getting element");
			findElement(testConfig,locatorType,locatorValue);
		}
		catch (NoSuchElementException e)
		{
			Log.Comment("Could not find the element on page with locator value : " +locatorValue );
			return null;
		}
		
		catch (Exception e)
		{
			Log.Fail("Unable to find element with locator " +  locatorValue + " due to exception : " + e);
					
			return null;
		}
		return null;
	}
	
	public static Map getAllAttributes(TestBase testConfig,WebElement element,String desc)
	{
	   JavascriptExecutor executor = (JavascriptExecutor)testConfig.driver;
	   Map attributes=(Map) executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
	   return attributes;   
    }
	
	
	/*public static Map getAllAttributes(TestBase testConfig,WebElement element,String desc)
    {
       JavascriptExecutor executor = (JavascriptExecutor)testConfig.driver;
       Map attributes=(Map) executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
       return attributes;   
 }*/


public boolean isSorted(List<String> list)
{
	    boolean sorted = true;        
	    for (int i = 1; i < list.size(); i++) {
	        if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
}

	    return sorted;
	}

public static void waitForPresenceOfElementLocated(TestBase testConfig,By locator, long timeOut) {
	WebDriverWait wait =  new WebDriverWait(testConfig.driver, timeOut);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
public static boolean waitForPresenceOfAllElements(TestBase testConfig,By locator, long timeOut) {
 WebDriverWait wait =  new WebDriverWait(testConfig.driver, timeOut);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	return true;
}

public static void waitForElementTobeClickAble(TestBase testConfig,WebElement elt, long timeOut) {
	try {
		WebDriverWait wait =  new WebDriverWait(testConfig.driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(elt));
	}
	catch(Exception e) {
		Log.Fail("Execption occurred while checking the element" + e);
	}
	
}


/**
 * Author: Mohammad Khalid
 *  */

public static void waitForElementWhileRefreshBrowser(TestBase testConfig,WebElement elt, int timeOut)
{
	for(int i=1; i<=timeOut;i++)
	{
		int count = 0;
		if(elt.isDisplayed())
		{
			Log.Pass("The Element is Visible, coming out of loop...");
			break;
		}
		else
		{
			Log.Comment("The Element is not Visible, hence refreshing the browser and waiting...");
			Browser.browserRefresh(testConfig);
			try {
				++count;
				
				if (!(count==timeOut))
				{	
					Thread.sleep(i);
				}
				else
				{
					Log.Fail("Element not visible...");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public static void fluentWait(TestBase testConfig,WebElement element,int timeOut, int pollingTime,String nameOfElement)
{
	try{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(testConfig.driver).withTimeout(timeOut, TimeUnit.SECONDS) 			
    .pollingEvery(pollingTime, TimeUnit.SECONDS) 			
	.ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.visibilityOf(element));
	
	 Log.Pass(nameOfElement + " " + "is present on page");
}
catch(NoSuchElementException e)
{
	Log.Fail("Element" + " " + "'"+nameOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
}

catch (TimeoutException e)
{
	Log.Fail("Element" + " " + "'"+nameOfElement +" "+ " " +  " is Not found on page and timeout happened" + '\n' + e);
}

catch(ElementNotVisibleException e)
{
	Log.Fail("Element" + " " + "'"+nameOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
}

catch(StaleElementReferenceException e)
{
	 WebDriverWait wait=new WebDriverWait(testConfig.driver, 60);
	 wait.until(ExpectedConditions.visibilityOf(element));
	 //Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
}

catch(Exception e)
{
	Log.Fail("Element" + " " + "'"+nameOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
}
}


public static void enterDataByJS(TestBase testConfig, WebElement element,String data,String namOfElement)
{ 
	try {
	Element.clearData(element, namOfElement);
	JavascriptExecutor js = (JavascriptExecutor)testConfig.driver;
    js.executeScript("arguments[0].value='" + data + "';", element);
    Log.Comment("Entered : " + data + " in " + namOfElement);
   }
catch(Exception e)
 {
 Log.Fail("Unable to enter"+data+"in"+ namOfElement+ "<br>" + e );
 }
}

public static boolean isValidFormat(String format, String value, Locale locale) {
    LocalDateTime ldt = null;
    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

    try {
        ldt = LocalDateTime.parse(value, fomatter);
        String result = ldt.format(fomatter);
        return result.equals(value);
    } catch (DateTimeParseException e) {
        try {
            LocalDate ld = LocalDate.parse(value, fomatter);
            String result = ld.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException exp) {
            try {
                LocalTime lt = LocalTime.parse(value, fomatter);
                String result = lt.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException e2) {

            }
        }
    }

    return false;
}
    
//public static void verifyElementNotEnabled(WebElement button,String namOfButton)
//{
//try
//{
//if(!button.isEnabled()== true)
//
//{
//String successMsg="Verified " + namOfButton + " is disabled";
//Log.Pass(successMsg);
//}
//else 
//{
//String failureMsg=namOfButton + " is enabled on the page";
//Log.Fail(failureMsg);
//}
//}
//catch(Exception e)
//{
//Log.Fail(namOfButton +" is not present on the page and exception is :" + "<br>" + e);
//e.printStackTrace();
//}
//}

}
