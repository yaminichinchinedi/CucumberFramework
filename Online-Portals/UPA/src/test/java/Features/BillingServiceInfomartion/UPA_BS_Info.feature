#Author: Sunanda
@UPABSInfo
Feature: UPA Billing Service Information Functionality 

  Scenario Outline: UPA Billing Service Information Page Text Verification
    Given User navigates to UPA portal and enters "<userType>" and login
    Then User clicks on Billing Service Information tab
    And User verifies the Trial End Date and updates it to one day later if trial is over
    And User verifies the page text during trial
    Examples:
      | userType | accessType |
      | BS_Admin | BS         |

  @US3179215
  Scenario Outline: UPA Billing Service Information Header Validation
    Given User navigates to UPA portal and enters "<userType>" and login
    Then User clicks on Billing Service Information tab
    Then Verify Billing Service Header Text
    Examples:
      | userType | accessType |
      | BS_Admin | BS         |