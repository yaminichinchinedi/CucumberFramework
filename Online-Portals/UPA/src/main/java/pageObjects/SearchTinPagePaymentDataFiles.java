package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class SearchTinPagePaymentDataFiles {
	@FindBy(name="taxIndNbr")
	public WebElement txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	public WebElement btnSubmit;
		
	@FindBy(name = "paProvTinNbr")
	WebElement bstinDrpDwn;
	
	@FindBy(name = "paProvTinNbr")
	WebElement payertinDrpDwn;
	
	@FindBy(name = "continueBtn")
	WebElement submitBtn;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement srchBtn;
	
	@FindBy(xpath = "//td[contains(text(),'Please enter valid Tax Identification Number')]") 
	WebElement invalidTinMsg;
	
	private TestBase testConfig;
	
	public SearchTinPagePaymentDataFiles(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(TestBase.driver, this);
	  if(testConfig.getRunTimeProperty("App").equalsIgnoreCase("CSR"))
	  Element.fluentWait(testConfig, srchBtn, 100, 1, "Search button");
    }
	
	public ViewPayments clickSearchBtn()
    {
      Element.clickByJS(testConfig,btnSubmit, "Search Button");
      return new ViewPayments(testConfig);
    }
	
	
	
	public PaymentDataFilesCSR enterTinAndSrch(String userType){
		switch (userType)
		{	
			case "PROV": //This case comes from CSR for providers to Enter TIN, not UPA flow
				if(testConfig.getRunTimeProperty("App").equalsIgnoreCase("CSR"))
				{
					Element.enterDataByJS(testConfig,txtboxTinNo, testConfig.getRunTimeProperty("tin"), "tin textbox");
					Element.clickByJS(testConfig,srchBtn, "Search Button");
				}
				break;
				
			case "BS": 
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,bstinDrpDwn, testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.click(submitBtn, "Search Button");
				break;
			case "Payer": 
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,payertinDrpDwn,testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.clickByJS(testConfig,submitBtn, "Search Button");
				break;		
		}
		return new PaymentDataFilesCSR(testConfig);
	}

	
	public SearchTinPagePaymentDataFiles verifyErrorMsgForInvalidTIN() throws Exception {
		String invalidTIN=Helper.generateRandomAlphaNumericString(9);
		Element.expectedWait(txtboxTinNo, testConfig, "TIN field","TIN Field");
		Element.enterData(txtboxTinNo, invalidTIN, "TIN entered as : "+invalidTIN, "enterTin");
		Element.clickByJS(testConfig,srchBtn, "Search Button");
		Helper.compareEquals(testConfig, "InValid TIN Functionality", "Please enter valid Tax Identification Number", invalidTinMsg.getText());
		return this;
	}
}
