package main.java.stepDefinitions.ViewPayments;

import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.RemittanceDetail;
import main.java.pageObjects.ValidateEnrollmentTypePage;
import main.java.pageObjects.ViewPayments_Page;
import main.java.pageObjects.paymentSummary;
import main.java.pageObjects.SearchTinPageViewPayments;

public class SearchTinPageViewPaymentsSteps extends TestBase {
	
    SearchTinPageViewPayments viewPaymentsTIN = new SearchTinPageViewPayments(testConfig);
	paymentSummary payment= new paymentSummary(testConfig); 
    
    @Then("^User enters tin on View Payments Tin \"([^\"]*)\" and click continue$")
    public void user_enters_tin_on_View_Payments_Tin_and_click_continue(String srchCriteria) throws Throwable {
        
    	viewPaymentsTIN.enterTin(srchCriteria).clickSearchBtn();
    }
    
	@Given("^User enters tin for UPA \"([^\"]*)\"$")
	public void user_enters_tin_for_UPA(String srchCriteria) throws Throwable {
	    
		viewPaymentsTIN.enterTinUPA(srchCriteria);
	}
	
	@Then("^User enters tin for UPA \"([^\"]*)\" for BS$")
	public void user_enters_tin_for_UPA_for_BS(String srchCriteria) throws Throwable {
	   
		viewPaymentsTIN.enterTinForBS(srchCriteria);
	}
	
	@When("^User enters tin for BS UPA \"([^\"]*)\" for BS for \"([^\"]*)\" and click on continue button$")
	public void user_enters_tin_for_BS_UPA_for_BS_for_and_click_on_continue_button(String srchCriteria, String priority) throws Throwable {
	
		if(priority.equals("1"))
		{
			testConfig.putRunTimeProperty("claimRange1", "1");
			testConfig.putRunTimeProperty("claimRange2", "10");
			testConfig.putRunTimeProperty("priority", "1");
		}
		else if(priority.equals("2"))
		{
			testConfig.putRunTimeProperty("claimRange1", "80");
			testConfig.putRunTimeProperty("claimRange2", "100");
			testConfig.putRunTimeProperty("priority", "2");
		}

		viewPaymentsTIN.enterTinForBS(srchCriteria);
	}

	@When("^User enters tin for BS UPA \"([^\"]*)\" for BS for \"([^\"]*)\",\"([^\"]*)\" and click on continue button$")
	public void user_enters_tin_for_BS_UPA_for_BS_for_and_click_on_continue_button1(String srchCriteria, String priority,String TimePeriod) throws Throwable {
	
			 String split[]=TimePeriod.split(" "); 
				if(split[split.length-1].contains("days"))
				{
					int LastNoOfdays=Integer.parseInt(split[split.length-2]);
					testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterDays(-LastNoOfdays,"yyyy-MM-dd"));
					testConfig.putRunTimeProperty("toDate",Helper.getCurrentDate("yyyy-MM-dd"));
					
				}
				
				else 
				{
					String monthRange=(split[split.length-2]);
					Map<String, String> startAndEndDates = Helper.getStartAndEndPeriod(monthRange);
					testConfig.putRunTimeProperty("fromDate",startAndEndDates.get("fromDate").toString());
					testConfig.putRunTimeProperty("toDate",startAndEndDates.get("toDate").toString());

				}	
		viewPaymentsTIN.enterTinForBS(srchCriteria);
//		int sqlRowNo=246;
//		String tin=System.getProperty("tin");
//		testConfig.putRunTimeProperty("tin", tin);
//		 Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//		 testConfig.putRunTimeProperty("dspl_consl_pay_nbr",tinNumbers.get("CP_DSPL_CONSL_PAY_NBR").toString());
	}
	@Given("^User enters tin for UPA \"([^\"]*)\" for Payer$")
	public void user_enters_tin_for_UPA_for_Payer(String srchCriteria) throws Throwable {
	   
		viewPaymentsTIN.enterTinForPayer(srchCriteria);
	}
	
	@Then("^User enters tin for View Payments UPA for \"([^\"]*)\" and \"([^\"]*)\" search criteria$")
	public void user_enters_tin_for_View_Payments_UPA_for_and_search_criteria(String paymentType, String userType) throws Throwable {
    	viewPaymentsTIN.enterPaymentTinUPA(paymentType, userType);
    }
	
	@Then("^User enters tin for BS View Payments UPA for \"([^\"]*)\" and \"([^\"]*)\" search criteria$")
	public void user_enters_tin_for_BS_View_Payments_UPA_for_and_search_criteria(String userType, String paymentType) throws Throwable {
    	payment.enterBSTin(paymentType, userType);
	}
	
	
	@Then("^User enters tin for BS View Payments UPA for \"([^\"]*)\" and \"([^\"]*)\" search criteria for \"([^\"]*)\" for \"([^\"]*)\" for Portal Experience\\.$")
	public void user_enters_tin_for_BS_View_Payments_UPA_for_and_search_criteria_for_for_for_Portal_Experience(String paymentType, String userType, String tinType, String portalAccess) throws Throwable {
		testConfig.putRunTimeProperty("tinType", tinType);
		testConfig.putRunTimeProperty("portalAccess", portalAccess);
		viewPaymentsTIN.enterTin(paymentType).clickSearchBtn();
	}
	
	@Then("^Select the TIN for \"([^\"]*)\" CSR Portal$")
	public void user_enters_tin_for_ViewPayment(String paymentType) throws Throwable {
		viewPaymentsTIN.enterTin(paymentType).clickSearchBtn();
	}
	
	@Then("^Enter \"([^\"]*)\" portal access tin for \"([^\"]*)\" and \"([^\"]*)\" criteria and click submit button$")
	public void enter_portal_access_tin_for_and_criteria_and_click_submit_button(String portalAccess, String tinType, String searchCriteria) throws Throwable {
		String paymentType=searchCriteria+"_"+tinType+"_"+portalAccess;
		testConfig.putRunTimeProperty("tinType", tinType);
		testConfig.putRunTimeProperty("portalAccess", portalAccess);
		viewPaymentsTIN.enterTin(paymentType).clickSearchBtn();
	}
	
	@When("^User Enters tin for \"([^\\\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for Portal Experience\\.$")
	public void user_Enters_tin_for_for_for_for_Portal_Experience(String userType,String searchCriteria, String tinType, String portalAccess) throws Throwable {
		viewPaymentsTIN.enterPaymentTinUPA(userType,searchCriteria, tinType,portalAccess);
		
	}
	
	@Then("^User Enters TIN for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" Portal Experience$")
	public void user_Enters_TIN_for_and_for_Portal_Experience(String searchCriteria, String tinType, String portalAccess, String TimePeriod) throws Throwable {
		testConfig.putRunTimeProperty("tinType", tinType);
    	testConfig.putRunTimeProperty("prdctSelected", portalAccess);
    	String split[]=TimePeriod.split(" "); 
		if(split[split.length-1].contains("days"))
		{
			int LastNoOfdays=Integer.parseInt(split[split.length-2]);
			testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterDays(-LastNoOfdays,"yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate",Helper.getCurrentDate("yyyy-MM-dd"));
			
		}
		
		else 
		{
			String monthRange=(split[split.length-2]);
			Map<String, String> startAndEndDates = Helper.getStartAndEndPeriod(monthRange);
			testConfig.putRunTimeProperty("fromDate",startAndEndDates.get("fromDate").toString());
			testConfig.putRunTimeProperty("toDate",startAndEndDates.get("toDate").toString());

		}	
    	viewPaymentsTIN.enterTinForBS(searchCriteria);
	}
	
	@When("^User Selects  tin on HomePage for \"([^\"]*)\" with \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\" for \"([^\"]*)\" for Portal Experience$")
	public void user_Selects_tin_on_HomePage_for_with_for_for_Portal_Experience(String userType,String trialStatus, String paidOption, String tinType, String portalAccess) throws Throwable {
		viewPaymentsTIN.enterPaymentTinUPA(userType,trialStatus+" and "+paidOption, tinType,portalAccess);

	}
	@Given("^User Selects tin on HomePage for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" Portal Experience$")
	public void user_Selects_tin_on_HomePage_for_and_Portal_Experience(String userType, String searchCriteria, String tinType, String portalAccess) 
	{
		testConfig.putRunTimeProperty("tinType", tinType);
    	testConfig.putRunTimeProperty("prdctSelected", portalAccess);
    	String split[]=searchCriteria.split(" "); 
		if(split[split.length-1].contains("days"))
		{
			int LastNoOfdays=Integer.parseInt(split[split.length-2]);
			testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterDays(-LastNoOfdays,"yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate",Helper.getCurrentDate("yyyy-MM-dd"));
			
		}
		
		else 
		{
			String monthRange=(split[split.length-2]);
			Map<String, String> startAndEndDates = Helper.getStartAndEndPeriod(monthRange);
			testConfig.putRunTimeProperty("fromDate",startAndEndDates.get("fromDate").toString());
			testConfig.putRunTimeProperty("toDate",startAndEndDates.get("toDate").toString());

		}	
		searchCriteria=searchCriteria+"PPRARecord";
		if (userType.equals("CSR"))
		viewPaymentsTIN.enterTinCSR(searchCriteria).clickSearchBtn();
		else
		viewPaymentsTIN.enterPaymentTinUPA(userType,searchCriteria, tinType,portalAccess);

	}
	
	@Then("^User Enters tin for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" Portal Experience and click on Search$")
	public void user_Enters_tin_for_and_Portal_Experience_and_click_on_Search(String userType, String searchCriteria, String tinType, String portalAccess) throws Throwable {
		user_Selects_tin_on_HomePage_for_and_Portal_Experience( userType,  searchCriteria,  tinType,  portalAccess);
	}
}
