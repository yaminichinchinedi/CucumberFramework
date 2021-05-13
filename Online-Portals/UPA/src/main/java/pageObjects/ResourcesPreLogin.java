package main.java.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class ResourcesPreLogin {
	
	
	
	@FindBy(xpath="//h2[contains(text(),'Guides')]")
	private WebElement textGuides;
	
	@FindBy(linkText="Cancellation Form")
	WebElement  CancellationForm;
	
	private TestBase testConfig;
	
	public ResourcesPreLogin(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expectedURL="epsFaqs.do";
		
		Element.expectedWait(textGuides, testConfig, "Guides", "Guides");
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	
	
	public void verifyCancellationFormLinkUnderResourcesPreLogin()
	{
		Element.verifyElementPresent(CancellationForm, "Cancellation Form");
		Element.click(CancellationForm, "Cancellation Form");
		Browser.switchToNewWindow(testConfig);
		Helper.compareEquals(testConfig, "Cancellation Form window", 2, Browser.getNoOfWindowHandles(testConfig));
		Helper.compareContains(testConfig, "The Cancellation PDF URL", "pdf", testConfig.getDriver().getCurrentUrl());
		Browser.verifyURL(testConfig, "pdf");
	}
	
	public void verifyCancellationFormLinkPDFContent() throws IOException
	{
		String expectedPDFContent=null;
		String actualPDFContent=null;
		
		String exPDFPath = System.getProperty("user.dir") + "\\PDFDocuments\\CancellationForm.pdf";
		
		actualPDFContent = Helper.readPDF(TestBase.driver.getCurrentUrl());
		expectedPDFContent = Helper.readPDF(exPDFPath);
		
		Helper.compareEquals(testConfig, "The Cancellation Form PDF", expectedPDFContent, actualPDFContent);
	}
	
	
	

		
	
	


}