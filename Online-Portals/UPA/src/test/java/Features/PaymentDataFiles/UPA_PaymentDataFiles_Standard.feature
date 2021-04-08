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