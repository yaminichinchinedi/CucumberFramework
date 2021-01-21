#Author: Sunanda
@OptumPaySolutionsUPA
Feature: - Optum Pay Solutions - VO Provider Options Page 

  @OptumPaySolutionsUPA1 @OPSUPA @US3115910
		Scenario Outline: - Optum Pay Solutions - VO Provider Options Page 
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then  User verifies their plan type information form the tiles
     Examples:
   	  |    userType     |   accessType  | 			searchCriteria				|		portalAccess	| tinType		|
      |      PROV_Admin |   PROV     		|		 	TinWithLessThnMaxUsr		|			Premium			|		VO			|