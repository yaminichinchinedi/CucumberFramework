#Sample Feature Definition Template
@CSRpPRASanity @CSRSanity
Feature: pPRA Validation for CSR Applicatin with different user groups

  ######################################################################################################################################
  ##################################################################CSR Scenarios#######################################################
  ######################################################################################################################################
  #@CSR_ErrorScenario_NPISearch, CSR_ErrorScenario_ConsolPayNumberSearch
  @CSR_ErrorScenario
  Scenario Outline: Login to CSR Application to validate error scenario for NPI search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Disp_Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<ToDate>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
      | Priority | User  | Tin       | Type          | Consol_Pay_Nmbr | NPI        | FromDate   | ToDate     | Status | Disp_Consol_Pay_Nmbr |
      | P1       | Super | 320474882 | byHCDOPAndNpi |      1440517535 | 1578933396 | 10/31/2019 | 10/31/2019 | E      | 1TR10374493          |

  @CSR_ErrorScenario
  Scenario Outline: Login to CSR Application to validate error scenario for ConsolPayNumber
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
      | Priority | User  | Tin       | Type               | Disp_Consol_Pay_Nmbr | Consol_Pay_Nmbr | Status |
      | P1       | Super | 320474882 | byHCPayment_Number | 1TR10374493          |      1440517535 | E      |

  @CSR_PDFDoesnotExist_ConsolPayNumber
  Scenario Outline: Validation of ppra scenario where PDf does not exist with Payment number search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

    Examples: 
      | Priority | User  | Tin       | Type               | Disp_Consol_Pay_Nmbr | Consol_Pay_Nmbr | FileStatus | Status | Date_NAS   | NPI | Date       |
      | P1       | Super | 541494969 | byHCPayment_Number |           1357393681 |      1357393681 | Present    | C      | 06.14.2018 |     | 06/14/2018 |

  @CSR_PDFAlreadyExist_ConsolPayNumber
  Scenario Outline: Validation of ppra scenario where PDf Already exist with Payment number search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" with value "<Consol_Pay_Nmbr>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

    Examples: 
      | Priority | User  | Tin       | Type               | Disp_Consol_Pay_Nmbr | Consol_Pay_Nmbr | FileStatus | Status | Date_NAS   | NPI | Date       |
      | P1       | Super | 541494969 | byHCPayment_Number |           1357393681 |      1357393681 | Present    | C      | 06.14.2018 |     | 06/14/2018 |

  @CSR_PDFDoesnotExist_ConsolPayNumber
  Scenario Outline: Validation of ppra scenario where PDf does not exist with NPI search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" with value "<Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

    Examples: 
      | Priority | User  | Tin       | Type          | Disp_Consol_Pay_Nmbr | Consol_Pay_Nmbr | FileStatus | Status | Date_NAS   | NPI | Date       |
      | P1       | Super | 541494969 | byHCDOPAndNpi |           1357393681 |      1357393681 | Present    | C      | 06.14.2018 |     | 06/14/2018 |

  @CSR_PDFAlreadyExist_NPI
  Scenario Outline: Validation of ppra scenario where PDf Already exist with NPI search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<FromDate>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date_NAS>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

    Examples: 
      | Priority | User  | Tin       | Type          | Disp_Consol_Pay_Nmbr | Consol_Pay_Nmbr | FileStatus | Status | Date_NAS   | NPI | FromDate   |
      | P1       | Super | 541494969 | byHCDOPAndNpi |           1357393681 |      1357393681 | Present    | C      | 06.14.2018 |     | 06/14/2018 |

