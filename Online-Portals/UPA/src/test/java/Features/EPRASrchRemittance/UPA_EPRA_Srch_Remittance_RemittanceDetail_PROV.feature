#Author: Amit Kushwah
#PPS.4012 job should be running to execute these test cases.

@UPASrchRemitEPRA  @UPARegression
Feature: Search Remittance Payment Number 


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
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		   |   usertype    |
			  		|	byElectronicPaymentNo	     |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	byElectronicPaymentNo	     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
				 	  |			byDOPAndNpi		         |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
		        |			byDOPAndNpi		         |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
		 			  |	byDOPAndAccountNo			     |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
		    		|	byDOPAndAccountNo			     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
						|	byDOPAndRenderingProvider  |			    PROV_Admin				|					1				|			EPRAPROVAdmin	 |    PROV       |
			  		|	byDOPAndRenderingProvider  |			    PROV_Admin				|					2				|			EPRAPROVAdmin	 |    PROV       |
			  		|	byElectronicPaymentNo	     |					PROV_Gen   				|					1				|			EPRAPROVGen		 |    PROV       |
  					|	byElectronicPaymentNo	     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
					  |			byDOPAndNpi		         |					PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
			      |			byDOPAndNpi		         |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
					  |	byDOPAndAccountNo			     |					PROV_Gen  				|					1				|			EPRAPROVGen	   |    PROV       |
		    		|	byDOPAndAccountNo			     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
						|	byDOPAndRenderingProvider  |			    PROV_Gen  				|					1				|			EPRAPROVGen		 |    PROV       |
			  		|	byDOPAndRenderingProvider  |			    PROV_Gen  				|					2				|			EPRAPROVGen		 |    PROV       |
			
			

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
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		                  |   usertype    |
			  		|	byElectronicPaymentNo	     |					PROV_Admin				|					1				|			EPRAgeneratedProvAdmin		    |    PROV       |
						|	byElectronicPaymentNo	     |					PROV_Admin				|					2				|			EPRAgeneratedProvAdmin				|    PROV       |
					  |			byDOPAndNpi		         |					PROV_Admin				|					1				|			EPRAgeneratedProvAdmin				|    PROV       |
			      |			byDOPAndNpi		         |					PROV_Admin				|					2				|			EPRAgeneratedProvAdmin				|    PROV       |
				    |	byDOPAndAccountNo			     |					PROV_Admin				|					1				|			EPRAgeneratedProvAdmin				|    PROV       |
		    		|	byDOPAndAccountNo			     |					PROV_Admin				|					2				|			EPRAgeneratedProvAdmin				|    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Admin				|					1				|			EPRAgeneratedProvAdmin				|    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Admin				|					2				|			EPRAgeneratedProvAdmin				|    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Admin				|					1				|			EPRAgeneratedProvAdmin				|    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Admin				|					2				|			EPRAgeneratedProvAdmin				|    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Admin				|					1				|			EPRAgeneratedProvAdmin				|    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Admin				|					2				|			EPRAgeneratedProvAdmin				|    PROV       |
						|	byDOPAndRenderingProvider  |			    PROV_Admin				|					1				|			EPRAgeneratedProvAdmin				|    PROV       |
			  		|	byDOPAndRenderingProvider  |			    PROV_Admin				|					2				|			EPRAgeneratedProvAdmin				|    PROV       |
			  		|	byElectronicPaymentNo	     |					PROV_Gen   				|					1				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byElectronicPaymentNo	     |					PROV_Gen  				|					2				|			EPRAgeneratedProvGen				  |    PROV       |
					  |			byDOPAndNpi		         |					PROV_Gen  				|					1				|			EPRAgeneratedProvGen				  |    PROV       |
			      |			byDOPAndNpi		         |					PROV_Gen  				|					2				|			EPRAgeneratedProvGen				  |    PROV       |
					  |	byDOPAndAccountNo			     |					PROV_Gen  				|					1				|			EPRAgeneratedProvGen				  |    PROV       |
		    		|	byDOPAndAccountNo			     |					PROV_Gen  				|					2				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Gen  				|					1				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byDOP&SubscriberID		     |					PROV_Gen  				|					2				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Gen  				|					1				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byDOPAndClaimNo				     | 				  PROV_Gen  				|					2				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Gen  				|					1				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byDOPAndPatientNm			     |					PROV_Gen  				|					2				|			EPRAgeneratedProvGen				  |    PROV       |
						|	byDOPAndRenderingProvider  |			    PROV_Gen  				|					1				|			EPRAgeneratedProvGen				  |    PROV       |
			  		|	byDOPAndRenderingProvider  |			    PROV_Gen  				|					2				|			EPRAgeneratedProvGen				  |    PROV       |