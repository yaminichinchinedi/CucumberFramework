package main.java.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class FinancialInstitutionInfoPageNPI{

	@FindBy(name = "finInstNameNPI")
	WebElement finInstName;

	@FindBy(name = "finInstNpiNPI")
	WebElement finInstNPINo;
	
	@FindBy(name = "finInstStreetNPI")
	WebElement finInstStreet;

	@FindBy(name = "finInstCityNPI")
	WebElement finInstCity;

	@FindBy(name = "finInstStateNPI")
	WebElement finInstState;

	@FindBy(name = "finInstZip1NPI")
	WebElement finInstZip1;

	@FindBy(name = "finInstZip2NPI")
	WebElement finInstZip2;

	@FindBy(name = "finInstPhone1NPI")
	WebElement finInstPhone1;

	@FindBy(name = "finInstPhone2NPI")
	WebElement finInstPhone2;

	@FindBy(name = "finInstPhone3NPI")
	WebElement finInstPhone3;

	@FindBy(name = "finInstRoutingNPI")
	WebElement finInstRoutNum;

	@FindBy(name = "finInstBankAccNPI")
	WebElement finInstAcctNum;

	@FindBy(xpath = "//input[@name='finInstAccTypeNPI'][1]")
	WebElement rdoChecking;

	@FindBy(xpath = "//input[@name='finInstAccTypeNPI'][2]")
	WebElement rdoSavings;
	
	@FindBy(id="uploads[0]")
	WebElement btnBrowse;
	
	// //div[4]/div[1]/div/div/div[1]/div[2]/div/label
	
	@FindBy(name="npienrollment_0")
	WebElement rdoBankLetter;
	
	@FindBy(xpath = "//input[@name='finInstTinNpiAcctYorN'][1]")
	WebElement rdoNPIYes;

	@FindBy(xpath = "//input[@name='finInstTinNpiAcctYorN'][2]")
	WebElement rdoNPINo;

	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
	@FindBy(xpath="//tr[4]/td/table/tbody/tr/td[2]")
	WebElement txtSecurity;

	protected TestBase testConfig;
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();

	public FinancialInstitutionInfoPageNPI(TestBase testConfig) 
	{
	
		String expectedURL = "/validateefterafinancialinfo";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		if(enrollmentInfoPageObj.getEnrollType().equals("AV"))
			expectedURL="/validateefteraprovidercontact";
		Browser.verifyURL(testConfig, expectedURL);
	}
	

	public UploadW9 clickContinue() {
		Element.clickByJS(testConfig, btnContinue, "Continue");
		return new UploadW9(testConfig) ;
	}
	
	public SelectPaymentMethods clickContinueAV() {
		Element.clickByJS(testConfig, btnContinue, "Continue");
		return new SelectPaymentMethods(testConfig) ;
	}
	
	public FinancialInstitutionInfoPageNPI fillFinancialInstInfoForNPI() throws IOException
	{
		String expectedText="To help ensure the security of your account, you must enter a physical address for your financial institution. PO Boxes are not allowed.";
	//	Element.verifyTextPresent(txtSecurity, expectedText);
		String financialInstName = Helper.generateRandomAlphabetsString(4);
		String financialInstStreet = Helper.generateRandomAlphabetsString(5);
		String phNo = Long.toString(Helper.generateRandomNumber(3));
		String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
		String npiNumber=Long.toString(Helper.generateRandomNumber(10));
		Element.enterData(finInstNPINo,npiNumber ,"Enter financial Institution name","finInstName");
		Element.enterData(finInstName, financialInstName,"Enter financial Institution name","finInstName");
		Element.enterData(finInstStreet, financialInstStreet,"Enter financial Institution street","finInstStreet");
        Element.enterData(finInstPhone1, phNo,"Entered first three digits of phone number","finInstPhone1");
		Element.enterData(finInstPhone2, phNo,"Entered second three digits of phone number","finInstPhone2");
		Element.enterData(finInstPhone3, phNoLstField,"Entered last four digits of phone number","finInstPhone3");
//		enrollmentInfoPageObj.setFinInstName(financialInstName);
//		enrollmentInfoPageObj.setFinPhoneNo(phNo+phNo+phNoLstField);
//		enrollmentInfoPageObj.setFinStreet(financialInstStreet);
		fillFinancialInstInfoFromExcel();
		Browser.wait(testConfig, 2);
		uploadBankLetterPdfWithAcceptance();
		
		return this;
	}
	
	public void uploadBankLetterPdfWithAcceptance()  
	{   
		String expectedText="Optum reserves the right to request additional information to help ensure the security of your account.";
		//Element.verifyTextPresent(txtSecurity,expectedText);
		expectedText="For your security, you may be contacted";
		//Element.verifyTextPresent(txtSecurity1,expectedText);
		expectedText="and required to submit additional information.";
		//Element.verifyTextPresent(txtSecurity2,expectedText);
		
		Browser.wait(testConfig, 2);
		Element.clickByJS(testConfig,rdoBankLetter, "Bank Letter radio button");
//		enrollmentInfoPageObj.setFinDocCode("BL");
		Browser.waitForLoad(testConfig.driver);
		Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnBrowse");
		Browser.wait(testConfig,2);
	}
	
	public void fillFinancialInstInfoFromExcel() throws IOException 
	{
	  int rowNo=15;
	  TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
	  String cityName =data.GetData(rowNo, "City");
	  String stateName =data.GetData(rowNo, "State");
	  String zipCode =data.GetData(rowNo, "ZipCode");
	  String routingNo =data.GetData(rowNo, "RoutingNumber");
	  String accountNo =data.GetData(rowNo, "AccountNumber");
	  Element.enterData(finInstCity, cityName,"Read from excel and Enter City name","finInstCity");
	  Element.selectVisibleText(finInstState, stateName,"Select City from excel");
	  Element.enterData(finInstZip1, zipCode,"Read from excel and Enter Zip 1","finInstZip1");
	  Element.enterData(finInstRoutNum, routingNo,"Read from excel and Enter Routing Number","finInstRoutNum");
	  Element.enterData(finInstAcctNum, accountNo,"Read from excel and Enter Account Number","finInstAcctNum");
//	  enrollmentInfoPageObj.setFinState(stateName);
//	  enrollmentInfoPageObj.setFinCity(cityName);
//	  enrollmentInfoPageObj.setFinZip(zipCode);
//	  enrollmentInfoPageObj.setFinAcntNo(accountNo);
//	  enrollmentInfoPageObj.setFinRoutingNo(routingNo);
//	  Element.enterData(element, data, description, namOfElement);
    }
}
