#Author: amit_kushwah@optum.com
@CsrViewPayments @CSRRegression
Feature: View Payment Access Payment

	#Author: AMIT
  @CSR_ViewPayments_US2801170_P @US2879948 @OctRelease @ViewPaymentStable
  Scenario Outline: Access Payments - View Payments Provider for Premium Experience
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Enter "<portalAccess>" portal access tin on CSR for "<userType>" having "<tinType>" and "<searchCriteria>" criteria and click submit button
    Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    Then Validate 835, ePRA and Payer PRA are enabled
    Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
    Examples:
			|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
			|   		Super	 	  | 		PROV		|		Last 30 days 	 |		 Premium		|		AO		|	Show All				|		Last 30 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|		Last 30 days 	 |		 Premium		|		AO		|	Show All				|		Last 30 days		| 		Closed	  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	Y|
			|   		Super	 	  | 		PROV		|		Last 30 days 	 |		 Premium		|		AO		|	Show All				|		Last 30 days		| 		Pending	  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	P|
			|   		Super	 	  | 		PROV		|		Last 60 days	 |		 Premium		|		AV		|	Show All				|		Last 60 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|		Last 90 days	 |		 Premium		|		VO		|	Show All				|		Last 90 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   		Super	 	  | 		PROV		|	Last 4-6 months  |		 Premium		|		AO		|	Show All				|	Last 4-6 months		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|	Last 6-9 months  |		 Premium		|		AV		|	Show All				|	Last 6-9 months		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   		Super	 	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
  
  #Author: AMIT
  @CSR_ViewPayments_US2801189 @OctRelease @ViewPaymentStable
  Scenario Outline: Access Payments - View Payments Provider for Premium Experience
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Enter "<portalAccess>" portal access tin on CSR for "<userType>" having "<tinType>" and "<searchCriteria>" criteria and click submit button
    Then Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate Archive column relabeled to Payment Status
    And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    Then Validate user is able to change the value of Payment Status column
   
    Examples:
			|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
			|   		Super	 	  | 		PROV		|		Last 30 days 	 |		 Premium		|		AO		|	Show All				|		Last 30 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|		Last 60 days	 |		 Premium		|		AO		|	Show All				|		Last 60 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|		Last 90 days	 |		 Premium		|		AV		|	Show All				|		Last 90 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	 	  | 		PROV		|	Last 4-6 months  |		 Premium		|		VO		|	Show All				|	Last 4-6 months		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   		Super	 	  | 		PROV		| Last 6-9 months  |		 Premium		|		AO		|	Show All				|	Last 6-9 months		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
			|   		Super	    | 		PROV		|	Last 9-13 months |		 Premium		|		VO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
			
			
			   	@CSR_ViewPayments_US3129195 @FebRelease 
		Scenario Outline: Access Payments - Manage users Provider for Premium Experience
		Given User navigates to CSR portal and enters "<credentials>" and login
		When Click on View Payments Link
		Then Enter "<portalAccess>" portal access tin on CSR for "<userType>" having "<tinType>" and "<searchCriteria>" criteria and click submit button
		Then Validate Fee Amount column is displayed.
		Then Validate amount is displayed for payments present in debit fee rate table.

  	 Examples: 
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
      |   		Super	 	  | 		PROV		|		Last 30 days	 |		 Premium		|		AO		|	Show All				|		Last 30 days		| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	Y|
    
    	
  