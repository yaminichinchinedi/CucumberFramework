#Author: Rahul Krishna
@UPACreateEnrollment
Feature: Create Enrollment InactiveUnBlockedTIN TIN status Enrolled message 


  Scenario: Create Enrollment_BS_Review and Submit 
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User clicks on Continue button of BeginEnrollment Page
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page and Validate TIN enrolled message
											|Enrollment Type|
											|     BS        |


	Scenario Outline: US1350550_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" clicks Continue button and verify enrolledTIN Message and its content from DB 
    Examples:
										      | EnrollmentType |						TINStatus					  |
										      |       BS        | 				InactiveUnBlockedTIN		|
									      
   	Scenario Outline: US1350550_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    #Then Select "<Enrollment Type>" and "<TIN status>" clicks Continue button
    Then Select "<EnrollmentType>" and "<TINStatus>" clicks Continue button and verify enrolledTIN Message and its content from DB 
	Then User clicks and validates wNineform link of this page
	Then User validates Cancel Enrollment and Continue button presence
	When User clicks on Cancel Enromment button,verify its popup content and also YES/NO button functionality 
		Examples:
										      | EnrollmentType |						TINStatus					  |
										      |       BS        | 				InactiveUnBlockedTIN		|