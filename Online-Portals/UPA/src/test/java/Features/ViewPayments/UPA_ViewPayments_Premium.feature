#Author: amit_kushwah@optum.com
@UPA_ViewPayments_Premium
Feature: UPA Manage User Functionality for Premium TIN

  	#Author: AMIT
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
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
		
 			
 		#Author: AMIT
 		@UPAViewPayments_US2783429 @OctRelease @UPA_ViewPaymentStable
 		Scenario Outline: Access Payments - View Payments - Provider Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
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
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Click on print Payment Summary button.
		And  Set FISL Parameters "<key>" and "<value>"
		Then Validate the data of Print Payment Summary page.
    Examples:
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|key															|	value	 	|
      |   PROV_Admin	  | 		PROV		|			Last 30 days |		 Premium		|		AO		|			Show All		|	Last 30 days			| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|	N|
      |   PROV_Gen	    | 		PROV		|	Last 9-13 months |		 Premium		|		AO		|			Show All		|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
		
		
		#Author: AMIT
		@UPAViewPayments_US2908671 @UPA_ViewPaymentStable
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Click on print Payment Summary button.
		And  Set FISL Parameters "<key>" and "<value>"
		Then Validate the data of Print Payment Summary page.
    Examples:
      |    credentials  |  userType 	|		searchCriteria  |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|	value	 	|
			|    BS_Admin	    | 	   BS	 	  |	Last 9-13 months 	|		 Premium		|		AO		|	Show All				|	Last 9-13 months  | 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
      |    BS_Gen		  | 	   BS		  |	Last 9-13 months 	|		 Premium		|		AO		|	Show All				|	Last 9-13 months	| 			New		  |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR| N|
		
		
		#Author: Amit
		@UPAViewPayments_US2973009 @NovRelease @UPA_ViewPaymentStable
		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
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
    
		
		
 @UPAUS2955416
   	Scenario Outline: Access Payments - View Payments - Header Page Text
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
    And User verifies different  messages based on "<credentials>", "<Trial Status>" and "<Paid option>"
     
     Examples:
             |    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   	| tinType		|
             |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  WithinTrial and Paid 	|	  AO			|
             |       PROV_Gen          | 			 PROV			    	|			Premium			  |  WithinTrial and Paid 	|	  AO			|
             |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and Paid 		|	  AO			|
             |       PROV_Gen          | 			 PROV			    	|			Premium		  	|  PostTrial and Paid 		|	  AO			|
             |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and NotPaid 	|	  VO			|
             |       PROV_Gen          | 			 PROV			    	|			Premium		  	|  PostTrial and NotPaid 	|	  VO			|
             
     @UPAUS3015574
   	Scenario Outline: Access Payments - View Payments - PPRA link for Prov
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then User clicks on pPRA link 
    And User verifies record is inserted in PPRA_STATUS Table with Tin No,Consolidated No and Settlement date
     
     Examples:
    				 |    credentials          |	 	 userType  			  | 	portalAccess    |	searchCriteria      | tinType		|filterpayments	|	quicksearchfilter	| archivefilter 			|
             |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  Last 60 days       |    AO			|Show All				|			Last 60 days	| 			New		        |
             |       PROV_Gen          | 			 PROV			    	|			Premium		  	|  Last 60 days       | 	 AO	  	|Show All				|			Last 60 days	| 			New		        |
            
        
         @UPAUS3015574   
   	Scenario Outline: Access Payments - View Payments - PPRA link for BS
    Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then User clicks on pPRA link 
    And User verifies record is inserted in PPRA_STATUS Table with Tin No,Consolidated No and Settlement date
     
     Examples:
    				 |    credentials        |	 	 userType  			    | 	portalAccess    |	searchCriteria       | tinType		|filterpayments	|	quicksearchfilter	| archivefilter 			|
             |       BS_Admin        | 			 BS			    	  	|			Premium		  	|  Last 60 days        |    AO			|Show All				|			Last 60 days	| 			New		        |
             |       BS_Gen          | 			 BS		    				|			Premium		  	|  Last 60 days        | 	 AO	  	|Show All				|			Last 60 days	| 			New		        |        
#Sunanda
  @UPAViewPaymentsPremiumBS @wait
	Scenario Outline: Access Payments - View Payments - BS Admin Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
		And  User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
 		Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
 		Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
		Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
 		Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
		Then Validate Archive column relabeled to Payment Status
		Then Validate Archive/Save changes button is relabeled to Save
		Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
		And User clicks on UPA logout
	
	Examples:		
      | credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	filterpayments	|	quicksearchfilter	| archivefilter 			|
      |   BS_Admin	 | 		BS		  |	  Last 60 days   |		 Premium		|		AO		|	Show All				|	  Last 60 days	  | 		New		          |
      |   BS_Gen	   | 		BS		  |		Last 60 days 	 |		 Premium		|		AO		|	Show All				|	 	Last 60 days		| 		New		          |

	
