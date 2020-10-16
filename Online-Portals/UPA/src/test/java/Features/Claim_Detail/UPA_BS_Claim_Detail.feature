#Author: Athyusha Thota

@UPAClaimDetail  @UPARegression @BothCSRUPAScenarios 

Feature: UPA BS Claim Detail

@UPAClaimDetailBS
Scenario Outline: Claim Detail UI Functionality and Data Check

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     #And Enter Electronic Number for Mutliple PLB Adjustments Criteria
     And Enter Electronic Payment Number based on "<CriteriaType>"
     Then Verify Claim Detail UI vs FISL Response for "<usertype>"
     Then Validate all Headers in the Page for Claim Detail Page
     Then Validate Column Headers in the Page for Claim Detail Page
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     Then Validate Payment Number Hyper Link in UPA
     
     
 Examples:

          |        searchBy                |       credentials      | usertype   | CriteriaType     |
          | byElectronicPaymentNoRemitBS   |       BS_Admin         |  BS        | RemitDetailBS    |
          |        Multiple_PLB_BSAdmin    |       BS_Admin         |  BS        | RemitDetailBS    |
  #       |        Multiple_PLB_BSGen      |       BS_Gen           |  BS        | RemitDetailBS    |
             

Scenario Outline: Claim Detail Tricare Functionality

     Given User navigates to UPA portal and enters "<credentials>" and login
     Then User clicks on Search Remittance link for UPA
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking for Claim Detail Page
     
Examples:

         |        searchBy           |   credentials     | usertype   |  
         |       Tricare_BS          |   BS_Admin        |  BS        |
         |       Tricare_BS          |   BS_Gen          |  BS        |  
        
     
     
     
     
     
     
     
     
     