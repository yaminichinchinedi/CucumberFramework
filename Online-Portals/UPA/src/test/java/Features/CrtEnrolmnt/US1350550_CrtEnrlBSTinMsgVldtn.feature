
#Author: Rahul Krishna

Feature: Create Enrollment InactiveUnBlockedTIN TIN status Enrolled message 


  Scenario: Create Enrollment_BS_Review and Submit 
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page and Validate TIN enrolled message
											|Enrollment Type|
											|     BS        |


	Scenario Outline: US1350550_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    Then Select "<Enrollment Type>" and "<TIN status>" clicks Continue button and verify enrolledTIN Message and its content from DB 
										      | Enrollment Type |						TIN Status					  |
										      |       BS        | 				InactiveUnBlockedTIN		|
										      
   	Scenario Outline: US1350550_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    Then Select "<Enrollment Type>" and "<TIN status>" clicks Continue button
		Then User clicks and validates  w9form link of this page 
		Then User validates Cancel Enrollment and Continue button presence
		When User clicks on Cancel Enromment button,verify its popup content and also YES/NO button functionality 
										      | Enrollment Type |						TIN Status					  |
										      |       BS        | 				InactiveUnBlockedTIN		|