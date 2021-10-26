#Author: your.email@your.domain.com
@UPACreateEnrollment @UPACreateEnrollPart2
Feature: UPA Create Enrollment Validations part2

  ##################################### 13. US1247822_CrtEnrlFIINPI ################################################
  #TS_001
  @UPASanity
  Scenario: TS_0001_Validate the navigation upon selection of Continue from Financial Institution Information page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.

  #TS_003
  @UPASanity
  Scenario: TS_0003_Validate the content of the Add NPI Bank Account page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User Validates UI content with DataBase enrties.

  #TS_004
  Scenario: TS_0004_Validate the Where can I find a financial institution routing number link.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User clicks on hyperlink 'where can I find a finantial Institution's routing number?'.

  #TC_5,#TC_6,#TC_9
  Scenario: TS_0005_Validate the default Type of Account TS_0006 Supporting documentation TS_0009 NPI bank account.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User validates the various default input like Typ of account,Supporting doc,NPI Bank Account and it can be changed.

  #TS_007
  Scenario: TS_0007_Validate the User is required to upload supporting documentation to their online enrollment for NPI.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User clicks on browse and upload its supporting document on NPI Page.

  # TS_008 #TS_010
  #
  #Scenario: TS_0008_TS_0010_Validate How do I manage multiple NPI bank accounts link presents and add multiple user
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #	Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
  #Then User clicks on hyperlink 'how do i manage multiple NPI bank accounts?'
  #Then User fills all the information on Financial Institution Information NPI page and click continue NPI.
  #TS_11,#TS_12
  Scenario Outline: TS_0011_TS_012_Validate the headers on Identify Administrator page for AO and AV TIN.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then user selects as "<EnrollmentType>" and  Clicks continue button of Enrollment TIN Eligible page
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type

    Examples: 
      | EnrollmentType |
      | AO             |

  #     |			 AV					|
  #TS_013 #TS_014 #TS_015 #TS_016 #TS_017 --TODO
  Scenario: TS_0013_0014_15_16_17_Validate the content of the Pop Up box upon click of Cancel Enrollment button also different buttons
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User validates functionality of different buttons like Back,cancel enrollment,Continue(Yes/No on Continue) by clicking.

  #TS_018
  Scenario: TS_0018_Validate the error validations upon clicking Continue button on NPI Financial Information Page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User clicks on continue button of FII NPI page and validtes the error messages.

  # TS_019
  Scenario: TS_0019_Validate the error message when no data entered for National Provider Identifier on NPI FII page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User validates various input field by giving blank input and clicking continue button.

  #TS_020 to 28,37,38
  #
  #Scenario: TS_0020_to_0028_37_38 Validate the error message when non-numeric data entered.
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #	Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #		Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
  #Then User validates various input field by giving nonnumeric data input and clicking continue button.
  # TS_029 to 32
  #Scenario: TS_0029_to_32_Validate the error message when PO box entered for Address Street and Incomplete Info on NPI FII page.
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #	Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #Then User fills all the information on Financial Institution Information page and click continue NPI
  #Then User validates error messages by giving PO BOX No in Street field,Invalid zip/state code incomplete phoneno.
  #TS_035
  Scenario: TS_0035_Validate the error message when Account Number is same as TIN Account Number on NPI FII page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User validates error messages when  TIN no and NPI no are same.

  #TS_036(Pending,Needs clarity on test case)
  Scenario: TS_0036_Validate the error message when National Provider Identifier duplicate entry on NPI FII page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue

  #Then User fills duplicate Information on NPI Page.
  ########################################### 14. US1248704_EditOrgInfoOnReviewSbmtPage ###################
  #TS_001#TS_04#TS_005 #TS_06#TS_07#TS_08
  @UPASanity
  Scenario: Fills the relevant Info with AO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    And Validate the Headers for Organization Information.
    And Validate page is Content Managed.
    And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
    Then User Clicks Cancel Changes button.
    And Validate User is  redirected to Review and Submit Page and No changes are saved.

  #TS_002#TS__009
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #Scenario: Fills the relevant Info with AV Enroll Typ
  #  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #									      | Enrollment Type |
  #										      |       AV        |
  #   Then User fills all the information  and click on Continue
  #   Then User fills all the information on Identify Administrators page and click continue
  #   Then User fills all the information on Financial Institution Information page and click continue AV
  #   Then User clicks Continue on Select Payment Methods Page
  #   Then User uploads the WNine form and click continue
  #   Then Validate Edit option appears next to Oranization Information
  #   And Validate the Headers for Organization Information.
  #   And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
  #TS_003#TS_010
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #Scenario: Fills the relevant Info with VO Enroll Typ
  #  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #									      |       VO        |
  #   Then User fills all the information  and click on Continue
  #   Then User fills all the information on Identify Administrators page and click continue to W9
  #   Then User uploads the WNine form and click continue
  #   Then Validate Edit option appears next to Oranization Information
  #   And Validate the Headers for Organization Information.
  #	And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
  #TS_013 #TS_015-TS_18
  #@UPASanity
  #Scenario: Fills the relevant Info with AO Enroll Typ
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #	Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
  #Then User uploads the WNine form and click continue
  #Then Validate Edit option appears next to Oranization Information
  #Then User enters new information incorrectly and clicks save button.
  #Then Validate the CANCEL CHANGE button is disabled.
  #TS_011#TS_012 #TS_014
  Scenario: Fills the relevant Info with AO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User clears all the information and clicks save button and validate error messages.

  #TS_019#TS_20
  Scenario: Fills the relevant Info with AO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User enters new information correctly and clicks save button.
    Then Validate User is  redirected to Review and Submit Page and changes are saved.

  ############################# 15. US1248819_EditAdminOnReviewSbmt ###################
  #TS01, TS02, TS04, TS05, TS06,TS07,TS08,TS09,TS10,TS11,TS12,TS17,TS36,TS37
  @UPASanity
  Scenario: Fills the relevent Info with AO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Validate the Headers on Identify Admin Page.
    And Validate the Identify Admin fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
    Then User Check if Mobile number field is mandatory if check box is enabled.
    Then User click on Learn About Alert Frequency Link.
    Then User Clicks Cancel Changes button On Identify Admin Page.

  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS18 and TS19 are commented beacuse AV and VO are currently not in our scope
  #TS18
  #Scenario: Fills the relevent Info with AV Enroll Typ
  #   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AV       |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User fills all the information on Financial Institution Information page and click continue AV
  #    Then User clicks Continue on Select Payment Methods Page
  #    Then User uploads the WNine form and click continue
  #    Then Validate Edit option appears next to Identify Administrators Information
  #    And Validate the Headers on Identify Admin Page.
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS19
  Scenario: Fills the relevent Info with VO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Validate the Headers on Identify Admin Page.

  #TS21-TS29,TS31,TS32,TS33,TS35,TS38-TS46,TS48,TS49,TS50,TS52,TS54
  Scenario: Fills the relevent Info with AO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Fill Administrator Info and Verify error msgs for Primary Contacts.
    And Fill Administrator Info and Verify error msgs for Secondary Contacts.

  #TS53
  Scenario: Fills the relevent Info with AO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And ReFill the Admin Info and verify the saved changes.

  #TS03 UXDS layout verification, not completed as this site is not responding.
  #TS13-16 cannot be done as CLEAR ADMIN INFO button is not present on page.
  #TS30,TS34,TS47,TS51 - alphanumeric data is allowed so their test script needs to be modified.
  ############################# 16. US1248921_CrtEnrlFinInsRevSub ##############################
  @UPASanity
  Scenario: TS_0001_Validate Edit Option next to each field on Review and Submit page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Validates Edit option next to each field on Review and Submit page

  @UPASanity
  Scenario: TS_0002_Validate the navigation upon selection of Edit button next to  Financial Information section on Review and Submit page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page

  #TC_003 and TC_004 covered in US1463317_TS004
  #TC_005 depricated
  Scenario: TS_0006_Validate the data on Financial Information  page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates buttons on Edit Financial Institution Information Page

  Scenario: TS_0007_Validate the navigation upon selection of Cancel changes. -- #Tech error
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Clicks on Cancel Changes button on Financial Institution Page.
    And Validate no changes are saved on Review Submit Page for Financial Institution section.

  Scenario: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Clicks on link Where can i find a financial institution's routing number? and validate the popup message

  Scenario: TS_0009_Validate User is able to update or re-upload enrollment information within the page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    Then User clicks on edit link of Account information section and reupload any other document
    Then User verifies that uploaded document is present on Review and Submit Page on TIN Section

  Scenario: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts  Link
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then User click back button on Review and Submit Page
    And clicks back button on Upload WNine Page.
    And Clicks on link How do i manage multiple NPI bank accounts and validate the popup message

  Scenario: TS_0011_Validate the headers on Financial Information page for AO TIN.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Headers on Financial Information page

  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #	Scenario: TS_0012_Validate the headers on Financial Information page for AV TIN.
  #	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #											|Enrollment Type|
  #											|     AV        |
  #  Then User navigates to Billing service information page and fill all fields and click on continue button
  #  Then User fills all the information on Identify Administrators page and click continue
  #  Then User fills all the information on Financial Institution Information page and click continue to AV
  #  Then User clicks Continue on Select Payment Methods Page
  #  Then User uploads the WNine form and click continue
  #  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  # And User validates fiels are editables on Financial Institution Information page
  #  And Validates Headers on Financial Information page
  #TS_014 015 is covered in US1463317 TS_015
  Scenario: TS_0013/16/17/19/20/21/24/27/30/32_Validate Missing data error message for Financial Institution Information fields.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Missing data Error messages for Financial Institution Fields on click on save changes button

  Scenario: TS_0018/23/29_Validate the error validations upon Entering PO Box in Street Name Field..
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Invalid data Error messages for Financial Institution Fields on click on save changes button

  Scenario: TS_0022/26/28/31/34_Validate Invalid Error Messages for Financial Institution Information Page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button

  Scenario: TS_0025_Validate the error validations upon no data for  Telephone number.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And User give alphanumeric No in Telphone no fiels and click on save changes button

  Scenario: TS_33/35_Upon correcting errors and selecting Save Changes again, updated information is saved and displays on Review and Submit page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button
    And User should navigate to Review and Submit Page upon Entering valid information
    And Validate the changes are reflected on Review and Submit Page.

  Scenario: TS_0036_Validate on edit of different voided check or bank letter, the Cancel Changes button gets disabled.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    And User validates fiels are editables on Financial Institution Information page
    And Validates Cancel button is disabled when click on edit for voided/blank letter document

  #################################################### 17. US1249134_CrtEnrlBSIdetifyEdit  ###########################
  @UPASanity
  Scenario: TS001/TS004_Create Enrollment_BS_Review and Submit - edit Identify Administrators_Edit option
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then User navigates to Organization information page and validate fields are editable

  @UPASanity
  Scenario: TS005_Create Enrollment_BS_Review and Submit - edit Identify Administrators_Cancel and Save Changes
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    And Validates only Cancel and Save Changes options are displayed on  Identify Administrators page

  Scenario: TS006_Create Enrollment_HO_Review and Submit - edit Organization Information_Cancel Changes
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then User clicks on cancel button and return to Review and Submit Page.
    And validates no changes are saved for Identify Admin Section on Review and Submit Page.

  Scenario: TS007_Validate all the headers from the Identify Administrators page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    And Validates all the headers from the Identify Administrators page

  #Scenario: TS002_Validate that Identify Administrators page content matches to UXDS html
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #											|Enrollment Type|
  #											|     BS        |
  #	Then User sets business phone
  #Then User navigates to Billing service information page and fill all fields and click on continue button
  #Then User navigates to Identity Administrators page and fill all fields and click on continue button
  #Then User uploads the WNine form and click continue
  #Then User navigates to ReviewAndSubmit page and click on edit icon
  #And Validates page content matches to UXDS html
  @UPASanity
  Scenario: TS003_Validate that Identify Administrators page text is content managed
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    And Validates page text is content managed

  Scenario: TS008_Validate form and error messaging on click of Save Changes button
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Click on Save changes/Continue button and validate Form and error messages

  Scenario: TS009_Validate Error hyperlink on click of Save Changes
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Click on Save changes/Continue button and Validate Error hyperlinks

  Scenario: TS010_Validate error message Missing Data for both Primary & Secondary Admin fields
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Click on save changes button and Validate Error message for both Primary and Secondary Admin Fields

  Scenario: TS011_Validate error message Invali Data for Telephone Number for both Primary & Secondary Admin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Enter invalid data for Primary Admin and validate error message
    Then Enter invalid data for Secondary Admin and validate error message

  Scenario: TS012/TS013 Validate error message Invali Data for Email and retype email Address for both Primary & Secondary Admin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Enter invalid email  address for Primary and Secondary Admin and validate error message
    Then Enter invalid Retype email address for Primary and Secondary Admin and validate error message

  Scenario: TS014_Validate Text alert indicator for Mobile Number for both Primary & Secondary Admin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Enter mobile number for Primary Admin and validate Text alert checkbox

  Scenario: TS015_Validate Learn about alert frequency for both Primary & Secondary Admin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    Then Click on Learn about alert frquency for both Primary and secondary admin and validate the popup

  Scenario: TS016_Validate upon clicking Save Changes new information is saved and displayed on Review and Submit page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    And Fills new information and click on save changes
    And Validate changes are reflected on Review and Submit Page

  Scenario: TS017_Validate Cancel button disabled functionality in case errors are seen on Identify Admin page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    And Validates Cancel button is disabled in case errors are seen on Identify Admin page

  Scenario: TS018_Validate that the Clear Administrator Information field is hidden when editing the administrator Information.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User navigates to ReviewAndSubmit page and click on edit icon
    And Validates Clear Administrator Information field is hidden when editing the administrator Information

  ############################################18  US1253068_CrtEnrlHORevSub ###########################################################
  @UPASanity
  Scenario: TS01/TS02_Create Enrollment_HO_Review and Submit page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Vaidates Headers in Review and Submit page

  @UPASanity
  Scenario: TS03_Create Enrollment_HO_Review and Submit page_Edit button
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Vaidates Edit Links on Review and Submit page

  Scenario: TS04_Create Enrollment_HO_Review and Submit page_T&C
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Vaidates Terms and condition Pdf download

  Scenario: TS05_Create Enrollment_HO_Review and Submit page_Authorized Enroller
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User validates Authorized Enroller Information fields.

  Scenario: TS06_Create Enrollment_HO_Review and Submit page_T&C_Submit Enabled
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Submit button is enabled when Terms & conditions is clicked

  Scenario: TS07_Create Enrollment_HO_Review and Submit page_Cancel_Back_Submit buttons
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Cancel Enrollment, Back and Submit Enrollment options display

  Scenario: TS08_Create Enrollment_HO_Review and Submit page_Back functionality
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Back button functionality

  Scenario: TS09/TS010/TS011_Create Enrollment_HO_Review and Submit page_Cancel Enrollment Popup
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then Validate Cancel Enrollment popup

  Scenario: TS012/TS013/TS014_Create Enrollment_HO_Review and Submit page_Error Messaging_Hyperlink Display
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Error Messages on Review and Submit Page

  Scenario: TS015-TS020_Create Enrollment_HO_Review and Submit page_Error Messaging_Hyperlink Display
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Invalid Data Error Messages on Review and Submit Page

  Scenario: TS021-TS024_Create Enrollment_HO_Review and Submit page_Error Messaging_Email_No Data
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Invalid Data Error Messages for Email Address on Review and Submit Page

  Scenario: TS25_Create Enrollment_HO_Review and Submit page_Confirm Data
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      #|     VO        |
      | BS              |
    Then User sets business phone
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.

  ############################ 19 US1348624_BS_EnrlType  ############################################################
  #TS01#TS02#TS011
  @UPASanity
  Scenario: Fills the relevent Info with BS Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type as BS
    Then Verify option to Select TIN/SSN is there and input box is present.
    And Verify Change Link is Present for BS.

  #TS04#TS05#TS011
  @UPASanity
  Scenario: Fills the relevent Info with BS Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type as BS
    Then Click Cancel Enrollment button and Verify its functionality.

  #TS06-TS09#TS011
  Scenario: Fills the relevent Info with BS Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type as BS
    Then Enter Incorrect Tin and Verify Error msgs.

  #TS03
  Scenario: Fills the relevent Info with BS Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type as BS
    Then Click Cancel Enrollment button and Verify its content.

  ##################################### 20   US1350550_CrtEnrlBSTinMsgVldtn #######################################
  Scenario: Create Enrollment_BS_Review and Submit
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page and Validate TIN enrolled message
      | Enrollment Type |
      | BS              |

  Scenario Outline: US1350550_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" clicks Continue button and verify enrolledTIN Message and its content from DB

    Examples: 
      | EnrollmentType | TINStatus            |
      | BS             | InactiveUnBlockedTIN |

  Scenario Outline: US1350550_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    #Then Select "<Enrollment Type>" and "<TIN status>" clicks Continue button
    Then Select "<EnrollmentType>" and "<TINStatus>" clicks Continue button and verify enrolledTIN Message and its content from DB
    Then User clicks and validates wNineform link of this page
    Then User validates Cancel Enrollment and Continue button presence
    When User clicks on Cancel Enromment button,verify its popup content and also YES/NO button functionality

    Examples: 
      | EnrollmentType | TINStatus            |
      | BS             | InactiveUnBlockedTIN |

  ######################################### 21 US1351172CrtEnrlAOEmailExist ##########################################################
  Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
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

  Scenario Outline: US1351172_Create Enrollment_AO_duplicate Primary_Email
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then Validate the Headers on Identify Admin Page.
    Then User fills all fields with "<existingEmail>" on Identify Admin page click continue button and validates all the data from DB

    Examples: 
      | existingEmail       |
      | PrimaryAndSecondary |

  ################################################## 22 US1425410_SelectPayMeths ##############################################################
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS01,TS06, TS07, TS08, TS12,TS13
  #Scenario: Fills the relevent Info with AV Enroll Typ
  #   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AV       |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User fills all the information on Financial Institution Information page and click continue AV
  #    Then Validate Select Payment Method Page is context Managed.
  #    And User Validate Header for Select Payment Method Page.
  #    Then User clicks on Terms and Condition link on Select Payment Method Page and clicks on close link.
  #    Then User clicks on which payment information should i choose link and then clicks on close link.
  #    Then User clicks on Back button on Select Payment Method Page and validate user is navigted to FII-Organisation Information Page.
  #TS02
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #Scenario: Fills the relevent Info with AV Enroll Typ
  #   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #									      | Enrollment Type |
  #										      |       AV       |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User fills all the information on Financial Institution Information page and click continue NPI
  #    Then User fills all the information of Financial Institution Information NPI page and click continue for AV.
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS13
  #Scenario: Fills the relevent Info with AV Enroll Typ
  #   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AV       |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User fills all the information on Financial Institution Information page and click continue AV
  #    Then User clicks on Cancel Enrollment button on Select Payment Method Page and clicks on No button on the Pop up.
  #    Then User clicks on Canerl Enrollment button on Select Payment Method Page and clicks on Yes button on the Pop up.
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS13
  #Scenario: Fills the relevent Info with AV Enroll Typ
  #   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AV       |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User fills all the information on Financial Institution Information page and click continue AV
  #    Then User clicks Continue on Select Payment Methods Page
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS03
  Scenario: Fills the relevent Info with VO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9

  #TS04
  @UPASanity
  Scenario: Fills the relevent Info with AO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue

  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS09, TS10, TS11
  #Scenario: Fills the relevent Info with AV Enroll Typ
  #   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AV       |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User fills all the information on Financial Institution Information page and click continue AV
  #		Then User checks the Payer are listed in Alpha Order and verify Payer for AO and AV.
  #TS02- cannot be done as Bank cheque cannot be uploaded.
  #TS05- UXDS site is down
  ############################################## 23 US1463317_CrtEnrlmntRvwSmtNPI ####################################################################
  #TS_001,TS_003
  @UPASanity
  Scenario: TS_0001/003_Validate Edit and Remove option Option next to each field on Review and Submit page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page

  #TS_002 #TS_0034
  @UPASanity
  Scenario: TS_02/09/34_Validate navigation of click Edit button on NPI section and content on Review and Submit page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User clicks Save Changes Button on Financial Institution Information NPI page.
    Then User verifies content of FII-NPI on Review and Submit Page

  #TS_004
  Scenario: TS_0004 Validate Upon selection of Remove the NPI information is deleted and the bank letter or voided check removed.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page remove link and validate it is removed.

  #TS_005 depricated
  #TS_06,07
  @UPASanity
  Scenario: TS_0006/007_Validate the buttons on the page and Navigatin on click of Cancel changes Button.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates the Cancel Changes and Save changes buttons,click on Cancel Changes button

  #TS_08
  Scenario: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User clicks on hyperlink 'where can I find a finantial Institution's routing number?'.

  #TS_10
  @UPAFailure
  Scenario: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts Link
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User click back button on Review and Submit Page
    And clicks back button on Upload WNine Page.
    Then User clicks on hyperlink 'how do i manage multiple NPI bank accounts?'

  #TS_11 is not present
  #TS_12
  Scenario: TS_0012_Validate Headers for AO Enrollment Type
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type

  #TS_13
  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #   Scenario: TS_0013_Validate Headers for AV Enrollment Type
  #
  #   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AV        |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User fills all the information on Financial Institution Information page and click continue NPI
  #		Then User fills all the information of Financial Institution Information NPI page and click continue for AV.
  #    Then User clicks Continue on Select Payment Methods Page
  #    Then User uploads the WNine form and click continue
  #    Then User validateds multiple Edit option on Review and Submit Page
  #    And User clicks on Financial Institution Information NPI page Edit link
  #    And User verifies that FII-NPI fields are editables
  #    Then Validate all the Headers from FII page in case of AO and AV Enrollment type
  #TS_14 Not applicable
  #TS_15_blank
  #TODO
  #@US1463317
  #Scenario: TS_15/17/18/20/21/22/23/28/31/33_Validate the Error message by giving blank input
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #	Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
  #Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
  #Then User uploads the WNine form and click continue
  #Then User validateds multiple Edit option on Review and Submit Page
  #Then User clicks on Financial Institution Information NPI page Edit link
  #And User verifies that FII-NPI fields are editables
  #Then User validates various input field by giving blank input and clicking Save Changes button.
  #TS_NonNumeric  //TODO
  #    #Scenario: TS_16/23/26/32_Validate the Error message by nonnumeric input
  #    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #	Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
  #    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
  #    Then User uploads the WNine form and click continue
  #    Then User validateds multiple Edit option on Review and Submit Page
  #    Then User clicks on Financial Institution Information NPI page Edit link
  #    And User verifies that FII-NPI fields are editables
  #    Then User validates various input field by giving nonnumeric data input and clicking Save Changes button.
  #
  #TS_POBox No in street field  //TODO
  #    #Scenario: TS_19/24/27 Validate the Error message by incomplete/PO BOX no in Street field
  #    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #	Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
  #    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
  #    Then User uploads the WNine form and click continue
  #    Then User validateds multiple Edit option on Review and Submit Page
  #    Then User clicks on Financial Institution Information NPI page Edit link
  #    And User verifies that FII-NPI fields are editables
  #    Then User validates error messages by giving PO BOX No in Street field,Invalid zip/state code,incomplete phoneno and click on Save Change.
  #
  #
  #TS_035A and 035B
  #Scenario: TS_0035A/35B_Disablinb of Cancel Changes button and with valid info changes are in Review and Submit Page.
  #    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       AO        |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #	Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
  #    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
  #    Then User uploads the WNine form and click continue
  #    Then User validateds multiple Edit option on Review and Submit Page
  #    And User clicks on Financial Institution Information NPI page Edit link
  #    And User verifies that FII-NPI fields are editables
  #    Then User fills invalid information on FII NPI page and click Save Changes, an error will be there and Cancel Changes button is disabled
  #    Then User fills valid information on FII NPI page and click Save Changes, an verifies changes on Review Submit Page
  #
  #    #TS_036
  Scenario: TS_0036_Validate on edit of different voided check or bank letter, the Cancel Changes button gets disabled.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User clicks on Edit link to upload doc and validates Cancel button is disabled
    Then User verifies that uploaded document is present on Review and Submit Page

  ######################################### 24 US3025921_3024872_BeforeEnrlmnt_FIITitle #######################################################
  @UPAUS3025921
  Scenario: US3025921_Create Enrollment Before You begin Enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Validates all the UI content with database for BeginEnrollment Page

  @UPAUS3024872
  Scenario: ABA Validator - Financial Institution Page RTN No Title message
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
    Then Users clears the RTN No fill the new RTN No and validate the details and click on Save changes button
    And Validate the changes are reflected on Review and Submit Page.

  ############################################################ 25 US3501234_OnlineEnrollmentPDF ####################################################
  @UPAUS3501234 @UPA2021_PI03_01
  Scenario: UPA Online enrollment PDF for AO tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page

  @UPAUS3501234_VO @UPA2021_PI03_01
  Scenario: UPA Create Enrollment Terms and Conditions pdf for VO tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page

  #Author:Sai
  @UPAUS3563585_AO @UPA2021_PI03_04
  Scenario Outline: Fraud Prevention - Implement scrollbar for Orgname and address suggestions
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User fills "<BussinessName>" and "<streetName>" on organization information page

    Examples: 
      | BussinessName | streetName |
      | MAYO CLINIC   |       1216 |
      | KAISER        |        200 |

  @UPAUS3563585_VO @UPA2021_PI03_04
  Scenario Outline: Fraud Prevention - Implement scrollbar for Orgname and address suggestions
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User fills "<BussinessName>" and "<streetName>" on organization information page

    Examples: 
      | BussinessName | streetName |
      | MAYO CLINIC   |       1216 |
      | KAISER        |        200 |

  ########################################################## VCPEnableCrtEnrlmnt #################################################
  @UPAUS2764491
  Scenario: Fills the relevent Info with VO Enroll Typ
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Validates link Download Virtual Card Payment Enrollment Guide Link  and click on it
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.

  ######################################### US3056650_CrtEnrlRvwSbmtTnc ##########################################################
  @UPAUS3056650_Tnc_AO
  Scenario: UPA Create Enrollment Terms and Conditions pdf for AO tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Vaidates Terms and condition Pdf download

  @UPAUS3056650_Tnc_VO
  Scenario: UPA Create Enrollment Terms and Conditions pdf for VO tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User uploads the WNine form and click continue
    And Vaidates Terms and condition Pdf download

  ################################################# ABAValidatorUPA_NPILevel #########################################################
  @Rahul
  Scenario: ABN Validators Financial Institution Information -NPI Level Validations
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link

  Scenario: ABN Validators Financial Institution Information -NPI Level Error Validations
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No and other information with Incorrect/Improper/Null RTN No on Financial Institution Information NPI page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No

  @NPIfailure
  Scenario: ABN Validators Financial Institution Information -NPI Level ReValidations
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
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

  ######################################## ABAValidatorUPA_OrgLevel #################################################################
  #TS_001,TS_003
  @NPIfailure
  Scenario: Create Enrollment-UPA- RTN API Request/Response- Format Bank Info
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then clicks back button on Upload WNine Page.
    And modify/remove RTN No making as invalid,validations are performed

  Scenario: Create Enrollment-UPA- RTN API Request/Response- Error Messages Validation
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information with Incorrect/Improper/Null RTN No on Financial Institution Information page for ABA Validator
    And All the validations are performed for Incorrect information with editable RTN No

  Scenario: ABN Validators Financial Institution Information -Org Level Error Messages ReValidations
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
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

  Scenario: ABN Validators Financial Institution Information -Org Level Revalidations
    When ABN Validator Switch is set as 'Y'
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
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
