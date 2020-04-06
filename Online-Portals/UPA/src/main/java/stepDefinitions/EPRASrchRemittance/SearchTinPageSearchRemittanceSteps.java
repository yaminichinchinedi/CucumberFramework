package main.java.stepDefinitions.EPRASrchRemittance;

import java.util.Map;

import cucumber.api.java.en.Then;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchTinPageSearchRemittance;

public class SearchTinPageSearchRemittanceSteps extends TestBase {
	
	SearchTinPageSearchRemittance srchTinPage=new SearchTinPageSearchRemittance(testConfig);
		
	@Then("^User enters tin on Search Remittance Tin Page for \"([^\"]*)\" and \"([^\"]*)\" click on continue button$")
	public void user_enters_tin_on_Search_Remittance_Tin_Page_for_and_click_on_continue_button(String priority, String searchBy) throws Throwable {
		if(searchBy.equals("EPRA"))
			testConfig.putRunTimeProperty("suite", "EPRA");
		else if(searchBy.equals("EPRAgenerated"))
			testConfig.putRunTimeProperty("suite", "EPRAgenerated");
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
		srchTinPage.enterTin(searchBy).clickSearchBtn();
	}
	
//	@Then("^User enters tin for UPA Search Remittance Tin Page for \"([^\"]*)\" and \"([^\"]*)\" click on continue button$")
//	public void user_enters_tin_for_UPA_Search_Remittance_Tin_Page_for_and_click_on_continue_button(String priority, String searchBy) throws Throwable {
//	   
//		if(searchBy.equals("EPRA"))
//			testConfig.putRunTimeProperty("suite", "EPRA");
//		
//		else if(searchBy.equals("EPRAgenerated"))
//			testConfig.putRunTimeProperty("suite", "EPRAgenerated");
//		if(priority.equals("1"))
//		{
//			testConfig.putRunTimeProperty("claimRange1", "1");
//			testConfig.putRunTimeProperty("claimRange2", "10");
//			testConfig.putRunTimeProperty("priority", "1");
//		}
//		else if(priority.equals("2"))
//		{
//			testConfig.putRunTimeProperty("claimRange1", "80");
//			testConfig.putRunTimeProperty("claimRange2", "100");
//			testConfig.putRunTimeProperty("priority", "2");
//		}
//		srchTinPage.enterTinUPA(searchBy);
//	}
	
	@Then("^User enters tin for UPA Search Remittance Tin Page for \"([^\"]*)\" and \"([^\"]*)\" through \"([^\"]*)\" and click on continue button$")
	public void user_enters_tin_for_UPA_Search_Remittance_Tin_Page_for_and_through_and_click_on_continue_button(String priority,String searchBy,String usertype) throws Throwable {
	    
		if(searchBy.equals("EPRA"))
			testConfig.putRunTimeProperty("suite", "EPRA");
		
		else if(searchBy.equals("EPRAgenerated"))
			testConfig.putRunTimeProperty("suite", "EPRAgenerated");
		
		else if(searchBy.equals("EPRAPayer"))
			testConfig.putRunTimeProperty("suite", "EPRAPayer");
		
		else if(searchBy.equals("EPRAPayergenerated"))
			testConfig.putRunTimeProperty("suite", "EPRAPayergenerated");
		
		else if(searchBy.equals("EPRAPROVAdmin"))
			testConfig.putRunTimeProperty("suite", "EPRAPROVAdmin");
		
		else if(searchBy.equals("EPRAgeneratedProvAdmin"))
			testConfig.putRunTimeProperty("suite", "EPRAgeneratedProvAdmin");
		
		else if(searchBy.equals("EPRAgeneratedPROVAdmin"))
			testConfig.putRunTimeProperty("suite", "EPRAgeneratedPROVAdmin");
		
		else if(searchBy.equals("EPRAPROVGen"))
			testConfig.putRunTimeProperty("suite", "EPRAPROVGen");
		
		else if(searchBy.equals("EPRAgeneratedProvGen"))
			testConfig.putRunTimeProperty("suite", "EPRAgeneratedProvGen");
		
		else if(searchBy.equals("EPRAgeneratedPROVGen"))
			testConfig.putRunTimeProperty("suite", "EPRAgeneratedPROVGen");
		
		else if(searchBy.equals("EPRAPayerAdmin"))
			testConfig.putRunTimeProperty("suite", "EPRAPayerAdmin");
		
		else if(searchBy.equals("EPRAPayerGen"))
			testConfig.putRunTimeProperty("suite", "EPRAPayerGen");
		
	    else if(searchBy.equals("EPRAPayergeneratedAdmin"))
			testConfig.putRunTimeProperty("suite", "EPRAPayergeneratedAdmin");
		
		else if(searchBy.equals("EPRAPayergeneratedGen"))
			testConfig.putRunTimeProperty("suite", "EPRAPayergeneratedGen");
		
		else if(searchBy.equals("EPRABSAdmin"))
			testConfig.putRunTimeProperty("suite", "EPRABSAdmin");
		
		else if(searchBy.equals("EPRABSGen"))
			testConfig.putRunTimeProperty("suite", "EPRABSGen");
		
		else if(searchBy.equals("EPRAgeneratedBSAdmin"))
			testConfig.putRunTimeProperty("suite", "EPRAgeneratedBSAdmin");
		
		else if(searchBy.equals("EPRAgeneratedBSGen"))
			testConfig.putRunTimeProperty("suite", "EPRAgeneratedBSGen");
		
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
		srchTinPage.enterTinUPA(searchBy, usertype);
	}

	@Then("^Enter Tin \"([^\"]*)\" and select serach button$")
	public void enter_Tin_and_select_serach_button(String Data) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("Tin", Data);
		srchTinPage.enterHCTin(Data).clickSearchBtn();		
	}
	
	@Then("^User enters tin for UPA Search Remittance Tin Page for \"([^\"]*)\" and \"([^\"]*)\" click on continue button$")
	public void user_enters_tin_for_UPA_Search_Remittance_Tin_Page_for_and_click_on_continue_button(String priority, String searchBy) throws Throwable {
		Browser.wait(testConfig, 10);
		System.out.println("*****Tin dropdown  debug point 1");
		int sqlRowNo=230;//34;		
		System.out.print("***ID selected is -->"+testConfig.getRunTimeProperty("UserID"));
		testConfig.putRunTimeProperty("UserID",testConfig.getRunTimeProperty("UserID"));
		Map portalUser=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		String User;
		User = (String) portalUser.get("USER_TYP");
		
		//testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+env);
		if(searchBy.equals("EPRA"))
		testConfig.putRunTimeProperty("suite", "EPRA");
		else if(searchBy.equals("EPRAgenerated"))
		testConfig.putRunTimeProperty("suite", "EPRAgenerated");
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
		System.out.println("*****Tin dropdown  1");
		srchTinPage.enterTinUPA(searchBy);	
	
	}
	
	
}