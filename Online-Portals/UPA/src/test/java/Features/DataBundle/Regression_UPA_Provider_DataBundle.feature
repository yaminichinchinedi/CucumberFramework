#Author: Sahil D Sharma

@UPADataBundle  @UPARegression   @BothCSRUPAScenarios
Feature: UPA_Provider_Data Bundle_Regression

	@TC001			
	Scenario Outline: UI Validations for Data Bundle
 	Given User navigates to UPA portal and enters "<credentials>" and login
	#And User selects tin for UPA "<Search Criteria>"
	And  User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	Then Verify the values in Create Data Bundle Page for Provider
Examples:		
      | credentials    |  userType 	  |		searchCriteria |	portalAccess	| tinType	|	
      |   PROV_Admin	 | 		PROV		  |	  Last 30 days   |		 Standard		|		AO		|	

@TC002  @fix	
	Scenario Outline: Verify Payer and PageButton Validations
	Given User navigates to UPA portal and enters "<credentials>" and login
	And  User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User Verify Payer Name List in Payer Selection Grid for Provider
	And User Verify All the PageButtons Available: Add, Add All, Remove, Remove All for Provider
	And Verify User is able to access Add Button Functionality for Provider
	And Verify User is able to access Remove Button Functionality for Provider
	Then Verify User is able to access Add All Button Functioanlity for Provider
 	And Verify User is able to access Remove All Button Functionality for Provider
 	And Verify User is able to access Reset Functionality for Provider
    Examples:     
             |       credentials       |		portalAccess    	|   userType    |  searchCriteria     | tinType		|
             |       PROV_Admin        | 			 Premium  			|			PROV			|		Last 9-13 months	|  	AO			|
@TC003
 	Scenario Outline: Validations to check errors 
 	Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
 	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And Verify Error Message upon clicking Submit Button without selecting any Fields for Provider
	And Verify Error Message when Settlement Date is not Selected for Provider
	And Verify Error Message when File Types is not Selected for Provider
	And Verify Error Message when Settlement Date range is selected for more than 30 Days Between From and To Date for Provider
	Then Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for Provider
	And Verify Error Message when No Payer is Selected for Provider
	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |
     
@TC004  @UPASanity  @UPADataBundleSanity  
	Scenario Outline: Data Bundle Submission : EPRAs
  Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User selects All Payers from the Payer List for Provider
	And User Enter Settlement Date in TO and From Date Range for Provider
	And User verifies All the Three File Type Options for Provider
	Then User selects File Type Option as EPRA and Submit Payment Data Bundle Request for Provider
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type for Provider
		And User verifies the EPRA indicator in Database entry for Provider
 	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |
 
@TC005
	Scenario Outline: Data Bundle Submission : PPRAs
  Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User selects All Payers from the Payer List for Provider
	And User Enter Settlement Date in TO and From Date Range for Provider
	And User verifies All the Three File Type Options for Provider
	Then User selects File Type Option as PPRA and Submit Payment Data Bundle Request for Provider
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type for Provider
		And User verifies the PPRA indicator in Database entry for Provider
 	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |
        
@TC006
 Scenario Outline: Data Bundle Submission : 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User selects All Payers from the Payer List for Provider
	And User Enter Settlement Date in TO and From Date Range for Provider
	And User verifies All the Three File Type Options for Provider
	Then User selects File Type Option as 835 and Submit Payment Data Bundle Request for Provider
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for 835 File Type for Provider
	And User verifies the 835 indicator in Database entry for Provider
  Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |
        
@TC007
 Scenario Outline: Validate the Data Bundle Submission of EPRA and PPRA
 	Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User selects All Payers from the Payer List for Provider
	And User Enter Settlement Date in TO and From Date Range for Provider
	And User verifies All the Three File Type Options for Provider
 Then User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request for Provider
 And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type for Provider
  And User verifies the EPRA and PPRA indicator in Database entry for Provider
   Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |
        
@TC008
	Scenario Outline: Validate the Data Bundle Submission of EPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User selects All Payers from the Payer List for Provider
	And User Enter Settlement Date in TO and From Date Range for Provider
	And User verifies All the Three File Type Options for Provider
	Then User selects File Type Option as EPRA and 835 and Submit Payment Data Bundle Request for Provider
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and 835 File Type for Provider
		And User verifies the EPRA and 835 indicator in Database entry for Provider
    Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |

@TC009
 Scenario Outline: Validate the Data Bundle Submission of PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User selects All Payers from the Payer List for Provider
	And User Enter Settlement Date in TO and From Date Range for Provider
	And User verifies All the Three File Type Options for Provider
	Then User selects File Type Option as PPRA and 835 and Submit Payment Data Bundle Request for Provider
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and 835 File Type for Provider
		And User verifies the PPRA and 835 indicator in Database entry for Provider
	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |
        
 @TC010
	Scenario Outline: Validate the Data Bundle Submission of EPRA, PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User selects All Payers from the Payer List for Provider
	And User Enter Settlement Date in TO and From Date Range for Provider
	And User verifies All the Three File Type Options for Provider
 	Then User selects File Type Option as EPRA PPRA and 835 and Submit Payment Data Bundle Request for Provider
 	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and 835 File Type for Provider
 	 	And User verifies the EPRA, PPRA and 835 indicator in Database entry for Provider
	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |
        
@TC011
	Scenario Outline: Validate Data Bundle Request Completed in Last 7 Days
	Given User navigates to UPA portal and enters "<credentials>" to login as Provider
	And User selects tin for UPA "<Search Criteria>" 
	When User clicks on Data Bundle Tab for Provider
	And Verify User navigates to Create Data Bundle Page on UI for Provider
	And User verifies the Data Bundle Request Completed in Last 7 Days for the Provider User
	And User Click on Download Data Bundle Tab on UI for Provider
	Then User validates the completed File Name in the Grid for Provider
	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Provider        |       PROV_Admin         |