#Author: Athyusha Thota
@UPARegression 
Feature: UPA Provider Claim Detail
     
@UPAClaimDetailProv
Scenario Outline: Claim Detail UI Functionality and Data Check

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
     Then User clicks on Search Remittance link for UPA
     Then User enters "<searchBy>" and click on search button.
     Then Verify Claim Detail UI vs FISL Response for "<usertype>"
     Then Validate all Headers in the Page for Claim Detail Page
     Then Validate Column Headers in the Page for Claim Detail Page
     And  Validate Column Footers in the Page for Claim Detail Page
     And Check RMK Code Pop Up
     And Check Adj Reason Code Pop Up
     Then Validate Payment Number Hyper Link in UPA

Examples:

         |  searchBy            | credentials  |userType   | searchCriteria       | portalAccess | tinType |
         |   byElectronicPayNum | PROV_Admin   |PROV       | TinWthatlstOnePayNum | Premium      |   VO    |
         |   byElectronicPayNum | PROV_Gen     |PROV       | TinWthatlstOnePayNum | Premium      |   VO    |
        
             
# Tricare data is not coming up  
Scenario Outline: Claim Detail Tricare Functionality

     Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA Search Remittance Tin Page for "<searchBy>" through "<usertype>" and click on continue button 
     Then User clicks on Search Remittance link for UPA
     And Enter Electronic Number for Tricare Masking Criteria
     And Validate Tricare Masking for Claim Detail Page
     
Examples:

         |    searchBy            |   credentials     |usertype   |
         |       Tricare          |   PROV_Admin      | PROV      |
         |       Tricare          |   PROV_Gen        | PROV      |      
        

     
        
     
     
     
     
     
     
     
     
     