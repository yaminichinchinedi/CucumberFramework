#Author: amit_kushwah@optum.com
@UPAViewPayments_Premium
Feature: UPA Manage User Functionality for Premium TIN

  @UPAViewPayments_US2793429
		Scenario Outline: Access Payments - View Payments - Provider Premium
		Given User navigates to UPA portal and enters "<userType>" and login
		When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link in UPA
		Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options.
		Then Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options.
		Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
		Then Validate Archive column relabeled to Payment Status
		Then Validate Archive/Save changes button is relabeled to Save
		Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.

		Examples:
 			|    userType     |  	searchCriteria	|	portalAccess	| tinType	|
 			|   PROV_Admin    | 		 premiumTin 	|		 Premium		|		AO		|
 			
 			
 		@UPAViewPayments_US2783429
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<userType>" and login
		When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Validate default value of Payment Status filter displays New and dropdown have other status options.
		Then Validate Archive column relabeled to Payment Status and has dropdown menu having values New, Pending and Closed
		Then Validate user is able to change the value of Payment Status column
		Then Validate upon changing of status in Payment Status filter appropriate payments display.
		Examples:

			 |    userType     |  	searchCriteria	|	portalAccess	| tinType	|
 			 |   PROV_Admin    | 			 premiumTin 	|		 Premium		|		AO		|
