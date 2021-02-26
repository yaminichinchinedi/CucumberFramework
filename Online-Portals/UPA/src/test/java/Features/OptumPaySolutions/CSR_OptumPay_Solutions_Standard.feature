#Author: Rahul Krishna
    
Feature: Optum Pay Solutions Scenarios for Standard Tins
   
  #Author: Marsha
  @CSROptumPaySolutionsInvalidTINError @US2948675OPScsr
  Scenario Outline: CSR Optum Pay Solutions check error msg display during invalid Tins
      Given User navigates to CSR portal and enters "<credentials>" and login
  		Then User clicks on Optum Pay Soultions link on CSR HomePage
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
	  
	    
         
    @CSRUS3138933
    Scenario Outline: Optum Pay Solutions Validate Change Rate PopUp
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User then validates the Change Rate popup based "<credentials>"
     Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid|       
         