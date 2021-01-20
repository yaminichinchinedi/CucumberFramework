#Author: Rahul Krishna
Feature: Create Enrollment Home Page Validations 
Background: 
		Given User navigates to CSR portal and enters "Super" and login
		

Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
  
  		When  ABN Validator Switch is set as 'Y'
  		Given User is on CSR Home Page
		#Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button
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
  
 When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button
		Then User fills all the information  and click on Continue
		Then Validate the Headers on Identify Admin Page. 
		Then User fills all fields with "<existingEmail>" on Identify Admin page click continue button and validates all the data from DB 
		Examples: 
		
		
			|	existingEmail		 |
			|  PrimaryAndSecondary   |	