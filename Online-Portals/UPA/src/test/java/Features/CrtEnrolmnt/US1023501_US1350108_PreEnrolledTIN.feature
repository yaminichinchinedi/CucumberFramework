
#Author: Rahul Krishna

Feature:Create Enrollment Home Page Validations 

 Scenario Outline: US1023501_Test Cases for PreEnrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    Then Select "<Enrollment Type>" and "<TIN status>" Clicks continue button of Enrollment TIN Eligible page and vaidate enrolledTINMsg
										      | Enrollment Type |						TIN Status							|
										      |       AO        | EnrolledPreEnrollmentStatusTIN		|
										      |       AO        | AutoEnrolledPreEnrollmentStatusTIN|
										      |       AO        | EnrolledInactiveAndBlockStatusTIN	|
										      |       AO        | EnrolledPreEnrollmentStatusTIN		|
										      |       AO        | EnrolledPreEnrollmentStatusTIN		|
										      
	
	
		Scenario Outline: US1350108_Test Cases for PreEnrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    Then Select "<Enrollment Type>" and "<TIN status>" clicks Continue button of Enrollment TIN Eligible page and vaidate enrolledTINMsg
										      | Enrollment Type |						TIN Status							|
										      |       AO        | 				TINNotEnrolled						|
										      |       AO        | 				InactiveUnBlockedTIN			|
										      |       VO        | 					TINNotEnrolled					|
				
		Scenario: US1350108_Test Cases for Not Enrolled Tin						      
		Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    Then Select Enrollment Type and TIN status,Clicks Cancel Enrollment verify text content,the click NO to be on the same page and Yes to Cancel the Enrollment
    										  | Enrollment Type |						TIN Status					|
										      |       AO        |         TINNotEnrolled		    |
				
		Scenario: US1350108_Test Cases for Not Enrolled Tin								      
			Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    Then Select Enrollment Type and TIN status then Clicks continue then,clicks on W9 form link on next page
										      | Enrollment Type |						TIN Status							|
										      |       AO        |					 TINNotEnrolled		        |			