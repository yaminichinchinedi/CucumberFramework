#Author: Sahil D Sharma
 @UPADataBundleNEW  @UPARegression    @BothCSRUPAScenarios @fish
 Feature: UPA Payment Data Files Functionality

	@TC001 			
	Scenario Outline: UI Validations for Data Bundle
 	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   Verify User navigates to Create Data Bundle Page on UI
	Then  Verify the values in Create Data Bundle Page for "<userType>"
	And   User clicks on UPA logout
	 Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 



@TC002 			@coco
	Scenario Outline: Verify Payer and PageButton Validations
	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   Verify User navigates to Create Data Bundle Page on UI
	And   User Verify Payer Name List in Payer Selection Grid for "<userType>"
	And   User Verify All the PageButtons Available: Add, Add All, Remove, Remove All
	And   Verify User is able to access Reset Functionality
	And   Verify User is able to access Add Button Functionality
	And   Verify User is able to access Remove Button Functionality
	Then  Verify User is able to access Add All Button Functioanlity
 	And   Verify User is able to access Remove All Button Functionality
 	And   User clicks on UPA logout
Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	


@TC003	
 	Scenario Outline: Validations to check errors 
 	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
 	And   Verify User navigates to Create Data Bundle Page on UI
	And   Verify Error Message upon clicking Submit Button without selecting any Fields for "<userType>"
	And   Verify Error Message when Settlement Date is not Selected for "<userType>"
	And   Verify Error Message when File Types is not Selected for "<userType>"
	And   Verify Error Message when Settlement Date range is selected for more than 30 Days Between From and To Date for "<userType>"
	Then  Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for "<userType>"
	And   Verify Error Message when No Payer is Selected for "<userType>"
	And User clicks on UPA logout
 Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 

   

@TC004  @UPASanity  @UPADataBundleSanity 
	Scenario Outline: Data Bundle Submission : EPRAs
  Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   Verify User navigates to Create Data Bundle Page on UI
	And   User Enter Settlement Date in TO and From Date Range
	And   User selects All Payers from the Payer List for "<userType>"
	And   User verifies All the Three File Type Options
	Then  User selects File Type Option as EPRA and Submit Payment Data Bundle Request
	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type
	And   User verifies the EPRA indicator in Database entry
	And   User clicks on UPA logout
 Examples:
   | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 

   

@TC005 
	Scenario Outline: Data Bundle Submission : PPRAs
 Given User navigates to UPA portal and enters "<credentials>" and login
  And  User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When User clicks on Payment Data Files Tab
	Then User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And  Verify User navigates to Create Data Bundle Page on UI
	And  User Enter Settlement Date in TO and From Date Range
	And  User selects All Payers from the Payer List for "<userType>"
	And  User verifies All the Three File Type Options
	Then User selects File Type Option as PPRA and Submit Payment Data Bundle Request
	And  User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type
	And  User verifies the PPRA indicator in Database entry
	And  User clicks on UPA logout
 	Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 



@TC006 
 Scenario Outline: Data Bundle Submission : 835s
	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   User Enter Settlement Date in TO and From Date Range
	And   User selects All Payers from the Payer List for "<userType>"
	And   User verifies All the Three File Type Options
	Then  User selects File Type Option as 835 and Submit Payment Data Bundle Request
	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for 835 File Type
	And   User verifies the 835 indicator in Database entry
	And   User clicks on UPA logout
	Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 



@TC007  
 Scenario Outline: Validate the Data Bundle Submission of EPRA and PPRA
  Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   Verify User navigates to Create Data Bundle Page on UI
	And   User Enter Settlement Date in TO and From Date Range
	And   User selects All Payers from the Payer List for "<userType>"
	And   User verifies All the Three File Type Options
 Then   User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request
  And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type
  And   User verifies the EPRA and PPRA indicator in Database entry
	And   User clicks on UPA logout
	Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 



@TC008  
	Scenario Outline: Validate the Data Bundle Submission of EPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   Verify User navigates to Create Data Bundle Page on UI
	And   User Enter Settlement Date in TO and From Date Range
	And   User selects All Payers from the Payer List for "<userType>"
	And   User verifies All the Three File Type Options
	Then  User selects File Type Option as EPRA and 835 and Submit Payment Data Bundle Request
	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and 835 File Type
	And   User verifies the EPRA and 835 indicator in Database entry
	And   User clicks on UPA logout
	Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 


@TC009 
 Scenario Outline: Validate the Data Bundle Submission of PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page 
	And   Verify User navigates to Create Data Bundle Page on UI
	And   User Enter Settlement Date in TO and From Date Range
	And   User selects All Payers from the Payer List for "<userType>"
	And   User verifies All the Three File Type Options
	Then  User selects File Type Option as PPRA and 835 and Submit Payment Data Bundle Request
	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and 835 File Type
	And   User verifies the PPRA and 835 indicator in Database entry
	And   User clicks on UPA logout
	Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 



@TC010   
	Scenario Outline: Validate the Data Bundle Submission of EPRA, PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
	Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   Verify User navigates to Create Data Bundle Page on UI
	And   User Enter Settlement Date in TO and From Date Range
	And   User selects All Payers from the Payer List for "<userType>"
	And   User verifies All the Three File Type Options
 	Then  User selects File Type Option as EPRA PPRA and 835 and Submit Payment Data Bundle Request
 	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and 835 File Type
 	And   User verifies the EPRA, PPRA and 835 indicator in Database entry
 	And   User clicks on UPA logout
	Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 


@TC011  
	Scenario Outline: Validate Data Bundle Request Completed in Last 7 Days
	Given User navigates to UPA portal and enters "<credentials>" and login
  And   User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When  User clicks on Payment Data Files Tab
  Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
	And   Verify User navigates to Create Data Bundle Page on UI
	And   User verifies the Data Bundle Request Completed in Last 7 Days
	And   User Click on Download Data Bundle Tab on UI
	Then  User validates the completed File Name in the Grid
	And   User clicks on UPA logout
	Examples:
	 | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
   |   BS_Admin	    | 		BS		   |	  Last 4-6 months    |		 Premium		|		AO		|	  
   |  PROV_Admin    |    PROV      |    Last 9-13 months   |		 Premium		|		AO		|	
   |  PAY_Admin     |    Payer     |    Last 4-6 months    |		 Premium		|		AO		| 
