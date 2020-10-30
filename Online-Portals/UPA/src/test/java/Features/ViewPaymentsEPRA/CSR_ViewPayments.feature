#Author: Pranav Kasula
@BothCSRUPAScenarios @UPARegression  @ViewPayments 
Feature: View Payments CSR        

Background: 
		Given User navigates to CSR portal and enters "Super" and login
		 
@US2707345 
Scenario: View Payments Page UI Functionality for CSR
	
	Given User is on CSR Home Page
    When Click on View Payments Link
    Then User enters tin on View Payments Tin "PatientPayment" and click continue
    And User selects time period filter "Last 90 days" for View Payments
    Then Validate that View Payments Payer/Patient column name is changed to Payer for "CSR"

@US2810748
Scenario: View Payments UI Functionality for Complaint patient payments CSR
	
	Given User is on CSR Home Page
    When Click on View Payments Link
    Then User enters tin on View Payments Tin "PatientPayment" and click continue
    And User selects time period filter "Last 90 days" for View Payments
    And User selects market type filter period "Patient Payments" for View Payments
    Then Validate the EPRA and Payer PRA column in View Payments Page for "CSR"


@US2707374 
Scenario: View Payments Page UI Functionality for Patient Payements(View Payments --> Remittance Detail)

	Given User is on CSR Home Page
    When Click on View Payments Link
    Then User enters tin on View Payments Tin "PatientPayment" and click continue
    And User selects time period filter "Last 90 days" for View Payments
    And User selects market type filter period "Patient Payments" for View Payments
    Then Validate and click on payment number
    Then Validate all Headers in the Page for Payer
    Then Validate Column Headers in the grid for remittance detail Page

    