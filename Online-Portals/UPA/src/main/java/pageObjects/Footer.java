package main.java.pageObjects;

import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class Footer extends TestBase {

@FindBy(linkText = "Privacy Policy")
private WebElement lnkPrvcyPlcy;

@FindBy(linkText = "Terms of Use")
private WebElement lnkTrmOfUse;

@FindBy(xpath="//nobr")
private WebElement cpyright;

//@FindBy(className="copyrights copyright__text")
@FindBy(xpath="//span[contains(text(),'Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC')]")
private WebElement cpyrightwthoutnobr;



public Footer(TestBase testConfig)
{
PageFactory.initElements(testConfig.driver, this);
Browser.waitForLoad(testConfig.driver);
Element.expectedWait(lnkPrvcyPlcy, testConfig, "Privacy Policy", "Privacy Policy");


}

public void validateFooterContents(TestBase testConfig) {
// Check first privacy policy


String parentwindowhandle=testConfig.driver.getWindowHandle();
Browser.scrollToBottom(testConfig);
Element.click(lnkPrvcyPlcy, "Privacy Policy");
Browser.switchToNewWindow(testConfig);

String expectePrivacydURL = "Website_Privacy_Policy.pdf";
Browser.verifyURL(testConfig, expectePrivacydURL);

//Then check Terms of Use

Browser.switchToParentWindow( testConfig,  parentwindowhandle);
Browser.scrollToBottom(testConfig);
Element.click(lnkTrmOfUse, "Terms of Use");

Browser.switchToNewWindow(testConfig);
String expecteTrmsOfUsedURL="Terms_of_Use.pdf";
Browser.verifyURL( testConfig, expecteTrmsOfUsedURL);



//Then check for copyright
String actualcopyright=null;
int cpyrghtlngth=0;
Browser.switchToParentWindow( testConfig,  parentwindowhandle);
int year=Calendar.getInstance().get(Calendar.YEAR);
String expectedcopyright=year+" Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC";
String expectedOptumText=" Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC";
System.out.println(testConfig.driver.getCurrentUrl().toLowerCase());
if( (testConfig.driver.getCurrentUrl().toLowerCase().contains("providerefteraenroll")) ||
(testConfig.driver.getCurrentUrl().toLowerCase().contains("validateefteraproviderinfo")) ||
(testConfig.driver.getCurrentUrl().toLowerCase().contains("validatebsbillingserviceinfo")) ||
(testConfig.driver.getCurrentUrl().toLowerCase().contains("validateefterafinancialinfortn.do")) ||
(testConfig.driver.getCurrentUrl().toLowerCase().contains("beginenrollment.do")) ||
(System.getProperty("Application").contains("UPA"))
)
{
Element.expectedWait(cpyrightwthoutnobr, testConfig, "CopyRight Element without nobr", "CopyRight Element");
actualcopyright=cpyrightwthoutnobr.getText();
Helper.compareEquals(testConfig, "Footer Text",expectedOptumText," " +actualcopyright);
}

else
{
Element.expectedWait(cpyright, testConfig, "CopyRight Element with nobr", "CopyRight Element");
actualcopyright=cpyright.getText();


//cpyrghtlngth=actualcopyright.length();

/*if(cpyrghtlngth != 10)
actualcopyright=actualcopyright.substring(2);*/

if(actualcopyright.charAt(0)!='2') {
	actualcopyright=actualcopyright.substring(2);
}

String stryear=actualcopyright.substring(0, 4);
String optum=actualcopyright.substring(4);
if ( (Integer.parseInt(stryear)==year) && (optum.trim().equalsIgnoreCase(expectedOptumText.trim())) )
Log.Pass("Passed Copyright Comparision" + " " + ":" + ""  + "Expected was :" +" " + expectedcopyright  + "and Actual is :" +" " +actualcopyright );


else
Log.Fail("Failed Copyright Comparision" + " " + ":" + ""  + "Expected was :" +" " + expectedcopyright  + "and Actual is :" +" " +actualcopyright );
}

}
}
