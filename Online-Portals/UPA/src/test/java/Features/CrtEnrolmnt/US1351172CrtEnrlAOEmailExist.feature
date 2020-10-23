#Author: Rahul Krishna


Feature: Create Enrollment Home Page Validations 

		
Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select "<Enrollment Type>" and  Clicks continue button of Enrollment TIN Eligible page
	Then User fills all the information  and click on Continue
  Then User navigates to Identity Administrators page and validate its headers
  Then User fills all fields with "<Existing Email>" on Identify Admin page click continue button and validates all the data from DB
  Then click on Yes to continue with same email address,Click on NO with different email address 
	
											|Enrollment Type|		Existing Email	 |
											|     AO        |		Primary email		 |
											|     AO        |		Secondary	email  |
											|     AO        |		Primary&Secondary both	email  |

Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select "<Enrollment Type>" and  Clicks continue button of Enrollment TIN Eligible page
	Then User fills all the information  and click on Continue
  Then User navigates to Identity Administrators page and validate its headers
  Then User fills all fields with "<Existing Email>" on Identify Admin page click continue button and validates all the data from DB
	
											|Enrollment Type|						Existing Email				 |
											|     AO        |		Primary&Secondary both	email  |		 