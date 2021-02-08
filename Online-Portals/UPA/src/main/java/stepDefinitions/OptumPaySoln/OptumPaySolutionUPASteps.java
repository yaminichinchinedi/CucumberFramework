package main.java.stepDefinitions.OptumPaySoln;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.nativeFunctions.TestBase;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.pageObjects.OptumPaySolutionUPA;


public class OptumPaySolutionUPASteps extends TestBase {
	
OptumPaySolutionUPA optumPaySol = new OptumPaySolutionUPA(testConfig);

@Then("^User verifies their plan type information form the tiles$")
public void user_verifies_their_plan_type_information_form_the_tiles() throws Throwable {
	optumPaySol.verifyPlanTypeInfoForVCP();
}
@Then("^User verifies Optum Pay Solution Tab for standard user with \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_verifies_Optum_Pay_Solution_Tab_for_standard_user_with_and(String trialStatus, String portalAccess) throws Throwable {
	if(portalAccess.equalsIgnoreCase("Standard"))
		optumPaySol.verifySolutionsTabForStandard(trialStatus,portalAccess);
	else if(portalAccess.equalsIgnoreCase("Premium"))
		optumPaySol.verifySolutionsTabForPremium(trialStatus,portalAccess);
}


//Added by Mohammad Khalid
@Then("^User verifies page text \"([^\"]*)\" messaging in Optum Pay Solutions page$")
public void user_verifies_page_text_messaging_in_Optum_Pay_Solutions_page(String pageText) throws Throwable 
{
	switch (pageText)
	{
	case "Premium_TopMsg":
	{
		optumPaySol.verifyPageText_Top_Premium();
		break;
	}
	case "Premium_FooterMsg":
	{
		optumPaySol.verifyPageText_Footer_Premium();
		break;
	}
	case "Standard_Msg_1":
	{
		optumPaySol.verifyPageText_Message1_Standard();
		break;
	}
	
	case "Standard_Msg_2":
	{
		optumPaySol.verifyPageText_Message2_Standard();
		break;
	}
	
	}
	
	
}


}
