#Author: Rahul Krishna

@CreateEnrollment @US1048061 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment BS Enrollment Type to Identify Administrators page

 Scenario: US1177082_Create Enrollment_BS_Edit Review and Submit 
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And User clicks on  Edit Link of Billing Service Information section of Review and Submit page and validates its content from database
  Then User validate headers of this page
  Then User Validates Save changes and Cancel Changes button presence and its functionality
  
  
  Scenario Outline: US1177082_Create Enrollment_BS_Edit Review and Submit 
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And User clicks on  Edit Link of Billing Service Information section of Review and Submit page
  Then User fills  information with "<Inpput field>" and "<dataFormat>" and validate Error messages	

  										|Input Field |dataFormat|
											|   BSName   |blank|
											|   Street   |blank|
											|		City  	 |blank|
											|		ZipCode  |blank|
											|   BSName   |Special Char|
											|   Street   |Special Char|
											|   Street   |Post Box No|
											|		City  	 |Special Char|
											|		ZipCode  |Invalid ZipCode|
											|		ZipCode	 |Alphanumeric|
										