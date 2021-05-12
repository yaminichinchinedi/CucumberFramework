package main.java.pageObjects;

import org.apache.commons.lang3.StringUtils;
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
	
	
	
	public PaymentDataFilesCSR enterTinAndSrchCSR(String userType){
		switch (userType)
		{	
			case "PROV": //This case comes from CSR for providers to Enter TIN, not UPA flow
				if(testConfig.getRunTimeProperty("App").equalsIgnoreCase("CSR"))
				{
					Element.enterDataByJS(testConfig,txtboxTinNo, testConfig.getRunTimeProperty("tin"), "tin textbox");
					Element.clickByJS(testConfig,srchBtn, "Search Button");
				}
				break;
		}
		return new PaymentDataFilesCSR(testConfig);
	}		
	public PaymentDataFilesUPA enterTinAndSrchUPA(String userType) {	
		switch (userType)
		{	
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
		return new PaymentDataFilesUPA(testConfig);
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
	 * @param accessType
	 * @param portalAccess
	 */
	public void validatePageText(String accessType, String portalAccess) {

		String expectedParagraph, expectedHeader, actualButtonText, expectedButtonText;
		WebElement button = null;

		switch (accessType + "_" + portalAccess + "_" + testConfig.getRunTimeProperty("tinType")){
			case "PROV_Admin_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_Admin_Premium_VO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.premium.vo.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;	
			case "PROV_Admin_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				button = Element.findElement(testConfig, "xpath", "//*[@type=\"button\"]/span[text()='Get Started']");
				actualButtonText = button.getText().trim();
				expectedButtonText = TestBase.contentMessages.getProperty("prov.admin.standard.ao.pageDataFiles.buttonText");
				Helper.compareEquals(testConfig, "Page Text", expectedButtonText, actualButtonText);
				break;
			case "PROV_Gen_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_Gen_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("prov.general.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			case "BS_Admin_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_Admin_Standard_AO":
				if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and NotPaid"))
				{
					expectedHeader = TestBase.contentMessages.getProperty("bs.admin.standard.withinTrialNotPaid.ao.pageDataFiles.header");
					expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.standard.withinTrialNotPaid.ao.pageDataFiles.paragraph");
					validateStandardUsers(expectedParagraph, expectedHeader);
				}
				else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "PostTrial and NotPaid"))
				{
				expectedHeader = TestBase.contentMessages.getProperty("bs.admin.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);}
				break;
			case "BS_Gen_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.premium.ao.pageDataFiles.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_Gen_Standard_AO":
				if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and NotPaid"))
				{
					expectedHeader = TestBase.contentMessages.getProperty("bs.general.standard.withinTrialNotPaid.ao.pageDataFiles.header");
					expectedParagraph = TestBase.contentMessages.getProperty("bs.general.standard.withinTrialNotPaid.ao.pageDataFiles.paragraph");
					validateStandardUsers(expectedParagraph, expectedHeader);
				}
				else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "PostTrial and NotPaid"))
				{
				expectedHeader = TestBase.contentMessages.getProperty("bs.general.standard.ao.pageDataFiles.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.standard.ao.pageDataFiles.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);}
				break;
			default:
				break;
		}
	}

	private void validateStandardUsers(String expectedParagraph, String expectedHeader) {
		WebElement headerTag=null;
		WebElement paragraphTag=null;
		String actualHeader;
		String actualParagraph;
		if (testConfig.getRunTimeProperty("searchCriteria").equals("WithinTrial and NotPaid"))
		{
			Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//div[@id='payment-data-files']/div[1]/h2"), 30);
			headerTag = Element.findElement(testConfig, "xpath", "//div[@id='payment-data-files']/div[1]/h2");
			paragraphTag=Element.findElement(testConfig, "xpath", "//div[@id='payment-data-files']/div[1]/p[2]");	
		}
		if (testConfig.getRunTimeProperty("searchCriteria").equals("PostTrial and NotPaid"))
		{
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@id=\"paymentDataFilesPremium\"]/h2"), 30);
		headerTag = Element.findElement(testConfig, "xpath", "//*[@id=\"paymentDataFilesPremium\"]/h2");
		paragraphTag=Element.findElement(testConfig, "xpath", "//*[@id=\"paymentDataFilesPremium\"]/p[2]");
		}
		actualHeader = headerTag.getText().trim();
		actualParagraph = paragraphTag.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", expectedHeader, actualHeader);
		Helper.compareEquals(testConfig, "Page Text", expectedParagraph, actualParagraph);
	}

	private void validatePremiumUsers(String expectedParagraph) {
		WebElement paragraphTag=null;
		String actualParagraph=null;
		if (testConfig.getRunTimeProperty("searchCriteria").equals("PremiumOrStandardTIN") && testConfig.getRunTimeProperty("tinType").equals("VO"))
		{
			Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//div[@id='payment-data-files']/div[1]/p[2]"), 30);
			paragraphTag = Element.findElement(testConfig, "xpath", "//div[@id='payment-data-files']/div[1]/p[2]");	
		}
		else{
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@class=\"topMessaggeDiv\"]"), 30);
		paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
		}
		actualParagraph = paragraphTag.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", expectedParagraph, actualParagraph);
	}
}
