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


public class TestMyProfileTab extends TestBase
 {


	@Test(priority=1,description="My Profile_Page_Change Password Link")
	public void testChangePasswordLink() throws InterruptedException, IOException
	 {
		
		String userType="Provider";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		LoginUPA loginPage=new LoginUPA(testConfig);
	    
		SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
		OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
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
		
		String userType="Provider";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		LoginUPA loginPage=new LoginUPA(testConfig);
	    
		SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
		OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		MyProfile myProfilePage=home.clickMyProfileTab();
		MyProfileChangePwd changePwdPage=myProfilePage.clickChangePwd();
		changePwdPage.verifyChangePwdValidations();
		
		
		
     }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 }

