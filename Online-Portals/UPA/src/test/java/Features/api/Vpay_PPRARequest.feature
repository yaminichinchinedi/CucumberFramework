
Feature: Vpay_PPRARequest
 @Vpay_ViewPayments_SearchRemittance
    Scenario: Validate the Vpay PPRARequest for ViewPayments and SearchRemittance
    Given Perform the GET Action for valid ClientId/CilentSecret for ViewPayments and SearchRemittance API
    Then the web service should respond with a "200" status code
    And verify pdf response is saved successfully


      Scenario Outline: Validate the Vpay PPRARequest for ViewPayments and SearchRemittance
    Given Perform the "<Method>" Action for Invalid scenarios ViewPayments and SearchRemittance API
    Then the web service should respond with NegativeScenarios "<statusCode>" status code
    And verify "<statusCode>" "<type>" "<title>"
    
    Examples:
    |Method|statusCode|type													|title|
    |GET	 |400			 	|https://httpstatuses.com/400 | One or more validation errors occurred.|
    |GET   | 401 			|https://httpstatuses.com/401 | Unauthorized|
    |GET   | 401 			|https://httpstatuses.com/401 | Unauthorized|
    |GET   | 404 			|https://httpstatuses.com/404 | TRANSACTION_NOT_FOUND|
    |POST  | 405 			|https://httpstatuses.com/405 | Method Not Allowed|
    
  
    
    