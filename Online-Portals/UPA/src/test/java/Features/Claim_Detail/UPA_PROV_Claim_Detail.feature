#Author: Athyusha Thota

@UPAClaimDetail  @UPARegression  @UPASanity
Feature: UPA Provider Claim Detail



Scenario Outline: Claim Detail UI Functionality and Data Check

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA "<Search Criteria>"
     When Click on View Payments Link for UPA
     And Validate all other columns in Show All State for UPA
     Then Verify Claim Detail UI vs FISL Response
     Then Validate all Headers in the Page for Claim Detail Page
     Then Validate Column Headers in the Page for Claim Detail Page
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     Then Validate Payment Number Hyper Link in UPA

Examples:

        |    Search Criteria            |   credentials     |
        |      RemitDetail_ProvAdmin    |    PROV_Admin     |
        |      RemitDetail_ProvGen      |    PROV_Gen       |
        
             

Scenario Outline: Claim Detail Tricare Functionality

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA "<Search Criteria>"
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking for Claim Detail Page
     
Examples:

        |    Search Criteria     |   credentials     |
        |      Tricare           |    PROV_Admin     |
        |      Tricare           |    PROV_Gen       |
        
     
     
     
     
     
     
     
     
     