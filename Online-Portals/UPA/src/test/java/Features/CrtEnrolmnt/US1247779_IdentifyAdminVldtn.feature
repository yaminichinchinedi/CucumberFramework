
#Author: Rahul Krishna

Feature: Create Enrollment Identify Admin validations

		
		Scenario: US1247779 Identify Admin page content,llinks validations
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    
    Then User Select a How you heard option and  click on Continue button
		    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
		Then User fills all the information  and click on Continue
		Then User validates the page content of Identify Admin page
		Then User clicks on Learn about alert frequency link validates its content and close it
		Then User clicks on CLEAR ADMINISTRATOR INFORMATION link verify its content and YES/NO functionality
		Then Clicks on Continue to validate all the Error Messages
		
										      
			Scenario: US1247779 Identify Admin page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
		    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
		Then User fills all the information  and click on Continue
		Then User fills mobileNo and checks its enabilty/disability of Identify Admin Page 	
		Then User checks its Back and continue button functionality
		Then User Clicks on Cancel Enrollment,verify its content and YES/NO button functionality		
		
		Scenario Outline: US1247779 Identify Admin page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
		Then Select "<Enrollment Type>" and  Clicks continue button of Enrollment TIN Eligible page
		Then User fills all the information  and click on Continue
		Then User validates headers of Identify Admin page 		
													| Enrollment Type |
										      |       AO        |	
										      |				VO				|	
										     
	
		
		Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
		    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
		Then User fills all the information  and click on Continue
		Then User fills  primary info. and in Secondary info. enter "<Inpput field>" and "<dataFormat>" and validate Error messages
											|Input Field|dataFormat|
											|First Name  |blank|
											|Last Name	 |blank|
											|Email		   |blank|
											|RetypeEmail |blank|
											|Tel No		   |blank|
											|   Tel No   |Incomplete|
											|   Tel No   |nonNumeric|
											|   email    |Incorrect|
											|First Name  |Alphanumeric|
											|Middle Name |numeric|
											|Last Name	 |Alphanumeric|
											|First Name  |Special Char|
											|Middle Name |Special Char|
											|Last Name	 |Special Char|
											
											
		Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
		 Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
		Then User fills all the information  and click on Continue
		Then User fills  all data but different email and Retype email for "<Input Field>" and validate Error messages	
											|Input Field|
											| Primary   |
											| Secondary  |
											
				Scenario Outline: US1247779 Identify Admin page Primary Information Error Messages
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
		    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
		Then User fills all the information  and click on Continue
		Then User fills  primary information with "<Inpput field>" and "<dataFormat>" and validate Error messages	
											|Input Field|dataFormat|
											
											|First Name  |blank|
											|Last Name	 |blank|
											|Email		   |blank|
											|RetypeEmail |blank|
											|Tel No		   |blank|
											|   Tel No   |Incomplete|
											|   Tel No   |nonNumeric|
											|   Email    |Incorrect|
											|First Name  |Alphanumeric|
											|Middle Name |numeric|
											|Last Name	 |Alphanumeric|
											|First Name  |Special Char|
											|Middle Name |Special Char|
											|Last Name	 |Special Char|
																				
										           