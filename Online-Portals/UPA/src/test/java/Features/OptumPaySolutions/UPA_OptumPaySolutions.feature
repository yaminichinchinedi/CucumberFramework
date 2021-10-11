#Author: Sunanda
@UPAOptumPaySolutions @UPARegression
Feature: - Optum Pay Solutions
  
   #OBSOLETE FOR NOW
 #  @US2948672  
  #	Scenario Outline: - Optum Pay Solutions - AO Provider Options Page 
   #Given User navigates to UPA portal and enters "<userType>" and login
   #And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   #And   User clicks on Optum Pay Solutions tab
   
   #Then  User verifies Optum Pay Solution Tab for standard user with "<trialStatus>" and "<portalAccess>"
  #   Examples:
   #  |    credentials            |	 	      userType    | 	portalAccess    |				searchCriteria   	| tinType		|
    #   |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  WithinTrial and Paid 	|	  AO			|
     #  |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and Paid   	|	  AO			|
      # |       PROV_Admin        | 			 PROV			    	|			Standard		  |  PostTrial and NotPaid 	|	  AO			|
       #|       PROV_Admin        | 			 PROV			    	|			Standard		  |  WithinTrial and NotPaid|	  AO			|
  
		#Author:Sayonee 
	 @UPAUS3060820 @UPAUS3060825 @UPAStable
	 Scenario Outline: - Verify Post Trial PopUp for "<credentials>"
   Given User navigates to UPA portal and enters "<credentials>" and login
   And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   And   User clicks on Optum Pay Solutions tab
   Then  Validate the texts in Manage My Plan Tile
   Then Verify the Cancellation Popup based on "<searchCriteria>"
   And User clicks on UPA logout
   
     Examples:
       |    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   	| tinType		|
      |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  WithinTrial and Paid 	|	  AO			|
       |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and Paid   	|	  AO			|
     
  
      
      @UPAUS3121676 @UPAStable
		Scenario Outline: - Provider VO tin tiles(content+tiles+hover) for "<credential>"
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
   Then  User verifies the Optum Pay Solutions tiles For VO
   And User clicks on UPA logout
     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   PROV_Admin    |     PROV     	|		 	PostTrial and Paid		|			Premium			|		VO			|
      
      @UPAUS3121676 @UPAStable
		Scenario Outline: - BS VO tin tiles(content+tiles+hover) for "<credential>"
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then User Enters tin for OPS and click on search button for "<userType>".
    Then  User verifies the Optum Pay Solutions tiles For VO
    And User clicks on UPA logout
     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   BS_Admin    |     BS     	|		 	PostTrial and Paid		|			Premium			|		VO			|



#Author: Mohammad Khalid
@UPA_OPS_US2949033 @UPAStable
Scenario Outline: To test page text messaging on OPS for Prov Admin

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And   User clicks on Optum Pay Solutions tab

Then User verifies page text "<PageMessageText_Top>" messaging in Optum Pay Solutions page
And User verifies page text "<PageMessageText_Footer>" messaging in Optum Pay Solutions page
And User clicks on UPA logout


 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|   PageMessageText_Top    |PageMessageText_Footer |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Standard	  |		AO			|      Standard_Msg_1      |  Standard_Msg_2       |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Premium		  |		AO			|      Premium_TopMsg      |   Premium_FooterMsg   |
      
      
      


#Author: Mohammad Khalid
@UPA_OPS_US3222937_ProvAdmin @UPAStable 
Scenario Outline: To validate Invoices tab for Provider admin users

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And User clicks on Optum Pay Solutions tab
Then User clicks on "Invoices" tab
And User validates Provider Name, Accrued Fees, Past Due Fees and Invoice Period Grid
And User clicks on UPA logout

 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		AO			|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Standard     	  |		AO			|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		VO			|  

 
 #Author: Mohammad Khalid-invoices tab not available
@UPA_OPS_US3222937_BSAdmin @UPAStable 
Scenario Outline: To validate Invoices tab for BS admin users

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And User clicks on Optum Pay Solutions tab
 Then User Enters tin for OPS and click on search button for "<userType>".
Then User clicks on "Invoices" tab
And User validates Provider Name, Accrued Fees, Past Due Fees and Invoice Period Grid
And User clicks on UPA logout

 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|  
 |      BS_Admin   |     BS     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		AO			|  
 |      BS_Admin   |     BS      	|		PremiumOrStandardFeeInvoice		|		Standard     	  |		AO			|  
 |      BS_Admin   |     BS     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		VO			|  
 

        @UPAUS3232882 @UPAStable
		Scenario Outline: - Optum Pay Solutions - Provider VO tin tiles(content+tiles+hover) +add data on debit_fee_invc
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
		Then User validates contents of Past due fee of Fee tiles for this page
		And User clicks on UPA logout

     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   PROV_Admin    |     PROV     	|		 	zeroPastdueFee					|			Premium			|		AO			| 
      |   PROV_Admin    |     PROV      |		 	positivePastdueFee			|			Premium			|		AO			|
     
      @UPAUS3232882_BS @UPAStable 
     Scenario Outline: - Optum Pay Solutions - BS VO tin tiles(content+tiles+hover)
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then User Enters tin for OPS and click on search button for "<userType>".
   Then User validates contents of Past due fee of Fee tiles for this page
   And User clicks on UPA logout
     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   BS_Admin    |     BS     	|		 	zeroPastdueFee		|			Premium			|		AO			| 
      |   BS_Admin    |     BS     	|		 	positivePastdueFee		|			Premium			|		AO			| 

      
      
#Author: Mohammad Khalid
@UPA_OPS_US3106783 @UPAStable
Scenario Outline: To test page text messaging on OPS for Prov Admin

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And User clicks on Optum Pay Solutions tab
Then User validated header and footer message on options tab for "<tinType>" for "<userType>".
Then User validates info icon hover message for Plan Type, Rate, Fees and Manage My Plan tile 
And User clicks on UPA logout

 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|  
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Premium  	  |		AO			|  
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Premium  	  |		VO			|  
|      PROV_Admin | 	 PROV				|		 WithinTrial and Paid 		|			Premium		  |   AO			|
 
     
#Author: Amit
@UPA_OPS_US @UPAStable 
Scenario Outline: To test page text messaging on OPS for BS Admin

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And User clicks on Optum Pay Solutions tab
Then User Enters tin for OPS and click on search button for "<userType>".
Then User validated header and footer message on options tab for "<tinType>" for "<userType>".
Then User validates info icon hover message for Plan Type, Rate, Fees and Manage My Plan tile 
And User clicks on UPA logout

 Examples:
 |	credentials  |    userType  | 			searchCriteria				|		portalAccess	| tinType	 	|  
 |   BS_Admin  	 | 	 			BS		|		 	PremiumOrStandardTIN		|			Premium  	  |		AO			|  
 |   BS_Admin  	 | 	 			BS		|		 	PremiumOrStandardTIN		|			Premium  	  |		VO			|
 
 
 
 
 #Author: Mohammad Khaid
 @UPA_OPS_US3259226 @UPAStable
 Scenario Outline: Access Payments - OPS tab vaidation for BS Users
		Given User navigates to UPA portal and enters "<credentials>" and login
		And  User clicks on Optum Pay Solutions tab
		Then User verifies if tiles are present for "Standard" TIN
		
		And  User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess1>" for Portal Experience.
		And  Click on View Payments Link in UPA
		Then User Enters tin and click on search button for "<userType>".
		And  User clicks on Optum Pay Solutions tab
   		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User verifies if tiles are present for "<portalAccess1>" TIN
		
   		And  User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess2>" for Portal Experience.
   		Then User Enters tin for OPS and click on search button for "<userType>".
   		Then User verifies if tiles are present for "<portalAccess2>" TIN
   		   		
   		Then User Enters an "Invalid" tin for OPS and click on search button for "<userType>".
   		And User verifies the error message for "Invalid" tin
   		   		
   		Then User Enters an "NotAssociated" tin for OPS and click on search button for "<userType>".
  		And User verifies the error message for "NotAssociated" tin
  		And User clicks on UPA logout
   		
 Examples:		
      | credentials  |  userType 	|	 searchCriteria    |	portalAccess1	|  portalAccess2  | tinType	|		
      |   BS_Admin	 | 		BS		| PremiumOrStandardTIN |	 Premium		|	Standard     |AO		|	
      |   BS_Admin	 | 		BS		| PremiumOrStandardTIN |	 Standard		|	Premium      |AO		|	
       
       
       
       
    @UPAUS3329105 @UPAStable 
  	Scenario Outline: - Optum Pay Solutions - Invoice pdf open in new tab 
   	Given User navigates to UPA portal and enters "<credentials>" and login
   	And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   	And User clicks on Optum Pay Solutions tab
   	Then User clicks on "Invoices" tab
   	Then User clicks on Invoice Number that opens pdf in new tab
   	Then User clicks on UPA logout
   	Examples:
    	|    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   				| tinType		|
      |       PROV_Admin        | 			 PROV			    |			Premium		  	|  PremiumOrStandardFeeInvoice 	|	  AO			|
       

    #Author: Marsha 
 		@UPAOptumPaySolBSUserStdAndErrorMessages @US3123337 @UPAStable
   	Scenario Outline: Optum Pay Solutions - Standard experience for BS and error messages 
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And User clicks on Optum Pay Solutions tab
    Then User Enters tin for OPS and click on search button for "<userType>".
    And User verifies the Optum Pay Solution page for "<userType>" for "<portalAccess>" for "<tinType>"
    Then User clicks on UPA logout

     Examples:
    	 |    credentials          |	 	  userType    		| 	portalAccess    	|				searchCriteria   	| tinType		|
       |       BS_Admin        	 | 			 BS			    		|			Standard		  	|  PostTrial and NotPaid 	|	  AO			|
       |       BS_Admin        	 | 			 BS			    		|			Standard		  	|  WithinTrial and NotPaid|	  AO			|


    #Author: Marsha
    @UPACancelPremiumDb @US3375699 @US3372495
   	Scenario Outline: Optum Pay Solutions - Cancel UPA Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		And User clicks on Optum Pay Solutions tab
	  Then Fill Cancel Details with Reason as "<reasonCode>" and Submit for "UPA" 
  	Then Verify that the Premium is cancelled for "<searchCriteria>" on "UPA"
	  Then User clicks on UPA logout
	    
		 Examples:
			 |		credentials  |    userType    | 			searchCriteria							|		portalAccess	  | tinType		| reasonCode |
			 |     PROV_Admin  |     PROV     	|		PostTrial and Paid							|		Premium     	  |		AO			|  R7				|
			 |     PROV_Admin  |     PROV     	|		New Enroll WithinTrial and Paid	|		Premium     	  |		AO			|  R7				|
			 
			  #Author:Marsha
    @UPA_VerifyEffectiveDateOfNewAchTin @US3221318
   	Scenario Outline: Optum Pay Solutions - Cancel UPA Premium
		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		And User clicks on Optum Pay Solutions tab
    And Verify the effective date for "Standard" record for "<tinType>"
    Then User clicks on Get Started to select Premium
    And Verify the effective date for "Premium" record for "<tinType>"
	  Then User clicks on UPA logout
	    
		 Examples:
			 |		credentials  |    userType    | 			searchCriteria									|		portalAccess	  | tinType		|
			 |     PROV_Admin  |     PROV     	|		New Enroll WithinTrial and NotPaid	|		Standard     	  |		AO			|
		            
		            
		 @UPAUS3453134
  	Scenario Outline: - Optum Pays Solutions - Invoice Integration with ABA validator for ACH payment
   	Given User navigates to UPA portal and enters "<credentials>" and login
   	And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   	And User clicks on Optum Pay Solutions tab
   	Then User clicks on "Invoices" tab
   	Then User clicks on Pay Now Button
    Then User validates Process My Payment modal
    Then User validates RTN when ABA Switch is "<ABA Switch>" and "<responseType>" response from ABA API

    Examples:
    	|    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   				| tinType		| ABA Switch | responseType |
      |       PROV_Admin       	| 			 PROV		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   Y				 |    Valid     |
      |       PROV_Admin       	| 			 PROV		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   Y				 |  Invalid     |
      |       PROV_Admin       	| 			 PROV		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   N				 |  Invalid     |
      
		 @UPAUS3453134
  	Scenario Outline: - Optum Pays Solutions - Invoice Integration with ABA validator for ACH payment
   	Given User navigates to UPA portal and enters "<credentials>" and login
   	And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   	And User clicks on Optum Pay Solutions tab
   	Then User Enters tin for OPS and click on search button for "<userType>".
   	Then User clicks on "Invoices" tab
   	Then User clicks on Pay Now Button
    Then User validates Process My Payment modal
    Then User validates RTN when ABA Switch is "<ABA Switch>" and "<responseType>" response from ABA API
    
    Examples:
      |    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   				| tinType		| ABA Switch | responseType |
      |       BS_Admin        	| 			  BS		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   Y				 |    Valid     |
      |       BS_Admin        	| 			  BS		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   Y				 |  Invalid     |
      |       BS_Admin        	| 			  BS		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   N				 |  Invalid     |

 #Author:Sayonee
 #Author: sai
		 @UPAUS3443039 @US3443069 @UPAUS3450360
  	Scenario Outline: - Optum Pays Solutions - Invoice Integration with ABA validator for ACH payment
   	Given User navigates to UPA portal and enters "<credentials>" and login
   	And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   	And User clicks on Optum Pay Solutions tab
   	Then User clicks on "Invoices" tab
   	Then User clicks on Pay Now Button
    Then User validates Process My Payment modal
    Then User validates RTN when ABA Switch is "<ABA Switch>" and "<responseType>" response from ABA API
    Then User verifies the Modal post filling information and Submits the ACH Payment Modal
    Then User clicks on close button of Thank you popup

    Examples:
    	|    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   				| tinType		| ABA Switch | responseType |
      |       PROV_Admin       	| 			 PROV		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   Y				 |    Valid     |
      
    #Author:Sayonee
		 @UPAUS3443039 @UPAUS3450360
  	Scenario Outline: - Optum Pays Solutions - Invoice Integration with ABA validator for ACH payment
   	Given User navigates to UPA portal and enters "<credentials>" and login
   	And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   	And User clicks on Optum Pay Solutions tab
   		Then User Enters tin for OPS and click on search button for "<userType>".
   	Then User clicks on "Invoices" tab
   	Then User clicks on Pay Now Button
    Then User validates Process My Payment modal
    Then User validates RTN when ABA Switch is "<ABA Switch>" and "<responseType>" response from ABA API
    Then User verifies the Modal post filling information and Submits the ACH Payment Modal
    Then User clicks on close button of Thank you popup

    Examples:
    	|    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   				| tinType		| ABA Switch | responseType |
 		  |       BS_Admin        	| 			  BS		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|   Y				 |    Valid     |     
 		  
		 
	#Author: Sai 
	 @US3462418 @US3462418_ProvAdmin
	 Scenario Outline: Optum Pay Solutions - Header message update
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	 And User clicks on Optum Pay Solutions tab
	 Then User clicks on "Invoices" tab
	 Then verify the Invoice tab header message
Examples:
    	|  credentials    |	 	userType    | 	portalAccess    |	searchCriteria   				| tinType		|
    #  |     PROV_Admin  | 	PROV			  |			Premium 		  |  PremiumOrStandardTIN   |	  AO			|
    #  |     PROV_Admin  | 	PROV			  |			Standard 		  | PremiumOrStandardTIN    |	  AO			|
      |       PROV_Admin       	| 			 PROV		   		|			Premium		  	|  				ValidInvoice  			  |	  AO			|
     |       PROV_Admin       	| 			 PROV		   		|			Standard		  	|  				ValidInvoice  			  |	  AO			|
  
  @US3462418 @US3462418_BSadmin
  Scenario Outline: Optum Pay Solutions - Header message update
   Given User navigates to UPA portal and enters "<credentials>" and login
  And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  And User clicks on Optum Pay Solutions tab
  Then User Enters tin for OPS and click on search button for "<userType>".
  Then User clicks on "Invoices" tab
  Then verify the Invoice tab header message  
Examples:


 |  credentials   |    userType | 	   portalAccess    |		searchCriteria	  | tinType	  |  
 #|     BS_Admin   |     BS     	|		PremiumOrStandardTIN |		Premium     	  |		AO			|  
 #|     BS_Admin   |     BS      |		PremiumOrStandardTIN |		Standard     	  |		AO			|  
      |    BS_Admin   |     BS     			  |			Premium 		  |  ValidInvoice  			  |	  AO			|
      |   BS_Admin   |     BS     			  |			Standard 		  | ValidInvoice  			  |	  AO			|
  
 
 #BELOW SCENARIO IS NOT ON STAGE
 @UPAUS3478620 
      Scenario Outline: PayNow btn disabled for Credit Invoice Prov
   Given User navigates to UPA portal and enters "<credentials>" and login
  And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  And User clicks on Optum Pay Solutions tab
  Then User clicks on "Invoices" tab
  Then verify that the Pay Now Button is disabled for Credit only Invoice
  Examples:
    	|    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   				| tinType		| 
      |       PROV_Admin       	| 			 PROV		   		|			Premium		  	|  				RefundInvoice  			  |	  AO			| 
      |       PROV_Admin       	| 			 PROV		   		|			Standard	  	|  				RefundInvoice  			  |	  AO			| 
      |       PROV_Admin       	| 			 PROV		   		|			Premium		  	|  				RefundInvoice  			  |	  VO			| 
      
    @UPAUS3478620
      Scenario Outline: PayNow btn disabled for Credit Invoice BS 
   Given User navigates to UPA portal and enters "<credentials>" and login
  And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  And User clicks on Optum Pay Solutions tab
    Then User Enters tin for OPS and click on search button for "<userType>".
  Then User clicks on "Invoices" tab
  Then verify that the Pay Now Button is disabled for Credit only Invoice
  Examples:
    	|    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   				| tinType		| 
      |       BS_Admin       	| 			 BS	   		|			Premium		  	|  				RefundInvoice  			  |	  AO			| 
      |       BS_Admin       	| 			 BS		   		|			Standard	  	|  				RefundInvoice  			  |	  AO			| 
      |       BS_Admin      	| 			 BS		   		|			Premium		  	|  				RefundInvoice  			  |	  VO			| 

 
 
 @US3485959
 Scenario Outline: - Optum Pay Solutions - Add Current billing month to the Total accrued fees label - UPA Prov
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then User validates contents of Fee tiles of this page
    Then User clicks on "Invoices" tab
	 Then User validates accrued content fee on this page
		And User clicks on UPA logout
		
		     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   PROV_Admin    |     PROV     	|		 	wthAccuredFee					|			Premium			|		AO			| 
    @US3485959  
    Scenario Outline: - Optum Pay Solutions - Add Current billing month to the Total accrued fees label - UPA
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then User Enters tin for OPS and click on search button for "<userType>".
    Then User validates contents of Fee tiles of this page
    Then User clicks on "Invoices" tab
	  Then User validates accrued content fee on this page
		And User clicks on UPA logout
		
		     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   BS_Admin        |     BS     	|		 	wthAccuredFee					|			Premium			|		AO			|  
      @US3485959
   Scenario Outline: Optum Pay Solutions - Add Current billing month to the Total accrued fees label - UPA VO Tins
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	 And User clicks on Optum Pay Solutions tab
	 Then User clicks on "Invoices" tab
	 Then User validates accrued content fee on this page 
Examples:
    	|  credentials    |	 	userType    | 	portalAccess    |	searchCriteria   				| tinType		|
      |     PROV_Admin  | 	PROV			  |			Premium 		  |  wthAccuredFee        |	  VO			|    

#Author: Sai
@UPAUS3561591
 Scenario Outline: Access Payments - Failed Payment Invoice UI - UPA
  Given User navigates to UPA portal and enters "<credentials>" and login
  And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  And User clicks on Optum Pay Solutions tab
  Then User clicks on "Invoices" tab
  Then User hover over purple dots
  
  Examples:
    	|    credentials        |	 	   userType    | 	portalAccess    |		searchCriteria   	| tinType		| 
      |     PROV_Admin       	| 			 PROV		   |		Premium		    |  	 FailedInvoice  	|	  AO			| 
      
  
  @UPAUS3918104
   Scenario Outline: Access Payments -Recurring ACH debit Payments
  Given User navigates to UPA portal and enters "<credentials>" and login
  And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  And User clicks on Optum Pay Solutions tab
  Then User clicks on "Invoices" tab
  Then User clicks on Set up recurring payments button
  Then User clicks on Continue button of welcome to recurring payments
  Then User selects Tins from the TIN grid,clicks one of radio button of one Available ACH debit options and Clicks on Assign Account button
  Then verifies that in TIN grid  Account ending and Pay type columns are populated with selected ACH debit options
  
  
  Examples:
    	|    credentials        |	 	   userType    | 	portalAccess    |		searchCriteria   	    | tinType		| 
      |     PROV_Admin       	| 			 PROV		   |		Premium		    |  	TinWithoutRecurrPay  	|	  AO			| 
      
      
   @UPAUS3918104_BS
   Scenario Outline: Access Payments -Recurring ACH debit Payments for BS User
   Given User navigates to UPA portal and enters "<credentials>" and login
  And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  And User clicks on Optum Pay Solutions tab
  Then User Enters tin for OPS and click on search button for "<userType>".
  Then User clicks on "Invoices" tab
  Then User clicks on Set up recurring payments button
  Then User clicks on Continue button of welcome to recurring payments
  Then User selects Tins from the TIN grid,clicks one of radio button of one Available ACH debit options and Clicks on Assign Account button
  Then verifies that in TIN grid  Account ending and Pay type columns are populated with selected ACH debit options
  
  
  Examples:
    	|    credentials        |	 	   userType    | 	portalAccess    |		searchCriteria   	    | tinType		| 
      |     BS_Admin        	| 			 BS 		   |		Premium		    |  	TinWithoutRecurrPay  	|	  AO			|    