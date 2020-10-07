#Author: Pranav
@UPASearchRemittance  @UPARegression @UPASrchRemit
Feature: UPA_Srch_Remittance_BS 

Scenario Outline: - verify returned reason in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then User verifies returned reason for "<Search Criteria>"  in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       |	
	         	        |	       byDOP	            |	 BS_Gen     |    BS       |	    
	         	        

Scenario Outline: - verify Large non large tin in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then verify large non large tin in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       |	
	         	        |	       byDOP	            |	 BS_Gen     |    BS       |	    
	         	        
	         	   										
Scenario Outline: - verify error messages in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then verify error messages in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       |	
	         	        |	       byDOP	            |	 BS_Gen     |    BS       |
	         	        
Scenario Outline: - verify pagination in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify pagination in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       |	
	         	        |	       byDOP	            |	 BS_Gen     |    BS       |	         	        					
	         	        					
	         	        
Scenario Outline: - verify payment status in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify payment status for <"paymentType"> in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |    paymentType  |
	         			|	byElectronicPaymenForACH    |	 BS_Admin   |    BS       |	     ACH        |
	         	        |	byElectronicPaymentForVCP   |	 BS_Admin   |    BS       |	     VCP        |
	         	      	|	byElectronicPaymenForACH    |	 BS_Gen     |    BS       |	     ACH        |
	         	        |	byElectronicPaymentForVCP   |	 BS_Gen     |    BS       |	     VCP        |
	         	        		
	         	        		
Scenario Outline: -  verify sorting in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results sorting for "<Criteria Type>"

Examples:
						|		Search Criteria			| credentials 	|   usertype  |        Criteria Type        |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	     Payer	            |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	   Claim Date           |
	         		    |	       byDOP  	            |	 BS_Admin   |    BS       | 	    NPI 	            |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	  Patient Name          |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	  Subscriber ID         |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	 Account Number         |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	     Claim #            |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	  Claim Amount          |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	   Market Type          |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	    Archive             |
	         			|	    byDOSAndNpi             |	 BS_Admin   |    BS       | 	   Payment Date         |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	  Payment Number        |
	         			|	    byDOSAndNpi             |	 BS_Admin   |    BS       | 	     Amount             |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	     Payer	            |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	   Claim Date           |
	         		    |	       byDOP  	            |	 BS_Gen     |    BS       | 	    NPI 	            |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	  Patient Name          |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	  Subscriber ID         |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	 Account Number         |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	     Claim #            |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	  Claim Amount          |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	   Market Type          |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	    Archive             |
	         			|	    byDOSAndNpi             |	 BS_Gen     |    BS       | 	   Payment Date         |
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	  Payment Number        |
	         			|	    byDOSAndNpi             |	 BS_Gen     |    BS       |       Payment Amount        |
	         			
		
Scenario Outline: - verify search results for search remittance

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Criteria Type>"	

Examples:
						|		Search Criteria			| credentials 	|   usertype  |        Criteria Type            |
	         			|	       byDOP  	            |	 BS_Admin   |    BS       | 	       byDOP  	            |	
	         	        |	       byDOS	            |	 BS_Admin   |    BS       | 	       byDOS	            |	
						|	byElectronicPaymentNo       |	 BS_Admin   |    BS       | 	byElectronicPaymentNo       |	
						|	     byCheckNo        	    |	 BS_Admin 	|    BS       | 	     byCheckNo        	    |	
						|	    byDOPAndAccountNo       |	 BS_Admin   |	 BS       | 	    byDOPAndAccountNo       |	
						|	   byDOP&SubscriberID       |	 BS_Admin 	|    BS       | 	   byDOP&SubscriberID       |	
						|	 byDOPAndNpi	            |	 BS_Admin   |    BS       | 	 byDOPAndNpi	            |	
						|	byDOPAndClaimNo	            |	 BS_Admin	|    BS       | 	byDOPAndClaimNo	            |	
						|	    byDOPAndPatientNm       |	 BS_Admin   |    BS       | 	    byDOPAndPatientNm       |	
						|	byDOPAndZeroPaymentClaims   |    BS_Admin  	|    BS       | 	byDOPAndZeroPaymentClaims   |   
	         	        |	  byDOPAndMarketType        |	 BS_Admin   |    BS       | 	  byDOPAndMarketType        |	
						|	      byDOSAndAcntNo        |	 BS_Admin   |    BS       | 	      byDOSAndAcntNo        |	
						|	 byDOSAndSubscriberId 	    |	 BS_Admin 	|    BS       | 	 byDOSAndSubscriberId 	    |	
						|	   byDOSAndNpi              |	 BS_Admin   |	 BS       | 	   byDOSAndNpi              |	
						|	   byDOSAndClmNo            |	 BS_Admin 	|    BS       | 	   byDOSAndClmNo            |	
						|	 byDOSAndPtntNm	            |	 BS_Admin   |    BS       | 	 byDOSAndPtntNm	            |	
						|	byDOSAndZeroPmntClms        |	 BS_Admin	|    BS       | 	byDOSAndZeroPmntClms        |	
						|	 byDOSAndMarketType         |	 BS_Admin   |    BS       | 	 byDOSAndMarketType         |	
						|	byDOPAndRenderingProvider   |    BS_Admin  	|    BS       |		byDOPAndRenderingProvider   |   		
						|	 byDOPAndPatientNm          |	 BS_Admin   |    BS       | 	       byDOP  	            |	
						|	   byDOP&SubscriberID       |	 BS_Admin 	|    BS       | 	       byDOP                |	
						| byCheckNoOfReoriginNacha      |	 BS_Admin   |    BS       | 	  byCheckNo                 |	
						|    byCheckNoOfConslPayDtl     |	 BS_Admin 	|    BS       | 	     byCheckNo        	    |	
	         			|	       byDOP  	            |	 BS_Gen     |    BS       | 	       byDOP  	            |	
	         	        |	       byDOS	            |	 BS_Gen     |    BS       | 	       byDOS	            |	
						|	byElectronicPaymentNo       |	 BS_Gen     |    BS       | 	byElectronicPaymentNo       |	
						|	     byCheckNo        	    |	 BS_Gen 	|    BS       | 	     byCheckNo        	    |	
						|	    byDOPAndAccountNo       |	 BS_Gen     |	 BS       | 	    byDOPAndAccountNo       |	
						|	   byDOP&SubscriberID       |	 BS_Gen 	|    BS       | 	   byDOP&SubscriberID       |	
						|	 byDOPAndNpi	            |	 BS_Gen     |    BS       | 	 byDOPAndNpi	            |	
						|	byDOPAndClaimNo	            |	 BS_Gen  	|    BS       | 	byDOPAndClaimNo	            |	
						|	    byDOPAndPatientNm       |	 BS_Gen     |    BS       | 	    byDOPAndPatientNm       |	
						|	byDOPAndZeroPaymentClaims   |    BS_Gen   	|    BS       | 	byDOPAndZeroPaymentClaims   |   
	         	        |	  byDOPAndMarketType        |	 BS_Gen     |    BS       | 	  byDOPAndMarketType        |	
						|	      byDOSAndAcntNo        |	 BS_Gen     |    BS       | 	      byDOSAndAcntNo        |	
						|	 byDOSAndSubscriberId 	    |	 BS_Gen 	|    BS       | 	 byDOSAndSubscriberId 	    |	
						|	   byDOSAndNpi              |	 BS_Gen     |	 BS       | 	   byDOSAndNpi              |	
						|	   byDOSAndClmNo            |	 BS_Gen  	|    BS       | 	   byDOSAndClmNo            |	
						|	 byDOSAndPtntNm	            |	 BS_Gen     |    BS       | 	 byDOSAndPtntNm	            |	
						|	byDOSAndZeroPmntClms        |	 BS_Gen 	|    BS       | 	byDOSAndZeroPmntClms        |	
						|	 byDOSAndMarketType         |	 BS_Gen     |    BS       | 	 byDOSAndMarketType         |	
						|	byDOPAndRenderingProvider   |    BS_Gen  	|    BS       |		byDOPAndRenderingProvider   |   		
						|	 byDOPAndPatientNm          |	 BS_Gen     |    BS       | 	       byDOP  	            |	
						|	   byDOP&SubscriberID       |	 BS_Gen  	|    BS       | 	       byDOP                |	
						| byCheckNoOfReoriginNacha      |	 BS_Gen     |    BS       | 	  byCheckNo                 |	
						|    byCheckNoOfConslPayDtl     |	 BS_Gen 	|    BS       | 	     byCheckNo        	    |	
																		