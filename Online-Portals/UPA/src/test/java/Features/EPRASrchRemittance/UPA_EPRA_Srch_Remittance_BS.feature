#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.

@UPASrchRemitEPRABS @UPASrchRemitEPRA1  @UPARegression
Feature: UPA_EPRA_Srch_Remittance_BS 


Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
	And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>" for Search Remit Page
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Search Remit Page
	And validate download status is set to Y in Ole.EPRA_STATUS
  And validate record is inserted in User_Event_Log for "<usertype>"
  

Examples:
						|		Search Criteria			|				credentials		  	|			priority		|			searchBy		    |   usertype  |
						|	byElectronicPaymentNo	|			 BS_Admin 		      |					1				|			EPRABSAdmin			|     BS      |
						|	byElectronicPaymentNo	|			 BS_Admin  					|					2				|			EPRABSAdmin			|     BS      |
						|	    byDOPAndNpi	      |			 BS_Admin     		  |					1				|			EPRABSAdmin			|     BS      |
						|	    byDOPAndNpi	      |			 BS_Admin 					|					2				|			EPRABSAdmin			|     BS      |
						|	byElectronicPaymentNo	|			 BS_Gen   		      |					1				|			EPRABSGen				|     BS      |
						|	byElectronicPaymentNo	|			 BS_Gen   					|					2				|			EPRABSGen				|     BS      |
						|	    byDOPAndNpi	      |			 BS_Gen       		  |					1				|			EPRABSGen				|     BS      |
						|	    byDOPAndNpi	      |			 BS_Gen   					|					2				|			EPRABSGen				|     BS      |

	


Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And validate PDF icon is enabled and is downloadable for "<Search Criteria>".
  And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>" for Search Remit Page
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Search Remit Page
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for "<usertype>"
	

Examples:
						|		Search Criteria			|				credentials		  	|			priority		|			searchBy		          |   usertype  |
						|	byElectronicPaymentNo	|			 BS_Admin 		      |					1				|			EPRAgeneratedBSAdmin	|    BS       |
						|	byElectronicPaymentNo	|			 BS_Admin 					|					2				|			EPRAgeneratedBSAdmin	|    BS       |
						|	    byDOPAndNpi	      |			 BS_Admin     		  |					1				|			EPRAgeneratedBSAdmin	|    BS       |
						|	    byDOPAndNpi	      |			 BS_Admin 					|					2				|			EPRAgeneratedBSAdmin	|    BS       |
						|	byElectronicPaymentNo	|			 BS_Gen   		      |					1				|			EPRAgeneratedBSGen		|    BS       |
						|	byElectronicPaymentNo	|			 BS_Gen   					|					2				|			EPRAgeneratedBSGen		|    BS       |
						|	    byDOPAndNpi	      |			 BS_Gen       		  |					1				|			EPRAgeneratedBSGen		|    BS       |
						|	    byDOPAndNpi	      |			 BS_Gen   					|					2				|			EPRAgeneratedBSGen	  |    BS       |
														
																		