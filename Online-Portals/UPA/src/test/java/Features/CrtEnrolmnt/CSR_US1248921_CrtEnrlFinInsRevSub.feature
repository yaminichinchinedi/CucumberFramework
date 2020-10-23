#Author: Madhavi Upputuri

Feature: US1248921_Create Enrollment- Review and Submit - Edit Financial Institution Information

															
	Scenario Outline: TS_0001_Validate Edit Option next to each field on Review and Submit page.
When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
   Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
		  Then User uploads the WNine form and click continue
  And Validates Edit option next to each field on Review and Submit page 
   Examples:

         |   credentials     |
         |    Super          |
				
	Scenario Outline: TS_0002_Validate the navigation upon selection of Edit button next to  Financial Information section on Review and Submit page.
	
When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  And Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
   Examples:

         |   credentials     |
         |    Super          |
	
  
  						
	Scenario Outline: TS_0006_Validate the data on Financial Information  page.
	
When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates buttons on Edit Financial Institution Information Page
  				 Examples:

         |   credentials     |
         |    Super          |		
	Scenario Outline: TS_0007_Validate the navigation upon selection of Cancel changes.
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Clicks on Cancel Changes button on Financial Institution Page. 
  And Validate no changes are saved on Review Submit Page for Financial Institution section.
  							 Examples:

         |   credentials     |
         |    Super          |
	Scenario Outline: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number.
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Clicks on link Where can i find a financial institution's routing number? and validate the popup message
  
  Examples:

         |   credentials     |
         |    Super          |
  Scenario Outline: TS_0009_Validate User is able to update or re-upload enrollment information within the page
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  Then User clicks on edit link of Account information section and reupload any other document 
  Then User verifies that uploaded document is present on Review and Submit Page on TIN Section
   Examples:

         |   credentials     |
         |    Super          |
  							
	Scenario Outline: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts  Link
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then User click back button on Review and Submit Page
  And clicks back button on Upload WNine Page.
  And Clicks on link How do i manage multiple NPI bank accounts and validate the popup message
  							 Examples:

         |   credentials     |
         |    Super          |
	Scenario Outline: TS_0011_Validate the headers on Financial Information page for AO TIN.
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Headers on Financial Information page
  						 Examples:

         |   credentials     |
         |    Super          |

  
								
	#TS_014 015 is covered in US1463317 TS_015 
  							
	Scenario Outline: TS_0013/16/17/19/20/21/24/27/30/32_Validate Missing data error message for Financial Institution Information fields.
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Missing data Error messages for Financial Institution Fields on click on save changes button
   Examples:

         |   credentials     |
         |    Super          |
	Scenario Outline: TS_0018/23/29_Validate the error validations upon Entering PO Box in Street Name Field..
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Invalid data Error messages for Financial Institution Fields on click on save changes button
  	 Examples:

         |   credentials     |
         |    Super          |			
	 
	Scenario Outline: TS_0022/26/28/31/34_Validate Invalid Error Messages for Financial Institution Information Page.
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button
 Examples:

         |   credentials     |
         |    Super          |
	
	Scenario Outline: TS_0025_Validate the error validations upon no data for  Telephone number.
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And User give alphanumeric No in Telphone no fiels and click on save changes button
 Examples:

         |   credentials     |
         |    Super          |

	Scenario Outline: TS_33/35_Upon correcting errors and selecting Save Changes again, updated information is saved and displays on Review and Submit page
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
 And User validates fiels are editables on Financial Institution Information page
  And Validates Non numeric data Error messages for Financial Institution Fields on click on save changes button
  And User should navigate to Review and Submit Page upon Entering valid information
  And Validate the changes are reflected on Review and Submit Page.
   Examples:

         |   credentials     |
         |    Super          |
  Scenario Outline: TS_0036_Validate on edit of different voided check or bank letter, the Cancel Changes button gets disabled.
	
	When  ABN Validator Switch is set as 'Y'
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Create/Maintain Enrollment link on CSR HomePage
		Then User Select User Type as "Provider" and enter unique TIN and click Search
		Then User select Yes button of TIN not enrolled page
		Then User select User Type Enrollment as "AO" and click continue button 
		Then User fills all the information  and click on Continue
		
  Then User fills all the information on Identify Administrators page and click continue
When RTI API server is up
		Then User fills all the information on Financial Institution Information page for ABA Validator and click continue
	  Then User uploads the WNine form and click continue
  Then Click on Edit on financial Institution Section and validate user navigates to Financial Institution Information Page
  And User validates fiels are editables on Financial Institution Information page
  And Validates Cancel button is disabled when click on edit for voided/blank letter document
   Examples:

         |   credentials     |
         |    Super          |