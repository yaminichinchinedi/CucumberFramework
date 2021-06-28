 @Vpay_ViewPayments_SearchRemittance
Feature: Vpay_PPRARequest

    Scenario: Validate the Vpay PPRARequest for ViewPayments and SearchRemittance
    Given Perform the GET Action for valid ClientId/CilentSecret for ViewPayments and SearchRemittance API
    Then the web service should respond with a "200" status code
    And verify pdf response is saved successfully


      Scenario Outline: Validate the Vpay PPRARequest for ViewPayments and SearchRemittance
    Given Perform the "<Method>" Action for Invalid "<scenarioType>" ViewPayments and SearchRemittance API
    Then the web service should respond with NegativeScenarios "<statusCode>" status code
    And verify "<statusCode>","<type>","<title>"
    
    Examples:
  |scenarioType  						|Method|statusCode|type													|title|
  | 400_BadRequest 					|GET	 | 400			|https://httpstatuses.com/400 | One or more validation errors occurred.|
  | 401_UnauthorizedID 			|GET   | 401 			|https://httpstatuses.com/401 | Unauthorized|
  | 401_UnauthorizedSecret  |GET   | 401 			|https://httpstatuses.com/401 | Unauthorized|
 	| 404_NotFound 						|GET   | 404 			|https://httpstatuses.com/404 | Not Found |
 	| 405_MethodNotAllowed 		|POST  | 405 			|https://httpstatuses.com/405 | Method Not Allowed|
    
  
    
    