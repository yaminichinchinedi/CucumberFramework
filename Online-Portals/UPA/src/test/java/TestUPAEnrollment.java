package test.java;

import java.io.IOException;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.UPARegistrationPage;

import org.testng.annotations.Test;

import main.java.pageObjects.*;

public class TestUPAEnrollment extends TestBase {

	
	@Test(priority=4,description="Verifies Header Links functionality")
	public void testHeaderLinks()
	 {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.verifyAllHeaderLinks();
		
	 }
	
	
	@Test(priority=1,description="Tests a Successful AO type new enrollment")
	public void testSuccessfulAOProviderEnrollment() throws Exception{
		
		int excelRowNo=1;
		int noOfEnrollments=0; 
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        noOfEnrollments=registrationPage.getNumberOfEnrollmentsToBeDone(excelRowNo);
        registrationPage.doCompleteEnrollment(excelRowNo, noOfEnrollments,registrationPage);
     
		   
	}
	
	@Test(priority=2,description="Tests a Successful AV type new enrollment")
	public void testSuccessfulAVProviderEnrollment() throws Exception{
		
	    int excelRowNo=3;
		int noOfEnrollments=0;   
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        noOfEnrollments=registrationPage.getNumberOfEnrollmentsToBeDone(excelRowNo);
        registrationPage.doCompleteEnrollment(excelRowNo, noOfEnrollments,registrationPage);
       
	}
	
	@Test(priority=2,description="Tests a Successful VO type new enrollment")
	public void testSuccessfulVOProviderEnrollment() throws Exception{
		
	    int excelRowNo=4;
		int noOfEnrollments=0;   
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
        noOfEnrollments=registrationPage.getNumberOfEnrollmentsToBeDone(excelRowNo);
        registrationPage.doCompleteEnrollment(excelRowNo, noOfEnrollments,registrationPage);
       
	}

	
	
	@Test(priority=3,description="Verifies validation message if an existing email is used for new enrollment")
	void testEmailDuplicateValidations()throws IOException {
		int excelRowNo=1;
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		EnrollmentTypePage enrollmentTypePage = registrationPage.clickEnrollNow();
		ValidateEnrollmentTypePage validateEnrollmentType = enrollmentTypePage.enrollAs(excelRowNo).clickNext();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		ProviderInformationEFTERAEnroll providerInfoPage = providerEnrollPage.clickContinue();
		ValidateEFTERAProviderInfo validateProvInfoPage = providerInfoPage.fillProviderInfo();
		validateProvInfoPage.VerifyDuplicateEmailError();
		
		
	}
	
	
	

}