#Author: amit_kushwah@optum.com
@CsrViewPayments @CSRRegression
Feature: View Payment Access Payment

  	@CSR_ViewPayments_US2801170,US2879948 @sudama
		Scenario Outline: Access Payments - Manage users Provider for Premium Experience
		Given User navigates to CSR portal and enters "<credentials>" and login
		When Click on View Payments Link
		Then Enter "<portalAccess>" portal access tin for "<tinType>" and "<usertype>" criteria and click submit button
		Then Validate default value of Quick Search filter displays Last thirty days option and dropdown have other time period options.
		Then Validate Active/Archived Payments filter is relabeled to Payment Status and has default value as New and dropdown have other status options.
		Then Validate grid no longer displays Type column or Payment Status field and is relabeled to ACH Trace
		Then Validate 835, ePRA and Payer PRA are enabled
		Then Validate "<usertype>" is able to re-originate ACH/drop to check payments
		Then Validate default value of Payment Status filter displays New and dropdown have other status options.
		Then Validate Archive column relabeled to Payment Status and has dropdown menu having values New, Pending and Closed
		Then Validate user is able to change the value of Payment Status column
		Then Validate Claim Count column is present which appears as Hyperlink and on click redirects to Remittance Detail page.
		
		Examples:
	
		|   credentials     |	usertype   |  tinType	|	portalAccess	|
    |      Super        |	  PROV     |		AO		|	  Standard		|
    #|      Super        |	  PROV     |		AV		|	  Standard		|
    #|      Super        |	  PROV     |		VO		|	  Premium			|
    #|      Super        |	  PROV     |		AO		|	  Premium			|
    #|      Super        |	  PROV     |		AV		|	  Premium			|
		
		
		@CSR_ViewPayments_US2801189 
		Scenario Outline: Access Payments - Manage users Provider for Premium Experience
		Given User navigates to CSR portal and enters "<credentials>" and login
		When Click on View Payments Link
		Then Enter "<portalAccess>" portal access tin for "<tinType>" and "<usertype>" criteria and click submit button
		Then Validate default value of Payment Status filter displays New and dropdown have other status options.
		Then Validate Archive column relabeled to Payment Status and has dropdown menu having values New, Pending and Closed
		Then Validate user is able to change the value of Payment Status column
		Then Validate upon changing of status in Payment Status filter appropriate payments display.
		Examples:
	
			|   credentials     |	usertype   |  tinType	|	portalAccess	|
    	|      Super        |	  PROV     |		AO		|	  Standard		|
		