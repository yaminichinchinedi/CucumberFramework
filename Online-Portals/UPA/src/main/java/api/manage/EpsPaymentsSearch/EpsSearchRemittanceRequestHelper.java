package main.java.api.manage.EpsPaymentsSearch;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.api.base.CreateConnection;
import main.java.api.pojo.epsPaymentDetailRequest.request.ObjectFactory;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.jsonresponse.EpsPaymentsSummarySearchResponse;
import main.java.reporting.Log;


//For Search Remittance Data 
public class EpsSearchRemittanceRequestHelper extends CreateConnection {
		
//	static final String connectionUrl = "https://feadgw-stg-esbserv.optum.com/api/finance/providers/payments/v1/search";
	
	static final String connectionUrl = "http://apsrs3771:8080/api/finance/providers/payments/v1/search";
	
	
	String xmlFilePath=System.getProperty("user.dir") +"\\src\\main\\java\\api\\pojo\\epspaymentsearch\\request";
		
	public EpsSearchRemittanceRequestHelper(String requestType)
		{
			super(connectionUrl);
			
			switch (requestType) {
	        case "byDOP":
	        case "byDOP&SubscriberID":
	        case "byDOPAndAccountNo":
	        case "byDOPAndRenderingProvider":
	        case "byDOPAndMarketType":
	        case "byDOPAndClaimNo":
	        case "byDOPAndZeroPaymentClaims":
	              xmlFilePath=xmlFilePath +"\\DOP.xml";
	               break;
	        case "byDOS":
	        case "byDOSAndSubscriberId":
	        case "byDOSAndAcntNo":
	        case "byDOSAndClmNo":
	        case "byDOSAndPtntNm":
	        case "byDOSAndZeroPmntClms":
	        case "byDOSAndMarketType":
	               xmlFilePath=xmlFilePath +"\\RequestSearchRemitDOS.xml";
	               break;
	        case "byDOPAndPatientNm":
	               xmlFilePath=xmlFilePath + "\\DOP&PatientNameRequest.xml";
	               break;
	      
	        case "byElectronicPaymentNo":
	        case "byCheckNo":
	              xmlFilePath=xmlFilePath+"\\DOP&ElectronicPaymentNoRequest.xml";
                  break;
                  
	        case "byDOPAndNpi":
	        	xmlFilePath=xmlFilePath+"\\DOP&NPI.xml";
	        	break;
	        	
	        case "byDOSAndNpi":
	        	xmlFilePath=xmlFilePath+"\\DOS&NPI.xml";
	        	break;
	       
	        
	        default:
	               Log.Comment("No Request exists for given input");
	               break;
	        }

		}

	@Override
	public Object convertResponseXMLToPojo(String response) throws JAXBException, IOException, SAXException, ParserConfigurationException {
		JAXBContext jaxbContext = JAXBContext.newInstance(EpsPaymentsSummarySearchResponse.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		EpsPaymentsSummarySearchResponse searchResponse = (EpsPaymentsSummarySearchResponse) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)));
		return searchResponse;
	}

		@Override
		public Object convertResponseJSONToPojo(String response) throws JAXBException, IOException, SAXException, ParserConfigurationException
		{
			{
				EpsPaymentsSummarySearchResponse eps = null;
				ObjectMapper mapper = new ObjectMapper();
//		      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		      mapper.enable(Feature.ALLOW_TRAILING_COMMA);
		      try {
		    	  eps = mapper.readValue(response, EpsPaymentsSummarySearchResponse.class);
		      } catch (IOException e) {
		          e.printStackTrace();
		      }
		      return eps;
			}
			
		}
		
		
		/**
		 * Reads the request XML and converts in into Java Objects
		 * Set the contents of xml request like tin number,date etc
		 * Now converts the Java object to 
		 * modified xml request to get the response
		 * returns @EpsPaymentsSearchRequest Object
		 */
		
		@Override
		public EpsPaymentsSearchRequest createRequestPojo() throws JAXBException
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(EpsPaymentsSearchRequest.class);   
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			EpsPaymentsSearchRequest requestXML= (EpsPaymentsSearchRequest) jaxbUnmarshaller.unmarshal(new File(xmlFilePath));
			return requestXML;
			
			
		}

		/**
		 * Converts the Pojo request 
		 * back to XML to get the response
		 * @arguments: Object of base pojo class 
		 * i.e EPSPaymentsSerachRequest
		 */
		
		@Override
		public String convertRequestPojoToXml(Object request) throws JAXBException
		{
			JAXBContext context = JAXBContext.newInstance(EpsPaymentsSearchRequest.class);
			StringWriter stringWriter = new StringWriter();
			ObjectFactory objectFactory = new ObjectFactory();
			JAXBElement jaxbElement = objectFactory.createEpsPaymentsSearchRequest((EpsPaymentsSearchRequest) request);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			marshaller.marshal(jaxbElement, stringWriter);
			return stringWriter.toString();	
		}	
		
	}

