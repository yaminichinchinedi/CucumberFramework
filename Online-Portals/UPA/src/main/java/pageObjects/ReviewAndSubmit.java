package main.java.pageObjects;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import main.java.Utils.DataBase;
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

public class ReviewAndSubmit {
	@FindBy(xpath=".//*[@id='EFTERAenrBSForm']//div[4]/div[1]/label")
	WebElement chkAcceptance;
	
	@FindBy(id="acceptance")
	WebElement chkAccptance;
	
	@FindBy(name="btnSubmit")
	WebElement btnEnrllmnt;
	
	@FindBy(name="firstName")
	WebElement frstName;
	
	@FindBy(name="lastName")
	WebElement lstName;
	
	@FindBy(name="enrollerTitleFinPage")
	WebElement titleName;
	
	@FindBy(name="enrollerEmail")
	WebElement priEmlAdrs;
	
	@FindBy(name="enrollerRetypeEmail")
	WebElement retypEmlAdrs;
	
	@FindBy(name="enrollerTele1") 
	WebElement phField1;
	
	@FindBy(name="enrollerTele2") 
	WebElement phField2;
	
	@FindBy(name="enrollerTele3")
	WebElement phField3;
	

	@FindBy(xpath="//form[@id='EFTERAregForm']//div[2]/div[1]/a")
	WebElement btnEditOrg;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[2]/div[2]/dl[1]/dd")
	WebElement tinOrgInfo;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[2]/div[3]/dl[1]/dd")
	WebElement BSNameOrgInfo;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[2]/div[3]/dl[2]/dd")
	WebElement provTypOrgInfo;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[2]/div[4]/dl[1]/dd")
	WebElement BSAddOrgInfo;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[2]/div[4]/dl[2]/dd")
	WebElement mrktTypOrgInfo;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[3]/div[2]/dl[1]/dd")
	WebElement adminName;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[3]/div[3]/dl[1]/dd")
	WebElement adminNumber;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[3]/div[5]/dl[1]/dd")
	WebElement adminEmail;

	@FindBy(xpath = "//a[@class='button--primary-hover float-right margin-top-delta margin-top-delta margin-bottom-delta']")
    WebElement edtlnk;

	@FindBy(xpath="//form[@id='EFTERAregForm']//div[3]/div[1]/a")
	WebElement edtAdmInfo;

	@FindBy(xpath="//form[@id='EFTERAregForm']//div[4]/div[1]/a")
	WebElement edtFinInfo;

	@FindBy(xpath = ".//*[@id='EFTERAregForm']//section/fieldset/div[3]/div[1]/a")
    WebElement identifyedtlnk;
	
	@FindBy(xpath = ".//*[@id='EFTERAenrBSForm']//section/fieldset/div[3]/div[1]/a")
    WebElement identifyedtlnkBS;
	
	@FindBy(xpath = ".//*[@id='EFTERAregForm']//section/fieldset/div[4]/div[1]/a")
	WebElement finInfoEdit;
	
	@FindBy(xpath = "/html/body/section/main/form/section/fieldset/div[3]/div[2]/dl[1]/dd")
    WebElement primaryAdminName;
	
	@FindBy(xpath = "/html/body/section/main/form/section/fieldset/div[3]/div[3]/dl[1]/dd")
    WebElement telephoneNum;
	
	@FindBy(xpath = "/html/body/section/main/form/section/fieldset/div[3]/div[5]/dl[1]/dd")
    WebElement primaryEmailAddr;
	
	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List <WebElement> RSInfoHeaders;
	
	@FindBy(xpath = "//div[@class='float-right width-40 padding-left-beta padding-right-giga']/a")
	WebElement termsAndConditionsLink;

	@FindBy(xpath ="//a[@class='button--primary-hover float-right cancel-activation']")
	WebElement cancelEnrolment;
	
	@FindBy(name="btnBack")
	WebElement btnBack;
	
	@FindBy(xpath ="//div[@class='modal modal-cancel-activation']//div")
	WebElement divCancelEnrollment;
	
	
	@FindBy(xpath="//div[@class='modal modal-cancel-activation']//div//div[@class='exit-modal-header float-left']")
	WebElement txtCancelEnrollmentPopUp;
	
	@FindBy(xpath="//div[@class='modal modal-cancel-activation']//div//div[@class='exit-modal-content float-left']//p")
	List <WebElement> txtCancelEnrollmentPopUpExtend;
	
	@FindBy(xpath="//div[@class='modal modal-cancel-activation']//div//div[3]//a[@class='button--primary-hover pane-container__button pane-container__button-noborder']")
	WebElement btnYesOnCancelPopUp;
	
	@FindBy(xpath="//div[@class='modal modal-cancel-activation']//div//div[3]//a[@class='button--primary margin-left btn-close']")
	WebElement btnNoOnCancelPopUp;
	
	@FindBy(xpath="//div[@class='error']//ul//li")
	List <WebElement> individualErrors;
	
	@FindBy(xpath ="//div[@class='error']//h4")
	WebElement errorHeader;
	
	@FindBy(xpath ="//div[@id='authEnrlTel']//p")
	WebElement telphnErrorMsg;
	
	@FindBy(xpath=".//*[@id='EFTERAregForm']//section/fieldset/div[4]/div[2]/dl[2]/dd")
	WebElement finroutingNumber;
	
	@FindBy(xpath=".//*[@id='EFTERAregForm']//section/fieldset/div[4]/div[3]/dl[2]/dd")
	WebElement finAccountNumber;
	
	@FindBy(xpath=".//*[@id='EFTERAregForm']//section/fieldset/div[4]/div[3]/dl[1]/dd")
	WebElement finInstName;
	
	@FindBy(xpath="//a[@class='button--primary-hover float-right margin-top-delta margin-top-delta margin-bottom-delta']")
	List <WebElement> edtlnks;
	
	private TestBase testConfig;
	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	
	String fName=Helper.generateRandomAlphabetsString(5);
	String lName=Helper.generateRandomAlphabetsString(5);
	String title=Helper.generateRandomAlphabetsString(5);
	String firstProvEmailAdr=Helper.getUniqueEmailId();
	String phNo = Long.toString(Helper.generateRandomNumber(3));
	String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
	
	public ReviewAndSubmit(TestBase testConfig) 
	{
		String expectedURL = "/validateEFTERAUploadW9";
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedURL="/validateBSSubmitInfo";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
//		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public EnrollmentSubmitted fillInfoAndClickSubmit() throws IOException
	{
		//Element.expectedWait(chkAccptance, testConfig, "Accept terms and condition", "Check Acceptance");
		Element.clickByJS(testConfig,chkAccptance, "Accept terms and condition");
		fillAuthorizedEnrollersInfo();
		Element.clickByJS(testConfig,btnEnrllmnt, "Submit Enrollment");
		return new EnrollmentSubmitted(testConfig);
	}
	
	public  ReviewAndSubmit fillAuthorizedEnrollersInfo()
	{	
		Element.enterData(frstName, fName,"Enter First name as : "+fName,"First Name");
		Element.enterData(lstName, lName,"Enter Last nam as : "+lName,"Last Name");
		if(!enrollmentInfoPageObj.getEnrollType().equals("BS"))
		{
			Element.enterData(titleName, title,"Enter Title as : "+title,"Title");
			enrollmentInfoPageObj.setAuthTitle(title);
		}
		Element.enterData(priEmlAdrs, firstProvEmailAdr, "Enter email address as : " +firstProvEmailAdr,"firstProvEmail");
		Element.enterData(retypEmlAdrs, firstProvEmailAdr, "Retype email address as : " +firstProvEmailAdr,"verifyFirstProvEmail");
		Element.enterData(phField1, phNo,"Entered first three digits of phone number as :" + phNo ,"firstProvPhField1");
		Element.enterData(phField2, phNo,"Entered second three digits of phone number as :" + phNo,"firstProvPhField2");
		Element.enterData(phField3, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"firstProvPhField3");
		enrollmentInfoPageObj.setAuthFrstName(fName);
		enrollmentInfoPageObj.setAuthLstName(lName);
		enrollmentInfoPageObj.setAuthEmail(firstProvEmailAdr);
		testConfig.putRunTimeProperty("Auth_Email", firstProvEmailAdr);
		enrollmentInfoPageObj.setAuthPhnNbr(phNo+phNo+phNoLstField);
		return this;
	}
	

	public ProviderInformationEFTERAEnroll clickEditOrgButton()
	{
		Element.verifyElementPresent(btnEditOrg, "Edit Organization Button");
		Element.click(btnEditOrg,"Organisation Edit Button");
		return new ProviderInformationEFTERAEnroll(testConfig);
	}
	
	public ReviewAndSubmit verifyOrgInfo()
	{
		Helper.compareEquals(testConfig, "Organisation Name", enrollmentInfoPageObj.getBusinessName(),BSNameOrgInfo.getText());
		Helper.compareEquals(testConfig, "Org Address", enrollmentInfoPageObj.getStreet()+"\n"+enrollmentInfoPageObj.getCity()+", "+enrollmentInfoPageObj.getStateName()+"\n"+enrollmentInfoPageObj.getZipCode(),BSAddOrgInfo.getText());
		Helper.compareEquals(testConfig, "Tin",enrollmentInfoPageObj.getTin() ,tinOrgInfo.getText());
		Helper.compareEquals(testConfig, "Provider Type",enrollmentInfoPageObj.getProvType() ,provTypOrgInfo.getText());
		Helper.compareEquals(testConfig, "Market Type",enrollmentInfoPageObj.getMrktType() ,mrktTypOrgInfo.getText());
		
		return this;
	}

	public ProviderInformationEFTERAEnroll clickEditLink()
	{
		Element.click(edtlnk, "Edit Hyperlink");
		String expectedURL="billingServiceInformationBSEnroll";
		Browser.verifyURL(testConfig, expectedURL);
		
		return new ProviderInformationEFTERAEnroll(testConfig).verifyEditable();
	}
	public void clickIdentifyEditLink()
	{
		Element.click(identifyedtlnkBS, "Edit Hyperlink");
		String expectedURL="viewBillingServiceContacts.do?fromReview=Y&BSAdminedit=N";
		Browser.verifyURL(testConfig, expectedURL);
		
		//return this;
	//	return new ValidateEFTERAProviderInfo(testConfig).verifyEditable();
	}
	
	public void verifySavedChangesIdentifyAdmin() {
		
		Helper.compareEquals(testConfig, "First Name",enrollmentInfoPageObj.getFrstName()+" "+enrollmentInfoPageObj.getLstName(),primaryAdminName.getText());
		Helper.compareEquals(testConfig, "First Name",enrollmentInfoPageObj.getPhnNumbr(),telephoneNum.getText().replace("-", "")); 
		Helper.compareEquals(testConfig, "First Name",enrollmentInfoPageObj.getEmail(),primaryEmailAddr.getText());
	}
	
	public ValidateEFTERAProviderInfo clickEditAdminInfo()
	{
		Element.verifyElementPresent(btnEditOrg, "Edit Organization Information");
		Element.verifyElementPresent(edtAdmInfo, "Edit Administrator Information");
		Element.verifyElementPresent(edtAdmInfo, "Edit Financial Information");
		Element.click(edtAdmInfo, "Edit Admin Information");
		return new ValidateEFTERAProviderInfo(testConfig);
	}
	
	public ReviewAndSubmit verifyAdminInfo()
	{
		Helper.compareEquals(testConfig, "Primary Contact First Name", enrollmentInfoPageObj.getFrstName()+" "+enrollmentInfoPageObj.getLstName(),adminName.getText());
		Helper.compareEquals(testConfig, "Primary Contact Email",enrollmentInfoPageObj.getEmail(),adminEmail.getText());
		Helper.compareEquals(testConfig, "Primary Contact Phone Number",enrollmentInfoPageObj.getPhnNumbr(),adminNumber.getText().replace("-", ""));
		
		return this;
	}

	public void verifyCancelChangesIdentifyAdminEdit() {
		
		String expectedURL="cancelBSReviewSubmit.do";
		Browser.verifyURL(testConfig, expectedURL);
		verifySavedChangesIdentifyAdmin();
	}
	
	  public ReviewAndSubmit verifyEditLinks() {
		 
		  if(enrollmentInfoPageObj.getEnrollType().equals("BS")) {
				 
			  Element.verifyElementPresent(identifyedtlnkBS,"EDIT");
			  Element.verifyElementPresent(edtlnk,"EDIT");
		  }
		  else if(enrollmentInfoPageObj.getEnrollType().equals("HO")) {
			 
			  Element.verifyElementPresent(identifyedtlnk,"EDIT");
			  Element.verifyElementPresent(edtlnk,"EDIT");
		  }else {
			 
			  Element.verifyElementPresent(edtlnk,"EDIT");
			  Element.verifyElementPresent(identifyedtlnk,"EDIT");
			  Element.verifyElementPresent(finInfoEdit,"EDIT");
		  }
		  return this;
	  }
	  
	  public ReviewAndSubmit verifyTermConditionPdfDownl() {
		  
		  Element.verifyElementPresent(termsAndConditionsLink, "Download Terms and Conditions");
		  Element.click(termsAndConditionsLink, "Download Terms and Conditions");
		  if(enrollmentInfoPageObj.getEnrollType().equals("BS")) 
			  Browser.switchToNewWindow(testConfig, "Optum_EPS_BillingService_Terms_Conditions.pdf");  
	      else
		  Browser.switchToNewWindow(testConfig, "Optum_EPS_Terms_Conditions.pdf");
		  return this;
		  
	  }
	  
	  public ReviewAndSubmit verifySubmitEnrollButton() {
		  
		  Element.clickByJS(testConfig,chkAccptance, "Accept terms and condition");
		  
		  if(!btnEnrllmnt.isEnabled())
			  Log.Comment("Submit Enroll Button is disabled..");
			  else
				Log.Comment("Submit Enroll Button is enabled..");
		  return this;
		  
	  }
	  
	  public ReviewAndSubmit verifyReviewSubmitPageButtons() {
		  
		  Element.verifyElementPresent(cancelEnrolment,"CANCEL ENROLLMENT");
		  Element.verifyElementPresent(btnBack,"Back Button");
		  Element.verifyElementPresent(btnEnrllmnt,"Submit Enrollment");
		  return this;
	  }
	  
	  public void validateBackButton() {

		  Element.clickByJS(testConfig,btnBack, "Back button");
		  if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			  Browser.verifyURL(testConfig, "submissionInformationBSEnroll.do");
		  else
			  Browser.verifyURL(testConfig, "UploadW9EFTERAEnroll");
		  
	  }
	  
	  public ReviewAndSubmit verifyCancelEnrollmentFlow() throws IOException{
		  
		  int sqlRowNo=174;
		  HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);

		  //  String expectedText="Are you sure you want to cancel your Optum Pay enrollment application?If you select 'Yes', your Optum Pay enrollment will not be completed and no information will be saved.Select 'No' to return to the Optum Pay enrollment process.";
		  clickCancelEnrollment();
		  Element.verifyElementPresent(divCancelEnrollment, "Cancel Enrollment Pop up");
		  //Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up text", expectedText,((txtCancelEnrollmentPopUp.getText() + txtCancelEnrollmentPopUpExtend.get(0).getText() + txtCancelEnrollmentPopUpExtend.get(1).getText()).replace("\n","")));
		  Helper.compareEquals(testConfig, "Billing Service Name", txtCancelEnrollmentPopUp.getText(), dataTest.get(13).get("TEXT_VAL"));
		  Helper.compareEquals(testConfig, "Billing Service Name", txtCancelEnrollmentPopUpExtend.get(0).getText(), dataTest.get(14).get("TEXT_VAL"));
		  Helper.compareEquals(testConfig, "Billing Service Name", txtCancelEnrollmentPopUpExtend.get(1).getText(), dataTest.get(15).get("TEXT_VAL"));
		  clickNoOnCancelEnrollment().clickCancelEnrollment().clickYesOnCancelEnrollment();
		  return this;
	  }
	  
	  public ReviewAndSubmit clickCancelEnrollment()
	  {
		  Element.click(cancelEnrolment, "Cancel Enrollment");	
		  return this;
	  }

	  public UPARegistrationPage clickYesOnCancelEnrollment()
	  {
		  Element.click(btnYesOnCancelPopUp, "Yes button on cancel Enrollment Pop up");	
		  return new UPARegistrationPage(testConfig);
	  }

	  public ReviewAndSubmit clickNoOnCancelEnrollment()
	  {
		  Element.click(btnNoOnCancelPopUp, "No button on cancel Enrollment Pop up");	
		  return this;
	  }

	  public void verifyErrorMsgNull()
	  {
		  Element.clickByJS(testConfig,chkAccptance, "Accept terms and condition");
		  Element.click(btnEnrllmnt, "Submit Enrollment");
		  List <String> expectedErrorMsgs;
		  Element.verifyTextPresent(errorHeader, "Please correct the following fields before continuing the enrollment process:");
		  if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
		  expectedErrorMsgs=Arrays.asList("- Review and Submit - Authorized Enroller First Name","- Review and Submit - Authorized Enroller Last Name","- Review and Submit - Authorized Enroller Telephone Number","- Review and Submit - Authorized Enroller Email Address","- Review and Submit - Authorized Enroller Re-type Email Address");
		  else
			  expectedErrorMsgs=Arrays.asList("- Review and Submit - Authorized Enroller First Name","- Review and Submit - Authorized Enroller Last Name","- Review and Submit - Authorized Enroller Title","- Review and Submit - Authorized Enroller Telephone Number","- Review and Submit - Authorized Enroller Email Address","- Review and Submit - Authorized Enroller Re-type Email Address");
		  for(int i=0;i<expectedErrorMsgs.size();i++)
		  {
			  Element.verifyTextPresent(individualErrors.get(i), expectedErrorMsgs.get(i));
		  }

		  verifyMissingDataErrorMsg();
		  
		  for (int i= 1; i <= individualErrors.size(); i++) {

				WebElement links = Element.findElement(testConfig,"xpath","//div[@class='error']//ul//li["+i+"]//a");
				String expectedURL=links.getAttribute("href");
				Element.click(links,links.getText());
				Browser.verifyURL(testConfig, expectedURL);
			}

	  }
	  public void verifyMissingDataErrorMsg()
	  {
		  String expectedText="Missing Data";
		  String expectedColor="#c21926";

		  Log.Comment("Verifying Error Msg is displayed for First Name..");
		  Element.verifyTextPresent(frstName.findElement(By.xpath("../following-sibling::p")), expectedText);
		  Helper.compareEquals(testConfig, "Verify Red color is highlighted in First name box" , expectedColor, Color.fromString(frstName.getCssValue("border-top-color")).asHex());

		  Log.Comment("Verifying Error Msg is displayed for Last Name..");
		  Element.verifyTextPresent(lstName.findElement(By.xpath("../following-sibling::p")), expectedText);
		  Helper.compareEquals(testConfig, "Verify Red color is highlighted in Last name box" , expectedColor, Color.fromString(lstName.getCssValue("border-top-color")).asHex());

		  if(enrollmentInfoPageObj.getEnrollType().equals("BS")) {
			  
			  Log.Comment("Verifying Error Msg is displayed for  Phone Number filed1 ..");
			  Element.verifyTextPresent(Element.findElement(testConfig, "xpath", ".//*[@id='EFTERAenrBSForm']/section/fieldset/div[5]/fieldset/div[3]/div/div/p"),expectedText);
			  Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 1 box" , expectedColor, Color.fromString(phField1.getCssValue("border-top-color")).asHex());

		  }else {
			  
			  Log.Comment("Verifying Error Msg is displayed for  Phone Number filed1 ..");
			  Element.verifyTextPresent(Element.findElement(testConfig, "xpath", ".//*[@id='EFTERAregForm']/section/fieldset/div[6]/fieldset/div[2]/div[2]/p"),expectedText);
			  Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 1 box" , expectedColor, Color.fromString(phField1.getCssValue("border-top-color")).asHex());
		  }
		  
		  Log.Comment("Verifying Error Msg is displayed for Phone Number filed2..");
		  Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 2 box" , expectedColor, Color.fromString(phField2.getCssValue("border-top-color")).asHex());

		  Log.Comment("Verifying Error Msg is displayed for Phone Number filed3..");
		  Helper.compareEquals(testConfig, "Verify Red color is highlighted in Ph filed 3 box" , expectedColor, Color.fromString(phField3.getCssValue("border-top-color")).asHex());

		  Log.Comment("Verifying Error Msg is displayed for Email Address ..");
		  Element.verifyTextPresent(priEmlAdrs.findElement(By.xpath("../following-sibling::p")), expectedText);
		  Helper.compareEquals(testConfig, "Verify Red color is highlighted in Email text box" , expectedColor, Color.fromString(priEmlAdrs.getCssValue("border-top-color")).asHex());

		  Log.Comment("Verifying Error Msg is displayed for  Retype Email Address ..");
		  Element.verifyTextPresent(retypEmlAdrs.findElement(By.xpath("../following-sibling::p")), expectedText);
		  Helper.compareEquals(testConfig, "Verify Red color is highlighted in Retype Email text box" , expectedColor, Color.fromString(retypEmlAdrs.getCssValue("border-top-color")).asHex());

	  }
	  
	  public ReviewAndSubmit VerifyEmailInvalidDataError(String inputFormat,String inputType) {

		  String ProvEmailAdr=null;
		  if (inputFormat.equals("inpFormatOne")){
			  ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "");
		  }
		  if (inputFormat.equals("inpFormatTwo")){
			  ProvEmailAdr=Helper.getUniqueEmailId().replaceAll("@abc.com", "abc.com");
		  }

		  Element.clickByJS(testConfig,chkAccptance, "Accept terms and condition");

		  if(inputType.equals("Email")) {
			  Element.enterData(priEmlAdrs, ProvEmailAdr, "Enter  email address "+ProvEmailAdr,"ProvEmail");
			  Element.click(btnEnrllmnt, "Submit Enrollment");
			  String emailAdr=priEmlAdrs.findElement(By.xpath("../following-sibling::p")).getText();
			  Helper.compareEquals(testConfig, "Email Id Comparison", emailAdr, "Invalid Data");
		  }else if(inputType.equals("RetypeEmail")) {

			  Element.enterData(retypEmlAdrs, ProvEmailAdr, "Enter Retype email address of "+ProvEmailAdr,"ProvEmail");
			  Element.click(btnEnrllmnt, "Submit Enrollment");
			  String retypeemailAdr=retypEmlAdrs.findElement(By.xpath("../following-sibling::p")).getText();
			  Helper.compareEquals(testConfig, "Retype Email Id Comparison", retypeemailAdr, "Invalid Data");
		  }


		  return this;

	  }
	  public void VerifyInvalidDataError() {

		  String data="$#12";
		  String Telno;
		  phNo=Helper.generateRandomAlphaNumericString(3);
		  phNoLstField=Helper.generateRandomAlphaNumericString(4);
		  Element.enterData(phField1, phNo,"Entered first three digits of phone number as :" + phNo ,"phField1");
		  Element.enterData(phField2, phNo,"Entered second three digits of phone number as :" + phNo,"phField2");
		  Element.enterData(phField3, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"phField3");
		  Element.enterData(frstName, data,"Enter First name as: "+ data,"FirstName");
		  Element.enterData(lstName, data,"Enter First name as: "+ data,"FirstName");

		  Element.clickByJS(testConfig,chkAccptance, "Accept terms and condition");
		  Element.click(btnEnrllmnt, "Submit Enrollment");

		  if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
		  Telno=Element.findElement(testConfig, "xpath", ".//*[@id='EFTERAenrBSForm']/section/fieldset/div[5]/fieldset/div[3]/div/div/p").getText();
		  else
		  Telno=Element.findElement(testConfig, "xpath", ".//*[@id='EFTERAregForm']/section/fieldset/div[6]/fieldset/div[2]/div[2]/p").getText();
		  Helper.compareEquals(testConfig, "phone no comparision", Telno, "Invalid Data");

		  WebElement firstName=frstName.findElement(By.xpath("../following-sibling::p"));
		  Helper.compareEquals(testConfig, "phone no comparision", firstName.getText(), "Invalid Data");

		  WebElement lastName=lstName.findElement(By.xpath("../following-sibling::p"));
		  Helper.compareEquals(testConfig, "phone no comparision", lastName.getText(), "Invalid Data");

	  }
	  
	  public void clickFinancialInfoEditLink()
		{
			
		  Browser.wait(testConfig, 3);
			Element.click(finInfoEdit, "Edit Hyperlink");
			String expectedURL="financialInformationEFTERAEnroll.do?fromReview=Y";
			Browser.verifyURL(testConfig, expectedURL);
			
		}
	  
	  public void verifyCancelChangesFinancialInfoEdit() {
			
			String expectedURL="cancelReviewSubmit.do";
			Browser.verifyURL(testConfig, expectedURL);
			verifySavedChangesFinInsInfo();
		}
	  
	  public void verifySavedChangesFinInsInfo() {
			
			Helper.compareEquals(testConfig, "Routing Number",enrollmentInfoPageObj.getFinRoutingNo(),finroutingNumber.getText());
			Helper.compareEquals(testConfig, "Account Number",enrollmentInfoPageObj.getFinAcntNo(),finAccountNumber.getText()); 
			Helper.compareEquals(testConfig, "Institution Name",enrollmentInfoPageObj.getFinInstName(),finInstName.getText());
		}
	public void verifyEditHyperLinks()
	{
	Browser.wait(testConfig, 3);	
	Element.verifyElementPresent(edtlnks.get(0),"Org Info EDIT");
	Element.verifyElementPresent(edtlnks.get(1),"Identify Admin EDIT");
	Element.verifyElementPresent(edtlnks.get(2),"Tin Information EDIT");
	Element.verifyElementPresent(edtlnks.get(3),"NPI FII EDIT");
	Element.verifyElementPresent(edtlnks.get(4),"NPI FII REMOVE");
	}
	
	public void clickEditNPI()
	{
		Element.click(edtlnks.get(3), "NPI FII Edit Link");
	}
	public void  clickRemoveNPI(){
		Element.click(edtlnks.get(4), "NPI FII Remove Link");
		List<WebElement>Uploaded=Element.findElements(testConfig, "linkText", "Uploaded Voided Check");
		if(edtlnks.size()==3 || Uploaded.size()==1)
		{
			Log.Pass("Finantial Institute Info-NPI Details deleted and Uploaded Voided Check of NPI is not present.");
		}
		else
		{
			Log.Fail("Finantial Institute Info-NPI Details not deleted.");
		}
	}
	
	public void verifyUpldDoc(String verifyDocLocation){
		
		String pdfData=System.getProperty("user.dir")+testConfig.getRunTimeProperty("AnotherPdfPath");
		String pdfDataonPage="";
		if (verifyDocLocation == "FIINPI")
		 pdfDataonPage=Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/section/fieldset/div[5]/div[4]/dl[2]/dd/a").getText();
		
		else if (verifyDocLocation == "FII")
			 pdfDataonPage=Element.findElement(testConfig, "xpath", "//*[@id='EFTERAregForm']/section/fieldset/div[4]/div[4]/dl[2]/dd/a").getText();
				
		if (pdfData.contains(pdfDataonPage))
		{
			Log.Pass("pdf uploaded and is on Review and submit Page");
		}
		else
		{
			Log.Fail("Uploaded doc is not on Review and Submit Page");
		}
		
	}
	public void verifyFIINPICOntent()
	{
		String fIIName=Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section/fieldset/div[5]/div[3]/dl[1]/dd").getText();
		String nPINo=Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']/section/fieldset/div[5]/div[2]/dl[1]/dd").getText();
		
		Helper.compareContains(testConfig, "FII-NPI Name", enrollmentInfoPageObj.getFinInstName(), fIIName);
		Helper.compareContains(testConfig, "FII-NPI NPI No", enrollmentInfoPageObj.getNpi(), nPINo);

	}
	
}
