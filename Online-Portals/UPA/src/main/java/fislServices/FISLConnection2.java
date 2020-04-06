package main.java.fislServices;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class FISLConnection2 {
	static class CustomRestTemplate extends RestTemplate {
		private MediaType defaultResponseContentType = MediaType.APPLICATION_XML;

		public CustomRestTemplate() {
			super();
		}

		public CustomRestTemplate(ClientHttpRequestFactory factory) {
			super(factory);
		}

		public void setDefaultResponseContentType(String defaultResponseContentType) {
			this.defaultResponseContentType = MediaType.parseMediaType(defaultResponseContentType);
		}

		@Override
		protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback,
				final ResponseExtractor<T> responseExtractor) throws RestClientException {

			return super.doExecute(url, method, requestCallback, new ResponseExtractor<T>() {
				public T extractData(ClientHttpResponse response) throws IOException {
					if (response.getHeaders().getContentType() == null && defaultResponseContentType != null) {
						response.getHeaders().setContentType(defaultResponseContentType);
					}

					return responseExtractor.extractData(response);
				}
			});
		}
	}

	protected CustomRestTemplate restTemplate = new CustomRestTemplate(new MyCustomClientHttpRequestFactory());

	protected static SSLSocketFactory sslFactory = null;

	protected EPSRestConfig mConfig = null;

	class MyCustomClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

		@Override
		protected HttpURLConnection openConnection(URL url, Proxy proxy) throws IOException {
			return super.openConnection(url, proxy);
		}

		@Override
		protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
			if (connection instanceof HttpsURLConnection) {

				InputStream keyInput = null;
				try {

					HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
					httpsConnection.setDoOutput(true);

					if (sslFactory == null) {
						KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("IbmX509");
						KeyStore keyStore = KeyStore.getInstance("JKS");

						keyInput = new FileInputStream(mConfig.getProvisionCertLoc());
						keyStore.load(keyInput, mConfig.getProvisionCertPwd().toCharArray());
						keyInput.close();

						keyManagerFactory.init(keyStore, mConfig.getProvisionCertPwd().toCharArray());

						SSLContext context = SSLContext.getInstance("TLSv1.2");
						context.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());

						sslFactory = context.getSocketFactory();
					}

					httpsConnection.setSSLSocketFactory(sslFactory);
					httpsConnection.setHostnameVerifier(new HostnameVerifier() {
						public boolean verify(String s, SSLSession sslSession) {
							return true;
						}
					});

					super.prepareConnection(httpsConnection, httpMethod);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (keyInput != null) {
						try {
							keyInput.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			} else {
				try {
					super.prepareConnection(connection, httpMethod);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String getEraResponse(String requestXml) throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_XML);
		String url = "http://apsrs3771:8080/api/finance/providers/payments/v1/search\r\n" + 
				"";
		String responseXml = "";
		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>(requestXml, requestHeaders);
			//System.out.println(requestEntity.toString());
			ResponseEntity<String> responseEntity = restTemplate.exchange("http://apsrs3771:8080/api/finance/providers/payments/v1/search", HttpMethod.POST, requestEntity,
					String.class);
			responseXml = responseEntity.getBody();

			System.out.println(responseXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseXml;
	}
	
	
	
	
	public String getEraResponse1(String requestXml) throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_XML);
		String url = "http://apsrs3771:8080/api/finance/providers/payments/claims/v1/read\r\n" + 
				"";
		String responseXml = "";
		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>(requestXml, requestHeaders);
			//System.out.println(requestEntity.toString());
			ResponseEntity<String> responseEntity = restTemplate.exchange("http://apsrs3771:8080/api/finance/providers/payments/claims/v1/read", HttpMethod.POST, requestEntity,
					String.class);
			responseXml = responseEntity.getBody();

			System.out.println(responseXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseXml;
	}
	
	
	
	
	/*
	

	public static void main(String args[]) throws Exception {
		String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
				"<EpsPaymentsSearchRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\">\r\n" + 
				"    <ns1:SearchCriteria ns1:FromRecord=\"0\" ns1:MaxResult=\"30\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"12\">\r\n" + 
				"        <ns1:ParameterMap>\r\n" + 
				"            <ns1:Entries>\r\n" + 
				"				<ns1:Key>SUBSCRIBER_IDENTIFIER</ns1:Key>\r\n" + 
				"                <ns1:Value>958719947</ns1:Value>\r\n" + 
				"				<ns1:Comparator>Equals</ns1:Comparator>\r\n" + 
				"            </ns1:Entries>\r\n" + 
				"        </ns1:ParameterMap>\r\n" + 
				"    </ns1:SearchCriteria>\r\n" + 
				"    <ns2:ServiceData>\r\n" + 
				"        <ns2:ApplicationIdentifier>EPS</ns2:ApplicationIdentifier>\r\n" + 
				"        <ns2:Version>1.0</ns2:Version>\r\n" + 
				"    </ns2:ServiceData>\r\n" + 
				"    <ns3:TaxIdentifierNumber>411791406</ns3:TaxIdentifierNumber>\r\n" + 
				"    <ns2:UserRole>PROVIDER</ns2:UserRole>\r\n" + 
				"    <ns4:PaymentMadeOnDateRange>\r\n" + 
				"        <ns4:FromDate>2019-04-01</ns4:FromDate>\r\n" + 
				"        <ns4:ToDate>2019-04-30</ns4:ToDate>\r\n" + 
				"    </ns4:PaymentMadeOnDateRange>\r\n" + 
				"</EpsPaymentsSearchRequest>";
		
		System.out.println(requestXml);
	
		new FISLConnection2().getEraResponse(requestXml);
	}
	
	*/

}
