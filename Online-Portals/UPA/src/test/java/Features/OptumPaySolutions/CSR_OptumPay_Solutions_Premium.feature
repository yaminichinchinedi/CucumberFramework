#Author: Rahul Krishna
@CSROptumPaySolutions    @CSRRegression
    Feature: Optum Pay Solutions Scenarios for Premium Tins
    @CSRUS3136637 @CSRStable
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
         
    @CSRUS3136627sss @CSRStable
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
    @CSRUS3136567 @CSRStable
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
         
    @CSRUS3138920 @CSRUS3138933 @CSRStable
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
    @CSRUS3157067 @CSRStable
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
    @CSRUS3290593 @CSRRegression @CSRStable
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
         
    @CSRUS3138933 @CSRStable 
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
         
         
         @CSRUS3138933_12 @CSRStable
    Scenario Outline: Optum Pay Solutions Validate Change Rate PopUp
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User then validates the Change Rate popup based "<credentials>"
     Examples:


         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium | PROV   |PostTrial and Paid|
        |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
        |    RO	           |	AO			|  Premium |PROV    |PostTrial and Paid|     
		 
     
                      
 @CSRUS3232897 @CSRStable
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
@CSRUS3221650  @CSRUS3329695 @CSRStable @CSRUS3449949
    Scenario Outline: Optum Pay Soution Accured Fees scenario 
		Given User navigates to CSR portal and enters "<credentials>" and login
		And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<prdctRecSts>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User verifies if Invoices tab is available for "<searchCriteria>" and "<portalAccess>" and "<tinType>" and "<prdctRecSts>".

    Examples: 
      | credentials | userType  | searchCriteria     | portalAccess | tinType | prdctRecSts |
      | Super       | PROV      | TinWithInvoices    | Premium      | AO      | PS          |
      | Super       | PROV      | TinWithoutInvoices | Premium      | AV      | PS          |
     #| Super       | PROV      | TinWithInvoices    | Premium      | VO      | PD          |  #No Data for this combination
      | Super       | PROV      | TinWithoutInvoices | Premium      | VO      | PD          |
     #| Super       | PROV      | TinWithoutInvoices | Premium      | AV      | TR          |  #Data issue in the DB
         
       
         
     @CSRUS3238500 @CSRStable
      Scenario Outline: Optum Pay Soution  Display Fee Search
        Given User navigates to CSR portal and enters "<credentials>" and login
        And User fetch tin on CSR for "<userType>" for "<Fee Search Criteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  		  Then User clicks on Optum Pay Solutions link on CSR HomePage
        Then User Enters tin for OPS and click on search button for "<userType>".
        Then User clicks on Fee Searh Tab on Optum Pay Solutions Page
        Then User enters "<Fee Search Criteria>" on Fee Search page and click on search button.
        Then verify that max 30 records are on single page and pagination links enabled/disabled accordingly 
        
        


  Examples:

          |   credentials     |   Fee Search Criteria   |tinType|portalAccess    |userType|
          |    Super          |	feeSrchTINdetailsTabwthAllVal	    |  AO 	|	Premium		 |	PROV	|
          |    Super          |	NofeeSearchTIN	    |  AO 	|	Premium		 |	PROV	|
         |    RW             |	feeSrchTINdetailsTabwthAllVal	    |  AO 	|	Premium		 |	PROV	|
         |    RW             |	NofeeSearchTIN	    |  AO 	|	Premium		 |	PROV	|
          |    RO          |	feeSrchTINdetailsTabwthAllVal	    |  AO 	|	Premium		 |	PROV	|
          |    RO          |	NofeeSearchTIN	    |  AO 	|	Premium		 |	PROV	|
 
 
    @CSRUS3307485
  	Scenario Outline: - Optum Pay Solutions - Invoice pdf open in new tab 
        Given User navigates to CSR portal and enters "<credentials>" and login
        And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
  		Then User clicks on Optum Pay Solutions link on CSR HomePage
        Then User Enters tin for OPS and click on search button for "<userType>".
   	    Then User clicks on "Invoices" tab
   	    Then User clicks on Invoice Number that opens pdf in new tab
   	Examples:
    	|    credentials     |	userType | 	portalAccess  |	searchCriteria   				| tinType		|
        |       Super        | 	PROV	 |	Premium       |  PremiumOrStandardFeeInvoice 	|	  AO		|
   
 #Aravind - difficult to debug         
   @CSRUS3374873 @CSRRegression
   Scenario Outline: Optum Pay Soution  Fee Refunds UI - CSR
       Given User navigates to CSR portal and enters "<credentials>" and login
       And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
           Then  User clicks on Optum Pay Solutions link on CSR HomePage
       Then  User Enters tin for OPS and click on search button for "<userType>".
       And   Change control to Optum Pay Solutions page
       Then  User clicks on Fee Searh Tab on Optum Pay Solutions Page
       And  User enters "<Fee Search Criteria 1>" on Fee Search page and click on search button.
       Then  User enters "<Fee Search Criteria 1>" validates selectAll, Cancel, RefundFee buttons and select column functionality
       And  User enters "<Fee Search Criteria 2>" on Fee Search page and click on search button.
       Then  User enters "<Fee Search Criteria 2>" validates selectAll, Cancel, RefundFee buttons and select column functionality
       And  User enters "<Fee Search Criteria 3>" on Fee Search page and click on search button.
       Then  User enters "<Fee Search Criteria 3>" validates selectAll, Cancel, RefundFee buttons and select column functionality
          
      Examples:
          |   credentials  |   searchCriteria         |tinType | portalAccess  |userType | Fee Search Criteria 1  | Fee Search Criteria 2  | Fee Search Criteria 3        |
          |    Super       |     TinForFeeSearchRefund  |  AO      |    Premium           |    PROV     | feeSearchInvoiceNumber | feeSearchPaymentNumber |feeSrchTINdetailsTabwthAllVal |
 
  #Author: Marsha
  @CSRCancelPremiumDb @US2948675
  Scenario Outline: CSR Optum Pay Solutions cancel subscription and check DB
    Given User navigates to CSR portal and enters "<credentials>" and login
    And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<prdctRecSts>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
	  Then User Enters tin for OPS and click on search button for "<userType>".
	  Then Fill Cancel Details with Reason as "<reasonCode>" and Submit for "CSR" 
  	Then Verify that the Premium is cancelled for "<searchCriteria>" on "CSR"
		
    Examples: 
      | credentials | userType | searchCriteria     						| portalAccess | tinType | prdctRecSts |reasonCode|
     | Super       | PROV     | PostTrial and Paid 						| Premium      | AO      | PS          |	R7			|
      | Super       | PROV     |New Enroll WithinTrial and Paid | Premium      | AO      | PS          |	R7			|
      
      
       #Author: Mohammad Khalid             
@CSRUS3252558 
Scenario Outline: Optum Pay Soution  Fee Refunds UI - CSR 
	Given User navigates to CSR portal and enters "<credentials>" and login 
	And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience. 
	Then  User clicks on Optum Pay Solutions link on CSR HomePage 
	Then  User Enters tin for OPS and click on search button for "<userType>". 
	And   Change control to Optum Pay Solutions page 
	Then  User clicks on Fee Searh Tab on Optum Pay Solutions Page 
	And  User enters "<Fee Search Criteria 1>" on Fee Search page and click on search button. 
	
	And User selects fees in the grid, calculate the total fee amount and clicks on Refund Fee button 
	And User verifies Refund Pop Up UI is displayed, verifies text and clicks on Cancel button 
	And User clicks on the Select All again and clicks on Refund Fee button 
	Then User selects Refund reason and clicks on Refund button on Pop Up 
	
   
       Examples: 
		|   credentials  |   searchCriteria           |tinType | portalAccess    |userType     | Fee Search Criteria 1  | Fee Search Criteria 2  | Fee Search Criteria 3        |
		|    Super       |	 TinForFeeSearchRefund  |  AO 	 |	Premium		   |	PROV	 | feeSearchInvoiceNumber | feeSearchPaymentNumber |feeSrchTINdetailsTabwthAllVal |  
            
#Author: Sai	
		@CSRUS3485977
	 Scenario Outline: Optum Pay Soution Current Month Accured Fees scenario 
			Given User navigates to CSR portal and enters "<credentials>" and login
			And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
			Then User clicks on Optum Pay Solutions link on CSR HomePage
			Then User Enters tin for OPS and click on search button for "<userType>".
			Then User validates contents of Fee tiles of this page
	    		Examples:
	
	         |   credentials     |  searchCriteria |tinType|portalAccess |userType|
	         |    Super          |  wthAccuredFee	 |  AO 	 |	Premium	   |	PROV	|  
	         |    RW	           |  wthAccuredFee	 |  AO 	 |	Premium		 |	PROV	|   
	         |    RO   		       |	wthAccuredFee	 |  AO 	 |	Premium		 |	PROV	|
	   
	 
	 @CSRUS3485977
	 Scenario Outline: Optum Pay Soution Current Month Accured Fees scenario Invoice tab
			Given User navigates to CSR portal and enters "<credentials>" and login
			And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
			Then User clicks on Optum Pay Solutions link on CSR HomePage
			Then User Enters tin for OPS and click on search button for "<userType>".  
			Then User clicks on "Invoices" tab
			Then User validates accrued content fee on this page
				Examples:
	
	         |   credentials  | searchCriteria   |tinType|portalAccess |userType|
	         |    Super       |	wthAccuredFee	   |  AO 	 |	Premium		 |	PROV	|
	         |    RW	        |	wthAccuredFee	   |  AO 	 |  Premium		 |	PROV	| 
	         |    RO   		    |	wthAccuredFee	   |  AO 	 |	Premium		 |	PROV	|
	         |    Super       |	wthAccuredFee	   |  VO 	 |	Premium		 |	PROV	|
	         |    RW	        |	wthAccuredFee	   |  VO 	 |  Premium		 |	PROV	| 
	         |    RO   		    |	wthAccuredFee	   |  VO 	 |	Premium		 |	PROV	|
	 
@CSRUS3546055 @checkmate
  Scenario Outline: Optum Pay Soution  Access Payments Accrued fee > $0 and Request is not in Progress
	Given User navigates to CSR portal and enters "<credentials>" and login 
	And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience. 
	Then  User clicks on Optum Pay Solutions link on CSR HomePage 
	Then  User Enters tin for OPS and click on search button for "<userType>". 
	Then validate Wavie Full Fee functionality and options when clicked on it
	
Examples: 
     | credentials | userType | searchCriteria     				    | portalAccess | tinType | userType |
     | Super       | PROV     | TIN_WITH_WAVIE 						| Premium      | AO      | PROV     |
  #   | Super       | PROV     | TIN_WITH_WAVIE 						| Premium      | AV      |  PROV     |
  
  
  
  

@CSRUS3547110 @CSR2021_PI02_IP
  Scenario Outline: Optum Pay Soution  Access Payments Accrued fee > $0 and Request is not in Progress
	Given User navigates to CSR portal and enters "<credentials>" and login 
	And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	And Update the ADJ_REQ_ON Date to Current Date for "<searchCriteria>"
	Then  User clicks on Optum Pay Solutions link on CSR HomePage 
	Then  User Enters tin for OPS and click on search button for "<userType>". 
  Then validate Wavie Full Fee Button based on "<searchCriteria>" enabled or not
	
Examples: 
     | credentials | userType | searchCriteria     				    | portalAccess | tinType | userType |
     | Super       | PROV     | ZERO_DEBIT_FEE 						| Premium      | AO      | PROV     |
     | Super       | PROV     | NOTZERO_DEBIT_FEE 						| Premium      | AO      | PROV     |
  #   | Super       | PROV     | TIN_WITH_WAVIE 						| Premium      | AV      |  PROV     |
  #   | Super       | PROV     | NOTZERO_DEBIT_FEE 						| Premium      | AV      |  PROV     |
  

      #Author: Mounika Talakanti       
    @CSRUS3575899 @CSR2021_PI02_IP
    Scenario Outline: Optum Pay Soution Waive Fees scenario 
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User verifies waive fees and clicks on waive fee button
		Then User clicks cancel button
		Then User verifies waive fees and clicks on waive fee button
		Then User selects waived fee reason "<waivedFeeReason>" and click continue
		Then User confirms waived fee and proceed
		Then User verify waive fees pending
		Then User verify waive fees button disabled
	
		
    		Examples:

         |   credentials     |  searchCriteria	    |tinType|portalAccess|userType|waivedFeeReason|
         |    Super          |		withAccuredFee>0	  |  AO 	|	Premium		 |	PROV	| UHC Requested|
        
        
        
    #Author: Mounika Talakanti    
		@CSRUS3575899 @CSR2021_PI02_IP
    Scenario Outline: Optum Pay Soution Waive Fees scenario for accrued fee as 0
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User verifies accrued fees as 0.00 and check waive fee button is disabled
		
    		Examples:

         |   credentials     |  searchCriteria	    |tinType|portalAccess|userType|
         |    Super          |		withAccuredFee<=0	  |  AO 	|	Premium		 |	PROV	|
 
	 
#Author Felix Gozuacik

      @CSRUS3575260 @WaiveFeeButton @CSR2021_PI02_IP
      Scenario Outline: Waive Fee button visible for fees greater than zero

        Given User navigates to CSR portal and enters "<credentials>" and login
        And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
        Then  User clicks on Optum Pay Solutions link on CSR HomePage
        Then  User Enters tin for OPS and click on search button for "<userType>".
        And  The accrued fee is abovezero
        And  Request for waive full fee is not in the process
        Then The system shall display the following-1. Display the Waive fees button as enabled under the Fees card

        Examples:
          |   credentials  |   searchCriteria           |tinType | portalAccess    |userType     | Fee Search Criteria 1  | Fee Search Criteria 2  | Fee Search Criteria 3        |
          |    Super       |	 TinAboveZeroFee  |  AO 	 |	Premium		   |	PROV	 | feeSearchInvoiceNumber | feeSearchPaymentNumber |feeSrchTINdetailsTabwthAllVal |


          
#Author: Piyush Bagdiya

      @US3571231 @WaiveFeeButton @pbagdiyaa
      Scenario Outline: Select Option is available for Full Waive Fee operation       
      Given User navigates to CSR portal and enters "<credentials>" and login
       And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
       Then  User clicks on Optum Pay Solutions link on CSR HomePage
        Then  User Enters tin for OPS and click on search button for "<userType>".
        #And  The accrued fee is abovezero
		When  User verifies waive fees and clicks on waive fee button
		Then Verify Select Option to Waive Fees opens
		And Verify Select Option for waive fees "<Options>" dropdown
		Then User selects waived fee reason "<waivedFeeReason>" from dropdown
		And User Provides "<ReasonMessage>" in message box for "<ScenarioType>" if "<waivedFeeReason>" is other
		Then Verify Continue button is enable for "<ScenarioType>" mentioned
		Then User clicks cancel button
		Then User verifies waive fees
		#Then User verifies waive fees and clicks on waive fee button
		#Then User selects waived fee reason "<waivedFeeReason>" and click continue

      Examples:
      |ScenarioType|credentials|searchCriteria           |tinType | portalAccess    |userType     |Options|waivedFeeReason|ReasonMessage|
      |PositiveMessage|Super|	 TinAboveZeroFee  |  AO 	 |	Premium		   |	PROV	 |UHC Requested*Provider Meets Criteria for Large Volume*Other|Other|This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.QATest|
      |NegativeMessage|Super|	 TinAboveZeroFee  |  AO 	 |	Premium		   |	PROV	 |UHC Requested*Provider Meets Criteria for Large Volume*Other|Other|This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.QATestXXX|
      
      
      #Author: Piyush Bagdiya

      @US3571225 @WaiveFeeButton @pbagdiyaa @WaivePartial
      Scenario Outline: Select Option is available for Partial Waive Fee operation       
      Given User navigates to CSR portal and enters "<credentials>" and login
       And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
       Then  User clicks on Optum Pay Solutions link on CSR HomePage
        Then  User Enters tin for OPS and click on search button for "<userType>".
        #And  The accrued fee is abovezero
		When  User verifies waive fees and clicks on waive fee button
		Then Verify Select Option to Waive Fees opens
		And User Selects Waive Partail amount radio button
		Then Verify that field is displayed called Enter partial dollar amount and Verify "<ErrorMessagePartial>" as per "<ScenarioType>" data in text box
		And Verify Select Option for waive fees "<Options>" dropdown
		Then User selects waived fee reason "<waivedFeeReason>" from dropdown
		And User Provides "<ReasonMessage>" in message box for "<ScenarioType>" if "<waivedFeeReason>" is other
		Then Verify Continue button is enable for "<ScenarioType>" mentioned
		Then User clicks cancel button
		Then User verifies waive fees
		
		#Then User verifies waive fees and clicks on waive fee button
		#Then User selects waived fee reason "<waivedFeeReason>" and click continue
		#The amount exceeds the fees due.
      Examples:
      |ScenarioType|credentials|searchCriteria           |tinType | portalAccess    |userType     |Options|waivedFeeReason|ReasonMessage|ErrorMessagePartial|
      |PositiveMessage|Super|	 TinAboveZeroFee  |  AO 	 |	Premium		   |	PROV	 |UHC Requested*Provider Meets Criteria for Large Volume*Other|Other|This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.QATest|No Error|
      |NegativeValue|Super|	 TinAboveZeroFee  |  AO 	 |	Premium		   |	PROV	 |UHC Requested*Provider Meets Criteria for Large Volume*Other|Other|This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.QATestXXX|Please enter dollar amount greater than $0|
      |NegativeMessage|Super|	 TinAboveZeroFee  |  AO 	 |	Premium		   |	PROV	 |UHC Requested*Provider Meets Criteria for Large Volume*Other|Other|This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.QATestXXX|The amount exceeds the fees due.|


 #Author: Piyush Bagdiya

      @US3571225 @WaiveFeeButton @pbagdiya @WaivePartial
      Scenario Outline: Verify Full and Partial Waive fees 
		 Given User navigates to CSR portal and enters "<credentials>" and login
       	And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then  User clicks on Optum Pay Solutions link on CSR HomePage
        Then  User Enters tin for OPS and click on search button for "<userType>".
		And User verifies waive fees and clicks on waive fee button
		Then Verify Select Option to Waive Fees opens
		And Verify Waive full and partial amount
		And User clicks cancel button
		
		Examples:
		|ScenarioType|credentials|searchCriteria |tinType | portalAccess    |userType     |Options|waivedFeeReason|ReasonMessage|ErrorMessagePartial|
		|PositiveMessage|Super|	 FullPartialTin  |  AO 	 |	Premium		   |	PROV	 |UHC Requested*Provider Meets Criteria for Large Volume*Other|Other|This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.This is QA Test.QATest|No Error|
#Author Felix Gozuacik

      @US3610665  @WaiveFeeButton
      Scenario Outline: Waive Fee button visible for fees equal to zero while process payments are true

        Given User navigates to CSR portal and enters "<credentials>" and login
        And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
        Then  User clicks on Optum Pay Solutions link on CSR HomePage
        Then  User Enters tin for OPS and click on search button for "<userType>".
        And  The accrued fee is zero
        Then The system shall display the following-1. Display the Waive fees button as enabled under the Fees card

        Examples:
          | credentials | searchCriteria                        | tinType | portalAccess | userType | Fee Search Criteria 1  | Fee Search Criteria 2  | Fee Search Criteria 3         |
          | Super       | TINEqualZeroFee_ProcessFeesInProgress  |  AO 	 |	Premium		   |	PROV	 | feeSearchInvoiceNumber | feeSearchPaymentNumber |feeSrchTINdetailsTabwthAllVal |

#Author Felix Gozuacik

      @US3547123   @WaiveFeeButton
      Scenario Outline: Waive Fee button visible for fees equal to zero while process payments are true

        Given User navigates to CSR portal and enters "<credentials>" and login
        And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
        Then  User clicks on Optum Pay Solutions link on CSR HomePage
        Then  User Enters tin for OPS and click on search button for "<userType>".
        When The user clicks on the Waive fees button
        Then The system shall display and allow the user to do the following actions:Preselected Full fee, disabled partial fee, total amount displayed, dropdown options

        Examples:
          | credentials | searchCriteria                        | tinType | portalAccess | userType | Fee Search Criteria 1  | Fee Search Criteria 2  | Fee Search Criteria 3         |
          | Super       | TINEqualZeroFee_ProcessFeesInProgress  |  AO 	 |	Premium		   |	PROV	 | feeSearchInvoiceNumber | feeSearchPaymentNumber |feeSrchTINdetailsTabwthAllVal |

          
          
#Author: Sai
  @CSRUS3561600
  Scenario Outline: Access Payments - Failed Payment Invoice UI
			Given User navigates to CSR portal and enters "<credentials>" and login
      And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
      Then User clicks on Optum Pay Solutions link on CSR HomePage
      Then User Enters tin for OPS and click on search button for "<userType>".
   	  Then User clicks on "Invoices" tab
   	  Then User hover over purple dots
      
   Examples:
	
	         |   credentials  | searchCriteria   |tinType|portalAccess |userType|
	         |    Super       |	FailedInvoice	   |  AO 	 |	Premium		 |	PROV	|


    #Author: Felix

      @US3964348
      Scenario Outline: Access Payments - Failed Payment Invoice UI
        Given User navigates to CSR portal and enters "<credentials>" and login
        And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
        Then User clicks on Optum Pay Solutions link on CSR HomePage
        Then User Enters tin for OPS and click on search button for "<userType>".
        Then User validates if request and remove exemption section is displayed accordingly

        Examples:

          | credentials | searchCriteria                    | tinType | portalAccess | userType |
          | RW          | TinWithRecurrPay and No exemption | AO      | Premium      | PROV     |
          | RO          | TinWithRecurrPay and No exemption | AO      | Premium      | PROV     |
          | RW          | TinWithRecurrPay and exemption    | AO      | Premium      | PROV     |
          | RO          | TinWithRecurrPay and exemption    | AO      | Premium      | PROV     |

       #Author: Felix
      @US4098395
      Scenario Outline: Access Payments - Failed Payment Invoice UI
        Given User navigates to CSR portal and enters "<credentials>" and login
        And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
        Then User clicks on Optum Pay Solutions link on CSR HomePage
        Then User Enters tin for OPS and click on search button for "<userType>".
        Then User validates if exemption section is not displayed for basic and VO

        Examples:

          | credentials | searchCriteria       | tinType | portalAccess | userType |
          | Super       | PremiumOrStandardTIN | AO      | Standard     | PROV     |
          | RO          | PremiumOrStandardTIN | AO      | Standard     | PROV     |
          | RW          | PremiumOrStandardTIN | AO      | Standard     | PROV     |
          | Super       | PremiumOrStandardTIN | VO      | Premium      | PROV     |
          | RO          | PremiumOrStandardTIN | VO      | Premium      | PROV     |
          | RW          | PremiumOrStandardTIN | VO      | Premium      | PROV     |

	         
@CSRUS3949310
Scenario Outline: Access Payments - 8.1 - Unpaid Invoices flow - Super CSR - Ability to view the Invoice adjustments page 
      Given User navigates to CSR portal and enters "<credentials>" and login
      Then User clicks on Optum Pay Solutions link on CSR HomePage
      And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
      Then User Enters tin for OPS and click on search button for "<userType>".
      Then user validates unpaid invoices flow in Adjustment tab
      
      
      
      
      
      Examples:
	
	         |   credentials  | searchCriteria       |tinType|portalAccess |userType|
	         |    Super       |	 ValidInvoice    |  AO 	 |	Premium		 |	PROV	|

@CSRUS3895025 
Scenario Outline: Access Payments - Manage Recurring Payments - CSR 2 Reviewing Alternate bank account information
			Given User navigates to CSR portal and enters "<credentials>" and login
      And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
      Then User clicks on Optum Pay Solutions link on CSR HomePage
      Then User Enters tin for OPS and click on search button for "<userType>".
      Then User clicks on "Invoices" tab
      Then User clicks on Manage pay methods button on CSR Invoices Tab
      Then User validates the Alternate bank account information based "<credentials>"

      Examples:
	
	         |   credentials  | searchCriteria                 |tinType|portalAccess |userType|
	         |    Super       |	TinWithAlternateBankAccount	   |  AO 	 |	Premium		 |	PROV	|
	         |    RO          |	TinWithAlternateBankAccount	   |  AO 	 |	Premium		 |	PROV	|
	         |    RW          |	TinWithAlternateBankAccount	   |  AO 	 |	Premium		 |	PROV	|
