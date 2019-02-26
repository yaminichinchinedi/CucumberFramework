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

public class TestTINReadyForEnrollment extends TestBase {


	@Test(priority=4,description="Verifies Header Links functionality")
	public void testHeaderLinks()
	{
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.verifyAllHeaderLinks();

	}

	@Test(priority=3,description="TS01_TIN does not exist on EPS")
	void testTINNotEnrolled()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyTINStatus();	
	}

	@Test(priority=3,description="TS02_TIN exists Inactive and not blocked")
	void testInactiveUnBlockedTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "InactiveUnBlockedTIN";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyTINStatus();	
	}

	@Test(priority=3,description="TS03_TIN does not exists on EPS_AO")
	void testTINNotEnrolledAO()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyTINStatus();	
	}

	@Test(priority=3,description="TS04_TIN does not exists on EPS_AV")
	void testTINNotEnrolledVO()throws IOException
	{
		int excelRowNo=4;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyTINStatus();	
	}

	@Test(priority=3,description="TS05_TIN does not exists on EPS_VO")
	void testTINNotEnrolledAV()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyTINStatus();	
	}

	@Test(priority=3,description="TS06_Content Managed")
	void testContentManaged()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyContentManaged();	
	}

	@Test(priority=3,description="TS07_UXDS match")
	void testUXDSMatch()throws IOException
	{
		int excelRowNo=3;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyContentWithUXDS();	
	}

	@Test(priority=3,description="TS08_Blank W9")
	void testW9Form()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyW9Form();	
	}

	@Test(priority=3,description="TS09_Cancel and Continue Enabled")
	void testCancelAndContinueBtn()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.verifyCancelAndContinueBtn();	
	}

	@Test(priority=3,description="TS10_Cancel Enrollment_Popup")
	void testBtnCancelPopUp()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.clickCancel().verifyBtnCancelPopup();	
	}

	@Test(priority=3,description="TS11_Cancel Enrollment_No")
	void testBtnCancelPopUpClickNo()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.clickCancel().verifyBtnCancelPopup().confirmCancelNo().verifyTINStatus();	
	}

	@Test(priority=3,description="TS12_Cancel Enrollment_Yes")
	void testBtnCancelPopUpClickYes()throws IOException
	{
		int excelRowNo=1;
		String status = "TINNotEnrolled";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		ValidateEnrollmentTypePage validateEnrollmentType = beginEnrollmentContinue.enrollTIN(excelRowNo, status).clickContinue();
		validateEnrollmentType.clickCancel().verifyBtnCancelPopup().confirmCancelYes().clickAndVerifyHeaderHome();	
	}


}