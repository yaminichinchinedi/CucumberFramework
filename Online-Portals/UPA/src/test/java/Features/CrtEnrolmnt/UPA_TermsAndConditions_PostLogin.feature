#Marsha
@PostLoginTermsAndConditionsPage
Feature: Terms and Conditions-Post Login

	@US2948683TnC
	Scenario Outline: T&C Re-acceptance - All-Payer Accept 
	Given User navigates to UPA portal and enters "<userType>" and login when the Terms and Conditions are not accepted
	Then The Terms and Conditions page is displayed
	Then The Terms and Conditions pdf is verified
	Then User Accept the Terms and Conditions and Submit
	
	 Examples:
	      |      userType       |   accessType|
	      |      PROV_Gen       |   PROV      |
	      |      BS_Admin       |   BS     	  |
	      |      BS_Gen         |   BS     	  |
	      |      PAY_Admin     	|   PAY       | 
	      |      PAY_Gen       	|   PAY       |
	    