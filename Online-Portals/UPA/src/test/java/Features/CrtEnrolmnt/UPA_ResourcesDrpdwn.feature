#Marsha Vegda
@ResourceTabDropDownUPA
Feature: UPA Resource Dropdown
  
  @ResourceTabDropDownUPA1 @US2999285resourcesUPA
  Scenario Outline: Resource Tab dropdown Post Login
		Given User navigates to UPA portal and enters "<userType>" and login
    When User hovers on the Resources DropDown
    Then User clicks on Faqs link and verifies the FAQ page
    When User hovers on the Resources DropDown
    Then User clicks on Terms and Conditions
    Examples:
      |      userType       |   
      |      PROV_Admin     |   
      |      PROV_Gen       |   
      |      BS_Admin       |  
      |      BS_Gen         | 
      |      PAY_Admin     	| 
      |      PAY_Gen     	  |  
      
#Author :Sayonee
 @UPAUS3221207
  Scenario Outline: Resource Tab dropdown Post Login
		Given User navigates to UPA portal and enters "<userType>" and login
    When User hovers on the Resources DropDown
    Then User clicks on Capitation Reports and verifies the link that opens
    Examples:
      |      userType       |   
      |      PROV_Admin     |   
      |      PROV_Gen       |   
      |      BS_Admin       |  
      |      BS_Gen         | 
      |      PAY_Admin     	| 
      |      PAY_Gen     	  |  