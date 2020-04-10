package main.java.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.paymentSummary;
import main.java.reporting.Log;

public class ViewPaymentsDataProvider {
	
	private TestBase testConfig;
	
	@FindBy(xpath = "//select[@id='taxIndNbrId']") WebElement tinDrpDwn;
	@FindBy(xpath = "//input[@name='billingProvTin']") WebElement bstinDrpDwn;
	@FindBy(xpath = "//input[@name='btnSearch']") WebElement submitBtn;
	
	
	
	
	public ViewPaymentsDataProvider(TestBase testConfig) {
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		
	}
	
	//Default Constructor
    public ViewPaymentsDataProvider() {
		
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
		String payType="";
		String env = "";
		String id = "";
		paymentSummary paySum=new paymentSummary(testConfig,"filter");
 		switch(paymentType) 
 		 {
 		    case "failedPayment": 
 			sqlRowNo=29;
 		 	break;
 		
 		    case "payerFilter":
 			sqlRowNo=27;
 			break;
 			
 		    case "remitPayment":
 			sqlRowNo=31;//35; 
 			break;
 			
 		    case "generalPayment":
 	 		sqlRowNo=127;//37; 
 	 		break;
 			
 		   case "generalPayment30Days":
 	 	 		sqlRowNo=129;//37; 
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
 		     
 		 case "byCheckNo":
 		 case "byElectronicPaymentNo":
 			 sqlRowNo=50;
 			 break;
 			 
 		 case "byDOP":
 		 case "byDOPAndAccountNo":
 			 sqlRowNo=204;
 			 break;
 		 case "byDOP&SubscriberID":
 		 case "byDOPAndNpi":
 		 case "byDOPAndClaimNo":
 		 case "byDOPAndPatientNm":	 
 		 case "byDOS":
 		
 		 case "byDOSAndNpi":
 		 case "byDOSAndClaimNo":
 		
			 sqlRowNo=41;
			 break;
 		 case "byDOSAndAcntNo":
 			sqlRowNo=41;
 			break;
 			 
 		 case "byDOPAndZeroPaymentClaims":
		 case "byDOSAndZeroPaymentClaims":
			sqlRowNo=47;
			break;
			
		 case "byDOSAndSubscriberId":
			 sqlRowNo=41;//156;
			 break;
			 
	
         
case "EPRA":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     System.setProperty("id", id);
		     
		      sqlRowNo=204;
	 			break;
	 			
	 			
	 	case "EPRACSR":

	 		 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
		      sqlRowNo=204;
	 			break;		
	 			
		 case "EPRAgenerated":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
				sqlRowNo=205;
				break;
				
         case "EPRAPROVAdmin":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=204;
	 			break;	
	 			
         case "EPRAgeneratedPROVAdmin":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
			 sqlRowNo=205;
			 break;	
		
         case "EPRAPROVGen":	
        	 
        	 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Gen"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
				sqlRowNo=204;
				break;	
				
         case "EPRAgeneratedPROVGen":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Gen"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
				sqlRowNo=205;
				break;			
		
         case "EPRAPayerAdmin":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=210;
	 			break;	
	 			
         case "EPRAPayerGen":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Gen"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=212;
	 			break;	
	 			
         case "EPRAPayergeneratedAdmin":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
				sqlRowNo=217;
				break;	
				
		 case "EPRAPayergeneratedGen":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Gen"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
				sqlRowNo=217;
				break;	
				
				
           case "EPRABSAdmin":
			 
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"BS_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=218;
	 			break;	
	 			
	 			
           case "EPRABSGen":
  			 
  			 env=System.getProperty("env");
  		     Browser.wait(testConfig, 5);
  		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"BS_Gen"+"_"+env);
  		     System.out.println(id);
  		     System.setProperty("id", id);
  		     testConfig.putRunTimeProperty("id", id);
  		     
  		      sqlRowNo=218;
  	 			break;	
  	 			
  	 			 
           case "EPRAgeneratedBSAdmin":
  			 
  			 env=System.getProperty("env");
  		     Browser.wait(testConfig, 5);
  		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"BS_Admin"+"_"+env);
  		     System.out.println(id);
  		     System.setProperty("id", id);
  		     testConfig.putRunTimeProperty("id", id);
  		     
  		      sqlRowNo=219;
  	 			break;
  	 			
           case "EPRAgeneratedBSGen":
    			 
    			 env=System.getProperty("env");
    		     Browser.wait(testConfig, 5);
    		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"BS_Gen"+"_"+env);
    		     System.out.println(id);
    		     System.setProperty("id", id);
    		     testConfig.putRunTimeProperty("id", id);
    		     
    		      sqlRowNo=219;
    	 			break;				
	
		 case "EPRAPayer":
	 			sqlRowNo=210;
	 			break;
	 			
		 case "EPRAPayergenerated":
				sqlRowNo=205;
				break;	
         
		 case "EPRABS":
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"BS_Admin"+"_"+env);
		     System.out.println(id);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=204;
	 			break;		
 		case "byElectronicPaymentForVCP":
 			testConfig.putRunTimeProperty("type","VCP");
 			sqlRowNo=52;
 			break;
// 		case "byElectronicPaymentForNON":
// 			testConfig.putRunTimeProperty("type","NON");
//
// 		
// 		 case "byElectronicPaymentforStatus":
// 			sqlRowNo=52;
// 			break;
// 			
// 		 case "DD":
// 			 testConfig.putRunTimeProperty("type","DD");
// 			 sqlRowNo=54;
// 			 break;
//
 		 case "byElectronicPaymenForACH":
 		 case "selectTin":
 			 testConfig.putRunTimeProperty("type","ACH");
 			 sqlRowNo=56;
 			 break;
// 		case "byElectronicPaymenForCHK":
//			 testConfig.putRunTimeProperty("type","CHK");
//			 sqlRowNo=56;
//			 break;
// 		case "byDOPAndPatientNmForTricare":
//			 sqlRowNo=63;
//			 break;
//			 
// 		case "byCheckNoOfReoriginNacha":
// 			sqlRowNo=98;
// 			break;
// 			
// 		case "byCheckNoOfConslPayDtl":
// 			sqlRowNo=99;
// 			break;
//=======
 		case "generalPaymentForTIN":
			sqlRowNo=51; 
			break;

		case "generalPaymentForNPI_30days":
		{
			 paySum.getQuickSearchDates("Last 30 days");
			 sqlRowNo=131;
			 break;
		}
		     
		case "generalPaymentForNPI_60days":
		{
			 paySum.getQuickSearchDates("Last 60 days");
			 sqlRowNo=130;
			 break;
		}
			
		case "generalPaymentForNPI_90days":
		{
			paySum.getQuickSearchDates("Last 90 days");
			sqlRowNo=147;
			break;
		}
		
		case "generalPaymentForNPI_4-6months":
		{
			paySum.getQuickSearchDates("Last 4-6 months");
			sqlRowNo=132; 
	 		break;
		}
		
		case "generalPaymentForNPI_6-9months":
		{
			  paySum.getQuickSearchDates("Last 6-9 months");
			  sqlRowNo=132; 
		 	  break;
			
		}
		case "generalPaymentForNPI_9-13months":
		{
			  paySum.getQuickSearchDates("Last 9-13 months");
			  sqlRowNo=132; 
		 	  break;
		}
			 
			
		case "generalPayment60Days":
		{
			 paySum.getQuickSearchDates("Last 60 days");
			 sqlRowNo=126; 
	 		 break;
		}
		
		case "generalPayment90Days":
		{ 
			paySum.getQuickSearchDates("Last 90 days");
 	 		sqlRowNo=143; 
 	 		break;
		}
 	 		  
		case "Last 4-6 months":
		{     
			  paySum.getQuickSearchDates("Last 4-6 months");
			  sqlRowNo=127; 
	 		  break;
		}
		
		case "Last 9-13 months":
		{
			  paySum.getQuickSearchDates("Last 9-13 months");
			  sqlRowNo=127; 
		 	  break;
			
		}
		case "Last 6-9 months":
		{
			  paySum.getQuickSearchDates("Last 6-9 months");
			  sqlRowNo=127; 
		 	  break;
			
		}
		
		case "generalPaymentForTIN_30days":
		{
			  paySum.getQuickSearchDates("Last 30 days");
			  sqlRowNo=133; 
		 	  break;
			
		}
	
		case "generalPaymentForTIN_60days":
		{
			  paySum.getQuickSearchDates("Last 60 days");
			  sqlRowNo=134; 
		 	  break;
			
		}
		
		case "generalPaymentForTIN_90days":
		{
			  paySum.getQuickSearchDates("Last 90 days");
			  sqlRowNo=144; 
		 	  break;
			
		}
		
		case "generalPaymentForTIN_4_6months":
		{
			  paySum.getQuickSearchDates("Last 4-6 months");
			  sqlRowNo=135; 
		 	  break;
			
		}
		case "generalPaymentForTIN_6_9months":
		{
			  paySum.getQuickSearchDates("Last 6-9 months");
			  sqlRowNo=135; 
		 	  break;
			
		}
		
		case "generalPaymentForTIN_9_13months":
		{
			  paySum.getQuickSearchDates("Last 9-13 months");
			  sqlRowNo=135; 
		 	  break;
			
		}
		
		case "archiveOnly30Days":
		{
			 paySum.getQuickSearchDates("Last 30 days");
			 sqlRowNo=136; 
		 	 break;
		}
		
		case "archiveOnly60Days":
		{
			 paySum.getQuickSearchDates("Last 60 days");
			 sqlRowNo=137; 
		 	 break;
		}
		
		case "archiveOnly90Days":
		{
			 paySum.getQuickSearchDates("Last 90 days");
			 sqlRowNo=145; 
		 	 break;
		}
		
		case "archiveOnly4_6months":
		{
			 paySum.getQuickSearchDates("Last 4-6 months");
			 sqlRowNo=138; 
		 	 break;
		}
		
		case "archiveOnly6_9months":
		{
			 paySum.getQuickSearchDates("Last 6-9 months");
			 sqlRowNo=138; 
		 	 break;
		}
		case "archiveOnly9_13months":
		{
			 paySum.getQuickSearchDates("Last 9-13 months");
			 sqlRowNo=138; 
		 	 break;
		}
			
		
		case "activeOnly30Days":
		{
			 paySum.getQuickSearchDates("Last 30 days");
			 sqlRowNo=139; 
		 	 break;
		}
		
		case "activeOnly60Days":
		{
			 paySum.getQuickSearchDates("Last 60 days");
			 sqlRowNo=140; 
		 	 break;
		}
		
		case "activeOnly90Days":
		{
			 paySum.getQuickSearchDates("Last 90 days");
			 sqlRowNo=146; 
		 	 break;
		}
		
		case "activeOnly4_6months":
		{
			 paySum.getQuickSearchDates("Last 4-6 months");
			 sqlRowNo=141; 
		 	 break;
		}
		
		case "activeOnly6_9months":
		{
			 paySum.getQuickSearchDates("Last 6-9 months");
			 sqlRowNo=141; 
		 	 break;
		}
		case "activeOnly9_13months":
		{
			 paySum.getQuickSearchDates("Last 9-13 months");
			 sqlRowNo=141; 
		 	 break;
		}
			
		case "medicalFilter":
		{
			payType="medicalPayment";
			getPaymentNoDetails(payType);
		}  
	 	    break;
	 	    
	 	    
		case "RemitDetail_ProvGen":
	 		  
	 	  {

	 		 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Gen"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=211;
	 			break;
	 	  }
	 	  
		case "RemitDetail_ProvAdmin":
	 		  
	 	  {

	 		 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=211;
	 			break;
	 	  }
	 	  
	 	  
		case "RemitDetail":
	 		  
	 	  {

	 		 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=211;
	 			break;
	 	  }
	 	  
		case "RemitDetail_BSAdmin":
	 		  
	 	  {
	  
	 		 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=211;
	 			break;
	 	  }
	 	  
		case "RemitDetail_BSGen":
	 		  
	 	  {
	  
	 		 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Gen"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=211;
	 			break;
	 	  }
	 	  
		case "Provider_Admin":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=211;
	 			break;
	 	}
		
		case "Provider_Gen":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Gen"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     
		      sqlRowNo=211;
	 			break;
	 	}
		
		
		case "BS_Admin":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
			 sqlRowNo = 211;
			break;

		}
		
		
		case "BS_Gen":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Gen"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
			 sqlRowNo = 211;
			 break;

		}
		
		
		case "Prov":
		{
			
			sqlRowNo = 213;
			break;

		}
		case "Payer_Admin":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     sqlRowNo = 212;
		     Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		     String payerSchema2 = payerSchema1.toString();
	   		 String schema = (payerSchema2.substring(payerSchema2.indexOf("=")+1, payerSchema2.length()-1)).trim();
		     System.out.println(schema);
		     testConfig.putRunTimeProperty("schema",schema);
		     sqlRowNo = 213;
   			 
   		     break;
		}
		
		case "Payer_Gen":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Gen"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     sqlRowNo = 212;
		     Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		     String payerSchema2 = payerSchema1.toString();
	   		 String schema = (payerSchema2.substring(payerSchema2.indexOf("=")+1, payerSchema2.length()-1)).trim();
		     System.out.println(schema);
		     testConfig.putRunTimeProperty("schema",schema);
		     sqlRowNo = 213;
   			 
   		     break;
		}	
	 	 
		case "Tricare":
		{
			sqlRowNo = 196;
			break;
		}	
		
		case "Tricare_BS":
		{
			sqlRowNo = 196;
			break;
		}
		
		case "Multiple PLB":
		{
			sqlRowNo = 200;
			break;
		}	
		
		
		case "PLB Adj Only":
		{
			sqlRowNo = 188;
			break;
		}	
		
		
		case "PLB_Adj_Only_Pay_Admin":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     sqlRowNo = 212;
			
		     
		     Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		     String payerSchema2 = payerSchema1.toString();
	   		 String schema = (payerSchema2.substring(payerSchema2.indexOf("=")+1, payerSchema2.length()-1)).trim();
		     System.out.println(schema);
		     testConfig.putRunTimeProperty("schema",schema);
		     sqlRowNo = 214;
			break;
		}	
		
		
		case "PLB_Adj_Only_Pay_Gen":
		{
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PAY_Admin"+"_"+env);
		     System.out.println(id);
		     testConfig.putRunTimeProperty("id", id);
		     sqlRowNo = 212;
			
		     
		     Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		     String payerSchema2 = payerSchema1.toString();
	   		 String schema = (payerSchema2.substring(payerSchema2.indexOf("=")+1, payerSchema2.length()-1)).trim();
		     System.out.println(schema);
		     testConfig.putRunTimeProperty("schema",schema);
		     sqlRowNo = 214;
			break;
		}	
		
			case "EPRABSViewPay":
		{
			sqlRowNo = 218;
			break;	
		}
		
 		   default:
 			   Log.Comment("Payment Type " + paymentType + " not found");
 		
 		}

 		if(!payType.equalsIgnoreCase("medicalPayment"))
 		 { 
 		   Log.Comment("Getting tin for  " + paymentType);
 		   Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
 		   
 		   try{
 		    Log.Comment("Tin retreived from query for " + paymentType + " is : " + tinNumbers.get("PROV_TAX_ID_NBR").toString());
 		    testConfig.putRunTimeProperty("tin",tinNumbers.get("PROV_TAX_ID_NBR").toString());
 		    if((paymentType.equalsIgnoreCase("EPRA"))|| (paymentType.equalsIgnoreCase("EPRABSViewPay")) )
 		   {   
 		    testConfig.putRunTimeProperty("dspl_consl_pay_nbr",tinNumbers.get("DSPL_CONSL_PAY_NBR").toString());
 		    testConfig.putRunTimeProperty("consl_pay_nbr",tinNumbers.get("CONSL_PAY_NBR").toString());
 		   } 
		   }
 		  catch(Exception e)
 		  {
 			testConfig.putRunTimeProperty("AlreadyFailed","yes");
 			Log.FailWarning("No tin with payments from the above query, please execute the test case manually",testConfig);
 		  }
 		

 		return tinNumbers.get("PROV_TAX_ID_NBR").toString();
 		 }
 		else 
 			return testConfig.getRunTimeProperty("provTinNo");
 		
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
	
	//amit - to be reviewed
	public String associateTinWithUser(String tin, int sqlRowNo,int insertQueryRowNo)
	{
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
 			sqlRowNo=32;//36; 
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
 	 		 
 		    case "medicalPayment":
 		    sqlRowNo=142;
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
		   try{
		   testConfig.putRunTimeProperty("provTinNo",displayConsNo.get("PROV_TAX_ID_NBR").toString());
		   }
		   catch(Exception e)
		   {
			   Log.Fail("Exception occured in setting Tin Number " + e);
		   }
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
		
	
	public String getQuickSearchFilterCriteria(String setlDate)
	{
		String filterCriteria="Last 30 days"; 
	    if (setlDate.compareTo(Helper.getDateBeforeOrAfterDays(-30,"yyyy-MM-dd")) >= 0 && setlDate.compareTo(Helper.getCurrentDate("yyyy-MM-dd")) < 0) 
		filterCriteria="Last 30 days";
	    
	    else if (setlDate.compareTo(Helper.getDateBeforeOrAfterDays(-60,"yyyy-MM-dd")) >= 0 && setlDate.compareTo(Helper.getDateBeforeOrAfterDays(-30,"yyyy-MM-dd")) < 0) 
		filterCriteria="Last 60 days";
		
	    else if (setlDate.compareTo(Helper.getDateBeforeOrAfterDays(-90,"yyyy-MM-dd")) >= 0 && setlDate.compareTo(Helper.getDateBeforeOrAfterDays(-60,"yyyy-MM-dd")) < 0)
		filterCriteria="Last 90 days";
		
	    else if (setlDate.compareTo(Helper.getStartAndEndPeriod("4-6").get("fromDate").toString()) >=0 && setlDate.compareTo(Helper.getStartAndEndPeriod("4-6").get("toDate").toString()) <=0) 
		filterCriteria="Last 4-6 months";
		
	    else if (setlDate.compareTo(Helper.getStartAndEndPeriod("6-9").get("fromDate").toString()) >=0 && setlDate.compareTo(Helper.getStartAndEndPeriod("6-9").get("toDate").toString()) <=0)
		filterCriteria="Last 6-9 months";
		
	    else if (setlDate.compareTo(Helper.getStartAndEndPeriod("9-13").get("fromDate").toString()) >=0 &&  setlDate.compareTo(Helper.getStartAndEndPeriod("9-13").get("toDate").toString()) <=0)
		filterCriteria="Last 9-13 months";
	    
	    paymentSummary pay=new paymentSummary(testConfig,"quickSearchDates");
	    pay.getQuickSearchDates(filterCriteria);
	
	    return filterCriteria;
	}
	
	
	public String getTinForStatus(String status) {
		int sqlRowNo=0;
		boolean tinFlag = false;
		switch(status) 
		{
		case "EnrolledActiveStatusTIN":
			sqlRowNo=111; 
			break;

		case "EnrolledPreEnrollmentStatusTIN":
			sqlRowNo=112; 
			break;

		case "AutoEnrolledPreEnrollmentStatusTIN":
			sqlRowNo=113; 
			break;

		case "EnrolledInactiveAndBlockStatusTIN":
			sqlRowNo=114; 
			break;
		
		case "TINNotEnrolled":
			tinFlag = true;
			break;
		
		case "InactiveUnBlockedTIN":
			sqlRowNo=115; 
			break;

		default:
			Log.Comment("Payment Type " + status + " not found");
		}
		if(tinFlag==true) {
			String tinNumber=Integer.toString(Helper.getUniqueTinNumber());	
			return tinNumber;
		}
		else {
		Log.Comment("Getting tin for  " + status);
		Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("Tin retreived from query for " + status + " is : " + tinNumbers.get("PROV_TIN_NBR").toString());
		testConfig.putRunTimeProperty("tin",tinNumbers.get("PROV_TIN_NBR").toString());
		return tinNumbers.get("PROV_TIN_NBR").toString();
		}
	}
	
	
public ArrayList getEnrollmentContent(String content) {
		
		int sqlRowNo=0;
		ArrayList<String> contentList = new ArrayList<String>();
		Map enrollmentContent;
		
		switch(content) 
		{
		case "EligibleTIN":
			sqlRowNo=116; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for EligibleTIN is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());			
			
		case "provideInformation":
			sqlRowNo=117; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for provideInformation is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			
		case "orgName":
			sqlRowNo=118; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for orgName is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			
		case "administrators":
			sqlRowNo=119; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for administrators is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			
		case "primaryContact":
			sqlRowNo=120; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for primaryContact is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			
		case "secondaryContact":
			sqlRowNo=121; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for secondaryContact is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			
		case "bankingInfo":
			sqlRowNo=122; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for bankingInfo is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			
		case "W-9":
			sqlRowNo=123; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for W-9 is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			break;
			
		default:
			Log.Comment("Enrollment Content not found");
		}
	
		return contentList;
		
	}

	public ArrayList getEnrollmentContentForActiveBSTIN(String content) {

		int sqlRowNo=0;
		ArrayList<String> contentList = new ArrayList<String>();
		Map enrollmentContent;

		switch(content) 
		{
		case "enrolledBSTIN":
			sqlRowNo=151; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for enrolledBSTIN is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());			

		case "enrolledActive":
			sqlRowNo=152; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for enrolledActive is : " + enrollmentContent.get("TEXT_VAL").toString());
			contentList.add(enrollmentContent.get("TEXT_VAL").toString());	
			break;

		default:
			Log.Comment("Enrollment Content not found");
		}

		return contentList;

}
	
	
	public String getEnrollmentContentForPendingEnrollmentBSTIN(String content) {

		int sqlRowNo=0;
		String value = "";
		Map enrollmentContent;

		switch(content) 
		{
		case "PendingEnrollmentBSTIN":
			sqlRowNo=153; 
			enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Log.Comment("Content retreived from query for PendingEnrollmentBSTIN is : " + enrollmentContent.get("TEXT_VAL").toString());
			value = enrollmentContent.get("TEXT_VAL").toString();		
			break;

		default:
			Log.Comment("Enrollment Content not found");
		}

		return value;

}
	
	
	public String getBSTinForStatus(String status) {
		int sqlRowNo=0;
		boolean tinFlag = false;
		switch(status) 
		{

		case "EnrolledActiveBSTIN":
			sqlRowNo=148; 
			break;
			
		case "PreEnrolledBSTIN":
			sqlRowNo=150; 
			break;	

		default:
			Log.Comment("Payment Type " + status + " not found");
		}

		Log.Comment("Getting tin for  " + status);
		Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("Tin retreived from query for " + status + " is : " + tinNumbers.get("IDENTIFIER_NBR").toString());
		testConfig.putRunTimeProperty("tin",tinNumbers.get("IDENTIFIER_NBR").toString());
		return tinNumbers.get("IDENTIFIER_NBR").toString();
	}
	
	public Map<String, String> getBSTinDetails()
	{
		int sqlRowNo=149;
		Map<String,String> bsTinDetails= new HashMap<String, String>();

		Map bsTin=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);

		if(bsTin.get("IDENTIFIER_NBR").toString()!=null)
		{
			bsTinDetails.put("BSTin", bsTin.get("IDENTIFIER_NBR").toString());
			bsTinDetails.put("BSName", bsTin.get("BS_NM").toString());
			bsTinDetails.put("BSAddress", bsTin.get("ADR_TXT").toString());
			bsTinDetails.put("BSStatus", bsTin.get("ENRL_STS_CD").toString());

			Log.Comment("Getting Payment Details : " + bsTinDetails);

			testConfig.putRunTimeProperty("BSTin", bsTin.get("IDENTIFIER_NBR").toString());
		}
		else
			Log.Warning("No result returned from query", testConfig);
		
		return bsTinDetails;
	}
	
	public ArrayList<String> getEnrollmentContentForTinNotEnrolledBs() throws IOException {
		
		int sqlRowNo=170;
		ArrayList<String> contentList = new ArrayList<String>();
		Map enrollmentContent;
		String orgText= null;
		String formText= null;
		HashMap<Integer, HashMap<String, String>> createEnroolment=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		for (int i = 1; i <= createEnroolment.size(); i++) {
			if(!createEnroolment.get(i).get("TEXT_VAL").equals("")) {
				 if(createEnroolment.get(i).get("TEXT_VAL").equals("If your organization does not have a completed W-9 form, please follow")) {
					 
					 orgText=createEnroolment.get(i).get("TEXT_VAL");
				 }
				 if(createEnroolment.get(i).get("TEXT_VAL").equals("to download a copy and complete the form.")) {
					 formText=createEnroolment.get(i).get("TEXT_VAL");
				 }
				 
				contentList.add(createEnroolment.get(i).get("TEXT_VAL"));
			}
		}
		
		contentList.add(orgText+" this link "+formText);
		sqlRowNo=117; 
		enrollmentContent = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String advisedText =enrollmentContent.get("TEXT_VAL").toString();
		Log.Comment("Content retreived from query for provideInformation is : " + advisedText);
		contentList.add(advisedText);
		
		return contentList;
		
	}
	
}
