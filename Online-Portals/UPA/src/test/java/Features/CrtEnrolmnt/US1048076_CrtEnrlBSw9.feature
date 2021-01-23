#Author: Rahul Krishna
@UPACreateEnrollment
Feature: Create Enrollment BS upload w9 page validations

		
  Scenario: US1048076_Create Enrollment_BS_upload w9 validations
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Upload w9 page and validate its headers

  
  
   Scenario: US1048076_Create Enrollment_BS_upload w9 validations
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User Validates Back,Cancel Enrollment and Continue button presence and its functionality on upload w9 page
  When User clicks on back button it navigates to Identify Admin Page
  Then User click on Cancel Enrollment verifies its popup content and YES/NO button functionality  
  Then User clicks on link Federal W9 Form here,validates its content 