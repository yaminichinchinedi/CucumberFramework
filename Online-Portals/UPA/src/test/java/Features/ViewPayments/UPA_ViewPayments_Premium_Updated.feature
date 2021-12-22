#Author: chandaka_srinu@optum.com
@UPA_ViewPayments_Premium_Stabilization
Feature: UPA ViewPayments Functionality for Premium TINs
@UPAtest001
  Scenario Outline: UPA_Provider admin _View payment UI validation for ACH-Premium-TIN
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetches the tin for the "<userType>" with search combination "<QuickSearch>", "<tinType>", "<portalAccess>", "<PaymentStatus>" and "<FilterPayments>"
    And Click on View Payments Link for UPA
    And Provider select the TIN on view payments page
    Then Verify UI of view payment for "<userType>" of TIN  for "<tinType>" for "<portalAccess>"
    #  And Validate View Payments page Text for "<credentials>" for "<portalAccess>"
    And Verify Quick Search dropdown and its default value
    And Verify Filter Payments dropdown and its default value
    And Verify Market Type dropdown and its default value
    And Verify Payment Status dropdown and its default value for "<portalAccess>" TIN
    Then Validate the Footer Information on this page

    Examples: 
      | credentials | userType | QuickSearch  | portalAccess | tinType | PaymentStatus | FilterPayments |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All      | Show All       |
     
  Scenario Outline: UPA_Provider admin _View payment functionality verification for different search criteria
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetches the tin for the "<userType>" with search combination "<QuickSearch>", "<tinType>", "<portalAccess>", "<PaymentStatus>" and "<FilterPayments>"
    And Click on View Payments Link for UPA
    And Provider select the TIN on view payments page
    Then User set filters for "<QuickSearch>", "<FilterPayments>", "<MarketType>", "<PaymentStatus>" on view payments screen
    And Verify Search Results With "<QuickSearch>" for "<FilterPayments>" With "<MarketType>" and "<PaymentStatus>"
    And User validate columns for the "<tinType>" with "<credentials>" for the "<portalAccess>" TIN
    And Verify results should be in chronological order and maximum record should be 30
    And Click on print Payment Summary button.
    And Validate the data of Print Payment Summary page.

    Examples: 
      | credentials | userType | QuickSearch      | portalAccess | tinType | FilterPayments | MarketType | PaymentStatus |
      | PROV_Admin  | PROV     | Last 30 days     | Premium      | AO      | Show All       | Show All   | Show All      |
      | PROV_Admin  | PROV     | Last 60 days     | Premium      | AO      | Show All       | Show All   | Show All      |
      | PROV_Admin  | PROV     | Last 90 days     | Premium      | AO      | Show All       | Show All   | Show All      |
      | PROV_Admin  | PROV     | Last 4-6 months  | Premium      | AO      | Show All       | Show All   | Show All      |
      | PROV_Admin  | PROV     | Last 6-9 months  | Premium      | AO      | Show All       | Show All   | Show All      |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Show All      |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Medical    | Show All      |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Dental     | Show All      |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | New           |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Pending       |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Closed        |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | NPI Only       | Show All   | Show All      |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | TIN Only       | Show All   | Show All      |
 
  Scenario Outline: UPA_Provider admin_Verify User able to update the Payment Status for ACH-Premium-TIN
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetches the tin for the "<userType>" with search combination "<QuickSearch>", "<tinType>", "<portalAccess>", "<PaymentStatus>" and "<FilterPayments>"
    And Click on View Payments Link for UPA
    And Provider select the TIN on view payments page
    Then User set filters for "<QuickSearch>", "<FilterPayments>", "<MarketType>", "<PaymentStatus>" on view payments screen
    And User change the status of payment from "<PaymentStatus>" to "<UpdatedPaymentStatus>" and verify the DB

    Examples: 
      | credentials | userType | QuickSearch      | portalAccess | tinType | FilterPayments | MarketType | PaymentStatus | UpdatedPaymentStatus |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | New           | Pending              |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | New           | Closed               |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Pending       | Closed               |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Closed        | New                  |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Closed        | Pending              |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Pending       | New                  |
@CSRTEST01
  Scenario Outline: UPA_Provider admin_Verify 835 file and EPRA pdf generation ACH-Premium-TIN
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetches the tin for the "<userType>" with search combination "<QuickSearch>", "<tinType>", "<portalAccess>", "<PaymentStatus>" and "<FilterPayments>"
    When Click on View Payments Link for UPA
    And Provider select the TIN on view payments page
    Then User set filters for "<QuickSearch>", "<FilterPayments>", "<MarketType>", "<PaymentStatus>" on view payments screen
    And User download the 835 file for any of the payment
    And User download the already avilable EPRA pdf document for any of the payment
    And User request the EPRA pdf document generation for any of the payment and download it

    Examples: 
      | credentials | userType | QuickSearch      | portalAccess | tinType | PaymentStatus | FilterPayments | MarketType |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All      | TIN Only       | Show All   |

  Scenario Outline: UPA_Provider admin_Verify Content for the one payment for ACH-Premium-TIN  in Remittance Detail page
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetches the tin for the "<userType>" with search combination "<QuickSearch>", "<tinType>", "<portalAccess>", "<PaymentStatus>" and "<FilterPayments>"
    And Click on View Payments Link for UPA
    And Provider select the TIN on view payments page
    Then User set filters for "<QuickSearch>", "<FilterPayments>", "<MarketType>", "<PaymentStatus>" on view payments screen
    Then User get the payment number for which amount is non zero
    And User Click on the payment number
    And User navigate to search Remittance Detail page and verify content
    And Validate Download, Print, Return buttons in Remit Page when user navigated from view paymemnts
    And User clicks on print request button present on Remittance Detail screen.

    Examples: 
      | credentials | userType | QuickSearch      | portalAccess | tinType | FilterPayments | MarketType | PaymentStatus |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | Show All      |

  
  Scenario Outline: UPA_Provider admin_Verify Content for the Zero doller payment for ACH-Premium-TIN  in Remittance Detail page
    Given User navigates to UPA portal and enters "<credentials>" and login
    When User fetches the tin for the "<userType>" with search combination "<QuickSearch>", "<tinType>", "<portalAccess>", "<PaymentStatus>" and "<FilterPayments>"
    And Click on View Payments Link for UPA
    And Provider select the TIN on view payments page
    Then User set filters for "<QuickSearch>", "<FilterPayments>", "<MarketType>", "<PaymentStatus>" on view payments screen
    And Get Zero Dollar Payments for "<QuickSearch>", "<FilterPayments>", "<MarketType>", "<PaymentStatus>" criteria
    And User Click on the payment number
    And User navigate to search Remittance Detail page and verify content
    
    Examples: 
      | credentials | userType | QuickSearch      | portalAccess | tinType | FilterPayments | MarketType | PaymentStatus |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Show All   | New           |
