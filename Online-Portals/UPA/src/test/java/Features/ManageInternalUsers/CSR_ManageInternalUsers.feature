#Author: Sayonee
@CSRManageInternalUsers
Feature: Manage Internal Users link on CSR

  @US2944327
  Scenario Outline: Optum Pay Solutions transaction can be added/removed from RW and RO CSRs, and Publish roles
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Manage Internal Users link
    And  Enter "<credential2>" in userid
    And Edit OptumPay Sol Transactions "<Action>"
    And User navigates to CSR portal and enters "<credential2>" and login
    And Check if OptumPay Solutions is present or not based on "<Action>"
    
   
 Examples: 
 

 
   |credentials|credential2|Action|
   |Super      | RW        |Remove|
  |Super      | RW        |Add   |
   |Super      | RO        |Remove|
   |Super      | RO        |Add   |
  |Super      | Super     |Add   |
   |Super      | Super     |Remove|