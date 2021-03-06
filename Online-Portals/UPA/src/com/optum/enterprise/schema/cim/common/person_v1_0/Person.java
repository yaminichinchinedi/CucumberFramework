//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.person_v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.optum.enterprise.schema.cim.common.code_v1_0.LocaleCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.TimezoneCode;
import com.optum.enterprise.schema.cim.common.contact_v1_0.Communication;
import com.optum.enterprise.schema.cim.member.member_v1_0.Member;


/**
 * <p>Java class for Person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://enterprise.optum.com/schema/cim/common/Person_v1_0}PersonSummaryGroup"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}LocaleCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}TimezoneCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", propOrder = {
    "personName",
    "personIdentifier",
    "uniquePersonSystemIdentifiers",
    "demographics",
    "communication",
    "localeCode",
    "timezoneCode"
})
@XmlSeeAlso({
    Member.class
})
public class Person {

    @XmlElement(name = "PersonName", required = true)
    protected PersonName personName;
    @XmlElement(name = "PersonIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String personIdentifier;
    @XmlElement(name = "UniquePersonSystemIdentifiers")
    protected List<UniquePersonSystemIdentifier> uniquePersonSystemIdentifiers;
    @XmlElement(name = "Demographics")
    protected Demographics demographics;
    @XmlElement(name = "Communication", namespace = "http://enterprise.optum.com/schema/cim/common/Contact_v1_0")
    protected Communication communication;
    @XmlElement(name = "LocaleCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected LocaleCode localeCode;
    @XmlElement(name = "TimezoneCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected TimezoneCode timezoneCode;

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonName }
     *     
     */
    public PersonName getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonName }
     *     
     */
    public void setPersonName(PersonName value) {
        this.personName = value;
    }

    /**
     * Gets the value of the personIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonIdentifier() {
        return personIdentifier;
    }

    /**
     * Sets the value of the personIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonIdentifier(String value) {
        this.personIdentifier = value;
    }

    /**
     * Gets the value of the uniquePersonSystemIdentifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uniquePersonSystemIdentifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniquePersonSystemIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniquePersonSystemIdentifier }
     * 
     * 
     */
    public List<UniquePersonSystemIdentifier> getUniquePersonSystemIdentifiers() {
        if (uniquePersonSystemIdentifiers == null) {
            uniquePersonSystemIdentifiers = new ArrayList<UniquePersonSystemIdentifier>();
        }
        return this.uniquePersonSystemIdentifiers;
    }

    /**
     * Gets the value of the demographics property.
     * 
     * @return
     *     possible object is
     *     {@link Demographics }
     *     
     */
    public Demographics getDemographics() {
        return demographics;
    }

    /**
     * Sets the value of the demographics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Demographics }
     *     
     */
    public void setDemographics(Demographics value) {
        this.demographics = value;
    }

    /**
     * Gets the value of the communication property.
     * 
     * @return
     *     possible object is
     *     {@link Communication }
     *     
     */
    public Communication getCommunication() {
        return communication;
    }

    /**
     * Sets the value of the communication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Communication }
     *     
     */
    public void setCommunication(Communication value) {
        this.communication = value;
    }

    /**
     * Gets the value of the localeCode property.
     * 
     * @return
     *     possible object is
     *     {@link LocaleCode }
     *     
     */
    public LocaleCode getLocaleCode() {
        return localeCode;
    }

    /**
     * Sets the value of the localeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocaleCode }
     *     
     */
    public void setLocaleCode(LocaleCode value) {
        this.localeCode = value;
    }

    /**
     * Gets the value of the timezoneCode property.
     * 
     * @return
     *     possible object is
     *     {@link TimezoneCode }
     *     
     */
    public TimezoneCode getTimezoneCode() {
        return timezoneCode;
    }

    /**
     * Sets the value of the timezoneCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimezoneCode }
     *     
     */
    public void setTimezoneCode(TimezoneCode value) {
        this.timezoneCode = value;
    }

}
