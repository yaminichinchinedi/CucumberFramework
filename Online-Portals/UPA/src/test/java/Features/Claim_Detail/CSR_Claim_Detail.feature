#Author: Athyusha Thota

@CSRClaimDetail    @CSRRegression
Feature: CSR Claim Detail

Scenario Outline: Claim Detail UI Functionality 

     Given User navigates to CSR portal and enters "<credentials>" and login
     When Click on View Payments Link
     And User enters tin on View Payments Tin "<Search Criteria>" and click continue
     And Validate all other columns in Show All State
     Then Verify Claim Detail UI vs FISL Response
     Then Validate all Headers in the Page for Claim Detail Page
     Then Validate Column Headers in the Page for Claim Detail Page
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     Then Validate Payment Number Hyper Link
     
Examples:

        |    Search Criteria     |   credentials     |
        |      RemitDetail       |      Super        |
        |      RemitDetail       |      RW           |
#       |      RemitDetail       |      RO           |         
        
       
Scenario Outline: Claim Detail Tricare Functionality

    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Search Remittance link
    And User enters tin for Tricare Masking Criteria
    And Enter Electronic Number for Tricare Masking Criteria
    And Validate Tricare Masking
     
Examples:

         |   credentials     |
         |    Super          |
         |    RW             |
#        |    RO             |
        
        
        
                
        
             
     
     
     
     
     
     
     
     
     
     
     
     