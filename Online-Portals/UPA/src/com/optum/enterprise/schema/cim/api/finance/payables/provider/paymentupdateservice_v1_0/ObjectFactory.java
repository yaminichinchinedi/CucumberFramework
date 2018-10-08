//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentupdateservice_v1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentupdateservice_v1_0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EpsPaymentNachaDetails_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", "EpsPaymentNachaDetails");
    private final static QName _EpsPaymentUpdateResponse_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", "EpsPaymentUpdateResponse");
    private final static QName _EpsPaymentUpdateRequest_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", "EpsPaymentUpdateRequest");
    private final static QName _EpsPaymentNachaDetail_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", "EpsPaymentNachaDetail");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentupdateservice_v1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EpsPaymentUpdateRequest }
     * 
     */
    public EpsPaymentUpdateRequest createEpsPaymentUpdateRequest() {
        return new EpsPaymentUpdateRequest();
    }

    /**
     * Create an instance of {@link EpsPaymentNachaDetail }
     * 
     */
    public EpsPaymentNachaDetail createEpsPaymentNachaDetail() {
        return new EpsPaymentNachaDetail();
    }

    /**
     * Create an instance of {@link EpsPaymentUpdateResponse }
     * 
     */
    public EpsPaymentUpdateResponse createEpsPaymentUpdateResponse() {
        return new EpsPaymentUpdateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsPaymentNachaDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", name = "EpsPaymentNachaDetails")
    public JAXBElement<EpsPaymentNachaDetail> createEpsPaymentNachaDetails(EpsPaymentNachaDetail value) {
        return new JAXBElement<EpsPaymentNachaDetail>(_EpsPaymentNachaDetails_QNAME, EpsPaymentNachaDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsPaymentUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", name = "EpsPaymentUpdateResponse")
    public JAXBElement<EpsPaymentUpdateResponse> createEpsPaymentUpdateResponse(EpsPaymentUpdateResponse value) {
        return new JAXBElement<EpsPaymentUpdateResponse>(_EpsPaymentUpdateResponse_QNAME, EpsPaymentUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsPaymentUpdateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", name = "EpsPaymentUpdateRequest")
    public JAXBElement<EpsPaymentUpdateRequest> createEpsPaymentUpdateRequest(EpsPaymentUpdateRequest value) {
        return new JAXBElement<EpsPaymentUpdateRequest>(_EpsPaymentUpdateRequest_QNAME, EpsPaymentUpdateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsPaymentNachaDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0", name = "EpsPaymentNachaDetail")
    public JAXBElement<EpsPaymentNachaDetail> createEpsPaymentNachaDetail(EpsPaymentNachaDetail value) {
        return new JAXBElement<EpsPaymentNachaDetail>(_EpsPaymentNachaDetail_QNAME, EpsPaymentNachaDetail.class, null, value);
    }

}
