#Author: Vinay R
@UPABSInfo  
Feature: UPA Billing Service Information Functionality 

  @PageTextUS3179215 
  Scenario Outline: UPA Billing Service Information Header Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then User clicks on Billing Service Information tab
    Then Verify Billing Service Header Text
    Examples:
      | credentials | userType |
      | BS_Admin    | BS       |
