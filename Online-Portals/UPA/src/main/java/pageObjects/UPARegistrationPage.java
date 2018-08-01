package main.java.pageObjects;

import java.io.IOException;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UPARegistrationPage{
	
	//Declare Page objects and methods
	
	@FindBy(partialLinkText="ENROLL NOW")
	private WebElement lnkEnrollNow;
	
	@FindBy(linkText="Home")
	private WebElement lnkHeaderHome;
	

	@FindBy(linkText="Benefits of EPS")
	private WebElement lnkHeaderBenefitsofEPS;

	@FindBy(linkText="How to Enroll")
	private WebElement lnkHeaderHowtoEnroll;
	

	@FindBy(linkText="FAQs")
	private WebElement lnkHeaderFAQs;

	@FindBy(css="a.white-header__logo.sprite--optum-logo")
	private WebElement lnkOptumLogo;
	
	@FindBy(xpath="//a[contains(@class, 'button')andtext()='ENROLL NOW']")
	private WebElement btnEnrollNow;
	
	private TestBase testConfig;
	public ValidateEFTERASubmitInfo validatw9SubmitForm;
	
	@FindBy(linkText="SIGN IN WITH OPTUM ID")
	WebElement lnkSignInWithOptumId;
	
	
	public UPARegistrationPage(TestBase testConfig) 
	{
		this.testConfig=testConfig;		
		testConfig.driver.navigate().to(System.getProperty("URL"));
		Log.Comment("Navigated to UPA with URL : " + System.getProperty("URL"));
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForLoad(testConfig.driver);
		Element.expectedWait(lnkSignInWithOptumId, testConfig, "Sign In With Optum ID",  "Sign In With Optum ID");
		
	}
	
	public void clickAndVerifyOptumLogo()
	{
		String expectedURL="/registrationSignIn.do";
		Element.click(lnkOptumLogo,"Optum Logo at header");
		Browser.waitForLoad(testConfig.driver);
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderHome()
	{
		String expectedURL="/registrationSignIn.do";
		Element.click(lnkHeaderHome,"Header Home");
		Browser.waitForLoad(testConfig.driver);
		Browser.verifyURL(testConfig, expectedURL);
		//Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderBenefitsOfEPS()
	{
		String expectedURL="/benefitofeps.do";
		Element.click(lnkHeaderBenefitsofEPS,"Header Benefits of EPS");
		Browser.waitForLoad(testConfig.driver);
		Browser.verifyURL(testConfig, expectedURL);
		//Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderHowToEnroll()
	{
		String expectedURL="/HowToEnroll.do";
		Element.click(lnkHeaderHowtoEnroll,"Header How to Enroll");
		Browser.wait(testConfig, 3);
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderFAQs()
	{
		String expectedURL="/epsFaqs.do";
		Element.click(lnkHeaderFAQs,"Header FAQs");
		Browser.wait(testConfig, 2);
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}

		
	public EnrollmentTypePage clickEnrollNow()
	{
		Element.click(lnkEnrollNow,"Enroll Now");
		return new EnrollmentTypePage(testConfig);
	}
	
	public EnrollmentTypePage clickbtnEnrollNow()
	{
		Element.click(btnEnrollNow,"Enroll Now");
		return new EnrollmentTypePage(testConfig);
	}
	
	public OptumIdLoginPage clickSignInWithOptumId()
	{
		Element.click(lnkSignInWithOptumId, "Sign in with optum id button");
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
	
		
	public void doCompleteEnrollment(int excelRowNo,int noOfEnrollments,UPARegistrationPage registrationPage) 
	{
		   int i=0;
		   boolean result=true;
		   while(i<noOfEnrollments) 
		   {
		 	 try 
		      {
		    	EnrollmentTypePage enrollmentTypePage = registrationPage.clickEnrollNow();
		        ValidateEnrollmentTypePage validateEnrollmentType = enrollmentTypePage.enrollAs(excelRowNo).clickNext();
		        ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		        ProviderInformationEFTERAEnroll providerInfoPage = providerEnrollPage.clickContinue();
		        ValidateEFTERAProviderInfo validateProvInfoPage = providerInfoPage.fillProviderInfo();
		        validateProvInfoPage.fillFirstProviderInfo();
		        validateProvInfoPage.fillSecondProviderInfo();
		        FinancialInstitutionInfoPage financialInstPage = validateProvInfoPage.clickContinue();
		       
		        if(!testConfig.getRunTimeProperty("enrollmentType").equalsIgnoreCase("VO"))
		        {
		         	financialInstPage.fillFinancialInstInfo();
			        validateEFTERAFinancialInfo validateFinancialInfoPage = financialInstPage.clickContinue();
			        validatw9SubmitForm = validateFinancialInfoPage.fillUploadEFTERAFileFormAndSubmit();
		        }
		        else
		        {
		        	financialInstPage.checkAcceptanceBox().fillAuthorizedSignature().submitForm();
			        validatw9SubmitForm= new ValidateEFTERASubmitInfo(testConfig);
		        }
		        
		        ThankYouPage thankYouPage = validatw9SubmitForm.fillEnrollersInfo();
		        thankYouPage.verifyEnrollmentInfoInDB();
		       }
		
		     catch(Exception e)
		      {	
		    	 Log.Warning(i+1 + "th enrollment failed due to" + e ,testConfig);
		    	 result=false;
		      }
		    finally
		     {
		       i++;
		       registrationPage=new UPARegistrationPage(testConfig);
		     }
		}
		   Log.Comment("Enrollment flow ran for" + " "+ i + " "+ "times","Brown");
		   if(!result){
			   Log.Fail("Exception occured while execution");
		   }   
	}

}
