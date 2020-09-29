#Author: vinit_rohela@optum.com
@UPAManageUsers
Feature: UPA Manage User Functionality

@UPAManageUsers1
Scenario Outline: Verifies user list sorting is working correctly on Manage Users Tab
    Given User navigates to UPA portal and enters "<userType>" and login
     Then Select the TIN for "<accessType>" UPA Portal
     When Click on Manage User Link
     Then Verifies user list sorting is working correctly on Manage Users Tab
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |
      #|      PROV_Gen       |   PROV|
 
  Scenario Outline: Verifies Save & Cancel button functionlity for Access level changes for a Provider User
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies "<accessType>" Save & Cancel button functionlity for Access level changes for a Provider User
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: Verifies Tin Grid Details in Manage Users Tab
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies Tin Grid Details in Manage Users Tab
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: Verifies error messages and associated tins with a user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies error messages and associated tins with a user
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline:Verifies provider user details are read only on UPA
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies provider user details are read only on UPA
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: Verifies details for New Billing Service user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Billing Service user
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      BS_Admin   |   BS      	|		Administrator			|

  Scenario Outline: Verifies BS user details are read only on UPA
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies Payer "<accessType>" user details are read only on UPA
    Examples:
      |    userType     |   accessType  |
      |      BS_Admin   |   BS     	|
      
       Scenario Outline: Verifies Payer user details are read only on UPA
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies Payer "<accessType>" user details are read only on UPA
    Examples:
      |    userType     |   accessType  |
      |      PAY_Admin  |   PAY     	|

  Scenario Outline: Verifies details for New Payer user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Payer user
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PAY_Admin  |   PAY     	|		Administrator	    	|


  Scenario Outline: Verifies details for New Provider user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Provider user
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PROV_Admin |   PROV     	|		Administrator		    |
      
      
  @UPAManageUsers_US2769380  @UPA_AugRelease  
  Scenario Outline: UPA Manage User Add new Provider user using purged user email address
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Provider user using "<stsCode>"
    Then Validate status of purged user for "<userType>" in portal tables.
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|  stsCode	  |
      |      PROV_Admin |   PROV      	|		 Administrator		    |			PU			|
      
  @UPAManageUsers_US2769380 @UPA_AugRelease
  Scenario Outline: UPA Manage User Add New Payer and BS user using purged user email address
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Payer and BS user using "<stsCode>"
    Then Validate status of purged user for "<userType>" in portal tables.
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|		stsCode		|
      |      PAY_Admin  |     PAY     	|		    Administrator	   	|			PU			|
      |      BS_Admin   |     BS      	|	    	Administrator			|			PU			|
      
  @UPARegistration_ManageUsers_US2695434 
  Scenario Outline: UPA Purged User login
    Given User navigates to UPA portal and enters "<userType>" and login as purged User.
    Then validate the error page and click return to login button.
    Then validate landing page is present.
    Examples:
      |  			  userType 			  | 
      |      PROV_Admin_PURGED  | 
      |      PAY_Admin_PURGED   |  
      | 		 BS_Admin_PURGED		|
      |			 SubPay_Admin_PURGED|
      
   @UPARegistration_ManageUsers_US2695434_02 
    Scenario Outline: UPA Purged User login
    Given User navigates to UPA portal and enters "<userType>" and login as purged User.
    Then Enters security pin for "<role>".
    Then validate the error page and click return to login button.
    Then validate landing page is present.
    Examples:
      |  			  userType 				 | 	role		|
      |      PRPURGED_Admin		   |   P			|
      |      PRPURGED_Admin		   |   BS			|
      |      PRPURGED_Admin		   |   PA			|
      
    @UPAManageUsers2
    Scenario Outline: Verifies Save & Cancel button functionlity for Access level changes for a Provider User
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verify Save and Cancel func for AccessLvl for "<userType>"
      Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PROV_Admin |   PROV     	|		Administrator		    |
      	
      	
@UPAUS2711909P1
Scenario Outline: US2711909_1_UPA_Payer_Admin_ManageUsers_UIValidationforPurgedUsers

	Given User navigates to UPA portal and enters "<userType>" and login
	When  Click on Manage User Link
	Then  Verify UI Details for Purged "<userType>" user
	
	    Examples:
      |    userType     |		
      |     PAY_Admin   |		  
      
      
      
@UPAUS2711909P2
Scenario Outline: US2684242_2_UPA_Payer_Admin__ManageUsers_selectViewPurgedUsers_CheckDesignation + US2684242_3_CSR_SuperUser_ManageUsers_UnselectViewPurgedUsers_CheckDesignation

	Given User navigates to UPA portal and enters "<userType>" and login
	When  Click on Manage User Link
	Then  Verify Users List for "<userType>" with "<searchCriteria>" on selecting and deselecting of purge checkbox
	
	Examples:
      |    userType     |		accessLevelOfNewUser	|searchCriteria   |
      |     PAY_Admin |  		Administrator		    | PurgedUsers|
	  
	
  @UPAUS2711348 @UPA_AugRelease
     Scenario Outline: Verifies Save & Cancel button functionlity for Access level changes for a Provider User
    Given User navigates to UPA portal and enters "<userType>" and login
   # Then Select the Purged TIN from the dropdown
     Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verify Purged User validations by clicking on it
      Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PROV_Admin |   PROV     	|		Administrator		    |  
     
     @UPAUS2720684 	@UPA_AugRelease
		Scenario Outline: Verifies Save & Cancel button functionlity for Access level changes for a Provider User
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then User perform validation by adding TIN with same TIN 
      Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PROV_Admin |   PROV     	|		Administrator		    |  
 
#Author:Sunanda   	
@US1846613
Scenario Outline: Verify Provider Admin and Provider General accessebilities
 		Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
   	Then verifies if the TIN grid is relabeled for from Remove Row to Delete User
    And  validates if access level, email checkbox, delete user checkbox are enabled or disabled for "<accessLevel>"
    And  deletes "<accessType>" "<accessLevel>" user and verifies from UI and DB 
    Then verifies adding a new user of "<accessType>" with deleted user email with "<accessLevel>"
    Then verifies Admin user is able to update General user "<accessLevel>"
    
Examples:
      |    userType     |   accessType  |		accessLevel	          |
      |   PROV_Admin    |   PROV     	  |		Administrator		      |
      |   PROV_Admin    |   PROV     	  |		General     		      |
      
#Author: Sunanda      
@US2048540 
Scenario Outline: Verify BS Admin and BS General accessebilities    
		 Given User navigates to UPA portal and enters "<userType>" and login
     Then Select the TIN for "<accessType>" UPA Portal
     When Click on Manage User Link 
     Then Validate the ability of the fields of TIN grid for "<accessLevel>"
     And  Verify BS Admin is able to update BS Gen "<accessLevel>"
     
Examples:
			|    userType     |   accessType  |		accessLevel						|
      |   BS_Admin   	  |     BS     	  |		Administrator		      |
      |		BS_Admin   	  |     BS     	  |		General					      |
      
#Author: Sunanda     
@US2854205
Scenario Outline: Verify Payer Admin and Payer General accessebilities
 		Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
   	Then verifies if the TIN grid is relabeled for from Remove Row to Delete User
    And  validate ability of access level, email checkbox, delete user checkbox for Payer "<accessLevel>"
    And  deletes "<accessType>" "<accessLevel>" user and verifies from UI and DB 
 		Then verifies adding a new user of "<accessType>" with deleted user email with "<accessLevel>"
    Then verifies Admin user is able to update General user "<accessLevel>"

    Examples:
			|    userType       |   accessType    |		accessLevel						|
      |   PAY_Admin   	  |     PAY     	  |		Administrator		      |
      |		PAY_Admin   	  |     PAY     	  |		General					      |
      
      	     	