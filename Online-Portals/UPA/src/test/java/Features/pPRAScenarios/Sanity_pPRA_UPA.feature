#Sample Feature Definition Template
@UPApPRASanity @UPASanity
Feature: pPRA Validation for UPA Applicatin with different user groups

  ######################################################################################################################################
  ##################################################################CSR Scenarios#######################################################
  ######################################################################################################################################
  ##UPA Sanity#######
  @CSR_ErrorScenario_Test
  Scenario Outline: Provider Login to CSR Application to validate error scenario for NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<ToDate>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
      | Priority | User     | Tin       | Consol_Pay_Nmbr | DSPL_CONSL_PAY_NBR | NPI        | FromDate   | Type          | Status | searchBy|
      | P1       | PROVPPRA | 020619423 |      1440517391 | 1TR10372035        | 1457468464 | 10/31/2019 | byHCDOPAndNpi | E      | default |

  @UPA_Provider_ErrorScenario
  Scenario Outline: Provider Login to CSR Application to validate error scenario for ConsolPayNumber search
    Given User navigates to UPA portal and enters "<User>" and login
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
      | Priority | User     | Tin       | Consol_Pay_Nmbr | Disp_Consol_Pay_Nmbr | NPI        | Dates      | Type               | Status |
      | P1       | PROVPPRA | 020619423 |      1440517391 | 1TR10372035          | 1457468464 | 10/31/2019 | byHCPayment_Number | E      |

  @UPA_Payer_BS_ErrorScenario
  Scenario Outline: Payer and Billing Service Login to CSR Application to validate error scenario for NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<FromDate>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
      | Priority | User      | Tin       | Consol_Pay_Nmbr | DSPL_CONSL_PAY_NBR | NPI        | FromDate   | Type          | Status |
      | P1       | PayerPPRA | 020619423 |      1440517391 | 1TR10372035        | 1457468464 | 10/31/2019 | byHCDOPAndNpi | E      |

  @UPA_Payer_BS_ErrorScenario
  Scenario Outline: Payer and Billing Service Login to CSR Application to validate error scenario for ConsolPayNumber search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
      | Priority | User      | Tin       | Consol_Pay_Nmbr | Disp_Consol_Pay_Nmbr | NPI        | Dates      | Type               | Status |
      | P1       | PayerPPRA | 020619423 |      1440517391 | 1TR10372035          | 1457468464 | 10/31/2019 | byHCPayment_Number | E      |

  #######Payer and Billing Service PDF does not exist##########
  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf does not exist with Payment number search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

    Examples: 
      | Priority | User      | Tin       | Consol_Pay_Nmbr | Disp_Consol_Pay_Nmbr | Type               | NPI | Dates      | Date_NAS   | FileStatus | Status |
      | P1       | PayerPPRA | 270923713 |      1362310252 |           1362310252 | byHCPayment_Number | N/A | 07/09/2018 | 07.09.2018 | Present    | C      |

  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf does not exist with NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<Dates>" and todate "<Dates>" and click on search button.
    Then User clicks on PDF Link
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

    Examples: 
      | Priority | User      | Tin       | Consol_Pay_Nmbr | Disp_Consol_Pay_Nmbr | Type               | NPI | Dates      | Date_NAS   | FileStatus | Status |
      | P1       | PayerPPRA | 270923713 |      1362310252 |           1362310252 | byHCPayment_Number | N/A | 07/09/2018 | 07.09.2018 | Present    | C      |

  Scenario Outline: Provider-Validation of ppra scenario where PDf does not exist with Payment number search
    Given User navigates to UPA portal and enters "<User>" and login
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

    Examples: 
      | Priority | User     | Tin       | CONSL_PAY_NBR | DSPL_CONSL_PAY_NBR | Type               | NPI | Dates      | Date_NAS   | FileStatus | Status |
      | P1       | PROVPPRA | 270923713 |    1362310252 |         1362310252 | byHCPayment_Number | N/A | 07/09/2018 | 07.09.2018 | Present    | C      |

  Scenario Outline: Provider-Validation of ppra scenario where PDf does not exist with NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<Dates>" and todate "<Dates>" and click on search button.
    Then User clicks on PDF Link
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

    Examples: 
      | Priority | User     | Tin       | CONSL_PAY_NBR | DSPL_CONSL_PAY_NBR | Type          | NPI | Dates      | Date_NAS   |
      | P1       | PROVPPRA | 270923713 |    1362310252 |         1362310252 | byHCDOPAndNpi | N/A | 07/09/2018 | 07.09.2018 |

  #######Payer and Billing Service already exist##########
  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf already exist with Payment number search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date_NAS>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

    Examples: 
      | Priority | User      | Tin       | Consol_Pay_Nmbr | Disp_Consol_Pay_Nmbr | Type               | NPI | Dates      | Date_NAS   | FileStatus | Status |
      | P1       | PayerPPRA | 270923713 |      1362310252 |           1362310252 | byHCPayment_Number | N/A | 07/09/2018 | 07.09.2018 | Present    | C      |

  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf already not exist with NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<Tin>" click on continue button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<Dates>" and todate "<Dates>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

    Examples: 
      | Priority | User      | Tin       | Consol_Pay_Nmbr | Disp_Consol_Pay_Nmbr | Type          | NPI | Dates      | Date_NAS   | FileStatus | Status |
      | P1       | PayerPPRA | 270923713 |      1362310252 |           1362310252 | byHCDOPAndNpi | N/A | 07/09/2018 | 07.09.2018 | Present    | C      |
