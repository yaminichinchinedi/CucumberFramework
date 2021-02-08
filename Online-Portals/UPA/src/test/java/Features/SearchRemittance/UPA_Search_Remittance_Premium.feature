#Author: Rahul Krishna
Feature: UPA Search Remittance for Premium access portal			

@UPAUS2879968 @OctRelease 
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
  Then User enters "<Search Criteria>" and click on search button.
  Then Validate in Grid search Results,Type column or Payment Status field not displayed and is relabeled to ACH Trace
  Then Validate Claim Count column is present which appears as Hyperlink for nonzero claim count and on click redirects to Remittance Detail page
  Then Validate ePRA,pPRA and 835 fields are enabled 
   Then Validate Archived Coulmn,Save Archived button is relabeled to Payment Status and Save button respectively
   Then Validate that Search Criertia box do not contain hyphen following colon on each search criteria option
    

	
	Examples:
		|		Search Criteria			|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN        |tinType|
		|	byElectronicPayNum	  |	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |
		|	byElectronicPayNum  	|	PROV_Gen   	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |



@UPAUS2838204
	Scenario Outline: Validate Market type in Search remittance
	
		Given User navigates to UPA portal and enters "<credentials>" and login
		When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Search Remittance link for UPA
		Then Validate the Market type field present in Search Remittance Page
		
		Examples:
			|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN        |tinType|
		 	|	PROV_Admin 	 |    PROV     |   Premium    |TinWthatlstOnePayNum   			 |  AO   |
			|	PROV_Gen		 |    PROV     |   Premium    |TinWthatlstOnePayNum   			 |  AO   |



		@US2948676 
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then Validate search button is enabled or disabled for "<portalAccess>"
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"	
	Then User clicks on Print Search Result button.
	Then Validate the data of Print Search Remmit Page for "<Search Criteria>"

	Examples:
		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|		byDOP		|	Super	 |    PROV     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	Super	 |    PROV     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	Super	 |    PROV     |   Premium    |	byElectronicPaymentNo  |  AO   |

		@US2793563 
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete
	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then verify error messages in search results
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"	

	Examples:
		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |		MoreThan13Months	   |  AO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |		MoreThan13Months	   |  VO   |
		|				byDOP		  |	PROV_Admin	 |    PROV     |   Premium    |		MoreThan13Months	   |  AV   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |		MoreThan13Months	   |  AO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |		MoreThan13Months	   |  VO   |
		|				byDOP		  |		PROV_Gen	 |    PROV     |   Premium    |		MoreThan13Months	   |  AV   |

@PROVSearchRemittance
Scenario Outline: Search Remittance 
	Given User navigates to UPA portal and enters "<credentials>" and login
	When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"	

	Examples:
		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|		byDOP		|	PROV_Admin	 |    PROV     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	PROV_Admin	 |    PROV     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	PROV_Admin	 |    PROV     |   Premium    |	byElectronicPaymentNo  |  AO   |
		|byDOPAndAccountNo  |	PROV_Admin	 |    PROV     |   Premium    |	  byDOPAndAccountNo    |  AO   |
		|byDOP&SubscriberID  |	PROV_Admin	 |    PROV     |   Premium    |	  byDOP&SubscriberID    |  AO   |
		|byDOPAndClaimNo     |	PROV_Admin	 |    PROV     |   Premium    |	  byDOPAndClaimNo       |  AO   |
		|byDOPAndPatientNm   |	PROV_Admin	 |    PROV     |   Premium    |	  byDOPAndPatientNm          |  AO   |
		#|byDOPAndNpi         |	PROV_Admin	 |    PROV     |   Premium    |	  byDOPAndNpi           |  AO   |
		|byCheckNo         |	PROV_Admin	 |    PROV     |   Premium    |	    byCheckNo          |  AO   |
		|byDOSAndAcntNo     |	PROV_Admin	 |    PROV     |   Premium    |	  byDOSAndAcntNo    |  AO   |
		|byDOSAndSubscriberId  |	PROV_Admin	 |    PROV     |   Premium    |	  byDOSAndSubscriberId    |  AO   |
		|   byDOSAndClmNo   |	PROV_Admin	 |    PROV     |   Premium    |	  byDOSAndClmNo    |  AO   |
		|   byDOSAndPtntNm   |	PROV_Admin	 |    PROV     |   Premium    |	  byDOSAndPtntNm          |  AO   |
		#|byDOSAndNpi         |	PROV_Admin	 |    PROV     |   Premium    |	  byDOSAndNpi           |  AO   |
		|		byDOP		|	PROV_Gen	 |    PROV     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	PROV_Gen	 |    PROV     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	PROV_Gen	 |    PROV     |   Premium    |	byElectronicPaymentNo  |  AO   |
		|byDOPAndAccountNo  |	PROV_Gen	 |    PROV     |   Premium    |	  byDOPAndAccountNo    |  AO   |
		|byDOP&SubscriberID  |	PROV_Gen	 |    PROV     |   Premium    |	  byDOP&SubscriberID    |  AO   |
		|byDOPAndClaimNo     |	PROV_Gen	 |    PROV     |   Premium    |	  byDOPAndClaimNo       |  AO   |
		|byDOPAndPatientNm   |	PROV_Gen	 |    PROV     |   Premium    |	  byDOPAndPatientNm          |  AO   |
		#|byDOPAndNpi         |	PROV_Gen	 |    PROV     |   Premium    |	  byDOPAndNpi           |  AO   |
		|byCheckNo         |	PROV_Gen	 |    PROV     |   Premium    |	    byCheckNo          |  AO   |
		|byDOSAndAcntNo     |	PROV_Gen	 |    PROV     |   Premium    |	  byDOSAndAcntNo    |  AO   |
		|byDOSAndSubscriberId  |	PROV_Gen	 |    PROV     |   Premium    |	  byDOSAndSubscriberId    |  AO   |
		|   byDOSAndClmNo   |	PROV_Gen	 |    PROV     |   Premium    |	  byDOSAndClmNo    |  AO   |
		|   byDOSAndPtntNm   |	PROV_Gen	 |    PROV     |   Premium    |	  byDOSAndPtntNm          |  AO   |
		#|byDOSAndNpi         |	PROV_Gen	 |    PROV     |   Premium    |	  byDOSAndNpi           |  AO   |

@BSSearchRemittance
Scenario Outline: - verify search results for search remittance

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	When User enters a tin  for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" through "<usertype>" for Portal Experience.
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Criteria Type>"	

Examples:

		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|
		|		byDOP		|	BS_Admin	 |    BS     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	BS_Admin	 |    BS     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	BS_Admin	 |    BS     |   Premium    |	byElectronicPaymentNo  |  AO   |
		|byDOPAndAccountNo  |	BS_Admin	 |    BS     |   Premium    |	  byDOPAndAccountNo    |  AO   |
		|byDOP&SubscriberID  |	BS_Admin	 |    BS     |   Premium    |	  byDOP&SubscriberID    |  AO   |
		|byDOPAndClaimNo     |	BS_Admin	 |    BS     |   Premium    |	  byDOPAndClaimNo       |  AO   |
		|byDOPAndPatientNm   |	BS_Admin	 |    BS     |   Premium    |	  byDOPAndPatientNm          |  AO   |
		#|byDOPAndNpi         |	BS_Admin	 |    BS     |   Premium    |	  byDOPAndNpi           |  AO   |
		|byCheckNo         |	BS_Admin	 |    BS     |   Premium    |	    byCheckNo          |  AO   |
		|byDOSAndAcntNo     |	BS_Admin	 |    BS     |   Premium    |	  byDOSAndAcntNo    |  AO   |
		|byDOSAndSubscriberId  |	BS_Admin	 |    BS     |   Premium    |	  byDOSAndSubscriberId    |  AO   |
		|   byDOSAndClmNo   |	BS_Admin	 |    BS     |   Premium    |	  byDOSAndClmNo    |  AO   |
		|   byDOSAndPtntNm   |	BS_Admin	 |    BS     |   Premium    |	  byDOSAndPtntNm          |  AO   |
		#|byDOSAndNpi         |	BS_Admin	 |    BS     |   Premium    |	  byDOSAndNpi           |  AO   |
		|		byDOP		|	BS_Gen	 |    BS     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	BS_Gen	 |    BS     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	BS_Gen	 |    BS     |   Premium    |	byElectronicPaymentNo  |  AO   |
		|byDOPAndAccountNo  |	BS_Gen	 |    BS     |   Premium    |	  byDOPAndAccountNo    |  AO   |
		|byDOP&SubscriberID  |	BS_Gen	 |    BS     |   Premium    |	  byDOP&SubscriberID    |  AO   |
		|byDOPAndClaimNo     |	BS_Gen	 |    BS     |   Premium    |	  byDOPAndClaimNo       |  AO   |
		|byDOPAndPatientNm   |	BS_Gen	 |    BS     |   Premium    |	  byDOPAndPatientNm          |  AO   |
		#|byDOPAndNpi         |	BS_Gen	 |    BS     |   Premium    |	  byDOPAndNpi           |  AO   |
		|byCheckNo         |	BS_Gen	 |    BS     |   Premium    |	    byCheckNo          |  AO   |
		|byDOSAndAcntNo     |	BS_Gen	 |    BS     |   Premium    |	  byDOSAndAcntNo    |  AO   |
		|byDOSAndSubscriberId  |	BS_Gen	 |    BS     |   Premium    |	  byDOSAndSubscriberId    |  AO   |
		|   byDOSAndClmNo   |	BS_Gen	 |    BS     |   Premium    |	  byDOSAndClmNo    |  AO   |
		|   byDOSAndPtntNm   |	BS_Gen	 |    BS     |   Premium    |	  byDOSAndPtntNm          |  AO   |
		#|byDOSAndNpi         |	BS_Gen	 |    BS     |   Premium    |	  byDOSAndNpi           |  AO   |
		
		
@PAYSearchRemittance
Scenario Outline: - verify search results for search remittance

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	When User enters a tin  for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" through "<usertype>" for Portal Experience.
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Criteria Type>"	
	Examples:

		|	Search Criteria	|	credentials	 |   usertype  | portalAccess | searchRemitorPymntTIN  |tinType|	
		|		byDOP		|	PAY_Admin	 |    PAY     |   Premium    |		 	byDOP	       |  AO   |
		|  	byDOS   		|	PAY_Admin	 |    PAY     |   Premium    |		byDOS              |  AO   |
		|byElectronicPaymentNo|	PAY_Admin	 |    PAY     |   Premium    |	byElectronicPaymentNo  |  AO   |
		|byDOPAndAccountNo  |	PAY_Admin	 |    PAY     |   Premium    |	  byDOPAndAccountNo    |  AO   |
		|byDOP&SubscriberID  |	PAY_Admin	 |    PAY     |   Premium    |	  byDOP&SubscriberID    |  AO   |
		|byDOPAndClaimNo     |	PAY_Admin	 |    PAY     |   Premium    |	  byDOPAndClaimNo       |  AO   |
		|byDOPAndPatientNm   |	PAY_Admin	 |    PAY     |   Premium    |	  byDOPAndPatientNm          |  AO   |
		#|byDOPAndNpi         |	PAY_Admin	 |    PAY     |   Premium    |	  byDOPAndNpi           |  AO   |
		|byCheckNo         |	PAY_Admin	 |    PAY     |   Premium    |	    byCheckNo          |  AO   |
		|byDOSAndAcntNo     |	PAY_Admin	 |    PAY     |   Premium    |	  byDOSAndAcntNo    |  AO   |
		|byDOSAndSubscriberId  |	PAY_Admin	 |    PAY     |   Premium    |	  byDOSAndSubscriberId    |  AO   |
		|   byDOSAndClmNo   |	PAY_Admin	 |    PAY     |   Premium    |	  byDOSAndClmNo    |  AO   |
		|   byDOSAndPtntNm   |	PAY_Admin	 |    PAY     |   Premium    |	  byDOSAndPtntNm          |  AO   |
		#|byDOSAndNpi         |	PAY_Admin	 |    PAY     |   Premium    |	  byDOSAndNpi           |  AO   |



