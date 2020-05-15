#Author: Athyusha Thota

@CSRRemitDetail   @CSRRegression @CSRSanity @BothCSRUPAScenarios
Feature: CSR Remittance Detail

Scenario Outline: Remittance Detail UI Functionality and FISL Data Validations

     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     And User enters tin for Mutliple PLB Adjustments Criteria
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Verify Remittance Detail Online vs FISL Response
     Then Validate all Headers in the Page
     Then Validate Column Headers in the Page
     And Validate Download, Print, Return buttons in Remit Page
     And Verify Pagination functionality
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     And Verify FISL Response for COB Only Filter Claim for "<usertype>"
     And Verify FISL Response for Reversal Only Filter Claim for "<usertype>"
     
Examples:

        |   credentials     |usertype   |  
        |      Super        |PROV       |
        |      RW           |PROV       |
        |      RO           |PROV       | 
        
    
Scenario Outline: Remittance Detail UI and FISL Sort Validations

      Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     And User enters tin for Mutliple PLB Adjustments Criteria
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     Then Validate Sort By - Patient Last Name
     Then Validate Sort By - Rendering Provider Last Name

Examples:     
        |   credentials     |  
        |      Super        |
        |      RW           |
        |      RO           | 

   
Scenario Outline: Remittance Detail multiple PLB Adjustments 
     
     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     And User enters tin for Mutliple PLB Adjustments Criteria
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Validate Payment with Multiple PLB Adjustments

Examples:

         |   credentials   |
         |     Super       |
         |     RW          |
         |     RO          |
  
  
Scenario Outline: Remittance Detail PLB Adjustments 
     
     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     And User enters tin for PLB Adjustment Only Criteria
     And Enter Electronic Number for Adjustment Only Criteria
     And Validate PLB Adjustment Only


Examples:

         |   credentials   |
         |     Super       |
         |     RW          |
         |     RO          |
                   
Scenario Outline: Remittance Detail Tricare Validation

     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link      
     And User enters tin for Tricare Masking Criteria
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking
     
Examples:

         |   credentials   |
         |     Super       | 
         |     RW          | 
         |     RO          |
         


  
  
                 