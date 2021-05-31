#Author: Priyanka
@UPASmoke
Feature: Smoke UPA    

Scenario Outline: UPA My Profile Functionality for "<userType>"

    Given User navigates to UPA portal and enters "<userType>" and login
    When Click on UPA - My Profile Link
    Then Verifies "<accessType>" User Details displayed on My profile Page from user details saved in Database for logged in user
    Examples:
      |      userType       |   accessType|
      |      PROV_Admin     |   PROV      |
   #   |      BS_Admin       |   BS     	  |
    #  |      PAY_Admin     	|   PAY       |
    
    
    Scenario Outline: Search Remittance Payment Number P1 & P2 Complete for "<userType>"

	Given User navigates to UPA portal and enters "<credentials>" and login
	And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
  Then User enters "<Search Criteria>" and click on search button.
  Then Validate in Grid search Results,Type column or Payment Status field not displayed and is relabeled to ACH Trace
  Then Validate Claim Count column is present which appears as Hyperlink for nonzero claim count and on click redirects to Remittance Detail page
  Then Validate ePRA,pPRA and 835 fields are enabled 
   Then Validate Archived Coulmn,Save Archived button is relabeled to Payment Status and Save button respectively
   Then Validate that Search Criertia box do not contain hyphen following colon on each search criteria option
    

	
	Examples:
		|		Search Criteria			|	credentials	 |   userType  | portalAccess | searchRemitorPymntTIN        |tinType|
		|	byElectronicPayNum	  |	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |
		#|	byElectronicPayNum  	|	PROV_Gen   	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |
		
		
		
		 @UPAViewPayments_US2793429 @OctRelease @UPA_ViewPaymentStable
		Scenario Outline: Access Payments - View Payments - Provider Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
        And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
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
    #  |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
		
 			
    