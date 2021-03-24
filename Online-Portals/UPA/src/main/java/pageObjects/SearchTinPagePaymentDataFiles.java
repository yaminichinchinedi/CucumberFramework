package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import org.testng.Assert;

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

	/**
	 * Author : Vinay Raghumanda
	 * Validates Page Text for Payment data Files for different types of users.
	 * @param credentials
	 * @param userType
	 * @param portalAccess
	 */
	public void validatePageText(String credentials, String userType, String portalAccess) {

		String expectedParagraph, expectedHeader, actualButtonText, expectedButtonText;
		WebElement button = null;

		switch (credentials + portalAccess + testConfig.getRunTimeProperty("tinType") + userType){
			case "PROV_AdminPremiumAOPROV":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_AdminStandardAOPROV":
				expectedHeader = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				button = Element.findElement(testConfig, "xpath", "//*[@type=\"button\"]/span[text()='Get Started']");
				actualButtonText = button.getText().trim();
				expectedButtonText = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.buttonText");
				Assert.assertTrue(actualButtonText.equalsIgnoreCase(expectedButtonText), "Content Message Validation Failed");
				break;
			case "PROV_GenPremiumAOPROV":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_GenStandardAOPROV":
				expectedHeader = TestBase.contentMessages.getProperty("prov.general.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			case "BS_AdminPremiumAOBS":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_AdminStandardAOBS":
				expectedHeader = TestBase.contentMessages.getProperty("bs.admin.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			case "BS_GenPremiumAOBS":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_GenStandardAOBS":
				expectedHeader = TestBase.contentMessages.getProperty("bs.general.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			default:
				break;
		}
	}

	private void validateStandardUsers(String expectedParagraph, String expectedHeader) {
		WebElement h2tag;
		WebElement ptag;
		String actualHeader;
		String actualParagraph;
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@id=\"paymentDataFilesPremium\"]/h2"), 30);
		h2tag = Element.findElement(testConfig, "xpath", "//*[@id=\"paymentDataFilesPremium\"]/h2");
		ptag=Element.findElement(testConfig, "xpath", "//*[@id=\"paymentDataFilesPremium\"]/p[2]");
		actualHeader = h2tag.getText().trim();
		actualParagraph = ptag.getText().trim();
		Log.Comment("Actual Header : " + actualHeader + "\nExpected Header : " + expectedHeader
				+"\nActual paragraph : "+actualParagraph+"\nExpected paragraph : "+expectedParagraph);
		Assert.assertTrue(actualHeader.equalsIgnoreCase(actualHeader), "Content Message Validation Failed");
		Assert.assertTrue(actualParagraph.equalsIgnoreCase(expectedParagraph), "Content Message Validation Failed");
	}

	private void validatePremiumUsers(String expectedParagraph) {
		WebElement ptag;
		String actualParagraph;
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@class=\"topMessaggeDiv\"]"), 30);
		ptag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
		actualParagraph = ptag.getText().trim();
		Log.Comment("Actual paragraph : " + actualParagraph + "\nExpected paragraph : " + expectedParagraph + "\n");
		Assert.assertTrue(actualParagraph.equalsIgnoreCase(expectedParagraph), "Content Message Validation Failed");
	}
}
