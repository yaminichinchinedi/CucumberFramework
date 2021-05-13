package main.java.stepDefinitions.api;

import io.restassured.response.Response;

import main.java.nativeFunctions.TestBase;
import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import main.java.reporting.Log;
import org.testng.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.api.pojo.debitFee.DebitFee;

import java.io.IOException;

public class deitfeeSrvSteps {
	private TestBase testConfig = TestBase.getInstance();
	private RequestSpecification requestSpecification;
	private Response response;

	@Given("^I perform the action POST at debit fee API end point for Entity Type \"([^\"]*)\"$")
	public Response i_perform_the_action_POST_at_debit_fee_API_end_point_for_Entity_Type(String arg1) throws Throwable {

		String debitFee = testConfig.getRunTimeProperty(testConfig.getRunTimeProperty("Env") + "DebitFee");

		RequestSpecification request = RestAssured.given();
		request.header("content-Type", "application/json");
		JSONObject requestBody = new JSONObject();
		requestBody.put("entityData", "133757370");
		requestBody.put("entityType", "PR");
		requestBody.put("processDate", "2021-02-05");
		requestBody.put("payerSchema", "");
		requestBody.put("primaryPayerId", "");
		requestBody.put("secondaryPayerId", "");
		Log.Comment(requestBody.toString());
		request.body(requestBody.toString());
		response = request.post(debitFee);
		return response;
	}

	@Then("^the web service should respond with a (\\d+) status code$")
	public void the_web_service_should_respond_with_a_status_code(int status) throws Throwable {

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, status);
	}

	@And("^verify debit fee API should return global level rate$")
	public void verifyDebitFeeAPIShouldReturnGlobalLevelRate() {
		DebitFee debitFee = getDebitFee();
		Log.Comment(debitFee.getResponseDetail());
		//Perform validations with the created POJO.
	}

	private DebitFee getDebitFee() {
		ObjectMapper mapper = new ObjectMapper();
		DebitFee debitFee = null;
		try {
			debitFee = mapper.readValue(response.getBody().prettyPrint(), DebitFee.class);
		} catch (IOException ex) {
			Log.Comment("Exception reading Mapper value for Debit Fee API " + ex.getMessage());
		}
		return debitFee;

	}
}
