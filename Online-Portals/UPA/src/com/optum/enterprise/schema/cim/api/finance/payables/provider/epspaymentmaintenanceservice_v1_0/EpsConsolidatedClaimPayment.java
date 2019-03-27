//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0;

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
import com.optum.enterprise.schema.cim.common.code_v1_0.MerchantClassificationCode;
import com.optum.enterprise.schema.cim.common.multimedia_v1_0.TextFileContent;
import com.optum.enterprise.schema.cim.common.payment_v1_0.Payment;
import com.optum.enterprise.schema.cim.provider.provider_v1_0.Provider;


/**
 * 
 * 				
 * 				Consolidated payment for services paid to Service Providers.
 * 				
 * 			
 * 
 * <p>Java class for EpsConsolidatedClaimPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsConsolidatedClaimPayment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Payment_v1_0}Payment">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsProvider"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}SchemaName"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ConsolidatedPaymentNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/provider/Provider_v1_0}ReferringProvider" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsPayer"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}DepositDate"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsAmbulatoryPaymentIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}InternalControlIdentifier" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PaymentTypeIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProcessDateTime"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProcessDate"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}DisplayConsolidatedPaymentNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PayerBankAccountNativeIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PullFundIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProcessControlIdentifier" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsPaymentStatusCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PaymentStatusTypeDateTime" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}MerchantClassificationCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProxyIdentifier" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}TraceNumber" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ArchiveIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsPaymentErrorStatusCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}PaymentErrorDateTime" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}VcpReoriginationDate" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsConsolidatedClaimPaymentDetails" maxOccurs="500000" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsUnconsolidatedClaimPayments" maxOccurs="500000" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}Edi835FileContent"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsClaimPaymentResponses" maxOccurs="500000" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsConsolidatedPaymentStatusHistories" maxOccurs="500000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsConsolidatedClaimPayment", propOrder = {
    "epsProvider",
    "schemaName",
    "consolidatedPaymentNumber",
    "referringProvider",
    "epsPayer",
    "depositDate",
    "epsAmbulatoryPaymentIndicator",
    "internalControlIdentifier",
    "paymentTypeIndicator",
    "processDateTime",
    "processDate",
    "displayConsolidatedPaymentNumber",
    "payerBankAccountNativeIdentifier",
    "pullFundIndicator",
    "processControlIdentifier",
    "epsPaymentStatusCode",
    "paymentStatusTypeDateTime",
    "merchantClassificationCode",
    "proxyIdentifier",
    "traceNumber",
    "archiveIndicator",
    "epsPaymentErrorStatusCode",
    "paymentErrorDateTime",
    "vcpReoriginationDate",
    "epsConsolidatedClaimPaymentDetails",
    "epsUnconsolidatedClaimPayments",
    "edi835FileContent",
    "epsClaimPaymentResponses",
    "epsConsolidatedPaymentStatusHistories"
})
public class EpsConsolidatedClaimPayment
    extends Payment
{

    @XmlElement(name = "EpsProvider", required = true)
    protected EpsProvider epsProvider;
    @XmlElement(name = "SchemaName", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected String schemaName;
    @XmlElement(name = "ConsolidatedPaymentNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String consolidatedPaymentNumber;
    @XmlElement(name = "ReferringProvider", namespace = "http://enterprise.optum.com/schema/cim/provider/Provider_v1_0")
    protected Provider referringProvider;
    @XmlElement(name = "EpsPayer", required = true)
    protected EpsPayer epsPayer;
    @XmlElement(name = "DepositDate", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar depositDate;
    @XmlElement(name = "EpsAmbulatoryPaymentIndicator")
    protected String epsAmbulatoryPaymentIndicator;
    @XmlElement(name = "InternalControlIdentifier")
    protected String internalControlIdentifier;
    @XmlElement(name = "PaymentTypeIndicator")
    protected String paymentTypeIndicator;
    @XmlElement(name = "ProcessDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processDateTime;
    @XmlElement(name = "ProcessDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar processDate;
    @XmlElement(name = "DisplayConsolidatedPaymentNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String displayConsolidatedPaymentNumber;
    @XmlElement(name = "PayerBankAccountNativeIdentifier")
    protected long payerBankAccountNativeIdentifier;
    @XmlElement(name = "PullFundIndicator")
    protected String pullFundIndicator;
    @XmlElement(name = "ProcessControlIdentifier")
    protected String processControlIdentifier;
    @XmlElement(name = "EpsPaymentStatusCode")
    protected EpsPaymentStatusCode epsPaymentStatusCode;
    @XmlElement(name = "PaymentStatusTypeDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentStatusTypeDateTime;
    @XmlElement(name = "MerchantClassificationCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected MerchantClassificationCode merchantClassificationCode;
    @XmlElement(name = "ProxyIdentifier")
    protected String proxyIdentifier;
    @XmlElement(name = "TraceNumber")
    protected String traceNumber;
    @XmlElement(name = "ArchiveIndicator")
    protected String archiveIndicator;
    @XmlElement(name = "EpsPaymentErrorStatusCode")
    protected EpsPaymentStatusCode epsPaymentErrorStatusCode;
    @XmlElement(name = "PaymentErrorDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentErrorDateTime;
    @XmlElement(name = "VcpReoriginationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vcpReoriginationDate;
    @XmlElement(name = "EpsConsolidatedClaimPaymentDetails")
    protected List<EpsConsolidatedClaimPaymentDetail> epsConsolidatedClaimPaymentDetails;
    @XmlElement(name = "EpsUnconsolidatedClaimPayments")
    protected List<EpsUnconsolidatedClaimPayment> epsUnconsolidatedClaimPayments;
    @XmlElement(name = "Edi835FileContent", required = true)
    protected TextFileContent edi835FileContent;
    @XmlElement(name = "EpsClaimPaymentResponses")
    protected List<EpsClaimPaymentResponse> epsClaimPaymentResponses;
    @XmlElement(name = "EpsConsolidatedPaymentStatusHistories")
    protected List<EpsConsolidatedClaimPaymentStatusHistory> epsConsolidatedPaymentStatusHistories;

    /**
     * 
     * 								
     * 								All <code>ClaimPayment</code>s are made to 
     * 								particular provider.
     * 								<p/> 
     * 								MASOOD: TBD: Claim Payments will always be 
     * 								associated with a single Provider 
     * 								(Meeting Aug 15, 2016: Steve Vaerten/Michael Bublitz). 
     * 								As such we need	this association here. Make sure
     * 								that this is actually true from the business SME.
     * 								
     * 							
     * 
     * @return
     *     possible object is
     *     {@link EpsProvider }
     *     
     */
    public EpsProvider getEpsProvider() {
        return epsProvider;
    }

    /**
     * Sets the value of the epsProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsProvider }
     *     
     */
    public void setEpsProvider(EpsProvider value) {
        this.epsProvider = value;
    }

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
     * Gets the value of the referringProvider property.
     * 
     * @return
     *     possible object is
     *     {@link Provider }
     *     
     */
    public Provider getReferringProvider() {
        return referringProvider;
    }

    /**
     * Sets the value of the referringProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link Provider }
     *     
     */
    public void setReferringProvider(Provider value) {
        this.referringProvider = value;
    }

    /**
     * Gets the value of the epsPayer property.
     * 
     * @return
     *     possible object is
     *     {@link EpsPayer }
     *     
     */
    public EpsPayer getEpsPayer() {
        return epsPayer;
    }

    /**
     * Sets the value of the epsPayer property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsPayer }
     *     
     */
    public void setEpsPayer(EpsPayer value) {
        this.epsPayer = value;
    }

    /**
     * Gets the value of the depositDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepositDate() {
        return depositDate;
    }

    /**
     * Sets the value of the depositDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepositDate(XMLGregorianCalendar value) {
        this.depositDate = value;
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
     * Gets the value of the internalControlIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalControlIdentifier() {
        return internalControlIdentifier;
    }

    /**
     * Sets the value of the internalControlIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalControlIdentifier(String value) {
        this.internalControlIdentifier = value;
    }

    /**
     * Gets the value of the paymentTypeIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentTypeIndicator() {
        return paymentTypeIndicator;
    }

    /**
     * Sets the value of the paymentTypeIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentTypeIndicator(String value) {
        this.paymentTypeIndicator = value;
    }

    /**
     * Gets the value of the processDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessDateTime() {
        return processDateTime;
    }

    /**
     * Sets the value of the processDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessDateTime(XMLGregorianCalendar value) {
        this.processDateTime = value;
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
     * 
     * 								
     * 								This is native datastore key value. Must not be 
     * 								used in Service and data contracts 
     * 								(Request/Response) objects.
     * 								
     * 							
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
     * Gets the value of the pullFundIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPullFundIndicator() {
        return pullFundIndicator;
    }

    /**
     * Sets the value of the pullFundIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPullFundIndicator(String value) {
        this.pullFundIndicator = value;
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
     * Gets the value of the paymentStatusTypeDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentStatusTypeDateTime() {
        return paymentStatusTypeDateTime;
    }

    /**
     * Sets the value of the paymentStatusTypeDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentStatusTypeDateTime(XMLGregorianCalendar value) {
        this.paymentStatusTypeDateTime = value;
    }

    /**
     * Gets the value of the merchantClassificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantClassificationCode }
     *     
     */
    public MerchantClassificationCode getMerchantClassificationCode() {
        return merchantClassificationCode;
    }

    /**
     * Sets the value of the merchantClassificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantClassificationCode }
     *     
     */
    public void setMerchantClassificationCode(MerchantClassificationCode value) {
        this.merchantClassificationCode = value;
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
     * Gets the value of the archiveIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiveIndicator() {
        return archiveIndicator;
    }

    /**
     * Sets the value of the archiveIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiveIndicator(String value) {
        this.archiveIndicator = value;
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
     * Gets the value of the epsConsolidatedClaimPaymentDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epsConsolidatedClaimPaymentDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpsConsolidatedClaimPaymentDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpsConsolidatedClaimPaymentDetail }
     * 
     * 
     */
    public List<EpsConsolidatedClaimPaymentDetail> getEpsConsolidatedClaimPaymentDetails() {
        if (epsConsolidatedClaimPaymentDetails == null) {
            epsConsolidatedClaimPaymentDetails = new ArrayList<EpsConsolidatedClaimPaymentDetail>();
        }
        return this.epsConsolidatedClaimPaymentDetails;
    }

    /**
     * Gets the value of the epsUnconsolidatedClaimPayments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epsUnconsolidatedClaimPayments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpsUnconsolidatedClaimPayments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpsUnconsolidatedClaimPayment }
     * 
     * 
     */
    public List<EpsUnconsolidatedClaimPayment> getEpsUnconsolidatedClaimPayments() {
        if (epsUnconsolidatedClaimPayments == null) {
            epsUnconsolidatedClaimPayments = new ArrayList<EpsUnconsolidatedClaimPayment>();
        }
        return this.epsUnconsolidatedClaimPayments;
    }

    /**
     * Gets the value of the edi835FileContent property.
     * 
     * @return
     *     possible object is
     *     {@link TextFileContent }
     *     
     */
    public TextFileContent getEdi835FileContent() {
        return edi835FileContent;
    }

    /**
     * Sets the value of the edi835FileContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFileContent }
     *     
     */
    public void setEdi835FileContent(TextFileContent value) {
        this.edi835FileContent = value;
    }

    /**
     * Gets the value of the epsClaimPaymentResponses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epsClaimPaymentResponses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpsClaimPaymentResponses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpsClaimPaymentResponse }
     * 
     * 
     */
    public List<EpsClaimPaymentResponse> getEpsClaimPaymentResponses() {
        if (epsClaimPaymentResponses == null) {
            epsClaimPaymentResponses = new ArrayList<EpsClaimPaymentResponse>();
        }
        return this.epsClaimPaymentResponses;
    }

    /**
     * Gets the value of the epsConsolidatedPaymentStatusHistories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epsConsolidatedPaymentStatusHistories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpsConsolidatedPaymentStatusHistories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpsConsolidatedClaimPaymentStatusHistory }
     * 
     * 
     */
    public List<EpsConsolidatedClaimPaymentStatusHistory> getEpsConsolidatedPaymentStatusHistories() {
        if (epsConsolidatedPaymentStatusHistories == null) {
            epsConsolidatedPaymentStatusHistories = new ArrayList<EpsConsolidatedClaimPaymentStatusHistory>();
        }
        return this.epsConsolidatedPaymentStatusHistories;
    }

}
