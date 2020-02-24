#Author: Madhavi Upputuri

@CreateEnrollment @US1248921
Feature: US1248921_Create Enrollment- Review and Submit - Edit Financial Institution Information

  Background: Create Enrollment_HO_Review and Submit 
 
  Given User navigates to UPA Sys Test application
  When User Clicks on Enroll Now from the landing page
  Then User Select a How you heard option and  click on Continue button
																	
	Scenario: TS_0001_Validate Edit Option next to each field on Review and Submit page.
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
   Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  And Validates Edit option next to each field on Review and Submit page 
  
  					
	Scenario: TS_0002_Validate the navigation upon selection of Edit button next to  Financial Information section on Review and Submit page.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  And Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  
  #TC_003 and TC_004 covered in US1463317_TS004
  #TC_005 depricated	
  
  						
	Scenario: TS_0006_Validate the data on Financial Information  page.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates buttons on Edit Financial Institution Information Page
  						
	Scenario: TS_0007_Validate the navigation upon selection of Cancel changes.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Clicks on Cancel Changes button on Financial Institution Page. 
  And Validate no changes are saved on Review Submit Page for Financial Institution section.
  							
	Scenario: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Clicks on link Where can i find a financial institution's routing number? and validate the popup message
  
 
  Scenario: TS_0009_Validate User is able to update or re-upload enrollment information within the page
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  Then User clicks on edit link of Account information section and reupload any other document 
  Then User verifies that uploaded document is present on Review and Submit Page on TIN Section
  
  							
	Scenario: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts  Link
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then User click back button on Review and Submit Page
  And clicks back button on Upload WNine Page.
  And Clicks on link How do i manage multiple NPI bank accounts and validate the popup message
  							
	Scenario: TS_0011_Validate the headers on Financial Information page for AO TIN.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Headers on Financial Information page
  						
	Scenario: TS_0012_Validate the headers on Financial Information page for AV TIN.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AV        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue to AV
  Then User clicks Continue on Select Payment Methods Page
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
 And User validates fiels are editables on Financial Institution Information page
  And Validates Headers on Financial Information page
  
								
	#TS_014 015 is covered in US1463317 TS_015 
  							
	Scenario: TS_0013/16/17/19/20/21/24/27/30/32_Validate Missing data error message for Financial Institution Information fields.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Missing data Error messages for Financial Institution Fields on click on save changes button
  
	Scenario: TS_0018/23/29_Validate the error validations upon Entering PO Box in Street Name Field..
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Invalid data Error messages for Financial Institution Fields on click on save changes button
  				
	 
	Scenario: TS_0022/26/28/31/34_Validate Invalid Error Messages for Financial Institution Information Page.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button

	
	Scenario: TS_0025_Validate the error validations upon no data for  Telephone number.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And User give alphanumeric No in Telphone no fiels and click on save changes button


	Scenario: TS_33/35_Upon correcting errors and selecting Save Changes again, updated information is saved and displays on Review and Submit page
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
 And User validates fiels are editables on Financial Institution Information page
  And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button
  And User should navigate to Review and Submit Page upon Entering valid information
  And Validate the changes are reflected on Review and Submit Page.
  
  Scenario: TS_0036_Validate on edit of different voided check or bank letter, the Cancel Changes button gets disabled.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Cancel button is disabled when click on edit for voided/blank letter document
  