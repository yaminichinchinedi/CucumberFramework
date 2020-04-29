#Author: Sahil D Sharma

@UPADataBundle  @UPARegression   @BothCSRUPAScenarios
Feature: UPA_Payer_Data Bundle_Regression

	@TC001
	Scenario Outline: UI Validations for Data Bundle
 	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>" 
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	Then Verify the values in Create Data Bundle Page for Payer
	Examples: 
				|    Search Criteria    |       credentials        |    
        |        Payer        	|       PAY_Admin	    	   |
        
@TC002
 	Scenario Outline: Validations to check errors 
 	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
 	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And Verify Error Message upon clicking Submit Button without selecting any Fields for Payer
	And Verify Error Message when Settlement Date is not Selected for Payer
	And Verify Error Message when File Types is not Selected for Payer
	And Verify Error Message when Settlement Date range is selected for more than 30 Days Between From and To Date for Payer
	Then Verify Error Message when Settlement Date selected To/From Dates prior to or same as Current date for Payer
	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer           |       PAY_Admin	        |
        

@TC003   @UPASanity  @UPADataBundleSanity
	Scenario Outline: Data Bundle Submission : EPRAs
  Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And User Enter Settlement Date in TO and From Date Range for Payer
	And User verifies All the Three File Type Options for Payer
	Then User selects File Type Option as EPRA and Submit Payment Data Bundle Request for Payer
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA File Type for Payer
	And User verifies the EPRA indicator in Database entry for Payer
 	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer       		 |       PAY_Admin     	    |

@TC004
	Scenario Outline: Data Bundle Submission : PPRAs
  Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And User Enter Settlement Date in TO and From Date Range for Payer
	And User verifies All the Three File Type Options for Payer
	Then User selects File Type Option as PPRA and Submit Payment Data Bundle Request for Payer
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA File Type for Payer
	And User verifies the PPRA indicator in Database entry for Payer
 	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer       		 |       PAY_Admin          |

@TC005
 Scenario Outline: Data Bundle Submission : 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And User Enter Settlement Date in TO and From Date Range for Payer
	And User verifies All the Three File Type Options for Payer
	Then User selects File Type Option as 835 and Submit Payment Data Bundle Request for Payer
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for 835 File Type for Payer
	And User verifies the 835 indicator in Database entry for Payer
  Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer           |        PAY_Admin	     	  |
        
  
 @TC006
 Scenario Outline: Validate the Data Bundle Submission of EPRA and PPRA
 	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And User Enter Settlement Date in TO and From Date Range for Payer
	And User verifies All the Three File Type Options for Payer
 Then User selects File Type Option as EPRA and PPRA and Submit Payment Data Bundle Request for Payer
 And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and PPRA File Type for Payer
 And User verifies the EPRA and PPRA indicator in Database entry for Payer
   Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer	         |       PAY_Admin          |
        
@TC007
	Scenario Outline: Validate the Data Bundle Submission of EPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And User Enter Settlement Date in TO and From Date Range for Payer
	And User verifies All the Three File Type Options for Payer
	Then User selects File Type Option as EPRA and 835 and Submit Payment Data Bundle Request for Payer
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA and 835 File Type for Payer
	And User verifies the EPRA and 835 indicator in Database entry for Payer
    Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer	         |       PAY_Admin          |
        
 @TC008
 Scenario Outline: Validate the Data Bundle Submission of PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And User Enter Settlement Date in TO and From Date Range for Payer
	And User verifies All the Three File Type Options for Payer
	Then User selects File Type Option as PPRA and 835 and Submit Payment Data Bundle Request for Payer
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for PPRA and 835 File Type for Payer
	And User verifies the PPRA and 835 indicator in Database entry for Payer
	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer	         |       PAY_Admin          |
        
 @TC009
	Scenario Outline: Validate the Data Bundle Submission of EPRA, PPRA and 835s
	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
	And Verify User navigates to Create Data Bundle Page on UI for Payer
	And User Enter Settlement Date in TO and From Date Range for Payer
	And User verifies All the Three File Type Options for Payer
 	Then User selects File Type Option as EPRA PPRA and 835 and Submit Payment Data Bundle Request for Payer
 	And User Verifies Data Bundle Request entry in Download Data Bundle Page for EPRA PPRA and 835 File Type for Payer
 	And User verifies the EPRA, PPRA and 835 indicator in Database entry for Payer
	Examples: 
				|    Search Criteria     |       credentials        |    
        |        Payer	         |       PAY_Admin          |
 
 
 	@TC010
	Scenario Outline: Validate the Data Bundle Submission for Rally Pay Patient Payer
	Given User navigates to UPA portal and enters "<credentials>" to login as Payer
	When User clicks on Data Bundle Tab for Payer
	And User enters Provider tin for UPA "<Search Criteria>"
  And Verify User navigates to Create Data Bundle Page on UI for Payer
  And User Enter Settlement Date in TO and From Date Range for Payer  
  And User verifies All the Three File Type Options for Payer
 And User verifies EPRA and PPRA Options Disabled for Payer
 Then User selects File Type Option as 835 and Submit Payment Data Bundle Request for Payer
	And User Verifies Data Bundle Request entry in Download Data Bundle Page for 835 File Type for Payer
	And User verifies the 835 indicator in Database entry for Payer 
	Examples:
     		|    Search Criteria     |       credentials        			|    
        |        Payer	         |       PAY_Rally_Admin          |