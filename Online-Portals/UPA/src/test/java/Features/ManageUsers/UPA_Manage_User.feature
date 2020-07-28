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
	  
	
  @UPAUS2711348
     Scenario Outline: Verifies Save & Cancel button functionlity for Access level changes for a Provider User
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the Purged TIN from the dropdown
    When Click on Manage User Link
    Then Verify Purged User validations by clicking on it
      Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PROV_Admin |   PROV     	|		Administrator		    |  
     
     @UPAUS2720684 	
		Scenario Outline: Verifies Save & Cancel button functionlity for Access level changes for a Provider User
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then User perform validation by adding TIN with same TIN 
      Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PROV_Admin |   PROV     	|		Administrator		    |  
     	
      	