#Author: Pranav Kasula
 @CSRMaintainEnrollment @CSRRegression @US2707327
Feature: Maintain Enrollment 

  Scenario Outline: Validate Bank Account(s) page, payers page, Payer PPRAs page within Edit enrollment

    Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Create/Maintain Enrollment link
    Then User enters "<userType>" and active "<TIN>" based on "<payMethodCode>" and "<enrollmentStatusCode>"in Create/Maintain Enrollment page and navigate to edit enrollment page.
    Then User navigates to Payer's page and Change the Payment Method
    
     
Examples:

        |   credentials     |    userType   |  TIN | payMethodCode |   enrollmentStatusCode |
        |      Super        |    PROV       |   AO |      ACH      |          A             |  
        |      Super        |    PROV       |   AO |      NONE     |          A             |  
        |      Super        |    PROV       |   AV |      ACH      |          A             |  
        |      Super        |    PROV       |   AV |      NONE     |          A             |  
        |      Super        |    PROV       |   VO |      ACH      |          A             |  
        |      Super        |    PROV       |   VO |      NONE     |          A             |  
        
        