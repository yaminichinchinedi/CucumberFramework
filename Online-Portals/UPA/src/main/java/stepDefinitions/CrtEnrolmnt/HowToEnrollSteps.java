
package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HowToEnroll;


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