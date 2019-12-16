
@US1249134
Feature: US1249134_Create Enrollment- Billing Service Identify Administrators Review and Submit

  Background: Create Enrollment_BS_Review and Submit 
 
  Given User navigates to UPA Sys application
  When User Clicks on Enroll Now button
  Then User Selects How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
    
  @Test2
  Scenario: TS001/TS004_Create Enrollment_BS_Review and Submit - edit Identify Administrators_Edit option
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then User navigates to ReviewAndSubmit page and click on edit icon
  Then User navigates to Organization information page and validate fields are editable
  
  @Test2
  Scenario: TS005_Create Enrollment_BS_Review and Submit - edit Identify Administrators_Cancel and Save Changes
   
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then User navigates to ReviewAndSubmit page and click on edit icon
  Then Validate only Cancel and Save Changes options are displayed on  Identify Administrators page
  
  @Test2
  Scenario: TS006_Create Enrollment_HO_Review and Submit - edit Organization Information_Cancel Changes
    
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then User navigates to ReviewAndSubmit page and click on edit icon
  Then  User clicks on cancel button and Validate no changes are saved and should return to Review and Submit page
    
  @Test2
  Scenario: TS007_Validate all the headers from the Identify Administrators page
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then User navigates to ReviewAndSubmit page and click on edit icon
  Then  Validate all the headers from the Identify Administrators page
   
   @Test2
  Scenario: TS002_Validate that Identify Administrators page content matches to UXDS html
  
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User navigates to Uploadw9 page and click on continue button
  Then User navigates to ReviewAndSubmit page and click on edit icon
  Then  Validate page content matches to UXDS html 
   
   @Test2 
   Scenario: TS003_Validate that Identify Administrators page text is content managed
   
   Then User navigates to Billing service information page and fill all fields and click on continue button
   Then User navigates to Identity Administrators page and fill all fields and click on continue button
   Then User navigates to Uploadw9 page and click on continue button
   Then User navigates to ReviewAndSubmit page and click on edit icon
   Then  Validate page text is content managed 
     
   @Test2
   Scenario: TS008_Validate form and error messaging on click of Save Changes button
     
   Then User navigates to Billing service information page and fill all fields and click on continue button
   Then User navigates to Identity Administrators page and fill all fields and click on continue button
   Then User navigates to Uploadw9 page and click on continue button
   Then User navigates to ReviewAndSubmit page and click on edit icon
   Then click on Save changes button and validate Form and error messages
 
   @Test2
   Scenario: TS009_Validate Error hyperlink on click of Save Changes
  
   Then User navigates to Billing service information page and fill all fields and click on continue button
   Then User navigates to Identity Administrators page and fill all fields and click on continue button
   Then User navigates to Uploadw9 page and click on continue button
   Then User navigates to ReviewAndSubmit page and click on edit icon
   Then click on save changes button and Validate Error hyperlinks 
     
   @Test2
   Scenario: TS010_Validate error message Missing Data for both Primary & Secondary Admin fields
    
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User navigates to Uploadw9 page and click on continue button
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then click on save changes button and Validate Error message for both Primary and Secondary Admin Fields

   @Test2
   Scenario: TS011_Validate error message Invali Data for Telephone Number for both Primary & Secondary Admin

    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User navigates to Uploadw9 page and click on continue button
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then enter invalid data for Primary Admin and validate error message
    Then enter invalid data for Secondary Admin and validate error message
     
   @Test2
   Scenario: TS012/TS013 Validate error message Invali Data for Email and retype email Address for both Primary & Secondary Admin
    
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User navigates to Uploadw9 page and click on continue button
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then enter invalid email  address for Primary and Secondary Admin and validate error message
     Then enter invalid Retype email address for Primary and Secondary Admin and validate error message
    
   @Test2
   Scenario: TS014_Validate Text alert indicator for Mobile Number for both Primary & Secondary Admin
   
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User navigates to Uploadw9 page and click on continue button
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then enter mobile number for Primary Admin and validate Text alert checkbox
      
    @Test2
   Scenario: TS015_Validate Learn about alert frequency for both Primary & Secondary Admin
     
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User navigates to Uploadw9 page and click on continue button
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then Click on Learn about alert frquency for both Primary and secondary admin and validate the popup
      
    @Test2
   Scenario: TS016_Validate upon clicking Save Changes new information is saved and displayed on Review and Submit page
      
      Then User navigates to Billing service information page and fill all fields and click on continue button
      Then User navigates to Identity Administrators page and fill all fields and click on continue button
      Then User navigates to Uploadw9 page and click on continue button
      Then User navigates to ReviewAndSubmit page and click on edit icon
      Then fill new information and click on save changes and displayed on Review and Submit page 
      
    @Test2
   Scenario: TS017_Validate Cancel button disabled functionality in case errors are seen on Identify Admin page
   
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User navigates to Uploadw9 page and click on continue button
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then Validate Cancel button is disabled in case errors are seen on Identify Admin page  
      
    @Test2
   Scenario: TS018_Validate that the Clear Administrator Information field is hidden when editing the administrator Information.
     
     Then User navigates to Billing service information page and fill all fields and click on continue button
     Then User navigates to Identity Administrators page and fill all fields and click on continue button
     Then User navigates to Uploadw9 page and click on continue button
     Then User navigates to ReviewAndSubmit page and click on edit icon
     Then Validate Clear Administrator Information field is hidden when editing the administrator Information
       