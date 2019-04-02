package main.java.pageObjects;

import java.util.Arrays;
import java.util.List;

import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadW9 {
	@FindBy(id="file")
	WebElement btnW9;
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
	private TestBase testConfig;
	EnrollmentInfo enrollmentInfoObj=EnrollmentInfo.getInstance();
	
	@FindBy(xpath = "//span[@class='progress-indicator__circle']")
	List<WebElement> OrgCircle;

	@FindBy(xpath = "//a[@class='progress-indicator__title']")
	List<WebElement> OrgInfoHeaders;
	
	@FindBy(xpath = "//footer[@class='enrollment-container-footer float-left']/a")
	List<WebElement> OrgInfoFooters;
	
	@FindBy(xpath = "//div[@class='exit-modal-footer float-right text-right']/a")
	List<WebElement> PopupYesNo;
	
	@FindBy(partialLinkText="Federal W9 form here")
	WebElement fedW9Lnk;
	
	public UploadW9(TestBase testConfig) 
	{
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
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
			{
				Helper.compareEquals( testConfig, "Color Value for " + (OrgInfoHeaders.get(i).getText().replace( "\n", " ")) + " Info is:", "#999999", Color.fromString( OrgInfoHeaders.get(i).getCssValue("color")) .asHex());  
			}
				else
			{
			Helper.compareEquals( testConfig, "Color Value for " + (OrgInfoHeaders.get(i).getText().replace( "\n", " ")) + " Info is:", "#e87722", Color.fromString( OrgInfoHeaders.get(i).getCssValue("color")) .asHex());  
			}
			 
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
		for (int i = 0; i < (OrgInfoFooters.size()); i++) {
			if (OrgInfoFooters.get(i).getText().equals(footers.get(i)))
				Log.Pass(footers.get(i), footers.get(i), OrgInfoFooters.get(i).getText());

		}

	}

	public void verifyProvierAdmin() {
		OrgInfoFooters.get(1).click();
		Browser.verifyURL(testConfig, "viewBillingServiceContacts.do");

	}
	
	public void verifyClckCancEnroll() {
		List<String> YesNoList = Arrays.asList("YES", "NO");
		OrgInfoFooters.get(2).click();

		for (int i = 0; i < (PopupYesNo.size()); i++) {
			if (PopupYesNo.get(i).getText().equals(YesNoList.get(i))) {
				Log.Pass(YesNoList.get(i), YesNoList.get(i), PopupYesNo.get(i).getText());

				if (PopupYesNo.get(i).getText().equalsIgnoreCase("Yes")) {
					PopupYesNo.get(i).click();
					Browser.verifyURL(testConfig, "returnToLoginPage.do");
				}
				if (PopupYesNo.get(i).getText().equalsIgnoreCase("No")) {
					PopupYesNo.get(i).click();
					Browser.verifyURL(testConfig,"validateBillingServiceContacts.do");
				}

			}
		}

	}
	
	public void verifyClckYes() {
		OrgInfoFooters.get(2).click();

		if (PopupYesNo.get(0).getText().equalsIgnoreCase("Yes")) {
			Browser.wait(testConfig, 3);
			PopupYesNo.get(0).click();
			Browser.verifyURL(testConfig, "returnToLoginPage.do");
		}

	}
	
	public void verifyClckNo() {
		OrgInfoFooters.get(2).click();

		if (PopupYesNo.get(1).getText().equalsIgnoreCase("No")) {
			Browser.wait(testConfig, 3);
			PopupYesNo.get(1).click();
			Browser.verifyURL(testConfig, "validateBillingServiceContacts.do");
		}

	}
	
	public void verifyFederalW9link() {
		fedW9Lnk.click();
		String expectedURL = "W9.pdf";
		Browser.switchToNewWindow(testConfig);
		Browser.verifyURL(testConfig, expectedURL);

	}
}
