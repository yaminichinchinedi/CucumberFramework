#Author: Rahul Krishna
    
Feature: Optum Pay Solutions Scenarios for Standard Tins
   
  #Author: Marsha
  @CSROptumPaySolutionsInvalidTINError @US2948675OPScsr
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
	  
	    
   