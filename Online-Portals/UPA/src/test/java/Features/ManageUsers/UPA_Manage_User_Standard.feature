#Author: amit_kushwah@optum.com
@UPAManageUsers_Standard
Feature: UPA Manage User Functionality for Standard TIN

@UPAManageUsers_US2775740	
		Scenario Outline: Access Payments - Manage users Provider for Standard Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then Verify user List on UI from DB for "<userType>" using "<searchCriteria>"
    Then verify Add user button is enabled.
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Provider user
    Then verify Add user button is disabled.
      Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	| 				searchCriteria			|		portalAccess	| tinType		|
      |      PROV_Admin |   PROV     		|				General				    |  		TinWithLessThnMaxUsr 		|			Standard		|		AO			|
      |      PROV_Admin |   PROV     		|				General				    | 	 	TinWithLessThnMaxUsr		|			Standard		|		AV			|
      
      @UPAManageUsers_US2775740_03	@stndrd
		Scenario Outline: Access Payments - Manage users Provider for Standard Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then verify Add user button is disabled.
    Then Verify user List on UI from DB for "<userType>" using "<searchCriteria>"
    Then Verify Access level and Email notification indicator can be updated for "<userType>".
    Then User perform validation by adding TIN with same TIN 
      Examples:
      |    userType     |     	searchCriteria			|		portalAccess	| tinType		|
      |      PROV_Admin |  	TinWithMoreThnMaxUsr 		|			Standard		|		AO			|
      |      PROV_Admin |  	TinWithMoreThnMaxUsr		|			Standard		|		AV			|
    
     
     @UPAUS2879930 @OctRelease
      Scenario Outline: Access Payments - Manage users Provider for Standard Experience
 
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<portalGroupName>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then User verifies Add User button visiblity for "<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.         
     Examples:
   	  |    userType     | accessLevelOfNewUser	| 		portalGroupName       	|		portalAccess	  | tinType		|System Mode|
      |      PROV_Admin | 	    Admin			      |  		LegacyOrPremiOrStandard	|			Standard			|		AO			|  FEEBASED |
      |      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Standard			|		AO			|  LEGACY |  