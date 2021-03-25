#Author: Sunanda

@homePageUPA
Feature: Post-Login T&C Page and Bring More Power Page Functionality 

  @UPABringMorePage @stars
  Scenario Outline: Bring More Power Page Functionality for user associated only with ACH TINs
    Given Is to verify if atleast one standard "<portalAccess>" TIN with "<tinType>" is associated with "<userType>" and has "<trialStatus>" with "<SelectedOrDefault>" and "<statusOfStandardRecd>"
   	And User navigates to UPA portal and enters "<userType>" and login when the Terms and Conditions are not accepted
    Then User verifies the presence of Bring More Power pop-up and clicks No Thanks
    And   User clicks on UPA logout
    And User navigates to UPA portal and enters "<userType>" and login
    Then User verifies the presence of Bring More Power pop-up and clicks I Accept
    And User verifies the insertion of pending PS record and inactivation of PD record in the product selection table for all the associated standard tins
    And User verifies if TC_ACCPT_IND is flipped to Y
    And   User clicks on UPA logout
    And User navigates to UPA portal and enters "<userType>" and login
    Then User verifies if homepage is presented when TC_ACCPT_IND is Y
    And   User clicks on UPA logout
    And User navigates to UPA portal and enters "<userType>" and login when the Terms and Conditions are not accepted
    Then The Terms and Conditions page is displayed
	  Then User Accept the Terms and Conditions and Submit
   Examples:
      |        userType        |   accessType   |		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
      | PROV_Admin_HomePage_AO |   PROV     		|		Standard			  |		AO			|     A     |					P					 |				PD			 |
      
       #Author : Vinay Raghumanda
  @US3179215
  Scenario Outline: BS and Payer admins Home Page Carousel Text Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Verify Home Page Carousel Text for "<userType>" with "<credentials>"
    Examples:
      | credentials | userType  |
      | BS_Admin    | BS_Admin  |
      | PAY_Admin   | PAY_Admin |

  @US3179215
  Scenario Outline: Provider Home page Carousel Text Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then Verify Home Page Carousel Text for "<userType>" with "<credentials>"
    Examples:
      | credentials | userType | searchCriteria       | tinType | portalAccess |
      | PROV_Admin  | PROV     | PremiumOrStandardTIN | AO      | Premium      |
      | PROV_Admin  | PROV     | PremiumOrStandardTIN | AO      | Standard     |
      | PROV_Gen    | PROV     | PremiumOrStandardTIN | AO      | Premium      |
      | PROV_Gen    | PROV     | PremiumOrStandardTIN | AO      | Standard     |
      | PROV_Admin  | PROV     | PostTrial and Paid   | VO      | Premium      |
      
      
      
      
      