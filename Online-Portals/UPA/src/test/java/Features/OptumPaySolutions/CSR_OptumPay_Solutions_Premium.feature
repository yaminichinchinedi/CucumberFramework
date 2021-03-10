#Author: Rahul Krishna
@CSROptumPaySolutions    
    Feature: Optum Pay Solutions Scenarios for Premium Tins
    @CSRUS3136637
    Scenario Outline: Optum Pay Soution New Layout Scenario
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates Tiles of this page in order
    		Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid|   
         
    @CSRUS3136627sss
    Scenario Outline: Optum Pay Soution Accured Fees scenario 
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates contents of Fee tiles of this page
    		Examples:

         |   credentials     |  searchCriteria	    |tinType|portalAccess|userType|
         |    Super          |		withAccuredFee	  |  AO 	|	Premium		 |	PROV	|  
         |    RW	           |		withAccuredFee  	|  AO 	|	Premium		 |	PROV	|   
         |    RO   		       |		withAccuredFee  	| AO 	  |	Premium		 |	PROV	|
         |    Super          |		withoutAccuredFee	| AO 	  |	Premium		 |	PROV	|
         |    RW	           |		withoutAccuredFee	| AO 	  |	Premium		 |	PROV	|
         |    RO   		       |		withoutAccuredFee	| AO 	  |	Premium		 |	PROV	|
 
   #Author: Sayonee
    @CSRUS3136567
    Scenario Outline: Optum Pay Solutions Plan Type Tile Content for Premium Tins
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates contents of Plan Type tile of this page 
     Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid|      
         
    @CSRUS3138920 @CSRUS3138933
    Scenario Outline: Optum Pay Solutions Validate Change Rate PopUp
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User then validates the Change Rate popup based "<credentials>"
     Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid|      
    @CSRUS3157067
    Scenario Outline: Optum Pay Solutions Info Icon Hover 
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates the hover on info icon on the tiles 
     Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid| 
     
   #Author: Aravind Lakshminarasimhan   
    @CSRUS3290593 @CSRRegression
    Scenario Outline: Optum Pay Solutions Rate Tile CSR
    Given User navigates to CSR portal and enters "<credentials>" and login
    And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<selectedOrDefault>" for Portal Experience.
    When  User clicks on Optum Pay Solutions link on CSR HomePage   
    Then  User Enters tin for OPS and click on search button for "<userType>".
    And   Change control to Optum Pay Solutions page
    Then  User validates the Text, Dates, Rates on the Rate Tile section for given "<tinType>" and "<portalAccess>"
          Examples:

         |   credentials     | userType | searchCriteria                        | tinType | portalAccess   | selectedOrDefault |
         |    Super          |  PROV    | TinWithNoCustomFeeRate                |   AO    | Premium        |       PS          | 
         |    Super          |  PROV    | TinWithNoCustomFeeRate                |   AO    | Standard       |       PD          |
         |    Super          |  PROV    | TinWithNoCustomFeeRate                |   AO    | Standard       |       PS          |
         |    Super          |  PROV    | TinWithNoCustomFeeRate                |   VO    | Premium        |       PD          |
         |    Super          |  PROV    | LegacyOrPremiOrStandard               |   AO    | Standard       |       PS          |

   #Scenario 1 - Premium TIN in trial period, and premium Post Trial as well
   #Scenario 2 - Premium TIN in trial period, and standard by default after trial period
   #Scenario 3 - Premium TIN in trial period, and standard Post Trial as well (User has accepted the premium and then cancelled it during Trial period)
   #Scenario 4 - Premium Tin in trial period, VO Tin
   #Scenario 5 - Standard AO Tin           
         
    @CSRUS3138933
    Scenario Outline: Optum Pay Solutions Plan Type Tile Content for Premium Tins
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User then validates the Change Rate scenarios based on "<credentials>","<changeRateValue>","<changeRateReason>"
     Examples:

         |   credentials     |  tinType  |portalAccess| userType |searchCriteria    |		changeRateValue	   |changeRateReason|
         |    Super          |	AO			|  Premium	 |	PROV    |PostTrial and Paid|	 	valid value	       |			Other			|
         |    Super          |	AO			|  Premium	 |	PROV    |PostTrial and Paid| 	 	Invalid value      |	UHC requested	|
     
                      
 @CSRUS3232897
    Scenario Outline: Optum Pay Soution Accured Fees scenario 
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
			Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates contents of Past due fee of Fee tiles for this page
    		Examples:

         |   credentials     |  searchCriteria	      |tinType|portalAccess|userType|
         |    Super          |		zeroPastdueFee	    |  AO 	|	Premium		 |	PROV	|  
         |    Super          |		positivePastdueFee	| AO 	  |	Premium		 |	PROV	|
  
         
#Author:Amit    
@CSRUS3221650_P    
    Scenario Outline: Optum Pay Soution Accured Fees scenario 
		Given User navigates to CSR portal and enters "<credentials>" and login
		And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<prdctRecSts>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User verifies if Invoices tab is available for "<searchCriteria>" and "<portalAccess>" and "<tinType>" and "<prdctRecSts>".

    Examples: 
      | credentials | userType | searchCriteria     | portalAccess | tinType | prdctRecSts |
      | Super       | PROV      | TinWithInvoices    | Premium      | AO      | PS          |
      | Super       | PROV      | TinWithoutInvoices | Premium      | AV      | PS          |
      | Super       | PROV      | TinWithInvoices    | Premium      | VO      | PD          |
      | Super       | PROV      | TinWithoutInvoices | Premium      | VO      | PD          |
         
         
   @US3238498
      Scenario Outline: Optum Pay Soution  Display Fee Search
        Given User navigates to CSR portal and enters "<credentials>" and login
        And User fetch tin on CSR for "<userType>" for "<Fee Search Criteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  		Then User clicks on Optum Pay Solutions link on CSR HomePage
        Then User Enters tin for OPS and click on search button for "<userType>".
        Then User clicks on Fee Searh Tab on Optum Pay Solutions Page
        Then User enters "<Fee Search Criteria>" on Fee Search page and click on search button.
        Then User verifies the headers on Fee Search page
        Then User verifies show fees i can refund on Fee Search page for "<credentials>"
        Then User verifies Fee Search results for "<Fee Search Criteria>"


  Examples:

          |   credentials     |   Fee Search Criteria   |tinType|portalAccess    |userType|
          |    Super          |	feeSearchPaymentNumber	|  AO 	|	Premium		 |	PROV	|
          |    Super          |	feeSearchInvoiceNumber	|  AO 	|	Premium		 |	PROV	|      
         
         
         
         
       