
#Author: Athyusha Thota

@UPARemitDetail  @UPARegression @BothCSRUPAScenarios 
Feature: UPA Remittance Detail Billing Service

 
Scenario Outline: Remittance Detail UI and FISL Validations for BS User

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
    # And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Enter Electronic Payment Number based on "<CriteriaType>"
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
         |        searchBy                    |       credentials      | usertype   |   CriteriaType   |
 #       |        Multiple_PLB_BSAdmin        |       BS_Admin         |  BS        | RemitDetail      |
   #     |        Multiple_PLB_BSAdmin        |       BS_Gen           |  BS        | RemitDetail      |
         |        byElectronicPaymentNoRemitBS|       BS_Admin         |  BS        | RemitDetailBS    |
        
        
Scenario Outline: Remittance Detail Validations for Patient, Rendering Provider for BS

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Electronic Payment Number based on "<CriteriaType>"
     #And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     Then Validate Sort By - Patient Last Name for "<usertype>" 
     Then Validate Sort By - Rendering Provider Last Name for "<usertype>" 

Examples:     
       
         |        searchBy                    |       credentials      | usertype   | CriteriaType   | 
         |        byElectronicPaymentNoRemitBS|       BS_Admin         |  BS        | RemitDetailBS   | 
    #     |        Multiple_PLB_BSAdmin    |       BS_Admin         |  BS        |
       #  |        Multiple_PLB           |       BS_Gen           |  BS        |
               
 
Scenario Outline: Remittance Detail multiple PLB Adjustments for BS 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Electronic Payment Number based on "<CriteriaType>"
     #And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Validate Payment with Multiple PLB Adjustments for UPA 

Examples:
           |        searchBy              |       credentials      | usertype   | CriteriaType   |  
           |      Multiple_PLB_BSAdmin    |       BS_Admin         |  BS        | RemitDetailBS   | 
   #        |      Multiple_PLB            |       BS_Gen           |  BS        |
          
          
 @UPARemitDetailBS        
Scenario Outline: Remittance Detail PLB Adjustments Only for BS
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Electronic Payment Number based on "<CriteriaType>"
    # And Enter Electronic Number for Adjustment Only Criteria
     And Validate PLB Adjustment Only for UPA
     
Examples:

         |        searchBy              |       credentials      | usertype   |   CriteriaType   |  
         |      PLB_Adj_Only_BSAdmin    |       BS_Admin         |  BS        | RemitDetailBS    | 
 #        |        PLB_Adj_Only_BSAdmin    |       BS_Admin         |  BS        |
  #       |        PLB Adj Only    |       BS_Gen           |  BS        |

# Data is not coming from DB for this scenario
Scenario Outline: Remittance Detail Tricare Validation for BS

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
   #  And User enters tin for UPA "<Search Criteria>" for BS
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking
     
Examples:

         |        searchBy           |   credentials     | usertype   |  
         |       Tricare_BS          |   BS_Admin        |  BS        |
         |       Tricare_BS          |   BS_Gen          |  BS        |         
          
@US2707347
Scenario Outline: Remittance Detail payer column relabel for BS 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Electronic Number for Tricare Masking Criteria
     Then Validate that Payer/Patient column name is changed to Payer 

Examples:

        |    searchBy                   |       credentials        |usertype   |  
		|       PLB_Adj_Only_BSAdmin    |       BS_Admin           |  BS        |
   #    |      Multiple_PLB             |       BS_Gen             |  BS        |
        
        
@US2707342  
Scenario Outline: Remittance Detail UI Functionality for Complaint patient payments 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Check Number and click search
     Then Click on Payment Number Link and Validate the Download 835 option is displayed

Examples:

        |    searchBy                   |       credentials        |usertype   |  
		| generalPaymentForTIN_90days   |       BS_Admin           |  BS        |
        | generalPaymentForTIN_90days   |       BS_Gen             |  BS        |
        
@US2707374  
Scenario Outline: Remittance Detail Page UI Functionality for Patient Payements (Search Remittance  --> Remittance Detail)
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Check Number and click search
	 Then Validate and click on payment number
     Then Validate all Headers in the Page for Payer
     Then Validate Column Headers in the grid for remittance detail Page
Examples:

        |    searchBy                   |       credentials        |usertype   |  
		| generalPaymentForTIN_90days   |       BS_Admin           |  BS        |
        | generalPaymentForTIN_90days   |       BS_Gen             |  BS        |
        
@US2707344  
Scenario Outline: Remittance Detail UI Functionality for Complaint patient payments UPA
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Check Number and click search
     Then Validate the EPRA and Payer PRA column in Search Remittance Page for "<type>"

Examples:

        |    searchBy                   |       credentials        |usertype    |  type   |
		| generalPaymentForTIN_90days   |       BS_Admin           |  BS        |  UPA    |
        | generalPaymentForTIN_90days   |       BS_Gen             |  BS        |  UPA    |
