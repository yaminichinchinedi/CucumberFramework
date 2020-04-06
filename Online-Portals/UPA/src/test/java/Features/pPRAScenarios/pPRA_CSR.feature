#Sample Feature Definition Template
@CSRpPRA @CSRRegression_
Feature: nPRA Validation with different user groups


  ######################################################################################################################################
  ##################################################################CSR Scenarios#######################################################
  ######################################################################################################################################
  
  @CSR_ErrorScenario_NPISearch_Add
  Scenario Outline: Login to CSR Application to validate error scenario for NPI search is
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"

  @CSR_ErrorScenario_NPISearch
  Scenario Outline: Login to CSR Application to validate error scenario for NPI search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<ToDate>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    
    Examples: 
      | Priority | User  | Tin       | Type          | Consol_Pay_Nmbr | NPI        | FromDate   | ToDate     | Status |
      | P1       | Super | 320474882 | byHCDOPAndNpi |      1440517535 | 1578933396 | 10/31/2019 | 10/31/2019 | E      |
      | P1       | Super | 480905931 | byHCDOPAndNpi |      1439039532 | 1659356442 | 06/24/2019 | 06/24/2019 | E      |
      | P2       | Super | 391678306 | byHCDOPAndNpi |      1440564451 | 1427271378 | 01/17/2020 | 01/17/2020 | E      |
      | P2       | Super | 941156581 | byHCDOPAndNpi |      1438792076 | 1013950807 | 05/29/2019 | 05/29/2019 | E      |
      | P1       | RW    | 320474882 | byHCDOPAndNpi |      1440517535 | 1578933396 | 10/31/2019 | 10/31/2019 | E      |
      | P1       | RW    | 480905931 | byHCDOPAndNpi |      1439039532 | 1659356442 | 06/24/2019 | 06/24/2019 | E      |
      | P2       | RW    | 391678306 | byHCDOPAndNpi |      1440564451 | 1427271378 | 01/17/2020 | 01/17/2020 | E      |
      | P2       | RW    | 941156581 | byHCDOPAndNpi |      1438792076 | 1013950807 | 05/29/2019 | 05/29/2019 | E      |
      | P1       | ROPPRA    | 320474882 | byHCDOPAndNpi |      1440517535 | 1578933396 | 10/31/2019 | 10/31/2019 | E      |
      | P1       | ROPPRA    | 480905931 | byHCDOPAndNpi |      1439039532 | 1659356442 | 06/24/2019 | 06/24/2019 | E      |
      | P2       | ROPPRA    | 391678306 | byHCDOPAndNpi |      1440564451 | 1427271378 | 01/17/2020 | 01/17/2020 | E      |
      | P2       | ROPPRA    | 941156581 | byHCDOPAndNpi |      1438792076 | 1013950807 | 05/29/2019 | 05/29/2019 | E      |
      | P3       | Super | 391678306 | byHCDOPAndNpi |      1440564451 | 1427271378 | 01/17/2020 | 01/17/2020 | E      |
      | P3       | Super | 941156581 | byHCDOPAndNpi |      1438792076 | 1013950807 | 05/29/2019 | 05/29/2019 | E      |
      | P3       | RW    | 391678306 | byHCDOPAndNpi |      1440564451 | 1427271378 | 01/17/2020 | 01/17/2020 | E      |
      | P3       | RW    | 941156581 | byHCDOPAndNpi |      1438792076 | 1013950807 | 05/29/2019 | 05/29/2019 | E      |
      | P3       | ROPPRA    | 391678306 | byHCDOPAndNpi |      1440564451 | 1427271378 | 01/17/2020 | 01/17/2020 | E      |
      | P3       | ROPPRA    | 941156581 | byHCDOPAndNpi |      1438792076 | 1013950807 | 05/29/2019 | 05/29/2019 | E      |
      
  @CSR_ErrorScenario_ConsolPayNumberSearch1
  Scenario Outline: Login to CSR Application to validate error scenario for ConsolPayNumber
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    #Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    #Then User clicks on PDF Link
    #Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    #Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
      | Priority | User  | Tin       | Type               | Disp_Consol_Pay_Nmbr | Consol_Pay_Nmbr | Status |
      | P1       | Super | 320474882 | byHCPayment_Number | 1TR10374493          |      1440517535 | E      |

  @CSR_ErrorScenario_ConsolPayNumberSearch
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
      | P1       | Super | 480905931 | byHCPayment_Number | 1SG05438158          |      1439039532 | E      |
      | P2       | Super | 391678306 | byHCPayment_Number | 1TR10401483          |      1440564451 | E      |
      | P2       | Super | 941156581 | byHCPayment_Number | 1SG05325263          |      1438792076 | E      |
      | P1       | RW    | 320474882 | byHCPayment_Number | 1TR10374493          |      1440517535 | E      |
      | P1       | RW    | 480905931 | byHCPayment_Number | 1SG05438158          |      1439039532 | E      |
      | P2       | RW    | 391678306 | byHCPayment_Number | 1TR10401483          |      1440564451 | E      |
      | P2       | RW    | 941156581 | byHCPayment_Number | 1SG05325263          |      1438792076 | E      |
      | P1       | ROPPRA    | 320474882 | byHCPayment_Number | 1TR10374493          |      1440517535 | E      |
      | P1       | ROPPRA    | 480905931 | byHCPayment_Number | 1SG05438158          |      1439039532 | E      |
      | P2       | ROPPRA    | 391678306 | byHCPayment_Number | 1TR10401483          |      1440564451 | E      |
      | P2       | ROPPRA    | 941156581 | byHCPayment_Number | 1SG05325263          |      1438792076 | E      |
      | P3       | Super | 391678306 | byHCPayment_Number | 1TR10401483          |      1440564451 | E      |
      | P3       | Super | 941156581 | byHCPayment_Number | 1SG05325263          |      1438792076 | E      |
      | P3       | RW    | 391678306 | byHCPayment_Number | 1TR10401483          |      1440564451 | E      |
      | P3       | RW    | 941156581 | byHCPayment_Number | 1SG05325263          |      1438792076 | E      |
      | P3       | ROPPRA    | 391678306 | byHCPayment_Number | 1TR10401483          |      1440564451 | E      |
      | P3       | ROPPRA    | 941156581 | byHCPayment_Number | 1SG05325263          |      1438792076 | E      |

  @CSR_PDFDoesnotExist_ConsolPayNumber
  Scenario Outline: Validation of ppra scenario where PDf does not exist with Payment number search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "Type" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

   Examples: 
      |Priority | User  | Tin       | Type               | Disp_Consol_Pay_Nmbr |Consol_Pay_Nmbr 	|FileStatus | Status | Date       |	NPI 					| Date_NAS 	|
      |P1       | Super | 541494969 | byHCPayment_Number |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | Super | 571004971 | byHCPayment_Number |      1SG05444672 		| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | Super | 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | Super | 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					 
			|P1       | ROPPRA 		| 541494969 | byHCPayment_Number |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | ROPPRA 		| 571004971 | byHCPayment_Number |      1SG05444672 		| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | ROPPRA 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | ROPPRA 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |	
      |P1       | RW 		| 541494969 | byHCPayment_Number |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | RW 		| 571004971 | byHCPayment_Number |      1SG05444672 		| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | RW 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | RW 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | Super | 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | Super | 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | ROPPRA 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | ROPPRA 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |	
      |P3       | RW 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | RW 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					  
      
  
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
      |Priority | User  | Tin       | Type               | Disp_Consol_Pay_Nmbr |Consol_Pay_Nmbr 	|FileStatus | Status | Date       |	NPI 					| Date_NAS 	|
      |P1       | Super | 541494969 | byHCPayment_Number |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | Super | 571004971 | byHCPayment_Number |      1SG05444672 		| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | Super | 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | Super | 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					 
			|P1       | ROPPRA 		| 541494969 | byHCPayment_Number |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | ROPPRA 		| 571004971 | byHCPayment_Number |      1SG05444672 		| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | ROPPRA 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | ROPPRA 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |	
      |P1       | RW 		| 541494969 | byHCPayment_Number |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | RW 		| 571004971 | byHCPayment_Number |      1SG05444672 		| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | RW 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | RW 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | Super | 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | Super | 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | ROPPRA 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | ROPPRA 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |	
      |P3       | RW 		| 560963485 | byHCPayment_Number |      1411761291	 		| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | RW 		| 410797853 | byHCPayment_Number |      1SG05439988 		| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |							  
      
      
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
      |Priority | User  | Tin       | Type          | Disp_Consol_Pay_Nmbr  |Consol_Pay_Nmbr 	|FileStatus | Status | Date       |	NPI 					| Date_NAS 	|
      |P1       | Super | 541494969 | byHCDOPAndNpi |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | Super | 571004971 | byHCDOPAndNpi |      1SG05444672 			| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | Super | 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | Super | 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					 
			|P1       | ROPPRA 		| 541494969 | byHCDOPAndNpi |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | ROPPRA 		| 571004971 | byHCDOPAndNpi |      1SG05444672 			| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | ROPPRA 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | ROPPRA 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					
      |P1       | RW 		| 541494969 | byHCDOPAndNpi |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | RW 		| 571004971 | byHCDOPAndNpi |      1SG05444672 			| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | RW 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | RW 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | Super | 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | Super | 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | ROPPRA 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | ROPPRA 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					
      |P3       | RW 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | RW 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					  
      

  @CSR_PDFAlreadyExist_NPI
  Scenario Outline: Validation of ppra scenario where PDf Already exist with NPI search
    Given User navigates to CSR portal and enters "<User>" and login
    Then User clicks on Search Remittance link
    Then Enter Tin "<Tin>" and select serach button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<ToDate>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"
    
    Examples: 
      |Priority | User  | Tin       | Type          | Disp_Consol_Pay_Nmbr  |Consol_Pay_Nmbr 	|FileStatus | Status | Date       |	NPI 					| Date_NAS 	|
      |P1       | Super | 541494969 | byHCDOPAndNpi |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | Super | 571004971 | byHCDOPAndNpi |      1SG05444672 			| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | Super | 560963485 | byHCDOPAndNpi |      1411761291	 		  | 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | Super | 410797853 | byHCDOPAndNpi |      1SG05439988 		  | 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					 
			|P1       | ROPPRA 		| 541494969 | byHCDOPAndNpi |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | ROPPRA 		| 571004971 | byHCDOPAndNpi |      1SG05444672 			| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | ROPPRA 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | ROPPRA 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |	
      |P1       | RW 		| 541494969 | byHCDOPAndNpi |      1357393681 			|	1357393681			|Present    | C      | 06.14.2018 |								|06/14/2018 |
      |P1       | RW 		| 571004971 | byHCDOPAndNpi |      1SG05444672 			| 1439046523			|Present    | C      | 06.24.2019 |	1083787006		|06/24/2019 |
      |P2       | RW 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P2       | RW 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | Super | 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | Super | 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |
      |P3       | ROPPRA 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | ROPPRA 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |	
      |P3       | RW 		| 560963485 | byHCDOPAndNpi |      1411761291	 			| 1411761291			|Present    | C      | 06.24.2019 |	1154384568		|02/15/2019	|
      |P3       | RW 		| 410797853 | byHCDOPAndNpi |      1SG05439988 			| 1439039989			|Present    | C      | 06.24.2019 |	1215048913		|06/24/2019 |					  
      

 
  
 