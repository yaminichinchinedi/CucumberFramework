
Feature: Fisl Api
    @FislApi
    Scenario Outline: Validate the FISL API
    Given Get tin for "<userType>" for "<Search Criteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
    When I perform the action POST at FISL API end point for "<Search Criteria>"
    Then FISL web service should respond with a 200 status code

        Examples:
            |	Search Criteria   | userType  | portalAccess | tinType|
            |		byDOP		        |	 PROV     |   Premium    |   AO   |
            |byDOPAndAccountNo  |	 PROV     |   Premium    |   AO   |
            |byDOP&SubscriberID |	 PROV     |   Premium    |	 AO   |
            |byDOPAndClaimNo    |	 PROV     |   Premium    |	 AO   |
            |byDOPAndPatientNm  |	 PROV     |   Premium    |   AO   |

