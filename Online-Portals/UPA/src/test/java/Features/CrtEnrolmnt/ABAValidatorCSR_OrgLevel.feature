
#Author:Rahul Krishna
@CSRUS2673017
Feature: US2673017CSROrg-Create Enrollment CSR- RTN API Request/Response - Org Financial Institution Information
@Rahulxyz
		Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
		#When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
		Then clicks back button on Upload WNine Page.
		And modify/remove RTN No making as invalid,validations are performed

 Examples:

         |   credentials     |
         |    Super          |
         |    RW             |

		Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Error Messages Validation
		#When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
		Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator
		And All the validations are performed for Incorrect information with editable RTN No
		
		Examples:
		
		         |   credentials     |
		         |    Super          |
		         |    RW             |
 
  		Scenario Outline: ABN Validators Financial Institution Information AO-Error message Revalidations
		#When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  	And User validates fiels are editables on Financial Institution Information page
  	And Validates buttons on Edit Financial Institution Information Page
		Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator     
	
	 		Examples:
		
		         |   credentials     |
		         |    Super          |
		         |    RW             |
		         
	  Scenario Outline: ABN Validators Financial Institution Information AO -Org Level Review and Submit
	  #When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And Clicks on Cancel Changes button on Financial Institution Page. 
    And Validate no changes are saved on Review Submit Page for Financial Institution section.
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    Then Users clears the RTN No fill the new RTN No and validate the details and click on Save changes button
    And Validate the changes are reflected on Review and Submit Page.
    		Examples:
		
		         |   credentials     |
		         |    Super          |
		         |    RW             |
    
    
    Scenario Outline: Create Enrollment-CSR- RTN API Request/Response AV- Error Messages Validation
    #When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AV" and click continue button 
		Then User fills all the information  and click on Continue
		Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
		Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator
		And All the validations are performed for Incorrect information with editable RTN No
    		Examples:
		
		         |   credentials     |
		         |    Super          |
		         |    RW             |
   
    Scenario Outline: ABN Validators Financial Institution Information AV -Error message Revalidations
    #When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AV" and click continue button 
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue AV
    Then User clicks Continue on Select Payment Methods Page
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  	And User validates fiels are editables on Financial Institution Information page
  	And Validates buttons on Edit Financial Institution Information Page
		Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator
				Examples:
		
		         |   credentials     |
		         |    Super          |
		         |    RW             |
		
	
		Scenario Outline: ABN Validators Financial Institution Information AV-Org Level Review and Submit
		#When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AV" and click continue button 
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue AV
    Then User clicks Continue on Select Payment Methods Page
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And Clicks on Cancel Changes button on Financial Institution Page. 
    And Validate no changes are saved on Review Submit Page for Financial Institution section.
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    Then Users clears the RTN No fill the new RTN No and validate the details and click on Save changes button
    And Validate the changes are reflected on Review and Submit Page.
    		Examples:
		
		         |   credentials     |
		         |    Super          |
		         |    RW             |