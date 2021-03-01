@UPAUS2764491
 Feature: VCP unhide option
  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Validates link Download Virtual Card Payment Enrollment Guide Link  and click on it
    Then User clicks on Continue button of BeginEnrollment Page
Scenario: Fills the relevent Info with VO Enroll Typ
   Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       VO       |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
