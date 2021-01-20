#Author: Rahul Krishna
@CreateEnrollment @US1247822 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment HO Financial Institution Information Continue from Identify Administrators

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    
    
    When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "Super" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
    
    
#TS_001
@UPASanity
  Scenario: TS_0001_Validate the navigation upon selection of Continue from Financial Institution Information page.
     Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
    
    

  #TS_003
	@UPASanity
  Scenario: TS_0003_Validate the content of the Add NPI Bank Account page
      	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User Validates UI content with DataBase enrties.  
    
    #TS_004

  Scenario: TS_0004_Validate the Where can I find a financial institution routing number link.
     	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User clicks on hyperlink 'where can I find a finantial Institution's routing number?'.
    
    
   #TC_5,#TC_6,#TC_9
  
   Scenario: TS_0005_Validate the default Type of Account TS_0006 Supporting documentation TS_0009 NPI bank account.
      	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    
    Then User validates the various default input like Typ of account,Supporting doc,NPI Bank Account and it can be changed.
    
    
        #TS_007

  Scenario: TS_0007_Validate the User is required to upload supporting documentation to their online enrollment for NPI.
      	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    
    Then User clicks on browse and upload its supporting document on NPI Page.
    
    
     #TS_008 #TS_010

  Scenario: TS_0008_TS_0010_Validate How do I manage multiple NPI bank accounts link presents and add multiple user 
     	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    
    Then User clicks on hyperlink 'how do i manage multiple NPI bank accounts?'
    Then User fills all the information on Financial Institution Information NPI page and click continue NPI.
    
    #TS_11,#TS_12
    @Retest11
    Scenario: TS_0011_TS_012_Validate the headers on Identify Administrator page for AO and AV TIN.
     	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type
   
  
											      
		     #TS_013 #TS_014 #TS_015 #TS_016 #TS_017

  Scenario: TS_0013_0014_15_16_17_Validate the content of the Pop Up box upon click of Cancel Enrollment button also different buttons
      	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
        Then User validates functionality of different buttons like Back,cancel enrollment,Continue(Yes/No on Continue) by clicking. 		
    
    #TS_018
    
    Scenario: TS_0018_Validate the error validations upon clicking Continue button on NPI Financial Information Page.
     	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
        Then User clicks on continue button of FII NPI page and validtes the error messages.		
    
    
    #TS_019
  
    Scenario: TS_0019_Validate the error message when no data entered for National Provider Identifier on NPI FII page.
     	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
        Then User validates various input field by giving blank input and clicking continue button.	
    
    
     #TS_020 to 28,37,38
   
    Scenario: TS_0020_to_0028_37_38 Validate the error message when non-numeric data entered.
      	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
        Then User validates various input field by giving nonnumeric data input and clicking continue button.
    
    #TS_029 to 32
      
    Scenario: TS_0029_to_32_Validate the error message when PO box entered for Address Street and Incomplete Info on NPI FII page.
    Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
        Then User validates error messages by giving PO BOX No in Street field,Invalid zip/state code incomplete phoneno.	
    
    #TS_035
    Scenario: TS_0035_Validate the error message when Account Number is same as TIN Account Number on NPI FII page.
   Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
        Then User validates error messages when  TIN no and NPI no are same.	
    
     #TS_036(Pending,Needs clarity on test case)
     
    Scenario: TS_0036_Validate the error message when National Provider Identifier duplicate entry on NPI FII page.
   	Then User select User Type Enrollment as "AO" and click continue button

    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
		When RTI API server is up
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
       # Then User fills duplicate Information on NPI Page.
    																	      