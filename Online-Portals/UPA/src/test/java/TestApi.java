package test.java;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
public class TestApi {
	
//	public static void main(String [] a){
//		String url="";
//		String content="";
//		Response response= RestAssured.given().contentType("application/json").body(content).port(1234).baseUri("").when().post();
//		System.out.println(response.asString());
//	}
	
	public static void main(String []a){
		
		String soapEndpointUrl = "http://www.webservicex.net/uszip.asmx";
        String soapAction = "https://trustbroker-stg-svcs.optum.com:8443/stage";

        callSoapWebService(soapEndpointUrl, soapAction);
	}
	
	private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "myNamespace";
        String myNamespaceURI = "http://www.webserviceX.NET";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:GetInfoByCity>
                        <myNamespace:USCity>New York</myNamespace:USCity>
                    </myNamespace:GetInfoByCity>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */
        
     /*   <ns17:EpsPaymentsSearchRequest xmlns="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0" xmlns:ns20="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/Edi835ContentService_v1_0" xmlns:ns21="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0" xmlns:ns10="http://enterprise.optum.com/schema/cim/product/Group_v1_0" xmlns:ns11="http://enterprise.optum.com/schema/cim/provider/Provider_v1_0" xmlns:ns12="http://enterprise.optum.com/schema/cim/common/Payment_v1_0" xmlns:ns13="http://enterprise.optum.com/schema/cim/common/Payee_v1_0" xmlns:ns14="http://enterprise.optum.com/schema/cim/common/Payer_v1_0" xmlns:ns15="http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0" xmlns:ns16="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentDetailService_v1_0" xmlns:ns17="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0" xmlns:ns18="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0" xmlns:ns19="http://enterprise.optum.com/schema/cim/common/Service_v1_0" xmlns:ns2="http://enterprise.optum.com/schema/cim/common/Person_v1_0" xmlns:ns3="http://enterprise.optum.com/schema/cim/common/Identifier_v1_0" xmlns:ns4="http://enterprise.optum.com/schema/cim/common/Common_v1_0" xmlns:ns5="http://enterprise.optum.com/schema/cim/common/Code_v1_0" xmlns:ns6="http://enterprise.optum.com/schema/cim/common/Phone_v1_0" xmlns:ns7="http://enterprise.optum.com/schema/cim/common/Contact_v1_0" xmlns:ns8="http://enterprise.optum.com/schema/cim/common/Address_v1_0" xmlns:ns9="http://enterprise.optum.com/schema/cim/member/Member_v1_0">
        <ns19:SearchCriteria ns19:FromRecord="0" ns19:MaxResult="0" ns19:SortDirection="DESC" ns19:SortFieldNumber="12">
            <ns19:ParameterMap>
                <ns19:Entries>
                    <ns19:Key>PAYMENT_LEVEL_DETAIL</ns19:Key>
                    <ns19:Value>Y</ns19:Value>
                    <ns19:Comparator>Equals</ns19:Comparator>
                </ns19:Entries>
            </ns19:ParameterMap>
        </ns19:SearchCriteria>
        <ns3:TaxIdentifierNumber>131624082</ns3:TaxIdentifierNumber>
        <UserRole>PROVIDER</UserRole>
        <ns4:PaymentMadeOnDateRange>
            <ns4:FromDate>2017-09-18</ns4:FromDate>
            <ns4:ToDate>2017-10-20</ns4:ToDate>
        </ns4:PaymentMadeOnDateRange>
    </ns17:EpsPaymentsSearchRequest> */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetInfoByCity", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("USCity", myNamespace);
        soapBodyElem1.addTextNode("New York");
    }
	
	private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }
	private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
		
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage(new MimeHeaders(),new FileInputStream("C:\\Users\\p1058\\Desktop\\api\\a.xml"));
//        MimeHeaders headers =new MimeHeaders().addHeader(name, value);;
//        headers.addHeader("SOAPAction", soapAction);
      //  createSoapEnvelope(soapMessage);
        
        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }

}
