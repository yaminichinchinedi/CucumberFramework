#Author: Sahil D Sharma

 @UPADataBundle  @UPARegression
Feature: UPA_Billing_Service_Data Bundle_Regression

	@TC001								
	Scenario Outline: UI Validations for Data Bundle
 	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	Then Verify the values in Create Data Bundle Page for Billing Service
	Examples: 
				|        Search Criteria  			  |       credentials        |    
        |        Billing Service        	|       BS_Admin	         |
        
@TC002
	Scenario Outline: Verify Payer and PageButton Validations
	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Verify Payer Name List in Payer Selection Grid for Billing Service
	And User Verify All the PageButtons Available: Add, Add All, Remove, Remove All for Billing Service
	And Verify User is able to access Add Button Functionality for Billing Service
	And Verify User is able to access Remove Button Functionality for Billing Service
	Then Verify User is able to access Add All Button Functioanlity for Billing Service
 	And Verify User is able to access Remove All Button Functionality for Billing Service
 	And Verify User is able to access Reset Functionality for Billing Service
Examples: 
				|    		Search Criteria         |       credentials        |    
        |        Billing Service        |       	BS_Admin         |

@TC003	
 	Scenario Outline: Validations to check errors 
 	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
 	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And Verify Error Message upon clicking Submit Button without selecting any Fields for Billing Service
	And Verify Error Message when Settlement Date is not Selected for Billing Service
	And Verify Error Message when File Types is not Selected for Billing Service
	And Verify Error Message when Settlement Date range is selected for more than 30 Days Between From and To Date for Billing Service
	Then Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for Billing Service
	And Verify Error Message when No Payer is Selected for Billing Service
Examples: 
				|    		Search Criteria         |       credentials        |    
        |        Billing Service        |       	BS_Admin         |
        
@TC004  @UPASanity  @UPADataBundleSanity
	Scenario Outline: Data Bundle Submission : EPRAs
  Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Enter Settlement Date in TO and From Date Range for Billing Service
	And User selects All Payers from the Payer List for Billing Service
	And User verifies All the Three File Type Options for Billing Service
	Then User selects File Type Option as EPRA and Submit Payment Data Bundle Request for Billing Service
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type for Billing Service
	And User verifies the EPRA indicator in Database entry for Billing Service
 	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |
        
@TC005
	Scenario Outline: Data Bundle Submission : PPRAs
  Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Enter Settlement Date in TO and From Date Range for Billing Service
	And User selects All Payers from the Payer List for Billing Service
	And User verifies All the Three File Type Options for Billing Service
	Then User selects File Type Option as PPRA and Submit Payment Data Bundle Request for Billing Service
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type for Billing Service
	And User verifies the PPRA indicator in Database entry for Billing Service
 	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |
        
@TC006
 Scenario Outline: Data Bundle Submission : 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Enter Settlement Date in TO and From Date Range for Billing Service
	And User selects All Payers from the Payer List for Billing Service
	And User verifies All the Three File Type Options for Billing Service
	Then User selects File Type Option as 835 and Submit Payment Data Bundle Request for Billing Service
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for 835 File Type for Billing Service
	And User verifies the 835 indicator in Database entry for Billing Service
	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |
        
@TC007
 Scenario Outline: Validate the Data Bundle Submission of EPRA and PPRA
 	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Enter Settlement Date in TO and From Date Range for Billing Service
	And User selects All Payers from the Payer List for Billing Service
	And User verifies All the Three File Type Options for Billing Service
 Then User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request for Billing Service
 And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type for Billing Service
 And User verifies the EPRA and PPRA indicator in Database entry for Billing Service
	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |
        
@TC008
	Scenario Outline: Validate the Data Bundle Submission of EPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Enter Settlement Date in TO and From Date Range for Billing Service
	And User selects All Payers from the Payer List for Billing Service
	And User verifies All the Three File Type Options for Billing Service
	Then User selects File Type Option as EPRA and 835 and Submit Payment Data Bundle Request for Billing Service
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and 835 File Type for Billing Service
	And User verifies the EPRA and 835 indicator in Database entry for Billing Service
	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |
        
 @TC009
 Scenario Outline: Validate the Data Bundle Submission of PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Enter Settlement Date in TO and From Date Range for Billing Service
	And User selects All Payers from the Payer List for Billing Service
	And User verifies All the Three File Type Options for Billing Service
	Then User selects File Type Option as PPRA and 835 and Submit Payment Data Bundle Request for Billing Service
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and 835 File Type for Billing Service
	And User verifies the PPRA and 835 indicator in Database entry for Billing Service
	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |
        
 @TC010
	Scenario Outline: Validate the Data Bundle Submission of EPRA, PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User Enter Settlement Date in TO and From Date Range for Billing Service
	And User selects All Payers from the Payer List for Billing Service
	And User verifies All the Three File Type Options for Billing Service
 	Then User selects File Type Option as EPRA PPRA and 835 and Submit Payment Data Bundle Request for Billing Service
 	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and 835 File Type for Billing Service
 	And User verifies the EPRA, PPRA and 835 indicator in Database entry for Billing Service
	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |
        
@TC011
	Scenario Outline: Validate Data Bundle Request Completed in Last 7 Days
	Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
	When User clicks on Data Bundle Tab for Billing Service
	And User enters Provider Tin associated to BS for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Billing Service
	And User verifies the Data Bundle Request Completed in Last 7 Days for Billing Service User
	And User Click on Download Data Bundle Tab on UI for Billing Service
	Then User validates the completed File Name in the Grid for Billing Service
	Examples: 
				|    Search Criteria     			|       credentials         |    
        |        Billing Service      |       BS_Admin     	  	  |