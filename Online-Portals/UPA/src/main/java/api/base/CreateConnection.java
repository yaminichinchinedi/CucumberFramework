package main.java.api.base;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.reporting.Log;

import org.xml.sax.SAXException;

public abstract class CreateConnection {

	final String connectionUrl;

	public CreateConnection(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public final Object postRequestGetResponse(Object pojoRequest)throws IOException, SAXException, ParserConfigurationException,JAXBException {
		String response = "";
		String line;
		URL conn = new URL(connectionUrl);
		
		// Opens connection with server
		URLConnection UrlConn = conn.openConnection();
		HttpURLConnection httpUrlConn = (HttpURLConnection) UrlConn;

		httpUrlConn.setDoOutput(true);
		httpUrlConn.setRequestMethod("POST");
		httpUrlConn.setRequestProperty("Content-Type", "application/xml");
		httpUrlConn.connect();

		OutputStreamWriter ReqWriter = new OutputStreamWriter(
		httpUrlConn.getOutputStream());
		String requestXML = convertRequestPojoToXml(pojoRequest);
		requestXML = requestXML.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>","").replace("null", "");
//		System.out.println("REQUEST :" + requestXML);
		ReqWriter.write(requestXML);
		ReqWriter.flush();

		/** Gets response of the request fired*/
		BufferedReader ReplyReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));

		/** printing response and writing it in api.xml*/
//		System.out.println("RESPONSE :" + '\n');
		while ((line = ReplyReader.readLine()) != null) {
//			System.out.println(line);
			response = response + line;
		}
		ReplyReader.close();
		httpUrlConn.disconnect();
		return convertResponseXMLToPojo(response.replace("<?xml version='1.0' encoding='UTF-8'?>", "").replace("null",""));
	}

	
	abstract protected Object convertResponseXMLToPojo(String response)
			throws JAXBException, IOException, SAXException,
			ParserConfigurationException;

	abstract protected Object createRequestPojo() throws JAXBException;

	abstract protected String convertRequestPojoToXml(Object object)
			throws JAXBException;
}