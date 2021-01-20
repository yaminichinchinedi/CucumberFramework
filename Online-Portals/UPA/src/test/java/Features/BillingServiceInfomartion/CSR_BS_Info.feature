#Author: Athyusha Thota

@CSRRegression  @CSRBSInfoTab @US2872239 
Feature: CSR Billing Service Info Tab
@hard
Scenario Outline: BS Info Functionality 
 
   Given User navigates to CSR portal and enters "<credentials>" and login
   When Click on Billing Service Info Link CSR
   Then Select "<searchBy>" and TIN for "<usertype>" 
   Then valdiate BS Info Page functionality 
   And validate Provider Tin Approval and functionality check   
   

Examples:

        |    usertype     |   credentials     | searchBy |
        |      BS         |      Super        | BS       | 
        
       
