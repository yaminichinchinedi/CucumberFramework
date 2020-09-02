#Author: amit_kushwah@optum.com
@UPAManageUsers_Premium
Feature: UPA Manage User Functionality for Premium TIN

  @UPAManageUsers_US2775740
		Scenario Outline: Access Payments - Manage users Provider for Premium Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Provider user
    Then Verify user List on UI from DB for "<userType>" using "<searchCriteria>"
    Then verify Add user button is enabled.
    Then Verify Access level and Email notification indicator can be updated for "<userType>".
    Then User perform validation by adding TIN with same TIN 
      Examples:
   	  |    userType     |   accessType  |		accessLevelOfNewUser	| 			searchCriteria				|		portalAccess	| tinType		|
      |      PROV_Admin |   PROV     		|					General			    |  		TinWithMoreThnMaxUsr 		|			Premium			|		AO			|
      |      PROV_Admin |   PROV     		|					General			    | 	 	TinWithMoreThnMaxUsr		|			Premium			|		AV			|
      |      PROV_Admin |   PROV     		|					General			    | 	 	TinWithMoreThnMaxUsr		|			Premium			|		VO			|
      	