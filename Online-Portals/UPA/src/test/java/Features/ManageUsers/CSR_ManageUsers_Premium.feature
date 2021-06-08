#Author: Rahul Krishna

@cloudCSRManageUsers @CSRRegression
Feature: CSR Manage User Functionality for Premium Tins

@CSRUS2879930 @OctRelease
Scenario Outline: CSR Manage Purse User 
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin  based on "<tinTyp>" and "<portalAccess>"
    Then User verifies Add User button visiblity for "<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.         
    
Examples:
	  |    userType |   credentials     |tinTyp |	portalAccess    |System Mode|
	  |      PROV   |   Super     	    |AO			|   Premium       |FEEBASED  |
	  |      PROV   |   Super     	    |VO			|   Premium       |FEEBASED  |
	  

	  
     # |      PROV   |   Super     	    |Any	  |   Any           |Legacy    |#--Always Legacy
     # |      PROV   |   Super     	    |AO			|   Legacy        |FeeBased    |#--Error
     # |      PROV   |   Super     	    |AO     |   Standard      |FeeBased   | #--Standard(Need to check)
     # |      PROV   |   Super     	    |AO			|   Premium       |FeeBased    |#--Premium
     # |      PROV   |   Super     	    |VO			|   Legacy        |FeeBased    |#--Error
     # |      PROV   |   Super     	    |VO			|   Premium        |FeeBased    |#--Premium
     # |      PROV   |   Super     	    |VO			|   TIN not found  |FeeBased    |#--Legacy(Need to check) 

		
		@CSRUS2879930 @OctRelease 
		Scenario Outline: CSR Manage Purse User for Billing Service
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin or select payer
    Then User verifies Add User button visiblity for "<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.    
    
Examples:
	  |    userType   |   credentials     |tinTyp |	portalAccess    |System Mode|
    |      BS       |   Super     	    |BS			|   Premium       | FEEBASED  |
    
  	@CSRUS2879930 @OctRelease 
  	Scenario Outline: CSR Manage Purse User for Payer
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin or select payer
    Then User verifies Add User button visiblity for "<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.   
             
Examples:
	  |    userType   |   credentials     |System Mode|
    |      PAY       |   Super     	    |FEEBASED  |
