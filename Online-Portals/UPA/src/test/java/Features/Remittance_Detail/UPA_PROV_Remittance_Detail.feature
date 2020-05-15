#Author: Athyusha Thota

@UPARemitDetail @UPARegression  @UPASanity @BothCSRUPAScenarios @UPARemitDetailprov
Feature: UPA Remittance Detail Provider

Scenario Outline: Remittance Detail UI and FISL Validations for Provider User

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
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
        |    searchBy            |       credentials        |usertype   |  
        |     Multiple_PLB       |       PROV_Admin         |PROV       |
        |     Multiple_PLB       |       PROV_Gen           |PROV       |
        
        

Scenario Outline: Remittance Detail Validations for Patient, Rendering Provider for Provider

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     Then Validate Sort By - Patient Last Name
     Then Validate Sort By - Rendering Provider Last Name

Examples:     
       
         |    searchBy           |       credentials      | usertype   |
         |     Multiple_PLB      |       PROV_Admin       | PROV       |
         |     Multiple_PLB      |       PROV_Gen         | PROV       |


        
Scenario Outline: Remittance Detail multiple PLB Adjustments for Provider 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Validate Payment with Multiple PLB Adjustments for UPA 

Examples:

          |    searchBy            |      credentials         |usertype   |
          |      Multiple_PLB      |      PROV_Admin          |PROV       |
          |      Multiple_PLB      |      PROV_Gen            |PROV       |
          
                    
Scenario Outline: Remittance Detail PLB Adjustments Only for Provider
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Adjustment Only Criteria
     And Validate PLB Adjustment Only for UPA
     
Examples:

          |       searchBy         |      credentials      |usertype   |
          |      PLB Adj Only      |     PROV_Admin        |PROV       |
          |      PLB Adj Only      |     PROV_Gen          |PROV       |     
          

     
Scenario Outline: Remittance Detail Tricare Validation for Provider

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button 
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking
     
Examples:

         |    searchBy            |   credentials     |usertype   |
         |       Tricare          |   PROV_Admin      | PROV      |
         |       Tricare          |   PROV_Gen        | PROV      |      
          

        
