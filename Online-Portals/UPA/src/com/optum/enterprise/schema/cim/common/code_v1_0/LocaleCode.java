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
 * 				Locale Code.
 * 			
 * 
 * <p>Java class for LocaleCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocaleCode">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}AbstractEnumeratedCode">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}LocaleCodeEnum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocaleCode", propOrder = {
    "code"
})
public class LocaleCode
    extends AbstractEnumeratedCode
{

    @XmlElement(name = "Code", required = true)
    protected LocaleCodeEnum code;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link LocaleCodeEnum }
     *     
     */
    public LocaleCodeEnum getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocaleCodeEnum }
     *     
     */
    public void setCode(LocaleCodeEnum value) {
        this.code = value;
    }

}
