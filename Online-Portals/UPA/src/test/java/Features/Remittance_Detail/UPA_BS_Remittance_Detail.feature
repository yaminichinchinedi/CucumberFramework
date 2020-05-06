#Author: Athyusha Thota

@UPARemitDetail  @UPARegression @BothCSRUPAScenarios
Feature: UPA Remittance Detail Billing Service


Scenario Outline: Remittance Detail UI and FISL Validations for BS User

     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     And User enters tin for UPA "<Search Criteria>" for BS
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
        |    Search Criteria     |       credentials      |  
        |        BS_Admin        |       BS_Admin         |
        |        BS_Gen          |       BS_Gen           |
        
        

Scenario Outline: Remittance Detail Validations for Patient, Rendering Provider for BS

     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA 
     And User enters tin for UPA "<Search Criteria>" for BS
     And Validate all other columns in Show All State for UPA
     Then Validate Sort By - Patient Last Name
     Then Validate Sort By - Rendering Provider Last Name

Examples:     
       
         |    Search Criteria     |       credentials      | 
         |        BS_Admin        |       BS_Admin         |
         |        BS_Gen          |       BS_Gen           |
            
 

Scenario Outline: Remittance Detail multiple PLB Adjustments for BS 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA "<Search Criteria>" for BS
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Validate Payment with Multiple PLB Adjustments for UPA 

Examples:

          |    Search Criteria     |      credentials      |
          |      Multiple PLB      |      BS_Admin         |
          |      Multiple PLB      |      BS_Gen           |
          
          
         
Scenario Outline: Remittance Detail PLB Adjustments Only for BS
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA "<Search Criteria>" for BS
     And Enter Electronic Number for Adjustment Only Criteria
     And Validate PLB Adjustment Only for UPA
     
Examples:

          |    Search Criteria     |      credentials      |
          |      PLB Adj Only      |      BS_Admin         |
          |      PLB Adj Only      |      BS_Gen           |          
          

     
Scenario Outline: Remittance Detail Tricare Validation for BS

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA "<Search Criteria>" for BS
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking
     
Examples:

         |    Search Criteria        |   credentials     |
         |       Tricare_BS          |   BS_Admin        | 
         |       Tricare_BS          |   BS_Gen          |           
          

        
