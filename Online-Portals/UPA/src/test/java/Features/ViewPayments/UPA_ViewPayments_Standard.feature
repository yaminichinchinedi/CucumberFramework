#Author: Rahul Krishna
@UPA_ViewPayments_Standard
Feature: UPA View Payments Functionality for Standard TIN
      @UPAUS2800914 @OctRelease @UPA_ViewPaymentStable @UPA_ViewPaymentStandard
  Scenario Outline: View Payments Standard TIN selection and validation       
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
    Then Validate default value of Quick Search filter displays Last thirty days option and it is greyed out for "<portalAccess>".
    Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate Save button is not displayed for "<portalAccess>".
   	Then Validate Claim Count,ePRA,pPRA and Payment status fields appear with a gray box with value 'N/A'and 835field as enabled.
   	Then Validate selecting different standard TIN page gets refreshed and will display limited UI View
		Examples:     
       
             |       credentials       |		portalAccess    	|   userType    |    searchCriteria | tinType		|
             |       PROV_Admin        | 			 Standard  			|			PROV			|Last 30 days		|  	AO			|
             |      	 PROV_Gen        | 			 Standard  			|			PROV			|Last 30 days		|  	AO			|
#Author: AMIT
@UPA_US3069347_1 @UPA_ViewPaymentStable @UPA_ViewPaymentStandard
Scenario Outline: View Payments Pop up for Standard TIN        
   	Given User navigates to UPA portal and enters "<credentials>" and login
   	And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User clicks on Get started button.
    Then User verifies bring more power to you pop up and click on I accept button.
    Then User verifies the entry in product selection table with portal record status as PS.
    Examples:     
             |       credentials       |		portalAccess    	|   userType    |    searchCriteria | tinType		|
             |       PROV_Admin        | 			 Standard  			|			PROV			|	Last 30 days	|  	AO			|
  
  
  #Author: AMIT
  @UPA_US3069347_2 @UPA_ViewPaymentStable @UPA_ViewPaymentStandard
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   userType    |  searchCriteria | tinType		|
             |       PROV_Gen        | 			 Standard  			|			PROV			|		Last 30 days	|  	AO			|
             
             
             #Author: AMIT 
  @UPA_US3069347_BS @UPA_ViewPaymentStable @UPA_ViewPaymentStandard
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   userType    |  searchCriteria    | tinType		|
             |       BS_Admin        | 			 Standard  			|			BS  			|		Last 30 days	   |  	AO			|
             
             
             #Author: AMIT
  @UPA_US3069347 @UPA_ViewPaymentStable @UPA_ViewPaymentStandard
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   userType    |   searchCriteria    | tinType		|
             |    	   BS_Gen        | 			 Standard  			|			BS  			|			Last 30 days		|  	AO			|
	     
	     #Author: Amit
		@UPAViewPayments_US2973009_S @NovRelease @UPA_ViewPaymentStable
		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Click on Payment number and go to Remittance Detail screen.
		Then Click on Claim number on Remittance Detail screen and go to Claim Detail screen.
		Then Click on Payment number on Claim detail screen and go to single Payment View Payment screen.
		Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
		Then Validate the data between Single Payment Summary page and poped up Print payment Summary page
		 Examples:
      |    credentials  |  userType 	|		searchCriteria |	portalAccess	| tinType	|	
      |   PROV_Admin	  | 		PROV		|		Last 30 days 	 |		 Standard		|		AV		|	
      |   	PROV_Gen	  | 		PROV		|		Last 30 days 	 |		 Standard		|		AV		|
	     
	 @UPAUS2955416
   Scenario Outline: Access Payments - View Payments - Header Page Text
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then Click on View Payments Link for UPA 
    And User verifies different  messages based on "<credentials>", "<Trial Status>" and "<Paid option>"
     
     Examples:
       	 		 |    credentials          |	 	      userType    | 	portalAccess    |			searchCriteria 			    | tinType		|
             |       PROV_Admin        | 			 PROV			    	|			Standard			|  WithinTrial and NotPaid    |	  AO			|
             |      	PROV_Gen         | 			 PROV  			    |			Standard 			|  WithinTrial and NotPaid		|   AO			|
             |       PROV_Admin        | 			 PROV			    	|			Standard	  	|  PostTrial and NotPaid 		  |	  AO			|
             |       PROV_Gen          | 			 PROV			    	|			Standard	  	|  PostTrial and NotPaid 		  |	  AO			|
              
   @UPAUS2999491
 		Scenario Outline: Access Payments - View Payments - Provider Premium
 		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
		Then Click on Payment number and go to Remittance Detail screen.
		Then User verifies Print Request and Print Available button is disabled
		
    Examples:
             |       credentials     |		portalAccess    	|   userType    |   searchCriteria    | tinType		|
             |    	   BS_Admin        | 			 Standard  		|			BS  		  |			Last 30 days		|  	AO			| 
             |    	   BS_Gen        | 			 Standard  			|			BS  			|			Last 30 days		|  	AO			| 

#Sunanda  
@UPAViewPaymentsStandardBS  @Joy
  Scenario Outline: BS user View Payments functionality for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA 
    Then User Enters tin and click on search button for "<userType>".  	
    Then Validate default value of Quick Search filter displays Last thirty days option and it is greyed out for "<portalAccess>".
    Then Validate Active/Archived Payments filter for "<userType>" is relabeled to Payment Status and has default value as New and dropdown have other status options for "<portalAccess>".
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate Save button is not displayed for "<portalAccess>".
   	Then Validate Claim Count,ePRA,pPRA and Payment status fields appear with a gray box with value 'N/A'and 835field as enabled.
   	And User clicks on UPA logout		
Examples:		
             |       credentials     |		portalAccess    	|   userType    |   searchCriteria    | tinType		|
             |    	   BS_Admin      | 			 Standard  		  |			BS  		  |			Last 30 days		|  	AO			| 
             |    	   BS_Gen        | 			 Standard  			|			BS  			|			Last 30 days		|  	AO			|


		#Author: Marsha
		@UPAViewPaymentsFeeAmtCol_Prov_std   @US3106945
		Scenario Outline: View Payments - Fee Amount Column for Standard TIN for Prov
		Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then Validate Fee Amount column is not displayed.
		Then Click on print Payment Summary button.
		Then Validate Fee Amount column is not displayed.
			Examples:
	 					 |    credentials        |	 	 userType  			  	| 	portalAccess      |	searchCriteria   | tinType		|
             |       PROV_Admin      | 			 PROV			    	  |			Standard		  	|  Last 30 days    |   AO	 			|
             |       PROV_Gen        | 			 PROV		    			|			Standard		  	|  Last 30 days    | 	 AO	  	  |
             
		#Author: Marsha		
		@UPAViewPaymentsFeeAmtCol_BS_std   @US3106945
 		Scenario Outline: View Payments - Fee Amount Column for Standard TIN for BS
    Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
		Then Validate Fee Amount column is not displayed.
		Then Click on print Payment Summary button.
		Then Validate Fee Amount column is not displayed.
     Examples:
    				 |    credentials        |	 	 userType  			  | 	portalAccess      |	searchCriteria   | tinType		|
             |       BS_Admin        | 			 BS			    	  |			Standard		  	|  Last 30 days    |   AO	 			|
             |       BS_Gen          | 			 BS		    			|			Standard		  	|  Last 30 days    | 	 AO	  	  |
             
             
     @US3438484 	 
	Scenario Outline: View payments page Text Validation for BS Users
		Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
		Then Validate View Payments page Text for "<credentials>" for "<portalAccess>"
		Examples:
			| credentials | userType | portalAccess | tinType | 		searchCriteria 			|
			| BS_Admin    | BS       | Standard     | AO      | PostTrial and NotPaid   |
			| BS_Gen      | BS       | Standard     | AO      | PostTrial and NotPaid   |
			| BS_Admin    | BS       | Standard     | AO      | WithinTrial and NotPaid   |       
			| BS_Gen      | BS       | Standard     | AO      | WithinTrial and NotPaid   |    
			 
			 @US3438484_12  
   Scenario Outline: View Payments - Clicking on geryed out area
   Given User navigates to UPA portal and enters "<credentials>" and login
		And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
		Then User Enters tin and click on search button for "<userType>".
		Then User clicks on greyed out area and verify popup text for "<credentials>" for "<portalAccess>"   
		
		 Examples:
    				 |    credentials        |	 	 userType  			  | 	portalAccess      |	searchCriteria   | tinType		|
             |       BS_Admin        | 			 BS			    	  |			Standard		  	|  Last 30 days    |   AO	 			|
             |       BS_Gen          | 			 BS		    			|			Standard		  	|  Last 30 days    | 	 AO	  	  |      