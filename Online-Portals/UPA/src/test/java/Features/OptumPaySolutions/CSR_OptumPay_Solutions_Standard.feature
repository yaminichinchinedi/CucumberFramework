#Author: Rahul Krishna
@CSROptumPayStandard @CSROptumPaySolutions @CSRRegression
Feature: Optum Pay Solutions Scenarios for Standard Tins
   
  #Author: Marsha
  @CSROptumPaySolutionsInvalidTINError @US2948675OPScsr @CSRStable
  Scenario Outline: CSR Optum Pay Solutions check error msg display during invalid Tins
      Given User navigates to CSR portal and enters "<credentials>" and login
  		Then User clicks on Optum Pay Solutions link on CSR HomePage
  		And User Validates Error Message upon Entering "<InvalidTIN>" on Optum Pay Solution
  		
 Examples:
 		| credentials			 | InvalidTIN		|
		|   Super     	   | 121234345		|		
	  |   Super      	   | 12123434 		|		
	  |   Super      	   | 121abc345		|	
	  |   Super  	       | %$)abc$%^		|					  	
	  |   Super      	   | 							|		
	  |   RO     	       | 121234345		|		
	  |   RO         	   | 12123434 		|		
	  |   RO         	   | 121abc345		|	
	  |   RO     	       | %$)abc$%^		|					  	
	  |   RO         	   | 							|		
	  |   RW     	       | 121234345		|		
	  |   RW         	   | 12123434 		|		
	  |   RW         	   | 121abc345		|	
	  |   RW     	       | %$)abc$%^		|					  	
	  |   RW         	   | 							|		
	  
	@CSRUS3138933_12 @CSRStable
    Scenario Outline: Optum Pay Solutions Validate Change Rate PopUp
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User then validates the Change Rate popup based "<credentials>"
     Examples:


         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Standard	 | PROV   |PostTrial and NotPaid|
        |    RW   		       |	AO			|  Standard	 |PROV    |PostTrial and NotPaid|
         |    RO	           |	AO			|  Standard	 |PROV    |PostTrial and NotPaid|     
		 
   
#Author: Amit
@CSRUS3221650_S @CSRStable
    Scenario Outline: Optum Pay Solutions Validate Change Rate PopUp
		Given User navigates to CSR portal and enters "<credentials>" and login
		And   User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<prdctRecSts>" for Portal Experience.
		Then User clicks on Optum Pay Solutions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User verifies if Invoices tab is available for "<searchCriteria>" and "<portalAccess>" and "<tinType>" and "<prdctRecSts>".
 
    Examples: 
      | credentials | userType  | searchCriteria     | portalAccess | tinType | prdctRecSts |
      | Super       | PROV      | TinWithInvoices    | Standard     | AO      | PD          |
      | Super       | PROV      | TinWithoutInvoices | Standard     | AV      | PD          |
      
#Author: Sai
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
	         |    Super       |	wthAccuredFee	   |  AO 	 |	Standard	 |	PROV	|
	         |    RW	        |	wthAccuredFee	   |  AO 	 |  Standard	 |	PROV	| 
	         |    RO   		    |	wthAccuredFee	   |  AO 	 |	Standard	 |	PROV	|      