@US1253068
Feature: US1253068_Create Enrollment- Review and Submit - show the page and test buttons edit- remove not tested QA

  Background: Create Enrollment_HO_Review and Submit 
 
  Given User navigates to UPA Sys application
  When User Clicks on Enroll Now button
  Then User Selects How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     VO        |
	@TC1									
	Scenario: TS01/TS02_Create Enrollment_HO_Review and Submit page
	
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Vaidate Headers in Review and Submit page 
  
  @TC2
  Scenario: TS03_Create Enrollment_HO_Review and Submit page_Edit button
	
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Vaidate Edit Links on Review and Submit page 
  
  @TC3
  Scenario: TS04_Create Enrollment_HO_Review and Submit page_T&C
	
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Vaidate Terms and condition Pdf download
  
  @TC4
  Scenario: TS05_Create Enrollment_HO_Review and Submit page_Authorized Enroller
	
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then User validates Authorized Enroller Information fields. 
  
   @TC5
  Scenario: TS06_Create Enrollment_HO_Review and Submit page_T&C_Submit Enabled
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate Submit button is enabled when Terms & conditions is clicked
  
   @TC6
  Scenario: TS07_Create Enrollment_HO_Review and Submit page_Cancel_Back_Submit buttons
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate Cancel Enrollment, Back and Submit Enrollment options display
  
  @TC7
  Scenario: TS08_Create Enrollment_HO_Review and Submit page_Back functionality
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate Back button functionality
  
  @TC8
  Scenario: TS09/TS010/TS011_Create Enrollment_HO_Review and Submit page_Cancel Enrollment Popup
  # need to verify again
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate Cancel Enrollment popup 
  
  @TC9
  Scenario: TS012/TS013/TS014_Create Enrollment_HO_Review and Submit page_Error Messaging_Hyperlink Display
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate Error Messages on Review and Submit Page
  
  @TC10
  Scenario: TS015-TS020_Create Enrollment_HO_Review and Submit page_Error Messaging_Hyperlink Display
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate Invalid Data Error Messages on Review and Submit Page
  
  @TC11
  Scenario: TS021-TS024_Create Enrollment_HO_Review and Submit page_Error Messaging_Email_No Data
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate Invalid Data Error Messages for Email Address on Review and Submit Page
  
  
  @TC12
  Scenario: TS25_Create Enrollment_HO_Review and Submit page_Confirm Data
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then Validate the Data saved in Database on submit of Enrollment