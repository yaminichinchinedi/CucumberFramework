package test.java;
import java.awt.AWTException;
import java.io.IOException;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.AddUserDetails;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.ManageUsers;
import main.java.pageObjects.SearchTinPage;

import org.testng.annotations.Test;

	public class TestCSRManageUsers extends TestBase {
		

	@Test(priority=5,description="Super user role verification")
	public void testSuperUserAddAndDeleteProvUser() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";
		
		
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().addTinCSR().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
		manageUsers.verifyDetailsOfNewUser(userType).approveNewUserFromCSR(userType).doResetPassword().updateDemoInfo(userType).deleteAndVerifyUserIsDeleted();

      }

	
	@Test(priority=5,description="Super user role verification")
	public void testSuperUserAddAndDeleteBillingUser() throws InterruptedException, IOException
	 {
		String loginUserType="Super";
		String userType="BS";	
		String accessLevelOfNewUser="Administrator";
				
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
		manageUsers.verifyDetailsOfNewUser(userType).approveNewUserFromCSR(userType).doResetPassword().updateDemoInfo(userType).deleteAndVerifyUserIsDeleted();

      }
	

	@Test(priority=5,description="Super user role verification")
	public void testSuperUserAddAndDeletePayerUser() throws InterruptedException, IOException
	 {
		String loginUserType="Super";
		String userType="PAY";	
		String accessLevelOfNewUser="Administrator";
				
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
		manageUsers.verifyDetailsOfNewUser(userType).approveNewUserFromCSR(userType).doResetPassword().updateDemoInfo(userType).deleteAndVerifyUserIsDeleted();

      }

}
