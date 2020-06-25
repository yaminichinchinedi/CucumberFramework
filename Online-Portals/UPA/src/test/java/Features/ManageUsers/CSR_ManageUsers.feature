#Author: Priyanka
Feature: PRJ202767 Fraud Prevention - Purged Users - CSR - Payer Manage Users - QA

			
@CSRPurgedTest1
Scenario Outline: US2684242_1_CSR_SuperUser_ManageUsers_checkforViewPurgedUsers

	Given User navigates to CSR portal and enters "<credentials>" and login
	When  User clicks on Manage Users link
	And   Search for "<userType>" with "<searchCriteria>"
	Then  Verify Purged user option state is "<expectedState>" 
	
	Examples:
	
					|  credentials	|   userType  |  searchCriteria   |  expectedState |  
					|     Super     |   PAY       |    PurgedUsers    |     enabled    |
					|     Super     |   PAY       |    NoPurgedUsers  |        true    |
#					|     Super     |   PAY       |    NoPurgedUsers  |     disabled   |
                    |     RO        |   PAY       |      PurgedUsers  |     enabled    |
                    |     RO        |   PAY       |    NoPurgedUsers  |     true       |
                    |     RW        |   PAY       |      PurgedUsers  |     enabled    |
                    |     RW        |   PAY       |    NoPurgedUsers  |     true       |
					
@CSRPurgedTest2
Scenario Outline: US2684242_2_CSR_SuperUsers_ManageUsers_selectViewPurgedUsers_CheckDesignation + US2684242_3_CSR_SuperUser_ManageUsers_UnselectViewPurgedUsers_CheckDesignation

	Given User navigates to CSR portal and enters "<credentials>" and login
	When  User clicks on Manage Users link
	And   Search for "<userType>" with "<searchCriteria>"
	Then  Verify Users List for "<userType>" with "<searchCriteria>" on selecting and deselecting of purge checkbox
	
	Examples:
	
					|  credentials	|   userType  |  searchCriteria   |  
					|     Super     |   PAY       |    PurgedUsers    | 
					|     RO        |   PAY       |    PurgedUsers    |
					|     RW        |   PAY       |    PurgedUsers    | 
					
					
@CSRPurgedTest3
Scenario Outline: US2684242_4_CSR_SuperUser_ManageUsers_ValidationforViewPurgedUsers

	Given User navigates to CSR portal and enters "<credentials>" and login
	When  User clicks on Manage Users link
	And   Search for "<userType>" with "<searchCriteria>"
	Then  Verify UI Details for Purged "<userType>" user
	
	Examples:
					|  credentials	|   userType  |  searchCriteria   |  
					|     Super     |   PAY       |    PurgedUsers    |  
					|     RO        |   PAY       |    PurgedUsers    |
					|     RW        |   PAY       |    PurgedUsers    | 
			  	 




																