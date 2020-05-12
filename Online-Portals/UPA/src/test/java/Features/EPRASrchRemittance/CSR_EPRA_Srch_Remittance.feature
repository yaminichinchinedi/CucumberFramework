#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.
#Few test cases will fail due to existing PROD defect

@CSREPRASrchRemitPage    @CSRRegression
Feature: CSR_EPRA_Srch_Remittance  

Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	#Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And User validates EPRA pdf link is present and clicks on EPRA when "<Search Criteria>" and validate a new window is open with appropriate Text and Hover msg is displayed.
	And validate PDF link is changed to PDF icon and is enabled and is downloadable for "<Search Criteria>".
	And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>" for Search Remit Page
	And validate new Entry is created in Ole.EPRA_STATUS with C status for Search Remit Page
	And validate download status is set to Y in Ole.EPRA_STATUS
  And validate record is inserted in User_Event_Log for "<usertype>"
	
	Examples:
						|		Search Criteria			|				credentials			|			priority		|			searchBy		|usertype   |
						|	byElectronicPaymentNo	|					Super					|					1				|			EPRA				|PROV       |
						|	byElectronicPaymentNo	|					Super					|					2				|			EPRA				|PROV       |
						|	byElectronicPaymentNo	|						RW					|					1				|			EPRA				|PROV       |
						|	byElectronicPaymentNo	|						RW					|					2				|			EPRA				|PROV       |
						|	byElectronicPaymentNo	|						RO					|					1				|			EPRA				|PROV       |
						|	byElectronicPaymentNo	|						RO					|					2				|			EPRA				|PROV       |
						|	    byDOPAndNpi	      |					Super					|					1				|			EPRA				|PROV       |
						|	    byDOPAndNpi	      |					Super					|					2				|			EPRA				|PROV       |
						|	    byDOPAndNpi	      |						RW					|					1				|			EPRA				|PROV       |
						|	    byDOPAndNpi	      |						RW					|					2				|			EPRA				|PROV       |
						|	    byDOPAndNpi	      |						RO					|					1				|			EPRA				|PROV       |
						|	    byDOPAndNpi	      |						RO					|					2				|			EPRA				|PROV       |
	
Scenario Outline: Search Remittance Payment Number P1 & P2 Already Existing
	Given User navigates to CSR portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link
	#Then User enters tin on Search Remittance Tin Page for "<priority>" and "<searchBy>" click on continue button
	Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	And validate PDF icon is enabled and is downloadable for "<Search Criteria>".
  And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>" for Search Remit Page
  And validate new Entry is created in Ole.EPRA_STATUS with C status for Search Remit Page
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for Remittance Detail for CSR "<credentials>"
	
Examples:
						|		Search Criteria			|				credentials			|			priority		|			searchBy		|usertype   |
						|	byElectronicPaymentNo	|					Super					|					1				|		EPRAgenerated	|PROV       |
						|	byElectronicPaymentNo	|					Super					|					2				|		EPRAgenerated	|PROV       |
						|	byElectronicPaymentNo	|						RW					|					1				|		EPRAgenerated	|PROV       |
						|	byElectronicPaymentNo	|						RW					|					2				|		EPRAgenerated	|PROV       |
						|	byElectronicPaymentNo	|						RO					|					1				|		EPRAgenerated	|PROV       |
						|	byElectronicPaymentNo	|						RO					|					2				|		EPRAgenerated	|PROV       |
						|	    byDOPAndNpi	      |					Super					|					1				|		EPRAgenerated	|PROV       |
						|	    byDOPAndNpi	      |					Super					|					2				|		EPRAgenerated	|PROV       |
						|	    byDOPAndNpi	      |						RW					|					1				|		EPRAgenerated	|PROV       |
						|	    byDOPAndNpi	      |						RW					|					2				|		EPRAgenerated	|PROV       |
						|	    byDOPAndNpi	      |						RO					|					1				|		EPRAgenerated	|PROV       |
						|	    byDOPAndNpi	      |						RO					|					2				|		EPRAgenerated	|PROV       |
														