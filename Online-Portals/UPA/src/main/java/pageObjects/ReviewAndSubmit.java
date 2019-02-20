package main.java.pageObjects;

import java.io.IOException;

import main.java.Utils.Helper;
import main.java.api.pojo.epsEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
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
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public ReviewAndSubmit() {
		// TODO Auto-generated constructor stub
	}

	public EnrollmentSubmitted fillInfoAndClickSubmit() throws IOException
	{
		Element.clickByJS(testConfig,chkAccptance, "Accept terms and condition");
		fillAuthorizedEnrollersInfo();
		Element.clickByJS(testConfig,btnEnrllmnt, "Submit Enrollment");
		return new EnrollmentSubmitted(testConfig);
	}
	
	public  ReviewAndSubmit fillAuthorizedEnrollersInfo()
	{	
		Element.enterData(frstName, fName,"Enter First name as : "+fName,"First Name");
		Element.enterData(lstName, lName,"Enter Last nam as : "+lName,"Last Name");
		Element.enterData(titleName, title,"Enter Title as : "+title,"Title");
		Element.enterData(priEmlAdrs, firstProvEmailAdr, "Enter email address as : " +firstProvEmailAdr,"firstProvEmail");
		Element.enterData(retypEmlAdrs, firstProvEmailAdr, "Retype email address as : " +firstProvEmailAdr,"verifyFirstProvEmail");
		Element.enterData(phField1, phNo,"Entered first three digits of phone number as :" + phNo ,"firstProvPhField1");
		Element.enterData(phField2, phNo,"Entered second three digits of phone number as :" + phNo,"firstProvPhField2");
		Element.enterData(phField3, phNoLstField,"Entered last four digits of phone number as :" + phNoLstField ,"firstProvPhField3");
		enrollmentInfoPageObj.setAuthFrstName(fName);
		enrollmentInfoPageObj.setAuthLstName(lName);
		enrollmentInfoPageObj.setAuthTitle(title);
		enrollmentInfoPageObj.setAuthEmail(firstProvEmailAdr);
		testConfig.putRunTimeProperty("Auth_Email", firstProvEmailAdr);
		enrollmentInfoPageObj.setAuthPhnNbr(phNo+phNo+phNoLstField);
		return this;
	}
}
