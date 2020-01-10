package main.java.stepDefinitions.CrtEnrolmnt;

import cucumber.api.java.en.Then;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.EnrollmentSubmitted;

public class EnrollmentSubmittedSteps extends TestBase{
	
	EnrollmentSubmitted enrollmentSubmitted=new EnrollmentSubmitted(testConfig);
	
	@Then("^Validate Data is saved in Database on Enrollment Page\\.$")
	public void validate_Data_is_saved_in_Database_on_Enrollment_Page() throws Throwable {
		enrollmentSubmitted.validateEnrollmentInfo();
	}
}
