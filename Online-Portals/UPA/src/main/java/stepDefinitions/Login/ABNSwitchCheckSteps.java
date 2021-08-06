package main.java.stepDefinitions.Login;
import java.util.Map;


import cucumber.api.java.en.When;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;
import main.java.reporting.Log;

public class ABNSwitchCheckSteps extends TestBase{
	
		@When("^ABN Validator Switch is set as 'Y'$")
		public void abn_Validator_Switch_is_set_as_Y() throws Throwable {
			int sqlRowNo=274;
			Map ABNSwitch=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			
			if (!ABNSwitch.get("PROC_DATA").toString().equals("Y"))
				Log.Fail("ABN Validator is not Switched ON.Please make it ON and retest.");	
			
		}

		/* Updates PROC_DATA value from 'N' to 'Y'in DB */
		@When("^ABN Validator Switch is updated to 'Y'$")
		public void abn_Validator_Switch_is_updated_to_Y() throws Throwable {
			int sqlRowNo=274;
			Map ABNSwitch=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			
			if (!ABNSwitch.get("PROC_DATA").toString().equals("Y")) {
				DataBase.executeUpdateQuery(testConfig, QUERY.UPDATE_PROC_DATA)	;
				ABNSwitch=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			}
			
		}
}