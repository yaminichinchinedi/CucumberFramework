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
         
         
    @CSRUS3136627sss
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

   
   #Author: Sayonee
    @CSRUS3136567
    Scenario Outline: Optum Pay Solutions Plan Type Tile Content for Premium Tins
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User enters "<tinTyp>" TIN with "<portalAccess>" and click on Search button
		Then User validates contents of Plan Type tile of this page 
     Examples:

         |   credentials     |  tinTyp  |portalAccess|
         |    Super          |	AO			|  Premium	 |
         |    RW   		       |	AO			|  Premium	 |
         |    RO	           |	AO			|  Premium	 |       
         
    @CSRUS3138920
    Scenario Outline: Optum Pay Solutions Plan Type Tile Content for Premium Tins
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User enters "<tinTyp>" TIN with "<portalAccess>" and click on Search button
		Then User then validates the Change Rate popup based "<credentials>"
     Examples:

         |   credentials     |  tinTyp  |portalAccess|
         |    Super          |	AO			|  Premium	 |
         |    RW   		       |	AO			|  Premium	 |
         |    RO	           |	AO			|  Premium	 |
   
    @CSRUS3157067
    Scenario Outline: Optum Pay Solutions Plan Type Tile Content for Premium Tins
		Given User navigates to CSR portal and enters "<credentials>" and login
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User enters "<tinTyp>" TIN with "<portalAccess>" and click on Search button
		Then User validates the hover on info icon on the tiles 
     Examples:

         |   credentials     |  tinTyp  |portalAccess|
         |    Super          |	AO			|  Premium	 |
         |    RW   		       |	AO			|  Premium	 |
         |    RO	           |	AO			|  Premium	 |            
         
         
                      
