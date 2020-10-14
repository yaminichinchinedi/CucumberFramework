#Author: amit_kushwah@optum.com
@CsrViewPayments @CSRRegression
Feature: View Payment Access Payment

	#Author: AMIT
  @CSR_ViewPayments_US2801170,US2879948 
  Scenario Outline: Access Payments - Manage users Provider for Premium Experience
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Enter "<portalAccess>" portal access tin for "<tinType>" and "<searchCriteria>" criteria and click submit button
    Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options.
    Then Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options.
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate 835, ePRA and Payer PRA are enabled
		And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
    Examples: 
			|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
      |   		Super	 	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   		Super	    | 		PROV		|	Last 9-13 months |		 Premium		|		AV		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
			|   		Super	    | 		PROV		|	Last 9-13 months |		 Premium		|		VO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
  #Author: AMIT
  @CSR_ViewPayments_US2801189 @xyz
  Scenario Outline: Access Payments - Manage users Provider for Premium Experience
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Enter "<portalAccess>" portal access tin for "<tinType>" and "<searchCriteria>" criteria and click submit button
    Then Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options.
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate Archive column relabeled to Payment Status
    Then Validate user is able to change the value of Payment Status column
    And  Set FISL Parameters "<key>" and "<value>"
		Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
   
    Examples: 
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
      |   		Super	 	  | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	Y|
      |   		Super	    | 		PROV		|	Last 9-13 months |		 Premium		|		AV		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| Y|
      |   		Super	    | 		PROV		|	Last 9-13 months |		 Premium		|		VO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| Y|
