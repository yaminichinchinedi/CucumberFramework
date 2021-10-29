#Author: your.email@your.domain.com
@UPACreateEnrollment @UPACreateEnrollPart4
Feature: UPA Create Enrollment Validations part4
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

  ########################################################## 26. VCPEnableCrtEnrlmnt #################################################
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

  ######################################### 27. US3056650_CrtEnrlRvwSbmtTnc ##########################################################
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

  ################################################# 28. ABAValidatorUPA_NPILevel #########################################################
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

  ########################################29 ABAValidatorUPA_OrgLevel #################################################################
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
