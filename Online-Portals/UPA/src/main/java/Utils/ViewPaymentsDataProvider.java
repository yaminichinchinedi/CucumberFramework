package main.java.Utils;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.openqa.selenium.support.PageFactory;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.paymentSummary;
import main.java.reporting.Log;

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
public String getTinForPaymentType(String paymentType)
	{
		int sqlRowNo=0;
 		switch(paymentType) 
 		 {
 		    case "failedPayment": 
 			sqlRowNo=29;
 		 	break;
 		
 		    case "payerFilter":
 			sqlRowNo=27;
 			break;
 			
 		    case "remitPayment":
 			sqlRowNo=35; 
 			break;
 			
 		    case "generalPayment":
 	 		sqlRowNo=37; 
 	 		break;
 			
 		   case "nonEpraPayment":
 		   { 
 		      testConfig.putRunTimeProperty("paymentNo",getPaymentNoDetails("nonEpraPayment").get("paymentNo").toString());
 	 		  sqlRowNo=27; 
 	 		  break;
 		   }
 		   
 		  case "ACH":
 		     sqlRowNo=35; 
 		      break;
 		       
 		 case "VCP":
 		     sqlRowNo=36; 
 		     break;
 		     
 		 case "byElectronicPaymentNumber":
 			sqlRowNo=39;
 			 break;
 			 
 		 case "byCheckNumber":
 			 sqlRowNo=39;
 			 break;
 			 
 		 case "byDateOfService":
 			 sqlRowNo=41;
 			 break;
 		   
 		   default:
 			   Log.Comment("Payment Type " + paymentType + " not found");
 		
 		}
 		Log.Comment("Getting tin for  " + paymentType);
 		Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
 		Log.Comment("Tin retreived from query for " + paymentType + " is : " + tinNumbers.get("PROV_TAX_ID_NBR").toString());
 		testConfig.putRunTimeProperty("tin",tinNumbers.get("PROV_TAX_ID_NBR").toString());
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
		 {
		   DataBase.executeInsertQuery(testConfig, insertQueryRowNo);
		   Log.Comment("Associated tin " + tin + "With Logged in user");
		 }
		else
		Log.Comment("Tin No " + tin + " is already associated with logged in user");
		return tin;
	}
	
	
	/**
	 * Gets display consol Number
     * and settlement date for
     * Passed Tin
     * @param- tin number
    **/
	
	public Map<String, String> getPaymentNoDetails(String paymentType)
	{
		int dateDiff;
		String dateToValidate;
		Map<String,String> paymentNoDetails= new HashMap<String, String>();
		
		int sqlRowNo=0;
 		switch(paymentType) 
 		 {
 		    case "failedPayment": 
 			sqlRowNo=30;
 		 	break;
 			
 		    case "remitPayment":
 			sqlRowNo=36; 
 			break;
 			
 		    case "nonEpraPayment":
 	 		sqlRowNo=26; 
 	 		break;
 	 		
 		    case "ACH":
 		    sqlRowNo=35; 
 	 		break;
 	 			
 		    case "VCP":
 	 		sqlRowNo=36; 
 	 		break;
 	 		
 	 		default:
 	 			Log.Comment("No SQL Row defined");
 
 		}
		
		Map displayConsNo=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);

		if(displayConsNo.get("DSPL_CONSL_PAY_NBR").toString()!=null)
		 {
		   dateDiff=Integer.parseInt(displayConsNo.get("DATE_DIFF").toString());
	       dateToValidate = Helper.getDateBeforeOrAfterDays(-dateDiff,"yyyy-MM-dd");
	       
		   paymentNoDetails.put("paymentNo", displayConsNo.get("DSPL_CONSL_PAY_NBR").toString());
	       paymentNoDetails.put("setlDate", dateToValidate);
		
		   Log.Comment("Getting Payment Details : " + paymentNoDetails);
		
		   testConfig.putRunTimeProperty("paymentNo",displayConsNo.get("DSPL_CONSL_PAY_NBR").toString());
		   testConfig.putRunTimeProperty("setlDate",dateToValidate);
		 }
		else
			Log.Warning("No result returned from query", testConfig);
		return paymentNoDetails;
	}
	

	/**
	 * Gets the Display cons number from
	 * PP001 Schema for which there is no entry in
	 * EPRA Status Table
	 * @return Display Consol No & SettlmentDate
	 */
	public Map<String, String> getPaymentNo_NotInEPRAStatus()
	{
		int sqlRow=26;
		
		Map<String,String> paymentNoAndSetlDate= new HashMap<String, String>();
		Map displayConsNo=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		
		paymentNoAndSetlDate.put("paymentNo", displayConsNo.get("DSPL_CONSL_PAY_NBR").toString());
		paymentNoAndSetlDate.put("setlDate", displayConsNo.get("SETL_DT").toString());
		
		testConfig.putRunTimeProperty("paymentNo",displayConsNo.get("DSPL_CONSL_PAY_NBR").toString());
		return paymentNoAndSetlDate;
	}
	
	
	/**
	 * Gets the Tin Number associated with consol number 
	 * that is not in
	 * EPRA Status Table
	 * @return 
	 * it associates the retrieved tin with logged in user
	 */
	public String getTinForPaymentNo_NotInEPRAStatus()
	{
		int sqlRow=27;
		getPaymentNo_NotInEPRAStatus();
		Map tinForDisplayConsNo=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		return associateTinWithUser(tinForDisplayConsNo.get("PROV_TAX_ID_NBR").toString());
	}
		
	
	public String getQuickSearchFilterCriteria(String settlDate)
	{
		String filterCriteria="Last 30 days"; 
	    if (settlDate.compareTo(Helper.getDateBeforeOrAfterDays(-30,"yyyy-MM-dd")) >= 0 && settlDate.compareTo(Helper.getCurrentDate("yyyy-MM-dd")) < 0) 
		filterCriteria="Last 30 days";
	    
	    else if (settlDate.compareTo(Helper.getDateBeforeOrAfterDays(-60,"yyyy-MM-dd")) >= 0 && settlDate.compareTo(Helper.getDateBeforeOrAfterDays(-30,"yyyy-MM-dd")) < 0) 
		filterCriteria="Last 60 days";
		
	    else if (settlDate.compareTo(Helper.getDateBeforeOrAfterDays(-90,"yyyy-MM-dd")) >= 0 && settlDate.compareTo(Helper.getDateBeforeOrAfterDays(-60,"yyyy-MM-dd")) < 0)
		filterCriteria="Last 90 days";
		
	    else if (settlDate.compareTo(Helper.getStartAndEndPeriod("4-6").get("fromDate").toString()) >=0 && settlDate.compareTo(Helper.getStartAndEndPeriod("4-6").get("toDate").toString()) <=0) 
		filterCriteria="Last 4-6 months";
		
	    else if (settlDate.compareTo(Helper.getStartAndEndPeriod("6-9").get("fromDate").toString()) >=0 && settlDate.compareTo(Helper.getStartAndEndPeriod("6-9").get("toDate").toString()) <=0)
		filterCriteria="Last 6-9 months";
		
	    else if (settlDate.compareTo(Helper.getStartAndEndPeriod("9-13").get("fromDate").toString()) >=0 &&  settlDate.compareTo(Helper.getStartAndEndPeriod("9-13").get("toDate").toString()) <=0)
		filterCriteria="Last 9-13 months";
	
	    return filterCriteria;
	}
}
