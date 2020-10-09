#Author: Rahul Krishna
@UPAViewPayments_Standard
Feature: UPA View Payments Functionality for Premium TIN
      @UPAUS2800914_R
  Scenario Outline: TS_001,010,012--View Payments Standard TIN selection and validation       
    Given User navigates to UPA portal and enters "<credentials>" and login
    When  User Selects a tin on HomePage for "<searchRemitorPymntTIN>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When Click on View Payments Link for UPA 

    Then Validate default value of Quick Search filter displays Last thirty days option and it is greyed out.
    Then Validate Active/Archived Payments filter is relabeled to Payment Status,default value as New and greyed out.
    Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
    Then Validate Archive/Save changes button is not there 
   	Then Validate Claim Count,ePRA,pPRA and Payment status fields appear with a gray box with value 'N/A'and 835field as enabled.
   	Then Validate selecting different standard TIN page gets refreshed and will display limited UI View
   	
Examples:     
       
             |       credentials       |		portalAccess    	|   usertype    |    searchRemitorPymntTIN    | tinType		|
             |       PROV_Admin        | 			 Standard  			|			PROV			|TinWthatlstOnePayNum					|  	AO			|


      