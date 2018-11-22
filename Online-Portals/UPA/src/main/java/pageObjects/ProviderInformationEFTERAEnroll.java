package main.java.pageObjects;

import java.io.IOException;
import main.java.nativeFunctions.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

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

	@FindBy(xpath = "//input[@id='14']//following-sibling::label")
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
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][3]//td//table//tr//td")
	WebElement txtSecurity;
	

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
		
		//Element.click(chkBehaviouralHealth, "Behavioual Health checkbox");
		
		Element.click(chkOther, "Other sub checkbox");
		Element.click(btnContinue, "Continue button");
		return new ValidateEFTERAProviderInfo(testConfig);

	}

}
