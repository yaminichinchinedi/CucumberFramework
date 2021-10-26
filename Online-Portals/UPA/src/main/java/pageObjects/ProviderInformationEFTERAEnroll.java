package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.bcel.generic.LNEG;
import org.openqa.selenium.support.Color;

import main.java.nativeFunctions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
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

	@FindBy(name = "businessPhone1")
	WebElement businessPhone1;

	@FindBy(name = "businessPhone2")
	WebElement businessPhone2;

	@FindBy(name = "businessPhone3")
	WebElement businessPhone3;

	@FindBy(name = "businessPhoneExt")
	WebElement businessPhoneExt;

	@FindBy(name = "npi")
	WebElement npi;

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

	@FindBy(xpath = "//div[@id='prvnpi']/label")
	WebElement txtNPI;

	@FindBy(name = "bsName")
	WebElement bsName;

	@FindBy(xpath = "(//ul[contains(@class,'autocomplete ')]/li[1]/div)[1]")
	WebElement autoPopulateProviderNameList;

	
	@FindBy(xpath = "//ul[@id='ui-id-2']/li/div")
	WebElement autoPopulateStreetList;
	
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

	@FindBy(xpath = "//label[@for='provider-name']")
	WebElement lblBusinessName;

	@FindBy(xpath = "//label[@for='street']")
	WebElement lblStreet;

	@FindBy(xpath = "//label[@for='city']")
	WebElement lblCity;

	@FindBy(xpath = "//label[@for='state']")
	WebElement lblState;

	@FindBy(xpath = "//div[@id='prvstate']//legend")
	WebElement lblZip;

	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List<WebElement> OrgInfoHeaders;

	@FindBy(xpath = "//div[@class='modal modal-cancel-activation']//div")
	WebElement divCancelEnrollment;

	@FindBy(xpath = "//section[1]/fieldset/p")
	WebElement txtBusinessAddress;

	@FindBy(xpath = "//div[@class='modal modal-cancel-activation']//div//div[@class='exit-modal-header float-left']")
	WebElement txtCancelEnrollmentPopUp;

	@FindBy(xpath = "//div[@class='modal modal-cancel-activation']//div//div[@class='exit-modal-content float-left']//p")
	List<WebElement> txtCancelEnrollmentPopUpExtend;

	@FindBy(linkText = "YES")
	WebElement btnYesOnCancelPopUp;

	@FindBy(linkText = "NO")
	WebElement btnNoOnCancelPopUp;

	@FindBy(xpath = "//div[@class='error']//h4")
	WebElement errorHeader;

	@FindBy(xpath = "//div[@class='error']//ul//li")
	List<WebElement> individualErrors;

	@FindBy(xpath = "//p[@class='error-msg']")
	WebElement error;

	@FindBy(xpath = "//div[@class='error']//a")
	WebElement errorLink;

	@FindBy(name = "btnCancel")
	WebElement btnCancel;

	@FindBy(linkText = "SAVE CHANGES")
	WebElement savChanges;

	@FindBy(xpath = "//div[@id='bsNameField']/label")
	WebElement lblbsName;

	@FindBy(xpath = "//section[1]/p")
	WebElement billingServiceInfoReqTxtror;

	@FindBy(xpath = "//div[@class='margin-top-beta']/h4")
	WebElement billingServiceInfoServiceAddrs;

	@FindBy(xpath = "//div[@class='margin-top-beta']//p")
	WebElement billingServiceInfoSerAdrsTxt;

	@FindBy(xpath = "//h2[@class='margin-bottom-beta']")
	WebElement billingServiceInfoIdentInfo;

	@FindBy(xpath = "//*[@class='lg']")
	WebElement billingServiceInfoIdentifiers;

	@FindBy(xpath = "//ul[@class='tin-list']//div/span")
	WebElement billingServiceInfoTin;

	@FindBy(xpath = "//section[1]//h1")
	WebElement pageHeader;

	@FindBy(xpath = "//section[2]//h2")
	WebElement provHeader;

	@FindBy(xpath = "//section[2]//h4")
	WebElement provSubHeader;

	@FindBy(id = "prvtype")
	WebElement prvType;

	@FindBy(id = "provSpecialty")
	WebElement prvSpeciallity;
	
	@FindBy(id = "ui-id-1")
	WebElement BussinessScrollBar;
	
	@FindBy(id = "ui-id-2")
	WebElement streetScrollBar;
	
	@FindBy(xpath = "//h2[text()='Provider Identifiers Information']")
	WebElement ProviderIdentifiersInformation;
	
	


	EnrollmentInfo enrollmentInfoPageObj = EnrollmentInfo.getInstance();

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
		int rowNo = 1;
		String provName = Helper.generateRandomAlphabetsString(5);
		String streetName = Helper.generateRandomAlphabetsString(5);
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		String expectedText = "To help ensure the security of your account, you must enter a physical address for your organization. PO Boxes are not allowed and cannot be used as your address of record. If you do attempt to use a PO Box, your enrollment may be delayed and may not be accepted.";
		// Element.verifyTextPresent(txtSecurity, expectedText);
		


		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			Element.enterData(bsName, provName, "Enter provider name as :" + provName, "providerName");
		else {
			Element.enterData(providerName, provName, "Enter provider name as :" + provName, "providerName");
			Element.clickByJS(testConfig, rdoHospital, "Hospital/Facility radio button");
			enrollmentInfoPageObj.setProvType("Hospital/Facility");
			Element.click(chkOther, "Other sub checkbox");
			enrollmentInfoPageObj.setMrktType("Other");
		}

		Element.enterData(street, streetName, "Enter street name as : " + streetName, "street");
		Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),
				"city");
		Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),
				"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"), "zipCode1");
		
		// Skipping business phone assertions for BS enrollment as its not applicable
		if (!enrollmentInfoPageObj.getEnrollType().equals("BS")) {
		
		Element.enterData(businessPhone1,System.getProperty("BusinessPhone1"),
				"Entered business phone1 in first textbox as : " + System.getProperty("BusinessPhone1"),
				"businessPhone1");
		Element.enterData(businessPhone2, System.getProperty("BusinessPhone2"),
				"Entered business phone2 in second textbox as : " + System.getProperty("BusinessPhone2"),
				"businessPhone2");
		Element.enterData(businessPhone3, System.getProperty("BusinessPhone3"),
				"Entered business phone3 in third textbox as : " + System.getProperty("BusinessPhone3"),
				"businessPhone3");
		Element.enterData(businessPhoneExt, System.getProperty("BusinessPhoneExt"),
				"Entered business phone ext in textbox as : " + System.getProperty("BusinessPhoneExt"),
				"businessPhoneExt");
		}


		enrollmentInfoPageObj.setBusinessName(provName);
		enrollmentInfoPageObj.setStreet(streetName);
		enrollmentInfoPageObj.setCity(data.GetData(rowNo, "City"));
		enrollmentInfoPageObj.setStateName(data.GetData(rowNo, "State"));
		enrollmentInfoPageObj.setZipCode(data.GetData(rowNo, "ZipCode"));
		
		// Skipping business phone entry for BS enrollment as its not applicable
		if (!enrollmentInfoPageObj.getEnrollType().equals("BS")) {
		enrollmentInfoPageObj.setBusinessPhone1(System.getProperty("BusinessPhone1"));
		enrollmentInfoPageObj.setBusinessPhone2(System.getProperty("BusinessPhone2"));
		enrollmentInfoPageObj.setBusinessPhone3(System.getProperty("BusinessPhone3"));
		enrollmentInfoPageObj.setBusinessPhoneExt(System.getProperty("BusinessPhoneExt"));
		}
		// Element.click(chkOther, "Other sub checkbox");

		// Element.click(btnContinue, "Continue button");
		Browser.wait(testConfig, 5);
		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			// Same xpath has been used both for Continue and save changes button.
			if (testConfig.driver.getCurrentUrl().contains("CSR"))
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/div[2]/a[1]"),
						"Continue/Save Changes Button CSR");
			else
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAenrBSForm']/div[3]/a[1]"),
						"Continue/Save Changes Button");
		else {
			// Element.click(Element.findElement(testConfig, "xpath",
			// "//*[@id='EFTERAregForm']/footer/a[1]"), "Continue/Save Changes Button");
			if (testConfig.driver.getCurrentUrl().contains("CSR"))
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/div[2]/a[1]"),
						"Continue/Save Changes Button CSR");
			else
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/div[3]/a[1]"),
						"Continue/Save Changes Button");

		}

		return new ValidateEFTERAProviderInfo(testConfig);

	}

	public ValidateEFTERAProviderInfo clickContinueToProviderInfoPage() {
		Element.click(btnContinue, "Continue Button");
		return new ValidateEFTERAProviderInfo(testConfig);
	}

	public ProviderInformationEFTERAEnroll verifyUITextFromDB() {
		int sqlRow = 124;
		testConfig.putRunTimeProperty("subject", "txt.enterbusiness");
		Map contentTbl = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		Helper.compareContains(testConfig, "Business Info Text", contentTbl.get("TEXT_VAL").toString(),
				txtBusinessOrgInfo.getText());

		testConfig.putRunTimeProperty("subject", "txt.infoprvidetax");
		contentTbl = DataBase.executeSelectQuery(testConfig, sqlRow, 1);

		Helper.compareContains(testConfig, "Federal Info Text", contentTbl.get("TEXT_VAL").toString(),
				txtProvFederalInfo.getText());

		testConfig.putRunTimeProperty("subject", "txt.infotaxId");
		contentTbl = DataBase.executeSelectQuery(testConfig, sqlRow, 1);

		Helper.compareContains(testConfig, "Tax ID Info Text",
				contentTbl.get("TEXT_VAL").toString().replace("<br>", "").replace(" Avoid", "Avoid"),
				txtTaxIdInfo.getText().replace("\n", ""));

		Element.verifyElementPresent(lblBusinessName, "Business Name Label");
		Element.verifyElementPresent(lblBusinessAddress, "Business Address Label");
		Element.verifyElementPresent(btnContinue, "Continue button");
		Element.verifyElementPresent(btnCancelEnrollment, "Continue button");
		return this;

	}

	public ProviderInformationEFTERAEnroll verifyUITextFromDBforBS() throws IOException {
		int sqlRowNo = 165;

		HashMap<Integer, HashMap<String, String>> dataTest = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		Element.expectedWait(lblbsName, testConfig, "Billing Service Name", "Billing Service Name");

		String BSInfoReqTxtror = dataTest.get(1).get("TEXT_VAL") + "\n" + dataTest.get(2).get("TEXT_VAL") + "() "
				+ dataTest.get(3).get("TEXT_VAL");

		Helper.compareEquals(testConfig, "BS Info Req. Text", billingServiceInfoReqTxtror.getText(), BSInfoReqTxtror);

		Helper.compareEquals(testConfig, "Billing Service Name", lblbsName.getText(), dataTest.get(4).get("TEXT_VAL"));

		Helper.compareEquals(testConfig, "Billing Service Name", billingServiceInfoServiceAddrs.getText(),
				dataTest.get(5).get("TEXT_VAL"));

		String BSInfoSerAdrsTxt = dataTest.get(6).get("TEXT_VAL") + " " + dataTest.get(7).get("TEXT_VAL")
				+ dataTest.get(8).get("TEXT_VAL");
		Helper.compareEquals(testConfig, "BS Info Address Text", billingServiceInfoSerAdrsTxt.getText(),
				BSInfoSerAdrsTxt);

		Helper.compareEquals(testConfig, "BS Identifier Info.", billingServiceInfoIdentInfo.getText(),
				dataTest.get(9).get("TEXT_VAL"));

		Helper.compareEquals(testConfig, "BS Identifiers", billingServiceInfoIdentifiers.getText(),
				dataTest.get(10).get("TEXT_VAL"));

		Helper.compareEquals(testConfig, "Billing Service TIN", billingServiceInfoTin.getText(),
				dataTest.get(11).get("TEXT_VAL"));

		return this;

	}

	public ProviderInformationEFTERAEnroll verifyOrgInfoHeaders() {
		List<String> headers = Arrays.asList("Organization Information", "Identify Administrators",
				"Financial Institution Information", "Upload W9", "Review and Submit", "Enrollment Submitted");
		for (int i = 0; i < headers.size(); i++) {
			Helper.compareEquals(testConfig, "Headers comparison for : " + headers.get(i), headers.get(i),
					OrgInfoHeaders.get(i).getText().replace("\n", " "));
			if (headers.get(i).equalsIgnoreCase("Organization Information"))
				Helper.compareEquals(testConfig, "Orange Color Value for Organization Information", "#e87722",
						Color.fromString(OrgInfoHeaders.get(i).getCssValue("color")).asHex());
			else
				Helper.compareEquals(testConfig, "Grey Color Value for : " + headers.get(i), "#999999",
						Color.fromString(OrgInfoHeaders.get(i).getCssValue("color")).asHex());

		}
		return this;

	}

	public ProviderInformationEFTERAEnroll verifyCancelEnrollmentFlow() {
		String expectedText = "Are you sure you want to cancel your EPS enrollment application?If you select 'Yes', your EPS enrollment will not be completed and no information will be saved.Select 'No' to return to the EPS enrollment process.";
		clickCancelEnrollment();
		Element.verifyElementPresent(divCancelEnrollment, "Cancel Enrollment Pop up");
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up text", expectedText,
				((txtCancelEnrollmentPopUp.getText() + txtCancelEnrollmentPopUpExtend.get(0).getText()
						+ txtCancelEnrollmentPopUpExtend.get(1).getText()).replace("\n", "")));
		clickNoOnCancelEnrollment().clickCancelEnrollment().clickYesOnCancelEnrollment();
		return this;
	}

	public ProviderInformationEFTERAEnroll verifyContinueEnrollmentValidations() {
		List<String> expectedErrorMsgs;
		Log.Comment("Keep all fields blank..");
		Element.click(btnContinue, "Continue button");
		Element.verifyTextPresent(errorHeader,
				"Please correct the following fields before continuing the enrollment process:");
		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedErrorMsgs = Arrays.asList("- Billing Service Information - Billing Service Name",
					"- Billing Service Information - Billing Service Address Street",
					"- Billing Service Information - Billing Service City",
					"- Billing Service Information - Billing Service State",
					"- Billing Service Information - Billing Service Zip Code");
		else
			expectedErrorMsgs = Arrays.asList("- Organization Information - Business Name",
					"- Organization Information - Street", "- Organization Information - City",
					"- Organization Information - State", "- Organization Information - Zip Code",
					"- Organization Information - Provider Type/Market Type");
		for (int i = 0; i < expectedErrorMsgs.size(); i++)
			Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));

		verifyMissingDataErrorMsg();

		return this;
	}

	public ProviderInformationEFTERAEnroll fillBusinessName(String name) throws IOException {
		int rowNo = 1;
		Element.enterData(providerName, name, "Enter Business Name as : " + name, "Business Name");
		enrollmentInfoPageObj.setBusinessName(name);
		String streetName = Helper.generateRandomAlphabetsString(5);
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		
		Element.enterData(street, streetName, "Enter street name as : " + streetName, "street");
		Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),
				"city");
		Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),
				"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"), "zipCode1");
		
		return this;
	}

	public ProviderInformationEFTERAEnroll fillBusinessAddress(String address) {
		Element.enterData(street, address, "Street Address as : " + address, "Street Address");
		Element.enterData(city, address, "City Address as : " + address, "City Address");
		return this;
	}

	public ProviderInformationEFTERAEnroll verifyErrorMsgForInvalidData(String fieldName) {
		Element.click(btnContinue, "Continue button");
		Element.verifyTextPresent(errorHeader,
				"Please correct the following fields before continuing the enrollment process:");
		if (fieldName.equals("BusinessName"))
			Element.verifyTextPresent(providerName.findElement(By.xpath("../following-sibling::p")),
					"Special characters not allowed");
		if (fieldName.equals("BusinessAddress")) {
			Browser.wait(testConfig, 2);
			Element.verifyTextPresent(street.findElement(By.xpath("following-sibling::p")),
					"Special characters not allowed");
			Element.verifyTextPresent(city.findElement(By.xpath("following-sibling::p")),
					"Special characters not allowed");
		}

		return this;
	}

	public void verifyMissingDataErrorMsg() {
		String expectedText = "Missing Data";
		String expectedColor = "#c21926";

		Log.Comment("Verifying Error Msg is displayed for Business Name..");
		if (enrollmentInfoPageObj.getEnrollType().contains("BS")) {
			Element.verifyTextPresent(bsName.findElement(By.xpath("../following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in Business Name text box", expectedColor,
					Color.fromString(bsName.getCssValue("border-top-color")).asHex());
		} else {
			Element.verifyTextPresent(providerName.findElement(By.xpath("../following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted in provider text box", expectedColor,
					Color.fromString(providerName.getCssValue("border-top-color")).asHex());

			Log.Comment("Verifying Error Msg is displayed for Provide type..");
			Element.verifyTextPresent(lblProvType.findElement(By.xpath("following-sibling::p")), expectedText);
			Helper.compareEquals(testConfig, "Verify Red color is highlighted for Provide type..", expectedColor,
					Color.fromString(lblProvType.getCssValue("border-top-color")).asHex());
		}

		Log.Comment("Verifying Error Msg is displayed for Street..");
		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			Element.verifyTextPresent(street.findElement(By.xpath("../following-sibling::p")), expectedText);
		else
			Element.verifyTextPresent(Element.findElement(testConfig, "xpath", "//div[@id='prvstreet']/div[1]/div/p"),
					expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box", expectedColor,
				Color.fromString(street.getCssValue("border-top-color")).asHex());

		Log.Comment("Verifying Error Msg is displayed for City..");
		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			Element.verifyTextPresent(city.findElement(By.xpath("../following-sibling::p")), expectedText);
		else
			Element.verifyTextPresent(Element.findElement(testConfig, "xpath", "//div[@id='prvstreet']/div[2]/div/p"),
					expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in City text box", expectedColor,
				Color.fromString(city.getCssValue("border-top-color")).asHex());

		Log.Comment("Verifying Error Msg is displayed for State dropdown..");
		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			Element.verifyTextPresent(drpDwnState.findElement(By.xpath("../following-sibling::p")), expectedText);
		else
			Element.verifyTextPresent(Element.findElement(testConfig, "xpath", "//div[@id='prvstate']/div//p"),
					expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for State dropdown", expectedColor,
				Color.fromString(drpDwnState.getCssValue("border-top-color")).asHex());

		Log.Comment("Verifying Error Msg is displayed for Zip/Postal Code..");
		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			Element.verifyTextPresent(
					testConfig.driver.findElement(By.xpath("//form[@id='EFTERAenrBSForm']//fieldset//p")),
					expectedText);
		else
			Element.verifyTextPresent(Element.findElement(testConfig, "xpath", "//div[@id='prvstate']/fieldset//p"),
					expectedText);
		// Element.verifyTextPresent(testConfig.driver.findElement(By.xpath("//div[id='bsZipField']//following-sibling::p")),
		// expectedText);
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip1/Postal Code", expectedColor,
				Color.fromString(zipCode1.getCssValue("border-top-color")).asHex());
		Helper.compareEquals(testConfig, "Verify Red color is highlighted for Zip2 Code", expectedColor,
				Color.fromString(zipCode2.getCssValue("border-top-color")).asHex());

	}

	public ProviderInformationEFTERAEnroll clickCancelEnrollment() {
		Element.click(btnCancelEnrollment, "Cancel Enrollment");
		return this;
	}

	public UPARegistrationPage clickYesOnCancelEnrollment() {
		Element.click(btnYesOnCancelPopUp, "Yes button on cancel Enrollment Pop up");
		return new UPARegistrationPage(testConfig);
	}

	public ProviderInformationEFTERAEnroll clickNoOnCancelEnrollment() {
		Element.click(btnNoOnCancelPopUp, "No button on cancel Enrollment Pop up");
		return this;
	}

	public ProviderInformationEFTERAEnroll validateBillingService(String field, String data, String ButtonType)
			throws IOException {
		WebElement ele = null;
		Browser.wait(testConfig, 2);
		fillBillingServiceInfo(field);
		switch (field) {
		case "BSName":
			if (enrollmentInfoPageObj.getEnrollType().equals("BS")) {
				Element.enterData(bsName, data, "Enter provider name as :" + data, "providerName");
				ele = bsName;
			} else {
				Element.enterData(providerName, data, "Enter provider name as :" + data, "providerName");
				ele = providerName;
			}
			break;
		case "Street":
			Element.clearData(street, "street");
			Element.enterData(street, data, "Enter street name as : " + data, "street");
			ele = street;
			break;
		case "City":
			Element.enterData(city, data, "Enter city name as :" + data, "city");
			ele = city;
			break;
		case "State":
			Element.selectVisibleText(drpDwnState, data, "Enter state name");
			ele = drpDwnState;
			break;
		case "ZipCode":
			Element.enterData(zipCode1, data, "Entered zip code in first textbox as: " + data, "zipCode1");
			ele = zipCode1;
			break;
		case "NPI":
			Element.enterData(npi, data, "Entered npi as: " + data, "NPI");
			ele = npi;
			break;
		}
		if (ButtonType.equalsIgnoreCase("CONTINUE"))
			Element.click(btnContinue, "Continue button");

		else {
			Element.click(savChanges, "Save Changes button");

			Helper.compareEquals(testConfig, "Cancel Button Disabled", "true", btnCancel.getAttribute("disabled"));
			// Element.verifyElementVisiblity(btnCancel, "Cancel Button");
		}
		verifyBSError(ele,field);
		return this;

	}

	public ProviderInformationEFTERAEnroll fillBillingServiceInfo(String field) throws IOException {
		int rowNo = 1;
		String provName = Helper.generateRandomAlphabetsString(5);
		String streetName = Helper.generateRandomAlphabetsString(5);
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");

		if (!field.equals("BSName"))
			if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
				Element.enterData(bsName, provName, "Enter provider name as :" + provName, "providerName");
			else
				Element.enterData(providerName, provName, "Enter provider name as :" + provName, "providerName");
		if (!field.equals("Street")) {
			Element.enterData(street, streetName, "Enter street name as : " + streetName, "street");
		}
		if (!field.equals("City"))
			Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),
					"city");
		if (!field.equals("State"))
			Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		if (!field.equals("ZipCode"))
			Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),
					"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"), "zipCode1");
	
		return this;
	}

	public void verifyBSError(WebElement element, String field) {
		if (field.equals("ZipCode")) {
			if (error.getText().contains("Data"))
				Element.verifyTextPresent(error, "Invalid Data");
			else
				Element.verifyTextPresent(error, "Invalid for City/State");
		} else if (field.equals("BSName")) {
			if (error.getText().contains("Special"))
				Element.verifyTextPresent(error, "Special characters not allowed");
		} else if (field.equals("City")) {
			if (error.getText().contains("Special"))
				Element.verifyTextPresent(error, "Special characters not allowed");
		} else if (field.equals("Street")) {
			if (error.getText().contains("Special"))
				Element.verifyTextPresent(error, "Special characters not allowed");
			else if (error.getText().contains("P.O."))
				Element.verifyTextPresent(error, "P.O. Boxes are not accepted");
			else
				Element.verifyTextPresent(error, "PO Boxes are not accepted");
		} else if (field.equals("NPI"))
			Element.verifyTextPresent(error, "Enter a valid 10 digit NPI");
		else
			Element.verifyTextPresent(error, "Special characters not allowed");
		Element.verifyElementPresent(errorLink, "Error links");
		Helper.compareEquals(testConfig, "Verify Red color is highlighted in Street text box", "#c21926",
				Color.fromString(element.getCssValue("border-top-color")).asHex());

	}

	public ProviderInformationEFTERAEnroll verifyCanclSavChangeBtns() {
		Element.verifyElementPresent(btnCancel, "CANCEL CHANGES button");
		Element.verifyElementPresent(savChanges, "SAVE CHANGES button");
		return this;
	}

	public ReviewAndSubmit clickCanclChangBtn() {
		Element.click(btnCancel, "CANCEL CHANGES button");
		return new ReviewAndSubmit(testConfig);
	}

	public ProviderInformationEFTERAEnroll verifyEditable() {

		// Comparision of various fields with previous input
		if (enrollmentInfoPageObj.getEnrollType().equals("BS"))
			Helper.compareEquals(testConfig, "BS Name Value comparision", enrollmentInfoPageObj.getBusinessName(),
					bsName.getAttribute("value"));
		else
			Helper.compareEquals(testConfig, "BS Name Value comparision", enrollmentInfoPageObj.getBusinessName(),
					providerName.getAttribute("value"));
		Helper.compareEquals(testConfig, "Street Value comparision", enrollmentInfoPageObj.getStreet(),
				street.getAttribute("value"));
		Helper.compareEquals(testConfig, "City Value comparision", enrollmentInfoPageObj.getCity(),
				city.getAttribute("value"));
		Helper.compareEquals(testConfig, "State Value comparision", enrollmentInfoPageObj.getStateName(),
				drpDwnState.getAttribute("value"));
		Helper.compareEquals(testConfig, "zip code Value comparision", enrollmentInfoPageObj.getZipCode(),
				zipCode1.getAttribute("value"));

		// Checking of editable criteria
		if (enrollmentInfoPageObj.getEnrollType().equals("BS") && (bsName.getAttribute("readonly") == null)
				&& (street.getAttribute("readonly") == null) && (city.getAttribute("readonly") == null)
				&& (drpDwnState.getAttribute("readonly") == null) && (zipCode1.getAttribute("readonly") == null))
			Log.Pass("Billing service fields are editable.");
		else if (enrollmentInfoPageObj.getEnrollType().equals("HO") && (providerName.getAttribute("readonly") == null)
				&& (street.getAttribute("readonly") == null) && (city.getAttribute("readonly") == null)
				&& (drpDwnState.getAttribute("readonly") == null) && (zipCode1.getAttribute("readonly") == null))
			Log.Pass("Organization Information fields are editable.");
		else
			Log.Fail("Billing service fields are readOnly.");

		return this;
	}

	public void verifyFooterButton() {
		Element.verifyElementPresent(btnCancel, "Cancel Changes Button");
		Element.verifyElementPresent(savChanges, "Save Changes Button");

		Element.click(btnCancel, "Cancel Changes Button");
		String expectedURL = "cancelBSReviewSubmit";
		Browser.verifyURL(testConfig, expectedURL);
	}

	public void verifyClickSaveChanges() {

		if (savChanges.isDisplayed() && savChanges.isEnabled()) {
			Log.Pass("Save changes button are present on webpage");
			savChanges.click();

		} else
			Log.Fail("Either Cancel changes or Save changes button or Both are not present on webpage");
	}

	public void verifyErrorMsgNull() {
		List<String> expectedErrorMsgs = null;
		if (enrollmentInfoPageObj.getEnrollType().contains("HO")) {
			Element.clearData(providerName, "Provider Service Name");
			Element.click(chkOther, "Other Check Button");
			expectedErrorMsgs = Arrays.asList("- Organization Information - Business Name",
					"- Organization Information - Street", "- Organization Information - City",
					"- Organization Information - State", "- Organization Information - Zip Code",
					"- Organization Information - Provider Type/Market Type");
		} else {
			Element.clearData(bsName, "Billing Service Name");
			expectedErrorMsgs = Arrays.asList("- Billing Service Information - Billing Service Name",
					"- Billing Service Information - Billing Service Address Street",
					"- Billing Service Information - Billing Service City",
					"- Billing Service Information - Billing Service State",
					"- Billing Service Information - Billing Service Zip Code");
		}
		Element.clearData(street, "Street Field ");
		Element.clearData(city, "City Field ");
		Element.selectByVisibleText(drpDwnState, "Select State", "default select state option");
		Element.clearData(zipCode1, "Zip Code1 field");
		Element.clearData(zipCode2, "Zip Code2 field");
		Element.click(savChanges, "Save Changes Button");

		Element.verifyTextPresent(errorHeader,
				"Please correct the following fields before continuing the enrollment process:");

		for (int i = 0; i < expectedErrorMsgs.size(); i++)
			Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));
		verifyMissingDataErrorMsg();

	}

	public void verifyContentBSWithUXDS() throws IOException {

		ArrayList<String> listUI = new ArrayList<String>();
		ArrayList<String> listUXDS = new ArrayList<String>();
		listUI.add(testConfig.driver.findElement(By.className("progress-indicator__container")).getText());
		listUI.add(testConfig.driver.findElement(By.xpath("//h1 [text()='Billing Service Information']")).getText());
		listUI.add(billingServiceInfoReqTxtror.getText());
		listUI.add(lblbsName.getText());
		listUI.add(billingServiceInfoServiceAddrs.getText());
		listUI.add(billingServiceInfoSerAdrsTxt.getText());
		listUI.add(billingServiceInfoIdentInfo.getText());
		listUI.add(billingServiceInfoIdentifiers.getText());
		listUI.add(billingServiceInfoTin.getText());

		new UXDSPageValidation(testConfig, "Enrollment BS Billing Service");

		listUXDS.add(Element.findElement(testConfig, "className", "progress-indicator__container").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//h1 [text()='Billing Service Information']").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//form//p").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//label [text()='Billing Service Name']").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//div[@class='margin-top-beta']/h4").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//div[@class='margin-top-beta']//p").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//h2 [text()='Billing Service Identifiers Information']")
				.getText());
		listUXDS.add(
				Element.findElement(testConfig, "xpath", "//strong [text()='Billing Service Identifiers']").getText());
		listUXDS.add(Element.findElement(testConfig, "xpath", "//span [text()='Billing Service TIN ']").getText());

		Helper.compareEquals(testConfig, "UI and UXDS comparision", listUXDS, listUI);
		if (listUI.equals(listUXDS)) {
			Log.Pass("matches in both UI and UXDS");
		} else {
			Log.Fail("matches in both UI and UXDS");
		}
	}

	public ReviewAndSubmit clickSaveBtn() {
		Element.click(savChanges, "SAVE CHANGES button");
		return new ReviewAndSubmit(testConfig);
	}

	public ProviderInformationEFTERAEnroll verifyCanclChangBtnDsabl() {
		Helper.compareEquals(testConfig, "Cancel Change button is disabled", "true",
				btnCancel.getAttribute("disabled"));
		return this;
	}

	public ProviderInformationEFTERAEnroll verifyPageContentManaged() throws IOException {
		int sqlRowNo = 173;
		HashMap<Integer, HashMap<String, String>> pageData = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);

		Helper.compareEquals(testConfig, "Header", pageData.get(2).get("TEXT_VAL"), pageHeader.getText());
		Helper.compareEquals(testConfig, "Business Info Text",
				pageData.get(18).get("TEXT_VAL").toString() + "() " + pageData.get(17).get("TEXT_VAL").toString(),
				txtBusinessOrgInfo.getText());
		Helper.compareEquals(testConfig, "Business Name", pageData.get(16).get("TEXT_VAL").toString(),
				lblBusinessName.getText());
		Helper.compareEquals(testConfig, "Page Content ID",
				pageData.get(13).get("TEXT_VAL").replace("<br>", "").replace(" Avoid", "Avoid").toString(),
				txtTaxIdInfo.getText().replace("\n", ""));
		Helper.compareEquals(testConfig, "Business Address", pageData.get(11).get("TEXT_VAL").toString(),
				lblBusinessAddress.getText());
		Helper.compareEquals(testConfig, "Street", pageData.get(15).get("TEXT_VAL").toString(), lblStreet.getText());
		Helper.compareEquals(testConfig, "City", pageData.get(14).get("TEXT_VAL").toString(), lblCity.getText());
		Helper.compareEquals(testConfig, "State", pageData.get(10).get("TEXT_VAL").toString(), lblState.getText());
		Helper.compareEquals(testConfig, "Zip", pageData.get(9).get("TEXT_VAL").toString(), lblZip.getText());
		Helper.compareEquals(testConfig, "Business Address Text",
				pageData.get(12).get("CLOBVAL").replace("<strong>", "").replace("</strong>", "").toString(),
				txtBusinessAddress.getText());
		Helper.compareEquals(testConfig, "Provider Header", pageData.get(8).get("TEXT_VAL"), provHeader.getText());
		Helper.compareEquals(testConfig, "Provider SubHeader", pageData.get(7).get("TEXT_VAL"),
				provSubHeader.getText());
		Helper.compareEquals(testConfig, "Provider Federal Text", pageData.get(6).get("TEXT_VAL").toString(),
				txtProvFederalInfo.getText());
		Helper.compareEquals(testConfig, "NPI text", pageData.get(5).get("TEXT_VAL").toString(), txtNPI.getText());

		sqlRowNo = 177;
		testConfig.putRunTimeProperty("mktTyp", "PT");
		HashMap<Integer, HashMap<String, String>> contentTbl = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		Helper.compareEquals(testConfig, "Provider Type",
				 "Provider Type"+"\n"+contentTbl.get(1).get("MKT_TYP_DESC").trim()+"\n"
						+ contentTbl.get(3).get("MKT_TYP_DESC").trim()+"\n" + contentTbl.get(4).get("MKT_TYP_DESC").trim()+"\n" +contentTbl.get(5).get("MKT_TYP_DESC").trim()+"\n" +contentTbl.get(6).get("MKT_TYP_DESC").trim()+"\n" + contentTbl.get(2).get("MKT_TYP_DESC").trim(),
				prvType.getText());
		testConfig.putRunTimeProperty("mktTyp", "PR");
		contentTbl = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
		String data = "";
		for (int i = 1; i <= contentTbl.size(); i++) {
			if (i == contentTbl.size())
				data = data + contentTbl.get(i).get("MKT_TYP_DESC").trim();
			else
				data = data + contentTbl.get(i).get("MKT_TYP_DESC").trim() + "\n";
		}
		Helper.compareEquals(testConfig, "Provider Type Speciality", pageData.get(3).get("TEXT_VAL") + "\n" + data,
				prvSpeciallity.getText());

		return this;
	}

	
	public void verifyBusinesPhoneErrorMsg() {
		Element.verifyTextPresent(error, "Invalid Data");
		Element.verifyElementPresent(errorLink, "Error links");

		
	}

	public void setOrgValues() {
			Element.clickByJS(testConfig, rdoHospital, "Hospital/Facility radio button");
		enrollmentInfoPageObj.setProvType("Hospital/Facility");
		Element.click(chkOther, "Other sub checkbox");
		enrollmentInfoPageObj.setMrktType("Other");
	
	}
	
	/** This method auto populates BusinessName(provName) and Business Address --- EPIM User stories
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public ValidateEFTERAProviderInfo fillProviderOrgInfoWithAutoPopulatedInfo(String checkAutoPopulate) throws IOException  {
		
		
		int rowNo = 1;
		String provName = Helper.generateRandomAlphabetsString(5);
		String streetName = Helper.generateRandomAlphabetsString(5);	
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		if (checkAutoPopulate.equals("busNameYAndAddrY")) {
			provName = "MAY";
			streetName = Helper.generateRandomAlphaNumericString(4);
			Element.enterData(providerName, provName, "Enter provider name as :" + provName, "providerName");
			Browser.wait(testConfig, 2);
			Element.clickByJS(testConfig, autoPopulateProviderNameList, "Provider Name");
			Browser.wait(testConfig, 2);
			Element.enterData(street, streetName, "Enter street name as : " + streetName, "Street");
			Browser.wait(testConfig, 3);
			Element.clickByJS(testConfig, autoPopulateStreetList, "Street Name");
			setOrgValues();
			testConfig.putRunTimeProperty("BusinessNameInd", "Y");
			testConfig.putRunTimeProperty("BusinessAddressInd", "Y");

		} else if (checkAutoPopulate.equals("busNameYAndAddrN")) {
			provName = "MAY";
			Element.enterData(providerName, provName, "Enter provider name as :" + provName, "providerName");
			Browser.wait(testConfig,2);	      
			Element.clickByJS(testConfig,autoPopulateProviderNameList, "Provider Name");	
			Element.enterData(street, streetName, "Enter street name as : " + streetName, "street");
			Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),
					"city");
			Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
			Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),
					"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"), "zipCode1");
			setOrgValues();
			testConfig.putRunTimeProperty("BusinessNameInd", "Y");
			testConfig.putRunTimeProperty("BusinessAddressInd", "N");

		}else if(checkAutoPopulate.equals("busNameNAndAddrY")) {
			 provName = "abc";
			 streetName ="1234";
			  Element.enterData(providerName, provName, "Enter provider name as :" + provName, "providerName");
			 setOrgValues();
			  Browser.wait(testConfig,2);	      
				Element.enterData(street, streetName, "Enter street name as : " + streetName,"Street");
				Browser.wait(testConfig,2);	      
	              Element.clickByJS(testConfig,autoPopulateStreetList, "Street Name");	
			    testConfig.putRunTimeProperty("BusinessNameInd", "N");
			      testConfig.putRunTimeProperty("BusinessAddressInd", "Y");

		}else {
			Element.enterData(providerName, provName, "Enter provider name as :" + provName, "providerName");
			setOrgValues();
			Element.enterData(street, streetName, "Enter street name as : " + streetName, "street");
			Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),
					"city");
			Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
			Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),
					"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"), "zipCode1");
			testConfig.putRunTimeProperty("BusinessNameInd", "N");
			testConfig.putRunTimeProperty("BusinessAddressInd", "N");

		}

		Element.enterData(businessPhone1,System.getProperty("BusinessPhone1"),
				"Entered business phone1 in first textbox as : " + System.getProperty("BusinessPhone1"),
				"businessPhone1");
		Element.enterData(businessPhone2, System.getProperty("BusinessPhone2"),
				"Entered business phone2 in second textbox as : " + System.getProperty("BusinessPhone2"),
				"businessPhone2");
		Element.enterData(businessPhone3, System.getProperty("BusinessPhone3"),
				"Entered business phone3 in third textbox as : " + System.getProperty("BusinessPhone3"),
				"businessPhone3");
		Element.enterData(businessPhoneExt, System.getProperty("BusinessPhoneExt"),
				"Entered business phone ext in textbox as : " + System.getProperty("BusinessPhoneExt"),
				"businessPhoneExt");

		enrollmentInfoPageObj.setBusinessName(provName);
		enrollmentInfoPageObj.setStreet(streetName);
		enrollmentInfoPageObj.setCity(data.GetData(rowNo, "City"));
		enrollmentInfoPageObj.setStateName(data.GetData(rowNo, "State"));
		enrollmentInfoPageObj.setZipCode(data.GetData(rowNo, "ZipCode"));
		enrollmentInfoPageObj.setBusinessPhone1(System.getProperty("BusinessPhone1"));
		enrollmentInfoPageObj.setBusinessPhone2(System.getProperty("BusinessPhone2"));
		enrollmentInfoPageObj.setBusinessPhone3(System.getProperty("BusinessPhone3"));
		enrollmentInfoPageObj.setBusinessPhoneExt(System.getProperty("BusinessPhoneExt"));

		Browser.wait(testConfig, 5);
		if (enrollmentInfoPageObj.getEnrollType().equals("HO"))
			// Same xpath has been used both for Continue and save changes button.
			if (testConfig.driver.getCurrentUrl().contains("CSR"))
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/div[2]/a[1]"),
						"Continue/Save Changes Button CSR");
			else
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/div[3]/a[1]"),
						"Continue/Save Changes Button");
		else {
			// Element.click(Element.findElement(testConfig, "xpath",
			// "//*[@id='EFTERAregForm']/footer/a[1]"), "Continue/Save Changes Button");
			if (testConfig.driver.getCurrentUrl().contains("CSR"))
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/div[2]/a[1]"),
						"Continue/Save Changes Button CSR");
			else
				Element.click(Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/div[3]/a[1]"),
						"Continue/Save Changes Button");

		}
		
		return new ValidateEFTERAProviderInfo(testConfig);

	}
	public void fillBussinessandStreetInfo(String BussinessName, String streetName) {
		Element.verifyElementPresent(providerName, "Business Name");
		Element.enterData(providerName, BussinessName, "Enter Bussiness name as : " + BussinessName, "providerName");
		Browser.wait(testConfig, 3);
		Element.verifyElementPresent(BussinessScrollBar, "Scroll Bar");
		Element.enterKeys(providerName, Keys.TAB, "TAB Key entering", "TAB Key");
		Element.verifyElementPresent(street, "Street Name");
		Element.verifyElementIsEnabled(street, "Street Name");
		Element.enterData(street, streetName, "Enter street name as : " + streetName, "street");
		Browser.wait(testConfig, 3);
		Element.verifyElementPresent(streetScrollBar, "Scroll Bar");
	}
	
	
	

	
}
