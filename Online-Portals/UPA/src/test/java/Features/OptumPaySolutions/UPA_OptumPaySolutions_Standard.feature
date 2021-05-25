#Author: Rahul Krishna
@UPAOptumPaySolutions
Feature: - Optum Pay Solutions for Standard TINs
 
 @US3485959
   Scenario Outline: Optum Pay Solutions - Add Current billing month to the Total accrued fees label - UPA Standard TINs
	 Given User navigates to UPA portal and enters "<credentials>" and login
	 And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
	 And User clicks on Optum Pay Solutions tab
	 Then User clicks on "Invoices" tab
	 Then User validates accrued content fee on this page 
Examples:
    	|  credentials    |	 	userType    | 	portalAccess    |	searchCriteria   				| tinType		|
      |     PROV_Admin  | 	PROV			  |			Standard 		  |  wthAccuredFee        |	  AO			|
