#Author: Sayonee
@UPAHomePageAlert
Feature: UPA HomePage Alert 
@UPAUS2948688
	Scenario Outline: - Optum Pay Solutions - AO Provider Options Page 
   Given User navigates to UPA portal and enters "<userType>" and login
   When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" Portal Experience.
   And   User verifies HomePage Alert depending upon "<portalAccess>" and "<tinType>"
   
     Examples:
   	  |    userType     |   accessType  | 			searchCriteria				|		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Standard			|		AO			|     A     |					P					 |				PD			 |
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Premium			  |		AO			|     A     |					P					 |				PS			 |

  @US3179215
  Scenario Outline: UPA Billing Service Home Page Carousel Text Validation
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Verify Home Page Carousel Text for "<userType>"
    Examples:
      | userType | accessType |
      | BS_Admin | BS         |
      | PAY_Admin | PAY       |