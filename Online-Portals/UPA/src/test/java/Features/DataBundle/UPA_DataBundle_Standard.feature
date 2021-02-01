#Author: Sunanda
@UPAPaymentDataFiles
Feature: UPA Payment Data Files Functionality for Standard TIN
@Tessy					
Scenario Outline: UI Validations for Data Bundle
Given User navigates to UPA portal and enters "<credentials>" to login as Billing Service
When User clicks on Data Bundle Tab for Billing Service
Then User enters a tin for "<tinType>" for "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" 
And  User verifies the Maximize your efficiency pop up for standard tin

	Examples:
	 |    credentials     | 	Search Criteria       |		portalAccess	    | tinType		|trialStatus|statusOfStandardRecd|SelectedOrDefault|
   |      BS_Admin 			|		 	Billing Service 		|			Standard			  |		AO			|     I     |					A					 |				PD			 |
   
	 