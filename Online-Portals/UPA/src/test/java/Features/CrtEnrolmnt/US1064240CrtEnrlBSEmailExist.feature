#Author: Rahul Krishna
Feature: Create Enrollment existing email validations on IdentifyAdmin Page

		
Scenario: US1064240_Create Enrollment_BS_existing Email entry
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then Validates all the headers from the Identify Administrators page
  Then User fills all fields with existing Primary Email on Identify Admin page click continue button and validates all the data from DB
  Then click on Yes to continue with same email address,Click on NO with different email address 
  								      
Scenario: US1064240_Create Enrollment_BS_existing Email,Identify Admin Header validation
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then Validates all the headers from the Identify Administrators page
  Then User fills all fields with existing Secondary Email on Identify Admin page click continue button
  Then User fills all fields with existing both primary and Secondary Email on Identify Admin page click continue validates all the content from DB

 