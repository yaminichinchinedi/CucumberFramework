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
import main.java.pageObjects.ViewPayments;
import main.java.reporting.Log;

public class ViewPaymentsDataProvider {
	
	private TestBase testConfig;
	
	@FindBy(xpath = "//select[@id='taxIndNbrId']") WebElement tinDrpDwn;
	@FindBy(xpath = "//input[@name='billingProvTin']") WebElement bstinDrpDwn;
	@FindBy(xpath = "//input[@name='btnSearch']") WebElement submitBtn;
	
	Map dataRequiredForSearch;
	
	
	public ViewPaymentsDataProvider(TestBase testConfig) {
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		
	}
	
    public ViewPaymentsDataProvider() {
		
	}
	
	public String associateTinWithUser(String userType,String tin) 
	{ 		
		int sqlRowNo=0;
		int insertQueryRowNo=0;
		int insertPortalUserBSTIN=0;
		int isTinAssociated;
		testConfig.putRunTimeProperty("userType", userType);
		if(userType.equals("BS"))
		{
			sqlRowNo=62;
			insertQueryRowNo=61;
			insertPortalUserBSTIN=1511;
		}
		else if(userType.equals("PROV"))
		{ 
			sqlRowNo=28;
		    insertQueryRowNo=24;
		}
		
		else if(userType.equals("Payer") || userType.equals("PAY") || userType.equals("SUBPAYER"))
		{ 
			sqlRowNo=242;
		}
		
		testConfig.putRunTimeProperty("tin", tin);
		
		Map associatedTins = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		isTinAssociated=Integer.valueOf((String) associatedTins.get("TIN_COUNT"));
		if(isTinAssociated == 0) 
		 {
			testConfig.putRunTimeProperty("associationDone", "true");
		   DataBase.executeInsertQuery(testConfig, insertQueryRowNo);
		   if(userType.equals("BS"))
			   DataBase.executeInsertQuery(testConfig, insertPortalUserBSTIN);
		   Log.Comment("Associated tin " + tin + " with Logged in user");
		   testConfig.putRunTimeProperty("TobeDeleted", userType);
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
 		    sqlRowNo=250; 
 	 		break;
 	 			
 		    case "VCP":
 	 		sqlRowNo=251; 
 	 		break;
 	 		 
 		    case "medicalPayment":
 		    sqlRowNo=142;
 		    break;
 		    
 		    case "NON":
 		    sqlRowNo=250; 
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
		   testConfig.putRunTimeProperty("tin",displayConsNo.get("PROV_TAX_ID_NBR").toString());
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
	    
	    ViewPayments pay=new ViewPayments(testConfig,"quickSearchDates");
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
	
	public String getTinForSearchCriteria(String searchCriteria,String tinType,String portalAccess )
	{
		int sqlRowNo=0;
		String payType="";
		
		String env = "";
		String id = "";
		
		testConfig.putRunTimeProperty("tinType", tinType);
		testConfig.putRunTimeProperty("portalAccess", portalAccess);
		testConfig.putRunTimeProperty("prdctSelected",portalAccess);
		ViewPayments paySum=new ViewPayments(testConfig,"filter");
 		switch(searchCriteria)
 		 {
 		    case "failedPayment": 
 			sqlRowNo=29;
 		 	break;
 		
 		   case "NPI": 
 	 			sqlRowNo=249;
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
 	 	 		
 		  case "EPRAViewPay":
	 	 		sqlRowNo=220;
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
 			 sqlRowNo=431;
 			 break;
 		case "byElectronicPaymentNoRemit":
			 sqlRowNo=1901;
			 break;
 			 
 			 
 		 case "byDOP":
 		 case "byDOPAndAccountNo":
 		 case "byDOP&SubscriberID":
 		 case "byDOPAndNpi":
 		 case "byDOPAndClaimNo":
 		 case "byDOPAndPatientNm":	 
			 sqlRowNo=430;
			 break;
			 
 		 case "byDOPAndZeroPaymentClaims":
 			sqlRowNo=47;
 			break;
 			
  		case "byDOSAndZeroPmntClms":
  			//sqlRowNo=251;
  			sqlRowNo=243;
 			break;
 			
 		 case "byDOSAndSubscriberId":
 			 sqlRowNo=432;
 			 break;
 			 
 		 case "byDOS":
 		 case "byDOSAndAcntNo":
 			 sqlRowNo=429;
 			 break;
 			 
 		 case "byDOSAndNpi":
 			 sqlRowNo=434;
 			 //sqlRowNo=253;
 			 break;

 		 case "byDOSAndClmNo":
 		 case "byDOSAndPtntNm":
 			 sqlRowNo=429;
 			 break;
 			 
 		 case "byDOSAndMarketType":
 			 //sqlRowNo=254;
 			 sqlRowNo=246;
 			 break;
 			 

		 case "NON":
	 		 sqlRowNo=35; 
	 		 break;
		 case "NPI_SingleTIN":
	 		 sqlRowNo=408; 
	 		 break;
		 case "NPI_MultipleTIN":
	 		 sqlRowNo=409; 
	 		 break;
			 
		    case "PatientPayment":
			sqlRowNo=417; 
	 		break;
	 			
	 			
           case "EPRA":
			 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     testConfig.putRunTimeProperty("id", id);
		     System.setProperty("id", id);
		      sqlRowNo=204;
	 			break;		

		 case "EPRAgenerated":
    	 env=System.getProperty("env");
		     Browser.wait(testConfig, 5);
		     id = testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+"PROV_Admin"+"_"+env);
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
				sqlRowNo=205;
				break;
				
         case "EPRAPROVAdmin":

		      sqlRowNo=204;
	 			break;	
	 			
         case "EPRAgeneratedPROVAdmin":
			 sqlRowNo=205;
			 break;	
		
         case "EPRAPROVGen":		 

				sqlRowNo=204;
				break;	
				
         case "EPRAgeneratedPROVGen":

				sqlRowNo=205;
				break;			
		
         case "EPRAPayerAdmin": 
           sqlRowNo=210;
	 			break;	
	 			
         case "EPRAPayerGen":

		      sqlRowNo=212;
	 			break;	
	 			
         case "EPRAPayergeneratedAdmin": 
				sqlRowNo=217;
				break;	
				
		 case "EPRAPayergeneratedGen": 
				sqlRowNo=217;
				break;	
  	 			
		 case "EPRABSAdmin":
			  sqlRowNo=218;
		 	break;	
		 				
           case "EPRABSGen":
  		      sqlRowNo=218;
  	 			break;	
          				
           case "EPRAgeneratedBSAdmin":
  		       sqlRowNo=219;
  	 		 	break;
           case "EPRAgeneratedBSGen":	 
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
		     System.setProperty("id", id);
		     testConfig.putRunTimeProperty("id", id);
		      sqlRowNo=204;
	 			break;	
	 			
 		case "byElectronicPaymentForVCP":
 			testConfig.putRunTimeProperty("type","VCP");
 			sqlRowNo=52;
 			break;

 		 case "byElectronicPaymenForACH":
 		 case "selectTin":
 			 testConfig.putRunTimeProperty("type","ACH");
 			 sqlRowNo=56;
 			 break;
 			 
 		case "byDOPAndRenderingProvider":
 			sqlRowNo=70;
			 break;

 		case "byCheckNoOfReoriginNacha":
 			sqlRowNo=247;
 			break;
 			
 		case "byCheckNoOfConslPayDtl":
 			sqlRowNo=248;
 			break;

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
		
		case "generalPaymentForNPI_6-9months"+"Premium":
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
			 sqlRowNo=1611; 
	 		 break;
		}
		
		case "generalPayment90Days":
		{ 
			paySum.getQuickSearchDates("Last 90 days");
 	 		sqlRowNo=143; 
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
			  sqlRowNo=1611; 
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
	 	    
		case "byDOPAndMarketType":
		{
			sqlRowNo=249;
			break;
		}  
	 	    
		case "RemitDetail_ProvGen":
	 	  {
		      sqlRowNo=211;
	 		  break;
	 	  }
	 	  
		case "RemitDetail_ProvAdmin":
	 	  {

		      sqlRowNo=211;
	 		  break;
	 	  }
	 	  
		case "RemitDetail":
	 	  {

		      sqlRowNo=211;
	 			break;
	 	  }
	 	  
		case "RemitDetail_BSAdmin":
	 	  {  
		      sqlRowNo=211;
	 		  break;
	 	  }
	 	  
		case "RemitDetail_BSGen":
	 	  {

		      sqlRowNo=211;
	 		  break;
	 	  }
	 	  
		case "Provider_Admin":
		{
		      sqlRowNo=211;
	 			break;
	 	}
		
		case "Provider_Gen":
		{

		     sqlRowNo=211;
	 			break;
	 	}
		
		
		case "BS_Admin":
		{
			 sqlRowNo = 211;
			break;
		}
		
		
		case "BS_Gen":
		{
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
		     sqlRowNo = 213;
   			 
   		     break;
		}
		
		case "Payer_Gen":
		{
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
		
		case "EPRAElectronicPaymentNo":
		{
			sqlRowNo = 204;
			break;
		}
		
		
		case "Multiple_PLB":
		{
			break;
		}	
		
		case "Multiple_PLB_ProvAdmin":
		{
          sqlRowNo = 1904;
			 break;
		}	
		
		case "Multiple_PLB_ProvGen":
		{
			 sqlRowNo = 222;
			 break;
		}	
		
		case "Multiple_PLB_BSAdmin":
		{
		     sqlRowNo = 1907;
			 break;
		}	
		
		case "Multiple_PLB_BSGen":
		{
			 sqlRowNo = 222;
			 break;
		}	
		
		case "PLB Adj Only":
		{
			sqlRowNo = 188;
			break;
		}	
		
		case "PLB_Adj_Only_ProvAdmin":
		{
		     sqlRowNo = 1905;
			 break;
		}	
		
		case "PLB_Adj_Only_ProvGen":
		{
			 sqlRowNo = 222;
			 break;
		}	
		
		case "PLB_Adj_Only_BSAdmin":
		{
        sqlRowNo = 1908;
			 break;
		}	
		
		case "PLB_Adj_Only_Pay_Admin":
		{
             sqlRowNo = 212;
			 Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		     String payerSchema2 = payerSchema1.toString();
	   		 String schema = (payerSchema2.substring(payerSchema2.indexOf("=")+1, payerSchema2.length()-1)).trim();
		     testConfig.putRunTimeProperty("schema",schema);
		     sqlRowNo = 214;
			break;
		}	
		case "PLB_Adj_Only_Pay_Gen":
		{
		     sqlRowNo = 212;
		     Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		     String payerSchema2 = payerSchema1.toString();
	   		 String schema = (payerSchema2.substring(payerSchema2.indexOf("=")+1, payerSchema2.length()-1)).trim();
		     testConfig.putRunTimeProperty("schema",schema);
		     sqlRowNo = 214;
			break;
		}	
		
		case "byElectronicPaymentNoRemitBS":
		{
			 sqlRowNo = 1906;
			 break;
		}	
		
			case "EPRABSViewPay":
		{
			sqlRowNo = 218;
			break;	
		}
		
			case "TinWithLessThnMaxUsr":
				sqlRowNo=1503;
				break;
				
			case "TinWithMoreThnMaxUsr":
				sqlRowNo=1504;
				break;
				
			case "generalStandardTin":
			sqlRowNo=225;
			break;
			
			case "generalPremiumTin":
				sqlRowNo=226;
				break;
				
			case "Last 30 days":
//				sqlRowNo=1617;
//				break;
				paySum.getQuickSearchDates("Last 30 days");
				sqlRowNo=1611;
				break;
			case "Last 60 days":
				paySum.getQuickSearchDates("Last 60 days");
				sqlRowNo=1611;
				break;
			case "Last 90 days":
				paySum.getQuickSearchDates("Last 90 days");
				sqlRowNo=1611;
				break;
			case "Last 4-6 months":
				paySum.getQuickSearchDates("Last 4-6 months");
				sqlRowNo=1611;
				break;
			case "Last 6-9 months":
				paySum.getQuickSearchDates("Last 6-9 months");
				sqlRowNo=1611;
				break;
			case "Last 9-13 months":
				paySum.getQuickSearchDates("Last 9-13 months");
				sqlRowNo=1611;
				break;
			case "LegacyOrPremiOrStandard_AO_Standard":	
			case "LegacyOrPremiOrStandard":
				sqlRowNo=1605;
				break;	
			case "TinWthatlstOnePayNum":
				sqlRowNo=1610;
				break;
			case "TinWthAccuredFeeStat":
				sqlRowNo=1615;
				break;	
			case "TinDuringOrPostTrial":
				sqlRowNo=1343;
//			case "TINwithTimeperiod":
//				sqlRowNo=1617;	
				break;	
			case "PremiumOrStandardTIN":	
				sqlRowNo=1605;
				break;
				
			case "PremiumOrStandardFeeInvoice":
				sqlRowNo=2009;
				break;
			
 		
			case "ActiveBSTin":
			    sqlRowNo=16;
			    break;

			case "TinWithInvoices":
                sqlRowNo=1513;
                break;
            case "TinWithoutInvoices":
                sqlRowNo=1514;
                break;
                
 		   default:
 			   Log.Comment("Payment Type " + searchCriteria + " not found");
 		
 		}
 		if(searchCriteria.equals("TinWithNoCustomFeeRate")) {
 			sqlRowNo=2000;
 		}
 		if(searchCriteria.contains("PPRARecord"))
 			sqlRowNo=1624;	
 	 			
 		if( (searchCriteria.contains("WithinTrial and NotPaid"))||
 			(searchCriteria.contains("WithinTrial and Paid")) ||
 			(searchCriteria.contains("PostTrial and NotPaid"))||
 			(searchCriteria.contains("PostTrial and Paid"))
 			
 				)
 			
 		{
 			if (searchCriteria.contains("WithinTrial and NotPaid")&& !tinType.equals("VO"))
 				{
 				testConfig.putRunTimeProperty("portalAcs", "Standard");
 				testConfig.putRunTimeProperty("portalStat", "PD");
 				sqlRowNo=1620;
 				}
 			if (searchCriteria.contains("WithinTrial and Paid")&& !tinType.equals("VO"))
				{
			testConfig.putRunTimeProperty("portalAcs", "Premium");
			testConfig.putRunTimeProperty("portalStat", "PS");
			sqlRowNo=1620;
				}
 			if (searchCriteria.contains("PostTrial and NotPaid") && !tinType.equals("VO"))
				{
				testConfig.putRunTimeProperty("portalAcs", "Standard");
				testConfig.putRunTimeProperty("portalStat", "PD");
				sqlRowNo=1622;
				}
			if (searchCriteria.contains("PostTrial and Paid") || tinType.equals("VO"))
			{
				testConfig.putRunTimeProperty("portalAcs", "Premium");
				testConfig.putRunTimeProperty("portalStat", "PS");
				sqlRowNo=1622;
			}
 				
 		}

 		if (searchCriteria.contains("PastdueFee"))
		{
 			if(searchCriteria.equalsIgnoreCase("zeroPastdueFee"))
 				testConfig.putRunTimeProperty("invcAmt", "=0");
 				else if(searchCriteria.equalsIgnoreCase("positivePastdueFee"))
 				testConfig.putRunTimeProperty("invcAmt", ">0");
			sqlRowNo=1629;
		}
       if (searchCriteria.contains("AccuredFee"))
			{
	 			if(searchCriteria.equalsIgnoreCase("withAccuredFee"))
	 				testConfig.putRunTimeProperty("nullStatus", "is not null");
	 				else if(searchCriteria.equalsIgnoreCase("withoutAccuredFee"))
	 				testConfig.putRunTimeProperty("nullStatus", "is null");
				sqlRowNo=1615;
			}

 		if(!payType.equalsIgnoreCase("medicalPayment"))
		 { 
		   Log.Comment("Getting tin for  " + searchCriteria);
		   Map tinNumbers = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		   
		    try
		     {
		       Log.Comment("Tin retreived from query for " + searchCriteria + " is : " + tinNumbers.get("PROV_TAX_ID_NBR").toString());
		       testConfig.putRunTimeProperty("tin",tinNumbers.get("PROV_TAX_ID_NBR").toString());
		       
		       if(sqlRowNo==1611)
		       {
		    	   testConfig.putRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER",tinNumbers.get("DSPL_CONSL_PAY_NBR").toString());
		    	   testConfig.putRunTimeProperty("CONSL_PAY_NBR",tinNumbers.get("CONSL_PAY_NBR").toString());
				   testConfig.putRunTimeProperty("setl_dt",tinNumbers.get("SETL_DT").toString());
			   }
				if(sqlRowNo==1617)
                   {
		    	   testConfig.putRunTimeProperty("PAYR_SCHM_NM",tinNumbers.get("PAYR_SCHM_NM").toString().trim());
		    	   testConfig.putRunTimeProperty("CONSL_PAY_NBR",tinNumbers.get("CONSL_PAY_NBR").toString());
		    	   testConfig.putRunTimeProperty("CLAIMCOUNT",tinNumbers.get("CLAIMCOUNT").toString());

		    	   if(Integer.parseInt(tinNumbers.get("CLAIMCOUNT").toString())< 75)
		    	   	{
		    	   		testConfig.putRunTimeProperty("PRIORITY","1");
		    	   	}
		    	   else
		    	   {
		    	   		testConfig.putRunTimeProperty("PRIORITY","2");

		    	   }
		    	   		
		    	   testConfig.putRunTimeProperty("PORTAL_USER_ID",tinNumbers.get("PORTAL_USER_ID").toString());
		    	   testConfig.putRunTimeProperty("SETL_DT",tinNumbers.get("SETL_DT").toString());
                   testConfig.putRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER",tinNumbers.get("DSPL_CONSL_PAY_NBR").toString());
                   	}
		       if(sqlRowNo==1624)
		       {
		    	   testConfig.putRunTimeProperty("dsp_consl_pay_nbr",tinNumbers.get("DSPL_CONSL_PAY_NBR").toString());
		       		testConfig.putRunTimeProperty("consl_pay_nbr",tinNumbers.get("CONSL_PAY_NBR").toString());
		       }
		       if(searchCriteria.contains("byDOS"))
		       {
		    	 if(tinNumbers.get("CLM_STRT_DT")!=null)
		    	  {
		    	    testConfig.putRunTimeProperty("fromDate",tinNumbers.get("CLM_STRT_DT").toString());
		    	    testConfig.putRunTimeProperty("toDate",tinNumbers.get("CLM_END_DT").toString());
		    	  }
		    	
		    	 if(searchCriteria.equalsIgnoreCase("byDOSAndSubscriberId"))
		    	 {
		    		testConfig.putRunTimeProperty("key", "SUBSCRIBER_IDENTIFIER");
			    	testConfig.putRunTimeProperty("value", tinNumbers.get("SBSCR_ID").toString());
		    	 }
		    	
		    	//claim and dos
		    	else if (searchCriteria.equalsIgnoreCase("byDOSAndClmNo"))
		    	{
		    		testConfig.putRunTimeProperty("key", "CLAIM_IDENTIFIER");
			    	testConfig.putRunTimeProperty("value", tinNumbers.get("CLM_NBR").toString());
		    	} 
		    	
		    	else if (searchCriteria.equalsIgnoreCase("byDOSAndPtntNm"))
		    	{
		    		testConfig.putRunTimeProperty("key", "PATIENT_FIRST_NAME");
			    	testConfig.putRunTimeProperty("value", tinNumbers.get("PTNT_FST_NM").toString());
			    	testConfig.putRunTimeProperty("key1", "PATIENT_LAST_NAME");
			    	testConfig.putRunTimeProperty("value1", tinNumbers.get("PTNT_LST_NM").toString());
		    	}
		    	
		    	else if (searchCriteria.equalsIgnoreCase("byDOSAndZeroPmntClms"))
		    	{
		    		testConfig.putRunTimeProperty("key", "ZERO_PAYMENT_CLAIMS");
			    	testConfig.putRunTimeProperty("value", "Y");
		    	}
		    	 
		    	else if (searchCriteria.equalsIgnoreCase("byDOSAndMarketType"))
		    	{
		    		testConfig.putRunTimeProperty("key","MARKET_TYPE");
			    	testConfig.putRunTimeProperty("value",tinNumbers.get("PAYMENT_TYPE_INDICATOR").toString());
		         }
		    	 
		    	else if (searchCriteria.equalsIgnoreCase("byDOSAndAcntNo"))
		    	{
		    		testConfig.putRunTimeProperty("key", "ACCOUNT_NUMBER");
		    		testConfig.putRunTimeProperty("value", tinNumbers.get("PTNT_ACCT_NBR").toString());
		    	}
		    	 
		    	else if (searchCriteria.equalsIgnoreCase("byDOSAndNpi"))
		    	{
		    		testConfig.putRunTimeProperty("NPI", tinNumbers.get("PROV_NPI_NBR").toString());
		    	}
		    }
		     else if(searchCriteria.equalsIgnoreCase("byDOPAndZeroPaymentClaims"))
		     {
		    	testConfig.putRunTimeProperty("fromDate",tinNumbers.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate",tinNumbers.get("SETL_DT").toString());
		     }
		       
		       
		     else if(searchCriteria.equalsIgnoreCase("EPRAPROVAdmin")||searchCriteria.equalsIgnoreCase("EPRAPROVGen")
		    		 ||searchCriteria.equalsIgnoreCase("EPRAgeneratedPROVAdmin")||searchCriteria.equalsIgnoreCase("EPRAgeneratedPROVGen")
		    		 ||searchCriteria.equalsIgnoreCase("EPRABSAdmin")||searchCriteria.equalsIgnoreCase("EPRAgeneratedBSAdmin")||searchCriteria.equalsIgnoreCase("EPRAPayerAdmin")
		    		 ||searchCriteria.equalsIgnoreCase("EPRAPayerGen")||searchCriteria.equalsIgnoreCase("EPRAPayergeneratedAdmin")||searchCriteria.equalsIgnoreCase("EPRAPayergeneratedGen")
		    		 ||searchCriteria.equalsIgnoreCase("EPRA")||searchCriteria.equalsIgnoreCase("EPRAgenerated"))
			 {

				  testConfig.putRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER",tinNumbers.get("DSPL_CONSL_PAY_NBR").toString());
				  testConfig.putRunTimeProperty("CONSL_PAY_NBR",tinNumbers.get("CONSL_PAY_NBR").toString());
			      System.setProperty("tin", tinNumbers.get("PROV_TAX_ID_NBR").toString());
				  System.setProperty("npi", tinNumbers.get("PROV_NPI_NBR").toString());
				  System.setProperty("ELECTRONIC_PAYMENT_NUMBER", tinNumbers.get("DSPL_CONSL_PAY_NBR").toString());
				  System.setProperty("fromDate", tinNumbers.get("SETL_DT").toString());
				  System.setProperty("toDate", tinNumbers.get("SETL_DT").toString());
				  System.setProperty("CONSL_PAY_NBR", tinNumbers.get("CONSL_PAY_NBR").toString());
				  System.setProperty("ptnt_acct_nbr", tinNumbers.get("PTNT_ACCT_NBR").toString());
				  System.setProperty("sbscr_id", tinNumbers.get("SBSCR_ID").toString());
				  System.setProperty("clm_nbr", tinNumbers.get("CLM_NBR").toString());
				  System.setProperty("ptnt_fst_nm", tinNumbers.get("PTNT_FST_NM").toString());
				  System.setProperty("ptnt_lst_nm", tinNumbers.get("PTNT_LST_NM").toString());
				  System.setProperty("lst_nm", tinNumbers.get("LST_NM").toString());

					 
			  }
		    
		    else if(searchCriteria.equalsIgnoreCase("byCheckNoOfReoriginNacha")||searchCriteria.equalsIgnoreCase("byCheckNoOfConslPayDtl"))
		    {
			  testConfig.putRunTimeProperty("key", "CHECK_NUMBER");
		      testConfig.putRunTimeProperty("value", tinNumbers.get("CHECK_NBR").toString());
		    }
		       
		   else if(searchCriteria.equalsIgnoreCase("byDOPAndMarketType"))
		     {
		    	testConfig.putRunTimeProperty("fromDate",tinNumbers.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate",tinNumbers.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("key","MARKET_TYPE");
		    	testConfig.putRunTimeProperty("value",tinNumbers.get("PAYMENT_TYPE_INDICATOR").toString());
		     }
		       
		  else if(searchCriteria.equalsIgnoreCase("byDOPAndRenderingProvider"))
		  {
			 testConfig.putRunTimeProperty("fromDate",tinNumbers.get("SETL_DT").toString());
		     testConfig.putRunTimeProperty("toDate",tinNumbers.get("SETL_DT").toString());
		     testConfig.putRunTimeProperty("key", "RENDERING_PROVIDER_IDENTIFIER");
		     testConfig.putRunTimeProperty("value", tinNumbers.get("LST_NM").toString());
		  }
		       
		  else if (searchCriteria.equalsIgnoreCase("Multiple_PLB_ProvAdmin")||searchCriteria.equalsIgnoreCase("PLB_Adj_Only_ProvAdmin")||searchCriteria.equalsIgnoreCase("byElectronicPaymentNoRemitBS")
				  ||searchCriteria.equalsIgnoreCase("Multiple_PLB_BSAdmin")||searchCriteria.equalsIgnoreCase("PLB_Adj_Only_BSAdmin"))
		  {
			  testConfig.putRunTimeProperty("elctronicNum", tinNumbers.get("CP_DSPL_CONSL_PAY_NBR").toString());
			  System.setProperty("consl_pay_nbr", tinNumbers.get("UCP_CONSL_PAY_NBR").toString());
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
}