package main.java.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class ResourcesPreLogin {
	
	
	
	@FindBy(xpath="//h2[contains(text(),'Guides')]")
	private WebElement textGuides;
	
	@FindBy(xpath="//a[text()='How to enroll – ACH']")
	private WebElement HowToEnrollACH;
	
	@FindBy(xpath="//a[text()='How to enroll – VCP']")
	private WebElement HowToEnrollVCP;
	
	@FindBy(xpath="//a[text()='How to enroll – Billing service']")
	private WebElement HowToEnrollBillingService;
	
	@FindBy(xpath="//a[text()='Alternative payment routing guide']")
	private WebElement AltPayRoutGuid;
	
	@FindBy(xpath="//a[text()='Updating payment method guide']")
	private WebElement UpdtPayMetGuid;
	
	@FindBy(xpath="//a[text()='Locating member payments guide']")
	private WebElement LocMemPayGuid;
	
	@FindBy(xpath="//h2[text()='Forms and Documents']")
	private WebElement FormsAndDocs;
		
	@FindBy(xpath="//a[text()='Cancellation Form']")
	WebElement  CancellationForm;
	
	@FindBy(xpath="//a[text()='FAQs']")
	WebElement  FAQs;
	
	private TestBase testConfig;
	String expectedPDFContent=null;
	String actualPDFContent=null;
	
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
		
		
		String exPDFPath = System.getProperty("user.dir") + "\\PDFDocuments\\CancellationForm.pdf";
		
		actualPDFContent = Helper.readPDF(TestBase.driver.getCurrentUrl());
		expectedPDFContent = Helper.readPDF(exPDFPath);
		
		Helper.compareEquals(testConfig, "The Cancellation Form PDF", expectedPDFContent, actualPDFContent);
	}
	
	public void verifyHowToEnrollACHdocument(WebElement ele) throws IOException {
		String parentWindow = testConfig.driver.getWindowHandle();
		Element.verifyElementPresent(ele, "How To Enroll ACH Form");
		String DocName = ele.getText();
		Element.click(ele, "How To Enroll ACH Form");

		Browser.switchToNewWindow(testConfig);
		Helper.compareContains(testConfig, DocName, "pdf", testConfig.getDriver().getCurrentUrl());
		String exPDFPath = System.getProperty("user.dir") + testConfig.getRunTimeProperty("PDFDocuments");
		switch (DocName) {

		case "How to enroll – ACH":
			exPDFPath = exPDFPath + "Howtoenroll_ACHuserguide.pdf";
			break;
		case "How to enroll – VCP":
			exPDFPath = exPDFPath + "HowToEnroll_VCPUserGuide.pdf";
			break;
		case "How to enroll – Billing service":
			exPDFPath = exPDFPath + "HowToEnroll_BillingServiceUserGuide.pdf";
			break;
		case "Alternative payment routing guide":
			exPDFPath = exPDFPath + "AlternativePaymentRouting-UserGuide.pdf";
			break;
		case "Updating payment method guide":
			exPDFPath = exPDFPath + "UpdatingPaymentMethod-UserGuide.pdf";
			break;
		case "Locating member payments guide":
			exPDFPath = exPDFPath + "LocatingAndDisablingMemberPayments-UserGuide.pdf";
			break;
		case "Cancellation Form":
			exPDFPath = exPDFPath + "CancellationForm.pdf";
			break;
		case "FAQs":
			exPDFPath = exPDFPath + "FAQs.pdf";
			break;

		}

		actualPDFContent = Helper.readPDF(TestBase.driver.getCurrentUrl());
		expectedPDFContent = Helper.readPDF(exPDFPath);

		Helper.compareEquals(testConfig, "The Cancellation Form PDF", expectedPDFContent, actualPDFContent);

		Browser.switchToParentWindow(testConfig, parentWindow);

	}

	public void verificationOfGuides() throws IOException {

		verifyHowToEnrollACHdocument(HowToEnrollACH);
		verifyHowToEnrollACHdocument(HowToEnrollVCP);
		verifyHowToEnrollACHdocument(HowToEnrollBillingService);
		verifyHowToEnrollACHdocument(AltPayRoutGuid);
		verifyHowToEnrollACHdocument(UpdtPayMetGuid);
		verifyHowToEnrollACHdocument(LocMemPayGuid);
		verifyHowToEnrollACHdocument(CancellationForm);
		verifyHowToEnrollACHdocument(FAQs);

	}

}