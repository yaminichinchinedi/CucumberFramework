#Author: Amit Kushwah

@US1425410
Feature: Create Enrollment - Select Payment Methods

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button


#TS01,TS06, TS07, TS08, TS12,TS13

Scenario: Fills the relevent Info with AV Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AV       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue AV
    Then Validate Select Payment Method Page is context Managed.
    And User Validate Header for Select Payment Method Page.
    Then User clicks on Terms and Condition link on Select Payment Method Page and clicks on close link.
    Then User clicks on which payment information should i choose link and then clicks on close link.
    Then User clicks on Back button on Select Payment Method Page and validate user is navigted to FII-Organisation Information Page.

#TS02 

Scenario: Fills the relevent Info with AV Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
									      | Enrollment Type |
										      |       AV       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User fills all the information of Financial Institution Information NPI page and click continue for AV.

#TS13
Scenario: Fills the relevent Info with AV Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AV       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue AV
    Then User clicks on Cancel Enrollment button on Select Payment Method Page and clicks on No button on the Pop up.
    Then User clicks on Canerl Enrollment button on Select Payment Method Page and clicks on Yes button on the Pop up. 
 
#TS13
Scenario: Fills the relevent Info with AV Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AV       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue AV
    Then User clicks Continue on Select Payment Methods Page

#TS03
Scenario: Fills the relevent Info with VO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       VO       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9

#TS04
Scenario: Fills the relevent Info with AO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue
   
#TS09, TS10, TS11

Scenario: Fills the relevent Info with AV Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AV       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue AV
		Then User checks the Payer are listed in Alpha Order and verify Payer for AO and AV.
   
#TS02- cannot be done as Bank cheque cannot be uploaded.
#TS05- UXDS site is down
    