#Author: Athyusha Thota

@UPAClaimDetail  @UPARegression @BothCSRUPAScenarios 

Feature: UPA BS Claim Detail

@UPAClaimDetailBS
Scenario Outline: Claim Detail UI Functionality and Data Check

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
     Then User clicks on Search Remittance link for UPA
     Then User Enters tin and click on search button for "<userType>".
     Then User enters "<searchBy>" and click on search button.
     Then Verify Claim Detail UI vs FISL Response for "<usertype>"
     Then Validate all Headers in the Page for Claim Detail Page
     Then Validate Column Headers in the Page for Claim Detail Page
     And  Validate Column Footers in the Page for Claim Detail Page
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     Then Validate Payment Number Hyper Link in UPA
        
 Examples:

          |        searchBy                |       credentials      | usertype   | searchCriteria       | portalAccess | tinType |
          | byElectronicPaymentNo          |       BS_Admin         |  BS        |byElectronicPaymentNo | Premium      |   AO    |
  
  
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
        
     
     
     
     
     
     
     
     
     