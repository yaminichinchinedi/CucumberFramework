
#Author: Athyusha Thota

@UPARemitDetail  @UPARegression @BothCSRUPAScenarios @UPARemitDetailPayer
Feature: UPA Remittance Detail Payer

Scenario Outline: Remittance Detail UI and FISL Validations for Payer User

     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA 
     And User enters tin for UPA "<Search Criteria>" for Payer
     And Validate all other columns in Show All State for UPA_Payer
     And Verify Remittance Detail Online vs FISL Response for UPA_Payer
     Then Validate all Headers in the Page for Payer
     Then Validate Column Headers in the Page for Payer
     And Validate Download, Print, Return buttons in Remit Page
     And Verify Pagination functionality
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     And Verify FISL Response for COB Only Filter Claim for "<usertype>"
     And Verify FISL Response for Reversal Only Filter Claim for "<usertype>"

Examples: 
        |    Search Criteria     |       credentials        | usertype | 
        |     Payer_Admin        |       PAY_Admin          | Payer    |
        |     Payer_Gen          |       PAY_Gen            | Payer    |
        
        

Scenario Outline: Remittance Detail Validations for Patient, Rendering Provider for Payer

     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA 
     And User enters tin for UPA "<Search Criteria>" for Payer
     And Validate all other columns in Show All State for UPA_Payer
     Then Validate Sort By - Patient Last Name
     Then Validate Sort By - Rendering Provider Last Name

Examples:     
       
         |    Search Criteria     |       credentials      | 
         |     Payer_Admin        |       PAY_Admin        |
         |     Payer_Gen          |       PAY_Gen          |

# Data not found for ERIE Payer User         
Scenario Outline: Remittance Detail multiple PLB Adjustments for Payer 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA "<Search Criteria>" for Payer
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Validate Payment with Multiple PLB Adjustments for UPA 

Examples:

          |    Search Criteria     |      credentials      |
 #         |      Multiple PLB      |      PAY_Admin        |
 #         |      Multiple PLB      |      PAY_Gen          |
          
          
      
Scenario Outline: Remittance Detail PLB Adjustments Only for Payer
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA "<Search Criteria>" for Payer
     And Enter Electronic Number for Adjustment Only Criteria for Payer
     And Validate PLB Adjustment Only for UPA for Payer
     
     
Examples:

          |    Search Criteria            |     credentials       |
          |      PLB_Adj_Only_Pay_Admin   |     PAY_Admin         |
          |      PLB_Adj_Only_Pay_Gen     |     PAY_Gen           |          
          

# Data not found as Tricare is for Payer = PP009 and we have user for PP008 or PP018     
Scenario Outline: Remittance Detail Tricare Validation for Payer

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA "<Search Criteria>" for Payer
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking
     
Examples:

         |    Search Criteria     |   credentials     |
#         |       Tricare          |   PAY_Admin       | 
#         |       Tricare          |   PAY_Gen         |           
          

        
