#Author: sai
Feature: UPA Maintain Enrollment
@UPAUS3601470 @UPA2021_PI03_02 @UPAUS3694216
Scenario Outline: Sunset AV - Provider Payment Method Update Email
 Given User navigates to UPA portal and enters "<credentials>" and login
 And  Clicks on Maintain Enrollment Tab
 And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
 And User clicks on Edit button
 And Clicks on Payers tab
 Then Change payment method preferences "<tinType>" 

 Examples:
      | credentials | userType | portalAccess | tinType | searchCriteria       |
      | PROV_Admin  | PROV     | Premium      | AO      | PremiumOrStandardTIN |
      | PROV_Admin  | PROV     | Premium      | VO      | PremiumOrStandardTIN |