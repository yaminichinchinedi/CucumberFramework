#Author: Madhavi Upputuri
@CreateEnrollment @US1048094
Feature: US1048094_Create Enrollment- Billing Service - Review and Submit

  Background: Create Enrollment_BS_Review and Submit 
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
																				
  Scenario: TS01/TS02_Create Enrollment_BS_Review and Submit page_Header
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Vaidates Headers in Review and Submit page

  Scenario: TS03_Create Enrollment_BS_Review and Submit page_Edit button
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Vaidates Edit Links on Review and Submit page
  
  Scenario: TS04_Create Enrollment_BS_Review and Submit page_T&C
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Vaidates Terms and condition Pdf download
  
  Scenario: TS05_Create Enrollment_BS_Review and Submit page_Authorized Enroller
   
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  Then User validates Authorized Enroller Information fields.
  
  Scenario: TS06_Create Enrollment_BS_Review and Submit page_T&C_Submit Enabled
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Validates Submit button is enabled when Terms & conditions is clicked
  
  Scenario: TS07_Create Enrollment_BS_Review and Submit page_Cancel_Back_Submit buttons
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Validates Cancel Enrollment, Back and Submit Enrollment options display
  
  Scenario: TS08_Create Enrollment_BS_Review and Submit page_Back functionality
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Validates Back button functionality
  
  Scenario: TS09/TS010/TS011_Create Enrollment_BS_Review and Submit page_Cancel Enrollment Popup

  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  Then Validate Cancel Enrollment popup
  
  Scenario: TS25_Create Enrollment_BS_Review and Submit page_Confirm Data
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  #And Validates the Data saved in Database on submit of Enrollment
  Then  Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
  And  Validate Data is saved in Database on Enrollment Page.
  
  Scenario: TS012/TS013/TS014_Create Enrollment_BS_Review and Submit page_Error Messaging_Hyperlink Display
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Validates Error Messages on Review and Submit Page
  
  Scenario: TS015-TS020_Create Enrollment_BS_Review and Submit page_Error Messaging_First Name_Last Name_Telephone_No Data
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Validates Invalid Data Error Messages on Review and Submit Page
  
  Scenario: TS021-TS024_Create Enrollment_BS_Review and Submit page_Error Messaging_Email_Invalid Data
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And Validates Invalid Data Error Messages for Email Address on Review and Submit Page
  