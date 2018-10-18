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
import com.optum.enterprise.schema.cim.common.common_v1_0.Currency;


/**
 * <p>Java class for EpsRosterDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsRosterDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdjustmentCodeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlanNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemberTotalCapitationAmount" type="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Currency" minOccurs="0"/>
 *         &lt;element name="CapitationAdjustmentAmount" type="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Currency" minOccurs="0"/>
 *         &lt;element name="RetroCapitationAmount" type="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Currency" minOccurs="0"/>
 *         &lt;element name="CurrentCapitationAmount" type="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Currency" minOccurs="0"/>
 *         &lt;element name="PriorBalanceAmount" type="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Currency" minOccurs="0"/>
 *         &lt;element name="ProviderTerminationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ProviderEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EligibilityStatusCodeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}GroupIdentifier" minOccurs="0"/>
 *         &lt;element name="MemberName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemberIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CoverageMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}SubscriberIdentifier"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ConsolidatedPaymentNumber"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsRosterDetail", propOrder = {
    "adjustmentCodeText",
    "planNumber",
    "memberTotalCapitationAmount",
    "capitationAdjustmentAmount",
    "retroCapitationAmount",
    "currentCapitationAmount",
    "priorBalanceAmount",
    "providerTerminationDate",
    "providerEffectiveDate",
    "eligibilityStatusCodeText",
    "groupIdentifier",
    "memberName",
    "memberIdentifier",
    "coverageMonth",
    "subscriberIdentifier",
    "consolidatedPaymentNumber"
})
public class EpsRosterDetail {

    @XmlElement(name = "AdjustmentCodeText")
    protected String adjustmentCodeText;
    @XmlElement(name = "PlanNumber")
    protected String planNumber;
    @XmlElement(name = "MemberTotalCapitationAmount")
    protected Currency memberTotalCapitationAmount;
    @XmlElement(name = "CapitationAdjustmentAmount")
    protected Currency capitationAdjustmentAmount;
    @XmlElement(name = "RetroCapitationAmount")
    protected Currency retroCapitationAmount;
    @XmlElement(name = "CurrentCapitationAmount")
    protected Currency currentCapitationAmount;
    @XmlElement(name = "PriorBalanceAmount")
    protected Currency priorBalanceAmount;
    @XmlElement(name = "ProviderTerminationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar providerTerminationDate;
    @XmlElement(name = "ProviderEffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar providerEffectiveDate;
    @XmlElement(name = "EligibilityStatusCodeText")
    protected String eligibilityStatusCodeText;
    @XmlElement(name = "GroupIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String groupIdentifier;
    @XmlElement(name = "MemberName")
    protected String memberName;
    @XmlElement(name = "MemberIdentifier")
    protected String memberIdentifier;
    @XmlElement(name = "CoverageMonth")
    protected String coverageMonth;
    @XmlElement(name = "SubscriberIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String subscriberIdentifier;
    @XmlElement(name = "ConsolidatedPaymentNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String consolidatedPaymentNumber;

    /**
     * Gets the value of the adjustmentCodeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjustmentCodeText() {
        return adjustmentCodeText;
    }

    /**
     * Sets the value of the adjustmentCodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjustmentCodeText(String value) {
        this.adjustmentCodeText = value;
    }

    /**
     * Gets the value of the planNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanNumber() {
        return planNumber;
    }

    /**
     * Sets the value of the planNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanNumber(String value) {
        this.planNumber = value;
    }

    /**
     * Gets the value of the memberTotalCapitationAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getMemberTotalCapitationAmount() {
        return memberTotalCapitationAmount;
    }

    /**
     * Sets the value of the memberTotalCapitationAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setMemberTotalCapitationAmount(Currency value) {
        this.memberTotalCapitationAmount = value;
    }

    /**
     * Gets the value of the capitationAdjustmentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCapitationAdjustmentAmount() {
        return capitationAdjustmentAmount;
    }

    /**
     * Sets the value of the capitationAdjustmentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCapitationAdjustmentAmount(Currency value) {
        this.capitationAdjustmentAmount = value;
    }

    /**
     * Gets the value of the retroCapitationAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getRetroCapitationAmount() {
        return retroCapitationAmount;
    }

    /**
     * Sets the value of the retroCapitationAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setRetroCapitationAmount(Currency value) {
        this.retroCapitationAmount = value;
    }

    /**
     * Gets the value of the currentCapitationAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCurrentCapitationAmount() {
        return currentCapitationAmount;
    }

    /**
     * Sets the value of the currentCapitationAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrentCapitationAmount(Currency value) {
        this.currentCapitationAmount = value;
    }

    /**
     * Gets the value of the priorBalanceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getPriorBalanceAmount() {
        return priorBalanceAmount;
    }

    /**
     * Sets the value of the priorBalanceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setPriorBalanceAmount(Currency value) {
        this.priorBalanceAmount = value;
    }

    /**
     * Gets the value of the providerTerminationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProviderTerminationDate() {
        return providerTerminationDate;
    }

    /**
     * Sets the value of the providerTerminationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProviderTerminationDate(XMLGregorianCalendar value) {
        this.providerTerminationDate = value;
    }

    /**
     * Gets the value of the providerEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProviderEffectiveDate() {
        return providerEffectiveDate;
    }

    /**
     * Sets the value of the providerEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProviderEffectiveDate(XMLGregorianCalendar value) {
        this.providerEffectiveDate = value;
    }

    /**
     * Gets the value of the eligibilityStatusCodeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEligibilityStatusCodeText() {
        return eligibilityStatusCodeText;
    }

    /**
     * Sets the value of the eligibilityStatusCodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEligibilityStatusCodeText(String value) {
        this.eligibilityStatusCodeText = value;
    }

    /**
     * Gets the value of the groupIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupIdentifier() {
        return groupIdentifier;
    }

    /**
     * Sets the value of the groupIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupIdentifier(String value) {
        this.groupIdentifier = value;
    }

    /**
     * Gets the value of the memberName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * Sets the value of the memberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberName(String value) {
        this.memberName = value;
    }

    /**
     * Gets the value of the memberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberIdentifier() {
        return memberIdentifier;
    }

    /**
     * Sets the value of the memberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberIdentifier(String value) {
        this.memberIdentifier = value;
    }

    /**
     * Gets the value of the coverageMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverageMonth() {
        return coverageMonth;
    }

    /**
     * Sets the value of the coverageMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverageMonth(String value) {
        this.coverageMonth = value;
    }

    /**
     * Gets the value of the subscriberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberIdentifier() {
        return subscriberIdentifier;
    }

    /**
     * Sets the value of the subscriberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberIdentifier(String value) {
        this.subscriberIdentifier = value;
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

}
