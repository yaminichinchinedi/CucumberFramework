#Author: Rahul Krishna
@CreateEnrollment @US1048061 @BothCSRUPAScenarios @UPARegression @UPACreateEnrollment
Feature: Create Enrollment BS Enrollment Type to Identify Administrators page

 Scenario: US1177082_Create Enrollment_BS_Edit Review and Submit 
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And User clicks on  Edit Link of Billing Service Information section of Review and Submit page and validates its content from database
  Then User validate headers of Billing Service Information page
  Then User Validates Save changes and Cancel Changes button presence and its functionality
  
  
  Scenario Outline: US1177082_Create Enrollment_BS_Edit Review and Submit 
  
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  And User clicks on  Edit Link of Billing Service Information section of Review and Submit page and validates its content from database
  Then User fills  information on Edit Billing Service Informatin with "<InputField>" and "<dataFormat>" and validate Error messages	
  Examples:

  										|InputField                     |dataFormat|
										|   BSName, Street, City         |Special Char|
										|   Street                       |Post Box No|
										|	ZipCode                      |Invalid ZipCode|
										|	ZipCode                  	 |Alphanumeric|
										|   BSName, Street, City ,ZipCode|  blank     |
