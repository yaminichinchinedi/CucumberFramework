package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class FinancialInstitutionInfoPage extends validateEFTERAFinancialInfo{

	@FindBy(name = "finInstTinName")
	WebElement finInstName;

	@FindBy(name = "finInstNpiNPI")
	WebElement finInstNPINo;
	
	@FindBy(name = "finInstTinStreet")
	WebElement finInstStreet;

	@FindBy(name = "finInstTinCity")
	WebElement finInstCity;

	@FindBy(name = "finInstTinState")
	WebElement finInstState;

	@FindBy(name = "finInstTinZip1")
	WebElement finInstZip1;

	@FindBy(name = "finInstTinZip2")
	WebElement finInstZip2;

	@FindBy(name = "finInstTinPhone1")
	WebElement finInstPhone1;

	@FindBy(name = "finInstTinPhone2")
	WebElement finInstPhone2;

	@FindBy(name = "finInstTinPhone3")
	WebElement finInstPhone3;

	@FindBy(name = "finInstTinRoutNum")
	WebElement finInstRoutNum;

	@FindBy(name = "finInstTinAcctNum")
	WebElement finInstAcctNum;

	@FindBy(xpath = "//input[@name='finInstTinAcctType'][1]")
	WebElement rdoChecking;

	@FindBy(xpath = "//input[@name='finInstTinAcctType'][2]")
	WebElement rdoSavings;

	@FindBy(xpath = "//input[@name='finInstTinNpiAcctYorN'][1]")
	WebElement rdoNPIYes;

	@FindBy(xpath = "//input[@name='finInstTinNpiAcctYorN'][2]")
	WebElement rdoNPINo;

	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;
	
	@FindBy(linkText="BACK")
	WebElement btnBack;
	
	@FindBy(linkText="CANCEL ENROLLMENT")
	WebElement btnCancEnroll;
	
	@FindBy(xpath="//tr[4]/td/table/tbody/tr/td[2]")
	WebElement txtSecurity;
	
	@FindBy(id="voided-check")
	WebElement voidChk;
	
	@FindBy(id="bank-letter")
	WebElement bnkLetter;
	
	@FindBy(partialLinkText="Where can I find a financial institution's")
	WebElement lnkFINRouNo;
	
	@FindBy(partialLinkText= "How do I manage multiple NPI bank")
	WebElement lnkNPIBnk;
	
	@FindBy(linkText="CLOSE TIP")
	WebElement btnCloseTIP;
	
	@FindBy(linkText="YES")
	WebElement btnYes;
	
	@FindBy(linkText="NO")
	WebElement btnNo;
	
	protected TestBase testConfig;
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();

	public FinancialInstitutionInfoPage(TestBase testConfig) 
	{
		super(testConfig);
		String expectedURL = "/validateEFTERAProviderContact";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	

	public void clickFINRoutlnk()
	{
	Element.click(lnkFINRouNo, "Finantial Institution Routing No");
	Browser.wait(testConfig, 1);
	Element.click(btnCloseTIP, "Close TIP Button");
	
	
	}
	public void clickFINMngNPIAcc()
	{
	
	Element.click(lnkNPIBnk, "Manage Multiple NPI Bank Account ");
	Browser.wait(testConfig, 1);
	Element.click(btnCloseTIP, "Close TIP Button");
	}
	public void verifyFinAccount()
	{
		//rdoChecking
//		Element.verifyElementIsChecked(rdoChecking, "Checking finantial Account");
//		Element.click(rdoSavings, "Saving Account");
//		Browser.wait(testConfig, 2);
//		Element.verifyElementIsChecked(rdoSavings, "Saving Account");
//		
//		Element.verifyElementIsChecked(voidChk, "Voided Check");
//		Browser.wait(testConfig, 3);
//		Element.click(rdoBankLetter, "Bank Letter");
//		Browser.wait(testConfig, 2);
//		Element.verifyElementIsChecked(rdoBankLetter, "Bank Letter");
		
		Element.verifyElementIsChecked(rdoNPINo, "NPI Account No Check");
		Browser.wait(testConfig, 3);
		Element.click(rdoNPIYes, "NPI Account Yes Check");
		Browser.wait(testConfig, 2);
		Element.verifyElementIsChecked(rdoBankLetter, "Bank Letter");
		
	}
	
	public void verifyButtons()
	{
		Element.verifyElementPresent(btnContinue, "Continue Button");
		Element.verifyElementPresent(btnBack, "Back Button");
		Element.verifyElementPresent(btnCancEnroll, "Cancel Enrollment Button");
		
		Element.click(btnBack, "Back Button");
		Browser.verifyURL(testConfig, "providerContactsEFTERAEnroll.do");
		Browser.wait(testConfig, 2);
		//Browser.forward(testConfig);
		Element.click(btnContinue, "Continue Button");
		Browser.wait(testConfig, 1);
		Element.click(btnCancEnroll, "Cancel Enroll Button");
		Browser.wait(testConfig, 1);
		
		Element.click(btnNo, "No Button of PopUp");
		Browser.verifyURL(testConfig, "validateEFTERAProviderContact.do");
		
		Browser.wait(testConfig, 2);
		Element.click(btnCancEnroll, "Cancel Enroll Button");
		Browser.wait(testConfig, 2);
		
		Element.click(btnYes, "YES Button of PopUp");
		Browser.verifyURL(testConfig, "registrationSignIn.do");
	}
	public void verifyErrors()
	{
		Element.clickByJS(testConfig, btnContinue, "Continue");
		ArrayList <String> errNames=new ArrayList<String>();
		errNames.add("- Financial Institution Information - Financial Institution / Bank Name");
		errNames.add("- Financial Institution Information - Street");
		errNames.add("- Financial Institution Information - City");
		errNames.add("- Financial Institution Information - State");
		errNames.add("- Financial Institution Information - Zip");
		errNames.add("- Financial Institution Information - Phone");
		errNames.add("- Financial Institution Information - Financial Institution Routing Number");
		errNames.add("- Financial Institution Information - Provider's Account Number with Financial Institution");
		errNames.add("- Financial Institution Information - Upload Voided Check/Bank Letter");
		
		ArrayList <String> webErrNamesText=new ArrayList<String>(); ;
		int i=1;
			while(i<10){
			String xpath="//form[@id=\"EFTERAregForm\"]/section[1]/fieldset[1]/legend/div/ul/"+"li"+"["+i+"]"+"/a";
			
			if (Element.findElement(testConfig, "xpath", xpath).getTagName().equals("a"))
			{
			webErrNamesText.add(Element.findElement(testConfig, "xpath", xpath).getText());
			xpath=null;
			i++;
			}
			}
		
		Helper.compareEquals(testConfig, "", errNames, webErrNamesText);
	verifyErrorMessages();
	}
	public void verifyErrorMessages()
	{
		
		
			String expectedText="Missing Data";
			String expectedColor="#c21926";
			
			Log.Comment("Verifying Error Msg is displayed for Financial Institution / Bank Name...");
			WebElement welt=finInstName.findElement(By.xpath("..//following::p"));
			//Element.verifyTextPresent(finInstName.findElement(By.xpath("../following::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in Finantial Institution/Bank text box" , expectedColor, Color.fromString(finInstName.getCssValue("border-top-color")).asHex());

//			Log.Comment("Verifying Error Msg is displayed for Finantial Institution Street...");
//			Element.verifyTextPresent(finInstStreet.findElement(By.xpath("following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Street Text Box..." , expectedColor, Color.fromString(finInstStreet.getCssValue("border-top-color")).asHex());
//
//
//			Log.Comment("Verifying Error Msg is displayed for Finantial Institution city...");
//			Element.verifyTextPresent(finInstCity.findElement(By.xpath("../following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted in City text box" , expectedColor, Color.fromString(finInstCity.getCssValue("border-top-color")).asHex());
//
//			Log.Comment("Verifying Error Msg is displayed for Finantial Institution  state...");
//			Element.verifyTextPresent(finInstState.findElement(By.xpath("../following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted in State text box" , expectedColor, Color.fromString(finInstState.getCssValue("border-top-color")).asHex());
//
//			Log.Comment("Verifying Error Msg is displayed for Finantial Institution  Telephone...");
//			Element.verifyTextPresent(finInstPhone1.findElement(By.xpath("../following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Telephone textbox" , expectedColor, Color.fromString(finInstPhone1.getCssValue("border-top-color")).asHex());
//
//			Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");
//
//			Element.verifyTextPresent(finInstZip1.findElement(By.xpath("//following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code" , expectedColor, Color.fromString(finInstZip2.getCssValue("border-top-color")).asHex());
//
//			Log.Comment("Verifying Error Msg is displayed for Financial Institution Routing Number..");
//			Element.verifyTextPresent(finInstRoutNum.findElement(By.xpath("../following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Fin Ins Routing No" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-top-color")).asHex());
//
//			Log.Comment("Verifying Error Msg is displayed for Provider's Account Number..");
//			Element.verifyTextPresent(finInstAcctNum.findElement(By.xpath("../following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Provider's AC No field" , expectedColor, Color.fromString(finInstAcctNum.getCssValue("border-top-color")).asHex());
//
//			Log.Comment("Verifying Error Msg is displayed for Voided Check");
//			Element.verifyTextPresent(finInstFile.findElement(By.xpath("../following-sibling::p")), expectedText);
//			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Upload voided Check" , expectedColor, Color.fromString(finInstFile.getCssValue("border-top-color")).asHex());
//

	}
	public UploadW9 clickContinue() {
		Element.clickByJS(testConfig, btnContinue, "Continue");
		return new UploadW9(testConfig) ;
	}
	

	public  FinancialInstitutionInfoPageNPI clickContinueNPI() {
		Element.clickByJS(testConfig, btnContinue, "Continue for NPI");
		return new FinancialInstitutionInfoPageNPI(testConfig);
	}


	public SelectPaymentMethods clickContinueAV() {
		Element.clickByJS(testConfig, btnContinue, "Continue");
		return new SelectPaymentMethods(testConfig) ;
	}
	
	public FinancialInstitutionInfoPage fillFinancialInstInfo() throws IOException
	{
		String expectedText="To help ensure the security of your account, you must enter a physical address for your financial institution. PO Boxes are not allowed.";
	//	Element.verifyTextPresent(txtSecurity, expectedText);
		String financialInstName = Helper.generateRandomAlphabetsString(4);
		String financialInstStreet = Helper.generateRandomAlphabetsString(5);
		String phNo = Long.toString(Helper.generateRandomNumber(3));
		String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
		Element.enterData(finInstName, financialInstName,"Enter financial Institution name","finInstName");
		Element.enterData(finInstStreet, financialInstStreet,"Enter financial Institution street","finInstStreet");
        Element.enterData(finInstPhone1, phNo,"Entered first three digits of phone number","finInstPhone1");
		Element.enterData(finInstPhone2, phNo,"Entered second three digits of phone number","finInstPhone2");
		Element.enterData(finInstPhone3, phNoLstField,"Entered last four digits of phone number","finInstPhone3");
		enrollmentInfoPageObj.setFinInstName(financialInstName);
		enrollmentInfoPageObj.setFinPhoneNo(phNo+phNo+phNoLstField);
		enrollmentInfoPageObj.setFinStreet(financialInstStreet);
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
		enrollmentInfoPageObj.setFinDocCode("BL");
		Browser.waitForLoad(testConfig.driver);
		Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnBrowse");
		Browser.wait(testConfig,2);
	}
	
	public void fillFinancialInstInfoFromExcel() throws IOException 
	{
	  int rowNo=1;
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
	
	  enrollmentInfoPageObj.setFinState(stateName);
	  enrollmentInfoPageObj.setFinCity(cityName);
	  enrollmentInfoPageObj.setFinZip(zipCode);
	  enrollmentInfoPageObj.setFinAcntNo(accountNo);
	  enrollmentInfoPageObj.setFinRoutingNo(routingNo);
//	  Element.enterData(element, data, description, namOfElement);
    }
	
	public FinancialInstitutionInfoPage clickYestoNPI()
	{
		  Element.clickByJS(testConfig,rdoNPIYes , "YES NPI");
		  return this;
	}
}
