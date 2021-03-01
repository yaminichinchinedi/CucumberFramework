#Author: Rahul Krishna
Feature: Create Enrollment Home Page Validations 	
		@UPAUS3025921
		Scenario: US3025921_Create Enrollment Before You begin Enrollment
		Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Validates all the UI content with database for BeginEnrollment Page
    
   
   @UPAUS3024872 
    Scenario: ABA Validator - Financial Institution Page RTN No Title message
    When  ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    Then Users clears the RTN No fill the new RTN No and validate the details and click on Save changes button
    And Validate the changes are reflected on Review and Submit Page.  
    

         
    
         