#Author: Amit Kushwah

@US1248704
Feature: Create Enrollment - Review and Submit -edit Organization Information

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
    
#TS_001#TS_04#TS_005 #TS_06#TS_07#TS_08

  Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    And Validate the Headers for Organization Information.
    And Validate page is Content Managed.
    And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page. 
    Then User Clicks Cancel Changes button.
    And Validate User is  redirected to Review and Submit Page and No changes are saved.
   
#TS_002#TS__009

 Scenario: Fills the relevent Info with AV Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AV        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue AV
    Then User clicks Continue on Select Payment Methods Page
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    And Validate the Headers for Organization Information.
    And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
#TS_003#TS_010
Scenario: Fills the relevent Info with VO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       VO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    And Validate the Headers for Organization Information.
		And Validate the fields are editable and SAVA CHANGES and CANCEL CHANGES button are present on page.
		
		
#TS_013 #TS_015-TS_18

  Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User enters new information incorrectly and clicks save button.
    Then Validate the CANCEL CHANGE button is disabled.
  
#TS_011#TS_012 #TS_014  
  Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User clears all the information and clicks save button and validate error messages.
   		
#TS_019#TS_20
  Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
    Then User uploads the WNine form and click continue
    Then Validate Edit option appears next to Oranization Information
    Then User enters new information correctly and clicks save button.
    Then Validate User is  redirected to Review and Submit Page and changes are saved.
   		
		
		
		
		