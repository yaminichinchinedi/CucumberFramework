#Author: Athyusha Thota

@UPARemitDetail @UPARegression  @UPASanity @BothCSRUPAScenarios 
Feature: UPA Remittance Detail Provider

@UPARemitDetailProv
Scenario Outline: Remittance Detail UI and FISL Validations for Provider User

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Payment Number based on "<CriteriaType>"
     #And Enter Electronic Number for Mutliple PLB Adjustments Criteria
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
        |    searchBy                    |       credentials        |usertype   |  CriteriaType  |
 #      |     Multiple_PLB_ProvAdmin     |       PROV_Admin         |PROV       | Multiple PLB   |
 #      |     byElectronicPaymentNo      |       PROV_Admin         |PROV       | Multiple PLB   |
 #      |     byElectronicPaymentNo      |       PROV_Admin         |PROV       | Multiple PLB   |
 #      |     byElectronicPaymentNo      |       PROV_Gen           |PROV       | Multiple PLB   |
        |     byElectronicPaymentNoRemit |       PROV_Admin         |PROV       | RemitDetail    |
        
        

Scenario Outline: Remittance Detail Validations for Patient, Rendering Provider for Provider

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     #And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Enter Electronic Payment Number for Rendering Provider
     Then Validate Sort By - Patient Last Name for "<usertype>" 
     Then Validate Sort By - Rendering Provider Last Name for "<usertype>" 

Examples:     
       
        |    searchBy                   |       credentials        |usertype   |  
   #     |     Multiple_PLB_ProvAdmin    |       PROV_Admin         |PROV       |
   #     |     Multiple_PLB_ProvGen      |       PROV_Gen           |PROV       |
         |     byElectronicPaymentNoRemit      |       PROV_Admin           |PROV       |


        
Scenario Outline: Remittance Detail multiple PLB Adjustments for Provider 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Payment Number based on "<CriteriaType>"
     #And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Validate Payment with Multiple PLB Adjustments for UPA 

Examples:

        |    searchBy                       |       credentials        |usertype   |   CriteriaType  |
        |     Multiple_PLB_ProvAdmin    |       PROV_Admin         |PROV       |   MultiplePLB   |
 #      |     Multiple_PLB_ProvGen          |       PROV_Gen           |PROV       |  Multiple PLB   |
          
                    
Scenario Outline: Remittance Detail PLB Adjustments Only for Provider
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Payment Number based on "<CriteriaType>"
     #And Enter Electronic Number for Adjustment Only Criteria
     And Validate PLB Adjustment Only for UPA
     
Examples:

          |       searchBy               |      credentials      |usertype   |   CriteriaType  |
          |      PLB_Adj_Only_ProvAdmin  |     PROV_Admin        |PROV       |      PLB        |
#          |      PLB_Adj_Only_ProvGen    |     PROV_Gen          |PROV       |     
          

# Data is not coming for Tricare Schema - so no TIN     
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
          
@US2707347          
Scenario Outline: Remittance Detail payer column relabel for Provider 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     Then Validate that Payer/Patient column name is changed to Payer 

Examples:

        |    searchBy                   |       credentials        |usertype   |  
        |     Multiple_PLB_ProvAdmin    |       PROV_Admin         |PROV       |
        #|     Multiple_PLB_ProvGen      |       PROV_Gen           |PROV       |
        
@US2707342 
Scenario Outline: Remittance Detail Page UI Functionality for CSR 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Check Number and click search
     Then Click on Payment Number Link and Validate the Download 835 option is displayed

Examples:

        |    searchBy                   |       credentials        |usertype   |  
        |  generalPaymentForTIN_90days  |       PROV_Admin         |PROV       |
        | generalPaymentForTIN_90days   |       PROV_Gen           |PROV       |
        
@US2707374 
Scenario Outline: Remittance Detail Page UI Functionality for Patient Payements (Search Remittance  --> Remittance Detail)
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Check Number and click search
	 Then Validate and click on payment number
     Then Validate all Headers in the Page for Payer
     Then Validate Column Headers in the grid for remittance detail Page
Examples:

        |    searchBy                   |       credentials        |usertype   |  
        |  generalPaymentForTIN_90days  |       PROV_Admin         |PROV       |
        | generalPaymentForTIN_90days   |       PROV_Gen           |PROV       |
        
@US2707344 
Scenario Outline: Remittance Detail UI Functionality for Complaint patient payments CSR
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     Then User clicks on Search Remittance link for UPA
     And Enter Check Number and click search
     Then Validate the EPRA and Payer PRA column in Search Remittance Page for "<type>"

Examples:

        |    searchBy                   |       credentials        |usertype   |  type  |
        |  generalPaymentForTIN_90days  |       PROV_Admin         |PROV       |  UPA   |
        | generalPaymentForTIN_90days   |       PROV_Gen           |PROV       |  UPA   |
        