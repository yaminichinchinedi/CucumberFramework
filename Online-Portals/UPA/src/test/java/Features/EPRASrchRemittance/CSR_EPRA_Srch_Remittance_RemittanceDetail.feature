#Author: Amit Kushwah
#PPS.4012 job should be running to execute these test cases.
# If any scripts fail due to unable to find payment number then it is an expected Prod Issue

@CSREPRASrchRemitDtl  @CSRRegression
Feature: Search Remittance Payment Number 


Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on print request button present on Remittance Detail screen.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for Remittance Detail for CSR "<credentials>"

	
	Examples:
	
						|		Search Criteria			    |			credentials			|			priority		|			searchBy		|
			  		|	byElectronicPaymentNo	    |					Super				|					1				|			EPRA				|
				  	|	byElectronicPaymentNo	    |					Super				|					2				|			EPRA				|
						|			byDOPAndNpi				    |					Super				|					1				|			EPRA				|
			      |			byDOPAndNpi				    |					Super				|					2				|			EPRA				|
					  |	byDOPAndAccountNo			    |					Super				|					1				|			EPRA				|
		      	|	byDOPAndAccountNo			    |					Super				|					2				|			EPRA				|
						|	byDOP&SubscriberID		    |					Super				|					1				|			EPRA				|
			    	|	byDOP&SubscriberID		    |					Super				|					2				|			EPRA				|
			    	|	byDOPAndClaimNo				    | 				Super				|					1				|			EPRA				|
			    	|	byDOPAndClaimNo				    | 				Super				|					2				|			EPRA				|
			    	|	byDOPAndPatientNm			    |					Super				|					1				|			EPRA				|
			    	|	byDOPAndPatientNm			    |					Super				|					2				|			EPRA				|
			    	|	byDOPAndRenderingProvider |			    Super				|					1				|			EPRA				|
			    	|	byDOPAndRenderingProvider |			    Super				|					2				|			EPRA				|
			    	|	byElectronicPaymentNo	    |					RO				  |					1				|			EPRA				|
			    	|	byElectronicPaymentNo	    |					RO				  |					2				|			EPRA				|
			    	|			byDOPAndNpi				    |					RO			  	|					1				|			EPRA				|
			    	|			byDOPAndNpi				    |					RO				  |					2				|			EPRA				|
			   	  |	byDOPAndAccountNo			    |					RO				  |					1				|			EPRA				|
			     	|	byDOPAndAccountNo			    |					RO				  |					2				|			EPRA				|
			     	|	byDOP&SubscriberID		    |					RO				  |					1				|			EPRA				|
			    	|	byDOP&SubscriberID		    |					RO				  |					2				|			EPRA				| 
			    	|	byDOPAndClaimNo				    |  				RO				  |					1				|			EPRA				|
			    	|	byDOPAndClaimNo				    |  				RO				  |					2				|			EPRA				| 
			    	|	byDOPAndPatientNm			    |					RO				  |					1				|			EPRA				|
			    	|	byDOPAndPatientNm			    |					RO				  |					2				|			EPRA				|
			    	|	byDOPAndRenderingProvider |				  RO				  |					1				|			EPRA				|
			    	|	byDOPAndRenderingProvider |				  RO				  |					2				|			EPRA				|
			    	|	byElectronicPaymentNo	    |					RW				  |					1				|			EPRA				|
				  	|	byElectronicPaymentNo	    |					RW				  |					2				|			EPRA				|
				  	|			byDOPAndNpi				    |					RW				  |					1				|			EPRA				|
				  	|			byDOPAndNpi				    |					RW				  |					2				|			EPRA				|
				  	|	byDOPAndAccountNo			    |					RW				  |					1				|			EPRA				|
			    	|	byDOPAndAccountNo			    |					RW				  |					2				|			EPRA				|
				  	|	byDOP&SubscriberID		    |					RW				  |					1				|			EPRA				|
			    	|	byDOP&SubscriberID		    |					RW				  |					2				|			EPRA				|
			    	|	byDOPAndClaimNo				    |  				RW				  |					1				|			EPRA				|
			    	|	byDOPAndClaimNo				    |  				RW				  |					2				|			EPRA				|
			    	|	byDOPAndPatientNm			    |					RW				  |					1				|			EPRA				|
			    	|	byDOPAndPatientNm			    |					RW				  |					2				|			EPRA				|
			    	|	byDOPAndRenderingProvider |				  RW				  |					1				|			EPRA				|
			    	|	byDOPAndRenderingProvider |				  RW				  |					2				|			EPRA				|
			    
			    

Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User clicks on Payment Number when "<Search Criteria>" and validate Remittance Detail page is opened.
	And User clicks on Print Available button on Remittance Detail screen.
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>"
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate download status is set to Y in Ole.EPRA_STATUS 
	And validate record is inserted in User_Event_Log for Remittance Detail for CSR "<credentials>"
	
	Examples:
	
						|		Search Criteria			    |			credentials			|			priority		|			searchBy		        |
			  		|	byElectronicPaymentNo	    |					Super				|					1				|			EPRAgenerated		    |
				  	|	byElectronicPaymentNo	    |					Super				|					2				|			EPRAgenerated				|
						|			byDOPAndNpi				    |					Super				|					1				|			EPRAgenerated				|
			      |			byDOPAndNpi				    |					Super				|					2				|			EPRAgenerated				|
					  |	byDOPAndAccountNo			    |					Super				|					1				|			EPRAgenerated				|
		      	|	byDOPAndAccountNo			    |					Super				|					2				|			EPRAgenerated				|
						|	byDOP&SubscriberID		    |					Super				|					1				|			EPRAgenerated				|
			    	|	byDOP&SubscriberID		    |					Super				|					2				|			EPRAgenerated				|
			    	|	byDOPAndClaimNo				    | 				Super				|					1				|			EPRAgenerated				|
			    	|	byDOPAndClaimNo				    | 				Super				|					2				|			EPRAgenerated				|
			    	|	byDOPAndPatientNm			    |					Super				|					1				|			EPRAgenerated				|
			    	|	byDOPAndPatientNm			    |					Super				|					2				|			EPRAgenerated				|
			    	|	byDOPAndRenderingProvider |			    Super				|					1				|			EPRAgenerated				|
			    	|	byDOPAndRenderingProvider |			    Super				|					2				|			EPRAgenerated				|
			    	|	byElectronicPaymentNo	    |						RO				|					1				|			EPRAgenerated				|
			    	|	byElectronicPaymentNo	    |						RO				|					2				|			EPRAgenerated				|
			    	|			byDOPAndNpi				    |						RO				|					1				|			EPRAgenerated				|
			    	|			byDOPAndNpi				    |						RO				|					2				|			EPRAgenerated				|
			    	|	byDOPAndAccountNo			    |						RO				|					1				|			EPRAgenerated				|
			    	|	byDOPAndAccountNo			    |						RO				|					2				|			EPRAgenerated				|
			    	|	byDOP&SubscriberID		    |						RO				|					1				|			EPRAgenerated				|
			    	|	byDOP&SubscriberID		    |						RO				|					2				|			EPRAgenerated				| 
			    	|	byDOPAndClaimNo				    |  					RO				|					1				|			EPRAgenerated				|
			    	|	byDOPAndClaimNo				    |  					RO				|					2				|			EPRAgenerated				| 
			    	|	byDOPAndPatientNm			    |						RO				|					1				|			EPRAgenerated				|
			    	|	byDOPAndPatientNm			    |						RO				|					2				|			EPRAgenerated				|
			    	|	byDOPAndRenderingProvider |				    RO				|					1				|			EPRAgenerated				|
			    	|	byDOPAndRenderingProvider |				    RO				|					2				|			EPRAgenerated				|
			    	|	byElectronicPaymentNo	    |						RW				|					1				|			EPRAgenerated				|
				  	|	byElectronicPaymentNo	    |						RW				|					2				|			EPRAgenerated				|
				  	|			byDOPAndNpi				    |						RW				|					1				|			EPRAgenerated				|
				  	|			byDOPAndNpi				    |						RW				|					2				|			EPRAgenerated				|
				  	|	byDOPAndAccountNo			    |						RW				|					1				|			EPRAgenerated				|
			    	|	byDOPAndAccountNo			    |						RW				|					2				|			EPRAgenerated				|
				  	|	byDOP&SubscriberID		    |						RW				|					1				|			EPRAgenerated				|
			    	|	byDOP&SubscriberID		    |						RW				|					2				|			EPRAgenerated				|
			    	|	byDOPAndClaimNo				    |  					RW				|					1				|			EPRAgenerated				|
			    	|	byDOPAndClaimNo				    |  					RW				|					2				|			EPRAgenerated				|
			    	|	byDOPAndPatientNm			    |						RW				|					1				|			EPRAgenerated				|
			    	|	byDOPAndPatientNm			    |						RW				|					2				|			EPRAgenerated				|
			    	|	byDOPAndRenderingProvider |				    RW				|					1				|			EPRAgenerated				|
			    	|	byDOPAndRenderingProvider |				    RW				|					2				|			EPRAgenerated				|
			    


																