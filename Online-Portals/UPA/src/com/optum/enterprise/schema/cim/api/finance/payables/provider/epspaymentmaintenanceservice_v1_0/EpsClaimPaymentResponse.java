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
import com.optum.enterprise.schema.cim.common.code_v1_0.BaseCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.PaymentMethodCode;
import com.optum.enterprise.schema.cim.common.common_v1_0.Currency;


/**
 * <p>Java class for EpsClaimPaymentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsClaimPaymentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}NachaResponseIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ConsolidatedPaymentNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PrimaryPayer"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}ReturnedOn"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}ReturnedAmount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}OriginalRoutingTransitNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}NewRoutingTransitNumber" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}OriginalBankAccountNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}NewBankAccountNumber" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}OriginalTransactionCodeText"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}NewTransactionCodeText" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}PaymentReturnedReasonCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ReturnedPaymentTypeCodeText"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ReturnedPaymentStatusCodeText"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}PaymentMethodCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CreatedOn"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}CreatedBy"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsReturnedReoriginatedClaimPayment"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ReoriginatedApFileProcess" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsClaimPaymentResponse", propOrder = {
    "nachaResponseIdentifier",
    "consolidatedPaymentNumber",
    "primaryPayer",
    "returnedOn",
    "returnedAmount",
    "originalRoutingTransitNumber",
    "newRoutingTransitNumber",
    "originalBankAccountNumber",
    "newBankAccountNumber",
    "originalTransactionCodeText",
    "newTransactionCodeText",
    "paymentReturnedReasonCode",
    "returnedPaymentTypeCodeText",
    "returnedPaymentStatusCodeText",
    "paymentMethodCode",
    "createdOn",
    "createdBy",
    "epsReturnedReoriginatedClaimPayment",
    "reoriginatedApFileProcess"
})
public class EpsClaimPaymentResponse {

    @XmlElement(name = "NachaResponseIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    protected String nachaResponseIdentifier;
    @XmlElement(name = "ConsolidatedPaymentNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String consolidatedPaymentNumber;
    @XmlElement(name = "PrimaryPayer", required = true)
    protected EpsPayer primaryPayer;
    @XmlElement(name = "ReturnedOn", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar returnedOn;
    @XmlElement(name = "ReturnedAmount", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected Currency returnedAmount;
    @XmlElement(name = "OriginalRoutingTransitNumber", required = true)
    protected String originalRoutingTransitNumber;
    @XmlElement(name = "NewRoutingTransitNumber")
    protected String newRoutingTransitNumber;
    @XmlElement(name = "OriginalBankAccountNumber", required = true)
    protected String originalBankAccountNumber;
    @XmlElement(name = "NewBankAccountNumber", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0")
    protected Long newBankAccountNumber;
    @XmlElement(name = "OriginalTransactionCodeText", required = true)
    protected String originalTransactionCodeText;
    @XmlElement(name = "NewTransactionCodeText")
    protected String newTransactionCodeText;
    @XmlElement(name = "PaymentReturnedReasonCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected BaseCode paymentReturnedReasonCode;
    @XmlElement(name = "ReturnedPaymentTypeCodeText", required = true)
    protected String returnedPaymentTypeCodeText;
    @XmlElement(name = "ReturnedPaymentStatusCodeText", required = true)
    protected String returnedPaymentStatusCodeText;
    @XmlElement(name = "PaymentMethodCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected PaymentMethodCode paymentMethodCode;
    @XmlElement(name = "CreatedOn", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdOn;
    @XmlElement(name = "CreatedBy", required = true)
    protected String createdBy;
    @XmlElement(name = "EpsReturnedReoriginatedClaimPayment", required = true)
    protected EpsReturnedReoriginatedClaimPayment epsReturnedReoriginatedClaimPayment;
    @XmlElement(name = "ReoriginatedApFileProcess")
    protected String reoriginatedApFileProcess;

    /**
     * Gets the value of the nachaResponseIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNachaResponseIdentifier() {
        return nachaResponseIdentifier;
    }

    /**
     * Sets the value of the nachaResponseIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNachaResponseIdentifier(String value) {
        this.nachaResponseIdentifier = value;
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
     * Gets the value of the primaryPayer property.
     * 
     * @return
     *     possible object is
     *     {@link EpsPayer }
     *     
     */
    public EpsPayer getPrimaryPayer() {
        return primaryPayer;
    }

    /**
     * Sets the value of the primaryPayer property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsPayer }
     *     
     */
    public void setPrimaryPayer(EpsPayer value) {
        this.primaryPayer = value;
    }

    /**
     * Gets the value of the returnedOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReturnedOn() {
        return returnedOn;
    }

    /**
     * Sets the value of the returnedOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReturnedOn(XMLGregorianCalendar value) {
        this.returnedOn = value;
    }

    /**
     * Gets the value of the returnedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getReturnedAmount() {
        return returnedAmount;
    }

    /**
     * Sets the value of the returnedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setReturnedAmount(Currency value) {
        this.returnedAmount = value;
    }

    /**
     * Gets the value of the originalRoutingTransitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalRoutingTransitNumber() {
        return originalRoutingTransitNumber;
    }

    /**
     * Sets the value of the originalRoutingTransitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalRoutingTransitNumber(String value) {
        this.originalRoutingTransitNumber = value;
    }

    /**
     * Gets the value of the newRoutingTransitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewRoutingTransitNumber() {
        return newRoutingTransitNumber;
    }

    /**
     * Sets the value of the newRoutingTransitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewRoutingTransitNumber(String value) {
        this.newRoutingTransitNumber = value;
    }

    /**
     * Gets the value of the originalBankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalBankAccountNumber() {
        return originalBankAccountNumber;
    }

    /**
     * Sets the value of the originalBankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalBankAccountNumber(String value) {
        this.originalBankAccountNumber = value;
    }

    /**
     * Gets the value of the newBankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNewBankAccountNumber() {
        return newBankAccountNumber;
    }

    /**
     * Sets the value of the newBankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNewBankAccountNumber(Long value) {
        this.newBankAccountNumber = value;
    }

    /**
     * Gets the value of the originalTransactionCodeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalTransactionCodeText() {
        return originalTransactionCodeText;
    }

    /**
     * Sets the value of the originalTransactionCodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalTransactionCodeText(String value) {
        this.originalTransactionCodeText = value;
    }

    /**
     * Gets the value of the newTransactionCodeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTransactionCodeText() {
        return newTransactionCodeText;
    }

    /**
     * Sets the value of the newTransactionCodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTransactionCodeText(String value) {
        this.newTransactionCodeText = value;
    }

    /**
     * Gets the value of the paymentReturnedReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link BaseCode }
     *     
     */
    public BaseCode getPaymentReturnedReasonCode() {
        return paymentReturnedReasonCode;
    }

    /**
     * Sets the value of the paymentReturnedReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseCode }
     *     
     */
    public void setPaymentReturnedReasonCode(BaseCode value) {
        this.paymentReturnedReasonCode = value;
    }

    /**
     * Gets the value of the returnedPaymentTypeCodeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnedPaymentTypeCodeText() {
        return returnedPaymentTypeCodeText;
    }

    /**
     * Sets the value of the returnedPaymentTypeCodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnedPaymentTypeCodeText(String value) {
        this.returnedPaymentTypeCodeText = value;
    }

    /**
     * Gets the value of the returnedPaymentStatusCodeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnedPaymentStatusCodeText() {
        return returnedPaymentStatusCodeText;
    }

    /**
     * Sets the value of the returnedPaymentStatusCodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnedPaymentStatusCodeText(String value) {
        this.returnedPaymentStatusCodeText = value;
    }

    /**
     * Gets the value of the paymentMethodCode property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodCode }
     *     
     */
    public PaymentMethodCode getPaymentMethodCode() {
        return paymentMethodCode;
    }

    /**
     * Sets the value of the paymentMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodCode }
     *     
     */
    public void setPaymentMethodCode(PaymentMethodCode value) {
        this.paymentMethodCode = value;
    }

    /**
     * Gets the value of the createdOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the value of the createdOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedOn(XMLGregorianCalendar value) {
        this.createdOn = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the epsReturnedReoriginatedClaimPayment property.
     * 
     * @return
     *     possible object is
     *     {@link EpsReturnedReoriginatedClaimPayment }
     *     
     */
    public EpsReturnedReoriginatedClaimPayment getEpsReturnedReoriginatedClaimPayment() {
        return epsReturnedReoriginatedClaimPayment;
    }

    /**
     * Sets the value of the epsReturnedReoriginatedClaimPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsReturnedReoriginatedClaimPayment }
     *     
     */
    public void setEpsReturnedReoriginatedClaimPayment(EpsReturnedReoriginatedClaimPayment value) {
        this.epsReturnedReoriginatedClaimPayment = value;
    }

    /**
     * Gets the value of the reoriginatedApFileProcess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReoriginatedApFileProcess() {
        return reoriginatedApFileProcess;
    }

    /**
     * Sets the value of the reoriginatedApFileProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReoriginatedApFileProcess(String value) {
        this.reoriginatedApFileProcess = value;
    }

}
