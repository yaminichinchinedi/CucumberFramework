#Author: your.email@your.domain.com
@UPACreateEnrollment @UPACreateEnrollPart1
Feature: UPA Create Enrollment Validations part1
###########################  Create Enrollment Home Page Validations   ##############################
Scenario: Test Cases for Home pages
    Given User navigates to UPA Sys Test application
    Then User validates that Enroll Now and Benefits of Optum pay button are there
    Then User validates all headers links Benefits of Optum Pay,How to Enroll,Optum Finantial Logo
    Then User clicks on Alternative payments routing options and validates the navigation
  Scenario: Test Cases for How to Enroll
    Given User navigates to UPA Sys Test application
    When User Clicks on How to Enroll link section of homepage
    Then User validates Enroll Now button,PDFs for AO,BS and VO,and Footer of this page
    Then User also validates the How to Enroll page content with database
    Then User Clicks on Enroll Now button and navigates to BeginEnrollment Page

  Scenario: Test Cases for FAQS section
    Given User navigates to UPA Sys Test application
    When User clicks on Resources section of homepage
    Then User validates Guides and Forms and Documents section
    Then Validate the Footer Information on this page

  #   Scenario: US1348562/US1348529_Test Cases for Begin your Enrollment page
  #   Given User navigates to UPA Sys Test application
  #    Then User Clicks on Enroll Now from the landing page and verify page content from databse
  #    Then User also verify survey questions and answer from Survery table
  #    Then user clicks on continue button without any entry and validates error message
  #    Then select Other option from of how you heard option,click continue and validate error message
  #    Then User also checks for the entered text limit is 50
  #    When User clicks on Cancel Enrollment button a popup appears verify its content
  #    Then User clicks on Yes to cancel the Enrollment and No to continue the Enrollment
  #    Then User is able to download the Enrollment PDFs
  #    Then Select any how you heard option and click continue to validte the BeginEnrollmentContinue page navigation
  #
  @UPAFailure
  Scenario Outline: US1048015_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" clicks Continue button and vaidate enrolledTIN Message and its content from DB

    Examples: 
      | EnrollmentType | TINStatus           |
      | BS             | PreEnrolledBSTIN    |
      | BS             | EnrolledActiveBSTIN |


  #1 ###########################  US1023501_US1350108_PreEnrolledTIN   ##############################
  @TC-1
  Scenario Outline: US1023501_Test Cases for PreEnrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" Clicks continue button of Enrollment TIN Eligible page and vaidate enrolledTINMsg

    Examples: 
      | EnrollmentType | TINStatus                          |
      | AO             | EnrolledPreEnrollmentStatusTIN     |
      | AO             | AutoEnrolledPreEnrollmentStatusTIN |
      | AO             | EnrolledInactiveAndBlockStatusTIN  |
      | AO             | EnrolledActiveStatusTIN            |

  @TC-2
  Scenario Outline: US1350108_Test Cases for PreEnrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" Clicks continue button of Enrollment TIN Eligible page and vaidate enrolledTINMsg

    Examples: 
      | EnrollmentType | TINStatus            |
      | AO             | TINNotEnrolled       |
      | AO             | InactiveUnBlockedTIN |
      | VO             | TINNotEnrolled       |

  @TC-3
  Scenario Outline: US1350108_Test Cases for Not Enrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>",Clicks Cancel Enrollment verify text content,the click NO to be on the same page and Yes to Cancel the Enrollment

    Examples: 
      | EnrollmentType | TINStatus      |
      | AO             | TINNotEnrolled |

  @TC-4
  Scenario Outline: US1350108_Test Cases for Not Enrolled Tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" then Clicks continue then,clicks on W9 form link on next page

    Examples: 
      | EnrollmentType | TINStatus      |
      | AO             | TINNotEnrolled |

  #2 ####################### US1033480_CrtEnrlFooter ##################################
  @TC-5
  Scenario: US1033480_Create Enrollment- AO - Footer Information
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then Validate the Footer Information on this page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Validate the Footer Information on this page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then Validate the Footer Information on this page
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then Validate the Footer Information on this page
    Then User fills all the information on Identify Administrators page and click continue
    Then Validate the Footer Information on this page
    #Need to check ABA Validator or Normal flow
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then Validate the Footer Information on this page
    Then User uploads the WNine form and click continue
    Then Validate the Footer Information on this page
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    Then Validate the Footer Information on this page

  @TC-6
  Scenario: US1033480_Create Enrollment- BS - Footer Information
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Validate the Footer Information on this page
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then Validate the Footer Information on this page
    Then User uploads the WNine form and click continue
    Then Validate the Footer Information on this page

  #3 ########################## US1033910_35_US1048192_99_CrtEnrlSubmtd #########################
  @TC-7 @UPAUS3610262 @UPA2021_PI02_IP
  Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    #Need to check ABA Validator or Normal flow
    #Then User fills all the information on Financial Institution Information page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.
    And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
    And Click on ACH Addendum link verify popup functionality and close the link
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
    And Click on Exit Enrollment button navigates to the Optum Pay landing page

    Examples: 
      | credentials |
      | Super       |

  @TC-8 @UPAUS3610262
  Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page VO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Validates link Download Virtual Card Payment Enrollment Guide Link  and click on it
    Then User clicks on Continue button of BeginEnrollment Page
    Then User clicks on which option should i choose link and close the opened popup
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
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
      | credentials |
      | Super       |

  Scenario: US1033935 Create Enrollment AO Enrollment Submitted page
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
    #Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    #Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    #Then User fills all the information on Financial Institution Information page and click continue NPI
    #Then User fills all the information of Financial Institution Information NPI page and click continue.
    #Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    Then Click on Submit Enrollment button and verify Enrollment Information
    Then Also click on Print Enrollment form link download PDF and verify PDF data

  # @TC-10
  #    Scenario: US1033935 Create Enrollment VO Enrollment Submitted Page
  #    Given User navigates to UPA Sys Test application
  #    When User Clicks on Enroll Now from the landing page
  #    Then User Select a How you heard option and  click on Continue button
  #    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #										      | Enrollment Type |
  #										      |       VO        |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #    Then User uploads the WNine form and click continue
  #    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
  #    Then Click on Submit Enrollment button and verify Enrollment Information
  #    Then Also click on Print Enrollment form link download PDF and verify PDF data
  @TC-11
  Scenario: US1048192/US1048199-Create Enrollment_BS Enrollment Submitted Page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.
    And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page

  #Author: Shalini Mahavratayajula
  @UPAUS3610262_Negative @TC-12
  Scenario Outline: US3610262 Provider navigates to UPA Application to validate error scenario for "BusinessPhone" in organization Information page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets invalid business phone "<invalidBusinessPhone>"
    Then User fills all the information  and click on Continue
    Then User validate error messages

    Examples: 
      | credentials | tinType | invalidBusinessPhone |
      | Super       | AO      | AlphaNumericString   |
      | Super       | VO      | SpecialCharacters    |

  #Author: Shalini Mahavratayajula
  @UPAUS2952537AO @TC-13
  Scenario Outline: UPAUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then User clicks on which option should i choose link and close the opened popup
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | checkAutoPopulate |
      | Super       | busNameYAndAddrY  |
      | Super       | busNameYAndAddrN  |
      | Super       | busNameNAndAddrY  |
      | Super       | busNameNAndAddrN  |

  #Author: Shalini Mahavratayajula
  #Author: Shalini Mahavratayajula
  @UPAUS2952537VO @TC-14
  Scenario Outline: UPAUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators VO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then User clicks on which option should i choose link and close the opened popup
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | checkAutoPopulate |
      | Super       | busNameYAndAddrY  |
      | Super       | busNameYAndAddrN  |
      | Super       | busNameNAndAddrY  |
      | Super       | busNameNAndAddrN  |

  #Author: Piyush Bagdiya
  @CSRUS2952532 @CSRUS3725611 @FraudPBB @TC-15
  Scenario Outline: UPAUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then User clicks on which option should i choose link and close the opened popup
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | checkAutoPopulate |
      | Super       | busNameYAndAddrY  |
      | Super       | busNameYAndAddrN  |
      | Super       | busNameNAndAddrY  |
      | Super       | busNameNAndAddrN  |

  #Author: Piyush Bagdiya
  @CSRUS2952532 @CSRUS3725611 @FraudPBB @TC-16
  Scenario Outline: UPAUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators VO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then User clicks on which option should i choose link and close the opened popup
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | VO              |
    Then User sets business phone
    Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue

    Examples: 
      | credentials | checkAutoPopulate |
      | Super       | busNameYAndAddrY  |
      | Super       | busNameYAndAddrN  |
      | Super       | busNameNAndAddrY  |
      | Super       | busNameNAndAddrN  |

  ##################### 4.  US1048061_CrtEnrlBSIdtfyAdmn    #######################################
  #TS_001
  @UPASanity
  Scenario: TS_00001_Upon selection of Continue from the TIN eligibility status page, user navigates to the Organization Information page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button

  #TS_003
  @UPASanity
  Scenario: TS_00003_Page text is content managed
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Validates page text is content managed

  ##TS_004 #TS_005
  Scenario: TS_00004_Secondary administrator is not mandatory and TS_00005_Mobile Phone Number field is not required.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button

  #TS_006
  Scenario: TS_00006_Text Alert indicator to get enabled on entering 10 digits of mobile number.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User Check if Mobile number field is mandatory if check box is enabled.

  #TS_007 #TS_008
  Scenario: TS_00007_The alert frequency link will display a popup box.Text matches to wireframe and
            TS_00008_The  Learn about alert frequency , a popup box gets closed with close tip option.

    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Click on Learn about alert frquency for both Primary and secondary admin and validate the popup

  #TS_009
  Scenario: TS_00009_The Clear Administrator Information click will ask user if  they want to remove entered Administrator Information. Yes and No options display.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User clicks on hyperlink CLEAR ADMINISTRATOR INFORMATION

  #TS_010
  Scenario: TS_00010_Header displays -Billing Service Information (in unbold orange),  Rest headers (all in gray).
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And Validate the Headers on Identify Admin Page.

  #TS_011 #TS_012
  Scenario: TS_00011_To Validate Cancel Enrollment, Back  and Continue options display and TS_00012_To Validate back button , user navigates to the Billing service Information Page.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And User validates Cancel Enrollment, Back and Continue options is displayed at the bottom of the Identify Administrators Page.
    Then User Clicks on Back button and navigates to Billing Service Information Page.

  #TS_013 #TS_014 #TS_015
  Scenario: TS_00013_To Validate Cancel Enrollment and Continue options display.Validation of Yes/No buton
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And User Clicks on Cancel button and a popup appears with Are you sure you want to cancel your Optum Pay enrollment application? with Yes and No
    When User Clicks on No button and user is back to Organization Information page.
    When User Clicks on Yes button and user is on Optum Pay landing page.

  #TS_016 #TS_017 #TS_018 #TS_019
  Scenario: TS_00016_ Upon selection of Continue,validation is performed.
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And Click on Save changes/Continue button and validate Form and error messages
    Then Click on Save changes/Continue button and Validate Error hyperlinks

  #TS_020 #TS_021  #TS_022 #TS_024  #TS_026 #TS_028  #TS_029 #TS_030 #TS_032
  Scenario: Validation of different input fiels for Primary/Secondary Contacts
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And Fill Administrator Info and Verify error msgs for Primary Contacts.
    And Fill Administrator Info and Verify error msgs for Secondary Contacts.

  #TS_023 #TS_031 #TS_025 #TS_033 #TS_034
  Scenario Outline: Validation of incorrect/improper input for different provider
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill  details for "<Provider Type>" with incorrect/improper "<InputField>" and click on continue button

    Examples: 
      | Provider Type | InputField    |
      | Secondary     | Telephone No  |
      | Secondary     | Email Address |
      | Primary       | Telephone No  |
      | Primary       | Email Address |

  #TS_027 #TS_035
  Scenario Outline: Validation for unmatching of Email and Confirm email fiels for different provider type
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all  details  for "<Provider Type>" details with not matching Email and Retype Email and click on continue button

    Examples: 
      | Provider Type |
      | Secondary     |
      | Primary       |

  ############################# 5. US1048076_CrtEnrlBSw9 ############################
  @TC-17
  Scenario: US1048076_Create Enrollment_BS_upload w9 validations
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User navigates to Upload w9 page and validate its headers

  @TC-18
  Scenario: US1048076_Create Enrollment_BS_upload w9 validations
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User Validates Back,Cancel Enrollment and Continue button presence and its functionality on upload w9 page
    When User clicks on back button it navigates to Identify Admin Page
    Then User click on Cancel Enrollment verifies its popup content and YES/NO button functionality
    Then User clicks on link Federal W9 Form here,validates its content

  ############################# 6. US1048094_CrtEnrlBSRevSubmit ############################
  @UPASanity
  Scenario: TS01/TS02_Create Enrollment_BS_Review and Submit page_Header
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Vaidates Headers in Review and Submit page

  @UPASanity
  Scenario: TS03_Create Enrollment_BS_Review and Submit page_Edit button
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Vaidates Edit Links on Review and Submit page

  Scenario: TS04_Create Enrollment_BS_Review and Submit page_T&C
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Vaidates Terms and condition Pdf download

  Scenario: TS05_Create Enrollment_BS_Review and Submit page_Authorized Enroller
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then User validates Authorized Enroller Information fields.

  Scenario: TS06_Create Enrollment_BS_Review and Submit page_T&C_Submit Enabled
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Submit button is enabled when Terms & conditions is clicked

  Scenario: TS07_Create Enrollment_BS_Review and Submit page_Cancel_Back_Submit buttons
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Cancel Enrollment, Back and Submit Enrollment options display

  Scenario: TS08_Create Enrollment_BS_Review and Submit page_Back functionality
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Back button functionality

  Scenario: TS09/TS010/TS011_Create Enrollment_BS_Review and Submit page_Cancel Enrollment Popup
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    Then Validate Cancel Enrollment popup

  Scenario: TS25_Create Enrollment_BS_Review and Submit page_Confirm Data
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    #And Validates the Data saved in Database on submit of Enrollment
    Then Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.

  Scenario: TS012/TS013/TS014_Create Enrollment_BS_Review and Submit page_Error Messaging_Hyperlink Display
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Error Messages on Review and Submit Page

  Scenario: TS015-TS020_Create Enrollment_BS_Review and Submit page_Error Messaging_First Name_Last Name_Telephone_No Data
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Invalid Data Error Messages on Review and Submit Page

  Scenario: TS021-TS024_Create Enrollment_BS_Review and Submit page_Error Messaging_Email_Invalid Data
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And Validates Invalid Data Error Messages for Email Address on Review and Submit Page
