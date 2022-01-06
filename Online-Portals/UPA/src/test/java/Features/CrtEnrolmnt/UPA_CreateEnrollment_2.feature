#Author: your.email@your.domain.com
@UPACreateEnrollment @UPACreateEnrollPart2
Feature: UPA Create Enrollment Validations part2
 ####################### 7. US1064240CrtEnrlBSEmailExist #############################
  Scenario: US1064240_Create Enrollment_BS_existing Email entry
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Validates all the headers from the Identify Administrators page
    Then User fills all fields with existing Primary Email on Identify Admin page click continue button and validates all the data from DB
    Then click on Yes to continue with same email address,Click on NO with different email address

  Scenario: US1064240_Create Enrollment_BS_existing Email,Identify Admin Header validation
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Validates all the headers from the Identify Administrators page
    Then User fills all fields with existing Secondary Email on Identify Admin page click continue button
    Then User fills all fields with existing both primary and Secondary Email on Identify Admin page click continue validates all the content from DB

  ############################ 8. US1099702_CrtEnrlBSFooter ############
  @UPASanity
  Scenario: TS01/TS02/TS03_Create Enrollment- Billing Service - Footer Information
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then Validate the Footer Information on this page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Validate the Footer Information on this page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then Validate the Footer Information on this page
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Validate the Footer Information on this page
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then Validate the Footer Information on this page
    Then User uploads the WNine form and click continue
    Then Validate the Footer Information on this page

  ########################### 9. US1177082_CrtEnrlBSEdtRvwSbmt ############################
  Scenario: US1177082_Create Enrollment_BS_Edit Review and Submit
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And User clicks on  Edit Link of Billing Service Information section of Review and Submit page and validates its content from database
    Then User validate headers of Billing Service Information page
    Then User Validates Save changes and Cancel Changes button presence and its functionality

  Scenario Outline: US1177082_Create Enrollment_BS_Edit Review and Submit
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | BS              |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button
    Then User uploads the WNine form and click continue
    And User clicks on  Edit Link of Billing Service Information section of Review and Submit page and validates its content from database
    Then User fills  information on Edit Billing Service Informatin with "<InputField>" and "<dataFormat>" and validate Error messages

    Examples: 
      | InputField                    | dataFormat      |
      | BSName, Street, City          | Special Char    |
      | Street                        | Post Box No     |
      | ZipCode                       | Invalid ZipCode |
      | ZipCode                       | Alphanumeric    |
      | BSName, Street, City ,ZipCode | blank           |

  #######################  10. US1202167_CrtEnrlBeginEnrlmnt #########################
  @TC-19
  Scenario Outline: US1202167_Create Enrollment Which option should i choose link
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then User clicks on which option should i choose link,validates its content and close the opened popup
    Then User validates on Clicking on Change link,beside of Enrollment type
    Then Select "<Enrollment Type>" and verifies popup content,and button fuctionality for Cancel and I Agree button
    Then User clicks on Cancel Enrollment button and verify YES/NO button functionality

    Examples: 
      | Enrollment Type |
      #    | AV              |
      | VO              |

  @TC-20
  Scenario: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page VO enrollment
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
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
    And Validate Data is saved in Database on Enrollment Page.

  @TC-21
  Scenario: Create Enrollment TIN Entry Error Message Validation
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    # Then User Select a How you heard option and  click on Continue button
    Then User clicks on which option should i choose link,validates its content and close the opened popup
    Then User validates on Clicking on Change link,beside of Enrollment type
    Then Select Enrollment Type as Enrollment Type and validates various messgaes by Entering null,less than 9 char,Alphanumeric char,Specia char in TIN
      | Enrollment Type |
      | AO              |
    Then User also validats captcha Error by turning ON and OFF captcha

  ##############################  11. US1247779_IdentifyAdminVldtn ###########################
  @TC-22
  Scenario: US1247779 Identify Admin page content,llinks validations
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User validates the page content of Identify Admin page
    Then User clicks on Learn about alert frequency link validates its content and close it
    Then User clicks on CLEAR ADMINISTRATOR INFORMATION link verify its content and YES/NO functionality
    Then Clicks on Continue to validate all the Error Messages

  @TC-23
  Scenario: US1247779 Identify Admin page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills mobileNo and checks its enabilty/disability of Identify Admin Page
    Then User checks its Back and continue button functionality
    Then User Clicks on Cancel Enrollment,verify its content and YES/NO button functionality

  Scenario Outline: US1247779 Identify Admin page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then user selects as "<EnrollmentType>" and  Clicks continue button of Enrollment TIN Eligible page
    Then User fills all the information  and click on Continue
    Then Validates all the headers from the Identify Administrators page

    Examples: 
      | EnrollmentType |
      | AO             |
      | VO             |

  Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills  primary info. and in Secondary info. enter "<InputField>" and "<dataFormat>" and validate Error messages

    Examples: 
      | InputField                                        | dataFormat            |
      | First Name, Last Name, Email, RetypeEmail, Tel No | blank                 |
      | Tel No                                            | Incomplete,nonNumeric |
      | email                                             | Incorrect             |
      | First Name, Middle Name ,Last Name                | Alphanumeric          |
      | First Name, Middle Name, Last Name                | Special Char          |

  Scenario Outline: US1247779 Identify Admin page Secondary Information Error Message
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills  all data but different email and Retype email for "<InputField>" and validate Error messages

    Examples: 
      | InputField |
      | Primary    |
      | Secondary  |

  Scenario Outline: US1247779 Identify Admin page Primary Information Error Messages
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills  primary information with "<InputField>" and "<dataFormat>" and validate Error messages

    Examples: 
      | InputField                                        | dataFormat            |
      | First Name, Last Name, Email, RetypeEmail, Tel No | blank                 |
      | Tel No                                            | Incomplete,nonNumeric |
      | email                                             | Incorrect             |
      | First Name, Middle Name ,Last Name                | Alphanumeric          |
      | First Name, Middle Name, Last Name                | Special Char          |

  ################ 12. US1247813_CrtEnrlmntFII ######################################################
  #TS_001
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

  #Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
  #TS_002
  #  Scenario: Fills the relevent Info with AV Enroll Typ
  #    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #												   | Enrollment Type |
  #												   | 			AV        |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #TS_003
  #  Scenario: Fills the relevent Info with VO Enroll Typ
  #    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #											      | Enrollment Type |
  #											      |      VO         |
  #    Then User fills all the information  and click on Continue
  #    Then User fills all the information on Identify Administrators page and click continue
  #TS_004
  #Scenario: Checking UI Content matches with UXDS Page
  #  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #									      | Enrollment Type |
  #									      |       AO        |
  #  Then User fills all the information  and click on Continue
  #  Then User fills all the information on Identify Administrators page and click continue
  #TS_005 -- TODO
  @UPASanity
  Scenario: Checking UI Content matches with DB
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then It is Validated that Financial Institution Information page text is content managed

  #TS_006
  Scenario: Clicking FI Routing no
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User clicks the link where can i find a finantial intitution's routing no

  #TS_007
  Scenario: Validates the Type of Account
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates the Type of account as Checking by default and can be change to Saving

  #TS_008
  Scenario: Validates the Supporting doc as Void Check and Bank Letter
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates the supporting document as Voided Check by default and can be change to Bank letter

  #TS_009
  Scenario: Browsing the Supporting docs
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User clicks on browse and upload its supporting document

  #TS_010
  Scenario: Clicking on multiple NRI bank accounts
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User clicks on hyperlink how do i manage multiple NPI bank accounts

  #TS_011
  Scenario: Validates the NPI Bank Account
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates the NPI Bank account as No by default and can be change to Yes

  #TS_012 #TS_013
  Scenario Outline: Validating the Headers content
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then user selects as "<EnrollmentType>" and  Clicks continue button of Enrollment TIN Eligible page
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type

    Examples: 
      | EnrollmentType |
      | AO             |

  # |		 AV			 	|
  #TS_014 #TS_015
  Scenario Outline: Validation of buttons Cancel Enrollment, Back and Continue for AV and AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then user selects as "<EnrollmentType>" and  Clicks continue button of Enrollment TIN Eligible page
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates and clicks buttons Back,Cancel Enrollment,Continue are on the FII page

    Examples: 
      | EnrollmentType |
      | AO             |

  #    |			 AV					|
  # All these test cases has been commented because FII - ABA validator implimentation
  #TS_016 #TS_017 #TS_018
  #
  #Scenario: Validating the Error on click of Continue button of FII page
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #| Enrollment Type |
  #| AO              |
  #Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #Then User clicks on continue button of FII page and validtes the error messages
  #
  #TS_019
  #
  #Scenario: Validating that PO Boxes are not accepted in Street field of FII Page
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #| Enrollment Type |
  #| AO              |
  #Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #Then User fills all the information and PO Box no in Street field and clicks on continue
  #
  #TS_020
  #
  #Scenario: Validating that Invalid Zip Code is not accepted
  #Given User navigates to UPA Sys Test application
  #When User Clicks on Enroll Now from the landing page
  #Then User clicks on Continue button of BeginEnrollment Page
  #Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
  #| Enrollment Type |
  #| AO              |
  #Then User sets business phone
  #Then User fills all the information  and click on Continue
  #Then User fills all the information on Identify Administrators page and click continue
  #Then User fills all the information and invalid Zip code for corresponding City and clicks on continue
  #TS_021
  Scenario: Validating that non accepted file format not uploaded
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
      | Enrollment Type |
      | AO              |
    Then User sets business phone
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information and upload non accepted file format and clicks on continue
    
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
    Then User validates functionality of different buttons like Back,cancel enrollment,Continue(Yes/No on Continue) by clicking on "UPA" portal.

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