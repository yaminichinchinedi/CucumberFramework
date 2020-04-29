#Author: Sahil D Sharma

@CSRDataBundle @CSRRegression   @BothCSRUPAScenarios
Feature: CSR_Data Bundle_Regression

	@TC001						
	Scenario Outline: UI Validations for Payment Data Files 
  Given User navigates to CSR portal and enters "<Credentials>" and login
	When  User clicks on Payment Data Files Link
  And   User Validates Error Message upon Entering "<InvalidTIN>"
  Then  Validates the System upon entering "<ValidTIN>"
	Examples:
      | Credentials | InvalidTIN 	| ValidTIN  |
      | 		Super 	| 	xyz39abc5 | 133757370 |
      
  @TC002		
	Scenario Outline: UI Validations to check all labels on Payment Data Bundle Page
	Given User navigates to CSR portal and enters "<Credentials>" and login
  When  User clicks on Payment Data Files Link
  And   User enters the ValidTIN number
  And  Verify User navigates to Create Data Bundle Page
  Then   Verify all values in Create Data Bundle Page
	Examples:
      | Credentials |
      | 		Super 	|
      
      
  @TC003	
  Scenario Outline: Verify Payer Selection Validations
  Given User navigates to CSR portal and enters "<Credentials>" and login
  When  User clicks on Payment Data Files Link
  And   User enters the ValidTIN number
  And  Verify User navigates to Create Data Bundle Page
  And User Verify Payer Name List in Payer Selection
  And User Verify Buttons Available viz: Add, Add All, Remove, Remove All
  And Verify Add Button Functionality
  And Verify Remove Button Functionality
  Then Verify Add All Button Functioanlity
  And Verify Remove All Button Functionality
  And Verify Reset Functionality
	Examples:
      | Credentials |
      | 		Super 	|
      
      
  @TC004
  Scenario Outline: Validations to check errors 
  	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	Then 	Verify Submit Error without selecting any Fields
  	And  Verify Settlement Date Error Upon selecting Payer and File Types
  	And 	Verify File Types Error Upon selecting Payer and Settlement Date 
  	And 	Verify Settlemnet Date Error for Selecting Date range of more than 30 Days Between From and To Date
  	And 	Verify Settlement Date Error for To/From Dates must be prior to or same as Current date
  	And 	Verify Payer Selection Error
	Examples:
      | Credentials |
      | 		Super 	|
      
 	 @TC005  @CSRDataBundeSanity  @CSRSanity
   Scenario Outline: Data Bundle Submission : EPRAs
   	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	And User selects all the Payer from the Payer List
  	And User Enter Settlement Date Range  
  	Then User selects File Type as EPRA and Submit File Data Bundle
  	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type
    And User verifies the EPRA indicator in Database entry
	Examples:
      | Credentials |
      | 		Super 	|
      
 	@TC006
   Scenario Outline: Data Bundle Submission : PPRAs
   	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	And User selects all the Payer from the Payer List
  	And User Enter Settlement Date Range  
  	Then User selects File Type as PPRA and Submit File Data Bundle
  	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type
    And User verifies the PPRA indicator in Database entry
	Examples:
      | Credentials |
      | 		Super 	|
      
@TC007
   Scenario Outline: Data Bundle Submission : 835s
   	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	And User selects all the Payer from the Payer List
  	And User Enter Settlement Date Range  
  	Then User selects File Type as 835 and Submit File Data Bundle
  	And User Verifies Data Bundle Request entry in Download Data Bundle Page for 835 File Type
    And User verifies the 835 indicator in Database entry
	Examples:
      | Credentials |
      | 		Super 	|
      
@TC008
   Scenario Outline: Validate the Data Bundle Submission of EPRA and PPRA
   	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	And User selects all the Payer from the Payer List
  	And User Enter Settlement Date Range  
  	Then User selects File Type as EPRA and PPRA and Submit File Data Bundle
  	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type
    And User verifies the EPRA and PPRA indicator in Database entry
	Examples:
      | Credentials |
      | 		Super 	|
      
@TC009
   Scenario Outline: Validate the Data Bundle Submission of EPRA and 835
   	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	And User selects all the Payer from the Payer List
  	And User Enter Settlement Date Range  
  	Then User selects File Type as EPRA and 835 and Submit File Data Bundle
  	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and 835 File Type
    And User verifies the EPRA and 835 indicator in Database entry
	Examples:
      | Credentials |
      | 		Super 	|
      
      
@TC010
   Scenario Outline: Validate the Data Bundle Submission of PPRA and 835
   	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	And User selects all the Payer from the Payer List
  	And User Enter Settlement Date Range  
  	Then User selects File Type as PPRA and 835 and Submit File Data Bundle
  	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and 835 File Type
    And User verifies the PPRA and 835 indicator in Database entry
	Examples:
      | Credentials |
      | 		Super 	|
      
      
@TC011
   Scenario Outline: Validate the Data Bundle Submission of EPRA, PPRA and 835s
   	Given User navigates to CSR portal and enters "<Credentials>" and login
 	 	When  User clicks on Payment Data Files Link
  	And   User enters the ValidTIN number
  	And  Verify User navigates to Create Data Bundle Page
  	And User selects all the Payer from the Payer List
  	And User Enter Settlement Date Range  
  	Then User selects File Type as EPRA PPRA and 835 and Submit File Data Bundle
  	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and 835 File Type
    And User verifies the EPRA, PPRA and 835 indicator in Database entry
	Examples:
      | Credentials |
      | 		Super 	|

      
 	@TC012
	Scenario Outline: Validate Data Bundle Request Completed in Last 7 Days
	Given User navigates to CSR portal and enters "<Credentials>" and login
	When User clicks on Payment Data Files Link
  And User enters the TIN number of completed Data Bundle Requests
  And Verify User navigates to Create Data Bundle Page
  And User Click on Download Data Bundle Tab
  Then User validates the completed File Name in the Grid
	Examples:
      | Credentials |
      | 		Super 	|
      