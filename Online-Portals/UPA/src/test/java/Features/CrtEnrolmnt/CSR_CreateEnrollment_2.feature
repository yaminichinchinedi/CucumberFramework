#Author: your.email@your.domain.com
@tag @CSRCreateEnrollStab @CSRCreateEnrollPart2
Feature: CSR Create Enrollment Validations part2

  ##################################6 CSR_US1247822_CrtEnrlFIINPI #######################################################
  #TS_001
  @CreateEnrollment @US1248704 @BothCSRUPAScenarios @UPARegression @UPASanity
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
  @UPASanity
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
  @Retest11
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
    Then User validates functionality of different buttons like Back,cancel enrollment,Continue(Yes/No on Continue) by clicking on "CSR" portal.

  #TS_018
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
  @UPASanity
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
  @UPASanity
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
  @UPASanity
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
