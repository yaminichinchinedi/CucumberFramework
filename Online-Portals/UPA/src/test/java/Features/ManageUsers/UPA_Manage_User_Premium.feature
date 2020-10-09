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
 
    
 Scenario Outline: US2711909_1 UPA Provider Admin ManageUsers_PurgeUser Checkbox
    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on Manage User Link
	  Then Select one of the Active User and select Associate BS User to all Providers as No
	  Then Enter "<productSelection>" TIN with "<tinTyp>" click on Add TIN Association,Click on save and User updated
      Examples:
      |    userType     |   accessType  |	productSelection|tinTyp|	
      |      BS_Admin   |   BS     	    |Premium      | AO  | 
      |      BS_Admin   |   BS     	  |Premium        | VO   |
      
      
       @UPAUS2879930
  Scenario Outline: Access Payments - Manage users Provider for Premium Experience
 
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<portalGroupName>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then User verifies Add User button visiblity for "<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.         
     Examples:
   	  |    userType     | accessLevelOfNewUser	| 		portalGroupName       	|		portalAccess	| tinType		|System Mode|
      |      PROV_Admin | 	    Admin			      |  		LegacyOrPremiOrStandard	|			Premium			|		AO			|  FEEBASED |
      |      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Premium			|		VO			|  FEEBASED |
      |      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Premium			|		AO			|  LEGACY |
      |      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Premium			|		VO			|  LEGACY |
     
      
      
      @UPAUS2879930_BS
    Scenario Outline: Access Payments - Manage users Provider for Premium Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on Manage User Link
    Then User verifies Add User button visiblity for "BillingService" based on System Mode like FeeBased or Legacy.
   # Then User verifies Add User button visiblity for "<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.         
             
	  
	  Examples:
		      |    userType     | System Mode|  
		      |      BS_Admin   | FEEBASED   |
		       |      BS_Admin  | LEGACY  |
 
 
 @UPAUSAccessPay12
 @UPAUS2879930_Pay
  Scenario Outline: Access Payments - Manage users Provider for Premium Experience
	Given User navigates to UPA portal and enters "<userType>" and login
	When  Click on Manage User Link
   Then User verifies Add User button visiblity for "Payer" based on System Mode like FeeBased or Legacy.         
	Examples:
      |    userType     |		System Mode	|
      |     PAY_Admin   |  		FEEBASED	|
      |     PAY_Admin   |  		LEGACY		|     
           
      	