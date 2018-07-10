package main.java.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class FinancialInstitutionInfoPage extends validateEFTERAFinancialInfo{

	@FindBy(name = "finInstTinName")
	WebElement finInstName;

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

	@FindBy(name = "btnSubmit")
	WebElement btnContinue;
	
	@FindBy(xpath="//tr[4]/td/table/tbody/tr/td[2]")
	WebElement txtSecurity;

	private TestBase testConfig;
	

	public FinancialInstitutionInfoPage(TestBase testConfig) 
	{
		super();
		String expectedURL = "/validateEFTERAProviderContact";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	

	public validateEFTERAFinancialInfo clickContinue() {
		Element.click(btnContinue, "Continue");
		return new validateEFTERAFinancialInfo(testConfig) ;
	}

	public void fillFinancialInstInfo() throws IOException
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
		Element.click(rdoSavings, "Savings account type");
		Element.click(rdoNPINo, "No radip button for Npi");
		fillFinancialInstInfoFromExcel();
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

    }
}
