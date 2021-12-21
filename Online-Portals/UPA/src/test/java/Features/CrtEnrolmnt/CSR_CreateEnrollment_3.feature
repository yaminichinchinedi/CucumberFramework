#Author: your.email@your.domain.com
@tag @CSRCreateEnrollStab @CSRCreateEnrollPart3
Feature: CSR Create Enrollment Validations part3

  ##################################### 10. CSR_US1351172CrtEnrlAOEmailExist   ###############################
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
  @CreateEnrollment @US1463317 @BothCSRUPAScenarios @UPARegression
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
  @CSRUS3501234_AO @CSR2021_PI03_01
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

  @CSRUS3501234_VO @CSR2021_PI03_01
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
  @CSRUS3563585_AO @CSR2021_PI03_04
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

  @CSRUS3563585_VO @CSR2021_PI03_04
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
  @CSRCreateEnrollment @BothCSRUPAScenarios @CSRRegression @US1132023 @CSRSanity
  Scenario: Enrollment Redesign-Surver Response Reporting for CSR
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Common Reports link
    Then User clicks on drop down and verifies Enrollment Survey Results option
    And User select Enrollment Survey Results option and verifies To and From Date fiels are present
    Then User verifies Submit button on the page
    And click on Submit button without any input

  #TC_05,06
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
  @CSRTEST01
  Scenario Outline: Enrollment Redesign-Verify Excel file generation
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Common Reports link
    Then User clicks on drop down and verifies Enrollment Survey Results option
    And User select Enrollment Survey Results option and verifies To and From Date fiels are present
    Then User verifies Submit button on the page
    Then Choose dates "<duration>" from calenders,click submit button,verifies SurveyResponse.xlx files opened

    # Then Verifies all the fields from excel file and database by running query
    Examples: 
      | duration  |
      #| Random    |
      #| 1 Month   |
      | 12 Months |
     # | 13 Months |

  #TC_11
  Scenario: Enrollment Redesign-No data error message generation
    Given User navigates to CSR portal and enters "Super" and login
    Then User clicks on Common Reports link
    Then User clicks on drop down and verifies Enrollment Survey Results option
    And User select Enrollment Survey Results option and verifies To and From Date fiels are present
    Then User verifies Submit button on the page
    Then Choose data dates from calenders,click submit button
    Then If No data fetched then Error message: Your Search Return No Data returned

  ########################### 15 ABAValidatorCSR_NPILevel ####################################################
  @CSRCreateEnrollmentTest
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
  Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and enter unique TIN and click Search
    Then User select NO button of TIN not enrolled page and validate that it is on CSR home page

    Examples: 
      | credentials |
      | Super       |

  Scenario Outline: Create Enrollment-CSR- RTN API Request/Response- Format Bank Info
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Billing Service" and enter unique TIN and click Search
    Then User navigates to TIN not enrolled page and check Return to CSR Welcome page button displayed
    Then clicks on Return to CSR Welcome page button and navigate to CSR Home page

    Examples: 
      | credentials |
      | Super       |

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

  Scenario Outline: Create Enrollment TIN Entry Error Message Validation
    When ABN Validator Switch is set as 'Y'
    Given User navigates to CSR portal and enters "<credentials>" and login
    Then User clicks on Create/Maintain Enrollment link on CSR HomePage
    Then User Select User Type as "Provider" and validates various messgaes by Entering null,less than 9 char,Alphanumeric char,Specia char in TIN

    Examples: 
      | credentials |
      | Super       |
