//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.address_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.code_v1_0.CountryCode;


/**
 * <p>Java class for AbstractAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StreetLine1" type="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}AddressLineType"/>
 *         &lt;element name="StreetLine2" type="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}AddressLineType" minOccurs="0"/>
 *         &lt;element name="StreetLine3" type="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}AddressLineType" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}City"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CountryCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractAddress", propOrder = {
    "streetLine1",
    "streetLine2",
    "streetLine3",
    "city",
    "countryCode"
})
@XmlSeeAlso({
    InternationalAddress.class,
    USAddress.class
})
public abstract class AbstractAddress {

    @XmlElement(name = "StreetLine1", required = true)
    protected String streetLine1;
    @XmlElement(name = "StreetLine2")
    protected String streetLine2;
    @XmlElement(name = "StreetLine3")
    protected String streetLine3;
    @XmlElement(name = "City", required = true)
    protected String city;
    @XmlElement(name = "CountryCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected CountryCode countryCode;

    /**
     * Gets the value of the streetLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetLine1() {
        return streetLine1;
    }

    /**
     * Sets the value of the streetLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetLine1(String value) {
        this.streetLine1 = value;
    }

    /**
     * Gets the value of the streetLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetLine2() {
        return streetLine2;
    }

    /**
     * Sets the value of the streetLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetLine2(String value) {
        this.streetLine2 = value;
    }

    /**
     * Gets the value of the streetLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetLine3() {
        return streetLine3;
    }

    /**
     * Sets the value of the streetLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetLine3(String value) {
        this.streetLine3 = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link CountryCode }
     *     
     */
    public CountryCode getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCode }
     *     
     */
    public void setCountryCode(CountryCode value) {
        this.countryCode = value;
    }

}
