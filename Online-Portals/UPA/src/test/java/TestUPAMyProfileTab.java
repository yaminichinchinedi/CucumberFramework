package test.java;


import java.io.IOException;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.AddUserDetails;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.ManageUsers;
import main.java.pageObjects.MyProfile;
import main.java.pageObjects.MyProfileChangePwd;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.ManageSecurityQuestions;
import main.java.pageObjects.UPARegistrationPage;

import org.testng.annotations.Test;


public class TestUPAMyProfileTab extends TestBase
 {

	@Test(priority=4,description="Verifies User Details displayed on My profile Page from user details saved in Database for logged in user")
	public void testProviderUserDetails() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		myProfilePage.verifyUserDetails(userType);
	 }
	
	@Test(priority=5,description="Verifies User Details displayed on My profile Page from user details saved in Database for logged in user")
	public void testBSUserDetails() throws InterruptedException, IOException
	 {
		String userType="BS";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		MyProfile myProfilePage=home.clickMyProfileTab();
		myProfilePage.verifyUserDetails(userType);
	 }
	
	
	@Test(priority=6,description="Verifies User Details displayed on My profile Page from user details saved in Database for logged in user")
	public void testPayerUserDetails() throws InterruptedException, IOException
	 {
		String userType="PAY";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		MyProfile myProfilePage=home.clickMyProfileTab();
		myProfilePage.verifyUserDetails(userType);
	 }
	
	@Test(priority=1,description="Verifies Error messages for provider")
	public void testErrorMsgsForProv() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		myProfilePage.verifyErrorMessages(userType);
	 }
	
	
	@Test(priority=2,description="Verifies Password guidelines text" + "<br>" + "Verifies user is able to change his password successfully." + "<br" + "Verifies yes/no functinality while changing password")
	public void testErrorMsgsForBS() throws InterruptedException, IOException
	 {
		String userType="BS";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		MyProfile myProfilePage=home.clickMyProfileTab();
		myProfilePage.verifyErrorMessages(userType);
	 }
	
	@Test(priority=3,description="Verifies Password guidelines text" + "<br>" + "Verifies user is able to change his password successfully." + "<br" + "Verifies yes/no functinality while changing password")
	public void testErrorMsgsForPayer() throws InterruptedException, IOException
	 {
		String userType="PAY";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		MyProfile myProfilePage=home.clickMyProfileTab();
		myProfilePage.verifyErrorMessages(userType);
	 }
	
	
	@Test(priority=7,description="Verifies user is able to change his password successfully." + "<br" + "Verifies yes/no functinality while changing password" + "<br" + "Verifies Change password Validations")
	public void testAdminChangePasswordFunctionality() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		MyProfileChangePwd changePwdPage=myProfilePage.clickChangePwd();
		changePwdPage.verifyCancelYesFunctionality();
		myProfilePage.clickChangePwd().verifyCancelNoFunctionality();
      	changePwdPage.savePwd();
     }
	
	@Test(priority=8,description="Verifies user is able to change his password successfully." + "<br" + "Verifies yes/no functinality while changing password" + "<br" + "Verifies Change password Validations")
	public void testAdminChangePwdValidations() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickMyProfileTab().clickChangePwd().verifyChangePwdValidations();
     }
	
	@Test(priority=9,description="Verifies Password guidelines text" + "<br>" + "Verifies Error messages on first name,last name, ph number, email address")
	public void testGenChangePasswordFunctionality() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		MyProfileChangePwd changePwdPage=myProfilePage.clickChangePwd().verifyPwdGuideLines();
		changePwdPage.verifyCancelYesFunctionality();
		myProfilePage.clickChangePwd();
		changePwdPage.verifyCancelNoFunctionality();
      	changePwdPage.savePwd();
     }
	
	
	//Verifies Manage Security Questions for Admin Provider User
	
	@Test(priority=10,description="My Profile_Page_Manage_Security_Questions Link for Admin Provider User")
	public void testAdminManageSecurityQuestions() throws InterruptedException, IOException
	 {
		
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage= registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		ManageSecurityQuestions securityQuestionsPage = myProfilePage.clickSecurityQuestions().fillSecurityQuestions();
		securityQuestionsPage.saveQuestion();
		securityQuestionsPage.verifySaveQuestionTxt();
		myProfilePage.clickSecurityQuestions().cancelNoQuestion().cancelYesQuestion().clickSecurityQuestions().saveQuestionDisabled();
	 }
	

	
	//Verifies Manage Security Questions for General Provider User
	
	@Test(priority=11,description="My Profile_Page_Manage_Security_Questions Link for General Provider User")
	public void testGenManageSecurityQuestions() throws InterruptedException, IOException
	 {
		
		String userType="PROV";
		String accessType="Gen";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage= registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		ManageSecurityQuestions securityQuestionsPage = myProfilePage.clickSecurityQuestions().fillSecurityQuestions();
		securityQuestionsPage.saveQuestion();
		securityQuestionsPage.verifySaveQuestionTxt().clickSecurityQuestions().cancelNoQuestion().cancelYesQuestion().clickSecurityQuestions().saveQuestionDisabled();
		
		
	 }
	
    //Verifies Change Pwd for Payer User
	
	@Test(priority=12,description="My Profile_Page_Change Password Link for Payer User")
	public void testPayerChangePasswordFunctionality() throws InterruptedException, IOException
	 {
		String userType="PAY";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		MyProfile myProfilePage=home.clickMyProfileTab();
		MyProfileChangePwd changePwdPage=myProfilePage.clickChangePwd().verifyChangePwdValidations().verifyPwdGuideLines();
		changePwdPage.verifyCancelYesFunctionality();
		myProfilePage.clickChangePwd();
		changePwdPage.verifyCancelNoFunctionality();
      	changePwdPage.savePwd();
		
     }
	
	//Verifies Change Pwd for Billing Service User
	
	@Test(priority=13,description="My Profile_Page_Change Password Link for Billing Service User")
	public void testBSChangePasswordFunctionality() throws InterruptedException, IOException
	 {
		String userType="BS";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		MyProfile myProfilePage=home.clickMyProfileTab();
		MyProfileChangePwd changePwdPage=myProfilePage.clickChangePwd();
		changePwdPage.verifyCancelYesFunctionality();
		myProfilePage.clickChangePwd();
		changePwdPage.verifyCancelNoFunctionality();
      	changePwdPage.savePwd();
		changePwdPage.verifyChangePwdValidations();	
     }
	
	
	
	
	

 }