#Author: amit_kushwah@optum.com
@UPAManageUsers_Premium  @cloudUPAManageUsers
Feature: UPA Manage User Functionality for Premium TIN

  @UPAManageUsers_US2775740 @OctRelease 
		Scenario Outline: Access Payments - Manage users Provider for Premium Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Provider user
    Then Verify user List on UI from DB for "<userType>" using "<searchCriteria>"
    Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
    Then Verify Access level and Email notification indicator can be updated for "<userType>".
    Then User perform validation by adding TIN with same TIN 
    
    
  Examples:
   	  |    userType     |   accessType  |		accessLevelOfNewUser	| 			searchCriteria				|		portalAccess	| tinType		| System Mode|
      |      PROV_Admin |   PROV     		|					General			    |  		TinWithMoreThnMaxUsr 		|			Premium			|		AO			| FEEBASED   |
      |      PROV_Admin |   PROV     		|					General			    | 	 	TinWithMoreThnMaxUsr		|			Premium			|		AV			| FEEBASED   |
      |      PROV_Admin |   PROV     		|					General			    | 	 	TinWithMoreThnMaxUsr		|			Premium			|		VO			| FEEBASED   |
 
    @US2801047 
 Scenario Outline: US2801047_ UPA Provider Admin ManageUsers_AddUserFunctionality for Premium Tins
    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on Manage User Link
	  Then Enter "<productSelection>" TIN with "<tinTyp>" click on Add TIN Association,Click on save and User updated
	   
      Examples:
      |    userType     |   accessType  |	productSelection|tinTyp|	
      |      BS_Admin   |   BS     	    |		Premium       | AO   | 
      |      BS_Admin   |   BS     	    |		Premium       | VO   |
      
      
       @UPAUS2879930 @OctRelease 
  Scenario Outline: Access Payments - Manage users Provider for Premium Experience
 
    Given User navigates to UPA portal and enters "<userType>" and login
    When  User Selects a tin on HomePage for "<portalGroupName>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
          
     Examples:
   	  |    userType     | accessLevelOfNewUser	| 		portalGroupName       	|		portalAccess	| tinType		|System Mode|
   	  |      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Premium			|		VO			|  FEEBASED |
      |      PROV_Admin | 	    Admin			      |  		LegacyOrPremiOrStandard	|			Premium			|		AO			|  FEEBASED |
      
      
      @UPAUS2879930 @OctRelease
    Scenario Outline: Access Payments - Manage users Provider for Premium Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on Manage User Link
    Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
        
             	  Examples:
		      |    userType     | System Mode|  
		      |      BS_Admin   | FEEBASED   |
 
 

 @UPAUS2879930 @OctRelease
  Scenario Outline: Access Payments - Manage users Provider for Premium Experience
	Given User navigates to UPA portal and enters "<userType>" and login
	When  Click on Manage User Link
  Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
	Examples:
      |    userType     |		System Mode	|
      |     PAY_Admin   |  		FEEBASED	|
      #|     PAY_Admin   |  		LEGACY		|     


  #Author : Vinay Raghumanda
  #(vo is part of US3438484 )
  @US3179215 @UPAUS3438484_1
  Scenario Outline: Manage Users Page Text Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on Manage User Link
    Then Validate Manage User Page Text for "<credentials>" for "<portalAccess>"
    Examples:
      | credentials | userType | portalAccess | tinType | searchCriteria       |
      | PROV_Admin  | PROV     | Premium      | AO      | PremiumOrStandardTIN |
      | PROV_Admin  | PROV     | Premium      | VO      | PremiumOrStandardTIN |
      | PROV_Admin  | PROV     | Standard     | AO      | PremiumOrStandardTIN |
      | BS_Admin    | BS       | Premium      | AO      | Last 60 days   |

  #Author: Mohammad Khalid    
  @UPAUS3601929_ManageUser
  Scenario Outline: Manage Users MFA Dialog Box Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    When Click on Manage User Link
    Then User validates MFA Dialog Box Title, Message, Yes and NO buttons for Manage User tab
    Examples:
      | credentials |
      | PROV_Admin  | 
  