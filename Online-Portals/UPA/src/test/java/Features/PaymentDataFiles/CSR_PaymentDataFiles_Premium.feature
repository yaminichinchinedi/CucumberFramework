#Author: Sahil D Sharma
@CSRDataBundle @CSRRegression  @BothCSRUPAScenarios  @CSRPaymentDataFiles
Feature: CSR Payment Data File Functionality

Scenario Outline: Validations to check errors 
    Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	Then 	Verify Submit Error without selecting any Fields
  	And   Verify Settlement Date Error Upon selecting Payer and File Types
  	And 	Verify File Types Error Upon selecting Payer and Settlement Date 
  	And 	Verify Settlemnet Date Error for Selecting Date range of more than 30 Days Between From and To Date
  	And 	Verify Settlement Date Error for To/From Dates must be prior to or same as Current date
  	And 	Verify Payer Selection Error
  	And   User clicks on CSR logout
	Examples:
     | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
     |   Super	      | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	    
    
     
Scenario Outline: UI Validations for Payment Data Files 
  Given User navigates to CSR portal and enters "<credentials>" and login
  And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  When  User clicks on Payment Data Files Link
  And   User Validates Error Message upon Entering invalid TIN
  Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  And   Verify User navigates to Create Data Bundle Page
  And   User clicks on CSR logout
	Examples:
     | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
     |   Super	      | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	    
    
 
	Scenario Outline: UI Validations to check all labels on Payment Data Bundle Page
   Given User navigates to CSR portal and enters "<credentials>" and login
   And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   When  User clicks on Payment Data Files Link
   Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
   And   Verify User navigates to Create Data Bundle Page
   Then  Verify all values in Create Data Bundle Page
   And   User clicks on CSR logout
	Examples:
       | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
       |   Super	      | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	    
      
  

 
  Scenario Outline: Validations to check errors 
    Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	Then 	Verify Submit Error without selecting any Fields
  	And   Verify Settlement Date Error Upon selecting Payer and File Types
  	And 	Verify File Types Error Upon selecting Payer and Settlement Date 
  	And 	Verify Settlemnet Date Error for Selecting Date range of more than 30 Days Between From and To Date
  	And 	Verify Settlement Date Error for To/From Dates must be prior to or same as Current date
  	And 	Verify Payer Selection Error
  	And   User clicks on CSR logout
	Examples:
     | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
     |   Super	      | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	    
    
    
   
   Scenario Outline: Data Bundle Submission : EPRAs
   	Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	And   User selects all the Payer from the Payer List
  	And   User Enter Settlement Date Range  
  	Then  User selects File Type as EPRA and Submit File Data Bundle
  	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type on CSR
    And   User verifies the EPRA indicator in Database entry on CSR
    And   User clicks on CSR logout
	Examples:
     | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
     |   Super	      | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
   
   
     
   Scenario Outline: Data Bundle Submission : PPRAs @AddAlls
   	Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	And   User selects all the Payer from the Payer List
  	And   User Enter Settlement Date Range  
  	Then  User selects File Type as PPRA and Submit File Data Bundle
  	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type on CSR
    And   User verifies the PPRA indicator in Database entry on CSR
    And   User clicks on CSR logout
	Examples:
     | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
     |   Super	      | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
  
  
      
@TC007  @AddAlls
   Scenario Outline: Data Bundle Submission : 835s
   	Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	And   User selects all the Payer from the Payer List
  	And   User Enter Settlement Date Range  
  	Then  User selects File Type as 835 and Submit File Data Bundle
  	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for 835 File Type on CSR
    And   User verifies the 835 indicator in Database entry on CSR
    And   User clicks on CSR logout
	Examples:
      | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
      |   Super	       | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
  
  
      
@TC008   @AddAlls
   Scenario Outline: Validate the Data Bundle Submission of EPRA and PPRA
   	Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	And   User selects all the Payer from the Payer List
  	And   User Enter Settlement Date Range  
  	Then  User selects File Type as EPRA and PPRA and Submit File Data Bundle on CSR
  	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type on CSR
    And   User verifies the EPRA and PPRA indicator in Database entry on CSR
    And   User clicks on CSR logout
	Examples:
     | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
     |   Super	      | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
  
  
      
@TC009 @AddAlls
   Scenario Outline: Validate the Data Bundle Submission of EPRA and 835
   	Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	And   User selects all the Payer from the Payer List
  	And   User Enter Settlement Date Range
  	Then  User selects File Type as EPRA and 835 and Submit File Data Bundle on CSR
  	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and 835 File Type on CSR
    And   User verifies the EPRA and 835 indicator in Database entry on CSR
    And   User clicks on CSR logout
	Examples:
      | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
      |   Super	       | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
      
 
      
@TC010  @AddAlls
   Scenario Outline: Validate the Data Bundle Submission of PPRA and 835
   	Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	And   User selects all the Payer from the Payer List
  	And   User Enter Settlement Date Range  
  	Then  User selects File Type as PPRA and 835 and Submit File Data Bundle on CSR
  	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and 835 File Type on CSR
    And   User verifies the PPRA and 835 indicator in Database entry on CSR
    And   User clicks on CSR logout
	Examples:
      | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
      |   Super	       | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
      
 
      
@TC011 @AddAlls
   Scenario Outline: Validate the Data Bundle Submission of EPRA, PPRA and 835s
   	Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  	And   Verify User navigates to Create Data Bundle Page
  	And   User selects all the Payer from the Payer List
  	And   User Enter Settlement Date Range  
  	Then  User selects File Type as EPRA PPRA and 835 and Submit File Data Bundle on CSR
  	And   User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and 835 File Type on CSR
    And   User verifies the EPRA, PPRA and 835 indicator in Database entry on CSR
    And   User clicks on CSR logout
	Examples:
      | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
      |   Super	       | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
      

      
 	@TC012 
	Scenario Outline: Validate Data Bundle Request Completed in Last 7 Days
	  Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When  User clicks on Payment Data Files Link
    Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
    And   Verify User navigates to Create Data Bundle Page
    And   User Click on Download Data Bundle Tab
    Then  User validates the completed File Name in the Grid on CSR
    And   User clicks on CSR logout
	Examples:
      | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
      |   Super	       | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
 
 
 
 @CSRDataBundle @CSRRegression @US2707347  
  Scenario Outline: Verify Payer Selection Validations
  Given User navigates to CSR portal and enters "<credentials>" and login
  And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  When  User clicks on Payment Data Files Link
  Then  User Enters tin and click on search button for "<userType>" on Payment Data Files page
  And   Verify User navigates to Create Data Bundle Page
  And   User Verify Payer Name List in Payer Selection
  Then  User Verify Patient Payment Payer appear on top of the list 
  Then  User Verify for Note appears that Payer PRAs and EPRAs are not available for Patient Payments
  Then  User  Verify for Note that Data Bundle requests for Patient Payments will be available soon, no longer appears above Payer Selection.
  Then  User  Verifies able to select 835s
  And   User clicks on CSR logout 
  
  	Examples:
      | credentials    |  userType 	 |		searchCriteria     |	portalAccess	| tinType	|	
      |   Super	       | 		PROV		 |	  Last 4-6 months    |		 Premium		|		AO		|	   
    