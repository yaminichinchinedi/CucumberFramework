#Author: Sayonee
 @CSRRunReports @CSRRegression

Feature: CSR Run Reports Feature

    @CSROrgProvUserHistory1
    Scenario Outline: Validating if the create edit and delete users affects the org user history report
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
   Then create new user of "<userType>" , "<accessLevelOfNewUser>" 
    And User clicks on Run Reports link
    Then verify reports for "<userType>"
    When Click on CSRManage User Link
    Then Delete the "<userType>" user
    And User clicks on Run Reports link
    Then verify reports for "<userType>"
    When Click on CSRManage User Link
    Then User enters "<userType>"and update existing user
    And User clicks on Run Reports link
    Then verify reports for "<userType>"

   
    Examples:
      |    userType     |   credentials    |  accessLevelOfNewUser |
      |      PROV       |      Super      |  	 General       		  |

    @CSROrgBSUserHistory1
    Scenario Outline: Validating if the create edit and delete users affects the org user history report
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on CSRManage User Link
   Then create new user of "<userType>" , "<accessLevelOfNewUser>" 
    And User clicks on Run Reports link
    Then verify reports for "<userType>"
    When Click on CSRManage User Link
    Then Delete the "<userType>" user
    And User clicks on Run Reports link
    Then verify reports for "<userType>"
    When Click on CSRManage User Link
    Then User enters "<userType>"and update existing user
    And User clicks on Run Reports link
    Then verify reports for "<userType>"

   
    Examples:
      |    userType     |   credentials    |  accessLevelOfNewUser |
       |      BS         |      Super       |  	 General       		  |
      
      
     @CSROrgUserHistory
    Scenario Outline: Validating if the report is in printable form and Change Description available in OrgUserHistory
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Organization User History
    And Input the data range and tin for Organization User History
    Then Validate if description link is present
    And Validate if the print button is present
    And Validate if the Save As Excel button is present
       
    Examples: 
      | credentials | userType |
      | Super       | PROV     |
     
   @CSROrgBSHistory
    Scenario Outline: Validating if the report is in printable form and Change Description available in OrgUserHistory
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Biling Service History
    And Input the data range and tin for Billing Service User History
    Then Validate if description link is present
    And Validate if the print button is present
    And Validate if the Save As Excel button is present
   
    Examples: 
      | credentials | userType |
      | Super       | BS       | 
      
#Feature: mouse hover functionality in Run Reports CSR
 @ReportingHoverMessage1 @CSRUS2987360

    Scenario Outline: Verify mouse hover functionality CSR for HIPAA Error Summary Report
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on HIPAA Error Summary Report
    Then verify hover functionality

 Examples: 
      | credentials | userType |
      | Super       | PROV     |
      
      
 @ReportingHoverMessage2 @CSRUS2987360
    Scenario Outline: Verify mouse hover functionality CSR for Payment/Remit Only Payment Summary Report
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Payment/Remit Only Payment Summary Report
    Then verify hover functionality
 Examples: 
      | credentials | userType |
      | Super       | PROV     |
      
  @ReportingHoverMessage3 @CSRUS2987360
    Scenario Outline: Verify mouse hover functionality CSR for Payment Summary Report
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Payment Summary Report
     Then verify hover functionality

 Examples: 
      | credentials | userType |
      | Super       | PROV     |
      
  @ReportingHoverMessage4 @CSRUS2987360
    Scenario Outline: Verify mouse hover functionality CSR for Transaction Summary Report
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Transaction Summary Report
    Then verify hover functionality

 Examples: 
      | credentials | userType |
      | Super       | PROV     |
      
     @CSRUS3206668
  Scenario Outline: TIN Report generation reports
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Customised TIN Rate radio button
    And Validate if the print button is present
    And Validate if the Save As Excel button is present
    And Validate if the New Report button is present
    And Validates that each column is sortable
   
    Examples: 
      | credentials |
      | Super       |
      
      
   @CSRUS3458065
   Scenario Outline: Verify the change description field in Organization History Report for fraud users
    Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.  
    When  User clicks on Manage Users link
    Then  User Enters tin and click on search button for "<userType>" on CSR Manage Users page.
    And   User deletes the fraud user
    And   User Clicks on CSR home link
    And   User clicks on Run Reports link
    When  User clicks on Organization User History
    And User Inputs the date range as current date and tin
    Then User verifies the field change description for the fraud user
    
    
	  
	  Examples:
        |    userType      |   credentials     |  searchCriteria        | 
        |      PROV        |      Super        | ProvTinWithActiveUser  |