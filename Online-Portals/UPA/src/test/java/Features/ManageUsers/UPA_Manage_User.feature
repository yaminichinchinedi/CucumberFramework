#Author: vinit_rohela@optum.com
@UPAManageUsers
Feature: Create Enrollment - UPA Manage User Functionality

Scenario Outline: UPA Manage User UI Functionality Verifies user list sorting is working correctly on Manage Users Tab
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies user list sorting is working correctly on Manage Users Tab
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: UPA Manage User UI Functionality Verifies Save & Cancel button functionlity for Access level changes for a Provider User
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies "<accessType>" Save & Cancel button functionlity for Access level changes for a Provider User
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: UPA Manage User UI Functionality Verifies Tin Grid Details in Manage Users Tab
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies Tin Grid Details in Manage Users Tab
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: UPA Manage User UI Functionality Verifies error messages and associated tins with a user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies error messages and associated tins with a user
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: UPA Manage User UI Functionality Verifies provider user details are read only on UPA
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies provider user details are read only on UPA
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

  Scenario Outline: UPA Manage User UI Functionality Verifies details for New Billing Service user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Billing Service user
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      BS_Admin   |   BS      	|		Administrator			|

  Scenario Outline: UPA Manage User UI Functionality Verifies Payer user details are read only on UPA
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies Payer "<accessType>" user details are read only on UPA
    Examples:
      |    userType     |   accessType  |
      |      PAY_Admin  |   PAY     	|

  Scenario Outline: UPA Manage User UI Functionality Verifies details for New Payer user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Payer user
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PAY_Admin  |   PAY     	|		Administrator	    	|

  Scenario Outline: UPA Manage User UI Functionality Verifies details for New Provider user
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Provider user
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|
      |      PROV_Admin |   PROV     	|		Administrator		    |
      
      @TEST1
      Scenario Outline: UPA Manage User Add new Provider user using purged user email address
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Provider user using "<stsCode>"
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|  stsCode	  |
      |      PROV_Admin |   PROV      	|		 Administrator		    |			PU			|
      
      Scenario Outline: UPA Manage User Add New Payer and BS user using purged user email address
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on Manage User Link
    Then Verifies details for "<accessType>" and "<accessLevelOfNewUser>" New Payer and BS user using "<stsCode>"
    Examples:
      |    userType     |   accessType  |		accessLevelOfNewUser	|		stsCode		|
      |      PAY_Admin  |     PAY     	|		    Administrator	   	|			PU			|
      |      BS_Admin   |     BS      	|	    	Administrator			|			PU			|
      
     
      
      
