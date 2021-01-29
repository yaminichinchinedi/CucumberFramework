#Author: Rahul Krishna
Feature: UPA Search Remittance for Premium access portal			

@UPAUS2879968 @OctRelease
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
  Then User enters "<Search Criteria>" and click on search button.
  Then Validate in Grid search Results,Type column or Payment Status field not displayed and is relabeled to ACH Trace
  Then Validate Claim Count column is present which appears as Hyperlink for nonzero claim count and on click redirects to Remittance Detail page
  Then Validate ePRA,pPRA and 835 fields are enabled 
   Then Validate Archived Coulmn,Save Archived button is relabeled to Payment Status and Save button respectively
   Then Validate that Search Criertia box do not contain hyphen following colon on each search criteria option
    

	
	Examples:
		|		Search Criteria			|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN        |tinType|
		|	byElectronicPayNum	  |	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |
		|	byElectronicPayNum  	|	PROV_Gen   	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |


@UPAUS2838204
	Scenario Outline: Validate Market type in Search remittance
	
		Given User navigates to UPA portal and enters "<credentials>" and login
		When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Search Remittance link for UPA
		Then Validate all the fields present in Search Remittance Page
		
		Examples:
			|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN        |tinType|
		 	|	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   			 |  AO   |
		