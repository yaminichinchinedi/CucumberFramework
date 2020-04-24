#Author: Rahul Krishna

@CreateEnrollment @US1247813
Feature: Create Enrollment HO Financial Institution Information Continue from Identify Administrators

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
#TS_001
@UPASanity
  Scenario: Fills the relevent Info with AO Enroll Typ
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue

#Changes made by Rahul on 26Fen2020 for F419963 - Create Enrollment ACP Hide requirement validation.AV and VO option hiddenon screen
#TS_002
#  Scenario: Fills the relevent Info with AV Enroll Typ
#    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
#												   | Enrollment Type |
#												   | 			AV        |
#    Then User fills all the information  and click on Continue
#    Then User fills all the information on Identify Administrators page and click continue


#TS_003
#  Scenario: Fills the relevent Info with VO Enroll Typ
#    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
#											      | Enrollment Type |
#											      |      VO         |
#    Then User fills all the information  and click on Continue
#    Then User fills all the information on Identify Administrators page and click continue

#TS_004
  #Scenario: Checking UI Content matches with UXDS Page
  #  Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
	#									      | Enrollment Type |
	#									      |       AO        |
  #  Then User fills all the information  and click on Continue
  #  Then User fills all the information on Identify Administrators page and click continue


#TS_005
@UPASanity
  Scenario: Checking UI Content matches with DB 
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
		Then It is Validated that Financial Institution Information page text is content managed
		     

#TS_006
  Scenario: Clicking FI Routing no
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User clicks the link where can i find a finantial intitution's routing no

#TS_007
  Scenario: Validates the Type of Account
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates the Type of account as Checking by default and can be change to Saving


#TS_008

  Scenario: Validates the Supporting doc as Void Check and Bank Letter
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates the supporting document as Voided Check by default and can be change to Bank letter


  #TS_009
 
	Scenario: Browsing the Supporting docs
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User clicks on browse and upload its supporting document
    
    
      #TS_010
	Scenario: Clicking on multiple NRI bank accounts
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User clicks on hyperlink how do i manage multiple NPI bank accounts
    
    #TS_011
   
    Scenario: Validates the NPI Bank Account
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates the NPI Bank account as No by default and can be change to Yes
    
          #TS_012 #TS_013
	Scenario Outline: Validating the Headers content
    Then user selects as "<EnrollmentType>" and  Clicks continue button of Enrollment TIN Eligible page
											      
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type
   
    Examples:
    												| EnrollmentType  |
											      |      AO         |
											     # |			 AV					|
											      
					#TS_014 #TS_015						      
	Scenario Outline: Validation of buttons Cancel Enrollment, Back and Continue for AV and AO enrollment
    Then user selects as "<EnrollmentType>" and  Clicks continue button of Enrollment TIN Eligible page
											      
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User validates and clicks buttons Back,Cancel Enrollment,Continue are on the FII page
    
    
    
    Examples:
    												| EnrollmentType  |
											      |      AO         |
											  #    |			 AV					|
											      
											      
		#TS_016 #TS_017 #TS_018
		
  Scenario: Validating the Error on click of Continue button of FII page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User clicks on continue button of FII page and validtes the error messages		
    
    
    		#TS_019
    		
  Scenario: Validating that PO Boxes are not accepted in Street field of FII Page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information and PO Box no in Street field and clicks on continue								      
			
			
				#TS_020
    	
  Scenario: Validating that Invalid Zip Code is not accepted
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information and invalid Zip code for corresponding City and clicks on continue								      
			
											      
	#TS_021
		
  Scenario: Validating that non accepted file format not uploaded
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											      | Enrollment Type |
											      |      AO         |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information and upload non accepted file format and clicks on continue								      
								