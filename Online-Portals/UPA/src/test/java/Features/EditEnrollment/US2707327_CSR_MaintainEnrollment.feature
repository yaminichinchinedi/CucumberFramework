#Author: Pranav Kasula
 @CSRMaintainEnrollment @CSRRegression @US2707327
Feature: Maintain Enrollment 

  Scenario Outline: Validate Bank Account(s) page, payers page, Payer PPRAs page within Edit enrollment

    Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Create/Maintain Enrollment link
    Then User enters "<userType>" and active TIN in Create/Maintain Enrollment page and navigate to edit enrollment page.
    Then User clicks on Bank Account(s) tab and verify Payer/Patient banking level header, Select Payer/Patient Dropdown title, Select Payer/Patient Dropdown displays 'Patient Payment', Header on Banking Information table display Payer/Patient.    
    Then User navigates to Payer's page and verify Payers page display Patient Payment
    Then User navigates to Payer PPRAs page and verify Patient Payment under Payer Name
    
     
Examples:

        |   credentials     |    userType   |  
        |      Super        |    PROV       |
