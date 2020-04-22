#Author: prashant_chaudahry@optum.com
@UPApPRARegression @UPARegression
Feature: UPA PPRA Scenarios 

  @UPA_Provider_ErrorScenario
  Scenario Outline: Provider Login to CSR Application to validate error scenario for NPI search
 		Given User navigates to UPA portal and enters "<User>" and login
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<ToDate>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
     |	Priority	|	User					|	Tin				|Consol_Pay_Nmbr|	DSPL_CONSL_PAY_NBR	|	NPI				|	FromDate		|	Type				  |Status	|
		 |	P1				|	ProviderPPRA	|	020619423	|	1440517391	|	1TR10372035					|	1457468464	|	10/31/2019	|	byHCDOPAndNpi	|E			|
		 |	P1				|	ProviderPPRA	|	480905931	|	1439039532	|	1SG05438158					|	1659356442	|	06/24/2019	|	byHCDOPAndNpi	|E			|
		 |	P2				|	ProviderPPRA	|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCDOPAndNpi	|E			|
		 |	P2				|	ProviderPPRA	|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCDOPAndNpi	|E			|
		 |	P3				|	ProviderPPRA	|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCDOPAndNpi	|E			|
		 |	P3				|	ProviderPPRA	|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCDOPAndNpi	|E			|
     

  @UPA_Provider_ErrorScenario
  Scenario Outline: Provider Login to CSR Application to validate error scenario for ConsolPayNumber search
    Given User navigates to UPA portal and enters "<User>" and login
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

    Examples: 
     |	Priority	|	User			|	Tin				|Consol_Pay_Nmbr|	Disp_Consol_Pay_Nmbr	|	NPI					|	Dates				|	Type						|Status|
		 |	P1				|	ProviderPPRA	|	020619423	|	1440517391	|	1TR10372035					|	1457468464	|	10/31/2019	|	byHCPayment_Number	|E		 |
		 |	P1				|	ProviderPPRA	|	480905931	|	1439039532	|	1SG05438158					|	1659356442	|	06/24/2019	|	byHCPayment_Number	|E		 |
		 |	P2				|	ProviderPPRA	|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCPayment_Number	|E		 |
		 |	P2				|	ProviderPPRA	|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCPayment_Number	|E		 |
		 |	P3				|	ProviderPPRA	|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCPayment_Number	|E		 |
		 |	P3				|	ProviderPPRA	|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCPayment_Number	|E		 |

  @UPA_Payer_BS_ErrorScenario
  Scenario Outline: Payer and Billing Service Login to CSR Application to validate error scenario for NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<FromDate>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

  Examples: 
     |	Priority	|	User			|	Tin				|Consol_Pay_Nmbr|	DSPL_CONSL_PAY_NBR	|	NPI					|	FromDate				|	Type				| Status |
		 |	P1				|	PayerPPRA			|	020619423	|	1440517391	|	1TR10372035					|	1457468464	|	10/31/2019	|	byHCDOPAndNpi	|E			 |
		 |	P1				|	PayerPPRA			|	480905931	|	1439039532	|	1SG05438158					|	1659356442	|	06/24/2019	|	byHCDOPAndNpi	|E			 |
		 |	P2				|	PayerPPRA			|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCDOPAndNpi	|E			 |
		 |	P2				|	PayerPPRA			|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCDOPAndNpi	|E			 |
		 |	P3				|	PayerPPRA			|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCDOPAndNpi	|E			 |
		 |	P3				|	PayerPPRA			|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCDOPAndNpi	|E			 |
		 |	P1				|	BSPPRA			|	020619423	|	1440517391	|	1TR10372035					|	1457468464	|	10/31/2019	|	byHCDOPAndNpi	|E       |
		 |	P1				|	BSPPRA				|	480905931	|	1439039532	|	1SG05438158					|	1659356442	|	06/24/2019	|	byHCDOPAndNpi	|E			 |
		 |	P2				|	BSPPRA				|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCDOPAndNpi	|E			 |
		 |	P2				|	BSPPRA				|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCDOPAndNpi	|E			 |
		 |	P3				|	BSPPRA				|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCDOPAndNpi	|E			 |
		 |	P3				|	BSPPRA				|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCDOPAndNpi	|E			 |

  @UPA_Payer_BS_ErrorScenario
  Scenario Outline: Payer and Billing Service Login to CSR Application to validate error scenario for ConsolPayNumber search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User selects "<Type>" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table

   Examples: 
     |	Priority	|	User					|	Tin				|Consol_Pay_Nmbr|	Disp_Consol_Pay_Nmbr	|	NPI					|	Dates				|	Type						| Status |
		 |	P1				|	PayerPPRA		|	020619423	|	1440517391	|	1TR10372035					|	1457468464	|	10/31/2019	|	byHCPayment_Number	|E			 |
		 |	P1				|	PayerPPRA		|	480905931	|	1439039532	|	1SG05438158					|	1659356442	|	06/24/2019	|	byHCPayment_Number	|E			 |
		 |	P2				|	PayerPPRA		|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCPayment_Number	|E			 |
		 |	P2				|	PayerPPRA		|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCPayment_Number	|E			 |
		 |	P3				|	PayerPPRA		|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCPayment_Number	|E			 |
		 |	P3				|	PayerPPRA		|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCPayment_Number	|E       |
		 |	P1				|	BSPPRA				|	020619423	|	1440517391	|	1TR10372035					|	1457468464	|	10/31/2019	|	byHCPayment_Number	|E			 |
		 |	P1				|	BSPPRA				|	480905931	|	1439039532	|	1SG05438158					|	1659356442	|	06/24/2019	|	byHCPayment_Number	|E			 |
		 |	P2				|	BSPPRA				|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCPayment_Number	|E			 |
		 |	P2				|	BSPPRA				|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCPayment_Number	|E			 |
		 |	P3				|	BSPPRA				|	391678306	|	1440564451	|	1TR10401483					|	1427271378	|	01/17/2020	|	byHCPayment_Number	|E			 |
		 |	P3				|	BSPPRA				|	941156581	|	1438792076	|	1SG05325263					|	1013950807	|	05/29/2019	|	byHCPayment_Number	|E				|

  #######Payer and Billing Service PDF does not exist##########
  
  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf does not exist with Payment number search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User selects "Type" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    #Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

   Examples: 
  |	Priority	|	User				|	Tin				|Consol_Pay_Nmbr|	Disp_Consol_Pay_Nmbr|	Type								|	NPI					|	Dates				|	Date_NAS		| FileStatus|Status|
	|	P1				|	PayerPPRA	|	270923713	|	1362310252	|	1362310252							|	byHCPayment_Number	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	PayerPPRA	|	571004971	|	1439046523	|	1SG05444672							|	byHCPayment_Number	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	311369596	|	1413435888	|	1413435888							|	byHCPayment_Number	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	752536818	|	1439047278	|	1SG05444624							|	byHCPayment_Number	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	PayerPPRA	|	043228346	|	1408098556	|	1408098556							|	byHCPayment_Number	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|
	|	P1				|	BSPPRA			|	270923713	|	1362310252	|	1362310252						|	byHCPayment_Number	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	BSPPRA			|	571004971	|	1439046523	|	1SG05444672						|	byHCPayment_Number	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	BSPPRA			|	311369596	|	1413435888	|	1413435888						|	byHCPayment_Number	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	BSPPRA			|	752536818	|	1439047278	|	1SG05444624						|	byHCPayment_Number	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	BSPPRA			|	043228346	|	1408098556	|	1408098556						|	byHCPayment_Number	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|


  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf does not exist with NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<Dates>" and todate "<Dates>" and click on search button.
    Then User clicks on PDF Link
    #Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

 Examples: 
 |	Priority	|	User				|	Tin				|Consol_Pay_Nmbr|	Disp_Consol_Pay_Nmbr|	Type								|	NPI					|	Dates				|	Date_NAS		| FileStatus|Status|
	|	P1				|	PayerPPRA	|	270923713	|	1362310252	|	1362310252							|	byHCPayment_Number	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	PayerPPRA	|	571004971	|	1439046523	|	1SG05444672							|	byHCPayment_Number	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	311369596	|	1413435888	|	1413435888							|	byHCPayment_Number	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	752536818	|	1439047278	|	1SG05444624							|	byHCPayment_Number	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	PayerPPRA	|	043228346	|	1408098556	|	1408098556							|	byHCPayment_Number	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|
	|	P1				|	BSPPRA			|	270923713	|	1362310252	|	1362310252						|	byHCPayment_Number	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	BSPPRA			|	571004971	|	1439046523	|	1SG05444672						|	byHCPayment_Number	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	BSPPRA			|	311369596	|	1413435888	|	1413435888						|	byHCPayment_Number	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	BSPPRA			|	752536818	|	1439047278	|	1SG05444624						|	byHCPayment_Number	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	BSPPRA			|	043228346	|	1408098556	|	1408098556						|	byHCPayment_Number	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|


 

  Scenario Outline: Provider-Validation of ppra scenario where PDf does not exist with Payment number search
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "Type" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User clicks on PDF Link
    #Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

    Examples: 
     |Priority|	User					|	Tin				|CONSL_PAY_NBR|	DSPL_CONSL_PAY_NBR	|	Type								|	NPI					|	Dates				|	Date_NAS		| FileStatus| Status |
		 |	P1		|	ProviderPPRA	|	270923713	|	1362310252	|	1362310252					|	byHCPayment_Number	|	N/A					|	07/09/2018	|	07.09.2018	|Present		| C			|
		 |	P1		|	ProviderPPRA	|	571004971	|	1439046523	|	1SG05444672					|	byHCPayment_Number	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|	C			|
		 |	P2		|	ProviderPPRA	|	311369596	|	1413435888	|	1413435888					|	byHCPayment_Number	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|	C			|
		 |	P2		|	ProviderPPRA	|	752536818	|	1439047278	|	1SG05444624					|	byHCPayment_Number	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|	C			|
		 |	P3		|	ProviderPPRA	|	043228346	|	1408098556	|	1408098556					|	byHCPayment_Number	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|	C			|

  Scenario Outline: Provider-Validation of ppra scenario where PDf does not exist with NPI search
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<Dates>" and todate "<Dates>" and click on search button.
    Then User clicks on PDF Link
    #Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    Then Validate PDF file placed over NAS Drive for date "<Date_NAS>"

      Examples: 
     |Priority|	User					|	Tin				|CONSL_PAY_NBR|	DSPL_CONSL_PAY_NBR	|	Type					|	NPI					|	Dates				|	Date_NAS		|
		 |	P1		|	ProviderPPRA	|	270923713	|	1362310252	|	1362310252					|	byHCDOPAndNpi	|	N/A					|	07/09/2018	|	07.09.2018	|
		 |	P1		|	ProviderPPRA	|	571004971	|	1439046523	|	1SG05444672					|	byHCDOPAndNpi	|	1083787006	|	06/24/2019	|	06.24.2019	|
		 |	P2		|	ProviderPPRA	|	311369596	|	1413435888	|	1413435888					|	byHCDOPAndNpi	|	1740231448	|	02/22/2019	|	02.22.2019	|
		 |	P2		|	ProviderPPRA	|	752536818	|	1439047278	|	1SG05444624					|	byHCDOPAndNpi	|	1760488936	|	06/24/2019	|	06.24.2019	|
		 |	P3		|	ProviderPPRA	|	043228346	|	1408098556	|	1408098556					|	byHCDOPAndNpi	|	1912987181	|	01/31/2019	|	01.31.2019	|

  #######Payer and Billing Service already exist exist##########
  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf already exist with Payment number search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User selects "Type" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date_NAS>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

 |	Priority	|	User	|	Tin				|Consol_Pay_Nmbr|	Disp_Consol_Pay_Nmbr|	Type								|	NPI					|	Dates				|	Date_NAS	| FileStatus|Status|
	|	P1				|	PayerPPRA	|	270923713	|	1362310252	|	1362310252					|	byHCPayment_Number	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	PayerPPRA	|	571004971	|	1439046523	|	1SG05444672					|	byHCPayment_Number	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	311369596	|	1413435888	|	1413435888					|	byHCPayment_Number	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	752536818	|	1439047278	|	1SG05444624					|	byHCPayment_Number	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	PayerPPRA	|	043228346	|	1408098556	|	1408098556					|	byHCPayment_Number	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|
	|	P1				|	BSPPRA		|	270923713	|	1362310252	|	1362310252					|	byHCPayment_Number	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	BSPPRA		|	571004971	|	1439046523	|	1SG05444672					|	byHCPayment_Number	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	BSPPRA		|	311369596	|	1413435888	|	1413435888					|	byHCPayment_Number	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	BSPPRA		|	752536818	|	1439047278	|	1SG05444624					|	byHCPayment_Number	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	BSPPRA		|	043228346	|	1408098556	|	1408098556					|	byHCPayment_Number	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|

  Scenario Outline: Payer and Billing Service-Validation of ppra scenario where PDf already not exist with NPI search
    Given User navigates to UPA portal and enters "<User>" and login
    Then User clicks on Search Remittance link for UPA
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<Dates>" and todate "<Dates>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

   
  |	Priority	|	User	|	Tin				|Consol_Pay_Nmbr|	Disp_Consol_Pay_Nmbr|	Type				|	NPI					|	Dates				|	Date_NAS		| FileStatus|Status|
	|	P1				|	PayerPPRA	|	270923713	|	1362310252	|	1362310252					|	byHCDOPAndNpi	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	PayerPPRA	|	571004971	|	1439046523	|	1SG05444672					|	byHCDOPAndNpi	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	311369596	|	1413435888	|	1413435888					|	byHCDOPAndNpi	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	PayerPPRA	|	752536818	|	1439047278	|	1SG05444624					|	byHCDOPAndNpi	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	PayerPPRA	|	043228346	|	1408098556	|	1408098556					|	byHCDOPAndNpi	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|
	|	P1				|	BSPPRA		|	270923713	|	1362310252	|	1362310252					|	byHCDOPAndNpi	|	N/A					|	07/09/2018	|	07.09.2018	|Present		|C			|
	|	P1				|	BSPPRA		|	571004971	|	1439046523	|	1SG05444672					|	byHCDOPAndNpi	|	1083787006	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P2				|	BSPPRA		|	311369596	|	1413435888	|	1413435888					|	byHCDOPAndNpi	|	1740231448	|	02/22/2019	|	02.22.2019	|Present		|C			|
	|	P2				|	BSPPRA		|	752536818	|	1439047278	|	1SG05444624					|	byHCDOPAndNpi	|	1760488936	|	06/24/2019	|	06.24.2019	|Present		|C			|
	|	P3				|	BSPPRA		|	043228346	|	1408098556	|	1408098556					|	byHCDOPAndNpi	|	1912987181	|	01/31/2019	|	01.31.2019	|Present		|C			|

  Scenario Outline: Provider Login to CSR Application to validate error scenario for Consol Pay number search
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "Type" with value "<Disp_Consol_Pay_Nmbr>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

    Examples: 
      | User  | priority | searchBy  |
      | PAYER |        1 | 270923713 |

  Scenario Outline: Provider Login to CSR Application to validate error scenario for NPI search
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
    Then User clicks on Search Remittance link for UPA
    Then User selects "<Type>" for Consol_Pay_Nmbr "<Consol_Pay_Nmbr>" with NPI value as "<NPI>" with fromdate "<FromDate>" and todate "<ToDate>" and click on search button.
    Then User validates pPRA file is "<FileStatus>"
    Then User Validates Ole.PPRA_STATUS status for Consol_Pay_Nbr "<Consol_Pay_Nmbr>" should be "<Status>"
    When Validate PDF file placed over NAS Drive for date "<Date>"
    Then User Deletes paymentdetail record "<Consol_Pay_Nmbr>" from ole.ppra_status_dtl and ole.ppra_status table
    Then User Delete PDf file placed over NAS drive  for date "<Date_NAS>"

    Examples: 
      | User  | priority | searchBy  |
      | PAYER |        1 | 270923713 |
