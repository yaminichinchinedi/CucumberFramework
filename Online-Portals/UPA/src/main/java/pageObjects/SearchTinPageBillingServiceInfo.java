package main.java.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BillingServiceInfo;

public class SearchTinPageBillingServiceInfo {
	@FindBy(xpath = "//select[@id='userTypeSelection']") 
	WebElement userTypeDrpDwn;
	@FindBy(name="identifierNbr") 
	WebElement txtboxTinNo;
	@FindBy(xpath = "//input[@value='Search']") 
	WebElement btnSearch;
	
	private TestBase testConfig;
	public SearchTinPageBillingServiceInfo(TestBase testConfig){
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	public void enterFetchedTIN(String userType){

		switch(userType){
	        case "BS":
	        {   
			   Element.selectByVisibleText(userTypeDrpDwn, "Billing Service", "Billing Service dropdown");
			   Element.clickByJS(testConfig,txtboxTinNo, "Enter TIN");
			   Element.enterDataByJS(testConfig, txtboxTinNo, System.getProperty("tin"), "Enter TIN for BS");
			   Browser.wait(testConfig, 2);
			   Element.clickByJS(testConfig,btnSearch, "Click Search Button");
			   Browser.waitForPageLoad(testConfig);
	  	       break;
	        }  
	       case "PROV":
	       {
			   Element.selectByVisibleText(userTypeDrpDwn, "Provider", "Provider dropdown");
			   Element.click(txtboxTinNo, "Enter TIN");
			   Element.enterData(txtboxTinNo, System.getProperty("tin"), "Enter TIN for PROV", "Enter PROV TIN in CSR");
			   Element.click(btnSearch, "Click Search Button");
	  	       break;
	        }
		 }
	}
}
