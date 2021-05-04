package main.java.api.manage.EpsPaymentsSearch;

import static com.jayway.restassured.RestAssured.given;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import main.java.api.pojo.epsRemittanceDetail.response.EpsClaimsResponse;
import main.java.nativeFunctions.TestBase;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EpsRemittanceDetailHelper {

    private TestBase testConfig=TestBase.getInstance();
    private String connectionUrl=(testConfig.getRunTimeProperty(testConfig.getRunTimeProperty("Env")+"FISLURL_RemittanceDetail"));
    private String remittanceDetailResponse;

    @SuppressWarnings("static-access")
	public String getAuthToken() throws IOException, NoSuchAlgorithmException, KeyManagementException
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
        
     /*   SSLContext context = SSLContext.getInstance("SSLv3");  //
        context.init(null, null, null);  //
        httpUrlConn.setDefaultSSLSocketFactory(context.getSocketFactory()); // */
        SSLSocketFactory abc = httpUrlConn.getSSLSocketFactory(); //
        System.out.print(abc); //
        
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

    public final String postRequestGetResponse(String xmlRequest) throws IOException, SAXException, ParserConfigurationException, JAXBException, KeyManagementException, NoSuchAlgorithmException {
        String response = "";
        String line;

        URL conn = new URL(connectionUrl);

        // Opens connection with server
        URLConnection UrlConn = conn.openConnection();
        HttpURLConnection httpUrlConn;

        httpUrlConn = (HttpURLConnection) UrlConn;

        httpUrlConn.setDoOutput(true);
        httpUrlConn.setRequestMethod("POST"); 
        httpUrlConn.setRequestProperty("Content-Type", "application/xml");
        httpUrlConn.setRequestProperty("Authorization", "Bearer " + getAuthToken());
        httpUrlConn.connect();

        try(OutputStream os = httpUrlConn.getOutputStream())
        {
            byte[] input = xmlRequest.getBytes();
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(httpUrlConn.getInputStream()))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response = response + responseLine.trim();
            }
        }

        httpUrlConn.disconnect();

        setRemittanceDetailResponse(response);
        return formatXML(response);
    }

    public String getFormattedDate(String input) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
        String reformattedStr = "";

        try {

            reformattedStr = myFormat.format(fromUser.parse(input));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  reformattedStr;
    }

    public String formatXML(String response) throws SAXException, IOException, ParserConfigurationException {

        response = response.replaceAll("ns[0-9]:", "").replaceAll("ns1[0-9]:", "");
        String remove = " xmlns:ns1=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\"  xmlns:ns0=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\"  xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns10=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\"";
        response = response.replace(remove, "");

        Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
        OutputFormat format = new OutputFormat(xmlDocument);
        format.setLineWidth(65);
        format.setIndenting(true);
        format.setIndent(2);
        Writer out = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(out, format);
        serializer.serialize(xmlDocument);
        response = out.toString();

        String[] originalString = response.split("\n");
        for(int i=0; i<originalString.length; i++){
            if(originalString[i].contains("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"")){
                originalString[i]=originalString[i].replace("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"", "");
            }
        }
        StringBuilder finalString = new StringBuilder();
        for(int i=0; i<originalString.length; i++){
            finalString.append(originalString[i]).append("\n");
        }

        BufferedReader br = new BufferedReader(new StringReader(finalString.toString()));
        String line2 = "";
        StringBuilder sb = new StringBuilder();
        while((line2=br.readLine())!= null){
            sb.append(line2.trim());
        }
        return sb.toString();
    }

    public EpsClaimsResponse convertXMLStringToPOJO(String xmlString) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EpsClaimsResponse.class);
        Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();
        EpsClaimsResponse epsClaimsResponse = (EpsClaimsResponse) jaxbUnmarshall.unmarshal(new StringReader(xmlString));
        return epsClaimsResponse;
    }

    public String getRemittanceDetailResponse() {
        return remittanceDetailResponse;
    }

    public void setRemittanceDetailResponse(String remittanceDetailResponse) {
        this.remittanceDetailResponse = remittanceDetailResponse;
    }
}
