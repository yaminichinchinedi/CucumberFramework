#Author: Pranav Kasula
@UPARegression @BothCSRUPAScenarios  @ViewPayments
Feature: UPA Payment Details Billing Service     
          
@US2707345
Scenario Outline: View Payments Page UI Functionality for CSR 
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
    And User selects time period filter "<timePeriod>" for View Payments
     Then Validate that View Payments Payer/Patient column name is changed to Payer for "<type>"
Examples:

        |    searchBy                   |       credentials        |userType   |  timePeriod   |  type  |
		|generalPaymentForTIN_90days    |       BS_Admin           |  BS       |  Last 90 days |  UPA   |
        |generalPaymentForTIN_90days    |       BS_Gen             |  BS       |  Last 90 days |  UPA   |
        

@US2810748 
Scenario Outline: View Payments UI Functionality for Complaint patient payments CSR
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
    And User selects time period filter "<timePeriod>" for View Payments
    And User selects market type filter period "<filter>" for View Payments
     Then Validate the EPRA and Payer PRA column in View Payments Page for "<<type>"
    
Examples:

        |    searchBy                   |       credentials        |userType   |  timePeriod   |  filter           |   type  |
		|generalPaymentForTIN_90days    |       BS_Admin           |  BS       |  Last 90 days |  Patient Payments |   UPA   |
        |generalPaymentForTIN_90days    |       BS_Gen             |  BS       |  Last 90 days |  Patient Payments |   UPA   |
        
        
@US2707374
Scenario Outline: View Payments Page UI Functionality for Patient Payements(View Payments --> Remittance Detail)
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
     And User selects time period filter "<timePeriod>" for View Payments
     And User selects market type filter period "<filter>" for View Payments
     Then Validate and click on payment number
     Then Validate all Headers in the Page for Payer
     Then Validate Column Headers in the grid for remittance detail Page
    
Examples:

        |    searchBy                   |       credentials        |userType   |  timePeriod   |  filter           |
		|generalPaymentForTIN_90days    |       BS_Admin           |  BS       |  Last 90 days |  Patient Payments |
        |generalPaymentForTIN_90days    |       BS_Gen             |  BS       |  Last 90 days |  Patient Payments |
        

Scenario Outline: View Payments information is displayed for BS
     
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for BS View Payments UPA for "<paymentType>" and "<userType>" search criteria
     Then User selects "<filterPayments>" "<quickSearchFilter>" "<archiveFilter>" "<MktTypeFilter>" filters for "<key>" "<value>" and validate payment search results
    
Examples:

    |       paymentType              | credentials|userType|filterPayments |quickSearchFilter|archiveFilter| MktTypeFilter    |        key        |value |
    | generalPaymentForTIN_30days    | BS_Admin   |  BS    |   TIN Only    | Last 30 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_60days    | BS_Admin   |  BS    |   TIN Only    | Last 60 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_90days    | BS_Admin   |  BS    |   TIN Only    | Last 90 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_4-6months | BS_Admin   |  BS    |   TIN Only    | Last 4-6 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_6-9months | BS_Admin   |  BS    |   TIN Only    | Last 6-9 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_9-13months| BS_Admin   |  BS    |   TIN Only    |Last 9-13 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPayment30Days           | BS_Admin   |  BS    |   Show All    | Last 30 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| ALL  |
    | generalPayment60Days           | BS_Admin   |  BS    |   Show All    | Last 60 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| ALL  |
    | generalPayment90Days           | BS_Admin   |  BS    |   Show All    | Last 90 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| ALL  |
    | Last 4-6 months                | BS_Admin   |  BS    |   Show All    |Last 4-6 months |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| ALL  |
    | Last 6-9 months                | BS_Admin   |  BS    |   Show All    |Last 6-9 months |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| ALL  |
    | Last 9-13 months               | BS_Admin   |  BS    |   Show All    |Last 9-13 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| ALL  |
    | generalPaymentForNPI_30days    | BS_Admin   |  BS    |   NPI Only    | Last 30 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| NPI  |
    | generalPaymentForNPI_60days    | BS_Admin   |  BS    |   NPI Only    | Last 60 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| NPI  |
    | generalPaymentForNPI_90days    | BS_Admin   |  BS    |   NPI Only    | Last 90 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| NPI  |
    | generalPaymentForNPI_4-6months | BS_Admin   |  BS    |   NPI Only    | Last 4-6 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| NPI  |
    | generalPaymentForNPI_6-9months | BS_Admin   |  BS    |   NPI Only    | Last 6-9 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| NPI  |
    | generalPaymentForNPI_9-13months| BS_Admin   |  BS    |   NPI Only    |Last 9-13 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| NPI  |
    | generalPaymentForTIN_30days    | BS_Admin   |  BS    |   TIN Only    | Last 30 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_60days    | BS_Admin   |  BS    |   TIN Only    | Last 60 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_90days    | BS_Admin   |  BS    |   TIN Only    | Last 90 days   |  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_4-6months | BS_Admin   |  BS    |   TIN Only    | Last 4-6 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_6-9months | BS_Admin   |  BS    |   TIN Only    | Last 6-9 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
    | generalPaymentForTIN_9-13months| BS_Admin   |  BS    |   TIN Only    |Last 9-13 months|  Show All    | Show All         |TAX_IDENTIFIER_TYPE| TIN  |
 	| activeOnly30Days               | BS_Admin   |  BS    |   Show All    | Last 30 days   |  Active Only | Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   N  |
    | activeOnly60Days               | BS_Admin   |  BS    |   Show All    | Last 60 days   |  Active Only | Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   N  |
    | activeOnly90Days               | BS_Admin   |  BS    |   Show All    | Last 90 days   |  Active Only | Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   N  |
    | activeOnly4_6months            | BS_Admin   |  BS    |   Show All    | Last 4-6 months|  Active Only | Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   N  |
    | activeOnly6_9months            | BS_Admin   |  BS    |   Show All    | Last 6-9 months|  Active Only | Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   N  |
    | activeOnly9_13months           | BS_Admin   |  BS    |   Show All    |Last 9-13 months|  Active Only | Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   N  |
    | archiveOnly30Days              | BS_Admin   |  BS    |   Show All    | Last 30 days   | Archived Only| Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   Y  |
    | archiveOnly60Days              | BS_Admin   |  BS    |   Show All    | Last 60 days   | Archived Only| Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   Y  |
    | archiveOnly90Days              | BS_Admin   |  BS    |   Show All    | Last 90 days   | Archived Only| Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   Y  |
    | archiveOnly4_6months           | BS_Admin   |  BS    |   Show All    | Last 4-6 months| Archived Only| Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   Y  |
    | archiveOnly6_9months           | BS_Admin   |  BS    |   Show All    | Last 6-9 months| Archived Only| Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   Y  |
    | archiveOnly9_13months          | BS_Admin   |  BS    |   Show All    |Last 9-13 months| Archived Only| Show All         |ACTIVE_ARCHIVE_PAYMENTS_INDICATOR|   Y  |
    | generalPayment60Days           | BS_Admin   |  BS    |   Show All    |Last 60 days    | Show All     | Show All         |   MARKET_TYPE   |   ALL  |
    | medicalFilter                  | BS_Admin   |  BS    |   Show All    |Last 60 days    | Show All     | Medical          |   MARKET_TYPE   |   M  |
    
@test123
Scenario Outline: View Payments information for Zero Dollar ACH and VCP
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for BS View Payments UPA for "<paymentType>" and "<userType>" search criteria
     Then User verifies "<paymentType>" zero dollar payments for "<key>" "<value>"
    
Examples:

    |       paymentType    | credentials|userType|        key        |value |
    |          NON         | BS_Admin   |  BS    |TAX_IDENTIFIER_TYPE| ALL  |
    

Scenario Outline: View Payments hovering text appearing in popup for Remit Payments
     Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     Then User enters tin for BS View Payments UPA for "<paymentType>" and "<userType>" search criteria
     Then User verifies hovering text in pop up for  "<paymentType>" and "<key>" "<value>"
    
Examples:

    |       paymentType    | credentials|userType|        key        |value |
    |     remitPayment     | BS_Admin   |  BS    |TAX_IDENTIFIER_TYPE| ALL  |
    |    failedPayment     | BS_Admin   |  BS    |TAX_IDENTIFIER_TYPE| ALL  |
    
Scenario: View Payments chronological order of payments
     
     Given User navigates to UPA portal and enters "BS_Admin" and login
     When Click on View Payments Link for UPA
     Then User enters tin for BS View Payments UPA for "generalPayment90Days" and "BS" search criteria
     Then User selects "Show All" "Last 90 days" "Show All" "Show All" filters for "TAX_IDENTIFIER_TYPE" "TIN" and validate payment date sorting
    
        