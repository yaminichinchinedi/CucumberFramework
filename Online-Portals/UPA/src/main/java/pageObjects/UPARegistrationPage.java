package main.java.pageObjects;

import java.io.IOException;
import java.util.Properties;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UPARegistrationPage extends TestBase{
	
	//Declare Page objects and methods
	
	@FindBy(partialLinkText="ENROLL NOW")
	private WebElement lnkEnrollNow;
	
	@FindBy(linkText="Home")
	private WebElement lnkHeaderHome;
	

	@FindBy(linkText="BENEFITS OF OPTUM PAY")
	private WebElement lnkHeaderBenefitsofOptumPay;

	@FindBy(linkText="HOW TO ENROLL")
	private WebElement lnkHeaderHowtoEnroll;
	
	@FindBy(linkText="FAQs")
	private WebElement lnkHeaderFAQs;

	@FindBy(css="a.white-header__logo.latest--optumbank-logo")
	private WebElement lnkOptumLogo;
	
	@FindBy(xpath="//a[contains(@class, 'button')andtext()='ENROLL NOW']")
	private WebElement btnEnrollNow;
	
	private TestBase testConfig;
	public ValidateEFTERASubmitInfo validatw9SubmitForm;
	
	@FindBy(linkText="SIGN IN")
	//@FindBy(linkText="SIGN IN WITH OPTUM ID")
	WebElement lnkSignInWithOptumId;
	
	@FindBy(tagName="nobr")
	private WebElement footerText;
	
	@FindBy(linkText="BENEFITS OF OPTUM PAY")
	private WebElement benefitsofOptumPayButton;
	
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome to Optum Pay�')]")
	WebElement welcomeToOptumPayHeader;
	
	@FindBy(xpath = "//p[contains(text(),'There is significant cost savings available by enrolling in Optum Pay delivery. Use this calculator to get an estimate of the dollars your organization could save by switching to either ACH (direct deposit) or Virtual Card Payments (VCP).')]")
	WebElement calculatorSectionText;
	
	@FindBy(xpath = "//h2[contains(text(),'Optum Pay Customer Support')]")
	WebElement optumPayCustomerSupportHeader;

	@FindBy(xpath = "//b[contains(text(),'Optum Pay Savings Calculator')]")
	WebElement optumPaySavingsCalculatorHeader;
	
	@FindBy(linkText="CALCULATE MY SAVINGS")
	private WebElement calculateMySavings;
	
	public UPARegistrationPage(TestBase testConfig) 
	{
		
		this.testConfig=testConfig;
		
		
		System.setProperty("Application", "UPA");
		Browser.dismissAlert(testConfig);
		testConfig.driver.navigate().to(System.getProperty("URL"));
		Log.Comment("Navigated to UPA with URL : " + System.getProperty("URL"));
		Browser.waitForLoad(testConfig.driver);
		PageFactory.initElements(testConfig.driver, this);
		
		String env=System.getProperty("env");
		
		//Added by AMit- ask him the reason for not putting elses
		if(!"prpurged".equals(testConfig.getRunTimeProperty("prpurged")))
			//Element.fluentWait(testConfig, lnkSignInWithOptumId, 200, 3, "Sign In With Optum ID");	
		    Element.fluentWait(testConfig, lnkSignInWithOptumId, 200, 3, "Sign In");

	}
	
	
	public void clickAndVerifyOptumLogo()
	{
		String expectedURL="/registrationSignIn.do";
		Element.click(lnkOptumLogo,"Optum Logo at header");
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderHome()
	{
		String expectedURL="/registrationSignIn.do";
		Element.click(lnkHeaderHome,"Header Home");
		Browser.waitTillSpecificPageIsLoaded(testConfig, "Login");
		
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public void clickAndVerifyHeaderBenefitsOfEPS()
	{
		String expectedURL="Benefits of EPS";
		Element.click(lnkHeaderBenefitsofOptumPay,"Header Benefits of EPS");
		Browser.waitTillSpecificPageIsLoaded(testConfig, expectedURL);
		expectedURL="benefitofeps.do";
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderHowToEnroll()
	{
		String expectedURL="How To Enroll";
		Browser.wait(testConfig, 2);
		lnkHeaderHowtoEnroll=Element.findElement(testConfig, "linkText", "How to Enroll");
		Element.clickByJS(testConfig,lnkHeaderHowtoEnroll,"How to enroll");
		Element.click(lnkHeaderHowtoEnroll,"How to enroll");
		Browser.waitTillSpecificPageIsLoaded(testConfig,expectedURL);
		Helper.compareContains(testConfig, "Browser URL", expectedURL.replace(" " , ""), Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderFAQs()
	{
		String expectedURL="/epsFaqs.do";
		Element.click(lnkHeaderFAQs,"Header FAQs");
		Browser.waitTillSpecificPageIsLoaded(testConfig, "FAQS");
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}

		
	public BeginEnrollment clickEnrollNow()
	{
		Element.click(lnkEnrollNow,"Enroll Now");
		return new BeginEnrollment(testConfig);
	}
	
	public BeginEnrollment clickbtnEnrollNow()
	{
		Element.click(btnEnrollNow,"Enroll Now");
		return new BeginEnrollment(testConfig);
	}
	
	public OptumIdLoginPage clickSignInWithOptumId()
	{
		Element.clickByJS(testConfig, lnkSignInWithOptumId, "Sign in with optum id button");
		return new OptumIdLoginPage(testConfig);
	}
	
	
	
	public void verifyAllHeaderLinks()
	{
		clickAndVerifyOptumLogo();
		clickAndVerifyHeaderHowToEnroll();
		clickAndVerifyHeaderBenefitsOfEPS();
		clickAndVerifyHeaderFAQs();
		clickAndVerifyHeaderHome();
		
		
	}
		
	
	public int getNumberOfEnrollmentsToBeDone(int excelRowNo) throws IOException
	{
		
		int j=1;
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		String i=data.GetData(excelRowNo, "Loop");
		if(i.length()==0)
		{
			return j;
		}
		j=Integer.parseInt(i);
		return j;
		   
	}
	
	public HowToEnroll clickHowToEnrollLink() {
		Element.click(lnkHeaderHowtoEnroll, "How to Enroll Link");
		return new HowToEnroll(testConfig);
	}
	
	public BenefitsOfOptumPay clickBenefitsOfOptumPayLink() {
		Element.click(lnkHeaderBenefitsofOptumPay, "Benefits of EPS Link");
		return new BenefitsOfOptumPay(testConfig);
	}
	
		
//	public void doCompleteEnrollment(int excelRowNo,int noOfEnrollments,UPARegistrationPage registrationPage) 
//	{
//		   int i=0;
//		   boolean result=true;
//		   while(i<noOfEnrollments) 
//		   {
//		 	 try 
//		      {
//		    	BeginEnrollment enrollmentTypePage = registrationPage.clickEnrollNow();
//		    	enrollmentTypePage=enrollmentTypePage.selectHowYouHeard("");
//		    	
//		    	
//		        ValidateEnrollmentTypePage validateEnrollmentType = enrollmentTypePage.enrollAs(excelRowNo).clickNext();
//		        ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
//		        ProviderInformationEFTERAEnroll providerInfoPage = providerEnrollPage.clickContinue();
//		        ValidateEFTERAProviderInfo validateProvInfoPage = providerInfoPage.fillProviderInfo();
//		        validateProvInfoPage.fillFirstProviderInfo();
//		        validateProvInfoPage.fillSecondProviderInfo();
//		        FinancialInstitutionInfoPage financialInstPage = validateProvInfoPage.clickContinue();
//		       
//		        if(!testConfig.getRunTimeProperty("enrollmentType").equalsIgnoreCase("VO"))
//		        {
//		         	financialInstPage.fillFinancialInstInfo();
//			        validateEFTERAFinancialInfo validateFinancialInfoPage = financialInstPage.clickContinue();
//			        validatw9SubmitForm = validateFinancialInfoPage.fillUploadEFTERAFileFormAndSubmit();
//		        }
//		        else
//		        {
//		        	financialInstPage.checkAcceptanceBox().fillAuthorizedSignature().submitForm();
//			        validatw9SubmitForm= new ValidateEFTERASubmitInfo(testConfig);
//		        }
//		        
//		        ThankYouPage thankYouPage = validatw9SubmitForm.fillEnrollersInfo();
////		        thankYouPage.verifyPDF();
//		        thankYouPage.verifyEnrollmentInfoInDB();
//		       }
//		
//		     catch(Exception e)
//		      {	
//		    	 Log.Warning(i+1 + "th enrollment failed due to" + e ,testConfig);
//		    	 result=false;
//		      }
//		    finally
//		     {
//		       i++;
//		       registrationPage=new UPARegistrationPage(testConfig);
//		     }
//		}
//		   Log.Comment("Enrollment flow ran for" + " "+ i + " "+ "times","Brown");
//		   if(!result){
//			   Log.Fail("Exception occured while execution");
//		   }   
//	}
	
	public void verifyOptumLogo()
	{
		Element.verifyElementPresent(lnkOptumLogo,"Optum Logo at header");
	}
	
	public void verifyFooter()
	
	{
		Helper.compareEquals(testConfig, "Footer Text", footerText.getText(), "2020 Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC");
	}
	
	public void verifyHeaderBenefitsOfOptumPay()
	{
		Helper.compareEquals(testConfig, "Header Benefits of Optum Pay", lnkHeaderBenefitsofOptumPay.getText(), "BENEFITS OF OPTUM PAY");
	}
	
	public void verifyBenefitsOfOptumPayButton()
	
	{
		Helper.compareEquals(testConfig, "Benefits Of Optum Pay Text", benefitsofOptumPayButton.getText(), "BENEFITS OF OPTUM PAY");
	}
	
	public void verifyWelcomeToOptumPayHeader()
	
	{
		Helper.compareEquals(testConfig, "Welcome to Optum Pay� Text", welcomeToOptumPayHeader.getText(), "Welcome to Optum Pay�");
	}
	
	public void verifyOptumPayText(WebElement ele) {
		String optum_pay = "Optum Pay";	
		String text = ele.getText();
		if (text.contains(optum_pay))
		{
		Log.Pass(ele + " " +"contains text" + " " + optum_pay);
		}
		else
		{
		Log.Fail(ele + " " + "does not contains text" + " " + optum_pay);
		}
		}
		
	
	public void verifyCalculatorSectionText()
	
	{
		this.verifyOptumPayText(calculatorSectionText);
	}
	
	public void verifyOptumPayCustomerSupportHeader()
	
	{
		Helper.compareEquals(testConfig, "Optum Pay Custome Support Text", optumPayCustomerSupportHeader.getText(), "Optum Pay Customer Support");
	}
	
	public void clickAndVerifyOptumPaySavingsCalculator()
	{
		Browser.scrollTillAnElement(testConfig, optumPayCustomerSupportHeader, "calculateMySavings");
		Element.click(calculateMySavings,"Calculate My Savings");
		Helper.compareEquals(testConfig, "Optum Pay Savings Calculator Text", optumPaySavingsCalculatorHeader.getText(), "Optum Pay Savings Calculator");

	}
	public void verifyHomePage()
	{
		this.verifyOptumLogo();
		this.verifyFooter();
		this.verifyHeaderBenefitsOfOptumPay();
		this.verifyWelcomeToOptumPayHeader();
		this.verifyBenefitsOfOptumPayButton();
		this.verifyCalculatorSectionText();
		this.verifyOptumPayCustomerSupportHeader();
		this.clickAndVerifyOptumPaySavingsCalculator();
	}
		

}