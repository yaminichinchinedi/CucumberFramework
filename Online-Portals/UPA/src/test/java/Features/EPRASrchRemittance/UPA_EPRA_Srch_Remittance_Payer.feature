#Author: Athyusha
#PPS.4012 job should be running to execute these test cases.

@UPASrchRemitEPRA1  @UPARegression @UPAPayerSrchEPRA
Feature: UPA_EPRA_Srch_Remittance_Payer


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
  And validate PDF icon is enabled and is downloadable for "<Search Criteria>".
  And validate Claim_Count and Priority is set accordingly based on "<Search Criteria>" for Search Remit Page
  And validate new Entry is created in Ole.EPRA_STATUS with C status for Search Remit Page
	And validate download status is set to Y in Ole.EPRA_STATUS
	And validate record is inserted in User_Event_Log for "<usertype>"
	
	Examples:
						|		Search Criteria			|				credentials		  	|			priority		|			searchBy		              |   usertype   |
						|	byElectronicPaymentNo	|			 PAY_Admin		      |					1				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Admin					|					2				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Admin    		  |					1				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Admin					|					2				|			EPRAPayergeneratedAdmin		|    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Gen  		      |					1				|			EPRAPayergeneratedGen		  |    Payer     |
						|	byElectronicPaymentNo	|			 PAY_Gen  					|					2				|			EPRAPayergeneratedGen		  |    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Gen      		  |					1				|			EPRAPayergeneratedGen		  |    Payer     |
						|	    byDOPAndNpi	      |			 PAY_Gen  					|					2				|			EPRAPayergeneratedGen	    |    Payer     |
	
	
	
Scenario Outline: - verify returned reason in search remittance page

	Given User navigates to UPA portal and enters "<credentials>" and login
	Then User clicks on Search Remittance link for UPA
	And User enters tin for UPA Search Remittance Tin Page for "<Search Criteria>" through "<usertype>" and click on continue button
	Then User enters "<Search Criteria>" and click on search button.
	Then verify returned reason for <"Search Criteria">  in search results

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
																															
																		