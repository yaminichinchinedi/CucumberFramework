
#Author: Vinay Raghumanda

@UPARemitDetail  @UPARegression @BothCSRUPAScenarios
Feature: UPA Remittance Detail Payer

  @UPARemitDetailPayer
  Scenario Outline: Remittance Detail UI and FISL Validations for Payer User

    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then User clicks on Search Remittance link for UPA
    Then User Enters Search Remittance tin and click on search button for "<userType>".
    And Enter Electronic Payment Number based on "<Search Criteria>"
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
      |byElectronicPaymentNo|	PAY_Admin	 |    PAY     |   Premium    |	byElectronicPaymentNo  |  AO   |