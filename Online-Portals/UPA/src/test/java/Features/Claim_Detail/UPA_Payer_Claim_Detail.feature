#Author: Athyusha Thota

@UPACLaimDetail13  @UPARegression
Feature: UPA Payer Claim Detail



Scenario Outline: Claim Detail UI Functionality and Data Check

     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     And User enters tin for UPA "<Search Criteria>"
     And Validate all other columns in Show All State for UPA_Payer
     Then Verify Claim Detail UI vs FISL Response
     #Then Validate all Headers in the Page for Claim Detail Page
     Then Validate all Headers in the Page for Claim Detail Page for Payer
     Then Validate Column Headers in the Page for Claim Detail Page
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
    # Then Validate Payment Number Hyper Link in UPA
     Then Validate Payment Number Hyper Link in UPA Payer

Examples:

        |    Search Criteria     |   credentials     |
        |      Payer_Admin       |    PAY_Admin      |
        |      Payer_Gen         |    PAY_Gen        |
        
             
# Data Not FOund as the credentials which we r using doesnt belong to Tricare
Scenario Outline: Claim Detail Tricare Functionality

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA "<Search Criteria>"
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking for Claim Detail Page
     
Examples:

        |    Search Criteria     |   credentials     |
#        |      Tricare           |    PAY_Admin      |
#        |      Tricare           |    PAY_Gen        |
        
     
     
     
     
     
     
     
     
     