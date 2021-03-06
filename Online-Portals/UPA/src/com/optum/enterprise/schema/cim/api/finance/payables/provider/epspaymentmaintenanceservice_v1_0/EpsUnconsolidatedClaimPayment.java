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
import com.optum.enterprise.schema.cim.common.common_v1_0.Currency;


/**
 * 
 * 				
 * 				Consolidated payment for services paid to Service Providers.
 * 				
 * 			
 * 
 * <p>Java class for EpsUnconsolidatedClaimPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsUnconsolidatedClaimPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}UnconsolidatedPaymentNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}AggregateNonCoveredTotalAmount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}AggregatePatientResponsibilityTotalAmount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CoveredTotalAmount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}ClaimTotalAmount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}PaidToProviderTotalAmount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Amount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}DepositDate"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EOBCreateDate" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}UnconsolidatedProcessIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}UnconsolidatedProcessCompleteDate" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}UnconsolidatedComplianceIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsSegmentRoutingIdentifier" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsReferenceSegmentG2Identifier" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsVersionReferenceQualifier" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ConsolidatedIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}OriginalBpr01" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}OriginalBpr01DateTime" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsClaimCount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ProcessDateTime"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsProviderPaymentAdjustments" maxOccurs="500000" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsRosterDetail"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsRosterTotal"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsClaims" maxOccurs="500000"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsUnconsolidatedClaimPayment", propOrder = {
    "unconsolidatedPaymentNumber",
    "aggregateNonCoveredTotalAmount",
    "aggregatePatientResponsibilityTotalAmount",
    "coveredTotalAmount",
    "claimTotalAmount",
    "paidToProviderTotalAmount",
    "amount",
    "depositDate",
    "eobCreateDate",
    "unconsolidatedProcessIndicator",
    "unconsolidatedProcessCompleteDate",
    "unconsolidatedComplianceIndicator",
    "epsSegmentRoutingIdentifier",
    "epsReferenceSegmentG2Identifier",
    "epsVersionReferenceQualifier",
    "consolidatedIndicator",
    "originalBpr01",
    "originalBpr01DateTime",
    "epsClaimCount",
    "processDateTime",
    "epsProviderPaymentAdjustments",
    "epsRosterDetail",
    "epsRosterTotal",
    "epsClaims"
})
public class EpsUnconsolidatedClaimPayment {

    @XmlElement(name = "UnconsolidatedPaymentNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String unconsolidatedPaymentNumber;
    @XmlElement(name = "AggregateNonCoveredTotalAmount", required = true)
    protected Currency aggregateNonCoveredTotalAmount;
    @XmlElement(name = "AggregatePatientResponsibilityTotalAmount", required = true)
    protected Currency aggregatePatientResponsibilityTotalAmount;
    @XmlElement(name = "CoveredTotalAmount", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected Currency coveredTotalAmount;
    @XmlElement(name = "ClaimTotalAmount", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected Currency claimTotalAmount;
    @XmlElement(name = "PaidToProviderTotalAmount", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected Currency paidToProviderTotalAmount;
    @XmlElement(name = "Amount", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected Currency amount;
    @XmlElement(name = "DepositDate", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar depositDate;
    @XmlElement(name = "EOBCreateDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar eobCreateDate;
    @XmlElement(name = "UnconsolidatedProcessIndicator")
    protected String unconsolidatedProcessIndicator;
    @XmlElement(name = "UnconsolidatedProcessCompleteDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar unconsolidatedProcessCompleteDate;
    @XmlElement(name = "UnconsolidatedComplianceIndicator")
    protected String unconsolidatedComplianceIndicator;
    @XmlElement(name = "EpsSegmentRoutingIdentifier")
    protected String epsSegmentRoutingIdentifier;
    @XmlElement(name = "EpsReferenceSegmentG2Identifier")
    protected String epsReferenceSegmentG2Identifier;
    @XmlElement(name = "EpsVersionReferenceQualifier")
    protected String epsVersionReferenceQualifier;
    @XmlElement(name = "ConsolidatedIndicator")
    protected String consolidatedIndicator;
    @XmlElement(name = "OriginalBpr01")
    protected String originalBpr01;
    @XmlElement(name = "OriginalBpr01DateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar originalBpr01DateTime;
    @XmlElement(name = "EpsClaimCount")
    protected long epsClaimCount;
    @XmlElement(name = "ProcessDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processDateTime;
    @XmlElement(name = "EpsProviderPaymentAdjustments")
    protected List<EpsProviderPaymentAdjustment> epsProviderPaymentAdjustments;
    @XmlElement(name = "EpsRosterDetail", required = true)
    protected EpsRosterDetail epsRosterDetail;
    @XmlElement(name = "EpsRosterTotal", required = true)
    protected EpsRosterTotal epsRosterTotal;
    @XmlElement(name = "EpsClaims", required = true)
    protected List<EpsClaim> epsClaims;

    /**
     * Gets the value of the unconsolidatedPaymentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnconsolidatedPaymentNumber() {
        return unconsolidatedPaymentNumber;
    }

    /**
     * Sets the value of the unconsolidatedPaymentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnconsolidatedPaymentNumber(String value) {
        this.unconsolidatedPaymentNumber = value;
    }

    /**
     * Gets the value of the aggregateNonCoveredTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getAggregateNonCoveredTotalAmount() {
        return aggregateNonCoveredTotalAmount;
    }

    /**
     * Sets the value of the aggregateNonCoveredTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setAggregateNonCoveredTotalAmount(Currency value) {
        this.aggregateNonCoveredTotalAmount = value;
    }

    /**
     * Gets the value of the aggregatePatientResponsibilityTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getAggregatePatientResponsibilityTotalAmount() {
        return aggregatePatientResponsibilityTotalAmount;
    }

    /**
     * Sets the value of the aggregatePatientResponsibilityTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setAggregatePatientResponsibilityTotalAmount(Currency value) {
        this.aggregatePatientResponsibilityTotalAmount = value;
    }

    /**
     * Gets the value of the coveredTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCoveredTotalAmount() {
        return coveredTotalAmount;
    }

    /**
     * Sets the value of the coveredTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCoveredTotalAmount(Currency value) {
        this.coveredTotalAmount = value;
    }

    /**
     * Gets the value of the claimTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getClaimTotalAmount() {
        return claimTotalAmount;
    }

    /**
     * Sets the value of the claimTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setClaimTotalAmount(Currency value) {
        this.claimTotalAmount = value;
    }

    /**
     * Gets the value of the paidToProviderTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getPaidToProviderTotalAmount() {
        return paidToProviderTotalAmount;
    }

    /**
     * Sets the value of the paidToProviderTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setPaidToProviderTotalAmount(Currency value) {
        this.paidToProviderTotalAmount = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setAmount(Currency value) {
        this.amount = value;
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
     * Gets the value of the eobCreateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEOBCreateDate() {
        return eobCreateDate;
    }

    /**
     * Sets the value of the eobCreateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEOBCreateDate(XMLGregorianCalendar value) {
        this.eobCreateDate = value;
    }

    /**
     * Gets the value of the unconsolidatedProcessIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnconsolidatedProcessIndicator() {
        return unconsolidatedProcessIndicator;
    }

    /**
     * Sets the value of the unconsolidatedProcessIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnconsolidatedProcessIndicator(String value) {
        this.unconsolidatedProcessIndicator = value;
    }

    /**
     * Gets the value of the unconsolidatedProcessCompleteDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUnconsolidatedProcessCompleteDate() {
        return unconsolidatedProcessCompleteDate;
    }

    /**
     * Sets the value of the unconsolidatedProcessCompleteDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUnconsolidatedProcessCompleteDate(XMLGregorianCalendar value) {
        this.unconsolidatedProcessCompleteDate = value;
    }

    /**
     * Gets the value of the unconsolidatedComplianceIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnconsolidatedComplianceIndicator() {
        return unconsolidatedComplianceIndicator;
    }

    /**
     * Sets the value of the unconsolidatedComplianceIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnconsolidatedComplianceIndicator(String value) {
        this.unconsolidatedComplianceIndicator = value;
    }

    /**
     * Gets the value of the epsSegmentRoutingIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpsSegmentRoutingIdentifier() {
        return epsSegmentRoutingIdentifier;
    }

    /**
     * Sets the value of the epsSegmentRoutingIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpsSegmentRoutingIdentifier(String value) {
        this.epsSegmentRoutingIdentifier = value;
    }

    /**
     * Gets the value of the epsReferenceSegmentG2Identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpsReferenceSegmentG2Identifier() {
        return epsReferenceSegmentG2Identifier;
    }

    /**
     * Sets the value of the epsReferenceSegmentG2Identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpsReferenceSegmentG2Identifier(String value) {
        this.epsReferenceSegmentG2Identifier = value;
    }

    /**
     * Gets the value of the epsVersionReferenceQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpsVersionReferenceQualifier() {
        return epsVersionReferenceQualifier;
    }

    /**
     * Sets the value of the epsVersionReferenceQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpsVersionReferenceQualifier(String value) {
        this.epsVersionReferenceQualifier = value;
    }

    /**
     * Gets the value of the consolidatedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsolidatedIndicator() {
        return consolidatedIndicator;
    }

    /**
     * Sets the value of the consolidatedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsolidatedIndicator(String value) {
        this.consolidatedIndicator = value;
    }

    /**
     * Gets the value of the originalBpr01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalBpr01() {
        return originalBpr01;
    }

    /**
     * Sets the value of the originalBpr01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalBpr01(String value) {
        this.originalBpr01 = value;
    }

    /**
     * Gets the value of the originalBpr01DateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOriginalBpr01DateTime() {
        return originalBpr01DateTime;
    }

    /**
     * Sets the value of the originalBpr01DateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOriginalBpr01DateTime(XMLGregorianCalendar value) {
        this.originalBpr01DateTime = value;
    }

    /**
     * Gets the value of the epsClaimCount property.
     * 
     */
    public long getEpsClaimCount() {
        return epsClaimCount;
    }

    /**
     * Sets the value of the epsClaimCount property.
     * 
     */
    public void setEpsClaimCount(long value) {
        this.epsClaimCount = value;
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

    /**
     * Gets the value of the epsRosterDetail property.
     * 
     * @return
     *     possible object is
     *     {@link EpsRosterDetail }
     *     
     */
    public EpsRosterDetail getEpsRosterDetail() {
        return epsRosterDetail;
    }

    /**
     * Sets the value of the epsRosterDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsRosterDetail }
     *     
     */
    public void setEpsRosterDetail(EpsRosterDetail value) {
        this.epsRosterDetail = value;
    }

    /**
     * Gets the value of the epsRosterTotal property.
     * 
     * @return
     *     possible object is
     *     {@link EpsRosterTotal }
     *     
     */
    public EpsRosterTotal getEpsRosterTotal() {
        return epsRosterTotal;
    }

    /**
     * Sets the value of the epsRosterTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpsRosterTotal }
     *     
     */
    public void setEpsRosterTotal(EpsRosterTotal value) {
        this.epsRosterTotal = value;
    }

    /**
     * Gets the value of the epsClaims property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epsClaims property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpsClaims().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpsClaim }
     * 
     * 
     */
    public List<EpsClaim> getEpsClaims() {
        if (epsClaims == null) {
            epsClaims = new ArrayList<EpsClaim>();
        }
        return this.epsClaims;
    }

}
