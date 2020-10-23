#Author: Amit Kushwah

Feature: Create Enrollment - Select Payment Methods

#TS03
Scenario Outline: Fills the relevent Info with VO Enroll Typ
   When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "VO" and click continue button 
    
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
   Examples:

         |   credentials     |
         |    Super          |
#TS04

Scenario Outline: Fills the relevent Info with AO Enroll Typ
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
       Examples:

         |   credentials     |
         |    Super          |
