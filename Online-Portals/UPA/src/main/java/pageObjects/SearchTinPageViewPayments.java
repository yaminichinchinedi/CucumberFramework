package main.java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class SearchTinPageViewPayments {

	@FindBy(name="providerTIN")
	public WebElement txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	public WebElement btnSubmit;
	
	@FindBy(xpath = "//select[@id='taxIndNbrId']") 
	WebElement prvdrTIN;
	
	@FindBy(xpath = "//input[@name='taxIdNbr']")
	WebElement tinDrpDwn;
	
	@FindBy(xpath = "//input[@name='billingProvTin']")
	WebElement bstinDrpDwn;
	
	@FindBy(xpath = "//input[@name='payerProvTin']") 
	WebElement payertinDrpDwn;
	
	@FindBy(xpath = "//input[@name='btnSearch']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement srchBtn;
	
	private TestBase testConfig;
	
	public SearchTinPageViewPayments(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(TestBase.driver, this);
    }
	
	public ViewPayments clickSearchBtn()
    {
      Element.clickByJS(testConfig,btnSubmit, "Search Button");
      return new ViewPayments(testConfig);
    }
	
	public SearchTinPageViewPayments enterTinAndSrch(String userType){
		switch (userType)
		{
			case "PROV": //This case comes from CSR for providers to Enter TIN, not UPA flow
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,txtboxTinNo, testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.clickByJS(testConfig, srchBtn, "Search Button");
				break;
			case "BS": 
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,bstinDrpDwn, testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.clickByJS(testConfig, submitBtn, "Search Button");
				break;
			case "PAY": 
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,payertinDrpDwn,testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.clickByJS(testConfig, submitBtn, "Search Button");
				break;
			}
		return this;
	}
	
	public SearchTinPageViewPayments SelectingTinOnViewPaymentPage(){
		   Element.waitForPresenceOfElementLocated(testConfig, By.id("taxIndNbrId"),5);
		   List<String> tinList = Element.getAllOptionsInSelect(testConfig, prvdrTIN);
		   String  tin = System.getProperty("tin");
		 String Enrolledtin = tin + " - Enrolled";
		 if ((!tinList.contains(Enrolledtin))) 
		 {
			Browser.waitForLoad(testConfig.driver);
			Browser.wait(testConfig, 2);
			Element.fluentWait(testConfig, prvdrTIN, 60, 1, "Tin dropdown");
		 }
		Element.selectVisibleText(prvdrTIN, tin + " - Enrolled", "TIN Selection from Dropdown");
		return this;
	}

}

