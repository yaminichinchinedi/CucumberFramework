#Author: chandaka_srinu@optum.com
Feature: UPA ViewPayments Functionality for Premium TINs

  Scenario Outline: UPA_Provider admin _View payment UI validation for ACH-Premium-TIN
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetch tin for "<userType>" for "<QuickSearch>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And Click on View Payments Link for UPA
    Then Verify UI of view payment for "<userType>" of TIN  for "<tinType>" for "<portalAccess>"
    #  And Validate View Payments page Text for "<credentials>" for "<portalAccess>"
    And Verify Quick Search dropdown and its default value
    And Verify Filter Payments dropdown and its default value
    And Verify Market Type dropdown and its default value
    And Verify Payment Status dropdown and its default value for "<portalAccess>" TIN
    Then Validate the Footer Information on this page

    Examples: 
      | credentials | userType | QuickSearch      | portalAccess | tinType |
      | PROV_Admin  | PROV     | Last 30 days | Premium      | AO      |
     # | PROV_Gen    | PROV     | Last 9-13 months | Premium      | AO      |

  @CSRTEST01
  Scenario Outline: UPA_Provider admin _View payment UI validation for ACH-Premium-TIN
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetch tin for "<userType>" for "<QuickSearch>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And Click on View Payments Link for UPA
    Then User set filters for "<QuickSearch>", "<FilterPayments>", "<MarketType>", "<PaymentStatus>" on view payments screen
    And User validate columns for the "<tinType>" with "<credentials>" for the "<portalAccess>" TIN
    And Verify Search Results With "<FilterPayments>" for "<QuickSearch>" With "<FilterPayments>"
    And Verify results should be in chronological order and maximum record should be 30
    And Click on print Payment Summary button.
    And Validate the data of Print Payment Summary page.
    Examples: 
      | credentials | userType | QuickSearch      | portalAccess | tinType | FilterPayments | MarketType | PaymentStatus |
      | PROV_Admin  | PROV     | Last 30 days | Premium      | AO      | Show All       | Show All   | Show All      |
  
