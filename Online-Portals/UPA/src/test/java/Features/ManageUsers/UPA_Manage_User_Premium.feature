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
      
 #     |      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Premium			|		AO			|  LEGACY |
 #     |      PROV_Admin |  	    Admin 			    | 	 	LegacyOrPremiOrStandard |			Premium			|		VO			|  LEGACY |
     
      
      
      @UPAUS2879930 @OctRelease
    Scenario Outline: Access Payments - Manage users Provider for Premium Experience
    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on Manage User Link
    Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
        
             	  Examples:
		      |    userType     | System Mode|  
		      |      BS_Admin   | FEEBASED   |
		      |      BS_Admin  | LEGACY  |
 
 

 @UPAUS2879930 @OctRelease
  Scenario Outline: Access Payments - Manage users Provider for Premium Experience
	Given User navigates to UPA portal and enters "<userType>" and login
	When  Click on Manage User Link
  Then User verifies Add User button visiblity for "<portalAccess>" and "<System Mode>" based on "<userType>" like FeeBased or Legacy for UPA
	Examples:
      |    userType     |		System Mode	|
      |     PAY_Admin   |  		FEEBASED	|
      |     PAY_Admin   |  		LEGACY		|     

#Author: Sunanda      
   @UPAPageTextPremium        
  Scenario Outline: Access Payments - Manage users Page Text Premium During and Post Trial
	Given User navigates to UPA portal and enters "<userType>" and login
	When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" Portal Experience.
	When  Click on Manage User Link  
	Then  User verifies page text and footer 
	Examples:
	 |    userType     |   accessType   | 			searchCriteria				|		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
	 |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Premium			  |		AO			|     A     |					P					 |				PS			 |
   |      PROV_Admin |   PROV     		|		 	TinDuringOrPostTrial		|			Premium			  |		AO			|     I     |					A					 |				PS			 |
	 	