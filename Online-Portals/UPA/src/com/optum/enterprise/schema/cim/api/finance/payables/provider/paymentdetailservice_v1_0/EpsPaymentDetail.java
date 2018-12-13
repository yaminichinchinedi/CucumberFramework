//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentdetailservice_v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0.EpsPaymentStatusCode;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0.EpsProviderPaymentAdjustment;
import com.optum.enterprise.schema.cim.common.payment_v1_0.Payment;


/**
 * <p>Java class for EpsPaymentDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsPaymentDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Payment_v1_0}Payment">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}ProviderIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}DisplayConsolidatedPaymentNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}NationalProviderIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}ProviderName"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}TraceNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsAmbulatoryPaymentIndicator"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProcessDate"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PayerBankAccountNativeIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProcessControlIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsPaymentStatusCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsPaymentErrorStatusCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PaymentErrorDateTime"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}VcpReoriginationDate"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProxyIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsProviderPaymentAdjustments" maxOccurs="500000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsPaymentDetail", propOrder = {
    "providerIdentifier",
    "displayConsolidatedPaymentNumber",
    "nationalProviderIdentifier",
    "providerName",
    "traceNumber",
    "epsAmbulatoryPaymentIndicator",
    "processDate",
    "payerBankAccountNativeIdentifier",
    "processControlIdentifier",
    "epsPaymentStatusCode",
    "epsPaymentErrorStatusCode",
    "paymentErrorDateTime",
    "vcpReoriginationDate",
    "proxyIdentifier",
    "epsProviderPaymentAdjustments"
})
public class EpsPaymentDetail
    extends Payment
{

    @XmlElement(name = "ProviderIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String providerIdentifier;
    @XmlElement(name = "DisplayConsolidatedPaymentNumber", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String displayConsolidatedPaymentNumber;
    @XmlElement(name = "NationalProviderIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String nationalProviderIdentifier;
    @XmlElement(name = "ProviderName", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected String providerName;
    @XmlElement(name = "TraceNumber", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected String traceNumber;
    @XmlElement(name = "EpsAmbulatoryPaymentIndicator", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected String epsAmbulatoryPaymentIndicator;
    @XmlElement(name = "ProcessDate", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar processDate;
    @XmlElement(name = "PayerBankAccountNativeIdentifier", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0")
    protected long payerBankAccountNativeIdentifier;
    @XmlElement(name = "ProcessControlIdentifier", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected String processControlIdentifier;
    @XmlElement(name = "EpsPaymentStatusCode", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected EpsPaymentStatusCode epsPaymentStatusCode;
    @XmlElement(name = "EpsPaymentErrorStatusCode", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected EpsPaymentStatusCode epsPaymentErrorStatusCode;
    @XmlElement(name = "PaymentErrorDateTime", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentErrorDateTime;
    @XmlElement(name = "VcpReoriginationDate", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vcpReoriginationDate;
    @XmlElement(name = "ProxyIdentifier", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected String proxyIdentifier;
    @XmlElement(name = "EpsProviderPaymentAdjustments", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0")
    protected List<EpsProviderPaymentAdjustment> epsProviderPaymentAdjustments;

    /**
     * This is the Provider's Tax Identifier Number
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderIdentifier() {
        return providerIdentifier;
    }

    /**
     * Sets the value of the providerIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderIdentifier(String value) {
        this.providerIdentifier = value;
    }

    /**
     * Gets the value of the displayConsolidatedPaymentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayConsolidatedPaymentNumber() {
        return displayConsolidatedPaymentNumber;
    }

    /**
     * Sets the value of the displayConsolidatedPaymentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayConsolidatedPaymentNumber(String value) {
        this.displayConsolidatedPaymentNumber = value;
    }

    /**
     * Gets the value of the nationalProviderIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalProviderIdentifier() {
        return nationalProviderIdentifier;
    }

    /**
     * Sets the value of the nationalProviderIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalProviderIdentifier(String value) {
        this.nationalProviderIdentifier = value;
    }

    /**
     * Gets the value of the providerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the value of the providerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderName(String value) {
        this.providerName = value;
    }

    /**
     * Gets the value of the traceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraceNumber() {
        return traceNumber;
    }

    /**
     * Sets the value of the traceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraceNumber(String value) {
        this.traceNumber = value;
    }

    /**
     * Gets the value of the epsAmbulatoryPaymentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpsAmbulatoryPaymentIndicator() {
        return epsAmbulatoryPaymentIndicator;
    }

    /**
     * Sets the value of the epsAmbulatoryPaymentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpsAmbulatoryPaymentIndicator(String value) {
        this.epsAmbulatoryPaymentIndicator = value;
    }

    /**
     * Gets the value of the processDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessDate() {
        return processDate;
    }

    /**
     * Sets the value of the processDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessDate(XMLGregorianCalendar value) {
        this.processDate = value;
    }

    /**
     * Gets the value of the payerBankAccountNativeIdentifier property.
     * 
     */
    public long getPayerBankAccountNativeIdentifier() {
        return payerBankAccountNativeIdentifier;
    }

    /**
     * Sets the value of the payerBankAccountNativeIdentifier property.
     * 
     */
    public void setPayerBankAccountNativeIdentifier(long value) {
        this.payerBankAccountNativeIdentifier = value;
    }

    /**
     * Gets the value of the processControlIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessControlIdentifier() {
        return processControlIdentifier;
    }

    /**
     * Sets the value of the processControlIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessControlIdentifier(String value) {
        this.processControlIdentifier = value;
    }

    /**
     * Gets the value of the epsPaymentStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link EpsPaymentStatusCode }
     *     
     */
    public EpsPaymentStatusCode getEpsPaymentStatusCode() {
        return epsPaymentStatusCode;
    }

    /**
     * Sets the value of the epsPaymentStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsPaymentStatusCode }
     *     
     */
    public void setEpsPaymentStatusCode(EpsPaymentStatusCode value) {
        this.epsPaymentStatusCode = value;
    }

    /**
     * Gets the value of the epsPaymentErrorStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link EpsPaymentStatusCode }
     *     
     */
    public EpsPaymentStatusCode getEpsPaymentErrorStatusCode() {
        return epsPaymentErrorStatusCode;
    }

    /**
     * Sets the value of the epsPaymentErrorStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsPaymentStatusCode }
     *     
     */
    public void setEpsPaymentErrorStatusCode(EpsPaymentStatusCode value) {
        this.epsPaymentErrorStatusCode = value;
    }

    /**
     * Gets the value of the paymentErrorDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentErrorDateTime() {
        return paymentErrorDateTime;
    }

    /**
     * Sets the value of the paymentErrorDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentErrorDateTime(XMLGregorianCalendar value) {
        this.paymentErrorDateTime = value;
    }

    /**
     * Gets the value of the vcpReoriginationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVcpReoriginationDate() {
        return vcpReoriginationDate;
    }

    /**
     * Sets the value of the vcpReoriginationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVcpReoriginationDate(XMLGregorianCalendar value) {
        this.vcpReoriginationDate = value;
    }

    /**
     * Gets the value of the proxyIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyIdentifier() {
        return proxyIdentifier;
    }

    /**
     * Sets the value of the proxyIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyIdentifier(String value) {
        this.proxyIdentifier = value;
    }

    /**
     * Gets the value of the epsProviderPaymentAdjustments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epsProviderPaymentAdjustments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpsProviderPaymentAdjustments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpsProviderPaymentAdjustment }
     * 
     * 
     */
    public List<EpsProviderPaymentAdjustment> getEpsProviderPaymentAdjustments() {
        if (epsProviderPaymentAdjustments == null) {
            epsProviderPaymentAdjustments = new ArrayList<EpsProviderPaymentAdjustment>();
        }
        return this.epsProviderPaymentAdjustments;
    }

}