#Author: Mohammad Khalid
Feature: Access Payments - Optum Pay Solutions - Provider Options Page Messaging QA


@UPA_OPS_US2949033
Scenario Outline: To test page text messaging on OPS for Prov Admin

Given User navigates to UPA portal and enters "<userType>" and login
When  User Selects a tin on HomePage for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for "<trialStatus>" and "<statusOfStandardRecd>" for "<SelectedOrDefault>" Portal Experience.
And   User clicks on Optum Pay Solutions tab

Then User verifies page text "<PageMessageText_Top>" messaging in Optum Pay Solutions page
And User verifies page text "<PageMessageText_Footer>" messaging in Optum Pay Solutions page


 Examples:
 |    userType     |   accessType  | 			searchCriteria				|		portalAccess	  | tinType	    	|trialStatus|statusOfStandardRecd|SelectedOrDefault| PageMessageText_Top |PageMessageText_Footer |
 |      PROV_Admin |   PROV     	|		 	TinDuringOrPostTrial		|			Standard	  |		AO			|     A     |	P				 |	PD      	   | Standard_Msg_1      |  Standard_Msg_2       |
 |      PROV_Admin |   PROV     	|		 	TinDuringOrPostTrial		|			Standard	  |		AO			|     I     |	A				 |	PD  		   | Standard_Msg_1      |  Standard_Msg_1       |
 |      PROV_Admin |   PROV     	|		 	TinDuringOrPostTrial		|			Premium		  |		AO			|     A     |	P				 |	PS		       | Premium_TopMsg      |   Premium_FooterMsg   |
 |      PROV_Admin |   PROV     	|		 	TinDuringOrPostTrial		|			Premium		  |		AO			|     I     |	A				 |	PS		       | Premium_TopMsg      |   Premium_FooterMsg   |
	    