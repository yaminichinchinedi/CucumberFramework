#Author: Amit Kushwah
@UPARegression
Feature: UPA Search Remittance for Standard portal access
		@US2990582
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then Validate search button is enabled or disabled for "<portalAccess>"
	Examples:
		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AV   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Standard    |TinWthatlstOnePayNum   |  AV   |

		
		 @UPAUS3438484
	Scenario Outline: Search Remittance Page Text Validation
		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Search Remittance link for UPA
		Then User Enters Search Remittance tin and click on search button for "<userType>".
		Then Validate Search Remittance Page Text for "<credentials>" for "<portalAccess>"
		Examples:
			| credentials | userType | searchCriteria 					 | tinType | portalAccess |
			| BS_Admin    | BS       | PostTrial and NotPaid     | AO      | Standard     |
			| BS_Gen      | BS       | PostTrial and NotPaid     | AO      | Standard     |
			| BS_Admin    | BS       | WithinTrial and NotPaid   | AO      | Standard     |
			| BS_Gen      | BS       | WithinTrial and NotPaid   | AO      | Standard     |
		