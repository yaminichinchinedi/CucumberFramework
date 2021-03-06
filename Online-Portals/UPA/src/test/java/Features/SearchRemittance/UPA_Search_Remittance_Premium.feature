#Author: Rahul Krishna
@UPASearchRemittancePRemium  @UPARegression
Feature: UPA Search Remittance for Premium access portal			

@UPAUS2879968 @OctRelease 
Scenario Outline: Search Remittance Payment Number P1 & P2 Complete

	Given User navigates to UPA portal and enters "<credentials>" and login
	And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
  Then User enters "<Search Criteria>" and click on search button.
  Then Validate in Grid search Results,Type column or Payment Status field not displayed and is relabeled to ACH Trace
  Then Validate Claim Count column is present which appears as Hyperlink for nonzero claim count and on click redirects to Remittance Detail page
  Then Validate ePRA,pPRA and 835 fields are enabled 
   Then Validate Archived Coulmn,Save Archived button is relabeled to Payment Status and Save button respectively
   Then Validate that Search Criertia box do not contain hyphen following colon on each search criteria option
    

	
	Examples:
		|		Search Criteria			|	credentials	 |   userType  | portalAccess | searchRemitorPymntTIN        |tinType|
		|	byElectronicPayNum	  |	PROV_Admin	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |
		|	byElectronicPayNum  	|	PROV_Gen   	 |    PROV     |   Premium    |TinWthatlstOnePayNum   |  VO   |



@UPAUS2838204
	Scenario Outline: Validate Market type in Search remittance
	
		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Search Remittance link for UPA
		Then Validate the Market type field present in Search Remittance Page
		
		Examples:
			|	credentials	 |   userType  | portalAccess | searchRemitorPymntTIN        |tinType|
		 	|	PROV_Admin 	 |    PROV     |   Premium    |TinWthatlstOnePayNum   			 |  AO   |
			|	PROV_Gen		 |    PROV     |   Premium    |TinWthatlstOnePayNum   			 |  AO   |



@UPAPROVSearchRemittance
Scenario Outline: Search Remittance 
	Given User navigates to UPA portal and enters "<credentials>" and login
	And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"

	Examples:
		|	Search Criteria	|	credentials	 |   userType  | portalAccess | searchRemitorPymntTIN  |tinType|
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
	And User fetch tin for "<userType>" for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	Then User clicks on Search Remittance link for UPA
	Then User Enters Search Remittance tin and click on search button for "<userType>".
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Search Criteria>"	

Examples:

		|	Search Criteria	|	credentials	 |   userType  | portalAccess | searchRemitorPymntTIN  |tinType|
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
		
	

#Author khalid_mohammad@optum.com
@UPA_SR_US2955421 @UPAPROVSearchRemittance
Scenario Outline: To test page text messaging on Serach Remittance for Provider User

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
Then User clicks on Search Remittance link for UPA
And User verifies page text message "<PageTextMsg>"



 Examples:
 |credentials      |    userType     |   searchCriteria     | tinType	|		portalAccess	| PageTestMsg  |
 |    PROV_Admin   |      PROV       |PremiumOrStandardTIN  |	AO	    |		Premium     	|PremiumPrvAdm |
 |    PROV_Admin   |        PROV     |PremiumOrStandardTIN  |	AO	    |		Standard     	|StandardPrvAdm|
 |    PROV_Gen     |        PROV     |PremiumOrStandardTIN  |	AO	    |		Premium     	|PremiumPrvGen |
 |    PROV_Gen     |        PROV     |PremiumOrStandardTIN  |	AO	    |		Standard     	|StandardPrvAdm|
 
#Author : Vinay Raghumanda
	#(VO is part of US3438488)
	@US3179215 @UPAUS3438488 @UPAPROVSearchRemittance
 Scenario Outline: Search Remittance Page Text Validation
		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Search Remittance link for UPA
		Then Validate Search Remittance Page Text for "<credentials>" for "<portalAccess>"
		Examples:
			| credentials | userType | searchCriteria       | tinType | portalAccess |
			| PROV_Admin  | PROV     | PremiumOrStandardTIN | VO      | Premium      |
			| PROV_Admin  | PROV     | PremiumOrStandardTIN | AO      | Premium      |
			| PROV_Admin  | PROV     | PremiumOrStandardTIN | AO      | Standard     |
			| PROV_Gen    | PROV     | PremiumOrStandardTIN | AO      | Premium      |
			| PROV_Gen    | PROV     | PremiumOrStandardTIN | AO      | Standard     |

	@US3179215 @BSSearchRemittance
	Scenario Outline: Search Remittance Page Text Validation
		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Search Remittance link for UPA
		Then User Enters Search Remittance tin and click on search button for "<userType>".
		Then Validate Search Remittance Page Text for "<credentials>" for "<portalAccess>"
		Examples:
			| credentials | userType | searchCriteria | tinType | portalAccess |
			| BS_Admin    | BS       | Last 60 days   | AO      | Premium      |
			| BS_Gen      | BS       | Last 60 days   | AO      | Premium      |
			