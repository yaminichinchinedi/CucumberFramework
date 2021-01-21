package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.TestBase;

public class OptumPaySolution {
	
	@FindBy(xpath = "//div[contains(text(),'Provider Name')]") 
	WebElement txtProvNameHeader;
	@FindBy(xpath = "//div[contains(text(),'Plan Type')]") 
	WebElement txtPlanTypeHeader;
	@FindBy(xpath = "//div[contains(text(),'Fees')]") 
	WebElement txtFeesHeader;
	@FindBy(xpath = "//div[contains(text(),'Manage Subscriptions')]") 
	WebElement txtManageSubHeader;
	@FindBy(xpath = "//*[@id=\"optum-pay-options\"]//div//div[1]/div/div[2]") 
	WebElement txtProvNameInfo;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[2]//div[2]") 
	WebElement txtPlanTypeInfo;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[3]//div[2]/b") 
	WebElement txtFeesInfo;
	@FindBy(xpath = "//div[@id=\"optum-pay-options\"]//div//div[4]//div[2]/b") 
	WebElement txtManageSubInfo;
	
		private TestBase testConfig;
		public OptumPaySolution(TestBase testConfig) {
			this.testConfig=testConfig;
			PageFactory.initElements(testConfig.driver, this);
		}
		
		public void verifyPlanTypeInfoForVCP(){
			Helper.compareEquals(testConfig, "1st Tile Header", "Provider Name", txtProvNameHeader.getText().trim());
			Helper.compareEquals(testConfig, "2nd Tile Header", "Plan Type", txtPlanTypeHeader.getText().trim());
			Helper.compareEquals(testConfig, "3rd Tile Header", "Fees", txtFeesHeader.getText().trim());
			Helper.compareEquals(testConfig, "4th Tile Header", "Manage Subscriptions", txtManageSubHeader.getText().trim());
			
			int sqlRowNo = 1;
		    testConfig.getRunTimeProperty("tin");
		    Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    Helper.compareEquals(testConfig, "Organization Name on 1st tile DB and UI", data.get("ORG_NM").toString().trim(),txtProvNameInfo.getText().trim());
		    Helper.compareEquals(testConfig, "Plan Type on 2nd tile DB and UI", "VCP Only", txtPlanTypeInfo.getText().trim());
		    Helper.compareEquals(testConfig, "Fees on 3rd tile DB and UI", "N/A", txtFeesInfo.getText().trim());
		    Helper.compareEquals(testConfig, "Manage Subscriptions on 4th tile DB and UI", "N/A", txtManageSubInfo.getText().trim());	    
		}
		}

