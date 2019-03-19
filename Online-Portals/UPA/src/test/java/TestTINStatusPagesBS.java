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

public class TestTINStatusPagesBS extends TestBase {

	
	@Test(priority=4,description="Verifies Header Links functionality")
	public void testHeaderLinks()
	 {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.verifyAllHeaderLinks();
		
	 }
	
	@Test(priority=3,description="US1048015_TS01_Enrolled_and_Active_BS_TIN")
	void testEnrolledActiveBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyEnrolledActiveBSTIN();		
	}
	
	@Test(priority=3,description="US1048015_TS02_Enrolled_and_Active_BS_TIN_Details")
	void testEnrolledActiveBSTINDetails()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyEnrolledActiveBSTINDetails();		
	}
	
	@Test(priority=3,description="US1048015_TS03_Enrolled_and_Active_BS_TIN_Sign_In_To_EPS_Option")
	void testEnrolledActiveBSTINReturnToLogin()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyEnrolledActiveBSTINDetails().returnToLogin();		
	}
	
	@Test(priority=3,description="US1048015_TS04_Pre_Enrolled_BS_TIN")
	void testPreEnrolledBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "PreEnrolledBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyPreEnrolledBSTIN();
	}
	
	@Test(priority=3,description="US1048015_TS05_Pre_Enrolled_BS_TIN_Sign_In_To_EPS_Option")
	void testPreEnrolledBSTINReturnToLogin()throws IOException
	{
		int excelRowNo=2;
		String status = "PreEnrolledBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyPreEnrolledBSTIN().returnToLogin();
	}
	
	@Test(priority=3,description="US1048015_TS06_UXDS_HTML")
	void testUXDSHTML()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyContentWithUXDSBS();	
	}
	
	@Test(priority=3,description="US1048015_TS07_Content_Managed")
	void testContentManagedActiveBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "EnrolledActiveBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyContentManagedForActiveBSTIN();
	}
	
	@Test(priority=3,description="US1048015_TS07_Content_Managed")
	void testContentManagedPendingEnrollmentBSTIN()throws IOException
	{
		int excelRowNo=2;
		String status = "PreEnrolledBSTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getBSTin(excelRowNo, status).clickContinue().verifyContentManagedForPendingEnrollmentBSTIN();
	}
	
}