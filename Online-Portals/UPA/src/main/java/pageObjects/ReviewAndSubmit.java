package main.java.pageObjects;

import java.io.IOException;
import java.util.List;

import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//*[@id='EFTERAregForm']//div[2]/div[1]/a")
	WebElement btnEditOrg;
	
	@FindBy(xpath="//*[@id='EFTERAregForm']//div[2]/div")
	List<WebElement> divOrgInfo;
	
	
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
		System.out.println("KUCH KUCH TO HOGA"+divOrgInfo.get(1).findElements(By.tagName("div")).get(2).findElements(By.tagName("dl")).get(0).findElement(By.tagName("dd")));
		return this;
	}
}
