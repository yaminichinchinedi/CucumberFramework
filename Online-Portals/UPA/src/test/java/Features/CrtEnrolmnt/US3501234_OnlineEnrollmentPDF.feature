#Author: Sai
Feature: UPA Online Erollment PDF
 @UPAUS3501234 @UPA2021_PI03_01
 Scenario: UPA Online enrollment PDF for AO tin
 Given User navigates to UPA Sys Test application
 When User Clicks on Enroll Now from the landing page
 Then User clicks on Continue button of BeginEnrollment Page
 Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
 Then User sets business phone
 Then User fills all the information  and click on Continue
 Then User fills all the information on Identify Administrators page and click continue
 Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
 Then User uploads the WNine form and click continue									      
 And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
 And Also click on Print Enrollment page,download PDF and validates all the information from PDF page


 @UPAUS3501234_VO @UPA2021_PI03_01
 Scenario: UPA Create Enrollment Terms and Conditions pdf for VO tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       VO        |
		Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
    
 #Author:Sai   
@UPAUS3563585_AO @UPA2021_PI03_04
 Scenario Outline: Fraud Prevention - Implement scrollbar for Orgname and address suggestions
 Given User navigates to UPA Sys Test application
 When User Clicks on Enroll Now from the landing page
 Then User clicks on Continue button of BeginEnrollment Page
 Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
 Then User fills "<BussinessName>" and "<streetName>" on organization information page
 
 Examples:
 
 |BussinessName|streetName|
 |MAYO CLINIC  |1216      |
 |KAISER			 |200       |

 
 @UPAUS3563585_VO @UPA2021_PI03_04
 Scenario Outline: Fraud Prevention - Implement scrollbar for Orgname and address suggestions
 Given User navigates to UPA Sys Test application
 When User Clicks on Enroll Now from the landing page
 Then User clicks on Continue button of BeginEnrollment Page
 Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       VO        |
	Then User fills "<BussinessName>" and "<streetName>" on organization information page		
	
 Examples:
 |BussinessName|streetName|
 |MAYO CLINIC  |1216      |
 |KAISER			 |200       |		      