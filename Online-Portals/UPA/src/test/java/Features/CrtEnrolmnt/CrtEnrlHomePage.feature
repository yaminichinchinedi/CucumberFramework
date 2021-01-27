#Author: Rahul Krishna
Feature: Create Enrollment Home Page Validations 

 
  Scenario: Test Cases for Home pages
   Given User navigates to UPA Sys Test application
   Then User validates that Enroll Now and Benefits of Optum pay button are there
   Then User validates all heades links Benefits of Optum Pay,How to Enroll,FAQ,Optum Finantial Logo 
   Then User clicks on Alternative payments routing options and validates the navigation 
   Then User validtes page content and footer content with database
 
  Scenario: Test Cases for How to Enroll
   Given User navigates to UPA Sys Test application
   When User Clicks on How to Enroll link section of homepage
   Then User validates Enroll Now button,PDFs for AO,BS and VO,and Footer of this page
   Then User also validates the How to Enroll page content with database
   Then User Clicks on Enroll Now button and navigates to BeginEnrollment Page
   

 Scenario: Test Cases for FAQS section
   Given User navigates to UPA Sys Test application
   When User clicks on FAQS section of homepage
   Then User validtes various question headers like Optum Pay,Administrative,Billing Service,Virtual Card Payments,NPI Questions
   Then User clicks on various questions and perform validation from database
   And  also validates footer of this page 

  
#   Scenario: US1348562/US1348529_Test Cases for Begin your Enrollment page
#   Given User navigates to UPA Sys Test application
#    Then User Clicks on Enroll Now from the landing page and verify page content from databse
#    Then User also verify survey questions and answer from Survery table
#    Then user clicks on continue button without any entry and validates error message
#    Then select Other option from of how you heard option,click continue and validate error message
#    Then User also checks for the entered text limit is 50
#    When User clicks on Cancel Enrollment button a popup appears verify its content
#    Then User clicks on Yes to cancel the Enrollment and No to continue the Enrollment
#    Then User is able to download the Enrollment PDFs
#    Then Select any how you heard option and click continue to validte the BeginEnrollmentContinue page navigation   
#    

										      
	Scenario Outline: US1351123_US1048048_Create Enrollment Provider flow validations
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<Enrollment Type>" and  Clicks continue button of Enrollment TIN Eligible page								     
	Then User verifies page content from database				
	Then Error Message when entering special character in business name and address
	Then validates Headers display for selected Enrollment type
	Then Cancel Enrollment,Back and Continue button  options displays on the page
	Then click on cancel Enrollment,validates its content and click Yes to stop the enrollment flow,No to continue the flow
	Then click continue without and entry and validate the error messages
	Examples:
										| EnrollmentType |
										|     AO         |
										|	  BS	     |	
		
 
 
  	Scenario Outline: US1048015_Test Cases for BS Tins
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    Then Select "<EnrollmentType>" and "<TINStatus>" clicks Continue button and vaidate enrolledTIN Message and its content from DB
    Examples: 
										      | EnrollmentType  |						TINStatus		  |
										      |       BS        | 				PreEnrolledBSTIN		  |
										      |       BS        | 				EnrolledActiveBSTIN		  |
										    
										      
										      
	
	  

  
  
 
  
  
   