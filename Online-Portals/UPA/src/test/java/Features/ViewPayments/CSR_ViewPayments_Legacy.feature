#Author: amit_kushwah@optum.com
@CsrViewPayments @CSRRegression
Feature: View Payment Access Payment

  @CSR_ViewPayments_US2801189
		Scenario Outline: Access Payments - Manage users Provider for Premium Experience
		Given User navigates to CSR portal and enters "<credentials>" and login
		When Click on View Payments Link
		Then Enter "<portalAccess>" portal access tin for "<tinType>" and "<usertype>" criteria and click submit button
		Then Validate on Legacy Mode Pending and New Status are treated as Active and Closed Status as Archive
		Examples:
	
			|   credentials     |	usertype   |  tinType	|	portalAccess	|
    	|      Super        |	  PROV     |		AO		|	  	Legacy		|	