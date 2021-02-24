#Author: Rahul Krishna
@CSROptumPaySolutions    
    Feature: Optum Pay Solutions Scenarios for Premium Tins
    @CSRUS3136637
    Scenario Outline: Optum Pay Soution New Layout Scenario
		Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates Tiles of this page in order
    		Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid|   
         
    #was not able to fix as not sure of the requirements
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
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates contents of Plan Type tile of this page 
     Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid|      
         
    @CSRUS3138920
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
    @CSRUS3157067
    Scenario Outline: Optum Pay Solutions Info Icon Hover 
				Given User navigates to CSR portal and enters "<credentials>" and login
		And User fetch tin on CSR for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
		Then User clicks on Optum Pay Soultions link on CSR HomePage
		Then User Enters tin for OPS and click on search button for "<userType>".
		Then User validates the hover on info icon on the tiles 
     Examples:

         |   credentials     |  tinType  |portalAccess|userType|searchCriteria|
         |    Super          |	AO			|  Premium	 | PROV   |PostTrial and Paid|
         |    RW   		       |	AO			|  Premium	 |PROV    |PostTrial and Paid|
         |    RO	           |	AO			|  Premium	 |PROV    |PostTrial and Paid|           
         
         
                      
