package test.java;

import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.BeginEnrollment;
import main.java.pageObjects.BeginEnrollmentContinue;
import main.java.pageObjects.FinancialInstitutionInfoPage;
import main.java.pageObjects.ProviderEFTERAEnrollPage;
import main.java.pageObjects.UPARegistrationPage;
import main.java.pageObjects.ValidateEFTERAProviderInfo;
import main.java.pageObjects.ValidateEnrollmentTypePage;
import main.java.reporting.Log;

public class TestUS1202167 extends TestBase{
	
	/**
	 * This test case belong to US1348529
	 */
	@Test(priority=4,description="TS001/TS002 Validates the Page navigation from BeginEnrollment page to BeginEnrollmentContinue page")
	public void testSurveyTablesAndResponse()
	 {
		String option="Provider Advocate recommendation";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		registrationPage.clickEnrollNow().selectHowYouHeard(option).verifySurveyTables(option);
	 }
	
	/**
	 * These below test cases belong to US1202167
	 * @throws IOException
	 */
	
	@Test(priority=4,description="TS001/TS002/TS018/TS023 Validates User Enrollment As Health Organisation") 
	public void testUserEnrollmentAsHealthOrg() throws IOException
	{
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinue().uploadW9().fillInfoAndClickSubmit();
	 }
	
	@Test(priority=4,description="TS003 Validates User Enrollment As BS")
	public void testUserEnrollmentAsBS() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=2;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).clickContinueBS().clickContinue().fillBusinessOrgInfo().fillPrimaryBSInfo().clickCntinue().uploadW9().fillBSInfoAndClickSubmit();
	 }
	
	@Test(priority=4,description="TS004/TS005/TS006/TS015 Validates what shall i choose after Selecting Health Org /TS005 Validates Pop Up after clicking Close link")
	public void testPopUpAfterChoosingHealthOrg() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyChooseLink();
	 }
	
	@Test(priority=4,description="TS007/TS016/TS017 Validates Page after clicking on change link")
	public void testChangeLinkFunctionality() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyChangeLink();
	 }
	
	@Test(priority=4,description="TS008 + TS009 =Validates navigation upon selection of VCP and healthOrg/TS009 Validates navigation upon clicking Cancel on VCP PopUp Box")
	public void testChooseVCP() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyPopUp("VO");
	 } 
	
	@Test(priority=4,description="TS010 Validates navigation upon selection of I agree option on VCP pop up ")
	public void testEnrollAsVCP() throws IOException
	 {
		String option="Health plan communication";
		int excelRowNo=4;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinueVO().uploadW9().fillInfoAndClickSubmit();
		
	 }
	
	@Test(priority=4,description="TS011/TS014 Validates navigation upon selection of I agree option on ACH and VCP pop up")
	public void testEnrollAsVCPandACH() throws IOException
	 {
		String option="Health plan communication";
		int excelRowNo=3;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRowNo).clickContinue().clickContinue().fillProviderOrgInfo().fillPrimaryProvInfo().clickContinue().fillFinancialInstInfo().clickContinueAV().clickContinue().uploadW9().fillInfoAndClickSubmit();	
	 }

	@Test(priority=4,description="TS012/TS013 Validates navigation upon clicking Cancel on VCP PopUp Box")
	public void testChooseVCPandACH() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		beginEnrollmentPage.selectHowYouHeard(option).verifyPopUp("AV");
	 }
	
	@Test(priority=4,description="TS020/TS021/TS022 Validates Content of PopUp upon clicking Cancel Button")
	public void testCancelEnrollmentPopUp() throws IOException
	 {
		String option="Health plan communication";
		int excelRow=1;
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.enrollAs(excelRow).verifyCancelEnrollmentFunctionality();
	 }
	
	@Test(priority=4,description="TS024-TS026 Validates errors messages displayed on various TIN combinations")
	public void testErrorMsgs() throws IOException
	 {
		String option="Health plan communication";
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		beginEnrollmentContinuePage.verifyErrorMsg();
	 }
	
	@Test(priority=4,description="TS01-Create Enrollment Provider Footer Display")
	public void testFooterContents() throws IOException
	 {
		String option="Health plan communication";
		TestFooter testfooter=new TestFooter();
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		testfooter.validateFooterContents(testConfig);
		BeginEnrollment beginEnrollmentPage=  registrationPage.clickEnrollNow();
		testfooter.validateFooterContents(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinuePage= beginEnrollmentPage.selectHowYouHeard(option);
		testfooter.validateFooterContents(testConfig);
		
		
			ValidateEnrollmentTypePage ValidateenrollmentTypePage=beginEnrollmentContinuePage.enrollAs(1).clickContinue();
			testfooter.validateFooterContents(testConfig);
			ProviderEFTERAEnrollPage providerEFTERAEnrollPage=ValidateenrollmentTypePage.clickContinue();
			testfooter.validateFooterContents(testConfig);
			ValidateEFTERAProviderInfo validateEFTERAProviderInfo=providerEFTERAEnrollPage.fillProviderOrgInfo().fillPrimaryProvInfo();
			testfooter.validateFooterContents(testConfig);
			FinancialInstitutionInfoPage financialInstitutionInfoPage=validateEFTERAProviderInfo.clickContinue().fillFinancialInstInfo();
			testfooter.validateFooterContents(testConfig);
		
	 }
	

	
}
