@US1248921
Feature: US1248921_Create Enrollment- Review and Submit - Edit Financial Institution Information

  Background: Create Enrollment_HO_Review and Submit 
 
  Given User navigates to UPA Sys application
  When User Clicks on Enroll Now button
  Then User Selects How you heard option and  click on Continue button
											
 @TC0001									
	Scenario: TS_0001_Validate Edit Option next to each field on Review and Submit page.
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Vaidate Edit option next to each field on Review and Submit page 
  
  @TC0002									
	Scenario: TS_0002_Validate the navigation upon selection of Edit button next to  Financial Information section on Review and Submit page.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  
   @TC0003									
	Scenario: TS_0006_Validate the data on Financial Information  page.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate buttons on Edit Financial Institution Information Page
  
   @TC0004									
	Scenario: TS_0007_Validate the navigation upon selection of Cancel changes.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Click on Cancel changes button and validate no changes are saved
  
  @TC0005									
	Scenario: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Click on link Where can i find a financial institution's routing number? and validate the popup message
  
  @TC0006									
	Scenario: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts  Link
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then User Navigates Back to Financial Institution Information Page from Review and Submit Page
  Then Click on link How do i manage multiple NPI bank accounts and validate the popup message
  
  @TC0007									
	Scenario: TS_0011_Validate the headers on Financial Information page for AO TIN.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate Headers on Financial Information page
  
  
   @TC0008									
	Scenario: TS_0012_Validate the headers on Financial Information page for AV TIN.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AV        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue to AV
  Then User clicks Continue on Select Payment Methods Page
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate Headers on Financial Information page
  
   @TC0009									
	Scenario: TS_0036_Validate on edit of different voided check or bank letter, the Cancel Changes button gets disabled.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate Cancel button is disabled when click on edit for voided/blank letter document
  
  @TC00010									
	Scenario: TS_0013/16/17/19/20/21/24/27/30/32_Validate Missing data error message for Financial Institution Information fields.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate Missing data Error messages for Financial Institution Fields on click on save changes button
  
  
  @TC00011									
	Scenario: TS_0018/23/29_Validate the error validations upon Entering PO Box in Street Name Field..
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate Invalid data Error messages for Financial Institution Fields on click on save changes button
  
  @TC00012									
	Scenario: TS_0022/26/28/31/34_Validate Invalid Error Messages for Financial Institution Information Page.
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate Non numeric data Error messages for Financial Institution Fields on click on save changes button
  
  @TC00013									
	Scenario: TS_33/35_Upon correcting errors and selecting Save Changes again, updated information is saved and displays on Review and Submit page
	
	Then Select Enrollment Type and  Clicks continue button of Enrollment TIN Eligible page
											|Enrollment Type|
											|     AO        |
											
  Then User navigates to Billing service information page and fill all fields and click on continue button
  Then User fills all the information on Identify Administrators page and click continue
  Then User fills all the information on Financial Institution Information page and click continue
  Then User navigates to Uploadw9 page and click on continue button on financial Institution Page
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  Then Validate Non numeric data Error messages for Financial Institution Fields on click on save changes button
  Then User should navigae to Review and Submit Page upon Entering valid information with changes reflecting 