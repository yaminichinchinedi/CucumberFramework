#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.
# If any scripts fail due to unable to find payment number then it is an expected Prod Issue

@CSREPRASrchRemitDtl  @CSRRegression @CSRSrchRemittanceEPRA
Feature: CSR_EPRA_Srch_Remittance_RemittanceDetail


Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	#Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on print request button present on Remittance Detail screen.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for Remittance Detail for CSR "<credentials>"

	
	Examples:
	
						|		Search Criteria			    |			credentials			|			priority		|			searchBy		|usertype    |
			  		|	byElectronicPaymentNo	    |					Super				|					1				|			EPRA				| PROV       |
				  	|	byElectronicPaymentNo	    |					Super				|					2				|			EPRA				| PROV       |
						|			byDOPAndNpi				    |					Super				|					1				|			EPRA				| PROV       |
			      |			byDOPAndNpi				    |					Super				|					2				|			EPRA				| PROV       |
					  |	byDOPAndAccountNo			    |					Super				|					1				|			EPRA				| PROV       |
		      	|	byDOPAndAccountNo			    |					Super				|					2				|			EPRA				| PROV       |
						|	byDOP&SubscriberID		    |					Super				|					1				|			EPRA				| PROV       |
			    	|	byDOP&SubscriberID		    |					Super				|					2				|			EPRA				| PROV       |
			    	|	byDOPAndClaimNo				    | 				Super				|					1				|			EPRA				| PROV       |
			    	|	byDOPAndClaimNo				    | 				Super				|					2				|			EPRA				| PROV       |
			    	|	byDOPAndPatientNm			    |					Super				|					1				|			EPRA				| PROV       |
			    	|	byDOPAndPatientNm			    |					Super				|					2				|			EPRA				| PROV       |
			    	|	byDOPAndRenderingProvider |			    Super				|					1				|			EPRA				| PROV       |
			    	|	byDOPAndRenderingProvider |			    Super				|					2				|			EPRA				| PROV       |
			    	|	byElectronicPaymentNo	    |					RO				  |					1				|			EPRA				| PROV       |
			    	|	byElectronicPaymentNo	    |					RO				  |					2				|			EPRA				| PROV       |
			    	|			byDOPAndNpi				    |					RO			  	|					1				|			EPRA				| PROV       |
			    	|			byDOPAndNpi				    |					RO				  |					2				|			EPRA				| PROV       |
			   	  |	byDOPAndAccountNo			    |					RO				  |					1				|			EPRA				| PROV       |
			     	|	byDOPAndAccountNo			    |					RO				  |					2				|			EPRA				| PROV       |
			     	|	byDOP&SubscriberID		    |					RO				  |					1				|			EPRA				| PROV       |
			    	|	byDOP&SubscriberID		    |					RO				  |					2				|			EPRA				| PROV       |
			    	|	byDOPAndClaimNo				    |  				RO				  |					1				|			EPRA				| PROV       |
			    	|	byDOPAndClaimNo				    |  				RO				  |					2				|			EPRA				| PROV       |
			    	|	byDOPAndPatientNm			    |					RO				  |					1				|			EPRA				| PROV       |
			    	|	byDOPAndPatientNm			    |					RO				  |					2				|			EPRA				| PROV       |
			    	|	byDOPAndRenderingProvider |				  RO				  |					1				|			EPRA				| PROV       |
			    	|	byDOPAndRenderingProvider |				  RO				  |					2				|			EPRA				| PROV       |
			    	|	byElectronicPaymentNo	    |					RW				  |					1				|			EPRA				| PROV       |
				  	|	byElectronicPaymentNo	    |					RW				  |					2				|			EPRA				| PROV       |
				  	|			byDOPAndNpi				    |					RW				  |					1				|			EPRA				| PROV       |
				  	|			byDOPAndNpi				    |					RW				  |					2				|			EPRA				| PROV       |
				  	|	byDOPAndAccountNo			    |					RW				  |					1				|			EPRA				| PROV       |
			    	|	byDOPAndAccountNo			    |					RW				  |					2				|			EPRA				| PROV       |
				  	|	byDOP&SubscriberID		    |					RW				  |					1				|			EPRA				| PROV       |
			    	|	byDOP&SubscriberID		    |					RW				  |					2				|			EPRA				| PROV       |
			    	|	byDOPAndClaimNo				    |  				RW				  |					1				|			EPRA				| PROV       |
			    	|	byDOPAndClaimNo				    |  				RW				  |					2				|			EPRA				| PROV       |
			    	|	byDOPAndPatientNm			    |					RW				  |					1				|			EPRA				| PROV       |
			    	|	byDOPAndPatientNm			    |					RW				  |					2				|			EPRA				| PROV       |
			    	|	byDOPAndRenderingProvider |				  RW				  |					1				|			EPRA				| PROV       |
			    	|	byDOPAndRenderingProvider |				  RW				  |					2				|			EPRA				| PROV       |


Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	#Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS 
	And validate record is inserted in User_Event_Log for Remittance Detail for CSR "<credentials>"
	
	Examples:
	
						|		Search Criteria			    |			credentials			|			priority		|			searchBy		        |usertype   |
			  		|	byElectronicPaymentNo	    |					Super				|					1				|			EPRAgenerated		    |PROV       |		
				  	|	byElectronicPaymentNo	    |					Super				|					2				|			EPRAgenerated				|PROV       |		
						|			byDOPAndNpi				    |					Super				|					1				|			EPRAgenerated				|PROV       |		
			      |			byDOPAndNpi				    |					Super				|					2				|			EPRAgenerated				|PROV       |		
					  |	byDOPAndAccountNo			    |					Super				|					1				|			EPRAgenerated				|PROV       |		
		      	|	byDOPAndAccountNo			    |					Super				|					2				|			EPRAgenerated				|PROV       |		
						|	byDOP&SubscriberID		    |					Super				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOP&SubscriberID		    |					Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				    | 				Super				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				    | 				Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			    |					Super				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			    |					Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndRenderingProvider |			    Super				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndRenderingProvider |			    Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byElectronicPaymentNo	    |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byElectronicPaymentNo	    |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|			byDOPAndNpi				    |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|			byDOPAndNpi				    |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndAccountNo			    |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndAccountNo			    |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOP&SubscriberID		    |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOP&SubscriberID		    |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				    |  					RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				    |  					RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			    |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			    |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndRenderingProvider |				    RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndRenderingProvider |				    RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byElectronicPaymentNo	    |						RW				|					1				|			EPRAgenerated				|PROV       |		
				  	|	byElectronicPaymentNo	    |						RW				|					2				|			EPRAgenerated				|PROV       |		
				  	|			byDOPAndNpi				    |						RW				|					1				|			EPRAgenerated				|PROV       |		
				  	|			byDOPAndNpi				    |						RW				|					2				|			EPRAgenerated				|PROV       |		
				  	|	byDOPAndAccountNo			    |						RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndAccountNo			    |						RW				|					2				|			EPRAgenerated				|PROV       |		
				  	|	byDOP&SubscriberID		    |						RW				|					1				|			EPRAgenerated				|PROV       |		
				  	|	byDOP&SubscriberID		    |						RW				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				    |  					RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				    |  					RW				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			    |						RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			    |						RW				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndRenderingProvider |				    RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndRenderingProvider |				    RW				|					2				|			EPRAgenerated				|PROV       |		
			    


																