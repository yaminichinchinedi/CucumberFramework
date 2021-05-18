#Author: Sunanda
@UPAPaymentDataFiles
Feature: UPA Payment Data Files Functionality for Standard TIN
@tiny					
Scenario Outline: UI Validations for Data Bundle
  Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  And   User verifies the Maximize your efficiency pop up for standard tin

Examples:
	 | credentials  |  userType 	|		searchCriteria        |	portalAccess	| tinType	|	
   |   BS_Admin	  | 		BS		  |	  Last 9-13 months       |		 Standard		|		AO		|	
  
  
  #Author : Vinay Raghumanda
   @US3179215
	 Scenario Outline: Payment Data Files page Text Validation for PROV users
		 Given User navigates to UPA portal and enters "<credentials>" and login
		 And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		 When  User clicks on Payment Data Files Tab
		 Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
		 Then Validate Payment Data File Page Text for "<credentials>" for "<portalAccess>"
		 Examples:
			 | credentials | userType | portalAccess | tinType | searchCriteria       |
			 | PROV_Admin  | PROV     | Standard     | AO      | PremiumOrStandardTIN |
			 | PROV_Gen    | PROV     | Standard     | AO      | PremiumOrStandardTIN |
		
   
   	 @UPAUS3438484
	 Scenario Outline: Payment Data Files page Text Validation for PROV users
		 Given User navigates to UPA portal and enters "<credentials>" and login
		 And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		 When  User clicks on Payment Data Files Tab
		 Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
		 Then Validate Payment Data File Page Text for "<credentials>" for "<portalAccess>"
		 Examples:
			 | credentials | userType | portalAccess | tinType | searchCriteria       |
			 | BS_Admin    | BS       | Standard     | AO      | PostTrial and NotPaid   |
			 | BS_Gen      | BS       | Standard     | AO      | PostTrial and NotPaid   |
			 | BS_Admin    | BS       | Standard     | AO      | WithinTrial and NotPaid   |       
			 | BS_Gen      | BS       | Standard     | AO      | WithinTrial and NotPaid   | 