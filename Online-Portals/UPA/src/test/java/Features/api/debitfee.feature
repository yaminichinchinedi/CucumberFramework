 @debitFeeApi
Feature: Debit Fee Api

    @debitFeeApi
    Scenario: Validate the debit fee API
    Given I perform the action POST at debit fee API end point for Entity Type "PC"
    Then the web service should respond with a 200 status code
    And verify debit fee API should return global level rate

