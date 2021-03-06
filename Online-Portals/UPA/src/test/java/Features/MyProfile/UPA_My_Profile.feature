#Author: vinit_rohela@optum.com
@UPAMyProfile @UPARegression
Feature: UPA My Profile Functionality

@naruto
  Scenario Outline: UPA My Profile UI Functionality Verifies User Details displayed on My profile Page from user details saved in Database for logged in user

    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on UPA - My Profile Link
    Then Verifies "<accessType>" User Details displayed on My profile Page from user details saved in Database for logged in user
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |
      |      BS_Admin       |   BS     	  |
      |      PAY_Admin     	|   PAY       |


  Scenario Outline: UPA My Profile UI Functionality Verifies Error messages for provider

    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on UPA - My Profile Link
    Then Verifies "<accessType>" Error messages for provider
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |


# password and security question scenario is not applicable #This is No Longer a Valid Scenario, as per Discussion with Prashant Gupta

#Scenario Outline: UPA My Profile UI Functionality Verifies Password guidelines text and Verifies user is able to change his password successfully and Verifies yes/no functinality while changing password
#
#     Given User navigates to UPA portal and enters "<userType>" and login
#     When Click on UPA - My Profile Link
#     Then Verifies "<userType>" Password guidelines text and Verifies user is able to change his password successfully and Verifies yes/no functinality while changing password
#     Examples:
#       |      userType       |   accessType |
#       |      BS_Admin       |   BS         |
#       |      PAY_Admin      |   PAY        |
#
#
#  Scenario Outline: UPA My Profile UI Functionality Verifies user is able to change his password successfully and Verifies yes/no functinality while changing password and Verifies Change password Validations
#
#     Given User navigates to UPA portal and enters "<userType>" and login
#     When Click on UPA - My Profile Link
#     Then Verifies user is able to change his password successfully and Verifies yes/no functinality while changing password and Verifies Change password Validations
#     Examples:
#       |      userType       |   accessType   |
#       |      PROV_Admin     |   PROV         |
#       |      BS_Admin       |   BS     	  |
#       |      PAY_Admin      |   PAY          |
#
#
#  Scenario Outline: UPA My Profile UI Functionality Verifies My Profile_Page_Manage_Security_Questions Link for Admin Provider User
#
#     Given User navigates to UPA portal and enters "<userType>" and login
#     When Click on UPA - My Profile Link
#     Then Verifies My Profile_Page_Manage_Security_Questions Link for Admin Provider User
#      Examples:
#        |      userType       |   accessType   |
#        |      PROV_Admin     |   Admin        |
#        |      PROV           |   Gen          |

#Author : Pranav
@US2707365 
  Scenario Outline: UPA My Profile UI Functionality Update and Verify User Details displayed on My profile Page from user details saved in Database for logged in user

    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on UPA - My Profile Link
    Then User updates fields on My profile Page and verifies in Database for logged in user
    Examples:
      |      userType       |   accessType|
      |      PAY_Admin     	|   PAY       |
      |      BS_Admin       |   BS     	  |

#Author : Pranav
@US2707363
Scenario Outline: UPA My Profile UI Functionality Update and verify user details for provider

    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on UPA - My Profile Link
    Then User updates fields on My profile Page for provider and verifies in Database for logged in user
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |

      
@UPAUS2637587_UPA 
Scenario Outline: UPA My Profile Fraud Prevention Check

    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on UPA - My Profile Link
    Then verify Change Password and Manage Security Questions Visibility
    Then Verify Optum ID is added in My Profile Page 
     
Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |
      |      PROV_Gen       |   PROV      |
      |      BS_Admin       |   BS     	  |
      |      BS_Gen         |   BS     	  |
      |      PAY_Admin     	|   PAY       |
      |      PAY_Gen      	|   PAY       |
  