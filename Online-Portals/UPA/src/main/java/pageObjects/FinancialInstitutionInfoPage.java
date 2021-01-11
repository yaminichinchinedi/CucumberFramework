package main.java.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
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

	@FindBy(id="checking")
	WebElement chkAcnt;
	@FindBy(xpath = "//input[@name='finInstTinAcctType'][2]")
	WebElement rdoSavings;
	@FindBy(id="savings")
	WebElement SavingAcnt;
	
	@FindBy(name = "msgFile")
	WebElement finInstFile;

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
	
	@FindBy(id="checking")
	WebElement NPIAcyes;

	@FindBy(id="no")
	WebElement NPIAcno;
	
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
	
	@FindBy(name = "btnCancel")
	WebElement btnCancel;
	
	@FindBy(linkText="SAVE CHANGES")
	WebElement saveChanges;
	
	@FindBy(xpath="//div[@class='modal modal-routing']//div[@class='modal-container lg-modal fixed-modal']")
	WebElement routingNumberPopup;
	
	//@FindBy(xpath=".//*[@id='EFTERAregForm']//section[2]/fieldset/div[2]/a")
	@FindBy(xpath="//*[@id='div2']/section/fieldset/div[2]/a")

	WebElement routingNumberLink;

	@FindBy(xpath="//div[@class='modal modal-routing']//div[@class='modal-container lg-modal fixed-modal']/div[1]/h4")
	WebElement routingNumPopupheader; 
	
	@FindBy(xpath="//div[@class='modal modal-routing']//div[@class='modal-container lg-modal fixed-modal']/div[2]/p")
	WebElement routingNumPopupText;
	
	@FindBy(xpath="//div[@class='modal modal-routing']//div[@class='modal-container lg-modal fixed-modal']/div[3]/a")
	WebElement routingPopupClose;
	
	//@FindBy(xpath=".//*[@id='EFTERAregForm']//section[2]/fieldset/div[5]/div/div/div[3]/a")
	@FindBy(xpath="//*[@id='finInstTinNpiAcctYorN']/div/div/div[3]/a")
	WebElement multipleNPILink;
	
	@FindBy(xpath="//div[@class='modal modal-tip']//div[@class='modal-container help-modal fixed-modal']")
	WebElement mutipleNPIPopup;
	
	@FindBy(xpath="//div[@class='modal modal-tip']//div[@class='modal-container help-modal fixed-modal']/div[1]/h4")
	WebElement mutipleNPIPopupHeader;
	
	@FindBy(xpath="//div[@class='modal modal-tip']//div[@class='modal-container help-modal fixed-modal']/div[2]/p")
	WebElement mutipleNPIPopupText;
	
	@FindBy(xpath="//div[@class='modal modal-tip']//div[@class='modal-container help-modal fixed-modal']/div[3]/a")
	WebElement mutipleNPIPopupClose;
	
	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List <WebElement> finInsInfoHeaders;
	
	//@FindBy(xpath=".//*[@id='EFTERAregForm']//section[2]/fieldset/div[4]/div[3]/a[2]")
	@FindBy(xpath="//*[@id='msgFile']/a[2]")
	WebElement editVoidedCheck;
	
	@FindBy(xpath="//div[@class='error']//ul//li")
	List <WebElement> individualErrors;
	
	@FindBy(xpath ="//div[@class='error']//h4")
	WebElement errorHeader;
	
	@FindBy(name = "msgFile")
	WebElement btnBrowse;
	
	@FindBy(id="bankDetailp")
	WebElement bnkdtls;
	protected TestBase testConfig;
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();

	public FinancialInstitutionInfoPage(TestBase testConfig) 
	{
		super(testConfig);
		String expectedURL = "/validateEFTERAProviderContact";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		String actualURL=Browser.getURL(testConfig);
		if(actualURL.contains("validateEFTERAProviderContact"))
			Browser.verifyURL(testConfig, expectedURL);
		else if(actualURL.contains("backefterafinancialinfonpi"))
		{
			expectedURL="/backefterafinancialinfonpi";
			Browser.verifyURL(testConfig, expectedURL);
		}
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
		
		Browser.wait(testConfig, 5);
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
	
	public void checkABNValidator()
	{
		WebElement ABAdown=Element.findElement(testConfig, "xpath", "//*[contains(text(),'Service is down,please try again.')]");
		if (  ABAdown == null)
		Log.Comment("Server is up.");
		else
		Log.Fail("Server is down.Please make it up.");			
	}
	public FinancialInstitutionInfoPage fillFinancialInstInfoFromABA(String routingNo) throws IOException 
	{
		  int rowNo=1;
		  TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		  if (routingNo== null)
		  {
		  Element.clearData(finInstRoutNum, "Routing Num");
		  //finInstRoutNum.sendKeys(Keys.TAB);
		  Element.enterKeys(finInstRoutNum, Keys.TAB, "TAB Key entering", "TAB Key");		  }
		 else
		  Element.enterData(finInstRoutNum, routingNo,"Read from excel and Enter Routing Number","finInstRoutNum");
		  
		  String accountNo =data.GetData(rowNo, "AccountNumber");
		  Element.enterData(finInstAcctNum, accountNo,"Read from excel and Enter Account Number","finInstAcctNum");
		  verifyErrorMsgABN(routingNo);
		
		 return this;
    }

	public void verifyErrorMsgABN(String routingNo){
		

		String expectedColor= "rgb(189, 60, 55)";
        Element.verifyTextPresent(Element.findElement(testConfig, "xpath", "//div[@id='headingErrorForInvalidRtn']/ul/li/a"), "- Financial Institution Information - Financial Institution Routing Number");
        Log.Comment("Verifying Error Msg is displayed for Financial Inst Name..");
	    
        //Null value
        if (routingNo==null){
        String expectedText="Missing Data";
        Element.verifyTextPresent(Element.findElement(testConfig, "xpath", "//div[@id='bankDetailMissingError']/p"), expectedText);
        }
        
	    //9 but incorrect RTN
        else if (routingNo.length()==9 && routingNo.matches("[^[0-9]]*$")){
        Browser.wait(testConfig, 5);
         String expectedVal="No Financial Institution match found for this routing number"+" "+"- Please enter again";
	    String actVal1=Element.findElement(testConfig, "xpath", "//div[@id='bankDetailInvalidErrorTryAgain']/p[1]").getText();
	    String actVal2=Element.findElement(testConfig, "xpath", "//div[@id='bankDetailInvalidErrorTryAgain']/p[2]").getText();
	    String actVal=actVal1+" "+actVal2;
	    Helper.compareEquals(testConfig, "Verify Error message" , expectedVal, actVal);
        }
       //Less than 9 and Alphanumeric
        else if (routingNo.length()!=9 || routingNo.matches("[^[a-zA-Z0-9]]*$")){
	    String expectedTextInvalid="Invalid Data";  
	    Element.verifyTextPresent(Element.findElement(testConfig, "xpath", "//div[@id='bankDetailInvalidError']/p"), expectedTextInvalid);
        }
	   Browser.wait(testConfig, 2);
	    Helper.compareEquals(testConfig, "Verify Red color is highlighted in Financial Routing No" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-color")).asRgb());
			
		
	}
	
	
	public FinancialInstitutionInfoPage clearNfillRTNNoABA() throws IOException 
	{
	  
		  	  
		  int rowNo=16;
		  TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		  List<String>ValidRoutNos=data.GetAllColumnsData("FinancialInfo","ValidRoutingNos");
		  String routingNo =data.GetData(rowNo, "RoutingNumber");
		  String accountNo =data.GetData(rowNo, "AccountNumber");
		  if( ValidRoutNos.contains(routingNo))
		  {  
		  Element.clearData(finInstRoutNum, "Routing No");
		  Element.enterData(finInstRoutNum, routingNo,"Read from excel and Enter Routing Number","finInstRoutNum");
		  Element.enterData(finInstAcctNum, accountNo,"Read from excel and Enter Account Number","finInstAcctNum");
		 // finInstAcctNum.sendKeys(Keys.TAB);
		  Element.enterKeys(finInstAcctNum, Keys.TAB, "TAB Key entering", "TAB Key");
		  Browser.wait(testConfig, 2);
		  //Check for the API down message "Service is down, please try again."
		  Element.waitForPresenceOfElementLocated(testConfig,By.id("bankDetailp"), 60);
		  Browser.wait(testConfig, 5);
		  WebElement AddronUI=Element.findElement(testConfig, "id", "bankDetailp");
		  String AddronUIText=AddronUI.getText();
		  try{
		  AddronUI.sendKeys("12");
		  }
		  catch(WebDriverException e){
		  Log.Comment("readOnly field");
		  }

		  String spChar="!#$%&'()*+./:;<=>?@[]^_`{|}";
		  for (int i = 0; i < AddronUIText.length(); i++) {
			    
			    if (spChar.contains(Character.toString(AddronUIText.charAt(i))))
			    {
			    Log.Warning((AddronUIText.charAt(i)+": is a special character"),testConfig);
			    }  
			  }
		  String[] Bankdetails=AddronUIText.split("\n");
		  List<String> UIBankDetails=Arrays.asList(Bankdetails);
		  //Validate that it does contain any special character
		  List<String>ValidAddr=data.GetAllColumnsData("FinancialInfo","ValidAddr2");
		  ValidAddr.add(3, "");
		  Helper.compareEquals(testConfig, "UI and Actual Compasision", ValidAddr, UIBankDetails);

		 String zip=ValidAddr.get(2).toString().substring(ValidAddr.get(2).toString().length()-10);
		 if (zip.length()==5 || ( zip.length()==10 || ( zip.substring(5,6).equals("-"))))
		 {}
		 else
		 Log.Fail("Zip length is not 5 or '-' is missing between them");	 
		 String phone=ValidAddr.get(4);
		 
		 if ( phone.substring(3,4).equals("-")  &&  phone.substring(7,8).equals("-")  )
		 {}
		 else
		 {
			 Log.Fail(" '-' is missing between phone nos");	 
		 }
		  enrollmentInfoPageObj.setFinAcntNo(accountNo);
		  enrollmentInfoPageObj.setFinRoutingNo(routingNo);
		  enrollmentInfoPageObj.setFinInstName(UIBankDetails.get(0));
		 }
		  else
			  Log.Fail("Please proceed with valid RTN");
		 
	   Element.click(saveChanges, "Save Changes Button");

		return this;
    }

	
	public FinancialInstitutionInfoPage fillFinancialInstInfoFromExcelABA() throws IOException 
	{
	  
		  Helper.compareEquals(testConfig, "Continue Button", "true", btnContinue.getAttribute("disabled"));	  
		  int rowNo=1;
		  TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		  List<String>ValidRoutNos=data.GetAllColumnsData("FinancialInfo","ValidRoutingNos");
		  String routingNo =data.GetData(rowNo, "RoutingNumber");
		  String accountNo =data.GetData(rowNo, "AccountNumber");
		  if( ValidRoutNos.contains(routingNo))
		  {  
		  Element.enterData(finInstRoutNum, routingNo,"Read from excel and Enter Routing Number","finInstRoutNum");
		  Element.enterData(finInstAcctNum, accountNo,"Read from excel and Enter Account Number","finInstAcctNum");
		  //finInstAcctNum.sendKeys(Keys.TAB);
		  Element.enterKeys(finInstAcctNum, Keys.TAB, "TAB Key entering", "TAB Key");
		  Browser.wait(testConfig, 2);
		  Element.waitForPresenceOfElementLocated(testConfig,By.id("bankDetailp"), 60);
		  Browser.wait(testConfig, 8);
		  WebElement AddronUI=Element.findElement(testConfig, "id", "bankDetailp");
		  String AddronUIText=AddronUI.getText();
		  try{
		  AddronUI.sendKeys("12");
		  }
		  catch(WebDriverException e){
		  Log.Comment("readOnly field");
		  }
		  //Validate that it does contain any special character
		  String spChar="!#$%&'()*+./:;<=>?@[]^_`{|}";
		  for (int i = 0; i < AddronUIText.length(); i++) {
			    
			    if (spChar.contains(Character.toString(AddronUIText.charAt(i))))
			    {
			    Log.Warning((AddronUIText.charAt(i)+": is a special character"),testConfig);
			    }  
			  }
		  String[] Bankdetails=AddronUIText.split("\n");
		  List<String> UIBankDetails=Arrays.asList(Bankdetails);
		  List<String>ValidAddr=data.GetAllColumnsData("FinancialInfo","ValidAddr");
		  ValidAddr.add(3, "");
		  Helper.compareEquals(testConfig, "UI and Actual Compasision", ValidAddr, UIBankDetails);
		  Element.verifyElementVisiblity(btnContinue, "Continue Button");
		 String zip=ValidAddr.get(2).toString().substring(ValidAddr.get(2).toString().length()-10);

		 
		 if (!(zip.length()==5 || ( zip.length()==10 && ( zip.substring(5,6).equals("-")))))
		 Log.Fail("Zip length is not 5 or '-' is missing between them");
		 
		 
		 String phone=ValidAddr.get(4);
		 if (!( phone.substring(3,4).equals("-")  &&  phone.substring(7,8).equals("-") ) )
		 Log.Fail(" '-' is missing between phone nos");	 
		 
		  uploadBankLetterPdfWithAcceptance();
		  enrollmentInfoPageObj.setFinAcntNo(accountNo);
		  enrollmentInfoPageObj.setFinRoutingNo(routingNo);
		  enrollmentInfoPageObj.setFinInstName(UIBankDetails.get(0));
		 }
		  else
			  Log.Fail("Please proceed with valid RTN");
		 
		
		return this;
    }
	
	
	public FinancialInstitutionInfoPage fillFinancialInstWrngInfo(String inpType ) throws IOException
	{
		String financialInstName = Helper.generateRandomAlphabetsString(4);
		String financialInstStreet=null;
		if (inpType.equals("Street"))
		     financialInstStreet = "PO BOX 7530";
		else
			 financialInstStreet = Helper.generateRandomAlphabetsString(5);
		String phNo = Long.toString(Helper.generateRandomNumber(3));
		String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
		Element.enterData(finInstName, financialInstName,"Enter financial Institution name","finInstName");
		Element.enterData(finInstStreet, financialInstStreet,"Enter financial Institution street","finInstStreet");
        Element.enterData(finInstPhone1, phNo,"Entered first three digits of phone number","finInstPhone1");
		Element.enterData(finInstPhone2, phNo,"Entered second three digits of phone number","finInstPhone2");
		Element.enterData(finInstPhone3, phNoLstField,"Entered last four digits of phone number","finInstPhone3");
		
		int rowNo=1;
		  TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		  String cityName =data.GetData(rowNo, "City");
		  String stateName =data.GetData(rowNo, "State");
		  String zipCode =data.GetData(rowNo, "ZipCode");
		  String routingNo =data.GetData(rowNo, "RoutingNumber");
		  String accountNo =data.GetData(rowNo, "AccountNumber");
		  Element.enterData(finInstCity, cityName,"Read from excel and Enter City name","finInstCity");
		  Element.selectVisibleText(finInstState, stateName,"Select City from excel");
		  if (inpType.equals("Zip"))
		  Element.enterData(finInstZip1, Long.toString(Helper.generateRandomNumber(5)),"Random Zip No","finInstZip1");
		  else
		  Element.enterData(finInstZip1, zipCode,"Read from excel and Enter Zip 1","finInstZip1");
		  Element.enterData(finInstRoutNum, routingNo,"Read from excel and Enter Routing Number","finInstRoutNum");
		  Element.enterData(finInstAcctNum, accountNo,"Read from excel and Enter Account Number","finInstAcctNum");
		  //Element.clickByJS(testConfig,rdoNPIYes , "YES NPI");
		
		  Browser.wait(testConfig, 2);
			Element.clickByJS(testConfig,rdoBankLetter, "Bank Letter radio button");
			enrollmentInfoPageObj.setFinDocCode("BL");
			Browser.waitForLoad(testConfig.driver);
			if (inpType.equals("uploadFile"))
			Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("DataFile"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("DataFile"), "btnBrowse");
			else
				Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnBrowse");	
			Browser.wait(testConfig,2);
		  
		  enrollmentInfoPageObj.setFinInstName(financialInstName);
		enrollmentInfoPageObj.setFinPhoneNo(phNo+phNo+phNoLstField);
		enrollmentInfoPageObj.setFinStreet(financialInstStreet);
		enrollmentInfoPageObj.setFinState(stateName);
		  enrollmentInfoPageObj.setFinCity(cityName);
		  enrollmentInfoPageObj.setFinZip(zipCode);
		  enrollmentInfoPageObj.setFinAcntNo(accountNo);
		  enrollmentInfoPageObj.setFinRoutingNo(routingNo);
		//fillFinancialInstInfoFromExcel();
		
		//uploadBankLetterPdfWithAcceptance();
		Element.clickByJS(testConfig, btnContinue, "Continue");
		Browser.wait(testConfig, 2);
		if (inpType.equals("Street"))
		{
			String expectedText="PO Boxes are not accepted";
		Log.Comment("Verifying Error Msg is displayed for Street");
		Element.verifyTextPresent(Element.findElement(testConfig,"xpath","//input[@name='finInstTinStreet']//following-sibling::p"), expectedText);
	   }
		if (inpType.equals("uploadFile"))
		{
		String expectedText="File Format must be 'PDF', 'JPEG', 'GIF' or 'PNG'";
		Log.Comment("Verifying Error Msg is displayed for Upload Bank Letter");
		Element.verifyTextPresent(Element.findElement(testConfig,"xpath","//*[@id='msgFile']/div/p"), expectedText);
	   }
		if (inpType.equals("Zip"))
		{
		String expectedText="Invalid for City/State";
		Log.Comment("Verifying Error Msg is displayed for Zip");
		Element.verifyTextPresent(Element.findElement(testConfig,"xpath","//*[@id='finInstTinZip1']/p[2]"), expectedText);
	   }
		return this;
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
	
	public void verifyFinAccount(String verifiableItems)
	{
		switch(verifiableItems){
		
		case "TypeOfAc" :
		Element.verifyElementIsChecked(chkAcnt, "Checking finantial Account");
		Browser.wait(testConfig, 3);
		Element.clickByJS(testConfig,SavingAcnt, "Saving Account");
		Browser.wait(testConfig, 2);
		Element.verifyElementIsChecked(SavingAcnt, "Saving Account");		
		break;
		
		case "SupportDoc" :
		Element.verifyElementIsChecked(voidChk, "Voided Check");
		Browser.wait(testConfig, 3);
		Element.clickByJS(testConfig,rdoBankLetter, "Bank Letter");
		Browser.wait(testConfig, 2);
		Element.verifyElementIsChecked(rdoBankLetter, "Bank Letter");
		break;
		
		case "NPIBankAc" :
		Element.verifyElementIsChecked(NPIAcno, "NPI Account No");
		Browser.wait(testConfig, 3);
		Element.clickByJS(testConfig,NPIAcyes, "NPI Account Yes");
		Browser.wait(testConfig, 2);
		Element.verifyElementIsChecked(NPIAcyes, "NPI Account Yes");
		break;
		
		}
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
		
		
		ArrayList <String> expectedURLs=new ArrayList<String>(); 
		expectedURLs.add("finInstTinNameId");
		expectedURLs.add("finInstTinStreet");
		expectedURLs.add("finInstTinCity");
		expectedURLs.add("finInstTinState");
		expectedURLs.add("finInstTinZip1");
		expectedURLs.add("finInstTinPhone1");
		expectedURLs.add("finInstTinRoutNum");
		expectedURLs.add("finInstTinAcctNum");
		expectedURLs.add("msgFile");
		
		ArrayList <String> webErrNamesText=new ArrayList<String>();
		int i=1;
			while(i<10){
			String xpath="//form[@id=\"EFTERAregForm\"]/div[2]/section[1]/fieldset[1]/legend/div/ul/"+"li"+"["+i+"]"+"/a";
			 
			if (Element.findElement(testConfig, "xpath", xpath).getTagName().equals("a"))
			{
			webErrNamesText.add(Element.findElement(testConfig, "xpath", xpath).getText());
			Element.findElement(testConfig, "xpath", xpath).click();
			Browser.verifyURL(testConfig, expectedURLs.get(i-1));
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
			Element.verifyTextPresent(finInstName.findElement(By.xpath("..//following::p[1]")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in Finantial Institution/Bank text box" , expectedColor, Color.fromString(finInstName.getCssValue("border-top-color")).asHex());
	//	  Element.clickByJS(testConfig,rdoNPIYes , "YES NPI");
			Log.Comment("Verifying Error Msg is displayed for Finantial Institution Street...");
			Element.verifyTextPresent(finInstStreet.findElement(By.xpath("following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Street Text Box..." , expectedColor, Color.fromString(finInstStreet.getCssValue("border-top-color")).asHex());


			Log.Comment("Verifying Error Msg is displayed for Finantial Institution city...");
			Element.verifyTextPresent(finInstCity.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in City text box" , expectedColor, Color.fromString(finInstCity.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Finantial Institution  state...");
			Element.verifyTextPresent(finInstState.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in State text box" , expectedColor, Color.fromString(finInstState.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Finantial Institution  Telephone...");
			Element.verifyTextPresent(finInstPhone1.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Telephone textbox" , expectedColor, Color.fromString(finInstPhone1.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");

			Element.verifyTextPresent(finInstZip1.findElement(By.xpath("..//following::p[1]")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code" , expectedColor, Color.fromString(finInstZip2.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Financial Institution Routing Number..");
			Element.verifyTextPresent(finInstRoutNum.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Fin Ins Routing No" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Provider's Account Number..");
			Element.verifyTextPresent(finInstAcctNum.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Provider's AC No field" , expectedColor, Color.fromString(finInstAcctNum.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Voided Check");
			Element.verifyTextPresent(finInstFile.findElement(By.xpath("//*[@id='msgFile']/div/p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Upload voided Check" , expectedColor, Color.fromString(finInstFile.getCssValue("border-top-color")).asHex());
	}
	
	
	public FinancialInstitutionInfoPage verifyUITextFromDB() throws IOException  
	{
		//int sqlRowNo=172;
		int sqlRowNo=240;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
		
		Helper.compareEquals(testConfig, "Finantial Institution Informatioon", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/div[2]/section[1]/fieldset[1]/legend/h1")).getText(), dataTest.get(53).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Informatioon", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/div[2]/section[1]/fieldset[1]/p[1]")).getText(), dataTest.get(50).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Informatioon", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/div[2]/section[1]/fieldset[1]/h4[1]/strong")).getText(), dataTest.get(32).get("TEXT_VAL"));
		String text=(Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/div[2]/section[1]/fieldset[1]/p[2]")).getText();
		int endIndex=text.indexOf(":");
		Helper.compareEquals(testConfig, "Finantial Institution Informatioon",text.substring(0, endIndex+1) , dataTest.get(31).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Informatioon", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/div[2]/section[1]/fieldset[1]/h4[2]/strong")).getText(), dataTest.get(51).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Name", (finInstName.findElement(By.xpath("//preceding::label[1]"))).getText(), dataTest.get(22).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Street", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinStreet']/label")).getText(), dataTest.get(44).get("TEXT_VAL"));
		//div[@id="finInstTinStreet"]/label
		Helper.compareEquals(testConfig, "Finantial Institution City", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinCity']/label")).getText(), dataTest.get(43).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution State", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinState']/label")).getText(), dataTest.get(42).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Zip Code", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinZip1']/legend")).getText(), dataTest.get(41).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Phone", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinPhone1']/legend")).getText(), dataTest.get(40).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Routing No", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinRoutNum']/div/label")).getText(), dataTest.get(38).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Ac no", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinAcctNum']/label")).getText(), dataTest.get(37).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Ac no", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinAcctNum']/label")).getText(), dataTest.get(37).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Type of Ac", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinAcctType']/div/p[1]/label")).getText(), dataTest.get(35).get("TEXT_VAL"));
		//Helper.compareEquals(testConfig, "Finantial Institution Voided Check", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/div[2]/section[2]/fieldset/div[4]/p[1]/label")).getText(), dataTest.get(21).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Voided Check", (Element.findElement(testConfig, "xpath", "//div[@id='secondportiontohide']/div[2]/p[1]/label")).getText(), dataTest.get(21).get("TEXT_VAL"));

		Helper.compareEquals(testConfig, "Finantial Institution Msg File", (Element.findElement(testConfig, "xpath", "//div[@id='uploadVC']/p")).getText(), dataTest.get(17).get("TEXT_VAL")+dataTest.get(15).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution NPI bank AC", (Element.findElement(testConfig, "xpath", "//div[@id='finInstTinNpiAcctYorN']/div/p[1]/label")).getText(), dataTest.get(14).get("TEXT_VAL"));
	
		  return this;
	}
	
	public FinancialInstitutionInfoPage clickYestoNPI()
	{
		  Element.clickByJS(testConfig,rdoNPIYes , "YES NPI");
		  return this;
	}
	
    public void validateCanclSaveButtons()
    
	{
		Helper.compareContains(testConfig, "Save Changes", "SAVE CHANGES", saveChanges.getText());
		Helper.compareContains(testConfig, "Cancel Changes", "Cancel Changes", btnCancel.getAttribute("value"));
	}
    
    public void clickCancelChanges() {
		Element.clickByJS(testConfig, btnCancel, "btnCancel");
	}
    
    public void validateRoutingNumberPopup() throws IOException {

    	int sqlRowNo=175;
    	Element.clickByJS(testConfig,routingNumberLink ,"Routing Number Link");
    	Element.verifyElementPresent(routingNumberPopup, "Where can i see Routing Number Pop up");
    	HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
    	Helper.compareContains(testConfig, "Business Info Text", dataTest.get(1).get("TEXT_VAL"), routingNumPopupheader.getText());
    	Helper.compareContains(testConfig, "Business Info Text", dataTest.get(2).get("TEXT_VAL"), routingNumPopupText.getText());
    	Element.clickByJS(testConfig, routingPopupClose ,"Close Popup");
    }

    public void validateMultipleNPIPopup() throws IOException {

    	Element.clickByJS(testConfig,multipleNPILink ,"How do I manage Multiple NPI Bank accounts Link");
    	Element.verifyElementPresent(mutipleNPIPopup, "Where can i see Routing Number Pop up");
        int sqlRowNo=176;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		Helper.compareContains(testConfig, "Business Info Text", dataTest.get(1).get("TEXT_VAL"), mutipleNPIPopupHeader.getText());
		Helper.compareContains(testConfig, "Business Info Text", dataTest.get(2).get("TEXT_VAL")+ dataTest.get(3).get("TEXT_VAL"), mutipleNPIPopupText.getText());
		Element.clickByJS(testConfig, mutipleNPIPopupClose ,"Close Popup");
    }
    
    public void validateCancelChanges() {
  		Element.clickByJS(testConfig, editVoidedCheck, "EDIT");
  		if(!btnCancel.isEnabled()) 
  			Log.Comment("Cancel Button is Disabled");
  		//return new UploadW9(testConfig) ;
  	}
    
    public void verifyErrorMsg()
	{
    	clearFinsInstInfoFields();
    	Element.clickByJS(testConfig, editVoidedCheck, "EDIT");
		Element.click(saveChanges, "Save Changes Button");
		
		List <String> expectedErrorMsgs;
		Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		 expectedErrorMsgs=Arrays.asList("- Financial Institution Information - Financial Institution / Bank Name","- Financial Institution Information - Street","- Financial Institution Information - City","- Financial Institution Information - State","- Financial Institution Information - Zip","- Financial Institution Information - Phone","- Financial Institution Information - Financial Institution Routing Number","- Financial Institution Information - Provider's Account Number with Financial Institution","- Financial Institution Information - Upload Voided Check/Bank Letter");
		for(int i=0;i<expectedErrorMsgs.size();i++)
		{
			Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));
		}
		
		verifyFinInsMissingDataErrorMsg();
		
	}
    public void clearFinsInstInfoFields(){
    	
    	Element.clearData(finInstName,  "Financial Institution/Bank Name"); 
		Element.clearData(finInstStreet,  "Street");
		Element.clearData(finInstPhone1,  "Ph Filed 1");
		Element.clearData(finInstPhone2,  "Ph Filed 2");
		Element.clearData(finInstPhone3,  "Ph Filed 3");
		Element.clearData(finInstCity,  "City");
		Element.clearData(finInstZip1,  "Zip");
		Element.clearData(finInstRoutNum,  "Routing Number");
		Element.clearData(finInstAcctNum,  "Account Number");
		Element.selectByVisibleText(finInstState, "Select State", "default select state option");
		
		
    }
    public void verifyFinInsMissingDataErrorMsg()
	{
		String expectedText="Missing Data";
		String expectedColor="#c21926";
		
		Log.Comment("Verifying Error Msg is displayed for Financial Inst Name..");
		Element.verifyTextPresent(finInstName.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Financial Inst Name box" , expectedColor, Color.fromString(finInstName.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Street..");
		Element.verifyTextPresent(finInstStreet.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street box" , expectedColor, Color.fromString(finInstStreet.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Phone Number filed1 ..");
		Element.verifyTextPresent(finInstPhone1.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 1 box" , expectedColor, Color.fromString(finInstPhone1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Phone Number filed2..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 2 box" , expectedColor, Color.fromString(finInstPhone2.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Phone Number filed3..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 3 box" , expectedColor, Color.fromString(finInstPhone3.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for City ..");
		Element.verifyTextPresent(finInstCity.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in City box" , expectedColor, Color.fromString(finInstCity.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for State ..");
		Element.verifyTextPresent(finInstState.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in State box" , expectedColor, Color.fromString(finInstState.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code ..");
		Element.verifyTextPresent(finInstZip1.findElement(By.xpath("../following-sibling::p[1]")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Zip/Postal Code text box" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Routing Number ..");
		Element.verifyTextPresent(finInstRoutNum.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Routing Number" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Account Number ..");
		Element.verifyTextPresent(finInstAcctNum.findElement(By.xpath("./following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Account Number" , expectedColor, Color.fromString(finInstAcctNum.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Upload a voided check..");
		Element.verifyTextPresent(btnBrowse.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Upload a voided check " , expectedColor, Color.fromString(btnBrowse.getCssValue("border-top-color")).asHex());
		
	}
    
    public void validateInvalidDataErrorMsg() {
    	
    	String expectedText="PO Boxes are not accepted";
		String expectedColor="#c21926";
		
    	Element.enterData(finInstStreet, "PO BOX","Enter financial Institution street","finInstStreet");
    	Element.enterData(finInstZip1, "70165","Read from excel and Enter Zip 1","finInstZip1");
    	 Element.enterData(finInstRoutNum, "107005318","Read from excel and Enter Routing Number","finInstRoutNum");
    	Element.click(saveChanges, "Save Changes Button");
    	
    	List <String> expectedErrorMsgs;
    	expectedErrorMsgs=Arrays.asList("- Financial Institution Information - Street","- Financial Institution Information - Zip","- Financial Institution Information - Financial Institution Routing Number");
    	Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
    	
    	for(int i=0;i<expectedErrorMsgs.size();i++)
		{
			Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));
		}
    	
    	Log.Comment("Verifying Error Msg is displayed for Street..");
		Element.verifyTextPresent(finInstStreet.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street box" , expectedColor, Color.fromString(finInstStreet.getCssValue("border-top-color")).asHex());
    	
		expectedText="Invalid for City/State";
		Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code ..");
		Element.verifyTextPresent(finInstZip1.findElement(By.xpath("../following-sibling::p[2]")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Zip/Postal Code text box" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
		
		expectedText="Invalid Data";
		Log.Comment("Verifying Error Msg is displayed for Routing Number ..");
		Element.verifyTextPresent(finInstRoutNum.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Routing Number" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-top-color")).asHex());
		
    }
    
    public void validateNonNumericErrorMsg() {
    	
    	String expectedText="Invalid Data";
    	String expectedColor="#c21926";
    	String zipcode=Helper.generateRandomAlphaNumericString(5);
    	String phNo = Long.toString(Helper.generateRandomNumber(2));
		String phNoLstField = Long.toString(Helper.generateRandomNumber(3));
		String nonNumericAccntNum = Helper.generateRandomAlphabetsString(10);
		String nonNumericRoutingNum = Helper.generateRandomAlphabetsString(9);
		Element.enterData(finInstZip1, zipcode,"Entered Alpha Numeric Zip code Number","finInstZip1");
        Element.enterData(finInstPhone1, phNo,"Entered first three digits of phone number","finInstPhone1");
		Element.enterData(finInstPhone2, phNo,"Entered second three digits of phone number","finInstPhone2");
		Element.enterData(finInstPhone3, phNoLstField,"Entered last four digits of phone number","finInstPhone3");
		Element.enterData(finInstRoutNum, nonNumericRoutingNum,"Enter Nonnumeric Routing Number","finInstRoutNum");
		Element.enterData(finInstAcctNum, nonNumericAccntNum,"Enter Nonnumeric Account Number","finInstAcctNum");
		Element.click(saveChanges, "Save Changes Button");
		
		List <String> expectedErrorMsgs;
    	expectedErrorMsgs=Arrays.asList("- Financial Institution Information - Zip","- Financial Institution Information - Phone","- Financial Institution Information - Financial Institution Routing Number","- Financial Institution Information - Provider's Account Number with Financial Institution");
    	Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		
    	for(int i=0;i<expectedErrorMsgs.size();i++)
		{
			Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));
		}
    	
    	Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code ..");
		Element.verifyTextPresent(finInstZip1.findElement(By.xpath("../following-sibling::p[1]")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Zip/Postal Code text box" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Routing Number ..");
		Element.verifyTextPresent(finInstRoutNum.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Routing Number" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Account Number ..");
		Element.verifyTextPresent(finInstAcctNum.findElement(By.xpath("./following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Account Number" , expectedColor, Color.fromString(finInstAcctNum.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Phone Number filed1 ..");
		Element.verifyTextPresent(finInstPhone1.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 1 box" , expectedColor, Color.fromString(finInstPhone1.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Phone Number filed2..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 2 box" , expectedColor, Color.fromString(finInstPhone2.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Phone Number filed3..");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 3 box" , expectedColor, Color.fromString(finInstPhone3.getCssValue("border-top-color")).asHex());
		
		if(!btnCancel.isEnabled()) 
		Log.Comment("Cancel Button is Disabled");
    }
    
    public void  VerifyValidFinInstInfo() throws IOException {
    	
    	clearFinsInstInfoFields();
    	Element.clickByJS(testConfig, editVoidedCheck, "EDIT");
    	fillFinancialInstInfo();
    	Browser.verifyURL(testConfig, "uploadefterafile.do?fromreview=y");
    	Element.click(saveChanges, "Save Changes Button");
    	Browser.verifyURL(testConfig, "validateEFTERAFinancialInfo.do?fromReview=Y");
    	
    }
    
    public void verifyEditable(){
		Helper.compareEquals(testConfig, "EditValeCheck", null, finInstStreet.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "EditValeCheck", null, finInstName.getAttribute("readonly"));
	}
    
	public void verifyUploadedDoc(){
		Element.clickByJS(testConfig, editVoidedCheck, "EDIT");
		Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("AnotherPdfPath"),"Entered path of another pdf file as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("AnotherPdfPath"), "btnBrowse");
		Browser.wait(testConfig,2);
		Element.clickByJS(testConfig, saveChanges, "Save Changes Button");
		}
	
	public FinancialInstitutionInfoPage fillFIIwithNonNumericPhone() throws IOException
	{
		Element.clickByJS(testConfig, editVoidedCheck, "EDIT");
		String financialInstName = Helper.generateRandomAlphabetsString(4);
		String financialInstStreet = Helper.generateRandomAlphabetsString(5);
		String phNo = Helper.generateRandomAlphabetsString(3);
		String phNoLstField =Helper.generateRandomAlphabetsString(4);
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
		Element.clickByJS(testConfig, saveChanges, "Continue");
		
		Log.Comment("Verifying Error Msg is displayed for Finantial Institution  Telephone...");
		Element.verifyTextPresent(finInstPhone1.findElement(By.xpath("..//following-sibling::p")), "Invalid Data");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Telephone textbox" , "#c21926", Color.fromString(finInstPhone1.getCssValue("border-top-color")).asHex());

		return this;
	}
	
	
}
