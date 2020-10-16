#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.
# Few test cases may fail due to existing PROD issue (It may not identify payment number)

 @UPASrchRemitEPRA  @UPARegression @UPAProvSrchRemittanceEPRA  
Feature: UPA_EPRA_Srch_Remittance_RemittanceDetail_PROV 


Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User clicks on Search Remittance link for UPA
	Then User enters "<Search Criteria>" and click on search button.
  And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on print request button present on Remittance Detail screen.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for Remittance Detail
	
	
	Examples:
	
						|		Search Criteria			       |			    credentials			  |			priority		|			searchBy		   |   usertype    |
			  		|	EPRAElectronicPaymentNo	     |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRAElectronicPaymentNo	     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
				 	  |			EPRADOPAndNpi		         |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
		        |			EPRADOPAndNpi		         |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
		 			  |	EPRADOPAndAccountNo  			   |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
		    		|	EPRADOPAndAccountNo			     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRADOP&SubscriberID		     |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRADOP&SubscriberID		     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRADOPAndPatientNm			     |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRADOPAndPatientNm			     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	EPRADOPAndRenderingProvider  |			    PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
			  		|	EPRADOPAndRenderingProvider  |			    PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
			  		|	EPRAElectronicPaymentNo	     |					PROV_Gen   				|					1				|			EPRAPROVGen		 |    PROV       |
  					|	EPRAElectronicPaymentNo	     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
					  |			EPRADOPAndNpi		         |					PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
			      |			EPRADOPAndNpi		         |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
					  |	EPRADOPAndAccountNo			     |					PROV_Gen  				|					1				|			EPRAPROVGen	   |    PROV       |
		    		|	EPRADOPAndAccountNo			     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	EPRADOP&SubscriberID		     |					PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
						|	EPRADOP&SubscriberID		     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	EPRADOPAndPatientNm			     |					PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
  					|	EPRADOPAndPatientNm			     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	EPRADOPAndRenderingProvider  |			    PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
			  		|	EPRADOPAndRenderingProvider  |			    PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
			  		
	
# Few times when we click on Print available button it is behaving as Print Request Functionality, so test cases are failing			  		

Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
	Given User navigates to UPA portal and enters "<credentials>" and login
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User clicks on Search Remittance link for UPA
	Then User enters "<Search Criteria>" and click on search button.
  And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
  And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS 
	And validate record is inserted in User_Event_Log for Remittance Detail
	
	Examples:
	
						|		Search Criteria			       |			    credentials			  |			priority		|			searchBy		                  |   usertype    |
			  		|	EPRAElectronicPaymentNo	     |					PROV_Admin				|					1				|			EPRAgeneratedPROVAdmin		    |    PROV       |
						|	EPRAElectronicPaymentNo	     |					PROV_Admin				|					2				|			EPRAgeneratedPROVAdmin				|    PROV       |
					  |			EPRADOPAndNpi		         |					PROV_Admin				|					1				|			EPRAgeneratedPROVAdmin				|    PROV       |
			      |			EPRADOPAndNpi		         |					PROV_Admin				|					2				|			EPRAgeneratedPROVAdmin				|    PROV       |
				    |	EPRADOPAndAccountNo			     |					PROV_Admin				|					1				|			EPRAgeneratedPROVAdmin				|    PROV       |
		    		|	EPRADOPAndAccountNo			     |					PROV_Admin				|					2				|			EPRAgeneratedPROVAdmin				|    PROV       |
						|	PRADOP&SubscriberID		       |					PROV_Admin				|					1				|			EPRAgeneratedPROVAdmin				|    PROV       |
						|	PRADOP&SubscriberID		       |					PROV_Admin				|					2				|			EPRAgeneratedPROVAdmin				|    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Admin				|					1				|			EPRAgeneratedPROVAdmin				|    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Admin				|					2				|			EPRAgeneratedPROVAdmin				|    PROV       |
						|	EPRADOPAndPatientNm			     |					PROV_Admin				|					1				|			EPRAgeneratedPROVAdmin				|    PROV       |
						|	EPRADOPAndPatientNm			     |					PROV_Admin				|					2				|			EPRAgeneratedPROVAdmin				|    PROV       |
						|	EPRADOPAndRenderingProvider  |			    PROV_Admin				|					1				|			EPRAgeneratedPROVAdmin				|    PROV       |
			  		|	EPRADOPAndRenderingProvider  |			    PROV_Admin				|					2				|			EPRAgeneratedPROVAdmin				|    PROV       |
			  		|	EPRAElectronicPaymentNo	     |					PROV_Gen   				|					1				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	EPRAElectronicPaymentNo	     |					PROV_Gen  				|					2				|			EPRAgeneratedPROVGen				  |    PROV       |
					  |			EPRADOPAndNpi		         |					PROV_Gen  				|					1				|			EPRAgeneratedPROVGen				  |    PROV       |
			      |			EPRADOPAndNpi		         |					PROV_Gen  				|					2				|			EPRAgeneratedPROVGen				  |    PROV       |
					  |	EPRADOPAndAccountNo			     |					PROV_Gen  				|					1				|			EPRAgeneratedPROVGen				  |    PROV       |
		    		|	EPRADOPAndAccountNo			     |					PROV_Gen  				|					2				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	PRADOP&SubscriberID		       |					PROV_Gen  				|					1				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	PRADOP&SubscriberID		       |					PROV_Gen  				|					2				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Gen  				|					1				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	EPRADOPAndClaimNo				     | 				  PROV_Gen  				|					2				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	EPRADOPAndPatientNm			     |					PROV_Gen  				|					1				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	EPRADOPAndPatientNm			     |					PROV_Gen  				|					2				|			EPRAgeneratedPROVGen				  |    PROV       |
						|	EPRADOPAndRenderingProvider  |			    PROV_Gen  				|					1				|			EPRAgeneratedPROVGen				  |    PROV       |
			  		|	EPRADOPAndRenderingProvider  |			    PROV_Gen  				|					2				|			EPRAgeneratedPROVGen				  |    PROV       |