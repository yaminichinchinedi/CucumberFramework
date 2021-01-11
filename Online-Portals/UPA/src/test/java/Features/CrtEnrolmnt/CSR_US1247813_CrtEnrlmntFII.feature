#Author: Rahul Krishna

@CreateEnrollment @US1247813 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment HO Financial Institution Information Continue from Identify Administrators

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
   
    When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "Super" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
#TS_001
@UPASanity
  Scenario: Fills the relevent Info with AO Enroll Typ

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue




#TS_005
@UPASanity
  Scenario: Checking UI Content matches with DB 
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
		Then It is Validated that Financial Institution Information page text is content managed
		     

#TS_006
  Scenario: Clicking FI Routing no

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User clicks the link where can i find a finantial intitution's routing no

#TS_007
  Scenario: Validates the Type of Account

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User validates the Type of account as Checking by default and can be change to Saving


#TS_008

  Scenario: Validates the Supporting doc as Void Check and Bank Letter

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User validates the supporting document as Voided Check by default and can be change to Bank letter


  #TS_009
 
	Scenario: Browsing the Supporting docs

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
      Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User clicks on browse and upload its supporting document
    
    
      #TS_010
	Scenario: Clicking on multiple NRI bank accounts

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
      Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User clicks on hyperlink how do i manage multiple NPI bank accounts
    
    #TS_011
   
    Scenario: Validates the NPI Bank Account

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
      Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User validates the NPI Bank account as No by default and can be change to Yes
    
          #TS_012 #TS_013
	Scenario: Validating the Headers content
   
											      
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
      Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type
   
   
											   
											      
					#TS_014 #TS_015						      
	Scenario: Validation of buttons Cancel Enrollment, Back and Continue for AV and AO enrollment
											      
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
      Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User validates and clicks buttons Back,Cancel Enrollment,Continue are on the FII page
    
    
  
											      
		#TS_016 #TS_017 #TS_018
		
  Scenario: Validating the Error on click of Continue button of FII page

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User clicks on continue button of FII page and validtes the error messages		
    
    
    		#TS_019
    		
  Scenario: Validating that PO Boxes are not accepted in Street field of FII Page

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User fills all the information and PO Box no in Street field and clicks on continue								      
			
			
				#TS_020
    	
  Scenario: Validating that Invalid Zip Code is not accepted

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User fills all the information and invalid Zip code for corresponding City and clicks on continue								      
			
											      
	#TS_021
		
  Scenario: Validating that non accepted file format not uploaded

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
    Then User fills all the information and upload non accepted file format and clicks on continue								      
								