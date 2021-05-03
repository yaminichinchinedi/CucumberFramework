#Author: Vinay Raghumanda

@UPARemitDetail @UPARegression  @UPASanity @BothCSRUPAScenarios
Feature: UPA Remittance Detail Provider

  @UPARemitDetailProv
  Scenario Outline: Remittance Detail UI and FISL Validations for Provider User

    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then User clicks on Search Remittance link for UPA
    Then User enters "<Search Criteria>" and click on search button.
    Then Verify FISL Response vs Remittance Detail UI
    Then Validate all Headers in the Page
    Then Validate Column Headers in the Page
    And Validate Download, Print, Return buttons in Remit Page
    And Verify Pagination functionality
    And Check RMK Code Pop Up
    And Check Adj Reason Code Pop Up
    And Verify FISL Response for COB Only Filter Claim for "<usertype>"
    And Verify FISL Response for Reversal Only Filter Claim for "<usertype>"

    Examples:
      | Search Criteria       | credentials | userType | portalAccess | searchRemitorPymntTIN | tinType |
      | byElectronicPayNum    | PROV_Admin  | PROV     | Premium      | TinWthatlstOnePayNum  | VO      |
      | byElectronicPaymentNo | PROV_Admin  | PROV     | Premium      | byElectronicPaymentNo | AO      |


  Scenario Outline: Remittance Detail single and multiple PLB Adjustments for Provider

    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then User clicks on Search Remittance link for UPA
    And Enter Electronic Payment Number based on "<Search Criteria>"
    Then Verify FISL Response vs Remittance Detail UI
    And Validate Payment with PLB Adjustments
    Then Validate all Headers in the Page
    Then Validate Column Headers in the Page
    And Validate Download, Print, Return buttons in Remit Page
    And Verify Pagination functionality
    And Check RMK Code Pop Up
    And Check Adj Reason Code Pop Up
    And Verify FISL Response for COB Only Filter Claim for "<usertype>"
    And Verify FISL Response for Reversal Only Filter Claim for "<usertype>"

    Examples:

      | Search Criteria       | credentials | userType | portalAccess | searchRemitorPymntTIN  | tinType |
      | byElectronicPayNum    | PROV_Admin  | PROV     | Premium      | Multiple_PLB_ProvAdmin | VO      |
      | byElectronicPaymentNo | PROV_Admin  | PROV     | Premium      | PLB_Adj_Only_ProvAdmin | AO      |

  Scenario Outline: Remittance Detail UI Functionality with Check Number

    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then User clicks on Search Remittance link for UPA
    Then User enters "<Search Criteria>" and click on search button.
    Then Verify FISL Response vs Remittance Detail UI
    Then Validate all Headers in the Page
    Then Validate Column Headers in the Page
    And Validate Download, Print, Return buttons in Remit Page
    And Verify Pagination functionality
    And Check RMK Code Pop Up
    And Check Adj Reason Code Pop Up
    And Verify FISL Response for COB Only Filter Claim for "<usertype>"
    And Verify FISL Response for Reversal Only Filter Claim for "<usertype>"

    Examples:

      | Search Criteria | credentials | userType | portalAccess | searchRemitorPymntTIN | tinType |
      | byCheckNo       | PROV_Admin  | PROV     | Premium      | byCheckNo             | AO      |