#Author: Amit Kushwah

@CreateEnrollment @US1248704 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment - Review and Submit -edit Organization Information


    
#TS_001#TS_04#TS_005 #TS_06#TS_07#TS_08
@UPASanity
  Scenario: Fills the relevant Info with AO Enroll Typ
   When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AO" and click continue button
  	
  	
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    		When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    And Validate the Headers for Organization Information.
    And Validate page is Content Managed.
    And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page. 
    Then User Clicks Cancel Changes button.
    And Validate User is  redirected to Review and Submit Page and No changes are saved.
   

		
#TS_013 #TS_015-TS_18
@UPASanity
  Scenario Outline: Fills the relevant Info with AO Enroll Typ
 When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AO" and click continue button
  	
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
		 Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User enters new information incorrectly and clicks save button.
    Then Validate the CANCEL CHANGE button is disabled.
   Examples:

         |   credentials     |
         |    Super          |
#TS_011#TS_012 #TS_014  
  Scenario Outline: Fills the relevant Info with AO Enroll Typ
 When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AO" and click continue button
  	
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
		    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User clears all the information and clicks save button and validate error messages.
   	 Examples:

         |   credentials     |
         |    Super          |	
#TS_019#TS_20
  Scenario Outline: Fills the relevant Info with AO Enroll Typ
 When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AO" and click continue button
  	
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
		   Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User enters new information correctly and clicks save button.
    Then Validate User is  redirected to Review and Submit Page and changes are saved.
   		
		 Examples:

         |   credentials     |
         |    Super          |
		
		
		