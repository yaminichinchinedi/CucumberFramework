#Author: Pranav
@UPARegression @UPASrchRemitSubPayer
Feature: UPA_Search_Remittance_SubPayer				


Scenario Outline: - verify returned reason in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then User verifies returned reason for "<Search Criteria>"  in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       |	
	         	        |	       byDOP	            |	 SUBPAYER_Gen     |    SUBPAYER       |	    
	         	        
        	        
Scenario Outline: - verify Large non large tin in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then verify large non large tin in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       |	
	         	        |	       byDOP	            |	 SUBPAYER_Gen     |    SUBPAYER       |	    
	         	        
	         	   										
Scenario Outline: - verify error messages in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then verify error messages in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       |	
	         	        |	       byDOP	            |	 SUBPAYER_Gen     |    SUBPAYER       |
	         	        
Scenario Outline: - verify pagination in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify pagination in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       |	
	         	        |	       byDOP	            |	 SUBPAYER_Gen     |    SUBPAYER       |	         	        					
	         	        					
	         	        
Scenario Outline: - verify payment status in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify payment status for <"paymentType"> in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |    paymentType  |
	         			|	byElectronicPaymenForACH    |	 SUBPAYER_Admin   |    SUBPAYER       |	     ACH        |
	         	        |	byElectronicPaymentForVCP   |	 SUBPAYER_Admin   |    SUBPAYER       |	     VCP        |
	         	      	|	byElectronicPaymenForACH    |	 SUBPAYER_Gen     |    SUBPAYER       |	     ACH        |
	         	        |	byElectronicPaymentForVCP   |	 SUBPAYER_Gen     |    SUBPAYER       |	     VCP        |
	         	        		
	         	        		
Scenario Outline: -  verify sorting in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results sorting for "<Criteria Type>"

Examples:
						|		Search Criteria			| credentials 	|   usertype  |        Criteria Type        |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	     Payer	            |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	   Claim Date           |
	         		    |	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	    NPI 	            |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	  Patient Name          |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	  SuSUBPAYERcriber ID         |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	 Account Number         |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	     Claim #            |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	  Claim Amount          |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	   Market Type          |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	    Archive             |
	         			|	    byDOSAndNpi             |	 SUBPAYER_Admin   |    SUBPAYER       | 	   Payment Date         |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	  Payment Number        |
	         			|	    byDOSAndNpi             |	 SUBPAYER_Admin   |    SUBPAYER       | 	     Amount             |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	     Payer	            |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	   Claim Date           |
	         		    |	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	    NPI 	            |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	  Patient Name          |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	  SuSUBPAYERcriber ID         |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	 Account Number         |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	     Claim #            |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	  Claim Amount          |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	   Market Type          |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	    Archive             |
	         			|	    byDOSAndNpi             |	 SUBPAYER_Gen     |    SUBPAYER       | 	   Payment Date         |
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	  Payment Number        |
	         			|	    byDOSAndNpi             |	 SUBPAYER_Gen     |    SUBPAYER       |       Payment Amount        |
	         			
		
Scenario Outline: - verify search results for search remittance

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Criteria Type>"	

Examples:
						|		Search Criteria			| credentials 	|   usertype  |        Criteria Type            |
	         			|	       byDOP  	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	       byDOP  	            |	
	         	        |	       byDOS	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	       byDOS	            |	
						|	byElectronicPaymentNo       |	 SUBPAYER_Admin   |    SUBPAYER       | 	byElectronicPaymentNo       |	
						|	     byCheckNo        	    |	 SUBPAYER_Admin 	|    SUBPAYER       | 	     byCheckNo        	    |	
						|	    byDOPAndAccountNo       |	 SUBPAYER_Admin   |	 SUBPAYER       | 	    byDOPAndAccountNo       |	
						|	   byDOP&SuSUBPAYERcriberID       |	 SUBPAYER_Admin 	|    SUBPAYER       | 	   byDOP&SuSUBPAYERcriberID       |	
						|	 byDOPAndNpi	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	 byDOPAndNpi	            |	
						|	byDOPAndClaimNo	            |	 SUBPAYER_Admin	|    SUBPAYER       | 	byDOPAndClaimNo	            |	
						|	    byDOPAndPatientNm       |	 SUBPAYER_Admin   |    SUBPAYER       | 	    byDOPAndPatientNm       |	
						|	byDOPAndZeroPaymentClaims   |    SUBPAYER_Admin  	|    SUBPAYER       | 	byDOPAndZeroPaymentClaims   |   
	         	        |	  byDOPAndMarketType        |	 SUBPAYER_Admin   |    SUBPAYER       | 	  byDOPAndMarketType        |	
						|	      byDOSAndAcntNo        |	 SUBPAYER_Admin   |    SUBPAYER       | 	      byDOSAndAcntNo        |	
						|	 byDOSAndSuSUBPAYERcriberId 	    |	 SUBPAYER_Admin 	|    SUBPAYER       | 	 byDOSAndSuSUBPAYERcriberId 	    |	
						|	   byDOSAndNpi              |	 SUBPAYER_Admin   |	 SUBPAYER       | 	   byDOSAndNpi              |	
						|	   byDOSAndClmNo            |	 SUBPAYER_Admin 	|    SUBPAYER       | 	   byDOSAndClmNo            |	
						|	 byDOSAndPtntNm	            |	 SUBPAYER_Admin   |    SUBPAYER       | 	 byDOSAndPtntNm	            |	
						|	byDOSAndZeroPmntClms        |	 SUBPAYER_Admin	|    SUBPAYER       | 	byDOSAndZeroPmntClms        |	
						|	 byDOSAndMarketType         |	 SUBPAYER_Admin   |    SUBPAYER       | 	 byDOSAndMarketType         |	
						|	byDOPAndRenderingProvider   |    SUBPAYER_Admin  	|    SUBPAYER       |		byDOPAndRenderingProvider   |   		
						|	 byDOPAndPatientNm          |	 SUBPAYER_Admin   |    SUBPAYER       | 	       byDOP  	            |	
						|	   byDOP&SuSUBPAYERcriberID       |	 SUBPAYER_Admin 	|    SUBPAYER       | 	       byDOP                |	
						| byCheckNoOfReoriginNacha      |	 SUBPAYER_Admin   |    SUBPAYER       | 	  byCheckNo                 |	
						|    byCheckNoOfConslPayDtl     |	 SUBPAYER_Admin 	|    SUBPAYER       | 	     byCheckNo        	    |	
	         			|	       byDOP  	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	       byDOP  	            |	
	         	        |	       byDOS	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	       byDOS	            |	
						|	byElectronicPaymentNo       |	 SUBPAYER_Gen     |    SUBPAYER       | 	byElectronicPaymentNo       |	
						|	     byCheckNo        	    |	 SUBPAYER_Gen 	|    SUBPAYER       | 	     byCheckNo        	    |	
						|	    byDOPAndAccountNo       |	 SUBPAYER_Gen     |	 SUBPAYER       | 	    byDOPAndAccountNo       |	
						|	   byDOP&SuSUBPAYERcriberID       |	 SUBPAYER_Gen 	|    SUBPAYER       | 	   byDOP&SuSUBPAYERcriberID       |	
						|	 byDOPAndNpi	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	 byDOPAndNpi	            |	
						|	byDOPAndClaimNo	            |	 SUBPAYER_Gen  	|    SUBPAYER       | 	byDOPAndClaimNo	            |	
						|	    byDOPAndPatientNm       |	 SUBPAYER_Gen     |    SUBPAYER       | 	    byDOPAndPatientNm       |	
						|	byDOPAndZeroPaymentClaims   |    SUBPAYER_Gen   	|    SUBPAYER       | 	byDOPAndZeroPaymentClaims   |   
	         	        |	  byDOPAndMarketType        |	 SUBPAYER_Gen     |    SUBPAYER       | 	  byDOPAndMarketType        |	
						|	      byDOSAndAcntNo        |	 SUBPAYER_Gen     |    SUBPAYER       | 	      byDOSAndAcntNo        |	
						|	 byDOSAndSuSUBPAYERcriberId 	    |	 SUBPAYER_Gen 	|    SUBPAYER       | 	 byDOSAndSuSUBPAYERcriberId 	    |	
						|	   byDOSAndNpi              |	 SUBPAYER_Gen     |	 SUBPAYER       | 	   byDOSAndNpi              |	
						|	   byDOSAndClmNo            |	 SUBPAYER_Gen  	|    SUBPAYER       | 	   byDOSAndClmNo            |	
						|	 byDOSAndPtntNm	            |	 SUBPAYER_Gen     |    SUBPAYER       | 	 byDOSAndPtntNm	            |	
						|	byDOSAndZeroPmntClms        |	 SUBPAYER_Gen 	|    SUBPAYER       | 	byDOSAndZeroPmntClms        |	
						|	 byDOSAndMarketType         |	 SUBPAYER_Gen     |    SUBPAYER       | 	 byDOSAndMarketType         |	
						|	byDOPAndRenderingProvider   |    SUBPAYER_Gen  	|    SUBPAYER       |		byDOPAndRenderingProvider   |   		
						|	 byDOPAndPatientNm          |	 SUBPAYER_Gen     |    SUBPAYER       | 	       byDOP  	            |	
						|	   byDOP&SuSUBPAYERcriberID       |	 SUBPAYER_Gen  	|    SUBPAYER       | 	       byDOP                |	
						| byCheckNoOfReoriginNacha      |	 SUBPAYER_Gen     |    SUBPAYER       | 	  byCheckNo                 |	
						|    byCheckNoOfConslPayDtl     |	 SUBPAYER_Gen 	|    SUBPAYER       | 	     byCheckNo        	    |	
																		