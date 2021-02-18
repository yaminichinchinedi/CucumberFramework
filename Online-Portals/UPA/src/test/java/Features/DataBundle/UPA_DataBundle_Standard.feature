#Author: Sunanda
@UPAPaymentDataFiles
Feature: UPA Payment Data Files Functionality for Standard TIN
@Tessy					
Scenario Outline: UI Validations for Data Bundle
Given User navigates to UPA portal and enters "<credentials>" and login
When User clicks on Data Bundle Tab for Billing Service
And  User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And  User verifies the Maximize your efficiency pop up for standard tin

Examples:
	 | credentials  |  userType 	|		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	  | 		BS		  |	  Last 30 days       |		 Standard		|		AO		|	