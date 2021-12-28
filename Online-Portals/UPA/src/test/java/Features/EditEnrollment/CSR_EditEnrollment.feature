 @CSRMaintainEnrollment @CSRRegression @CSRUS3498826 @CSR2021_PI02_IP
Feature: Maintain Enrollment 

  # Scenario Outline: Validate VPay payer on payers page within Edit enrollment

  #  Given User navigates to CSR portal and enters "<credentials>" and login
  #  And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	#	Then User clicks on Create/Maintain Enrollment link
	#	Then User Select User Type for "<userType>" and enter tin and click Search
  #  Then User clicks on edit and navigates to Payer page and verify  Payment Method for "<payer>" and "<tinType>"
    
     
#Examples:

	#		|    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	payer |
	#		|   		Super	 	  | 		PROV		|		ActiveTin 	   |		 Premium		|		AO		|	VPay  |
	#		|   		Super	 	  | 		PROV		|		ActiveTin   	 |		 Premium		|		VO		|	VPay  |
	
#Author:Sai

@CSRUS3501237 @CSR2021_PI03_01
Scenario Outline: Online enrollment PDF - Provider Edit 
  Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Create/Maintain Enrollment link
  Then User enters "<userType>" and active "<TIN>" based on "<payMethodCode>" and "<enrollmentStatusCode>"in Create/Maintain Enrollment page and navigate to edit enrollment page.
  Then User Edit organization information 
  Then User Click on Print Enrollment Form 

  Examples:

        |   credentials     |    userType   |  TIN | payMethodCode |   enrollmentStatusCode |
        |      Super        |    PROV       |   AO |      ACH      |          A             | 
        |      Super        |    PROV       |   VO |      ACH      |          A             |  
        |      Super        |    PROV       |   AV |      ACH      |          A             |   
        


@CSRUS4053595
Scenario Outline: Validation of error message when RTN No and AC No are same
  Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Create/Maintain Enrollment link
  Then User enters "<userType>" and active "<TIN>" based on "<payMethodCode>" and "<enrollmentStatusCode>"in Create/Maintain Enrollment page and navigate to edit enrollment page.
  #Then User Edit organization information 
  And  User Clicks Bank Account Tab 
  And Users enters same AC No and RTN No on maintain Enrollment CSR page and validate error message
  
  Examples:

        |   credentials     |    userType   |  TIN | payMethodCode |   enrollmentStatusCode |
        |      Super        |    PROV       |   AO |      ACH      |          A             | 
        
	