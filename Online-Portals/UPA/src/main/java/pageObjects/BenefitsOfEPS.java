package main.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class BenefitsOfEPS {
	
	@FindBy(xpath="//h1[contains(text(),'Benefits of EPS')]")
	private WebElement textBenefitsOfEps;
	
	@FindBy(linkText="Payment Savings Calculator")
	private WebElement lnkPaymentSavingsCalc;
	
	private TestBase testConfig;
	
	public BenefitsOfEPS(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expectedURL="benefitofeps.do";
		
		Element.expectedWait(textBenefitsOfEps, testConfig, "Benefits of EPS", "Benefits of EPS");
		Browser.verifyURL(testConfig, expectedURL);
		Element.verifyElementPresent(lnkPaymentSavingsCalc, "Payment Saving Calculator");		
	}

}
