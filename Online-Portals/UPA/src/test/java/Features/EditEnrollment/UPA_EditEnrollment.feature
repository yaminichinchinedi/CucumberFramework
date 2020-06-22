#Author: Priyanka
@UPAEditEnrollment  @UPARegression 		
Feature: UPA Edit Enrollment


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
             #| PROV_Admin        |PROV       |generalPayment30Days|
              |PROV_Gen          |PROV|NPI|

             
     
     
     
     
     
     
     