package test.java;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.AddUserDetails;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.ManageUsers;
import main.java.pageObjects.SearchTinPage;

import org.testng.annotations.Test;

	public class TestCSRManageUsers extends TestBase {
		


//	@Test(priority=5,description="Super user role verification ..")
//	public void testSuperUserAddAndDeleteProvUser() throws InterruptedException, IOException, AWTException
//	 {
//		String loginUserType="Super";
//		String userType="PROV";	
//		String accessLevelOfNewUser="Administrator";
//	
//		LoginCSR loginPage=new LoginCSR(testConfig);
//		CSRHomePage homePage=loginPage.doLogin(loginUserType);
//		SearchTinPage searchPage=homePage.clickManageUsersLink();
//		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().addTinCSR().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
//		manageUsers.verifyDetailsOfNewUser(userType).approveNewUserFromCSR(userType).doResetPassword().updateDemoInfo(userType).deleteAndVerifyUserIsDeleted();
//
//      }
	
	
	@Test(priority=5,description="Super user role verification ..")
	public void testSuperUserAddAndDeleteProvUser() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";
	
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().addTinCSR().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
		manageUsers.verifyDetailsOfNewUser(userType).deleteAndVerifyUserIsDeleted();

      }

	
//	@Test(priority=5,description="Super user role verification")
//	public void testSuperUserAddAndDeleteBillingUser() throws InterruptedException, IOException
//	 {
//		String loginUserType="Super";
//		String userType="BS";	
//		String accessLevelOfNewUser="Administrator";
//				
//		LoginCSR loginPage=new LoginCSR(testConfig);
//		CSRHomePage homePage=loginPage.doLogin(loginUserType);
//		SearchTinPage searchPage=homePage.clickManageUsersLink();
//		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
//		manageUsers.verifyDetailsOfNewUser(userType).approveNewUserFromCSR(userType).doResetPassword().updateDemoInfo(userType).deleteAndVerifyUserIsDeleted();
//
//      }
	
	
	
//	@Test(priority=5,description="Super user role verification")
//	public void testSuperUserAddAndDeleteBillingUser() throws InterruptedException, IOException
//	 {
//		String loginUserType="Super";
//		String userType="BS";	
//		String accessLevelOfNewUser="Administrator";
//				
//		LoginCSR loginPage=new LoginCSR(testConfig);
//		CSRHomePage homePage=loginPage.doLogin(loginUserType);
//		SearchTinPage searchPage=homePage.clickManageUsersLink();
//		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
//		manageUsers.verifyDetailsOfNewUser(userType).approveNewUserFromCSR(userType).doResetPassword().updateDemoInfo(userType).deleteAndVerifyUserIsDeleted();
//
//      }
	
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
		manageUsers.verifyDetailsOfNewUser(userType).deleteAndVerifyUserIsDeleted();

      }
	

//	@Test(priority=5,description="Super user role verification")
//	public void testSuperUserAddAndDeletePayerUser() throws InterruptedException, IOException
//	 {
//		String loginUserType="Super";
//		String userType="PAY";	
//		String accessLevelOfNewUser="Administrator";
//				
//		LoginCSR loginPage=new LoginCSR(testConfig);
//		CSRHomePage homePage=loginPage.doLogin(loginUserType);
//		SearchTinPage searchPage=homePage.clickManageUsersLink();
//		ManageUsers manageUsers=searchPage.doSearch(userType).clickAddNewUser().fillNewUserInfo().selectTinAccessLvl(accessLevelOfNewUser).clickSave();
//		manageUsers.verifyDetailsOfNewUser(userType).approveNewUserFromCSR(userType).doResetPassword().updateDemoInfo(userType).deleteAndVerifyUserIsDeleted();
//
//      }
	
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
		manageUsers.verifyDetailsOfNewUser(userType).deleteAndVerifyUserIsDeleted();

      }

	
	@Test(priority=5,description="Verifies if a tin has only one active admin , access level dropdown, email check box & remove tin/npi checkbox is disabled")
	public void testDisabledGridForActiveAdmin() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String disabledValue="true";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
		searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);

      }
	
	@Test(priority=5,description="Verifies if a tin has only one active admin , access level dropdown, email check box & remove tin/npi checkbox is disabled after modifying the Email address of user with existing email address")
	public void testDisabledGridOnEmailChange() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String disabledValue="true";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
		ManageUsers manageUsers=searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);
		manageUsers.editEmailWithExistingAdress().verifyDisabledItemsForTin(tinNo,disabledValue);
      }
	
	@Test(priority=5,description="Verifies if a tin has only one active admin , access level dropdown, email check box & remove tin/npi checkbox is disabled after modifying the First name of user with both valid and invalid data")
	public void testDisabledGridOnFirstNameChange() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String disabledValue="true";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
		ManageUsers manageUsers=searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);
		manageUsers.editFirstName("abc").verifyDisabledItemsForTin(tinNo,disabledValue);
		manageUsers.editFirstName("abc%()").verifyDisabledItemsForTin(tinNo,disabledValue);
      }
	
	@Test(priority=5,description="Verifies if a tin has only one active admin , access level dropdown, email check box & remove tin/npi checkbox is disabled after modifying the Last name of user with both valid and invalid data")
	public void testDisabledGridOnLastNameChange() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String disabledValue="true";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
		ManageUsers manageUsers=searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username"));
		manageUsers.editLastName("abc").verifyDisabledItemsForTin(tinNo,disabledValue);
		manageUsers.editLastName("abc%()").verifyDisabledItemsForTin(tinNo,disabledValue);
      }
	
	
	@Test(priority=5,description="Verifies if a tin has more than one active admin , access level dropdown, email check box & remove tin/npi checkbox is enabled")
	public void testEnabledGridForMoreThanOneActiveAdmin() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String disabledValue="false";
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		String tinNo=searchPage.selectUserType(userType).enterTin("tinWithMoreThanOneActiveAdmin");
		searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);
		
      }
	
	@Test(priority=5,description=" 1. Verifies access level,email and npi/tin checkbox remains disabled for a user who is the only active admin for a tin when gets associated with another new tin" + "<br>" + "2. Verifies if the new tin is removed then also these items access level etc remains disabled for the only active admin tin")
	public void testDisabledGridOnOtherTinGridChange() throws InterruptedException, IOException, AWTException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String disabledValue="true";
		int sqlNo=47;
		
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPage searchPage=homePage.clickManageUsersLink();
		String tinNo=searchPage.selectUserType(userType).enterTin("tinWithOneActiveAdmin");
		ManageUsers manageUsers=searchPage.clickSearch().clickSpecificUserName(testConfig.getRunTimeProperty("username")).verifyDisabledItemsForTin(tinNo,disabledValue);
		String newTinAdded=manageUsers.addTinCSR(sqlNo);
		manageUsers.verifyDisabledItemsForTin(tinNo, disabledValue).selectAccessLvl("Administrator",newTinAdded).clickSave().removeTinNpi(newTinAdded).verifyDisabledItemsForTin(tinNo,disabledValue);
      }
	
	
}
