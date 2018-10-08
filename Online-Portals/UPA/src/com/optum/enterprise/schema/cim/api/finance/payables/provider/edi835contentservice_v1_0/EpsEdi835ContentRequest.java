//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.edi835contentservice_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0.ServiceData;


/**
 * 
 * 				
 * 				Request to get EPS EDI 835 contents.				
 * 				
 * 			
 * 
 * <p>Java class for EpsEdi835ContentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsEdi835ContentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ServiceData"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}PaymentIdentifier"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsEdi835ContentRequest", propOrder = {
    "serviceData",
    "paymentIdentifier"
})
public class EpsEdi835ContentRequest {

    @XmlElement(name = "ServiceData", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected ServiceData serviceData;
    @XmlElement(name = "PaymentIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String paymentIdentifier;

    /**
     * Gets the value of the serviceData property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceData }
     *     
     */
    public ServiceData getServiceData() {
        return serviceData;
    }

    /**
     * Sets the value of the serviceData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceData }
     *     
     */
    public void setServiceData(ServiceData value) {
        this.serviceData = value;
    }

    /**
     * Gets the value of the paymentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    /**
     * Sets the value of the paymentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentIdentifier(String value) {
        this.paymentIdentifier = value;
    }

}
