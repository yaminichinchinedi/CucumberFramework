#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.
# there is no data for NPI and Rendering Provider Name 

@UPASrchRemitEPRA  @UPARegression @UPAPayerSrchRemittanceEPRA

Feature: UPA_EPRA_Srch_Remittance_RemittanceDetail_Payer 

Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
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
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		        |   usertype     |
			  		|	EPRAElectronicPaymentNo	     |					PAY_Admin				  |					1				|			EPRAPayerAdmin			|    Payer       |
						|	EPRAElectronicPaymentNo	     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
					  |			EPRADOPAndNpi		         |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
			      |			EPRADOPAndNpi		         |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
					  |	EPRADOPAndAccountNo			     |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
		    		|	EPRADOPAndAccountNo			     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
						|	EPRADOPAndRenderingProvider  |			    PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
			  		|	EPRADOPAndRenderingProvider  |			    PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
			  		|	EPRAElectronicPaymentNo	     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	EPRAElectronicPaymentNo	     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
					  |			EPRADOPAndNpi		         |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
			      |			EPRADOPAndNpi		         |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
					  |	EPRADOPAndAccountNo			     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
		    		|	EPRADOPAndAccountNo			     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
						|	EPRADOPAndRenderingProvider  |			    PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
			  		|	EPRADOPAndRenderingProvider  |			    PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
			
			


Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
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
	
				Examples:
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		               |   usertype     |
			  		|	EPRAElectronicPaymentNo	     |					PAY_Admin				  |					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRAElectronicPaymentNo	     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
					  |			EPRADOPAndNpi		         |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
			      |			EPRADOPAndNpi		         |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
					  |	EPRADOPAndAccountNo			     |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
		    		|	EPRADOPAndAccountNo			     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	EPRADOPAndRenderingProvider  |			    PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
			  		|	EPRADOPAndRenderingProvider  |			    PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
			  		|	EPRAElectronicPaymentNo	     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRAElectronicPaymentNo	     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
					  |			EPRADOPAndNpi		         |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
			      |			EPRADOPAndNpi		         |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
					  |	EPRADOPAndAccountNo			     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
		    		|	EPRADOPAndAccountNo			     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRADOP&SubscriberID		     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRADOPAndClaimNo				     | 				  PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRADOPAndPatientNm			     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
						|	EPRADOPAndRenderingProvider  |			    PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
			  		|	EPRADOPAndRenderingProvider  |			    PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |