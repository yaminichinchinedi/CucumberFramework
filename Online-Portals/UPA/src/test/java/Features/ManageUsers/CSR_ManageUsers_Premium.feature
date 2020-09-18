#Author: Rahul Krishna

Feature: CSR Manage User Functionality for Premium Tins

@CSRUS2879930_111
Scenario Outline: CSR Manage Purse User 
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin  based on "<tinTyp>" and "<portalAccess>"
    Then User verifies Add User button visiblity for "<tinTyp>","<portalAccess>" based on "<System Mode>" like FeeBased or Legacy.         
    
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

		
		@CSRUS2879930_BS
		Scenario Outline: CSR Manage Purse User for Billing Service
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin or select payer
    Then User verifies Add User button visiblity for "CSR","BillingService" based on System Mode like FeeBased or Legacy.         
    
Examples:
	  |    userType   |   credentials     |tinTyp |	portalAccess    |
    |      BS       |   Super     	    |BS			|   Premium       |
    
  	@CSRUS2879930_Payer
  	Scenario Outline: CSR Manage Purse User for Payer
    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    And   Users selects  "<userType>" from dropdown and enter Tin or select payer
    Then User verifies Add User button visiblity for "CSR","Payer" based on System Mode like FeeBased or Legacy.         
    
Examples:
	  |    userType   |   credentials     |
    |      PAY       |   Super     	    |
   														