#Author: Rahul Krishna

@CreateEnrollment @US1048061 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment BS Enrollment Type to Identify Administrators page

  Scenario Outline: US1033480_Create Enrollment- AO - Footer Information
 
 When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		  Then Validate the Footer Information on this page 
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		  Then Validate the Footer Information on this page 
		Then User select Yes button of TIN not enrolled page
		  Then Validate the Footer Information on this page 
		Then User select User Type Enrollment as "AO" and click continue button 
		  Then Validate the Footer Information on this page 
		Then User fills all the information  and click on Continue
	  Then Validate the Footer Information on this page 
    Then User fills all the information on Identify Administrators page and click continue to W9
   	Then Validate the Footer Information on this page 
       #Need to check ABA Validator or Normal flow
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
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
   Examples:

         |   credentials     |
         |    Super          |
  