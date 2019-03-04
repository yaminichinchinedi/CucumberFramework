package test.java;

import java.io.IOException;

import org.testng.annotations.Test;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.BenefitsOfEPS;
import main.java.pageObjects.HowToEnroll;
import main.java.pageObjects.UPARegistrationPage;

public class TestBeforeYouBeginEnrollment extends TestBase{
	
	@Test(priority=3,description="US1348562 - TS_00001 - Upon selection of  Enroll Now button click navigates user to Before you begin enrollment page")
	public void testBeforeYouBeginEnrollmentPage()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateBeginEnrollment();
	}
	
	
	// TC_0007 is covered with this
	@Test(priority=3,description="US1348562 - TS_00002 - Enroll Now  button from How to Enroll Page navigates user to  Before you begin enrollment  page")
	public void testHowToEnrollLink()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		HowToEnroll howToEnroll = upaRegistrationPage.clickHowToEnrollLink();
		BeginEnrollment beginEnrollment = howToEnroll.validateEnrollNowBtn();
		beginEnrollment.validateBeginEnrollment();
	}
	
	@Test(priority=3,description="US1348562 - TS_00006 - Benefits of EPS link on page navigates user to the Benefits of EPS page.")
	public void testValidateBenefitsOfEPSLink()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BenefitsOfEPS benefitsOfEPS = upaRegistrationPage.clickBenefitsOfEPSLink();		
	}
	
	// TC_0009 is already covered and standard step for each test case.
	
	@Test(priority=3,description="US1348562 - TS_00010 - To Validate If user does not select an option and clicks continue , error message is displayed  below the radio buttons.")
	public void testBeginEnrollmentErrorValidation()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinue = beginEnrollment.clickContinue();
		beginEnrollmentContinue.validateErrorMsgs();		
	}
	
	//TC_00012 is also covered with this
	@Test(priority=3,description="US1348562 - TS_00011 - the error message  if user selects Other without entering text and clicks continue")
	public void testBeginEnrollmentOtherRadioSelectedErrorValidation()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinue = beginEnrollment.selectOtherToValidateErrorMessage();
		beginEnrollmentContinue.validateErrorMsgs();		
	}
	
	//Add TC0015 in below 
	@Test(priority=3,description="US1348562 - TS_00013 - the limit of characters to be entered for the Text box, [Max limit 50]")
	public void testBeginEnrollmentValidateLmtOfChars()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateTextBoxCharLmt();
	}
	
	@Test(priority=3,description="US1348562 - TS_00014 - The Pop up message on click of Cancel Enrollment Button.")
	public void testValidateCancelEnrlmntBtn()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateCancelEnrollmentBtnNo();
		beginEnrollment.validateBeginEnrollment();
		upaRegistrationPage = beginEnrollment.validateCancelEnrollmentBtnYes();
	}
	
	@Test(priority=3,description="US1348562 - TS_00008 - User is able to download Enrollment Guide PDFs.")
	public void testAbleToDwnldEnrlmntPdf()
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateUserIsAbleToDwnldEnrlmntPdf();		
	}
	
	@Test(priority=3,description="US1348562 - TS_00005 - Q and A are obtained from active entries in Survey Table (responses appear in appropriate order")
	public void testBeginEnrollmentQuestions() throws IOException
	{
		UPARegistrationPage upaRegistrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollment = upaRegistrationPage.clickEnrollNow();
		beginEnrollment.validateBeginEnrollmentQuestions();
	}

}
