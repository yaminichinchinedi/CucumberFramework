#Author: Athyusha Thota

@CSRRemitDetail   @CSRRegression @CSRSanity @BothCSRUPAScenarios
Feature: CSR Remittance Detail

Scenario Outline: Remittance Detail UI Functionality and FISL Data Validations

     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     And User enters tin for Mutliple PLB Adjustments Criteria
     #And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Enter Electronic Payment Number based on "<CriteriaType>"
     #And Verify Remittance Detail Online vs FISL Response
     And Verify Remittance Detail Online vs FISL Response for "<usertype>"
     Then Validate all Headers in the Page
     Then Validate Column Headers in the Page
     And Validate Download, Print, Return buttons in Remit Page
     And Verify Pagination functionality
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     And Verify FISL Response for COB Only Filter Claim for "<usertype>"
     And Verify FISL Response for Reversal Only Filter Claim for "<usertype>"

     
Examples:

        |   credentials     |usertype   |  CriteriaType  |
        |      Super        |PROV       | RemitDetail    |
 #       |      RW           |PROV       | RemitDetail    |
 #       |      RO           |PROV       | RemitDetail    |
        
    
Scenario Outline: Remittance Detail UI and FISL Sort Validations

      Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     And User enters tin for Mutliple PLB Adjustments Criteria
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     Then Validate Sort By - Patient Last Name for "<usertype>" 
     Then Validate Sort By - Rendering Provider Last Name for "<usertype>" 
     #Then Validate Sort By - Patient Last Name
     #Then Validate Sort By - Rendering Provider Last Name

Examples:     
        |   credentials     | usertype   | 
        |      Super        |  PROV      |
        |      RW           | PROV       |
        |      RO           | PROV       |

   
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
         
@US2707347
Scenario Outline: Remittance Detail payer column relabel for CSR 
     
     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button     
     And Enter Electronic Number for Adjustment Only Criteria
     Then Validate that Payer/Patient column name is changed to Payer 


Examples:

         |   credentials   |	priority		|	     searchBy	            | usertype   |
         |     Super       |      None          |    Multiple_PLB_ProvAdmin     |   PROV     |

@US2707342
Scenario Outline: Remittance Detail Page UI Functionality for CSR 
     
     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button     
     And Enter Check Number and click search
     Then Click on Payment Number Link and Validate the Download 835 option is displayed


Examples:

         |   credentials   |	priority		|	     searchBy	                 | usertype   |
         |     Super       |      None          |    generalPaymentForTIN_90days     |   PROV     |

@US2707374 
Scenario Outline: Remittance Detail Page UI Functionality for Patient Payements (Search Remittance  --> Remittance Detail)
     
     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button     
     And Enter Check Number and click search
	Then Validate and click on payment number
    Then Validate all Headers in the Page for Payer
    Then Validate Column Headers in the grid for remittance detail Page


Examples:

         |   credentials   |	priority		|	     searchBy	                 | usertype   |
         |     Super       |      None          |    generalPaymentForTIN_90days     |   PROV     |
  
@US2707344
Scenario Outline: Remittance Detail UI Functionality for Complaint patient payments CSR
     
     Given User navigates to CSR portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link
     Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button     
     And Enter Check Number and click search
     Then Validate the EPRA and Payer PRA column in Search Remittance Page for "CSR"


Examples:

         |   credentials   |	priority		|	     searchBy	                 | usertype   |
         |     Super       |      None          |    generalPaymentForTIN_90days     |   PROV     |
                 