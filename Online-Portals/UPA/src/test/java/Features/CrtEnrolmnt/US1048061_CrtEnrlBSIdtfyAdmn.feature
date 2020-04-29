#Author: Rahul Krishna

@CreateEnrollment @US1048061 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment BS Enrollment Type to Identify Administrators page

  Background: Create Enrollment BS Enrollment Type to Identify Administrators page
    Given User navigates to UPA Sys Test application
    When User Clicks on Enroll Now from the landing page
    Then User Select a How you heard option and  click on Continue button
#TS_001
@UPASanity
  Scenario: TS_00001_Upon selection of Continue from the TIN eligibility status page, user navigates to the Organization Information page
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    
    #TS_003
	@UPASanity
  Scenario: TS_00003_Page text is content managed
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Validates page text is content managed
   
##TS_004 #TS_005

  Scenario: TS_00004_Secondary administrator is not mandatory and TS_00005_Mobile Phone Number field is not required.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
     Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all fields and click on continue button

#TS_006

  Scenario: TS_00006_Text Alert indicator to get enabled on entering 10 digits of mobile number.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
     Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User Check if Mobile number field is mandatory if check box is enabled.

#TS_007 #TS_008

  Scenario: TS_00007_The alert frequency link will display a popup box.Text matches to wireframe and
            TS_00008_The  Learn about alert frequency , a popup box gets closed with close tip option.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then Click on Learn about alert frquency for both Primary and secondary admin and validate the popup


#TS_009

  Scenario: TS_00009_The Clear Administrator Information click will ask user if  they want to remove entered Administrator Information. Yes and No options display.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User clicks on hyperlink CLEAR ADMINISTRATOR INFORMATION
    
    #TS_010

  Scenario: TS_00010_Header displays -Billing Service Information (in unbold orange),  Rest headers (all in gray).
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And Validate the Headers on Identify Admin Page.
   
   
      #TS_011 #TS_012
		
    Scenario: TS_00011_To Validate Cancel Enrollment, Back  and Continue options display and TS_00012_To Validate back button , user navigates to the Billing service Information Page.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And User validates Cancel Enrollment, Back and Continue options is displayed at the bottom of the Identify Administrators Page.
    Then User Clicks on Back button and navigates to Billing Service Information Page.
    
   
    #TS_013 #TS_014 #TS_015
			
    Scenario: TS_00013_To Validate Cancel Enrollment and Continue options display.Validation of Yes/No buton
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And User Clicks on Cancel button and a popup appears with Are you sure you want to cancel your Optum Pay enrollment application? with Yes and No
    When User Clicks on No button and user is back to Organization Information page.
    When User Clicks on Yes button and user is on Optum Pay landing page.
    
    
    #TS_016 #TS_017 #TS_018 #TS_019
    Scenario: TS_00016_ Upon selection of Continue,validation is performed.
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And  Click on Save changes/Continue button and validate Form and error messages
    Then Click on Save changes/Continue button and Validate Error hyperlinks 	
    
    
    #TS_020 #TS_021  #TS_022 #TS_024  #TS_026 #TS_028  #TS_029 #TS_030 #TS_032
	
  Scenario: Validation of different input fiels for Primary/Secondary Contacts
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
    Then User navigates to Billing service information page and fill all fields and click on continue button
    And Fill Administrator Info and Verify error msgs for Primary Contacts.
    And Fill Administrator Info and Verify error msgs for Secondary Contacts.
  		              
							              
							              
		 #TS_023 #TS_031 #TS_025 #TS_033 #TS_034
  	
  Scenario Outline: Validation of incorrect/improper input for different provider
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
     Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill  details for "<Provider Type>" with incorrect/improper "<InputField>" and click on continue button
    Examples:
							              |Provider Type  | InputField   |
							              |  Secondary    | Telephone No |
							              |  Secondary    | Email Address|
							              |  Primary      | Telephone No |
							              |  Primary      | Email Address|
							              				              
			#TS_027 #TS_035				              				              
		 Scenario Outline: Validation for unmatching of Email and Confirm email fiels for different provider type 
    Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
										      | Enrollment Type |
										      |       BS        |
     Then User navigates to Billing service information page and fill all fields and click on continue button
    Then User navigates to Identity Administrators page and fill all  details  for "<Provider Type>" details with not matching Email and Retype Email and click on continue button
    Examples:
							              |Provider Type  |
							              |  Secondary    | 
							              |  Primary      | 
							     					              				              