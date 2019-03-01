package test.java;

import java.io.IOException;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.UPARegistrationPage;

import org.testng.annotations.Test;

import main.java.pageObjects.*;

public class TestUPAEnrollment extends TestBase {

	
	@Test(priority=1,description="Verifies Header Links functionality")
	public void testHeaderLinks()
	 {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.verifyAllHeaderLinks();
		
	 }
	
	
	@Test(priority=3,description="Verifies validation message if an existing email is used for new enrollment For Primary Prov")
	public void testDupEmailErrorForPrimaryProvWithYes()throws IOException
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
	public void testDupEmailErrorForPrimaryProvWithNo()throws IOException
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
	public void testDupEmailErrorForSecondaryProvWithYes()throws IOException
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
	public void testDupEmailErrorForSecondaryProvWithNo()throws IOException
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
	public void testDupEmailErrorForBothPrimaryAndSecondaryProv()throws IOException
	{
		int excelRowNo=1;
		String provType="PrimaryAndSecondary";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillProviderOrgInfo().verifyDupEmailError(provType).clickYes(provType).verifyDupEmailError("Secondary");
	}
	
	//US1351123
	
	@Test(priority=3,description="[1]TS_00003_Page text is content managed + TS_00004_Field label changes display Business Name and Business Address. + TS_00005_Messaging on page indicates not to enter special characters. + TS_00006_Header displays - For AO .+ TS_00009_To Validate Cancel Enrollment and Continue options display." )
	public void testPageContextFromDB()throws IOException
	{
		int excelRowNo=1;
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyOrgInfoHeaders().verifyUITextFromDB();
		
	}
	
	@Test(priority=3,description="TS_00009_To Validate Cancel Enrollment and Continue options display.+ TS_00010_To Validate Cancel Enrollment and Continue options display. + TS_00011_ Validate  Upon selection of No, popup box closes and user is back on Organization Information page.. + TS_00012_ Validate Upon selection of Yes, user is returned to the EPS Landing page." )
	public void testCancelEnrollment()throws IOException
	{
		int excelRowNo=1;
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyCancelEnrollmentFlow();
		
	}
	
	
	@Test(priority=3,description="TS_00009_To Validate Cancel Enrollment and Continue options display.+ TS_00010_To Validate Cancel Enrollment and Continue options display. + TS_00011_ Validate  Upon selection of No, popup box closes and user is back on Organization Information page.. + TS_00012_ Validate Upon selection of Yes, user is returned to the EPS Landing page.+TS_00013,14 and 15,17" )
	public void testContinueEnrollment()throws IOException
	{
		int excelRowNo=1;
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.verifyContinueEnrollmentValidations();
		
	}
	
	@Test(priority=3,description="TS_00018_Missing and invalid field validation for Business Name (special characters)" )
	public void testFieldValidations()throws IOException
	{
		int excelRowNo=1;
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollAs(excelRowNo).clickContinue();
		ProviderEFTERAEnrollPage providerEnrollPage = validateEnrollmentType.clickContinue();
		providerEnrollPage.fillBusinessName("#&*").verifyErrorMsgForInvalidData("BusinessName").fillBusinessAddress("#&*").verifyErrorMsgForInvalidData("BusinessAddress");
		
	}
	

	

}