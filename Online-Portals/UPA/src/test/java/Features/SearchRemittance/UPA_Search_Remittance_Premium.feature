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




		@US2948676
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then Validate search button is enabled or disabled for "<portalAccess>"
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"	
	Then User clicks on Print Search Result button.
	Then Validate the data of Print Search Remmit Page.

	Examples:
		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  AO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  AV   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  AO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  AV   |

		@US2793563
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then verify error messages in search results
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"	

	Examples:
		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |		MoreThan13Months	   |  AO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |		MoreThan13Months	   |  VO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |		MoreThan13Months	   |  AV   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |		MoreThan13Months	   |  AO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |		MoreThan13Months	   |  VO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |		MoreThan13Months	   |  AV   |






