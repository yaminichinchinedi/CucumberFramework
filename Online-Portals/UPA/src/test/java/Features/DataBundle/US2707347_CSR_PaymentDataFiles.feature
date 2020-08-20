#Author: Pranav Kasula
@CSRDataBundle @CSRRegression @US2707347
Feature: CSR_PaymentDataFiles

  Scenario Outline: Verify Payer Selection Validations
  Given User navigates to CSR portal and enters "<Credentials>" and login
  When  User clicks on Payment Data Files Link
  And   User enters the Valid tin number
  And  Verify User navigates to Create Data Bundle Page
  And User Verify Payer Name List in Payer Selection
  Then User Verify Patient Payment Payer appear on top of the list 
  Then User Verify for Note appears that Payer PRAs and EPRAs are not available for Patient Payments
  Then User  Verify for Note that Data Bundle requests for Patient Payments will be available soon, no longer appears above Payer Selection.
  Then User  Verifies able to select 835s 
  
  	Examples:
      |     Credentials |
      | 		Super 	|
       