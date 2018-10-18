//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.code_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				MASOOD: From EDI specs:
 * 				B = Registered Domestic
 * 				Partner
 * 				D = Divorced
 * 				I = Single
 * 				M = Married
 * 				R = Unreported
 * 				S = Separated
 * 				U = Unmarried (Single or Divorced or Widowed)
 * 				W = Widowed
 * 				X = Legally
 * 				Separated
 * 			
 * 
 * <p>Java class for MaritalStatusCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MaritalStatusCode">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}AbstractEnumeratedCode">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}MaritalStatusCodeEnum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaritalStatusCode", propOrder = {
    "code"
})
public class MaritalStatusCode
    extends AbstractEnumeratedCode
{

    @XmlElement(name = "Code", required = true)
    protected MaritalStatusCodeEnum code;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link MaritalStatusCodeEnum }
     *     
     */
    public MaritalStatusCodeEnum getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaritalStatusCodeEnum }
     *     
     */
    public void setCode(MaritalStatusCodeEnum value) {
        this.code = value;
    }

}
