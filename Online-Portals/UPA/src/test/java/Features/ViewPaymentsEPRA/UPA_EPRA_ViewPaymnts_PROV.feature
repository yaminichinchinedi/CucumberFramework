#Author: Rahul Krishna
@PROVEPRAViewPay
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
     And User enters tin for UPA View Payments Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
     When Click on View Payments Link for UPA 
     And Validate all other columns in Show All State for UPA
     And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
     And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	   And validate new Entry is created in Ole.EPRA_STATUS with appropriate status for Consol_Pay_Nbr
	   And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
     And validate record is inserted in User_Event_Log.
    # And User validates EPRA file is present in NAS Drive and delete it in both EPRA_STATUS Table, Nas Drive
  

Examples:     
       
             |       credentials      |priority |searchBy|   usertype     |		Search Criteria			|
             |       PROV_Admin       |     1   |  EPRA  |			PROV			|		viewPayments				|
             #|       PROV_Admin       |     2   |  EPRA  |		  PROV		  |		viewPayments			  |
            # |       PROV_Gen         |		  1	  |	EPRA	 |			PROV			|		viewPayments				|

         
  
  
  
   
  Scenario Outline: TS_001,010,012--View Payments EPRA Provider Payment No click
	
	    Given User navigates to UPA portal and enters "<credentials>" and login
      And User enters tin for UPA View Payments Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
      When Click on View Payments Link for UPA 
      And Validate all other columns in Show All State for UPA
      And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
			And User clicks on print request button present on Remittance Detail screen.
			And User clicks on Print Available button on Remittance Detail screen.
			And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
			And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
			And validate download status is set to Y in Ole.EPRA_STATUS
			And validate record is inserted in User_Event_Log for Remittance Detail   
	
	Examples:     
       
             |       credentials      |priority |searchBy|   usertype     |		Search Criteria			|
             |       PROV_Admin       |     1   |  EPRA  |			PROV			|		viewPayments				|
             #|       PROV_Admin       |     2   |  EPRA  |		  PROV		  |		viewPayments			  |
            # |       PROV_Gen         |		  1	  |	EPRA	 |			PROV			|		viewPayments				|
            
            
            
Scenario Outline: TS_001,010,012--View Payments EPRA BS
	
		 Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     And User enters tin for BS UPA "<Payment Type>" for BS for "<priority>" and click on continue button
     And Validate all other columns in Show All State for UPA
     And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
     And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	   And validate new Entry is created in Ole.EPRA_STATUS with appropriate status for Consol_Pay_Nbr
	   And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
     And validate record is inserted in User_Event_Log.
      #And User validates EPRA file is present in NAS Drive and delete it in both EPRA_STATUS Table, Nas Drive
     

Examples:     
       
         |   		 Payment Type		  |       credentials      |priority |   Search Criteria		|
         |        EPRABSViewPay   |       BS_Admin         |		1	   |   viewPayments				|
        # |        BS Gen         |       BS_Gen           |		1	   |   viewPayments				|
        
        
        

Scenario Outline: TS_001,010,012--View Payments EPRA BS Payment No click
	
		 Given User navigates to UPA portal and enters "<credentials>" and login
     When Click on View Payments Link for UPA
     And User enters tin for BS UPA "<Payment Type>" for BS for "<priority>" and click on continue button
     And Validate all other columns in Show All State for UPA
     And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
			And User clicks on print request button present on Remittance Detail screen.
			And User clicks on Print Available button on Remittance Detail screen.
			And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
			And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
			And validate download status is set to Y in Ole.EPRA_STATUS
			And validate record is inserted in User_Event_Log for Remittance Detail

Examples:     
       
         |   		 Payment Type		  |       credentials      |priority |   Search Criteria		|
         |        EPRABSViewPay   |       BS_Admin         |		1	   |   viewPayments				|
        # |        BS Gen         |       BS_Gen           |		1	   |   viewPayments				|       