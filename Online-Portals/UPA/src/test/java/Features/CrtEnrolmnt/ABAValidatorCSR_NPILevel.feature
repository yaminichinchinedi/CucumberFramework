#Author:Rahul Krishna

#@CSRUS2673017  
Feature: US2673017CSRNPI-Create Enrollment CSR- RTN API Request/Response - Org Financial Institution Information NPI
		
  Scenario Outline: ABN Validators Financial Institution Information AO -NPI Level Validations
  	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AO" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
 Examples:

         |   credentials     |
         |    Super          |
         |    RW             |


	 Scenario Outline: ABN Validators Financial Institution Information AO -Error Messages Validations
		When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No and other information with Incorrect/Improper/Null RTN No on Financial Institution Information NPI page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No
    Examples:

         |   credentials     |
         |    Super          |
         |    RW             | 
    
        
    Scenario Outline: ABN Validators Financial Institution Information AO-NPI Level ReValidations
    When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    Then Users clears the RTN No on NPI page fill the new RTN No and validate the details and click on Save changes button
     Examples:

         |   credentials     |
         |    Super          |
         |    RW             |
    
  Scenario Outline: ABN Validators Financial Institution Information AV-NPI Level Validations
  	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AV" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue for AV.
    Then User clicks Continue on Select Payment Methods Page
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
     Examples:

         |   credentials     |
         |    Super          |
         |    RW             |
    
   	 Scenario Outline: ABN Validators Financial Institution Information AV -NPI Level Validations
   	 When  ABN Validator Switch is set as 'Y'
   	Given User navigates to CSR portal and enters "Super" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AV" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No and other information with Incorrect/Improper/Null RTN No on Financial Institution Information NPI page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No
     Examples:

         |   credentials     |
         |    Super          |
         |    RW             |
    
    Scenario Outline: ABN Validators Financial Institution Information AV -NPI Level ReValidations
    When  ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AV" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue for AV.
    Then User clicks Continue on Select Payment Methods Page
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    Then Users clears the RTN No on NPI page fill the new RTN No and validate the details and click on Save changes button
    
		 Examples:

         |   credentials     |
         |    Super          |
         |    RW             |
      