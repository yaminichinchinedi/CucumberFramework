#Author: Vinay Raghumanda

@CSRRemitDetail   @CSRRegression @CSRSanity @BothCSRUPAScenarios
Feature: CSR Remittance Detail
@vinay
  Scenario Outline: Remittance Detail UI Functionality and FISL Data Validations for Multiple PLB adjustments

    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Search Remittance link
    And User enters tin for Mutliple PLB Adjustments Criteria
    And Enter Electronic Payment Number based on "<CriteriaType>"
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
      | credentials | usertype | CriteriaType |
      | Super       | PROV     | RemitDetail  |
      #| RW          | PROV     | RemitDetail  |
      #| RO          | PROV     | RemitDetail  |

  Scenario Outline: Remittance Detail UI Functionality and FISL Data Validations for PLB adjustments

    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Search Remittance link
    And User enters tin for PLB Adjustment Only Criteria
    And Enter Electronic Payment Number based on "<CriteriaType>"
    Then Verify FISL Response vs Remittance Detail UI
    And Validate Payment with PLB Adjustments

    Examples:
      | credentials | CriteriaType |
      | Super       | RemitDetail  |
      | RW          | RemitDetail  |
      | RO          | RemitDetail  |

  @US2707342
  Scenario Outline: Remittance Detail Page UI Functionality with Check Number

    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Search Remittance link
    And User Enters TIN for Check Number
    And Enter Check Number and click search
    And Validate Download, Print, Return buttons in Remit Page
    Then Validate all Headers in the Page
    Then Validate Column Headers in the Page

    Examples:
      | credentials |
      | Super       |