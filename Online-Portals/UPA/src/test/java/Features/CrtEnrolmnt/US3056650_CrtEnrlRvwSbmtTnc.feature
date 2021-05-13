#Author: Marsha
@TermsAndConditionOnReviewAndSubmit
Feature: UPA Create Enrollment Terms and Conditions pdf on Review and Submit page
    @UPAUS3056650_Tnc_AO
    Scenario: UPA Create Enrollment Terms and Conditions pdf for AO tin
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
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
										      |       VO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User uploads the WNine form and click continue
    And Vaidates Terms and condition Pdf download     
    