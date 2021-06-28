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
	
	@Given("^Perform the GET Action for valid ClientId/CilentSecret for ViewPayments and SearchRemittance API$")
	public void perform_the_GET_action() throws Throwable {
		serachRemittance = new SearchRemittance(testConfig);
		response = serachRemittance.getViewPaymentResponse();

	}


	@Then("^the web service should respond with a \"([^\"]*)\" status code$")
	public void webserviceResponseStatus(String status) throws Throwable {
			Assert.assertTrue(Integer.parseInt(status)==response.getStatusCode(),"Incorrect status code");
		
	}
	@And("^verify pdf response is saved successfully$")
	public void verify_pdf_response() throws Throwable {
			
		serachRemittance.verify_pdf_response(response);
	}

	
	
}
