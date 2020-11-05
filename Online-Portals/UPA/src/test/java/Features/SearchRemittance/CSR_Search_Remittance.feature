#Author: Pavani
Feature: CSR Search Remittance
@CSR_SR_Regression_SC
Scenario Outline: - verify search results for search remittance

Given User navigates to CSR portal and enters "<credentials>" and login
Then User clicks on Search Remittance link
  Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button     
Then User enters "<Search Criteria>" and click on search button.
Then verify search results for "<Criteria Type>"	

Examples:
|	Search Criteria	        |credentials |   usertype    |        Criteria Type            |priority  |searchBy                   |
|	byElectronicPaymentNo  	|	Super      |    PROV       |        byElectronicPaymentNo    |	1       |generalPaymentForTIN_90days|
|	byCheckNo             	|	Super      |    PROV       |        byCheckNo                |	1       |generalPaymentForTIN_90days|
|	byDOP  							  	|	Super      |    PROV       |        byDOP  							     |	1       |generalPaymentForTIN_90days|
|	byDOS								  	|	Super      |    PROV       |        byDOS								     |	1       |generalPaymentForTIN_90days|
|	byDOPAndAccountNo     	|	Super      |    PROV       |        byDOPAndAccountNo        |	1       |generalPaymentForTIN_90days|
|	byDOP&SuPAYcriberID   	|	Super      |    PROV       |        byDOP&SuPAYcriberID      |	1       |generalPaymentForTIN_90days|
|	byDOPAndNpi	           	|	Super      |    PROV       |        byDOPAndNpi	             |	1       |generalPaymentForTIN_90days|
|	byDOPAndClaimNo	       	|	Super      |    PROV       |        byDOPAndClaimNo	         |	1       |generalPaymentForTIN_90days|
|	byDOPAndPatientNm      	|	Super      |    PROV       |        byDOPAndPatientNm        |	1       |generalPaymentForTIN_90days|
|	byDOPAndZeroPaymentClaims|	Super    |    PROV       |        byDOPAndZeroPaymentClaims|	1       |generalPaymentForTIN_90days|
|	byDOPAndMarketType      |	Super      |    PROV       |        byDOPAndMarketType       |	1       |generalPaymentForTIN_90days|
|	byDOSAndAcntNo         	|	Super      |    PROV       |        byDOSAndAcntNo        	 |	1       |generalPaymentForTIN_90days|
|	byDOSAndSuPAYcriberId  	|	Super      |    PROV       |        byDOSAndSuPAYcriberId 	 |	1       |generalPaymentForTIN_90days|
|	byDOSAndNpi            	|	Super      |    PROV       |        byDOSAndNpi              |	1       |generalPaymentForTIN_90days|
|	byDOSAndClmNo          	|	Super      |    PROV       |        byDOSAndClmNo            |	1       |generalPaymentForTIN_90days|
|	byDOSAndPtntNm         	|	Super      |    PROV       |        byDOSAndPtntNm           |	1       |generalPaymentForTIN_90days|
|	byDOSAndZeroPmntClms   	|	Super      |    PROV       |        byDOSAndZeroPmntClms     |	1       |generalPaymentForTIN_90days|
|	byDOSAndMarketType    	|	Super      |    PROV       |        byDOSAndMarketType       |	1       |generalPaymentForTIN_90days|
|	byDOPAndRenderingProvider|	Super    |    PROV       |        byDOPAndRenderingProvider|	1       |generalPaymentForTIN_90days|
|	byDOPAndPatientNm     	|	Super      |    PROV       |        byDOPAndPatientNm        |	1       |generalPaymentForTIN_90days|
|	byDOP&SuPAYcriberID    	|	Super      |    PROV       |        byDOP&SuPAYcriberID      |	1       |generalPaymentForTIN_90days|
| byCheckNoOfReoriginNacha|	Super      |    PROV       |        byCheckNoOfReoriginNacha |	1       |generalPaymentForTIN_90days|
|byCheckNoOfConslPayDtl   |	Super      |    PROV       |        byCheckNoOfReoriginNacha |	1       |generalPaymentForTIN_90days|          

@CSR_SR_Regression_SR1
Scenario Outline: -  verify sorting in search remittance page

	Given User navigates to CSR portal and enters "<credentials>" and login
  Then User clicks on Search Remittance link
  Then User enters tin for CSR Search Remittance Tin Page for "<priority>" and "<searchBy>" through "<usertype>" click on continue button     
  Then User enters "<Search Criteria>" and click on search button.
	Then verify search results sorting for "<Criteria Type>"

Examples:
						    |		Search Criteria			      | credentials 	|   usertype    |        Criteria Type      |priority  |searchBy                   |
	         			|	       byDOP  	            |	 Super        |    PROV       | 	     Payer	            |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	   Claim Date           |	1        |generalPaymentForTIN_90days|
	         		  |	       byDOP  	            |	 Super        |    PROV       | 	    NPI 	              |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	  Patient Name          |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	  SuPAYcriber ID        |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	 Account Number         |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	     Claim #            |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	  Claim Amount          |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	   Market Type          |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	    Archive             |	1        |generalPaymentForTIN_90days|
	         			|	    byDOSAndNpi             |	 Super        |    PROV       | 	   Payment Date         |	1        |generalPaymentForTIN_90days|
	         			|	       byDOP  	            |	 Super        |    PROV       | 	  Payment Number        |	1        |generalPaymentForTIN_90days|
	         			|	    byDOSAndNpi             |	 Super        |    PROV       | 	     Amount             |	1        |generalPaymentForTIN_90days|
	         	