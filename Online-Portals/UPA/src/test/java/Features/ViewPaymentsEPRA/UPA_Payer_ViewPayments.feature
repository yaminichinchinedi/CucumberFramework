#Author: Pranav Kasula
@UPARegression @BothCSRUPAScenarios  
Feature: UPA Payment Details Payor     
          
@US2707345
Scenario Outline: View Payments Page UI Functionality for CSR
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
    And User selects time period filter "<timePeriod>" for View Payments
     Then Validate that View Payments Payer/Patient column name is changed to Payer for "<type>"

Examples:

        |    searchBy                   |       credentials        |  timePeriod   |  userType  | type  |
		|generalPaymentForTIN_90days    |       PAY_Admin          |  Last 90 days |  Payer     |  UPA  |
        |generalPaymentForTIN_90days    |       PAY_Gen            |  Last 90 days |  Payer     |  UPA  |
        
        
@US2810748 
Scenario Outline: View Payments UI Functionality for Complaint patient payments CSR
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
     And User selects time period filter "<timePeriod>" for View Payments
     And User selects market type filter period "<filter>" for View Payments
     Then Validate the EPRA and Payer PRA column in View Payments Page for "<type>"

Examples:

        |    searchBy                   |       credentials        |  timePeriod   |  userType  |   filter           | type  |
		|generalPaymentForTIN_90days    |       PAY_Admin          |  Last 90 days |  Payer     |   Patient Payments |  UPA  |
        |generalPaymentForTIN_90days    |       PAY_Gen            |  Last 90 days |  Payer     |   Patient Payments |  UPA  |
        

@US2707374 
Scenario Outline:  View Payments Page UI Functionality for Patient Payements(View Payments --> Remittance Detail)
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
     And User selects time period filter "<timePeriod>" for View Payments
     And User selects market type filter period "<filter>" for View Payments
     Then Validate and click on payment number
     Then Validate all Headers in the Page for Payer
     Then Validate Column Headers in the grid for remittance detail Page

Examples:

        |    searchBy                   |       credentials        |  timePeriod   |  userType  |   filter           |
		|generalPaymentForTIN_90days    |       PAY_Admin          |  Last 90 days |  Payer     |   Patient Payments |
        |generalPaymentForTIN_90days    |       PAY_Gen            |  Last 90 days |  Payer     |   Patient Payments |
        