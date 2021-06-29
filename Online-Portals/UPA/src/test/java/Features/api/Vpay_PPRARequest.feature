 @Vpay_ViewPayments_SearchRemittance
Feature: Vpay_PPRARequest

    Scenario: Validate the Vpay PPRARequest for ViewPayments and SearchRemittance API
    Given Perform the GET Action for valid VPayClientId/VPayCilentSecret for ViewPayments and SearchRemittance API
    Then the web service should respond with a "200" status code
    And verify pdf response is saved successfully


    Scenario Outline: Validate the Vpay PPRARequest for ViewPayments and SearchRemittance API
    Given Perform the "<Method>" Action for Invalid "<scenarioType>" ViewPayments and SearchRemittance API
    Then the web service should respond with a "<statusCode>" status code
    And verify response body for Vpay PPRA Request View Payments and Search Remittance "<statusCode>","<type>","<title>"
    
    Examples:
  |scenarioType  						|Method|statusCode|type													|title|
  | 400badRequest 					|GET	 | 400			|https://httpstatuses.com/400 | One or more validation errors occurred.|
  | 401unauthorizedID 			|GET   | 401 			|https://httpstatuses.com/401 | Unauthorized|
  | 401unauthorizedSecret   |GET   | 401 			|https://httpstatuses.com/401 | Unauthorized|
 	| 404notFound 						|GET   | 404 			|https://httpstatuses.com/404 | Not Found |
 	| 405methodNotAllowed 		|POST  | 405 			|https://httpstatuses.com/405 | Method Not Allowed|
    
  
    
    