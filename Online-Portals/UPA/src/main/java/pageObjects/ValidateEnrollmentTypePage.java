package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;

public class ValidateEnrollmentTypePage {
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
	@FindBy(xpath="//*[@id='EFTERAenrForm']/section/main/h4/strong")
	WebElement enrolledTIN;

	@FindBy(xpath="//*[@id='EFTERAenrForm']/section/main/ul/li[1]/span")
	WebElement tin;

	@FindBy(xpath="//*[@id='EFTERAenrForm']/section/main/ul/li[2]/span")
	WebElement name;

	@FindBy(xpath="//*[@id='EFTERAenrForm']/section/main/ul/li[3]/span")
	WebElement address;

	@FindBy(xpath="//*[@id='EFTERAenrForm']/section/main/ul/li[4]/span")
	WebElement status;
	
	@FindBy(xpath="/html/body/form/section/main/h4/strong")
	WebElement preEnrolledStatus;
	
	@FindBy(xpath="//html/body/form/section/main/p[3]/a")
	WebElement homePageLink;
	
	@FindBy(xpath="//html/body/form/section/main/footer/a")
	WebElement loginBtn;
	
	@FindBy(xpath="//html/body/form/section/main/h4/strong")
	WebElement inActiveStatus;
	
	@FindBy(xpath="html/body/form/section/main/p[2]")
	WebElement inActiveStatusMsgUI;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']/section/main/h4/strong")
	WebElement TINEligibleForEnrlHeading;	
	
	@FindBy(xpath="/html/body/form/section/main/div[2]/ul/li/ul/li[1]")
	WebElement tinAndBusinessInfo;
	
	@FindBy(xpath="//a[contains(text(),'this link')]")
	WebElement w9FormLink;
	
	@FindBy(xpath="//a[contains(text(),'Cancel Enrollment')]")
	WebElement btnCancel;
	
	@FindBy(css= ".exit-modal-header__title.float-left")
	WebElement btnCancelPopUp;
	
	@FindBy(xpath= ".//*[@id='welcomeDiv']/div[1]/div[3]/a[1]")
	WebElement btnYes;
	
	@FindBy(xpath=".//*[@id='welcomeDiv']/div[1]/div[3]/a[2]")
	WebElement btnNo;
	
	@FindBy(xpath="/html/body/form/section/main/p[2]")
	WebElement enrollmentProcessInfo;
	
	@FindBy(xpath="/html/body/form/section/main/div[1]/ul/li[1]")
	WebElement orgName;
	
	@FindBy(xpath="/html/body/form/section/main/div[1]/ul/li[2]/ul/li[1]")
	WebElement administrators;
	
	@FindBy(xpath="/html/body/form/section/main/div[1]/ul/li[2]/ul/li[2]")
	WebElement primaryContact;
	
	@FindBy(xpath="/html/body/form/section/main/div[1]/ul/li[2]/ul/li[3]")
	WebElement secondaryContact;
	
	@FindBy(xpath="/html/body/form/section/main/div[1]/ul/li[3]")
	WebElement bankingInfo;
	
	@FindBy(xpath="/html/body/form/section/main/div[2]/ul/li[2]/ul/li[2]")
	WebElement w9Form;

	@FindBy(xpath="/html/body/form/section/main/div[2]/ul/li[2]/ul/li[3]")
	WebElement w9FormDownload;
	
	@FindBy(xpath="/html/body/section[1]/fieldset/section[4]/ul[1]/li[4]/a")
	WebElement EnrollmentTINEligibleVCPUXDS;
	
	@FindBy(xpath="/html/body/section/main/h4/strong")
	WebElement TINEligibleForEnrlHeadingUXDS;
	
	@FindBy(xpath="/html/body/section/main/p[2]")
	WebElement enrollmentProcessInfoUXDS;
	
	@FindBy(xpath="/html/body/section/main/div[1]/ul/li[1]")
	WebElement orgNameUXDS;
	
	@FindBy(xpath="/html/body/section/main/div[1]/ul/li[2]/ul/li[1]")
	WebElement administratorsUXDS;
	
	@FindBy(xpath="/html/body/section/main/div[1]/ul/li[2]/ul/li[2]")
	WebElement primaryContactUXDS;
	
	@FindBy(xpath="/html/body/section/main/div[1]/ul/li[2]/ul/li[3]")
	WebElement secondaryContactUXDS;
	
	@FindBy(xpath="/html/body/section/main/div[2]/ul/li/ul/li[1]")
	WebElement tinAndBusinessInfoUXDS;
	
	@FindBy(xpath="/html/body/section/main/div[2]/ul/li/ul/li[2]")
	WebElement w9FormUXDS;
	
	@FindBy(xpath="/html/body/section/main/div[2]/ul/li/ul/li[3]")
	WebElement w9FormDownloadUXDS;
	
	@FindBy(xpath="/html/body/section[1]/h1")
	WebElement uxdsPageHeading;
	
	ViewPaymentsDataProvider dataProvider;

	private TestBase testConfig;
	EnrollmentInfo enrollmnt=EnrollmentInfo.getInstance();
	
	public ValidateEnrollmentTypePage(TestBase testConfig)
	{   
		String expectedURL="/validateEnrollmentType.do";
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		if(enrollmnt.getEnrollType().equals("BS"))
			expectedURL="/validateBillingServiceEnrollmentType.do";
		Browser.verifyURL(testConfig, expectedURL); 
	}
	
	public ProviderEFTERAEnrollPage clickContinue()
	{
		Element.clickByJS(testConfig, btnContinue, "Continue on validate enrollment type page");
		return new ProviderEFTERAEnrollPage(testConfig) ;
	}

	public ValidateEnrollmentTypePage clickCancel()
	{
		Element.click(btnCancel, "Cancel Enrollment");
		Browser.wait(testConfig, 2);
		return this;
	}
	
	public ValidateEnrollmentTypePage confirmCancelNo()
	{
		Element.click(btnNo, "Confirm Cancel No");
		Browser.wait(testConfig, 2);
		return this;
	}
	
	public UPARegistrationPage confirmCancelYes()
	{
		Element.click(btnYes, "Confirm Cancel Yes");
		Browser.wait(testConfig, 2);
		return new UPARegistrationPage(testConfig);
	}

	public ValidateEnrollmentTypePage verifyEnrolledActiveStatusTIN() throws IOException
	{
		String enrolledTINMsg =  "Your TIN is already enrolled.";
		Element.verifyTextPresent(enrolledTIN,enrolledTINMsg);
		Element.verifyElementPresent(tin,"TIN");
		Element.verifyElementPresent(name,"Name");
		Element.verifyElementPresent(address,"Address");
		Element.verifyElementPresent(status,"Status");
		return this;
	}
	
	public ValidateEnrollmentTypePage verifyEnrolledPreEnrollmentStatusTIN() throws IOException
	{
		String enrolledTINMsg =  "Your TIN is pending enrollment status.";
		Element.verifyTextPresent(preEnrolledStatus,enrolledTINMsg);
		Element.verifyElementPresent(homePageLink,"Home Page Link");
		Element.verifyElementPresent(loginBtn,"Return to Login Button");		
		return this;
	}
	
	public ValidateEnrollmentTypePage verifyAutoEnrolledPreEnrollmentStatusTIN() throws IOException
	{
		String enrolledTINMsg =  "Your TIN is pending enrollment status.";
		Element.verifyTextPresent(preEnrolledStatus,enrolledTINMsg);
		Element.verifyElementPresent(loginBtn,"Return to Login Button");
		return this;
	}
	
	public ValidateEnrollmentTypePage verifyEnrolledInactiveAndBlockStatusTIN() throws IOException
	{
		String inActiveTIN =  "Your TIN cannot be enrolled at this time.";
		String inActiveTINMsg = "The TIN you entered is currently in an inactive status and cannot be enrolled in Electronic Payments and Statements at this time.";
		Element.verifyTextPresent(inActiveStatus,inActiveTIN);
		Element.verifyTextPresent(inActiveStatusMsgUI,inActiveTINMsg);
		Element.verifyElementPresent(loginBtn,"Return to Login Button");
		return this;
	}
	
	public ValidateEnrollmentTypePage verifyTINStatus() throws IOException
	{
		String TINEligibleForEnrlExpectedMsg =  "Congratulations, your TIN is eligible for enrollment!";
		Element.verifyTextPresent(TINEligibleForEnrlHeading,TINEligibleForEnrlExpectedMsg);		
		return this;
	} 
	
	public ValidateEnrollmentTypePage verifyW9Form() throws IOException
	{
		Element.click(w9FormLink, "W9 Form Link");
		return this;
	} 
	
	public ValidateEnrollmentTypePage verifyCancelAndContinueBtn() throws IOException
	{
		Element.verifyElementPresent(btnCancel,"Cancel Enrollment");
		Element.verifyElementPresent(btnContinue,"Continue Enrollment");
		return this;
	} 
	
	public ValidateEnrollmentTypePage verifyBtnCancelPopup() throws IOException
	{
		String btnCancelPopupMsg =  "Are you sure you want to cancel your EPS enrollment application?";
		Element.verifyTextPresent(btnCancelPopUp, btnCancelPopupMsg);
		Element.verifyElementPresent(btnYes,"Cancel Button Yes");
		Element.verifyElementPresent(btnNo,"Cancel Button No");
		return this;
	} 
	
	public ValidateEnrollmentTypePage verifyContentManaged() throws IOException
	{
		ArrayList<String> listDB = new ArrayList<String>();
		ArrayList<String> listUI = new ArrayList<String>();
		String content = "EligibleTIN";
		dataProvider=new ViewPaymentsDataProvider(testConfig);	
		listDB =  dataProvider.getEnrollmentContent(content);		
		listUI.add(TINEligibleForEnrlHeading.getText());
		listUI.add(enrollmentProcessInfo.getText());
		listUI.add(orgName.getText());
		listUI.add(administrators.getText());
		listUI.add(primaryContact.getText());
		listUI.add(secondaryContact.getText());
		listUI.add(bankingInfo.getText());
		listUI.add(w9Form.getText()+".");

		for (String contentUI : listUI) {
			if (listDB.contains(contentUI)) {
				Log.Pass(contentUI + " :" + " " + "matches in both UI and DB");
			}
			else {
				Log.Fail(contentUI + " :" + " " + "not present in DB");				
			}
		}	
		
		return this;
	} 
	
	public void UXDSPage(TestBase testConfig) 
	{
		this.testConfig=testConfig;		
		testConfig.driver.navigate().to("http://webrd1220.uhc.com/eps-2018/approved/");
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForLoad(testConfig.driver);
		Element.expectedWait(uxdsPageHeading, testConfig, "Pages",  "Pages");
	}
	
	public ValidateEnrollmentTypePage verifyContentWithUXDS() throws IOException
	{

		ArrayList<String> listUI = new ArrayList<String>();
		ArrayList<String> listUXDS = new ArrayList<String>();
		
		listUI.add(TINEligibleForEnrlHeading.getText());
		listUI.add(enrollmentProcessInfo.getText());
		listUI.add(orgName.getText());
		listUI.add(administrators.getText());
		listUI.add(primaryContact.getText());
		listUI.add(secondaryContact.getText());
		listUI.add(tinAndBusinessInfo.getText());
		listUI.add(w9Form.getText()+".");
		listUI.add(w9FormDownload.getText());
		
		UXDSPage(testConfig);
		Element.click(EnrollmentTINEligibleVCPUXDS, "Enrollment TIN Eligible HO VCP only");
		Browser.wait(testConfig, 10);
		
		listUXDS.add(TINEligibleForEnrlHeadingUXDS.getText());
		listUXDS.add(enrollmentProcessInfoUXDS.getText());
		listUXDS.add(orgNameUXDS.getText());
		listUXDS.add(administratorsUXDS.getText());
		listUXDS.add(primaryContactUXDS.getText());
		listUXDS.add(secondaryContactUXDS.getText());
		listUXDS.add(tinAndBusinessInfoUXDS.getText());
		listUXDS.add(w9FormUXDS.getText());
		listUXDS.add(w9FormDownloadUXDS.getText());
		
		for (String contentUI : listUI) {
			if (listUXDS.contains(contentUI)) {
				Log.Pass(contentUI + " :" + " " + "matches in both UI and DB");
			}
			else {
				Log.Fail(contentUI + " :" + " " + "not present in DB");				
			}
		}
		
		return this;
	}
	
	

}
