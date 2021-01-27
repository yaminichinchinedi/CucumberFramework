#Author: khalid_mohammad@optum.com
Feature: Validate Fee Amount column in View Payments


Scenario Outline: Access Payments - View Payments - Provider Premium

Given User navigates to UPA portal and enters "<credentials>" and login
And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
When Click on View Payments Link for UPA
		
		
Examples:
|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|key															|	value	 	|
|   PROV_Admin	  |  PROV		|	Last 9-13 months   |		 Premium    |		AO	|	Show All    	|	Last 9-13 months	| 			Show All		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	Show All|
		