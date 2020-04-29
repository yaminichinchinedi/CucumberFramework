#Author: Amit Kushwah

@CreateEnrollment @US1248819 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment - Review and Submit -edit Identify Administrator Information

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
#TS01, TS02, TS04, TS05, TS06,TS07,TS08,TS09,TS10,TS11,TS12,TS17,TS36,TS37
@UPASanity
Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
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
#Scenario: Fills the relevent Info with VO Enroll Typ
#   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
#										      | Enrollment Type |
#										      |       VO       |
#    Then User fills all the information  and click on Continue
#    Then User fills all the information on Identify Administrators page and click continue to W9
#    Then User uploads the WNine form and click continue
#    Then Validate Edit option appears next to Identify Administrators Information
#    And Validate the Headers on Identify Admin Page.

#TS21-TS29,TS31,TS32,TS33,TS35,TS38-TS46,TS48,TS49,TS50,TS52,TS54
Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And Fill Administrator Info and Verify error msgs for Primary Contacts.
    And Fill Administrator Info and Verify error msgs for Secondary Contacts.
    
#TS53
Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Identify Administrators Information
    And ReFill the Admin Info and verify the saved changes.

#TS03 UXDS layout verification, not completed as this site is not responding.
#TS13-16 cannot be done as CLEAR ADMIN INFO button is not present on page.
#TS30,TS34,TS47,TS51 - alphanumeric data is allowed so their test script needs to be modified.

