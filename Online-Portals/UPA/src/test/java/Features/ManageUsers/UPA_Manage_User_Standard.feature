
#Author: amit_kushwah@optum.com
@UPAManageUsers_Standard  @cloudUPAManageUsers
Feature: UPA Manage User Functionality for Standard TIN

@UPAManageUsers_US2775740	
		Scenario Outline: Access Payments - Manage users Provider for Standard Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then Verify user List on UI from DB for "<userType>" using "<searchCriteria>"
    Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA

    
    
      Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	| 				searchCriteria			|		portalAccess	| tinType		| System Mode|
      |      PROV_Admin |   PROV     		|				General				    |  		TinWithLessThnMaxUsr 		|			Standard		|		AO			| FEEBASED   |
      |      PROV_Admin |   PROV     		|				General				    | 	 	TinWithLessThnMaxUsr		|			Standard		|		AV		| FEEBASED   |
      
      @UPAManageUsers_US2775740_03	
		Scenario Outline: Access Payments - Manage users Provider for Standard Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then Verify user List on UI from DB for "<userType>" using "<searchCriteria>"
    Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
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
    Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
  
       
     Examples:
   	  |    userType     | accessLevelOfNewUser	| 		portalGroupName       	|		portalAccess	  | tinType		|System Mode|
      |      PROV_Admin | 	    Admin			      |  		LegacyOrPremiOrStandard	|			Standard			|		AO			|  FEEBASED |
      #|      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Standard			|		AO			|  LEGACY |  

