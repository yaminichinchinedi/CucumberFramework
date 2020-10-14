#Author: Priyanka
@UPAEditEnrollment  @UPARegression 		
Feature: UPA Edit Enrollment
BACKGROUND


Scenario Outline: TS_0001_UPA_Maintain Enrollment_Edit Enrollment

     Given User navigates to UPA portal and enters "<credentials>" and login
     When  User Selects a tin on HomePage
     And   Clicks on Maintain Enrollment Tab
     Then  Verify Edit Enrollment Page UI for "<credentials>"
     And   Verify Org Info
     And   Verify W9 is downloaded successfully
     And   Verify Bank Account info for "<credentials>"
     And   Verify Voided Check is downloaded successfully for "<credentials>"
   
Examples:
              |credentials        |usertype   |  
              | PROV_Admin        |PROV       |
            #  | PROV_Gen          |PROV       |
            
@UPAEditEnrollmentPriy
Scenario Outline: TS_0002_UPA_Maintain Enrollment_Edit Enrollment_Organization Tab

     Given User navigates to UPA portal and enters "<credentials>" and login
     When  User Selects a tin on HomePage
     And   Clicks on Maintain Enrollment Tab
     And   Clicks on Edit button
     Then  Verify Org,Payer and Bank Account Tabs are displayed
     And   Verify Org Info from DB and UI
     Then  Clicks and verify cancel button functionality 
     And   Clicks on Maintain Enrollment Tab
     And   Clicks on Edit button
     And   Clicks Continue button and verify Payer tab gets Active
     
Examples:
              |credentials        |usertype   |  
              | PROV_Admin        |PROV       |
            #  | PROV_Gen          |PROV       |
            
@UPAEditEnrollment3
Scenario Outline: TS_0003_UPA_Maintain Enrollment_Edit Enrollment_PayersTab

     Given User navigates to UPA portal and enters "<credentials>" and login
     When  User Selects a tin on HomePage
     And   Clicks on Maintain Enrollment Tab
     And   Clicks on Edit button
     And   Clicks Continue button and verify Payer tab gets Active
     Then  Verify Payer Table Data
     
Examples:
              |credentials        |usertype   |  
              | PROV_Admin        |PROV       |
            #  | PROV_Gen          |PROV       |
            
@UPAEditEnr4
Scenario Outline: TS_0004_UPA_Maintain Enrollment_Edit Enrollment_Bank Accounts_TIN Level Banking Information

     Given User navigates to UPA portal and enters "<credentials>" and login
     When  User Selects a tin on HomePage
     And   Clicks on Maintain Enrollment Tab
     And   Clicks on Edit button
     And   Clicks Bank Account Tab  
     Then  Clicks Change Bank Data and fill details
     And   Clicks Continue Bank
     Then  Verify Tin Level Bank Info
     And   Verify Bank Name is updated with new name
     
Examples:
              |credentials        |usertype   |  
              | PROV_Admin        |PROV       |
           # | PROV_Gen          |PROV       |
            
@UPAEditEnr5
Scenario Outline: TS_0005_UPA_Maintain Enrollment_Edit Enrollment_Bank Changes Tab_Payer Level Banking Information

     Given User navigates to UPA portal and enters "<credentials>" and login
     When  User Selects a tin on HomePage for "<searchCriteria>"
     And   Clicks on Maintain Enrollment Tab
     And   Clicks on Edit button
     And   Clicks Bank Account Tab  
     Then  Clicks Change Bank Data and fill details
     And   Clicks Continue Bank
     Then  Verify Payer Level Info
     
Examples:
              |credentials        |usertype     |  searchCriteria|
              | PROV_Admin        |PROV       |NPI|
            # | PROV_Gen          |PROV       |
            
@UPAEditEnr6
Scenario Outline: TS_0006_UPA_Maintain Enrollment_Edit Enrollment_Bank Changes Tab_NPI Level Banking Information

     Given User navigates to UPA portal and enters "<credentials>" and login
     When  User Selects a tin on HomePage for "<searchCriteria>" 
     And   Clicks on Maintain Enrollment Tab
     And   Clicks on Edit button
     And   Clicks Bank Account Tab  
     Then  Clicks Change Bank Data and fill details
     And   Clicks Continue Bank
     Then  Verify NPI Level Info

Examples:
              |credentials        |usertype   |  searchCriteria|
 #            | PROV_Admin        |   PROV    |       NPI      |
              |PROV_Gen           |   PROV    |       NPI      |

             

#Update RTN API switch to ‘Y’ in DB
@UPAEditEnrRTNUserStory
Scenario Outline: RTN API feature
Given User navigates to UPA portal and enters "<credentials>" and login
When  User Selects a tin on HomePage
And   Clicks on Maintain Enrollment Tab
And   Clicks on Edit button
And   Clicks Bank Account Tab  
And   Clicks Change Bank Data and fill details
And   Clicks Continue Bank
Then  Verify at tin level Bank Name, Bank Address, and Phone Number are  greyed out

Examples:
              |credentials        |usertype   |  searchCriteria|
 #            | PROV_Admin        |   PROV    |       NPI      |
              |PROV_Gen           |   PROV    |       NPI      |
              
@UPAEditEnrRTNUserStory123
Scenario Outline: RTN API feature3
Given User navigates to UPA portal and enters "<credentials>" and login
When  User Selects a tin on HomePage
And   Clicks on Maintain Enrollment Tab
And   Changes banking data
And   Adds a new bank account at Payer Level
Then  Verify at Payer level Bank Name, Bank Address, and Phone Number are  greyed out.
And   Verify Message “Financial Institution information will be populated from the Federal Reserve based on the routing number data you provide” is displayed above the Bank Information
When  User updates the bank account at payer level
Then  Verify at Payer level Bank Name, Bank Address, and Phone Number are  greyed out.

Examples:
              |credentials        |usertype   |  searchCriteria|
 #            | PROV_Admin        |   PROV    |       NPI      |
              |PROV_Gen           |   PROV    |       NPI      |
     
@UPAEditEnrRTNUserStory 
Scenario Outline: RTN API feature4
Given User navigates to UPA portal and enters "<credentials>" and login
When  User Selects a tin on HomePage
And   Clicks on Maintain Enrollment Tab
And   Changes banking data
And   Adds a new bank account at NPI Level
Then  Verify at NPI level Bank Name, Bank Address, and Phone Number are  greyed out.

Examples:
              |credentials        |usertype   |  searchCriteria|
 #            | PROV_Admin        |   PROV    |       NPI      |
              |PROV_Gen           |   PROV    |       NPI      |
     
@UPAEditEnrRTNUserStory 
Scenario Outline: RTN API feature5   
Given User navigates to UPA portal and enters "<credentials>" and login
When  User Selects a tin on HomePage
And   Clicks on Maintain Enrollment Tab
And   Changes banking data
And   Leaves the RTN Blank 
Then  Verify Error Message “ Missing data” is displayed.
And   Enters RTN not of 9 digits
Then  Verify Error Message “ Invalid data” is displayed.

Examples:
              |credentials        |usertype   |  searchCriteria|
 #            | PROV_Admin        |   PROV    |       NPI      |
              |PROV_Gen           |   PROV    |       NPI      |
              
              
@UPAEditEnrRTNUserStory 
Scenario Outline: RTN API feature6   
Given User navigates to UPA portal and enters "<credentials>" and login
When  User Selects a tin on HomePage
And   Clicks on Maintain Enrollment Tab
And   Changes banking data
And   Enters Valid RTN 
Then  Verify API request is sent
And   Updates multiple RTNs
Then  Verify API request is sent for each request.

Examples:
              |credentials        |usertype   |  searchCriteria|
 #            | PROV_Admin        |   PROV    |       NPI      |
              |PROV_Gen           |   PROV    |       NPI      |
              

@UPAEditEnrRTNUserStory 
Scenario Outline: RTN API feature7
Given User navigates to UPA portal and enters "<credentials>" and login
When  User Selects a tin on HomePage
And   Clicks on Maintain Enrollment Tab
And   Changes banking data
And   Enters Valid RTN
Then  Verify API response is valid

Examples:
              |credentials        |usertype   |  searchCriteria|
 #            | PROV_Admin        |   PROV    |       NPI      |
              |PROV_Gen           |   PROV    |       NPI      |



@UPAUS2705920
Scenario Outline: Optum Pay Rebranding
Given User navigates to UPA portal and enters "<credentials>" and login
When  User Selects a tin on HomePage
And   Clicks on Maintain Enrollment Tab
Then User clicks on Payer Information Tab and validates Optum Pay text insted of EPS
Then Click on Edit button and then Organisation Tab,Enter special charater,click on Continue and validates Optum Pay text insted of EPS
Then Click on Edit button and then Payers Tab and validates Optum Pay text insted of EPS
Then User clicks on Cancel button and validates Optum Pay text insted of EPS
Then User clicks on Finish and Submit button and validates Optum Pay text insted of EPS
Then User clicks of Print Enrollment Form,a PDF file is downloaded and verify Optum Pay Text instead of EPS

Examples:
            |  credentials     |
            |   PROV_Admin     |      



@UPAUS2705920P2
Scenario Outline: Optum Pay Rebranding for BS
    Given User navigates to UPA portal and enters "<userType>" and login
    Then Select the TIN for "<accessType>" UPA Portal
And   Clicks on Maintain Enrollment Tab
Then User clicks on Edit button,Enter special charater in Org Name then click on Finish button and validates Optum Pay text insted of EPS
Then User clicks on Edit button then Cancel button and validates Optum Pay text insted of EPS
Then User clicks on Finish and Submit button and validates Optum Pay text insted of EPS for Billing Service
Then User clicks of Print Enrollment Form,a PDF file is downloaded and verify Optum Pay Text instead of EPS in Billing Service
Examples:
      |    userType     |   accessType  |
      |      BS_Admin   |   BS     	| 



     
     
     
     