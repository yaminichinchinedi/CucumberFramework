#Author: amit_kushwah@optum.com
@UPAViewPayments_Premium
Feature: UPA Manage User Functionality for Premium TIN

  	#Author: AMIT
  	@UPAViewPayments_US2793429 @OctRelease
		Scenario Outline: Access Payments - View Payments - Provider Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
		Then Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
		Then Validate Archive column relabeled to Payment Status
		Then Validate Archive/Save changes button is relabeled to Save
		And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
		Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
 		Examples:
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|key															|	value	 	|
      |   PROV_Admin	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			Show All		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	Show All|
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			Show All		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| Show All|
		
 			
 		#Author: AMIT
 		@UPAViewPayments_US2783429 @OctRelease 
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Validate Archive column relabeled to Payment Status
		And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
		Then Validate user is able to change the value of Payment Status column
		
		
		Examples:

			|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
      |   PROV_Admin	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|		Last 30 days	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	Y|
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| Y|
 			 
 			 
		
		#Author: AMIT
		@UPAViewPayments_US2783429 
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Click on print Payment Summary button.
		And  Set FISL Parameters "<key>" and "<value>"
		Then Validate the data of Print Payment Summary page.
    Examples:
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|key															|	value	 	|
      |   PROV_Admin	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 30 days	| 			Show All		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	Show All|
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			Show All		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| Show All|
		
		
		#Author: AMIT
		@UPAViewPayments_US2783429 
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
		When Click on View Payments Link for UPA
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Click on print Payment Summary button.
		And  Set FISL Parameters "<key>" and "<value>"
		Then Validate the data of Print Payment Summary page.
    Examples:
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|key															|	value	 	|
			|    BS_Admin	    | 	   BS	 	  |	Last 9-13 months 	|		 Premium		|		AO		|	Show All				|	Last 30 days		| 			Show All		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| Show All|
      |    BS_Gen		    | 	   BS		  |	Last 9-13 months 	|		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			Show All		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| Show All|
		
		
		
		
		
		
		
		
