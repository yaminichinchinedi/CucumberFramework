#Author: Rahul Krishna+
Feature: Create Enrollment Home Page Validations 

@UPAUS3610262 @UPA2021_PI02_IP

 Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    #Then Select "<Enrollment Type>" and  Clicks continue button of Enrollment TIN Eligible page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
		Then User sets business phone
		Then User fills all the information  and click on Continue
		Then User fills all the information on Identify Administrators page and click continue
		#Need to check ABA Validator or Normal flow
    #Then User fills all the information on Financial Institution Information page and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    And Validate Data is saved in Database on Enrollment Page.
    And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
    And Click on ACH Addendum link verify popup functionality and close the link 
    And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
    And Click on Exit Enrollment button navigates to the Optum Pay landing page 
    
     Examples:

          |   credentials     |
          |    Super          |
                	
									
    											
	@UPAUS3610262	@UPA2021_PI02_IP
	Scenario Outline: US1033910/US2952500 Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  # Then User Validates link Download Virtual Card Payment Enrollment Guide Link  and click on it
	Then User clicks on Continue button of BeginEnrollment Page
	Then User clicks on which option should i choose link and close the opened popup
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
		| Enrollment Type |
	  |       VO        |			
	Then User sets business phone
	Then User fills all the information  and click on Continue
	Then User fills all the information on Identify Administrators page and click continue to W9
	Then User uploads the WNine form and click continue
	And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
	And Validate Data is saved in Database on Enrollment Page.
  And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
	# And Click on ACH Addendum link verify popup functionality and close the link 
	# And Also click on Print Enrollment page,download PDF and validates all the information from PDF page
	And Click on Exit Enrollment button navigates to the Optum Pay landing page 
	
	  Examples:

          |   credentials     |
          |    Super          |
           				
									
    										
  										
	
	Scenario: US1033935 Create Enrollment AO Enrollment Submitted page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    #Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    #Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    #Then User fills all the information on Financial Institution Information page and click continue NPI
    #Then User fills all the information of Financial Institution Information NPI page and click continue.
    Then User uploads the WNine form and click continue
    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
    Then Click on Submit Enrollment button and verify Enrollment Information 
    Then Also click on Print Enrollment form link download PDF and verify PDF data 
    
    
#    Scenario: US1033935 Create Enrollment VO Enrollment Submitted Page
#    Given User navigates to UPA Sys Test application
#    When User Clicks on Enroll Now from the landing page
#    Then User Select a How you heard option and  click on Continue button
#    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
#										      | Enrollment Type |
#										      |       VO        |
#    Then User fills all the information  and click on Continue
#    Then User fills all the information on Identify Administrators page and click continue
#    Then User uploads the WNine form and click continue
#    And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
#    Then Click on Submit Enrollment button and verify Enrollment Information 
#    Then Also click on Print Enrollment form link download PDF and verify PDF data     			      				
#	
#		
	  Scenario: US1048192/US1048199-Create Enrollment_BS Enrollment Submitted Page 
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     BS        |				      					
	Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User navigates to Identity Administrators page and fill all fields and click on continue button
  Then User uploads the WNine form and click continue
  Then  Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.
  And  Validate Data is saved in Database on Enrollment Page.
   And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
   And Also click on Print Enrollment page,download PDF and validates all the information from PDF page		

#Author: Shalini Mahavratayajula
 @UPAUS3610262_Negative   
 Scenario Outline: US3610262 Provider navigates to UPA Application to validate error scenario for "BusinessPhone" in organization Information page.
    
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
  	Then User clicks on Continue button of BeginEnrollment Page
		Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										|Enrollment Type|
										|     AO        |		
		Then User sets invalid business phone "<invalidBusinessPhone>"
		Then User fills all the information  and click on Continue
		Then User validate error messages
    
     Examples:

          |   credentials     | tinType |  invalidBusinessPhone |    	
        	|    Super          |  AO  		|			AlphaNumericString  |
        	|    Super          |  VO   	|			SpecialCharacters   |
        				
    			
 @UPAUS2952537AO						      
	Scenario Outline: UPAUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators AO enrollment
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
	Then User clicks on which option should i choose link and close the opened popup
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
		| Enrollment Type |
	  |       AO        |			
	Then User sets business phone
	Then User fills the auto populated information for BusinessNameAddress and click on Continue	
	Then User fills all the information on Identify Administrators page and click continue
	Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
  Then User uploads the WNine form and click continue
  And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
  And Validate OrgInfo Indicators are saved in Database on Enrollment Page

     Examples:

          |   credentials     |
          |    Super          |
                	    
 
 @UPAUS2952537VO							      
	Scenario Outline: UPAUS2952537 Create Enrollment validate OrgInfo OrgName BusinessAddr BusinessPhone Indicators VO enrollment
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
	Then User clicks on Continue button of BeginEnrollment Page
	Then User clicks on which option should i choose link and close the opened popup
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
		| Enrollment Type |
	  |       VO        |			
	Then User sets business phone
	Then User fills the auto populated information for BusinessNameAddress and click on Continue	
	Then User fills all the information on Identify Administrators page and click continue to W9
	Then User uploads the WNine form and click continue
	And Fill Authorize Enrollers Info and click on submit button on Review and Submit Page.  
  And Validate OrgInfo Indicators are saved in Database on Enrollment Page
  And Also Validates page content,Headers,Exit Enrollment button on Enrollment Submitted Page
		
	  Examples:

          |   credentials     |
          |    Super          |         
 