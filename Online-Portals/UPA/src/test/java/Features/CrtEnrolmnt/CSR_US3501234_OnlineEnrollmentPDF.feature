#Author:Sai
Feature: Create Enrollment Terms and Conditons Update Validation.
@CSRUS3501234_AO @CSR2021_PI03_01
Scenario Outline: CSR Create Online enrollment PDF for AO tin
Given User navigates to CSR portal and enters "<credentials>" and login 
Then User clicks on Create/Maintain Enrollment link on CSR HomePage 
Then User Select User Type as "Provider" and enter unique TIN and click Search
Then User select Yes button of TIN not enrolled page
Then User select User Type Enrollment as "AO" and click continue button
Then User sets business phone
Then User fills all the information  and click on Continue
Then User fills all the information on Identify Administrators page and click continue
Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
Then User uploads the WNine form and click continue
And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page. 
And Also click on Print Enrollment page,download PDF and validates all the information from PDF page


Examples: 
	
		|   credentials     |
		|    Super          |
		
@CSRUS3501234_VO @CSR2021_PI03_01
Scenario Outline: CSR Create Online enrollment PDF for VO tin		
  Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Create/Maintain Enrollment link on CSR HomePage
	Then User Select User Type as "Provider" and enter unique TIN and click Search
	Then User select Yes button of TIN not enrolled page
	Then User select User Type Enrollment as "VO" and click continue button
	Then User sets business phone
  Then User fills all the information  and click on Continue
  Then User fills all the information on Identify Administrators page and click continue
  Then User uploads the WNine form and click continue 
  And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page. 
  Then Click on Submit Enrollment button and verify Enrollment Information 
  And Also click on Print Enrollment page,download PDF and validates all the information from PDF page   

	 Examples:

         |   credentials     |
         |    Super          |
         
  #Author:Sai       
  @CSRUS3563585_AO @CSR2021_PI03_04
Scenario Outline: Fraud Prevention - Implement scrollbar for Orgname and address suggestions
Given User navigates to CSR portal and enters "<credentials>" and login 
Then User clicks on Create/Maintain Enrollment link on CSR HomePage 
Then User Select User Type as "Provider" and enter unique TIN and click Search
Then User select Yes button of TIN not enrolled page
Then User select User Type Enrollment as "AO" and click continue button
Then User fills "<BussinessName>" and "<streetName>" on organization information page
 Examples:

         |   credentials |BussinessName|streetName|
         |    Super      |MAYO CLINIC  |1216      |	
         |    Super      |KAISER			 |200       |
         
 @CSRUS3563585_VO @CSR2021_PI03_04   
Scenario Outline: CSR Create Online enrollment PDF for VO tin		
  Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Create/Maintain Enrollment link on CSR HomePage
	Then User Select User Type as "Provider" and enter unique TIN and click Search
	Then User select Yes button of TIN not enrolled page
	Then User select User Type Enrollment as "VO" and click continue button
	Then User fills "<BussinessName>" and "<streetName>" on organization information page
 Examples:

         |   credentials |BussinessName|streetName|
         |    Super      |MAYO CLINIC  |1216      |	
         |    Super      |KAISER			 |200       |	