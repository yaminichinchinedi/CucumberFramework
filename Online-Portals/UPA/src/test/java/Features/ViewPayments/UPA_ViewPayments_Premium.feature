#Author: amit_kushwah@optum.com
@UPA_ViewPayments_Premium @UPARegression
Feature: UPA ViewPayments Functionality for Premium TIN

  #Author: AMIT
  @UPAViewPayments_US2793429 @OctRelease @UPA_ViewPaymentStable 
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
    Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate Archive column relabeled to Payment Status
    Then Validate Archive/Save changes button is relabeled to Save
    And Set FISL Parameters "<key>" and "<value>"
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    Then Validate 835, ePRA and Payer PRA are enabled
    Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter | archivefilter | key                               | value |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Gen    | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |

  #Author: AMIT
  @UPAViewPayments_US2783429 @OctRelease @UPA_ViewPaymentStable 
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate Archive column relabeled to Payment Status
    And Set FISL Parameters "<key>" and "<value>"
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    Then Validate user is able to change the value of Payment Status column

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter | archivefilter | key                               | value |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Gen    | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |

  #Author: AMIT
  @UPAViewPayments_US2908669 @UPA_ViewPaymentStable 
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Click on print Payment Summary button.
    And Set FISL Parameters "<key>" and "<value>"
    Then Validate the data of Print Payment Summary page.

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter | archivefilter | key                               | value |
      | PROV_Admin  | PROV     | Last 30 days     | Premium      | AO      | Show All       | Last 30 days      | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | PROV_Gen    | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |

  #Author: AMIT
  @UPAViewPayments_US2908671 @UPA_ViewPaymentStable 
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Click on print Payment Summary button.
    And Set FISL Parameters "<key>" and "<value>"
    Then Validate the data of Print Payment Summary page.

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter | archivefilter | key                               | value |
      | BS_Admin    | BS       | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |
      | BS_Gen      | BS       | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           | ACTIVE_ARCHIVE_PAYMENTS_INDICATOR | N     |

  #Author: Amit
  @UPAViewPayments_US2973009 @NovRelease @UPA_ViewPaymentStable 
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Click on Payment number and go to Remittance Detail screen.
    Then Click on Claim number on Remittance Detail screen and go to Claim Detail screen.
    Then Click on Payment number on Claim detail screen and go to single Payment View Payment screen.
    Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Validate the data between Single Payment Summary page and poped up Print payment Summary page

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter | archivefilter |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  | New           |
      | PROV_Admin  | PROV     | Last 30 days     | Premium      | AO      | Show All       | Last 30 days      | New           |

   @UPAUS2955416 @UPATEST01
  	Scenario Outline: Access Payments - View Payments - Header Page Text
   Given User navigates to UPA portal and enters "<credentials>" and login
   And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  	When Click on View Payments Link for UPA
    And User verifies different  messages based on "<credentials>", "<Trial Status>" and "<Paid option>"
     Examples:
             |    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   	| tinType		|
             |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  WithinTrial and Paid 	|	  AO			|
             |       PROV_Gen          | 			 PROV			    	|			Premium			  |  WithinTrial and Paid 	|	  AO			|
             |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and Paid 		|	  AO			|
             |       PROV_Gen          | 			 PROV			    	|			Premium		  	|  PostTrial and Paid 		|	  AO			|
             |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and NotPaid 	|	  VO			|
             |       PROV_Gen          | 			 PROV			    	|			Premium		  	|  PostTrial and NotPaid 	|	  VO			|
  @UPAUS3015574
  Scenario Outline: Access Payments - View Payments - PPRA link for Prov
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then User clicks on pPRA link
    And User verifies record is inserted in PPRA_STATUS Table with Tin No,Consolidated No and Settlement date

    Examples: 
      | credentials | userType | portalAccess | searchCriteria | tinType | filterpayments | quicksearchfilter | archivefilter |
      | PROV_Admin  | PROV     | Premium      | Last 60 days   | AO      | Show All       | Last 60 days      | New           |
      | PROV_Gen    | PROV     | Premium      | Last 60 days   | AO      | Show All       | Last 60 days      | New           |

  @UPAUS3015574 
  Scenario Outline: Access Payments - View Payments - PPRA link for BS
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then User clicks on pPRA link
    And User verifies record is inserted in PPRA_STATUS Table with Tin No,Consolidated No and Settlement date

    Examples: 
      | credentials | userType | portalAccess | searchCriteria | tinType | filterpayments | quicksearchfilter | archivefilter |
      | BS_Admin    | BS       | Premium      | Last 60 days   | AO      | Show All       | Last 60 days      | New           |
      | BS_Gen      | BS       | Premium      | Last 60 days   | AO      | Show All       | Last 60 days      | New           |

  #Sunanda
  @UPAViewPaymentsPremiumBS @wait 
  Scenario Outline: Access Payments - View Payments - BS Admin Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate Archive column relabeled to Payment Status
    Then Validate Archive/Save changes button is relabeled to Save
    Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
    And User clicks on UPA logout

    Examples: 
      | credentials | userType | searchCriteria | portalAccess | tinType | filterpayments | quicksearchfilter | archivefilter |
      | BS_Admin    | BS       | Last 60 days   | Premium      | AO      | Show All       | Last 60 days      | New           |
      | BS_Gen      | BS       | Last 60 days   | Premium      | AO      | Show All       | Last 60 days      | New           |

  #Author: Mohammad Khalid
  @UPAViewPayments_US3080022 @UPAViewPayments_US3080019 
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Validate "Fee Amount" column is displayed.
    Then validate Fee Amount info icon message
    Then Validate amount is displayed for payments present in debit fee rate table.

    Examples: 
      | credentials | userType | searchCriteria | portalAccess | tinType | filterpayments | quicksearchfilter | archivefilter |
      | PROV_Admin  | PROV     | Last 30 days   | Premium      | AO      | Show All       | Last 30 days      | New           |

  #Author : Vinay Raghumanda
  @US3179215 @UPAUS3438488 
  Scenario Outline: View payments page Text Validation for PROV users
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Validate View Payments page Text for "<credentials>" for "<portalAccess>"

    Examples: 
      | credentials | userType | portalAccess | tinType | searchCriteria       |
      | PROV_Admin  | PROV     | Premium      | AO      | PremiumOrStandardTIN |
      | PROV_Admin  | PROV     | Standard     | AO      | PremiumOrStandardTIN |
      | PROV_Gen    | PROV     | Premium      | AO      | PremiumOrStandardTIN |
      | PROV_Gen    | PROV     | Standard     | AO      | PremiumOrStandardTIN |
      | PROV_Admin  | PROV     | Premium      | VO      | PostTrial and Paid   |
      | PROV_Gen    | PROV     | Premium      | VO      | PostTrial and Paid   |

  @US3179215 
  Scenario Outline: View payments page Text Validation for BS Users
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Validate View Payments page Text for "<credentials>" for "<portalAccess>"

    Examples: 
      | credentials | userType | portalAccess | tinType | searchCriteria |
      | BS_Admin    | BS       | Premium      | AO      | Last 60 days   |
      | BS_Gen      | BS       | Premium      | AO      | Last 60 days   |

  #Author: Marsha
  @UPAViewPaymentsFeeAmtCol_Prov_premium @US3106945 
  Scenario Outline: View Payments - Fee Amount Column for Premium TIN Provider
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate Fee Amount column is displayed.
    Then Click on print Payment Summary button.
    Then Validate Fee Amount column is displayed.

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | archivefilter | quicksearchfilter | filterpayments |
      | PROV_Admin  | PROV     | Last 9-13 months | Premium      | AO      | New           | Last 9-13 months  | Show All       |
      | PROV_Gen    | PROV     | Last 9-13 months | Premium      | AO      | New           | Last 9-13 months  | Show All       |

  #Author: Marsha
  @UPAViewPaymentsFeeAmtCol_BS_premium @US3106945 
  Scenario Outline: View Payments - Fee Amount Column for Premium TIN BS
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Set search filters for "<archivefilter>" having "<quicksearchfilter>" With "<filterpayments>"
    Then Validate Fee Amount column is displayed.
    Then Click on print Payment Summary button.
    Then Validate Fee Amount column is displayed.

    Examples: 
      | credentials | userType | portalAccess | searchCriteria   | tinType | archivefilter | quicksearchfilter | filterpayments |
      | BS_Admin    | BS       | Premium      | Last 9-13 months | AO      | New           | Last 9-13 months  | Show All       |
      | BS_Gen      | BS       | Premium      | Last 9-13 months | AO      | New           | Last 9-13 months  | Show All       |

  #Author: AMIT
  @UPA_ViewPaymentPayer_1 @UPA_ViewPaymentStable @UPA_ViewPaymentPremium 
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Set search filters for Payer "<filterpayments>" having "<quicksearchfilter>"
    Then Click on print Payment Summary button.
    Then Validate the data of Print Payment Summary page.

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter |
      | PAY_Admin   | PAY      | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  |
      | PAY_Admin   | PAY      | Last 6-9 months  | Premium      | AO      | Show All       | Last 6-9 months   |
      | PAY_Admin   | PAY      | Last 60 days     | Premium      | AO      | Show All       | Last 60 days      |
      | PAY_Gen     | PAY      | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  |

  #Author: AMIT
  @UPA_ViewPaymentPayer_2 @UPA_ViewPaymentStable @UPA_ViewPaymentPremium  
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options for "<portalAccess>".
    Then Set search filters for Payer "<filterpayments>" having "<quicksearchfilter>"
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Verify Search Results With "<filterpayments>" for "<quicksearchfilter>" With "<archivefilter>"
    Then Validate 835, ePRA and Payer PRA are enabled
    Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter |
      | PAY_Admin   | PAY      | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  |
      | PAY_Gen     | PAY      | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  |

  #Author: Amit
  @UPA_ViewPaymentPayer @UPA_ViewPaymentStable @UPA_ViewPaymentPremium
  Scenario Outline: Access Payments - View Payments - Provider Premium
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Set search filters for Payer "<filterpayments>" having "<quicksearchfilter>"
    Then Click on Payment number and go to Remittance Detail screen.
    Then Click on Claim number on Remittance Detail screen and go to Claim Detail screen.
    Then Click on Payment number on Claim detail screen and go to single Payment View Payment screen.
    Then Validate 835, ePRA and Payer PRA are enabled
    Then Validate the data between Single Payment Summary page and poped up Print payment Summary page

    Examples: 
      | credentials | userType | searchCriteria   | portalAccess | tinType | filterpayments | quicksearchfilter |
      | PAY_Admin   | PAY      | Last 30 days     | Premium      | AO      | Show All       | Last 30 days      |
      | PAY_Admin   | PAY      | Last 6-9 months  | Premium      | AO      | Show All       | Last 6-9 months   |
      | PAY_Gen     | PAY      | Last 9-13 months | Premium      | AO      | Show All       | Last 9-13 months  |

  @UPAUS3690873 
  Scenario Outline: Vpay 835 and epra link visiblity for Prov
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then Validate 835,ePRA links are enabled/disabled based on Search criteria and click on 835 if enabled to get it downloaded

    Examples: 
      | credentials | userType | searchCriteria                  | portalAccess | tinType |
      | PROV_Admin  | PROV     | vpay_835_enabled_ePRA_disabled  | Premium      | AO      |
      | PROV_Gen    | PROV     | vpay_835_enabled_ePRA_disabled  | Premium      | AO      |
      | PROV_Admin  | PROV     | vpay_835_disabled_ePRA_disabled | Premium      | AO      |
      | PROV_Gen    | PROV     | vpay_835_disabled_ePRA_disabled | Premium      | AO      |

  @UPAUS3690873 
  Scenario Outline: Vpay 835 and epra link visiblity  for BS and Payer
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA
    Then User Enters tin and click on search button for "<userType>".
    Then Validate 835,ePRA links are enabled/disabled based on Search criteria and click on 835 if enabled to get it downloaded

    Examples: 
      | credentials | userType | searchCriteria                 | portalAccess | tinType |
      | BS_Admin    | BS       | vpay_835_enabled_ePRA_disabled | Premium      | AO      |
      | PAY_Admin   | PAY      | vpay_835_enabled_ePRA_disabled | Premium      | AO      |
