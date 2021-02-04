#Author: Rahul Krishna
@UPAViewPayments_Standard
Feature: UPA View Payments Functionality for Premium TIN
      @UPAUS2800914 @OctRelease @UPA_ViewPaymentStable
  Scenario Outline: TS_001,010,012--View Payments Standard TIN selection and validation       
    Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
    Then Validate default value of Quick Search filter displays Last thirty days option and it is greyed out for "<portalAccess>".
    Then Validate Active/Archived Payments filter is relabeled to Payment Status,default value as New and greyed out for "<portalAccess>".
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate Save button is not displayed for "<portalAccess>".
   	Then Validate Claim Count,ePRA,pPRA and Payment status fields appear with a gray box with value 'N/A'and 835field as enabled.
   	Then Validate selecting different standard TIN page gets refreshed and will display limited UI View
   	
Examples:     
       
             |       credentials       |		portalAccess    	|   userType    |    searchCriteria | tinType		|
             |       PROV_Admin        | 			 Standard  			|			PROV			|Last 30 days		|  	AO			|
             |      	 PROV_Gen        | 			 Standard  			|			PROV			|Last 30 days		|  	AO			|



#Author: AMIT
@UPA_US3069347_1 @UPA_ViewPaymentStable
Scenario Outline: View Payments Pop up for Standard TIN        
   	Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
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
  @UPA_US3069347_2 @UPA_ViewPaymentStable
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		When Click on View Payments Link for UPA
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   userType    |  searchCriteria | tinType		|
             |       PROV_Gen        | 			 Standard  			|			PROV			|		Last 30 days	|  	AO			|
             
             
             #Author: AMIT
  @UPA_US3069347_BS @UPA_ViewPaymentStable
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
		When Click on View Payments Link for UPA
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience. 
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   userType    |  searchCriteria    | tinType		|
             |       BS_Admin        | 			 Standard  			|			BS  			|		Last 30 days	   |  	AO			|
             
             
             #Author: AMIT
  @UPA_US3069347 @UPA_ViewPaymentStable
  Scenario Outline: View Payments Pop up for Standard TIN        
    Given User navigates to UPA portal and enters "<credentials>" and login
		When Click on View Payments Link for UPA
		And   User Enters tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience. 
    Then User clicks on claim count grayed out column.
    Then User verifies the pop up for user type having access as "<credentials>".
    Then User click on cross to close the pop up.
   
    Examples:     
             |       credentials     |		portalAccess    	|   userType    |   searchCriteria    | tinType		|
             |    	   BS_Gen        | 			 Standard  			|			BS  			|			Last 30 days		|  	AO			|
  