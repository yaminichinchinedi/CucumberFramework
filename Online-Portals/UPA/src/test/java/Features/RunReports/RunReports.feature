#Author: Sayonee
 @CSRRunReports

Feature: CSR Run Reports Feature

   @OrgUserHistory1 @OrgBSUserHistory1 @adtoy @CSRUS2048441
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
      |    userType     |   credentials   |		disabledValue		|   email   |   firstName   |  accessLevelOfNewUser |
      |      PROV       |      Super      |		disabled			  |   email   |   firstName   |  	 General       		  |
     # |      BS         |      Super      |		disabled			  |   email   |   firstName   |  	 General       		  |
      
     @OrgUserHistory @CSRUS2048441
    Scenario Outline: Validating if the report is in printable form and Change Description available in OrgUserHistory
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Organization User History
    And Input the data range and tin for "<userType>"
    Then Validate if description link is present
    And Validate if the print button is present
    And Validate if the Save As Excel button is present
       
    Examples: 
      | credentials | userType |
      | Super       | PROV     |
     
   @OrgBSHistory @CSRUS2048441
    Scenario Outline: Validating if the report is in printable form and Change Description available in OrgUserHistory
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User clicks on Run Reports link
    When User clicks on Biling Service History
    And Input the data range and tin for "<userType>"
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
      
   