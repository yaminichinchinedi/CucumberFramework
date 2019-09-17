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
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
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

	@FindBy(xpath = "//label[contains(text(),'Hospital/Facility')]//preceding-sibling::input")
	WebElement rdoHospital;

	@FindBy(xpath = "//input[@name='provType'][2]")
	WebElement rdoPhysician;

	@FindBy(xpath = "//input[@name='provType'][3]")
	WebElement rdoOtherHealthcare;

	@FindBy(xpath = ".//*[@id='mktid']//input[1]")
	WebElement chkBehaviouralHealth;

	@FindBy(xpath = "//input[@id='103']//following-sibling::label")
	WebElement chkOther;

	@FindBy(linkText = "CONTINUE")
	WebElement btnContinue;
	
	@FindBy(linkText = "CANCEL ENROLLMENT")
	WebElement btnCancelEnrollment;

	@FindBy(name = "npi")
	WebElement txtNPI;
	
	@FindBy(name = "bsName")
	WebElement bsName;
	
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
	
	@FindBy(linkText="YES")
	WebElement btnYesOnCancelPopUp;
	
	@FindBy(linkText="NO")
	WebElement btnNoOnCancelPopUp;
	
	@FindBy(xpath="//div[@class='error']//h4")
	WebElement errorHeader;
	
	@FindBy(xpath="//div[@class='error']//ul//li")
	List <WebElement> individualErrors;
	
	@FindBy(xpath = "//p[@class='error-msg']") 
	WebElement error;
	
	@FindBy(xpath = "//div[@class='error']//a") 
	WebElement errorLink;
	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();


	protected TestBase testConfig;
	public ValidateEFTERAProviderInfo validateProvInfo;

	public ProviderInformationEFTERAEnroll(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public ValidateEFTERAProviderInfo fillProviderOrgInfo() throws IOException {
	
		int rowNo=1;
		String provName = Helper.generateRandomAlphabetsString(5);
		String streetName = Helper.generateRandomAlphabetsString(5);
		TestDataReader data= testConfig.cacheTestDataReaderObject("FinancialInfo");
		String expectedText="To help ensure the security of your account, you must enter a physical address for your organization. PO Boxes are not allowed and cannot be used as your address of record. If you do attempt to use a PO Box, your enrollment may be delayed and may not be accepted.";
		//Element.verifyTextPresent(txtSecurity, expectedText);
		
	
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			Element.enterData(bsName, provName, "Enter provider name as :" + provName,"providerName");
		else
		{
			Element.enterData(providerName, provName, "Enter provider name as :" + provName,"providerName");
			Element.clickByJS(testConfig, rdoHospital, "Hospital/Facility radio button");
			enrollmentInfoPageObj.setProvType("Hospital/Facility");
			Element.click(chkOther, "Other sub checkbox");
			enrollmentInfoPageObj.setMrktType("Other");
		}
		
		
		Element.enterData(street, streetName, "Enter street name as : " + streetName,"street");
		Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),"city");
		Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"),"zipCode1");
		
		enrollmentInfoPageObj.setBusinessName(provName);
		enrollmentInfoPageObj.setStreet(streetName);
		enrollmentInfoPageObj.setCity(data.GetData(rowNo, "City"));
		enrollmentInfoPageObj.setStateName(data.GetData(rowNo, "State"));
		enrollmentInfoPageObj.setZipCode(data.GetData(rowNo, "ZipCode"));
		
//		Element.click(chkOther, "Other sub checkbox");

		Element.click(btnContinue, "Continue button");
		return new ValidateEFTERAProviderInfo(testConfig);

	}
	
	public ValidateEFTERAProviderInfo clickContinueToProviderInfoPage()
	{
		Element.click(btnContinue, "Continue Button");
		return new ValidateEFTERAProviderInfo(testConfig);
	}

	public ProviderInformationEFTERAEnroll verifyUITextFromDB()  
	{
		int sqlRow=124;
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
		List <String> expectedErrorMsgs;
		Log.Comment("Keep all fields blank..");
		Element.click(btnContinue, "Continue button");
		Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			 expectedErrorMsgs=Arrays.asList("- Billing Service Information - Billing Service Name","- Billing Service Information - Billing Service Address Street","- Billing Service Information - Billing Service City","- Billing Service Information - Billing Service State","- Billing Service Information - Billing Service Zip Code");
		else
			expectedErrorMsgs=Arrays.asList("- Organization Information - Business Name","- Organization Information - Street","- Organization Information - City","- Organization Information - State","- Organization Information - Zip Code","- Organization Information - Provider Type/Market Type");
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
		if(enrollmentInfoPageObj.getEnrollType().contains("BS"))
		{
			Element.verifyTextPresent(bsName.findElement(By.xpath("../following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in provider text box" , expectedColor, Color.fromString(bsName.getCssValue("border-top-color")).asHex());
		}
		else
		{
			Element.verifyTextPresent(providerName.findElement(By.xpath("../following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in provider text box" , expectedColor, Color.fromString(providerName.getCssValue("border-top-color")).asHex());
			
			Log.Comment("Verifying Error Msg is displayed for Provide type..");
			Element.verifyTextPresent(lblProvType.findElement(By.xpath("following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Provide type.." , expectedColor, Color.fromString(lblProvType.getCssValue("border-top-color")).asHex());
		}
		
		Log.Comment("Verifying Error Msg is displayed for Street..");
		Element.verifyTextPresent(street.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , expectedColor, Color.fromString(street.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for City..");
		Element.verifyTextPresent(city.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in City text box" , expectedColor, Color.fromString(city.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for State dropdown..");
		Element.verifyTextPresent(drpDwnState.findElement(By.xpath("../following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for State dropdown" , expectedColor, Color.fromString(drpDwnState.getCssValue("border-top-color")).asHex());
		
		Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");
		Element.verifyTextPresent(zipCode1.findElement(By.xpath("following-sibling::p")), expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code" , expectedColor, Color.fromString(zipCode1.getCssValue("border-top-color")).asHex());
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code" , expectedColor, Color.fromString(zipCode2.getCssValue("border-top-color")).asHex());
		
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
	
	public  ProviderInformationEFTERAEnroll validateBillingService(String field,String data) throws IOException {
		WebElement ele=null;
		switch(field)
		{
			case "BSName":
				Element.enterData(bsName, data, "Enter provider name as :" + data,"providerName");
				ele=bsName;
				break;
			case "Street":
				Element.enterData(street, data, "Enter street name as : " + data,"street");
				ele=street;
				break;
			case "City":
				Element.enterData(city, data, "Enter city name as :" + data,"city");
				ele=city;
				break;
			case "State":
				Element.selectVisibleText(drpDwnState, data, "Enter state name");
				ele=drpDwnState;
				break;
			case "ZipCode":
				Element.enterData(zipCode1, data,"Entered zip code in first textbox as" + data,"zipCode1");
				ele=zipCode1;
				break;
		}
		fillBillingServiceInfo(field);
		Element.click(btnContinue, "Continue button");
		verifyBSError(ele);
		return this;

	}
	
	public  ProviderInformationEFTERAEnroll fillBillingServiceInfo(String field) throws IOException {
		int rowNo=1;
		String provName = Helper.generateRandomAlphabetsString(5);
		String streetName = Helper.generateRandomAlphabetsString(5);
		TestDataReader data= testConfig.cacheTestDataReaderObject("FinancialInfo");
	
		if(!field.equals("BSName"))
			Element.enterData(bsName, provName, "Enter provider name as :" + provName,"providerName");
		if(!field.equals("Street"))
			Element.enterData(street, streetName, "Enter street name as : " + streetName,"street");
		if(!field.equals("City"))
			Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),"city");
		if(!field.equals("State"))
			Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		if(!field.equals("ZipCode"))
			Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"),"zipCode1");
		
		return this;
	}	

	public void verifyBSError(WebElement element)
	{
		if(element.equals(zipCode1))
		{
			if(error.getText().contains("Data"))
				Element.verifyTextPresent(error, "Invalid Data");
			else
				Element.verifyTextPresent(error, "Invalid for City/State");
		}
		else if(element.equals(street))
		{
			if(error.getText().contains("Special"))
				Element.verifyTextPresent(error, "Special characters not allowed");
			else
				Element.verifyTextPresent(error, "P.O. Boxes are not accepted");
		}
		else
			Element.verifyTextPresent(error, "Special characters not allowed");
		Element.verifyElementPresent(errorLink, "Error links");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box" , "#c21926", Color.fromString(element.getCssValue("border-top-color")).asHex());
		
	}
	
	public ProviderInformationEFTERAEnroll verifyEditable()
	{
		Helper.compareEquals(testConfig, "Organisation Name", enrollmentInfoPageObj.getBusinessName(),providerName.getAttribute("value"));
		Helper.compareEquals(testConfig, "City", enrollmentInfoPageObj.getCity(),city.getAttribute("value"));
		Helper.compareEquals(testConfig, "Street", enrollmentInfoPageObj.getStreet(),street.getAttribute("value"));
		Helper.compareEquals(testConfig, "State", enrollmentInfoPageObj.getStateName(),drpDwnState.getAttribute("value"));
		Helper.compareEquals(testConfig, "Zip Code", enrollmentInfoPageObj.getZipCode(),zipCode1.getAttribute("value"));
		return this;
	}
	
}
