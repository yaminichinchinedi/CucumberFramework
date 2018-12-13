//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0 package. 
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

    private final static QName _EpsPaymentsSummarySearchResults_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", "EpsPaymentsSummarySearchResults");
    private final static QName _EpsConsolidatedClaimPaymentSummary_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", "EpsConsolidatedClaimPaymentSummary");
    private final static QName _EpsPaymentsSummarySearchResponse_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", "EpsPaymentsSummarySearchResponse");
    private final static QName _EpsConsolidatedClaimPaymentSummaries_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", "EpsConsolidatedClaimPaymentSummaries");
    private final static QName _EpsPaymentsSearchRequest_QNAME = new QName("http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", "EpsPaymentsSearchRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EpsConsolidatedClaimPaymentSummary }
     * 
     */
    public EpsConsolidatedClaimPaymentSummary createEpsConsolidatedClaimPaymentSummary() {
        return new EpsConsolidatedClaimPaymentSummary();
    }

    /**
     * Create an instance of {@link EpsPaymentsSummarySearchResponse }
     * 
     */
    public EpsPaymentsSummarySearchResponse createEpsPaymentsSummarySearchResponse() {
        return new EpsPaymentsSummarySearchResponse();
    }

    /**
     * Create an instance of {@link EpsPaymentsSummarySearchResult }
     * 
     */
    public EpsPaymentsSummarySearchResult createEpsPaymentsSummarySearchResult() {
        return new EpsPaymentsSummarySearchResult();
    }

    /**
     * Create an instance of {@link EpsPaymentsSearchRequest }
     * 
     */
    public EpsPaymentsSearchRequest createEpsPaymentsSearchRequest() {
        return new EpsPaymentsSearchRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsPaymentsSummarySearchResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", name = "EpsPaymentsSummarySearchResults")
    public JAXBElement<EpsPaymentsSummarySearchResult> createEpsPaymentsSummarySearchResults(EpsPaymentsSummarySearchResult value) {
        return new JAXBElement<EpsPaymentsSummarySearchResult>(_EpsPaymentsSummarySearchResults_QNAME, EpsPaymentsSummarySearchResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsConsolidatedClaimPaymentSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", name = "EpsConsolidatedClaimPaymentSummary")
    public JAXBElement<EpsConsolidatedClaimPaymentSummary> createEpsConsolidatedClaimPaymentSummary(EpsConsolidatedClaimPaymentSummary value) {
        return new JAXBElement<EpsConsolidatedClaimPaymentSummary>(_EpsConsolidatedClaimPaymentSummary_QNAME, EpsConsolidatedClaimPaymentSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsPaymentsSummarySearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", name = "EpsPaymentsSummarySearchResponse")
    public JAXBElement<EpsPaymentsSummarySearchResponse> createEpsPaymentsSummarySearchResponse(EpsPaymentsSummarySearchResponse value) {
        return new JAXBElement<EpsPaymentsSummarySearchResponse>(_EpsPaymentsSummarySearchResponse_QNAME, EpsPaymentsSummarySearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpsConsolidatedClaimPaymentSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0", name = "EpsConsolidatedClaimPaymentSummaries")
    public JAXBElement<EpsConsolidatedClaimPaymentSummary> createEpsConsolidatedClaimPaymentSummaries(EpsConsolidatedClaimPaymentSummary value) {
        return new JAXBElement<EpsConsolidatedClaimPaymentSummary>(_EpsConsolidatedClaimPaymentSummaries_QNAME, EpsConsolidatedClaimPaymentSummary.class, null, value);
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