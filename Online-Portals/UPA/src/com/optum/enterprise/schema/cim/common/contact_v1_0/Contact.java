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
import com.optum.enterprise.schema.cim.common.code_v1_0.TimezoneCode;
import com.optum.enterprise.schema.cim.common.common_v1_0.Effectable;


/**
 * 
 * 				A contact with effective and end dates.
 * 			
 * 
 * <p>Java class for Contact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Contact">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Effectable">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}TimezoneCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Contact_v1_0}Communication"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact", propOrder = {
    "timezoneCode",
    "communication"
})
public class Contact
    extends Effectable
{

    @XmlElement(name = "TimezoneCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected TimezoneCode timezoneCode;
    @XmlElement(name = "Communication", required = true)
    protected Communication communication;

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

}
