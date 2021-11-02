#Author: your.email@your.domain.com
@tag @CSRCreateEnrollStab
Feature: CSR Create Enrollment Validations
  ################################## 1. CSR_US1033480_CrtEnrlFooter ###########################################################
  @CSRtest
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
  @CSRUS3610262 @CSR2021_PI02_IP @CSRtest
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

  @CSRUS3610262 @CSR2021_PI02_IP @CSRtest
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
@CSRtest
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
@CSRtest
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

  @CSRUS3143570 @CSRtest
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
  @CSRUS3610262_Negative @CSRtest
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
  @CSRUS2952537AO @CSRtest
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
  @CSRUS2952537VO @CSRtest
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
  @CSRUS2952532 @CSRUS3725611 @FraudPB @CSRtest
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
  @CSRUS2952532 @CSRUS3725611 @FraudPB @CSRtest
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
 @CSRtest
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
@CSRtest
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
@CSRtest
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
@CSRtest
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
@CSRtest
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
@CSRtest
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
  @UPASanity @CSRtest
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
  @UPASanity @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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
  @CSRtest
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

  ##################################6 CSR_US1247822_CrtEnrlFIINPI #######################################################
  #TS_001
  @CreateEnrollment @US1248704 @BothCSRUPAScenarios @UPARegression @UPASanity @CSRtest1
  Scenario: TS_0001_Validate the navigation upon selection of Continue from Financial Institution Information page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.

  #TS_003
  @UPASanity @CSRtest1
  Scenario: TS_0003_Validate the content of the Add NPI Bank Account page
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User Validates UI content with DataBase enrties.

  #TS_004 
  @CSRtest1
  Scenario: TS_0004_Validate the Where can I find a financial institution routing number link.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User clicks on hyperlink 'where can I find a finantial Institution's routing number?'.

  #TC_5,#TC_6,#TC_9
  @CSRtest1
  Scenario: TS_0005_Validate the default Type of Account TS_0006 Supporting documentation TS_0009 NPI bank account.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User validates the various default input like Typ of account,Supporting doc,NPI Bank Account and it can be changed.

  #TS_007
  @CSRtest1
  Scenario: TS_0007_Validate the User is required to upload supporting documentation to their online enrollment for NPI.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User clicks on browse and upload its supporting document on NPI Page.

  #TS_008 #TS_010
  @CSRtest1
  Scenario: TS_0008_TS_0010_Validate How do I manage multiple NPI bank accounts link presents and add multiple user
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills all the information on NPI page for ABA Validator
    Then User clicks on hyperlink 'how do i manage multiple NPI bank accounts?'

  #TS_11,#TS_12
  @Retest11 @CSRtest1
  Scenario: TS_0011_TS_012_Validate the headers on Identify Administrator page for AO and AV TIN.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type

  #TS_013 #TS_014 #TS_015 #TS_016 #TS_017
  @CSRtest1
  Scenario: TS_0013_0014_15_16_17_Validate the content of the Pop Up box upon click of Cancel Enrollment button also different buttons
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User validates functionality of different buttons like Back,cancel enrollment,Continue(Yes/No on Continue) by clicking.

  #TS_018
  @CSRtest1
  Scenario: TS_0018_Validate the error validations upon clicking Continue button on NPI Financial Information Page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User clicks on continue button of FII NPI page and validtes the error messages.

  #TS_019
  @CSRtest1
  Scenario: TS_0019_Validate the error message when no data entered for National Provider Identifier on NPI FII page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User validates various input field by giving blank input and clicking continue button.

  #TS_020 to 28,37,38
  @CSRtest1
  Scenario: TS_0020_to_0028_37_38 Validate the error message when non-numeric data entered.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User validates various input field by giving nonnumeric data input and clicking continue button.

  #TS_035
  @CSRtest1
  Scenario: TS_0035_Validate the error message when Account Number is same as TIN Account Number on NPI FII page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User validates error messages when  TIN no and NPI no are same.

  #TS_036(Pending,Needs clarity on test case)
  @CSRtest1
  Scenario: TS_0036_Validate the error message when National Provider Identifier duplicate entry on NPI FII page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue

  #Then User fills duplicate Information on NPI Page.
  ################################## 7. CSR_US1248704_EditOrgInfoOnReviewSbmtPage ##########################
  #TS_001#TS_04#TS_005 #TS_06#TS_07#TS_08
  @UPASanity @CSRtest1
  Scenario: Fills the relevant Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    And Validate the Headers for Organization Information.
    And Validate page is Content Managed.
    And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
    Then User Clicks Cancel Changes button.
    And Validate User is  redirected to Review and Submit Page and No changes are saved.

  #TS_013 #TS_015-TS_18
  @UPASanity @CSRtest1
  Scenario Outline: Fills the relevant Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User enters new information incorrectly and clicks save button.
    Then Validate the CANCEL CHANGE button is disabled.

    Examples: 
      | credentials |
      | Super       |

  #TS_011#TS_012 #TS_014 
  @CSRtest1
  Scenario Outline: Fills the relevant Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User clears all the information and clicks save button and validate error messages.

    Examples: 
      | credentials |
      | Super       |

  #TS_019#TS_20
  @CSRtest1
  Scenario Outline: Fills the relevant Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User enters new information correctly and clicks save button.
    Then Validate User is  redirected to Review and Submit Page and changes are saved.

    Examples: 
      | credentials |
      | Super       |

  ######################################## 8.CSR_US1248819_EditAdminOnReviewSbmt #######################
  #TS01, TS02, TS04, TS05, TS06,TS07,TS08,TS09,TS10,TS11,TS12,TS17,TS36,TS37
  @UPASanity @CSRtest1
  Scenario Outline: Fills the relevent Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Validate the Headers on Identify Admin Page.
    And Validate the Identify Admin fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
    Then User Check if Mobile number field is mandatory if check box is enabled.
    Then User click on Learn About Alert Frequency Link.
    Then User Clicks Cancel Changes button On Identify Admin Page.

    Examples: 
      | credentials |
      | Super       |

  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS19
  @CSRtest1
  Scenario Outline: Fills the relevent Info with VO Enroll Typ
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "VO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Validate the Headers on Identify Admin Page.

    Examples: 
      | credentials |
      | Super       |

  #TS21-TS29,TS31,TS32,TS33,TS35,TS38-TS46,TS48,TS49,TS50,TS52,TS54
  @CSRtest1
  Scenario Outline: Fills the relevent Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Fill Administrator Info and Verify error msgs for Primary Contacts.
    And Fill Administrator Info and Verify error msgs for Secondary Contacts.

    Examples: 
      | credentials |
      | Super       |

  #TS53
  @CSRtest1
  Scenario Outline: Fills the relevent Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And ReFill the Admin Info and verify the saved changes.

    Examples: 
      | credentials |
      | Super       |

  ################################## 9. CSR_US1248921_CrtEnrlFinInsRevSub #################################
  @CSRtest1
  Scenario Outline: TS_0001_Validate Edit Option next to each field on Review and Submit page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Validates Edit option next to each field on Review and Submit page

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0002_Validate the navigation upon selection of Edit button next to  Financial Information section on Review and Submit page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0006_Validate the data on Financial Information  page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates buttons on Edit Financial Institution Information Page

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0007_Validate the navigation upon selection of Cancel changes.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Clicks on Cancel Changes button on Financial Institution Page.
    And Validate no changes are saved on Review Submit Page for Financial Institution section.

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Clicks on link Where can i find a financial institution's routing number? and validate the popup message

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0009_Validate User is able to update or re-upload enrollment information within the page
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    Then User clicks on edit link of Account information section and reupload any other document
    Then User verifies that uploaded document is present on Review and Submit Page on TIN Section

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts  Link
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then User click back button on Review and Submit Page
    And clicks back button on Upload WNine Page.
    And Clicks on link How do i manage multiple NPI bank accounts and validate the popup message

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0011_Validate the headers on Financial Information page for AO TIN.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Headers on Financial Information page

    Examples: 
      | credentials |
      | Super       |

  #TS_014 015 is covered in US1463317 TS_015
  @CSRtest1
  Scenario Outline: TS_0013/16/17/19/20/21/24/27/30/32_Validate Missing data error message for Financial Institution Information fields.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Missing data Error messages for Financial Institution Fields on click on save changes button

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0018/23/29_Validate the error validations upon Entering PO Box in Street Name Field..
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Invalid data Error messages for Financial Institution Fields on click on save changes button

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0022/26/28/31/34_Validate Invalid Error Messages for Financial Institution Information Page.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0025_Validate the error validations upon no data for  Telephone number.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And User give alphanumeric No in Telphone no fiels and click on save changes button

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_33/35_Upon correcting errors and selecting Save Changes again, updated information is saved and displays on Review and Submit page
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button
    And User should navigate to Review and Submit Page upon Entering valid information
    And Validate the changes are reflected on Review and Submit Page.

    Examples: 
      | credentials |
      | Super       |
@CSRtest1
  Scenario Outline: TS_0036_Validate on edit of different voided check or bank letter, the Cancel Changes button gets disabled.
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Cancel button is disabled when click on edit for voided/blank letter document

    Examples: 
      | credentials |
      | Super       |

  ##################################### 10. CSR_US1351172CrtEnrlAOEmailExist   ###############################
  @CSRtest2
  Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
    Given User navigates to CSR portal and enters "Super" and login
    When ABN Validator Switch is set as 'Y'
    Given User is on CSR Home Page
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then Validate the Headers on Identify Admin Page.
    Then User fills all fields with "<existingEmail>" on Identify Admin page click continue button and validates all the data from DB
    Then click on Yes to continue with "<existingEmail>",Click on NO with different email address depending on "<flag>"

    Examples: 
      | existingEmail       | flag |
      | Primary             | Y    |
      | Primary             | N    |
      | Secondary           | Y    |
      | Secondary           | N    |
      | PrimaryAndSecondary | Y    |
      | PrimaryAndSecondary | N    |
@CSRtest2
  Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
    Given User navigates to CSR portal and enters "Super" and login
    When ABN Validator Switch is set as 'Y'
    Given User is on CSR Home Page
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then Validate the Headers on Identify Admin Page.
    Then User fills all fields with "<existingEmail>" on Identify Admin page click continue button and validates all the data from DB

    Examples: 
      | existingEmail       |
      | PrimaryAndSecondary |

  ######################################## 11. CSR_US1425410_SelectPayMeths ######################################
  #TS03
  @CSRtest2
  Scenario Outline: Fills the relevent Info with VO Enroll Typ
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "VO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9

    Examples: 
      | credentials |
      | Super       |

  #TS04
  @CSRtest2
  Scenario Outline: Fills the relevent Info with AO Enroll Typ
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue

    Examples: 
      | credentials |
      | Super       |

  ######################################12. CSR_US1463317_CrtEnrlmntRvwSmtNPI #################################################
  @CreateEnrollment @US1463317 @BothCSRUPAScenarios @UPARegression @CSRtest2
  Scenario Outline: TS_0001/003_Validate Edit and Remove option Option next to each field on Review and Submit page.
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
    Then User validateds multiple Edit option on Review and Submit Page

    Examples: 
      | credentials |
      | Super       |
@CSRtest2
  Scenario Outline: TS_02/09/34_Validate navigation of click Edit button on NPI section and content on Review and Submit page
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User fills all the information on Financial Institution Information NPI page and click Save Changes
    Then User verifies content of FII-NPI on Review and Submit Page

    Examples: 
      | credentials |
      | Super       |

  #TS_004
  @CSRtest2
  Scenario Outline: TS_0004 Validate Upon selection of Remove the NPI information is deleted and the bank letter or voided check removed.
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page remove link and validate it is removed.

    Examples: 
      | credentials |
      | Super       |

  #TS_005 depricated
  #TS_06,07
  @CSRtest2
  Scenario Outline: TS_0006/007_Validate the buttons on the page and Navigatin on click of Cancel changes Button.
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
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates the Cancel Changes and Save changes buttons,click on Cancel Changes button

    Examples: 
      | credentials |
      | Super       |

  #TS_08
  @CSRtest2
  Scenario Outline: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number
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
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User clicks on hyperlink 'where can I find a finantial Institution's routing number?'.

    Examples: 
      | credentials |
      | Super       |

  #TS_10
  @CSRtest2
  Scenario Outline: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts Link
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User click back button on Review and Submit Page
    And clicks back button on Upload WNine Page.
    Then User clicks on hyperlink 'how do i manage multiple NPI bank accounts?'

    Examples: 
      | credentials |
      | Super       |

  #TS_11 is not present
  #TS_12
  @CSRtest2
  Scenario Outline: TS_0012_Validate Headers for AO Enrollment Type
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
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type

    Examples: 
      | credentials |
      | Super       |

  #TS_15_blank
  #@US1463317
  @CSRtest2
  Scenario Outline: TS_15/17/18/20/21/22/23/28/31/33_Validate the Error message by giving blank input
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates various input field by giving blank input and clicking Save Changes button.

    Examples: 
      | credentials |
      | Super       |

  #TS_NonNumeric
  @CSRtest2
  Scenario Outline: TS_16/23/26/32_Validate the Error message by nonnumeric input
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates various input field by giving nonnumeric data input and clicking Save Changes button.

    Examples: 
      | credentials |
      | Super       |

  #TS_035A and 035B
  @CSRtest2
  Scenario Outline: TS_0035A/35B_Disablinb of Cancel Changes button and with valid info changes are in Review and Submit Page.
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
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User fills invalid information on FII NPI page and click Save Changes, an error will be there and Cancel Changes button is disabled
    Then User fills valid information on FII NPI page and click Save Changes, an verifies changes on Review Submit Page

    Examples: 
      | credentials |
      | Super       |

  #TS_036
  @CSRtest2
  Scenario Outline: TS_0036_Validate on edit of different voided check or bank letter, the Cancel Changes button gets disabled.
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
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User clicks on Edit link to upload doc and validates Cancel button is disabled
    Then User verifies that uploaded document is present on Review and Submit Page

    Examples: 
      | credentials |
      | Super       |

  ################################## 13. CSR_US3501234_OnlineEnrollmentPDF #######################################
  @CSRUS3501234_AO @CSR2021_PI03_01 @CSRtest2
  Scenario Outline: CSR Create Online enrollment PDF for AO tin
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page

    Examples: 
      | credentials |
      | Super       |

  @CSRUS3501234_VO @CSR2021_PI03_01 @CSRtest2
  Scenario Outline: CSR Create Online enrollment PDF for VO tin
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
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page

    Examples: 
      | credentials |
      | Super       |

  #Author:Sai
  @CSRUS3563585_AO @CSR2021_PI03_04 @CSRtest2
  Scenario Outline: Fraud Prevention - Implement scrollbar for Orgname and address suggestions
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "AO" and click continue button
    Then User fills "<BussinessName>" and "<streetName>" on organization information page

    Examples: 
      | credentials | BussinessName | streetName |
      | Super       | MAYO CLINIC   |       1216 |
      | Super       | KAISER        |        200 |

  @CSRUS3563585_VO @CSR2021_PI03_04 @CSRtest2
  Scenario Outline: CSR Create Online enrollment PDF for VO tin
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select Yes button of TIN not enrolled page
    Then User select User Type Enrollment as "VO" and click continue button
    Then User fills "<BussinessName>" and "<streetName>" on organization information page

    Examples: 
      | credentials | BussinessName | streetName |
      | Super       | MAYO CLINIC   |       1216 |
      | Super       | KAISER        |        200 |

  ################################14 US1132023_EnrollmntRedesign #######################
  #TC_01,02,03,04
  @CSRCreateEnrollment @BothCSRUPAScenarios @CSRRegression @US1132023 @CSRSanity @CSRtest2
  Scenario: Enrollment Redesign-Surver Response Reporting for CSR
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Common Reports link
    Then User clicks on drop down and verifies Enrollment Survey Results option
    And User select Enrollment Survey Results option and verifies To and From Date fiels are present
    Then User verifies Submit button on the page
    And click on Submit button without any input

  #TC_05,06
  @CSRtest2
  Scenario: Enrollment Redesign-Surver Response Reporting for CSR
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Common Reports link
    Then User clicks on drop down and verifies Enrollment Survey Results option
    And User select Enrollment Survey Results option and verifies To and From Date fiels are present
    Then User verifies Submit button on the page
    #Then Click on form Button
    When Provide from date and To Date greater than  todays date
    Then Error Message End Date should not be greater than Todays message should be displayed
    When Provide from date  greater than To date
    Then Error Message FromDate can not exceed ToDate should be displayed

  #TC_07,08,09,10
  @CSRtest2
  Scenario Outline: Enrollment Redesign-Verify Excel file generation
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Common Reports link
    Then User clicks on drop down and verifies Enrollment Survey Results option
    And User select Enrollment Survey Results option and verifies To and From Date fiels are present
    Then User verifies Submit button on the page
    Then Choose dates "<duration>" from calenders,click submit button,verifies SurveyResponse.xlx files opened
    Then Verifies all the fields from excel file and database by running query

    Examples: 
      | duration  |
      | Random    |
      | 1 Month   |
      | 12 Months |
      | 13 Months |

  #TC_11
  @CSRtest2
  Scenario: Enrollment Redesign-No data error message generation
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Common Reports link
    Then User clicks on drop down and verifies Enrollment Survey Results option
    And User select Enrollment Survey Results option and verifies To and From Date fiels are present
    Then User verifies Submit button on the page
    Then Choose data dates from calenders,click submit button
    Then If No data fetched then Error message: Your Search Return No Data returned

  ########################### 15 ABAValidatorCSR_NPILevel ####################################################
  @CSRCreateEnrollmentTest @CSRtest2
  Scenario Outline: ABN Validators Financial Institution Information AO -NPI Level Validations
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link

    Examples: 
      | credentials |
      | Super       |

  #|    RW             |
  @CSRtest2
  Scenario Outline: ABN Validators Financial Institution Information AO -Error Messages Validations
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
    Then User fills NPI No and other information with Incorrect/Improper/Null RTN No on Financial Institution Information NPI page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No

    Examples: 
      | credentials |
      | Super       |

  #|    RW             |
  @CSRtest2
  Scenario Outline: ABN Validators Financial Institution Information AO-NPI Level ReValidations
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    Then Users clears the RTN No on NPI page fill the new RTN No and validate the details and click on Save changes button

    Examples: 
      | credentials |
      | Super       |

  #|    RW             |
  ######################################### 16 ABAValidatorCSR_OrgLevel ################################
  @CSRtest2
  Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then clicks back button on Upload WNine Page.
    And modify/remove RTN No making as invalid,validations are performed

    Examples: 
      | credentials |
      | Super       |

  #|    RW             |
  @CSRtest2
  Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Error Messages Validation
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
    Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No

    Examples: 
      | credentials |
      | Super       |

  #|    RW             |
  @CSRtest2
  Scenario Outline: ABN Validators Financial Institution Information AO-Error message Revalidations
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates buttons on Edit Financial Institution Information Page
    Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator

    Examples: 
      | credentials |
      | Super       |

  #|    RW             |
  @CSRtest2
  Scenario Outline: ABN Validators Financial Institution Information AO -Org Level Review and Submit
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
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And Clicks on Cancel Changes button on Financial Institution Page.
    And Validate no changes are saved on Review Submit Page for Financial Institution section.
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    Then Users clears the RTN No fill the new RTN No and validate the details and click on Save changes button
    And Validate the changes are reflected on Review and Submit Page.

    Examples: 
      | credentials |
      | Super       |

  #|    RW             |
  ############################################# 17 CSR_US1202167_CrtEnrlCSRVldtns ##################################
  @CSRtest2
  Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select NO button of TIN not enrolled page and validate that it is on CSR home page

    Examples: 
      | credentials |
      | Super       |
@CSRtest2
  Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Billing Service" and enter unique TIN and click Search
    Then User navigates to TIN not enrolled page and check Return to CSR Welcome page button displayed
    Then clicks on Return to CSR Welcome page button and navigate to CSR Home page

    Examples: 
      | credentials |
      | Super       |
@CSRtest2
  Scenario Outline: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page VO enrollment
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
    And Validate Data is saved in Database on Enrollment Page.

    Examples: 
      | credentials |
      | Super       |

  @CSRtest2
  Scenario Outline: Create Enrollment TIN Entry Error Message Validation
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and validates various messgaes by Entering null,less than 9 char,Alphanumeric char,Specia char in TIN

    Examples: 
      | credentials |
      | Super       |
