#Author: Athyusha, Mohammad Khalid(Stabilisation)
#PPS.4012 job should be running to execute these test cases.
# If any scripts fail due to unable to find payment number then it is an expected Prod Issue
@CSREPRASrchRemitDtl  @CSRRegression @CSRSrchRemittanceEPRA
Feature: CSR_EPRA_Srch_Remittance_RemittanceDetail

@CSR_Stabilisation_SR_RD_Complete
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on print request button present on Remittance Detail screen.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for Remittance Detail for CSR "<credentials>"
	And User clicks on CSR logout

	
	Examples: 
	
    	|		Search Criteria			|			credentials			|			priority		|			searchBy		|usertype    |
		|	EPRAElectronicPaymentNo	    |					Super				|					1				|			EPRA				| PROV       |
		|	EPRAElectronicPaymentNo	    |					Super				|					2				|			EPRA				| PROV       |
		|			EPRADOPAndNpi		|					Super				|					1				|			EPRA				| PROV       |
		|			EPRADOPAndNpi		|					Super				|					2				|			EPRA				| PROV       |
		|	EPRADOPAndAccountNo			|					Super				|					1				|			EPRA				| PROV       |
    	|	EPRADOPAndAccountNo			|					Super				|					2				|			EPRA				| PROV       |
		|	EPRADOP&SubscriberID		|					Super				|					1				|			EPRA				| PROV       |
		|	EPRADOP&SubscriberID		|					Super				|					2				|			EPRA				| PROV       |
		|	EPRADOPAndClaimNo			| 				Super				|					1				|			EPRA				| PROV       |
		|	EPRADOPAndClaimNo			| 				Super				|					2				|			EPRA				| PROV       |
		|	EPRADOPAndPatientNm			|					Super				|					1				|			EPRA				| PROV       |
		|	EPRADOPAndPatientNm			|					Super				|					2				|			EPRA				| PROV       |
		|	EPRADOPAndRenderingProvider |			    Super				|					1				|			EPRA				| PROV       |
	    |	EPRADOPAndRenderingProvider |			    Super				|					2				|			EPRA				| PROV       |
		|	EPRAElectronicPaymentNo	    |					RO				  |					1				|			EPRA				| PROV       |
		|	EPRAElectronicPaymentNo	    |					RO				  |					2				|			EPRA				| PROV       |
		|			EPRADOPAndNpi		|					RO			  	|					1				|			EPRA				| PROV       |
		|			EPRADOPAndNpi		|					RO				  |					2				|			EPRA				| PROV       |
		|	EPRADOPAndAccountNo			|					RO				  |					1				|			EPRA				| PROV       |
		|	EPRADOPAndAccountNo			|					RO				  |					2				|			EPRA				| PROV       |
	    |	EPRADOP&SubscriberID		|					RO				  |					1				|			EPRA				| PROV       |
		|	EPRADOP&SubscriberID		|					RO				  |					2				|			EPRA				| PROV       |
		|	byDOPAndClaimNo				|  				RO				  |					1				|			EPRA				| PROV       |
    	|	byDOPAndClaimNo				|  				RO				  |					2				|			EPRA				| PROV       |
		|	EPRADOPAndPatientNm			|					RO				  |					1				|			EPRA				| PROV       |
		|	EPRADOPAndPatientNm			|					RO				  |					2				|			EPRA				| PROV       |
	    |	EPRADOPAndRenderingProvider |				  RO				  |					1				|			EPRA				| PROV       |
		|	EPRADOPAndRenderingProvider |				  RO				  |					2				|			EPRA				| PROV       |
		|	byElectronicPaymentNo	    |					RW				  |					1				|			EPRA				| PROV       |
		|	byElectronicPaymentNo	    |					RW				  |					2				|			EPRA				| PROV       |
		|			EPRADOPAndNpi		|					RW				  |					1				|			EPRA				| PROV       |
		|			EPRADOPAndNpi		|					RW				  |					2				|			EPRA				| PROV       |
		|	EPRADOPAndAccountNo			|					RW				  |					1				|			EPRA				| PROV       |
		|	EPRADOPAndAccountNo			|					RW				  |					2				|			EPRA				| PROV       |
		|	EPRADOP&SubscriberID		|					RW				  |					1				|			EPRA				| PROV       |
		|	EPRADOP&SubscriberID		|					RW				  |					2				|			EPRA				| PROV       |
		|	EPRADOPAndClaimNo			|  				RW				  |					1				|			EPRA				| PROV       |
		|	EPRADOPAndClaimNo			|  				RW				  |					2				|			EPRA				| PROV       |
    	|	EPRADOPAndPatientNm			|					RW				  |					1				|			EPRA				| PROV       |
		|	EPRADOPAndPatientNm			|					RW				  |					2				|			EPRA				| PROV       |
		|	EPRADOPAndRenderingProvider |				  RW				  |					1				|			EPRA				| PROV       |
		|	EPRADOPAndRenderingProvider |				  RW				  |					2				|			EPRA				| PROV       |

	@CSR_Stabilisation_SR_RD_Existing
Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS 
	And validate record is inserted in User_Event_Log for Remittance Detail for CSR "<credentials>"
	And User clicks on CSR logout
	
	Examples:
	
						|		Search Criteria			      |			credentials			|			priority		|			searchBy		        |usertype   |
			  		|	EPRAElectronicPaymentNo	    |					Super				|					1				|			EPRAgenerated		    |PROV       |		
				  	|	EPRAElectronicPaymentNo	    |					Super				|					2				|			EPRAgenerated				|PROV       |		
						|			EPRADOPAndNpi				    |					Super				|					1				|			EPRAgenerated				|PROV       |		
			      |			EPRADOPAndNpi				    |					Super				|					2				|			EPRAgenerated				|PROV       |		
					  |	EPRADOPAndAccountNo			    |					Super				|					1				|			EPRAgenerated				|PROV       |		
		      	|	EPRADOPAndAccountNo			    |					Super				|					2				|			EPRAgenerated				|PROV       |		
						|	EPRADOP&SubscriberID		    |					Super				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOP&SubscriberID		    |					Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndClaimNo				    | 				Super				|					1				|			EPRAgenerated				|PROV       |		
		    	|	EPRADOPAndClaimNo				    | 				Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndPatientNm			    |					Super				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndPatientNm			    |					Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndRenderingProvider |			    Super				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndRenderingProvider |			    Super				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byElectronicPaymentNo	      |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byElectronicPaymentNo	      |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|			EPRADOPAndNpi				    |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|			EPRADOPAndNpi				    |						RO				|					2				|			EPRAgenerated				|PROV       |		
		    	|	EPRADOPAndAccountNo			    |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndAccountNo			    |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOP&SubscriberID		    |						RO				|					1				|			EPRAgenerated				|PROV       |		
		    	|	EPRADOP&SubscriberID		    |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				      |  					RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndClaimNo				      |  					RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			      |						RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	byDOPAndPatientNm			      |						RO				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndRenderingProvider |				    RO				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndRenderingProvider |				    RO				|					2				|			EPRAgenerated				|PROV       |		
		    	|	EPRAElectronicPaymentNo	    |						RW				|					1				|			EPRAgenerated				|PROV       |		
				  	|	EPRAElectronicPaymentNo	    |						RW				|					2				|			EPRAgenerated				|PROV       |		
				  	|			EPRADOPAndNpi				    |						RW				|					1				|			EPRAgenerated				|PROV       |		
				  	|			EPRADOPAndNpi				    |						RW				|					2				|			EPRAgenerated				|PROV       |		
				  	|	EPRADOPAndAccountNo			    |						RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndAccountNo			    |						RW				|					2				|			EPRAgenerated				|PROV       |		
				  	|	EPRADOP&SubscriberID		    |						RW				|					1				|			EPRAgenerated				|PROV       |		
				  	|	EPRADOP&SubscriberID		    |						RW				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndClaimNo				    |  					RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndClaimNo				    |  					RW				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndPatientNm			    |						RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndPatientNm			    |						RW				|					2				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndRenderingProvider |				    RW				|					1				|			EPRAgenerated				|PROV       |		
			    	|	EPRADOPAndRenderingProvider |				    RW				|					2				|			EPRAgenerated				|PROV       |		
    


																