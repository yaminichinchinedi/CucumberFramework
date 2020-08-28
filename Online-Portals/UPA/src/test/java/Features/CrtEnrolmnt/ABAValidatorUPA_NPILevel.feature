#Author:Rahul Krishna
 @UPAUS2690163
Feature: US2690163UPANPI-Create Enrollment UPA- RTN API Request/Response - Org Financial Institution Information NPI

  Background: ABA Validator - Financial Institution NPI Page
  When  ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    @Rahul
  Scenario: ABN Validators Financial Institution Information -NPI Level Validations
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link


	 Scenario: ABN Validators Financial Institution Information -NPI Level Error Validations
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No and other information with Incorrect/Improper/Null RTN No on Financial Institution Information NPI page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No
    
    
    Scenario: ABN Validators Financial Institution Information -NPI Level ReValidations
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    Then Users clears the RTN No on NPI page fill the new RTN No and validate the details and click on Save changes button
      