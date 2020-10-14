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

public class TestUPAManageUsers extends TestBase {

	@Test(priority=1,description="Verifies user list sorting is working correctly on Manage Users Tab")
	public void testUserListSorting() throws InterruptedException, IOException
	 {
		
		String userType="PROV";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		ManageUsers manageUser=home.clickManageUsersTab();
		manageUser.doUserListSorting();
		home.logOutFromUPA();
	}
	
	
	@Test(priority=2,description="Verifies 'Save' & 'Cancel' button functionlity for 'Access level' changes for a Provider User")
	public void testChangesInExistingActiveUser() throws InterruptedException, IOException
	 {
		String userType="PROV";
		String accessType="Admin";
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin();
		ManageUsers manageUser=home.clickManageUsersTab();
		manageUser.changeAndVerifyAccLvlEmailNotify(userType);//.changeAndCancelAccessLevel(userType);		
		home.logOutFromUPA();
     }
		
		
	@Test(priority=3,description="Verifies Tin Grid Details in Manage Users Tab")
	public void testTinGridDetails() throws InterruptedException, IOException
	 {
		 String userType="PROV";
		 String accessType="Admin";
		 
		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		 home.selectTin();
		 ManageUsers manageUser=home.clickManageUsersTab();
		 manageUser.verifyTinGridSorting();
		 manageUser.verifyManageUserUI();
     }	

	
	@Test(priority=4,description="Verifies error messages and associated tins with a user")
	public void testProvUserValidations() throws InterruptedException, IOException
	 {
			
		 String userType="PROV";
		 String accessType="Admin";
		 
		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		 home.selectTin();
		 ManageUsers manageUser=home.clickManageUsersTab();
		 AddUserDetails addUserDetails=manageUser.clickAddNewUser();
		 addUserDetails.verifyErrorMessages();	
		 home.logOutFromUPA();
       }
	
	
	@Test(priority=5,description="Verifies provider user details are read only on UPA")
	public void testProvDetailsAreReadOnly() throws InterruptedException, IOException
	  {
		 String userType="PROV";
		 String accessType="Admin";
		 
		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		 home.selectTin();
		 ManageUsers manageUser=home.clickManageUsersTab();	
		 manageUser.verifyUserDetailsAreReadOnly(userType);
//		 manageUser.verifySuccessfulEmailNotificationChange(userType);	
		 home.logOutFromUPA();
       }	
		
		
//	@Test(priority=6,description="Verifies Billing service User details are read only on UPA")
//	public void testBSDetailsAreReadOnly() throws InterruptedException, IOException
//	  {
//		 String userType="BS";
//		 String accessType="Admin";
//		 
//		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		 ManageUsers manageUser=home.clickManageUsersTab();	
//		 manageUser.verifyUserDetailsAreReadOnly();
//		 manageUser.verifySuccessfulEmailNotificationChange(userType);
//		 manageUser.verifySuccessfulAssociateProvChange();
//		 manageUser.verifyAccessLvlChange(userType);
//		 home.logOutFromUPA();
//       }	
//
//		
	@Test(priority=7,description="Verifies details for New Billing Service user.")
	public void testAddNewBSUser() throws InterruptedException, IOException
	  {
		 String userType="BS";
		 String accessType="Admin";
			
		 String accessLevelOfNewUser="Administrator";
		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		 ManageUsers manageUser=home.clickManageUsersTab();
		 AddUserDetails addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser);
		 addUserDetails.clickSave();
		 addUserDetails.verifyDetailsOfNewUser(userType);	
		 //manageUser.removeFistTinInGrid();
       }
		

	@Test(priority=8,description="Verifies Payer user details are read only on UPA")
	public void testPayerDetailsAreReadOnly() throws InterruptedException, IOException
	  {
		 String userType="PAY";
		 String accessType="Admin";
			
		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		 ManageUsers manageUser=home.clickManageUsersTab();
		 manageUser.verifyPayerUserDetailsAreReadOnly();
		 manageUser.verifyAccessLvlChange(userType);	
		 home.logOutFromUPA();
       }	
		
	
	@Test(priority=9,description="Verifies details for New Payer user.")
	public void testAddNewPayerUser() throws InterruptedException, IOException
	  {
		 String userType="PAY";
		 String accessType="Admin";
		 String accessLevelOfNewUser="Administrator";
			
		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		 ManageUsers manageUser=home.clickManageUsersTab();
		 AddUserDetails addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser);
		 addUserDetails.clickSave();
		 addUserDetails.verifyDetailsOfNewUser(userType);
		 home.logOutFromUPA();
		//manageUser.removeFistTinInGrid();
      }
		
		
	@Test(priority=10,description="Verifies details for New Provider user.")
	public void testAddNewProviderUser() throws InterruptedException, IOException
	  {
			
		 String userType="PROV";
		 String accessType="Admin";
		 String accessLevelOfNewUser="Administrator";
			
		 UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		 OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		 HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		 home.selectTin();
		 ManageUsers manageUser=home.clickManageUsersTab();
		 AddUserDetails addUserDetails=manageUser.clickAddNewUser().fillNewUserInfo().selectAndAddTin().selectTinAccessLvl(accessLevelOfNewUser);
		 addUserDetails.clickSave();
		 addUserDetails.verifyDetailsOfNewUser(userType);	
		 manageUser.removeFistTinInGrid();
		 home.logOutFromUPA();
      }
		
}



