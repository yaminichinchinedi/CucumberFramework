#Author: Amit Kushwah

@CreateEnrollment @US1248819 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment - Review and Submit -edit Identify Administrator Information


#TS01, TS02, TS04, TS05, TS06,TS07,TS08,TS09,TS10,TS11,TS12,TS17,TS36,TS37
@UPASanity
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
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Validate the Headers on Identify Admin Page.
    And Validate the Identify Admin fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
    Then User Check if Mobile number field is mandatory if check box is enabled.
    Then User click on Learn About Alert Frequency Link.
    Then User Clicks Cancel Changes button On Identify Admin Page.
 Examples:

         |   credentials     |
         |    Super          |


#Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
#TS19
Scenario Outline: Fills the relevent Info with VO Enroll Typ
   When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "VO" and click continue button 
		
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Validate the Headers on Identify Admin Page.
 Examples:

         |   credentials     |
         |    Super          |
#TS21-TS29,TS31,TS32,TS33,TS35,TS38-TS46,TS48,TS49,TS50,TS52,TS54
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
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Fill Administrator Info and Verify error msgs for Primary Contacts.
    And Fill Administrator Info and Verify error msgs for Secondary Contacts.
     Examples:

         |   credentials     |
         |    Super          |
#TS53
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
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And ReFill the Admin Info and verify the saved changes.
 Examples:

         |   credentials     |
         |    Super          |


