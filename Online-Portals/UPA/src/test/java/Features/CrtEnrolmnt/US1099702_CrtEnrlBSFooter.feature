#Author: Madhavi Upputuri
@CreateEnrollment @US1099702 @BothCSRUPAScenarios @UPARegression @UPACreateEnrollment
Feature: US1099702_Create Enrollment- Billing Service - Footer Information
  @UPASanity
  Scenario: TS01/TS02/TS03_Create Enrollment- Billing Service - Footer Information
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then Validate the Footer Information on this page 
	Then User clicks on Continue button of BeginEnrollment Page
  Then Validate the Footer Information on this page 
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
	Then Validate the Footer Information on this page 
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then Validate the Footer Information on this page 
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then Validate the Footer Information on this page 
  Then User uploads the WNine form and click continue
  Then Validate the Footer Information on this page 
