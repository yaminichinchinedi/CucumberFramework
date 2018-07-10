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

	@FindBy(xpath = "//input[@name='provType'][1]")
	WebElement rdoHospital;

	@FindBy(xpath = "//input[@name='provType'][2]")
	WebElement rdoPhysician;

	@FindBy(xpath = "//input[@name='provType'][3]")
	WebElement rdoOtherHealthcare;

	@FindBy(xpath = ".//*[@id='mktid']//input[1]")
	WebElement chkBehaviouralHealth;
	
//	@FindBy(xpath = ".//*[@id='mktid']//input[4]")
//	WebElement chkOther;
	
	@FindBy(xpath = "//input[@value='103']")
	WebElement chkOther;

	@FindBy(name = "btnSubmit")
	WebElement btnContinue;
	
	@FindBy(xpath = "//tr[@class='subheadernormal'][3]//td//table//tr//td")
	WebElement txtSecurity;
	

	private TestBase testConfig;
	public ValidateEFTERAProviderInfo validateProvInfo;

	public ProviderInformationEFTERAEnroll(TestBase testConfig) {
		String expectedURL = "/providerInformationEFTERAEnroll";
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
		
	
	}

	public ValidateEFTERAProviderInfo fillProviderInfo() throws IOException {
		int rowNo=1;
		String expectedText="To help ensure the security of your account, you must enter a physical address for your organization. PO Boxes are not allowed and cannot be used as your address of record. If you do attempt to use a PO Box, your enrollment may be delayed and may not be accepted.";
		TestDataReader data= testConfig.cacheTestDataReaderObject("FinancialInfo");
		
		//Element.verifyTextPresent(txtSecurity, expectedText);
		
		String provName = Helper.generateRandomAlphabetsString(5);
		Element.enterData(providerName, provName, "Enter provider name","providerName");
		
		String streetName = Helper.generateRandomAlphabetsString(5);
		Element.enterData(street, streetName, "Enter street name","street");
			
		Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name","city");
		
		Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		
		Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"),"zipCode1");
		Browser.wait(testConfig, 5);
		Element.click(rdoHospital, "Hospital/Facility radio button");
		//Element.click(chkBehaviouralHealth, "Behavioual Health checkbox");
		Browser.wait(testConfig, 5);
		Element.click(chkOther, "Other sub checkbox");
		Browser.wait(testConfig, 5);
		if(!chkOther.isSelected())
		{
			Element.click(chkOther, "Other sub checkbox");
		}
		Element.verifyElementIsChecked(chkOther, "other checkbox");
		
		Element.click(btnContinue, "Continue button");
		return new ValidateEFTERAProviderInfo(testConfig);

	}

}
