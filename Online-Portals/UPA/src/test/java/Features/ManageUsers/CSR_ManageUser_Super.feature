#Author: vishal_mishra@optum.com

@CSRManageUsers @CSRRegression @CSRManageUsersSuperUser
Feature: CSR Manage User Functionality for super user
	
	Scenario Outline: Manage User page UI validation for provider/payer/billing service
		Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link 
    And selects "<userType>" from dropdown, enters tin on Search Tin Page for the selected usertype and clicks on search button
    Then User verifies the UI for selected "<userType>"
		Examples:
     |    userType     |   credentials   |  
     |      PROV       |      Super      |     
     |      PAY        |      Super      |
     |      BS	       |      Super      |
                
 	Scenario Outline: Manage User - Add user validation for provider/payer/billing service
		Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link 
    And selects "<userType>" from dropdown, enters tin on Search Tin Page for the selected usertype and clicks on search button
    And Adds a user for the selected "<userType>" with "<tinAccessLevel>" and "<subPayerAccess>" or "<AssociateBStoAllProv>"
    Then Verify that user successfully created message is displayed for the newly created "<userType>"
    And Verify that user is added for the selected "<userType>"
		Examples:
     |    userType     |   credentials   |  tinAccessLevel  |  subPayerAccess  |  AssociateBStoAllProv  |
     |      PROV       |      Super      |  Administrator   |      No          |       No               |
     |      PAY        |      Super      |	Administrator   |			 Yes         |       No               |
     |      PAY        |      Super      |	Administrator   |			 No          |       No               |
     |      BS	       |      Super      |  Administrator   |      No          |       Yes              |
     |      BS	       |      Super      |  Administrator   |      No          |       No               |

  Scenario Outline: Manage User- Edit and Save functionality  for provider/payer/billing service
		Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link 
    And selects "<userType>" from dropdown, enters tin on Search Tin Page for the selected usertype and clicks on search button
    And Selects an active user from the user list
    And Edits the user details
    Then Verify that user successfully updated message is displayed
    And Verify the updated user details in database
		Examples:
     |    userType     |   credentials   |  tinAccessLevel  |  subPayerAccess  |  AssociateBStoAllProv  |
     |      PROV       |      Super      |  Administrator   |      No          |       No               |
     |      PAY        |      Super      |	Administrator   |			 No          |       No               |
     |      BS	       |      Super      |  Administrator   |      No          |       Yes              |
     
     
     
     
     
     
     
     