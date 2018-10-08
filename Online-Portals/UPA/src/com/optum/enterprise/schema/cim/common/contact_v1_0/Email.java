//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.contact_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.code_v1_0.EmailAddressTypeCode;


/**
 * <p>Java class for Email complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Email">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}EmailAddressTypeCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}EmailAddress"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Email", propOrder = {
    "emailAddressTypeCode",
    "emailAddress"
})
public class Email {

    @XmlElement(name = "EmailAddressTypeCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected EmailAddressTypeCode emailAddressTypeCode;
    @XmlElement(name = "EmailAddress", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected String emailAddress;

    /**
     * Gets the value of the emailAddressTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link EmailAddressTypeCode }
     *     
     */
    public EmailAddressTypeCode getEmailAddressTypeCode() {
        return emailAddressTypeCode;
    }

    /**
     * Sets the value of the emailAddressTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailAddressTypeCode }
     *     
     */
    public void setEmailAddressTypeCode(EmailAddressTypeCode value) {
        this.emailAddressTypeCode = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

}
