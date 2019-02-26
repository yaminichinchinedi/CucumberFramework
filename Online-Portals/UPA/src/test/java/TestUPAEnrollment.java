package test.java;

import java.io.IOException;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.ProviderInformationEFTERAEnroll;
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
	
	
//	@Test(priority=1,description="Verifies Successful AO type new enrollment with all details saved in DB")
//	public void testSuccessfulAOProviderEnrollment() throws Exception{
//		
//		int excelRowNo=1;
//		int noOfEnrollments=0; 
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        noOfEnrollments=registrationPage.getNumberOfEnrollmentsToBeDone(excelRowNo);
//        registrationPage.doCompleteEnrollment(excelRowNo, noOfEnrollments,registrationPage);
//     
//		   
//	}
//	
//	@Test(priority=2,description="Verifies Successful AV type new enrollment")
//	public void testSuccessfulAVProviderEnrollment() throws Exception{
//		
//	    int excelRowNo=3;
//		int noOfEnrollments=0;   
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        noOfEnrollments=registrationPage.getNumberOfEnrollmentsToBeDone(excelRowNo);
//        registrationPage.doCompleteEnrollment(excelRowNo, noOfEnrollments,registrationPage);
//       
//	}
//	
//	@Test(priority=2,description="Verifies Successful VO type new enrollment")
//	public void testSuccessfulVOProviderEnrollment() throws Exception{
//		
//	    int excelRowNo=4;
//		int noOfEnrollments=0;   
//        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//        noOfEnrollments=registrationPage.getNumberOfEnrollmentsToBeDone(excelRowNo);
//        registrationPage.doCompleteEnrollment(excelRowNo, noOfEnrollments,registrationPage);
//       
//	}

	
	@Test(priority=3,description="Verifies validation message if an existing email is used for new enrollment For Primary Prov")
	void testDupEmailErrorForPrimaryProvWithYes()throws IOException
	{
		int excelRowNo=1;
		String provType="Primary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).verifyAssociatedTins().clickYes(provType);
		
	}
	
	@Test(priority=3,description="Verifies validation message if an existing email is used for new enrollment For Primary Prov")
	void testDupEmailErrorForPrimaryProvWithNo()throws IOException
	{
		int excelRowNo=1;
		String provType="Primary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).clickNo(provType);
		
	}
	
	@Test(priority=3,description="Verifies validation message if an existing email is used for new enrollment For Secondary Prov")
	void testDupEmailErrorForSecondaryProvWithYes()throws IOException
	{
		int excelRowNo=1;
		String provType="Secondary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).verifyAssociatedTins().clickYes(provType);
	}
	
	
	@Test(priority=3,description="Verifies validation message if an existing email is used for new enrollment For Secondary Prov")
	void testDupEmailErrorForSecondaryProvWithNo()throws IOException
	{
		int excelRowNo=1;
		String provType="Secondary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).verifyAssociatedTins().clickNo(provType);
	}
	
	@Test(priority=3,description="Verifies validation message if an existing email is used for new enrollment For Secondary Prov")
	void testDupEmailErrorForBothPrimaryAndSecondaryProv()throws IOException
	{
		int excelRowNo=1;
		String provType="PrimaryAndSecondary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).clickYes(provType).verifyDupEmailError("Secondary");
	}
	
	
	

}