#Author: Sunanda
@UPAOptumPaySolutions
Feature: - Optum Pay Solutions - VO Provider Options Page 

  @OptumPaySolutionsUPA1 @OPSUPA @US3115910
		Scenario Outline: - Optum Pay Solutions - VO Provider Options Page 
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then  User verifies their plan type information form the tiles
     Examples:
   	  |    userType     |   accessType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   PROV_Admin    |     PROV     	|		 	TinWithLessThnMaxUsr		|			Premium			|		VO			|
   @US2948672   
	Scenario Outline: - Optum Pay Solutions - AO Provider Options Page 
   Given User navigates to UPA portal and enters "<userType>" and login
   When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" Portal Experience.
   And   User clicks on Optum Pay Solutions tab
   Then  User verifies Optum Pay Solution Tab for standard user with "<trialStatus>" and "<portalAccess>"
     Examples:
   	  |    userType     |   accessType  | 			searchCriteria				|		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Standard			|		AO			|     A     |					P					 |				PD			 |
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Standard			|		AO			|     I     |					A					 |				PD			 |
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Premium			  |		AO			|     A     |					P					 |				PS			 |
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Premium			  |		AO			|     I     |					A					 |				PS			 |
		 #P- Pending, PD-Post Default
		 #A- Active,  PS-Post Selection
		 #I- Inactive
		 
		#Author:Sayonee 
	 @UPAUS3060820
	 Scenario Outline: - Optum Pay Solutions - Verify Post Trial PopUp
   Given User navigates to UPA portal and enters "<userType>" and login
   When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" Portal Experience.
   And   User clicks on Optum Pay Solutions tab
   Then Verify the Cancellation Popup based on "<trialStatus>"
     Examples:
   	  |    userType     |   accessType  | 			searchCriteria				|		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Premium			  |		AO			|     I     |					A					 |				PS			 |
      
   @US3060825
	 Scenario Outline: - Optum Pay Solutions - Verify During Trial PopUp
   Given User navigates to UPA portal and enters "<userType>" and login
   When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" Portal Experience.
   And   User clicks on Optum Pay Solutions tab
   Then Verify the Cancellation Popup based on "<trialStatus>"
     Examples:
   	  |    userType     |   accessType  | 			searchCriteria				|		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
      |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Premium			  |		AO			|     A     |					P					 |				PS			 |