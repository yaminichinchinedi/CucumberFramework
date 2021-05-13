#Author: Athyusha Thota
#Stabilized By: Sunanda

@CSRRegression  @CSRBSInfoTab
Feature: CSR Billing Service Info Tab
@US2872239
Scenario Outline: Biiling Service Information Functionality for "<credentials>"
 
   Given User navigates to CSR portal and enters "<credentials>" and login   
   And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   When  Click on Billing Service Info Link CSR   
   Then  User Enters tin and click on search button for "<userType>" on CSR Billing Service Info page.
   Then  valdiate BS Info Page functionality 
   And   validate Provider Tin Approval and functionality check   
   
Examples:
        |    userType     |   credentials     |searchCriteria| 
        |      BS         |      Super        | ActiveBSTin  |
        
       
