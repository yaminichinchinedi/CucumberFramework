#Author: Marsha(Stabilisation)
@UPAhomePage @UPARegression
Feature:  UPA Home Page Functionality - Post Login 
	#Author: Sunanda
  @UPABringMorePage_1 @homePage_func
  Scenario Outline: Bring More Power Page Functionality for user associated only with ACH TINs
    Given Is to verify if atleast one standard "<portalAccess>" TIN with "<tinType>" is associated with "<userType>" and has "<trialStatus>" with "<SelectedOrDefault>" and "<statusOfStandardRecd>"
   	And User navigates to UPA portal and enters "<userType>" and login when the Terms and Conditions are not accepted
    Then User verifies the presence of Bring More Power pop-up and clicks No Thanks
    And User clicks on UPA logout
    And User navigates to UPA portal and enters "<userType>" and login
    Then User verifies the presence of Bring More Power pop-up and clicks I Accept
    And User verifies the insertion of pending PS record and inactivation of PD record in the product selection table for all the associated standard tins
    And User verifies if TC_ACCPT_IND is flipped to Y
    And   User clicks on UPA logout
    And User navigates to UPA portal and enters "<userType>" and login
    Then User verifies if homepage is presented when TC_ACCPT_IND is Y
    And   User clicks on UPA logout
    And User navigates to UPA portal and enters "<userType>" and login when the Terms and Conditions are not accepted
    Then The Terms and Conditions page is displayed
	  Then User Accept the Terms and Conditions and Submit
   Examples:
      |        userType        |   accessType   |		portalAccess	  | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
      | PROV_Admin_HomePage_AO |   PROV     		|		Standard			  |		AO			|     A     |					P					 |				PD			 |
      
  #Author : Vinay Raghumanda
  @UPA_US3179215 @homePage_func 
  Scenario Outline: BS and Payer admins Home Page Carousel Text Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    Then Verify Home Page Carousel Text for "<userType>" with "<credentials>"
    And User clicks on UPA logout
    Examples:
      | credentials | userType  |
      | BS_Admin    |   BS      |
	  |   BS_Gen    |   BS     	|
      | PAY_Admin   | PAY_Admin |

  @UPA_US3179215_prov @homePage_func
  Scenario Outline: Provider Home page Carousel Text Validation
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then Verify Home Page Carousel Text for "<userType>" with "<credentials>"
    And User clicks on UPA logout
    Examples:
      | credentials | userType | searchCriteria       | tinType | portalAccess |
      | PROV_Admin  | PROV     | PremiumOrStandardTIN | AO      | Premium      |
      | PROV_Admin  | PROV     | PremiumOrStandardTIN | AO      | Standard     |
      | PROV_Gen    | PROV     | PremiumOrStandardTIN | AO      | Premium      |
      | PROV_Gen    | PROV     | PremiumOrStandardTIN | AO      | Standard     |
      | PROV_Admin  | PROV     | PostTrial and Paid   | VO      | Premium      |
      | PROV_Admin  | PROV     | WithinTrial and Paid | AO      | Premium      |
      | PROV_Admin  | PROV     | positivePastdueFee   | AO      | Premium      |
      | PROV_Gen    | PROV     | positivePastdueFee   | AO      | Premium      |
  
  #Author: Marsha        
	@UPAUS2948683TnC_1 @homePage_func
	Scenario Outline: T&C Re-acceptance - All-Payer Accept 
	Given User navigates to UPA portal and enters "<userType>" and login when the Terms and Conditions are not accepted
	Then The Terms and Conditions page is displayed
	Then The Terms and Conditions pdf is verified
	Then User Accept the Terms and Conditions and Submit
	
	 Examples:
	      |      userType       |   accessType|
	      |      PROV_Gen       |   PROV      |
	      |      BS_Admin       |   BS     	  |
	      |      BS_Gen         |   BS     	  |
	      |      PAY_Admin     	|   PAY       | 
	      |      PAY_Gen       	|   PAY       |      
  
  @UPAResourceTabDropDownUPA_1 @US2999285 @US3221194 @US3221199 @homePage_func @US3221207
  Scenario Outline: Resource Tab dropdown Post Login
		Given User navigates to UPA portal and enters "<userType>" and login
    When User hovers on the Resources DropDown
    Then User clicks on Faqs link and verifies the FAQ page
    When User hovers on the Resources DropDown
    Then User clicks on Terms and Conditions
    When User hovers on the Resources DropDown
    Then User clicks on Partners link and verifies the page
    When User hovers on the Resources DropDown
    Then User clicks on Document Vault and verifies the page
    When User hovers on the Resources DropDown
    Then User clicks on Capitation Report
    Examples:
      |      userType       |   
      |      PROV_Admin     |   
      |      PROV_Gen       |   
      |      BS_Admin       |  
      |      BS_Gen         | 
      |      PAY_Admin     	| 
      |      PAY_Gen     	  |  

      
   #OBSOLETE   
	 #@UPAUS2948688_1 
	 #Scenario Outline: UPA HomePage Alert 
   #Given User navigates to UPA portal and enters "<credentials>" and login
   #And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
   #And User verifies HomePage Alert depending upon "<portalAccess>" and "<tinType>"
        
		# Examples:
		#	 |		credentials  |    userType    | 			searchCriteria			|		portalAccess	  | tinType		|
		#	 |     PROV_Admin  |     PROV     	|		WithinTrial and NotPaid	|		Standard     	  |		AO			|
		#	 |     PROV_Admin  |     PROV     	|		WithinTrial and Paid	  |		Premium     	  |		AO			|
	
		#OBSOLETE
	  #@UPAPopularFAQ_1 
  	#Scenario: Popular FAQs section
		#Given User navigates to UPA Sys Test application
    #When User scrolls to popular FAQ section
    #Then Verify all Popular FAQ links are present
    #And Click on VIEW ALL FAQs button and verify all FAQs are present
    
    
  #Author: Mohammad Khalid
  @UPAUS3415252_PostLogin
   Scenario Outline: Resource Tab dropdown Post Login
    Given User navigates to UPA portal and enters "<userType>" and login
    When User hovers on the Resources DropDown
    Then User clicks on Cancellation Form and verifies the url is pdf
    Then user validates cancellation pdf form content under Post Login resources link
    
    
     Examples:
      |      userType       |   
      |      PROV_Admin     |




 #Author : Burak Ucal
  @US3775315
  Scenario Outline: Unsecured Guest Payment Page
    Given User navigates to UPA Sys Test application
    And User clicks on Pay an invoice now
    Then I validate the Title for Pay as a guest
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And User enters tin and invoice number and clicks on continue button
    And User validates provider information
    And User enters contact information


    Examples:
      |userType     |portalAccess|searchCriteria| tinType|
      |  PROV_Admin	|Premium     |UnpaidInvoice |	  AO |
      
      
      #Author : Mounika Talakanti
  @US3724733UnsecureGuestPaymentStep2
  Scenario Outline: Unsecured Guest Payment Page
    Given User navigates to UPA Sys Test application
    And User clicks on Pay an invoice now
    Then I validate the Title for Pay as a guest
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And User enters tin and invoice number and clicks on continue button
    And User validates provider information
    And User enters name and email

    Examples:
      |userType     |portalAccess|searchCriteria| tinType|
      |  PROV_Admin	|Premium     |UnpaidInvoice |	  AO |

        #Author : Felix Gozuacik
  @US3725135_Step3
  Scenario Outline: Unsecured Guest Payment Page
    Given User navigates to UPA Sys Test application
    And User clicks on Pay an invoice now
    Then I validate the Title for Pay as a guest
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And User enters tin and invoice number and clicks on continue button
    And User enters name and email
    And User enters routing and account number
    And User clicks on consent
    And User clicks on submit

    Examples:
      |userType     |portalAccess|searchCriteria| tinType|
      |  PROV_Admin	|Premium     |UnpaidInvoice |	  AO |
      
      
     @UPAUS4053595
	Scenario Outline: AC No and RTN No same
    Given User navigates to UPA Sys Test application
    And User clicks on Pay an invoice now
    Then I validate the Title for Pay as a guest
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    And User enters tin and invoice number and clicks on continue button
    And User enters name and email
    And User enters same routing number and account number and validates error "RTN No and AC no cannot be same"

    Examples:
      |userType     |portalAccess|searchCriteria| tinType|
      |  PROV_Admin	|Premium     |UnpaidInvoice |	  AO |   
      
      
      
      @UPA4157043
  Scenario Outline: Access Payments -  Premium Restrictions - Changes to account will be converted to basic popup
    Given User navigates to UPA portal and enters "<credentials>" and login
    And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    Then validates text and column TIN,Organisation,Effective date are displayed and close button is enabled.
    Examples:
      | credentials | userType | searchCriteria       | tinType     | portalAccess |
      |   PROV_Gen  | PROV     | convertedBasicTIN  					  | 		AO      | Standard     |
     