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

import main.java.api.base.CreateConnection;
import main.java.api.pojo.epsPaymentDetailRequest.request.ObjectFactory;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import org.xml.sax.SAXException;

public class EpsPaymentSearchRequestHelper extends CreateConnection
{
	
	
	static String connectionUrl = "";
	static final String xmlFilePath=System.getProperty("user.dir")+"\\src\\main\\java\\api\\pojo\\epspaymentsearch\\request\\Request.xml";
	 
	
	public EpsPaymentSearchRequestHelper()
	{
		
		super(connectionUrl);
		
    }

	
	@Override
	public Object convertResponseXMLToPojo(String response) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(EpsPaymentsSummarySearchResponse.class);   
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
		EpsPaymentsSummarySearchResponse searchResponse= (EpsPaymentsSummarySearchResponse) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)));  
        return searchResponse;		
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
