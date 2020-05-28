#Author: Athyusha Thota

@CSRClaimDetail @CSRRegression @CSRSanity @BothCSRUPAScenarios
Feature: CSR Claim Detail

Scenario Outline: Claim Detail UI Functionality and Data Check

    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Search Remittance link
    And User enter tin for CSR Search Remittance Page for "<searchBy>" through "<usertype>" and click on continue button
    #And User enters tin for Mutliple PLB Adjustments Criteria
    And Enter Electronic Number for Mutliple PLB Adjustments Criteria
    Then Verify Claim Detail UI vs FISL Response for "<usertype>"
    Then Validate all Headers in the Page for Claim Detail Page
    Then Validate Column Headers in the Page for Claim Detail Page
    And Check RMK Code Pop Up
    And Check Adj Reason Code Pop Up
    Then Validate Payment Number Hyper Link in UPA
     
Examples:
 
        |     searchBy               |   credentials     |usertype   |  
        |     Multiple_PLB_ProvAdmin |      Super        |PROV       |
        |     Multiple_PLB_ProvAdmin |      RW           |PROV       |
        |     Multiple_PLB_ProvAdmin |      RO           |PROV       |   
        

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
         |    RO             |
        
        
        
                
        
             
     
     
     
     
     
     
     
     
     
     
     
     