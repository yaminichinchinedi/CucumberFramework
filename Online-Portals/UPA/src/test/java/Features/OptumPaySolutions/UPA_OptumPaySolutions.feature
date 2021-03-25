#Author: Sunanda
@UPAOptumPaySolutions
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
	 @UPAUS3060820 @UPAUS3060825
	 Scenario Outline: - Optum Pay Solutions - Verify Post Trial PopUp
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
     
  
      
      @UPAUS3121676
		Scenario Outline: - Optum Pay Solutions - Provider VO tin tiles(content+tiles+hover)
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
   Then  User verifies the Optum Pay Solutions tiles For VO
   And User clicks on UPA logout
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
    And User clicks on UPA logout
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
And User clicks on UPA logout


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
And User validates Provider Name, Accrued Fees, Past Due Fees and Invoice Period Grid
And User clicks on UPA logout

 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		AO			|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Standard     	  |		AO			|  
 |      PROV_Admin |   PROV     	|		PremiumOrStandardFeeInvoice		|		Premium     	  |		VO			|  

 
 #Author: Mohammad Khalid
@UPA_OPS_US3222937_BSAdmin
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
 

        @UPAUS3232882
		Scenario Outline: - Optum Pay Solutions - Provider VO tin tiles(content+tiles+hover)
    Given User navigates to UPA portal and enters "<credential>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And   User clicks on Optum Pay Solutions tab
		Then User validates contents of Past due fee of Fee tiles for this page
		And User clicks on UPA logout

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
   And User clicks on UPA logout
     Examples:
   	  |    credential     |   userType  | 			searchCriteria				|		portalAccess	| tinType		|
      |   BS_Admin    |     BS     	|		 	zeroPastdueFee		|			Premium			|		AO			| 
      |   BS_Admin    |     BS     	|		 	positivePastdueFee		|			Premium			|		AO			| 

      
      
#Author: Mohammad Khalid
@UPA_OPS_US3106783
Scenario Outline: To test page text messaging on OPS for Prov Admin

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And User clicks on Optum Pay Solutions tab
Then User validates info icon hover message for Plan Type, Rate, Fees and Manage My Plan tile 

 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|  
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Premium  	  |		AO			|  
 
 
 #Author: Mohammad Khaid
 @UPA_OPS_US3259226
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
       
