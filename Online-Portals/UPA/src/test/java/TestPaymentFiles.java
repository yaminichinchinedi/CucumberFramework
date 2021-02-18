//package test.java;
//
//import java.io.IOException;
//
//import org.testng.annotations.Test;
//
//import main.java.nativeFunctions.TestBase;
//import main.java.pageObjects.HomePage;
//import main.java.pageObjects.ManageUsers;
//import main.java.pageObjects.OptumIdLoginPage;
//import main.java.pageObjects.PaymentDataFiles;
//import main.java.pageObjects.UPARegistrationPage;
//
//public class TestPaymentFiles extends TestBase {
//	
//	@Test(priority=4,description="Verifies Header Links functionality")
//	public void testPaymentDataCalendar() throws InterruptedException, IOException
//	 {
//		
//		String userType="PROV";
//		String accessType="Admin";
//		String date="19/08/2018";
//		String date1="21/08/2018";
//
//		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//		OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
//		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//		home.selectTin();
//		PaymentDataFiles paymentDataFiles=home.clickPaymentDataFilesTab().clickFromDateIcon().setDate(date).clickToDateIcon().setDate(date1);
//		paymentDataFiles.clickSubmit();
//		
//		
//		
//		//home.clickPaymentDataFilesTab().setFromDate(date);
//
//}
//	
//}
