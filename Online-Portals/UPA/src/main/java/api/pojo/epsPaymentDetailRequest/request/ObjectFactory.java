package main.java.api.pojo.epsPaymentDetailRequest.request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;

@XmlRegistry
public class ObjectFactory {

   
    private final static QName _EpsPaymentsSearchRequest_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", "EpsPaymentsSearchRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0
     * 
     */
    public ObjectFactory() {
    }

   

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsPaymentsSearchRequest }{@code >}}
     * 
     */
    
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", name = "EpsPaymentsSearchRequest")
    public JAXBElement<EpsPaymentsSearchRequest> createEpsPaymentsSearchRequest(EpsPaymentsSearchRequest value) {
        return new JAXBElement<EpsPaymentsSearchRequest>(_EpsPaymentsSearchRequest_QNAME, EpsPaymentsSearchRequest.class, null, value);
    }

}