#Author: Amit Kushwah
Feature: UPA Search Remittance for Standard portal access
		@US2990582
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then Validate search button is enabled or disabled for "<portalAccess>"
	Examples:
		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AV   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AV   |
