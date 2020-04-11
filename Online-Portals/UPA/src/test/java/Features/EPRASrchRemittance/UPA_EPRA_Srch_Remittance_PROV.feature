#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.
# Few test Cases May fail due to existing PROD issue

@UPASrchRemitEPRA12 @UPASrchRemitEPRA1  @UPARegression
Feature: UPA_EPRA_Srch_Remittance_PROV --> Search Remittance Payment Number 


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
						|		Search Criteria			|				credentials		  	|			priority		|			searchBy		     |   usertype      |
						|	byElectronicPaymentNo	|			 PROV_Admin		      |					1				|			EPRAPROVAdmin		 |    PROV_Admin   |
						|	byElectronicPaymentNo	|			 PROV_Admin					|					2				|			EPRAPROVAdmin		 |    PROV_Admin   |
						|	    byDOPAndNpi	      |			 PROV_Admin    		  |					1				|			EPRAPROVAdmin		 |    PROV_Admin   |
						|	    byDOPAndNpi	      |			 PROV_Admin					|					2				|			EPRAPROVAdmin		 |    PROV_Admin   |
						|	byElectronicPaymentNo	|			 PROV_Gen 		      |					1				|			EPRAPROVGen			 |    PROV_Gen     |
						|	byElectronicPaymentNo	|			 PROV_Gen 					|					2				|			EPRAPROVGen			 |    PROV_Gen     |
						|	    byDOPAndNpi	      |			 PROV_Gen     		  |					1				|			EPRAPROVGen			 |    PROV_Gen     |
						|	    byDOPAndNpi	      |			 PROV_Gen 					|					2				|			EPRAPROVGen			 |    PROV_Gen     |

	


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
						|		Search Criteria			|				credentials		  	|			priority		|			searchBy		              |   usertype        |
						|	byElectronicPaymentNo	|			 PROV_Admin		      |					1				|			EPRAgeneratedPROVAdmin		|    PROV_Admin     |
						|	byElectronicPaymentNo	|			 PROV_Admin					|					2				|			EPRAgeneratedPROVAdmin		|    PROV_Admin     |
						|	    byDOPAndNpi	      |			 PROV_Admin    		  |					1				|			EPRAgeneratedPROVAdmin		|    PROV_Admin     |
						|	    byDOPAndNpi	      |			 PROV_Admin					|					2				|			EPRAgeneratedPROVAdmin		|    PROV_Admin     |
						|	byElectronicPaymentNo	|			 PROV_Gen 		      |					1				|			EPRAgeneratedPROVGen		  |    PROV_Gen       |
						|	byElectronicPaymentNo	|			 PROV_Gen 					|					2				|			EPRAgeneratedPROVGen		  |    PROV_Gen       |
						|	    byDOPAndNpi	      |			 PROV_Gen     		  |					1				|			EPRAgeneratedPROVGen	    |    PROV_Gen       |
						|	    byDOPAndNpi	      |			 PROV_Gen 					|					2				|			EPRAgeneratedPROVGen	    |    PROV_Gen       |
														
																		