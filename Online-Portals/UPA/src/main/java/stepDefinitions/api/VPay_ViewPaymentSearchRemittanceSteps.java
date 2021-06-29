package main.java.stepDefinitions.api;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.SearchRemittance;
import io.restassured.response.Response;

public class VPay_ViewPaymentSearchRemittanceSteps extends TestBase {
	private Response response;
	public SearchRemittance serachRemittance;

		/*Verify API has been invoked and valid request parameters are sent accordingly*/
	@Given("^Perform the GET Action for valid VPayClientId/VPayCilentSecret for ViewPayments and SearchRemittance API$")
	public void perform_the_GET_action() throws Throwable {
		serachRemittance = new SearchRemittance(testConfig);
		response = serachRemittance.getViewPaymentResponse();

	}

		/*Validating response statusCodes for PPRA request*/
	@Then("^the web service should respond with a \"([^\"]*)\" status code$")
	public void webserviceResponseStatus(String status) throws Throwable {
		serachRemittance.verifyResponseStatus(status, response);
		
	}

		/*Validating If response is being saved in pdf format for PPRA request*/
	@And("^verify pdf response is saved successfully$")
	public void verifyPdfDownload() throws Throwable {
		serachRemittance.verifyPdfDownload(response);
	}

		/*Validate API for NegativeScenarios*/
	@Given("^Perform the \"([^\"]*)\" Action for Invalid \"([^\"]*)\" ViewPayments and SearchRemittance API$")
	public void getInvalidResponse(String method,String scenarioType) throws Throwable {
		serachRemittance = new SearchRemittance(testConfig);
		response = serachRemittance.getInvalidResponse(method, scenarioType);
	
	}

		/*Validate Response Body fields - status, type, title, detail */
	@And("^verify response body for Vpay PPRA Request View Payments and Search Remittance \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_invalid_response_body(String status,String type,String title) throws Throwable {
		serachRemittance.verifyResponseBody(response,status,type,title);
	}
}
