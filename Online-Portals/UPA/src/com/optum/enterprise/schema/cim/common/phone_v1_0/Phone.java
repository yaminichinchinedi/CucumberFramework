//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.phone_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.code_v1_0.PhoneTypeCode;


/**
 * <p>Java class for Phone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Phone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}PhoneTypeCode" minOccurs="0"/>
 *         &lt;element name="AreaCode" type="{http://enterprise.optum.com/schema/cim/common/Phone_v1_0}PhoneAreaCode"/>
 *         &lt;element name="Subscriber" type="{http://enterprise.optum.com/schema/cim/common/Phone_v1_0}PhoneSubscriberNumber"/>
 *         &lt;element name="Extension" type="{http://enterprise.optum.com/schema/cim/common/Phone_v1_0}PhoneExtensionNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CountryCode" type="{http://enterprise.optum.com/schema/cim/common/Phone_v1_0}PhoneCountryCode" default="1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Phone", propOrder = {
    "phoneTypeCode",
    "areaCode",
    "subscriber",
    "extension"
})
public class Phone {

    @XmlElement(name = "PhoneTypeCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected PhoneTypeCode phoneTypeCode;
    @XmlElement(name = "AreaCode")
    protected long areaCode;
    @XmlElement(name = "Subscriber")
    protected long subscriber;
    @XmlElement(name = "Extension")
    protected Short extension;
    @XmlAttribute(name = "CountryCode")
    protected Integer countryCode;

    /**
     * Gets the value of the phoneTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneTypeCode }
     *     
     */
    public PhoneTypeCode getPhoneTypeCode() {
        return phoneTypeCode;
    }

    /**
     * Sets the value of the phoneTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneTypeCode }
     *     
     */
    public void setPhoneTypeCode(PhoneTypeCode value) {
        this.phoneTypeCode = value;
    }

    /**
     * Gets the value of the areaCode property.
     * 
     */
    public long getAreaCode() {
        return areaCode;
    }

    /**
     * Sets the value of the areaCode property.
     * 
     */
    public void setAreaCode(long value) {
        this.areaCode = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     */
    public long getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     */
    public void setSubscriber(long value) {
        this.subscriber = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setExtension(Short value) {
        this.extension = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getCountryCode() {
        if (countryCode == null) {
            return  1;
        } else {
            return countryCode;
        }
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCountryCode(Integer value) {
        this.countryCode = value;
    }

}
