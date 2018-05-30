package main.java.nativeFunctions;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.sourceforge.htmlunit.corejs.javascript.ast.CatchClause;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.reporting.Log;

 public class Element {
	
	 //creating object of Log class to use its methods
	
	 public static TestBase testConfig;
	 
	//Enters data in web element
	public static void enterData(WebElement element,String data, String description,String namOfElement)
	{
		try{
		element.clear();
		element.sendKeys(data);		
		Log.Comment(description);
		}
		catch(NoSuchElementException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page");
		}
		
		catch(ElementNotVisibleException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page");
		}
		
		catch(StaleElementReferenceException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page");
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
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not Visible on the page" + '\n' + e);
		}
		
		catch(Exception e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page" + '\n' + e);
		}
	}
	
	//Clicks the web element
	public static void click(WebElement element,String namOfElement)
	{
		try
		{
		  element.click();
		  Log.Comment("Clicked " + namOfElement);
		}
		
		catch(NoSuchElementException e)
		{
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page");
		}
		
		catch(ElementNotVisibleException e)
		{
			Log.Fail("Element" + namOfElement+" is not visible at first go, trying again");
		}
		
		catch(NullPointerException e)
		{
			
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page and exception is: " + '\n' + e);
		}
		
		catch(Exception e)
		{
			
			Log.Fail("Element" + " " + "'"+namOfElement +"'"+ " " + " is Not found on page and exception is: " + '\n' + e);
		}
			
	}
	
	
	
	
	public static void onMouseHover(TestBase testConfig,WebElement element,String namOfElement)
	{
		Actions action = new Actions(testConfig.driver);
		action.moveToElement(element).build().perform();
		Log.Comment("Mouse Hovered over " + namOfElement);
			
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
		Log.Fail(namOfElement +" is not present on the page" + e);
			
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
	
		
	
	
	//Verifies element is not present on the page 
	public static void verifyElementNotPresent(String locatorType,String locatorValue,String elementName)
	{
		try {
			  findElement(locatorType, locatorValue);
			  Log.Fail(elementName + " " + " is present");
		    }
			
		catch (Exception e) 
		{
			Log.Pass(elementName + " " + "is not present");
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
	
	public static String getFirstSelectedOption(TestBase testConfig, WebElement element,String textOrValue)
	{
		try{
			String FirstSelectedOption=null;
		
		Select sel = new Select(element);
		if(textOrValue.contains("text"))
		{
		 FirstSelectedOption=sel.getFirstSelectedOption().getText();
		}
		else if (textOrValue.contains("value"))
		{
			FirstSelectedOption=sel.getFirstSelectedOption().getAttribute("value");
		}
		
		return FirstSelectedOption;
		}
		
		catch(Exception e)
		{
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
				Log.Comment("Select" + " " +  description);
			
			
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
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
	
	
	public static List<WebElement> findElements(TestBase testConfig,String locatorType,String locatorValue ) throws InterruptedException
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
			Log.Comment("Could not find the element on page");
			return null;
		}
		
		catch (NullPointerException e)
		{
			Log.Fail("exception" + e);
			return null;
		}
		
		catch (Exception e)
		{
			Log.Fail("exception" + e);
			return null;
		}
		return null;
		
	}
	
	public static WebElement findElement(String locatorType,String locatorValue ) throws InterruptedException
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
		
		     default:
		     return null;  
		  }
		
	    }
		
		catch (StaleElementReferenceException e1)
		{
			Log.Comment("Stale element reference exception. Trying again...");
			
			// retry
			Browser.wait(testConfig, 3);
			Log.Comment("Retrying getting element");
			findElement(locatorType,locatorValue);
		}
		catch (NoSuchElementException e)
		{
			Log.Comment("Could not find the element on page");
			return null;
		}
		
		catch (Exception e)
		{
			Log.Fail("Unable to find element with locator" + " " + locatorValue );
			return null;
		}
		return null;
	}
	
	
	

}
