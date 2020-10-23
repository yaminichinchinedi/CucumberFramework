#Author:Rahul Krishna
@CreateEnrollment @US1463317 @BothCSRUPAScenarios @UPARegression
Feature: Create Enrollment HO Financial Institution Information Continue from Identify Administrators

 
  Scenario Outline: TS_0001/003_Validate Edit and Remove option Option next to each field on Review and Submit page.
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
    Then User validateds multiple Edit option on Review and Submit Page
       Examples:

         |   credentials     |
         |    Super          |
    

  Scenario Outline: TS_02/09/34_Validate navigation of click Edit button on NPI section and content on Review and Submit page
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User fills all the information on Financial Institution Information NPI page and click Save Changes
    Then User verifies content of FII-NPI on Review and Submit Page  
       Examples:

         |   credentials     |
         |    Super          |
 #TS_004
 
  Scenario Outline:TS_0004 Validate Upon selection of Remove the NPI information is deleted and the bank letter or voided check removed.
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
    Then User validateds multiple Edit option on Review and Submit Page
    Then User clicks on Financial Institution Information NPI page remove link and validate it is removed.
       Examples:

         |   credentials     |
         |    Super          |
   #TS_005 depricated  
    #TS_06,07

    Scenario Outline: TS_0006/007_Validate the buttons on the page and Navigatin on click of Cancel changes Button.
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
    Then User validateds multiple Edit option on Review and Submit Page 
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates the Cancel Changes and Save changes buttons,click on Cancel Changes button
      Examples:

         |   credentials     |
         |    Super          |
     
    #TS_08
    Scenario Outline: TS_0008_Validate the popup on selecting Where can I find a financial institution s routing number

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
    Then User validateds multiple Edit option on Review and Submit Page 
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User clicks on hyperlink 'where can I find a finantial Institution's routing number?'.
       Examples:

         |   credentials     |
         |    Super          |
    #TS_10
    Scenario Outline: TS_0010_Validate Pop up message to be displayed on selecting How do I manage multiple NPI bank accounts Link
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
    Then User validateds multiple Edit option on Review and Submit Page 
    Then User click back button on Review and Submit Page
    And  clicks back button on Upload WNine Page.
    Then User clicks on hyperlink 'how do i manage multiple NPI bank accounts?'
       Examples:

         |   credentials     |
         |    Super          |
    #TS_11 is not present
    #TS_12
    
     Scenario Outline: TS_0012_Validate Headers for AO Enrollment Type
    
  
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
    Then User validateds multiple Edit option on Review and Submit Page 
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then Validate all the Headers from FII page in case of AO and AV Enrollment type
       Examples:

         |   credentials     |
         |    Super          |

    
    
   
   #TS_15_blank
   #@US1463317
    Scenario Outline: TS_15/17/18/20/21/22/23/28/31/33_Validate the Error message by giving blank input
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
    Then User validateds multiple Edit option on Review and Submit Page 
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates various input field by giving blank input and clicking Save Changes button.
       Examples:

         |   credentials     |
         |    Super          |
   #TS_NonNumeric
   
    Scenario Outline: TS_16/23/26/32_Validate the Error message by nonnumeric input
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
    Then User validateds multiple Edit option on Review and Submit Page 
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates various input field by giving nonnumeric data input and clicking Save Changes button.
       Examples:

         |   credentials     |
         |    Super          |
    
    #TS_POBox No in street field
    
    Scenario Outline: TS_19/24/27 Validate the Error message by incomplete/PO BOX no in Street field

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
    Then User validateds multiple Edit option on Review and Submit Page 
    Then User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User validates error messages by giving PO BOX No in Street field,Invalid zip/state code,incomplete phoneno and click on Save Change.
   
        Examples:

         |   credentials     |
         |    Super          |
   
											      
    #TS_035A and 035B
    
    Scenario Outline: TS_0035A/35B_Disablinb of Cancel Changes button and with valid info changes are in Review and Submit Page.
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
    Then User validateds multiple Edit option on Review and Submit Page
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User fills invalid information on FII NPI page and click Save Changes, an error will be there and Cancel Changes button is disabled
    Then User fills valid information on FII NPI page and click Save Changes, an verifies changes on Review Submit Page
       Examples:

         |   credentials     |
         |    Super          |
    #TS_036
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
    Then User fills all the information on Financial Institution Information page for ABA Validator,Click YES to NPI and click continue
    Then User fills NPI No,RTN No and other information on Financial Institution Information NPI page and click continue.
      Then User uploads the WNine form and click continue
    Then User validateds multiple Edit option on Review and Submit Page 
    And User clicks on Financial Institution Information NPI page Edit link
    And User verifies that FII-NPI fields are editables
    Then User clicks on Edit link to upload doc and validates Cancel button is disabled
    Then User verifies that uploaded document is present on Review and Submit Page
      Examples:

         |   credentials     |
         |    Super          |
     