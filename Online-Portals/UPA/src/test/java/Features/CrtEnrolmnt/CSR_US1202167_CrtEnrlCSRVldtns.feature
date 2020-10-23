
#Author: Rahul Krishna

Feature:Create Enrollment Home Page Validations 

		
	
		
		Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select NO button of TIN not enrolled page and validate that it is on CSR home page
		Examples:

         |   credentials     |
         |    Super          |	
		
		Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Billing Service" and enter unique TIN and click Search
		Then User navigates to TIN not enrolled page with Return to CSR Welcome page button
		Then clicks on button to navigate to CSR Home page 
		Examples:

         |   credentials     |
         |    Super          |	
		Scenario Outline: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page VO enrollment
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "VO" and click continue button 
		Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.
    		   Examples:

         |   credentials     |
         |    Super          |	
    
    Scenario Outline: Create Enrollment TIN Entry Error Message Validation
    
    When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and validates various messgaes by Entering null,less than 9 char,Alphanumeric char,Specia char in TIN
		   Examples:

         |   credentials     |
         |    Super          |	
    
