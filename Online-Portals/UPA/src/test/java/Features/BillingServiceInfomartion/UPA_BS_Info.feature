#Author: Vinay Raghumanda
@UPABSInfo  
Feature: UPA Billing Service Information Functionality

  @US3179215 @US3438484
  Scenario Outline: Billing Service Information Page Text Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then User clicks on Billing Service Information tab
    Then Validate Billing Service Information Page Text for "<credentials>" for "<portalAccess>"
    Examples:
      | credentials | userType | portalAccess | tinType | searchCriteria       |
      | PROV_Admin  | PROV     | Premium      | AO      | PremiumOrStandardTIN |
      | PROV_Admin  | PROV     | Premium      | VO      | PremiumOrStandardTIN |
      | BS_Admin    | BS       | Premium      | AO      | Last 60 days         |
      | BS_Admin    | BS       | Standard     | AO      | PostTrial and NotPaid   |

#Author:Sayonee
      @UPAUS2820687
   Scenario Outline: UPA Porvider Billing Service Information Page Text Verification
      Given User navigates to UPA portal and enters "<credential>" and login
       And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
      Then User clicks on Billing Service Information tab
       Then User verifies the page text for provider based on the "<tinType>" and "<portalAccess>"
   Examples:
       |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
       |   PROV_Admin    |     PROV     	|		 	PostTrial and Paid		|			Premium			|		VO			|
       |   PROV_Admin    |     PROV     	|		 	PostTrial and Paid		|			Premium			|		AO			|
       |   PROV_Admin    |     PROV     	|		 	PostTrial and NotPaid		|			Standard	|		AO			|
      