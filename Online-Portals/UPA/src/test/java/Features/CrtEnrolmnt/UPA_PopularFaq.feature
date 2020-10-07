#Author: Marsha Vegda

@UPAPopularFAQ
Feature: Poplular FAQ navigation

  @UPAPopularFAQ1
  Scenario: Popular FAQs section
		Given User navigates to UPA Sys Test application
    When User scrolls to popular FAQ section
    Then Verify all Popular FAQ links are present
    And Click on VIEW ALL FAQs button and verify all FAQs are present
    