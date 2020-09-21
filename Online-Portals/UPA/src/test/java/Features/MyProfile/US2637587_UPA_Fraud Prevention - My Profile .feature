#Author: Athyusha Thota


Feature: US2637587 PRJ202767 Fraud Prevention - My Profile - QA

@US2637587_UPA @UPARegression

Scenario Outline: UPA My Profile Fraud Prevention Check

    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
    When Click on UPA - My Profile Link
    Then verify Change Password and Manage Security Questions Visibility
    Then Verify Optum ID is added in My Profile Page 
     
Examples:
      |      userType       |   accessType|
    #  |      PROV_Admin     |   PROV      |
   #   |      PROV_Gen       |   PROV      |
  #    |      BS_Admin       |   BS     	  |
 #     |      BS_Gen         |   BS     	  |
      |      PAY_Admin     	|   PAY       |
 #     |      PAY_Gen      	|   PAY       |
  



    
     
     