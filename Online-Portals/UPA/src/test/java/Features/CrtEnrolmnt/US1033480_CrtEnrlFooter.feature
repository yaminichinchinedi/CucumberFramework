#Author: Rahul Krishna
@CreateEnrollment @US1048061 @BothCSRUPAScenarios @UPARegression @UPACreateEnrollment
Feature: Create Enrollment BS Enrollment Type to Identify Administrators page

  Scenario: US1033480_Create Enrollment- AO - Footer Information
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then Validate the Footer Information on this page 
  	Then User clicks on Continue button of BeginEnrollment Page
  Then Validate the Footer Information on this page 
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
		Then Validate the Footer Information on this page
		Then User fills all the information  and click on Continue
	  Then Validate the Footer Information on this page 
	Then User fills all the information on Identify Administrators page and click continue
   	Then Validate the Footer Information on this page 
       #Need to check ABA Validator or Normal flow
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue 
      Then Validate the Footer Information on this page 
    Then User uploads the WNine form and click continue
    Then Validate the Footer Information on this page 
     And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    Then Validate the Footer Information on this page 
    
   Scenario: US1033480_Create Enrollment- BS - Footer Information
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then Validate the Footer Information on this page 
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then Validate the Footer Information on this page 
  Then User uploads the WNine form and click continue
  Then Validate the Footer Information on this page 	
  
  