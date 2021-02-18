#Author: Marsha
@UPAResourceTabDropDownUPA
Feature: UPA Resource Dropdown
  
  @UPAResourceTabDropDownUPA1 @US2999285 @US3221194 @US3221199
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
    
    Examples:
      |      userType       |   
      |      PROV_Admin     |   
      |      PROV_Gen       |   
      |      BS_Admin       |  
      |      BS_Gen         | 
      |      PAY_Admin     	| 
      |      PAY_Gen     	  |  

 #Author:Sayonee   
    @UPAUS3221207 @US3221207
  Scenario Outline:Add Capitation Reports Link in Resource Tab dropdown Post Login
		Given User navigates to UPA portal and enters "<userType>" and login
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


