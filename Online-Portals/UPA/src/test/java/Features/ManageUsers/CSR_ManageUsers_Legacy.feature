#Author: Rahul Krishna
@CSRManageUsers @CSRRegression
Feature: CSR Manage User Functionality for Legacy Tins
@CSRUS2879930_111
Scenario Outline: CSR Manage Purge User 
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin  based on "<tinTyp>" and "<portalAccess>"
    Then User verifies Add User button visiblity for "<tinTyp>","<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.         
    
Examples:
	  |    userType |   credentials     |tinTyp |	portalAccess     |System Mode|
	  |      PROV   |   Super     	    |AO			|   Legacy         |LEGACY  |
	   |      PROV   |   Super     	    |VO			|   Legacy         |LEGACY  |
	#  |      PROV   |   Super     	    |AO			|   Legacy         |FEEBASED  | --Need to check,Probably Error
	 #|      PROV   |   Super     	    |VO			|   Legacy         |FEEBASED |--Not a valid scenario,always Premium