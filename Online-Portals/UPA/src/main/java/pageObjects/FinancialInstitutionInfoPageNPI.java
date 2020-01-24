package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import main.java.Utils.DataBase;
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
	
	@FindBy(id="file")
	WebElement btnBrowse;
	
	@FindBy(name="npienrollment_0")
	WebElement rdoBankLetter;
	
	@FindBy(id="yes")
	WebElement rdoNPIYes;

	@FindBy(id="no")
	WebElement rdoNPINo;

	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;
	
	@FindBy(xpath="//tr[4]/td/table/tbody/tr/td[2]")
	WebElement txtSecurity;
    
	@FindBy(partialLinkText="Where can I find a")
	WebElement txtFIIRoutNo;
	
	@FindBy(xpath="//a[@class='button--primary margin-left float-right btn-close']")
	WebElement closeTIP;
	
	@FindBy(id="checking")
	WebElement chkAcnt;

	@FindBy(id="savings")
	WebElement SavingAcnt;
	
	@FindBy(id="no")
	WebElement NPIAcno;

	@FindBy(id="checking")
	WebElement NPIAcyes;


	@FindBy(id="voided-check")
	WebElement voidChk;
	
	@FindBy(id="bank-letter")
	WebElement bnkLetter;
	
	@FindBy(partialLinkText= "How do I manage multiple NPI bank")
	WebElement lnkNPIBnk;
	
	@FindBy(linkText="CLOSE TIP")
	WebElement btnCloseTIP;
	
	@FindBy(linkText="BACK")
	WebElement btnBack;
	
	@FindBy(linkText="CANCEL ENROLLMENT")
	WebElement btnCancEnroll;
	
	@FindBy(linkText="YES")
	WebElement btnYes;
	
	@FindBy(linkText="NO")
	WebElement btnNo;
	
	@FindBy(name = "npiFile")
	WebElement finInstNPIFile;
	
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
	

	public FinancialInstitutionInfoPageNPI verifyUIContentFromDB() throws IOException  
	{
		int sqlRowNo=181;
		
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
		
		Helper.compareEquals(testConfig, "Finantial Institution Information NPI", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[1]/legend/h1")).getText(), dataTest.get(38).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Information NPI", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[1]/p[1]")).getText(), dataTest.get(37).get("TEXT_VAL")+dataTest.get(36).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Information NPI", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[1]/div[1]")).getText(), dataTest.get(35).get("CLOBVAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Information NPI", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[1]/h4[1]/strong")).getText(), dataTest.get(34).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Information NPI", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[1]/div[2]/div/p/span")).getText(), dataTest.get(33).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Name", (finInstNPINo.findElement(By.xpath("//preceding::label[1]"))).getText(), dataTest.get(32).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Information for your NPI", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[1]/div[3]/h4/strong")).getText(), dataTest.get(31).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Bank Name", (finInstName.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(30).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution address", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[2]/h4/strong")).getText(), dataTest.get(29).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Information address Text", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[1]/fieldset[2]/p")).getText(), dataTest.get(28).get("TEXT_VAL")+"\n"+dataTest.get(27).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Street", (finInstStreet.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(26).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution City", (finInstCity.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(25).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution State", (finInstState.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(24).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution State", finInstState.getText().substring(0, 12), dataTest.get(23).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Zip Code", (finInstZip1.findElement(By.xpath(".//preceding::legend[1]"))).getText(), dataTest.get(22).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Phone", (finInstPhone1.findElement(By.xpath(".//preceding::legend[1]"))).getText(), dataTest.get(21).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution AC Information", (Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section[2]/fieldset/h4/strong")).getText(), dataTest.get(20).get("TEXT_VAL"));

		Helper.compareEquals(testConfig, "Finantial Institution Routing No", (finInstRoutNum.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(19).get("TEXT_VAL"));
		

		
		Helper.compareEquals(testConfig, "Finantial Institution Ac No", (finInstAcctNum.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(18).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Hyperlink Text", txtFIIRoutNo.getText(), dataTest.get(17).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Typ of AC", (chkAcnt.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(16).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Typ of Checking", (chkAcnt.findElement(By.xpath(".//following::label[1]"))).getText(), dataTest.get(15).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Typ of Saving", (chkAcnt.findElement(By.xpath(".//following::label[2]"))).getText(), dataTest.get(14).get("TEXT_VAL"));
		
		Helper.compareEquals(testConfig, "Finantial Institution Voided Check", (voidChk.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(13).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution Voided Check", (rdoNPIYes.findElement(By.xpath(".//preceding::label[1]"))).getText(), dataTest.get(5).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution NPI Add Bnk Ac yes", (rdoNPIYes.findElement(By.xpath(".//following::label[1]"))).getText(), dataTest.get(4).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Finantial Institution NPI Add Bnk Ac No", (rdoNPIYes.findElement(By.xpath(".//following::label[2]"))).getText(), dataTest.get(3).get("TEXT_VAL"));
		  return this;
	}
	
	public UploadW9 clickContinue() {
		Element.clickByJS(testConfig, btnContinue, "CONTINUE");
		return new UploadW9(testConfig) ;
	}
	
	public SelectPaymentMethods clickContinueAV() {
		Element.clickByJS(testConfig, btnContinue, "Continue");
		return new SelectPaymentMethods(testConfig) ;
	}
	public FinancialInstitutionInfoPageNPI clickEditlink(){
		
		Browser.waitTillSpecificPageIsLoaded(testConfig, testConfig.getDriver().getTitle());
		WebElement editlink=Element.findElement(testConfig, "linkText", "EDIT");
	
	//if(editlink.isDisplayed())
		editlink.click();
	return this;
	}
	public FinancialInstitutionInfoPageNPI fillInsufficientFinancialInstInfoForNPI(String InputField) throws IOException
	{
		String expectedText="To help ensure the security of your account, you must enter a physical address for your financial institution. PO Boxes are not allowed.";
	//	Element.verifyTextPresent(txtSecurity, expectedText);
		String financialInstName = Helper.generateRandomAlphabetsString(4);
		String financialInstStreet = Helper.generateRandomAlphabetsString(5);
		String phNo = Long.toString(Helper.generateRandomNumber(3));
		String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
		String npiNumber=Long.toString(Helper.generateRandomNumber(10));
		 int rowNo=15;
		  TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		  String cityName =data.GetData(rowNo, "City");
		  String stateName =data.GetData(rowNo, "State");
		  String zipCode =data.GetData(rowNo, "ZipCode");
		  String routingNo =data.GetData(rowNo, "RoutingNumber");
		  String accountNo =data.GetData(rowNo, "AccountNumber");
		 String NonNumericData= Helper.generateRandomAlphabetsString(4);
		
		switch(InputField)
		{
		case "NpiNumber":
			npiNumber="";
			break;
		case "NonNumericNPI":
			npiNumber=NonNumericData;	
			break;
		case "SameNPI&TIN":
			npiNumber=enrollmentInfoPageObj.getTin();
			break;
		case "financialInstName":
			financialInstName="";
			break;
		case "financialInstStreet":
			financialInstStreet="";
			break;
		case "POBoxNoInStreet":
			 financialInstStreet = "PO BOX 7530";
			break;	
		case "PhoneNo":
			phNo="";
			phNoLstField="";
			break;
		case "IncompPhoneNo":
			phNo="34";
			phNoLstField="287";
			break;
		case "financialInstCity":
			cityName="";
				break;
			case "financialInstState":
				stateName="Select State";
				break;
			case "financialInstZipCode":
				zipCode="";
				break;
			case "AlphaZipCode":
				zipCode=Helper.generateRandomAlphabetsString(5);
				break;
			case "UnMatchedAddress":
				zipCode=Long.toString(Helper.generateRandomNumber(5));	
				cityName=Helper.generateRandomAlphabetsString(5);
			break;
			case "financialInstroutingNo":
				routingNo="";
				break;	
			case "NonNumericroutingNo":
				routingNo=NonNumericData;	
				break;	
			case "financialInstaccountNo":
				accountNo="";
				break;
			case "NonNumericAccountNo":
				accountNo=NonNumericData;	
				break;
		}
		Element.enterData(finInstNPINo,npiNumber ,"Enter financial Institution name","finInstNPINo");
		Element.enterData(finInstName, financialInstName,"Enter financial Institution name","finInstName");
		Element.enterData(finInstStreet, financialInstStreet,"Enter financial Institution street","finInstStreet");
        Element.enterData(finInstPhone1, phNo,"Entered first three digits of phone number","finInstPhone1");
		Element.enterData(finInstPhone2, phNo,"Entered second three digits of phone number","finInstPhone2");
		Element.enterData(finInstPhone3, phNoLstField,"Entered last four digits of phone number","finInstPhone3");
//		enrollmentInfoPageObj.setFinInstName(financialInstName);
//		enrollmentInfoPageObj.setFinPhoneNo(phNo+phNo+phNoLstField);
//		enrollmentInfoPageObj.setFinStreet(financialInstStreet);

		
		  Element.enterData(finInstCity, cityName,"Read from excel and Enter City name","finInstCity");
		  Element.selectVisibleText(finInstState, stateName,"Select City from excel");
		  Element.enterData(finInstZip1, zipCode,"Read from excel and Enter Zip 1","finInstZip1");
		  Element.enterData(finInstRoutNum, routingNo,"Read from excel and Enter Routing Number","finInstRoutNum");
		  Element.enterData(finInstAcctNum, accountNo,"Read from excel and Enter Account Number","finInstAcctNum");
		Browser.wait(testConfig, 2);
		if (InputField.equalsIgnoreCase("NofileUpload")||InputField.equalsIgnoreCase("NonPdfUpload") )
		{
			if (InputField.equalsIgnoreCase("NonPdfUpload"))
			{
			Browser.wait(testConfig, 2);
			Element.clickByJS(testConfig,rdoBankLetter, "Bank Letter radio button");
			Browser.waitForLoad(testConfig.driver);
			Element.enterData(btnBrowse,System.getProperty("user.dir")+testConfig.getRunTimeProperty("DataFile"),"Entered path of data file as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("DataFile"), "btnBrowse");
			Browser.wait(testConfig,2);
		}
			else{}
		}
			else
		uploadBankLetterPdfWithAcceptance();
		
		clickContinueNPI();
		verifyErrorMessage(InputField);
		return this;
	}
	
	public void verifyErrorMessage(String InputField){
		String xpath="//*[@id=\"EFTERAregForm\"]/section[1]/fieldset[1]/div[1]/ul/li/a";
		Element.click(Element.findElement(testConfig, "xpath", xpath), "Error Hyperlink");
		
		
		String expectedText="Missing Data";
		String expectedColor="#c21926";
		
    	String expectedInvalidText="Invalid Data";
    	
		switch(InputField)
		{
		case "NpiNumber":
		Log.Comment("Verifying Error Msg is displayed for National Provider Identifier...");
		Element.verifyTextPresent(finInstNPINo.findElement(By.xpath("..//following::p[1]")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in National Provider Identifier text box" , expectedColor, Color.fromString(finInstNPINo.getCssValue("border-top-color")).asHex());
		break;
		
		case "NonNumericNPI":
			Log.Comment("Verifying Error Msg is displayed for National Provider Identifier...");
			Element.verifyTextPresent(finInstNPINo.findElement(By.xpath("..//following::p[1]")), expectedInvalidText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in National Provider Identifier text box" , expectedColor, Color.fromString(finInstNPINo.getCssValue("border-top-color")).asHex());
			break;
			
		case "SameNPI&TIN":
			Log.Comment("Verifying Error Msg is displayed for National Provider Identifier...");
			Element.verifyTextPresent(finInstNPINo.findElement(By.xpath("..//following::p[1]")), expectedInvalidText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in National Provider Identifier text box" , expectedColor, Color.fromString(finInstNPINo.getCssValue("border-top-color")).asHex());
			break;
			
		case "financialInstName":
			Log.Comment("Verifying Error Msg is displayed for Financial Institution / Bank Name...");
			Element.verifyTextPresent(finInstName.findElement(By.xpath("..//following::p[1]")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in Finantial Institution/Bank text box" , expectedColor, Color.fromString(finInstName.getCssValue("border-top-color")).asHex());
			break;
		
		case "financialInstStreet":
			Log.Comment("Verifying Error Msg is displayed for Finantial Institution Street...");
			Element.verifyTextPresent(finInstStreet.findElement(By.xpath("following::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Street Text Box..." , expectedColor, Color.fromString(finInstStreet.getCssValue("border-top-color")).asHex());
			break;
		
		case "POBoxNoInStreet":
			Log.Comment("Verifying Error Msg is displayed for Finantial Institution Street...");
			Element.verifyTextPresent(finInstStreet.findElement(By.xpath("following::p")), "P.O. Boxes are not accepted");
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Street Text Box..." , expectedColor, Color.fromString(finInstStreet.getCssValue("border-top-color")).asHex());
			break;
		
		case "financialInstCity":
		Log.Comment("Verifying Error Msg is displayed for Finantial Institution city...");
		Element.verifyTextPresent(finInstCity.findElement(By.xpath("..//following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in City text box" , expectedColor, Color.fromString(finInstCity.getCssValue("border-top-color")).asHex());
		break;
		
		case "financialInstState":
		Log.Comment("Verifying Error Msg is displayed for Finantial Institution  state...");
		Element.verifyTextPresent(finInstState.findElement(By.xpath("..//following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in State text box" , expectedColor, Color.fromString(finInstState.getCssValue("border-top-color")).asHex());
		break;
		
		case "PhoneNo":
		Log.Comment("Verifying Error Msg is displayed for Finantial Institution  Telephone...");
		Element.verifyTextPresent(finInstPhone1.findElement(By.xpath("..//following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Telephone textbox" , expectedColor, Color.fromString(finInstPhone1.getCssValue("border-top-color")).asHex());
		break;
		
		case "IncompPhoneNo":
			Log.Comment("Verifying Error Msg is displayed for Finantial Institution  Telephone...");
			Element.verifyTextPresent(finInstPhone1.findElement(By.xpath("..//following-sibling::p")), expectedInvalidText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Telephone textbox" , expectedColor, Color.fromString(finInstPhone1.getCssValue("border-top-color")).asHex());
			break;
		
		case "financialInstZipCode":
		Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");
		Element.verifyTextPresent(finInstZip1.findElement(By.xpath("..//following::p[1]")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code" , expectedColor, Color.fromString(finInstZip2.getCssValue("border-top-color")).asHex());
		break;
		
		case "AlphaZipCode":
			Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");
			Element.verifyTextPresent(finInstZip1.findElement(By.xpath("..//following::p[1]")), expectedInvalidText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code" , expectedColor, Color.fromString(finInstZip2.getCssValue("border-top-color")).asHex());
			break;
			
		case "UnMatchedAddress":
			Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");
			Element.verifyTextPresent(finInstZip1.findElement(By.xpath("..//following::p[1]")), "Invalid for City/State");
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code" , expectedColor, Color.fromString(finInstZip1.getCssValue("border-top-color")).asHex());
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code" , expectedColor, Color.fromString(finInstZip2.getCssValue("border-top-color")).asHex());
		break;
		
		case "financialInstroutingNo":
		Log.Comment("Verifying Error Msg is displayed for Financial Institution Routing Number..");
		Element.verifyTextPresent(finInstRoutNum.findElement(By.xpath("..//following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Fin Ins Routing No" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-top-color")).asHex());
		break;
		
		case "NonNumericroutingNo":
			
			Log.Comment("Verifying Error Msg is displayed for Routing Number ..");
			Element.verifyTextPresent(finInstRoutNum.findElement(By.xpath("../following-sibling::p")), expectedInvalidText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in Routing Number" , expectedColor, Color.fromString(finInstRoutNum.getCssValue("border-top-color")).asHex());
		break;
		
		case "financialInstaccountNo":
		Log.Comment("Verifying Error Msg is displayed for NPI Account Number..");
		Element.verifyTextPresent(finInstAcctNum.findElement(By.xpath("..//following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for NPI AC No field" , expectedColor, Color.fromString(finInstAcctNum.getCssValue("border-top-color")).asHex());
		break;
		
		case "NonNumericAccountNo":	
			Log.Comment("Verifying Error Msg is displayed for Account Number ..");
			Element.verifyTextPresent(finInstAcctNum.findElement(By.xpath("../following-sibling::p")), expectedInvalidText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in Account Number" , expectedColor, Color.fromString(finInstAcctNum.getCssValue("border-top-color")).asHex());
		break;	
		
		case "NofileUpload" :
			Log.Comment("Verifying Error Msg is displayed for Voided Check");
			Element.verifyTextPresent(finInstNPIFile.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Upload voided Check" , expectedColor, Color.fromString(finInstNPIFile.getCssValue("border-top-color")).asHex());
			break;
		case "NonPdfUpload" :
		Log.Comment("Verifying Error Msg is displayed for Voided Check");
		Element.verifyTextPresent(finInstNPIFile.findElement(By.xpath("..//following-sibling::p")), "File Format must be 'PDF','JPEG','GIF' or 'PNG'");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Upload voided Check" , expectedColor, Color.fromString(finInstNPIFile.getCssValue("border-top-color")).asHex());
		break;
		
		}
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
	
	public void clickFIIRoutingNumNPI()
	{
		Element.click(txtFIIRoutNo, "FII Routing No for NPI");
		Browser.wait(testConfig, 3);
		
		Element.click(closeTIP, "Close TIP Button");
		
		Browser.wait(testConfig, 3);
		Element.click(txtFIIRoutNo, "FII Routing No for NPI");
		Browser.wait(testConfig, 3);
		
		WebElement close=Element.findElement(testConfig, "xpath", "//h4[@class='help-modal-header__title float-left']/following::a[1]");
		close.click();
	}
	
	public FinancialInstitutionInfoPageNPI verifyFinAccount(String verifiableItems)
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
		return this;
	}
	
	public void clickFINMngNPIAcc()
	{
	
	Element.click(lnkNPIBnk, "Manage Multiple NPI Bank Account ");
	Browser.wait(testConfig, 1);
	Element.click(btnCloseTIP, "Close TIP Button");
	}
	public FinancialInstitutionInfoPageNPI clickNPIYes()
	{
		Element.clickByJS(testConfig,rdoNPIYes , "YES NPI");
		return this;
	}
	public  FinancialInstitutionInfoPageNPI clickContinueNPI() {
		
		Browser.wait(testConfig, 2);
		Element.clickByJS(testConfig, btnContinue, "Continue for NPI");
		return new FinancialInstitutionInfoPageNPI(testConfig);
	}
	
	public void verifyButtons()
	{
		Element.verifyElementPresent(btnContinue, "Continue Button");
		Element.verifyElementPresent(btnBack, "Back Button");
		Element.verifyElementPresent(btnCancEnroll, "Cancel Enrollment Button");
		
		Element.click(btnBack, "Back Button");
		Browser.verifyURL(testConfig, "backEFTERAFinancialInfoNPI.do");
		Browser.wait(testConfig, 2);
		//Browser.forward(testConfig);
		Element.click(btnContinue, "Continue Button");
		Browser.wait(testConfig, 1);
		Element.click(btnCancEnroll, "Cancel Enroll Button");
		Browser.wait(testConfig, 1);
		
		Element.click(btnNo, "No Button of PopUp");
		Browser.verifyURL(testConfig, "validateEFTERAFinancialInfo.do");
		
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
		errNames.add("- Financial Information - National Provider Identifier(NPI)");
		errNames.add("- Financial Information - Financial Institution/Bank Name");
		errNames.add("- Financial Information - Financial Institution Address - Street");
		errNames.add("- Financial Information - Financial Institution Address - City");
		errNames.add("- Financial Information - Financial Institution Address - State");
		errNames.add("- Financial Information - Financial Institution Address - Zip");
		errNames.add("- Financial Information - Financial Institution Address - Telephone");
		errNames.add("- Financial Information - Account Information - Financial Institution Routing Number");
		errNames.add("- Financial Information - Account Information - NPI Account Number with Financial Institution");
		errNames.add("- Financial Information - Account Information - Upload Voided Check/Bank Letter");
		
		
		ArrayList <String> expectedURLs=new ArrayList<String>(); 
		expectedURLs.add("npiField");
		expectedURLs.add("npiFinInst");
		expectedURLs.add("npiStreet");
		expectedURLs.add("npiCity");
		expectedURLs.add("npiState");
		expectedURLs.add("npiZip");
		expectedURLs.add("npiTele");
		expectedURLs.add("npiRouting");
		expectedURLs.add("npiAcctNbr");
		expectedURLs.add("npiUploadDoc");
		
		
		ArrayList <String> webErrNamesText=new ArrayList<String>();
		int i=1;
			while(i<11){
			String xpath="//form[@id=\"EFTERAregForm\"]/section[1]/fieldset[1]/div/ul/"+"li"+"["+i+"]"+"/a";
			 
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
			
			Log.Comment("Verifying Error Msg is displayed for National Provider Identifier...");
			Element.verifyTextPresent(finInstNPINo.findElement(By.xpath("..//following::p[1]")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in National Provider Identifier text box" , expectedColor, Color.fromString(finInstNPINo.getCssValue("border-top-color")).asHex());
	
			
			Log.Comment("Verifying Error Msg is displayed for Financial Institution / Bank Name...");
			Element.verifyTextPresent(finInstName.findElement(By.xpath("..//following::p[1]")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in Finantial Institution/Bank text box" , expectedColor, Color.fromString(finInstName.getCssValue("border-top-color")).asHex());
	
			Log.Comment("Verifying Error Msg is displayed for Finantial Institution Street...");
			Element.verifyTextPresent(finInstStreet.findElement(By.xpath("following::p")), expectedText);
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

			Log.Comment("Verifying Error Msg is displayed for NPI Account Number..");
			Element.verifyTextPresent(finInstAcctNum.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for NPI AC No field" , expectedColor, Color.fromString(finInstAcctNum.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Voided Check");
			Element.verifyTextPresent(finInstNPIFile.findElement(By.xpath("..//following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Upload voided Check" , expectedColor, Color.fromString(finInstNPIFile.getCssValue("border-top-color")).asHex());
	}
	
	
	
}
