package main.java.pageObjects;

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
			    Element.click(srchBtn, "Search Button");
				break;
			case "BS": 
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,bstinDrpDwn, testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.click(submitBtn, "Search Button");
				break;
			case "Payer": 
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,payertinDrpDwn,testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.click(submitBtn, "Search Button");
				break;
			}
		return this;
	}

}

