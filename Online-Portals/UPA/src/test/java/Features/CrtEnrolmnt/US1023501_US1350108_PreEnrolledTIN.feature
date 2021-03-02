#Author: Rahul Krishna
@UPACreateEnrollment
Feature: Create Enrollment Home Page Validations 

 Scenario Outline: US1023501_Test Cases for PreEnrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" Clicks continue button of Enrollment TIN Eligible page and vaidate enrolledTINMsg
    Examples:
										      | EnrollmentType  |		TINStatus				|
										      |       AO        | EnrolledPreEnrollmentStatusTIN	|
										      |       AO        | AutoEnrolledPreEnrollmentStatusTIN|
										      |       AO        | EnrolledInactiveAndBlockStatusTIN	|
										      |       AO        | EnrolledActiveStatusTIN		|
										      
	
Scenario Outline: US1350108_Test Cases for PreEnrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" Clicks continue button of Enrollment TIN Eligible page and vaidate enrolledTINMsg
    Examples:
										      | EnrollmentType  |						TINStatus					|
										      |       AO        | 				TINNotEnrolled						|
										      |       AO        | 				InactiveUnBlockedTIN		    	|
										      |       VO        | 					TINNotEnrolled					|
				
	Scenario Outline: US1350108_Test Cases for Not Enrolled Tin						      
		Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>",Clicks Cancel Enrollment verify text content,the click NO to be on the same page and Yes to Cancel the Enrollment
    Examples:
    										  | EnrollmentType  |		TINStatus					|
										      |       AO        |         TINNotEnrolled		    |
				
		Scenario Outline: US1350108_Test Cases for Not Enrolled Tin								      
			Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" then Clicks continue then,clicks on W9 form link on next page
		Examples:
										      | EnrollmentType |				TINStatus						|
										      |       AO        |					 TINNotEnrolled		        |			

