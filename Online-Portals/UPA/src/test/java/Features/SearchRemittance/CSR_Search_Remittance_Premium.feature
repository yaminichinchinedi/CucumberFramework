#Author: Rahul Krishna
Feature: CSR Search Remittance for Premium access portal			
@CSRRegression
@SrchRemitt123 @OctRelease @CSRUS2879974
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	
#	Given User navigates to CSR portal and enters "<credentials>" and login
#	And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
#	Then User clicks on Search Remittance link
#		Then User Enters tin and click on search button for "<userType>".
#	#Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<portalAccess>" through "<usertype>" click on continue button
#	Then User enters "<Search Criteria>" and click on search button.
  #Then Validate in Grid search Results,Type column or Payment Status field not displayed and is relabeled to ACH Trace
  #Then Validate Claim Count column is present which appears as Hyperlink for nonzero claim count and on click redirects to Remittance Detail page
  #Then Validate ePRA,pPRA and 835 fields are enabled 
   #Then Validate Archived Coulmn,Save Archived button is relabeled to Payment Status and Save button respectively
   #Then Validate that Search Criertia box do not contain hyphen following colon on each search criteria option
    

  
	
	Examples:
		|		Search Criteria			    |	credentials	  | portalAccess |   searchRemitorPymntTIN  |tinType|usertype|
		|	byElectronicPayNum	      |	Super    |	  Premium    |   TinWthatlstOnePayNum    |  VO   |PROV|
		|	byElectronicPayNum	      |	Super    |	  Standard    |   TinWthatlstOnePayNum    |  AO   |PROV|
		
		
	
	Scenario Outline: - verify search results for search remittance
	
	Given User navigates to CSR portal and enters "<credentials>" and login
	And User fetch tin on CSR for "<userType>" for "<Search Criteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link
	Then User Enters tin and click on search button for "<userType>".
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"
	
	Examples:
		|	Search Criteria	|	credentials	 |   userType  | portalAccess | searchRemitorPymntTIN  |tinType|
		|		byDOP		|	Super	 |    PROV     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	Super	 |    PROV     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	Super	 |    PROV     |   Premium    |	byElectronicPaymentNo  |  AO   |
		|byDOPAndAccountNo  |	Super	 |    PROV     |   Premium    |	  byDOPAndAccountNo    |  AO   |
		|byDOP&SubscriberID  |	Super	 |    PROV     |   Premium    |	  byDOP&SubscriberID    |  AO   |
		|byDOPAndClaimNo     |	Super	 |    PROV     |   Premium    |	  byDOPAndClaimNo       |  AO   |
		|byDOPAndPatientNm   |	Super	 |    PROV     |   Premium    |	  byDOPAndPatientNm          |  AO   |
		#TODO|byDOPAndNpi         |	Super	 |    PROV     |   Premium    |	  byDOPAndNpi           |  AO   |
		|byCheckNo         |	Super	 |    PROV     |   Premium    |	    byCheckNo          |  AO   |
		|byDOSAndAcntNo     |	Super	 |    PROV     |   Premium    |	  byDOSAndAcntNo    |  AO   |
		|byDOSAndSubscriberId  |	Super	 |    PROV     |   Premium    |	  byDOSAndSubscriberId    |  AO   |
		|   byDOSAndClmNo   |	Super	 |    PROV     |   Premium    |	  byDOSAndClmNo    |  AO   |
		|   byDOSAndPtntNm   |	Super	 |    PROV     |   Premium    |	  byDOSAndPtntNm          |  AO   |
		#|byDOSAndNpi         |	Super	 |    PROV     |   Premium    |	  byDOSAndNpi           |  AO   |
		
	Scenario Outline: - verify Print page for search remittance
	
	Given User navigates to CSR portal and enters "<credentials>" and login
	And User fetch tin on CSR for "<userType>" for "<Search Criteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link
	Then User Enters tin and click on search button for "<userType>".
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"
#	Then User clicks on Print Search Result button.
#	Then Validate the data of Print Search Remmit Page for "<Search Criteria>"
	
	Examples:
		|	Search Criteria	|	credentials	 |   userType  | portalAccess | searchRemitorPymntTIN  |tinType|
		|		byDOP		|	Super	 |    PROV     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	Super	 |    PROV     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	Super	 |    PROV     |   Premium    |	byElectronicPaymentNo  |  AO   |

