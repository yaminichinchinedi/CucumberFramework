package test.java;

import java.io.IOException;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.AddUserDetails;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.ManageUsers;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.UPARegistrationPage;

import org.testng.annotations.Test;

public class TestManageUsers extends TestBase {

//		@Test(priority=5,description="Verify details for New user.")
//		public void testCreatingNewUser() throws InterruptedException, IOException
//		 {
//			
//			String userType="Provider";
//			String accessType="Admin";
//			
//			String accessLevelOfNewUser="Administrator";
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			LoginUPA loginPage=new LoginUPA(testConfig);
//		    
//			SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
//			OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
//			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//			home.selectTin();
//			ManageUsers manageUser=home.clickManageUsersTab();
//			AddUserDetails addUserDetails=manageUser.addNewUser().fillNewUserInfo().selectAndAddTin().selectTinAccessLvl(accessLevelOfNewUser);
//			addUserDetails.clickSave();
//			addUserDetails.verifyDetailsOfNewUser();	
//			manageUser.removeFistTinInGrid();
//         }
			
		@Test(priority=1,description="Manage User_Existing User-verifies user list sorting")
		public void testUserListSorting() throws InterruptedException, IOException
		 {
			
			String userType="Provider";
			String accessType="Admin";

			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			LoginUPA loginPage=new LoginUPA(testConfig);
		    
			//Login with EPS credentials
			SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
			OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
			home.selectTin();
			ManageUsers manageUser=home.clickManageUsersTab();
			manageUser.doUserListSorting();
		}
		
		

		@Test(priority=3,description="Email_Add User_Manage User-Verifies error messages and associated tins with a user")
		public void testAddNewUserValidations() throws InterruptedException, IOException
		 {
			
			String userType="Provider";
			String accessType="Admin";
			
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			LoginUPA loginPage=new LoginUPA(testConfig);
		    
			SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
			OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
			home.selectTin();
			ManageUsers manageUser=home.clickManageUsersTab();
			AddUserDetails addUserDetails=manageUser.addNewUser();
			addUserDetails.verifyErrorMessages();		
           }
		
		
		@Test(priority=2,description="Verify Save and cancel access level changes")
		public void testChangesInExistingActiveUser() throws InterruptedException, IOException
		 {
			String userType="Provider";
			String accessType="Admin";
			
			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
			LoginUPA loginPage=new LoginUPA(testConfig);
		    
			SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
			OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
			home.selectTin();
			ManageUsers manageUser=home.clickManageUsersTab();
			manageUser.changeAndSaveAccessLevel().changeAndCancelAccessLevel();				
         }
		
//		@Test(priority=4,description="Verify Tin Grid Details")
//		public void testTinGridDetails() throws InterruptedException, IOException
//		 {
//			String userType="Provider";
//			String accessType="Admin";
//			
//			UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			LoginUPA loginPage=new LoginUPA(testConfig);
//		    
//			SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
//			OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
//			HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//			home.selectTin();
//			ManageUsers manageUser=home.clickManageUsersTab();
//			manageUser.verifyTinGridSorting();
//			manageUser.verifyManageUserUI();
//         }	
			
}

