//package test.java;
//
//import java.io.IOException;
//
//import main.java.nativeFunctions.TestBase;
//import main.java.pageObjects.AddUserDetails;
//import main.java.pageObjects.HomePage;
//import main.java.pageObjects.ManageUsers;
//import main.java.pageObjects.OptumIdLoginPage;
//import main.java.pageObjects.SplashPage3;
//import main.java.pageObjects.LoginUPA;
//import main.java.pageObjects.UPARegistrationPage;
//import main.java.pageObjects.paymentSummary;
//
//import org.testng.annotations.Test;
//
//	public class TestViewPayments extends TestBase {
//		
//		 @Test(priority=5,description="Verifies payment records for different tenure")
//		  void testUPAViewPaymentsSearchFilters() throws InterruptedException, IOException  
//		  {
//			   String filterPayments="Show All";
//			   String quickSearchFilter="Last 4-6 months";
//			  
//			   String userType="Provider";
//			   String accessType="Admin";
//					   
//			  UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
//			  LoginUPA loginPage=new LoginUPA(testConfig);
//			  SplashPage3 splashPage3=loginPage.doLogin(userType,accessType);
//			  OptumIdLoginPage optumIDLoginPage=splashPage3.clickSignInWithOptumId();
//			  HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
//			  home.selectTin();
//			  paymentSummary paymentSummaryPage= home.clickViewPaymentsTab().verifyDefaultStateOfFilters();
//			  paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
//			   
//			  quickSearchFilter="Last 90 days";
//			  paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
//			   
//			  quickSearchFilter="Last 30 days";
//			  paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);
//			   
//		      quickSearchFilter="Last 9-13 months";
//			  paymentSummaryPage.verifySearchResultsWithFilters(filterPayments, quickSearchFilter, filterPayments, filterPayments);	
//		}
//		
//		
//			
//	}
//	
