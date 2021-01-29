#Author: Pranav
@UPASearchRemittance  @UPARegression  @UPASrchRemitPayer
Feature: UPA_Search_Remittance_Payer
	
Scenario Outline: - verify returned reason in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then User verifies returned reason for "<Search Criteria>"  in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       |	
	         	        |	       byDOP	            |	 PAY_Gen     |    PAY       |	    
	         	        
         	        
Scenario Outline: - verify Large non large tin in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then verify large non large tin in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       |	
	         	        |	       byDOP	            |	 PAY_Gen     |    PAY       |	    
	         	        
	         	   										
Scenario Outline: - verify error messages in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then verify error messages in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       |	
	         	        |	       byDOP	            |	 PAY_Gen     |    PAY       |
	         	        
Scenario Outline: - verify pagination in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify pagination in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       |	
	         	        |	       byDOP	            |	 PAY_Gen     |    PAY       |	         	        					
	         	        					
	         	        
Scenario Outline: - verify payment status in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify payment status for <"paymentType"> in search results

Examples:
						|		Search Criteria			| credentials 	|   usertype  |    paymentType  |
	         			|	byElectronicPaymenForACH    |	 PAY_Admin   |    PAY       |	     ACH        |
	         	        |	byElectronicPaymentForVCP   |	 PAY_Admin   |    PAY       |	     VCP        |
	         	      	|	byElectronicPaymenForACH    |	 PAY_Gen     |    PAY       |	     ACH        |
	         	        |	byElectronicPaymentForVCP   |	 PAY_Gen     |    PAY       |	     VCP        |
	         	        		
	         	        		
Scenario Outline: -  verify sorting in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results sorting for "<Criteria Type>"

Examples:
						|		Search Criteria			| credentials 	|   usertype  |        Criteria Type        |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	     Payer	            |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	   Claim Date           |
	         		    |	       byDOP  	            |	 PAY_Admin   |    PAY       | 	    NPI 	            |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	  Patient Name          |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	  SuPAYcriber ID         |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	 Account Number         |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	     Claim #            |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	  Claim Amount          |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	   Market Type          |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	    Archive             |
	         			|	    byDOSAndNpi             |	 PAY_Admin   |    PAY       | 	   Payment Date         |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	  Payment Number        |
	         			|	    byDOSAndNpi             |	 PAY_Admin   |    PAY       | 	     Amount             |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	     Payer	            |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	   Claim Date           |
	         		    |	       byDOP  	            |	 PAY_Gen     |    PAY       | 	    NPI 	            |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	  Patient Name          |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	  SuPAYcriber ID         |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	 Account Number         |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	     Claim #            |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	  Claim Amount          |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	   Market Type          |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	    Archive             |
	         			|	    byDOSAndNpi             |	 PAY_Gen     |    PAY       | 	   Payment Date         |
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	  Payment Number        |
	         			|	    byDOSAndNpi             |	 PAY_Gen     |    PAY       |       Payment Amount        |
	         			
		
Scenario Outline: - verify search results for search remittance

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify search results for "<Criteria Type>"	

Examples:
						|		Search Criteria			| credentials 	|   usertype  |        Criteria Type            |
	         			|	       byDOP  	            |	 PAY_Admin   |    PAY       | 	       byDOP  	            |	
	         	        |	       byDOS	            |	 PAY_Admin   |    PAY       | 	       byDOS	            |	
						|	byElectronicPaymentNo       |	 PAY_Admin   |    PAY       | 	byElectronicPaymentNo       |	
						|	     byCheckNo        	    |	 PAY_Admin 	|    PAY       | 	     byCheckNo        	    |	
						|	    byDOPAndAccountNo       |	 PAY_Admin   |	 PAY       | 	    byDOPAndAccountNo       |	
						|	   byDOP&SuPAYcriberID       |	 PAY_Admin 	|    PAY       | 	   byDOP&SuPAYcriberID       |	
						|	 byDOPAndNpi	            |	 PAY_Admin   |    PAY       | 	 byDOPAndNpi	            |	
						|	byDOPAndClaimNo	            |	 PAY_Admin	|    PAY       | 	byDOPAndClaimNo	            |	
						|	    byDOPAndPatientNm       |	 PAY_Admin   |    PAY       | 	    byDOPAndPatientNm       |	
						|	byDOPAndZeroPaymentClaims   |    PAY_Admin  	|    PAY       | 	byDOPAndZeroPaymentClaims   |   
	         	        |	  byDOPAndMarketType        |	 PAY_Admin   |    PAY       | 	  byDOPAndMarketType        |	
						|	      byDOSAndAcntNo        |	 PAY_Admin   |    PAY       | 	      byDOSAndAcntNo        |	
						|	 byDOSAndSuPAYcriberId 	    |	 PAY_Admin 	|    PAY       | 	 byDOSAndSuPAYcriberId 	    |	
						|	   byDOSAndNpi              |	 PAY_Admin   |	 PAY       | 	   byDOSAndNpi              |	
						|	   byDOSAndClmNo            |	 PAY_Admin 	|    PAY       | 	   byDOSAndClmNo            |	
						|	 byDOSAndPtntNm	            |	 PAY_Admin   |    PAY       | 	 byDOSAndPtntNm	            |	
						|	byDOSAndZeroPmntClms        |	 PAY_Admin	|    PAY       | 	byDOSAndZeroPmntClms        |	
						|	 byDOSAndMarketType         |	 PAY_Admin   |    PAY       | 	 byDOSAndMarketType         |	
						|	byDOPAndRenderingProvider   |    PAY_Admin  	|    PAY       |		byDOPAndRenderingProvider   |   		
						|	 byDOPAndPatientNm          |	 PAY_Admin   |    PAY       | 	       byDOP  	            |	
						|	   byDOP&SuPAYcriberID       |	 PAY_Admin 	|    PAY       | 	       byDOP                |	
						| byCheckNoOfReoriginNacha      |	 PAY_Admin   |    PAY       | 	  byCheckNo                 |	
						|    byCheckNoOfConslPayDtl     |	 PAY_Admin 	|    PAY       | 	     byCheckNo        	    |	
	         			|	       byDOP  	            |	 PAY_Gen     |    PAY       | 	       byDOP  	            |	
	         	        |	       byDOS	            |	 PAY_Gen     |    PAY       | 	       byDOS	            |	
						|	byElectronicPaymentNo       |	 PAY_Gen     |    PAY       | 	byElectronicPaymentNo       |	
						|	     byCheckNo        	    |	 PAY_Gen 	|    PAY       | 	     byCheckNo        	    |	
						|	    byDOPAndAccountNo       |	 PAY_Gen     |	 PAY       | 	    byDOPAndAccountNo       |	
						|	   byDOP&SuPAYcriberID       |	 PAY_Gen 	|    PAY       | 	   byDOP&SuPAYcriberID       |	
						|	 byDOPAndNpi	            |	 PAY_Gen     |    PAY       | 	 byDOPAndNpi	            |	
						|	byDOPAndClaimNo	            |	 PAY_Gen  	|    PAY       | 	byDOPAndClaimNo	            |	
						|	    byDOPAndPatientNm       |	 PAY_Gen     |    PAY       | 	    byDOPAndPatientNm       |	
						|	byDOPAndZeroPaymentClaims   |    PAY_Gen   	|    PAY       | 	byDOPAndZeroPaymentClaims   |   
	         	        |	  byDOPAndMarketType        |	 PAY_Gen     |    PAY       | 	  byDOPAndMarketType        |	
						|	      byDOSAndAcntNo        |	 PAY_Gen     |    PAY       | 	      byDOSAndAcntNo        |	
						|	 byDOSAndSuPAYcriberId 	    |	 PAY_Gen 	|    PAY       | 	 byDOSAndSuPAYcriberId 	    |	
						|	   byDOSAndNpi              |	 PAY_Gen     |	 PAY       | 	   byDOSAndNpi              |	
						|	   byDOSAndClmNo            |	 PAY_Gen  	|    PAY       | 	   byDOSAndClmNo            |	
						|	 byDOSAndPtntNm	            |	 PAY_Gen     |    PAY       | 	 byDOSAndPtntNm	            |	
						|	byDOSAndZeroPmntClms        |	 PAY_Gen 	|    PAY       | 	byDOSAndZeroPmntClms        |	
						|	 byDOSAndMarketType         |	 PAY_Gen     |    PAY       | 	 byDOSAndMarketType         |	
						|	byDOPAndRenderingProvider   |    PAY_Gen  	|    PAY       |		byDOPAndRenderingProvider   |   		
						|	 byDOPAndPatientNm          |	 PAY_Gen     |    PAY       | 	       byDOP  	            |	
						|	   byDOP&SuPAYcriberID       |	 PAY_Gen  	|    PAY       | 	       byDOP                |	
						| byCheckNoOfReoriginNacha      |	 PAY_Gen     |    PAY       | 	  byCheckNo                 |	
						|    byCheckNoOfConslPayDtl     |	 PAY_Gen 	|    PAY       | 	     byCheckNo        	    |	
	
	
	@test123
Scenario Outline: Access Payments- Payer Portal Search Results

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	

Examples:
						|		Search Criteria			| credentials 	|   usertype  |
	         	|	       byDOP  	      |	 PAY_Admin   |    PAY       |	
																															
																		