#Author: Rahul Krishna

@CreateEnrollment @US1048061 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment BS Enrollment Type to Identify Administrators page

  Scenario: US1033480_Create Enrollment- AO - Footer Information
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then Validate the Footer Information on this page 
  Then User Select a How you heard option and  click on Continue button
  Then Validate the Footer Information on this page 
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
		Then Validate the Footer Information on this page
		Then User fills all the information  and click on Continue
	  Then Validate the Footer Information on this page 
    Then User fills all the information on Identify Administrators page and click continue to W9
   	Then Validate the Footer Information on this page 
       #Need to check ABA Validator or Normal flow
    Then User fills all the information on Financial Institution Information page and click continue
    Then Validate the Footer Information on this page 
    Then User uploads the WNine form and click continue
    Then Validate the Footer Information on this page 
     And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    Then Validate the Footer Information on this page 
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then Validate the Footer Information on this page 
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then Validate the Footer Information on this page 
  Then User uploads the WNine form and click continue
  Then Validate the Footer Information on this page 	
  
  