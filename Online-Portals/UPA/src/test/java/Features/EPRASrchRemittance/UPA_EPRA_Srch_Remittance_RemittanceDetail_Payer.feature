#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.

@UPASrchRemitEPRAPayer  @UPARegression
Feature: UPA_EPRA_Srch_Remittance_RemittanceDetail_Payer 

# there is no data for NPI and Rendering Provider Name


@UPASrchRemitEPRAPayer1
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
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		        |   usertype     |
			  	  |			byDOPAndNpi		         |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |

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
	
						|		Search Criteria			     |			    credentials			  |			priority		|			searchBy		        |   usertype     |
			  		|	byElectronicPaymentNo	     |					PAY_Admin				  |					1				|			EPRAPayerAdmin			|    Payer       |
						|	byElectronicPaymentNo	     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
					  |			byDOPAndNpi		         |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
			      |			byDOPAndNpi		         |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
					  |	byDOPAndAccountNo			     |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
		    		|	byDOPAndAccountNo			     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
				#		|	byDOPAndRenderingProvider  |			    PAY_Admin  				|					1				|			EPRAPayerAdmin			|    Payer       |
			  #		|	byDOPAndRenderingProvider  |			    PAY_Admin  				|					2				|			EPRAPayerAdmin			|    Payer       |
			  		|	byElectronicPaymentNo	     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	byElectronicPaymentNo	     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
				#	  |			byDOPAndNpi		         |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
			  #   |			byDOPAndNpi		         |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
					  |	byDOPAndAccountNo			     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
		    		|	byDOPAndAccountNo			     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
				#		|	byDOPAndRenderingProvider  |			    PAY_Gen    				|					1				|			EPRAPayerGen				|    Payer       |
			  #		|	byDOPAndRenderingProvider  |			    PAY_Gen    				|					2				|			EPRAPayerGen				|    Payer       |
			
			


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
			  		|	byElectronicPaymentNo	     |					PAY_Admin				  |					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	byElectronicPaymentNo	     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
				#	  |			byDOPAndNpi		         |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
			  #   |			byDOPAndNpi		         |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
					  |	byDOPAndAccountNo			     |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
		    		|	byDOPAndAccountNo			     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
				#		|	byDOPAndRenderingProvider  |			    PAY_Admin  				|					1				|			EPRAPayergeneratedAdmin		 |    Payer       |
			  #		|	byDOPAndRenderingProvider  |			    PAY_Admin  				|					2				|			EPRAPayergeneratedAdmin		 |    Payer       |
			  		|	byElectronicPaymentNo	     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	byElectronicPaymentNo	     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
				#	  |			byDOPAndNpi		         |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
			  #   |			byDOPAndNpi		         |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
					  |	byDOPAndAccountNo			     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
		    		|	byDOPAndAccountNo			     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	byDOP&SubscriberID		     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	byDOPAndClaimNo				     | 				  PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
						|	byDOPAndPatientNm			     |					PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |
				#		|	byDOPAndRenderingProvider  |			    PAY_Gen    				|					1				|			EPRAPayergeneratedGen			 |    Payer       |
			  #		|	byDOPAndRenderingProvider  |			    PAY_Gen    				|					2				|			EPRAPayergeneratedGen			 |    Payer       |