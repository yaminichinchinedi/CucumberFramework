#Author: Rahul Krishna


Feature: Create Enrollment Home Page Validations 

		
Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
  

  
  When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button
		
	Then User fills all the information  and click on Continue
  Then User navigates to Identity Administrators page and validate its headers
  Then User fills all fields with "<Existing Email>" on Identify Admin page click continue button and validates all the data from DB
  Then click on Yes to continue with same email address,Click on NO with different email address 
	
									|credentials		|		Existing Email	 |
									|Super	  |		Primary email		 |
									|Super	 	|		Secondary	email  |
									|Super		  |		Primary&Secondary both	email  |

Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
  
 When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button
		
	Then User fills all the information  and click on Continue
  Then User navigates to Identity Administrators page and validate its headers
  Then User fills all fields with "<Existing Email>" on Identify Admin page click continue button and validates all the data from DB
	
									|credentials	|						Existing Email				 |
									|Super			  |		Primary&Secondary both	email  |		 