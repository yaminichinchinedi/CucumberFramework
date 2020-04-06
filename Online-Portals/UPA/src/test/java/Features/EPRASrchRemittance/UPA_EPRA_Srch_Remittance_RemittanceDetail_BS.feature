#Author: Amit Kushwah
#PPS.4012 job should be running to execute these test cases.

@UPASrchRemitEPRA  @UPARegression
Feature: Search Remittance Payment Number 


Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
  And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on print request button present on Remittance Detail screen.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for Remittance Detail
	
	
	Examples:
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		      |   usertype  |
			  		|	byElectronicPaymentNo	     |					BS_Admin				  |					1				|			EPRABSAdmin				|    BS       |
						|	byElectronicPaymentNo	     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
					  |			byDOPAndNpi		         |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
			      |			byDOPAndNpi		         |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
					  |	byDOPAndAccountNo			     |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
		    		|	byDOPAndAccountNo			     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	byDOP&SubscriberID		     |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
						|	byDOP&SubscriberID		     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	byDOPAndPatientNm			     |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
						|	byDOPAndPatientNm			     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	byDOPAndRenderingProvider  |			    BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
			  		|	byDOPAndRenderingProvider  |			    BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
			  		|	byElectronicPaymentNo	     |					BS_Gen    				|					1				|			EPRABSGen 				|    BS       |
						|	byElectronicPaymentNo	     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
					  |			byDOPAndNpi		         |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
			      |			byDOPAndNpi		         |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
					  |	byDOPAndAccountNo			     |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
		    		|	byDOPAndAccountNo			     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	byDOP&SubscriberID		     |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
						|	byDOP&SubscriberID		     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	byDOPAndPatientNm			     |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
						|	byDOPAndPatientNm			     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	byDOPAndRenderingProvider  |			    BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
			  		|	byDOPAndRenderingProvider  |			    BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
			
			


Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
  And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
  And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS 
	And validate record is inserted in User_Event_Log for Remittance Detail
	
	Examples:
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		                |   usertype  |
			  		|	byElectronicPaymentNo	     |					BS_Admin				  |					1				|			EPRAgeneratedBSAdmin	      |    BS       |
						|	byElectronicPaymentNo	     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin		    |    BS       |
					  |			byDOPAndNpi		         |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
			      |			byDOPAndNpi		         |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
					  |	byDOPAndAccountNo			     |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
		    		|	byDOPAndAccountNo			     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	byDOP&SubscriberID		     |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
						|	byDOP&SubscriberID		     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	byDOPAndPatientNm			     |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
						|	byDOPAndPatientNm			     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	byDOPAndRenderingProvider  |			    BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
			  		|	byDOPAndRenderingProvider  |			    BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
			  		|	byElectronicPaymentNo	     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
						|	byElectronicPaymentNo	     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
					  |			byDOPAndNpi		         |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
			      |			byDOPAndNpi		         |					BS_Gen    				|					2				|			EPRAgeneratedBSGen			  	|    BS       |
					  |	byDOPAndAccountNo			     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
		    		|	byDOPAndAccountNo			     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	byDOP&SubscriberID		     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
						|	byDOP&SubscriberID		     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Gen    				|					1				|			EPRAgeneratedBSGen		  		|    BS       |
						|	byDOPAndClaimNo				     | 				  BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	byDOPAndPatientNm			     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
						|	byDOPAndPatientNm			     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	byDOPAndRenderingProvider  |			    BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
			  		|	byDOPAndRenderingProvider  |			    BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |