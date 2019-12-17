package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPaymentMethods {
	
private TestBase testConfig;
	
	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;

	@FindBy(xpath=".//*[@id='EFTERAregForm']//td[1]//tr[5]/td[2]/select")
	WebElement drpPaytyp;
	
	public SelectPaymentMethods(TestBase testConfig) 
	{
		String expectedURL = "/validateEFTERAFinancialInfo";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
//		Browser.verifyURL(testConfig, expectedURL);
	}

	public void chooseACHVCP()
	{
		drpPaytyp=Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']//div[2]//table//tr/td[1]//tr[1]/td[2]/select");
		Element.selectVisibleText(drpPaytyp, "VCP", "Choose VCP Option");
	}
	
	public UploadW9 clickContinue() {
		chooseACHVCP();
		Browser.wait(testConfig, 2);
		Element.clickByJS(testConfig, btnContinue, "Continue");
		return new UploadW9(testConfig) ;
	}
}
