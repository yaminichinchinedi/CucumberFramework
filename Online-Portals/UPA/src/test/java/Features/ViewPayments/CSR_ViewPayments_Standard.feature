#Author: amit_kushwah@optum.com
@CSRRegression @CSR_ViewPayments_Standard
Feature: CSR View Payments for Standard TIN

#Author: AMIT
  @CSR_ViewPayments_US2801170 @CSR_US2879948 @OctRelease @CSR_ViewPaymentStable
  Scenario Outline: Access Payments - View Payments Provider for Standard Experience
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link
		Then User Enters tin and click on search button for "<userType>".
    Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
		And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
		Then Validate 835, ePRA and Payer PRA are enabled
    Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
    Examples: 
			|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
			|   		Super	 	  | 		PROV		|		Last 30 days 	 |		 Standard		|		AO		|	Show All				|		Last 30 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|		Last 60 days	 |		 Standard		|		AV		|	Show All				|		Last 60 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|		Last 90 days	 |		 Standard		|		VO		|	Show All				|		Last 90 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   		Super	 	  | 		PROV		|	Last 4-6 months  |		 Standard		|		AO		|	Show All				|	Last 4-6 months		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|	Last 6-9 months  |		 Standard		|		AV		|	Show All				|	Last 6-9 months		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	    | 		PROV		|	Last 9-13 months |		 Standard		|		VO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
  
  #Author: AMIT
  @CSR_ViewPayments_US2801189 @OctRelease @CSR_ViewPaymentStable
  Scenario Outline: Access Payments - View Payments Provider for Standard Experience
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link
		Then User Enters tin and click on search button for "<userType>".
    Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate Archive column relabeled to Payment Status
   	Then Validate user is able to change the value of Payment Status column
   
    Examples: 
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |
			|   		Super	 	  | 		PROV		|		Last 30 days 	 |		 Standard		|		AO		|	Show All				|		Last 30 days		| 			New		  |
			|   		Super	 	  | 		PROV		|		Last 60 days	 |		 Standard		|		AV		|	Show All				|		Last 60 days		| 			New		  |
			|   		Super	 	  | 		PROV		|		Last 90 days	 |		 Standard		|		VO		|	Show All				|		Last 90 days		| 			New		  |
      |   		Super	 	  | 		PROV		|	Last 4-6 months  |		 Standard		|		AO		|	Show All				|	Last 4-6 months		| 			New		  |
			|   		Super	 	  | 		PROV		|	Last 6-9 months  |		 Standard		|		AV		|	Show All				|	Last 6-9 months		| 			New		  |
			|   		Super	    | 		PROV		|	Last 9-13 months |		 Standard		|		VO		|	Show All				|	Last 9-13 months	| 			New		  |

			
			
				@CSR_ViewPayments_US3129195 @FebRelease @CSR_ViewPaymentStable
		Scenario Outline: Access Payments - Manage users Provider for Premium Experience
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link
		Then User Enters tin and click on search button for "<userType>".
		Then Validate Fee Amount column is not displayed.
		Examples:
	
			|   credentials     |	userType   |  tinType	|	portalAccess	|	searchCriteria 	|
    	|      Super        |	  PROV     |		AO		|	  Standard		|		Last 30 days	|
    	|      Super        |	  PROV     |		VO		|	  Premium			|		Last 30 days	|
