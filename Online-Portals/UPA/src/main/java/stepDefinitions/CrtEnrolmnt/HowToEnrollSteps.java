
package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.Footer;
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
	
	@And("^User validates Enroll Now button,PDFs for AO,BS and VO,and Footer of this page$")
	public void User_validates_Enroll_Now_buttonPDFs_for_AOBS_and_VOand_Footer_of_this_page() throws Throwable
    {
     howtoEnroll.verifyHowToEnrollpage();
 	 new Footer(testConfig).validateFooterContents(testConfig);
    }
	
	@And("^User also validates the How to Enroll page content with database$")
	public void User_also_validates_the_How_to_Enroll_page_content_with_database() throws Throwable
    {
     howtoEnroll.verifyHowToEnrollpageWithDataBase();
 	 
    }
	
	@And("^User Clicks on Enroll Now button and navigates to BeginEnrollment Page$")
	public void User_Clicks_on_Enroll_Now_button_and_navigates_to_BeginEnrollment_Page() throws Throwable
    {
     howtoEnroll.navigateToBegineEnrollpage();
 	 
    }
	
	
}