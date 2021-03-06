//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 				This identifier comprises of two separate attributes:
 * 				EPS Schema Name, Consolidated Payment Number and Payment Made On.
 * 			
 * 
 * <p>Java class for EpsPaymentComplexIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsPaymentComplexIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}SchemaName"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ConsolidatedPaymentNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}PaymentMadeOn"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsPaymentComplexIdentifier", propOrder = {
    "schemaName",
    "consolidatedPaymentNumber",
    "paymentMadeOn"
})
public class EpsPaymentComplexIdentifier {

    @XmlElement(name = "SchemaName", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected String schemaName;
    @XmlElement(name = "ConsolidatedPaymentNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String consolidatedPaymentNumber;
    @XmlElement(name = "PaymentMadeOn", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar paymentMadeOn;

    /**
     * Gets the value of the schemaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * Sets the value of the schemaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaName(String value) {
        this.schemaName = value;
    }

    /**
     * Gets the value of the consolidatedPaymentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsolidatedPaymentNumber() {
        return consolidatedPaymentNumber;
    }

    /**
     * Sets the value of the consolidatedPaymentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsolidatedPaymentNumber(String value) {
        this.consolidatedPaymentNumber = value;
    }

    /**
     * Gets the value of the paymentMadeOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentMadeOn() {
        return paymentMadeOn;
    }

    /**
     * Sets the value of the paymentMadeOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentMadeOn(XMLGregorianCalendar value) {
        this.paymentMadeOn = value;
    }

}
