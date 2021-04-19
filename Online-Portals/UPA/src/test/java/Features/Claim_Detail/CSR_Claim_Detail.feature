#Author: Athyusha Thota

 @CSRRegression @CSRSanity @BothCSRUPAScenarios
Feature: CSR Claim Detail

@CSRClaimDetail
  Scenario Outline: Claim Detail UI Functionality and Data Check
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then User clicks on Search Remittance link
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
 
        |		searchCriteria			  |	credentials	 | portalAccess  |tinType |userType | searchBy                   |
		    |	TIN_FOR_CLAIM_DETAILS	  |	Super        |	  Premium    |  AO    | PROV    | byElectronicPaymentNoRemit |

        
# Data is not there at backend, so it fails near TIN 
Scenario Outline: Claim Detail Tricare Functionality

    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Search Remittance link
    And User enters tin for Tricare Masking Criteria
    And Enter Electronic Number for Tricare Masking Criteria
    And Validate Tricare Masking
     
Examples:

         |   credentials     |
         |    Super          |
         |    RW             |
         |    RO             |
        
        
        
                
        
             
     
     
     
     
     
     
     
     
     
     
     
     