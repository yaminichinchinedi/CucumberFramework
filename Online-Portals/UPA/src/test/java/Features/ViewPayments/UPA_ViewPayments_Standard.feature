#Author: Rahul Krishna
@UPAViewPayments_Standard
Feature: UPA View Payments Functionality for Premium TIN
      @UPAUS2800914 @OctRelease @ViewPaymentStable
  Scenario Outline: TS_001,010,012--View Payments Standard TIN selection and validation       
    Given User navigates to UPA portal and enters "<credentials>" and login
    When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA 
    Then Validate default value of Quick Search filter displays Last thirty days option and it is greyed out for "<portalAccess>".
    Then Validate Active/Archived Payments filter is relabeled to Payment Status,default value as New and greyed out for "<portalAccess>".
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate Save button is not displayed for "<portalAccess>".
   	Then Validate Claim Count,ePRA,pPRA and Payment status fields appear with a gray box with value 'N/A'and 835field as enabled.
   	Then Validate selecting different standard TIN page gets refreshed and will display limited UI View
   	
Examples:     
       
             |       credentials       |		portalAccess    	|   usertype    |    searchRemitorPymntTIN    | tinType		|
             |       PROV_Admin        | 			 Standard  			|			PROV			|TinWthatlstOnePayNum					|  	AO			|
             |      	 PROV_Gen        | 			 Standard  			|			PROV			|TinWthatlstOnePayNum					|  	AO			|



#Author: AMIT
@US3069347 @ViewPaymentStable
Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
    When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA 
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User clicks on Get started button.
    Then User verifies bring more power to you pop up and click on I accept button.
    Then User verifies the entry in product selection table with portal record status as PS.
    Examples:     
             |       credentials       |		portalAccess    	|   usertype    |    searchRemitorPymntTIN    | tinType		|
             |       PROV_Admin        | 			 Standard  			|			PROV			|TinWthatlstOnePayNum					|  	AO			|
  
  
  #Author: AMIT
  @US3069347 @ViewPaymentStable
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
    When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA 
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   usertype    |    searchRemitorPymntTIN    | tinType		|
             |       PROV_Gen        | 			 Standard  			|			PROV			|TinWthatlstOnePayNum					|  	AO			|
             
             
             #Author: AMIT
  @US3069347 @ViewPaymentStable
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
    When Click on View Payments Link for UPA
    Then User enters tin for BS View Payments UPA for "<searchRemitorPymntTIN>" and "<usertype>" search criteria for "<tinType>" for "<portalAccess>" for Portal Experience. 
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   usertype    |    searchRemitorPymntTIN    | tinType		|
             |       BS_Admin        | 			 Standard  			|			BS  			|TinWthatlstOnePayNum					|  	AO			|
             
             
             #Author: AMIT
  @US3069347 @ViewPaymentStable
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
    When Click on View Payments Link for UPA 
    Then User enters tin for BS View Payments UPA for "<searchRemitorPymntTIN>" and "<usertype>" search criteria for "<tinType>" for "<portalAccess>" for Portal Experience. 
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   usertype    |    searchRemitorPymntTIN    | tinType		|
             |    	   BS_Gen        | 			 Standard  			|			BS  			|TinWthatlstOnePayNum					|  	AO			|
	     
	     
	     
	 @UPAUS2955416
     	Scenario Outline: Access Payments - View Payments - Header Page Text
     Given User navigates to UPA portal and enters "<credentials>" and login
    When  User Selects  tin on HomePage for "<userType>" with "<Trial Status>","<Paid option>", "<tinType>" for "<portalAccess>" for Portal Experience
    Then Click on View Payments Link for UPA 
    And User verifies different  messages based on "<credentials>", "<Trial Status>" and "<Paid option>"
     
     Examples:
        	 |    credentials          |	 	      userType    | 	portalAccess    |	Trial Status   |Paid option   | tinType		|
             |       PROV_Admin        | 			 PROV			    	|			Standard			|  WithinTrial   |  NotPaid    |	  AO			|
             |      	PROV_Gen         | 			 PROV  			    |			Standard 			|  WithinTrial	 |   NotPaid		|   AO			|
             |       PROV_Admin        | 			 PROV			    	|			Standard	  	|  PostTrial     |   NotPaid 		  |	  AO			|
             |       PROV_Gen          | 			 PROV			    	|			Standard	  	|  PostTrial     |   NotPaid 		  |	  AO			|
              
  