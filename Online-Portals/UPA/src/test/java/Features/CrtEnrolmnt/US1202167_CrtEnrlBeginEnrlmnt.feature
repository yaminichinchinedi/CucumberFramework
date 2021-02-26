#Author: Rahul Krishna
@UPACreateEnrollment
Feature: Create Enrollment Home Page Validations 

Scenario Outline: US1202167_Create Enrollment Which option should i choose link
		Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
		Then User clicks on which option should i choose link,validates its content and close the opened popup
		Then User validates on Clicking on Change link,beside of Enrollment type
		#Then Select "<Enrollment Type>" and verifies popup content,and button fuctionality for Cancel and I Agree button 
		Then User clicks on Cancel Enrollment button and verify YES/NO button functionality
		
		Examples:
															|Enrollment Type|
															#|			AV				|
															|			VO				|
		
Scenario: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page VO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       VO       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.
    
 Scenario: Create Enrollment TIN Entry Error Message Validation
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    Then User clicks on which option should i choose link,validates its content and close the opened popup
	Then User validates on Clicking on Change link,beside of Enrollment type
    Then Select Enrollment Type as Enrollment Type and validates various messgaes by Entering null,less than 9 char,Alphanumeric char,Specia char in TIN
    										      | Enrollment Type |
										      |       AO       |

    Then User also validats captcha Error by turning ON and OFF captcha 

