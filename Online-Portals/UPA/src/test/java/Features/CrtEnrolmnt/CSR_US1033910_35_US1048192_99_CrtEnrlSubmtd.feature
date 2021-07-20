
#Author: Rahul Krishna
Feature:Create Enrollment Home Page Validations 

@CSRUS3610262 @CSR2021_PI02_IP

 Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
   
   	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "<userType>" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "<tinType>" and click continue button
		Then User sets business phone
		Then User fills all the information  and click on Continue	
		Then User fills all the information on Identify Administrators page and click continue
		#Need to check ABA Validator or Normal flow
		When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    And Validate Data is saved in Database on Enrollment Page.
    And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
    And Click on ACH Addendum link verify popup functionality and close the link 
   And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
    And Click on Exit Enrollment button navigates to the Optum Pay landing page 
   
   Examples:

          |   credentials     |  tinType   |userType| 
          |    Super          |	AO		  	 | PROV   |
                	
										      
		
		@CSRUS3610262		@CSR2021_PI02_IP			      
		Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page VO enrollment
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "<userType>" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "<tinType>" and click continue button 
		Then User sets business phone
		Then User fills all the information  and click on Continue	
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    And Validate Data is saved in Database on Enrollment Page.
    And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
  	And Click on ACH Addendum link verify popup functionality and close the link 
   	And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
    And Click on Exit Enrollment button navigates to the Optum Pay landing page 
    		Examples:

          |   credentials   |  tinType   |userType| 
        	|    Super        |	VO		  	 | PROV 	|
   
         	
       				
		
		 Scenario Outline: US1033935 Create Enrollment AO Enrollment Submitted page
		When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
  	Then User select User Type Enrollment as "AO" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.								      
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    Then Click on Submit Enrollment button and verify Enrollment Information 
    Then Also click on Print Enrollment form link download PDF and verify PDF data 
     Examples:

         |   credentials     |
         |    Super          |
   
    Scenario Outline: US1033935 Create Enrollment VO Enrollment Submitted Page
    
	Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "VO" and click continue button
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    Then Click on Submit Enrollment button and verify Enrollment Information 
    Then Also click on Print Enrollment form link download PDF and verify PDF data     			      				
	
	 Examples:

         |   credentials     |
         |    Super          |
	
       @CSRUS3143570
    Scenario Outline: Create Enrollment Enrollment Submitted
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "VO" and click continue button 
		Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    #And Validate Data is saved in Database on Enrollment Page.
    And Validate one corresponding row is inserted in Product Selection Table
    
    		Examples:

         |   credentials     |
         |    Super          |
         
   
   
  #Author: Shalini Mahavratayajula
   @CSRUS3610262_Negative

 Scenario Outline: US3610262 Provider Login to CSR Application to validate error scenario for "BusinessPhone" in organization Information page.
   
   	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "<userType>" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "<tinType>" and click continue button 
		Then User sets invalid business phone "<invalidBusinessPhone>"
		Then User fills all the information  and click on Continue	
		Then User validate error messages
		
   
    Examples:

          |   credentials     |  tinType   |userType|   invalidBusinessPhone |    	
        	|    Super          |	AO		  	 | PROV   |    AlphaNumericString  |
        	|    Super          |	VO		  	 | PROV   |    SpecialCharacters   |
        	
          	
        	      
@CSRUS2952537AO
	Scenario Outline: CSRUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators AO enrollment
   
   	When ABN Validator Switch is updated to 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "<userType>" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "<tinType>" and click continue button
		Then User sets business phone
		Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue	
		Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    And Validate OrgInfo Indicators are saved in Database on Enrollment Page
   
   Examples:

          |   credentials     |  tinType   |userType| checkAutoPopulate|
          |    Super          |	AO		  	 | PROV   |busNameYAndAddrY |
          |    Super          |	AO		  	 | PROV   |busNameYAndAddrN |
          |    Super          |	AO		  	 | PROV   |busNameNAndAddrY |
          |    Super          |	AO		  	 | PROV   |busNameNAndAddrN |
      
          
 	
 	@CSRUS2952537VO			      
	Scenario Outline: CSRUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators VO enrollment
	
		When ABN Validator Switch is updated to 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "<userType>" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "<tinType>" and click continue button 
		Then User sets business phone
		Then User fills the auto populated information for BusinessNameAddress "<checkAutoPopulate>" and click on Continue	
    Then User fills all the information on Identify Administrators page and click continue to W9
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    And Validate OrgInfo Indicators are saved in Database on Enrollment Page
 
    Examples:

          |   credentials     |  tinType   |userType| checkAutoPopulate|
          |    Super          |	VO		  	 | PROV   |busNameYAndAddrY |
          |    Super          |	VO		  	 | PROV   |busNameYAndAddrN |
          |    Super          |	VO		  	 | PROV   |busNameNAndAddrY |
          |    Super          |	VO		  	 | PROV   |busNameNAndAddrN |
      