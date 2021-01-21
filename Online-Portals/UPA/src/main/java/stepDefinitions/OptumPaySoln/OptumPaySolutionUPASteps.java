package main.java.stepDefinitions.OptumPaySoln;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.pageObjects.OptumPaySolution;


public class OptumPaySolutionUPASteps extends TestBase {
	
OptumPaySolution optumPaySol = new OptumPaySolution(testConfig);

@Then("^User verifies their plan type information form the tiles$")
public void user_verifies_their_plan_type_information_form_the_tiles() throws Throwable {
	optumPaySol.verifyPlanTypeInfoForVCP();
}
}
