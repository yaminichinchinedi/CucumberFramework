#Author:Rahul Krishna
 @CSRCreateEnrollment @BothCSRUPAScenarios @CSRRegression @US1132023 @UPACreateEnrollment
Feature: Enrollment Redesign-Surver Response Reporting

#TC_01,02,03,04
@CSRSanity
Scenario: Enrollment Redesign-Surver Response Reporting for CSR

Given User navigates to CSR portal and enters "Super" and login
Then User clicks on Common Reports link
Then User clicks on drop down and verifies Enrollment Survey Results option
And User select Enrollment Survey Results option and verifies To and From Date fiels are present 	
Then User verifies Submit button on the page
And click on Submit button without any input

#TC_05,06

Scenario: Enrollment Redesign-Surver Response Reporting for CSR

Given User navigates to CSR portal and enters "Super" and login
Then User clicks on Common Reports link
Then User clicks on drop down and verifies Enrollment Survey Results option
And User select Enrollment Survey Results option and verifies To and From Date fiels are present 	
Then User verifies Submit button on the page
#Then Click on form Button
When Provide from date and To Date greater than  todays date
Then Error Message End Date should not be greater than Todays message should be displayed
When Provide from date  greater than To date
Then Error Message FromDate can not exceed ToDate should be displayed

#TC_07,08,09,10

Scenario Outline: Enrollment Redesign-Verify Excel file generation

Given User navigates to CSR portal and enters "Super" and login
Then User clicks on Common Reports link
Then User clicks on drop down and verifies Enrollment Survey Results option
And User select Enrollment Survey Results option and verifies To and From Date fiels are present 	
Then User verifies Submit button on the page
Then Choose dates "<duration>" from calenders,click submit button,verifies SurveyResponse.xlx files opened
Then Verifies all the fields from excel file and database by running query 

Examples: 
												| duration  |
   											| Random    |
												| 1 Month   |
										  	| 12 Months |
												| 13 Months |
												
#TC_11

Scenario: Enrollment Redesign-No data error message generation

Given User navigates to CSR portal and enters "Super" and login
Then User clicks on Common Reports link
Then User clicks on drop down and verifies Enrollment Survey Results option
And User select Enrollment Survey Results option and verifies To and From Date fiels are present 	
Then User verifies Submit button on the page
Then Choose data dates from calenders,click submit button
Then If No data fetched then Error message: Your Search Return No Data returned
												


 
