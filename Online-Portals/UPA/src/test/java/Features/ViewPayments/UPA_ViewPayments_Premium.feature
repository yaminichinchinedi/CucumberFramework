#Author: amit_kushwah@optum.com
@UPAViewPayments_Premium
Feature: UPA Manage User Functionality for Premium TIN

  	#Author: AMIT

  	@UPAViewPayments_US2793429 @OctRelease @UPA_ViewPaymentStable

		Scenario Outline: Access Payments - View Payments - Provider Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
		Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
		Then Validate Archive column relabeled to Payment Status
		Then Validate Archive/Save changes button is relabeled to Save
		And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
		Then Validate 835, ePRA and Payer PRA are enabled
		Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
 		Examples:
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|key															|	value	 	|
      |   PROV_Admin	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
		
 			
 		#Author: AMIT
 		@UPAViewPayments_US2783429 @OctRelease @UPA_ViewPaymentStable
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Validate Archive column relabeled to Payment Status
		And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
		Then Validate user is able to change the value of Payment Status column
		
		Examples:

			|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
      |   PROV_Admin	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|		Last 30 days	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
 			 
 			 
		
		#Author: AMIT
		@UPAViewPayments_US2908669 @UPA_ViewPaymentStable
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
      |   PROV_Admin	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|			Show All		|	Last 30 days			| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|			Show All		|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
		
		
		#Author: AMIT
		@UPAViewPayments_US2908671 @UPA_ViewPaymentStable
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
		When Click on View Payments Link for UPA
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Click on print Payment Summary button.
		And  Set FISL Parameters "<key>" and "<value>"
		Then Validate the data of Print Payment Summary page.
    Examples:
      |    credentials  |  userType 	|		searchCriteria  |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
			|    BS_Admin	    | 	   BS	 	  |	Last 9-13 months 	|		 Premium		|		AO		|	Show All				|	Last 9-13 months  | 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
      |    BS_Gen		    | 	   BS		  |	Last 9-13 months 	|		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
		
		
		#Author: Amit
		@UPAViewPayments_US2973009 @NovRelease @UPA_ViewPaymentStable
		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Click on Payment number and go to Remittance Detail screen.
		Then Click on Claim number on Remittance Detail screen and go to Claim Detail screen.
		Then Click on Payment number on Claim detail screen and go to single Payment View Payment screen.
		Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
		Then Click on print Payment Summary button.
		And  Set FISL Parameters "<key>" and "<value>"
		Then Validate the data of Print Payment Summary page.
		Then Validate the data between Single Payment Summary page and poped up Print payment Summary page
    
		 Examples:
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|key															|	value	 	|
      |   PROV_Admin	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 		New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   PROV_Admin	  | 		PROV		|		Last 30 days 	 |		 Standard		|		AO		|	Show All				|	 	Last 30 days		| 		New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
    
		
	#Sunanda
 @Joy @UPAViewPaymentsPremiumBS
	Scenario Outline: Access Payments - View Payments - BS Admin Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
		When Click on View Payments Link for UPA
		When User enters  "<tinType>" tin "<searchCriteria>" with "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" for "<userType>"
 		Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
		Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
 		Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
		Then Validate Archive column relabeled to Payment Status
		Then Validate Archive/Save changes button is relabeled to Save
		Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
		And User logs out the session
		
		Examples:
		 |    credentials     |   userType    | 			searchCriteria				            |		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
     |      BS_Admin      |   BS     	    |		 	TinWithPaymentsAndBsAssociation		  |			Premium			  |		AO			|     I     |					A					 |				PS			 |
     |      BS_Gen        |   BS     	    |		 	TinWithPaymentsAndBsAssociation		  |			Premium			  |		AO			|     I     |					A					 |				PS			 |
		
		
