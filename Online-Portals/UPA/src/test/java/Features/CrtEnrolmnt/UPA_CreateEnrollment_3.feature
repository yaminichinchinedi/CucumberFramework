#Author: your.email@your.domain.com
@UPACreateEnrollment @UPACreateEnrollPart3
Feature: UPA Create Enrollment Validations part3

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

 
