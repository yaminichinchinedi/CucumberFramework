#Author: Rahul Krishna
Feature: CSR Search Remittance for Premium access portal			


@SrchRemitt123
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	#Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<portalAccess>" through "<usertype>" click on continue button
	Then User enters tin for Search Remittance page for "<searchRemitorPymntTIN>","<tinType>","<portalAccess>" and "<usertype>" click on continue button
	  Then User enters "<Search Criteria>" and click on search button.
  Then Validate in Grid search Results,Type column or Payment Status field not displayed and is relabeled to ACH Trace
  Then Validate Claim Count column is present which appears as Hyperlink for nonzero claim count and on click redirects to Remittance Detail page
  Then Validate ePRA,pPRA and 835 fields are enabled 
   Then Validate Archived Coulmn,Save Archived button is relabeled to Payment Status and Save button respectively
   Then Validate that Search Criertia box do not contain hyphen following colon on each search criteria option
    

  
	
	Examples:
		|		Search Criteria			    |	credentials	  | portalAccess |   searchRemitorPymntTIN  |tinType|usertype|
		|	byElectronicPayNum	      |	Super    |	  Premium    |   TinWthatlstOnePayNum    |  VO   |PROV|
		|	byElectronicPayNum	      |	Super    |	  Standard    |   TinWthatlstOnePayNum    |  AO   |PROV|
		
	