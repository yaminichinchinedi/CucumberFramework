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
import main.java.pageObjects.UPARegistrationPage;

import org.testng.annotations.Test;


public class TestUPAMyProfileTab extends TestBase
 {

	@Test(priority=1,description="Verifies Password guidelines text" + "<br>" + "Verifies user is able to change his password successfully." + "<br" + "Verifies yes/no functinality while changing password")
	public void testChangePasswordLink() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		MyProfileChangePwd changePwdPage=myProfilePage.clickChangePwd();
		changePwdPage.verifyPwdGuideLines();
		changePwdPage.verifyCancelYesFunctionality();
		myProfilePage.clickChangePwd();
		changePwdPage.verifyCancelNoFunctionality();
      	changePwdPage.savePwd();
     }
	
	@Test(priority=1,description="My Profile_Page_Change Password Link")
	public void testChangePasswordValidations() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		MyProfileChangePwd changePwdPage=myProfilePage.clickChangePwd();
		changePwdPage.verifyChangePwdValidations();	
     }

 }

