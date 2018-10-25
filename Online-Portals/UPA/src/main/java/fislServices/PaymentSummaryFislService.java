package main.java.fislServices;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.optum.enterprise.schema.cim.api.finance.payables.provider.claimsservice_v1_0.EpsClaimsRequest;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.claimsservice_v1_0.EpsClaimsResponse;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.edi835contentservice_v1_0.EpsEdi835ContentResponse;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentdetailservice_v1_0.EpsPaymentDetailResponse;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.EpsConsolidatedClaimPaymentSummary;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.EpsPaymentsSummarySearchResponse;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.ObjectFactory;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentupdateservice_v1_0.EpsPaymentUpdateRequest;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentupdateservice_v1_0.EpsPaymentUpdateResponse;


public class PaymentSummaryFislService {

	protected JAXBContext ctx;
	
	public PaymentSummaryFislService() {
		super();
		// TODO Auto-generated constructor stub
		try {
			ctx = JAXBContext
					.newInstance(
							EpsClaimsResponse.class,
							EpsEdi835ContentResponse.class,
							EpsPaymentDetailResponse.class,
							EpsPaymentsSummarySearchResponse.class,
							EpsPaymentUpdateResponse.class,
							EpsPaymentUpdateRequest.class,
							ObjectFactory.class,
							com.optum.enterprise.schema.cim.api.finance.payables.provider.edi835contentservice_v1_0.ObjectFactory.class,
							com.optum.enterprise.schema.cim.api.finance.payables.provider.claimsservice_v1_0.ObjectFactory.class,
							com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentdetailservice_v1_0.ObjectFactory.class,
							com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentupdateservice_v1_0.ObjectFactory.class,
							EpsClaimsRequest.class);
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}

	public Object toObject(String response) throws Exception {
		String context = "toObject";
		try {
			XMLInputFactory xif = XMLInputFactory.newInstance();
			xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
			xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
			xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

			try {
				XMLStreamReader xsr = xif.createXMLStreamReader(new ByteArrayInputStream(response.getBytes()));
				Unmarshaller unmarshaller = ctx.createUnmarshaller();
				return unmarshaller.unmarshal(xsr);
			} catch (XMLStreamException e) {
				System.out.println(e.getMessage());
				throw new Exception("Exception occurred while toObject : " + e.getMessage());
			}

		} catch (JAXBException e) {
			throw new Exception("Exception occurred while toObject : " + e.getMessage());
		}

	}

	
	public String getTotalCounts(Object responseData)
	{
		String totalCount="";
		EpsPaymentsSummarySearchResponse data = (EpsPaymentsSummarySearchResponse) responseData;
		totalCount = data.getResponseReturnStatus().getTotalCount();
		return totalCount;
	}
	
	
	public List<EpsConsolidatedClaimPaymentSummary> getEpsConsolidatedClaimPaymentSummaries(Object responseData)
	{
		List<EpsConsolidatedClaimPaymentSummary> epsConsolidatedClaimPaymentSummaries= null;
		EpsPaymentsSummarySearchResponse data = (EpsPaymentsSummarySearchResponse) responseData;
		epsConsolidatedClaimPaymentSummaries = data.getEpsConsolidatedClaimPaymentSummaries();
		return epsConsolidatedClaimPaymentSummaries;
	}
	
	
	
	

}
