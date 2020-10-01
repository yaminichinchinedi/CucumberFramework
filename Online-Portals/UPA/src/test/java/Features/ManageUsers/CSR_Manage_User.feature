#Author: vinit_rohela@optum.com
@CSRManageUsers @CSRRegression
Feature: CSR Manage User Functionality


@US2707358 
  Scenario Outline: CSR Manage User UI Functionality Portal User History
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>" in Manage Users Page and Updates an active User and verify the user details in the UI and DB
    Examples:
      |    userType     |   credentials   |  
      |      PROV       |      Super      |
      |      PAY        |      Super      |
      
@CSRManageUsers1 
  Scenario Outline: CSR Manage User UI Functionality Add new user
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>" in Manage Users Page and Click to add new User and fill the details "<accessLevelOfNewUser>" and verify the user detils and delete the user
    Examples:
      |    userType     |   credentials   |  accessLevelOfNewUser |
      |      PAY        |      Super      |	 Administrator		  |
      |      PROV       |      Super      |	 Administrator		  |
      |      BS         |      Super      |	 Administrator		  |
      

  Scenario Outline: CSR Manage User UI Functionality Verifies Details
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then validate User enters "<userType>" to verify acive admin, access level, email check, remove tin "<disabledValue>" and modify email "<email>" and "<firstName>" firstName
    Examples:
      |    userType     |   credentials   |		disabledValue		|   email   |   firstName   |
      |      PROV       |      Super      |		disabled			|   email   |   firstName   |

  Scenario Outline: CSR Manage User UI Functionality Verifies Details
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>" in Manage Users Page and Verifies if a tin has only one active admin , access level dropdown, email check box & remove tin/npi checkbox "<disabledValue>" is disabled after modifying the Last name of user with both valid and invalid data
    Examples:
      |    userType     |   credentials   |		disabledValue		|
      |      PROV       |      Super      |		disabled			|

  Scenario Outline: CSR Manage User UI Functionality Verifies Details
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>" in Manage Users Page and Verifies access level,email and npi/tin checkbox remains disabled for a user who is the only active admin for a tin when gets associated with another new tin and Verifies if the new tin is removed then also these items access level etc remains "<disabledValue>" disabled for the only active admin tin
    Examples:
      |    userType     |   credentials   |		disabledValue		|
      |      PROV       |      Super      |		disabled    		|
      
  
  @CSR_AugRelease
	@CSRManageUsers_US2769380
  Scenario Outline: CSR Manage User UI Functionality Add new user using Purged user Email address
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>" in Manage Users Page and Click to add new User using "<stsCode>"  and fill the details "<accessLevelOfNewUser>" and verify the user detils and delete the user
   	Then Validate status of purged user for "<userType>" in tables.
    Examples:
      |    userType     |   credentials   |  stsCode 	 | accessLevelOfNewUser   	|
      |    PROV			    |      Super      |	 		PU     |			Administrator				|
      |      BS         |      Super      |	 	  PU 		 |			Administrator				|
      |      PAY        |      Super      |	    PU		 |			Administrator				|
      
			
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
					#|     RO        |   PAY       |    PurgedUsers    |
					#|     RW        |   PAY       |    PurgedUsers    | 
					
					
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
			  	 

@CSRUS2684219 @CSRUS2767633 @CSR_AugRelease 
Scenario Outline: CSR Manage Purse User 
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>"  and Purged TIN  and click on Search button in Manage Users Page
    Then User clicks on View Purge Users checkbox
    Then User clicks on one of Purged User from User list and perform validations like Name,Phone No,Email,TIN List,buttons disabled for "<credentials>" user 
    Examples:
      |    userType     |   credentials   |   
      #|      PROV       |      ROOnly    	|	 
      #|      PROV       |      RWOnly    	|	 
      |      PROV       |      Super      |	
      |      PROV       |      RO 				|
      |      PROV       |      RW 				|

      
#Author:Sunanda       
@US2020806
Scenario Outline: CSR Manage User UI Functionality Add new user
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>" in Manage Users Page and Click to add new User and fill the details "<accessLevelOfNewUser>" and verify the user detils and delete the user
    Examples:
      |    userType     |   credentials   |  accessLevelOfNewUser |
      |      PROV       |      Super      |	 Administrator		  |
      |      BS         |      Super      |	 Administrator		  |
      |      PAY        |      Super      |	 Administrator		  |     
      
#Author:Sunanda    
@US2854207
Scenario Outline: CSR Manage User UI Functionality Add new user
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
    Then User enters "<userType>" and adds new User with "<accessLevelOfNewUser>" and verifies and deletes the user
    Examples:
      |    userType     |   credentials   |  accessLevelOfNewUser |
      |      PROV       |      Super      |	 Administrator		  |
      |      BS         |      Super      |	 Administrator		  |
      |      PAY        |      Super      |	 Administrator		  |
 