#Author: Mohammad Khalid
Feature: Access Payments - Search Remittance - Provider - Page Text QA


@UPA_SR_US2955421
Scenario Outline: To test page text messaging on Serach Remittance for Provider User

Given User navigates to UPA portal and enters "<userType>" and login
When User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
Then User clicks on Search Remittance link for UPA
And User verifies page text message "<PageTextMsg>"



 Examples:
 |    userType     |   searchCriteria        | tinType	|		portalAccess	| PageTestMsg  |
 |    PROV_Admin   |   PremiumOrStandardTIN  |	AO	    |		Premium     	|PremiumPrvAdm |
 |    PROV_Admin   |   PremiumOrStandardTIN  |	AO	    |		Standard     	|StandardPrvAdm|
 |    PROV_Gen     |   PremiumOrStandardTIN  |	AO	    |		Premium     	|PremiumPrvGen |
 |    PROV_Gen     |   PremiumOrStandardTIN  |	AO	    |		Standard     	|StandardPrvAdm|    