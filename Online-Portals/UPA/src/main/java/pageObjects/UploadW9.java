package main.java.pageObjects;

import java.util.Arrays;
import java.util.List;

import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadW9 {
	@FindBy(id="file")
	WebElement btnW9;
	
	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;
	
	private TestBase testConfig;
	EnrollmentInfo enrollmentInfoObj=EnrollmentInfo.getInstance();
	
	@FindBy(xpath = "//span[@class='progress-indicator__circle']")
	List<WebElement> OrgCircle;

	@FindBy(xpath = "//a[@class='progress-indicator__title']")
	List<WebElement> OrgInfoHeaders;
	
	@FindBy(xpath = "//div[@class='enrollment-container-footer float-left']/a")
	List<WebElement> OrgInfoFooters;
	
	//exit-modal-header__title float-left
	@FindBy(xpath="//h4[@class='exit-modal-header__title float-left']")
	WebElement CancHeaderTitle;
	
	@FindBy(xpath = "//div[@class='exit-modal-footer float-right text-right']/a")
	List<WebElement> PopupYesNo;
	
	@FindBy(partialLinkText="Federal W9 form here")
	WebElement fedW9Lnk;
	
	public UploadW9(TestBase testConfig) 
	{
		this.testConfig = testConfig;
		Browser.checkPageReadyState(testConfig.driver);
		PageFactory.initElements(testConfig.driver, this);
		
		//Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//form[@id='EFTERAregForm']/footer/a[2]"), 60);
		Element.expectedWait(fedW9Lnk, testConfig, "Fedral W9 Form Link", "FedW9Link");
		String expectedURL;
		
		if(enrollmentInfoObj.getTinIdentifier().equals("VO"))
			expectedURL = "/validateEFTERAProviderContact";
		else if(enrollmentInfoObj.getTinIdentifier().equals("AV"))
			expectedURL="/UploadW9EFTERAEnroll";
		else if(enrollmentInfoObj.getTinIdentifier().equals("AO"))
			expectedURL="/validateefterafinancialinfo";
		else
			expectedURL="/validateBillingServiceContacts";
		
		Browser.verifyURL(testConfig, expectedURL);
	}

	public ReviewAndSubmit uploadW9()  
	{   
		Element.enterData(btnW9,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "btnW9");
		Browser.wait(testConfig, 2);
		enrollmentInfoObj.setW9DocCode("W9");
		Browser.wait(testConfig, 3);
		Element.clickByJS(testConfig, btnContinue, "Clicked Continue");
		return new ReviewAndSubmit(testConfig);
	}
	

	public void verifyHeaders() {  

		List<String> headers = Arrays.asList("Billing Service Information","Identify Administrators","Upload W9","Review and Submit","Enrollment Submitted"); 
		for (int i = 0; i < (OrgInfoHeaders.size()); i++) 
		{ 
		 

		if (!(OrgInfoHeaders.get(i).getText().replace("\n", " ")) .equalsIgnoreCase("Upload W9") && headers.get(i) .equalsIgnoreCase( (OrgInfoHeaders.get(i).getText().replace( "\n", " "))))
		 {
			if ( (OrgInfoHeaders.get(i).getText().replace("\n", " ")) .equalsIgnoreCase("Review and Submit") && headers.get(i) .equalsIgnoreCase( (OrgInfoHeaders.get(i).getText().replace( "\n", " "))) || 
					(OrgInfoHeaders.get(i).getText().replace("\n", " ")) .equalsIgnoreCase("Enrollment Submitted") && headers.get(i) .equalsIgnoreCase( (OrgInfoHeaders.get(i).getText().replace( "\n", " "))) 
					)
			
				Helper.compareEquals( testConfig, "Color Value for " + (OrgInfoHeaders.get(i).getText().replace( "\n", " ")) + " Info is:", "#999999", Color.fromString( OrgInfoHeaders.get(i).getCssValue("color")) .asHex());  
			
				else
			
			Helper.compareEquals( testConfig, "Color Value for " + (OrgInfoHeaders.get(i).getText().replace( "\n", " ")) + " Info is:", "#e87722", Color.fromString( OrgInfoHeaders.get(i).getCssValue("color")) .asHex());  
			
			 Helper.compareEquals(testConfig, "font weight for " + (OrgInfoHeaders.get(i).getText().replace("\n", " ")) + " Info is:", "400", OrgInfoHeaders.get(i) .getCssValue("font-weight")); 
			 
		 } 
		
		 if ((OrgInfoHeaders.get(i).getText().replace("\n", " ")) .equalsIgnoreCase("Upload W9") && OrgCircle.get(i).isDisplayed() == true) 
		 {
		 Helper.compareEquals( testConfig, "Color Value for " + (OrgInfoHeaders.get(i).getText().replace( "\n", " ")) + " Info is:", "#e87722", Color.fromString( OrgInfoHeaders.get(i).getCssValue("color")) .asHex());  
		 Helper.compareEquals( testConfig, "Bold font with circle is present for " + (OrgInfoHeaders.get(i).getText().replace( "\n", " ")), "900", OrgInfoHeaders.get(i).getCssValue("font-weight")); 
		 } 
		 }
		 }
	
	public void verifyFootersContent() {
		List<String> footers = Arrays.asList("CONTINUE", "BACK","CANCEL ENROLLMENT");
		for (int i = 0; i < (OrgInfoFooters.size()); i++) 
		{
			Helper.compareEquals(testConfig, footers.get(i), OrgInfoFooters.get(i).getText(), footers.get(i));
			//if (OrgInfoFooters.get(i).getText().equals(footers.get(i)))
			//	Log.Pass(footers.get(i), footers.get(i), OrgInfoFooters.get(i).getText());

		}

	}

	public void verifyProvierAdmin() {
		Element.click(OrgInfoFooters.get(1), "Back Button");
		Browser.verifyURL(testConfig, "viewBillingServiceContacts.do");

	}
	
	public UploadW9 verifyClckCancEnroll() {
		Element.click(OrgInfoFooters.get(2), "Cancel Enrollment Button");
		Browser.wait(testConfig, 3);
		Helper.compareEquals(testConfig, "Cancel Popup Header", "Are you sure you want to cancel your Optum Pay enrollment application?", CancHeaderTitle.getText());
		Helper.compareEquals(testConfig, "Yes Button of Cancel Popup", "YES", PopupYesNo.get(0).getText());
		Helper.compareEquals(testConfig, "No Button of Cancel Popup", "NO", PopupYesNo.get(1).getText());
		
		return this;

	}
	
public UploadW9  verifyClckNo() {
		
		Browser.wait(testConfig, 3);
		Element.click(PopupYesNo.get(1), "No Button");
		Browser.verifyURL(testConfig, "validateBillingServiceContacts.do");
		return this;
		

	}
	
	
	public void verifyClckYes() {
		
		Element.click(OrgInfoFooters.get(2), "Cancel Enrollment Button");
		Browser.wait(testConfig, 3);
		
			Element.click(PopupYesNo.get(0), "Yes Button");
			Browser.verifyURL(testConfig, "returnToLoginPage.do");
		

	}
	
	
	public void verifyFederalW9link() {
		Element.click(fedW9Lnk, "Federal W9 Link");
		String expectedURL = "W9.pdf";
		Browser.switchToNewWindow(testConfig);
		Browser.verifyURL(testConfig, expectedURL);

	}
	
	public void clickBackButton() {
		
		if(enrollmentInfoObj.getTinIdentifier().equals("AO")) {
		Element.click(OrgInfoFooters.get(1), "Back Button");
		}
		Browser.verifyURL(testConfig, "backEFTERAFinancialInfoNPI.do");
	}
}
