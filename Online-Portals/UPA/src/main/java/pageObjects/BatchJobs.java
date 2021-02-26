//package main.java.pageObjects;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import main.java.Utils.BatchUtilities;
//import main.java.Utils.DataBase;
//import main.java.nativeFunctions.TestBase;
//import main.java.reporting.Log;
//
//import org.openqa.selenium.support.PageFactory;
//import org.seleniumhq.jetty9.server.session.DatabaseAdaptor;
//
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.SftpException;
//
//public class BatchJobs{
//	
//	
//	//=======================================================================================================================================
//	//Test Scenario Name: fun_Batch1002_file835_ExistanceCheck
//	//Status :In-Progress*
//	//Review : Yet to review
//	//Designed by :Sahil D Sharma
//	//=======================================================================================================================================
//
//	
//	private TestBase testConfig;
//	public BatchUtilities batchUtility;
//	
//	
//	public BatchJobs(TestBase testConfig) {
//		this.testConfig = testConfig;
//		PageFactory.initElements(testConfig.driver, this);
//	}
//	
//	public boolean fun_Batch1002_file835_ExistanceCheck_multiple() throws ClassNotFoundException, SQLException, IOException, JSchException, SftpException, InterruptedException 
//	{
//    	boolean status = true;
//		String fValue="";
//		try {
//			
//		String f1 ="/pps/"+testConfig.getRunTimeProperty("Env")+"/ftp/CE835IN";
//		String totalinputrecords = testConfig.getRunTimeProperty("totalrecords");
//		System.out.println("number of records: "+totalinputrecords );
//		int inputrecords = Integer.parseInt(totalinputrecords);
//		int i;
//		
//		for( i=0; i<inputrecords; i++)
//		{ 
//			String str835FileName = batchUtility.funGetPropertyValue("str835FileName["+i+"]");	
//			String strSubFileName = str835FileName.substring(str835FileName.length()-3, str835FileName.length());
//			str835FileName=str835FileName.replace(strSubFileName,"");
//			
//		 	
//			System.out.println(" PRE Path update :::::::::::::::::::::::::::" + f1);
//				
//			String CurrentFileName=batchUtility.funFindFileRemoteServer(f1,str835FileName);
//			fValue =f1+"/"+CurrentFileName;
//			
//			boolean blnCheckFile=batchUtility.funwaitThenCheckFileExistsOnServerByTime(fValue,30);
//			
//			if(blnCheckFile)
//				Log.Pass("TEST PASSED : 835 File moved to the folder as expected:::"+fValue);
//			else 
//				Log.Fail("TEST FAILED : 835 File NOT moved to the folder as expected::::"+fValue);
//		}
//	}
//			
//		catch(Exception e) 
//		{
//			Log.Fail("TEST FAILED : 835 File NOT moved to the folder as expected::::"+fValue);
//		}
//		return status;
//	}
//
//	
//	
//	
//    
//  //Function will validate Accounts Payable [AP] file, Argument: AP output file File path & Input file path
//    public boolean funValidateAPFile(String fValue) throws ClassNotFoundException, SQLException, JSchException, SftpException, IOException
//    {
//    	   int sqlRow=53;
//           
//    	   boolean blnFunResult = true;
//           
//    	   String[] inputData = fValue.split("#");
//           String strAPFIlePath = inputData[0]; 
//           String strInputFIlePath = inputData[1];
//           String[] fileComps = strInputFIlePath.split("/");
//           String[] fileNameComps = fileComps[fileComps.length-1].split("_");
//           String flPayerName = fileNameComps[0];
//           
//           String[] strAPFileContent=batchUtility.funGetFileContentRemoteServer(strAPFIlePath).split(System.lineSeparator());
//           String[] strIPFileContent=batchUtility.funGetFileContentRemoteServer(strInputFIlePath).replace("\r\n", "").split("~");
//           String headerInfo=batchUtility.funGetLinesFromFile(strAPFIlePath, "1");
//           String trailerInfo=batchUtility.funGetLinesFromFile(strAPFIlePath, "9");
//           String[] detailInfo=batchUtility.funGetLinesFromFile(strAPFIlePath, "6").split(System.lineSeparator());
//           
//           //Header record validation
//          
//           if(headerInfo!=null)
//                 System.out.println("Header record found");
//           else
//                 blnFunResult = false;
//           
//           if(headerInfo.substring(0, 2).equals("10")) 
//                 Log.Pass("Header Record Type validated successfully");
//           else
//        	   Log.FailWarning("Header Record Type validated successfully");
//           
//           if(headerInfo.substring(18, 38).trim().equals("ACCOUNTS PAYABLE"))
//        	   Log.Pass("Header Discretionary Data validated successfully");
//           else
//           {
//                 blnFunResult = false;
//                 Log.FailWarning("Incorrect Header Discretionary Data");
//           }
//           if(headerInfo.length()==202)
//        	   Log.Pass("Length of Header validated successfully");
//           else
//                 blnFunResult = false;
//           
//           //Detail records validation
//            
//           ArrayList<String> strTRNs = new ArrayList<String>();
//           for(int i=0; i<strIPFileContent.length-1; i++)
//            {
//              if(strIPFileContent[i].substring(0, 3).equals("TRN"))
//                 strTRNs.add(strIPFileContent[i]);
//             }
//             
//                 
//           String[] unConsolNums = new String[strTRNs.size()];
//           
//           for(int i=0; i<strTRNs.size(); i++)
//           {
////               unConsolNums[i] = strTRNs[i].substring(6,17);
//                 String[] trnComps = strTRNs.get(i).split("\\*");
//                 unConsolNums[i] = trnComps[2];
//           }
//          
//           for(String unConsolNBR: unConsolNums)
//           {
//                 String validateRecord = "";
//                 for(String detailRecord: detailInfo)
//                 {
//                        if(detailRecord.contains(unConsolNBR))
//                        {
//                               validateRecord = detailRecord;
//                               break;
//                        }
//                 }
//                 String strPayr835Id =validateRecord.substring(6,11);
//                 testConfig.putRunTimeProperty("strPayr835Id", strPayr835Id);
//                 Log.Comment("Validating Unconsol Pay Number: "+unConsolNBR);
//                 testConfig.putRunTimeProperty("unConsolNBR", unConsolNBR);
//                 
//                 HashMap<Integer, HashMap<String, String>> payerTbl=DataBase.executeSelectQueryALL(testConfig, sqlRow);
//                 
//  
//                 String strTblScheema;
//                 sqlRow=54;
//                 
//                 for(int i=0; i<payerTbl.size(); i++)
//                 {
//                    System.out.println(payerTbl.get(i).get(0));
//                    strTblScheema=payerTbl.get(i).get(0).trim();
//                    testConfig.putRunTimeProperty("strTblScheema", strTblScheema);
//                        
//                    Map result=DataBase.executeSelectQuery(testConfig,sqlRow,1);
//                    if(result.get("record_count").equals("0"))
//                  
//                               strTblScheema = listScheema.get(i).get(0);
//                               break;
//                        }
//                        
//                 }
//                 if(validateRecord.substring(0, 2).equals("65"))
//                 {
//                        System.out.println("Detail Record Type validated successfully");
//                        writeLog("Detail Record Type validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Detail Record Type",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strPayerID = funGetColumnValue("select * from "+strTblScheema+".PAYOR p, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and p.PAYR_KEY_ID=u.PAYR_KEY_ID order by u.PROC_DTTM desc fetch first 1 rows only", "SEC_PAYR_ID");
//                 if(validateRecord.substring(2, 11).trim().replace("0", "").equals(strPayerID))
//                 {
//                        System.out.println("Payer ID validated successfully");
//                        writeLog("Payer ID validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Payer ID",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strPayerAdditionalID = funGetColumnValue("select * from "+strTblScheema+".PAYOR p, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and p.PAYR_KEY_ID=u.PAYR_KEY_ID order by u.PROC_DTTM desc fetch first 1 rows only", "PRI_PAYR_ID");
//                 if(strPayerAdditionalID.contains(validateRecord.substring(11, 20).trim()))
//                 {
//                        System.out.println("Payer Additional ID validated successfully");
//                        writeLog("Payer Additional ID validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Payer Additional ID",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strProviderTIN = funGetColumnValue("select * from "+strTblScheema+".PROVIDER p, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and p.PROV_KEY_ID=u.PROV_KEY_ID order by u.PROC_DTTM desc fetch first 1 rows only", "PROV_TAX_ID_NBR");
//                 if(validateRecord.substring(30, 39).trim().equals(strProviderTIN))
//                 {
//                        System.out.println("Provider TIN validated successfully");
//                        writeLog("Provider TIN validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Provider TIN",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 if(validateRecord.substring(39, 65).trim().equals(unConsolNBR))
//                 {
//                        System.out.println("Unconsolidated Payment Number validated successfully");
//                        writeLog("Unconsolidated Payment Number validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Unconsolidated Payment Number",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strUnconsolPayAmt = funGetColumnValue("Select * from "+strTblScheema+".UNCONSOLIDATED_PAYMENT where UCONSL_PAY_NBR = '"+unConsolNBR+"'", "PAY_AMT");
//                 long expUnconsolPayAmt = Long.valueOf(strUnconsolPayAmt.replace(".", ""));
//                 String strFlPayAmt=validateRecord.substring(65,75).trim();
//                 if(strFlPayAmt.equals("")){
//                 strFlPayAmt="0";
//                 }
//                 long actUnconsolPayAmt = Long.valueOf(strFlPayAmt);
//                 
//                 if(expUnconsolPayAmt==actUnconsolPayAmt)
//                 {
//                        System.out.println("Unconsolidated Payment Amount validated successfully");
//                        writeLog("Unconsolidated Payment Amount validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Unconsolidated Payment Amount",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strDspConsolPayNbr = funGetColumnValue("select * from "+strTblScheema+".CONSOLIDATED_PAYMENT c, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and c.PROV_KEY_ID=u.PROV_KEY_ID  order by c.PROC_DTTM desc fetch first 1 rows only", "DSPL_CONSL_PAY_NBR");
//                 if(validateRecord.substring(75, 100).trim().equals(strDspConsolPayNbr))
//                 {
//                        System.out.println("Consolidated Payment Number validated successfully");
//                        writeLog("Consolidated Payment Number validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Consolidated Payment Number",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strConsolAmt = funGetColumnValue("select * from "+strTblScheema+".CONSOLIDATED_PAYMENT c, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and c.PROV_KEY_ID=u.PROV_KEY_ID  order by c.PROC_DTTM desc fetch first 1 rows only", "CONSL_AMT");
//                 long expConsolAmt = Long.valueOf(strConsolAmt.replace(".", ""));
//                 long actConsolAmt = Long.valueOf(validateRecord.substring(100,110));
//                 if(expConsolAmt==actConsolAmt)
//                 {
//                        System.out.println("Consolidated Payment Amount validated successfully");
//                        writeLog("Consolidated Payment Amount validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Consolidated Payment Amount",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strOriginalPaymentMethod = funGetColumnValue("select * from "+strTblScheema+".CONSOLIDATED_PAYMENT c, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and c.PROV_KEY_ID=u.PROV_KEY_ID  order by c.PROC_DTTM desc fetch first 1 rows only", "PAY_METH_CD");
//                 if(validateRecord.substring(110, 113).trim().equals(strOriginalPaymentMethod))
//                 {
//                        System.out.println("Original Payment Method validated successfully");
//                        writeLog("Original Payment Method validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Original Payment Method",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strProvNm = funGetColumnValue("select * from "+strTblScheema+".PROVIDER p, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and p.PROV_KEY_ID=u.PROV_KEY_ID order by u.PROC_DTTM desc fetch first 1 rows only","PROV_NM");
//                if(validateRecord.substring(113, 173).trim().equals(strProvNm.trim()))
//                 {
//                        System.out.println("Payee Name validated successfully");
//                        writeLog("Payee Name validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Payee Name",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 
//                 String strOriginalPaymentDate = funGetColumnValue("select * from "+strTblScheema+".CONSOLIDATED_PAYMENT c, "+strTblScheema+".UNCONSOLIDATED_PAYMENT u where u.UCONSL_PAY_NBR = '"+unConsolNBR+"' and c.PROV_KEY_ID=u.PROV_KEY_ID order by c.PROC_DTTM desc fetch first 1 rows only", "SETL_DT").replace("-", "");
//                 if(validateRecord.substring(173, 181).trim().equals(strOriginalPaymentDate))
//                 {
//                        System.out.println("Original Payment Date validated successfully");
//                        writeLog("Original Payment Date validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//                 else
//                 {
//                        blnFunResult = false;
//                        System.out.println("Incorrect Detail Record Type validated successfully");
//                        writeLog("Incorrect Original Payment Date",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//                 }
//           }
//           
//           
//           //Trailer record validation
//           
//           if(trailerInfo!=null)
//                 System.out.println("Trailer record found");
//           else
//                 blnFunResult = false;
//           
//           if(trailerInfo.substring(0, 2).equals("90"))
//           {
//                 System.out.println("Trailer Record Type validated successfully");
//                 writeLog("Trailer Record Type validated successfully",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//           }
//           else
//           {
//                 blnFunResult = false;
//                 System.out.println("Incorrect Detail Record Type validated successfully");
//                 writeLog("Incorrect Trailer Record Type",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//           }
//           
//           long totalRecords = strAPFileContent.length;
//           
//           long totalDetailRecords = detailInfo.length;
//           
//           long totalRecordsFile = Long.valueOf(trailerInfo.substring(2, 12));
//           long totalDetailRecordsFile = Long.valueOf(trailerInfo.substring(12, 22));
//           
//           if(totalRecords==totalRecordsFile)
//           {
//                 System.out.println("Validated Total number of records in file");
//                 writeLog("Validated Total number of records in file",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//           }
//           else
//           {
//                 blnFunResult = false;
//                 System.out.println("Incorrect Detail Record Type validated successfully");
//                 writeLog("Incorrect Total number of records in file",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//           }
//           
//           if(totalDetailRecords==totalDetailRecordsFile)
//           {
//                 System.out.println("Validated Number of detail records in file");
//                 writeLog("Validated Number of detail records in file",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//           }
//           else
//           {
//                 blnFunResult = false;
//                 System.out.println("Incorrect Detail Record Type validated successfully");
//                 writeLog("Incorrect Number of detail records in file",PREVIOUS_TEST_CASE, TEST_STEP_COUNT);
//           }
//           
//           if(trailerInfo.length()==202)
//                 System.out.println("Length of Trailer validated successfully");
//           else{
//              System.out.println("Incorrect Detail Record Type validated successfully");
//              blnFunResult = false;
//           }
//                
//           
//           return blnFunResult;
//    }
//	
//	
//}
