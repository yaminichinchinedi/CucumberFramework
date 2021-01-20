#Author: Rahul Krishna 
Feature: Create Enrollment Home Page Validations 

Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email 

	Given User navigates to UPA Sys Test application 
	When User Clicks on Enroll Now from the landing page 
	Then User Select a How you heard option and  click on Continue button 
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page 
		|Enrollment Type|
		|     AO        |	
	Then User fills all the information  and click on Continue 
	Then Validate the Headers on Identify Admin Page. 
	Then User fills all fields with "<existingEmail>" on Identify Admin page click continue button and validates all the data from DB 
	Then click on Yes to continue with "<existingEmail>",Click on NO with different email address depending on "<flag>"
	
	Examples: 
	
		|		existingEmail	     |   flag |
		|		Primary 		     |   Y    |
		|		Primary 		     |   N    |
		|		Secondary            |   Y    |
		|		Secondary            |   N    |
		|		PrimaryAndSecondary  |   Y    |
		|		PrimaryAndSecondary  |   N    |
	
		
Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email 
	
		Given User navigates to UPA Sys Test application 
		When User Clicks on Enroll Now from the landing page 
		Then User Select a How you heard option and  click on Continue button 
		Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page 
			|Enrollment Type|
			|     AO        |
		Then User fills all the information  and click on Continue 
		Then Validate the Headers on Identify Admin Page. 
		Then User fills all fields with "<existingEmail>" on Identify Admin page click continue button and validates all the data from DB 
		Examples: 
		
		
			|	existingEmail		 |
			|  PrimaryAndSecondary   |		 
