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

public class TestTINStatusPages extends TestBase {

	
	@Test(priority=4,description="Verifies Header Links functionality")
	public void testHeaderLinks()
	 {
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.verifyAllHeaderLinks();
		
	 }
	
	@Test(priority=3,description="US1023501_TS01_Enrolled and Active Status TIN")
	void testEnrolledActiveStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledActiveStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledActiveStatusTIN();		
	}
	
	@Test(priority=3,description="US1023501_TS02_Enrolled and Pre-Enrollment Status TIN")
	void testEnrolledPreEnrollmentStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledPreEnrollmentStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledPreEnrollmentStatusTIN();		
	}
	
	@Test(priority=3,description="US1023501_TS03_Auto Enrolled and in Pre-Enrollment Status TIN")
	void testAutoEnrolledPreEnrollmentStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "AutoEnrolledPreEnrollmentStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyAutoEnrolledPreEnrollmentStatusTIN();		
	}
	
	@Test(priority=3,description="US1023501_TS04_Enrolled and Inactive/Block Status TIN")
	void testEnrolledInactiveAndBlockStatusTIN()throws IOException
	{
		int excelRowNo=1;
		String status = "EnrolledInactiveAndBlockStatusTIN";
		
        UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);       
		BeginEnrollmentContinue beginEnrollmentContinue = registrationPage.clickEnrollNow().selectHowYouHeard("Health plan communication");		
		beginEnrollmentContinue.getTin(excelRowNo, status).clickContinue().verifyEnrolledInactiveAndBlockStatusTIN();		
	}
	
}