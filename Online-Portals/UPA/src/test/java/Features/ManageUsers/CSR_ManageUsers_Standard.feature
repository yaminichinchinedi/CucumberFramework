#Author: Rahul Krishna

@cloudCSRManageUsers 
Feature: CSR Manage Users functionality for Standard Tins
@CSRUS2879930 @OctRelase 
Scenario Outline: CSR Manage Purse User 
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin  based on "<tinTyp>" and "<portalAccess>"
    Then User verifies Add User button visiblity for "<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.
         
 Examples:
	  |    userType |   credentials     |tinTyp |	portalAccess     |System Mode|
	  |      PROV   |   Super     	    |AO			|   Standard       |FEEBASED  |
	  

																