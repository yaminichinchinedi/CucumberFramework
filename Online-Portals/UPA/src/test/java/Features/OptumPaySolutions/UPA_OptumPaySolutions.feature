#Author: Sunanda
@UPAOptumPaySolutions
Feature: - Optum Pay Solutions
   #OBSOLETE FOR NOW
   @US2948672  
  	Scenario Outline: - Optum Pay Solutions - AO Provider Options Page 
   Given User navigates to UPA portal and enters "<userType>" and login
   And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   And   User clicks on Optum Pay Solutions tab
   Then  User verifies Optum Pay Solution Tab for standard user with "<trialStatus>" and "<portalAccess>"
     Examples:
     |    credentials            |	 	      userType    | 	portalAccess    |				searchCriteria   	| tinType		|
       |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  WithinTrial and Paid 	|	  AO			|
       |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and Paid   	|	  AO			|
       |       PROV_Admin        | 			 PROV			    	|			Standard		  |  PostTrial and NotPaid 	|	  AO			|
       |       PROV_Admin        | 			 PROV			    	|			Standard		  |  WithinTrial and NotPaid|	  AO			|
  
		#Author:Sayonee 
	 @UPAUS3060820 @UPAUS3060825
	 Scenario Outline: - Optum Pay Solutions - Verify Post Trial PopUp
   Given User navigates to UPA portal and enters "<credentials>" and login
   And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   And   User clicks on Optum Pay Solutions tab
   Then  Validate the texts in Manage My Plan Tile
   Then Verify the Cancellation Popup based on "<searchCriteria>"
     Examples:
       |    credentials          |	 	      userType    | 	portalAccess    |				searchCriteria   	| tinType		|
       |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  WithinTrial and Paid 	|	  AO			|
       |       PROV_Admin        | 			 PROV			    	|			Premium		  	|  PostTrial and Paid   	|	  AO			|
     
  
      
      @UPAUS3121676
		Scenario Outline: - Optum Pay Solutions - Provider VO tin tiles(content+tiles+hover)
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
   Then  User verifies the Optum Pay Solutions tiles For VO
     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   PROV_Admin    |     PROV     	|		 	PostTrial and Paid		|			Premium			|		VO			|
      
      @UPAUS3121676
		Scenario Outline: - Optum Pay Solutions - BS VO tin tiles(content+tiles+hover)
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then User Enters tin for OPS and click on search button for "<userType>".
    Then  User verifies the Optum Pay Solutions tiles For VO
     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   BS_Admin    |     BS     	|		 	PostTrial and Paid		|			Premium			|		VO			|



#Author: Mohammad Khalid
@UPA_OPS_US2949033
Scenario Outline: To test page text messaging on OPS for Prov Admin

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And   User clicks on Optum Pay Solutions tab

Then User verifies page text "<PageMessageText_Top>" messaging in Optum Pay Solutions page
And User verifies page text "<PageMessageText_Footer>" messaging in Optum Pay Solutions page


 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|   PageMessageText_Top    |PageMessageText_Footer |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Standard	  |		AO			|      Standard_Msg_1      |  Standard_Msg_2       |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Premium		  |		AO			|      Premium_TopMsg      |   Premium_FooterMsg   |
      
      
      


#Author: Mohammad Khalid
@UPA_OPS_US3222937_ProvAdmin
Scenario Outline: To validate Invoices tab for Provider admin users

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And User clicks on Optum Pay Solutions tab

Then User clicks on "Invoices" tab
And User validates "ProviderName" 
And User validates "AccruedFees" 
And User validates "PastDueFees" 
And User validates "InvoicePeriodGrid" 



 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		AO			|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Standard     	  |		AO			|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		VO			|  

 
 #Author: Mohammad Khalid
@UPA_OPS_US3222937_BSAdmin
Scenario Outline: To validate Invoices tab for Provider admin users

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And User clicks on Optum Pay Solutions tab
 Then User Enters tin for OPS and click on search button for "<userType>".
 
Then User clicks on "Invoices" tab
And User validates "ProviderName" 
And User validates "AccruedFees" 
And User validates "PastDueFees" 
And User validates "InvoicePeriodGrid" 



 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|  
 |      BS_Admin   |     BS     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		AO			|  
 |      BS_Admin   |     BS      	|		PremiumOrStandardFeeInvoice		|		Standard     	  |		AO			|  
 |      BS_Admin   |     BS     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		VO			|  
 

        @UPAUS3232882
		Scenario Outline: - Optum Pay Solutions - Provider VO tin tiles(content+tiles+hover)
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
		Then User validates contents of Past due fee of Fee tiles for this page

     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   PROV_Admin    |     PROV     	|		 	zeroPastdueFee					|			Premium			|		AO			| 
      |   PROV_Admin    |     PROV      |		 	positivePastdueFee			|			Premium			|		AO			|
     
      @UPAUS3232882_BS
     Scenario Outline: - Optum Pay Solutions - BS VO tin tiles(content+tiles+hover)
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
    Then User Enters tin for OPS and click on search button for "<userType>".
   Then User validates contents of Past due fee of Fee tiles for this page
     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   BS_Admin    |     BS     	|		 	zeroPastdueFee		|			Premium			|		AO			| 
      |   BS_Admin    |     BS     	|		 	positivePastdueFee		|			Premium			|		AO			| 
