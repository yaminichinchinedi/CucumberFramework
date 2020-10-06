#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.
# The query is fecthing data for EPRA Generated related payment Numbers, so not getting Print request and able to see print available
# Few test cases may fail due to existing PROD issue (Issue: It may not identify Payment Number)

@UPASrchRemitEPRA  @UPARegression @UPABSSrchRemittanceEPRA
Feature: UPA_EPRA_Srch_Remittance_RemittanceDetail_BS 


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
	
						|		Search Criteria			       |			    credentials			  |			priority		|			searchBy		      |   usertype  |
			  		|	EPRAElectronicPaymentNo	     |					BS_Admin				  |					1				|			EPRABSAdmin				|    BS       |
						|	EPRAElectronicPaymentNo	     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
					  |			EPRADOPAndNpi		         |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
			      |			EPRADOPAndNpi		         |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
					  |	EPRADOPAndAccountNo			     |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
		    		|	EPRADOPAndAccountNo			     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	EPRADOPAndClaimNo				     | 				  BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
						|	EPRADOPAndClaimNo				     | 				  BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
						|	EPRADOPAndRenderingProvider  |			    BS_Admin  				|					1				|			EPRABSAdmin				|    BS       |
			  		|	EPRADOPAndRenderingProvider  |			    BS_Admin  				|					2				|			EPRABSAdmin				|    BS       |
			  		|	EPRAElectronicPaymentNo	     |					BS_Gen    				|					1				|			EPRABSGen 				|    BS       |
						|	EPRAElectronicPaymentNo	     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
					  |			EPRADOPAndNpi		         |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
			      |			EPRADOPAndNpi		         |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
					  |	EPRADOPAndAccountNo			     |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
		    		|	EPRADOPAndAccountNo			     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	EPRADOPAndClaimNo				     | 				  BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
						|	EPRADOPAndClaimNo				     | 				  BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Gen    				|					2				|			EPRABSGen				  |    BS       |
						|	EPRADOPAndRenderingProvider  |			    BS_Gen    				|					1				|			EPRABSGen				  |    BS       |
			      |	EPRADOPAndRenderingProvider  |			    BS_Gen    				|					2				|			EPRABSGen				  |    BS       |

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
			  		|	EPRAElectronicPaymentNo	     |					BS_Admin				  |					1				|			EPRAgeneratedBSAdmin	      |    BS       |
						|	EPRAElectronicPaymentNo	     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin		    |    BS       |
					  |			EPRADOPAndNpi		         |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
			      |			EPRADOPAndNpi		         |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
					  |	EPRADOPAndAccountNo			     |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
		    		|	EPRADOPAndAccountNo			     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	EPRADOPAndClaimNo				     | 				  BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
						|	EPRADOPAndClaimNo				     | 				  BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
						|	EPRADOPAndRenderingProvider  |			    BS_Admin  				|					1				|			EPRAgeneratedBSAdmin				|    BS       |
			  		|	EPRADOPAndRenderingProvider  |			    BS_Admin  				|					2				|			EPRAgeneratedBSAdmin				|    BS       |
			  		|	EPRAElectronicPaymentNo	     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
						|	EPRAElectronicPaymentNo	     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
					  |			EPRADOPAndNpi		         |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
			      |			EPRADOPAndNpi		         |					BS_Gen    				|					2				|			EPRAgeneratedBSGen			  	|    BS       |
					  |	EPRADOPAndAccountNo			     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
		    		|	EPRADOPAndAccountNo			     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
						|	EPRADOP&SubscriberID		     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	EPRADOPAndClaimNo	  		     | 				  BS_Gen    				|					1				|			EPRAgeneratedBSGen		  		|    BS       |
						|	EPRADOPAndClaimNo				     | 				  BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
						|	EPRADOPAndPatientNm			     |					BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |
						|	EPRADOPAndRenderingProvider  |			    BS_Gen    				|					1				|			EPRAgeneratedBSGen				  |    BS       |
			  		|	EPRADOPAndRenderingProvider  |			    BS_Gen    				|					2				|			EPRAgeneratedBSGen				  |    BS       |