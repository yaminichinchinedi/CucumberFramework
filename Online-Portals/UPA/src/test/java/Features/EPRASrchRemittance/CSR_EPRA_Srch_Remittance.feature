#Author: Amit Kushwah
#PPS.4012 job should be running to execute these test cases.

@CSREPRASrchRemit  @CSRRegression
Feature: Search Remittance Payment Number 

Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
	And validate Claim_Count and Priority is set accordingly.
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
	And validate download status is set to Y in Ole.EPRA_STATUS
  And validate record is inserted in User_Event_Log.
	
	Examples:
						|		Search Criteria			|				credentials			|			priority		|			searchBy		|
						|	byElectronicPaymentNo	|					Super					|					1				|			EPRA				|
						|	byElectronicPaymentNo	|					Super					|					2				|			EPRA				|
						|	byElectronicPaymentNo	|						RW					|					1				|			EPRA				|
						|	byElectronicPaymentNo	|						RW					|					2				|			EPRA				|
						|	byElectronicPaymentNo	|						RO					|					1				|			EPRA				|
						|	byElectronicPaymentNo	|						RO					|					2				|			EPRA				|
						|	    byDOPAndNpi	      |					Super					|					1				|			EPRA				|
						|	    byDOPAndNpi	      |					Super					|					2				|			EPRA				|
						|	    byDOPAndNpi	      |						RW					|					1				|			EPRA				|
						|	    byDOPAndNpi	      |						RW					|					2				|			EPRA				|
						|	    byDOPAndNpi	      |						RO					|					1				|			EPRA				|
						|	    byDOPAndNpi	      |						RO					|					2				|			EPRA				|
	

	
	Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And validate Entry exist in Ole.EPRA_STATUS with C status for Consol_Pay_Nbr
	And validate Claim_Count and Priority is set accordingly.
	And validate PDF icon is enabled and is downloadable for "<Search Criteria>".
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log.
	
	Examples:
						|		Search Criteria			|				credentials			|			priority		|			searchBy		|
						|	byElectronicPaymentNo	|					Super					|					1				|		EPRAgenerated	|
						|	byElectronicPaymentNo	|					Super					|					2				|		EPRAgenerated	|
						|	byElectronicPaymentNo	|						RW					|					1				|		EPRAgenerated	|
						|	byElectronicPaymentNo	|						RW					|					2				|		EPRAgenerated	|
						|	byElectronicPaymentNo	|						RO					|					1				|		EPRAgenerated	|
						|	byElectronicPaymentNo	|						RO					|					2				|		EPRAgenerated	|
						|	    byDOPAndNpi	      |					Super					|					1				|		EPRAgenerated	|
						|	    byDOPAndNpi	      |					Super					|					2				|		EPRAgenerated	|
						|	    byDOPAndNpi	      |						RW					|					1				|		EPRAgenerated	|
						|	    byDOPAndNpi	      |						RW					|					2				|		EPRAgenerated	|
						|	    byDOPAndNpi	      |						RO					|					1				|		EPRAgenerated	|
						|	    byDOPAndNpi	      |						RO					|					2				|		EPRAgenerated	|
														