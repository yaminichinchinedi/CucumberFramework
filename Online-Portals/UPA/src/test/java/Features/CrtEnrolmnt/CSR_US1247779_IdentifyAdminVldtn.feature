
#Author: Rahul Krishna

Feature: Create Enrollment Identify Admin validations

		
		Scenario Outline: US1247779 Identify Admin page content,llinks validations
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		
		Then User fills all the information  and click on Continue
		Then User validates the page content of Identify Admin page
		Then User clicks on Learn about alert frequency link validates its content and close it
		Then User clicks on CLEAR ADMINISTRATOR INFORMATION link verify its content and YES/NO functionality
		Then Clicks on Continue to validate all the Error Messages
		   Examples:

         |   credentials     |
         |    Super          |
										      
			Scenario Outline: US1247779 Identify Admin page
    Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		
		Then User fills all the information  and click on Continue
		Then User fills mobileNo and checks its enabilty/disability of Identify Admin Page 	
		Then User checks its Back and continue button functionality
		Then User Clicks on Cancel Enrollment,verify its content and YES/NO button functionality		
		   Examples:

         |   credentials     |
         |    Super          |
		Scenario Outline: US1247779 Identify Admin page
    Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "<Enrollment Type>" and click continue button 
		
		Then User fills all the information  and click on Continue
		Then User validates headers of Identify Admin page 		
										 		|   credentials       		| Enrollment Type |
										    |Super           				  |       AO        |	
										    |Super          					|				VO				|	
										     
	
		
		Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
    Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		
		Then User fills all the information  and click on Continue
		Then User fills  primary info. and in Secondary info. enter "<Inpput field>" and "<dataFormat>" and validate Error messages
											|   credentials       		|Input Field|dataFormat|
											|Super           				  |First Name  |blank|
											|Super           				  |Last Name	 |blank|
											|Super           				  |Email		   |blank|
											|Super           				  |RetypeEmail |blank|
											|Super           				  |Tel No		   |blank|
											|Super           				  |   Tel No   |Incomplete|
											|Super           				  |   Tel No   |nonNumeric|
											|Super           				  |   email    |Incorrect|
											|Super           				  |First Name  |Alphanumeric|
											|Super           				  |Middle Name |numeric|
											|Super           				  |Last Name	 |Alphanumeric|
											|Super           				  |First Name  |Special Char|
											|Super           				  |Middle Name |Special Char|
											|Super           				  |Last Name	 |Special Char|
											
											
		Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
   Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		
		Then User fills all the information  and click on Continue
		Then User fills  all data but different email and Retype email for "<Input Field>" and validate Error messages	
										|   credentials       			|Input Field|
										|Super           				  	| Primary   |
										|Super           				  	| Secondary  |
											
				Scenario Outline: US1247779 Identify Admin page Primary Information Error Messages
    Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		
		Then User fills all the information  and click on Continue
		Then User fills  primary information with "<Inpput field>" and "<dataFormat>" and validate Error messages	
											|   credentials       		|Input Field			|dataFormat|
										  |Super           				  |First Name  |blank|
										  |Super           				  |Last Name	 |blank|
											|Super           				  |Email		   |blank|
											|Super           				  |RetypeEmail |blank|
											|Super           				  |Tel No		   |blank|
											|Super           				  |   Tel No   |Incomplete|
											|Super           				  |   Tel No   |nonNumeric|
											|Super           				  |   Email    |Incorrect|
											|Super           				  |First Name  |Alphanumeric|
											|Super           				  |Middle Name |numeric|
											|Super           				  |Last Name	 |Alphanumeric|
											|Super           				  |First Name  |Special Char|
											|Super           				  |Middle Name |Special Char|
											|Super           				  |Last Name	 |Special Char|
																				
										           