#Author: Pranav Kasula
@UPARegression @ActivateAccount @US2707371
Feature: Activate Account

  Scenario Outline: Verify the changes done in Activate Account page
    Given User navigates to UPA portal for account activation,enters "<credentials>" and login
    Then verify user is on activate your account page
    Then verify Optum header is displayed on activate your account page
    Then Verify the message -> Welcome to Optum Pay! Help us answer a few short questions to get you started
    Then Verify the message -> First things first, is your organization enrolled in Optum Pay?
    Then Verify the message -> Yes, my organization is already enrolled and I need account access
    Then Verify the message -> No, I need to enroll my organization
    Given User Clicks on -> Yes, my organization is already enrolled and I need account access
    Then Verify the option -> Yes, I have my active Optum Pay username and password
    Then Verify the option -> No, I do not have an active Optum Pay user account
    Given User Clicks on -> Yes, I have my active Optum Pay username and password
    Then Verify the option -> Take a minute to connect your Optum Pay account with Optum ID
    Then Verify the absence of forgot Username and password link
    Then User navigates back by clicking change my answer
    Then User clicks on No, I need to enroll my organization
    And Verifies the text -> Benefits of Optum Pay link
    Then Click on Need Help link
    And Verify the text on the we are here to help pop up
    Then Click on Benefits of Optum Pay link
    And Verify User navigates to benefit page

Examples: 
        |    credentials     							|
        |     PayerActivateAccount        |             
