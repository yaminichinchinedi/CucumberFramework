#Author: Amit Kushwah
#PPS.4012 job should be running to execute these test cases.

@UPASrchRemitEPRA1  @UPARegression
Feature: Search Remittance Payment Number 


Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
	And validate Claim_Count and Priority is set accordingly.
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
	And validate download status is set to Y in Ole.EPRA_STATUS
  And validate record is inserted in User_Event_Log.
	
	Examples:
						|		Search Criteria			|				credentials		  	|			priority		|			searchBy		       |   usertype   |
						|	byElectronicPaymentNo	|			 PAY_Admin		      |					1				|			EPRAPayerAdmin		 |    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Admin					|					2				|			EPRAPayerAdmin		 |    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Admin    		  |					1				|			EPRAPayerAdmin		 |    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Admin					|					2				|			EPRAPayerAdmin		 |    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Gen  		      |					1				|			EPRAPayerGen			 |    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Gen  					|					2				|			EPRAPayerGen			 |    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Gen      		  |					1				|			EPRAPayerGen			 |    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Gen  					|					2				|			EPRAPayerGen			 |    Payer     |

	



Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
  And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
  And validate Claim_Count and Priority is set accordingly.
	And validate Entry exist in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate PDF icon is enabled and is downloadable for "<Search Criteria>".
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log.
	
	Examples:
						|		Search Criteria			|				credentials		  	|			priority		|			searchBy		              |   usertype   |
						|	byElectronicPaymentNo	|			 PAY_Admin		      |					1				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Admin					|					2				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Admin    		  |					1				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Admin					|					2				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Gen  		      |					1				|			EPRAPayergeneratedGen		  |    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Gen  					|					2				|			EPRAPayergeneratedGen		  |    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Gen      		  |					1				|			EPRAPayergeneratedGen		  |     Payer    |
						|	    byDOPAndNpi	      |			 PAY_Gen  					|					2				|			EPRAPayergeneratedGen	    |     Payer    |
														
																		