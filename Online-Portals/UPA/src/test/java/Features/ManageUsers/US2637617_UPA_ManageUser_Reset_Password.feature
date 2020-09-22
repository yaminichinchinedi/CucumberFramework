#Author: Athyusha Thota

@US2637617_UPA @UPARegression
Feature: UPA Reset Password

Scenario Outline: UPA Manage User UI Check Reset Password Visibility

    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on UPA - Manage User Link
    And Verify Reset Password Option doesnt exists for UPA
    
Examples:
       |      userType       |   accessType|
       |      PROV_Admin     |   PROV      |
       |      BS_Admin       |   BS     	 |
       |      PAY_Admin      |   PAY       |
         


    
     
     