package main.java.Utils;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.paymentSummary;

public class ViewPaymentsDataProvider {
	
	private TestBase testConfig;
	
	public ViewPaymentsDataProvider(TestBase testConfig) {
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}

   /**
   * This function is basically
   * for preparing the data in 
   * this case we are preparing a tin
   * that has some payments of type @param typeOfPayment
   * like it gets the tin that has some failed payments etc
   * @param typeOfPayment
   * @return tin
  */
	public String getTinForSpecificTypeOfPayment(String typeOfPayment)
	{
		int sqlRowNo=0;
 		switch(typeOfPayment) 
 		 {
 		    case "failedPayment": 
 			sqlRowNo=23;
 		 	break;
 		
 		    case "payerFilter":
 			sqlRowNo=27;
 			break;
 			
 		    case "remitPayment":
 			sqlRowNo=23; 
 			break;
 		
 		}
 		
 		Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
 		return tinNumbers.get("PROV_TAX_ID_NBR").toString();
 	}

	/**
	 * This functions checks if the 
	 * required tin is already associated 
	 * with the logged in user or not.
	 * if in case its not associated it fires an insert query
	 * to get it associated 	
	 */
	public String associateTinWithUser(String tin) 
	{ 		
		int sqlRowNo=28;
		int insertQueryRowNo=24;
		int isTinAssociated;
		
		testConfig.putRunTimeProperty("tin", tin);
		
		Map associatedTins = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		isTinAssociated=Integer.valueOf((String) associatedTins.get("TIN_COUNT"));
		if(isTinAssociated == 0) 
		DataBase.executeInsertQuery(testConfig, insertQueryRowNo);	
		return tin;
	}
	
	public String getPaymentNo_NotInEPRAStatus()
	{
		int sqlRow=26;
		Map displayConsNo=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		testConfig.putRunTimeProperty("paymentNo",displayConsNo.get("DSPL_CONSL_PAY_NBR").toString());
		return testConfig.getRunTimeProperty("paymentNo");
	}
	
	public String getTinForPaymentNo_NotInEPRAStatus()
	{
		int sqlRow=27;
		getPaymentNo_NotInEPRAStatus();
		Map tinForDisplayConsNo=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		return associateTinWithUser(tinForDisplayConsNo.get("PROV_TAX_ID_NBR").toString());
	}
	
	
	
}
