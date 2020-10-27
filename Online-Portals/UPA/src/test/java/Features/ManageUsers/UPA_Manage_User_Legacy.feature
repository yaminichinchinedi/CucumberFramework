#Author: vinit_rohela@optum.com
@UPAManageUsers
Feature: UPA Manage User Functionality

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

  