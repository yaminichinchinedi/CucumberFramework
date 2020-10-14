#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.
# Few test Cases May fail due to existing PROD issue

@UPAProvSrchEPRA @UPARegression  @UPASrchRemitEPRAProv
Feature: UPA_EPRA_Srch_Remittance_PROV 


Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	Given User navigates to UPA portal and enters "<credentials>" and login
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User clicks on Search Remittance link for UPA
  Then User enters "<Search Criteria>" and click on search button.
	And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
	And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>" for Search Remit Page
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Search Remit Page
	And validate download status is set to Y in Ole.EPRA_STATUS
  And validate record is inserted in User_Event_Log for "<usertype>"
 
  
	                                                                                       
	Examples:
						|		Search Criteria			    |				credentials		  	|			priority		|			searchBy		     |   usertype  |
						|	 EPRAElectronicPaymentNo  |			 PROV_Admin		      |					1				|			EPRAPROVAdmin		 |    PROV     |
						|	 EPRAElectronicPaymentNo  |			 PROV_Admin		      |					2				|			EPRAPROVAdmin		 |    PROV     |
					  |	    EPRADOPAndNpi	        |			 PROV_Admin    		  |					1				|			EPRAPROVAdmin		 |    PROV     |
					  |	    EPRADOPAndNpi	        |			 PROV_Admin    		  |					2				|			EPRAPROVAdmin		 |    PROV     |
					  |	 EPRAElectronicPaymentNo  |			 PROV_Gen		        |					1				|			EPRAPROVGen 		 |    PROV     |
						|	 EPRAElectronicPaymentNo  |			 PROV_Gen		        |					2				|			EPRAPROVGen 		 |    PROV     |
					  |	    EPRADOPAndNpi	        |			 PROV_Gen    		    |					1				|			EPRAPROVGen 		 |    PROV     |
					  |	    EPRADOPAndNpi	        |			 PROV_Gen    		    |					2				|			EPRAPROVGen 		 |    PROV     |



						
Scenario Outline: UPA_EPRA_Srch_Remittance_PROV --> Search Remittance Payment Number P1 & P2 Already Existing

	Given User navigates to UPA portal and enters "<credentials>" and login
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User clicks on Search Remittance link for UPA
  Then User enters "<Search Criteria>" and click on search button.
  And validate PDF icon is enabled and is downloadable for "<Search Criteria>".
  And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>" for Search Remit Page
  And validate new Entry is created in Ole.EPRA_STATUS with C status for Search Remit Page
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for "<usertype>"
	

	Examples:
						|		Search Criteria			  |				credentials		  	|			priority		|			searchBy		              |   usertype  |
						|	EPRAElectronicPaymentNo	|			 PROV_Admin		      |					1				|			EPRAgeneratedPROVAdmin		|    PROV     |
						|	EPRAElectronicPaymentNo	|			 PROV_Admin					|					2				|			EPRAgeneratedPROVAdmin		|    PROV     |
						|	    EPRADOPAndNpi	      |			 PROV_Admin    		  |					1				|			EPRAgeneratedPROVAdmin		|    PROV     |
						|	    EPRADOPAndNpi	      |			 PROV_Admin					|					2				|			EPRAgeneratedPROVAdmin		|    PROV     |
						|	EPRAElectronicPaymentNo	|			 PROV_Gen 		      |					1				|			EPRAgeneratedPROVGen		  |    PROV     |
						|	EPRAElectronicPaymentNo	|			 PROV_Gen 					|					2				|			EPRAgeneratedPROVGen		  |    PROV     |
						|	    EPRADOPAndNpi	      |			 PROV_Gen     		  |					1				|			EPRAgeneratedPROVGen	    |    PROV     |
						|	    EPRADOPAndNpi	      |			 PROV_Gen 					|					2				|			EPRAgeneratedPROVGen	    |    PROV     |
														
																		