#Author: Athyusha Thota
@US2637617_CSR @CSRRegression
Feature: CSR Reset Password

Scenario Outline: CSR Manage User UI Check Reset Password Visibility

    Given User navigates to CSR portal and enters "<credentials>" and login
    When User clicks on Manage Users link
    Then User enters "<userType>" in Manage Users Page to enter TIN
    And Verify Reset Password Option doesnt exists
 
 Examples:
    
   |    userType    |   credentials   |
   |     PROV       |     Super       |
   |     BS         |     Super       |
   |     PAY        |     Super       |
   |     PROV       |     RW          |
   |     BS         |     RW          |
   



    
     
     