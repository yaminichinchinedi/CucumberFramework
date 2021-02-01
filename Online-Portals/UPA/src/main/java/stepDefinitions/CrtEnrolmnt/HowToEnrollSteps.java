
package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.nativeFunctions.Element;
import main.java.pageObjects.HowToEnroll;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.LoginUPA;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.SearchRemittance;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.UPAHomePage;
import main.java.pageObjects.UPARegistrationPage;

public class HowToEnrollSteps extends TestBase {
	HowToEnroll howtoEnroll=new HowToEnroll(testConfig);
		
	@Then("^User validates logo, Title, Enroll Now button,PDFs and Footer of this page$")
    public void user_validates_page_title() throws Throwable
    {
     howtoEnroll.verifyHowToEnrollPage();
    }
	
	@And("^User also validates the How to Enroll page content$")
	public void user_validates_howtoEnroll_Page() throws Throwable
    {
     howtoEnroll.verifyHowtoEnrollPara();
    }
	
	
}