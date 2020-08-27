#Author: rashi_hooda@optum.com

@CsrViewPayments @CSRRegression
Feature: CSR View Payments UI Functionality

@CSRViewPayments_TC001
 Scenario Outline: Validate the Failed Payment on CSR
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    Then Set Quick Search Filter for "<paymentType>"  
    Then Verify Failed Payment PopUp

    Examples:
      |    credentials     |   paymentType  	|
      |      Super		     |   failedPayment  |
  
@CSRViewPayments_TC002
  Scenario Outline: Validate the Remit Payment on CSR
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    Then Set Quick Search Filter for "<paymentType>"  
    Then Verify Remit Payment PopUp
       Examples:
      |    credentials     |   paymentType  	|
      |      Super		     |   remitPayment   |
 
 @CSRViewPayments_TC003
 Scenario Outline: CSR View Payments UI Functionality TS006_View Payments_Payments filter_Show All and TS002_View Payments_display of TINs latest payments within the last 30 days and Validate correct payment information is displayed on selection of Show All from the  filter - Filter Payments
     Given User navigates to CSR portal and enters "<credentials>" and login
     When Click on View Payments Link
     Then Select the TIN for "<paymentType>" CSR Portal
     And  Set FISL Parameters "<key>" and "<value>"
     Then Verify Default Search Result Count
     Examples:
        |    credentials  |   paymentType  		     |key									|value|
        |      Super		  |   generalPayment30Days |TAX_IDENTIFIER_TYPE	|ALL	|

@CSRViewPayments_TC004-TC008
  Scenario Outline: Validate correct payment information is displayed on filter Show All
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    And  Set FISL Parameters "<key>" and "<value>"
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" 
    Examples:
      |credentials   |   paymentType  					|	filterpayments	|	quicksearchfilter	| key									|value|
      |Super		     |   generalPayment60Days   |	Show All				|	Last 60 days			|TAX_IDENTIFIER_TYPE	|ALL	|
      |Super		     |   generalPayment90Days   |	Show All				|	Last 90 days			|TAX_IDENTIFIER_TYPE	|ALL	|
      |Super		     |   Last 4-6 months        |	Show All				|	Last 4-6 months		|TAX_IDENTIFIER_TYPE	|ALL	|
      |Super		     |   Last 6-9 months        |	Show All				|	Last 6-9 months		|TAX_IDENTIFIER_TYPE	|ALL	|
      |Super		     |   Last 9-13 months       |	Show All				|	Last 9-13 months	|TAX_IDENTIFIER_TYPE	|ALL	|

  @CSRViewPayments_TC009
  Scenario Outline: Validation of TIN's latest NPI Only payments and Quick Search Filter
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    And  Set FISL Parameters "<key>" and "<value>"
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    
    Examples:
      |    credentials     |   paymentType  			      		|	filterpayments	|	quicksearchfilter	| archivefilter |key									|value|
      |      Super		     | generalPaymentForNPI_30days    |	NPI Only				|	Last 30 days			| Show All      |TAX_IDENTIFIER_TYPE	|NPI	|
      |      Super		     | generalPaymentForNPI_60days    |	NPI Only				|	Last 60 days			| Show All      |TAX_IDENTIFIER_TYPE	|NPI	|
      |      Super		     | generalPaymentForNPI_90days    |	NPI Only				|	Last 90 days			| Show All      |TAX_IDENTIFIER_TYPE	|NPI	|
      |      Super		     | generalPaymentForNPI_4-6months |	NPI Only				|	Last 4-6 months		| Show All      |TAX_IDENTIFIER_TYPE	|NPI	|
      |      Super		     | generalPaymentForNPI_6-9months |	NPI Only				|	Last 6-9 months		| Show All      |TAX_IDENTIFIER_TYPE	|NPI	|
      |      Super		     | generalPaymentForNPI_9-13months|	NPI Only				|	Last 9-13 months	| Show All      |TAX_IDENTIFIER_TYPE	|NPI	|

  Scenario Outline: CSR View Payments UI Functionality Validate correct payment information is displayed on selection of 'TIN Only' from the filter
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    And  Set FISL Parameters "<key>" and "<value>"
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    Examples:
      |    credentials     |   paymentType  			      		|	filterpayments	|	quicksearchfilter	| archivefilter  |key									|value|
      |      Super		     | generalPaymentForTIN_30days    |	TIN Only				|	Last 30 days			|  Show All      |TAX_IDENTIFIER_TYPE	|TIN	|
      |      Super		     | generalPaymentForTIN_60days    |	TIN Only				|	Last 60 days			|  Show All      |TAX_IDENTIFIER_TYPE	|TIN	|
      |      Super		     | generalPaymentForTIN_90days    |	TIN Only				|	Last 90 days			|  Show All      |TAX_IDENTIFIER_TYPE	|TIN	|
      |      Super		     | generalPaymentForTIN_4_6months |	TIN Only				|	Last 4-6 months		|  Show All      |TAX_IDENTIFIER_TYPE	|TIN	|
      |      Super		     | generalPaymentForTIN_6_9months |	TIN Only				|	Last 6-9 months		|  Show All      |TAX_IDENTIFIER_TYPE	|TIN	|
      |      Super		     | generalPaymentForTIN_9_13months|	TIN Only				|	Last 9-13 months	|  Show All      |TAX_IDENTIFIER_TYPE	|TIN	|

  Scenario Outline: CSR View Payments UI Functionality Validate correct payment information is displayed on selection of 'Active Only' from the filter
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    And  Set FISL Parameters "<key>" and "<value>"
    Then Verify Search Results for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"  
    Examples:
      |    credentials     |   paymentType       |	filterpayments	|	quicksearchfilter	| archivefilter   |key															|value|		
      |      Super		     | activeOnly30Days    |	Show All				|	Last 30 days			| Active Only     |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|N		|
      |      Super		     | activeOnly60Days    |	Show All				|	Last 60 days			| Active Only     |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|N		|
      |      Super		     | activeOnly90Days    |	Show All				|	Last 90 days			| Active Only     |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|N		|
      |      Super		     | activeOnly4_6months |	Show All				|	Last 4-6 months		| Active Only     |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|N		|
      |      Super		     | activeOnly6_9months |	Show All				|	Last 6-9 months		| Active Only     |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|N		|
      |      Super		     | activeOnly9_13months|	Show All				|	Last 9-13 months	| Active Only     |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|N		|


  Scenario Outline: CSR View Payments UI Functionality Validate correct payment information is displayed on selection of 'Archived Only' from the filter
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    And  Set FISL Parameters "<key>" and "<value>"
    Then Verify Search Results for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"  
    Examples:
      |    credentials     |   paymentType        	|	filterpayments	|	quicksearchfilter	| archivefilter |key															|value|
      |      Super		     | archiveOnly30Days    	|	Show All				|	Last 30 days			| Archived Only |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|Y		|
      |      Super		     | archiveOnly60Days    	|	Show All				|	Last 60 days			| Archived Only |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|Y		|
      |      Super		     | archiveOnly90Days    	|	Show All				|	Last 90 days			| Archived Only |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|Y		|
      |      Super		     | archiveOnly4_6months 	|	Show All				|	Last 4-6 months		| Archived Only |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|Y		|
      |      Super		     | archiveOnly6_9months 	|	Show All				|	Last 6-9 months		| Archived Only |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|Y		|
      |      Super		     | archiveOnly9_13months	|	Show All				|	Last 9-13 months	| Archived Only |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|Y		|

  Scenario Outline: CSR View Payments UI Functionality Validate Payment date sorting for both ascending and descending
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    Then Validate "<paymentType>" , "<quickSearchFilter>" , "<archiveFilter>" Payment date sorting for both ascending and descending
    Examples:
      |    credentials     |   paymentType       |	quickSearchFilter	|  archiveFilter   |
      |      Super		     | generalPayment      |	Last 60 days      |   Show All       |

  Scenario Outline: CSR View Payments UI Functionality Validate TS014_View Payments_Zero Dollar ACH or VCP Payments
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymenttype>" CSR Portal
    And Set FISL Parameters "<key>" and "<value>"
    Then Verify Zero Dollar Payments for "<paymenttype>"
    Examples:
      |    credentials     |   paymenttype  |key									|value|
      |      Super		     |      ACH       |TAX_IDENTIFIER_TYPE	|ALL	|
      |      Super		     |      VCP       |TAX_IDENTIFIER_TYPE	|ALL	|

  Scenario Outline: CSR View Payments UI Functionality Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<paymentType>" CSR Portal
    And Set FISL Parameters "<key>" and "<value>"
    Then Verify Mkt Type for "<mktTypeFilter>"
    Examples:
      |    credentials     |   paymentType      |   mktTypeFilter   |
      |      Super		     |   medicalFilter    |   Medical         |

  Scenario Outline: CSR View Payments UI Functionality Validate that correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type
    Given User navigates to CSR portal and enters "<credentials>" and login
    When Click on View Payments Link
    Then Select the TIN for "<quickSearchFilter>" CSR Portal
    Then Validate "<quickSearchFilter>" , "<filterPayments>" that correct payment information is displayed on selection of Market type-Medical from the  filter
    Examples:
      |    credentials       |   quickSearchFilter      |   filterPayments   |
      |      Super		     |   Last 9-13 months       |   Show All         |
