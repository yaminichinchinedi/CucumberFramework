package main.java.stepDefinitions.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.api.pojo.debitFee.DebitFee;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.SearchRemittance;
import main.java.reporting.Log;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

public class FislSrvSteps extends TestBase{
	private int statusCode;
	
	@Given("^Get tin for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for Portal Experience\\.$")
	public void user_fetch_tin_on_CSR_for_for_for_for_for_Portal_Experience(String userType,String searchCriteria, String tinType, String portalAccess) throws Throwable {
		new CSRHomePage(testConfig).fetchTin(userType, searchCriteria, tinType, portalAccess);
	}
	
	
	@When("^I perform the action POST at FISL API end point for \"([^\"]*)\"$")
	public void i_perform_the_action_POST_at_FISL_API_end_point_for(String criteriaType) throws Throwable {
		statusCode = new SearchRemittance(testConfig).getFISLAPIResponse(criteriaType);

	}
	
	@Then("^FISL web service should respond with a (\\d+) status code$")
	public void the_web_service_should_respond_with_a_status_code(int status) throws Throwable {
		new SearchRemittance(testConfig).verifyStatusCode(statusCode, status);

	}


}
