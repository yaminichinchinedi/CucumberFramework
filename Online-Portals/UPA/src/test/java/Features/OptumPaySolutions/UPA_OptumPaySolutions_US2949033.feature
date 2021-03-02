#Author: Mohammad Khalid
Feature: Access Payments - Optum Pay Solutions - Provider Options Page Messaging QA


@UPA_OPS_US2949033
Scenario Outline: To test page text messaging on OPS for Prov Admin

Given User navigates to UPA portal and enters "<credentials>" and login
And User fetch tin for "<userType>" for "<searchCriteria>" for "<tinType>" for "<portalAccess>" for Portal Experience.
And   User clicks on Optum Pay Solutions tab

Then User verifies page text "<PageMessageText_Top>" messaging in Optum Pay Solutions page
And User verifies page text "<PageMessageText_Footer>" messaging in Optum Pay Solutions page


 Examples:
 |credentials      |    userType    | 			searchCriteria				|		portalAccess	  | tinType	    	|   PageMessageText_Top    |PageMessageText_Footer |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Standard	  |		AO			|      Standard_Msg_1      |  Standard_Msg_2       |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Standard	  |		AO			|      Standard_Msg_1      |  Standard_Msg_1       |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Premium		  |		AO			|      Premium_TopMsg      |   Premium_FooterMsg   |
 |      PROV_Admin |   PROV     	|		 	PremiumOrStandardTIN		|			Premium		  |		AO			|      Premium_TopMsg      |   Premium_FooterMsg   |
	    