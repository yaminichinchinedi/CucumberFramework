#Author: vinit_rohela@optum.com
@CSRManageUser
Feature: Create Enrollment - CSR Manage User Functionality

@CSRManageUser1
  Scenario Outline: CSR Manage User UI Functionality Add new user
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on Manage User Link
    Then User enters "<userType>" in Manage Users Page and Click to add new User and fill the details "<accessLevelOfNewUser>" and verify the user detils and delete the user
    Examples:
      |    userType     |   credentials   |  accessLevelOfNewUser |
      |      PROV       |      Super      |	 Administrator		  |
      |      BS         |      Super      |	 Administrator		  |
      |      PAY        |      Super      |	 Administrator		  |

  Scenario Outline: CSR Manage User UI Functionality Verifies Details
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on Manage User Link
    Then validate User enters "<userType>" to verify acive admin, access level, email check, remove tin "<disabledValue>" and modify email "<email>" and "<firstName>" firstName
    Examples:
      |    userType     |   credentials   |		disabledValue		|   email   |   firstName   |
      |      PROV       |      Super      |		disabled			|   email   |   firstName   |

  Scenario Outline: CSR Manage User UI Functionality Verifies Details
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on Manage User Link
    Then User enters "<userType>" in Manage Users Page and Verifies if a tin has only one active admin , access level dropdown, email check box & remove tin/npi checkbox "<disabledValue>" is disabled after modifying the Last name of user with both valid and invalid data
    Examples:
      |    userType     |   credentials   |		disabledValue		|
      |      PROV       |      Super      |		disabled			|

#Scenario Outline: CSR Manage User UI Functionality Verifies Details
     #Given User navigates to CSR portal and enters "<credentials>" and login
     #When Click on Manage User Link
     #Then User enters "<userType>" in Manage Users Page and Verifies if a tin has more than one active admin , access level dropdown, email check box & remove tin/npi checkbox "<disabledValue>" is enabled
     #Examples:
        #|    userType     |   credentials   |		disabledValue		|
        #|      PROV       |      Super      |		false				    |

  Scenario Outline: CSR Manage User UI Functionality Verifies Details
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on Manage User Link
    Then User enters "<userType>" in Manage Users Page and Verifies access level,email and npi/tin checkbox remains disabled for a user who is the only active admin for a tin when gets associated with another new tin and Verifies if the new tin is removed then also these items access level etc remains "<disabledValue>" disabled for the only active admin tin
    Examples:
      |    userType     |   credentials   |		disabledValue		|
      |      PROV       |      Super      |		disabled    		|

