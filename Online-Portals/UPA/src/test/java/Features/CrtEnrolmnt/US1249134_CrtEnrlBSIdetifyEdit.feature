#Author: Madhavi Upputuri
@US1249134
Feature: US1249134_Create Enrollment- Billing Service Identify Administrators Review and Submit

  Background: Create Enrollment_BS_Review and Submit 
 
   Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
    
  Scenario: TS001/TS004_Create Enrollment_BS_Review and Submit - edit Identify Administrators_Edit option
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  Then User navigates to ReviewAndSubmit page and click on edit icon
  Then User navigates to Organization information page and validate fields are editable
  
  Scenario: TS005_Create Enrollment_BS_Review and Submit - edit Identify Administrators_Cancel and Save Changes
   
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  Then User navigates to ReviewAndSubmit page and click on edit icon
  And Validates only Cancel and Save Changes options are displayed on  Identify Administrators page
  
  Scenario: TS006_Create Enrollment_HO_Review and Submit - edit Organization Information_Cancel Changes
    
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  Then User navigates to ReviewAndSubmit page and click on edit icon
  Then User clicks on cancel button and return to Review and Submit Page.
  And validates no changes are saved for Identify Admin Section on Review and Submit Page.
    
  Scenario: TS007_Validate all the headers from the Identify Administrators page
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  Then User navigates to ReviewAndSubmit page and click on edit icon
  And  Validates all the headers from the Identify Administrators page
   
  #Scenario: TS002_Validate that Identify Administrators page content matches to UXDS html
  
  #Then User navigates to Billing service information page and fill all fields and click on continue button
  #Then User navigates to Identity Administrators page and fill all fields and click on continue button
  #Then User uploads the WNine form and click continue
  #Then User navigates to ReviewAndSubmit page and click on edit icon
  #And Validates page content matches to UXDS html 
   
   Scenario: TS003_Validate that Identify Administrators page text is content managed
   
   Then User navigates to Billing service information page and fill all fields and click on continue button
   Then User navigates to Identity Administrators page and fill all fields and click on continue button
   Then User uploads the WNine form and click continue
   Then User navigates to ReviewAndSubmit page and click on edit icon
   And  Validates page text is content managed 
     @Rerun1
   Scenario: TS008_Validate form and error messaging on click of Save Changes button
     
   Then User navigates to Billing service information page and fill all fields and click on continue button
   Then User navigates to Identity Administrators page and fill all fields and click on continue button
   Then User uploads the WNine form and click continue
   Then User navigates to ReviewAndSubmit page and click on edit icon
   Then Click on Save changes/Continue button and validate Form and error messages
 @Rerun1
   Scenario: TS009_Validate Error hyperlink on click of Save Changes
  
   Then User navigates to Billing service information page and fill all fields and click on continue button
   Then User navigates to Identity Administrators page and fill all fields and click on continue button
   Then User uploads the WNine form and click continue
   Then User navigates to ReviewAndSubmit page and click on edit icon
   Then Click on Save changes/Continue button and Validate Error hyperlinks 
     
   Scenario: TS010_Validate error message Missing Data for both Primary & Secondary Admin fields
    
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Click on save changes button and Validate Error message for both Primary and Secondary Admin Fields

   Scenario: TS011_Validate error message Invali Data for Telephone Number for both Primary & Secondary Admin

    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Enter invalid data for Primary Admin and validate error message
    Then Enter invalid data for Secondary Admin and validate error message
     
   Scenario: TS012/TS013 Validate error message Invali Data for Email and retype email Address for both Primary & Secondary Admin
    
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User uploads the WNine form and click continue
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then Enter invalid email  address for Primary and Secondary Admin and validate error message
     Then Enter invalid Retype email address for Primary and Secondary Admin and validate error message
    
   Scenario: TS014_Validate Text alert indicator for Mobile Number for both Primary & Secondary Admin
   
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User uploads the WNine form and click continue
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then Enter mobile number for Primary Admin and validate Text alert checkbox
      
   Scenario: TS015_Validate Learn about alert frequency for both Primary & Secondary Admin
     
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User uploads the WNine form and click continue
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then Click on Learn about alert frquency for both Primary and secondary admin and validate the popup
      
   Scenario: TS016_Validate upon clicking Save Changes new information is saved and displayed on Review and Submit page
      
      Then User navigates to Billing service information page and fill all fields and click on continue button
      Then User navigates to Identity Administrators page and fill all fields and click on continue button
      Then User uploads the WNine form and click continue
      Then User navigates to ReviewAndSubmit page and click on edit icon
      And Fills new information and click on save changes
      And Validate changes are reflected on Review and Submit Page
      
   Scenario: TS017_Validate Cancel button disabled functionality in case errors are seen on Identify Admin page
   
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User uploads the WNine form and click continue
     Then User navigates to ReviewAndSubmit page and click on edit icon
     And Validates Cancel button is disabled in case errors are seen on Identify Admin page  
      
   Scenario: TS018_Validate that the Clear Administrator Information field is hidden when editing the administrator Information.
     
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User uploads the WNine form and click continue
     Then User navigates to ReviewAndSubmit page and click on edit icon
     And Validates Clear Administrator Information field is hidden when editing the administrator Information
       