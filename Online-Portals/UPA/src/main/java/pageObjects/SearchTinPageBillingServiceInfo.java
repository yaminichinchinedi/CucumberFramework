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
	@FindBy(xpath = "//select[@id='userTypeSelection']") WebElement userTypeDrpDwn;
	@FindBy(name="identifierNbr") WebElement txtboxTinNo;
	@FindBy(xpath = "//input[@value='Search']") WebElement btnSearch;
	
	private TestBase testConfig;
	public SearchTinPageBillingServiceInfo(TestBase testConfig){
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	public void verifyUserType(String userType){
		if(userType.equalsIgnoreCase("Prov")){
		String tin= System.getProperty("tin"); 
	    System.setProperty("tin", tin); 
		}
		else if(userType.equalsIgnoreCase("BS")){
			String bsTIN=System.getProperty("tin"); 
		    System.setProperty("bsTIN", bsTIN); 
		} 
		switch(userType){
	        case "BS":
	        {   
			   String bsTIN = System.getProperty("bsTIN");
			   Element.selectByVisibleText(userTypeDrpDwn, "Billing Service", "Billing Service dropdown");
			   Element.click(txtboxTinNo, "Enter TIN");
			   Element.enterData(txtboxTinNo, bsTIN, "Enter TIN for BS", "Enter BS TIN in CSR");
			   Browser.wait(testConfig, 5);
			   Element.click(btnSearch, "Click Search Button");
			   Browser.waitForPageLoad(testConfig);
	  	       break;
	        }  
	       case "PROV":
	       {
			   String provTIN = System.getProperty("provTIN");
			   Element.selectByVisibleText(userTypeDrpDwn, "Provider", "Provider dropdown");
			   Element.click(txtboxTinNo, "Enter TIN");
			   Element.enterData(txtboxTinNo, provTIN, "Enter TIN for PROV", "Enter PROV TIN in CSR");
			   Element.click(btnSearch, "Click Search Button");
	  	       break;
	        }
		 }
	}
}
