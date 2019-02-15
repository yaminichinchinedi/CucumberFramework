package main.java.pageObjects;

import java.io.IOException;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.api.pojo.epsEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingServiceInformation extends ProviderInformationEFTERAEnroll {
	
	@FindBy(name = "bsName")
	WebElement bsName;
	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	
	public BillingServiceInformation(TestBase testConfig) {
		super(testConfig);
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	public ValidateBSbillingServiceInfo fillBusinessOrgInfo() throws IOException {
		int rowNo=1;
		TestDataReader data= testConfig.cacheTestDataReaderObject("FinancialInfo");
		String expectedText="To help ensure the security of your account, you must enter a physical address for your organization. PO Boxes are not allowed and cannot be used as your address of record. If you do attempt to use a PO Box, your enrollment may be delayed and may not be accepted.";
		
		String BSName = Helper.generateRandomAlphabetsString(5);
		Element.enterData(bsName, BSName, "Enter provider name as :" + BSName,"providerName");
		
		
		String streetName = Helper.generateRandomAlphabetsString(5);
		Element.enterData(street, streetName, "Enter street name as : " + streetName,"street");
		
		Element.enterData(city, data.GetData(rowNo, "City"), "Enter city name as :" + data.GetData(rowNo, "City"),"city");
		Element.selectVisibleText(drpDwnState, data.GetData(rowNo, "State"), "Enter state name");
		Element.enterData(zipCode1, data.GetData(rowNo, "ZipCode"),"Entered zip code in first textbox as" + data.GetData(rowNo, "ZipCode"),"zipCode1");
		enrollmentInfoPageObj.setBusinessName(BSName);
		enrollmentInfoPageObj.setStreet(streetName);
		enrollmentInfoPageObj.setCity(data.GetData(rowNo, "City"));
		enrollmentInfoPageObj.setStateName(data.GetData(rowNo, "State"));
		enrollmentInfoPageObj.setZipCode(data.GetData(rowNo, "ZipCode"));
		Element.click(btnContinue, "Continue button");
		return new ValidateBSbillingServiceInfo(testConfig);

	}
}
