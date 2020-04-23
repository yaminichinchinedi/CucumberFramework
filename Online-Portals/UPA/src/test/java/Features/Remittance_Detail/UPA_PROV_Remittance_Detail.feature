#Author: Athyusha Thota

@UPARemitDetail    @UPARegression  @UPASanity
Feature: UPA Remittance Detail Provider


Scenario Outline: Remittance Detail UI and FISL Validations for Provider User

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA "<Search Criteria>"
     When Click on View Payments Link for UPA 
     And Validate all other columns in Show All State for UPA
     And Verify Remittance Detail Online vs FISL Response for UPA
     Then Validate all Headers in the Page
     Then Validate Column Headers in the Page
     And Validate Download, Print, Return buttons in Remit Page
     And Verify Pagination functionality
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     And Verify FISL Response for COB Only Filter Claim
     And Verify FISL Response for Reversal Only Filter Claim
     
Examples: 
        |    Search Criteria     |       credentials        |  
        |     Provider_Admin     |       PROV_Admin         |
        |     Provider_Gen       |       PROV_Gen           |
        
        

Scenario Outline: Remittance Detail Validations for Patient, Rendering Provider for Provider

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA "<Search Criteria>"
     When Click on View Payments Link for UPA 
     And Validate all other columns in Show All State for UPA
     Then Validate Sort By - Patient Last Name
     Then Validate Sort By - Rendering Provider Last Name

Examples:     
       
         |    Search Criteria      |       credentials      | 
         |     Provider_Admin      |       PROV_Admin       |
         |     Provider_Gen        |       PROV_Gen         |


           
Scenario Outline: Remittance Detail multiple PLB Adjustments for Provider 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA "<Search Criteria>"
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Validate Payment with Multiple PLB Adjustments for UPA 

Examples:

          |    Search Criteria     |      credentials      |
          |      Multiple PLB      |      PROV_Admin       |
          |      Multiple PLB      |      PROV_Gen         |
          
                   
Scenario Outline: Remittance Detail PLB Adjustments Only for Provider
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA "<Search Criteria>"
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Adjustment Only Criteria
     And Validate PLB Adjustment Only for UPA
     
Examples:

          |    Search Criteria     |      credentials      |
          |      PLB Adj Only      |     PROV_Admin        |
          |      PLB Adj Only      |     PROV_Gen          |          
          

     
Scenario Outline: Remittance Detail Tricare Validation for Provider

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA "<Search Criteria>"  
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking
     
Examples:

         |    Search Criteria     |   credentials     |
         |       Tricare          |   PROV_Admin      | 
         |       Tricare          |   PROV_Gen        |           
          

        
