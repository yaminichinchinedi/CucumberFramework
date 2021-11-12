#Author: your.email@your.domain.com
@CSRCreateEnrollStab @CSRCreateEnrollPart1
Feature: CSR Create Enrollment Validations

  ################################## 1. CSR_US1033480_CrtEnrlFooter ###########################################################
  Scenario Outline: US1033480_Create Enrollment- AO - Footer Information
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then Validate the Footer Information on this page
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then Validate the Footer Information on this page
    Then User select Yes button of TIN not enrolled page
    Then Validate the Footer Information on this page
    Then User select User Type Enrollment as "AO" and click continue button
    Then Validate the Footer Information on this page
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then Validate the Footer Information on this page
    Then User fills all the information on Identify Administrators page and click continue
    Then Validate the Footer Information on this page
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then Validate the Footer Information on this page
    Then User uploads the WNine form and click continue
    Then Validate the Footer Information on this page
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    Then Validate the Footer Information on this page

    Examples: 
      | credentials |
      | Super       |

  ###################################2. CSR_US1033910_35_US1048192_99_CrtEnrlSubmtd ############################################
  @CSRUS3610262 @CSR2021_PI02_IP
  Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "<userType>" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<tinType>" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.
    And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
    And Click on ACH Addendum link verify popup functionality and close the link
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
    And Click on Exit Enrollment button navigates to the Optum Pay landing page

    Examples: 
      | credentials | tinType | userType |
      | Super       | AO      | PROV     |

  @CSRUS3610262 @CSR2021_PI02_IP
  Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page VO enrollment
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "<userType>" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<tinType>" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.
    And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
    And Click on Exit Enrollment button navigates to the Optum Pay landing page

    Examples: 
      | credentials | tinType | userType |
      | Super       | VO      | PROV     |

  Scenario Outline: US1033935 Create Enrollment AO Enrollment Submitted page
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    Then Click on Submit Enrollment button and verify Enrollment Information
    Then Also click on Print Enrollment form link download PDF and verify PDF data

    Examples: 
      | credentials |
      | Super       |

  Scenario Outline: US1033935 Create Enrollment VO Enrollment Submitted Page
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "VO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    Then Click on Submit Enrollment button and verify Enrollment Information
    Then Also click on Print Enrollment form link download PDF and verify PDF data

    Examples: 
      | credentials |
      | Super       |

  @CSRUS3143570
  Scenario Outline: Create Enrollment Enrollment Submitted
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "VO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    #And Validate Data is saved in Database on Enrollment Page.
    And Validate one corresponding row is inserted in Product Selection Table

    Examples: 
      | credentials |
      | Super       |

  #Author: Shalini Mahavratayajula
  @CSRUS3610262_Negative
  Scenario Outline: US3610262 Provider Login to CSR Application to validate error scenario for "BusinessPhone" in organization Information page.
    #When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "<userType>" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<tinType>" and click continue button
    Then User sets invalid business phone "<invalidBusinessPhone>"
    Then User fills all the information  and click on Continue
    Then User validate error messages

    Examples: 
      | credentials | tinType | userType | invalidBusinessPhone |
      | Super       | AO      | PROV     | AlphaNumericString   |
      | Super       | VO      | PROV     | SpecialCharacters    |

  #Author: Shalini Mahavratayajula
  @CSRUS2952537AO
  Scenario Outline: CSRUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators AO enrollment
    When ABN Validator Switch is updated to 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "<userType>" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<tinType>" and click continue button
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | tinType | userType | checkAutoPopulate |
      | Super       | AO      | PROV     | busNameYAndAddrY  |
      | Super       | AO      | PROV     | busNameYAndAddrN  |
      | Super       | AO      | PROV     | busNameNAndAddrY  |
      | Super       | AO      | PROV     | busNameNAndAddrN  |

  #Author: Shalini Mahavratayajula
  @CSRUS2952537VO
  Scenario Outline: CSRUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators VO enrollment
    When ABN Validator Switch is updated to 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "<userType>" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<tinType>" and click continue button
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | tinType | userType | checkAutoPopulate |
      | Super       | VO      | PROV     | busNameYAndAddrY  |
      | Super       | VO      | PROV     | busNameYAndAddrN  |
      | Super       | VO      | PROV     | busNameNAndAddrY  |
      | Super       | VO      | PROV     | busNameNAndAddrN  |

  #Author: Piyush Bagdiya
  @CSRUS2952532 @CSRUS3725611 @FraudPB
  Scenario Outline: CSRUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators AO enrollment
    When ABN Validator Switch is updated to 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "<userType>" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<tinType>" and click continue button
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | tinType | userType | checkAutoPopulate |
      | Super       | AO      | PROV     | busNameYAndAddrY  |
      | Super       | AO      | PROV     | busNameYAndAddrN  |
      | Super       | AO      | PROV     | busNameNAndAddrY  |
      | Super       | AO      | PROV     | busNameNAndAddrN  |

  #Author: Piyush Bagdiya
  @CSRUS2952532 @CSRUS3725611 @FraudPB
  Scenario Outline: CSRUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators VO enrollment
    When ABN Validator Switch is updated to 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "<userType>" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<tinType>" and click continue button
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | tinType | userType | checkAutoPopulate |
      | Super       | VO      | PROV     | busNameYAndAddrY  |
      | Super       | VO      | PROV     | busNameYAndAddrN  |
      | Super       | VO      | PROV     | busNameNAndAddrY  |
      | Super       | VO      | PROV     | busNameNAndAddrN  |

  ##################################### 4. CSR_US1247779_IdentifyAdminVldtn #############################################
  Scenario Outline: US1247779 Identify Admin page content,llinks validations
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User validates the page content of Identify Admin page
    Then User clicks on Learn about alert frequency link validates its content and close it
    Then User clicks on CLEAR ADMINISTRATOR INFORMATION link verify its content and YES/NO functionality
    Then Clicks on Continue to validate all the Error Messages

    Examples: 
      | credentials |
      | Super       |

  Scenario Outline: US1247779 Identify Admin page
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills mobileNo and checks its enabilty/disability of Identify Admin Page
    Then User checks its Back and continue button functionality
    Then User Clicks on Cancel Enrollment,verify its content and YES/NO button functionality for CSR

    Examples: 
      | credentials |
      | Super       |

  Scenario Outline: US1247779 Identify Admin page
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "<Enrollment Type>" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then Validates all the headers from the Identify Administrators page

    Examples: 
      | credentials | Enrollment Type |
      | Super       | AO              |
      | Super       | VO              |

  Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills  primary info. and in Secondary info. enter "<InputField>" and "<dataFormat>" and validate Error messages

    Examples: 
      | credentials | InputField                                        | dataFormat            |
      | Super       | First Name, Last Name, Email, RetypeEmail, Tel No | blank                 |
      | Super       | Tel No                                            | Incomplete,nonNumeric |
      | Super       | email                                             | Incorrect             |
      | Super       | First Name, Middle Name ,Last Name                | Alphanumeric          |
      | Super       | First Name, Middle Name, Last Name                | Special Char          |

  Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills  all data but different email and Retype email for "<InputField>" and validate Error messages

    Examples: 
      | credentials | InputField |
      | Super       | Primary    |
      | Super       | Secondary  |

  Scenario Outline: US1247779 Identify Admin page Primary Information Error Messages
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills  primary information with "<InputField>" and "<dataFormat>" and validate Error messages

    Examples: 
      | credentials | InputField                                        | dataFormat            |
      | Super       | First Name, Last Name, Email, RetypeEmail, Tel No | blank                 |
      | Super       | Tel No                                            | Incomplete,nonNumeric |
      | Super       | email                                             | Incorrect             |
      | Super       | First Name, Middle Name ,Last Name                | Alphanumeric          |
      | Super       | First Name, Middle Name, Last Name                | Special Char          |

  #######################################5. CSR_US1247813_CrtEnrlmntFII ###################################
  #TS_001
  @UPASanity
  Scenario: Fills the relevent Info with AO Enroll Typ
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue

  #TS_005
  @UPASanity
  Scenario: Checking UI Content matches with DB
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then It is Validated that Financial Institution Information page text is content managed

  #TS_006
  Scenario: Clicking FI Routing no
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator
    Then User clicks the link where can i find a finantial intitution's routing no

  #TS_007
  Scenario: Validates the Type of Account
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    When User fills all the information on Financial Institution Information page for Routing And AccountNumber
    Then User validates the Type of account as Checking by default and can be change to Saving

  #TS_008
  Scenario: Validates the Supporting doc as Void Check and Bank Letter
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    When User fills all the information on Financial Institution Information page for Routing And AccountNumber
    Then User validates the supporting document as Voided Check by default and can be change to Bank letter

  #TS_009
  Scenario: Browsing the Supporting docs
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    When User fills all the information on Financial Institution Information page for Routing And AccountNumber
    Then User clicks on browse and upload its supporting document

  #TS_010
  Scenario: Clicking on multiple NRI bank accounts
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User clicks on hyperlink how do i manage multiple NPI bank accounts

  #TS_011
  Scenario: Validates the NPI Bank Account
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User validates the NPI Bank account as No by default and can be change to Yes

  #TS_012 #TS_013
  Scenario: Validating the Headers content
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type

  #TS_014 #TS_015
  Scenario: Validation of buttons Cancel Enrollment, Back and Continue for AV and AO enrollment
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User validates and clicks buttons Back,Cancel Enrollment,Continue are on the FII page

  #TS_016 #TS_017 #TS_018
  Scenario: Validating the Error on click of Continue button of FII page
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User clicks on continue button of FII page and validtes the error messages

  #TS_021
  Scenario: Validating that non accepted file format not uploaded
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information and upload non accepted file format and clicks on continue
