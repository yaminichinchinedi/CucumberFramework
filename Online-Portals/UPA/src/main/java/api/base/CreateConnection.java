package main.java.api.base;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.xml.sax.SAXException;

public abstract class CreateConnection {

	final String connectionUrl;
	private TestBase testConfig=TestBase.getInstance();

	public CreateConnection(String connectionUrl) {
		connectionUrl=(testConfig.getRunTimeProperty(testConfig.getRunTimeProperty("Env")+"FISLURL_Payments"));
		this.connectionUrl = connectionUrl;
	}
	
	
	public String getAuthToken() throws IOException
	{    
		StringBuilder response = new StringBuilder();
		String authURL="https://gateway-stage-dmz.optum.com/auth/oauth2/token";
		URL conn = new URL(authURL);
		// Opens connection with server
				URLConnection UrlConn = conn.openConnection();
				HttpsURLConnection httpUrlConn = (HttpsURLConnection) UrlConn;

				httpUrlConn.setDoOutput(true);
				httpUrlConn.setRequestMethod("POST");
				httpUrlConn.setRequestProperty("Content-Type", "application/json");
				httpUrlConn.setRequestProperty("Accept", "application/json");
				httpUrlConn.setDoOutput(true);
				httpUrlConn.connect();
				String payload = "{" +
		                "\"client_id\": \"NpOFhNDcNuDNiqZ3xHBvI7hDWzcV13CD\", " +
		                "\"client_secret\": \"04tYtsyfNSBFyJr3CcHCJuYSvIeOl6X1\", " +
		                "\"grant_type\": \"client_credentials\"" +
		                "}";
				try(OutputStream os = httpUrlConn.getOutputStream()) 
				{
				    byte[] input = payload.getBytes("utf-8");
				    os.write(input, 0, input.length);			
				}
				
				try(BufferedReader br = new BufferedReader(
						  new InputStreamReader(httpUrlConn.getInputStream(), "utf-8"))) {
						    String responseLine = null;
						    while ((responseLine = br.readLine()) != null) {
						        response.append(responseLine.trim());
						    }
						}
				return  (response.substring(39,71));
	}

	public final Object postRequestGetResponse(Object pojoRequest)throws  IOException, SAXException, ParserConfigurationException,JAXBException {
		String response = "";
		String line;
		
		URL conn = new URL(connectionUrl);

		// Opens connection with server
		URLConnection UrlConn = conn.openConnection();
		HttpURLConnection httpUrlConn;
		
		httpUrlConn = (HttpURLConnection) UrlConn;

		httpUrlConn.setDoOutput(true);
		httpUrlConn.setRequestMethod("POST");
		httpUrlConn.setRequestProperty("Content-Type", "application/json");
		httpUrlConn.setRequestProperty("Authorization", "Bearer " + getAuthToken());
		httpUrlConn.connect();

		String payload = pojoRequest.toString();

		try(OutputStream os = httpUrlConn.getOutputStream()) 
		{
		    byte[] input = payload.getBytes("utf-8");
		    os.write(input, 0, input.length);			
		}
		
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(httpUrlConn.getInputStream(), "utf-8"))) {
				    String responseLine = null;
				    while ((responseLine = br.readLine()) != null) {
				        //response1.append(responseLine.trim());
						System.out.println(responseLine);
				        response = response + responseLine.trim();
				    }
				}
		
		httpUrlConn.disconnect();
		return convertResponseJSONToPojo(response);
	}

	
	abstract protected Object convertResponseJSONToPojo(String response)
			throws JAXBException, IOException, SAXException,
			ParserConfigurationException;

	abstract protected Object convertResponseXMLToPojo(String response)
			throws JAXBException, IOException, SAXException,
			ParserConfigurationException;

	abstract protected Object createRequestPojo() throws JAXBException;

	abstract protected String convertRequestPojoToXml(Object object)
			throws JAXBException;
}