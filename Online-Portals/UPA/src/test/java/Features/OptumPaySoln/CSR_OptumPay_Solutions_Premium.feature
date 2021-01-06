#Author: Rahul Krishna

    @CSRUS3136637
    Feature: Optum Pay Solutions Scenarios for Premium Tins
    
    Scenario Outline: Optum Pay Soution New Layout Scenario
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User enters "<tinTyp>" TIN with "<portalAccess>" and click on Search button 
		Then User validates Tiles of this page in order
    		Examples:

         |   credentials     |  tinTyp  |portalAccess|
         |    Super          |	AO			|  Premium	 |
         |    RW   		       |	AO			|  Premium	 |
         |    RO	           |	AO			|  Premium	 |
         
         
    @CSRUS3136627
    
    Scenario Outline: Optum Pay Soution Accured Fees scenario 
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User enters TIN of "<accuredFeeStatus>" and click on Search button 
		Then User validates contents of Fee tiles of this page
    		Examples:

         |   credentials     |  accuredFeeStatus    |
         |    Super          |		withAccuredFee	  |     
         |    RW	           |		withAccuredFee  	|    
         |    RO   		       |		withAccuredFee  	|
         |    Super          |		withoutAccuredFee	|
         |    RW	           |		withoutAccuredFee	|
         |    RO   		       |		withoutAccuredFee	|
             