#Author: Rahul Krishna

@CreateEnrollment @US1247822 
Feature: Create Enrollment HO Financial Institution Information Continue from Identify Administrators

  Background: Create Enrollment HO Financial Institution Information Continue from Identify Administrators page AO enrollment
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
#TS_001

  Scenario: TS_0001_Validate the navigation upon selection of Continue from Financial Institution Information page.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User fills all the information of Financial Institution Information NPI page and click continue.

  #TS_003
	
  Scenario: TS_0003_Validate the content of the Add NPI Bank Account page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User Validates UI content with DataBase enrties.  
    
    #TS_004

  Scenario: TS_0004_Validate the Where can I find a financial institution routing number link.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User clicks on hyperlink 'where can I find a finantial Institution's routing number?'.
    
    
   #TC_5,#TC_6,#TC_9
  
   Scenario: TS_0005_Validate the default Type of Account TS_0006 Supporting documentation TS_0009 NPI bank account.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User validates the various default input like Typ of account,Supporting doc,NPI Bank Account and it can be changed.
    
    
        #TS_007

  Scenario: TS_0007_Validate the User is required to upload supporting documentation to their online enrollment for NPI.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User clicks on browse and upload its supporting document on NPI Page.
    
    
     #TS_008 #TS_010

  Scenario: TS_0008_TS_0010_Validate How do I manage multiple NPI bank accounts link presents and add multiple user 
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User clicks on hyperlink 'how do i manage multiple NPI bank accounts?'
    Then User fills all the information on Financial Institution Information NPI page and click continue NPI.
    
    #TS_11,#TS_12
    @Retest11
    Scenario Outline: TS_0011_TS_012_Validate the headers on Identify Administrator page for AO and AV TIN.
    Then user selects as "<EnrollmentType>" and  Clicks continue button of Enrollment TIN Eligible page
											      
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type
   
    Examples:
    												| EnrollmentType  |
											      |      AO         |
											 #     |			 AV					|
											      
											      
		     #TS_013 #TS_014 #TS_015 #TS_016 #TS_017

  Scenario: TS_0013_0014_15_16_17_Validate the content of the Pop Up box upon click of Cancel Enrollment button also different buttons
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User validates functionality of different buttons like Back,cancel enrollment,Continue(Yes/No on Continue) by clicking. 		
    
    #TS_018
    
    Scenario: TS_0018_Validate the error validations upon clicking Continue button on NPI Financial Information Page.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User clicks on continue button of FII NPI page and validtes the error messages.		
    
    
    #TS_019
  
    Scenario: TS_0019_Validate the error message when no data entered for National Provider Identifier on NPI FII page.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User validates various input field by giving blank input and clicking continue button.	
    
    
     #TS_020 to 28,37,38
   
    Scenario: TS_0020_to_0028_37_38 Validate the error message when non-numeric data entered.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User validates various input field by giving nonnumeric data input and clicking continue button.
    
    #TS_029 to 32
      
    Scenario: TS_0029_to_32_Validate the error message when PO box entered for Address Street and Incomplete Info on NPI FII page.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User validates error messages by giving PO BOX No in Street field,Invalid zip/state code incomplete phoneno.	
    
    #TS_035
    Scenario: TS_0035_Validate the error message when Account Number is same as TIN Account Number on NPI FII page.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
    Then User validates error messages when  TIN no and NPI no are same.	
    
     #TS_036(Pending,Needs clarity on test case)
     
    Scenario: TS_0036_Validate the error message when National Provider Identifier duplicate entry on NPI FII page.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       AO        |
    Then User fills all the information  and click on Continue
    Then User fills all the information on Identify Administrators page and click continue
    Then User fills all the information on Financial Institution Information page and click continue NPI
   # Then User fills duplicate Information on NPI Page.
    																	      