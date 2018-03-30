package main.java.pageObjects;

import java.io.IOException;

import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.LogTemp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UPARegistrationPage{
	
	//Declare Page objects and methods
	
	@FindBy(partialLinkText="Enroll Now")
	private WebElement lnkEnrollNow;
	
	@FindBy(xpath="//nav[@class='standard-header__nav']//a[contains(text(),'Home')]")
	private WebElement lnkHeaderHome;
	

	@FindBy(xpath="//nav[@class='standard-header__nav']//a[contains(text(),'Benefits of EPS')]")
	private WebElement lnkHeaderBenefitsofEPS;

	@FindBy(xpath="//nav[@class='standard-header__nav']//a[contains(text(),'How to Enroll')]")
	private WebElement lnkHeaderHowtoEnroll;
	

	@FindBy(xpath="//nav[@class='standard-header__nav']//a[contains(text(),'FAQs')]")
	private WebElement lnkHeaderFAQs;

	@FindBy(css=".standard-header__logo.sprite--optum-logo")
	private WebElement lnkOptumLogo;
	
	@FindBy(xpath="//a[contains(@class, 'button')andtext()='ENROLL NOW']")
	private WebElement btnEnrollNow;
	
	
			
	
	private TestBase testConfig;
	
	
	public UPARegistrationPage(TestBase testConfig) 
	{
		this.testConfig=testConfig;		
		testConfig.driver.navigate().to(System.getProperty("URL"));
		LogTemp.Comment("Navigated to UPA");
		PageFactory.initElements(testConfig.driver, this);
		Browser.wait(testConfig, 2);
		
	}
	
	public void clickAndVerifyOptumLogo()
	{
		String expectedURL="/registrationSignIn.do";
		Element.click(lnkOptumLogo,"Optum Logo at header");
		Browser.wait(testConfig, 5);
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderHome()
	{
		String expectedURL="/registrationSignIn.do";
		Element.click(lnkHeaderHome,"Header Home");
		Browser.waitForLoad(testConfig.driver);
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderBenefitsOfEPS()
	{
		String expectedURL="/benefitofeps.do";
		Element.click(lnkHeaderBenefitsofEPS,"Header Benefits of EPS");
		Browser.waitForLoad(testConfig.driver);
		Browser.wait(testConfig, 5);
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderHowToEnroll()
	{
		String expectedURL="/HowToEnroll.do";
		Element.click(lnkHeaderHowtoEnroll,"Header How to Enroll");
		Browser.wait(testConfig, 5);
		Helper.compareContains(testConfig, "Browser URL", expectedURL, Browser.getURL(testConfig));
	}
	
	public void clickAndVerifyHeaderFAQs()
	{
		String expectedURL="/epsFaqs.do";
		Element.click(lnkHeaderFAQs,"Header FAQs");
		Browser.wait(testConfig, 5);
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
	
	
	
	
	public void verifyAllHeaderLinks()
	{
		clickAndVerifyOptumLogo();
		clickAndVerifyHeaderHowToEnroll();
		Browser.wait(testConfig, 5);
		clickAndVerifyHeaderBenefitsOfEPS();
		Browser.wait(testConfig, 5);
		clickAndVerifyHeaderFAQs();
		Browser.wait(testConfig, 5);
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
		       
		        financialInstPage.fillFinancialInstInfo();
		        validateEFTERAFinancialInfo validateFinancialInfoPage = financialInstPage.clickContinue();
		        
		        ValidateEFTERASubmitInfo validatw9SubmitForm = validateFinancialInfoPage.fillUploadEFTERAFileFormAndSubmit();
		        ThankYouPage thankYouPage = validatw9SubmitForm.fillEnrollersInfo();
		        thankYouPage.verifyEnrollmentInfoInDB();
		        
		       }
		
		     catch(Exception e)
		      {	
		    	 LogTemp.Warning(i+1 + "th enrollment failed due to" + e ,testConfig);
		    	 result=false;
			     
		      }
		    finally
		    {
		    i++;
		    registrationPage=new UPARegistrationPage(testConfig);
		    }
		}
		   
		   LogTemp.Comment("Enrollment flow ran for" + " "+ i + " "+ "times","Brown");
		   if(!result)
		   {
			   LogTemp.Fail("Exception occured while execution");
		   }
	}


}
