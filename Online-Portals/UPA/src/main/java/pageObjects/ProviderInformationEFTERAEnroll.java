package main.java.pageObjects;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.bcel.generic.LNEG;
import org.openqa.selenium.support.Color;

import main.java.nativeFunctions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

//This page was in earlier phase but does not appear now, hence keeping it for inheriting purpose


public class ProviderInformationEFTERAEnroll {

	@FindBy(name = "providerName")
	WebElement providerName;

	@FindBy(name = "street")
	WebElement street;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement drpDwnState;

	@FindBy(name = "zip1")
	WebElement zipCode1;
	
	@FindBy(name = "zip2")
	WebElement zipCode2;
	
	@FindBy(xpath = "//span[contains(text(),'Provider Type')]")
	WebElement lblProvType;

	@FindBy(xpath = "//label[contains(text(),'Hospital/Facility')]")
	WebElement rdoHospital;

	@FindBy(xpath = "//input[@name='provType'][2]")
	WebElement rdoPhysician;

	@FindBy(xpath = "//input[@name='provType'][3]")
	WebElement rdoOtherHealthcare;

	@FindBy(xpath = ".//*[@id='mktid']//input[1]")
	WebElement chkBehaviouralHealth;

	@FindBy(xpath = "//input[@id='103']//following-sibling::label")
	WebElement chkOther;

	@FindBy(linkText = "Continue")
	WebElement btnContinue;
	
	@FindBy(linkText = "Cancel Enrollment")
	WebElement btnCancelEnrollment;
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][3]//td//table//tr//td")
	WebElement txtSecurity;
	
	@FindBy(xpath = "//section[1]/fieldset/div[1]/p")
	WebElement txtBusinessOrgInfo;
	
	@FindBy(xpath = "//section[1]/fieldset/div[2]/div[2]/label")
	WebElement txtTaxIdInfo;

	@FindBy(xpath = "//section[2]/fieldset/p[1]")
	WebElement txtProvFederalInfo;
	
	@FindBy(xpath = "//h4[@class='provider-address']")
	WebElement lblBusinessAddress;
	
	@FindBy(xpath = "//label[@for='provider-name']//span")
	WebElement lblBusinessName;
	
	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List <WebElement> OrgInfoHeaders;
	
	@FindBy(xpath ="//div[@class='modal modal-cancel-activation']//div")
	WebElement divCancelEnrollment;
	
	
	@FindBy(xpath="//div[@class='modal modal-cancel-activation']//div//div[@class='exit-modal-header float-left']")
	WebElement txtCancelEnrollmentPopUp;
	
	@FindBy(xpath="//div[@class='modal modal-cancel-activation']//div//div[@class='exit-modal-content float-left']//p")
	List <WebElement> txtCancelEnrollmentPopUpExtend;
	
	@FindBy(linkText="Yes")
	WebElement btnYesOnCancelPopUp;
	
	@FindBy(linkText="No")
	WebElement btnNoOnCancelPopUp;
	
	@FindBy(xpath="//div[@class='error']//h4")
	WebElement errorHeader;
	
	@FindBy(xpath="//div[@class='error']//ul//li")
	List <WebElement> individualErrors;
	
	
	

	private TestBase testConfig;
	public ValidateEFTERAProviderInfo validateProvInfo;

	public ProviderInformationEFTERAEnroll(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}

	public ValidateEFTERAProviderInfo fillProviderOrgInfo() throws IOException {
		int rowNo=1;
		TestDataReader data= testConfig.cacheTestDataReaderObject("FinancialInfo");
		String expectedText="To help ensure the security of your account, you must enter a physical address for your organization. PO Boxes are not allowed and cannot be used as your address of record. If you do attempt to use a PO Box, your enrollment may be delayed and may not be accepted.";
		//Element.verifyTextPresent(txtSecurity, expectedText);
		
		String provName = Helper.generateRandomAlphabetsString(5);
		Element.enterData(providerName, provName, "Enter provider name as :" + provName,"providerName");
		
		String streetName = Helper.generateRandomAlphabetsString(5);
		Element.enterData(street, streetName, "Enter street name as : " + streetName,"street");
		Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),"city");
		Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"),"zipCode1");
		Element.expectedWait(rdoHospital, testConfig, "Hospital/Facility radio button", "Hospital/Facility radio button");
		
		Element.click(rdoHospital, "Hospital/Facility radio button");
		
		Element.click(chkOther, "Other sub checkbox");
		Element.click(btnContinue, "Continue button");
		return new ValidateEFTERAProviderInfo(testConfig);

	}
	
	

	public ProviderInformationEFTERAEnroll verifyUITextFromDB()  
	{
		int sqlRow=98;
		testConfig.putRunTimeProperty("subject","txt.enterbusiness");
		Map contentTbl=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		Helper.compareContains(testConfig, "Business Info Text", contentTbl.get("TEXT_VAL").toString(), txtBusinessOrgInfo.getText());
		
		testConfig.putRunTimeProperty("subject","txt.infoprvidetax");
		contentTbl=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		
		Helper.compareContains(testConfig, "Federal Info Text", contentTbl.get("TEXT_VAL").toString(), txtProvFederalInfo.getText());
		
		testConfig.putRunTimeProperty("subject","txt.infotaxId");
		contentTbl=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		
		Helper.compareContains(testConfig, "Tax ID Info Text", contentTbl.get("TEXT_VAL").toString().replace("<br>","").replace(" Avoid", "Avoid"), txtTaxIdInfo.getText().replace("\n",""));
		
		Element.verifyElementPresent(lblBusinessName, "Business Name Label");
		Element.verifyElementPresent(lblBusinessAddress, "Business Address Label");
		Element.verifyElementPresent(btnContinue, "Continue button");
		Element.verifyElementPresent(btnCancelEnrollment, "Continue button");
		return this;
		
	}
	
	public ProviderInformationEFTERAEnroll verifyOrgInfoHeaders()  
	{
		List<String> headers= Arrays.asList("Organization Information","Identify Administrators","Financial Institution Information","Upload W9","Review and Submit","Enrollment Submitted");
		for(int i=0;i<headers.size();i++)
		{
		 Helper.compareEquals(testConfig, "Headers comparison for : " + headers.get(i) , headers.get(i), OrgInfoHeaders.get(i).getText().replace("\n", " "));
		 if(headers.get(i).equalsIgnoreCase("Organization Information"))
			 Helper.compareEquals(testConfig, "Orange Color Value for Organization Information" , "#e87722",Color.fromString(OrgInfoHeaders.get(i).getCssValue("color")).asHex());
		 else
			 Helper.compareEquals(testConfig, "Grey Color Value for : " +headers.get(i) , "#999999",Color.fromString(OrgInfoHeaders.get(i).getCssValue("color")).asHex());
		 
		}
		return this;
	
	}
	
	public ProviderInformationEFTERAEnroll verifyCancelEnrollmentFlow()
	{
		String expectedText="Are you sure you want to cancel your EPS enrollment application?If you select 'Yes', your EPS enrollment will not be completed and no information will be saved.Select 'No' to return to the EPS enrollment process.";
		clickCancelEnrollment();
		Element.verifyElementPresent(divCancelEnrollment, "Cancel Enrollment Pop up");
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up text", expectedText,((txtCancelEnrollmentPopUp.getText() + txtCancelEnrollmentPopUpExtend.get(0).getText() + txtCancelEnrollmentPopUpExtend.get(1).getText()).replace("\n","")));
		clickNoOnCancelEnrollment().clickCancelEnrollment().clickYesOnCancelEnrollment();
		return this;
	}
	
	public ProviderInformationEFTERAEnroll verifyContinueEnrollmentValidations()
	{
		
		Log.Comment("Keep all fields blank..");
		Element.click(btnContinue, "Continue button");
		Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		List <String> expectedErrorMsgs=Arrays.asList("- Organization Information - Business Name","- Organization Information - Street","- Organization Information - City","- Organization Information - State","- Organization Information - Zip Code","- Organization Information - Provider Type/Market Type");
		for(int i=0;i<expectedErrorMsgs.size();i++)
			Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));
		
		verifyMissingDataErrorMsg();
		
		
	
		return this;
	}
	
	
	public ProviderInformationEFTERAEnroll fillBusinessName(String name)
	{
		Element.enterData(providerName, name, "Enter Business Name as : " +name , "Business Name");
		return this;
	}
	
	public ProviderInformationEFTERAEnroll fillBusinessAddress(String address)
	{
		Element.enterData(street, address, "Street Address as : " + address, "Street Address");
		Element.enterData(city, address, "City Address as : " + address , "City Address");
		return this;
	}
	
	
	public ProviderInformationEFTERAEnroll verifyErrorMsgForInvalidData(String fieldName)
	{
		Element.click(btnContinue, "Continue button");
		Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		if(fieldName.equals("BusinessName"))  
			Element.verifyTextPresent(providerName.findElement(By.xpath("../following-sibling::p")), "Special characters not allowed");
		if(fieldName.equals("BusinessAddress"))
		{
			Browser.wait(testConfig, 2);
			Element.verifyTextPresent(street.findElement(By.xpath("following-sibling::p")), "Special characters not allowed");
			Element.verifyTextPresent(city.findElement(By.xpath("following-sibling::p")), "Special characters not allowed");
		}
			
		return this;
	}
	
	public void verifyMissingDataErrorMsg()
	{
		String expectedText="Missing Data";
		String expectedColor="#c21926";
		
		Log.Comment("Verifying Error Msg is displayed for Business Name..");
		Element.verifyTextPresent(providerName.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in provider text box" , expectedColor, Color.fromString(providerName.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Street..");
		Element.verifyTextPresent(street.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(street.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for City..");
		Element.verifyTextPresent(city.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in City text box" , expectedColor, Color.fromString(city.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for State dropdown..");
		Element.verifyTextPresent(drpDwnState.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for State dropdown" , expectedColor, Color.fromString(drpDwnState.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");
		Element.verifyTextPresent(zipCode1.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code" , expectedColor, Color.fromString(zipCode1.getCssValue("border-top-color")).asHex());
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code" , expectedColor, Color.fromString(zipCode2.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Provide type..");
		Element.verifyTextPresent(lblProvType.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Provide type.." , expectedColor, Color.fromString(lblProvType.getCssValue("border-top-color")).asHex());
	}
	
	public ProviderInformationEFTERAEnroll clickCancelEnrollment()
	{
		Element.click(btnCancelEnrollment, "Cancel Enrollment");	
		return this;
	}
	
	public UPARegistrationPage clickYesOnCancelEnrollment()
	{
		Element.click(btnYesOnCancelPopUp, "Yes button on cancel Enrollment Pop up");	
		return new UPARegistrationPage(testConfig);
	}
	
	public ProviderInformationEFTERAEnroll clickNoOnCancelEnrollment()
	{
		Element.click(btnNoOnCancelPopUp, "No button on cancel Enrollment Pop up");	
		return this;
	}

}
