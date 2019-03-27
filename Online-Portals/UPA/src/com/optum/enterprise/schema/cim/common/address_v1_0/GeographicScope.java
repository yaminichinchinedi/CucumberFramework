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
import com.optum.enterprise.schema.cim.common.code_v1_0.CountryCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.StateUSCode;


/**
 * 
 * 				Represents geographic metadata such as Country, State etc. To be
 * 				used where Country/State dependency is required for certain
 * 				contexts, without specific addresses. Examples could be 
 * 				Law Course offerings based on Country/State specificity.  
 * 			
 * 
 * <p>Java class for GeographicScope complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeographicScope">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CountryCode"/>
 *         &lt;choice>
 *           &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}StateUSCode"/>
 *           &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}State"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicScope", propOrder = {
    "countryCode",
    "stateUSCode",
    "state"
})
public class GeographicScope {

    @XmlElement(name = "CountryCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected CountryCode countryCode;
    @XmlElement(name = "StateUSCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected StateUSCode stateUSCode;
    @XmlElement(name = "State")
    protected String state;

    /**
     * 
     * 						Country associated with this Geographic metadata.
     * 					
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

    /**
     * Gets the value of the stateUSCode property.
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
     * Gets the value of the state property.
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

}
