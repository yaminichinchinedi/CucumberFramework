#Author: Athyusha Thota

@CSRRegression  @CSRBSInfoTab @US2872239
Feature: CSR Billing Service Info Tab

Scenario Outline: BS Info Functionality 
 
   Given User navigates to CSR portal and enters "<credentials>" and login
   When Click on Billing Service Info Link CSR
   Then Select "<usertype>" and TIN for "<searchBy>" 
  # And validate BS Info Page functionality for "<usertype>"
   Then valdiate BS Info Page functionality
   And validate Provider Tin Approval and functionality check   
   

Examples:

        |    usertype     |   credentials     | searchBy |
        |      BS         |      Super        | BS       |
        
       
Scenario Outline: - verify search results for search remittance

Given User navigates to CSR portal and enters "<credentials>" and login
Then User clicks on Search Remittance link
  Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button     
Then User enters "<Search Criteria>" and click on search button.
Then verify search results for "<Criteria Type>"	

Examples:
|	Search Criteria	                      | credentials |   usertype    |        Criteria Type            |priority  |searchBy|
|	       byElectronicPaymentNo  	      |	Super       |    PROV       |        byElectronicPaymentNo  	                |	1        |generalPaymentForTIN_90days|        
     

     
     