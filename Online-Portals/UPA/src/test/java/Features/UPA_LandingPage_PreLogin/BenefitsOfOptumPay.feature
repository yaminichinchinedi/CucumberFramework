#Author: Mohammad Khalid
@BenefitsOfOptumPay 
Feature: Verify Benefits of Optum Pay Tab in UPA 



@BenefitsOfOptumPay_US2998969 @BenefitsOfOptumPay_US3033482 
Scenario: Verify text in  Benefits of Optum Pay Tab in UPA 
	Given User navigates to UPA Sys Test application 
	When User Clicks on Benefits Of Optum Pay from the landing page 
	Then User validates Page title 
	And User validates Opening Paragraph Text 
	And User validates Green Tick Paragraph 1 
	And User validates Green Tick Paragraph 2 
	And User validates Green Tick Paragraph 3 
	And User Validates "Access can be restricted" paragraph 
	And User Validates "We are only a call away" paragraph 
	And User validates Footer in the Benefits of Optum Pay page
