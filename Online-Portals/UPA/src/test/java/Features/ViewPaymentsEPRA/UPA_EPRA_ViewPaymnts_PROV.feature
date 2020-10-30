#Author: Rahul Krishna
@PROVEPRAViewPay @BothCSRUPAScenarios @UPARegression  
Feature: View Payments EPRA Prov

#TF41923 01-22
#TF41924 01-SuperUserRole-PROV_Admin,
         #02-Same as TF41923 01
         #04-how we are deciding the priority(claim count and priority relation)
#TF41925 10-Same as TF41923 01
         #11,13,14-Covered
#TF41926 01,02-Same and covered         
   
#Note: If any error comes due to unable to identify payment number then that is due to existing PT ticket:PRB0764346 
#In EPRA portion payment No is not getting identified on pages due to some issue          
 
Scenario Outline: TS_001,010,012--View Payments EPRA Provider
	
	   Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA View Payments Page for "<TimePeriod>","<priority>","<searchBy>" through "<usertype>" and click on continue button
     When Click on View Payments Link for UPA 
     And Validate all other columns in Show All State for "<TimePeriod>" of UPA View Payments
     And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
     And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	   And validate new Entry is created in Ole.EPRA_STATUS with appropriate status for Consol_Pay_Nbr
	   And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
     And validate record is inserted in User_Event_Log.
     #And User validates EPRA file is present in NAS Drive and delete it in both EPRA_STATUS Table, Nas Drive
  

Examples:     
       
             |       credentials      |priority  |		searchBy	 |   usertype     |		Search Criteria|TimePeriod|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments	| Last 30 days|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments	| Last 60 days|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments	| Last 90 days|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments	| Last 4-6 months|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments	| Last 6-9 months|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments	| Last 9-13 months|
             #|       PROV_Admin       |     2   |  EPRAViewPay  |		  PROV		  |		viewPayments	|		Last 30 days		|
            

         
  
  
  
 
  Scenario Outline: TS_001,010,012--View Payments EPRA Provider Payment No click
		 Given User navigates to UPA portal and enters "<credentials>" and login
     And User enters tin for UPA View Payments Page for "<TimePeriod>","<priority>","<searchBy>" through "<usertype>" and click on continue button
     When Click on View Payments Link for UPA 
     And Validate all other columns in Show All State for "<TimePeriod>" of UPA View Payments
      
      And User clicks on Payment Number when "<searchBy>" and validate Remittance Detail page is opened.
			And User clicks on print request button present on Remittance Detail screen.
			And User clicks on Print Available button on Remittance Detail screen.
			And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
			#And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
			And validate new Entry is created in Ole.EPRA_STATUS with appropriate status for Consol_Pay_Nbr
			And validate download status is set to Y in Ole.EPRA_STATUS
			And validate record is inserted in User_Event_Log for Remittance Detail   
	
	Examples:     
       
             |       credentials      |priority |  searchBy     |   usertype    |		Search Criteria			|TimePeriod|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments				|Last 30 days|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments			|Last 60 days|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments			|Last 90 days|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments				|Last 4-6 months|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments				|Last 6-9 months|
             |       PROV_Admin       |     1   |  EPRAViewPay  |			PROV			|		viewPayments				|Last 9-13 months|
            
            
       
Scenario Outline: TS_001,010,012--View Payments EPRA BS
	
		 Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     And User enters tin for BS UPA "<Payment Type>" for BS for "<priority>","<TimePeriod>" and click on continue button
     #And Validate all other columns in Show All State for UPA
     And Validate all other columns in Show All State for "<TimePeriod>" of UPA View Payments
     And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
     And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	   And validate new Entry is created in Ole.EPRA_STATUS with appropriate status for Consol_Pay_Nbr
	   And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
     And validate record is inserted in User_Event_Log.
      #And User validates EPRA file is present in NAS Drive and delete it in both EPRA_STATUS Table, Nas Drive
     

Examples:     
       
         |   		 Payment Type		  |       credentials    |priority |   Search Criteria		|TimePeriod|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 30 days|
         |        EPRAViewPay  |       BS_Admin          |		1	   |   viewPayments				|Last 60 days|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 90 days|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 4-6 months|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 6-9 months|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 9-13 months|
        
        
        

Scenario Outline: TS_001,010,012--View Payments EPRA BS Payment No click
	
		 Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     #And User enters tin for BS UPA "<Payment Type>" for BS for "<priority>" and click on continue button
     And User enters tin for BS UPA "<Payment Type>" for BS for "<priority>","<TimePeriod>" and click on continue button
     #And Validate all other columns in Show All State for UPA
     And Validate all other columns in Show All State for "<TimePeriod>" of UPA View Payments
     And User clicks on Payment Number when "<Payment Type>" and validate Remittance Detail page is opened.
		 And User clicks on print request button present on Remittance Detail screen.
			And User clicks on Print Available button on Remittance Detail screen.
			And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
			#And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
			And validate new Entry is created in Ole.EPRA_STATUS with appropriate status for Consol_Pay_Nbr
			And validate download status is set to Y in Ole.EPRA_STATUS
			And validate record is inserted in User_Event_Log for Remittance Detail

Examples:     
       
         |   		 Payment Type		  |       credentials      |priority |   Search Criteria		|TimePeriod|
         |        EPRAViewPay  	  |       BS_Admin         |		1	   |   viewPayments				|Last 30 days|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments			|Last 60 days|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 90 days|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 4-6 months|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 6-9 months|
         |        EPRAViewPay   |       BS_Admin         |		1	   |   viewPayments				|Last 9-13 months|
         
         
         
@US2707345 
Scenario Outline: View Payments Page UI Functionality for UPA
	
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
	 When Click on View Payments Link for UPA 
    And User selects time period filter "<timePeriod>" for View Payments
     Then Validate that View Payments Payer/Patient column name is changed to Payer for "<<type>"

Examples:     
       
   

        |    searchBy                   |       credentials        |  TimePeriod   |  userType  | type  |
		|    PatientPayment             |       PROV_Admin         |  Last 90 days |  PROV      |  UPA  |
        |    PatientPayment             |       PROV_Gen           |  Last 90 days |  PROV      |  UPA  |
        
@US2810748 
Scenario Outline: View Payments UI Functionality for Complaint patient payments UPA
	
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
	 When Click on View Payments Link for UPA 
     And User selects time period filter "<timePeriod>" for View Payments
     And User selects market type filter period "<filter>" for View Payments
     Then Validate the EPRA and Payer PRA column in View Payments Page for "<<type>"
Examples:     
       
   
        |    searchBy                   |       credentials        |  TimePeriod   |  userType  |    filter          |  type  |
		|    PatientPayment             |       PROV_Admin         |  Last 90 days |  PROV      |   Patient Payments |   UPA  |
        |    PatientPayment             |       PROV_Gen           |  Last 90 days |  PROV      |   Patient Payments |   UPA  |
        
@US2707374 
Scenario Outline: View Payments Page UI Functionality for Patient Payements(View Payments --> Remittance Detail)
	
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
	 When Click on View Payments Link for UPA 
     And User selects time period filter "<timePeriod>" for View Payments
     And User selects market type filter period "<filter>" for View Payments
     Then Validate and click on payment number
     Then Validate all Headers in the Page for Payer
     Then Validate Column Headers in the grid for remittance detail Page
Examples:     
       
        |    searchBy                   |       credentials        |  timePeriod   |  userType  |    filter          | 
		|    PatientPayment             |       PROV_Admin         |  Last 90 days |  PROV      |   Patient Payments | 
        |    PatientPayment             |       PROV_Gen           |  Last 90 days |  PROV      |   Patient Payments | 
        
 @US2854253 
Scenario Outline: NPI User Payment Summary
	
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
	 When Click on View Payments Link for UPA 
     And User selects time period filter "<timePeriod>" for View Payments
     Then Validate payment summary page for only single NPI payments for "<searchBy>"
Examples:     
       
        |    searchBy                   |       credentials        |  timePeriod   |  userType  |
      	|  NPI_SingleTIN                |       PROV_Admin         |  Last 90 days |  PROV      |
        |  NPI_MultipleTIN              |       PROV_Admin         |  Last 90 days |  PROV      |
        
@US2112134
Scenario Outline: Remittance detail screen mapping
	
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 Then User enters tin for View Payments UPA for "<searchBy>" and "<userType>" search criteria
	 When Click on View Payments Link for UPA 
     And User selects time period filter "<timePeriod>" for View Payments
     And User selects market type filter period "<filter>" for View Payments
     Then Validate and click on payment number
     Then validate data in remittance detail screen
Examples:     
       
        |    searchBy                   |       credentials        |  timePeriod   |  userType  |    filter          | 
		|    PatientPayment             |       PROV_Admin         |  Last 90 days |  PROV      |   Patient Payments | 
        |    PatientPayment             |       PROV_Gen           |  Last 90 days |  PROV      |   Patient Payments | 

             