//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.service_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.claimsservice_v1_0.EpsClaimsRequest;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentdetailservice_v1_0.EpsPaymentDetailRequest;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.EpsPaymentsSearchRequest;


/**
 * 
 * 				These request are by nature synchronous, so no need
 * 				to extend the
 * 				Request type.
 * 			
 * 
 * <p>Java class for SearchByCriteriaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchByCriteriaRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Service_v1_0}SearchCriteria"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchByCriteriaRequest", propOrder = {
    "searchCriteria"
})
@XmlSeeAlso({
    EpsClaimsRequest.class,
    EpsPaymentDetailRequest.class,
    EpsPaymentsSearchRequest.class
})
public class SearchByCriteriaRequest {

    @XmlElement(name = "SearchCriteria", required = true)
    protected SearchCriteria searchCriteria;

    /**
     * Gets the value of the searchCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteria }
     *     
     */
    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * Sets the value of the searchCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteria }
     *     
     */
    public void setSearchCriteria(SearchCriteria value) {
        this.searchCriteria = value;
    }

}
