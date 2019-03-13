package test.java;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.MaintainEnrollment;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SplashPage3;
import main.java.pageObjects.UPARegistrationPage;

import org.testng.annotations.Test;

public class TestUPAHomeTab extends TestBase {
	
	
	
	@Test(priority=5,description="Verifies functionality for Resources Links for Admin User")
	public void testUPALoginAdminResourcesLink() throws IOException, InterruptedException 
     {
		String userType="PROV";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.VerifyResourcesLinks();
	    home.logOutFromUPA();     
     }
	
	@Test(priority=5,description="Verifies functionality for Resources Links for General User")
	public void testUPALoginGeneralResourcesLink() throws IOException, InterruptedException 
     {
		String userType="PROV";
		String accessType="Gen";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.VerifyResourcesLinks();
	    home.logOutFromUPA(); 
     }
	
	
	
	@Test(priority=6,description="Verifies News and info section after provider is logged in for Admin users")
	public void testUPAAdminHomeNewsAndInformation() throws InterruptedException, IOException 
     {
		String userType="PROV";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.verifyWelcomeScreen();
	    home.verifyNewsSectionIsDisplayed();
	    home.VerifyAllTabsAreDisplayedAfterSelectingTin(accessType);
	    home.logOutFromUPA();
     }
	
	
	
	@Test(priority=6,description="Verifies News and info section after provider is logged in for General users")
	public void testUPAGeneralHomeNewsAndInformation() throws InterruptedException, IOException 
     {
		String userType="PROV";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.verifyWelcomeScreen();
	    home.verifyNewsSectionIsDisplayed();
	    home.VerifyAllTabsAreDisplayedAfterSelectingTin(accessType);
     }
	
	
	
	/*@Test(priority=7,description="Verifies Terms and conditions")
	public void testTermAndConditions() throws IOException 
     {   
	    String userType="PROV";
		String accessType="Admin";
	    
		testConfig.putRunTimeProperty("userType", userType);
		testConfig.putRunTimeProperty("accessType", accessType);
		
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	    
	    optumIDLoginPage.fillCredsAndSignIn("","").verifyTermsConditionsPage();
	   
     }
	
	
	
	@Test(priority=7,description="Verifies Login validations negative scenarios")
	public void testUPALoginValidations() throws IOException 
     {   
	   int excelRowNo=4;
	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	   OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
	   
	   //Correct UserName and incorrect Password
	   optumIDLoginPage.doInvalidLoginAndVerifyValidation(excelRowNo);  
      
       excelRowNo=5;
       //Incorrect username and correct Password
       optumIDLoginPage.doInvalidLoginAndVerifyValidation(excelRowNo); 
      }*/
	
	
	
	@Test(priority=7,description="Verifies Provider_TIN_Selection_Dropdown for Admin")
	public void testUPAAdminTinDropdown() throws IOException, InterruptedException, ParseException 
    {   
		String userType="PROV";
		String accessType="Admin";

		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
	    home.verifyWelcomeScreen().verifyAssociatedTins();
	    home.selectTin();
	    home.clickMaintainEnrollmentTab().verifyOrgBankAccountInfo().verifyOrgInfoOfSelectedTin();	 
	  }
	
	
	
	
	/*
	 * Ask Prashant about General functionality, he is not able to see bank info
	 */
//	@Test(priority=7,description="Verifies Provider_TIN_Selection_Dropdown for General Users")
//	 void testUPAGeneralTinDropdown() throws IOException, InterruptedException, ParseException 
//{   
//	   String userType="Provider";
//	   String accessType="Gen";
//	   UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//	   LoginUPA loginPage=new LoginUPA(testConfig);
//	   SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
//	   OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
//	   HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//	   home.verifyWelcomeScreen().verifyAssociatedTins();
//	   home.selectTin();
//	   home.clickMaintainEnrollmentTab().verifyOrgBankAccountInfo().verifyOrgInfoOfSelectedTin();	 
//}
}
