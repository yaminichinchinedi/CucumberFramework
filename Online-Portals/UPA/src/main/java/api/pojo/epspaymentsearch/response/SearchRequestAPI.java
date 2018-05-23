package main.java.api.pojo.epspaymentsearch.response;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SearchRequestAPI 
 {
	static String reqXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><EpsPaymentsSearchRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\"><ns1:SearchCriteria><ns1:ParameterMap><ns1:Entries><ns1:Key>PAYMENT_LEVEL_DETAIL</ns1:Key><ns1:Value>Y</ns1:Value><ns1:Comparator>Equals</ns1:Comparator></ns1:Entries></ns1:ParameterMap></ns1:SearchCriteria><ns3:TaxIdentifierNumber>631245407</ns3:TaxIdentifierNumber><ns2:UserRole>PROVIDER</ns2:UserRole><ns4:PaymentMadeOnDateRange><ns4:FromDate>2018-04-06</ns4:FromDate><ns4:ToDate>2018-05-07</ns4:ToDate></ns4:PaymentMadeOnDateRange></EpsPaymentsSearchRequest>";

	public static void main(String [] a) throws Exception
	{
	SearchRequestAPI searchReq = new SearchRequestAPI();
	 try 
	  {
		searchReq.getEPSSearchRequestResponse();
	  } 
		
	catch (Exception e) 
	 {	
		e.printStackTrace();
	 }
	}
	
public 	String con;
public void getEPSSearchRequestResponse() throws IOException, SAXException, ParserConfigurationException
{

            String line; 
            String urlString = "http://apsrs3771:8080/api/finance/providers/payments/v1/search";
	        String RequestMessage = reqXML;
	        URL conn = new URL(urlString);
	        
	        //Opens connection with server
	        URLConnection UrlConn = conn.openConnection();
	        HttpURLConnection httpUrlConn = (HttpURLConnection) UrlConn;
	        
	        httpUrlConn.setDoOutput(true);
	        httpUrlConn.setRequestMethod("POST");
	        httpUrlConn.setRequestProperty("Content-Type","application/xml");
	        httpUrlConn.connect();
	       
	        //Send request
	        OutputStreamWriter ReqWriter = new OutputStreamWriter(httpUrlConn.getOutputStream());
	        ReqWriter.write(RequestMessage);
	        ReqWriter.flush();
	        

	        //Gets response of the request fired
	        BufferedReader ReplyReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
	        
	        //creating a file to store the response received
	     //   FileOutputStream responseFile = new FileOutputStream("C:\\FinalTest\\TestAutomation\\Online-Portals\\api\\Response.xml");
	        
        	//printing response and writing it in api.xml
	        while ((line = ReplyReader.readLine()) != null)
	        {
	        	System.out.println(line);
	        	con=con+line;
	      //  	responseFile.write(line.getBytes());
	        	
	        }
	        System.out.println("#####"+con);
	   //     responseFile.flush();
	        //closing all connections
	  //      responseFile.close();
	        ReplyReader.close();
	    //    httpUrlConn.disconnect();
	        
}
	

	
}

