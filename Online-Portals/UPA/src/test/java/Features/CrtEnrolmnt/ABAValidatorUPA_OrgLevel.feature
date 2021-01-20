
#Author:Rahul Krishna
@UPAUS2690163
Feature: US2690163UPAOrg-Create Enrollment UPA- RTN API Request/Response - Org Financial Institution Information

  Background: ABA Validator - Financial Institution Page
    When  ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
#TS_001,TS_003

  Scenario: Create Enrollment-UPA- RTN API Request/Response- Format Bank Info
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then clicks back button on Upload WNine Page.
    And modify/remove RTN No making as invalid,validations are performed

	    
    
	
  Scenario: Create Enrollment-UPA- RTN API Request/Response- Error Messages Validation
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No

    
    
   Scenario: ABN Validators Financial Institution Information -Org Level Error Messages ReValidations
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  	And User validates fiels are editables on Financial Institution Information page
  	And Validates buttons on Edit Financial Institution Information Page
		Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator     
		
		
		Scenario: ABN Validators Financial Institution Information -Org Level Revalidations
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And Clicks on Cancel Changes button on Financial Institution Page. 
    And Validate no changes are saved on Review Submit Page for Financial Institution section.
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    Then Users clears the RTN No fill the new RTN No and validate the details and click on Save changes button
    And Validate the changes are reflected on Review and Submit Page.