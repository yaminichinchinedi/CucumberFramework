#Author: Vinay R
@UPABSInfo  
Feature: UPA Billing Service Information Functionality 

  @PageTextUS3179215 
  Scenario Outline: UPA Billing Service Information Header Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then User clicks on Billing Service Information tab
    Then Verify Billing Service Header Text
    Examples:
      | credentials | userType |
      | BS_Admin    | BS       |
#Author:Sayonee
      @UPAUS2820687
   Scenario Outline: UPA Porvider Billing Service Information Page Text Verification
      Given User navigates to UPA portal and enters "<credential>" and login
       And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
      Then User clicks on Billing Service Information tab
       Then User verifies the page text for provider based on the "<tinType>" and "<portalAccess>"
   Examples:
       |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
       |   PROV_Admin    |     PROV     	|		 	PostTrial and Paid		|			Premium			|		VO			|
       |   PROV_Admin    |     PROV     	|		 	PostTrial and Paid		|			Premium			|		AO			|
       |   PROV_Admin    |     PROV     	|		 	PostTrial and NotPaid		|			Standard			|		AO			|
      