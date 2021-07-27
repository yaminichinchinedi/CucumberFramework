#Author: Marsha(Stabilisation)
@UPALandingPage  @UPARegression
Feature: UPA Landing Page Pre-Login functionality
	#Author:MohammadKhalid
	@UPABenefitsOfOptumPay_US2998969 @UPABenefitsOfOptumPay_US3033482 
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
	
		#Author: Rashi Hooda		
	  @UPAUS2882813_1 @UPARegression
	  Scenario: Test Cases for How to Enroll Page in UPA
	  Given User navigates to UPA Sys Test application
	  Then user navigates to how to enroll tab
	  Then User validates logo, Title, Enroll Now button,PDFs and Footer of this page
	  And User also validates the How to Enroll page content
	  
 @UPAUS3415252_PreLogin
Scenario: Test the PDF Cancellation Form on Pre Login Screen
	  Given User navigates to UPA Sys Test application
	  Then user navigates to resources tab
	  Then user clicks on the cancellation link and verifies the url
	  Then user validates cancellation pdf form content
