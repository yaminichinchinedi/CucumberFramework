//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.service_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				For use with specifying a URL related configuration.
 * 			
 * 
 * <p>Java class for UrlConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UrlConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Service_v1_0}Url"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Service_v1_0}SecurityCredential" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UrlConfig", propOrder = {
    "url",
    "securityCredential"
})
public class UrlConfig {

    @XmlElement(name = "Url", required = true)
    protected Url url;
    @XmlElement(name = "SecurityCredential")
    protected SecurityCredential securityCredential;

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link Url }
     *     
     */
    public Url getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link Url }
     *     
     */
    public void setUrl(Url value) {
        this.url = value;
    }

    /**
     * Gets the value of the securityCredential property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityCredential }
     *     
     */
    public SecurityCredential getSecurityCredential() {
        return securityCredential;
    }

    /**
     * Sets the value of the securityCredential property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityCredential }
     *     
     */
    public void setSecurityCredential(SecurityCredential value) {
        this.securityCredential = value;
    }

}
