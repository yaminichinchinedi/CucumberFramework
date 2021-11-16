#Author: Megha Anand
@UPA_PROV_ViewPayments
Feature: View Payments Provider Admin

  #TF41850
  #TC002
  @UPA_PROV_ViewPayments_TC002 
  Scenario Outline: Validation of TIN's latest payments
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<timeperiod>"
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Default Search Result Count

    Examples: 
      #|	credentials	|	usertype	|	timeperiod						|	key  								|	value	|
      #|	PROV_Admin  |	PROV			| generalPayment30Days	|	TAX_IDENTIFIER_TYPE |	ALL		|
      | credentials | userType | searchCriteria       | portalAccess | tinType | key                 | value |
      | PROV_Admin  | PROV     | generalPayment30Days | Premium      | AO      | TAX_IDENTIFIER_TYPE | ALL   |

  @UPA_PROV_ViewPayments_TC006-TC011   
  Scenario Outline: Validation of TIN's latest payments and Quick Search Filter
    Given User navigates to UPA portal and enters "<credentials>" and login
    #   Then Select the TIN for UPA Portal for "<timeperiod>"
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>"

    Examples: 
      #| credentials | usertype | timeperiod       | quicksearchfilter | filterpayments | key                 | value |
      #| PROV_Admin  | PROV     | Last 9-13 months | Last 9-13 months  | Show All       | TAX_IDENTIFIER_TYPE | ALL   |
     
      | credentials | userType | searchCriteria   | portalAccess | tinType | quicksearchfilter | filterpayments | key                 | value |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Last 9-13 months  | Show All       | TAX_IDENTIFIER_TYPE | ALL   |

  @UPA_PROV_ViewPayments_TC005 
  Scenario Outline: Validation of TIN's latest NPI Only payments and Quick Search Filter
    Given User navigates to UPA portal and enters "<credentials>" and login
   # Then Select the TIN for UPA Portal for "<timeperiod>"
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"

    Examples: 
      #| credentials | usertype | timeperiod                      | quicksearchfilter | filterpayments | archivefilter | key                 | value |
      #| PROV_Admin  | PROV     | generalPaymentForNPI_30days     | Last 30 days      | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |
      #| PROV_Admin  | PROV     | generalPaymentForNPI_60days     | Last 60 days      | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |
      #| PROV_Admin  | PROV     | generalPaymentForNPI_90days     | Last 90 days      | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |
      #| PROV_Admin  | PROV     | generalPaymentForNPI_4-6months  | Last 4-6 months   | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |
      #| PROV_Admin  | PROV     | generalPaymentForNPI_6-9months  | Last 6-9 months   | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |
      #| PROV_Admin  | PROV     | generalPaymentForNPI_9-13months | Last 9-13 months  | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |
      
      
      | credentials | userType | searchCriteria                  | quicksearchfilter | filterpayments | archivefilter | key                 | value | tinType |portalAccess|
      | PROV_Admin  | PROV     | generalPaymentForNPI_30days     | Last 30 days      | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForNPI_60days     | Last 60 days      | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForNPI_90days     | Last 90 days      | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForNPI_4-6months  | Last 4-6 months   | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForNPI_6-9months  | Last 6-9 months   | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForNPI_9-13months | Last 9-13 months  | NPI Only       | Show All      | TAX_IDENTIFIER_TYPE | NPI   |AO|Premium|

  @UPA_PROV_ViewPayments_TC004
  Scenario Outline: Validation of TIN's latest TIN Only payments and Quick Search Filter
    Given User navigates to UPA portal and enters "<credentials>" and login
    #Then Select the TIN for UPA Portal for "<timeperiod>"
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"

    Examples: 
      #| credentials | usertype | timeperiod                      | quicksearchfilter | filterpayments | archivefilter | key                 | value |
      #| PROV_Admin  | PROV     | generalPaymentForTIN_30days     | Last 30 days      | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |
      #| PROV_Admin  | PROV     | generalPaymentForTIN_60days     | Last 60 days      | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |
      #| PROV_Admin  | PROV     | generalPaymentForTIN_90days     | Last 90 days      | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |
      #| PROV_Admin  | PROV     | generalPaymentForTIN_4_6months  | Last 4-6 months   | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |
      #| PROV_Admin  | PROV     | generalPaymentForTIN_6_9months  | Last 6-9 months   | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |
      #| PROV_Admin  | PROV     | generalPaymentForTIN_9_13months | Last 9-13 months  | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |


      | credentials | userType | searchCriteria                  | quicksearchfilter | filterpayments | archivefilter | key                 | value |tinType |portalAccess|
      | PROV_Admin  | PROV     | generalPaymentForTIN_30days     | Last 30 days      | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForTIN_60days     | Last 60 days      | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForTIN_90days     | Last 90 days      | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForTIN_4_6months  | Last 4-6 months   | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForTIN_6_9months  | Last 6-9 months   | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |AO|Premium|
      | PROV_Admin  | PROV     | generalPaymentForTIN_9_13months | Last 9-13 months  | TIN Only       | Show All      | TAX_IDENTIFIER_TYPE | TIN   |AO|Premium|

  @UPA_PROV_ViewPayments_TC021
  Scenario Outline: Validation of TIN's latest Archive Only payments and Quick Search Filter
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<timeperiod>"
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Search Results for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"

    Examples: 
      | credentials | usertype | timeperiod            | quicksearchfilter | filterpayments | archivefilter | key                               | value |
      | PROV_Admin  | PROV     | archiveOnly30Days     | Last 30 days      | Show All       | Archived Only | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | Y     |
      | PROV_Admin  | PROV     | archiveOnly60Days     | Last 60 days      | Show All       | Archived Only | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | Y     |
      | PROV_Admin  | PROV     | archiveOnly90Days     | Last 90 days      | Show All       | Archived Only | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | Y     |
      | PROV_Admin  | PROV     | archiveOnly4_6months  | Last 4-6 months   | Show All       | Archived Only | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | Y     |
      | PROV_Admin  | PROV     | archiveOnly6_9months  | Last 6-9 months   | Show All       | Archived Only | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | Y     |
      | PROV_Admin  | PROV     | archiveOnly9_13months | Last 9-13 months  | Show All       | Archived Only | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | Y     |

  @UPA_PROV_ViewPayments_TC022
  Scenario Outline: Validation of TIN's latest Active Only payments and Quick Search Filter
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<timeperiod>"
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Search Results for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"

    Examples: 
      | credentials | usertype | timeperiod           | quicksearchfilter | filterpayments | archivefilter | key                               | value |
      | PROV_Admin  | PROV     | activeOnly30Days     | Last 30 days      | Show All       | Active Only   | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Admin  | PROV     | activeOnly60Days     | Last 60 days      | Show All       | Active Only   | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Admin  | PROV     | activeOnly90Days     | Last 90 days      | Show All       | Active Only   | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Admin  | PROV     | activeOnly4_6months  | Last 4-6 months   | Show All       | Active Only   | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Admin  | PROV     | activeOnly6_9months  | Last 6-9 months   | Show All       | Active Only   | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Admin  | PROV     | activeOnly9_13months | Last 9-13 months  | Show All       | Active Only   | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |

  @UPA_PROV_ViewPayments_TC003
  Scenario Outline: Validation of Payment date sorting for both ascending and descending
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<timeperiod>"
    When Click on View Payments Link for UPA
    Then Set Search Filters for "<archivefilter>" having "<timeperiod>"
    Then Verify Payment Date Sorting for "<chronologicalorder>"

    Examples: 
      | credentials | usertype | timeperiod       | chronologicalorder | archivefilter |
      | PROV_Admin  | PROV     | Last 9-13 months | Desc               | Show All      |
      | PROV_Admin  | PROV     | Last 9-13 months | Asc                | Show All      |

  @UPA_PROV_ViewPayments_TC024
  Scenario Outline: Validation of hovering text appearing in popup for Remit Payments
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<paymentType>"
    When Click on View Payments Link for UPA
    Then Set Quick Search Filter for "<paymentType>"
    Then Verify Remit Payment PopUp

    Examples: 
      | credentials | usertype | paymentType  |
      | PROV_Admin  | PROV     | remitPayment |

  @UPA_PROV_ViewPayments_TC025
  Scenario Outline: Validation of hovering text appearing in popup for Failed Payments
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<paymenttype>"
    When Click on View Payments Link for UPA
    Then Set Quick Search Filter for "<paymenttype>"
    Then Verify Failed Payment PopUp

    Examples: 
      | credentials | usertype | paymenttype   |
      | PROV_Admin  | PROV     | failedPayment |

  @UPA_PROV_ViewPayments_TC014
  Scenario Outline: Validation of Zero Dollar ACH Payments
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<paymenttype>"
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Zero Dollar Payments for "<paymenttype>"

    Examples: 
      | credentials | usertype | paymenttype | key                 | value |
      | PROV_Admin  | PROV     | ACH         | TAX_IDENTIFIER_TYPE | ALL   |

  @UPA_PROV_ViewPayments_TC015
  Scenario Outline: Validation of Zero Dollar VCP Payments
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<paymenttype>"
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Zero Dollar Payments for "<paymenttype>"

    Examples: 
      | credentials | usertype | paymenttype | key                 | value |
      | PROV_Admin  | PROV     | VCP         | TAX_IDENTIFIER_TYPE | ALL   |

  @UPA_PROV_ViewPayments_TC012
  Scenario Outline: Validation of correct payment information is displayed on selection of Market type-Medical from the  filter - Market Type
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<paymenttype>"
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Mkt Type for "<mktTypeFilter>"

    Examples: 
      | credentials | usertype | paymenttype   | mktTypeFilter | key         | value |
      | PROV_Admin  | PROV     | medicalFilter | Medical       | MARKET_TYPE | M     |

  @UPA_PROV_ViewPayments_TC013
  Scenario Outline: Validation of TIN's latest Active Only payments and Quick Search Filter
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Select the TIN for UPA Portal for "<quicksearchfilter>"
    And Set FISL Parameters "<key>" and "<value>"
    When Click on View Payments Link for UPA
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>"

    Examples: 
      | credentials | usertype | quicksearchfilter | filterpayments | key         | value |
      | PROV_Admin  | PROV     | Last 9-13 months  | Show All       | MARKET_TYPE | ALL   |
