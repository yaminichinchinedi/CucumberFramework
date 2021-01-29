#Author: Amit Kushwah
@CreateEnrollment @US1348624 @BothCSRUPAScenarios @UPARegression @UPACreateEnrollment
Feature: Create Enrollment - Review and Submit -edit Organization Information

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
#TS01#TS02#TS011
@UPASanity
  Scenario: Fills the relevent Info with BS Enroll Typ
   Then Select Enrollment Type as BS
	 Then Verify option to Select TIN/SSN is there and input box is present.
	 And Verify Change Link is Present for BS.
	 
#TS04#TS05#TS011
@UPASanity
  Scenario: Fills the relevent Info with BS Enroll Typ
   Then Select Enrollment Type as BS
	 Then Click Cancel Enrollment button and Verify its functionality.
	 
#TS06-TS09#TS011
  Scenario: Fills the relevent Info with BS Enroll Typ
   Then Select Enrollment Type as BS
   Then Enter Incorrect Tin and Verify Error msgs.
   
#TS03
  Scenario: Fills the relevent Info with BS Enroll Typ
   Then Select Enrollment Type as BS
	 Then Click Cancel Enrollment button and Verify its content.
	 
	 
	 
#TS10 - Run all these test cases on Mozilla browser, as we dont have that browser so this cannot be completed.