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
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.code_v1_0.StateUSCode;


/**
 * <p>Java class for USAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="USAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}AbstractAddress">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}StateUSCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}State"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}PostalUSCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}PostalUSCodeAddOn" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}CountyUSName" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}CountyUSFipsCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "USAddress", propOrder = {
    "stateUSCode",
    "state",
    "postalUSCode",
    "postalUSCodeAddOn",
    "countyUSName",
    "countyUSFipsCode"
})
public class USAddress
    extends AbstractAddress
{

    @XmlElement(name = "StateUSCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected StateUSCode stateUSCode;
    @XmlElement(name = "State", required = true)
    protected String state;
    @XmlElement(name = "PostalUSCode", required = true)
    protected String postalUSCode;
    @XmlElement(name = "PostalUSCodeAddOn")
    protected String postalUSCodeAddOn;
    @XmlElement(name = "CountyUSName")
    protected String countyUSName;
    @XmlElement(name = "CountyUSFipsCode")
    protected String countyUSFipsCode;

    /**
     * 
     * 								US State codes/abbreviations.
     * 							
     * 
     * @return
     *     possible object is
     *     {@link StateUSCode }
     *     
     */
    public StateUSCode getStateUSCode() {
        return stateUSCode;
    }

    /**
     * Sets the value of the stateUSCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateUSCode }
     *     
     */
    public void setStateUSCode(StateUSCode value) {
        this.stateUSCode = value;
    }

    /**
     * 
     * 								Full name of the US State.
     * 							
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalUSCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalUSCode() {
        return postalUSCode;
    }

    /**
     * Sets the value of the postalUSCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalUSCode(String value) {
        this.postalUSCode = value;
    }

    /**
     * Gets the value of the postalUSCodeAddOn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalUSCodeAddOn() {
        return postalUSCodeAddOn;
    }

    /**
     * Sets the value of the postalUSCodeAddOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalUSCodeAddOn(String value) {
        this.postalUSCodeAddOn = value;
    }

    /**
     * Gets the value of the countyUSName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountyUSName() {
        return countyUSName;
    }

    /**
     * Sets the value of the countyUSName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountyUSName(String value) {
        this.countyUSName = value;
    }

    /**
     * Gets the value of the countyUSFipsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountyUSFipsCode() {
        return countyUSFipsCode;
    }

    /**
     * Sets the value of the countyUSFipsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountyUSFipsCode(String value) {
        this.countyUSFipsCode = value;
    }

}
